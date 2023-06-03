package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.jz;
import com.baidu.tieba.ux;
import com.baidu.tieba.uz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i08 extends in<vo6, AutoVideoCardViewHolder<vo6>> implements d56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public e18 c;
    public String d;
    public bo e;
    public rz f;
    public eo6<vo6> g;

    /* loaded from: classes6.dex */
    public class a extends eo6<vo6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i08 b;

        public a(i08 i08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.eo6
        /* renamed from: d */
        public void a(View view2, vo6 vo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, vo6Var) == null) {
                xn6.b().d(true);
                b56.c().h("page_recommend", "show_");
                if (this.b.c != null && vo6Var != null && vo6Var.getThreadData() != null && !StringUtils.isNull(vo6Var.getThreadData().getTid())) {
                    if (vo6Var.getThreadData().middle_page_num > 0) {
                        TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(vo6Var.J(vo6Var.getThreadData())));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !hz7.b(tg.g(vo6Var.getThreadData().getTid(), 0L))) {
                        hz7.a(tg.g(vo6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(tg.g(vo6Var.getThreadData().getTid(), 0L), vo6Var.w(), vo6Var.k(), vo6Var.i(), vo6Var.c(), tg.e((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, vo6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.A(view2, vo6Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ux.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rz a;
        public final /* synthetic */ i08 b;

        public b(i08 i08Var, rz rzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i08Var, rzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i08Var;
            this.a = rzVar;
        }

        @Override // com.baidu.tieba.ux.a
        public void a(f15 f15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, f15Var) != null) || f15Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (f15Var instanceof vo6) {
                f15Var.objType = 5;
                ThreadCardUtils.jumpToPB(f15Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(f15Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements fo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i08 a;

        public c(i08 i08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i08Var;
        }

        @Override // com.baidu.tieba.fo
        public void b(View view2, vn vnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, vnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (vnVar instanceof vo6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                vo6 vo6Var = (vo6) vnVar;
                vo6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), vo6Var);
                }
                ThreadCardUtils.jumpToPB((f15) vo6Var, view2.getContext(), 2, false, yx.a((bo) viewGroup, view2, i));
                autoVideoCardViewHolder.a().p(new uz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i08(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this);
        this.b = tbPageContext;
        B();
    }

    public void E(e18 e18Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, e18Var) == null) {
            this.c = e18Var;
        }
    }

    public void F(bo boVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, boVar) == null) {
            this.e = boVar;
        }
    }

    @Override // com.baidu.tieba.d56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.d = str;
        }
    }

    public final void A(View view2, vo6 vo6Var) {
        rz rzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, vo6Var) == null) && (rzVar = this.f) != null && rzVar.t() != null && this.f.t().getMainView() != null) {
            if (view2.getId() == this.f.t().getMainView().getId()) {
                CardLinkageManager.INSTANCE.cancelHighLight(this.e, vo6Var);
                j18.d(vo6Var.a, this.a, vo6Var.i(), 4);
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(vo6Var.L()));
                j18.c(vo6Var.a, vo6Var.k(), vo6Var.i(), 2);
            } else if (view2.getId() == R.id.thread_card_root) {
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(vo6Var.J(vo6Var.a)));
                j18.c(vo6Var.a, vo6Var.k(), vo6Var.i(), 1);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            vo6.V = "c10708";
            vo6.W = "c10735";
            vo6.X = "c10709";
            vo6.Y = "c10734";
            vo6.Z = "c11929";
            vo6.a0 = "c11928";
            vo6.b0 = "c10756";
        }
    }

    public void onPause() {
        rz rzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (rzVar = this.f) != null) {
            rzVar.y();
        }
    }

    public void onResume() {
        rz rzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (rzVar = this.f) != null) {
            rzVar.z();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: C */
    public AutoVideoCardViewHolder<vo6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            jz.b bVar = new jz.b(this.b.getPageActivity(), false);
            p18 p18Var = new p18(this.b.getPageActivity());
            p18Var.A(new b(this, p18Var));
            this.f = p18Var;
            p18Var.C(this.a);
            this.f.setFrom("index");
            this.f.setStageType("2001");
            bVar.n(this.f);
            jz k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<vo6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.q(this.g);
            k.s(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: D */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, vo6 vo6Var, AutoVideoCardViewHolder<vo6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, vo6Var, autoVideoCardViewHolder})) == null) {
            if (vo6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            vo6Var.B(vo6Var.position + 1);
            vo6Var.a.statFloor = vo6Var.i();
            autoVideoCardViewHolder.a().r(i);
            vo6Var.f1182T = 0;
            xn6.b().a(vo6Var.s());
            autoVideoCardViewHolder.x(z(vo6Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(vo6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.g);
            j18.p(vo6Var.a, this.a, vo6Var.i());
            j18.o(vo6Var.a, vo6Var.k(), vo6Var.i());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final zi9 z(vo6 vo6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, vo6Var)) == null) {
            if (vo6Var != null) {
                zi9 zi9Var = new zi9();
                zi9Var.a = "1";
                zi9Var.c = vo6Var.g;
                if (vo6Var.getThreadData() != null) {
                    zi9Var.d = String.valueOf(vo6Var.getThreadData().getFid());
                    zi9Var.v = vo6Var.getThreadData().getNid();
                    if (vo6Var.getThreadData().getThreadVideoInfo() != null) {
                        zi9Var.m = vo6Var.getThreadData().getThreadVideoInfo().video_md5;
                        zi9Var.p = String.valueOf(vo6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                zi9Var.k = vo6Var.e();
                zi9Var.f = vo6Var.k();
                zi9Var.l = vo6Var.c();
                zi9Var.h = vo6Var.w();
                zi9Var.e = TbadkCoreApplication.getCurrentAccount();
                zi9Var.q = String.valueOf(vo6Var.i());
                if (vo6Var.getThreadData() != null && vo6Var.getThreadData().getBaijiahaoData() != null) {
                    zi9Var.t = vo6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    zi9Var.u = vo6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return zi9Var;
                }
                return zi9Var;
            }
            return null;
        }
        return (zi9) invokeL.objValue;
    }
}
