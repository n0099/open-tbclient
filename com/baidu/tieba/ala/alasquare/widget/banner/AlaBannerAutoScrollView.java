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
/* loaded from: classes8.dex */
public class AlaBannerAutoScrollView<T> extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f47937e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f47938f;

    /* renamed from: g  reason: collision with root package name */
    public RecyclerView f47939g;

    /* renamed from: h  reason: collision with root package name */
    public AlaBannerRecyclerAdapter f47940h;

    /* renamed from: i  reason: collision with root package name */
    public PagerSnapHelper f47941i;
    public int j;
    public long k;
    public boolean l;
    public b.a.r0.w.f.i.h.c m;
    public b.a.r0.w.f.i.h.b n;
    public b.a.r0.w.f.i.h.a o;
    public Runnable p;
    public RecyclerView.OnScrollListener q;

    /* loaded from: classes8.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaBannerAutoScrollView f47942e;

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
            this.f47942e = alaBannerAutoScrollView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f47942e.s();
                    return false;
                } else if (action == 1) {
                    this.f47942e.r();
                    return false;
                } else if (action != 2) {
                    this.f47942e.r();
                    return false;
                } else {
                    this.f47942e.s();
                    return false;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaBannerAutoScrollView f47943e;

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
            this.f47943e = alaBannerAutoScrollView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47943e.f47939g.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                this.f47943e.p(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements b.a.r0.w.f.i.h.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaBannerAutoScrollView f47944a;

        /* loaded from: classes8.dex */
        public class a extends AlaBannerViewHolder<b.a.r0.w.f.g.c.b> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public TbImageView f47945a;

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

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            /* renamed from: a */
            public void bindData(int i2, b.a.r0.w.f.g.c.b bVar) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, bVar) == null) || bVar == null || this.f47945a == null || StringUtils.isNull(bVar.f26339f)) {
                    return;
                }
                this.f47945a.startLoad(bVar.f26339f, 10, false);
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void initView(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
                    this.f47945a = (TbImageView) view.findViewById(R.id.cover);
                }
            }

            @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
            public void onChangeSkinType(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47944a = alaBannerAutoScrollView;
        }

        @Override // b.a.r0.w.f.i.h.a
        public AlaBannerViewHolder a(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) ? new a(this, LayoutInflater.from(this.f47944a.f47937e).inflate(R.layout.special_bar_recommend_activity, viewGroup, false)) : (AlaBannerViewHolder) invokeLI.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AlaBannerAutoScrollView f47946e;

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
            this.f47946e = alaBannerAutoScrollView;
        }

        @Override // java.lang.Runnable
        public void run() {
            int currentItem;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f47946e.l && (currentItem = this.f47946e.getCurrentItem()) != -1) {
                    this.f47946e.q(currentItem + 1, true);
                }
                AlaBannerAutoScrollView alaBannerAutoScrollView = this.f47946e;
                alaBannerAutoScrollView.postDelayed(alaBannerAutoScrollView.p, this.f47946e.k);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaBannerAutoScrollView f47947a;

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
            this.f47947a = alaBannerAutoScrollView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                int currentItem = this.f47947a.getCurrentItem();
                int realItemCount = this.f47947a.f47940h.getRealItemCount();
                AlaBannerAutoScrollView alaBannerAutoScrollView = this.f47947a;
                if (realItemCount != 0) {
                    currentItem %= realItemCount;
                }
                alaBannerAutoScrollView.t(currentItem);
                if (this.f47947a.m != null) {
                    this.f47947a.m.b(recyclerView, i2);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                super.onScrolled(recyclerView, i2, i3);
                if (this.f47947a.m != null) {
                    this.f47947a.m.a(recyclerView, i2, i3);
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
        this.f47941i = new PagerSnapHelper();
        this.j = -1;
        this.k = 2000L;
        this.l = false;
        this.o = new c(this);
        this.p = new d(this);
        this.q = new e(this);
        n(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            View findSnapView = this.f47941i.findSnapView(this.f47939g.getLayoutManager());
            if (findSnapView != null) {
                int position = this.f47939g.getLayoutManager().getPosition(findSnapView);
                int realItemCount = this.f47940h.getRealItemCount();
                if (position < realItemCount) {
                    int i2 = position + realItemCount;
                    this.f47939g.getLayoutManager().scrollToPosition(i2);
                    return i2;
                } else if (position >= realItemCount * 2) {
                    int i3 = position - realItemCount;
                    this.f47939g.getLayoutManager().scrollToPosition(i3);
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
            q(i2, false);
        }
    }

    public void bindActivityData(List<T> list, b.a.r0.w.f.i.h.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, list, aVar) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        s();
        if (this.j != ListUtils.getCount(list)) {
            int count = ListUtils.getCount(list);
            this.j = count;
            if (count == 1) {
                this.l = false;
            } else {
                this.l = true;
            }
            o(this.j);
        }
        this.f47940h.setData(list);
        this.f47940h.notifyDataSetChanged();
        r();
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.f47937e = context;
            LayoutInflater.from(context).inflate(R.layout.ala_banner_auto_scroll_view, (ViewGroup) this, true);
            this.f47938f = (LinearLayout) findViewById(R.id.dotLayout);
            this.f47939g = (RecyclerView) findViewById(R.id.list_view);
            this.f47939g.setLayoutManager(new LinearLayoutManager(context, 0, false));
            this.f47939g.setOnTouchListener(new a(this));
            AlaBannerRecyclerAdapter alaBannerRecyclerAdapter = new AlaBannerRecyclerAdapter(context, this.o, false);
            this.f47940h = alaBannerRecyclerAdapter;
            this.f47939g.setAdapter(alaBannerRecyclerAdapter);
            this.f47939g.addOnScrollListener(this.q);
            this.f47939g.getViewTreeObserver().addOnGlobalLayoutListener(new b(this));
            this.f47941i.attachToRecyclerView(this.f47939g);
        }
    }

    public final void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (this.f47938f.getChildCount() != this.j) {
                this.f47938f.removeAllViews();
                if (this.j == 1) {
                    this.f47938f.setVisibility(8);
                } else {
                    this.f47938f.setVisibility(0);
                    int dimensionPixelSize = this.f47937e.getResources().getDimensionPixelSize(R.dimen.ds12);
                    int dimensionPixelSize2 = this.f47937e.getResources().getDimensionPixelSize(R.dimen.ds20);
                    for (int i3 = 0; i3 < this.j; i3++) {
                        View view = new View(this.f47937e);
                        view.setBackgroundResource(R.drawable.ala_banner_view_dot_unselected);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                        if (i3 != 0) {
                            layoutParams.leftMargin = dimensionPixelSize2;
                        }
                        this.f47938f.addView(view, layoutParams);
                    }
                }
            }
            LinearLayout linearLayout = this.f47938f;
            if (linearLayout == null || linearLayout.getChildAt(0) == null) {
                return;
            }
            this.f47938f.getChildAt(0).setBackgroundResource(R.drawable.ala_banner_view_dot_selected);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            s();
            t(getCurrentItem());
            r();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            s();
        }
    }

    public final void p(int i2) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (recyclerView = this.f47939g) == null) {
            return;
        }
        ((LinearLayoutManager) recyclerView.getLayoutManager()).scrollToPositionWithOffset(i2, 0);
    }

    public final void q(int i2, boolean z) {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (recyclerView = this.f47939g) == null) {
            return;
        }
        if (z) {
            recyclerView.smoothScrollToPosition(i2);
        } else {
            p(i2);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            postDelayed(this.p, 2000L);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            removeCallbacks(this.p);
        }
    }

    public void setAutoPlayDuation(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.k = j;
        }
    }

    public void setOnBannerClickListener(b.a.r0.w.f.i.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.n = bVar;
            AlaBannerRecyclerAdapter alaBannerRecyclerAdapter = this.f47940h;
            if (alaBannerRecyclerAdapter != null) {
                alaBannerRecyclerAdapter.setOnBannerClickListener(bVar);
            }
        }
    }

    public void setOnBannerScrollListener(b.a.r0.w.f.i.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.m = cVar;
        }
    }

    public void setViewHolderAdapter(b.a.r0.w.f.i.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.f47940h.setViewHolderAdapter(aVar);
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            if (i2 >= this.f47938f.getChildCount()) {
                o(this.j);
                return;
            }
            for (int i3 = 0; i3 < this.f47938f.getChildCount(); i3++) {
                View childAt = this.f47938f.getChildAt(i3);
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
        this.f47941i = new PagerSnapHelper();
        this.j = -1;
        this.k = 2000L;
        this.l = false;
        this.o = new c(this);
        this.p = new d(this);
        this.q = new e(this);
        n(context);
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
        this.f47941i = new PagerSnapHelper();
        this.j = -1;
        this.k = 2000L;
        this.l = false;
        this.o = new c(this);
        this.p = new d(this);
        this.q = new e(this);
        n(context);
    }
}
