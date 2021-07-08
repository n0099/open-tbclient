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
import d.a.o0.r.s.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.SendGiftAndroid.DataRes;
import tbclient.SendGiftAndroid.SendGiftAndroidResIdl;
@Deprecated
/* loaded from: classes4.dex */
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
    public final d.a.c.c.g.c mGetGiftsSocketListener;
    public GiftCommonList mGiftCommonList;
    public SendGiftSuccessMessage.a mGiftInfo;
    public d.a.p0.y0.a.b mGiftNumAdapter;
    public GiftPagerAdapter mGiftPagerAdapter;
    public boolean mHasShowAnim;
    public boolean mHasYinji;
    public InputMethodManager mInputMethodManager;
    public SparseIntArray mPageInfos;
    public String mPassword;
    public String mPublicKey;
    public View mPwdContentView;
    public d.a.o0.r.s.a mPwdDialog;
    public EditText mPwdText;
    public long mReceiverId;
    public int mSelectedPage;
    public int mSelectedPosition;
    public final d.a.c.c.g.a mSendGiftNetListener;
    public List<View> mViewPagerContent;
    public TextView password_dialog_warning;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BuyGiftActivity f16309e;

        public a(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16309e = buyGiftActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16309e.sendGift();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BuyGiftActivity f16310e;

        public b(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16310e = buyGiftActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16310e.gift_num_layout.setVisibility(8);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BuyGiftActivity f16311e;

        public c(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16311e = buyGiftActivity;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f16311e.mPassword = "";
                this.f16311e.mPwdText.clearFocus();
                BuyGiftActivity buyGiftActivity = this.f16311e;
                buyGiftActivity.HidenSoftKeyPad(buyGiftActivity.mInputMethodManager, this.f16311e.mPwdText);
                this.f16311e.mPwdDialog.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BuyGiftActivity f16312e;

        public d(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16312e = buyGiftActivity;
        }

        @Override // d.a.o0.r.s.a.e
        public void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f16312e.showWarningOrNot(false);
                BuyGiftActivity buyGiftActivity = this.f16312e;
                buyGiftActivity.mPassword = buyGiftActivity.mPwdText.getText().toString();
                if (StringUtils.isValidPassWord(this.f16312e.mPassword)) {
                    if (!StringUtils.isNull(this.f16312e.mPublicKey)) {
                        try {
                            d.a.u0.a.a a2 = d.a.u0.a.b.a(new d.a.u0.a.d.a(EncryptAlgorithm.RSA, this.f16312e.mPublicKey));
                            this.f16312e.mPassword = a2.a(this.f16312e.mPassword);
                        } catch (Exception e2) {
                            this.f16312e.mPassword = "";
                            e2.printStackTrace();
                        }
                    }
                    this.f16312e.sendGift();
                    this.f16312e.mPwdText.setText("");
                    return;
                }
                this.f16312e.showWarningOrNot(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BuyGiftActivity f16313e;

        public e(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16313e = buyGiftActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16313e.mPwdDialog.show();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BuyGiftActivity f16314e;

        public f(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16314e = buyGiftActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BuyGiftActivity buyGiftActivity = this.f16314e;
                buyGiftActivity.ShowSoftKeyPad((InputMethodManager) buyGiftActivity.getSystemService("input_method"), this.f16314e.mPwdText);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BuyGiftActivity f16315a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(BuyGiftActivity buyGiftActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16315a = buyGiftActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof GetGiftCommonListHttpResponseMessage)) {
                GetGiftCommonListHttpResponseMessage getGiftCommonListHttpResponseMessage = (GetGiftCommonListHttpResponseMessage) httpResponsedMessage;
                this.f16315a.mGiftCommonList = getGiftCommonListHttpResponseMessage.getGiftInfo();
                this.f16315a.handleGetGiftsResponse(getGiftCommonListHttpResponseMessage.getError(), getGiftCommonListHttpResponseMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends d.a.c.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BuyGiftActivity f16316a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(BuyGiftActivity buyGiftActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16316a = buyGiftActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && (socketResponsedMessage instanceof GetGiftCommonListSocketResponseMessage)) {
                GetGiftCommonListSocketResponseMessage getGiftCommonListSocketResponseMessage = (GetGiftCommonListSocketResponseMessage) socketResponsedMessage;
                this.f16316a.mGiftCommonList = getGiftCommonListSocketResponseMessage.getGiftInfo();
                this.f16316a.handleGetGiftsResponse(getGiftCommonListSocketResponseMessage.getError(), getGiftCommonListSocketResponseMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BuyGiftActivity f16317a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(BuyGiftActivity buyGiftActivity, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16317a = buyGiftActivity;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage instanceof SendGiftSocketResponseMessage) {
                    this.f16317a.gift_button.setEnabled(true);
                    SendGiftSocketResponseMessage sendGiftSocketResponseMessage = (SendGiftSocketResponseMessage) responsedMessage;
                    this.f16317a.handleSendGiftResponse(sendGiftSocketResponseMessage.getError(), sendGiftSocketResponseMessage.getErrorString(), sendGiftSocketResponseMessage.getResponseData());
                } else if (responsedMessage instanceof SendGiftHttpResponseMessage) {
                    this.f16317a.gift_button.setEnabled(true);
                    SendGiftHttpResponseMessage sendGiftHttpResponseMessage = (SendGiftHttpResponseMessage) responsedMessage;
                    this.f16317a.handleSendGiftResponse(sendGiftHttpResponseMessage.getError(), sendGiftHttpResponseMessage.getErrorString(), sendGiftHttpResponseMessage.getResponseData());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BuyGiftActivity f16318a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(BuyGiftActivity buyGiftActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16318a = buyGiftActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f16318a.mHasYinji = true;
                this.f16318a.sendGift();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BuyGiftActivity f16319a;

        public k(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16319a = buyGiftActivity;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f16319a.gift_list_layout.setVisibility(0);
                this.f16319a.getGiftList();
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

    /* loaded from: classes4.dex */
    public class l implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BuyGiftActivity f16320a;

        public l(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16320a = buyGiftActivity;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f16320a.finish();
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

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BuyGiftActivity f16321e;

        public m(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16321e = buyGiftActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f16321e.gift_num_layout.getVisibility() == 0) {
                    this.f16321e.gift_num_layout.setVisibility(8);
                } else {
                    this.f16321e.closeActivity();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BuyGiftActivity f16322e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ n f16323e;

            public a(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16323e = nVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f16323e.f16322e.changeEditTextFocusState(false);
                    this.f16323e.f16322e.gift_num_layout.setVisibility(0);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16322e = buyGiftActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                BuyGiftActivity buyGiftActivity = this.f16322e;
                buyGiftActivity.HidenSoftKeyPad(buyGiftActivity.mInputMethodManager, this.f16322e.gift_count_input);
                this.f16322e.mHandler.postDelayed(new a(this), 200L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BuyGiftActivity f16324e;

        public o(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16324e = buyGiftActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (z) {
                    BuyGiftActivity buyGiftActivity = this.f16324e;
                    buyGiftActivity.ShowSoftKeyPad(buyGiftActivity.mInputMethodManager, this.f16324e.gift_count_input);
                    return;
                }
                BuyGiftActivity buyGiftActivity2 = this.f16324e;
                buyGiftActivity2.HidenSoftKeyPad(buyGiftActivity2.mInputMethodManager, this.f16324e.gift_count_input);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BuyGiftActivity f16325e;

        public p(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16325e = buyGiftActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                BuyGiftActivity buyGiftActivity = this.f16325e;
                buyGiftActivity.mSelectedPage = buyGiftActivity.mCurrentPage;
                this.f16325e.mSelectedPosition = i2;
                d.a.p0.y0.a.a aVar = (d.a.p0.y0.a.a) adapterView.getAdapter();
                if (aVar != null) {
                    GiftCommonList.GiftItem item = aVar.getItem(i2);
                    if (item != null) {
                        this.f16325e.mCurrentItem = item;
                    }
                    aVar.d(i2);
                    aVar.notifyDataSetChanged();
                }
                this.f16325e.countTotalPrice(true);
            }
        }

        public /* synthetic */ p(BuyGiftActivity buyGiftActivity, g gVar) {
            this(buyGiftActivity);
        }
    }

    /* loaded from: classes4.dex */
    public class q implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BuyGiftActivity f16326e;

        public q(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16326e = buyGiftActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f16326e.mGiftCommonList == null || this.f16326e.mGiftCommonList.getGiftInfo() == null) {
                return;
            }
            List<GiftCommonList.NumInfo> numInfo = this.f16326e.mGiftCommonList.getGiftInfo().getNumInfo();
            if (i2 == numInfo.size()) {
                this.f16326e.changeEditTextFocusState(true);
                Selection.selectAll(this.f16326e.gift_count_input.getText());
            } else {
                this.f16326e.gift_count_input.setCursorVisible(true);
                this.f16326e.gift_count_input.setFocusable(true);
                GiftCommonList.NumInfo numInfo2 = numInfo.get(i2);
                if (numInfo2 != null) {
                    EditText editText = this.f16326e.gift_count_input;
                    editText.setText("" + numInfo2.getNum());
                }
            }
            this.f16326e.gift_num_layout.setVisibility(8);
            this.f16326e.countTotalPrice(true);
        }

        public /* synthetic */ q(BuyGiftActivity buyGiftActivity, g gVar) {
            this(buyGiftActivity);
        }
    }

    /* loaded from: classes4.dex */
    public class r implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ BuyGiftActivity f16327e;

        public r(BuyGiftActivity buyGiftActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16327e = buyGiftActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int d2 = d.a.c.e.m.b.d(editable.toString(), 0);
                if (editable.toString().length() == String.valueOf(d2).length()) {
                    this.f16327e.countTotalPrice(true);
                    return;
                }
                int i2 = d2 >= 0 ? d2 : 0;
                EditText editText = this.f16327e.gift_count_input;
                editText.setText("" + i2);
                this.f16327e.gift_count_input.setSelection(String.valueOf(i2).length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }

        public /* synthetic */ r(BuyGiftActivity buyGiftActivity, g gVar) {
            this(buyGiftActivity);
        }
    }

    /* loaded from: classes4.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f16328e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ BuyGiftActivity f16329f;

        public s(BuyGiftActivity buyGiftActivity, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {buyGiftActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16329f = buyGiftActivity;
            this.f16328e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int min = Math.min(this.f16328e, this.f16329f.mPageInfos.size());
                int i2 = 0;
                for (int i3 = 0; i3 < min; i3++) {
                    i2 += this.f16329f.mPageInfos.get(i3);
                }
                this.f16329f.mCurrentPage = i2;
                this.f16329f.gift_viewpager.setCurrentItem(this.f16329f.mCurrentPage);
                this.f16329f.updateIndicatorAndTabs();
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
                TextView textView = (TextView) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.gift_tab_item, (ViewGroup) null);
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
            int d2 = d.a.c.e.m.b.d(this.gift_count_input.getText().toString(), 1);
            GiftCommonList.GiftItem giftItem = this.mCurrentItem;
            int price = ((giftItem == null || giftItem.getPrice() <= 0) ? 1 : this.mCurrentItem.getPrice()) * d2;
            if (z) {
                this.gift_count_result.setText(String.format(getPageContext().getString(R.string.tdou_count_format), StringHelper.numFormat(price)));
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
            d.a.p0.y0.a.a aVar = new d.a.p0.y0.a.a(getPageContext().getPageActivity());
            aVar.c(list);
            aVar.d(i2);
            GridView gridView = new GridView(getPageContext().getPageActivity());
            gridView.setVerticalScrollBarEnabled(false);
            gridView.setNumColumns(4);
            gridView.setVerticalSpacing(8);
            gridView.setHorizontalSpacing(8);
            gridView.setSelector(R.color.common_color_10022);
            gridView.setAdapter((ListAdapter) aVar);
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
                showToast(R.string.neterror);
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
            d.a.o0.r.s.a aVar = this.mPwdDialog;
            if (aVar != null && aVar.isShowing()) {
                this.mPwdDialog.setYesBtnClickable(true);
                this.mPwdDialog.setNoBtnClickable(true);
            }
            this.gift_progress_layout.setVisibility(8);
            this.mPassword = "";
            if (i2 == 1990018 && !this.mHasYinji) {
                int countTotalPrice = countTotalPrice(false);
                int intValue = (sendGiftAndroidResIdl == null || (dataRes2 = sendGiftAndroidResIdl.data) == null || (num = dataRes2.money) == null) ? 0 : countTotalPrice - num.intValue();
                if (intValue > 0) {
                    showToast(String.format(getPageContext().getString(R.string.not_enough_tdou_format), Integer.valueOf(intValue)));
                }
                CurrencyJumpHelper.buyGiftGotoBuyTBeanPage(getPageContext().getPageActivity(), countTotalPrice);
                InputMethodManager inputMethodManager = this.mInputMethodManager;
                if (inputMethodManager != null) {
                    HidenSoftKeyPad(inputMethodManager, this.gift_count_input);
                }
                d.a.o0.r.s.a aVar2 = this.mPwdDialog;
                if (aVar2 == null || !aVar2.isShowing()) {
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
                    showToastFromServer(str, R.string.neterror);
                    return;
                }
                SendGiftSuccessMessage sendGiftSuccessMessage = new SendGiftSuccessMessage(2001232, Long.valueOf(this.mReceiverId));
                sendGiftSuccessMessage.setGiftInfo(this.mGiftInfo);
                MessageManager.getInstance().dispatchResponsedMessageToUI(sendGiftSuccessMessage);
                showToastFromServer(str, R.string.send_gift_succeed);
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
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_down);
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
            d.a.p0.y0.a.b bVar = new d.a.p0.y0.a.b(getPageContext().getPageActivity());
            this.mGiftNumAdapter = bVar;
            this.gift_num_list.setAdapter((ListAdapter) bVar);
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
            this.gift_panel_lay = (FrameLayout) findViewById(R.id.gift_panel_lay);
            View findViewById = findViewById(R.id.empty_layout);
            this.empty_layout = findViewById;
            findViewById.setOnClickListener(new m(this));
            this.gift_list_layout = findViewById(R.id.gift_list_layout);
            this.mInputMethodManager = (InputMethodManager) getSystemService("input_method");
            EditText editText = (EditText) findViewById(R.id.gift_count_input);
            this.gift_count_input = editText;
            editText.setSelection(1);
            changeEditTextFocusState(false);
            this.gift_count_input.addTextChangedListener(new r(this, null));
            this.gift_count_input.setOnClickListener(new n(this));
            this.gift_count_input.setOnFocusChangeListener(new o(this));
            this.gift_count_result = (TextView) findViewById(R.id.gift_count_result);
            TextView textView = (TextView) findViewById(R.id.gift_button);
            this.gift_button = textView;
            textView.setEnabled(false);
            this.gift_button.setOnClickListener(new a(this));
            this.gift_lower_layout = findViewById(R.id.gift_lower_layout);
            BaseViewPager baseViewPager = (BaseViewPager) findViewById(R.id.gift_viewpager);
            this.gift_viewpager = baseViewPager;
            baseViewPager.setOnPageChangeListener(this);
            this.gift_tab_indicator = (IndicatorView) findViewById(R.id.gift_tab_indicator);
            this.gift_tab_layout = (LinearLayout) findViewById(R.id.gift_tab_layout);
            this.gift_progress_layout = findViewById(R.id.gift_progress_layout);
            View findViewById2 = findViewById(R.id.gift_num_layout);
            this.gift_num_layout = findViewById2;
            findViewById2.setOnClickListener(new b(this));
            ListView listView = (ListView) findViewById(R.id.gift_num_list);
            this.gift_num_list = listView;
            listView.setOnItemClickListener(new q(this, null));
            this.mPwdDialog = new d.a.o0.r.s.a(getActivity());
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_tdou_pay_pwd, (ViewGroup) null);
            this.mPwdContentView = inflate;
            this.mPwdText = (EditText) inflate.findViewById(R.id.password_dialog_input);
            this.password_dialog_warning = (TextView) this.mPwdContentView.findViewById(R.id.password_dialog_warning);
            this.mPwdDialog.setContentView(this.mPwdContentView);
            this.mPwdDialog.setCanceledOnTouchOutside(false);
            this.mPwdDialog.setNegativeButton(getPageContext().getString(R.string.cancel), new c(this));
            this.mPwdDialog.setPositiveButton(getPageContext().getString(R.string.confirm), new d(this));
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
            d.a.o0.v0.b bVar = new d.a.o0.v0.b(308001);
            bVar.setResponsedClass(GetGiftCommonListSocketResponseMessage.class);
            bVar.g(true);
            bVar.h(false);
            bVar.f(SocketMessageTask.DupLicateMode.NONE);
            messageManager.registerTask(bVar);
            TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.SEND_GIFT, TbConfig.SERVER_ADDRESS + TbConfig.SEND_GIFT + "?cmd=308007");
            tbHttpMessageTask2.setResponsedClass(SendGiftHttpResponseMessage.class);
            messageManager.registerTask(tbHttpMessageTask2);
            d.a.o0.v0.b bVar2 = new d.a.o0.v0.b(308007);
            bVar2.setResponsedClass(SendGiftSocketResponseMessage.class);
            bVar2.g(true);
            bVar2.h(false);
            bVar2.f(SocketMessageTask.DupLicateMode.NONE);
            messageManager.registerTask(bVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendGift() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65584, this) == null) || this.mCurrentItem == null || this.mReceiverId <= 0) {
            return;
        }
        d.a.o0.r.s.a aVar = this.mPwdDialog;
        if (aVar != null && aVar.isShowing()) {
            this.mPwdDialog.setYesBtnClickable(false);
            this.mPwdDialog.setNoBtnClickable(false);
        }
        this.gift_button.setEnabled(false);
        this.gift_progress_layout.setVisibility(0);
        RequestSendGiftNetMessage requestSendGiftNetMessage = new RequestSendGiftNetMessage();
        int d2 = d.a.c.e.m.b.d(String.valueOf(this.gift_count_input.getText()), 1);
        requestSendGiftNetMessage.setParams(this.mReceiverId, this.mCurrentItem.getGiftId(), this.mCurrentItem.getPrice(), d2, readFromVal(), this.mPassword);
        this.mGiftInfo.a(d2);
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
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_up);
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
            d.a.p0.y0.a.b bVar = this.mGiftNumAdapter;
            if (bVar != null) {
                bVar.notifyDataSetChanged();
            }
            if (z) {
                this.gift_tab_indicator.setSelector(getResources().getDrawable(R.drawable.icon_pagecontrol_on_1));
                this.gift_tab_indicator.setDrawable(getResources().getDrawable(R.drawable.icon_pagecontrol_off_1));
                return;
            }
            this.gift_tab_indicator.setSelector(getResources().getDrawable(R.drawable.icon_pagecontrol_on));
            this.gift_tab_indicator.setDrawable(getResources().getDrawable(R.drawable.icon_pagecontrol_off));
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
            setContentView(R.layout.activity_buy_gift);
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
                d.a.o0.r.s.a aVar = this.mPwdDialog;
                if (aVar != null && aVar.isShowing()) {
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
                d.a.p0.y0.a.a aVar = (d.a.p0.y0.a.a) gridView.getAdapter();
                if (aVar.b() >= 0 && i2 != this.mSelectedPage) {
                    aVar.d(-1);
                    aVar.notifyDataSetChanged();
                }
                if (aVar.b() >= 0 || i2 != this.mSelectedPage) {
                    return;
                }
                aVar.d(this.mSelectedPosition);
                aVar.notifyDataSetChanged();
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
