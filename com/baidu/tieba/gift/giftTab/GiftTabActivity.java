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
import d.a.p0.s.q.j0;
import d.a.p0.s.q.k0;
import d.a.p0.s.s.a;
import d.a.q0.y0.b.f;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class GiftTabActivity extends BaseActivity<GiftTabActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int accountType;
    public String addFreeUrl;
    public int freeChance;
    public String mClickZone;
    public View.OnClickListener mCommenClickListener;
    public f.d mFreeCountCallback;
    public String mFrom;
    public SendGiftModel.c mGiftSendCallback;
    public boolean mHasShowAnim;
    public GiftTabView.o mLoadCategoryListCallback;
    public GiftTabView.n mLoadDefaultListCallback;
    public d.a.q0.y0.b.f mModelController;
    public String mReferPage;
    public f.e mRefreshCallback;
    public SendGiftModel mSendGiftModel;
    public CustomMessageListener mSendGiftResultListener;
    public String mToNameShow;
    public long mToUserId;
    public String mToUserName;
    public GiftTabView mView;
    public long postId;
    public int sendCount;
    public j0 sendGift;
    public d.a.q0.y0.d.a sendOrder;
    public boolean shouldRefreshFreechance;
    public long threadId;

    /* loaded from: classes4.dex */
    public class a implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f16401e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GiftTabActivity f16402f;

        public a(GiftTabActivity giftTabActivity, d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16402f = giftTabActivity;
            this.f16401e = aVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f16401e.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f16403e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GiftTabActivity f16404f;

        public b(GiftTabActivity giftTabActivity, d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16404f = giftTabActivity;
            this.f16403e = aVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f16403e.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f16405e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GiftTabActivity f16406f;

        public c(GiftTabActivity giftTabActivity, d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16406f = giftTabActivity;
            this.f16405e = aVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f16405e.dismiss();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f16406f.getActivity(), TbadkCoreApplication.getCurrentMemberType(), "", 17)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f16407e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GiftTabActivity f16408f;

        public d(GiftTabActivity giftTabActivity, d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16408f = giftTabActivity;
            this.f16407e = aVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f16407e.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f16409e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GiftTabActivity f16410f;

        public e(GiftTabActivity giftTabActivity, d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16410f = giftTabActivity;
            this.f16409e = aVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f16409e.dismiss();
                if (StringUtils.isNull(this.f16410f.addFreeUrl)) {
                    return;
                }
                this.f16410f.shouldRefreshFreechance = true;
                UrlManager.getInstance().dealOneLink(this.f16410f.getPageContext(), new String[]{this.f16410f.addFreeUrl});
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabActivity f16411e;

        public f(GiftTabActivity giftTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16411e = giftTabActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            d.a.d.e.p.l.x(this.f16411e.getActivity(), this.f16411e.mView.k);
            if (view == this.f16411e.mView.q) {
                if (this.f16411e.mSendGiftModel == null || this.f16411e.mView.B() <= 0 || this.f16411e.mView.C() == null) {
                    return;
                }
                if (!d.a.d.e.p.l.D()) {
                    this.f16411e.showToast(R.string.neterror);
                } else if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(this.f16411e.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f16411e.getPageContext().getPageActivity())));
                } else {
                    GiftTabActivity giftTabActivity = this.f16411e;
                    if (giftTabActivity.resetSendButtonState(giftTabActivity.mView.C(), this.f16411e.mView.B())) {
                        this.f16411e.mView.R();
                        GiftTabActivity giftTabActivity2 = this.f16411e;
                        giftTabActivity2.sendGift = giftTabActivity2.mView.C();
                        GiftTabActivity giftTabActivity3 = this.f16411e;
                        giftTabActivity3.sendCount = giftTabActivity3.mView.B();
                        this.f16411e.sendGift.l = this.f16411e.sendCount;
                        this.f16411e.sendGift.m = this.f16411e.threadId;
                        this.f16411e.sendGift.n = this.f16411e.postId;
                        this.f16411e.sendGift.p = this.f16411e.mToUserId;
                        this.f16411e.sendGift.o = this.f16411e.mToUserName;
                        j0 j0Var = this.f16411e.sendGift;
                        GiftTabActivity giftTabActivity4 = this.f16411e;
                        j0Var.r = giftTabActivity4.accountType;
                        giftTabActivity4.mSendGiftModel.x(this.f16411e.mView.C(), this.f16411e.mView.B(), this.f16411e.mFrom, this.f16411e.mToUserId, this.f16411e.mToUserName, this.f16411e.threadId, this.f16411e.postId);
                    }
                }
            } else if (view != this.f16411e.mView.s || StringUtils.isNull(this.f16411e.addFreeUrl)) {
            } else {
                this.f16411e.shouldRefreshFreechance = true;
                UrlManager.getInstance().dealOneLink(this.f16411e.getPageContext(), new String[]{this.f16411e.addFreeUrl});
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements GiftTabView.o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GiftTabActivity f16412a;

        public g(GiftTabActivity giftTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16412a = giftTabActivity;
        }

        @Override // com.baidu.tieba.gift.giftTab.GiftTabView.o
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f16412a.mModelController.p(i2);
                this.f16412a.mView.R();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements GiftTabView.n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GiftTabActivity f16413a;

        public h(GiftTabActivity giftTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16413a = giftTabActivity;
        }

        @Override // com.baidu.tieba.gift.giftTab.GiftTabView.n
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16413a.mModelController.o(this.f16413a.mFrom, this.f16413a.mToUserId);
                this.f16413a.mView.R();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements f.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GiftTabActivity f16414a;

        public i(GiftTabActivity giftTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16414a = giftTabActivity;
        }

        @Override // d.a.q0.y0.b.f.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f16414a.freeChance = i2;
                this.f16414a.mView.N(i2);
                this.f16414a.shouldRefreshFreechance = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements f.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GiftTabActivity f16415a;

        public j(GiftTabActivity giftTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16415a = giftTabActivity;
        }

        @Override // d.a.q0.y0.b.f.e
        public void a(int i2, String str, boolean z, String str2, int i3, k0 k0Var, ArrayList<d.a.q0.y0.b.c> arrayList, ArrayList<d.a.q0.y0.b.a> arrayList2, ArrayList<d.a.q0.y0.b.e> arrayList3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z), str2, Integer.valueOf(i3), k0Var, arrayList, arrayList2, arrayList3}) == null) {
                if (i2 != 0 && !StringUtils.isNull(str)) {
                    this.f16415a.showToast(str);
                }
                this.f16415a.addFreeUrl = str2;
                if (this.f16415a.mView != null) {
                    this.f16415a.mView.M = i3;
                    this.f16415a.mView.N = k0Var;
                    this.f16415a.mView.Q(z, arrayList, arrayList2, arrayList3);
                    this.f16415a.mView.M(str2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements SendGiftModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GiftTabActivity f16416a;

        public k(GiftTabActivity giftTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16416a = giftTabActivity;
        }

        @Override // com.baidu.tieba.gift.send.SendGiftModel.c
        public void a(int i2, String str, d.a.q0.y0.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, aVar) == null) {
                this.f16416a.mView.G();
                if (i2 != 0) {
                    if (StringUtils.isNull(str)) {
                        this.f16416a.showToast(R.string.neterror);
                    } else {
                        this.f16416a.showToast(str);
                    }
                } else if (aVar == null) {
                } else {
                    this.f16416a.sendOrder = aVar;
                    PaymentConfirmRequestData a2 = aVar.a();
                    a2.setTerminal(PaymentConfirmRequestData.TERMINAL_ANDROID);
                    this.f16416a.sendMessage(new CustomMessage(2002001, new PaymentConfirmActivityConfig(this.f16416a.getPageContext().getPageActivity(), a2, this.f16416a.mReferPage, this.f16416a.mClickZone)));
                }
            }
        }

        @Override // com.baidu.tieba.gift.send.SendGiftModel.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f16416a.mView.G();
                this.f16416a.showToast(R.string.gift_send_data_illegal);
            }
        }

        @Override // com.baidu.tieba.gift.send.SendGiftModel.c
        public void c(int i2, String str, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) {
                this.f16416a.mView.G();
                if (i2 != 0) {
                    new d.a.p0.s.f0.c().b(this.f16416a.getResources().getString(R.string.send_gift_fail));
                    return;
                }
                new d.a.p0.s.f0.c().c(this.f16416a.getResources().getString(R.string.send_gift_succeed));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001369, this.f16416a.sendGift));
                Intent intent = new Intent();
                intent.putExtra("success", true);
                this.f16416a.setResult(-1, intent);
                this.f16416a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GiftTabActivity f16417a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(GiftTabActivity giftTabActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity, Integer.valueOf(i2)};
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
            this.f16417a = giftTabActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (this.f16417a.sendOrder != null && str.equalsIgnoreCase(this.f16417a.sendOrder.b())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001369, this.f16417a.sendGift));
                }
                new d.a.p0.s.f0.c().c(this.f16417a.getResources().getString(R.string.send_gift_succeed));
                Intent intent = new Intent();
                intent.putExtra("success", true);
                this.f16417a.setResult(-1, intent);
                this.f16417a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GiftTabActivity f16418a;

        public m(GiftTabActivity giftTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16418a = giftTabActivity;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f16418a.mView.f16424i.setVisibility(0);
                this.f16418a.mModelController.o(this.f16418a.mFrom, this.f16418a.mToUserId);
                this.f16418a.mModelController.n(this.f16418a.mFrom);
                this.f16418a.mView.R();
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
    public class n implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GiftTabActivity f16419a;

        public n(GiftTabActivity giftTabActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16419a = giftTabActivity;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f16419a.setResult(-1);
                this.f16419a.finish();
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
            this.mView.f16423h.setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            this.mView.f16423h.startAnimation(alphaAnimation);
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_down);
            loadAnimation.setDuration(300L);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new n(this));
            this.mView.f16424i.startAnimation(loadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean resetSendButtonState(j0 j0Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65559, this, j0Var, i2)) == null) {
            if (j0Var == null || i2 <= 0) {
                return false;
            }
            int i3 = j0Var.f53365f;
            if (i3 == 1) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (currentTimeMillis < j0Var.f53367h) {
                    new d.a.p0.s.f0.c().b(getResources().getString(R.string.gift_limit_time_not_start));
                    return false;
                } else if (currentTimeMillis > j0Var.f53368i) {
                    new d.a.p0.s.f0.c().b(getResources().getString(R.string.gift_limit_time_has_over));
                    return false;
                }
            } else if (i3 != 2) {
                if (i3 != 4) {
                    if (i3 == 5 && this.freeChance < i2) {
                        d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(getActivity());
                        aVar.setMessageShowCenter(true);
                        if (this.freeChance <= 0) {
                            aVar.setTitle(R.string.have_no_free_chance);
                        } else {
                            aVar.setTitle(String.format(getPageContext().getString(R.string.most_free_gift), Integer.valueOf(this.freeChance)));
                        }
                        aVar.setMessageId(R.string.go_to_get_more_free_chance);
                        aVar.setNegativeButton(R.string.cancel, new d(this, aVar));
                        aVar.setPositiveButton(R.string.get_more_chance, new e(this, aVar));
                        aVar.create(getPageContext());
                        aVar.show();
                        return false;
                    }
                } else if (TbadkCoreApplication.getCurrentMemberType() >= 2) {
                    return true;
                } else {
                    d.a.p0.s.s.a aVar2 = new d.a.p0.s.s.a(getActivity());
                    aVar2.setButtonTextColor(R.color.CAM_X0305);
                    aVar2.setTitle(R.string.open_vip_can_send_gift);
                    aVar2.setNegativeButton(R.string.cancel, new b(this, aVar2));
                    aVar2.setPositiveButton(R.string.open_now, new c(this, aVar2));
                    aVar2.create(getPageContext());
                    aVar2.show();
                    return false;
                }
            } else if (j0Var.k < i2) {
                d.a.p0.s.s.a aVar3 = new d.a.p0.s.s.a(getActivity());
                aVar3.setMessageShowCenter(true);
                aVar3.setTitle(R.string.gift_limit_number_not_enough);
                aVar3.setMessage(String.format(getPageContext().getString(R.string.limit_number_gift_has_left), Integer.valueOf(j0Var.k)));
                aVar3.setNegativeButton(R.string.know, new a(this, aVar3));
                aVar3.create(getPageContext());
                aVar3.show();
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    private void showAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            this.mView.f16423h.setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
            alphaAnimation.setDuration(300L);
            this.mView.f16423h.startAnimation(alphaAnimation);
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_up);
            loadAnimation.setDuration(300L);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new m(this));
            this.mView.f16424i.startAnimation(loadAnimation);
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
                this.mToUserId = getIntent().getLongExtra("gift_receiver_id", 0L);
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
            TextView textView = giftTabView.t;
            String string = getResources().getString(R.string.gift_to);
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(this.mToNameShow) ? this.mToUserName : this.mToNameShow;
            textView.setText(String.format(string, objArr));
            this.mView.O(this.mLoadCategoryListCallback);
            this.mView.P(this.mLoadDefaultListCallback);
            d.a.q0.y0.b.f fVar = new d.a.q0.y0.b.f(getPageContext());
            this.mModelController = fVar;
            fVar.s(this.mRefreshCallback);
            this.mModelController.r(this.mFreeCountCallback);
            SendGiftModel sendGiftModel = new SendGiftModel(getPageContext());
            this.mSendGiftModel = sendGiftModel;
            sendGiftModel.y(this.mGiftSendCallback);
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
            if (i2 == 4 && this.mView.B.getVisibility() == 0) {
                this.mView.B.setVisibility(8);
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
            this.mToUserId = getIntent().getLongExtra("gift_receiver_id", 0L);
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
        d.a.q0.y0.b.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            if (!this.shouldRefreshFreechance || (fVar = this.mModelController) == null) {
                return;
            }
            fVar.n(this.mFrom);
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
