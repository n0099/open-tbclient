package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.io5;
import com.baidu.tieba.ko5;
import com.baidu.tieba.no5;
import com.baidu.tieba.oo5;
import com.baidu.tieba.sf8;
import com.baidu.tieba.so5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class FrsFeedAdAdapter extends so5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sf8 mRecAppContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsFeedAdAdapter(sf8 sf8Var, BdUniqueId bdUniqueId) {
        super(sf8Var.o().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sf8Var, bdUniqueId};
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
        this.mRecAppContext = sf8Var;
    }

    @Override // com.baidu.tieba.so5, com.baidu.tieba.jn
    public View getView(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof io5)) {
                return null;
            }
            io5 io5Var = (io5) obj;
            no5 P0 = ((oo5) this.mRecAppContext).P0(1);
            if (!(P0 instanceof ko5)) {
                return null;
            }
            return ((ko5) P0).m(i, view2, viewGroup, io5Var.a());
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.jn
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (io5.g(getType()) == -1 || !(obj instanceof io5)) {
                return null;
            }
            no5 P0 = ((oo5) this.mRecAppContext).P0(1);
            if (!(P0 instanceof ko5)) {
                return null;
            }
            return ((ko5) P0).g(viewGroup, ((io5) obj).a());
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.jn
    public void onFillViewHolder(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof io5)) {
            return;
        }
        no5 P0 = ((oo5) this.mRecAppContext).P0(1);
        if (!(P0 instanceof ko5)) {
            return;
        }
        ((ko5) P0).n(i, viewGroup, viewHolder, ((io5) obj).a());
    }

    public void setTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            no5 P0 = ((oo5) this.mRecAppContext).P0(1);
            if (!(P0 instanceof ko5)) {
                return;
            }
            ((ko5) P0).p(str);
        }
    }
}
