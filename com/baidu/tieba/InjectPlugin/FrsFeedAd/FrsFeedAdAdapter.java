package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ab9;
import com.baidu.tieba.bx5;
import com.baidu.tieba.ex5;
import com.baidu.tieba.fx5;
import com.baidu.tieba.jx5;
import com.baidu.tieba.zw5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class FrsFeedAdAdapter extends jx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ab9 mRecAppContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsFeedAdAdapter(ab9 ab9Var, BdUniqueId bdUniqueId) {
        super(ab9Var.q().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ab9Var, bdUniqueId};
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
        this.mRecAppContext = ab9Var;
    }

    @Override // com.baidu.tieba.jx5, com.baidu.tieba.vm
    public View getView(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof zw5)) {
                return null;
            }
            zw5 zw5Var = (zw5) obj;
            ex5 b1 = ((fx5) this.mRecAppContext).b1(1);
            if (!(b1 instanceof bx5)) {
                return null;
            }
            return ((bx5) b1).m(i, view2, viewGroup, zw5Var.a());
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.vm
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (zw5.e(getType()) == -1 || !(obj instanceof zw5)) {
                return null;
            }
            ex5 b1 = ((fx5) this.mRecAppContext).b1(1);
            if (!(b1 instanceof bx5)) {
                return null;
            }
            return ((bx5) b1).g(viewGroup, ((zw5) obj).a());
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.vm
    public void onFillViewHolder(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof zw5)) {
            return;
        }
        ex5 b1 = ((fx5) this.mRecAppContext).b1(1);
        if (!(b1 instanceof bx5)) {
            return;
        }
        ((bx5) b1).n(i, viewGroup, viewHolder, ((zw5) obj).a());
    }

    public void setTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            ex5 b1 = ((fx5) this.mRecAppContext).b1(1);
            if (!(b1 instanceof bx5)) {
                return;
            }
            ((bx5) b1).p(str);
        }
    }
}
