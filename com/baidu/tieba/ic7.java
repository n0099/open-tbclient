package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.cy;
import com.baidu.tieba.ny;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ic7 extends tm<vf6, ThreadCardViewHolder<vf6>> implements jx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public mn d;
    public lf6<vf6> e;

    /* loaded from: classes4.dex */
    public class a extends lf6<vf6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ic7 b;

        public a(ic7 ic7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ic7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ic7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lf6
        /* renamed from: d */
        public void a(View view2, vf6 vf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, vf6Var) == null) {
                ef6.b().d(true);
                hx5.c().h("page_recommend", "show_");
                if (view2 != null && vf6Var != null && vf6Var.getThreadData() != null && !StringUtils.isNull(vf6Var.getThreadData().getTid())) {
                    this.b.z(view2, vf6Var);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements qn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ic7 a;

        public b(ic7 ic7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ic7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ic7Var;
        }

        @Override // com.baidu.tieba.qn
        public void b(View view2, gn gnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, gnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.u(view2, gnVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ic7(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.e = new a(this);
        this.b = tbPageContext;
    }

    public void A(mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mnVar) == null) {
            this.d = mnVar;
        }
    }

    @Override // com.baidu.tieba.jx5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.c = str;
        }
    }

    public final void u(View view2, gn gnVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, view2, gnVar) == null) && (gnVar instanceof vf6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            vf6 vf6Var = (vf6) gnVar;
            vf6Var.f = 1;
            ThreadCardUtils.jumpToPB((hw4) vf6Var, view2.getContext(), 1, false);
            ((ThreadCardViewHolder) view2.getTag()).a().p(new ny.a(1));
        }
    }

    public final void z(View view2, vf6 vf6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view2, vf6Var) == null) {
            int id = view2.getId();
            if (id == R.id.thread_card_root) {
                cc7.b(view2, vf6Var, 2);
            } else if (id != R.id.user_avatar && id != R.id.user_name) {
                if (id == R.id.cover_img || id == R.id.bottom_mask) {
                    cc7.b(view2, vf6Var, 3);
                }
            } else {
                cc7.b(view2, vf6Var, 1);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: x */
    public ThreadCardViewHolder<vf6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.b.getPageActivity());
            rw rwVar = new rw(this.b.getPageActivity());
            rwVar.x(this.a);
            rwVar.z(this.b);
            bVar.o(rwVar);
            bVar.n(new pw(this.b.getPageActivity()));
            bVar.h(new yw(this.b.getPageActivity()));
            ey eyVar = new ey(this.b.getPageActivity());
            nw4 nw4Var = new nw4();
            nw4Var.b = 1;
            nw4Var.h = 1;
            eyVar.z(nw4Var);
            eyVar.B(9);
            eyVar.G(4);
            eyVar.C(1);
            eyVar.A(false);
            bVar.m(eyVar);
            bVar.l().i(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            cy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<vf6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, vf6 vf6Var, ThreadCardViewHolder<vf6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, vf6Var, threadCardViewHolder})) == null) {
            if (vf6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                vf6Var.E(vf6Var.position + 1);
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.a().b(this.c);
                threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP);
                threadCardViewHolder.j();
                threadCardViewHolder.e(vf6Var);
                ef6.b().a(vf6Var.f("c12351"));
                threadCardViewHolder.a().q(this.e);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
