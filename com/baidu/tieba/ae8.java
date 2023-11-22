package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
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
import com.baidu.tieba.bu;
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.mu;
import com.baidu.tieba.ns;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ae8 extends bi<pm6, AutoVideoCardViewHolder<pm6>> implements t16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public bf8 c;
    public String d;
    public ui e;
    public ju f;
    public yl6<pm6> g;

    /* loaded from: classes5.dex */
    public class a extends yl6<pm6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae8 b;

        public a(ae8 ae8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ae8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ae8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yl6
        /* renamed from: d */
        public void a(View view2, pm6 pm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, pm6Var) == null) {
                ql6.b().d(true);
                r16.c().h("page_recommend", "show_");
                if (this.b.c != null && pm6Var != null && pm6Var.getThreadData() != null && !StringUtils.isNull(pm6Var.getThreadData().getTid())) {
                    if (pm6Var.getThreadData().middle_page_num > 0) {
                        TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(pm6Var.G(pm6Var.getThreadData())));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !xc8.b(JavaTypesHelper.toLong(pm6Var.getThreadData().getTid(), 0L))) {
                        xc8.a(JavaTypesHelper.toLong(pm6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(JavaTypesHelper.toLong(pm6Var.getThreadData().getTid(), 0L), pm6Var.u(), pm6Var.i(), pm6Var.h(), pm6Var.c(), JavaTypesHelper.toInt((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, pm6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.B(view2, pm6Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ns.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju a;
        public final /* synthetic */ ae8 b;

        public b(ae8 ae8Var, ju juVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ae8Var, juVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ae8Var;
            this.a = juVar;
        }

        @Override // com.baidu.tieba.ns.a
        public void a(bw4 bw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, bw4Var) != null) || bw4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (bw4Var instanceof pm6) {
                bw4Var.objType = 5;
                ThreadCardUtils.jumpToPB(bw4Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(bw4Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements yi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae8 a;

        public c(ae8 ae8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ae8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ae8Var;
        }

        @Override // com.baidu.tieba.yi
        public void b(View view2, oi oiVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, oiVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (oiVar instanceof pm6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                pm6 pm6Var = (pm6) oiVar;
                pm6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), pm6Var);
                }
                ThreadCardUtils.jumpToPB((bw4) pm6Var, view2.getContext(), 2, false, rs.a((ui) viewGroup, view2, i));
                autoVideoCardViewHolder.a().q(new mu.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        C();
    }

    public void F(bf8 bf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bf8Var) == null) {
            this.c = bf8Var;
        }
    }

    public void G(ui uiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, uiVar) == null) {
            this.e = uiVar;
        }
    }

    @Override // com.baidu.tieba.t16
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.d = str;
        }
    }

    public final g9a A(pm6 pm6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pm6Var)) == null) {
            if (pm6Var != null) {
                g9a g9aVar = new g9a();
                g9aVar.a = "1";
                g9aVar.c = pm6Var.g;
                if (pm6Var.getThreadData() != null) {
                    g9aVar.d = String.valueOf(pm6Var.getThreadData().getFid());
                    g9aVar.v = pm6Var.getThreadData().getNid();
                    if (pm6Var.getThreadData().getThreadVideoInfo() != null) {
                        g9aVar.m = pm6Var.getThreadData().getThreadVideoInfo().video_md5;
                        g9aVar.p = String.valueOf(pm6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                g9aVar.k = pm6Var.e();
                g9aVar.f = pm6Var.i();
                g9aVar.l = pm6Var.c();
                g9aVar.h = pm6Var.u();
                g9aVar.e = TbadkCoreApplication.getCurrentAccount();
                g9aVar.q = String.valueOf(pm6Var.h());
                if (pm6Var.getThreadData() != null && pm6Var.getThreadData().getBaijiahaoData() != null) {
                    g9aVar.t = pm6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    g9aVar.u = pm6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return g9aVar;
                }
                return g9aVar;
            }
            return null;
        }
        return (g9a) invokeL.objValue;
    }

    public final void B(View view2, pm6 pm6Var) {
        ju juVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, pm6Var) == null) && (juVar = this.f) != null && juVar.s() != null && this.f.s().getMainView() != null) {
            if (view2.getId() == this.f.s().getMainView().getId()) {
                CardLinkageManager.INSTANCE.cancelHighLight(this.e, pm6Var);
                gf8.d(pm6Var.a, this.a, pm6Var.h(), 4);
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(pm6Var.I()));
                gf8.c(pm6Var.a, pm6Var.i(), pm6Var.h(), 2);
            } else if (view2.getId() == R.id.thread_card_root) {
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(pm6Var.G(pm6Var.a)));
                gf8.c(pm6Var.a, pm6Var.i(), pm6Var.h(), 1);
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            pm6.V = "c10708";
            pm6.W = "c10735";
            pm6.X = "c10709";
            pm6.Y = "c10734";
            pm6.Z = "c11929";
            pm6.a0 = "c11928";
            pm6.b0 = "c10756";
        }
    }

    public void onPause() {
        ju juVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (juVar = this.f) != null) {
            juVar.x();
        }
    }

    public void onResume() {
        ju juVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (juVar = this.f) != null) {
            juVar.y();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: D */
    public AutoVideoCardViewHolder<pm6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            bu.b bVar = new bu.b(this.b.getPageActivity(), false);
            of8 of8Var = new of8(this.b.getPageActivity());
            of8Var.z(new b(this, of8Var));
            this.f = of8Var;
            of8Var.o(this.a);
            this.f.setFrom("index");
            this.f.setStageType("2001");
            bVar.n(this.f);
            bu k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<pm6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.r(this.g);
            k.t(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: E */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, pm6 pm6Var, AutoVideoCardViewHolder<pm6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, pm6Var, autoVideoCardViewHolder})) == null) {
            if (pm6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            pm6Var.A(pm6Var.position + 1);
            pm6Var.a.statFloor = pm6Var.h();
            autoVideoCardViewHolder.a().s(i);
            pm6Var.f1153T = 0;
            ql6.b().a(pm6Var.s());
            autoVideoCardViewHolder.z(A(pm6Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(pm6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().r(this.g);
            gf8.p(pm6Var.a, this.a, pm6Var.h());
            gf8.o(pm6Var.a, pm6Var.i(), pm6Var.h());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
