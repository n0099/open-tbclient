package com.baidu.tieba.feed.card;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.c87;
import com.baidu.tieba.d87;
import com.baidu.tieba.e57;
import com.baidu.tieba.e87;
import com.baidu.tieba.feed.list.TemplateAdapter;
import com.baidu.tieba.h87;
import com.baidu.tieba.j87;
import com.baidu.tieba.k87;
import com.baidu.tieba.n87;
import com.baidu.tieba.n9;
import com.baidu.tieba.o87;
import com.baidu.tieba.p75;
import com.baidu.tieba.s97;
import com.baidu.tieba.v97;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FeedCardView extends FrameLayout implements j87, d87, h87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView a;
    public RelativeLayout b;
    public e87 c;
    public k87 d;
    public boolean e;

    /* loaded from: classes5.dex */
    public class a implements c87.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e57 a;
        public final /* synthetic */ FeedCardView b;

        public a(FeedCardView feedCardView, e57 e57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedCardView, e57Var};
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
            this.a = e57Var;
        }

        @Override // com.baidu.tieba.c87.a
        public void a(View view2, o87<?> o87Var, n87<?, ?> n87Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, view2, o87Var, n87Var) == null) {
                this.a.c().invoke(this.b.getContext(), this.a);
                if (this.b.d != null) {
                    this.b.d.a();
                }
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
        e();
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
        e();
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
        e();
    }

    public final void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                n9.b(this);
            } else {
                n9.a(this);
            }
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void f(e57<?> e57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, e57Var) == null) {
            this.e = false;
            c(e57Var.g());
            this.c.i(new a(this, e57Var));
            this.c.setList(e57Var.a());
            b();
        }
    }

    @Override // com.baidu.tieba.d87
    public void setOnTemplateClickListener(@NonNull k87 k87Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, k87Var) == null) {
            this.d = k87Var;
        }
    }

    @Override // com.baidu.tieba.h87
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            p75 d = p75.d(this.a);
            d.o(R.string.J_X06);
            d.j(R.color.CAM_X0205, R.color.CAM_X0206);
            this.c.b();
        }
    }

    @Override // com.baidu.tieba.j87
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int i = 0; i < this.a.getChildCount(); i++) {
                View childAt = this.a.getChildAt(i);
                if (childAt instanceof j87) {
                    ((j87) childAt).d();
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"NotifyDataSetChanged"})
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            if (this.e) {
                this.c.notifyDataSetChanged();
                b();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            this.e = true;
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            RecyclerView recyclerView = new RecyclerView(getContext());
            this.a = recyclerView;
            recyclerView.setFocusableInTouchMode(false);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setRecycleChildrenOnDetach(true);
            this.a.setLayoutManager(linearLayoutManager);
            this.a.setRecycledViewPool(v97.f().g());
            TemplateAdapter templateAdapter = new TemplateAdapter();
            this.c = templateAdapter;
            templateAdapter.j(new s97());
            this.c.d(this.a, true);
            addView(this.a, new FrameLayout.LayoutParams(-1, -2));
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            this.b = relativeLayout;
            addView(relativeLayout, new FrameLayout.LayoutParams(-1, -2));
            b();
        }
    }
}
