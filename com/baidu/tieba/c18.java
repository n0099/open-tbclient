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
import com.baidu.tieba.lz;
import com.baidu.tieba.wx;
import com.baidu.tieba.wz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c18 extends kn<hp6, AutoVideoCardViewHolder<hp6>> implements p56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public y18 c;
    public String d;
    public Cdo e;
    public tz f;
    public qo6<hp6> g;

    /* loaded from: classes5.dex */
    public class a extends qo6<hp6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c18 b;

        public a(c18 c18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qo6
        /* renamed from: d */
        public void a(View view2, hp6 hp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, hp6Var) == null) {
                jo6.b().d(true);
                n56.c().h("page_recommend", "show_");
                if (this.b.c != null && hp6Var != null && hp6Var.getThreadData() != null && !StringUtils.isNull(hp6Var.getThreadData().getTid())) {
                    if (hp6Var.getThreadData().middle_page_num > 0) {
                        TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(hp6Var.J(hp6Var.getThreadData())));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !b08.b(vg.g(hp6Var.getThreadData().getTid(), 0L))) {
                        b08.a(vg.g(hp6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(vg.g(hp6Var.getThreadData().getTid(), 0L), hp6Var.w(), hp6Var.k(), hp6Var.i(), hp6Var.c(), vg.e((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, hp6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.A(view2, hp6Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements wx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tz a;
        public final /* synthetic */ c18 b;

        public b(c18 c18Var, tz tzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c18Var, tzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c18Var;
            this.a = tzVar;
        }

        @Override // com.baidu.tieba.wx.a
        public void a(l15 l15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, l15Var) != null) || l15Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (l15Var instanceof hp6) {
                l15Var.objType = 5;
                ThreadCardUtils.jumpToPB(l15Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(l15Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c18 a;

        public c(c18 c18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c18Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof hp6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                hp6 hp6Var = (hp6) xnVar;
                hp6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), hp6Var);
                }
                ThreadCardUtils.jumpToPB((l15) hp6Var, view2.getContext(), 2, false, ay.a((Cdo) viewGroup, view2, i));
                autoVideoCardViewHolder.a().p(new wz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c18(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void E(y18 y18Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, y18Var) == null) {
            this.c = y18Var;
        }
    }

    public void F(Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cdo) == null) {
            this.e = cdo;
        }
    }

    @Override // com.baidu.tieba.p56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.d = str;
        }
    }

    public final void A(View view2, hp6 hp6Var) {
        tz tzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, hp6Var) == null) && (tzVar = this.f) != null && tzVar.t() != null && this.f.t().getMainView() != null) {
            if (view2.getId() == this.f.t().getMainView().getId()) {
                CardLinkageManager.INSTANCE.cancelHighLight(this.e, hp6Var);
                d28.d(hp6Var.a, this.a, hp6Var.i(), 4);
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(hp6Var.L()));
                d28.c(hp6Var.a, hp6Var.k(), hp6Var.i(), 2);
            } else if (view2.getId() == R.id.thread_card_root) {
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(hp6Var.J(hp6Var.a)));
                d28.c(hp6Var.a, hp6Var.k(), hp6Var.i(), 1);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            hp6.V = "c10708";
            hp6.W = "c10735";
            hp6.X = "c10709";
            hp6.Y = "c10734";
            hp6.Z = "c11929";
            hp6.a0 = "c11928";
            hp6.b0 = "c10756";
        }
    }

    public void onPause() {
        tz tzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (tzVar = this.f) != null) {
            tzVar.y();
        }
    }

    public void onResume() {
        tz tzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (tzVar = this.f) != null) {
            tzVar.z();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: C */
    public AutoVideoCardViewHolder<hp6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            lz.b bVar = new lz.b(this.b.getPageActivity(), false);
            j28 j28Var = new j28(this.b.getPageActivity());
            j28Var.A(new b(this, j28Var));
            this.f = j28Var;
            j28Var.C(this.a);
            this.f.setFrom("index");
            this.f.setStageType("2001");
            bVar.n(this.f);
            lz k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<hp6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.q(this.g);
            k.s(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: D */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, hp6 hp6Var, AutoVideoCardViewHolder<hp6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, hp6Var, autoVideoCardViewHolder})) == null) {
            if (hp6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            hp6Var.B(hp6Var.position + 1);
            hp6Var.a.statFloor = hp6Var.i();
            autoVideoCardViewHolder.a().r(i);
            hp6Var.f1115T = 0;
            jo6.b().a(hp6Var.s());
            autoVideoCardViewHolder.x(z(hp6Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(hp6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.g);
            d28.p(hp6Var.a, this.a, hp6Var.i());
            d28.o(hp6Var.a, hp6Var.k(), hp6Var.i());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final to9 z(hp6 hp6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, hp6Var)) == null) {
            if (hp6Var != null) {
                to9 to9Var = new to9();
                to9Var.a = "1";
                to9Var.c = hp6Var.g;
                if (hp6Var.getThreadData() != null) {
                    to9Var.d = String.valueOf(hp6Var.getThreadData().getFid());
                    to9Var.v = hp6Var.getThreadData().getNid();
                    if (hp6Var.getThreadData().getThreadVideoInfo() != null) {
                        to9Var.m = hp6Var.getThreadData().getThreadVideoInfo().video_md5;
                        to9Var.p = String.valueOf(hp6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                to9Var.k = hp6Var.e();
                to9Var.f = hp6Var.k();
                to9Var.l = hp6Var.c();
                to9Var.h = hp6Var.w();
                to9Var.e = TbadkCoreApplication.getCurrentAccount();
                to9Var.q = String.valueOf(hp6Var.i());
                if (hp6Var.getThreadData() != null && hp6Var.getThreadData().getBaijiahaoData() != null) {
                    to9Var.t = hp6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    to9Var.u = hp6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return to9Var;
                }
                return to9Var;
            }
            return null;
        }
        return (to9) invokeL.objValue;
    }
}
