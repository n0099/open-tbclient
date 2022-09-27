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
import com.baidu.tieba.h55;
import com.baidu.tieba.o55;
import com.baidu.tieba.s55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BLauncher extends ImageView implements o55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public int b;
    public int c;
    public s55 d;
    public Drawable e;
    public boolean f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BLauncher(Context context, s55 s55Var) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, s55Var};
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
        this.c = 0;
        this.f = false;
        if (s55Var == null) {
            return;
        }
        this.d = s55Var;
        setIcon();
        setToolId(s55Var.c);
    }

    @Override // com.baidu.tieba.i55
    public void B(h55 h55Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, h55Var) == null) && h55Var != null && h55Var.a == 2) {
            Object obj = h55Var.c;
            if (obj == null) {
                b();
            } else if (obj instanceof String) {
                a((String) obj);
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || getVisibility() == 8 || TextUtils.isEmpty(str)) {
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
        SkinManager.setViewTextColor(this.a, R.color.CAM_X0111, 1, this.c);
        this.a.setGravity(17);
        if (!str.equals(" ")) {
            this.a.setTextSize(10.0f);
            this.a.setText(str);
            SkinManager.setBackgroundResource(this.a, R.drawable.icon_news_red_dot, this.c);
            this.a.setVisibility(0);
            return;
        }
        this.a.setVisibility(8);
        this.d.q = true;
        invalidate();
    }

    public void b() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (textView = this.a) == null) {
            return;
        }
        textView.setVisibility(8);
        j0();
    }

    @Override // com.baidu.tieba.o55
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setVisibility(0);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            super.draw(canvas);
            if (this.d.q) {
                this.e = SkinManager.getDrawable(R.drawable.icon_news_red_dot);
                int width = getWidth();
                int intrinsicHeight = this.e.getIntrinsicHeight();
                this.e.setBounds(getWidth() - this.e.getIntrinsicWidth(), 0, width, intrinsicHeight);
                this.e.draw(canvas);
            }
        }
    }

    public boolean getIsOutSetVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f : invokeV.booleanValue;
    }

    public TextView getNotice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o55
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b : invokeV.intValue;
    }

    @Override // com.baidu.tieba.o55
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b();
            setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.o55
    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.d.q = false;
            invalidate();
        }
    }

    @Override // com.baidu.tieba.o55
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.c = i;
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
        s55 s55Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (s55Var = this.d) == null) {
            return;
        }
        if (s55Var.i) {
            SvgManager svgManager = SvgManager.getInstance();
            s55 s55Var2 = this.d;
            setImageDrawable(svgManager.getSeletableDrawableForEditorTools(s55Var2.d, s55Var2.e, this.c));
        } else if (s55Var.j) {
            setImageDrawable(WebPManager.getSeletableDrawableForEditorToolsEM(s55Var.d, s55Var.e, s55Var.f, s55Var.g, this.c));
        } else {
            SkinManager.setImageResource(this, s55Var.d, this.c);
        }
        if (this.d.c()) {
            return;
        }
        setEnabled(false);
    }

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
        }
    }

    public void setOutSetVisibilty(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f = z;
        }
    }

    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.b = i;
        }
    }
}
