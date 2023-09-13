package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c46;
import com.baidu.tieba.d46;
import com.baidu.tieba.e3a;
import com.baidu.tieba.h46;
import com.baidu.tieba.x36;
import com.baidu.tieba.z36;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsFeedAdAdapter extends h46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e3a mRecAppContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsFeedAdAdapter(e3a e3aVar, BdUniqueId bdUniqueId) {
        super(e3aVar.u().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e3aVar, bdUniqueId};
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
        this.mRecAppContext = e3aVar;
    }

    @Override // com.baidu.tieba.h46, com.baidu.tieba.pm
    public View getView(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof x36)) {
                return null;
            }
            x36 x36Var = (x36) obj;
            c46 o1 = ((d46) this.mRecAppContext).o1(1);
            if (!(o1 instanceof z36)) {
                return null;
            }
            return ((z36) o1).m(i, view2, viewGroup, x36Var.a());
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.pm
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (x36.e(getType()) == -1 || !(obj instanceof x36)) {
                return null;
            }
            c46 o1 = ((d46) this.mRecAppContext).o1(1);
            if (!(o1 instanceof z36)) {
                return null;
            }
            return ((z36) o1).g(viewGroup, ((x36) obj).a());
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.pm
    public void onFillViewHolder(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof x36)) {
            return;
        }
        c46 o1 = ((d46) this.mRecAppContext).o1(1);
        if (!(o1 instanceof z36)) {
            return;
        }
        ((z36) o1).n(i, viewGroup, viewHolder, ((x36) obj).a());
    }

    public void setTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            c46 o1 = ((d46) this.mRecAppContext).o1(1);
            if (!(o1 instanceof z36)) {
                return;
            }
            ((z36) o1).p(str);
        }
    }
}
