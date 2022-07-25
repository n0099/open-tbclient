package com.baidu.tbadk.editortools.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.repackage.y35;
import java.util.List;
/* loaded from: classes3.dex */
public class CommonTabHorizonScrollView extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DeskLinearLayout a;
    public int b;
    public List<y35> c;
    public CommonTabWidgetView.b d;
    public LinearLayout.LayoutParams e;
    public int f;
    public int g;
    public TextView h;
    public View i;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;
        public final /* synthetic */ CommonTabHorizonScrollView b;

        public /* synthetic */ b(CommonTabHorizonScrollView commonTabHorizonScrollView, int i, a aVar) {
            this(commonTabHorizonScrollView, i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.d.a(this.a);
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
            this.b = commonTabHorizonScrollView;
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
        this.b = -1;
        d();
    }

    public void b(y35.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            c(bVar);
            invalidate();
        }
    }

    public final TbImageView c(y35.b bVar) {
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
            int i = this.g;
            int i2 = this.f;
            tbImageView.setPadding(i, i2, i, i2);
            linearLayout.setClickable(true);
            linearLayout.setFocusable(true);
            SkinManager.setImageResource(tbImageView, bVar.b);
            linearLayout.setOnClickListener(new b(this, this.a.getChildCount() - 1, null));
            this.a.addView(linearLayout, this.a.getChildCount() - 1, this.e);
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
            this.f = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070302);
            this.g = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070230);
            this.a.setPadding(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070230), 0, 0);
            this.e = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070232), -1);
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
            TextView textView = this.h;
            if (textView != null) {
                SkinManager.setBackgroundResource(textView, R.drawable.icon_news_head_prompt_one, i);
                this.h.setTextColor((i == 1 || i == 4) ? Color.parseColor("#ffd2d2d2") : -1);
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
                        if (i2 == this.b) {
                            SkinManager.setImageResource(tbImageView, this.c.get(i2).f().a, i);
                        } else {
                            SkinManager.setImageResource(tbImageView, this.c.get(i2).f().b, i);
                        }
                    }
                }
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b = -1;
            this.a.removeAllViews();
        }
    }

    public void setCurrentTab(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || i == (i2 = this.b)) {
            return;
        }
        if (i2 != -1) {
            LinearLayout linearLayout = (LinearLayout) this.a.getChildAt(i2);
            if (linearLayout == null) {
                return;
            }
            linearLayout.setSelected(false);
            ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.c.get(this.b).f().b);
        }
        this.b = i;
        LinearLayout linearLayout2 = (LinearLayout) this.a.getChildAt(i);
        if (linearLayout2 == null) {
            return;
        }
        linearLayout2.setSelected(true);
        SkinManager.setImageResource((TbImageView) linearLayout2.getChildAt(0), this.c.get(this.b).f().a);
    }

    public void setDatas(List<y35> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.c = list;
        }
    }

    public void setOnTabSelectedListener(CommonTabWidgetView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.d = bVar;
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
        this.b = -1;
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
        this.b = -1;
        d();
    }
}
