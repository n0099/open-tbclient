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
import com.repackage.i05;
import com.repackage.p05;
import com.repackage.u05;
/* loaded from: classes3.dex */
public class BLauncher extends ImageView implements p05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public int b;
    public int c;
    public u05 d;
    public Drawable e;
    public boolean f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BLauncher(Context context, u05 u05Var) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, u05Var};
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
        if (u05Var == null) {
            return;
        }
        this.d = u05Var;
        setIcon();
        setToolId(u05Var.c);
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
        this.d.o = true;
        invalidate();
    }

    @Override // com.repackage.p05
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
        e();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.draw(canvas);
            if (this.d.o) {
                this.e = SkinManager.getDrawable(R.drawable.icon_news_red_dot);
                int width = getWidth();
                int intrinsicHeight = this.e.getIntrinsicHeight();
                this.e.setBounds(getWidth() - this.e.getIntrinsicWidth(), 0, width, intrinsicHeight);
                this.e.draw(canvas);
            }
        }
    }

    @Override // com.repackage.p05
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.d.o = false;
            invalidate();
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

    @Override // com.repackage.p05
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b : invokeV.intValue;
    }

    @Override // com.repackage.p05
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c();
            setVisibility(8);
        }
    }

    @Override // com.repackage.j05
    public void onAction(i05 i05Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, i05Var) == null) && i05Var != null && i05Var.a == 2) {
            Object obj = i05Var.c;
            if (obj == null) {
                c();
            } else if (obj instanceof String) {
                a((String) obj);
            }
        }
    }

    @Override // com.repackage.p05
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
        u05 u05Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (u05Var = this.d) == null) {
            return;
        }
        if (u05Var.g) {
            SvgManager svgManager = SvgManager.getInstance();
            u05 u05Var2 = this.d;
            setImageDrawable(svgManager.getSeletableDrawableForEditorTools(u05Var2.d, u05Var2.e, this.c));
        } else if (u05Var.h) {
            setImageDrawable(WebPManager.getSeletableDrawableForEditorToolsEM(u05Var.d, u05Var.e, this.c));
        } else {
            SkinManager.setImageResource(this, u05Var.d, this.c);
        }
        if (this.d.c()) {
            return;
        }
        setEnabled(false);
    }

    @Override // com.repackage.p05
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
