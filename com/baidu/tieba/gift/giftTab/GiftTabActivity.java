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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.d25;
import com.baidu.tieba.e25;
import com.baidu.tieba.e95;
import com.baidu.tieba.fw7;
import com.baidu.tieba.gift.giftTab.GiftTabView;
import com.baidu.tieba.gift.send.SendGiftModel;
import com.baidu.tieba.hw7;
import com.baidu.tieba.jw7;
import com.baidu.tieba.kw7;
import com.baidu.tieba.m45;
import com.baidu.tieba.pay.panel.PayPanelUtils;
import com.baidu.tieba.pw7;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class GiftTabActivity extends BaseActivity<GiftTabActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GiftTabView a;
    public kw7 b;
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
    public d25 m;
    public pw7 n;
    public int o;
    public int p;
    public boolean q;
    public String r;
    public String s;
    public View.OnClickListener t;
    public GiftTabView.o u;
    public GiftTabView.n v;
    public kw7.d w;
    public kw7.e x;
    public SendGiftModel.c y;
    public CustomMessageListener z;

    /* loaded from: classes6.dex */
    public class a implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m45 a;
        public final /* synthetic */ GiftTabActivity b;

        public a(GiftTabActivity giftTabActivity, m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity, m45Var};
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
            this.a = m45Var;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m45 a;
        public final /* synthetic */ GiftTabActivity b;

        public b(GiftTabActivity giftTabActivity, m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity, m45Var};
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
            this.a = m45Var;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m45 a;
        public final /* synthetic */ GiftTabActivity b;

        public c(GiftTabActivity giftTabActivity, m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity, m45Var};
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
            this.a = m45Var;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                this.a.dismiss();
                PayPanelUtils.launchPayPanel(this.b.getPageContext());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m45 a;
        public final /* synthetic */ GiftTabActivity b;

        public d(GiftTabActivity giftTabActivity, m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity, m45Var};
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
            this.a = m45Var;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements m45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m45 a;
        public final /* synthetic */ GiftTabActivity b;

        public e(GiftTabActivity giftTabActivity, m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabActivity, m45Var};
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
            this.a = m45Var;
        }

        @Override // com.baidu.tieba.m45.e
        public void onClick(m45 m45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m45Var) == null) {
                this.a.dismiss();
                if (!StringUtils.isNull(this.b.l)) {
                    this.b.q = true;
                    UrlManager.getInstance().dealOneLink(this.b.getPageContext(), new String[]{this.b.l});
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
            BdUtilHelper.hideSoftKeyPad(this.a.getActivity(), this.a.a.g);
            if (view2 == this.a.a.m) {
                if (this.a.c != null && this.a.a.B() > 0 && this.a.a.C() != null) {
                    if (!BdUtilHelper.isNetOk()) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0e21);
                    } else if (!TbadkCoreApplication.isLogin()) {
                        TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.getPageContext().getPageActivity())));
                    } else {
                        GiftTabActivity giftTabActivity = this.a;
                        if (giftTabActivity.S1(giftTabActivity.a.C(), this.a.a.B())) {
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
                            d25 d25Var = this.a.m;
                            GiftTabActivity giftTabActivity4 = this.a;
                            d25Var.r = giftTabActivity4.p;
                            giftTabActivity4.c.O(this.a.a.C(), this.a.a.B(), this.a.d, this.a.f, this.a.g, this.a.i, this.a.j);
                        }
                    }
                }
            } else if (view2 == this.a.a.o && !StringUtils.isNull(this.a.l)) {
                this.a.q = true;
                UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{this.a.l});
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class i implements kw7.d {
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

        @Override // com.baidu.tieba.kw7.d
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

    /* loaded from: classes6.dex */
    public class j implements kw7.e {
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

        @Override // com.baidu.tieba.kw7.e
        public void a(int i, String str, boolean z, String str2, int i2, e25 e25Var, ArrayList<hw7> arrayList, ArrayList<fw7> arrayList2, ArrayList<jw7> arrayList3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z), str2, Integer.valueOf(i2), e25Var, arrayList, arrayList2, arrayList3}) == null) {
                if (i != 0 && !StringUtils.isNull(str)) {
                    this.a.showToast(str);
                }
                this.a.l = str2;
                if (this.a.a != null) {
                    this.a.a.I = i2;
                    this.a.a.J = e25Var;
                    this.a.a.R(z, arrayList, arrayList2, arrayList3);
                    this.a.a.N(str2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
        public void a(int i, String str, pw7 pw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, pw7Var) == null) {
                this.a.a.G();
                if (i != 0) {
                    if (StringUtils.isNull(str)) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0e21);
                    } else {
                        this.a.showToast(str);
                    }
                } else if (pw7Var != null) {
                    this.a.n = pw7Var;
                    PaymentConfirmRequestData a = pw7Var.a();
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
                    new e95().c(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1357));
                    return;
                }
                new e95().d(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1358));
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
                this.a.showToast(R.string.obfuscated_res_0x7f0f08ec);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                new e95().d(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1358));
                Intent intent = new Intent();
                intent.putExtra("success", true);
                this.a.setResult(-1, intent);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
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

    public final void R1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a.d.setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            this.a.d.startAnimation(alphaAnimation);
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_down);
            loadAnimation.setDuration(300L);
            loadAnimation.setFillAfter(true);
            loadAnimation.setAnimationListener(new n(this));
            this.a.e.startAnimation(loadAnimation);
        }
    }

    public final void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.d.setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
            alphaAnimation.setDuration(300L);
            this.a.d.startAnimation(alphaAnimation);
            Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_up);
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (z && !this.e) {
                T1();
            }
        }
    }

    public final boolean S1(d25 d25Var, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d25Var, i2)) == null) {
            if (d25Var == null || i2 <= 0) {
                return false;
            }
            int i3 = d25Var.f;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 4) {
                        if (i3 == 5 && this.k < i2) {
                            m45 m45Var = new m45(getActivity());
                            m45Var.setMessageShowCenter(true);
                            if (this.k <= 0) {
                                m45Var.setTitle(R.string.obfuscated_res_0x7f0f09a7);
                            } else {
                                m45Var.setTitle(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f0c9d), Integer.valueOf(this.k)));
                            }
                            m45Var.setMessageId(R.string.obfuscated_res_0x7f0f08fc);
                            m45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new d(this, m45Var));
                            m45Var.setPositiveButton(R.string.obfuscated_res_0x7f0f08d8, new e(this, m45Var));
                            m45Var.create(getPageContext());
                            m45Var.show();
                            return false;
                        }
                    } else if (TbadkCoreApplication.getCurrentMemberType() >= 2) {
                        return true;
                    } else {
                        m45 m45Var2 = new m45(getActivity());
                        m45Var2.setButtonTextColor(R.color.CAM_X0305);
                        m45Var2.setTitle(R.string.obfuscated_res_0x7f0f0ef0);
                        m45Var2.setNegativeButton(R.string.obfuscated_res_0x7f0f03ce, new b(this, m45Var2));
                        m45Var2.setPositiveButton(R.string.open_now, new c(this, m45Var2));
                        m45Var2.create(getPageContext());
                        m45Var2.show();
                        return false;
                    }
                } else if (d25Var.k < i2) {
                    m45 m45Var3 = new m45(getActivity());
                    m45Var3.setMessageShowCenter(true);
                    m45Var3.setTitle(R.string.obfuscated_res_0x7f0f08e2);
                    m45Var3.setMessage(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f0b88), Integer.valueOf(d25Var.k)));
                    m45Var3.setNegativeButton(R.string.obfuscated_res_0x7f0f0b3e, new a(this, m45Var3));
                    m45Var3.create(getPageContext());
                    m45Var3.show();
                    return false;
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (currentTimeMillis < d25Var.h) {
                    new e95().c(getResources().getString(R.string.obfuscated_res_0x7f0f08e5));
                    return false;
                } else if (currentTimeMillis > d25Var.i) {
                    new e95().c(getResources().getString(R.string.obfuscated_res_0x7f0f08e4));
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
            R1();
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

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
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
        kw7 kw7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            if (this.q && (kw7Var = this.b) != null) {
                kw7Var.n(this.d);
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
            String string = getResources().getString(R.string.obfuscated_res_0x7f0f08ee);
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
            kw7 kw7Var = new kw7(getPageContext());
            this.b = kw7Var;
            kw7Var.s(this.x);
            this.b.r(this.w);
            SendGiftModel sendGiftModel = new SendGiftModel(getPageContext());
            this.c = sendGiftModel;
            sendGiftModel.P(this.y);
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
