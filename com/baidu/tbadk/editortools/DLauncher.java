package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.s.u.c;
import c.a.s0.x.a;
import c.a.s0.x.h;
import c.a.s0.x.m;
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
/* loaded from: classes11.dex */
public class DLauncher extends RelativeLayout implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f40898e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f40899f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f40900g;

    /* renamed from: h  reason: collision with root package name */
    public int f40901h;

    /* renamed from: i  reason: collision with root package name */
    public String f40902i;

    /* renamed from: j  reason: collision with root package name */
    public m f40903j;

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
        this.f40901h = 0;
        if (mVar == null) {
            return;
        }
        this.f40903j = mVar;
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.M_H_X008);
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f40899f = new EMTextView(context);
        setName(mVar.f14189b);
        setIcon();
        setToolId(mVar.f14190c);
        this.f40899f.setGravity(17);
        c d2 = c.d(this.f40899f);
        d2.z(R.dimen.T_X09);
        d2.v(R.color.CAM_X0106);
        context.getResources().getDimensionPixelSize(R.dimen.ds12);
        addView(this.f40899f, layoutParams);
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f40902i = str;
        if (this.f40900g == null) {
            TextView textView = new TextView(getContext());
            this.f40900g = textView;
            addView(textView, new RelativeLayout.LayoutParams(-2, -2));
        }
        SkinManager.setViewTextColor(this.f40900g, R.color.common_color_10225, 1, this.f40901h);
        this.f40900g.setGravity(17);
        if (!str.equals(" ")) {
            this.f40900g.setTextSize(1, 10.0f);
            this.f40900g.setText(str);
            SkinManager.setBackgroundResource(this.f40900g, R.drawable.icon_news_head_prompt_one, this.f40901h);
            return;
        }
        this.f40900g.setWidth(0);
        this.f40900g.setHeight(0);
        this.f40900g.setText("");
        SkinManager.setBackgroundResource(this.f40900g, R.drawable.icon_news_down_bar_one, this.f40901h);
    }

    @Override // c.a.s0.x.h
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
            this.f40900g.setVisibility(0);
        }
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f40902i : (String) invokeV.objValue;
    }

    @Override // c.a.s0.x.h
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f40898e : invokeV.intValue;
    }

    @Override // c.a.s0.x.h
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setVisibility(8);
        }
    }

    public void hideNotice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f40902i = null;
            TextView textView = this.f40900g;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    @Override // c.a.s0.x.h
    public void hideRedPoint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // c.a.s0.x.b
    public void onAction(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) && aVar != null && aVar.a == 2) {
            Object obj = aVar.f14180c;
            if (obj == null) {
                hideNotice();
            } else if (obj instanceof String) {
                displayNotice((String) obj);
            }
        }
    }

    @Override // c.a.s0.x.h
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f40901h = i2;
            if (isEnabled()) {
                SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, i2);
            }
            c.d(this.f40899f).v(R.color.CAM_X0106);
            if (this.f40903j == null) {
                return;
            }
            setIcon();
            TextView textView = this.f40900g;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.common_color_10225, 1, i2);
                if (!TextUtils.isEmpty(this.f40900g.getText())) {
                    SkinManager.setBackgroundResource(this.f40900g, R.drawable.icon_news_head_prompt_one, i2);
                } else {
                    SkinManager.setBackgroundResource(this.f40900g, R.drawable.icon_news_down_bar_one, i2);
                }
                this.f40900g.setPadding(0, 0, 0, 0);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (this.f40900g != null) {
                if (getVisibility() == 0) {
                    int right = this.f40899f.getRight() - (this.f40900g.getMeasuredWidth() / 2);
                    int top = this.f40899f.getTop() - (this.f40900g.getMeasuredHeight() / 2);
                    this.f40900g.layout(right, top, this.f40900g.getMeasuredWidth() + right, this.f40900g.getMeasuredHeight() + top);
                    return;
                }
                this.f40900g.layout(0, 0, 0, 0);
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            super.setEnabled(z);
            if (z) {
                this.f40899f.setAlpha(1.0f);
                this.f40899f.setEnabled(z);
                setPressed(true);
                SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, TbadkCoreApplication.getInst().getSkinType());
            } else {
                this.f40899f.setAlpha(0.33f);
                this.f40899f.setEnabled(false);
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
            m mVar = this.f40903j;
            int i2 = mVar.f14193f;
            int i3 = mVar.p;
            if (i2 <= 0) {
                i2 = mVar.f14191d;
            }
            if (this.f40903j.f14194g) {
                drawable = SvgManager.getInstance().getSeletableDrawableForEditorTools(i2, this.f40903j.f14192e, this.f40901h);
            } else {
                drawable = SkinManager.getDrawable(this.f40901h, i2);
            }
            if (drawable == null) {
                return;
            }
            Drawable drawable2 = i3 > 0 ? SkinManager.getDrawable(this.f40901h, i3) : null;
            if (drawable2 != null) {
                drawable = new LayerDrawable(new Drawable[]{drawable, drawable2});
            }
            if (drawable == null) {
                return;
            }
            if (TextUtils.isEmpty(this.f40899f.getText())) {
                this.f40899f.setBackground(drawable);
                return;
            }
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.tbds165), getResources().getDimensionPixelSize(R.dimen.tbds165));
            this.f40899f.setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.M_H_X002));
            this.f40899f.setCompoundDrawables(null, drawable, null, null);
        }
    }

    @Override // c.a.s0.x.h
    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f40899f.setText(str);
        }
    }

    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f40898e = i2;
        }
    }
}
