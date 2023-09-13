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
/* loaded from: classes5.dex */
public class fc6 extends pm<jc6, LiveTabConcernRecommendLineHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public tc6 b;
    public uc6 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fc6(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), jc6.d);
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
    @Override // com.baidu.tieba.pm
    /* renamed from: s */
    public LiveTabConcernRecommendLineHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            tc6 tc6Var = new tc6(this.a, viewGroup);
            this.b = tc6Var;
            uc6 uc6Var = this.c;
            if (uc6Var != null) {
                tc6Var.s(uc6Var);
            }
            return new LiveTabConcernRecommendLineHolder(this.b);
        }
        return (LiveTabConcernRecommendLineHolder) invokeL.objValue;
    }

    public void u(uc6 uc6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, uc6Var) == null) {
            this.c = uc6Var;
            tc6 tc6Var = this.b;
            if (tc6Var != null) {
                tc6Var.s(uc6Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, jc6 jc6Var, LiveTabConcernRecommendLineHolder liveTabConcernRecommendLineHolder) {
        InterceptResult invokeCommon;
        tc6 tc6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, jc6Var, liveTabConcernRecommendLineHolder})) == null) {
            if (liveTabConcernRecommendLineHolder != null && (tc6Var = liveTabConcernRecommendLineHolder.a) != null) {
                tc6Var.i(jc6Var);
                return liveTabConcernRecommendLineHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
