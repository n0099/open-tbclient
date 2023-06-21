package com.baidu.tieba;

import android.content.Intent;
import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.bda;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes5.dex */
public class dn9 {
    public static /* synthetic */ Interceptable $ic;
    public static dn9 c;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public id9 b;

    /* loaded from: classes5.dex */
    public class a implements bda.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ dn9 b;

        public a(dn9 dn9Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dn9Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dn9Var;
            this.a = tbPageContext;
        }

        @Override // com.baidu.tieba.bda.g
        public void onClick(int i) {
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

    /* loaded from: classes5.dex */
    public class b implements bda.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ dn9 b;

        public b(dn9 dn9Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dn9Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dn9Var;
            this.a = tbPageContext;
        }

        @Override // com.baidu.tieba.bda.e
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

    /* loaded from: classes5.dex */
    public class c implements bda.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dn9 a;

        public c(dn9 dn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dn9Var;
        }

        @Override // com.baidu.tieba.bda.d
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

    public dn9() {
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

    public static dn9 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (c == null) {
                synchronized (dn9.class) {
                    if (c == null) {
                        c = new dn9();
                    }
                }
            }
            return c;
        }
        return (dn9) invokeV.objValue;
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
                Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(BaseConstants.MARKET_PREFIX + TbadkCoreApplication.getInst().getPackageName()));
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
            if (!version.equals(o95.p().w("key_rate_version", ""))) {
                o95.p().J("key_rate_version", version);
                o95.p().H("key_rate_version_time", new Date().getTime());
            }
        }
    }

    public final void k(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, tbPageContext) != null) || tbPageContext == null || TbConfig.getVersionType() == 2) {
            return;
        }
        if (Long.valueOf(new Date().getTime()).longValue() - o95.p().r("key_rate_version_time", 0L) < 86400000) {
            return;
        }
        String version = TbConfig.getVersion();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        o95 p = o95.p();
        if (p.l("key_rate_same_version_is_score" + version + currentAccount, false)) {
            return;
        }
        o95 p2 = o95.p();
        p2.A("key_rate_same_version_is_score" + version + currentAccount, true);
        n(tbPageContext);
    }

    public void n(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        bda bdaVar = new bda(tbPageContext.getContext());
        bdaVar.x(tbPageContext.getContext().getString(R.string.is_tieba_pleased));
        bdaVar.n(8);
        bdaVar.r(0);
        int g = wi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070419);
        int g2 = wi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070368);
        int g3 = wi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0703a5);
        bdaVar.w(R.dimen.obfuscated_res_0x7f0701f9);
        bdaVar.v(0, g, 0, g3);
        bdaVar.p(0, 0, 0, g2);
        bdaVar.o(true);
        bdaVar.u(new a(this, tbPageContext));
        id9 id9Var = new id9(tbPageContext.getContext(), bdaVar.j());
        this.b = id9Var;
        id9Var.a(0.7f);
        zg.j(this.b, tbPageContext);
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_DIALOG_SHOW));
    }

    public void l(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        o95 p = o95.p();
        int q = p.q("key_rate_like_count" + currentAccount, 0) + 1;
        if (q < 3) {
            if (q == 1) {
                Long valueOf = Long.valueOf(new Date().getTime());
                o95 p2 = o95.p();
                p2.H("key_rate_first_like_time" + currentAccount, valueOf.longValue());
                o95 p3 = o95.p();
                p3.F("key_rate_like_count" + currentAccount, q);
                return;
            }
            o95 p4 = o95.p();
            p4.F("key_rate_like_count" + currentAccount, q);
            return;
        }
        o95 p5 = o95.p();
        if (Long.valueOf(new Date().getTime()).longValue() - p5.r("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
            o95 p6 = o95.p();
            p6.F("key_rate_like_count" + currentAccount, 0);
            k(tbPageContext);
            return;
        }
        o95 p7 = o95.p();
        p7.F("key_rate_like_count" + currentAccount, 0);
    }

    public void o(TbPageContext tbPageContext) {
        bda.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        bda bdaVar = new bda(tbPageContext.getContext());
        int i = this.a;
        if (i != 1 && i != 2) {
            bdaVar.x(tbPageContext.getContext().getString(R.string.go_shop_give_me_comment));
            cVar = new bda.c(tbPageContext.getContext().getString(R.string.go_score), bdaVar);
        } else {
            bdaVar.x(tbPageContext.getContext().getString(R.string.help_my_improving_experience));
            cVar = new bda.c(tbPageContext.getContext().getString(R.string.go_feedback), bdaVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        bdaVar.q(this.a);
        bdaVar.r(0);
        bdaVar.n(0);
        bdaVar.o(false);
        wi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0703d2);
        int g = wi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070207);
        wi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0703e9);
        bdaVar.v(0, wi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f07038e), 0, 0);
        bdaVar.p(0, g, 0, g);
        cVar.h(new b(this, tbPageContext));
        bdaVar.t(new c(this));
        bdaVar.s(arrayList);
        id9 id9Var = new id9(tbPageContext.getContext(), bdaVar.j());
        this.b = id9Var;
        id9Var.a(0.7f);
        zg.j(this.b, tbPageContext);
        int i2 = this.a;
        if (i2 != 1 && i2 != 2) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_DIALOG_SHOW));
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_DIALOG_SHOW));
        }
    }
}
