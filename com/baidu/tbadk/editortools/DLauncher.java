package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.s.v.c;
import c.a.t0.x.a;
import c.a.t0.x.h;
import c.a.t0.x.m;
import c.a.u0.a4.d;
import c.a.u0.a4.e;
import c.a.u0.a4.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class DLauncher extends RelativeLayout implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f41155e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f41156f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f41157g;

    /* renamed from: h  reason: collision with root package name */
    public int f41158h;

    /* renamed from: i  reason: collision with root package name */
    public String f41159i;

    /* renamed from: j  reason: collision with root package name */
    public m f41160j;

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
        this.f41158h = 0;
        if (mVar == null) {
            return;
        }
        this.f41160j = mVar;
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(e.M_H_X008);
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(e.M_W_X007);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(e.M_W_X007);
        this.f41156f = new EMTextView(context);
        setName(mVar.f14603b);
        setIcon();
        setToolId(mVar.f14604c);
        this.f41156f.setGravity(17);
        c d2 = c.d(this.f41156f);
        d2.z(e.T_X09);
        d2.v(d.CAM_X0106);
        context.getResources().getDimensionPixelSize(e.ds12);
        addView(this.f41156f, layoutParams);
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f41159i = str;
        if (this.f41157g == null) {
            TextView textView = new TextView(getContext());
            this.f41157g = textView;
            addView(textView, new RelativeLayout.LayoutParams(-2, -2));
        }
        SkinManager.setViewTextColor(this.f41157g, d.common_color_10225, 1, this.f41158h);
        this.f41157g.setGravity(17);
        if (!str.equals(" ")) {
            this.f41157g.setTextSize(1, 10.0f);
            this.f41157g.setText(str);
            SkinManager.setBackgroundResource(this.f41157g, f.icon_news_head_prompt_one, this.f41158h);
            return;
        }
        this.f41157g.setWidth(0);
        this.f41157g.setHeight(0);
        this.f41157g.setText("");
        SkinManager.setBackgroundResource(this.f41157g, f.icon_news_down_bar_one, this.f41158h);
    }

    @Override // c.a.t0.x.h
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
            this.f41157g.setVisibility(0);
        }
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41159i : (String) invokeV.objValue;
    }

    @Override // c.a.t0.x.h
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f41155e : invokeV.intValue;
    }

    @Override // c.a.t0.x.h
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setVisibility(8);
        }
    }

    public void hideNotice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f41159i = null;
            TextView textView = this.f41157g;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    @Override // c.a.t0.x.h
    public void hideRedPoint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // c.a.t0.x.b
    public void onAction(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) && aVar != null && aVar.a == 2) {
            Object obj = aVar.f14594c;
            if (obj == null) {
                hideNotice();
            } else if (obj instanceof String) {
                displayNotice((String) obj);
            }
        }
    }

    @Override // c.a.t0.x.h
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f41158h = i2;
            if (isEnabled()) {
                SkinManager.setBackgroundResource(this, f.btn_editor_selector, i2);
            }
            c.d(this.f41156f).v(d.CAM_X0106);
            if (this.f41160j == null) {
                return;
            }
            setIcon();
            TextView textView = this.f41157g;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, d.common_color_10225, 1, i2);
                if (!TextUtils.isEmpty(this.f41157g.getText())) {
                    SkinManager.setBackgroundResource(this.f41157g, f.icon_news_head_prompt_one, i2);
                } else {
                    SkinManager.setBackgroundResource(this.f41157g, f.icon_news_down_bar_one, i2);
                }
                this.f41157g.setPadding(0, 0, 0, 0);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (this.f41157g != null) {
                if (getVisibility() == 0) {
                    int right = this.f41156f.getRight() - (this.f41157g.getMeasuredWidth() / 2);
                    int top = this.f41156f.getTop() - (this.f41157g.getMeasuredHeight() / 2);
                    this.f41157g.layout(right, top, this.f41157g.getMeasuredWidth() + right, this.f41157g.getMeasuredHeight() + top);
                    return;
                }
                this.f41157g.layout(0, 0, 0, 0);
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            super.setEnabled(z);
            if (z) {
                this.f41156f.setAlpha(1.0f);
                this.f41156f.setEnabled(z);
                setPressed(true);
                SkinManager.setBackgroundResource(this, f.btn_editor_selector, TbadkCoreApplication.getInst().getSkinType());
            } else {
                this.f41156f.setAlpha(0.33f);
                this.f41156f.setEnabled(false);
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
            m mVar = this.f41160j;
            int i2 = mVar.f14607f;
            int i3 = mVar.p;
            if (i2 <= 0) {
                i2 = mVar.f14605d;
            }
            if (this.f41160j.f14608g) {
                drawable = SvgManager.getInstance().getSeletableDrawableForEditorTools(i2, this.f41160j.f14606e, this.f41158h);
            } else {
                drawable = SkinManager.getDrawable(this.f41158h, i2);
            }
            if (drawable == null) {
                return;
            }
            Drawable drawable2 = i3 > 0 ? SkinManager.getDrawable(this.f41158h, i3) : null;
            if (drawable2 != null) {
                drawable = new LayerDrawable(new Drawable[]{drawable, drawable2});
            }
            if (drawable == null) {
                return;
            }
            if (TextUtils.isEmpty(this.f41156f.getText())) {
                this.f41156f.setBackground(drawable);
                return;
            }
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(e.tbds165), getResources().getDimensionPixelSize(e.tbds165));
            this.f41156f.setCompoundDrawablePadding(getResources().getDimensionPixelSize(e.M_H_X002));
            this.f41156f.setCompoundDrawables(null, drawable, null, null);
        }
    }

    @Override // c.a.t0.x.h
    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f41156f.setText(str);
        }
    }

    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f41155e = i2;
        }
    }
}
