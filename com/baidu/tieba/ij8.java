package com.baidu.tieba;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.view.TbImageAutoSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ij8 implements qj8 {
    public static /* synthetic */ Interceptable $ic;
    public static int A;
    public static int B;
    public static final int y;
    public static int z;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;
    public RelativeLayout b;
    public RelativeLayout c;
    public View d;
    public LinearLayout e;
    public TextView f;
    public TextView g;
    public ImageView h;
    public RecyclerView i;
    public View j;
    public View k;
    public View l;
    public TextView m;
    public LinearLayout n;
    public ImageView o;
    public EMTextView p;
    public LinearLayout q;
    public ImageView r;
    public EMTextView s;
    public RelativeLayout t;
    public RelativeLayout u;
    public RelativeLayout v;
    public TbImageAutoSwitch w;
    public HeadImageView x;

    @Override // com.baidu.tieba.qj8
    public void d(@NonNull String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, str, j) == null) {
        }
    }

    @Override // com.baidu.tieba.qj8
    public TextView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj8
    public LinearLayout u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return null;
        }
        return (LinearLayout) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947855538, "Lcom/baidu/tieba/ij8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947855538, "Lcom/baidu/tieba/ij8;");
                return;
            }
        }
        y = yi.g(TbadkApplication.getInst(), R.dimen.tbds600);
        z = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds56);
        A = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2);
        B = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds20);
    }

    public ij8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.qj8
    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj8
    public LinearLayout c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj8
    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj8
    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj8
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return B;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.qj8
    public HeadImageView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.x;
        }
        return (HeadImageView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj8
    @NonNull
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return A;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.qj8
    @NonNull
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return z;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.qj8
    public LinearLayout k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.q;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj8
    public LinearLayout l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.n;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj8
    public RelativeLayout m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.u;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj8
    @Nullable
    public RecyclerView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.i;
        }
        return (RecyclerView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj8
    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return y;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.qj8
    public RelativeLayout p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.c;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj8
    public RelativeLayout r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.t;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qj8
    public TbImageAutoSwitch s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.w;
        }
        return (TbImageAutoSwitch) invokeV.objValue;
    }

    public static ij8 v(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            GreyUtil.grey(view2);
            ij8 ij8Var = new ij8();
            ij8Var.a = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e81);
            ij8Var.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090ea1);
            ij8Var.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e85);
            ij8Var.d = view2.findViewById(R.id.obfuscated_res_0x7f090edb);
            ij8Var.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e87);
            ij8Var.t = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09193d);
            ij8Var.u = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091946);
            ij8Var.j = view2.findViewById(R.id.obfuscated_res_0x7f090ea2);
            ij8Var.h = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e9e);
            ij8Var.k = view2.findViewById(R.id.obfuscated_res_0x7f09117d);
            ij8Var.l = view2.findViewById(R.id.obfuscated_res_0x7f091523);
            ij8Var.i = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090e84);
            ij8Var.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e90);
            ij8Var.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e7a);
            ij8Var.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091bdf);
            ij8Var.n = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090805);
            ij8Var.o = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090807);
            ij8Var.p = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090806);
            ij8Var.q = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0916a6);
            ij8Var.r = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0916a8);
            ij8Var.s = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f0916a7);
            ij8Var.v = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09077c);
            ij8Var.w = (TbImageAutoSwitch) view2.findViewById(R.id.obfuscated_res_0x7f09077d);
            ij8Var.x = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090781);
            return ij8Var;
        }
        return (ij8) invokeL.objValue;
    }

    @Override // com.baidu.tieba.qj8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            d85.d(this.a).o(R.string.deprecated_J_X18);
            d85 d = d85.d(this.j);
            d.n(0);
            d.o(R.string.J_X03);
            d.f(R.color.CAM_X0618);
            d85 d2 = d85.d(this.k);
            d2.o(R.string.deprecated_J_X18);
            d2.f(R.color.CAM_X0201);
            d85 d3 = d85.d(this.f);
            d3.x(R.color.CAM_X0101);
            d3.C(R.dimen.T_X04);
            d3.D(R.string.F_X02);
            d85 d4 = d85.d(this.g);
            d4.x(R.color.CAM_X0102);
            d4.C(R.dimen.T_X12);
            d4.D(R.string.F_X01);
            d85.d(this.b).o(R.string.deprecated_J_X18);
            SkinManager.setBackgroundResource(this.h, R.drawable.obfuscated_res_0x7f08070e);
            d85.d(this.c).o(R.string.deprecated_J_X18);
            d85 d5 = d85.d(this.m);
            d5.C(R.dimen.T_X07);
            d5.D(R.string.F_X02);
            d5.x(R.color.CAM_X0105);
            d85 d6 = d85.d(this.p);
            d6.C(R.dimen.T_X12);
            d6.D(R.string.F_X01);
            d6.x(R.color.CAM_X0105);
            d85 d7 = d85.d(this.s);
            d7.C(R.dimen.T_X12);
            d7.D(R.string.F_X01);
            d7.x(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.o, R.drawable.obfuscated_res_0x7f080554, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
            WebPManager.setPureDrawable(this.r, R.drawable.obfuscated_res_0x7f080f63, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
        }
    }

    @Override // com.baidu.tieba.qj8
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.l.getLayoutParams().height = i;
        }
    }

    @Override // com.baidu.tieba.qj8
    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.k.getLayoutParams().height = i;
        }
    }
}
