package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.v.c;
import c.a.o0.w.a;
import c.a.o0.w.h;
import c.a.o0.w.m;
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
/* loaded from: classes5.dex */
public class DLauncher extends RelativeLayout implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f30469b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f30470c;

    /* renamed from: d  reason: collision with root package name */
    public int f30471d;

    /* renamed from: e  reason: collision with root package name */
    public String f30472e;

    /* renamed from: f  reason: collision with root package name */
    public m f30473f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DLauncher(Context context, m mVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mVar};
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
        this.f30471d = 0;
        if (mVar == null) {
            return;
        }
        this.f30473f = mVar;
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.M_H_X008);
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f30469b = new EMTextView(context);
        setName(mVar.f11508b);
        setIcon();
        setToolId(mVar.f11509c);
        this.f30469b.setGravity(17);
        c d2 = c.d(this.f30469b);
        d2.z(R.dimen.T_X09);
        d2.v(R.color.CAM_X0106);
        context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070234);
        addView(this.f30469b, layoutParams);
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f30472e = str;
        if (this.f30470c == null) {
            TextView textView = new TextView(getContext());
            this.f30470c = textView;
            addView(textView, new RelativeLayout.LayoutParams(-2, -2));
        }
        SkinManager.setViewTextColor(this.f30470c, R.color.common_color_10225, 1, this.f30471d);
        this.f30470c.setGravity(17);
        if (!str.equals(" ")) {
            this.f30470c.setTextSize(1, 10.0f);
            this.f30470c.setText(str);
            SkinManager.setBackgroundResource(this.f30470c, R.drawable.icon_news_head_prompt_one, this.f30471d);
            return;
        }
        this.f30470c.setWidth(0);
        this.f30470c.setHeight(0);
        this.f30470c.setText("");
        SkinManager.setBackgroundResource(this.f30470c, R.drawable.icon_news_down_bar_one, this.f30471d);
    }

    @Override // c.a.o0.w.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(0);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            a(str);
            this.f30470c.setVisibility(0);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f30472e = null;
            TextView textView = this.f30470c;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    @Override // c.a.o0.w.h
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f30472e : (String) invokeV.objValue;
    }

    @Override // c.a.o0.w.h
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : invokeV.intValue;
    }

    @Override // c.a.o0.w.h
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setVisibility(8);
        }
    }

    @Override // c.a.o0.w.b
    public void onAction(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) && aVar != null && aVar.a == 2) {
            Object obj = aVar.f11499c;
            if (obj == null) {
                e();
            } else if (obj instanceof String) {
                c((String) obj);
            }
        }
    }

    @Override // c.a.o0.w.h
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.f30471d = i;
            if (isEnabled()) {
                SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, i);
            }
            c.d(this.f30469b).v(R.color.CAM_X0106);
            if (this.f30473f == null) {
                return;
            }
            setIcon();
            TextView textView = this.f30470c;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.common_color_10225, 1, i);
                if (!TextUtils.isEmpty(this.f30470c.getText())) {
                    SkinManager.setBackgroundResource(this.f30470c, R.drawable.icon_news_head_prompt_one, i);
                } else {
                    SkinManager.setBackgroundResource(this.f30470c, R.drawable.icon_news_down_bar_one, i);
                }
                this.f30470c.setPadding(0, 0, 0, 0);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f30470c != null) {
                if (getVisibility() == 0) {
                    int right = this.f30469b.getRight() - (this.f30470c.getMeasuredWidth() / 2);
                    int top = this.f30469b.getTop() - (this.f30470c.getMeasuredHeight() / 2);
                    this.f30470c.layout(right, top, this.f30470c.getMeasuredWidth() + right, this.f30470c.getMeasuredHeight() + top);
                    return;
                }
                this.f30470c.layout(0, 0, 0, 0);
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            super.setEnabled(z);
            if (z) {
                this.f30469b.setAlpha(1.0f);
                this.f30469b.setEnabled(z);
                setPressed(true);
                SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, TbadkCoreApplication.getInst().getSkinType());
            } else {
                this.f30469b.setAlpha(0.33f);
                this.f30469b.setEnabled(false);
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
            m mVar = this.f30473f;
            int i = mVar.f11512f;
            int i2 = mVar.p;
            if (i <= 0) {
                i = mVar.f11510d;
            }
            if (this.f30473f.f11513g) {
                drawable = SvgManager.getInstance().getSeletableDrawableForEditorTools(i, this.f30473f.f11511e, this.f30471d);
            } else {
                drawable = SkinManager.getDrawable(this.f30471d, i);
            }
            if (drawable == null) {
                return;
            }
            Drawable drawable2 = i2 > 0 ? SkinManager.getDrawable(this.f30471d, i2) : null;
            if (drawable2 != null) {
                drawable = new LayerDrawable(new Drawable[]{drawable, drawable2});
            }
            if (drawable == null) {
                return;
            }
            if (TextUtils.isEmpty(this.f30469b.getText())) {
                this.f30469b.setBackground(drawable);
                return;
            }
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.tbds165), getResources().getDimensionPixelSize(R.dimen.tbds165));
            this.f30469b.setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.M_H_X002));
            this.f30469b.setCompoundDrawables(null, drawable, null, null);
        }
    }

    @Override // c.a.o0.w.h
    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f30469b.setText(str);
        }
    }

    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.a = i;
        }
    }
}
