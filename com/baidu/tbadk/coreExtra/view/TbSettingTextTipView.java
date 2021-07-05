package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class TbSettingTextTipView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f12900e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12901f;

    /* renamed from: g  reason: collision with root package name */
    public View f12902g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f12903h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f12904i;
    public TextView j;
    public int k;
    public ImageView l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbSettingTextTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f12901f = true;
        this.f12900e = context;
        d();
        e(attributeSet);
    }

    private void setMainTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65538, this, f2) == null) {
            this.f12904i.setTextSize(0, f2);
        }
    }

    private void setTipTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65539, this, f2) == null) {
            this.j.setTextSize(0, f2);
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int g2 = l.g(this.f12900e, R.dimen.tbds42);
            int g3 = l.g(this.f12900e, R.dimen.tbds33);
            setMainTextSize(g2);
            setTipTextSize(g3);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f12904i.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
            ((LinearLayout.LayoutParams) this.j.getLayoutParams()).setMargins(0, 0, l.g(this.f12900e, R.dimen.tbds18), 0);
            this.f12903h.getLayoutParams().height = -1;
            requestLayout();
        }
    }

    public void b() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.j) == null) {
            return;
        }
        textView.setVisibility(0);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.l.setVisibility(8);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LayoutInflater.from(this.f12900e).inflate(R.layout.tb_setting_text_tip_view, (ViewGroup) this, true);
            this.f12903h = (LinearLayout) findViewById(R.id.container);
            this.f12904i = (TextView) findViewById(R.id.text);
            this.j = (TextView) findViewById(R.id.tip);
            this.l = (ImageView) findViewById(R.id.arrow2);
            this.f12902g = findViewById(R.id.top_line_ll);
        }
    }

    public void e(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = this.f12900e.obtainStyledAttributes(attributeSet, R$styleable.TbSettingView);
            if (obtainStyledAttributes != null) {
                String string = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingText);
                String string2 = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingTip);
                if (string != null) {
                    this.f12904i.setText(string);
                }
                if (string2 != null) {
                    this.j.setText(string2);
                }
                this.f12901f = obtainStyledAttributes.getBoolean(R$styleable.TbSettingView_settingShowArraw, true);
                obtainStyledAttributes.recycle();
            }
            this.f12903h.setClickable(false);
            this.f12903h.setFocusable(false);
            if (this.f12901f) {
                return;
            }
            this.l.setVisibility(4);
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f12902g, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.f12904i, R.color.CAM_X0105);
            TextView textView = this.j;
            int i3 = this.k;
            if (i3 == 0) {
                i3 = R.color.CAM_X0109;
            }
            SkinManager.setViewTextColor(textView, i3);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            LinearLayout linearLayout = this.f12903h;
            if (linearLayout != null) {
                linearLayout.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
            }
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j.getText() : (CharSequence) invokeV.objValue;
    }

    public void h(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5) == null) || this.j == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i2, i3, i4, i5);
        this.j.setLayoutParams(layoutParams);
    }

    public void setBottomLineVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.f12904i.setText(str);
        }
    }

    public void setTip(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.j.setText(str);
        }
    }

    public void setTipBackground(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, drawable) == null) {
            this.j.setBackgroundDrawable(drawable);
        }
    }

    public void setTipColor(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (textView = this.j) == null) {
            return;
        }
        textView.setTextColor(i2);
    }

    public void setTipStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
        }
    }

    public void setTipViewColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.k = i2;
            SkinManager.setViewTextColor(this.j, i2);
        }
    }

    @Deprecated
    public void setTopLineVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f12902g.setVisibility(8);
        }
    }

    public void setText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f12904i.setText(i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12901f = true;
        this.f12900e = context;
        d();
    }
}
