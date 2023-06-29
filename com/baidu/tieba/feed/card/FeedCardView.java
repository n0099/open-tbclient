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
import com.baidu.tieba.aa7;
import com.baidu.tieba.feed.list.TemplateAdapter;
import com.baidu.tieba.h87;
import com.baidu.tieba.i87;
import com.baidu.tieba.j57;
import com.baidu.tieba.j87;
import com.baidu.tieba.m87;
import com.baidu.tieba.o87;
import com.baidu.tieba.o9;
import com.baidu.tieba.p87;
import com.baidu.tieba.s75;
import com.baidu.tieba.s87;
import com.baidu.tieba.t87;
import com.baidu.tieba.x97;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FeedCardView extends FrameLayout implements o87, i87, m87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecyclerView a;
    public RelativeLayout b;
    public j87 c;
    public p87 d;
    public boolean e;

    /* loaded from: classes5.dex */
    public class a implements h87.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j57 a;
        public final /* synthetic */ FeedCardView b;

        public a(FeedCardView feedCardView, j57 j57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedCardView, j57Var};
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
            this.a = j57Var;
        }

        @Override // com.baidu.tieba.h87.a
        public void a(View view2, t87<?> t87Var, s87<?, ?> s87Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, view2, t87Var, s87Var) == null) {
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
                o9.b(this);
            } else {
                o9.a(this);
            }
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void f(j57<?> j57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, j57Var) == null) {
            this.e = false;
            c(j57Var.g());
            this.c.i(new a(this, j57Var));
            this.c.setList(j57Var.a());
            b();
        }
    }

    @Override // com.baidu.tieba.i87
    public void setOnTemplateClickListener(@NonNull p87 p87Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, p87Var) == null) {
            this.d = p87Var;
        }
    }

    @Override // com.baidu.tieba.m87
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            s75 d = s75.d(this.a);
            d.o(R.string.J_X06);
            d.j(R.color.CAM_X0205, R.color.CAM_X0206);
            this.c.b();
        }
    }

    @Override // com.baidu.tieba.o87
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int i = 0; i < this.a.getChildCount(); i++) {
                View childAt = this.a.getChildAt(i);
                if (childAt instanceof o87) {
                    ((o87) childAt).d();
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
            this.a.setRecycledViewPool(aa7.f().g());
            TemplateAdapter templateAdapter = new TemplateAdapter();
            this.c = templateAdapter;
            templateAdapter.j(new x97());
            this.c.d(this.a, true);
            addView(this.a, new FrameLayout.LayoutParams(-1, -2));
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            this.b = relativeLayout;
            addView(relativeLayout, new FrameLayout.LayoutParams(-1, -2));
            b();
        }
    }
}
