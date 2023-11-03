package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b06;
import com.baidu.tieba.d06;
import com.baidu.tieba.g06;
import com.baidu.tieba.h06;
import com.baidu.tieba.l06;
import com.baidu.tieba.uca;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsFeedAdAdapter extends l06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uca mRecAppContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsFeedAdAdapter(uca ucaVar, BdUniqueId bdUniqueId) {
        super(ucaVar.H().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ucaVar, bdUniqueId};
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
        this.mRecAppContext = ucaVar;
    }

    @Override // com.baidu.tieba.l06, com.baidu.tieba.bi
    public View getView(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof b06)) {
                return null;
            }
            b06 b06Var = (b06) obj;
            g06 H1 = ((h06) this.mRecAppContext).H1(1);
            if (!(H1 instanceof d06)) {
                return null;
            }
            return ((d06) H1).m(i, view2, viewGroup, b06Var.a());
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.bi
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (b06.e(getType()) == -1 || !(obj instanceof b06)) {
                return null;
            }
            g06 H1 = ((h06) this.mRecAppContext).H1(1);
            if (!(H1 instanceof d06)) {
                return null;
            }
            return ((d06) H1).g(viewGroup, ((b06) obj).a());
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.bi
    public void onFillViewHolder(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof b06)) {
            return;
        }
        g06 H1 = ((h06) this.mRecAppContext).H1(1);
        if (!(H1 instanceof d06)) {
            return;
        }
        ((d06) H1).n(i, viewGroup, viewHolder, ((b06) obj).a());
    }

    public void setTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            g06 H1 = ((h06) this.mRecAppContext).H1(1);
            if (!(H1 instanceof d06)) {
                return;
            }
            ((d06) H1).p(str);
        }
    }
}
