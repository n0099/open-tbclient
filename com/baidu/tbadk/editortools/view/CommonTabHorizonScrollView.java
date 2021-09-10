package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.x.z.a;
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
/* loaded from: classes6.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public DeskLinearLayout f48358e;

    /* renamed from: f  reason: collision with root package name */
    public int f48359f;

    /* renamed from: g  reason: collision with root package name */
    public List<c.a.q0.x.z.a> f48360g;

    /* renamed from: h  reason: collision with root package name */
    public CommonTabWidgetView.b f48361h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout.LayoutParams f48362i;

    /* renamed from: j  reason: collision with root package name */
    public int f48363j;
    public int k;
    public TextView l;
    public View m;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final int f48364e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CommonTabHorizonScrollView f48365f;

        public /* synthetic */ b(CommonTabHorizonScrollView commonTabHorizonScrollView, int i2, a aVar) {
            this(commonTabHorizonScrollView, i2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48365f.f48361h.onTabSelected(this.f48364e);
            }
        }

        public b(CommonTabHorizonScrollView commonTabHorizonScrollView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonTabHorizonScrollView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48365f = commonTabHorizonScrollView;
            this.f48364e = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonTabHorizonScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f48359f = -1;
        c();
    }

    public void addTabWidget(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            b(bVar);
            invalidate();
        }
    }

    public final TbImageView b(a.b bVar) {
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
            int i2 = this.k;
            int i3 = this.f48363j;
            tbImageView.setPadding(i2, i3, i2, i3);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            SkinManager.setImageResource(tbImageView, bVar.f15181b);
            linearLayout.setOnClickListener(new b(this, this.f48358e.getChildCount() - 1, null));
            this.f48358e.addView(linearLayout, this.f48358e.getChildCount() - 1, this.f48362i);
            return tbImageView;
        }
        return (TbImageView) invokeL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            removeAllViews();
            setFillViewport(true);
            setHorizontalScrollBarEnabled(false);
            DeskLinearLayout deskLinearLayout = new DeskLinearLayout(getContext());
            this.f48358e = deskLinearLayout;
            deskLinearLayout.setOrientation(0);
            this.f48358e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.f48358e.setBaselineAligned(false);
            addView(this.f48358e);
            this.f48363j = getResources().getDimensionPixelSize(R.dimen.ds8);
            this.k = getResources().getDimensionPixelSize(R.dimen.ds10);
            this.f48358e.setPadding(0, getResources().getDimensionPixelSize(R.dimen.ds10), 0, 0);
            this.f48362i = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.ds106), -1);
            this.m = new View(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            this.m.setLayoutParams(layoutParams);
            SkinManager.setBackgroundResource(this.m, R.drawable.bg_expression_bar_n);
            this.f48358e.addView(this.m);
        }
    }

    public void onChangeSkin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            TextView textView = this.l;
            if (textView != null) {
                SkinManager.setBackgroundResource(textView, R.drawable.icon_news_head_prompt_one, i2);
                this.l.setTextColor((i2 == 1 || i2 == 4) ? Color.parseColor("#ffd2d2d2") : -1);
            }
            int childCount = this.f48358e.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.f48358e.getChildAt(i3);
                if (childAt != null) {
                    SkinManager.setBackgroundResource(childAt, R.drawable.bg_expression_bar, i2);
                    if (i3 == childCount - 1) {
                        return;
                    }
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i3 == this.f48359f) {
                            SkinManager.setImageResource(tbImageView, this.f48360g.get(i3).f().f15180a, i2);
                        } else {
                            SkinManager.setImageResource(tbImageView, this.f48360g.get(i3).f().f15181b, i2);
                        }
                    }
                }
            }
        }
    }

    public void removeTabWidget(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f48358e.removeViewAt(i2);
            int i3 = this.f48359f;
            if (i3 != i2) {
                if (i3 > i2) {
                    this.f48359f = i3 - 1;
                    return;
                }
                return;
            }
            int i4 = i3 - 1;
            this.f48359f = i4;
            if (i4 < 0) {
                i4 = 0;
            }
            setCurrentTab(i4);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f48359f = -1;
            this.f48358e.removeAllViews();
        }
    }

    public void setCurrentTab(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || i2 == (i3 = this.f48359f)) {
            return;
        }
        if (i3 != -1) {
            LinearLayout linearLayout = (LinearLayout) this.f48358e.getChildAt(i3);
            if (linearLayout == null) {
                return;
            }
            linearLayout.setSelected(false);
            ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.f48360g.get(this.f48359f).f().f15181b);
        }
        this.f48359f = i2;
        LinearLayout linearLayout2 = (LinearLayout) this.f48358e.getChildAt(i2);
        if (linearLayout2 == null) {
            return;
        }
        linearLayout2.setSelected(true);
        SkinManager.setImageResource((TbImageView) linearLayout2.getChildAt(0), this.f48360g.get(this.f48359f).f().f15180a);
    }

    public void setDatas(List<c.a.q0.x.z.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f48360g = list;
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f48361h = bVar;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48359f = -1;
        c();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48359f = -1;
        c();
    }
}
