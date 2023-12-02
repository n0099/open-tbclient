package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.tieba.vya;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class TbSettingTextTipView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public boolean b;
    public LinearLayout c;
    public TextView d;
    public TextView e;
    public int f;
    public ImageView g;

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbSettingTextTipView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = true;
        this.a = context;
        d();
        e(null);
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            TextView textView = this.e;
            int i2 = this.f;
            if (i2 == 0) {
                i2 = R.color.CAM_X0109;
            }
            SkinManager.setViewTextColor(textView, i2);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            EMManager.from(this).setBackGroundSelectorColor(R.color.CAM_X0205);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = true;
        this.a = context;
        d();
        e(attributeSet);
    }

    private void setMainTextSize(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65538, this, f) == null) {
            this.d.setTextSize(0, f);
        }
    }

    private void setTipTextSize(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65539, this, f) == null) {
            this.e.setTextSize(0, f);
        }
    }

    public void setText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.d.setText(i);
        }
    }

    public void setTip(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.e.setText(str);
        }
    }

    public void setTipViewColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f = i;
            SkinManager.setViewTextColor(this.e, i);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int dimens = BdUtilHelper.getDimens(this.a, R.dimen.tbds42);
            int dimens2 = BdUtilHelper.getDimens(this.a, R.dimen.tbds33);
            setMainTextSize(dimens);
            setTipTextSize(dimens2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.d.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
            ((LinearLayout.LayoutParams) this.e.getLayoutParams()).setMargins(0, 0, BdUtilHelper.getDimens(this.a, R.dimen.tbds18), 0);
            this.c.getLayoutParams().height = -1;
            requestLayout();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.tb_setting_text_tip_view, (ViewGroup) this, true);
            this.c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0907f7);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f09257c);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f092658);
            this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f0902f7);
        }
    }

    public void b() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (textView = this.e) != null) {
            textView.setVisibility(0);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g.setVisibility(8);
        }
    }

    public CharSequence getTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e.getText();
        }
        return (CharSequence) invokeV.objValue;
    }

    public void e(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(attributeSet, vya.TbSettingView);
            if (obtainStyledAttributes != null) {
                String string = obtainStyledAttributes.getString(1);
                String string2 = obtainStyledAttributes.getString(4);
                if (string != null) {
                    this.d.setText(string);
                }
                if (string2 != null) {
                    this.e.setText(string2);
                }
                this.b = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
            this.c.setClickable(false);
            this.c.setFocusable(false);
            if (!this.b) {
                this.g.setVisibility(4);
            }
        }
    }

    public void h(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4) != null) || this.e == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i, i2, i3, i4);
        this.e.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.d.setText(str);
        }
    }
}
