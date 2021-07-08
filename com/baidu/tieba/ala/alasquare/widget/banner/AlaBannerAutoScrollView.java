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
import java.util.List;
/* loaded from: classes4.dex */
public class AlaBannerAutoScrollView<T> extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f14168e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f14169f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView f14170g;

    /* renamed from: h  reason: collision with root package name */
    public AlaBannerRecyclerAdapter f14171h;

    /* renamed from: i  reason: collision with root package name */
    public PagerSnapHelper f14172i;
    public int j;
    public long k;
    public boolean l;
    public d.a.p0.v.d.h.a.c m;
    public d.a.p0.v.d.h.a.b n;
    public d.a.p0.v.d.h.a.a o;
    public Runnable p;
    public RecyclerView.OnScrollListener q;

    /* loaded from: classes4.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaBannerAutoScrollView f14173e;

        public a(AlaBannerAutoScrollView alaBannerAutoScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaBannerAutoScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14173e = alaBannerAutoScrollView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f14173e.u();
                    return false;
                } else if (action == 1) {
                    this.f14173e.t();
                    return false;
                } else if (action != 2) {
                    this.f14173e.t();
                    return false;
                } else {
                    this.f14173e.u();
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaBannerAutoScrollView f14174e;

        public b(AlaBannerAutoScrollView alaBannerAutoScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaBannerAutoScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14174e = alaBannerAutoScrollView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14174e.f14170g.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                this.f14174e.r(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.p0.v.d.h.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaBannerAutoScrollView f14175a;

        /* loaded from: classes4.dex */
        public class a extends AlaBannerViewHolder<d.a.p0.v.d.f.c.b> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public TbImageView f14176a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, View view) {
                super(view);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, view};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((View) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void b(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                    this.f14176a = (TbImageView) view.findViewById(R.id.cover);
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void c(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            /* renamed from: d */
            public void a(int i2, d.a.p0.v.d.f.c.b bVar) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, bVar) == null) || bVar == null || this.f14176a == null || StringUtils.isNull(bVar.f64517f)) {
                    return;
                }
                this.f14176a.M(bVar.f64517f, 10, false);
            }
        }

        public c(AlaBannerAutoScrollView alaBannerAutoScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaBannerAutoScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14175a = alaBannerAutoScrollView;
        }

        @Override // d.a.p0.v.d.h.a.a
        public AlaBannerViewHolder a(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) ? new a(this, LayoutInflater.from(this.f14175a.f14168e).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) : (AlaBannerViewHolder) invokeLI.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaBannerAutoScrollView f14177e;

        public d(AlaBannerAutoScrollView alaBannerAutoScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaBannerAutoScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14177e = alaBannerAutoScrollView;
        }

        @Override // java.lang.Runnable
        public void run() {
            int currentItem;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f14177e.l && (currentItem = this.f14177e.getCurrentItem()) != -1) {
                    this.f14177e.s(currentItem + 1, true);
                }
                AlaBannerAutoScrollView alaBannerAutoScrollView = this.f14177e;
                alaBannerAutoScrollView.postDelayed(alaBannerAutoScrollView.p, this.f14177e.k);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaBannerAutoScrollView f14178a;

        public e(AlaBannerAutoScrollView alaBannerAutoScrollView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaBannerAutoScrollView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14178a = alaBannerAutoScrollView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                int currentItem = this.f14178a.getCurrentItem();
                int e2 = this.f14178a.f14171h.e();
                AlaBannerAutoScrollView alaBannerAutoScrollView = this.f14178a;
                if (e2 != 0) {
                    currentItem %= e2;
                }
                alaBannerAutoScrollView.v(currentItem);
                if (this.f14178a.m != null) {
                    this.f14178a.m.b(recyclerView, i2);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (this.f14178a.m != null) {
                    this.f14178a.m.a(recyclerView, i2, i3);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14172i = new PagerSnapHelper();
        this.j = -1;
        this.k = 2000L;
        this.l = false;
        this.o = new c(this);
        this.p = new d(this);
        this.q = new e(this);
        o(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            View findSnapView = this.f14172i.findSnapView(this.f14170g.getLayoutManager());
            if (findSnapView != null) {
                int position = this.f14170g.getLayoutManager().getPosition(findSnapView);
                int e2 = this.f14171h.e();
                if (position < e2) {
                    int i2 = position + e2;
                    this.f14170g.getLayoutManager().scrollToPosition(i2);
                    return i2;
                } else if (position >= e2 * 2) {
                    int i3 = position - e2;
                    this.f14170g.getLayoutManager().scrollToPosition(i3);
                    return i3;
                } else {
                    return position;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    private void setCurrentItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65553, this, i2) == null) {
            s(i2, false);
        }
    }

    public void n(List<T> list, d.a.p0.v.d.h.a.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, list, aVar) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        u();
        if (this.j != ListUtils.getCount(list)) {
            int count = ListUtils.getCount(list);
            this.j = count;
            if (count == 1) {
                this.l = false;
            } else {
                this.l = true;
            }
            p(this.j);
        }
        this.f14171h.setData(list);
        this.f14171h.notifyDataSetChanged();
        t();
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f14168e = context;
            LayoutInflater.from(context).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
            this.f14169f = (LinearLayout) findViewById(R.id.dotLayout);
            this.f14170g = (RecyclerView) findViewById(R.id.list_view);
            this.f14170g.setLayoutManager(new LinearLayoutManager(context, 0, false));
            this.f14170g.setOnTouchListener(new a(this));
            AlaBannerRecyclerAdapter alaBannerRecyclerAdapter = new AlaBannerRecyclerAdapter(context, this.o, false);
            this.f14171h = alaBannerRecyclerAdapter;
            this.f14170g.setAdapter(alaBannerRecyclerAdapter);
            this.f14170g.addOnScrollListener(this.q);
            this.f14170g.getViewTreeObserver().addOnGlobalLayoutListener(new b(this));
            this.f14172i.attachToRecyclerView(this.f14170g);
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

    public final void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (this.f14169f.getChildCount() != this.j) {
                this.f14169f.removeAllViews();
                if (this.j == 1) {
                    this.f14169f.setVisibility(8);
                } else {
                    this.f14169f.setVisibility(0);
                    int dimensionPixelSize = this.f14168e.getResources().getDimensionPixelSize(R.dimen.ds12);
                    int dimensionPixelSize2 = this.f14168e.getResources().getDimensionPixelSize(R.dimen.ds20);
                    for (int i3 = 0; i3 < this.j; i3++) {
                        View view = new View(this.f14168e);
                        view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                        if (i3 != 0) {
                            layoutParams.leftMargin = dimensionPixelSize2;
                        }
                        this.f14169f.addView(view, layoutParams);
                    }
                }
            }
            LinearLayout linearLayout = this.f14169f;
            if (linearLayout == null || linearLayout.getChildAt(0) == null) {
                return;
            }
            this.f14169f.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            u();
            v(getCurrentItem());
            t();
        }
    }

    public final void r(int i2) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (recyclerView = this.f14170g) == null) {
            return;
        }
        ((LinearLayoutManager) recyclerView.getLayoutManager()).scrollToPositionWithOffset(i2, 0);
    }

    public final void s(int i2, boolean z) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (recyclerView = this.f14170g) == null) {
            return;
        }
        if (z) {
            recyclerView.smoothScrollToPosition(i2);
        } else {
            r(i2);
        }
    }

    public void setAutoPlayDuation(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.k = j;
        }
    }

    public void setOnBannerClickListener(d.a.p0.v.d.h.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.n = bVar;
            AlaBannerRecyclerAdapter alaBannerRecyclerAdapter = this.f14171h;
            if (alaBannerRecyclerAdapter != null) {
                alaBannerRecyclerAdapter.i(bVar);
            }
        }
    }

    public void setOnBannerScrollListener(d.a.p0.v.d.h.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.m = cVar;
        }
    }

    public void setViewHolderAdapter(d.a.p0.v.d.h.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.f14171h.j(aVar);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            postDelayed(this.p, 2000L);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            removeCallbacks(this.p);
        }
    }

    public final void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            if (i2 >= this.f14169f.getChildCount()) {
                p(this.j);
                return;
            }
            for (int i3 = 0; i3 < this.f14169f.getChildCount(); i3++) {
                View childAt = this.f14169f.getChildAt(i3);
                if (childAt != null) {
                    if (i3 == i2) {
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
        this.f14172i = new PagerSnapHelper();
        this.j = -1;
        this.k = 2000L;
        this.l = false;
        this.o = new c(this);
        this.p = new d(this);
        this.q = new e(this);
        o(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaBannerAutoScrollView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f14172i = new PagerSnapHelper();
        this.j = -1;
        this.k = 2000L;
        this.l = false;
        this.o = new c(this);
        this.p = new d(this);
        this.q = new e(this);
        o(context);
    }
}
