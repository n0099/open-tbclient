package com.baidu.tieba.gift.giftTab;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.giftTab.GiftTabView;
import com.baidu.tieba.gift.send.SendGiftModel;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.aq6;
import com.repackage.cq6;
import com.repackage.ct4;
import com.repackage.dq4;
import com.repackage.eq6;
import com.repackage.fq6;
import com.repackage.kq6;
import com.repackage.li;
import com.repackage.yn4;
import com.repackage.zn4;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class GiftTabActivity extends BaseActivity<GiftTabActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int accountType;
    public String addFreeUrl;
    public int freeChance;
    public String mClickZone;
    public View.OnClickListener mCommenClickListener;
    public fq6.d mFreeCountCallback;
    public String mFrom;
    public SendGiftModel.c mGiftSendCallback;
    public boolean mHasShowAnim;
    public GiftTabView.o mLoadCategoryListCallback;
    public GiftTabView.n mLoadDefaultListCallback;
    public fq6 mModelController;
    public String mReferPage;
    public fq6.e mRefreshCallback;
    public SendGiftModel mSendGiftModel;
    public CustomMessageListener mSendGiftResultListener;
    public String mToNameShow;
    public long mToUserId;
    public String mToUserName;
    public GiftTabView mView;
    public long postId;
    public int sendCount;
    public yn4 sendGift;
    public kq6 sendOrder;
    public boolean shouldRefreshFreechance;
    public long threadId;

    /* loaded from: classes3.dex */
    public class a implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq4 a;
        public final /* synthetic */ GiftTabActivity b;

        public a(GiftTabActivity giftTabActivity, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity, dq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = giftTabActivity;
            this.a = dq4Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq4 a;
        public final /* synthetic */ GiftTabActivity b;

        public b(GiftTabActivity giftTabActivity, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity, dq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = giftTabActivity;
            this.a = dq4Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq4 a;
        public final /* synthetic */ GiftTabActivity b;

        public c(GiftTabActivity giftTabActivity, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity, dq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = giftTabActivity;
            this.a = dq4Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                this.a.dismiss();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.b.getActivity(), TbadkCoreApplication.getCurrentMemberType(), "", 17)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq4 a;
        public final /* synthetic */ GiftTabActivity b;

        public d(GiftTabActivity giftTabActivity, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity, dq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = giftTabActivity;
            this.a = dq4Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements dq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq4 a;
        public final /* synthetic */ GiftTabActivity b;

        public e(GiftTabActivity giftTabActivity, dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity, dq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = giftTabActivity;
            this.a = dq4Var;
        }

        @Override // com.repackage.dq4.e
        public void onClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                this.a.dismiss();
                if (StringUtils.isNull(this.b.addFreeUrl)) {
                    return;
                }
                this.b.shouldRefreshFreechance = true;
                UrlManager.getInstance().dealOneLink(this.b.getPageContext(), new String[]{this.b.addFreeUrl});
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabActivity a;

        public f(GiftTabActivity giftTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = giftTabActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            li.x(this.a.getActivity(), this.a.mView.g);
            if (view2 == this.a.mView.m) {
                if (this.a.mSendGiftModel == null || this.a.mView.B() <= 0 || this.a.mView.C() == null) {
                    return;
                }
                if (!li.D()) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c33);
                } else if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.getPageContext().getPageActivity())));
                } else {
                    GiftTabActivity giftTabActivity = this.a;
                    if (giftTabActivity.resetSendButtonState(giftTabActivity.mView.C(), this.a.mView.B())) {
                        this.a.mView.R();
                        GiftTabActivity giftTabActivity2 = this.a;
                        giftTabActivity2.sendGift = giftTabActivity2.mView.C();
                        GiftTabActivity giftTabActivity3 = this.a;
                        giftTabActivity3.sendCount = giftTabActivity3.mView.B();
                        this.a.sendGift.l = this.a.sendCount;
                        this.a.sendGift.m = this.a.threadId;
                        this.a.sendGift.n = this.a.postId;
                        this.a.sendGift.p = this.a.mToUserId;
                        this.a.sendGift.o = this.a.mToUserName;
                        yn4 yn4Var = this.a.sendGift;
                        GiftTabActivity giftTabActivity4 = this.a;
                        yn4Var.r = giftTabActivity4.accountType;
                        giftTabActivity4.mSendGiftModel.z(this.a.mView.C(), this.a.mView.B(), this.a.mFrom, this.a.mToUserId, this.a.mToUserName, this.a.threadId, this.a.postId);
                    }
                }
            } else if (view2 != this.a.mView.o || StringUtils.isNull(this.a.addFreeUrl)) {
            } else {
                this.a.shouldRefreshFreechance = true;
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{this.a.addFreeUrl});
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements GiftTabView.o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabActivity a;

        public g(GiftTabActivity giftTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = giftTabActivity;
        }

        @Override // com.baidu.tieba.gift.giftTab.GiftTabView.o
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.mModelController.p(i);
                this.a.mView.R();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements GiftTabView.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabActivity a;

        public h(GiftTabActivity giftTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = giftTabActivity;
        }

        @Override // com.baidu.tieba.gift.giftTab.GiftTabView.n
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mModelController.o(this.a.mFrom, this.a.mToUserId);
                this.a.mView.R();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements fq6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabActivity a;

        public i(GiftTabActivity giftTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = giftTabActivity;
        }

        @Override // com.repackage.fq6.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.freeChance = i;
                this.a.mView.N(i);
                this.a.shouldRefreshFreechance = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements fq6.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabActivity a;

        public j(GiftTabActivity giftTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = giftTabActivity;
        }

        @Override // com.repackage.fq6.e
        public void a(int i, String str, boolean z, String str2, int i2, zn4 zn4Var, ArrayList<cq6> arrayList, ArrayList<aq6> arrayList2, ArrayList<eq6> arrayList3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z), str2, Integer.valueOf(i2), zn4Var, arrayList, arrayList2, arrayList3}) == null) {
                if (i != 0 && !StringUtils.isNull(str)) {
                    this.a.showToast(str);
                }
                this.a.addFreeUrl = str2;
                if (this.a.mView != null) {
                    this.a.mView.I = i2;
                    this.a.mView.J = zn4Var;
                    this.a.mView.Q(z, arrayList, arrayList2, arrayList3);
                    this.a.mView.M(str2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements SendGiftModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabActivity a;

        public k(GiftTabActivity giftTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = giftTabActivity;
        }

        @Override // com.baidu.tieba.gift.send.SendGiftModel.c
        public void a(int i, String str, kq6 kq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, kq6Var) == null) {
                this.a.mView.G();
                if (i != 0) {
                    if (StringUtils.isNull(str)) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c33);
                    } else {
                        this.a.showToast(str);
                    }
                } else if (kq6Var == null) {
                } else {
                    this.a.sendOrder = kq6Var;
                    PaymentConfirmRequestData a = kq6Var.a();
                    a.setTerminal(PaymentConfirmRequestData.TERMINAL_ANDROID);
                    this.a.sendMessage(new CustomMessage(2002001, new PaymentConfirmActivityConfig(this.a.getPageContext().getPageActivity(), a, this.a.mReferPage, this.a.mClickZone)));
                }
            }
        }

        @Override // com.baidu.tieba.gift.send.SendGiftModel.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.mView.G();
                this.a.showToast(R.string.obfuscated_res_0x7f0f07b2);
            }
        }

        @Override // com.baidu.tieba.gift.send.SendGiftModel.c
        public void c(int i, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
                this.a.mView.G();
                if (i != 0) {
                    new ct4().b(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f110f));
                    return;
                }
                new ct4().c(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1110));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001369, this.a.sendGift));
                Intent intent = new Intent();
                intent.putExtra("success", true);
                this.a.setResult(-1, intent);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(GiftTabActivity giftTabActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity, Integer.valueOf(i)};
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
            this.a = giftTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (this.a.sendOrder != null && str.equalsIgnoreCase(this.a.sendOrder.b())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001369, this.a.sendGift));
                }
                new ct4().c(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1110));
                Intent intent = new Intent();
                intent.putExtra("success", true);
                this.a.setResult(-1, intent);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabActivity a;

        public m(GiftTabActivity giftTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = giftTabActivity;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.mView.e.setVisibility(0);
                this.a.mModelController.o(this.a.mFrom, this.a.mToUserId);
                this.a.mModelController.n(this.a.mFrom);
                this.a.mView.R();
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
    public class n implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabActivity a;

        public n(GiftTabActivity giftTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = giftTabActivity;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.setResult(-1);
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

    public GiftTabActivity() {
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
        this.mHasShowAnim = false;
        this.shouldRefreshFreechance = false;
        this.mCommenClickListener = new f(this);
        this.mLoadCategoryListCallback = new g(this);
        this.mLoadDefaultListCallback = new h(this);
        this.mFreeCountCallback = new i(this);
        this.mRefreshCallback = new j(this);
        this.mGiftSendCallback = new k(this);
        this.mSendGiftResultListener = new l(this, 2001367);
    }

    private void hideAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            this.mView.d.setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            this.mView.d.startAnimation(alphaAnimation);
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.obfuscated_res_0x7f010041);
            loadAnimation.setDuration(300L);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new n(this));
            this.mView.e.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean resetSendButtonState(yn4 yn4Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65559, this, yn4Var, i2)) == null) {
            if (yn4Var == null || i2 <= 0) {
                return false;
            }
            int i3 = yn4Var.f;
            if (i3 == 1) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (currentTimeMillis < yn4Var.h) {
                    new ct4().b(getResources().getString(R.string.obfuscated_res_0x7f0f07ab));
                    return false;
                } else if (currentTimeMillis > yn4Var.i) {
                    new ct4().b(getResources().getString(R.string.obfuscated_res_0x7f0f07aa));
                    return false;
                }
            } else if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 == 5 && this.freeChance < i2) {
                        dq4 dq4Var = new dq4(getActivity());
                        dq4Var.setMessageShowCenter(true);
                        if (this.freeChance <= 0) {
                            dq4Var.setTitle(R.string.obfuscated_res_0x7f0f0823);
                        } else {
                            dq4Var.setTitle(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f0ae9), Integer.valueOf(this.freeChance)));
                        }
                        dq4Var.setMessageId(R.string.obfuscated_res_0x7f0f07c1);
                        dq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new d(this, dq4Var));
                        dq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f079e, new e(this, dq4Var));
                        dq4Var.create(getPageContext());
                        dq4Var.show();
                        return false;
                    }
                } else if (TbadkCoreApplication.getCurrentMemberType() >= 2) {
                    return true;
                } else {
                    dq4 dq4Var2 = new dq4(getActivity());
                    dq4Var2.setButtonTextColor(R.color.CAM_X0305);
                    dq4Var2.setTitle(R.string.obfuscated_res_0x7f0f0cee);
                    dq4Var2.setNegativeButton(R.string.obfuscated_res_0x7f0f0376, new b(this, dq4Var2));
                    dq4Var2.setPositiveButton(R.string.obfuscated_res_0x7f0f0cea, new c(this, dq4Var2));
                    dq4Var2.create(getPageContext());
                    dq4Var2.show();
                    return false;
                }
            } else if (yn4Var.k < i2) {
                dq4 dq4Var3 = new dq4(getActivity());
                dq4Var3.setMessageShowCenter(true);
                dq4Var3.setTitle(R.string.obfuscated_res_0x7f0f07a8);
                dq4Var3.setMessage(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f09ef), Integer.valueOf(yn4Var.k)));
                dq4Var3.setNegativeButton(R.string.obfuscated_res_0x7f0f098e, new a(this, dq4Var3));
                dq4Var3.create(getPageContext());
                dq4Var3.show();
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    private void showAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            this.mView.d.setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
            alphaAnimation.setDuration(300L);
            this.mView.d.startAnimation(alphaAnimation);
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.obfuscated_res_0x7f010042);
            loadAnimation.setDuration(300L);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new m(this));
            this.mView.e.startAnimation(loadAnimation);
            this.mHasShowAnim = true;
        }
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
            this.mView.K(i2);
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
            if (getIntent() != null) {
                this.mToUserId = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_RECEIVER_ID, 0L);
                this.mToUserName = getIntent().getStringExtra(GiftTabActivityConfig.GIFT_RECEIVER_NAME);
                this.mToNameShow = getIntent().getStringExtra(GiftTabActivityConfig.GIFT_RECEIVER_NAME_SHOW);
                this.mFrom = getIntent().getStringExtra("from");
                this.postId = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_POST_ID, 0L);
                this.threadId = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_THREAD_ID, 0L);
                this.accountType = getIntent().getIntExtra("account_type", 0);
                this.mReferPage = getIntent().getStringExtra(MemberPayStatistic.REFER_PAGE);
                this.mClickZone = getIntent().getStringExtra(MemberPayStatistic.CLICK_ZONE);
            }
            GiftTabView giftTabView = new GiftTabView(this, this.mCommenClickListener);
            this.mView = giftTabView;
            TextView textView = giftTabView.p;
            String string = getResources().getString(R.string.obfuscated_res_0x7f0f07b4);
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(this.mToNameShow) ? this.mToUserName : this.mToNameShow;
            textView.setText(String.format(string, objArr));
            this.mView.O(this.mLoadCategoryListCallback);
            this.mView.P(this.mLoadDefaultListCallback);
            fq6 fq6Var = new fq6(getPageContext());
            this.mModelController = fq6Var;
            fq6Var.s(this.mRefreshCallback);
            this.mModelController.r(this.mFreeCountCallback);
            SendGiftModel sendGiftModel = new SendGiftModel(getPageContext());
            this.mSendGiftModel = sendGiftModel;
            sendGiftModel.A(this.mGiftSendCallback);
            registerListener(this.mSendGiftResultListener);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            this.mView.A();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i2, keyEvent)) == null) {
            if (i2 == 4 && this.mView.x.getVisibility() == 0) {
                this.mView.x.setVisibility(8);
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, intent) == null) {
            super.onNewIntent(intent);
            this.mToUserId = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_RECEIVER_ID, 0L);
            this.mToUserName = getIntent().getStringExtra(GiftTabActivityConfig.GIFT_RECEIVER_NAME);
            this.mToNameShow = getIntent().getStringExtra(GiftTabActivityConfig.GIFT_RECEIVER_NAME_SHOW);
            this.mFrom = getIntent().getStringExtra("from");
            this.postId = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_POST_ID, 0L);
            this.threadId = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_THREAD_ID, 0L);
            this.mReferPage = getIntent().getStringExtra(MemberPayStatistic.REFER_PAGE);
            this.mClickZone = getIntent().getStringExtra(MemberPayStatistic.CLICK_ZONE);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        fq6 fq6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            if (!this.shouldRefreshFreechance || (fq6Var = this.mModelController) == null) {
                return;
            }
            fq6Var.n(this.mFrom);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z || this.mHasShowAnim) {
                return;
            }
            showAnimation();
        }
    }

    public void setShouldRefreshFreechance(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.shouldRefreshFreechance = z;
        }
    }
}
