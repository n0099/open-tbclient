package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ap5;
import com.baidu.tieba.dg8;
import com.baidu.tieba.ep5;
import com.baidu.tieba.uo5;
import com.baidu.tieba.wo5;
import com.baidu.tieba.zo5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class FrsFeedAdAdapter extends ep5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dg8 mRecAppContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsFeedAdAdapter(dg8 dg8Var, BdUniqueId bdUniqueId) {
        super(dg8Var.o().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dg8Var, bdUniqueId};
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
        this.mRecAppContext = dg8Var;
    }

    @Override // com.baidu.tieba.ep5, com.baidu.tieba.kn
    public View getView(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof uo5)) {
                return null;
            }
            uo5 uo5Var = (uo5) obj;
            zo5 P0 = ((ap5) this.mRecAppContext).P0(1);
            if (!(P0 instanceof wo5)) {
                return null;
            }
            return ((wo5) P0).m(i, view2, viewGroup, uo5Var.a());
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.kn
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (uo5.g(getType()) == -1 || !(obj instanceof uo5)) {
                return null;
            }
            zo5 P0 = ((ap5) this.mRecAppContext).P0(1);
            if (!(P0 instanceof wo5)) {
                return null;
            }
            return ((wo5) P0).g(viewGroup, ((uo5) obj).a());
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.kn
    public void onFillViewHolder(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof uo5)) {
            return;
        }
        zo5 P0 = ((ap5) this.mRecAppContext).P0(1);
        if (!(P0 instanceof wo5)) {
            return;
        }
        ((wo5) P0).n(i, viewGroup, viewHolder, ((uo5) obj).a());
    }

    public void setTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            zo5 P0 = ((ap5) this.mRecAppContext).P0(1);
            if (!(P0 instanceof wo5)) {
                return;
            }
            ((wo5) P0).p(str);
        }
    }
}
