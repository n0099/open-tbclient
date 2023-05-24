package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lz5;
import com.baidu.tieba.nz5;
import com.baidu.tieba.qz5;
import com.baidu.tieba.rz5;
import com.baidu.tieba.tf9;
import com.baidu.tieba.vz5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FrsFeedAdAdapter extends vz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tf9 mRecAppContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsFeedAdAdapter(tf9 tf9Var, BdUniqueId bdUniqueId) {
        super(tf9Var.s().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tf9Var, bdUniqueId};
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
        this.mRecAppContext = tf9Var;
    }

    @Override // com.baidu.tieba.vz5, com.baidu.tieba.en
    public View getView(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof lz5)) {
                return null;
            }
            lz5 lz5Var = (lz5) obj;
            qz5 c1 = ((rz5) this.mRecAppContext).c1(1);
            if (!(c1 instanceof nz5)) {
                return null;
            }
            return ((nz5) c1).m(i, view2, viewGroup, lz5Var.a());
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.en
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (lz5.e(getType()) == -1 || !(obj instanceof lz5)) {
                return null;
            }
            qz5 c1 = ((rz5) this.mRecAppContext).c1(1);
            if (!(c1 instanceof nz5)) {
                return null;
            }
            return ((nz5) c1).g(viewGroup, ((lz5) obj).a());
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.en
    public void onFillViewHolder(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof lz5)) {
            return;
        }
        qz5 c1 = ((rz5) this.mRecAppContext).c1(1);
        if (!(c1 instanceof nz5)) {
            return;
        }
        ((nz5) c1).n(i, viewGroup, viewHolder, ((lz5) obj).a());
    }

    public void setTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            qz5 c1 = ((rz5) this.mRecAppContext).c1(1);
            if (!(c1 instanceof nz5)) {
                return;
            }
            ((nz5) c1).p(str);
        }
    }
}
