package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.cu;
import com.baidu.tieba.nu;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class eb8 extends ci<xm6, ThreadCardViewHolder<xm6>> implements e26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public vi d;
    public mm6<xm6> e;

    /* loaded from: classes5.dex */
    public class a extends mm6<xm6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eb8 b;

        public a(eb8 eb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = eb8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm6
        /* renamed from: d */
        public void a(View view2, xm6 xm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, xm6Var) == null) {
                em6.b().d(true);
                c26.c().h("page_recommend", "show_");
                if (view2 != null && xm6Var != null && xm6Var.getThreadData() != null && !StringUtils.isNull(xm6Var.getThreadData().getTid())) {
                    this.b.A(view2, xm6Var);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eb8 a;

        public b(eb8 eb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eb8Var;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.x(view2, piVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eb8(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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

    public final void A(View view2, xm6 xm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, xm6Var) == null) {
            int id = view2.getId();
            if (id == R.id.thread_card_root) {
                za8.b(view2, xm6Var, 2);
            } else if (id != R.id.user_avatar && id != R.id.user_name) {
                if (id == R.id.cover_img || id == R.id.bottom_mask) {
                    za8.b(view2, xm6Var, 3);
                }
            } else {
                za8.b(view2, xm6Var, 1);
            }
        }
    }

    public final void x(View view2, pi piVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, view2, piVar) == null) && (piVar instanceof xm6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            xm6 xm6Var = (xm6) piVar;
            xm6Var.f = 1;
            ThreadCardUtils.jumpToPB((fw4) xm6Var, view2.getContext(), 1, false);
            ((ThreadCardViewHolder) view2.getTag()).a().q(new nu.a(1));
        }
    }

    public void B(vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viVar) == null) {
            this.d = viVar;
        }
    }

    @Override // com.baidu.tieba.e26
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: y */
    public ThreadCardViewHolder<xm6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            cu.b bVar = new cu.b(this.b.getPageActivity());
            rs rsVar = new rs(this.b.getPageActivity());
            rsVar.o(this.a);
            rsVar.A(this.b);
            bVar.o(rsVar);
            bVar.n(new ps(this.b.getPageActivity()));
            bVar.h(new zs(this.b.getPageActivity()));
            eu euVar = new eu(this.b.getPageActivity());
            lw4 lw4Var = new lw4();
            lw4Var.b = 1;
            lw4Var.h = 1;
            euVar.C(lw4Var);
            euVar.E(9);
            euVar.J(4);
            euVar.F(1);
            euVar.D(false);
            bVar.m(euVar);
            bVar.l().i(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            cu k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.d);
            k.t(1);
            ThreadCardViewHolder<xm6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, xm6 xm6Var, ThreadCardViewHolder<xm6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, xm6Var, threadCardViewHolder})) == null) {
            if (xm6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                xm6Var.B(xm6Var.position + 1);
                threadCardViewHolder.a().s(i);
                threadCardViewHolder.a().b(this.c);
                threadCardViewHolder.x(true, Align.ALIGN_RIGHT_TOP);
                threadCardViewHolder.k();
                threadCardViewHolder.e(xm6Var);
                em6.b().a(xm6Var.d("c12351"));
                threadCardViewHolder.a().r(this.e);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
