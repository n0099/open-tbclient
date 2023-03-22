package com.baidu.tieba;

import android.content.Intent;
import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.so9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes4.dex */
public class i09 {
    public static /* synthetic */ Interceptable $ic;
    public static i09 c;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public hr8 b;

    /* loaded from: classes4.dex */
    public class a implements so9.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ i09 b;

        public a(i09 i09Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i09Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i09Var;
            this.a = tbPageContext;
        }

        @Override // com.baidu.tieba.so9.g
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.b.b == null) {
                return;
            }
            this.b.b.dismiss();
            this.b.b = null;
            this.b.a = i;
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_CLICK_STAR).param("obj_type", this.b.a));
            this.b.o(this.a);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements so9.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ i09 b;

        public b(i09 i09Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i09Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i09Var;
            this.a = tbPageContext;
        }

        @Override // com.baidu.tieba.so9.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.b == null) {
                return;
            }
            this.b.b.dismiss();
            this.b.b = null;
            if (this.b.a == 1 || this.b.a == 2) {
                this.b.h(this.a);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_CLICK_FEEDBACK));
                return;
            }
            this.b.i(this.a);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_CLICK_SCORE));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements so9.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i09 a;

        public c(i09 i09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i09Var;
        }

        @Override // com.baidu.tieba.so9.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.b == null) {
                return;
            }
            this.a.b.dismiss();
            this.a.b = null;
            if (this.a.a != 1 && this.a.a != 2) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_CLICK_CANCEL));
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_CLICK_CANCEL));
            }
        }
    }

    public i09() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
    }

    public static i09 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (c == null) {
                synchronized (i09.class) {
                    if (c == null) {
                        c = new i09();
                    }
                }
            }
            return c;
        }
        return (i09) invokeV.objValue;
    }

    public final void h(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink((TbPageContext<?>) tbPageContext, new String[]{TbConfig.getFeedBackUrl()}, true);
    }

    public void m(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        k(tbPageContext);
    }

    public final void i(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(BaseConstants.MARKET_PREFIX + TbadkCoreApplication.getInst().getPackageName()));
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                tbPageContext.getContext().startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String version = TbConfig.getVersion();
            if (!version.equals(m35.m().s("key_rate_version", ""))) {
                m35.m().B("key_rate_version", version);
                m35.m().A("key_rate_version_time", new Date().getTime());
            }
        }
    }

    public final void k(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, tbPageContext) != null) || tbPageContext == null || TbConfig.getVersionType() == 2) {
            return;
        }
        if (Long.valueOf(new Date().getTime()).longValue() - m35.m().o("key_rate_version_time", 0L) < 86400000) {
            return;
        }
        String version = TbConfig.getVersion();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        m35 m = m35.m();
        if (m.i("key_rate_same_version_is_score" + version + currentAccount, false)) {
            return;
        }
        m35 m2 = m35.m();
        m2.w("key_rate_same_version_is_score" + version + currentAccount, true);
        n(tbPageContext);
    }

    public void n(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        so9 so9Var = new so9(tbPageContext.getContext());
        so9Var.x(tbPageContext.getContext().getString(R.string.is_tieba_pleased));
        so9Var.n(8);
        so9Var.r(0);
        int g = hi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070306);
        int g2 = hi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070247);
        int g3 = hi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f07028e);
        so9Var.w(R.dimen.obfuscated_res_0x7f0701f9);
        so9Var.v(0, g, 0, g3);
        so9Var.p(0, 0, 0, g2);
        so9Var.o(true);
        so9Var.u(new a(this, tbPageContext));
        hr8 hr8Var = new hr8(tbPageContext.getContext(), so9Var.j());
        this.b = hr8Var;
        hr8Var.a(0.7f);
        lg.j(this.b, tbPageContext);
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_DIALOG_SHOW));
    }

    public void l(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        m35 m = m35.m();
        int n = m.n("key_rate_like_count" + currentAccount, 0) + 1;
        if (n < 3) {
            if (n == 1) {
                Long valueOf = Long.valueOf(new Date().getTime());
                m35 m2 = m35.m();
                m2.A("key_rate_first_like_time" + currentAccount, valueOf.longValue());
                m35 m3 = m35.m();
                m3.z("key_rate_like_count" + currentAccount, n);
                return;
            }
            m35 m4 = m35.m();
            m4.z("key_rate_like_count" + currentAccount, n);
            return;
        }
        m35 m5 = m35.m();
        if (Long.valueOf(new Date().getTime()).longValue() - m5.o("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
            m35 m6 = m35.m();
            m6.z("key_rate_like_count" + currentAccount, 0);
            k(tbPageContext);
            return;
        }
        m35 m7 = m35.m();
        m7.z("key_rate_like_count" + currentAccount, 0);
    }

    public void o(TbPageContext tbPageContext) {
        so9.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        so9 so9Var = new so9(tbPageContext.getContext());
        int i = this.a;
        if (i != 1 && i != 2) {
            so9Var.x(tbPageContext.getContext().getString(R.string.go_shop_give_me_comment));
            cVar = new so9.c(tbPageContext.getContext().getString(R.string.go_score), so9Var);
        } else {
            so9Var.x(tbPageContext.getContext().getString(R.string.help_my_improving_experience));
            cVar = new so9.c(tbPageContext.getContext().getString(R.string.go_feedback), so9Var);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        so9Var.q(this.a);
        so9Var.r(0);
        so9Var.n(0);
        so9Var.o(false);
        hi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0702bf);
        int g = hi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070207);
        hi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0702d6);
        so9Var.v(0, hi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070273), 0, 0);
        so9Var.p(0, g, 0, g);
        cVar.h(new b(this, tbPageContext));
        so9Var.t(new c(this));
        so9Var.s(arrayList);
        hr8 hr8Var = new hr8(tbPageContext.getContext(), so9Var.j());
        this.b = hr8Var;
        hr8Var.a(0.7f);
        lg.j(this.b, tbPageContext);
        int i2 = this.a;
        if (i2 != 1 && i2 != 2) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_DIALOG_SHOW));
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_DIALOG_SHOW));
        }
    }
}
