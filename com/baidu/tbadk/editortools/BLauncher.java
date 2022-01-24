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
import c.a.s0.x.a;
import c.a.s0.x.h;
import c.a.s0.x.m;
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
/* loaded from: classes11.dex */
public class BLauncher extends ImageView implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f40920e;

    /* renamed from: f  reason: collision with root package name */
    public int f40921f;

    /* renamed from: g  reason: collision with root package name */
    public int f40922g;

    /* renamed from: h  reason: collision with root package name */
    public m f40923h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f40924i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f40925j;

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
        this.f40922g = 0;
        this.f40925j = false;
        if (mVar == null) {
            return;
        }
        this.f40923h = mVar;
        setIcon();
        setToolId(mVar.f14330c);
    }

    @Override // c.a.s0.x.h
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
        TextView textView = this.f40920e;
        if (textView == null) {
            TextView textView2 = new TextView(getContext());
            this.f40920e = textView2;
            textView2.setTag("tip");
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).addView(this.f40920e);
            }
        } else if (textView.getParent() == null) {
            ViewParent parent2 = getParent();
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).addView(this.f40920e);
            }
        }
        SkinManager.setViewTextColor(this.f40920e, R.color.CAM_X0111, 1, this.f40922g);
        this.f40920e.setGravity(17);
        if (!str.equals(" ")) {
            this.f40920e.setTextSize(10.0f);
            this.f40920e.setText(str);
            SkinManager.setBackgroundResource(this.f40920e, R.drawable.icon_news_red_dot, this.f40922g);
            this.f40920e.setVisibility(0);
            return;
        }
        this.f40920e.setVisibility(8);
        this.f40923h.o = true;
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.draw(canvas);
            if (this.f40923h.o) {
                this.f40924i = SkinManager.getDrawable(R.drawable.icon_news_red_dot);
                int width = getWidth();
                int intrinsicHeight = this.f40924i.getIntrinsicHeight();
                this.f40924i.setBounds(getWidth() - this.f40924i.getIntrinsicWidth(), 0, width, intrinsicHeight);
                this.f40924i.draw(canvas);
            }
        }
    }

    public boolean getIsOutSetVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f40925j : invokeV.booleanValue;
    }

    public TextView getNotice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f40920e : (TextView) invokeV.objValue;
    }

    @Override // c.a.s0.x.h
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f40921f : invokeV.intValue;
    }

    @Override // c.a.s0.x.h
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (textView = this.f40920e) == null) {
            return;
        }
        textView.setVisibility(8);
        hideRedPoint();
    }

    @Override // c.a.s0.x.h
    public void hideRedPoint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f40923h.o = false;
            invalidate();
        }
    }

    @Override // c.a.s0.x.b
    public void onAction(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) && aVar != null && aVar.a == 2) {
            Object obj = aVar.f14320c;
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
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f40922g = i2;
            setIcon();
            TextView textView = this.f40920e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0111, 1, i2);
                if (!TextUtils.isEmpty(this.f40920e.getText()) && !TextUtils.isEmpty(this.f40920e.getText().toString().trim())) {
                    SkinManager.setBackgroundResource(this.f40920e, R.drawable.icon_news_head_prompt_one, i2);
                } else {
                    SkinManager.setBackgroundResource(this.f40920e, R.drawable.icon_news_down_bar_one, i2);
                }
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            TextView textView = this.f40920e;
            if (textView != null && textView.getVisibility() == 0 && this.f40920e.getParent() == null) {
                ViewParent parent = getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).addView(this.f40920e);
                }
            }
        }
    }

    public void setIcon() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (mVar = this.f40923h) == null) {
            return;
        }
        if (mVar.f14334g) {
            SvgManager svgManager = SvgManager.getInstance();
            m mVar2 = this.f40923h;
            setImageDrawable(svgManager.getSeletableDrawableForEditorTools(mVar2.f14331d, mVar2.f14332e, this.f40922g));
        } else if (mVar.f14335h) {
            setImageDrawable(WebPManager.getSeletableDrawableForEditorToolsEM(mVar.f14331d, mVar.f14332e, this.f40922g));
        } else {
            SkinManager.setImageResource(this, mVar.f14331d, this.f40922g);
        }
        if (this.f40923h.c()) {
            return;
        }
        setEnabled(false);
    }

    @Override // c.a.s0.x.h
    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
        }
    }

    public void setOutSetVisibilty(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f40925j = z;
        }
    }

    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f40921f = i2;
        }
    }
}
