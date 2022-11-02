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
import com.baidu.tieba.ny;
import com.baidu.tieba.yy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g37 extends jn<o46, ThreadCardViewHolder<o46>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public co c;

    /* loaded from: classes4.dex */
    public class a implements go {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ux a;

        public a(g37 g37Var, ux uxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g37Var, uxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uxVar;
        }

        @Override // com.baidu.tieba.go
        public void b(View view2, wn wnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            o46 o46Var;
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, wnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                boolean z = wnVar instanceof o46;
                int i2 = 0;
                if (z && (o46Var = (o46) wnVar) != null && o46Var.u && (threadData = o46Var.a) != null && threadData.getItem() != null) {
                    int intValue = o46Var.a.getItem().button_link_type.intValue();
                    if (o46Var.a.getItem().apk_detail != null) {
                        i2 = o46Var.a.getItem().apk_detail.pkg_source.intValue();
                    }
                    int a = sz4.a(intValue, i2);
                    ItemData itemData = new ItemData();
                    itemData.parseProto(o46Var.a.getItem());
                    ItemCardHelper.q(this.a.y(), o46Var.a.getItem().item_id.longValue(), this.a.x(itemData), o46Var.a.getTid(), a, "", 2);
                    ItemClickJumpUtil.itemClickJump(o46Var.a.getItem().forum_name, String.valueOf(o46Var.a.getItem().item_id), 1, 1);
                } else if (z && (view2.getTag() instanceof ThreadCardViewHolder)) {
                    o46 o46Var2 = (o46) wnVar;
                    o46Var2.f = 1;
                    ThreadCardUtils.jumpToPB((rr4) o46Var2, view2.getContext(), 4, false);
                    ((ThreadCardViewHolder) view2.getTag()).a().o(new yy.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g37(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void u(co coVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, coVar) == null) {
            this.c = coVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: s */
    public ThreadCardViewHolder<o46> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.b.getPageActivity(), false);
            ux uxVar = new ux(this.b.getPageActivity());
            uxVar.A(true);
            uxVar.D(1);
            uxVar.w();
            bVar.h(uxVar);
            ny k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.c);
            k.r(2);
            ThreadCardViewHolder<o46> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new a(this, uxVar));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, o46 o46Var, ThreadCardViewHolder<o46> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, o46Var, threadCardViewHolder})) == null) {
            if (o46Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && o46Var.a != null) {
                o46Var.I(o46Var.position + 1);
                o46Var.a.statFloor = o46Var.n();
                threadCardViewHolder.a().q(i);
                threadCardViewHolder.e(o46Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
