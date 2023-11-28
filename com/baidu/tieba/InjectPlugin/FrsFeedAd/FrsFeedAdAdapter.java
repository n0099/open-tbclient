package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.j06;
import com.baidu.tieba.l06;
import com.baidu.tieba.nha;
import com.baidu.tieba.o06;
import com.baidu.tieba.p06;
import com.baidu.tieba.t06;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsFeedAdAdapter extends t06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nha mRecAppContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsFeedAdAdapter(nha nhaVar, BdUniqueId bdUniqueId) {
        super(nhaVar.I().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nhaVar, bdUniqueId};
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
        this.mRecAppContext = nhaVar;
    }

    @Override // com.baidu.tieba.t06, com.baidu.tieba.ci
    public View getView(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof j06)) {
                return null;
            }
            j06 j06Var = (j06) obj;
            o06 T1 = ((p06) this.mRecAppContext).T1(1);
            if (!(T1 instanceof l06)) {
                return null;
            }
            return ((l06) T1).m(i, view2, viewGroup, j06Var.a());
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.ci
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (j06.e(getType()) == -1 || !(obj instanceof j06)) {
                return null;
            }
            o06 T1 = ((p06) this.mRecAppContext).T1(1);
            if (!(T1 instanceof l06)) {
                return null;
            }
            return ((l06) T1).g(viewGroup, ((j06) obj).a());
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ci
    public void onFillViewHolder(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof j06)) {
            return;
        }
        o06 T1 = ((p06) this.mRecAppContext).T1(1);
        if (!(T1 instanceof l06)) {
            return;
        }
        ((l06) T1).n(i, viewGroup, viewHolder, ((j06) obj).a());
    }

    public void setTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            o06 T1 = ((p06) this.mRecAppContext).T1(1);
            if (!(T1 instanceof l06)) {
                return;
            }
            ((l06) T1).p(str);
        }
    }
}
