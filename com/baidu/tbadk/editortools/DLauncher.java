package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.s.v.c;
import c.a.r0.x.a;
import c.a.r0.x.h;
import c.a.r0.x.m;
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
    public int f42214e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f42215f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f42216g;

    /* renamed from: h  reason: collision with root package name */
    public int f42217h;

    /* renamed from: i  reason: collision with root package name */
    public String f42218i;

    /* renamed from: j  reason: collision with root package name */
    public m f42219j;

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
        this.f42217h = 0;
        if (mVar == null) {
            return;
        }
        this.f42219j = mVar;
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.M_H_X008);
        layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
        this.f42215f = new EMTextView(context);
        setName(mVar.f14029b);
        setIcon();
        setToolId(mVar.f14030c);
        this.f42215f.setGravity(17);
        c d2 = c.d(this.f42215f);
        d2.z(R.dimen.T_X09);
        d2.v(R.color.CAM_X0106);
        context.getResources().getDimensionPixelSize(R.dimen.ds12);
        addView(this.f42215f, layoutParams);
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f42218i = str;
        if (this.f42216g == null) {
            TextView textView = new TextView(getContext());
            this.f42216g = textView;
            addView(textView, new RelativeLayout.LayoutParams(-2, -2));
        }
        SkinManager.setViewTextColor(this.f42216g, R.color.common_color_10225, 1, this.f42217h);
        this.f42216g.setGravity(17);
        if (!str.equals(" ")) {
            this.f42216g.setTextSize(1, 10.0f);
            this.f42216g.setText(str);
            SkinManager.setBackgroundResource(this.f42216g, R.drawable.icon_news_head_prompt_one, this.f42217h);
            return;
        }
        this.f42216g.setWidth(0);
        this.f42216g.setHeight(0);
        this.f42216g.setText("");
        SkinManager.setBackgroundResource(this.f42216g, R.drawable.icon_news_down_bar_one, this.f42217h);
    }

    @Override // c.a.r0.x.h
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
            this.f42216g.setVisibility(0);
        }
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f42218i : (String) invokeV.objValue;
    }

    @Override // c.a.r0.x.h
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f42214e : invokeV.intValue;
    }

    @Override // c.a.r0.x.h
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setVisibility(8);
        }
    }

    public void hideNotice() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f42218i = null;
            TextView textView = this.f42216g;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
    }

    @Override // c.a.r0.x.h
    public void hideRedPoint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // c.a.r0.x.b
    public void onAction(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) && aVar != null && aVar.a == 2) {
            Object obj = aVar.f14019c;
            if (obj == null) {
                hideNotice();
            } else if (obj instanceof String) {
                displayNotice((String) obj);
            }
        }
    }

    @Override // c.a.r0.x.h
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f42217h = i2;
            if (isEnabled()) {
                SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, i2);
            }
            c.d(this.f42215f).v(R.color.CAM_X0106);
            if (this.f42219j == null) {
                return;
            }
            setIcon();
            TextView textView = this.f42216g;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.common_color_10225, 1, i2);
                if (!TextUtils.isEmpty(this.f42216g.getText())) {
                    SkinManager.setBackgroundResource(this.f42216g, R.drawable.icon_news_head_prompt_one, i2);
                } else {
                    SkinManager.setBackgroundResource(this.f42216g, R.drawable.icon_news_down_bar_one, i2);
                }
                this.f42216g.setPadding(0, 0, 0, 0);
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (this.f42216g != null) {
                if (getVisibility() == 0) {
                    int right = this.f42215f.getRight() - (this.f42216g.getMeasuredWidth() / 2);
                    int top = this.f42215f.getTop() - (this.f42216g.getMeasuredHeight() / 2);
                    this.f42216g.layout(right, top, this.f42216g.getMeasuredWidth() + right, this.f42216g.getMeasuredHeight() + top);
                    return;
                }
                this.f42216g.layout(0, 0, 0, 0);
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            super.setEnabled(z);
            if (z) {
                this.f42215f.setAlpha(1.0f);
                this.f42215f.setEnabled(z);
                setPressed(true);
                SkinManager.setBackgroundResource(this, R.drawable.btn_editor_selector, TbadkCoreApplication.getInst().getSkinType());
            } else {
                this.f42215f.setAlpha(0.33f);
                this.f42215f.setEnabled(false);
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
            m mVar = this.f42219j;
            int i2 = mVar.f14033f;
            int i3 = mVar.p;
            if (i2 <= 0) {
                i2 = mVar.f14031d;
            }
            if (this.f42219j.f14034g) {
                drawable = SvgManager.getInstance().getSeletableDrawableForEditorTools(i2, this.f42219j.f14032e, this.f42217h);
            } else {
                drawable = SkinManager.getDrawable(this.f42217h, i2);
            }
            if (drawable == null) {
                return;
            }
            Drawable drawable2 = i3 > 0 ? SkinManager.getDrawable(this.f42217h, i3) : null;
            if (drawable2 != null) {
                drawable = new LayerDrawable(new Drawable[]{drawable, drawable2});
            }
            if (drawable == null) {
                return;
            }
            if (TextUtils.isEmpty(this.f42215f.getText())) {
                this.f42215f.setBackground(drawable);
                return;
            }
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.tbds165), getResources().getDimensionPixelSize(R.dimen.tbds165));
            this.f42215f.setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.M_H_X002));
            this.f42215f.setCompoundDrawables(null, drawable, null, null);
        }
    }

    @Override // c.a.r0.x.h
    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f42215f.setText(str);
        }
    }

    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f42214e = i2;
        }
    }
}
