package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsLiveNormalCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e76 extends um<h76, AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public q36 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e76(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.a = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.um
    /* renamed from: s */
    public AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return new AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder(new AlaGameFrsLiveNormalCardView(this.a));
        }
        return (AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder) invokeL.objValue;
    }

    public void u(q36 q36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, q36Var) == null) {
            this.b = q36Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.um
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, h76 h76Var, AlaGameFrsLiveNormalCardView.AlaGameFrsNormalViewHolder alaGameFrsNormalViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, h76Var, alaGameFrsNormalViewHolder})) == null) {
            alaGameFrsNormalViewHolder.a.l(h76Var);
            alaGameFrsNormalViewHolder.a.t(this.b);
            return alaGameFrsNormalViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
