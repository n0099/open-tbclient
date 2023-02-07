package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.av5;
import com.baidu.tieba.bv5;
import com.baidu.tieba.fv5;
import com.baidu.tieba.jr8;
import com.baidu.tieba.vu5;
import com.baidu.tieba.xu5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class FrsFeedAdAdapter extends fv5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jr8 mRecAppContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsFeedAdAdapter(jr8 jr8Var, BdUniqueId bdUniqueId) {
        super(jr8Var.p().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jr8Var, bdUniqueId};
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
        this.mRecAppContext = jr8Var;
    }

    @Override // com.baidu.tieba.fv5, com.baidu.tieba.qn
    public View getView(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof vu5)) {
                return null;
            }
            vu5 vu5Var = (vu5) obj;
            av5 Z0 = ((bv5) this.mRecAppContext).Z0(1);
            if (!(Z0 instanceof xu5)) {
                return null;
            }
            return ((xu5) Z0).m(i, view2, viewGroup, vu5Var.a());
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.qn
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (vu5.g(getType()) == -1 || !(obj instanceof vu5)) {
                return null;
            }
            av5 Z0 = ((bv5) this.mRecAppContext).Z0(1);
            if (!(Z0 instanceof xu5)) {
                return null;
            }
            return ((xu5) Z0).g(viewGroup, ((vu5) obj).a());
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.qn
    public void onFillViewHolder(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof vu5)) {
            return;
        }
        av5 Z0 = ((bv5) this.mRecAppContext).Z0(1);
        if (!(Z0 instanceof xu5)) {
            return;
        }
        ((xu5) Z0).n(i, viewGroup, viewHolder, ((vu5) obj).a());
    }

    public void setTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            av5 Z0 = ((bv5) this.mRecAppContext).Z0(1);
            if (!(Z0 instanceof xu5)) {
                return;
            }
            ((xu5) Z0).p(str);
        }
    }
}
