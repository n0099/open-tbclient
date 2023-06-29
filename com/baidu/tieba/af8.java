package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class af8 implements ve8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;
    public TextView b;
    public ImageView c;
    public RecyclerView d;
    public af8 e;

    public af8() {
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

    @Override // com.baidu.tieba.ve8
    public RelativeLayout a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e.a;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ve8
    public RecyclerView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e.d;
        }
        return (RecyclerView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ve8
    public ImageView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e.c;
        }
        return (ImageView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ve8
    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e.b;
        }
        return (TextView) invokeV.objValue;
    }

    public static af8 f(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            af8 af8Var = new af8();
            af8Var.a = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0917b3);
            af8Var.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917b2);
            af8Var.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0917b9);
            af8Var.d = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f0917be);
            af8Var.e = af8Var;
            return af8Var;
        }
        return (af8) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ve8
    public void b(int i, @NonNull jf8 jf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, jf8Var) == null) {
            if (!jf8Var.e()) {
                s75 d = s75.d(this.e.b);
                d.C(R.dimen.T_X12);
                d.D(R.string.F_X01);
                d.x(R.color.CAM_X0107);
            }
            s75.d(this.e.d).f(R.color.CAM_X0201);
            s75.d(this.e.a).f(R.color.CAM_X0201);
        }
    }
}
