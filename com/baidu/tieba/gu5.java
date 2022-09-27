package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.view.LiveTabConcernItemViewLineHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class gu5 extends qn<du5, LiveTabConcernItemViewLineHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public tu5 b;
    public yu5 c;
    public String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gu5(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), du5.d);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
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
        this.d = "";
        this.a = tbPageContext;
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: s */
    public LiveTabConcernItemViewLineHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            tu5 tu5Var = new tu5(this.a, viewGroup, this.d);
            this.b = tu5Var;
            yu5 yu5Var = this.c;
            if (yu5Var != null) {
                tu5Var.s(yu5Var);
            }
            return new LiveTabConcernItemViewLineHolder(this.b);
        }
        return (LiveTabConcernItemViewLineHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, du5 du5Var, LiveTabConcernItemViewLineHolder liveTabConcernItemViewLineHolder) {
        InterceptResult invokeCommon;
        tu5 tu5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, du5Var, liveTabConcernItemViewLineHolder})) == null) {
            if (liveTabConcernItemViewLineHolder == null || (tu5Var = liveTabConcernItemViewLineHolder.a) == null) {
                return null;
            }
            tu5Var.i(du5Var);
            return liveTabConcernItemViewLineHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void u(yu5 yu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, yu5Var) == null) {
            this.c = yu5Var;
            tu5 tu5Var = this.b;
            if (tu5Var != null) {
                tu5Var.s(yu5Var);
            }
        }
    }
}
