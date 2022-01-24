package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.s0.s.u.c;
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
/* loaded from: classes11.dex */
public class TbSettingTextTipView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout container;
    public View dividerline;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40872e;

    /* renamed from: f  reason: collision with root package name */
    public int f40873f;
    public ImageView imageView;
    public Context mContext;
    public TextView textView;
    public TextView tipView;

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
        this.f40872e = true;
        this.mContext = context;
        initialieView();
        initializeStyle(attributeSet);
    }

    private void setMainTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65538, this, f2) == null) {
            this.textView.setTextSize(0, f2);
        }
    }

    private void setTipTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65539, this, f2) == null) {
            this.tipView.setTextSize(0, f2);
        }
    }

    public void changeStyleTo1080() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int f2 = n.f(this.mContext, R.dimen.tbds42);
            int f3 = n.f(this.mContext, R.dimen.tbds33);
            setMainTextSize(f2);
            setTipTextSize(f3);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.textView.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, 0);
            ((LinearLayout.LayoutParams) this.tipView.getLayoutParams()).setMargins(0, 0, n.f(this.mContext, R.dimen.tbds18), 0);
            this.container.getLayoutParams().height = -1;
            requestLayout();
        }
    }

    public void displayTip() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (textView = this.tipView) == null) {
            return;
        }
        textView.setVisibility(0);
    }

    public CharSequence getTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.tipView.getText() : (CharSequence) invokeV.objValue;
    }

    public void hideArrow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.imageView.setVisibility(8);
        }
    }

    public void hideTip() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (textView = this.tipView) == null) {
            return;
        }
        textView.setVisibility(8);
    }

    public void initialieView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            LayoutInflater.from(this.mContext).inflate(R.layout.tb_setting_text_tip_view, (ViewGroup) this, true);
            this.container = (LinearLayout) findViewById(R.id.container);
            this.textView = (TextView) findViewById(R.id.text);
            this.tipView = (TextView) findViewById(R.id.tip);
            this.imageView = (ImageView) findViewById(R.id.arrow2);
        }
    }

    public void initializeStyle(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R$styleable.TbSettingView);
            if (obtainStyledAttributes != null) {
                String string = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingText);
                String string2 = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingTip);
                if (string != null) {
                    this.textView.setText(string);
                }
                if (string2 != null) {
                    this.tipView.setText(string2);
                }
                this.f40872e = obtainStyledAttributes.getBoolean(R$styleable.TbSettingView_settingShowArraw, true);
                obtainStyledAttributes.recycle();
            }
            this.container.setClickable(false);
            this.container.setFocusable(false);
            if (this.f40872e) {
                return;
            }
            this.imageView.setVisibility(4);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
            SkinManager.setViewTextColor(this.textView, R.color.CAM_X0105);
            TextView textView = this.tipView;
            int i3 = this.f40873f;
            if (i3 == 0) {
                i3 = R.color.CAM_X0109;
            }
            SkinManager.setViewTextColor(textView, i3);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.imageView, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            c.d(this).f(R.color.CAM_X0205);
        }
    }

    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public void resetTipViewMargains(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048585, this, i2, i3, i4, i5) == null) || this.tipView == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(i2, i3, i4, i5);
        this.tipView.setLayoutParams(layoutParams);
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.textView.setText(str);
        }
    }

    public void setTip(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.tipView.setText(str);
        }
    }

    public void setTipViewColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f40873f = i2;
            SkinManager.setViewTextColor(this.tipView, i2);
        }
    }

    public void setText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.textView.setText(i2);
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
        this.f40872e = true;
        this.mContext = context;
        initialieView();
        initializeStyle(null);
    }
}
