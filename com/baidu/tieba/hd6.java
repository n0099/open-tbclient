package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.ko8;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class hd6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public View b;
    public BarImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TBSpecificationBtn h;
    public String i;
    public String j;
    public fu4 k;
    public LikeModel l;
    public ko8 m;
    public boolean n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hd6 a;

        public a(hd6 hd6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hd6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hd6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.j();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hd6 a;

        public b(hd6 hd6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hd6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hd6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = new StatisticItem("c13644");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.a.k.j());
                int i = 1;
                statisticItem.param("obj_locate", 1);
                if (this.a.k.s()) {
                    i = 2;
                }
                statisticItem.param(TiebaStatic.Params.OBJ_TO, i);
                TiebaStatic.log(statisticItem);
                if (this.a.k.s()) {
                    this.a.i();
                } else {
                    this.a.h();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends q9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hd6 a;

        public c(hd6 hd6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hd6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hd6Var;
        }

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.a.l.getErrorCode() == 22) {
                    xi.P(this.a.a.getPageActivity(), this.a.a.getString(R.string.obfuscated_res_0x7f0f084e));
                } else if (obj == null) {
                } else {
                    if (this.a.l.getErrorCode() != 0) {
                        xi.P(this.a.a.getPageActivity(), this.a.l.getErrorString());
                    } else {
                        this.a.n(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ko8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hd6 a;

        @Override // com.baidu.tieba.ko8.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            }
        }

        public d(hd6 hd6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hd6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hd6Var;
        }

        @Override // com.baidu.tieba.ko8.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.a.n(false);
                xi.P(this.a.a.getPageActivity(), this.a.a.getString(R.string.obfuscated_res_0x7f0f14f3));
            }
        }
    }

    public hd6(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.i = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02b1);
        this.j = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1427);
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d078a, (ViewGroup) null);
        this.b = inflate;
        this.c = (BarImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090343);
        this.d = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090350);
        this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0907ae);
        this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090a4f);
        this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092224);
        this.h = (TBSpecificationBtn) this.b.findViewById(R.id.obfuscated_res_0x7f090a9e);
        this.b.setOnClickListener(new a(this));
        this.h.setOnClickListener(new b(this));
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.n = z;
        }
    }

    public void g(fu4 fu4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, fu4Var) != null) || fu4Var == null) {
            return;
        }
        this.k = fu4Var;
        this.c.setShowOval(true);
        this.c.setShowOuterBorder(false);
        this.c.setShowInnerBorder(true);
        this.c.setStrokeWith(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.c.setStrokeColorResId(R.color.CAM_X0401);
        this.c.K(fu4Var.h(), 10, false);
        String l = fu4Var.l();
        if (wi.isEmpty(l)) {
            l = "";
        }
        this.d.setText(l);
        this.f.setText(this.i + " " + StringHelper.numFormatOverWanWithoutDecimals(fu4Var.n()));
        this.g.setText(this.j + " " + StringHelper.numFormatOverWanWithoutDecimals((long) fu4Var.r()));
        String recomReason = fu4Var.getRecomReason();
        if (wi.isEmpty(recomReason)) {
            if (this.e.getVisibility() != 8) {
                this.e.setVisibility(8);
                if (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.d.getLayoutParams()).topMargin = xi.g(this.a.getPageActivity(), R.dimen.tbds47);
                    this.d.requestLayout();
                }
            }
        } else {
            if (this.e.getVisibility() != 0) {
                this.e.setVisibility(0);
                if (this.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.d.getLayoutParams()).topMargin = xi.g(this.a.getPageActivity(), R.dimen.tbds24);
                    this.d.requestLayout();
                }
            }
            this.e.setText(recomReason);
        }
        n(this.k.s());
        l();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!xi.F()) {
                UtilHelper.showToast(this.a.getPageActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0c7f));
                return;
            }
            fu4 fu4Var = this.k;
            if (fu4Var != null && !StringUtils.isNull(fu4Var.l()) && this.k.j() > 0) {
                if (!ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                    return;
                }
                if (this.l == null) {
                    this.l = new LikeModel(this.a);
                }
                this.l.setLoadDataCallBack(new c(this));
                if (wi.isForumName(this.k.l())) {
                    this.l.M();
                    this.l.Q(this.k.l(), String.valueOf(this.k.j()));
                }
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!xi.F()) {
                UtilHelper.showToast(this.a.getPageActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0c7f));
                return;
            }
            fu4 fu4Var = this.k;
            if (fu4Var != null && !StringUtils.isNull(fu4Var.l()) && this.k.j() > 0) {
                if (!ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                    return;
                }
                if (this.m == null) {
                    this.m = new ko8();
                }
                this.m.b(new d(this));
                this.m.c(this.k.l(), this.k.j());
            }
        }
    }

    public final void j() {
        fu4 fu4Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (fu4Var = this.k) == null) {
            return;
        }
        String l = fu4Var.l();
        if (!wi.isForumName(l)) {
            return;
        }
        this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageActivity()).createNormalCfg(l, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
        StatisticItem statisticItem = new StatisticItem("c13643");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("fid", this.k.j());
        int i = 1;
        statisticItem.param("obj_locate", 1);
        if (this.n) {
            i = 4;
        }
        statisticItem.param("obj_type", i);
        TiebaStatic.log(statisticItem);
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            if (!z) {
                jz4 jz4Var = new jz4();
                jz4Var.r(R.color.CAM_X0302);
                this.h.setConfig(jz4Var);
                this.h.setText(this.i);
            } else {
                jz4 jz4Var2 = new jz4();
                jz4Var2.t(R.color.CAM_X0109);
                this.h.setConfig(jz4Var2);
                this.h.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f100a));
            }
            this.k.w(z);
        }
    }
}
