package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fm9;
import com.baidu.tieba.o36;
import com.baidu.tieba.q36;
import com.baidu.tieba.t36;
import com.baidu.tieba.u36;
import com.baidu.tieba.y36;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FrsFeedAdAdapter extends y36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fm9 mRecAppContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsFeedAdAdapter(fm9 fm9Var, BdUniqueId bdUniqueId) {
        super(fm9Var.t().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fm9Var, bdUniqueId};
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
        this.mRecAppContext = fm9Var;
    }

    @Override // com.baidu.tieba.y36, com.baidu.tieba.in
    public View getView(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof o36)) {
                return null;
            }
            o36 o36Var = (o36) obj;
            t36 d1 = ((u36) this.mRecAppContext).d1(1);
            if (!(d1 instanceof q36)) {
                return null;
            }
            return ((q36) d1).m(i, view2, viewGroup, o36Var.a());
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.in
    public TypeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, obj)) == null) {
            if (o36.e(getType()) == -1 || !(obj instanceof o36)) {
                return null;
            }
            t36 d1 = ((u36) this.mRecAppContext).d1(1);
            if (!(d1 instanceof q36)) {
                return null;
            }
            return ((q36) d1).g(viewGroup, ((o36) obj).a());
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.in
    public void onFillViewHolder(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof o36)) {
            return;
        }
        t36 d1 = ((u36) this.mRecAppContext).d1(1);
        if (!(d1 instanceof q36)) {
            return;
        }
        ((q36) d1).n(i, viewGroup, viewHolder, ((o36) obj).a());
    }

    public void setTab(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            t36 d1 = ((u36) this.mRecAppContext).d1(1);
            if (!(d1 instanceof q36)) {
                return;
            }
            ((q36) d1).p(str);
        }
    }
}
