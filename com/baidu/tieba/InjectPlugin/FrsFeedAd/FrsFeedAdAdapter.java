package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b36;
import com.baidu.tieba.d36;
import com.baidu.tieba.g36;
import com.baidu.tieba.h36;
import com.baidu.tieba.l36;
import com.baidu.tieba.n1a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsFeedAdAdapter extends l36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n1a mRecAppContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsFeedAdAdapter(n1a n1aVar, BdUniqueId bdUniqueId) {
        super(n1aVar.u().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n1aVar, bdUniqueId};
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
        this.mRecAppContext = n1aVar;
    }

    @Override // com.baidu.tieba.l36, com.baidu.tieba.om
    public View getView(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof b36)) {
                return null;
            }
            b36 b36Var = (b36) obj;
            g36 n1 = ((h36) this.mRecAppContext).n1(1);
            if (!(n1 instanceof d36)) {
                return null;
            }
            return ((d36) n1).m(i, view2, viewGroup, b36Var.a());
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.om
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (b36.e(getType()) == -1 || !(obj instanceof b36)) {
                return null;
            }
            g36 n1 = ((h36) this.mRecAppContext).n1(1);
            if (!(n1 instanceof d36)) {
                return null;
            }
            return ((d36) n1).g(viewGroup, ((b36) obj).a());
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.om
    public void onFillViewHolder(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof b36)) {
            return;
        }
        g36 n1 = ((h36) this.mRecAppContext).n1(1);
        if (!(n1 instanceof d36)) {
            return;
        }
        ((d36) n1).n(i, viewGroup, viewHolder, ((b36) obj).a());
    }

    public void setTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            g36 n1 = ((h36) this.mRecAppContext).n1(1);
            if (!(n1 instanceof d36)) {
                return;
            }
            ((d36) n1).p(str);
        }
    }
}
