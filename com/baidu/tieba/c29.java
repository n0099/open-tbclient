package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.view.TbImageAutoSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c29 implements k29 {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static int B;
    public static int C;
    public static int D;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;
    public RelativeLayout b;
    public NavigationBar c;
    public ImageView d;
    public RelativeLayout e;
    public View f;
    public LinearLayout g;
    public TextView h;
    public TextView i;
    public ImageView j;
    public RecyclerView k;
    public View l;
    public View m;
    public View n;
    public TextView o;
    public LinearLayout p;
    public ImageView q;
    public EMTextView r;
    public LinearLayout s;
    public ImageView t;
    public EMTextView u;
    public RelativeLayout v;
    public RelativeLayout w;
    public RelativeLayout x;
    public TbImageAutoSwitch y;
    public HeadImageView z;

    @Override // com.baidu.tieba.k29
    public void d(@NonNull String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, str, j) == null) {
        }
    }

    @Override // com.baidu.tieba.k29
    public TextView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k29
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947623007, "Lcom/baidu/tieba/c29;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947623007, "Lcom/baidu/tieba/c29;");
                return;
            }
        }
        A = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds600);
        B = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds56);
        C = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2);
        D = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds20);
    }

    public c29() {
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

    @Override // com.baidu.tieba.k29
    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k29
    public LinearLayout c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.g;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k29
    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.h;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k29
    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k29
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return D;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.k29
    public HeadImageView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.z;
        }
        return (HeadImageView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k29
    @NonNull
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return C;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.k29
    @NonNull
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return B;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.k29
    public LinearLayout k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.s;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k29
    public LinearLayout l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.p;
        }
        return (LinearLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k29
    public RelativeLayout m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.w;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k29
    @Nullable
    public RecyclerView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.k;
        }
        return (RecyclerView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k29
    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return A;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.k29
    public RelativeLayout p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.e;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k29
    public RelativeLayout r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.v;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k29
    public TbImageAutoSwitch s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.y;
        }
        return (TbImageAutoSwitch) invokeV.objValue;
    }

    public static c29 v(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            GreyUtil.grey(view2);
            c29 c29Var = new c29();
            c29Var.a = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090f08);
            c29Var.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090f28);
            c29Var.e = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090f0b);
            c29Var.f = view2.findViewById(R.id.obfuscated_res_0x7f090f67);
            c29Var.c = (NavigationBar) view2.findViewById(R.id.obfuscated_res_0x7f090f1a);
            c29Var.o = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f0d);
            c29Var.v = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a5f);
            c29Var.w = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a6a);
            c29Var.l = view2.findViewById(R.id.obfuscated_res_0x7f090f29);
            c29Var.j = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f25);
            c29Var.m = view2.findViewById(R.id.obfuscated_res_0x7f09121c);
            c29Var.n = view2.findViewById(R.id.obfuscated_res_0x7f09160c);
            c29Var.k = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090f0a);
            c29Var.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f17);
            c29Var.g = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090f02);
            c29Var.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cec);
            c29Var.p = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09085c);
            c29Var.q = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f09085e);
            c29Var.r = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f09085d);
            c29Var.s = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09178f);
            c29Var.t = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091791);
            c29Var.u = (EMTextView) view2.findViewById(R.id.obfuscated_res_0x7f091790);
            c29Var.x = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0907d2);
            c29Var.y = (TbImageAutoSwitch) view2.findViewById(R.id.obfuscated_res_0x7f0907d3);
            c29Var.z = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0907d7);
            w(c29Var);
            return c29Var;
        }
        return (c29) invokeL.objValue;
    }

    @Override // com.baidu.tieba.k29
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            EMManager.from(this.a).setCorner(R.string.deprecated_J_X18);
            EMManager.from(this.l).setCardType(0).setCorner(R.string.J_X03).setBackGroundColor(R.color.CAM_X0618);
            EMManager.from(this.m).setCorner(R.string.deprecated_J_X18).setBackGroundColor(R.color.CAM_X0201);
            EMManager.from(this.h).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X04).setTextStyle(R.string.F_X02);
            EMManager.from(this.i).setTextColor(R.color.CAM_X0102).setTextSize(R.dimen.T_X12).setTextStyle(R.string.F_X01);
            EMManager.from(this.b).setCorner(R.string.deprecated_J_X18);
            SkinManager.setBackgroundResource(this.j, R.drawable.obfuscated_res_0x7f080731);
            EMManager.from(this.e).setCorner(R.string.deprecated_J_X18);
            EMManager.from(this.o).setTextSize(R.dimen.T_X07).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.r).setTextSize(R.dimen.T_X12).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.u).setTextSize(R.dimen.T_X12).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0105);
            WebPManager.setPureDrawable(this.q, R.drawable.obfuscated_res_0x7f08056e, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
            WebPManager.setPureDrawable(this.t, R.drawable.obfuscated_res_0x7f080fc6, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
            if (this.d != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.d, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public static void w(c29 c29Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, c29Var) == null) {
            if (c29Var.f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) c29Var.f.getLayoutParams();
                marginLayoutParams.setMargins(0, 0, 0, -UtilHelper.getDimenPixelSize(R.dimen.tbds43));
                c29Var.f.setLayoutParams(marginLayoutParams);
            }
            if (UbsABTestHelper.isNewFrs()) {
                c29Var.c.setVisibility(0);
                c29Var.d = (ImageView) c29Var.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).findViewById(R.id.widget_navi_back_button);
                c29Var.l.setVisibility(8);
                if (c29Var.b.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) c29Var.b.getLayoutParams();
                    marginLayoutParams2.setMargins(0, 0, 0, 0);
                    c29Var.b.setLayoutParams(marginLayoutParams2);
                    return;
                }
                return;
            }
            c29Var.c.setVisibility(8);
            c29Var.l.setVisibility(0);
            if (c29Var.b.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) c29Var.b.getLayoutParams();
                marginLayoutParams3.setMargins(0, UtilHelper.getDimenPixelSize(R.dimen.tbds50), 0, 0);
                c29Var.b.setLayoutParams(marginLayoutParams3);
            }
        }
    }

    @Override // com.baidu.tieba.k29
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.n.getLayoutParams().height = i;
        }
    }

    @Override // com.baidu.tieba.k29
    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.m.getLayoutParams().height = i;
        }
    }
}
