package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.cu;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d2a extends ci<dw9, ThreadCardViewHolder<dw9>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public boolean c;
    public vi d;
    public mm6<dw9> e;

    /* loaded from: classes5.dex */
    public class a extends mm6<dw9> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d2a b;

        public a(d2a d2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d2aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d2aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm6
        /* renamed from: d */
        public void a(View view2, dw9 dw9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, dw9Var) == null) && view2 != null && dw9Var != null && dw9Var.getThreadData() != null && !TextUtils.isEmpty(dw9Var.getThreadData().getTid())) {
                this.b.z(view2, dw9Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d2a a;

        public b(d2a d2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d2aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d2aVar;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (piVar instanceof dw9) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                dw9 dw9Var = (dw9) piVar;
                dw9Var.f = 1;
                if (this.a.e != null) {
                    this.a.e.a(threadCardViewHolder.getView(), dw9Var);
                }
                UrlManager.getInstance().dealOneLink(dw9Var.W());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d2a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.c = true;
        this.e = new a(this);
        this.b = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: x */
    public ThreadCardViewHolder<dw9> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            cu.b bVar = new cu.b(this.b.getPageActivity(), false);
            bVar.l().k(false);
            bVar.o(new bt(this.b.getPageActivity()));
            ot otVar = new ot(this.b.getPageActivity());
            otVar.setFrom("pb");
            otVar.x(this.c);
            otVar.A(false);
            bVar.n(otVar);
            eu euVar = new eu(this.b.getPageActivity());
            lw4 lw4Var = new lw4();
            lw4Var.b = 25;
            lw4Var.h = 25;
            euVar.C(lw4Var);
            euVar.E(25);
            euVar.J(11);
            euVar.F(0);
            euVar.b(32);
            bVar.m(euVar);
            cu k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            k.t(0);
            ThreadCardViewHolder<dw9> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, dw9 dw9Var, ThreadCardViewHolder<dw9> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, dw9Var, threadCardViewHolder})) == null) {
            if (dw9Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && dw9Var.a != null) {
                dw9Var.B(dw9Var.position + 1);
                threadCardViewHolder.a().s(i);
                threadCardViewHolder.e(dw9Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().r(this.e);
                b6a.r(dw9Var, this.b, "2");
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z(View view2, dw9 dw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, dw9Var) == null) {
            if (view2.getId() != R.id.forum_head_image && view2.getId() != R.id.forum_head_barname && view2.getId() != R.id.forum_head_info_attention && view2.getId() != R.id.forum_head_info_thread) {
                if (view2.getId() == R.id.thread_card_root) {
                    b6a.p(dw9Var, 1, this.b, "2");
                    return;
                } else if (view2 instanceof TbImageView) {
                    b6a.p(dw9Var, 3, this.b, "2");
                    return;
                } else if (view2.getId() == R.id.thread_card_title || view2.getId() == R.id.thread_card_abstract) {
                    b6a.p(dw9Var, 1, this.b, "2");
                    return;
                } else {
                    return;
                }
            }
            b6a.p(dw9Var, 2, this.b, "2");
        }
    }
}
