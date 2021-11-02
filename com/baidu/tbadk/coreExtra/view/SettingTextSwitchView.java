package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class SettingTextSwitchView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Context f45767e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f45768f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f45769g;

    /* renamed from: h  reason: collision with root package name */
    public BdSwitchView f45770h;
    public TextView tipView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
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
        this.f45767e = context;
        b();
        a(attributeSet);
        switchSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void a(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = this.f45767e.obtainStyledAttributes(attributeSet, R$styleable.TbSettingView);
            String string = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingText);
            int color = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTextColor, -1);
            float dimension = obtainStyledAttributes.getDimension(R$styleable.TbSettingView_settingTextSize, -1.0f);
            String string2 = obtainStyledAttributes.getString(R$styleable.TbSettingView_settingTip);
            int color2 = obtainStyledAttributes.getColor(R$styleable.TbSettingView_settingTipColor, -1);
            TextView textView = this.tipView;
            if (textView != null && string2 != null) {
                textView.setVisibility(0);
                this.tipView.setText(string2);
                if (color2 > -1) {
                    this.tipView.setTextColor(color2);
                }
            }
            if (string != null) {
                this.f45769g.setText(string);
            }
            if (color > -1) {
                this.f45769g.setTextColor(color);
            }
            if (dimension > -1.0f) {
                this.f45769g.setTextSize(0, dimension);
            }
            this.f45768f.setClickable(false);
            this.f45768f.setFocusable(false);
            obtainStyledAttributes.recycle();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(this.f45767e).inflate(R.layout.setting_text_switch_view, (ViewGroup) this, true);
            this.f45768f = (LinearLayout) findViewById(R.id.container);
            this.f45769g = (TextView) findViewById(R.id.text);
            BdSwitchView bdSwitchView = (BdSwitchView) findViewById(R.id.button);
            this.f45770h = bdSwitchView;
            bdSwitchView.setFocusable(true);
            TextView textView = (TextView) findViewById(R.id.tip);
            this.tipView = textView;
            if (textView != null) {
                textView.setVisibility(8);
            }
            setTag(this.f45770h);
            this.f45768f.setClickable(false);
            this.f45768f.setFocusable(false);
        }
    }

    public void displayTip() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (textView = this.tipView) == null) {
            return;
        }
        textView.setVisibility(8);
    }

    public BdSwitchView getSwitchView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f45770h : (BdSwitchView) invokeV.objValue;
    }

    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f45768f : (View) invokeV.objValue;
    }

    public void hideTip() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (textView = this.tipView) == null) {
            return;
        }
        textView.setVisibility(0);
    }

    public boolean isOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f45770h.isOn() : invokeV.booleanValue;
    }

    public void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    public void setSwitchStateChangeListener(BdSwitchView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f45770h.setOnSwitchStateChangeListener(bVar);
        }
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdSwitchView) == null) {
            this.f45770h = bdSwitchView;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f45769g.setText(str);
        }
    }

    public void setTextLeftMargin(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i2) == null) && (this.f45769g.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f45769g.getLayoutParams();
            layoutParams.leftMargin = this.f45767e.getResources().getDimensionPixelSize(i2);
            this.f45769g.setLayoutParams(layoutParams);
        }
    }

    public void setTip(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || str == null || this.tipView == null) {
            return;
        }
        displayTip();
        this.tipView.setText(str);
    }

    public void setTipColor(int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (textView = this.tipView) == null) {
            return;
        }
        textView.setTextColor(i2);
    }

    public void switchSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f45770h.setBackgroundRes(SkinManager.getBitmap(R.drawable.bg_switch_open), SkinManager.getBitmap(R.drawable.bg_switch_close), SkinManager.getBitmap(R.drawable.btn_handle));
            SkinManager.setViewTextColor(this.f45769g, R.color.CAM_X0105, 1);
            TextView textView = this.tipView;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109, 1);
            }
        }
    }

    public void turnOff() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f45770h.turnOff();
            BdSwitchView bdSwitchView = this.f45770h;
            bdSwitchView.setContentDescription(this.f45767e.getString(R.string.talk_message_tip) + this.f45767e.getString(R.string.talk_close));
        }
    }

    public void turnOn() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f45770h.turnOn();
            BdSwitchView bdSwitchView = this.f45770h;
            bdSwitchView.setContentDescription(this.f45767e.getString(R.string.talk_message_tip) + this.f45767e.getString(R.string.talk_open));
        }
    }

    public void turnOff(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f45770h.turnOff(z);
            BdSwitchView bdSwitchView = this.f45770h;
            bdSwitchView.setContentDescription(this.f45767e.getString(R.string.talk_message_tip) + this.f45767e.getString(R.string.talk_close));
        }
    }

    public void turnOn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.f45770h.turnOn(z);
            BdSwitchView bdSwitchView = this.f45770h;
            bdSwitchView.setContentDescription(this.f45767e.getString(R.string.talk_message_tip) + this.f45767e.getString(R.string.talk_open));
        }
    }

    public void setTip(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || i2 == -1 || this.tipView == null) {
            return;
        }
        displayTip();
        this.tipView.setText(i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingTextSwitchView(Context context) {
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
        this.f45767e = context;
        b();
        switchSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f45767e = context;
        b();
        a(attributeSet);
        switchSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
