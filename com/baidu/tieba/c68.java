package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c68 extends pm<cq6, ThreadCardViewHolder<cq6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public in c;

    /* loaded from: classes5.dex */
    public class a implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx a;

        public a(c68 c68Var, xx xxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c68Var, xxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xxVar;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            cq6 cq6Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = cnVar instanceof cq6;
                int i2 = 0;
                if (z && (cq6Var = (cq6) cnVar) != null && cq6Var.u && (threadData = cq6Var.a) != null && threadData.getItem() != null) {
                    int intValue = cq6Var.a.getItem().button_link_type.intValue();
                    if (cq6Var.a.getItem().apk_detail != null) {
                        i2 = cq6Var.a.getItem().apk_detail.pkg_source.intValue();
                    }
                    int a = wa5.a(intValue, i2);
                    ItemData itemData = new ItemData();
                    itemData.parseProto(cq6Var.a.getItem());
                    ItemCardHelper.q(this.a.A(), cq6Var.a.getItem().item_id.longValue(), this.a.z(itemData), cq6Var.a.getTid(), a, "", 2);
                    ItemClickJumpUtil.itemClickJump(cq6Var.a.getItem().forum_name, String.valueOf(cq6Var.a.getItem().item_id), 1, 1);
                } else if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    cq6 cq6Var2 = (cq6) cnVar;
                    cq6Var2.f = 1;
                    ThreadCardUtils.jumpToPB((b15) cq6Var2, view2.getContext(), 4, false);
                    ((ThreadCardViewHolder) view2.getTag()).a().p(new zy.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c68(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.b = tbPageContext;
    }

    public void u(in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, inVar) == null) {
            this.c = inVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: s */
    public ThreadCardViewHolder<cq6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity(), false);
            xx xxVar = new xx(this.b.getPageActivity());
            xxVar.C(true);
            xxVar.F(1);
            xxVar.y();
            bVar.h(xxVar);
            oy k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.c);
            k.s(2);
            ThreadCardViewHolder<cq6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new a(this, xxVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, cq6 cq6Var, ThreadCardViewHolder<cq6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, cq6Var, threadCardViewHolder})) == null) {
            if (cq6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && cq6Var.a != null) {
                cq6Var.B(cq6Var.position + 1);
                cq6Var.a.statFloor = cq6Var.h();
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.e(cq6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
