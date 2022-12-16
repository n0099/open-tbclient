package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernRecommendLineHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class hx5 extends kn<lx5, LiveTabConcernRecommendLineHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public vx5 b;
    public wx5 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hx5(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), lx5.d);
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
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: s */
    public LiveTabConcernRecommendLineHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            vx5 vx5Var = new vx5(this.a, viewGroup);
            this.b = vx5Var;
            wx5 wx5Var = this.c;
            if (wx5Var != null) {
                vx5Var.s(wx5Var);
            }
            return new LiveTabConcernRecommendLineHolder(this.b);
        }
        return (LiveTabConcernRecommendLineHolder) invokeL.objValue;
    }

    public void u(wx5 wx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wx5Var) == null) {
            this.c = wx5Var;
            vx5 vx5Var = this.b;
            if (vx5Var != null) {
                vx5Var.s(wx5Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, lx5 lx5Var, LiveTabConcernRecommendLineHolder liveTabConcernRecommendLineHolder) {
        InterceptResult invokeCommon;
        vx5 vx5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, lx5Var, liveTabConcernRecommendLineHolder})) == null) {
            if (liveTabConcernRecommendLineHolder != null && (vx5Var = liveTabConcernRecommendLineHolder.a) != null) {
                vx5Var.i(lx5Var);
                return liveTabConcernRecommendLineHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
