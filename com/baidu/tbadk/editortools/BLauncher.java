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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.lb5;
import com.baidu.tieba.p15;
import com.baidu.tieba.sb5;
import com.baidu.tieba.wb5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BLauncher extends ImageView implements sb5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public int b;
    public int c;
    public wb5 d;
    public Drawable e;
    public boolean f;

    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BLauncher(Context context, wb5 wb5Var) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, wb5Var};
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
        if (wb5Var == null) {
            return;
        }
        this.d = wb5Var;
        setIcon();
        setToolId(wb5Var.c);
    }

    @Override // com.baidu.tieba.mb5
    public void A(lb5 lb5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, lb5Var) == null) && lb5Var != null && lb5Var.a == 2) {
            Object obj = lb5Var.c;
            if (obj == null) {
                b();
            } else if (obj instanceof String) {
                a((String) obj);
            }
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

    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || getVisibility() == 8 || TextUtils.isEmpty(str)) {
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
        this.a.setGravity(17);
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X002);
        this.a.setPadding(dimenPixelSize, 0, dimenPixelSize, 0);
        if (!str.equals(" ")) {
            p15 d = p15.d(this.a);
            d.v(R.color.CAM_X0101);
            d.z(R.dimen.T_X10);
            d.A(R.string.F_X02);
            this.a.setText(str);
            SkinManager.setBackgroundResource(this.a, R.drawable.icon_news_red_dot_one_number, this.c);
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
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (textView = this.a) != null) {
            textView.setVisibility(8);
            e0();
        }
    }

    @Override // com.baidu.tieba.sb5
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.sb5
    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.d.q = false;
            invalidate();
        }
    }

    public boolean getIsOutSetVisibility() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public TextView getNotice() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sb5
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.sb5
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            b();
            setVisibility(8);
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

    @Override // com.baidu.tieba.sb5
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
        wb5 wb5Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || (wb5Var = this.d) == null) {
            return;
        }
        if (wb5Var.i) {
            SvgManager svgManager = SvgManager.getInstance();
            wb5 wb5Var2 = this.d;
            setImageDrawable(svgManager.getSeletableDrawableForEditorTools(wb5Var2.d, wb5Var2.e, this.c));
        } else if (wb5Var.j) {
            setImageDrawable(WebPManager.getSeletableDrawableForEditorToolsEM(wb5Var.d, wb5Var.e, wb5Var.f, wb5Var.g, this.c));
        } else {
            SkinManager.setImageResource(this, wb5Var.d, this.c);
        }
        if (!this.d.c()) {
            setEnabled(false);
        }
    }
}
