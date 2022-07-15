package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.j15;
import com.repackage.q15;
import com.repackage.u15;
import com.repackage.ur4;
/* loaded from: classes3.dex */
public class DLauncher extends RelativeLayout implements q15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TextView b;
    public TextView c;
    public int d;
    public String e;
    public u15 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DLauncher(Context context, u15 u15Var) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, u15Var};
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
        this.d = 0;
        if (u15Var == null) {
            return;
        }
        this.f = u15Var;
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.M_H_X008);
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.b = new EMTextView(context);
        setName(u15Var.b);
        setIcon();
        setToolId(u15Var.c);
        this.b.setGravity(17);
        ur4 d = ur4.d(this.b);
        d.z(R.dimen.T_X09);
        d.v(R.color.CAM_X0106);
        context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023d);
        addView(this.b, layoutParams);
    }

    @Override // com.repackage.k15
    public void C(j15 j15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, j15Var) == null) && j15Var != null && j15Var.a == 2) {
            Object obj = j15Var.c;
            if (obj == null) {
                c();
            } else if (obj instanceof String) {
                b((String) obj);
            }
        }
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.e = str;
        if (this.c == null) {
            TextView textView = new TextView(getContext());
            this.c = textView;
            addView(textView, new RelativeLayout.LayoutParams(-2, -2));
        }
        SkinManager.setViewTextColor(this.c, R.color.common_color_10225, 1, this.d);
        this.c.setGravity(17);
        if (!str.equals(" ")) {
            this.c.setTextSize(1, 10.0f);
            this.c.setText(str);
            SkinManager.setBackgroundResource(this.c, R.drawable.icon_news_head_prompt_one, this.d);
            return;
        }
        this.c.setWidth(0);
        this.c.setHeight(0);
        this.c.setText("");
        SkinManager.setBackgroundResource(this.c, R.drawable.icon_news_down_bar_one, this.d);
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            a(str);
            this.c.setVisibility(0);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.e = null;
            TextView textView = this.c;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    @Override // com.repackage.q15
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : invokeV.intValue;
    }

    @Override // com.repackage.q15
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setVisibility(8);
        }
    }

    @Override // com.repackage.q15
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.repackage.q15
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.d = i;
            if (isEnabled()) {
                SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, i);
            }
            ur4.d(this.b).v(R.color.CAM_X0106);
            if (this.f == null) {
                return;
            }
            setIcon();
            TextView textView = this.c;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.common_color_10225, 1, i);
                if (!TextUtils.isEmpty(this.c.getText())) {
                    SkinManager.setBackgroundResource(this.c, R.drawable.icon_news_head_prompt_one, i);
                } else {
                    SkinManager.setBackgroundResource(this.c, R.drawable.icon_news_down_bar_one, i);
                }
                this.c.setPadding(0, 0, 0, 0);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.c != null) {
                if (getVisibility() == 0) {
                    int right = this.b.getRight() - (this.c.getMeasuredWidth() / 2);
                    int top = this.b.getTop() - (this.c.getMeasuredHeight() / 2);
                    this.c.layout(right, top, this.c.getMeasuredWidth() + right, this.c.getMeasuredHeight() + top);
                    return;
                }
                this.c.layout(0, 0, 0, 0);
            }
        }
    }

    @Override // com.repackage.q15
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            setVisibility(0);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            super.setEnabled(z);
            if (z) {
                this.b.setAlpha(1.0f);
                this.b.setEnabled(z);
                setPressed(true);
                SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, TbadkCoreApplication.getInst().getSkinType());
            } else {
                this.b.setAlpha(0.33f);
                this.b.setEnabled(false);
                setPressed(false);
                setBackground(null);
            }
            requestLayout();
        }
    }

    public void setIcon() {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            u15 u15Var = this.f;
            int i = u15Var.h;
            int i2 = u15Var.r;
            if (i <= 0) {
                i = u15Var.d;
            }
            if (this.f.i) {
                drawable = SvgManager.getInstance().getSeletableDrawableForEditorTools(i, this.f.e, this.d);
            } else {
                drawable = SkinManager.getDrawable(this.d, i);
            }
            if (drawable == null) {
                return;
            }
            Drawable drawable2 = i2 > 0 ? SkinManager.getDrawable(this.d, i2) : null;
            if (drawable2 != null) {
                drawable = new LayerDrawable(new Drawable[]{drawable, drawable2});
            }
            if (drawable == null) {
                return;
            }
            if (TextUtils.isEmpty(this.b.getText())) {
                this.b.setBackground(drawable);
                return;
            }
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.tbds165), getResources().getDimensionPixelSize(R.dimen.tbds165));
            this.b.setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.M_H_X002));
            this.b.setCompoundDrawables(null, drawable, null, null);
        }
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.b.setText(str);
        }
    }

    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.a = i;
        }
    }
}
