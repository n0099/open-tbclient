package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.u.c;
import c.a.q0.x.a;
import c.a.q0.x.h;
import c.a.q0.x.m;
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
/* loaded from: classes9.dex */
public class DLauncher extends RelativeLayout implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f41723e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f41724f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f41725g;

    /* renamed from: h  reason: collision with root package name */
    public int f41726h;

    /* renamed from: i  reason: collision with root package name */
    public String f41727i;

    /* renamed from: j  reason: collision with root package name */
    public m f41728j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DLauncher(Context context, m mVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar};
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
        this.f41726h = 0;
        if (mVar == null) {
            return;
        }
        this.f41728j = mVar;
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.M_H_X008);
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f41724f = new EMTextView(context);
        setName(mVar.f13689b);
        setIcon();
        setToolId(mVar.f13690c);
        this.f41724f.setGravity(17);
        c d2 = c.d(this.f41724f);
        d2.z(R.dimen.T_X09);
        d2.v(R.color.CAM_X0106);
        context.getResources().getDimensionPixelSize(R.dimen.ds12);
        addView(this.f41724f, layoutParams);
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f41727i = str;
        if (this.f41725g == null) {
            TextView textView = new TextView(getContext());
            this.f41725g = textView;
            addView(textView, new RelativeLayout.LayoutParams(-2, -2));
        }
        SkinManager.setViewTextColor(this.f41725g, R.color.common_color_10225, 1, this.f41726h);
        this.f41725g.setGravity(17);
        if (!str.equals(" ")) {
            this.f41725g.setTextSize(1, 10.0f);
            this.f41725g.setText(str);
            SkinManager.setBackgroundResource(this.f41725g, R.drawable.icon_news_head_prompt_one, this.f41726h);
            return;
        }
        this.f41725g.setWidth(0);
        this.f41725g.setHeight(0);
        this.f41725g.setText("");
        SkinManager.setBackgroundResource(this.f41725g, R.drawable.icon_news_down_bar_one, this.f41726h);
    }

    @Override // c.a.q0.x.h
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(0);
        }
    }

    public void displayNotice(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            a(str);
            this.f41725g.setVisibility(0);
        }
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41727i : (String) invokeV.objValue;
    }

    @Override // c.a.q0.x.h
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f41723e : invokeV.intValue;
    }

    @Override // c.a.q0.x.h
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setVisibility(8);
        }
    }

    public void hideNotice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f41727i = null;
            TextView textView = this.f41725g;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    @Override // c.a.q0.x.h
    public void hideRedPoint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // c.a.q0.x.b
    public void onAction(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) && aVar != null && aVar.a == 2) {
            Object obj = aVar.f13679c;
            if (obj == null) {
                hideNotice();
            } else if (obj instanceof String) {
                displayNotice((String) obj);
            }
        }
    }

    @Override // c.a.q0.x.h
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f41726h = i2;
            if (isEnabled()) {
                SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, i2);
            }
            c.d(this.f41724f).v(R.color.CAM_X0106);
            if (this.f41728j == null) {
                return;
            }
            setIcon();
            TextView textView = this.f41725g;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.common_color_10225, 1, i2);
                if (!TextUtils.isEmpty(this.f41725g.getText())) {
                    SkinManager.setBackgroundResource(this.f41725g, R.drawable.icon_news_head_prompt_one, i2);
                } else {
                    SkinManager.setBackgroundResource(this.f41725g, R.drawable.icon_news_down_bar_one, i2);
                }
                this.f41725g.setPadding(0, 0, 0, 0);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (this.f41725g != null) {
                if (getVisibility() == 0) {
                    int right = this.f41724f.getRight() - (this.f41725g.getMeasuredWidth() / 2);
                    int top = this.f41724f.getTop() - (this.f41725g.getMeasuredHeight() / 2);
                    this.f41725g.layout(right, top, this.f41725g.getMeasuredWidth() + right, this.f41725g.getMeasuredHeight() + top);
                    return;
                }
                this.f41725g.layout(0, 0, 0, 0);
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            super.setEnabled(z);
            if (z) {
                this.f41724f.setAlpha(1.0f);
                this.f41724f.setEnabled(z);
                setPressed(true);
                SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, TbadkCoreApplication.getInst().getSkinType());
            } else {
                this.f41724f.setAlpha(0.33f);
                this.f41724f.setEnabled(false);
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
            m mVar = this.f41728j;
            int i2 = mVar.f13693f;
            int i3 = mVar.p;
            if (i2 <= 0) {
                i2 = mVar.f13691d;
            }
            if (this.f41728j.f13694g) {
                drawable = SvgManager.getInstance().getSeletableDrawableForEditorTools(i2, this.f41728j.f13692e, this.f41726h);
            } else {
                drawable = SkinManager.getDrawable(this.f41726h, i2);
            }
            if (drawable == null) {
                return;
            }
            Drawable drawable2 = i3 > 0 ? SkinManager.getDrawable(this.f41726h, i3) : null;
            if (drawable2 != null) {
                drawable = new LayerDrawable(new Drawable[]{drawable, drawable2});
            }
            if (drawable == null) {
                return;
            }
            if (TextUtils.isEmpty(this.f41724f.getText())) {
                this.f41724f.setBackground(drawable);
                return;
            }
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.tbds165), getResources().getDimensionPixelSize(R.dimen.tbds165));
            this.f41724f.setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.M_H_X002));
            this.f41724f.setCompoundDrawables(null, drawable, null, null);
        }
    }

    @Override // c.a.q0.x.h
    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f41724f.setText(str);
        }
    }

    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f41723e = i2;
        }
    }
}
