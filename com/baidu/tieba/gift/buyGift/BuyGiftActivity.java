package com.baidu.tieba.gift.buyGift;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.SendGiftSuccessMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.buyGift.GiftCommonList;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ueg.encrypt.entity.EncryptAlgorithm;
import com.repackage.dr4;
import com.repackage.l95;
import com.repackage.m79;
import com.repackage.mg;
import com.repackage.n79;
import com.repackage.p79;
import com.repackage.ss6;
import com.repackage.ts6;
import com.repackage.wa;
import com.repackage.ya;
import java.util.ArrayList;
import java.util.List;
import tbclient.SendGiftAndroid.DataRes;
import tbclient.SendGiftAndroid.SendGiftAndroidResIdl;
@Deprecated
/* loaded from: classes3.dex */
public class BuyGiftActivity extends BaseActivity<BuyGiftActivity> implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERROR_GIFT_PRICE_CHANGED = 1990019;
    public static final int ERROR_NEED_PASSWORD = 1990027;
    public static final int ERROR_NOT_ENOUGH_TDOU = 1990018;
    public static final int ERROR_PASSWORD_INVALID = 1990028;
    public static final int ITEM_PER_PAGE = 8;
    public transient /* synthetic */ FieldHolder $fh;
    public View empty_layout;
    public TextView gift_button;
    public EditText gift_count_input;
    public TextView gift_count_result;
    public View gift_list_layout;
    public View gift_lower_layout;
    public View gift_num_layout;
    public ListView gift_num_list;
    public FrameLayout gift_panel_lay;
    public View gift_progress_layout;
    public IndicatorView gift_tab_indicator;
    public LinearLayout gift_tab_layout;
    public BaseViewPager gift_viewpager;
    public final CustomMessageListener mBuyTdouListener;
    public GiftCommonList.GiftItem mCurrentItem;
    public int mCurrentPage;
    public int mFrom;
    public final HttpMessageListener mGetGiftsHttpListener;
    public final ya mGetGiftsSocketListener;
    public GiftCommonList mGiftCommonList;
    public SendGiftSuccessMessage.a mGiftInfo;
    public ts6 mGiftNumAdapter;
    public GiftPagerAdapter mGiftPagerAdapter;
    public boolean mHasShowAnim;
    public boolean mHasYinji;
    public InputMethodManager mInputMethodManager;
    public SparseIntArray mPageInfos;
    public String mPassword;
    public String mPublicKey;
    public View mPwdContentView;
    public dr4 mPwdDialog;
    public EditText mPwdText;
    public long mReceiverId;
    public int mSelectedPage;
    public int mSelectedPosition;
    public final wa mSendGiftNetListener;
    public List<View> mViewPagerContent;
    public TextView password_dialog_warning;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyGiftActivity a;

        public a(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buyGiftActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.sendGift();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyGiftActivity a;

        public b(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buyGiftActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.gift_num_layout.setVisibility(8);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyGiftActivity a;

        public c(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buyGiftActivity;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                this.a.mPassword = "";
                this.a.mPwdText.clearFocus();
                BuyGiftActivity buyGiftActivity = this.a;
                buyGiftActivity.HidenSoftKeyPad(buyGiftActivity.mInputMethodManager, this.a.mPwdText);
                this.a.mPwdDialog.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements dr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyGiftActivity a;

        public d(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buyGiftActivity;
        }

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                this.a.showWarningOrNot(false);
                BuyGiftActivity buyGiftActivity = this.a;
                buyGiftActivity.mPassword = buyGiftActivity.mPwdText.getText().toString();
                if (StringUtils.isValidPassWord(this.a.mPassword)) {
                    if (!StringUtils.isNull(this.a.mPublicKey)) {
                        try {
                            m79 a = n79.a(new p79(EncryptAlgorithm.RSA, this.a.mPublicKey));
                            this.a.mPassword = a.a(this.a.mPassword);
                        } catch (Exception e) {
                            this.a.mPassword = "";
                            e.printStackTrace();
                        }
                    }
                    this.a.sendGift();
                    this.a.mPwdText.setText("");
                    return;
                }
                this.a.showWarningOrNot(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyGiftActivity a;

        public e(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buyGiftActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mPwdDialog.show();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyGiftActivity a;

        public f(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buyGiftActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BuyGiftActivity buyGiftActivity = this.a;
                buyGiftActivity.ShowSoftKeyPad((InputMethodManager) buyGiftActivity.getSystemService("input_method"), this.a.mPwdText);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyGiftActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(BuyGiftActivity buyGiftActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buyGiftActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof GetGiftCommonListHttpResponseMessage)) {
                GetGiftCommonListHttpResponseMessage getGiftCommonListHttpResponseMessage = (GetGiftCommonListHttpResponseMessage) httpResponsedMessage;
                this.a.mGiftCommonList = getGiftCommonListHttpResponseMessage.getGiftInfo();
                this.a.handleGetGiftsResponse(getGiftCommonListHttpResponseMessage.getError(), getGiftCommonListHttpResponseMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends ya {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyGiftActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(BuyGiftActivity buyGiftActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buyGiftActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && (socketResponsedMessage instanceof GetGiftCommonListSocketResponseMessage)) {
                GetGiftCommonListSocketResponseMessage getGiftCommonListSocketResponseMessage = (GetGiftCommonListSocketResponseMessage) socketResponsedMessage;
                this.a.mGiftCommonList = getGiftCommonListSocketResponseMessage.getGiftInfo();
                this.a.handleGetGiftsResponse(getGiftCommonListSocketResponseMessage.getError(), getGiftCommonListSocketResponseMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyGiftActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(BuyGiftActivity buyGiftActivity, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buyGiftActivity;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage instanceof SendGiftSocketResponseMessage) {
                    this.a.gift_button.setEnabled(true);
                    SendGiftSocketResponseMessage sendGiftSocketResponseMessage = (SendGiftSocketResponseMessage) responsedMessage;
                    this.a.handleSendGiftResponse(sendGiftSocketResponseMessage.getError(), sendGiftSocketResponseMessage.getErrorString(), sendGiftSocketResponseMessage.getResponseData());
                } else if (responsedMessage instanceof SendGiftHttpResponseMessage) {
                    this.a.gift_button.setEnabled(true);
                    SendGiftHttpResponseMessage sendGiftHttpResponseMessage = (SendGiftHttpResponseMessage) responsedMessage;
                    this.a.handleSendGiftResponse(sendGiftHttpResponseMessage.getError(), sendGiftHttpResponseMessage.getErrorString(), sendGiftHttpResponseMessage.getResponseData());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyGiftActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(BuyGiftActivity buyGiftActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buyGiftActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.mHasYinji = true;
                this.a.sendGift();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyGiftActivity a;

        public k(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buyGiftActivity;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.gift_list_layout.setVisibility(0);
                this.a.getGiftList();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyGiftActivity a;

        public l(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buyGiftActivity;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.finish();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyGiftActivity a;

        public m(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buyGiftActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.gift_num_layout.getVisibility() == 0) {
                    this.a.gift_num_layout.setVisibility(8);
                } else {
                    this.a.closeActivity();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyGiftActivity a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n a;

            public a(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = nVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.changeEditTextFocusState(false);
                    this.a.a.gift_num_layout.setVisibility(0);
                }
            }
        }

        public n(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buyGiftActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                BuyGiftActivity buyGiftActivity = this.a;
                buyGiftActivity.HidenSoftKeyPad(buyGiftActivity.mInputMethodManager, this.a.gift_count_input);
                this.a.mHandler.postDelayed(new a(this), 200L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyGiftActivity a;

        public o(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buyGiftActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (z) {
                    BuyGiftActivity buyGiftActivity = this.a;
                    buyGiftActivity.ShowSoftKeyPad(buyGiftActivity.mInputMethodManager, this.a.gift_count_input);
                    return;
                }
                BuyGiftActivity buyGiftActivity2 = this.a;
                buyGiftActivity2.HidenSoftKeyPad(buyGiftActivity2.mInputMethodManager, this.a.gift_count_input);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class p implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyGiftActivity a;

        public p(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buyGiftActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                BuyGiftActivity buyGiftActivity = this.a;
                buyGiftActivity.mSelectedPage = buyGiftActivity.mCurrentPage;
                this.a.mSelectedPosition = i;
                ss6 ss6Var = (ss6) adapterView.getAdapter();
                if (ss6Var != null) {
                    GiftCommonList.GiftItem item = ss6Var.getItem(i);
                    if (item != null) {
                        this.a.mCurrentItem = item;
                    }
                    ss6Var.d(i);
                    ss6Var.notifyDataSetChanged();
                }
                this.a.countTotalPrice(true);
            }
        }

        public /* synthetic */ p(BuyGiftActivity buyGiftActivity, g gVar) {
            this(buyGiftActivity);
        }
    }

    /* loaded from: classes3.dex */
    public class q implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyGiftActivity a;

        public q(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buyGiftActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.mGiftCommonList == null || this.a.mGiftCommonList.getGiftInfo() == null) {
                return;
            }
            List<GiftCommonList.NumInfo> numInfo = this.a.mGiftCommonList.getGiftInfo().getNumInfo();
            if (i == numInfo.size()) {
                this.a.changeEditTextFocusState(true);
                Selection.selectAll(this.a.gift_count_input.getText());
            } else {
                this.a.gift_count_input.setCursorVisible(true);
                this.a.gift_count_input.setFocusable(true);
                GiftCommonList.NumInfo numInfo2 = numInfo.get(i);
                if (numInfo2 != null) {
                    EditText editText = this.a.gift_count_input;
                    editText.setText("" + numInfo2.getNum());
                }
            }
            this.a.gift_num_layout.setVisibility(8);
            this.a.countTotalPrice(true);
        }

        public /* synthetic */ q(BuyGiftActivity buyGiftActivity, g gVar) {
            this(buyGiftActivity);
        }
    }

    /* loaded from: classes3.dex */
    public class r implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BuyGiftActivity a;

        public r(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = buyGiftActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int e = mg.e(editable.toString(), 0);
                if (editable.toString().length() == String.valueOf(e).length()) {
                    this.a.countTotalPrice(true);
                    return;
                }
                int i = e >= 0 ? e : 0;
                EditText editText = this.a.gift_count_input;
                editText.setText("" + i);
                this.a.gift_count_input.setSelection(String.valueOf(i).length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }

        public /* synthetic */ r(BuyGiftActivity buyGiftActivity, g gVar) {
            this(buyGiftActivity);
        }
    }

    /* loaded from: classes3.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ BuyGiftActivity b;

        public s(BuyGiftActivity buyGiftActivity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = buyGiftActivity;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int min = Math.min(this.a, this.b.mPageInfos.size());
                int i = 0;
                for (int i2 = 0; i2 < min; i2++) {
                    i += this.b.mPageInfos.get(i2);
                }
                this.b.mCurrentPage = i;
                this.b.gift_viewpager.setCurrentItem(this.b.mCurrentPage);
                this.b.updateIndicatorAndTabs();
            }
        }
    }

    public BuyGiftActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mViewPagerContent = new ArrayList();
        this.mPageInfos = new SparseIntArray();
        this.mHasYinji = false;
        this.mHasShowAnim = false;
        this.mGiftInfo = new SendGiftSuccessMessage.a();
        this.mGetGiftsHttpListener = new g(this, CmdConfigHttp.GET_GIFT_LIST);
        this.mGetGiftsSocketListener = new h(this, 308001);
        this.mSendGiftNetListener = new i(this, CmdConfigHttp.SEND_GIFT, 308007);
        this.mBuyTdouListener = new j(this, 2001227);
    }

    @SuppressLint({"ResourceAsColor"})
    private void addTabs(List<GiftCommonList.TypeInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65567, this, list) == null) || list == null || list.size() <= 0) {
            return;
        }
        this.gift_tab_layout.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        filterGiftTypes(list);
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            GiftCommonList.TypeInfo typeInfo = list.get(i2);
            if (!TextUtils.isEmpty(typeInfo.getTypeName()) && typeInfo.getGiftItems().size() > 0) {
                TextView textView = (TextView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0389, (ViewGroup) null);
                SkinManager.setBackgroundColor(textView, R.color.CAM_X0205);
                textView.setText(typeInfo.getTypeName());
                textView.setOnClickListener(new s(this, i2));
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setPadding(8, 0, 8, 0);
                this.gift_tab_layout.addView(textView, layoutParams);
            }
        }
        handleTabUi(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeEditTextFocusState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65568, this, z) == null) {
            this.gift_count_input.setCursorVisible(z);
            this.gift_count_input.setFocusable(z);
            this.gift_count_input.setFocusableInTouchMode(z);
            if (z) {
                this.gift_count_input.requestFocus();
            } else {
                this.gift_count_input.clearFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int countTotalPrice(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65569, this, z)) == null) {
            int e2 = mg.e(this.gift_count_input.getText().toString(), 1);
            GiftCommonList.GiftItem giftItem = this.mCurrentItem;
            int price = ((giftItem == null || giftItem.getPrice() <= 0) ? 1 : this.mCurrentItem.getPrice()) * e2;
            if (z) {
                this.gift_count_result.setText(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f1383), StringHelper.numFormat(price)));
                if (price <= 0) {
                    SkinManager.setBackgroundResource(this.gift_button, R.drawable.btn_gift_give_d);
                    this.gift_button.setEnabled(false);
                } else {
                    SkinManager.setBackgroundResource(this.gift_button, R.drawable.btn_gift_give_normal);
                    this.gift_button.setEnabled(true);
                }
                return price;
            }
            return price;
        }
        return invokeZ.intValue;
    }

    private List<GiftCommonList.GiftItem> filterGiftItems(List<GiftCommonList.GiftItem> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() != 0) {
                for (GiftCommonList.GiftItem giftItem : list) {
                    if (giftItem.getPrice() > 0 && giftItem.getGiftId() > 0) {
                        arrayList.add(giftItem);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    private void filterGiftTypes(List<GiftCommonList.TypeInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65571, this, list) == null) || list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (GiftCommonList.TypeInfo typeInfo : list) {
            if (TextUtils.isEmpty(typeInfo.getTypeName()) || typeInfo.getGiftItems().size() <= 0) {
                arrayList.add(typeInfo);
            }
        }
        list.removeAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getGiftList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            this.gift_progress_layout.setVisibility(0);
            this.gift_lower_layout.setVisibility(8);
            this.gift_num_layout.setVisibility(8);
            changeEditTextFocusState(false);
            HidenSoftKeyPad((InputMethodManager) getSystemService("input_method"), this.gift_count_input);
            sendMessage(new GetGiftCommonListRequestMessage());
        }
    }

    private GridView getPageView(List<GiftCommonList.GiftItem> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65573, this, list, i2)) == null) {
            ss6 ss6Var = new ss6(getPageContext().getPageActivity());
            ss6Var.c(list);
            ss6Var.d(i2);
            GridView gridView = new GridView(getPageContext().getPageActivity());
            gridView.setVerticalScrollBarEnabled(false);
            gridView.setNumColumns(4);
            gridView.setVerticalSpacing(8);
            gridView.setHorizontalSpacing(8);
            gridView.setSelector(R.color.common_color_10022);
            gridView.setAdapter((ListAdapter) ss6Var);
            gridView.setPadding(4, 0, 4, 0);
            gridView.setOnItemClickListener(new p(this, null));
            return gridView;
        }
        return (GridView) invokeLI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGetGiftsResponse(int i2, String str) {
        GiftCommonList giftCommonList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65574, this, i2, str) == null) {
            if (i2 == 0 && (giftCommonList = this.mGiftCommonList) != null && giftCommonList.getGiftInfo() != null && this.mGiftCommonList.getGiftInfo().getTypeInfo().size() > 0) {
                this.gift_button.setEnabled(true);
                this.gift_progress_layout.setVisibility(8);
                this.gift_lower_layout.setVisibility(0);
                updateViews();
                return;
            }
            if (TextUtils.isEmpty(str)) {
                showToast(R.string.obfuscated_res_0x7f0f0c18);
            } else {
                showToast(str);
            }
            closeActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSendGiftResponse(int i2, String str, SendGiftAndroidResIdl sendGiftAndroidResIdl) {
        DataRes dataRes;
        String str2;
        DataRes dataRes2;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65575, this, i2, str, sendGiftAndroidResIdl) == null) {
            dr4 dr4Var = this.mPwdDialog;
            if (dr4Var != null && dr4Var.isShowing()) {
                this.mPwdDialog.setYesBtnClickable(true);
                this.mPwdDialog.setNoBtnClickable(true);
            }
            this.gift_progress_layout.setVisibility(8);
            this.mPassword = "";
            if (i2 == 1990018 && !this.mHasYinji) {
                int countTotalPrice = countTotalPrice(false);
                int intValue = (sendGiftAndroidResIdl == null || (dataRes2 = sendGiftAndroidResIdl.data) == null || (num = dataRes2.money) == null) ? 0 : countTotalPrice - num.intValue();
                if (intValue > 0) {
                    showToast(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f0c70), Integer.valueOf(intValue)));
                }
                CurrencyJumpHelper.buyGiftGotoBuyTBeanPage(getPageContext().getPageActivity(), countTotalPrice);
                InputMethodManager inputMethodManager = this.mInputMethodManager;
                if (inputMethodManager != null) {
                    HidenSoftKeyPad(inputMethodManager, this.gift_count_input);
                }
                dr4 dr4Var2 = this.mPwdDialog;
                if (dr4Var2 == null || !dr4Var2.isShowing()) {
                    return;
                }
                this.mPwdDialog.dismiss();
            } else if (i2 == 1990028) {
                showWarningOrNot(true);
            } else if (i2 == 1990019) {
                showToastFromServer(str, 0);
                getGiftList();
            } else if (i2 != 1990027) {
                if (i2 != 0) {
                    showToastFromServer(str, R.string.obfuscated_res_0x7f0f0c18);
                    return;
                }
                SendGiftSuccessMessage sendGiftSuccessMessage = new SendGiftSuccessMessage(2001232, Long.valueOf(this.mReceiverId));
                sendGiftSuccessMessage.setGiftInfo(this.mGiftInfo);
                MessageManager.getInstance().dispatchResponsedMessageToUI(sendGiftSuccessMessage);
                showToastFromServer(str, R.string.obfuscated_res_0x7f0f10e6);
                closeActivity();
            } else {
                if (sendGiftAndroidResIdl != null && (dataRes = sendGiftAndroidResIdl.data) != null && (str2 = dataRes.public_key) != null) {
                    this.mPublicKey = str2;
                }
                this.mHandler.post(new e(this));
                this.mPwdText.setText("");
                showWarningOrNot(false);
                this.mPwdText.requestFocus();
                this.mHandler.post(new f(this));
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    private void handleTabUi(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65576, this, i2) == null) {
            int childCount = this.gift_tab_layout.getChildCount();
            if (i2 < 0 || i2 >= childCount) {
                return;
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                TextView textView = (TextView) this.gift_tab_layout.getChildAt(i3);
                if (i3 != i2) {
                    SkinManager.setViewTextColor(textView, R.color.gift_tab_textcolor_normal, 1);
                } else {
                    SkinManager.setViewTextColor(textView, R.color.gift_tab_textcolor_selected, 1);
                }
            }
        }
    }

    private void hideAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            this.empty_layout.setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            this.empty_layout.startAnimation(alphaAnimation);
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.obfuscated_res_0x7f010041);
            loadAnimation.setDuration(300L);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new l(this));
            this.gift_list_layout.startAnimation(loadAnimation);
        }
    }

    private void inflateGiftList(List<GiftCommonList.TypeInfo> list) {
        List<GiftCommonList.GiftItem> subList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65578, this, list) == null) || list == null) {
            return;
        }
        this.mPageInfos.clear();
        this.mViewPagerContent.clear();
        this.gift_viewpager.setAdapter(null);
        for (int i2 = 0; i2 < list.size(); i2++) {
            List<GiftCommonList.GiftItem> filterGiftItems = filterGiftItems(list.get(i2).getGiftItems());
            int size = filterGiftItems.size();
            if (size > 0) {
                if (this.mCurrentItem == null) {
                    this.mCurrentItem = filterGiftItems.get(0);
                    countTotalPrice(true);
                }
                int ceil = (int) Math.ceil(size / 8.0d);
                this.mPageInfos.append(i2, ceil);
                for (int i3 = 0; i3 < ceil; i3++) {
                    if (i3 == ceil - 1) {
                        int i4 = i3 * 8;
                        int i5 = size - 1;
                        if (i4 == i5) {
                            subList = new ArrayList<>();
                            subList.add(filterGiftItems.get(i5));
                        } else {
                            subList = filterGiftItems.subList(i4, size);
                        }
                    } else {
                        subList = filterGiftItems.subList(i3 * 8, (i3 + 1) * 8);
                    }
                    if (i2 == 0 && i3 == 0) {
                        this.mViewPagerContent.add(getPageView(subList, this.mSelectedPage));
                    } else {
                        this.mViewPagerContent.add(getPageView(subList, -1));
                    }
                }
            }
        }
        GiftPagerAdapter giftPagerAdapter = new GiftPagerAdapter(this.mViewPagerContent);
        this.mGiftPagerAdapter = giftPagerAdapter;
        this.gift_viewpager.setAdapter(giftPagerAdapter);
        updateIndicatorAndTabs();
    }

    private void inflateNumList(List<GiftCommonList.NumInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65579, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (GiftCommonList.NumInfo numInfo : list) {
                    if (numInfo.getNum() <= 0) {
                        arrayList.add(numInfo);
                    }
                }
                list.removeAll(arrayList);
            }
            ts6 ts6Var = new ts6(getPageContext().getPageActivity());
            this.mGiftNumAdapter = ts6Var;
            this.gift_num_list.setAdapter((ListAdapter) ts6Var);
            this.mGiftNumAdapter.b(list);
        }
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, this) == null) {
            if (getIntent() != null) {
                this.mReceiverId = getIntent().getLongExtra("gift_receiver_id", 0L);
            }
            registerTask();
            registerListener();
        }
    }

    private void initViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
            this.gift_panel_lay = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090cbb);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0908c6);
            this.empty_layout = findViewById;
            findViewById.setOnClickListener(new m(this));
            this.gift_list_layout = findViewById(R.id.obfuscated_res_0x7f090cb2);
            this.mInputMethodManager = (InputMethodManager) getSystemService("input_method");
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f090cab);
            this.gift_count_input = editText;
            editText.setSelection(1);
            changeEditTextFocusState(false);
            this.gift_count_input.addTextChangedListener(new r(this, null));
            this.gift_count_input.setOnClickListener(new n(this));
            this.gift_count_input.setOnFocusChangeListener(new o(this));
            this.gift_count_result = (TextView) findViewById(R.id.obfuscated_res_0x7f090cad);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090caa);
            this.gift_button = textView;
            textView.setEnabled(false);
            this.gift_button.setOnClickListener(new a(this));
            this.gift_lower_layout = findViewById(R.id.obfuscated_res_0x7f090cb5);
            BaseViewPager baseViewPager = (BaseViewPager) findViewById(R.id.obfuscated_res_0x7f090cc7);
            this.gift_viewpager = baseViewPager;
            baseViewPager.setOnPageChangeListener(this);
            this.gift_tab_indicator = (IndicatorView) findViewById(R.id.obfuscated_res_0x7f090cc2);
            this.gift_tab_layout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090cc3);
            this.gift_progress_layout = findViewById(R.id.obfuscated_res_0x7f090cbd);
            View findViewById2 = findViewById(R.id.obfuscated_res_0x7f090cb8);
            this.gift_num_layout = findViewById2;
            findViewById2.setOnClickListener(new b(this));
            ListView listView = (ListView) findViewById(R.id.obfuscated_res_0x7f090cb9);
            this.gift_num_list = listView;
            listView.setOnItemClickListener(new q(this, null));
            this.mPwdDialog = new dr4(getActivity());
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d023d, (ViewGroup) null);
            this.mPwdContentView = inflate;
            this.mPwdText = (EditText) inflate.findViewById(R.id.obfuscated_res_0x7f09165c);
            this.password_dialog_warning = (TextView) this.mPwdContentView.findViewById(R.id.obfuscated_res_0x7f09165d);
            this.mPwdDialog.setContentView(this.mPwdContentView);
            this.mPwdDialog.setCanceledOnTouchOutside(false);
            this.mPwdDialog.setNegativeButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f036e), new c(this));
            this.mPwdDialog.setPositiveButton(getPageContext().getString(R.string.obfuscated_res_0x7f0f0421), new d(this));
            this.mPwdDialog.create(getPageContext());
        }
    }

    private void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
            registerListener(this.mGetGiftsHttpListener);
            registerListener(this.mGetGiftsSocketListener);
            registerListener(this.mSendGiftNetListener);
            registerListener(this.mBuyTdouListener);
        }
    }

    private void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65583, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.GET_GIFT_LIST, TbConfig.SERVER_ADDRESS + TbConfig.GIFT_COMMONLIST + "?cmd=308001");
            tbHttpMessageTask.setResponsedClass(GetGiftCommonListHttpResponseMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
            l95 l95Var = new l95(308001);
            l95Var.setResponsedClass(GetGiftCommonListSocketResponseMessage.class);
            l95Var.g(true);
            l95Var.h(false);
            l95Var.f(SocketMessageTask.DupLicateMode.NONE);
            messageManager.registerTask(l95Var);
            TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.SEND_GIFT, TbConfig.SERVER_ADDRESS + TbConfig.SEND_GIFT + "?cmd=308007");
            tbHttpMessageTask2.setResponsedClass(SendGiftHttpResponseMessage.class);
            messageManager.registerTask(tbHttpMessageTask2);
            l95 l95Var2 = new l95(308007);
            l95Var2.setResponsedClass(SendGiftSocketResponseMessage.class);
            l95Var2.g(true);
            l95Var2.h(false);
            l95Var2.f(SocketMessageTask.DupLicateMode.NONE);
            messageManager.registerTask(l95Var2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendGift() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65584, this) == null) || this.mCurrentItem == null || this.mReceiverId <= 0) {
            return;
        }
        dr4 dr4Var = this.mPwdDialog;
        if (dr4Var != null && dr4Var.isShowing()) {
            this.mPwdDialog.setYesBtnClickable(false);
            this.mPwdDialog.setNoBtnClickable(false);
        }
        this.gift_button.setEnabled(false);
        this.gift_progress_layout.setVisibility(0);
        RequestSendGiftNetMessage requestSendGiftNetMessage = new RequestSendGiftNetMessage();
        int e2 = mg.e(String.valueOf(this.gift_count_input.getText()), 1);
        requestSendGiftNetMessage.setParams(this.mReceiverId, this.mCurrentItem.getGiftId(), this.mCurrentItem.getPrice(), e2, readFromVal(), this.mPassword);
        this.mGiftInfo.a(e2);
        this.mGiftInfo.c(this.mCurrentItem.getName());
        this.mGiftInfo.e(this.mCurrentItem.getThumbnailUrl());
        this.mGiftInfo.b(this.mCurrentItem.getGiftId());
        this.mGiftInfo.d(TbadkCoreApplication.getCurrentAccountName());
        sendMessage(requestSendGiftNetMessage);
    }

    private void showAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65585, this) == null) {
            this.empty_layout.setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
            alphaAnimation.setDuration(300L);
            this.empty_layout.startAnimation(alphaAnimation);
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.obfuscated_res_0x7f010042);
            loadAnimation.setDuration(300L);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new k(this));
            this.gift_list_layout.startAnimation(loadAnimation);
            this.mHasShowAnim = true;
        }
    }

    private void showToastFromServer(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65586, this, str, i2) == null) {
            if (!TextUtils.isEmpty(str)) {
                showToast(str);
            } else if (i2 > 0) {
                showToast(i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWarningOrNot(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65587, this, z) == null) {
            if (z) {
                this.password_dialog_warning.setVisibility(0);
            } else {
                this.password_dialog_warning.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateIndicatorAndTabs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65588, this) == null) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.mPageInfos.size(); i3++) {
                for (int i4 = 0; i4 < this.mPageInfos.get(i3); i4++) {
                    if (i2 + i4 == this.mCurrentPage) {
                        if (this.mPageInfos.get(i3) <= 1) {
                            this.gift_tab_indicator.setVisibility(4);
                        } else {
                            this.gift_tab_indicator.setVisibility(0);
                        }
                        this.gift_tab_indicator.setCount(this.mPageInfos.get(i3));
                        this.gift_tab_indicator.setPosition(i4);
                        handleTabUi(i3);
                        return;
                    }
                }
                i2 += this.mPageInfos.get(i3);
            }
        }
    }

    private void updateViews() {
        GiftCommonList giftCommonList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65589, this) == null) || (giftCommonList = this.mGiftCommonList) == null || giftCommonList.getGiftInfo() == null) {
            return;
        }
        List<GiftCommonList.TypeInfo> typeInfo = this.mGiftCommonList.getGiftInfo().getTypeInfo();
        addTabs(typeInfo);
        inflateGiftList(typeInfo);
        inflateNumList(this.mGiftCommonList.getGiftInfo().getNumInfo());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            hideAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            closeActivity();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            super.onChangeSkinType(i2);
            boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
            getLayoutMode().k(z);
            getLayoutMode().j(this.gift_list_layout);
            ts6 ts6Var = this.mGiftNumAdapter;
            if (ts6Var != null) {
                ts6Var.notifyDataSetChanged();
            }
            if (z) {
                this.gift_tab_indicator.setSelector(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080887));
                this.gift_tab_indicator.setDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080885));
                return;
            }
            this.gift_tab_indicator.setSelector(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080886));
            this.gift_tab_indicator.setDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080884));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            requestWindowFeature(1);
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setActivityBgTransparent();
            setContentView(R.layout.obfuscated_res_0x7f0d002d);
            initViews();
            initData();
            this.mFrom = getIntent().getIntExtra("from", 1);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                dr4 dr4Var = this.mPwdDialog;
                if (dr4Var != null && dr4Var.isShowing()) {
                    this.mPwdText.clearFocus();
                    this.mPwdDialog.dismiss();
                    return true;
                } else if (this.gift_num_layout.getVisibility() == 0) {
                    this.gift_num_layout.setVisibility(8);
                    return true;
                }
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, intent) == null) {
            super.onNewIntent(intent);
            this.mFrom = intent.getIntExtra("from", 1);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.mCurrentPage = i2;
            updateIndicatorAndTabs();
            if (i2 < 0 || i2 >= this.mViewPagerContent.size()) {
                return;
            }
            GridView gridView = (GridView) this.mViewPagerContent.get(i2);
            if (gridView.getAdapter() != null) {
                ss6 ss6Var = (ss6) gridView.getAdapter();
                if (ss6Var.b() >= 0 && i2 != this.mSelectedPage) {
                    ss6Var.d(-1);
                    ss6Var.notifyDataSetChanged();
                }
                if (ss6Var.b() >= 0 || i2 != this.mSelectedPage) {
                    return;
                }
                ss6Var.d(this.mSelectedPosition);
                ss6Var.notifyDataSetChanged();
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z || this.mHasShowAnim) {
                return;
            }
            showAnimation();
        }
    }

    public int readFromVal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            int i2 = this.mFrom;
            int i3 = 2;
            if (i2 != 2) {
                i3 = 3;
                if (i2 != 3) {
                    return 1;
                }
            }
            return i3;
        }
        return invokeV.intValue;
    }
}
