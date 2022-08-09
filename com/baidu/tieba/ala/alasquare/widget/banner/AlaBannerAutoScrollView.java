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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bt5;
import com.repackage.eu5;
import com.repackage.fu5;
import com.repackage.gu5;
import java.util.List;
/* loaded from: classes3.dex */
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
    public gu5 i;
    public fu5 j;
    public eu5 k;
    public Runnable l;
    public RecyclerView.OnScrollListener m;

    /* loaded from: classes3.dex */
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
                if (action == 0) {
                    this.a.u();
                    return false;
                } else if (action == 1) {
                    this.a.t();
                    return false;
                } else if (action != 2) {
                    this.a.t();
                    return false;
                } else {
                    this.a.u();
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.r(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements eu5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaBannerAutoScrollView a;

        /* loaded from: classes3.dex */
        public class a extends AlaBannerViewHolder<bt5> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public TbImageView a;

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

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void b(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                    this.a = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0906fd);
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void c(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            /* renamed from: d */
            public void a(int i, bt5 bt5Var) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, bt5Var) == null) || bt5Var == null || this.a == null || StringUtils.isNull(bt5Var.b)) {
                    return;
                }
                this.a.K(bt5Var.b, 10, false);
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

        @Override // com.repackage.eu5
        public AlaBannerViewHolder a(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) ? new a(this, LayoutInflater.from(this.a.a).inflate(R.layout.obfuscated_res_0x7f0d07bd, viewGroup, false)) : (AlaBannerViewHolder) invokeLI.objValue;
        }
    }

    /* loaded from: classes3.dex */
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
                    this.a.s(currentItem + 1, true);
                }
                AlaBannerAutoScrollView alaBannerAutoScrollView = this.a;
                alaBannerAutoScrollView.postDelayed(alaBannerAutoScrollView.l, this.a.g);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int e = this.a.d.e();
                AlaBannerAutoScrollView alaBannerAutoScrollView = this.a;
                if (e != 0) {
                    currentItem %= e;
                }
                alaBannerAutoScrollView.v(currentItem);
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
        o(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            View findSnapView = this.e.findSnapView(this.c.getLayoutManager());
            if (findSnapView != null) {
                int position = this.c.getLayoutManager().getPosition(findSnapView);
                int e2 = this.d.e();
                if (position < e2) {
                    int i = position + e2;
                    this.c.getLayoutManager().scrollToPosition(i);
                    return i;
                } else if (position >= e2 * 2) {
                    int i2 = position - e2;
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

    private void setCurrentItem(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65553, this, i) == null) {
            s(i, false);
        }
    }

    public void n(List<T> list, eu5 eu5Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, list, eu5Var) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        u();
        if (this.f != ListUtils.getCount(list)) {
            int count = ListUtils.getCount(list);
            this.f = count;
            if (count == 1) {
                this.h = false;
            } else {
                this.h = true;
            }
            p(this.f);
        }
        this.d.setData(list);
        this.d.notifyDataSetChanged();
        t();
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.a = context;
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d00e5, (ViewGroup) this, true);
            this.b = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090815);
            this.c = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091312);
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

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDetachedFromWindow();
            u();
        }
    }

    public final void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (this.b.getChildCount() != this.f) {
                this.b.removeAllViews();
                if (this.f == 1) {
                    this.b.setVisibility(8);
                } else {
                    this.b.setVisibility(0);
                    int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07023b);
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
            if (linearLayout == null || linearLayout.getChildAt(0) == null) {
                return;
            }
            this.b.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            u();
            v(getCurrentItem());
            t();
        }
    }

    public final void r(int i) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || (recyclerView = this.c) == null) {
            return;
        }
        ((LinearLayoutManager) recyclerView.getLayoutManager()).scrollToPositionWithOffset(i, 0);
    }

    public final void s(int i, boolean z) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) || (recyclerView = this.c) == null) {
            return;
        }
        if (z) {
            recyclerView.smoothScrollToPosition(i);
        } else {
            r(i);
        }
    }

    public void setAutoPlayDuation(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.g = j;
        }
    }

    public void setOnBannerClickListener(fu5 fu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fu5Var) == null) {
            this.j = fu5Var;
            AlaBannerRecyclerAdapter alaBannerRecyclerAdapter = this.d;
            if (alaBannerRecyclerAdapter != null) {
                alaBannerRecyclerAdapter.i(fu5Var);
            }
        }
    }

    public void setOnBannerScrollListener(gu5 gu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gu5Var) == null) {
            this.i = gu5Var;
        }
    }

    public void setViewHolderAdapter(eu5 eu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, eu5Var) == null) {
            this.d.j(eu5Var);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            postDelayed(this.l, 2000L);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            removeCallbacks(this.l);
        }
    }

    public final void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            if (i >= this.b.getChildCount()) {
                p(this.f);
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
        o(context);
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
        o(context);
    }
}
