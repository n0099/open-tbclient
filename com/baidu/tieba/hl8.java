package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hl8 implements jl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;
    public TextView b;
    public ImageView c;
    public RecyclerView d;
    public hl8 e;

    public hl8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.jl8
    public RelativeLayout a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e.a;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jl8
    public RecyclerView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e.d;
        }
        return (RecyclerView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jl8
    public ImageView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e.c;
        }
        return (ImageView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jl8
    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e.b;
        }
        return (TextView) invokeV.objValue;
    }

    public static hl8 f(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            hl8 hl8Var = new hl8();
            hl8Var.a = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0918bd);
            hl8Var.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090eaf);
            hl8Var.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090ecb);
            hl8Var.d = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090ebc);
            hl8Var.e = hl8Var;
            return hl8Var;
        }
        return (hl8) invokeL.objValue;
    }

    @Override // com.baidu.tieba.jl8
    public void b(int i, @NonNull am8 am8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, am8Var) == null) && !am8Var.e()) {
            EMManager.from(this.e.b).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0107);
        }
    }
}
