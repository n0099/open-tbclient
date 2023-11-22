package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c06;
import com.baidu.tieba.e06;
import com.baidu.tieba.h06;
import com.baidu.tieba.i06;
import com.baidu.tieba.m06;
import com.baidu.tieba.vca;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsFeedAdAdapter extends m06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vca mRecAppContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsFeedAdAdapter(vca vcaVar, BdUniqueId bdUniqueId) {
        super(vcaVar.H().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vcaVar, bdUniqueId};
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
        this.mRecAppContext = vcaVar;
    }

    @Override // com.baidu.tieba.m06, com.baidu.tieba.bi
    public View getView(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof c06)) {
                return null;
            }
            c06 c06Var = (c06) obj;
            h06 H1 = ((i06) this.mRecAppContext).H1(1);
            if (!(H1 instanceof e06)) {
                return null;
            }
            return ((e06) H1).m(i, view2, viewGroup, c06Var.a());
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.bi
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (c06.e(getType()) == -1 || !(obj instanceof c06)) {
                return null;
            }
            h06 H1 = ((i06) this.mRecAppContext).H1(1);
            if (!(H1 instanceof e06)) {
                return null;
            }
            return ((e06) H1).g(viewGroup, ((c06) obj).a());
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.bi
    public void onFillViewHolder(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof c06)) {
            return;
        }
        h06 H1 = ((i06) this.mRecAppContext).H1(1);
        if (!(H1 instanceof e06)) {
            return;
        }
        ((e06) H1).n(i, viewGroup, viewHolder, ((c06) obj).a());
    }

    public void setTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            h06 H1 = ((i06) this.mRecAppContext).H1(1);
            if (!(H1 instanceof e06)) {
                return;
            }
            ((e06) H1).p(str);
        }
    }
}
