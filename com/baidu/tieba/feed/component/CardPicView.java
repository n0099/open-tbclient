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
import com.baidu.tieba.a87;
import com.baidu.tieba.h37;
import com.baidu.tieba.i47;
import com.baidu.tieba.m75;
import com.baidu.tieba.vi;
import com.baidu.tieba.x57;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class CardPicView extends CardFrameView<i47> implements a87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final h37.d c;
    public int d;
    public int e;
    public LinearLayout f;
    public TextView g;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ i47 b;
        public final /* synthetic */ CardPicView c;

        public a(CardPicView cardPicView, int i, i47 i47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardPicView, Integer.valueOf(i), i47Var};
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
            this.b = i47Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Rect rect = new Rect();
                this.c.f.getChildAt(this.a).getGlobalVisibleRect(rect);
                if (!TextUtils.isEmpty(this.b.f())) {
                    this.b.e().invoke(this.c.getContext(), Integer.valueOf(this.a), rect, this.b.f());
                }
                this.b.c().invoke(this.b.g());
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
        this.c = h37.a().a();
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
        this.c = h37.a().a();
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
        this.c = h37.a().a();
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

    @Override // com.baidu.tieba.a87
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            m75 d = m75.d(this.g);
            d.w(R.color.CAM_X0101);
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
                h37.c cVar = new h37.c();
                cVar.a = R.string.J_X05;
                if (i2 == 0) {
                    cVar.b = 5;
                } else if (i2 == i - 1) {
                    cVar.b = 10;
                } else {
                    cVar.b = 0;
                }
                this.c.b(childAt, cVar);
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
            h37.c cVar = new h37.c();
            cVar.a = R.string.J_X05;
            cVar.b = 15;
            this.c.b(childAt, cVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.feed.component.CardFrameView
    /* renamed from: j */
    public void e(i47 i47Var) {
        boolean z;
        ImageView.ScaleType scaleType;
        x57 x57Var;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, i47Var) == null) {
            l();
            if (i47Var == null) {
                return;
            }
            List<x57> list = i47Var.d().a;
            if (ListUtils.isEmpty(list)) {
                return;
            }
            int min = Math.min(list.size(), 3);
            float f = 0.0f;
            if (min == 1 && (x57Var = list.get(0)) != null && (i = x57Var.c) != 0) {
                f = (x57Var.b * 1.0f) / i;
            }
            if (min == 1) {
                i(f);
            } else if (min > 1) {
                h(min);
            }
            for (int i2 = 0; i2 < min; i2++) {
                x57 x57Var2 = list.get(i2);
                if (x57Var2 == null) {
                    break;
                }
                ImageView imageView = (ImageView) this.f.getChildAt(i2);
                if (min > 1 && x57Var2.d > 0.0d && x57Var2.e > 0.0d) {
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
                this.c.d(imageView, z, (float) x57Var2.d, (float) x57Var2.e);
                this.c.e(this.f.getChildAt(i2), x57Var2.a);
                this.f.getChildAt(i2).setOnClickListener(new a(this, i2, i47Var));
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
            m75 d = m75.d(textView);
            d.B(R.dimen.T_X09);
            d.C(R.string.F_X02);
            this.g.setGravity(16);
            int g = vi.g(context, R.dimen.M_W_X003);
            this.g.setPadding(g, 0, g, 0);
            this.e = vi.g(context, R.dimen.tbds52);
            int i2 = this.e;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, i2);
            layoutParams2.gravity = 85;
            layoutParams2.rightMargin = vi.g(context, R.dimen.M_W_X004);
            layoutParams2.bottomMargin = vi.g(context, R.dimen.M_H_X003);
            addView(this.g, layoutParams2);
        }
    }
}
