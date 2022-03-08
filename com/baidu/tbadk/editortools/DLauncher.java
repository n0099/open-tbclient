package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.r.v.c;
import c.a.q0.w.a;
import c.a.q0.w.h;
import c.a.q0.w.m;
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

    /* renamed from: e  reason: collision with root package name */
    public int f39561e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f39562f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f39563g;

    /* renamed from: h  reason: collision with root package name */
    public int f39564h;

    /* renamed from: i  reason: collision with root package name */
    public String f39565i;

    /* renamed from: j  reason: collision with root package name */
    public m f39566j;

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
        this.f39564h = 0;
        if (mVar == null) {
            return;
        }
        this.f39566j = mVar;
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.M_H_X008);
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f39562f = new EMTextView(context);
        setName(mVar.f13998b);
        setIcon();
        setToolId(mVar.f13999c);
        this.f39562f.setGravity(17);
        c d2 = c.d(this.f39562f);
        d2.z(R.dimen.T_X09);
        d2.v(R.color.CAM_X0106);
        context.getResources().getDimensionPixelSize(R.dimen.ds12);
        addView(this.f39562f, layoutParams);
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f39565i = str;
        if (this.f39563g == null) {
            TextView textView = new TextView(getContext());
            this.f39563g = textView;
            addView(textView, new RelativeLayout.LayoutParams(-2, -2));
        }
        SkinManager.setViewTextColor(this.f39563g, R.color.common_color_10225, 1, this.f39564h);
        this.f39563g.setGravity(17);
        if (!str.equals(" ")) {
            this.f39563g.setTextSize(1, 10.0f);
            this.f39563g.setText(str);
            SkinManager.setBackgroundResource(this.f39563g, R.drawable.icon_news_head_prompt_one, this.f39564h);
            return;
        }
        this.f39563g.setWidth(0);
        this.f39563g.setHeight(0);
        this.f39563g.setText("");
        SkinManager.setBackgroundResource(this.f39563g, R.drawable.icon_news_down_bar_one, this.f39564h);
    }

    @Override // c.a.q0.w.h
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
            this.f39563g.setVisibility(0);
        }
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f39565i : (String) invokeV.objValue;
    }

    @Override // c.a.q0.w.h
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f39561e : invokeV.intValue;
    }

    @Override // c.a.q0.w.h
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setVisibility(8);
        }
    }

    public void hideNotice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f39565i = null;
            TextView textView = this.f39563g;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    @Override // c.a.q0.w.h
    public void hideRedPoint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // c.a.q0.w.b
    public void onAction(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) && aVar != null && aVar.a == 2) {
            Object obj = aVar.f13989c;
            if (obj == null) {
                hideNotice();
            } else if (obj instanceof String) {
                displayNotice((String) obj);
            }
        }
    }

    @Override // c.a.q0.w.h
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f39564h = i2;
            if (isEnabled()) {
                SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, i2);
            }
            c.d(this.f39562f).v(R.color.CAM_X0106);
            if (this.f39566j == null) {
                return;
            }
            setIcon();
            TextView textView = this.f39563g;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.common_color_10225, 1, i2);
                if (!TextUtils.isEmpty(this.f39563g.getText())) {
                    SkinManager.setBackgroundResource(this.f39563g, R.drawable.icon_news_head_prompt_one, i2);
                } else {
                    SkinManager.setBackgroundResource(this.f39563g, R.drawable.icon_news_down_bar_one, i2);
                }
                this.f39563g.setPadding(0, 0, 0, 0);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (this.f39563g != null) {
                if (getVisibility() == 0) {
                    int right = this.f39562f.getRight() - (this.f39563g.getMeasuredWidth() / 2);
                    int top = this.f39562f.getTop() - (this.f39563g.getMeasuredHeight() / 2);
                    this.f39563g.layout(right, top, this.f39563g.getMeasuredWidth() + right, this.f39563g.getMeasuredHeight() + top);
                    return;
                }
                this.f39563g.layout(0, 0, 0, 0);
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            super.setEnabled(z);
            if (z) {
                this.f39562f.setAlpha(1.0f);
                this.f39562f.setEnabled(z);
                setPressed(true);
                SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, TbadkCoreApplication.getInst().getSkinType());
            } else {
                this.f39562f.setAlpha(0.33f);
                this.f39562f.setEnabled(false);
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
            m mVar = this.f39566j;
            int i2 = mVar.f14002f;
            int i3 = mVar.p;
            if (i2 <= 0) {
                i2 = mVar.f14000d;
            }
            if (this.f39566j.f14003g) {
                drawable = SvgManager.getInstance().getSeletableDrawableForEditorTools(i2, this.f39566j.f14001e, this.f39564h);
            } else {
                drawable = SkinManager.getDrawable(this.f39564h, i2);
            }
            if (drawable == null) {
                return;
            }
            Drawable drawable2 = i3 > 0 ? SkinManager.getDrawable(this.f39564h, i3) : null;
            if (drawable2 != null) {
                drawable = new LayerDrawable(new Drawable[]{drawable, drawable2});
            }
            if (drawable == null) {
                return;
            }
            if (TextUtils.isEmpty(this.f39562f.getText())) {
                this.f39562f.setBackground(drawable);
                return;
            }
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.tbds165), getResources().getDimensionPixelSize(R.dimen.tbds165));
            this.f39562f.setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.M_H_X002));
            this.f39562f.setCompoundDrawables(null, drawable, null, null);
        }
    }

    @Override // c.a.q0.w.h
    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f39562f.setText(str);
        }
    }

    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f39561e = i2;
        }
    }
}
