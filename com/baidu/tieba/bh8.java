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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
/* loaded from: classes5.dex */
public class bh8 implements jh8 {
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

    @Override // com.baidu.tieba.jh8
    public void d(@NonNull String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, str, j) == null) {
        }
    }

    @Override // com.baidu.tieba.jh8
    public TextView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947645079, "Lcom/baidu/tieba/bh8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947645079, "Lcom/baidu/tieba/bh8;");
                return;
            }
        }
        y = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds600);
        z = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds56);
        A = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2);
        B = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds20);
    }

    public bh8() {
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

    @Override // com.baidu.tieba.jh8
    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    public LinearLayout c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return B;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.jh8
    public HeadImageView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.x;
        }
        return (HeadImageView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    @NonNull
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return A;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.jh8
    @NonNull
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return z;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.jh8
    public LinearLayout k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.q;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    public LinearLayout l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.n;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    public RelativeLayout m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.u;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    @Nullable
    public RecyclerView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.i;
        }
        return (RecyclerView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return y;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.jh8
    public RelativeLayout p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.c;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    public RelativeLayout r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.t;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jh8
    public TbImageAutoSwitch s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.w;
        }
        return (TbImageAutoSwitch) invokeV.objValue;
    }

    public static bh8 v(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            GreyUtil.grey(view2);
            bh8 bh8Var = new bh8();
            bh8Var.a = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e93);
            bh8Var.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090eb3);
            bh8Var.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e97);
            bh8Var.d = view2.findViewById(R.id.obfuscated_res_0x7f090eed);
            bh8Var.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e99);
            bh8Var.t = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091951);
            bh8Var.u = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09195a);
            bh8Var.j = view2.findViewById(R.id.obfuscated_res_0x7f090eb4);
            bh8Var.h = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090eb0);
            bh8Var.k = view2.findViewById(R.id.obfuscated_res_0x7f091190);
            bh8Var.l = view2.findViewById(R.id.obfuscated_res_0x7f091536);
            bh8Var.i = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090e96);
            bh8Var.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ea2);
            bh8Var.e = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e8c);
            bh8Var.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091bfb);
            bh8Var.n = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090814);
            bh8Var.o = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090816);
            bh8Var.p = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f090815);
            bh8Var.q = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0916ba);
            bh8Var.r = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0916bc);
            bh8Var.s = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f0916bb);
            bh8Var.v = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f09078b);
            bh8Var.w = (TbImageAutoSwitch) view2.findViewById(R.id.obfuscated_res_0x7f09078c);
            bh8Var.x = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090790);
            return bh8Var;
        }
        return (bh8) invokeL.objValue;
    }

    @Override // com.baidu.tieba.jh8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            EMManager.from(this.a).setCorner(R.string.deprecated_J_X18);
            EMManager.from(this.j).setCardType(0).setCorner(R.string.J_X03).setBackGroundColor(R.color.CAM_X0618);
            EMManager.from(this.k).setCorner(R.string.deprecated_J_X18).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.f).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X04).setTextStyle(R.string.F_X02);
            EMManager.from(this.g).setTextColor(R.color.CAM_X0102).setTextSize(R.dimen.T_X12).setTextStyle(R.string.F_X01);
            EMManager.from(this.b).setCorner(R.string.deprecated_J_X18);
            SkinManager.setBackgroundResource(this.h, R.drawable.obfuscated_res_0x7f08070e);
            EMManager.from(this.c).setCorner(R.string.deprecated_J_X18);
            EMManager.from(this.m).setTextSize(R.dimen.T_X07).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.p).setTextSize(R.dimen.T_X12).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.s).setTextSize(R.dimen.T_X12).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.o, R.drawable.obfuscated_res_0x7f080554, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
            WebPManager.setPureDrawable(this.r, R.drawable.obfuscated_res_0x7f080f6b, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
        }
    }

    @Override // com.baidu.tieba.jh8
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.l.getLayoutParams().height = i;
        }
    }

    @Override // com.baidu.tieba.jh8
    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.k.getLayoutParams().height = i;
        }
    }
}
