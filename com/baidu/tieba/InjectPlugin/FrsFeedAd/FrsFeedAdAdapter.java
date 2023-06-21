package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.d46;
import com.baidu.tieba.t36;
import com.baidu.tieba.v36;
import com.baidu.tieba.xn9;
import com.baidu.tieba.y36;
import com.baidu.tieba.z36;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FrsFeedAdAdapter extends d46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xn9 mRecAppContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsFeedAdAdapter(xn9 xn9Var, BdUniqueId bdUniqueId) {
        super(xn9Var.t().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xn9Var, bdUniqueId};
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
        this.mRecAppContext = xn9Var;
    }

    @Override // com.baidu.tieba.d46, com.baidu.tieba.jn
    public View getView(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof t36)) {
                return null;
            }
            t36 t36Var = (t36) obj;
            y36 d1 = ((z36) this.mRecAppContext).d1(1);
            if (!(d1 instanceof v36)) {
                return null;
            }
            return ((v36) d1).m(i, view2, viewGroup, t36Var.a());
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.jn
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (t36.e(getType()) == -1 || !(obj instanceof t36)) {
                return null;
            }
            y36 d1 = ((z36) this.mRecAppContext).d1(1);
            if (!(d1 instanceof v36)) {
                return null;
            }
            return ((v36) d1).g(viewGroup, ((t36) obj).a());
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.jn
    public void onFillViewHolder(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof t36)) {
            return;
        }
        y36 d1 = ((z36) this.mRecAppContext).d1(1);
        if (!(d1 instanceof v36)) {
            return;
        }
        ((v36) d1).n(i, viewGroup, viewHolder, ((t36) obj).a());
    }

    public void setTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            y36 d1 = ((z36) this.mRecAppContext).d1(1);
            if (!(d1 instanceof v36)) {
                return;
            }
            ((v36) d1).p(str);
        }
    }
}
