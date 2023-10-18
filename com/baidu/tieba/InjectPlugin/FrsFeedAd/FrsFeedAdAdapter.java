package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.hy5;
import com.baidu.tieba.jy5;
import com.baidu.tieba.my5;
import com.baidu.tieba.ny5;
import com.baidu.tieba.pz9;
import com.baidu.tieba.ry5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FrsFeedAdAdapter extends ry5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public pz9 mRecAppContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsFeedAdAdapter(pz9 pz9Var, BdUniqueId bdUniqueId) {
        super(pz9Var.D().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pz9Var, bdUniqueId};
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
        this.mRecAppContext = pz9Var;
    }

    @Override // com.baidu.tieba.ry5, com.baidu.tieba.lh
    public View getView(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof hy5)) {
                return null;
            }
            hy5 hy5Var = (hy5) obj;
            my5 t1 = ((ny5) this.mRecAppContext).t1(1);
            if (!(t1 instanceof jy5)) {
                return null;
            }
            return ((jy5) t1).m(i, view2, viewGroup, hy5Var.a());
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.lh
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (hy5.e(getType()) == -1 || !(obj instanceof hy5)) {
                return null;
            }
            my5 t1 = ((ny5) this.mRecAppContext).t1(1);
            if (!(t1 instanceof jy5)) {
                return null;
            }
            return ((jy5) t1).g(viewGroup, ((hy5) obj).a());
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.lh
    public void onFillViewHolder(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof hy5)) {
            return;
        }
        my5 t1 = ((ny5) this.mRecAppContext).t1(1);
        if (!(t1 instanceof jy5)) {
            return;
        }
        ((jy5) t1).n(i, viewGroup, viewHolder, ((hy5) obj).a());
    }

    public void setTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            my5 t1 = ((ny5) this.mRecAppContext).t1(1);
            if (!(t1 instanceof jy5)) {
                return;
            }
            ((jy5) t1).p(str);
        }
    }
}
