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
/* loaded from: classes5.dex */
public class am8 implements vl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;
    public TextView b;
    public ImageView c;
    public RecyclerView d;
    public am8 e;

    public am8() {
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

    @Override // com.baidu.tieba.vl8
    public RelativeLayout a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e.a;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vl8
    public RecyclerView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e.d;
        }
        return (RecyclerView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vl8
    public ImageView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e.c;
        }
        return (ImageView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vl8
    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e.b;
        }
        return (TextView) invokeV.objValue;
    }

    public static am8 f(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            am8 am8Var = new am8();
            am8Var.a = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09180e);
            am8Var.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09180d);
            am8Var.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091814);
            am8Var.d = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091826);
            am8Var.e = am8Var;
            return am8Var;
        }
        return (am8) invokeL.objValue;
    }

    @Override // com.baidu.tieba.vl8
    public void b(int i, @NonNull mm8 mm8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, mm8Var) == null) {
            if (!mm8Var.e()) {
                EMManager.from(this.e.b).setTextSize(R.dimen.T_X12).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0107);
            }
            EMManager.from(this.e.d).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.e.a).setBackGroundColor(R.color.CAM_X0201);
        }
    }
}
