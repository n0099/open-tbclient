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
import c.a.d.f.p.n;
import c.a.o0.r.v.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
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

    /* renamed from: b  reason: collision with root package name */
    public boolean f30427b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f30428c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f30429d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f30430e;

    /* renamed from: f  reason: collision with root package name */
    public int f30431f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f30432g;

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
        this.f30427b = true;
        this.a = context;
        d();
        e(attributeSet);
    }

    private void setMainTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65538, this, f2) == null) {
            this.f30429d.setTextSize(0, f2);
        }
    }

    private void setTipTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65539, this, f2) == null) {
            this.f30430e.setTextSize(0, f2);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int f2 = n.f(this.a, R.dimen.tbds42);
            int f3 = n.f(this.a, R.dimen.tbds33);
            setMainTextSize(f2);
            setTipTextSize(f3);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30429d.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
            ((LinearLayout.LayoutParams) this.f30430e.getLayoutParams()).setMargins(0, 0, n.f(this.a, R.dimen.tbds18), 0);
            this.f30428c.getLayoutParams().height = -1;
            requestLayout();
        }
    }

    public void b() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.f30430e) == null) {
            return;
        }
        textView.setVisibility(0);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f30432g.setVisibility(8);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0814, (ViewGroup) this, true);
            this.f30428c = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0906c9);
            this.f30429d = (TextView) findViewById(R.id.obfuscated_res_0x7f091f1b);
            this.f30430e = (TextView) findViewById(R.id.obfuscated_res_0x7f092002);
            this.f30432g = (ImageView) findViewById(R.id.obfuscated_res_0x7f0902a4);
        }
    }

    public void e(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040543, R.attr.obfuscated_res_0x7f040544, R.attr.obfuscated_res_0x7f040545, R.attr.obfuscated_res_0x7f040546, R.attr.obfuscated_res_0x7f040547, R.attr.obfuscated_res_0x7f040548});
            if (obtainStyledAttributes != null) {
                String string = obtainStyledAttributes.getString(1);
                String string2 = obtainStyledAttributes.getString(4);
                if (string != null) {
                    this.f30429d.setText(string);
                }
                if (string2 != null) {
                    this.f30430e.setText(string2);
                }
                this.f30427b = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
            this.f30428c.setClickable(false);
            this.f30428c.setFocusable(false);
            if (this.f30427b) {
                return;
            }
            this.f30432g.setVisibility(4);
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
            SkinManager.setViewTextColor(this.f30429d, (int) R.color.CAM_X0105);
            TextView textView = this.f30430e;
            int i2 = this.f30431f;
            if (i2 == 0) {
                i2 = R.color.CAM_X0109;
            }
            SkinManager.setViewTextColor(textView, i2);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f30432g, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            c.d(this).f(R.color.CAM_X0205);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public CharSequence getTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f30430e.getText() : (CharSequence) invokeV.objValue;
    }

    public void h(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4) == null) || this.f30430e == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i, i2, i3, i4);
        this.f30430e.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f30429d.setText(str);
        }
    }

    public void setTip(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f30430e.setText(str);
        }
    }

    public void setTipViewColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f30431f = i;
            SkinManager.setViewTextColor(this.f30430e, i);
        }
    }

    public void setText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.f30429d.setText(i);
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
        this.f30427b = true;
        this.a = context;
        d();
        e(null);
    }
}
