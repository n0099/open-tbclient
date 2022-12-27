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
import com.baidu.tieba.t49;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes4.dex */
public class di8 {
    public static /* synthetic */ Interceptable $ic;
    public static di8 c;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public e98 b;

    /* loaded from: classes4.dex */
    public class a implements t49.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ di8 b;

        public a(di8 di8Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {di8Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = di8Var;
            this.a = tbPageContext;
        }

        @Override // com.baidu.tieba.t49.g
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
    public class b implements t49.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ di8 b;

        public b(di8 di8Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {di8Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = di8Var;
            this.a = tbPageContext;
        }

        @Override // com.baidu.tieba.t49.e
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
    public class c implements t49.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ di8 a;

        public c(di8 di8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {di8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = di8Var;
        }

        @Override // com.baidu.tieba.t49.d
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

    public di8() {
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

    public static di8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (c == null) {
                synchronized (di8.class) {
                    if (c == null) {
                        c = new di8();
                    }
                }
            }
            return c;
        }
        return (di8) invokeV.objValue;
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
            if (!version.equals(ry4.l().r("key_rate_version", ""))) {
                ry4.l().z("key_rate_version", version);
                ry4.l().y("key_rate_version_time", new Date().getTime());
            }
        }
    }

    public final void k(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, tbPageContext) != null) || tbPageContext == null || TbConfig.getVersionType() == 2) {
            return;
        }
        if (Long.valueOf(new Date().getTime()).longValue() - ry4.l().n("key_rate_version_time", 0L) < 86400000) {
            return;
        }
        String version = TbConfig.getVersion();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        ry4 l = ry4.l();
        if (l.i("key_rate_same_version_is_score" + version + currentAccount, false)) {
            return;
        }
        ry4 l2 = ry4.l();
        l2.v("key_rate_same_version_is_score" + version + currentAccount, true);
        n(tbPageContext);
    }

    public void n(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        t49 t49Var = new t49(tbPageContext.getContext());
        t49Var.x(tbPageContext.getContext().getString(R.string.is_tieba_pleased));
        t49Var.n(8);
        t49Var.r(0);
        int g = yi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070305);
        int g2 = yi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070246);
        int g3 = yi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f07028d);
        t49Var.w(R.dimen.obfuscated_res_0x7f0701f9);
        t49Var.v(0, g, 0, g3);
        t49Var.p(0, 0, 0, g2);
        t49Var.o(true);
        t49Var.u(new a(this, tbPageContext));
        e98 e98Var = new e98(tbPageContext.getContext(), t49Var.j());
        this.b = e98Var;
        e98Var.a(0.7f);
        ch.j(this.b, tbPageContext);
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_DIALOG_SHOW));
    }

    public void l(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        ry4 l = ry4.l();
        int m = l.m("key_rate_like_count" + currentAccount, 0) + 1;
        if (m < 3) {
            if (m == 1) {
                Long valueOf = Long.valueOf(new Date().getTime());
                ry4 l2 = ry4.l();
                l2.y("key_rate_first_like_time" + currentAccount, valueOf.longValue());
                ry4 l3 = ry4.l();
                l3.x("key_rate_like_count" + currentAccount, m);
                return;
            }
            ry4 l4 = ry4.l();
            l4.x("key_rate_like_count" + currentAccount, m);
            return;
        }
        ry4 l5 = ry4.l();
        if (Long.valueOf(new Date().getTime()).longValue() - l5.n("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
            ry4 l6 = ry4.l();
            l6.x("key_rate_like_count" + currentAccount, 0);
            k(tbPageContext);
            return;
        }
        ry4 l7 = ry4.l();
        l7.x("key_rate_like_count" + currentAccount, 0);
    }

    public void o(TbPageContext tbPageContext) {
        t49.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        t49 t49Var = new t49(tbPageContext.getContext());
        int i = this.a;
        if (i != 1 && i != 2) {
            t49Var.x(tbPageContext.getContext().getString(R.string.go_shop_give_me_comment));
            cVar = new t49.c(tbPageContext.getContext().getString(R.string.go_score), t49Var);
        } else {
            t49Var.x(tbPageContext.getContext().getString(R.string.help_my_improving_experience));
            cVar = new t49.c(tbPageContext.getContext().getString(R.string.go_feedback), t49Var);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        t49Var.q(this.a);
        t49Var.r(0);
        t49Var.n(0);
        t49Var.o(false);
        yi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0702be);
        int g = yi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070207);
        yi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0702d5);
        t49Var.v(0, yi.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070272), 0, 0);
        t49Var.p(0, g, 0, g);
        cVar.h(new b(this, tbPageContext));
        t49Var.t(new c(this));
        t49Var.s(arrayList);
        e98 e98Var = new e98(tbPageContext.getContext(), t49Var.j());
        this.b = e98Var;
        e98Var.a(0.7f);
        ch.j(this.b, tbPageContext);
        int i2 = this.a;
        if (i2 != 1 && i2 != 2) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_DIALOG_SHOW));
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_DIALOG_SHOW));
        }
    }
}
