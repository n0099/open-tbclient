package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.bu;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class f98 extends bi<l98, ThreadCardViewHolder<bw4>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    @JvmField
    public BdUniqueId b;
    public ui<?> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f98(TbPageContext<?> mPageContext, BdUniqueId bdUniqueId) {
        super(mPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mPageContext, bdUniqueId};
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
        Intrinsics.checkNotNullParameter(mPageContext, "mPageContext");
        this.a = mPageContext;
    }

    public final void x(ui<?> uiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, uiVar) == null) {
            this.c = uiVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: t */
    public ThreadCardViewHolder<bw4> onCreateViewHolder(ViewGroup parent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, parent)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            bu.b bVar = new bu.b(this.a.getPageActivity(), false);
            w98 w98Var = new w98(this.a);
            w98Var.o(this.b);
            bVar.n(w98Var);
            bVar.l().j(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            bVar.l().c(0);
            bVar.l().g(0);
            bVar.l().f(0);
            bVar.l().e(0);
            bVar.l().i(0);
            bu k = bVar.k(BaseCardInfo.SupportType.CONTENT, parent, this.c);
            Intrinsics.checkNotNullExpressionValue(k, "builder.build(BaseCardIn…, parent, mITypeListView)");
            ThreadCardViewHolder<bw4> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.b);
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, l98 l98Var, ThreadCardViewHolder<bw4> viewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, l98Var, viewHolder})) == null) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            viewHolder.e(l98Var);
            if (viewHolder.a() != null) {
                viewHolder.a().s(i);
                viewHolder.a().onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            }
            return viewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
