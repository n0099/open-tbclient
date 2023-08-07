package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hx9;
import com.baidu.tieba.j26;
import com.baidu.tieba.l26;
import com.baidu.tieba.o26;
import com.baidu.tieba.p26;
import com.baidu.tieba.t26;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsFeedAdAdapter extends t26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hx9 mRecAppContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsFeedAdAdapter(hx9 hx9Var, BdUniqueId bdUniqueId) {
        super(hx9Var.u().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hx9Var, bdUniqueId};
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
        this.mRecAppContext = hx9Var;
    }

    @Override // com.baidu.tieba.t26, com.baidu.tieba.lm
    public View getView(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof j26)) {
                return null;
            }
            j26 j26Var = (j26) obj;
            o26 e1 = ((p26) this.mRecAppContext).e1(1);
            if (!(e1 instanceof l26)) {
                return null;
            }
            return ((l26) e1).m(i, view2, viewGroup, j26Var.a());
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.lm
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (j26.e(getType()) == -1 || !(obj instanceof j26)) {
                return null;
            }
            o26 e1 = ((p26) this.mRecAppContext).e1(1);
            if (!(e1 instanceof l26)) {
                return null;
            }
            return ((l26) e1).g(viewGroup, ((j26) obj).a());
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.lm
    public void onFillViewHolder(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof j26)) {
            return;
        }
        o26 e1 = ((p26) this.mRecAppContext).e1(1);
        if (!(e1 instanceof l26)) {
            return;
        }
        ((l26) e1).n(i, viewGroup, viewHolder, ((j26) obj).a());
    }

    public void setTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            o26 e1 = ((p26) this.mRecAppContext).e1(1);
            if (!(e1 instanceof l26)) {
                return;
            }
            ((l26) e1).p(str);
        }
    }
}
