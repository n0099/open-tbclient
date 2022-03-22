package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.o0.w.b0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.view.CommonTabWidgetView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DeskLinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public int f30547b;

    /* renamed from: c  reason: collision with root package name */
    public List<c.a.o0.w.b0.a> f30548c;

    /* renamed from: d  reason: collision with root package name */
    public CommonTabWidgetView.b f30549d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout.LayoutParams f30550e;

    /* renamed from: f  reason: collision with root package name */
    public int f30551f;

    /* renamed from: g  reason: collision with root package name */
    public int f30552g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f30553h;
    public View i;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CommonTabHorizonScrollView f30554b;

        public /* synthetic */ b(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(commonTabHorizonScrollView, i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f30554b.f30549d.a(this.a);
            }
        }

        public b(CommonTabHorizonScrollView commonTabHorizonScrollView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonTabHorizonScrollView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30554b = commonTabHorizonScrollView;
            this.a = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
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
        this.f30547b = -1;
        d();
    }

    public void b(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            c(bVar);
            invalidate();
        }
    }

    public final TbImageView c(a.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
            if (bVar == null) {
                return null;
            }
            LinearLayout linearLayout = new LinearLayout(getContext());
            TbImageView tbImageView = new TbImageView(getContext());
            linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(-1, -1));
            SkinManager.setBackgroundResource(linearLayout, R.drawable.bg_expression_bar);
            int i = this.f30552g;
            int i2 = this.f30551f;
            tbImageView.setPadding(i, i2, i, i2);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            SkinManager.setImageResource(tbImageView, bVar.f11507b);
            linearLayout.setOnClickListener(new b(this, this.a.getChildCount() - 1, null));
            this.a.addView(linearLayout, this.a.getChildCount() - 1, this.f30550e);
            return tbImageView;
        }
        return (TbImageView) invokeL.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            removeAllViews();
            setFillViewport(true);
            setHorizontalScrollBarEnabled(false);
            DeskLinearLayout deskLinearLayout = new DeskLinearLayout(getContext());
            this.a = deskLinearLayout;
            deskLinearLayout.setOrientation(0);
            this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.a.setBaselineAligned(false);
            addView(this.a);
            this.f30551f = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702fb);
            this.f30552g = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070229);
            this.a.setPadding(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070229), 0, 0);
            this.f30550e = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07022b), -1);
            this.i = new View(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            this.i.setLayoutParams(layoutParams);
            SkinManager.setBackgroundResource(this.i, R.drawable.bg_expression_bar_n);
            this.a.addView(this.i);
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            TextView textView = this.f30553h;
            if (textView != null) {
                SkinManager.setBackgroundResource(textView, R.drawable.icon_news_head_prompt_one, i);
                this.f30553h.setTextColor((i == 1 || i == 4) ? Color.parseColor("#ffd2d2d2") : -1);
            }
            int childCount = this.a.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.a.getChildAt(i2);
                if (childAt != null) {
                    SkinManager.setBackgroundResource(childAt, R.drawable.bg_expression_bar, i);
                    if (i2 == childCount - 1) {
                        return;
                    }
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.f30547b) {
                            SkinManager.setImageResource(tbImageView, this.f30548c.get(i2).i().a, i);
                        } else {
                            SkinManager.setImageResource(tbImageView, this.f30548c.get(i2).i().f11507b, i);
                        }
                    }
                }
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f30547b = -1;
            this.a.removeAllViews();
        }
    }

    public void setCurrentTab(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || i == (i2 = this.f30547b)) {
            return;
        }
        if (i2 != -1) {
            LinearLayout linearLayout = (LinearLayout) this.a.getChildAt(i2);
            if (linearLayout == null) {
                return;
            }
            linearLayout.setSelected(false);
            ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.f30548c.get(this.f30547b).i().f11507b);
        }
        this.f30547b = i;
        LinearLayout linearLayout2 = (LinearLayout) this.a.getChildAt(i);
        if (linearLayout2 == null) {
            return;
        }
        linearLayout2.setSelected(true);
        SkinManager.setImageResource((TbImageView) linearLayout2.getChildAt(0), this.f30548c.get(this.f30547b).i().a);
    }

    public void setDatas(List<c.a.o0.w.b0.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.f30548c = list;
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f30549d = bVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet) {
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
        this.f30547b = -1;
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonTabHorizonScrollView(Context context) {
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
        this.f30547b = -1;
        d();
    }
}
