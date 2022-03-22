package com.baidu.tieba.emotion.editortool;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import c.a.o0.s.c.u;
import c.a.o0.s.c.v;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UserCollectManageActivityConfig;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context A;
    public c.a.d.f.k.b<GridView> B;
    public CustomMessageListener C;
    public ViewPager a;

    /* renamed from: b  reason: collision with root package name */
    public EmotionViewPagerAdapter f31777b;

    /* renamed from: c  reason: collision with root package name */
    public GridView f31778c;

    /* renamed from: d  reason: collision with root package name */
    public IndicatorView f31779d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f31780e;

    /* renamed from: f  reason: collision with root package name */
    public WindowManager f31781f;

    /* renamed from: g  reason: collision with root package name */
    public WindowManager.LayoutParams f31782g;

    /* renamed from: h  reason: collision with root package name */
    public GifView f31783h;
    public final Rect i;
    public ViewGroup j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public int o;
    public c.a.p0.v0.d.b p;
    public List<c.a.o0.w.p.d> q;
    public List<c.a.p0.v0.d.b> r;
    public int s;
    public int t;
    public int u;
    public d v;
    public int w;
    public final Point x;
    public EditorTools y;
    public int z;

    /* loaded from: classes5.dex */
    public class EmotionViewPagerAdapter extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabContentView a;

        /* loaded from: classes5.dex */
        public class a implements AdapterView.OnItemLongClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EmotionViewPagerAdapter a;

            public a(EmotionViewPagerAdapter emotionViewPagerAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {emotionViewPagerAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = emotionViewPagerAdapter;
            }

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                    c cVar = (c) adapterView.getAdapter();
                    if (cVar == null || cVar.a() == null) {
                        return false;
                    }
                    c.a.p0.v0.d.b a = cVar.a();
                    if (a.c() == EmotionGroupType.BIG_EMOTION || a.c() == EmotionGroupType.USER_COLLECT) {
                        this.a.a.A(i, (GridView) adapterView);
                        return true;
                    }
                    return false;
                }
                return invokeCommon.booleanValue;
            }
        }

        /* loaded from: classes5.dex */
        public class b implements AdapterView.OnItemClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ EmotionViewPagerAdapter a;

            public b(EmotionViewPagerAdapter emotionViewPagerAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {emotionViewPagerAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = emotionViewPagerAdapter;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                    adapterView.setSelection(-1);
                    if (this.a.a.y != null) {
                        u uVar = new u();
                        c cVar = (c) adapterView.getAdapter();
                        if (cVar == null || cVar.a() == null) {
                            return;
                        }
                        c.a.p0.v0.d.b a = cVar.a();
                        int b2 = cVar.b();
                        c.a.o0.w.p.d j2 = a.j();
                        String b3 = a.j().b(b2 + i);
                        if (j2.h() == EmotionGroupType.USER_COLLECT && c.a.o0.b0.d.f9862d.equals(b3)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(this.a.a.A)));
                            return;
                        }
                        uVar.j(b3);
                        uVar.m(j2.h());
                        uVar.l(j2.g());
                        uVar.k(j2.f());
                        uVar.o(j2.l());
                        uVar.i(j2.i());
                        v vVar = new v();
                        vVar.a = this.a.a.y.getFid();
                        vVar.f11268b = this.a.a.y.getTid();
                        vVar.f11270d = a.g() + 1;
                        vVar.f11274h = a.e() + 1;
                        vVar.f11272f = (a.e() * 21) + i + 1;
                        vVar.f11273g = 0;
                        vVar.f11271e = 0;
                        if (this.a.a.y.a.getBarLauncherType() != 3) {
                            if (this.a.a.y.a.getBarLauncherType() == 2) {
                                vVar.f11271e = 2;
                            }
                        } else {
                            vVar.f11271e = 1;
                        }
                        vVar.f11269c = TbadkCoreApplication.getCurrentAccount();
                        uVar.h(vVar);
                        this.a.a.y.A(new c.a.o0.w.a(24, -1, uVar));
                        this.a.a.s(vVar, "c14122");
                    }
                }
            }
        }

        public EmotionViewPagerAdapter(EmotionTabContentView emotionTabContentView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabContentView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionTabContentView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i, obj) == null) {
                GridView gridView = (GridView) obj;
                viewGroup.removeView(gridView);
                this.a.B.e(gridView);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.r == null) {
                    return 0;
                }
                return this.a.r.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                GridView gridView = (GridView) this.a.B.b();
                if (gridView == null) {
                    gridView = new GridView(this.a.A);
                }
                gridView.setScrollbarFadingEnabled(false);
                if (this.a.r != null && i < this.a.r.size()) {
                    c.a.p0.v0.d.b bVar = (c.a.p0.v0.d.b) this.a.r.get(i);
                    gridView.setNumColumns(bVar.a());
                    gridView.setVerticalSpacing(0);
                    gridView.setHorizontalSpacing(0);
                    gridView.setSelector(R.color.common_color_10022);
                    gridView.setPadding(this.a.A.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9), 0, this.a.A.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701f9), 0);
                    gridView.setOnItemLongClickListener(new a(this));
                    gridView.setOnItemClickListener(new b(this));
                    gridView.setAdapter((ListAdapter) new c(this.a, bVar));
                }
                viewGroup.addView(gridView);
                return gridView;
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048580, this, viewGroup, i, obj) == null) {
                if (this.a.r != null) {
                    int size = this.a.r.size();
                    if (i == 0 && i < size && i != this.a.u) {
                        c.a.p0.v0.d.b bVar = (c.a.p0.v0.d.b) this.a.r.get(i);
                        if (bVar != null) {
                            this.a.u = i;
                            this.a.f31779d.setVisibility(bVar.f() > 1 ? 0 : 4);
                            this.a.f31779d.setCount(bVar.f());
                            this.a.f31779d.setPosition(bVar.e());
                            this.a.f31779d.setContentDescription(String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f054c), Integer.valueOf(bVar.e() + 1)) + String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f054b), Integer.valueOf(bVar.f())));
                        }
                        if (bVar != null && bVar.g() != this.a.t) {
                            this.a.t = bVar.g();
                            if (this.a.v != null) {
                                this.a.v.c(bVar.g());
                            }
                        }
                    }
                }
                super.setPrimaryItem(viewGroup, i, obj);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements c.a.d.f.k.c<GridView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabContentView a;

        public a(EmotionTabContentView emotionTabContentView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabContentView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionTabContentView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ GridView a(GridView gridView) {
            GridView gridView2 = gridView;
            e(gridView2);
            return gridView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ GridView c(GridView gridView) {
            GridView gridView2 = gridView;
            h(gridView2);
            return gridView2;
        }

        public GridView e(GridView gridView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gridView)) == null) ? gridView : (GridView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(GridView gridView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gridView) == null) {
                gridView.setAdapter((ListAdapter) null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public GridView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new GridView(this.a.getContext()) : (GridView) invokeV.objValue;
        }

        public GridView h(GridView gridView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gridView)) == null) {
                gridView.setAdapter((ListAdapter) null);
                return gridView;
            }
            return (GridView) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabContentView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EmotionTabContentView emotionTabContentView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabContentView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionTabContentView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2921028) {
                this.a.t(new ArrayList(this.a.q));
                if (this.a.f31777b == null) {
                    return;
                }
                this.a.f31777b.notifyDataSetChanged();
                if ((this.a.t < 0 || this.a.t >= this.a.q.size() || ((c.a.o0.w.p.d) this.a.q.get(this.a.t)).h() == EmotionGroupType.USER_COLLECT) && this.a.f31777b != null) {
                    if (this.a.u >= 0 && this.a.u < this.a.r.size()) {
                        EmotionTabContentView emotionTabContentView = this.a;
                        emotionTabContentView.p = (c.a.p0.v0.d.b) emotionTabContentView.r.get(this.a.u);
                        int f2 = this.a.p.f();
                        this.a.f31779d.setCount(f2);
                        this.a.f31779d.setVisibility(f2 > 1 ? 0 : 4);
                    }
                    if (this.a.a != null) {
                        for (int i = 0; i < this.a.a.getChildCount(); i++) {
                            try {
                                View childAt = this.a.a.getChildAt(i);
                                if (childAt != null && (childAt instanceof GridView)) {
                                    GridView gridView = (GridView) childAt;
                                    if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof c)) {
                                        c cVar = (c) gridView.getAdapter();
                                        int d2 = cVar.a().d();
                                        if (d2 >= 0 && d2 < this.a.r.size()) {
                                            cVar.c((c.a.p0.v0.d.b) this.a.r.get(d2));
                                            cVar.notifyDataSetChanged();
                                        }
                                    }
                                }
                            } catch (Throwable unused) {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.p0.v0.d.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ EmotionTabContentView f31784b;

        /* loaded from: classes5.dex */
        public class a extends c.a.d.f.l.c<c.a.d.o.d.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.d.f.l.c
            public void onLoaded(c.a.d.o.d.a aVar, String str, int i) {
                View findViewWithTag;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i) == null) || aVar == null || (findViewWithTag = this.a.f31784b.findViewWithTag(str)) == null || !(findViewWithTag instanceof TbImageView) || str == null) {
                    return;
                }
                TbImageView tbImageView = (TbImageView) findViewWithTag;
                aVar.h(tbImageView);
                tbImageView.setTag(null);
            }
        }

        public c(EmotionTabContentView emotionTabContentView, c.a.p0.v0.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabContentView, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31784b = emotionTabContentView;
            this.a = bVar;
        }

        public c.a.p0.v0.d.b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (c.a.p0.v0.d.b) invokeV.objValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                c.a.p0.v0.d.b bVar = this.a;
                if (bVar == null) {
                    return 0;
                }
                return bVar.i();
            }
            return invokeV.intValue;
        }

        public void c(c.a.p0.v0.d.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
                this.a = bVar;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                c.a.p0.v0.d.b bVar = this.a;
                if (bVar == null) {
                    return 0;
                }
                return bVar.b();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? Integer.valueOf(i) : invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            LinearLayout linearLayout;
            int i2;
            int color;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view, viewGroup)) == null) {
                if (view == null) {
                    LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d026f, (ViewGroup) null);
                    int measuredWidth = viewGroup.getMeasuredWidth();
                    int measuredHeight = viewGroup.getMeasuredHeight();
                    int a2 = this.a.a() != 0 ? measuredWidth / this.a.a() : 0;
                    int h2 = this.a.h() != 0 ? measuredHeight / this.a.h() : 0;
                    linearLayout2.setPadding(this.f31784b.m * 2, this.f31784b.m * 2, this.f31784b.m * 2, this.f31784b.m * 2);
                    linearLayout = linearLayout2;
                    linearLayout = linearLayout2;
                    if (a2 != 0 && h2 != 0) {
                        if (viewGroup != null && viewGroup.getChildAt(0) != null) {
                            viewGroup.getChildAt(0).setLayoutParams(new AbsListView.LayoutParams(a2, h2));
                        }
                        linearLayout2.setLayoutParams(new AbsListView.LayoutParams(a2, h2));
                        linearLayout = linearLayout2;
                    }
                } else {
                    linearLayout = view;
                }
                LinearLayout linearLayout3 = (LinearLayout) linearLayout;
                c.a.p0.v0.d.b bVar = this.a;
                if (bVar == null) {
                    return linearLayout3;
                }
                int i3 = bVar.i() + i;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.obfuscated_res_0x7f0908af);
                tbImageView.setAutoChangeStyle(false);
                SkinManager.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, this.f31784b.z);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String b2 = this.a.j().b(i3);
                tbImageView.setTag(b2);
                if (TextUtils.isEmpty(b2)) {
                    i2 = 3;
                } else {
                    i2 = 3;
                    Object k = c.a.d.f.l.d.h().k(b2, 20, new a(this), 0, 0, null, null, b2, Boolean.FALSE, null);
                    c.a.d.o.d.a aVar = (k == null || !(k instanceof c.a.d.o.d.a)) ? null : (c.a.d.o.d.a) k;
                    if (aVar != null) {
                        aVar.h(tbImageView);
                        tbImageView.setTag(null);
                    }
                }
                TextView textView = (TextView) linearLayout3.findViewById(R.id.obfuscated_res_0x7f0908b0);
                if (this.a.c() == EmotionGroupType.BIG_EMOTION) {
                    String b3 = this.a.j().b(i3);
                    if (!TextUtils.isEmpty(b3) && !b3.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                        if (this.f31784b.z == 0) {
                            color = this.f31784b.getContext().getResources().getColor(R.color.CAM_X0108);
                        } else {
                            color = SkinManager.getColor(R.color.CAM_X0108);
                        }
                        textView.setVisibility(0);
                        textView.setTextColor(color);
                        textView.setText(b3.substring(b3.lastIndexOf("_") + 1, b3.length() - 1));
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                if (b2 != null && b2.length() > i2) {
                    linearLayout3.setContentDescription(b2.substring(2, b2.length() - 1));
                }
                return linearLayout3;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void c(int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
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
        this.i = new Rect();
        this.o = -1;
        this.s = 0;
        this.t = -1;
        this.u = -1;
        this.x = new Point();
        this.C = new b(this, 2921028);
        u(context);
    }

    public void A(int i, GridView gridView) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048576, this, i, gridView) == null) || this.o == i || gridView == null || (cVar = (c) gridView.getAdapter()) == null || cVar.a() == null) {
            return;
        }
        c.a.p0.v0.d.b a2 = cVar.a();
        String b2 = a2.j().b(cVar.b() + i);
        if (a2.c() == EmotionGroupType.USER_COLLECT && c.a.o0.b0.d.f9862d.equals(b2)) {
            return;
        }
        this.f31783h.setTag(b2);
        GifInfo gifInfo = new GifInfo();
        gifInfo.mSharpText = b2;
        if (b2.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
            this.f31783h.setShowStaticDrawable(false);
        } else {
            this.f31783h.setShowStaticDrawable(true);
        }
        this.f31783h.f0(gifInfo);
        LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i - gridView.getFirstVisiblePosition());
        linearLayout.getDrawingRect(this.i);
        this.j.offsetDescendantRectToMyCoords(linearLayout, this.i);
        WindowManager.LayoutParams layoutParams = this.f31782g;
        layoutParams.x = this.i.left - ((layoutParams.width - linearLayout.getWidth()) / 2);
        WindowManager.LayoutParams layoutParams2 = this.f31782g;
        layoutParams2.y = (this.i.top - layoutParams2.height) + this.m;
        this.f31783h.setVisibility(0);
        if (!this.n) {
            this.f31781f.addView(this.f31783h, this.f31782g);
            this.n = true;
        } else {
            this.f31781f.updateViewLayout(this.f31783h, this.f31782g);
        }
        gridView.setSelection(i);
        int i2 = this.o;
        if (i2 != -1) {
            ((LinearLayout) gridView.getChildAt(i2 - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
        }
        linearLayout.getChildAt(0).setSelected(true);
        this.o = i;
        this.f31778c = gridView;
    }

    public void B(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.a == null) {
            return;
        }
        int size = this.r.size();
        if (i < 0 || i >= size) {
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                c.a.p0.v0.d.b bVar = this.r.get(i3);
                if (bVar != null && bVar.g() == i) {
                    i2 = bVar.d();
                    break;
                }
                i3++;
            } else {
                i2 = 0;
                break;
            }
        }
        this.a.setCurrentItem(i2, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.C);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
            if (this.n) {
                this.f31781f.removeView(this.f31783h);
                this.n = false;
            }
            MessageManager.getInstance().unRegisterListener(this.C);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r0 != 3) goto L11;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        this.x.set(x, y);
                        if (this.n && this.f31783h.getVisibility() != 8 && this.f31778c != null) {
                            return true;
                        }
                    }
                }
                x();
            } else {
                this.x.set(x, y);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
        List<c.a.p0.v0.d.b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) || (list = this.r) == null) {
            return;
        }
        int size = list.size();
        if (i < 0 || i >= size) {
            return;
        }
        c.a.p0.v0.d.b bVar = this.r.get(i);
        this.p = bVar;
        IndicatorView indicatorView = this.f31779d;
        if (indicatorView == null || bVar == null) {
            return;
        }
        if (this.u != i) {
            this.u = i;
            indicatorView.setVisibility(bVar.f() > 1 ? 0 : 4);
            this.f31779d.setCount(this.p.f());
            c.a.p0.v0.d.b bVar2 = this.p;
            if (bVar2 != null && bVar2.g() != this.t) {
                this.t = this.p.g();
                d dVar = this.v;
                if (dVar != null) {
                    dVar.c(this.p.g());
                }
            }
        }
        float e2 = this.p.e() + f2;
        this.f31779d.setPosition(e2);
        StringBuilder sb = new StringBuilder();
        int i3 = ((int) e2) + 1;
        sb.append(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f054c), Integer.valueOf(i3)));
        sb.append(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f054b), Integer.valueOf(this.p.f())));
        this.f31780e.setContentDescription(sb.toString());
        v vVar = new v();
        vVar.a = this.y.getFid();
        vVar.f11268b = this.y.getTid();
        vVar.f11270d = this.p.g() + 1;
        vVar.f11272f = this.p.b();
        vVar.f11274h = i3;
        vVar.f11271e = 0;
        if (this.y.a.getBarLauncherType() == 3) {
            vVar.f11271e = 1;
        } else if (this.y.a.getBarLauncherType() == 2) {
            vVar.f11271e = 2;
        }
        vVar.f11269c = TbadkCoreApplication.getCurrentAccount();
        s(vVar, "c14124");
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
        if (r0 != 4) goto L12;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        getFocusedRect(this.i);
                        if (!this.i.contains(x, y)) {
                            x();
                            return true;
                        }
                        this.i.set(x, y, x + 1, y + 1);
                        GridView gridView = this.f31778c;
                        if (gridView != null) {
                            offsetRectIntoDescendantCoords(gridView, this.i);
                            GridView gridView2 = this.f31778c;
                            Rect rect = this.i;
                            int pointToPosition = gridView2.pointToPosition(rect.left, rect.top);
                            if (pointToPosition != -1) {
                                A(pointToPosition, this.f31778c);
                            }
                        }
                    } else if (action != 3) {
                    }
                }
                x();
            } else {
                this.x.set(x, y);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void s(v vVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, vVar, str) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("fid", vVar.a).param("tid", vVar.f11268b).param("uid", vVar.f11269c).param("obj_type", vVar.f11270d).param("obj_source", vVar.f11271e).param("obj_locate", vVar.f11272f).param("obj_param1", vVar.f11273g).param(TiebaStatic.Params.OBJ_PARAM2, vVar.f11274h);
            TiebaStatic.log(statisticItem);
        }
    }

    public void setOnDataSelected(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, editorTools) == null) {
            this.y = editorTools;
        }
    }

    public void setOnEmotionSwitchedListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.v = dVar;
        }
    }

    public final void t(List<c.a.o0.w.p.d> list) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.q.clear();
            this.r.clear();
            if (list == null || list.isEmpty()) {
                return;
            }
            this.q.addAll(list);
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                c.a.o0.w.p.d dVar = list.get(i2);
                if (dVar != null) {
                    int c2 = dVar.c();
                    int a2 = dVar.a();
                    int k = dVar.k();
                    int i3 = a2 * k;
                    int i4 = c2 / i3;
                    if (c2 % i3 != 0) {
                        i4++;
                    }
                    int i5 = 0;
                    while (i5 < i4) {
                        c.a.p0.v0.d.b bVar = new c.a.p0.v0.d.b();
                        int i6 = i4 - 1;
                        int i7 = i5 < i6 ? i3 : c2 - (i6 * i3);
                        bVar.u(dVar);
                        bVar.r(i2);
                        bVar.m(dVar.h());
                        bVar.s(k);
                        bVar.k(a2);
                        bVar.q(i4);
                        bVar.p(i5);
                        bVar.l(i7);
                        bVar.t(i5 * a2 * k);
                        bVar.n((i + i7) - 1);
                        this.r.add(bVar);
                        i5++;
                    }
                }
            }
            this.s = this.r.size();
            for (int i8 = 0; i8 < this.s; i8++) {
                List<c.a.p0.v0.d.b> list2 = this.r;
                if (list2 != null && list2.get(i8) != null) {
                    this.r.get(i8).o(i8);
                }
            }
        }
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
            this.A = context;
            this.q = new ArrayList();
            this.r = new ArrayList();
            this.B = new c.a.d.f.k.b<>(new a(this), 3, 0);
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d026e, (ViewGroup) this, true);
            ViewPager viewPager = (ViewPager) findViewById(R.id.obfuscated_res_0x7f09095f);
            this.a = viewPager;
            viewPager.setFadingEdgeLength(0);
            this.a.setOnPageChangeListener(this);
            GifView gifView = new GifView(context);
            this.f31783h = gifView;
            SkinManager.setBackgroundResource(gifView, R.drawable.bg_expression_bubble, this.z);
            this.f31783h.setVisibility(8);
            this.f31781f = (WindowManager) context.getSystemService("window");
            this.f31782g = new WindowManager.LayoutParams();
            this.k = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07027a);
            this.l = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070280);
            this.m = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070229);
            WindowManager.LayoutParams layoutParams = this.f31782g;
            layoutParams.width = this.k;
            layoutParams.height = this.l;
            layoutParams.gravity = 51;
            layoutParams.format = -3;
            layoutParams.type = 1000;
            layoutParams.flags |= 56;
            this.j = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
            this.f31779d = (IndicatorView) findViewById(R.id.obfuscated_res_0x7f090880);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f09095c);
            this.f31780e = linearLayout;
            linearLayout.setClickable(true);
            if (MenuKeyUtils.hasSmartBar()) {
                WindowManager.LayoutParams layoutParams2 = this.f31782g;
                layoutParams2.type = 1000;
                layoutParams2.flags = 25165832;
            }
        }
    }

    public final void v(int i) {
        List<c.a.p0.v0.d.b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i) == null) || (list = this.r) == null) {
            return;
        }
        int size = list.size();
        if (i < 0 || i >= size) {
            return;
        }
        for (int i2 = 0; i2 < size; i2++) {
            c.a.p0.v0.d.b bVar = this.r.get(i2);
            if (bVar != null && bVar.g() == i) {
                this.w = bVar.d();
                return;
            }
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.z = i;
            SkinManager.setBackgroundResource(this.f31783h, R.drawable.bg_expression_bubble, i);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0206, i);
            this.f31779d.setSelector(SkinManager.getDrawable(i, (int) R.drawable.dot_pb_expression_s));
            this.f31779d.setDrawable(SkinManager.getDrawable(i, (int) R.drawable.dot_pb_expression_n));
            if (this.a != null) {
                for (int i2 = 0; i2 < this.a.getChildCount(); i2++) {
                    View childAt = this.a.getChildAt(i2);
                    if (childAt != null && (childAt instanceof GridView)) {
                        GridView gridView = (GridView) childAt;
                        if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof c)) {
                            ((c) gridView.getAdapter()).notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    }

    public final void x() {
        GridView gridView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || !this.n || this.f31783h.getVisibility() == 8 || (gridView = this.f31778c) == null) {
            return;
        }
        gridView.setSelection(-1);
        this.f31783h.setVisibility(8);
        this.f31781f.removeView(this.f31783h);
        this.n = false;
        int i = this.o;
        if (i != -1) {
            GridView gridView2 = this.f31778c;
            ((LinearLayout) gridView2.getChildAt(i - gridView2.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
        }
        this.o = -1;
        this.f31778c = null;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            x();
        }
    }

    public void z(List<c.a.o0.w.p.d> list, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048594, this, list, i) == null) || list == null) {
            return;
        }
        int size = list.size();
        if (i < 0 || i >= size) {
            return;
        }
        t(list);
        v(i);
        EmotionViewPagerAdapter emotionViewPagerAdapter = new EmotionViewPagerAdapter(this);
        this.f31777b = emotionViewPagerAdapter;
        this.a.setAdapter(emotionViewPagerAdapter);
        this.a.setCurrentItem(this.w, true);
        d dVar = this.v;
        if (dVar != null) {
            dVar.c(i);
            this.t = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionTabContentView(Context context) {
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
        this.i = new Rect();
        this.o = -1;
        this.s = 0;
        this.t = -1;
        this.u = -1;
        this.x = new Point();
        this.C = new b(this, 2921028);
        u(context);
    }
}
