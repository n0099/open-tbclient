package com.baidu.tieba.gift.giftTab;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
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
import com.baidu.tieba.ay6;
import com.baidu.tieba.dt4;
import com.baidu.tieba.et4;
import com.baidu.tieba.gift.giftTab.GiftTabView;
import com.baidu.tieba.gift.send.SendGiftModel;
import com.baidu.tieba.kv4;
import com.baidu.tieba.qx6;
import com.baidu.tieba.sx6;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import com.baidu.tieba.ux6;
import com.baidu.tieba.vx6;
import com.baidu.tieba.wy4;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class GiftTabActivity extends BaseActivity<GiftTabActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GiftTabView a;
    public vx6 b;
    public SendGiftModel c;
    public String d;
    public boolean e;
    public long f;
    public String g;
    public String h;
    public long i;
    public long j;
    public int k;
    public String l;
    public dt4 m;
    public ay6 n;
    public int o;
    public int p;
    public boolean q;
    public String r;
    public String s;
    public View.OnClickListener t;
    public GiftTabView.o u;
    public GiftTabView.n v;
    public vx6.d w;
    public vx6.e x;
    public SendGiftModel.c y;
    public CustomMessageListener z;

    /* loaded from: classes4.dex */
    public class a implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv4 a;
        public final /* synthetic */ GiftTabActivity b;

        public a(GiftTabActivity giftTabActivity, kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity, kv4Var};
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
            this.a = kv4Var;
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv4 a;
        public final /* synthetic */ GiftTabActivity b;

        public b(GiftTabActivity giftTabActivity, kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity, kv4Var};
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
            this.a = kv4Var;
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv4 a;
        public final /* synthetic */ GiftTabActivity b;

        public c(GiftTabActivity giftTabActivity, kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity, kv4Var};
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
            this.a = kv4Var;
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                this.a.dismiss();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.b.getActivity(), TbadkCoreApplication.getCurrentMemberType(), "", 17)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv4 a;
        public final /* synthetic */ GiftTabActivity b;

        public d(GiftTabActivity giftTabActivity, kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity, kv4Var};
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
            this.a = kv4Var;
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements kv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kv4 a;
        public final /* synthetic */ GiftTabActivity b;

        public e(GiftTabActivity giftTabActivity, kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity, kv4Var};
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
            this.a = kv4Var;
        }

        @Override // com.baidu.tieba.kv4.e
        public void onClick(kv4 kv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                this.a.dismiss();
                if (!StringUtils.isNull(this.b.l)) {
                    this.b.q = true;
                    UrlManager.getInstance().dealOneLink(this.b.getPageContext(), new String[]{this.b.l});
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null) {
                return;
            }
            yi.z(this.a.getActivity(), this.a.a.g);
            if (view2 == this.a.a.m) {
                if (this.a.c != null && this.a.a.B() > 0 && this.a.a.C() != null) {
                    if (!yi.F()) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c81);
                    } else if (!TbadkCoreApplication.isLogin()) {
                        TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.getPageContext().getPageActivity())));
                    } else {
                        GiftTabActivity giftTabActivity = this.a;
                        if (giftTabActivity.T1(giftTabActivity.a.C(), this.a.a.B())) {
                            this.a.a.S();
                            GiftTabActivity giftTabActivity2 = this.a;
                            giftTabActivity2.m = giftTabActivity2.a.C();
                            GiftTabActivity giftTabActivity3 = this.a;
                            giftTabActivity3.o = giftTabActivity3.a.B();
                            this.a.m.l = this.a.o;
                            this.a.m.m = this.a.i;
                            this.a.m.n = this.a.j;
                            this.a.m.p = this.a.f;
                            this.a.m.o = this.a.g;
                            dt4 dt4Var = this.a.m;
                            GiftTabActivity giftTabActivity4 = this.a;
                            dt4Var.r = giftTabActivity4.p;
                            giftTabActivity4.c.A(this.a.a.C(), this.a.a.B(), this.a.d, this.a.f, this.a.g, this.a.i, this.a.j);
                        }
                    }
                }
            } else if (view2 == this.a.a.o && !StringUtils.isNull(this.a.l)) {
                this.a.q = true;
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{this.a.l});
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.b.p(i);
                this.a.a.S();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.b.o(this.a.d, this.a.f);
                this.a.a.S();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements vx6.d {
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

        @Override // com.baidu.tieba.vx6.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(1048576, this, i) != null) {
                return;
            }
            this.a.k = i;
            this.a.a.O(i);
            this.a.q = false;
        }
    }

    /* loaded from: classes4.dex */
    public class j implements vx6.e {
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

        @Override // com.baidu.tieba.vx6.e
        public void a(int i, String str, boolean z, String str2, int i2, et4 et4Var, ArrayList<sx6> arrayList, ArrayList<qx6> arrayList2, ArrayList<ux6> arrayList3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z), str2, Integer.valueOf(i2), et4Var, arrayList, arrayList2, arrayList3}) == null) {
                if (i != 0 && !StringUtils.isNull(str)) {
                    this.a.showToast(str);
                }
                this.a.l = str2;
                if (this.a.a != null) {
                    this.a.a.I = i2;
                    this.a.a.J = et4Var;
                    this.a.a.R(z, arrayList, arrayList2, arrayList3);
                    this.a.a.N(str2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void a(int i, String str, ay6 ay6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, ay6Var) == null) {
                this.a.a.G();
                if (i != 0) {
                    if (StringUtils.isNull(str)) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c81);
                    } else {
                        this.a.showToast(str);
                    }
                } else if (ay6Var != null) {
                    this.a.n = ay6Var;
                    PaymentConfirmRequestData a = ay6Var.a();
                    a.setTerminal(PaymentConfirmRequestData.TERMINAL_ANDROID);
                    this.a.sendMessage(new CustomMessage(2002001, new PaymentConfirmActivityConfig(this.a.getPageContext().getPageActivity(), a, this.a.r, this.a.s)));
                }
            }
        }

        @Override // com.baidu.tieba.gift.send.SendGiftModel.c
        public void c(int i, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
                this.a.a.G();
                if (i != 0) {
                    new wy4().c(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f115c));
                    return;
                }
                new wy4().d(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f115d));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001369, this.a.m));
                Intent intent = new Intent();
                intent.putExtra("success", true);
                this.a.setResult(-1, intent);
                this.a.finish();
            }
        }

        @Override // com.baidu.tieba.gift.send.SendGiftModel.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.a.G();
                this.a.showToast(R.string.obfuscated_res_0x7f0f07ee);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (this.a.n != null && str.equalsIgnoreCase(this.a.n.b())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001369, this.a.m));
                }
                new wy4().d(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f115d));
                Intent intent = new Intent();
                intent.putExtra("success", true);
                this.a.setResult(-1, intent);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabActivity a;

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
                this.a.a.e.setVisibility(0);
                this.a.b.o(this.a.d, this.a.f);
                this.a.b.n(this.a.d);
                this.a.a.S();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabActivity a;

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
        this.e = false;
        this.q = false;
        this.t = new f(this);
        this.u = new g(this);
        this.v = new h(this);
        this.w = new i(this);
        this.x = new j(this);
        this.y = new k(this);
        this.z = new l(this, 2001367);
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.d.setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            this.a.d.startAnimation(alphaAnimation);
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.obfuscated_res_0x7f010041);
            loadAnimation.setDuration(300L);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new n(this));
            this.a.e.startAnimation(loadAnimation);
        }
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.d.setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
            alphaAnimation.setDuration(300L);
            this.a.d.startAnimation(alphaAnimation);
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.obfuscated_res_0x7f010042);
            loadAnimation.setDuration(300L);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new m(this));
            this.a.e.startAnimation(loadAnimation);
            this.e = true;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i2, keyEvent)) == null) {
            if (i2 == 4 && this.a.x.getVisibility() == 0) {
                this.a.x.setVisibility(8);
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.a.K(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (this.a != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                this.a.L(displayMetrics);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (z && !this.e) {
                U1();
            }
        }
    }

    public final boolean T1(dt4 dt4Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dt4Var, i2)) == null) {
            if (dt4Var == null || i2 <= 0) {
                return false;
            }
            int i3 = dt4Var.f;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 4) {
                        if (i3 == 5 && this.k < i2) {
                            kv4 kv4Var = new kv4(getActivity());
                            kv4Var.setMessageShowCenter(true);
                            if (this.k <= 0) {
                                kv4Var.setTitle(R.string.obfuscated_res_0x7f0f0861);
                            } else {
                                kv4Var.setTitle(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f0b24), Integer.valueOf(this.k)));
                            }
                            kv4Var.setMessageId(R.string.obfuscated_res_0x7f0f07fe);
                            kv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0377, new d(this, kv4Var));
                            kv4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f07da, new e(this, kv4Var));
                            kv4Var.create(getPageContext());
                            kv4Var.show();
                            return false;
                        }
                    } else if (TbadkCoreApplication.getCurrentMemberType() >= 2) {
                        return true;
                    } else {
                        kv4 kv4Var2 = new kv4(getActivity());
                        kv4Var2.setButtonTextColor(R.color.CAM_X0305);
                        kv4Var2.setTitle(R.string.obfuscated_res_0x7f0f0d41);
                        kv4Var2.setNegativeButton(R.string.obfuscated_res_0x7f0f0377, new b(this, kv4Var2));
                        kv4Var2.setPositiveButton(R.string.obfuscated_res_0x7f0f0d3d, new c(this, kv4Var2));
                        kv4Var2.create(getPageContext());
                        kv4Var2.show();
                        return false;
                    }
                } else if (dt4Var.k < i2) {
                    kv4 kv4Var3 = new kv4(getActivity());
                    kv4Var3.setMessageShowCenter(true);
                    kv4Var3.setTitle(R.string.obfuscated_res_0x7f0f07e4);
                    kv4Var3.setMessage(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f0a16), Integer.valueOf(dt4Var.k)));
                    kv4Var3.setNegativeButton(R.string.obfuscated_res_0x7f0f09d4, new a(this, kv4Var3));
                    kv4Var3.create(getPageContext());
                    kv4Var3.show();
                    return false;
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (currentTimeMillis < dt4Var.h) {
                    new wy4().c(getResources().getString(R.string.obfuscated_res_0x7f0f07e7));
                    return false;
                } else if (currentTimeMillis > dt4Var.i) {
                    new wy4().c(getResources().getString(R.string.obfuscated_res_0x7f0f07e6));
                    return false;
                }
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            S1();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            closeActivity();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            this.a.A();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        vx6 vx6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            if (this.q && (vx6Var = this.b) != null) {
                vx6Var.n(this.d);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            requestWindowFeature(1);
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            setActivityBgTransparent();
            if (getIntent() != null) {
                this.f = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_RECEIVER_ID, 0L);
                this.g = getIntent().getStringExtra(GiftTabActivityConfig.GIFT_RECEIVER_NAME);
                this.h = getIntent().getStringExtra(GiftTabActivityConfig.GIFT_RECEIVER_NAME_SHOW);
                this.d = getIntent().getStringExtra("from");
                this.j = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_POST_ID, 0L);
                this.i = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_THREAD_ID, 0L);
                this.p = getIntent().getIntExtra("account_type", 0);
                this.r = getIntent().getStringExtra(MemberPayStatistic.REFER_PAGE);
                this.s = getIntent().getStringExtra(MemberPayStatistic.CLICK_ZONE);
            }
            GiftTabView giftTabView = new GiftTabView(this, this.t);
            this.a = giftTabView;
            TextView textView = giftTabView.p;
            String string = getResources().getString(R.string.obfuscated_res_0x7f0f07f0);
            Object[] objArr = new Object[1];
            if (TextUtils.isEmpty(this.h)) {
                str = this.g;
            } else {
                str = this.h;
            }
            objArr[0] = str;
            textView.setText(String.format(string, objArr));
            this.a.P(this.u);
            this.a.Q(this.v);
            vx6 vx6Var = new vx6(getPageContext());
            this.b = vx6Var;
            vx6Var.s(this.x);
            this.b.r(this.w);
            SendGiftModel sendGiftModel = new SendGiftModel(getPageContext());
            this.c = sendGiftModel;
            sendGiftModel.B(this.y);
            registerListener(this.z);
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, intent) == null) {
            super.onNewIntent(intent);
            this.f = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_RECEIVER_ID, 0L);
            this.g = getIntent().getStringExtra(GiftTabActivityConfig.GIFT_RECEIVER_NAME);
            this.h = getIntent().getStringExtra(GiftTabActivityConfig.GIFT_RECEIVER_NAME_SHOW);
            this.d = getIntent().getStringExtra("from");
            this.j = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_POST_ID, 0L);
            this.i = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_THREAD_ID, 0L);
            this.r = getIntent().getStringExtra(MemberPayStatistic.REFER_PAGE);
            this.s = getIntent().getStringExtra(MemberPayStatistic.CLICK_ZONE);
        }
    }
}
