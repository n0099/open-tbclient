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
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.mz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class f18 extends ln<l18, ThreadCardViewHolder<t15>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    @JvmField
    public BdUniqueId b;
    public eo<?> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f18(TbPageContext<?> mPageContext, BdUniqueId bdUniqueId) {
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

    public final void u(eo<?> eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eoVar) == null) {
            this.c = eoVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: s */
    public ThreadCardViewHolder<t15> onCreateViewHolder(ViewGroup parent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, parent)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            mz.b bVar = new mz.b(this.a.getPageActivity(), false);
            w18 w18Var = new w18(this.a);
            w18Var.r(this.b);
            bVar.n(w18Var);
            bVar.l().j(UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            bVar.l().c(0);
            bVar.l().g(0);
            bVar.l().f(0);
            bVar.l().e(0);
            bVar.l().i(0);
            mz k = bVar.k(BaseCardInfo.SupportType.CONTENT, parent, this.c);
            Intrinsics.checkNotNullExpressionValue(k, "builder.build(BaseCardIn…, parent, mITypeListView)");
            ThreadCardViewHolder<t15> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.j(this.b);
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, l18 l18Var, ThreadCardViewHolder<t15> viewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, l18Var, viewHolder})) == null) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            viewHolder.f(l18Var);
            if (viewHolder.b() != null) {
                viewHolder.b().r(i);
                viewHolder.b().onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            }
            return viewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
