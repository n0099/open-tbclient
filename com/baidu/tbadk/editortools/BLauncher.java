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
import d.a.r0.w.a;
import d.a.r0.w.h;
import d.a.r0.w.m;
/* loaded from: classes4.dex */
public class BLauncher extends ImageView implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f12956e;

    /* renamed from: f  reason: collision with root package name */
    public int f12957f;

    /* renamed from: g  reason: collision with root package name */
    public int f12958g;

    /* renamed from: h  reason: collision with root package name */
    public m f12959h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f12960i;
    public boolean j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BLauncher(Context context, m mVar) {
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
        this.f12958g = 0;
        this.j = false;
        if (mVar == null) {
            return;
        }
        this.f12959h = mVar;
        setIcon();
        setToolId(mVar.f56774c);
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || getVisibility() == 8 || TextUtils.isEmpty(str)) {
            return;
        }
        TextView textView = this.f12956e;
        if (textView == null) {
            TextView textView2 = new TextView(getContext());
            this.f12956e = textView2;
            textView2.setTag("tip");
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).addView(this.f12956e);
            }
        } else if (textView.getParent() == null) {
            ViewParent parent2 = getParent();
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).addView(this.f12956e);
            }
        }
        SkinManager.setViewTextColor(this.f12956e, R.color.CAM_X0111, 1, this.f12958g);
        this.f12956e.setGravity(17);
        if (!str.equals(" ")) {
            this.f12956e.setTextSize(10.0f);
            this.f12956e.setText(str);
            SkinManager.setBackgroundResource(this.f12956e, R.drawable.icon_news_red_dot, this.f12958g);
            this.f12956e.setVisibility(0);
            return;
        }
        this.f12956e.setVisibility(8);
        this.f12959h.o = true;
        invalidate();
    }

    @Override // d.a.r0.w.h
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setVisibility(0);
        }
    }

    public void c() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (textView = this.f12956e) == null) {
            return;
        }
        textView.setVisibility(8);
        e();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.draw(canvas);
            if (this.f12959h.o) {
                this.f12960i = SkinManager.getDrawable(R.drawable.icon_news_red_dot);
                int width = getWidth();
                int intrinsicHeight = this.f12960i.getIntrinsicHeight();
                this.f12960i.setBounds(getWidth() - this.f12960i.getIntrinsicWidth(), 0, width, intrinsicHeight);
                this.f12960i.draw(canvas);
            }
        }
    }

    @Override // d.a.r0.w.h
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f12959h.o = false;
            invalidate();
        }
    }

    public boolean getIsOutSetVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public TextView getNotice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f12956e : (TextView) invokeV.objValue;
    }

    @Override // d.a.r0.w.h
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f12957f : invokeV.intValue;
    }

    @Override // d.a.r0.w.h
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c();
            setVisibility(8);
        }
    }

    @Override // d.a.r0.w.b
    public void onAction(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) && aVar != null && aVar.f56766a == 2) {
            Object obj = aVar.f56768c;
            if (obj == null) {
                c();
            } else if (obj instanceof String) {
                a((String) obj);
            }
        }
    }

    @Override // d.a.r0.w.h
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f12958g = i2;
            setIcon();
            TextView textView = this.f12956e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0111, 1, i2);
                if (!TextUtils.isEmpty(this.f12956e.getText()) && !TextUtils.isEmpty(this.f12956e.getText().toString().trim())) {
                    SkinManager.setBackgroundResource(this.f12956e, R.drawable.icon_news_head_prompt_one, i2);
                } else {
                    SkinManager.setBackgroundResource(this.f12956e, R.drawable.icon_news_down_bar_one, i2);
                }
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            TextView textView = this.f12956e;
            if (textView != null && textView.getVisibility() == 0 && this.f12956e.getParent() == null) {
                ViewParent parent = getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).addView(this.f12956e);
                }
            }
        }
    }

    public void setIcon() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (mVar = this.f12959h) == null) {
            return;
        }
        if (mVar.f56778g) {
            SvgManager svgManager = SvgManager.getInstance();
            m mVar2 = this.f12959h;
            setImageDrawable(svgManager.getSeletableDrawableForEditorTools(mVar2.f56775d, mVar2.f56776e, this.f12958g));
        } else if (mVar.f56779h) {
            setImageDrawable(WebPManager.getSeletableDrawableForEditorToolsEM(mVar.f56775d, mVar.f56776e, this.f12958g));
        } else {
            SkinManager.setImageResource(this, mVar.f56775d, this.f12958g);
        }
        if (this.f12959h.d()) {
            return;
        }
        setEnabled(false);
    }

    @Override // d.a.r0.w.h
    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
        }
    }

    public void setOutSetVisibilty(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.j = z;
        }
    }

    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f12957f = i2;
        }
    }
}
