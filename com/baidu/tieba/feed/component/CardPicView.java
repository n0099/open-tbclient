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
import com.baidu.tieba.a77;
import com.baidu.tieba.h47;
import com.baidu.tieba.i47;
import com.baidu.tieba.j67;
import com.baidu.tieba.n47;
import com.baidu.tieba.t07;
import com.baidu.tieba.z17;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class CardPicView extends CardFrameView<z17> implements a77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final t07.e c;
    public int d;
    public int e;
    public LinearLayout f;
    public List<ImageView> g;
    public TextView h;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ z17 b;
        public final /* synthetic */ CardPicView c;

        public a(CardPicView cardPicView, int i, z17 z17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardPicView, Integer.valueOf(i), z17Var};
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
            this.b = z17Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Rect rect = new Rect();
                this.c.f.getChildAt(this.a).getGlobalVisibleRect(rect);
                String j = this.b.j(this.a);
                if (!TextUtils.isEmpty(j)) {
                    this.b.i().invoke(this.c.getContext(), Integer.valueOf(this.a), rect, j);
                }
                if (this.b.h().a.size() > this.a) {
                    for (n47 n47Var : this.b.h().a.get(this.a).i) {
                        this.b.f().invoke(n47Var);
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
        this.c = t07.a().a();
        this.g = new ArrayList();
        l(context);
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
                t07.d dVar = new t07.d();
                dVar.a = R.string.J_X05;
                if (i2 == 0) {
                    dVar.b = 5;
                } else if (i2 == i - 1) {
                    dVar.b = 10;
                } else {
                    dVar.b = 0;
                }
                this.c.c(this.g.get(i2), dVar);
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
            t07.d dVar = new t07.d();
            dVar.a = R.string.J_X05;
            dVar.b = 15;
            this.c.c(this.g.get(0), dVar);
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
        this.c = t07.a().a();
        this.g = new ArrayList();
        l(context);
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
        this.c = t07.a().a();
        this.g = new ArrayList();
        l(context);
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

    @Override // com.baidu.tieba.a77
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            EMManager.from(this.h).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0607);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            for (int i = 0; i < 3; i++) {
                this.f.getChildAt(i).setVisibility(8);
            }
            this.h.setVisibility(8);
        }
    }

    public final void j(h47 h47Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, h47Var, i) == null) {
            View childAt = this.f.getChildAt(i);
            if (!(childAt instanceof FrameLayout)) {
                return;
            }
            FrameLayout frameLayout = (FrameLayout) childAt;
            j67.a.b(frameLayout);
            List<i47> list = h47Var.h;
            if (list == null) {
                return;
            }
            for (i47 i47Var : list) {
                j67.a.a(getContext(), i47Var, frameLayout);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.feed.component.CardFrameView
    /* renamed from: k */
    public void e(z17 z17Var) {
        boolean z;
        ImageView.ScaleType scaleType;
        h47 h47Var;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, z17Var) == null) {
            m();
            if (z17Var == null) {
                return;
            }
            List<h47> list = z17Var.h().a;
            if (ListUtils.isEmpty(list)) {
                return;
            }
            int min = Math.min(list.size(), 3);
            float f = 0.0f;
            if (min == 1 && (h47Var = list.get(0)) != null && (i = h47Var.c) != 0) {
                f = (h47Var.b * 1.0f) / i;
            }
            if (min == 1) {
                i(f);
            } else if (min > 1) {
                h(min);
            }
            for (int i2 = 0; i2 < min; i2++) {
                h47 h47Var2 = list.get(i2);
                if (h47Var2 == null) {
                    break;
                }
                j(h47Var2, i2);
                ImageView imageView = this.g.get(i2);
                if (min > 1 && h47Var2.e > 0.0d && h47Var2.f > 0.0d) {
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
                this.c.e(imageView, z, (float) h47Var2.e, (float) h47Var2.f);
                this.c.b(imageView, h47Var2.d);
                this.c.f(this.g.get(i2), h47Var2.a);
                this.f.getChildAt(i2).setOnClickListener(new a(this, i2, z17Var));
            }
            if (list.size() > 3) {
                this.h.setText(getContext().getString(R.string.constrain_image_extra_text, Integer.valueOf(list.size() - 3)));
                this.h.setVisibility(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.h.getLayoutParams();
                layoutParams.width = -2;
                layoutParams.height = this.e;
                this.h.setLayoutParams(layoutParams);
            }
            b();
        }
    }

    public final void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            this.d = getResources().getDimensionPixelSize(R.dimen.tbds10);
            LinearLayout linearLayout = new LinearLayout(context);
            this.f = linearLayout;
            linearLayout.setOrientation(0);
            addView(this.f, new FrameLayout.LayoutParams(-1, -2));
            for (int i = 0; i < 3; i++) {
                ImageView imageView = (ImageView) this.c.create(context);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                FrameLayout frameLayout = new FrameLayout(context);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
                if (i > 0) {
                    frameLayout.setPadding(getImageMargin(), 0, 0, 0);
                }
                this.g.add(imageView);
                frameLayout.addView(imageView, layoutParams);
                this.f.addView(frameLayout, layoutParams2);
            }
            TextView textView = new TextView(context);
            this.h = textView;
            EMManager.from(textView).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X02);
            this.h.setGravity(16);
            int dimens = BdUtilHelper.getDimens(context, R.dimen.M_W_X003);
            this.h.setPadding(dimens, 0, dimens, 0);
            this.e = BdUtilHelper.getDimens(context, R.dimen.tbds52);
            int i2 = this.e;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i2, i2);
            layoutParams3.gravity = 85;
            layoutParams3.rightMargin = BdUtilHelper.getDimens(context, R.dimen.M_W_X004);
            layoutParams3.bottomMargin = BdUtilHelper.getDimens(context, R.dimen.M_H_X003);
            addView(this.h, layoutParams3);
        }
    }
}
