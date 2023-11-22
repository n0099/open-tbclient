package com.baidu.tieba.feed.card;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.ab7;
import com.baidu.tieba.c87;
import com.baidu.tieba.f57;
import com.baidu.tieba.feed.list.TemplateAdapter;
import com.baidu.tieba.feed.widget.ThemeAndStarView;
import com.baidu.tieba.nq6;
import com.baidu.tieba.oa7;
import com.baidu.tieba.pa7;
import com.baidu.tieba.pc7;
import com.baidu.tieba.qa7;
import com.baidu.tieba.sc7;
import com.baidu.tieba.ta7;
import com.baidu.tieba.va7;
import com.baidu.tieba.wa7;
import com.baidu.tieba.x4;
import com.baidu.tieba.xa7;
import com.baidu.tieba.za7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FeedCardView extends RelativeLayout implements va7, pa7, ta7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView a;
    public RelativeLayout b;
    public qa7 c;
    public wa7 d;
    public boolean e;
    public View f;
    public View g;
    public TextView h;
    public ImageView i;
    public ThemeAndStarView j;
    public View.OnClickListener k;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedCardView a;

        public a(FeedCardView feedCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedCardView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.r();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f57 a;
        public final /* synthetic */ FeedCardView b;

        public b(FeedCardView feedCardView, f57 f57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedCardView, f57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = feedCardView;
            this.a = f57Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                nq6.b().c(new c87(this.b.getContext(), this.a));
                this.b.g(this.a.q(), false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedCardView a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public c(FeedCardView feedCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedCardView;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements oa7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f57 a;
        public final /* synthetic */ FeedCardView b;

        public d(FeedCardView feedCardView, f57 f57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedCardView, f57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = feedCardView;
            this.a = f57Var;
        }

        @Override // com.baidu.tieba.oa7.a
        public void a(View view2, ab7<?> ab7Var, za7<?, ?> za7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, view2, ab7Var, za7Var) == null) {
                this.a.i().invoke(this.b.getContext(), this.a);
                if (this.b.d != null) {
                    this.b.d.a();
                }
                this.b.c.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements oa7.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedCardView a;

        public e(FeedCardView feedCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = feedCardView;
        }

        @Override // com.baidu.tieba.oa7.e
        public void a(@NonNull Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.setTag(obj);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f57 a;
        public final /* synthetic */ FeedCardView b;

        public f(FeedCardView feedCardView, f57 f57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedCardView, f57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = feedCardView;
            this.a = f57Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.h().invoke(this.b.getContext(), this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedCardView(@NonNull Context context) {
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
        this.e = false;
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedCardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        this.e = false;
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedCardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.e = false;
        f();
    }

    public final void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                x4.b(this);
            } else {
                x4.a(this);
            }
        }
    }

    public final void j(@NonNull f57<?> f57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, f57Var) == null) {
            boolean k = k(f57Var);
            if (i(f57Var)) {
                k = true;
            }
            if (k) {
                this.b.setVisibility(0);
            } else {
                this.b.setVisibility(8);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            if (motionEvent.getAction() == 1 && (onClickListener = this.k) != null) {
                onClickListener.onClick(this);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.pa7
    public void setOnTemplateClickListener(@NonNull wa7 wa7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, wa7Var) == null) {
            this.d = wa7Var;
        }
    }

    @Override // com.baidu.tieba.va7
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (int i = 0; i < this.a.getChildCount(); i++) {
                View childAt = this.a.getChildAt(i);
                if (childAt instanceof va7) {
                    ((va7) childAt).b();
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"NotifyDataSetChanged"})
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onAttachedToWindow();
            if (this.e) {
                this.c.notifyDataSetChanged();
                r();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDetachedFromWindow();
            this.e = true;
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RecyclerView recyclerView = new RecyclerView(getContext());
            this.a = recyclerView;
            recyclerView.setFocusableInTouchMode(false);
            this.a.setNestedScrollingEnabled(false);
            this.a.setOverScrollMode(2);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setRecycleChildrenOnDetach(true);
            this.a.setLayoutManager(linearLayoutManager);
            this.a.setRecycledViewPool(sc7.f().g(getContext()));
            this.a.setId(R.id.obfuscated_res_0x7f0905d4);
            TemplateAdapter templateAdapter = new TemplateAdapter();
            this.c = templateAdapter;
            templateAdapter.i(new pc7());
            this.c.i(new xa7());
            this.c.c(this.a, true);
            addView(this.a, new RelativeLayout.LayoutParams(-1, -2));
            this.b = new RelativeLayout(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(6, R.id.obfuscated_res_0x7f0905d4);
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f0905d4);
            addView(this.b, layoutParams);
            r();
        }
    }

    public final void g(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || this.f == null) {
            return;
        }
        if (z2) {
            this.i.setVisibility(4);
            this.h.setVisibility(4);
        } else {
            this.i.setVisibility(0);
            this.h.setVisibility(0);
        }
        if (z) {
            WebPManager.setPureDrawable(this.i, R.drawable.icon_pure_frs_chosen_22, R.color.CAM_X0304, null);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0304);
            this.g.setVisibility(0);
        } else {
            WebPManager.setPureDrawable(this.i, R.drawable.icon_pure_frs_select_22, R.color.CAM_X0107, null);
            SkinManager.setViewTextColor(this.h, (int) R.drawable.selector_comment_and_prise_item_text_color);
            this.g.setVisibility(8);
        }
        EMManager.from(this.g).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void h(f57<?> f57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, f57Var) == null) {
            this.e = false;
            e(f57Var.o());
            this.c.h(new d(this, f57Var));
            setTag(null);
            this.c.k(new e(this));
            this.c.setList(f57Var.c());
            this.k = new f(this, f57Var);
            j(f57Var);
            r();
        }
    }

    public final boolean k(@NonNull f57<?> f57Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, f57Var)) == null) {
            ThemeAndStarView themeAndStarView = this.j;
            if (themeAndStarView != null) {
                themeAndStarView.setVisibility(8);
            }
            boolean z = false;
            if (f57Var.l() == null) {
                return false;
            }
            if (this.j == null) {
                ThemeAndStarView themeAndStarView2 = new ThemeAndStarView(getContext());
                this.j = themeAndStarView2;
                this.b.addView(themeAndStarView2);
            }
            ThemeAndStarView themeAndStarView3 = this.j;
            if (f57Var.f() != null) {
                z = true;
            }
            themeAndStarView3.setIsNegativeFeedbackShow(z);
            return this.j.c(f57Var.l());
        }
        return invokeL.booleanValue;
    }

    public final boolean i(@NonNull f57<?> f57Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, f57Var)) == null) {
            if (f57Var.p()) {
                if (this.f == null) {
                    View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d01b0, (ViewGroup) null);
                    this.f = inflate;
                    this.g = inflate.findViewById(R.id.obfuscated_res_0x7f091722);
                    this.h = (TextView) this.f.findViewById(R.id.manage_select_txt);
                    this.i = (ImageView) this.f.findViewById(R.id.manage_select_img);
                    this.g.setAlpha(0.5f);
                    this.b.addView(this.f, new RelativeLayout.LayoutParams(-1, -1));
                }
                if (f57Var.b()) {
                    this.f.setOnClickListener(new b(this, f57Var));
                    g(f57Var.q(), false);
                } else {
                    this.f.setOnClickListener(new c(this));
                    g(true, true);
                }
                return true;
            }
            View view2 = this.f;
            if (view2 == null) {
                return false;
            }
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f);
            }
            this.f = null;
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ta7
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.a.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0205));
            EMManager.from(this.a).setCorner(R.string.J_X06).setBackGroundSelectorColor(R.color.CAM_X0205, R.color.CAM_X0206);
            this.a.post(new a(this));
            ThemeAndStarView themeAndStarView = this.j;
            if (themeAndStarView != null) {
                themeAndStarView.b();
            }
        }
    }
}
