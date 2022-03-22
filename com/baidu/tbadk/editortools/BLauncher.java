package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.w.a;
import c.a.o0.w.h;
import c.a.o0.w.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class BLauncher extends ImageView implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public int f30464b;

    /* renamed from: c  reason: collision with root package name */
    public int f30465c;

    /* renamed from: d  reason: collision with root package name */
    public m f30466d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f30467e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30468f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BLauncher(Context context, m mVar) {
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
        this.f30465c = 0;
        this.f30468f = false;
        if (mVar == null) {
            return;
        }
        this.f30466d = mVar;
        setIcon();
        setToolId(mVar.f11509c);
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || getVisibility() == 8 || TextUtils.isEmpty(str)) {
            return;
        }
        TextView textView = this.a;
        if (textView == null) {
            TextView textView2 = new TextView(getContext());
            this.a = textView2;
            textView2.setTag("tip");
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).addView(this.a);
            }
        } else if (textView.getParent() == null) {
            ViewParent parent2 = getParent();
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).addView(this.a);
            }
        }
        SkinManager.setViewTextColor(this.a, R.color.CAM_X0111, 1, this.f30465c);
        this.a.setGravity(17);
        if (!str.equals(" ")) {
            this.a.setTextSize(10.0f);
            this.a.setText(str);
            SkinManager.setBackgroundResource(this.a, R.drawable.icon_news_red_dot, this.f30465c);
            this.a.setVisibility(0);
            return;
        }
        this.a.setVisibility(8);
        this.f30466d.o = true;
        invalidate();
    }

    @Override // c.a.o0.w.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(0);
        }
    }

    public void c() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (textView = this.a) == null) {
            return;
        }
        textView.setVisibility(8);
        f();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.draw(canvas);
            if (this.f30466d.o) {
                this.f30467e = SkinManager.getDrawable(R.drawable.icon_news_red_dot);
                int width = getWidth();
                int intrinsicHeight = this.f30467e.getIntrinsicHeight();
                this.f30467e.setBounds(getWidth() - this.f30467e.getIntrinsicWidth(), 0, width, intrinsicHeight);
                this.f30467e.draw(canvas);
            }
        }
    }

    @Override // c.a.o0.w.h
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f30466d.o = false;
            invalidate();
        }
    }

    public boolean getIsOutSetVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f30468f : invokeV.booleanValue;
    }

    public TextView getNotice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (TextView) invokeV.objValue;
    }

    @Override // c.a.o0.w.h
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f30464b : invokeV.intValue;
    }

    @Override // c.a.o0.w.h
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c();
            setVisibility(8);
        }
    }

    @Override // c.a.o0.w.b
    public void onAction(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) && aVar != null && aVar.a == 2) {
            Object obj = aVar.f11499c;
            if (obj == null) {
                c();
            } else if (obj instanceof String) {
                a((String) obj);
            }
        }
    }

    @Override // c.a.o0.w.h
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.f30465c = i;
            setIcon();
            TextView textView = this.a;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0111, 1, i);
                if (!TextUtils.isEmpty(this.a.getText()) && !TextUtils.isEmpty(this.a.getText().toString().trim())) {
                    SkinManager.setBackgroundResource(this.a, R.drawable.icon_news_head_prompt_one, i);
                } else {
                    SkinManager.setBackgroundResource(this.a, R.drawable.icon_news_down_bar_one, i);
                }
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            super.onMeasure(i, i2);
            TextView textView = this.a;
            if (textView != null && textView.getVisibility() == 0 && this.a.getParent() == null) {
                ViewParent parent = getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).addView(this.a);
                }
            }
        }
    }

    public void setIcon() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (mVar = this.f30466d) == null) {
            return;
        }
        if (mVar.f11513g) {
            SvgManager svgManager = SvgManager.getInstance();
            m mVar2 = this.f30466d;
            setImageDrawable(svgManager.getSeletableDrawableForEditorTools(mVar2.f11510d, mVar2.f11511e, this.f30465c));
        } else if (mVar.f11514h) {
            setImageDrawable(WebPManager.getSeletableDrawableForEditorToolsEM(mVar.f11510d, mVar.f11511e, this.f30465c));
        } else {
            SkinManager.setImageResource(this, mVar.f11510d, this.f30465c);
        }
        if (this.f30466d.c()) {
            return;
        }
        setEnabled(false);
    }

    @Override // c.a.o0.w.h
    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
        }
    }

    public void setOutSetVisibilty(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f30468f = z;
        }
    }

    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.f30464b = i;
        }
    }
}
