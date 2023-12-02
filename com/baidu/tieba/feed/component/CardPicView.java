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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.e87;
import com.baidu.tieba.k37;
import com.baidu.tieba.kb7;
import com.baidu.tieba.sa7;
import com.baidu.tieba.u47;
import com.baidu.tieba.w77;
import com.baidu.tieba.x77;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class CardPicView extends CardFrameView<u47> implements kb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final k37.e d;
    public int e;
    public int f;
    public LinearLayout g;
    public List<ImageView> h;
    public TextView i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ u47 b;
        public final /* synthetic */ CardPicView c;

        public a(CardPicView cardPicView, int i, u47 u47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardPicView, Integer.valueOf(i), u47Var};
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
            this.b = u47Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Rect rect = new Rect();
                this.c.g.getChildAt(this.a).getGlobalVisibleRect(rect);
                String n = this.b.n(this.a);
                if (!TextUtils.isEmpty(n)) {
                    this.b.m().invoke(this.c.getContext(), Integer.valueOf(this.a), rect, n, this.b);
                }
                if (this.b.l().a.size() > this.a) {
                    for (e87 e87Var : this.b.l().a.get(this.a).i) {
                        this.b.j().invoke(e87Var);
                    }
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
        this.d = k37.a().a();
        this.h = new ArrayList();
        i(context);
    }

    public final void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            for (int i2 = 0; i2 < i; i2++) {
                View childAt = this.g.getChildAt(i2);
                childAt.setVisibility(0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                layoutParams.width = getMinImageWidth();
                layoutParams.height = getMinImageWidth();
                childAt.setLayoutParams(layoutParams);
                k37.d dVar = new k37.d();
                dVar.a = R.string.J_X05;
                if (i2 == 0) {
                    dVar.b = 5;
                } else if (i2 == i - 1) {
                    dVar.b = 10;
                } else {
                    dVar.b = 0;
                }
                this.d.c(this.h.get(i2), dVar);
            }
        }
    }

    public final void e(float f) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) == null) {
            View childAt = this.g.getChildAt(0);
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
            k37.d dVar = new k37.d();
            dVar.a = R.string.J_X05;
            dVar.b = 15;
            this.d.c(this.h.get(0), dVar);
        }
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
        this.d = k37.a().a();
        this.h = new ArrayList();
        i(context);
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
        this.d = k37.a().a();
        this.h = new ArrayList();
        i(context);
    }

    private int getImageMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    private int getMinImageWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            return (getMeasuredWidth() - (getImageMargin() * 2)) / 3;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.kb7
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            EMManager.from(this.i).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0607);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            for (int i = 0; i < 3; i++) {
                this.g.getChildAt(i).setVisibility(8);
            }
            this.i.setVisibility(8);
        }
    }

    public final void g(w77 w77Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, w77Var, i) == null) {
            View childAt = this.g.getChildAt(i);
            if (!(childAt instanceof FrameLayout)) {
                return;
            }
            FrameLayout frameLayout = (FrameLayout) childAt;
            sa7.a.b(frameLayout);
            List<x77> list = w77Var.h;
            if (list == null) {
                return;
            }
            for (x77 x77Var : list) {
                sa7.a.a(getContext(), x77Var, frameLayout);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.feed.component.CardFrameView
    /* renamed from: h */
    public void a(u47 u47Var) {
        boolean z;
        ImageView.ScaleType scaleType;
        w77 w77Var;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, u47Var) == null) {
            j();
            if (u47Var == null) {
                return;
            }
            List<w77> list = u47Var.l().a;
            if (ListUtils.isEmpty(list)) {
                return;
            }
            int min = Math.min(list.size(), 3);
            float f = 0.0f;
            if (min == 1 && (w77Var = list.get(0)) != null && (i = w77Var.c) != 0) {
                f = (w77Var.b * 1.0f) / i;
            }
            if (min == 1) {
                e(f);
            } else if (min > 1) {
                d(min);
            }
            for (int i2 = 0; i2 < min; i2++) {
                w77 w77Var2 = list.get(i2);
                if (w77Var2 == null) {
                    break;
                }
                g(w77Var2, i2);
                ImageView imageView = this.h.get(i2);
                if (min > 1 && w77Var2.e > 0.0d && w77Var2.f > 0.0d) {
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
                this.d.e(imageView, z, (float) w77Var2.e, (float) w77Var2.f);
                this.d.b(imageView, w77Var2.d);
                this.d.f(this.h.get(i2), w77Var2.a);
                this.g.getChildAt(i2).setOnClickListener(new a(this, i2, u47Var));
            }
            if (list.size() > 3) {
                this.i.setText(getContext().getString(R.string.constrain_image_extra_text, Integer.valueOf(list.size() - 3)));
                this.i.setVisibility(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.i.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = this.f;
                this.i.setLayoutParams(layoutParams);
            }
            f();
        }
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.e = getResources().getDimensionPixelSize(R.dimen.tbds10);
            LinearLayout linearLayout = new LinearLayout(context);
            this.g = linearLayout;
            linearLayout.setOrientation(0);
            addView(this.g, new FrameLayout.LayoutParams(-1, -2));
            for (int i = 0; i < 3; i++) {
                ImageView imageView = (ImageView) this.d.create(context);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                FrameLayout frameLayout = new FrameLayout(context);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
                if (i > 0) {
                    frameLayout.setPadding(getImageMargin(), 0, 0, 0);
                }
                this.h.add(imageView);
                frameLayout.addView(imageView, layoutParams);
                this.g.addView(frameLayout, layoutParams2);
            }
            TextView textView = new TextView(context);
            this.i = textView;
            EMManager.from(textView).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X02);
            this.i.setGravity(16);
            int dimens = BdUtilHelper.getDimens(context, R.dimen.M_W_X003);
            this.i.setPadding(dimens, 0, dimens, 0);
            this.f = BdUtilHelper.getDimens(context, R.dimen.tbds52);
            int i2 = this.f;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i2, i2);
            layoutParams3.gravity = 85;
            layoutParams3.rightMargin = BdUtilHelper.getDimens(context, R.dimen.M_W_X004);
            layoutParams3.bottomMargin = BdUtilHelper.getDimens(context, R.dimen.M_H_X003);
            addView(this.i, layoutParams3);
        }
    }
}
