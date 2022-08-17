package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ak5;
import com.repackage.ck5;
import com.repackage.fk5;
import com.repackage.gk5;
import com.repackage.kk5;
import com.repackage.vb8;
/* loaded from: classes3.dex */
public class FrsFeedAdAdapter extends kk5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vb8 mRecAppContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsFeedAdAdapter(vb8 vb8Var, BdUniqueId bdUniqueId) {
        super(vb8Var.o().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vb8Var, bdUniqueId};
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
        this.mRecAppContext = vb8Var;
    }

    @Override // com.repackage.kk5, com.repackage.bn
    public View getView(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (obj instanceof ak5) {
                ak5 ak5Var = (ak5) obj;
                fk5 Q0 = ((gk5) this.mRecAppContext).Q0(1);
                if (Q0 instanceof ck5) {
                    return ((ck5) Q0).m(i, view2, viewGroup, ak5Var.a());
                }
                return null;
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.bn
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (ak5.g(getType()) != -1 && (obj instanceof ak5)) {
                fk5 Q0 = ((gk5) this.mRecAppContext).Q0(1);
                if (Q0 instanceof ck5) {
                    return ((ck5) Q0).g(viewGroup, ((ak5) obj).a());
                }
                return null;
            }
            return null;
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.repackage.bn
    public void onFillViewHolder(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) == null) && (obj instanceof ak5)) {
            fk5 Q0 = ((gk5) this.mRecAppContext).Q0(1);
            if (Q0 instanceof ck5) {
                ((ck5) Q0).n(i, viewGroup, viewHolder, ((ak5) obj).a());
            }
        }
    }

    public void setTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            fk5 Q0 = ((gk5) this.mRecAppContext).Q0(1);
            if (Q0 instanceof ck5) {
                ((ck5) Q0).p(str);
            }
        }
    }
}
