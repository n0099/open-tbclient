package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ax5;
import com.baidu.tieba.dx5;
import com.baidu.tieba.ex5;
import com.baidu.tieba.ix5;
import com.baidu.tieba.sa9;
import com.baidu.tieba.yw5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class FrsFeedAdAdapter extends ix5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sa9 mRecAppContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsFeedAdAdapter(sa9 sa9Var, BdUniqueId bdUniqueId) {
        super(sa9Var.q().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sa9Var, bdUniqueId};
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
        this.mRecAppContext = sa9Var;
    }

    @Override // com.baidu.tieba.ix5, com.baidu.tieba.um
    public View getView(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof yw5)) {
                return null;
            }
            yw5 yw5Var = (yw5) obj;
            dx5 b1 = ((ex5) this.mRecAppContext).b1(1);
            if (!(b1 instanceof ax5)) {
                return null;
            }
            return ((ax5) b1).m(i, view2, viewGroup, yw5Var.a());
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.um
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (yw5.e(getType()) == -1 || !(obj instanceof yw5)) {
                return null;
            }
            dx5 b1 = ((ex5) this.mRecAppContext).b1(1);
            if (!(b1 instanceof ax5)) {
                return null;
            }
            return ((ax5) b1).g(viewGroup, ((yw5) obj).a());
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.um
    public void onFillViewHolder(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof yw5)) {
            return;
        }
        dx5 b1 = ((ex5) this.mRecAppContext).b1(1);
        if (!(b1 instanceof ax5)) {
            return;
        }
        ((ax5) b1).n(i, viewGroup, viewHolder, ((yw5) obj).a());
    }

    public void setTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            dx5 b1 = ((ex5) this.mRecAppContext).b1(1);
            if (!(b1 instanceof ax5)) {
                return;
            }
            ((ax5) b1).p(str);
        }
    }
}
