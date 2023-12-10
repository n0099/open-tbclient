package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.util.BdToastHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.forumSquare.ForumSquareActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.LikeReturnData;
import com.baidu.tieba.yva;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class er7 extends nl6<br7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public BarImageView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TBSpecificationBtn o;
    public String p;
    public String q;
    public br7 r;
    public LikeModel s;
    public yva t;
    public boolean u;

    @Override // com.baidu.tieba.nl6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.obfuscated_res_0x7f0d0922 : invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class a extends w4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ er7 a;

        public a(er7 er7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {er7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = er7Var;
        }

        @Override // com.baidu.tieba.w4
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.u = false;
                if (this.a.s.getErrorCode() == 22) {
                    BdUtilHelper.showToast(this.a.b.getPageActivity(), this.a.b.getString(R.string.had_liked_forum));
                } else if (!(obj instanceof LikeReturnData)) {
                } else {
                    if (this.a.s.getErrorCode() != 0) {
                        BdUtilHelper.showToast(this.a.b.getPageActivity(), this.a.s.getErrorString());
                        return;
                    }
                    this.a.C(true);
                    if (vh5.b.a().a("jump_to_frs")) {
                        BdToastData toastData = ((LikeReturnData) obj).getToastData();
                        if (toastData == null || toastData.toJson() == null) {
                            this.a.A(null);
                        } else {
                            this.a.A(toastData.toJson().toString());
                        }
                    } else if (!BdToastHelper.canShowToast(((LikeReturnData) obj).getToastData())) {
                        BdUtilHelper.showToastByTextCenter(TbadkCoreApplication.getInst(), R.string.push_like_tip_msg);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements yva.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ er7 a;

        public b(er7 er7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {er7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = er7Var;
        }

        @Override // com.baidu.tieba.yva.a
        public void a(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
                this.a.u = false;
            }
        }

        @Override // com.baidu.tieba.yva.a
        public void b(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
                this.a.u = false;
                this.a.C(false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public er7(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = false;
        this.p = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.q = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View i3 = i();
        this.i = i3;
        this.j = (BarImageView) i3.findViewById(R.id.obfuscated_res_0x7f090379);
        this.k = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f090387);
        this.l = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f0908cd);
        this.m = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f0917ff);
        this.n = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f091e06);
        this.o = (TBSpecificationBtn) i3.findViewById(R.id.obfuscated_res_0x7f090c4e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nl6
    /* renamed from: B */
    public void j(br7 br7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, br7Var) != null) || br7Var == null) {
            return;
        }
        this.r = br7Var;
        this.j.setShowOval(true);
        this.j.setShowOuterBorder(false);
        this.j.setShowInnerBorder(true);
        this.j.setStrokeWith(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.j.setStrokeColorResId(R.color.CAM_X0401);
        this.j.startLoad(br7Var.c(), 10, false);
        String e = br7Var.e();
        if (rd.isEmpty(e)) {
            e = "";
        }
        this.k.setText(e);
        this.m.setText(this.p + " " + StringHelper.numberUniformFormatExtra(br7Var.f()));
        this.n.setText(this.q + " " + StringHelper.numberUniformFormatExtra((long) br7Var.g()));
        D(br7Var.getRecomReason());
        C(this.r.h());
        this.i.setOnClickListener(this);
        this.o.setOnClickListener(this);
        k(this.b, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        StatisticItem statisticItem;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, view2) != null) || this.r == null) {
            return;
        }
        if (this.i == view2) {
            A(null);
            mm6<T> mm6Var = this.e;
            if (mm6Var != 0) {
                mm6Var.a(view2, this.r);
            }
        } else if (this.o == view2) {
            if (this.b.getPageActivity() instanceof ForumSquareActivity) {
                String f = ((ForumSquareActivity) this.b.getPageActivity()).H0().f();
                if (!"推荐".equals(f)) {
                    statisticItem = new StatisticItem("c13653");
                    statisticItem.param("resource_id", f);
                } else {
                    statisticItem = new StatisticItem("c13644");
                    statisticItem.param("obj_locate", 3);
                }
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.r.a);
                if (this.r.h()) {
                    i = 2;
                } else {
                    i = 1;
                }
                statisticItem.param(TiebaStatic.Params.OBJ_TO, i);
                TiebaStatic.log(statisticItem);
            }
            if (this.r.h()) {
                z();
            } else {
                y();
            }
        }
    }

    public final void A(String str) {
        br7 br7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (br7Var = this.r) == null) {
            return;
        }
        String e = br7Var.e();
        if (!rd.isForumName(e)) {
            return;
        }
        FrsActivityConfig callFrom = new FrsActivityConfig(this.b.getPageActivity()).createNormalCfg(e, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5);
        callFrom.setToastData(str);
        this.b.sendMessage(new CustomMessage(2003000, callFrom));
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (!z) {
                e65 e65Var = new e65();
                e65Var.u(R.color.CAM_X0302);
                this.o.setConfig(e65Var);
                this.o.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
            } else {
                e65 e65Var2 = new e65();
                e65Var2.v(R.color.CAM_X0109);
                this.o.setConfig(e65Var2);
                this.o.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
            }
            this.r.l(z);
        }
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (rd.isEmpty(str)) {
                if (this.l.getVisibility() != 8) {
                    this.l.setVisibility(8);
                    if (this.k.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) this.k.getLayoutParams()).topMargin = BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.tbds47);
                        this.k.requestLayout();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.l.getVisibility() != 0) {
                this.l.setVisibility(0);
                if (this.k.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.k.getLayoutParams()).topMargin = BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.tbds24);
                    this.k.requestLayout();
                }
            }
            this.l.setText(str);
        }
    }

    @Override // com.baidu.tieba.nl6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i) == null) {
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
            this.o.k();
            SkinManager.setBackgroundColor(i(), R.color.CAM_X0205);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || this.u) {
            return;
        }
        if (!BdUtilHelper.isNetOk()) {
            UtilHelper.showToast(this.b.getPageActivity(), this.b.getString(R.string.obfuscated_res_0x7f0f0e70));
            return;
        }
        br7 br7Var = this.r;
        if (br7Var == null || StringUtils.isNull(br7Var.e()) || this.r.d() <= 0 || !ViewHelper.checkUpIsLogin(this.b.getPageActivity())) {
            return;
        }
        if (this.s == null) {
            LikeModel likeModel = new LikeModel(this.b);
            this.s = likeModel;
            likeModel.setLoadDataCallBack(new a(this));
        }
        if (rd.isForumName(this.r.e())) {
            this.u = true;
            this.s.c0();
            if (vh5.b.a().a("jump_to_frs")) {
                this.s.setNeedShowSeverToast(false);
            }
            this.s.g0(this.r.e(), String.valueOf(this.r.d()));
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || this.u) {
            return;
        }
        if (!BdUtilHelper.isNetOk()) {
            UtilHelper.showToast(this.b.getPageActivity(), this.b.getString(R.string.obfuscated_res_0x7f0f0e70));
            return;
        }
        br7 br7Var = this.r;
        if (br7Var == null || StringUtils.isNull(br7Var.e()) || this.r.d() <= 0 || !ViewHelper.checkUpIsLogin(this.b.getPageActivity())) {
            return;
        }
        if (this.t == null) {
            yva yvaVar = new yva();
            this.t = yvaVar;
            yvaVar.b(new b(this));
        }
        this.u = true;
        this.t.c(this.r.e(), this.r.d());
    }
}
