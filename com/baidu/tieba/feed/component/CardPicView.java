package com.baidu.tieba.feed.component;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.c67;
import com.baidu.tieba.d85;
import com.baidu.tieba.fc7;
import com.baidu.tieba.h77;
import com.baidu.tieba.p97;
import com.baidu.tieba.sc7;
import com.baidu.tieba.u97;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class CardPicView extends CardFrameView<h77> implements fc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c67.e c;
    public int d;
    public int e;
    public LinearLayout f;
    public TextView g;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ h77 b;
        public final /* synthetic */ CardPicView c;

        public a(CardPicView cardPicView, int i, h77 h77Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardPicView, Integer.valueOf(i), h77Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cardPicView;
            this.a = i;
            this.b = h77Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Rect rect = new Rect();
                this.c.f.getChildAt(this.a).getGlobalVisibleRect(rect);
                if (!TextUtils.isEmpty(this.b.j())) {
                    this.b.i().invoke(this.c.getContext(), Integer.valueOf(this.a), rect, this.b.j());
                }
                for (u97 u97Var : this.b.k()) {
                    sc7.a.b(u97Var, this.b.g() + 1);
                    this.b.f().invoke(u97Var);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPicView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.c = c67.a().a();
        k(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPicView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = c67.a().a();
        k(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPicView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.c = c67.a().a();
        k(context);
    }

    private int getImageMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    private int getMinImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            return (getWidth() - (getImageMargin() * 2)) / 3;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.fc7
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d85 d = d85.d(this.g);
            d.x(R.color.CAM_X0101);
            d.o(R.string.J_X01);
            d.f(R.color.CAM_X0607);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (int i = 0; i < 3; i++) {
                this.f.getChildAt(i).setVisibility(8);
            }
            this.g.setVisibility(8);
        }
    }

    public final void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            for (int i2 = 0; i2 < i; i2++) {
                View childAt = this.f.getChildAt(i2);
                childAt.setVisibility(0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                layoutParams.width = getMinImageWidth();
                layoutParams.height = getMinImageWidth();
                childAt.setLayoutParams(layoutParams);
                c67.d dVar = new c67.d();
                dVar.a = R.string.J_X05;
                if (i2 == 0) {
                    dVar.b = 5;
                } else if (i2 == i - 1) {
                    dVar.b = 10;
                } else {
                    dVar.b = 0;
                }
                this.c.c(childAt, dVar);
            }
        }
    }

    public final void i(float f) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
            View childAt = this.f.getChildAt(0);
            childAt.setVisibility(0);
            int minImageWidth = (getMinImageWidth() * 2) + getImageMargin();
            int i2 = (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1));
            if (i2 == 0) {
                i = minImageWidth;
            } else if (i2 > 0) {
                i = (minImageWidth * 3) / 4;
            } else {
                i = (minImageWidth * 4) / 3;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.width = minImageWidth;
            layoutParams.height = i;
            childAt.setLayoutParams(layoutParams);
            c67.d dVar = new c67.d();
            dVar.a = R.string.J_X05;
            dVar.b = 15;
            this.c.c(childAt, dVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.feed.component.CardFrameView
    /* renamed from: j */
    public void e(h77 h77Var) {
        boolean z;
        ImageView.ScaleType scaleType;
        p97 p97Var;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, h77Var) == null) {
            l();
            if (h77Var == null) {
                return;
            }
            List<p97> list = h77Var.h().a;
            if (ListUtils.isEmpty(list)) {
                return;
            }
            int min = Math.min(list.size(), 3);
            float f = 0.0f;
            if (min == 1 && (p97Var = list.get(0)) != null && (i = p97Var.c) != 0) {
                f = (p97Var.b * 1.0f) / i;
            }
            if (min == 1) {
                i(f);
            } else if (min > 1) {
                h(min);
            }
            for (int i2 = 0; i2 < min; i2++) {
                p97 p97Var2 = list.get(i2);
                if (p97Var2 == null) {
                    break;
                }
                ImageView imageView = (ImageView) this.f.getChildAt(i2);
                if (min > 1 && p97Var2.e > 0.0d && p97Var2.f > 0.0d) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    scaleType = ImageView.ScaleType.MATRIX;
                } else {
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                }
                imageView.setScaleType(scaleType);
                this.c.e(imageView, z, (float) p97Var2.e, (float) p97Var2.f);
                this.c.b(imageView, p97Var2.d);
                this.c.f(this.f.getChildAt(i2), p97Var2.a);
                this.f.getChildAt(i2).setOnClickListener(new a(this, i2, h77Var));
            }
            if (list.size() > 3) {
                this.g.setText(getContext().getString(R.string.constrain_image_extra_text, Integer.valueOf(list.size() - 3)));
                this.g.setVisibility(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.g.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = this.e;
                this.g.setLayoutParams(layoutParams);
            }
            b();
        }
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.d = getResources().getDimensionPixelSize(R.dimen.tbds10);
            LinearLayout linearLayout = new LinearLayout(context);
            this.f = linearLayout;
            linearLayout.setOrientation(0);
            addView(this.f, new FrameLayout.LayoutParams(-1, -2));
            for (int i = 0; i < 3; i++) {
                ImageView imageView = (ImageView) this.c.create(context);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                if (i > 0) {
                    layoutParams.leftMargin = getImageMargin();
                }
                this.f.addView(imageView, layoutParams);
            }
            TextView textView = new TextView(context);
            this.g = textView;
            d85 d = d85.d(textView);
            d.C(R.dimen.T_X09);
            d.D(R.string.F_X02);
            this.g.setGravity(16);
            int g = yi.g(context, R.dimen.M_W_X003);
            this.g.setPadding(g, 0, g, 0);
            this.e = yi.g(context, R.dimen.tbds52);
            int i2 = this.e;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, i2);
            layoutParams2.gravity = 85;
            layoutParams2.rightMargin = yi.g(context, R.dimen.M_W_X004);
            layoutParams2.bottomMargin = yi.g(context, R.dimen.M_H_X003);
            addView(this.g, layoutParams2);
        }
    }
}
