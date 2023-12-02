package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n06;
import com.baidu.tieba.p06;
import com.baidu.tieba.rha;
import com.baidu.tieba.s06;
import com.baidu.tieba.t06;
import com.baidu.tieba.x06;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsFeedAdAdapter extends x06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rha mRecAppContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsFeedAdAdapter(rha rhaVar, BdUniqueId bdUniqueId) {
        super(rhaVar.I().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rhaVar, bdUniqueId};
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
        this.mRecAppContext = rhaVar;
    }

    @Override // com.baidu.tieba.x06, com.baidu.tieba.ci
    public View getView(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof n06)) {
                return null;
            }
            n06 n06Var = (n06) obj;
            s06 T1 = ((t06) this.mRecAppContext).T1(1);
            if (!(T1 instanceof p06)) {
                return null;
            }
            return ((p06) T1).m(i, view2, viewGroup, n06Var.a());
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.ci
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (n06.e(getType()) == -1 || !(obj instanceof n06)) {
                return null;
            }
            s06 T1 = ((t06) this.mRecAppContext).T1(1);
            if (!(T1 instanceof p06)) {
                return null;
            }
            return ((p06) T1).g(viewGroup, ((n06) obj).a());
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ci
    public void onFillViewHolder(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof n06)) {
            return;
        }
        s06 T1 = ((t06) this.mRecAppContext).T1(1);
        if (!(T1 instanceof p06)) {
            return;
        }
        ((p06) T1).n(i, viewGroup, viewHolder, ((n06) obj).a());
    }

    public void setTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            s06 T1 = ((t06) this.mRecAppContext).T1(1);
            if (!(T1 instanceof p06)) {
                return;
            }
            ((p06) T1).p(str);
        }
    }
}
