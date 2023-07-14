package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c56;
import com.baidu.tieba.e56;
import com.baidu.tieba.h56;
import com.baidu.tieba.i56;
import com.baidu.tieba.m56;
import com.baidu.tieba.qy9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsFeedAdAdapter extends m56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qy9 mRecAppContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsFeedAdAdapter(qy9 qy9Var, BdUniqueId bdUniqueId) {
        super(qy9Var.t().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qy9Var, bdUniqueId};
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
        this.mRecAppContext = qy9Var;
    }

    @Override // com.baidu.tieba.m56, com.baidu.tieba.ln
    public View getView(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof c56)) {
                return null;
            }
            c56 c56Var = (c56) obj;
            h56 d1 = ((i56) this.mRecAppContext).d1(1);
            if (!(d1 instanceof e56)) {
                return null;
            }
            return ((e56) d1).m(i, view2, viewGroup, c56Var.a());
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.ln
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (c56.e(getType()) == -1 || !(obj instanceof c56)) {
                return null;
            }
            h56 d1 = ((i56) this.mRecAppContext).d1(1);
            if (!(d1 instanceof e56)) {
                return null;
            }
            return ((e56) d1).g(viewGroup, ((c56) obj).a());
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ln
    public void onFillViewHolder(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof c56)) {
            return;
        }
        h56 d1 = ((i56) this.mRecAppContext).d1(1);
        if (!(d1 instanceof e56)) {
            return;
        }
        ((e56) d1).n(i, viewGroup, viewHolder, ((c56) obj).a());
    }

    public void setTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            h56 d1 = ((i56) this.mRecAppContext).d1(1);
            if (!(d1 instanceof e56)) {
                return;
            }
            ((e56) d1).p(str);
        }
    }
}
