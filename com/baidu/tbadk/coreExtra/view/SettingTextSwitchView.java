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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SettingTextSwitchView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f30423b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f30424c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f30425d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwitchView f30426e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingTextSwitchView(Context context, AttributeSet attributeSet) {
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
        this.a = context;
        c();
        b(attributeSet);
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    public void a() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (textView = this.f30425d) == null) {
            return;
        }
        textView.setVisibility(8);
    }

    public final void b(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040543, R.attr.obfuscated_res_0x7f040544, R.attr.obfuscated_res_0x7f040545, R.attr.obfuscated_res_0x7f040546, R.attr.obfuscated_res_0x7f040547, R.attr.obfuscated_res_0x7f040548});
            String string = obtainStyledAttributes.getString(1);
            int color = obtainStyledAttributes.getColor(2, -1);
            float dimension = obtainStyledAttributes.getDimension(3, -1.0f);
            String string2 = obtainStyledAttributes.getString(4);
            int color2 = obtainStyledAttributes.getColor(5, -1);
            TextView textView = this.f30425d;
            if (textView != null && string2 != null) {
                textView.setVisibility(0);
                this.f30425d.setText(string2);
                if (color2 > -1) {
                    this.f30425d.setTextColor(color2);
                }
            }
            if (string != null) {
                this.f30424c.setText(string);
            }
            if (color > -1) {
                this.f30424c.setTextColor(color);
            }
            if (dimension > -1.0f) {
                this.f30424c.setTextSize(0, dimension);
            }
            this.f30423b.setClickable(false);
            this.f30423b.setFocusable(false);
            obtainStyledAttributes.recycle();
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0770, (ViewGroup) this, true);
            this.f30423b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0906c9);
            this.f30424c = (TextView) findViewById(R.id.obfuscated_res_0x7f091f1b);
            BdSwitchView bdSwitchView = (BdSwitchView) findViewById(R.id.obfuscated_res_0x7f09045c);
            this.f30426e = bdSwitchView;
            bdSwitchView.setFocusable(true);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f092002);
            this.f30425d = textView;
            if (textView != null) {
                textView.setVisibility(8);
            }
            setTag(this.f30426e);
            this.f30423b.setClickable(false);
            this.f30423b.setFocusable(false);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f30426e.setBackgroundRes(SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f0802e8), SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f0802e7), SkinManager.getBitmap(R.drawable.obfuscated_res_0x7f080398));
            SkinManager.setViewTextColor(this.f30424c, R.color.CAM_X0105, 1);
            TextView textView = this.f30425d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0109, 1);
            }
        }
    }

    public void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.f30426e.g(z);
            BdSwitchView bdSwitchView = this.f30426e;
            bdSwitchView.setContentDescription(this.a.getString(R.string.obfuscated_res_0x7f0f133f) + this.a.getString(R.string.obfuscated_res_0x7f0f133d));
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f30426e.k(z);
            BdSwitchView bdSwitchView = this.f30426e;
            bdSwitchView.setContentDescription(this.a.getString(R.string.obfuscated_res_0x7f0f133f) + this.a.getString(R.string.obfuscated_res_0x7f0f1340));
        }
    }

    public BdSwitchView getSwitchView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f30426e : (BdSwitchView) invokeV.objValue;
    }

    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f30423b : (View) invokeV.objValue;
    }

    public void setSwitchStateChangeListener(BdSwitchView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f30426e.setOnSwitchStateChangeListener(bVar);
        }
    }

    public void setSwitchView(BdSwitchView bdSwitchView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bdSwitchView) == null) {
            this.f30426e = bdSwitchView;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.f30424c.setText(str);
        }
    }

    public void setTextLeftMargin(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (this.f30424c.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30424c.getLayoutParams();
            layoutParams.leftMargin = this.a.getResources().getDimensionPixelSize(i);
            this.f30424c.setLayoutParams(layoutParams);
        }
    }

    public void setTip(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || str == null || this.f30425d == null) {
            return;
        }
        a();
        this.f30425d.setText(str);
    }

    public void setTipColor(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i) == null) || (textView = this.f30425d) == null) {
            return;
        }
        textView.setTextColor(i);
    }

    public void setTip(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || i == -1 || this.f30425d == null) {
            return;
        }
        a();
        this.f30425d.setText(i);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        c();
        d(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingTextSwitchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = context;
        c();
        b(attributeSet);
        d(TbadkCoreApplication.getInst().getSkinType());
    }
}
