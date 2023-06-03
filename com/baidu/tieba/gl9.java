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
import com.baidu.tieba.fba;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes5.dex */
public class gl9 {
    public static /* synthetic */ Interceptable $ic;
    public static gl9 c;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public bc9 b;

    /* loaded from: classes5.dex */
    public class a implements fba.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ gl9 b;

        public a(gl9 gl9Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gl9Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gl9Var;
            this.a = tbPageContext;
        }

        @Override // com.baidu.tieba.fba.g
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
    public class b implements fba.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ gl9 b;

        public b(gl9 gl9Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gl9Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gl9Var;
            this.a = tbPageContext;
        }

        @Override // com.baidu.tieba.fba.e
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
    public class c implements fba.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gl9 a;

        public c(gl9 gl9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gl9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gl9Var;
        }

        @Override // com.baidu.tieba.fba.d
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

    public gl9() {
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

    public static gl9 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (c == null) {
                synchronized (gl9.class) {
                    if (c == null) {
                        c = new gl9();
                    }
                }
            }
            return c;
        }
        return (gl9) invokeV.objValue;
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
            if (!version.equals(l95.m().s("key_rate_version", ""))) {
                l95.m().B("key_rate_version", version);
                l95.m().A("key_rate_version_time", new Date().getTime());
            }
        }
    }

    public final void k(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, tbPageContext) != null) || tbPageContext == null || TbConfig.getVersionType() == 2) {
            return;
        }
        if (Long.valueOf(new Date().getTime()).longValue() - l95.m().o("key_rate_version_time", 0L) < 86400000) {
            return;
        }
        String version = TbConfig.getVersion();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        l95 m = l95.m();
        if (m.i("key_rate_same_version_is_score" + version + currentAccount, false)) {
            return;
        }
        l95 m2 = l95.m();
        m2.w("key_rate_same_version_is_score" + version + currentAccount, true);
        n(tbPageContext);
    }

    public void n(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        fba fbaVar = new fba(tbPageContext.getContext());
        fbaVar.x(tbPageContext.getContext().getString(R.string.is_tieba_pleased));
        fbaVar.n(8);
        fbaVar.r(0);
        int g = vi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070419);
        int g2 = vi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070368);
        int g3 = vi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0703a5);
        fbaVar.w(R.dimen.obfuscated_res_0x7f0701f9);
        fbaVar.v(0, g, 0, g3);
        fbaVar.p(0, 0, 0, g2);
        fbaVar.o(true);
        fbaVar.u(new a(this, tbPageContext));
        bc9 bc9Var = new bc9(tbPageContext.getContext(), fbaVar.j());
        this.b = bc9Var;
        bc9Var.a(0.7f);
        yg.j(this.b, tbPageContext);
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_DIALOG_SHOW));
    }

    public void l(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        l95 m = l95.m();
        int n = m.n("key_rate_like_count" + currentAccount, 0) + 1;
        if (n < 3) {
            if (n == 1) {
                Long valueOf = Long.valueOf(new Date().getTime());
                l95 m2 = l95.m();
                m2.A("key_rate_first_like_time" + currentAccount, valueOf.longValue());
                l95 m3 = l95.m();
                m3.z("key_rate_like_count" + currentAccount, n);
                return;
            }
            l95 m4 = l95.m();
            m4.z("key_rate_like_count" + currentAccount, n);
            return;
        }
        l95 m5 = l95.m();
        if (Long.valueOf(new Date().getTime()).longValue() - m5.o("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
            l95 m6 = l95.m();
            m6.z("key_rate_like_count" + currentAccount, 0);
            k(tbPageContext);
            return;
        }
        l95 m7 = l95.m();
        m7.z("key_rate_like_count" + currentAccount, 0);
    }

    public void o(TbPageContext tbPageContext) {
        fba.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        fba fbaVar = new fba(tbPageContext.getContext());
        int i = this.a;
        if (i != 1 && i != 2) {
            fbaVar.x(tbPageContext.getContext().getString(R.string.go_shop_give_me_comment));
            cVar = new fba.c(tbPageContext.getContext().getString(R.string.go_score), fbaVar);
        } else {
            fbaVar.x(tbPageContext.getContext().getString(R.string.help_my_improving_experience));
            cVar = new fba.c(tbPageContext.getContext().getString(R.string.go_feedback), fbaVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        fbaVar.q(this.a);
        fbaVar.r(0);
        fbaVar.n(0);
        fbaVar.o(false);
        vi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0703d2);
        int g = vi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070207);
        vi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0703e9);
        fbaVar.v(0, vi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f07038e), 0, 0);
        fbaVar.p(0, g, 0, g);
        cVar.h(new b(this, tbPageContext));
        fbaVar.t(new c(this));
        fbaVar.s(arrayList);
        bc9 bc9Var = new bc9(tbPageContext.getContext(), fbaVar.j());
        this.b = bc9Var;
        bc9Var.a(0.7f);
        yg.j(this.b, tbPageContext);
        int i2 = this.a;
        if (i2 != 1 && i2 != 2) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_DIALOG_SHOW));
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_DIALOG_SHOW));
        }
    }
}
