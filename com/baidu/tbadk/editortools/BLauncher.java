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
import b.a.q0.x.a;
import b.a.q0.x.h;
import b.a.q0.x.m;
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
/* loaded from: classes8.dex */
public class BLauncher extends ImageView implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f45824e;

    /* renamed from: f  reason: collision with root package name */
    public int f45825f;

    /* renamed from: g  reason: collision with root package name */
    public int f45826g;

    /* renamed from: h  reason: collision with root package name */
    public m f45827h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f45828i;
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
        this.f45826g = 0;
        this.j = false;
        if (mVar == null) {
            return;
        }
        this.f45827h = mVar;
        setIcon();
        setToolId(mVar.f14210c);
    }

    @Override // b.a.q0.x.h
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
        TextView textView = this.f45824e;
        if (textView == null) {
            TextView textView2 = new TextView(getContext());
            this.f45824e = textView2;
            textView2.setTag("tip");
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).addView(this.f45824e);
            }
        } else if (textView.getParent() == null) {
            ViewParent parent2 = getParent();
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).addView(this.f45824e);
            }
        }
        SkinManager.setViewTextColor(this.f45824e, R.color.CAM_X0111, 1, this.f45826g);
        this.f45824e.setGravity(17);
        if (!str.equals(" ")) {
            this.f45824e.setTextSize(10.0f);
            this.f45824e.setText(str);
            SkinManager.setBackgroundResource(this.f45824e, R.drawable.icon_news_red_dot, this.f45826g);
            this.f45824e.setVisibility(0);
            return;
        }
        this.f45824e.setVisibility(8);
        this.f45827h.o = true;
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            super.draw(canvas);
            if (this.f45827h.o) {
                this.f45828i = SkinManager.getDrawable(R.drawable.icon_news_red_dot);
                int width = getWidth();
                int intrinsicHeight = this.f45828i.getIntrinsicHeight();
                this.f45828i.setBounds(getWidth() - this.f45828i.getIntrinsicWidth(), 0, width, intrinsicHeight);
                this.f45828i.draw(canvas);
            }
        }
    }

    public boolean getIsOutSetVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public TextView getNotice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f45824e : (TextView) invokeV.objValue;
    }

    @Override // b.a.q0.x.h
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f45825f : invokeV.intValue;
    }

    @Override // b.a.q0.x.h
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (textView = this.f45824e) == null) {
            return;
        }
        textView.setVisibility(8);
        hideRedPoint();
    }

    @Override // b.a.q0.x.h
    public void hideRedPoint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f45827h.o = false;
            invalidate();
        }
    }

    @Override // b.a.q0.x.b
    public void onAction(a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) && aVar != null && aVar.f14195a == 2) {
            Object obj = aVar.f14197c;
            if (obj == null) {
                hideNotice();
            } else if (obj instanceof String) {
                displayNotice((String) obj);
            }
        }
    }

    @Override // b.a.q0.x.h
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f45826g = i2;
            setIcon();
            TextView textView = this.f45824e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0111, 1, i2);
                if (!TextUtils.isEmpty(this.f45824e.getText()) && !TextUtils.isEmpty(this.f45824e.getText().toString().trim())) {
                    SkinManager.setBackgroundResource(this.f45824e, R.drawable.icon_news_head_prompt_one, i2);
                } else {
                    SkinManager.setBackgroundResource(this.f45824e, R.drawable.icon_news_down_bar_one, i2);
                }
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            TextView textView = this.f45824e;
            if (textView != null && textView.getVisibility() == 0 && this.f45824e.getParent() == null) {
                ViewParent parent = getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).addView(this.f45824e);
                }
            }
        }
    }

    public void setIcon() {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (mVar = this.f45827h) == null) {
            return;
        }
        if (mVar.f14214g) {
            SvgManager svgManager = SvgManager.getInstance();
            m mVar2 = this.f45827h;
            setImageDrawable(svgManager.getSeletableDrawableForEditorTools(mVar2.f14211d, mVar2.f14212e, this.f45826g));
        } else if (mVar.f14215h) {
            setImageDrawable(WebPManager.getSeletableDrawableForEditorToolsEM(mVar.f14211d, mVar.f14212e, this.f45826g));
        } else {
            SkinManager.setImageResource(this, mVar.f14211d, this.f45826g);
        }
        if (this.f45827h.c()) {
            return;
        }
        setEnabled(false);
    }

    @Override // b.a.q0.x.h
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
            this.f45825f = i2;
        }
    }
}
