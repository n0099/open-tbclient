package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.kq5;
import com.baidu.tieba.mq5;
import com.baidu.tieba.on8;
import com.baidu.tieba.pq5;
import com.baidu.tieba.qq5;
import com.baidu.tieba.uq5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class FrsFeedAdAdapter extends uq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public on8 mRecAppContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsFeedAdAdapter(on8 on8Var, BdUniqueId bdUniqueId) {
        super(on8Var.p().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {on8Var, bdUniqueId};
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
        this.mRecAppContext = on8Var;
    }

    @Override // com.baidu.tieba.uq5, com.baidu.tieba.ln
    public View getView(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof kq5)) {
                return null;
            }
            kq5 kq5Var = (kq5) obj;
            pq5 Y0 = ((qq5) this.mRecAppContext).Y0(1);
            if (!(Y0 instanceof mq5)) {
                return null;
            }
            return ((mq5) Y0).m(i, view2, viewGroup, kq5Var.a());
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.ln
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (kq5.g(getType()) == -1 || !(obj instanceof kq5)) {
                return null;
            }
            pq5 Y0 = ((qq5) this.mRecAppContext).Y0(1);
            if (!(Y0 instanceof mq5)) {
                return null;
            }
            return ((mq5) Y0).g(viewGroup, ((kq5) obj).a());
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ln
    public void onFillViewHolder(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof kq5)) {
            return;
        }
        pq5 Y0 = ((qq5) this.mRecAppContext).Y0(1);
        if (!(Y0 instanceof mq5)) {
            return;
        }
        ((mq5) Y0).n(i, viewGroup, viewHolder, ((kq5) obj).a());
    }

    public void setTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            pq5 Y0 = ((qq5) this.mRecAppContext).Y0(1);
            if (!(Y0 instanceof mq5)) {
                return;
            }
            ((mq5) Y0).p(str);
        }
    }
}
