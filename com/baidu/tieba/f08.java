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
import com.baidu.tieba.mz;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f08 extends ln<fq6, ThreadCardViewHolder<fq6>> implements t66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public eo d;
    public up6<fq6> e;

    /* loaded from: classes5.dex */
    public class a extends up6<fq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f08 b;

        public a(f08 f08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, fq6 fq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, fq6Var) == null) {
                np6.b().d(true);
                r66.c().h("page_recommend", "show_");
                if (view2 != null && fq6Var != null && fq6Var.getThreadData() != null && !StringUtils.isNull(fq6Var.getThreadData().getTid())) {
                    this.b.z(view2, fq6Var);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f08 a;

        public b(f08 f08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f08Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.u(view2, ynVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f08(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public void A(eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eoVar) == null) {
            this.d = eoVar;
        }
    }

    @Override // com.baidu.tieba.t66
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.c = str;
        }
    }

    public final void u(View view2, yn ynVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, view2, ynVar) == null) && (ynVar instanceof fq6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            fq6 fq6Var = (fq6) ynVar;
            fq6Var.f = 1;
            ThreadCardUtils.jumpToPB((t15) fq6Var, view2.getContext(), 1, false);
            ((ThreadCardViewHolder) view2.getTag()).b().p(new xz.a(1));
        }
    }

    public final void z(View view2, fq6 fq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view2, fq6Var) == null) {
            int id = view2.getId();
            if (id == R.id.thread_card_root) {
                a08.b(view2, fq6Var, 2);
            } else if (id != R.id.user_avatar && id != R.id.user_name) {
                if (id == R.id.cover_img || id == R.id.bottom_mask) {
                    a08.b(view2, fq6Var, 3);
                }
            } else {
                a08.b(view2, fq6Var, 1);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: x */
    public ThreadCardViewHolder<fq6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            mz.b bVar = new mz.b(this.b.getPageActivity());
            ay ayVar = new ay(this.b.getPageActivity());
            ayVar.r(this.a);
            ayVar.C(this.b);
            bVar.o(ayVar);
            bVar.n(new yx(this.b.getPageActivity()));
            bVar.h(new iy(this.b.getPageActivity()));
            oz ozVar = new oz(this.b.getPageActivity());
            z15 z15Var = new z15();
            z15Var.b = 1;
            z15Var.h = 1;
            ozVar.D(z15Var);
            ozVar.F(9);
            ozVar.L(4);
            ozVar.G(1);
            ozVar.E(false);
            bVar.m(ozVar);
            bVar.l().i(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            mz k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<fq6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, fq6 fq6Var, ThreadCardViewHolder<fq6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, fq6Var, threadCardViewHolder})) == null) {
            if (fq6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                fq6Var.B(fq6Var.position + 1);
                threadCardViewHolder.b().r(i);
                threadCardViewHolder.b().b(this.c);
                threadCardViewHolder.u(true, Align.ALIGN_RIGHT_TOP);
                threadCardViewHolder.k();
                threadCardViewHolder.f(fq6Var);
                np6.b().a(fq6Var.d("c12351"));
                threadCardViewHolder.b().q(this.e);
                threadCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
