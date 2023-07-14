package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.mz;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gv5 extends hv5<z45, ThreadCardViewHolder<z45>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public up6<z45> g;

    /* loaded from: classes6.dex */
    public class a extends up6<z45> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gv5 b;

        public a(gv5 gv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gv5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, z45Var) == null) {
                this.b.u(view2, z45Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gv5 a;

        public b(gv5 gv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gv5Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.P(view2, ynVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gv5(TbPageContext tbPageContext) {
        super(tbPageContext, ThreadData.TYPE_ARTICLE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this);
    }

    public final void P(View view2, yn ynVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, ynVar) == null) && (ynVar instanceof z45) && (view2.getTag() instanceof ThreadCardViewHolder)) {
            ThreadData threadData = ((z45) ynVar).t;
            threadData.objType = 1;
            ThreadCardUtils.jumpToPB((t15) threadData, view2.getContext(), C(), false);
            ((ThreadCardViewHolder) view2.getTag()).b().p(new xz.a(1));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: Q */
    public ThreadCardViewHolder<z45> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            mz.b bVar = new mz.b(this.c.getPageActivity());
            ay ayVar = new ay(this.c.getPageActivity());
            ayVar.r(this.mPageId);
            ayVar.C(this.c);
            bVar.o(ayVar);
            bVar.n(new yx(this.c.getPageActivity()));
            bVar.h(new iy(this.c.getPageActivity()));
            oz ozVar = new oz(this.c.getPageActivity());
            z15 z15Var = new z15();
            z15Var.b = x();
            z15Var.h = y();
            ozVar.D(z15Var);
            ozVar.F(A());
            ozVar.L(B());
            ozVar.G(C());
            bVar.m(ozVar);
            bVar.l().i(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds35));
            bVar.l().b(R.drawable.addresslist_item_bg);
            bVar.l().h(yi.g(this.c.getPageActivity(), R.dimen.tbds17));
            mz k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.d);
            k.s(C());
            ThreadCardViewHolder<z45> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.mPageId);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: R */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, z45 z45Var, ThreadCardViewHolder<z45> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, z45Var, threadCardViewHolder})) == null) {
            if (z45Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                z45Var.t.statFloor = getPositionByType(i) + 1;
                threadCardViewHolder.b().r(i);
                threadCardViewHolder.f(z45Var);
                threadCardViewHolder.b().q(this.g);
                threadCardViewHolder.b().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                N(threadCardViewHolder.getView(), z45Var, i, i);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
