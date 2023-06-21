package com.baidu.tieba.ala.alasquare.widget.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.sd6;
import com.baidu.tieba.td6;
import com.baidu.tieba.ud6;
import com.baidu.tieba.zc6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class AlaBannerAutoScrollView<T> extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public LinearLayout b;
    public RecyclerView c;
    public AlaBannerRecyclerAdapter d;
    public PagerSnapHelper e;
    public int f;
    public long g;
    public boolean h;
    public ud6 i;
    public td6 j;
    public sd6 k;
    public Runnable l;
    public RecyclerView.OnScrollListener m;

    /* loaded from: classes5.dex */
    public class c implements sd6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaBannerAutoScrollView a;

        /* loaded from: classes5.dex */
        public class a extends AlaBannerViewHolder<zc6> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public TbImageView a;

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void c(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, View view2) {
                super(view2);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, view2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((View) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            /* renamed from: d */
            public void a(int i, zc6 zc6Var) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeIL(1048579, this, i, zc6Var) == null) && zc6Var != null && this.a != null && !StringUtils.isNull(zc6Var.a)) {
                    this.a.N(zc6Var.a, 10, false);
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void b(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                    this.a = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0907e5);
                }
            }
        }

        public c(AlaBannerAutoScrollView alaBannerAutoScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaBannerAutoScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaBannerAutoScrollView;
        }

        @Override // com.baidu.tieba.sd6
        public AlaBannerViewHolder a(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) {
                return new a(this, LayoutInflater.from(this.a.a).inflate(R.layout.obfuscated_res_0x7f0d0899, viewGroup, false));
            }
            return (AlaBannerViewHolder) invokeLI.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaBannerAutoScrollView a;

        public a(AlaBannerAutoScrollView alaBannerAutoScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaBannerAutoScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaBannerAutoScrollView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action != 2) {
                            this.a.r();
                            return false;
                        }
                        this.a.s();
                        return false;
                    }
                    this.a.r();
                    return false;
                }
                this.a.s();
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaBannerAutoScrollView a;

        public b(AlaBannerAutoScrollView alaBannerAutoScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaBannerAutoScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaBannerAutoScrollView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                this.a.p(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaBannerAutoScrollView a;

        public d(AlaBannerAutoScrollView alaBannerAutoScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaBannerAutoScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaBannerAutoScrollView;
        }

        @Override // java.lang.Runnable
        public void run() {
            int currentItem;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.h && (currentItem = this.a.getCurrentItem()) != -1) {
                    this.a.q(currentItem + 1, true);
                }
                AlaBannerAutoScrollView alaBannerAutoScrollView = this.a;
                alaBannerAutoScrollView.postDelayed(alaBannerAutoScrollView.l, this.a.g);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaBannerAutoScrollView a;

        public e(AlaBannerAutoScrollView alaBannerAutoScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaBannerAutoScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaBannerAutoScrollView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                int currentItem = this.a.getCurrentItem();
                int l = this.a.d.l();
                AlaBannerAutoScrollView alaBannerAutoScrollView = this.a;
                if (l != 0) {
                    currentItem %= l;
                }
                alaBannerAutoScrollView.t(currentItem);
                if (this.a.i != null) {
                    this.a.i.b(recyclerView, i);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
                if (this.a.i != null) {
                    this.a.i.a(recyclerView, i, i2);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaBannerAutoScrollView(Context context) {
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
        this.e = new PagerSnapHelper();
        this.f = -1;
        this.g = 2000L;
        this.h = false;
        this.k = new c(this);
        this.l = new d(this);
        this.m = new e(this);
        n(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet) {
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
        this.e = new PagerSnapHelper();
        this.f = -1;
        this.g = 2000L;
        this.h = false;
        this.k = new c(this);
        this.l = new d(this);
        this.m = new e(this);
        n(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i) {
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
        this.e = new PagerSnapHelper();
        this.f = -1;
        this.g = 2000L;
        this.h = false;
        this.k = new c(this);
        this.l = new d(this);
        this.m = new e(this);
        n(context);
    }

    private void setCurrentItem(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65553, this, i) == null) {
            q(i, false);
        }
    }

    public final void p(int i) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || (recyclerView = this.c) == null) {
            return;
        }
        ((LinearLayoutManager) recyclerView.getLayoutManager()).scrollToPositionWithOffset(i, 0);
    }

    public void setAutoPlayDuation(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.g = j;
        }
    }

    public void setOnBannerClickListener(td6 td6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, td6Var) == null) {
            this.j = td6Var;
            AlaBannerRecyclerAdapter alaBannerRecyclerAdapter = this.d;
            if (alaBannerRecyclerAdapter != null) {
                alaBannerRecyclerAdapter.p(td6Var);
            }
        }
    }

    public void setOnBannerScrollListener(ud6 ud6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ud6Var) == null) {
            this.i = ud6Var;
        }
    }

    public void setViewHolderAdapter(sd6 sd6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, sd6Var) == null) {
            this.d.q(sd6Var);
        }
    }

    public final void q(int i, boolean z) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) != null) || (recyclerView = this.c) == null) {
            return;
        }
        if (z) {
            recyclerView.smoothScrollToPosition(i);
        } else {
            p(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            View findSnapView = this.e.findSnapView(this.c.getLayoutManager());
            if (findSnapView != null) {
                int position = this.c.getLayoutManager().getPosition(findSnapView);
                int l = this.d.l();
                if (position < l) {
                    int i = position + l;
                    this.c.getLayoutManager().scrollToPosition(i);
                    return i;
                } else if (position >= l * 2) {
                    int i2 = position - l;
                    this.c.getLayoutManager().scrollToPosition(i2);
                    return i2;
                } else {
                    return position;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.a = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00ed, (ViewGroup) this, true);
            this.b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090912);
            this.c = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f09150b);
            this.c.setLayoutManager(new LinearLayoutManager(context, 0, false));
            this.c.setOnTouchListener(new a(this));
            AlaBannerRecyclerAdapter alaBannerRecyclerAdapter = new AlaBannerRecyclerAdapter(context, this.k, false);
            this.d = alaBannerRecyclerAdapter;
            this.c.setAdapter(alaBannerRecyclerAdapter);
            this.c.addOnScrollListener(this.m);
            this.c.getViewTreeObserver().addOnGlobalLayoutListener(new b(this));
            this.e.attachToRecyclerView(this.c);
        }
    }

    public final void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (this.b.getChildCount() != this.f) {
                this.b.removeAllViews();
                if (this.f == 1) {
                    this.b.setVisibility(8);
                } else {
                    this.b.setVisibility(0);
                    int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07035d);
                    int dimensionPixelSize2 = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5);
                    for (int i2 = 0; i2 < this.f; i2++) {
                        View view2 = new View(this.a);
                        view2.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                        if (i2 != 0) {
                            layoutParams.leftMargin = dimensionPixelSize2;
                        }
                        this.b.addView(view2, layoutParams);
                    }
                }
            }
            LinearLayout linearLayout = this.b;
            if (linearLayout != null && linearLayout.getChildAt(0) != null) {
                this.b.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDetachedFromWindow();
            s();
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            postDelayed(this.l, 2000L);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            removeCallbacks(this.l);
        }
    }

    public final void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if (i >= this.b.getChildCount()) {
                o(this.f);
                return;
            }
            for (int i2 = 0; i2 < this.b.getChildCount(); i2++) {
                View childAt = this.b.getChildAt(i2);
                if (childAt != null) {
                    if (i2 == i) {
                        SkinManager.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_selected);
                    } else {
                        SkinManager.setBackgroundResource(childAt, R.drawable.ala_banner_view_dot_unselected);
                    }
                }
            }
        }
    }
}
