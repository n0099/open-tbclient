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
import c.a.q0.x.a;
import c.a.q0.x.h;
import c.a.q0.x.m;
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
/* loaded from: classes6.dex */
public class BLauncher extends ImageView implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f48282e;

    /* renamed from: f  reason: collision with root package name */
    public int f48283f;

    /* renamed from: g  reason: collision with root package name */
    public int f48284g;

    /* renamed from: h  reason: collision with root package name */
    public m f48285h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f48286i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f48287j;

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
        this.f48284g = 0;
        this.f48287j = false;
        if (mVar == null) {
            return;
        }
        this.f48285h = mVar;
        setIcon();
        setToolId(mVar.f15125c);
    }

    @Override // c.a.q0.x.h
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setVisibility(0);
        }
    }

    public void displayNotice(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || getVisibility() == 8 || TextUtils.isEmpty(str)) {
            return;
        }
        TextView textView = this.f48282e;
        if (textView == null) {
            TextView textView2 = new TextView(getContext());
            this.f48282e = textView2;
            textView2.setTag("tip");
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).addView(this.f48282e);
            }
        } else if (textView.getParent() == null) {
            ViewParent parent2 = getParent();
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).addView(this.f48282e);
            }
        }
        SkinManager.setViewTextColor(this.f48282e, R.color.CAM_X0111, 1, this.f48284g);
        this.f48282e.setGravity(17);
        if (!str.equals(" ")) {
            this.f48282e.setTextSize(10.0f);
            this.f48282e.setText(str);
            SkinManager.setBackgroundResource(this.f48282e, R.drawable.icon_news_red_dot, this.f48284g);
            this.f48282e.setVisibility(0);
            return;
        }
        this.f48282e.setVisibility(8);
        this.f48285h.o = true;
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.draw(canvas);
            if (this.f48285h.o) {
                this.f48286i = SkinManager.getDrawable(R.drawable.icon_news_red_dot);
                int width = getWidth();
                int intrinsicHeight = this.f48286i.getIntrinsicHeight();
                this.f48286i.setBounds(getWidth() - this.f48286i.getIntrinsicWidth(), 0, width, intrinsicHeight);
                this.f48286i.draw(canvas);
            }
        }
    }

    public boolean getIsOutSetVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f48287j : invokeV.booleanValue;
    }

    public TextView getNotice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f48282e : (TextView) invokeV.objValue;
    }

    @Override // c.a.q0.x.h
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f48283f : invokeV.intValue;
    }

    @Override // c.a.q0.x.h
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            hideNotice();
            setVisibility(8);
        }
    }

    public void hideNotice() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (textView = this.f48282e) == null) {
            return;
        }
        textView.setVisibility(8);
        hideRedPoint();
    }

    @Override // c.a.q0.x.h
    public void hideRedPoint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f48285h.o = false;
            invalidate();
        }
    }

    @Override // c.a.q0.x.b
    public void onAction(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) && aVar != null && aVar.f15109a == 2) {
            Object obj = aVar.f15111c;
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
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f48284g = i2;
            setIcon();
            TextView textView = this.f48282e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0111, 1, i2);
                if (!TextUtils.isEmpty(this.f48282e.getText()) && !TextUtils.isEmpty(this.f48282e.getText().toString().trim())) {
                    SkinManager.setBackgroundResource(this.f48282e, R.drawable.icon_news_head_prompt_one, i2);
                } else {
                    SkinManager.setBackgroundResource(this.f48282e, R.drawable.icon_news_down_bar_one, i2);
                }
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            TextView textView = this.f48282e;
            if (textView != null && textView.getVisibility() == 0 && this.f48282e.getParent() == null) {
                ViewParent parent = getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).addView(this.f48282e);
                }
            }
        }
    }

    public void setIcon() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (mVar = this.f48285h) == null) {
            return;
        }
        if (mVar.f15129g) {
            SvgManager svgManager = SvgManager.getInstance();
            m mVar2 = this.f48285h;
            setImageDrawable(svgManager.getSeletableDrawableForEditorTools(mVar2.f15126d, mVar2.f15127e, this.f48284g));
        } else if (mVar.f15130h) {
            setImageDrawable(WebPManager.getSeletableDrawableForEditorToolsEM(mVar.f15126d, mVar.f15127e, this.f48284g));
        } else {
            SkinManager.setImageResource(this, mVar.f15126d, this.f48284g);
        }
        if (this.f48285h.d()) {
            return;
        }
        setEnabled(false);
    }

    @Override // c.a.q0.x.h
    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
        }
    }

    public void setOutSetVisibilty(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f48287j = z;
        }
    }

    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f48283f = i2;
        }
    }
}
