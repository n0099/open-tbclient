package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbCornersImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gh8 implements hh8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int n;
    public static final int o;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;
    public FrameLayout b;
    public FrameLayout c;
    public HeadImageView d;
    public TbCornersImageView e;
    public BarImageView f;
    public RelativeLayout g;
    public TextView h;
    public TextView i;
    public TextView j;
    public LinearLayout k;
    public TextView l;
    public gh8 m;

    @Override // com.baidu.tieba.hh8
    public void a(@NonNull ci8 ci8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ci8Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947794034, "Lcom/baidu/tieba/gh8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947794034, "Lcom/baidu/tieba/gh8;");
                return;
            }
        }
        n = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds4);
        o = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds450);
    }

    public gh8() {
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

    @Override // com.baidu.tieba.hh8
    public HeadImageView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.m.d;
        }
        return (HeadImageView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hh8
    public TextView c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.m.l;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hh8
    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.m.i;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hh8
    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.m.j;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hh8
    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.m.h;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hh8
    public FrameLayout g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.m.c;
        }
        return (FrameLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hh8
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return o;
        }
        return invokeV.intValue;
    }

    public static gh8 k(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, view2)) == null) {
            gh8 gh8Var = new gh8();
            gh8Var.c = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e98);
            gh8Var.a = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e94);
            gh8Var.b = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090eb9);
            gh8Var.d = (HeadImageView) view2.findViewById(R.id.chat_head);
            gh8Var.e = (TbCornersImageView) view2.findViewById(R.id.svg_head);
            gh8Var.f = (BarImageView) view2.findViewById(R.id.forum_head);
            gh8Var.g = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e85);
            gh8Var.h = (TextView) view2.findViewById(R.id.chat_name);
            gh8Var.i = (TextView) view2.findViewById(R.id.last_chat_content);
            gh8Var.j = (TextView) view2.findViewById(R.id.new_message);
            gh8Var.k = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e87);
            gh8Var.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0906b8);
            gh8Var.m = gh8Var;
            return gh8Var;
        }
        return (gh8) invokeL.objValue;
    }

    @Override // com.baidu.tieba.hh8
    public void h(@NonNull ci8 ci8Var) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ci8Var) == null) {
            EMManager.from(this.m.h).setTextSize(R.dimen.T_X07).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0105);
            if (ci8Var.a() != null && ci8Var.a().isLocationScrolled()) {
                i = R.color.CAM_X0313;
                i2 = R.string.A_X03;
            } else {
                i = R.color.CAM_X0201;
                i2 = R.string.A_X06;
            }
            EMManager.from(this.m.a).setCorner(R.string.J_X06).setAlpha(i2).setBackGroundColor(i);
            EMManager.from(this.m.j).setTextSize(R.dimen.T_X10).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0108);
            EMManager.from(this.m.i).setTextColor(R.color.CAM_X0108).setTextSize(R.dimen.T_X08);
            this.m.d.setBorderWidth(n);
            this.m.d.setBorderColor(SkinManager.getColor(R.color.CAM_X0211));
            this.m.d.setIsRound(true);
            this.m.d.setDrawBorder(true);
            this.m.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.m.d.setPlaceHolder(1);
            this.m.d.setDrawBorder(true);
            EMManager.from(this.m.l).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0301);
        }
    }

    @Override // com.baidu.tieba.hh8
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.m.i.setMaxLines(1);
            this.m.i.setEllipsize(TextUtils.TruncateAt.END);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, R.id.chat_name);
            layoutParams.topMargin = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.M_H_X001);
            layoutParams.bottomMargin = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.M_H_X001);
            layoutParams.rightMargin = BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds162);
            this.m.k.setLayoutParams(layoutParams);
        }
    }
}
