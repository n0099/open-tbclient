package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c19;
import com.baidu.tieba.cw5;
import com.baidu.tieba.sv5;
import com.baidu.tieba.uv5;
import com.baidu.tieba.xv5;
import com.baidu.tieba.yv5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class FrsFeedAdAdapter extends cw5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c19 mRecAppContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsFeedAdAdapter(c19 c19Var, BdUniqueId bdUniqueId) {
        super(c19Var.n().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c19Var, bdUniqueId};
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
        this.mRecAppContext = c19Var;
    }

    @Override // com.baidu.tieba.cw5, com.baidu.tieba.tm
    public View getView(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof sv5)) {
                return null;
            }
            sv5 sv5Var = (sv5) obj;
            xv5 Z0 = ((yv5) this.mRecAppContext).Z0(1);
            if (!(Z0 instanceof uv5)) {
                return null;
            }
            return ((uv5) Z0).m(i, view2, viewGroup, sv5Var.a());
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.tm
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (sv5.g(getType()) == -1 || !(obj instanceof sv5)) {
                return null;
            }
            xv5 Z0 = ((yv5) this.mRecAppContext).Z0(1);
            if (!(Z0 instanceof uv5)) {
                return null;
            }
            return ((uv5) Z0).g(viewGroup, ((sv5) obj).a());
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.tm
    public void onFillViewHolder(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof sv5)) {
            return;
        }
        xv5 Z0 = ((yv5) this.mRecAppContext).Z0(1);
        if (!(Z0 instanceof uv5)) {
            return;
        }
        ((uv5) Z0).n(i, viewGroup, viewHolder, ((sv5) obj).a());
    }

    public void setTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            xv5 Z0 = ((yv5) this.mRecAppContext).Z0(1);
            if (!(Z0 instanceof uv5)) {
                return;
            }
            ((uv5) Z0).p(str);
        }
    }
}
