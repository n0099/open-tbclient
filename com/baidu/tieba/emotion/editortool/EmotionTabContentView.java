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
import c.a.q0.t.c.w;
import c.a.q0.t.c.x;
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
/* loaded from: classes10.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public final Point B;
    public EditorTools C;
    public int D;
    public Context E;
    public c.a.d.f.k.b<GridView> F;
    public CustomMessageListener G;

    /* renamed from: e  reason: collision with root package name */
    public ViewPager f43421e;

    /* renamed from: f  reason: collision with root package name */
    public EmotionViewPagerAdapter f43422f;

    /* renamed from: g  reason: collision with root package name */
    public GridView f43423g;

    /* renamed from: h  reason: collision with root package name */
    public IndicatorView f43424h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f43425i;

    /* renamed from: j  reason: collision with root package name */
    public WindowManager f43426j;

    /* renamed from: k  reason: collision with root package name */
    public WindowManager.LayoutParams f43427k;
    public GifView l;
    public final Rect m;
    public ViewGroup n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public int s;
    public c.a.r0.t0.b.b t;
    public List<c.a.q0.x.p.c> u;
    public List<c.a.r0.t0.b.b> v;
    public int w;
    public int x;
    public int y;
    public d z;

    /* loaded from: classes10.dex */
    public class EmotionViewPagerAdapter extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabContentView a;

        /* loaded from: classes10.dex */
        public class a implements AdapterView.OnItemLongClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ EmotionViewPagerAdapter f43428e;

            public a(EmotionViewPagerAdapter emotionViewPagerAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {emotionViewPagerAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f43428e = emotionViewPagerAdapter;
            }

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                InterceptResult invokeCommon;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
                    c cVar = (c) adapterView.getAdapter();
                    if (cVar == null || cVar.a() == null) {
                        return false;
                    }
                    c.a.r0.t0.b.b a = cVar.a();
                    if (a.c() == EmotionGroupType.BIG_EMOTION || a.c() == EmotionGroupType.USER_COLLECT) {
                        this.f43428e.a.showFloatView(i2, (GridView) adapterView);
                        return true;
                    }
                    return false;
                }
                return invokeCommon.booleanValue;
            }
        }

        /* loaded from: classes10.dex */
        public class b implements AdapterView.OnItemClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ EmotionViewPagerAdapter f43429e;

            public b(EmotionViewPagerAdapter emotionViewPagerAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {emotionViewPagerAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f43429e = emotionViewPagerAdapter;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                    adapterView.setSelection(-1);
                    if (this.f43429e.a.C != null) {
                        w wVar = new w();
                        c cVar = (c) adapterView.getAdapter();
                        if (cVar == null || cVar.a() == null) {
                            return;
                        }
                        c.a.r0.t0.b.b a = cVar.a();
                        int b2 = cVar.b();
                        c.a.q0.x.p.c j3 = a.j();
                        String b3 = a.j().b(b2 + i2);
                        if (j3.h() == EmotionGroupType.USER_COLLECT && c.a.q0.c0.d.f11794d.equals(b3)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(this.f43429e.a.E)));
                            return;
                        }
                        wVar.j(b3);
                        wVar.m(j3.h());
                        wVar.l(j3.g());
                        wVar.k(j3.f());
                        wVar.o(j3.l());
                        wVar.i(j3.i());
                        x xVar = new x();
                        xVar.a = this.f43429e.a.C.getFid();
                        xVar.f13423b = this.f43429e.a.C.getTid();
                        xVar.f13425d = a.g() + 1;
                        xVar.f13429h = a.e() + 1;
                        xVar.f13427f = (a.e() * 21) + i2 + 1;
                        xVar.f13428g = 0;
                        xVar.f13426e = 0;
                        if (this.f43429e.a.C.mEB.getBarLauncherType() != 3) {
                            if (this.f43429e.a.C.mEB.getBarLauncherType() == 2) {
                                xVar.f13426e = 2;
                            }
                        } else {
                            xVar.f13426e = 1;
                        }
                        xVar.f13424c = TbadkCoreApplication.getCurrentAccount();
                        wVar.h(xVar);
                        this.f43429e.a.C.sendAction(new c.a.q0.x.a(24, -1, wVar));
                        this.f43429e.a.emotionStatistics(xVar, "c14122");
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = emotionTabContentView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) {
                GridView gridView = (GridView) obj;
                viewGroup.removeView(gridView);
                this.a.F.e(gridView);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.v == null) {
                    return 0;
                }
                return this.a.v.size();
            }
            return invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2)) == null) {
                GridView gridView = (GridView) this.a.F.b();
                if (gridView == null) {
                    gridView = new GridView(this.a.E);
                }
                gridView.setScrollbarFadingEnabled(false);
                if (this.a.v != null && i2 < this.a.v.size()) {
                    c.a.r0.t0.b.b bVar = (c.a.r0.t0.b.b) this.a.v.get(i2);
                    gridView.setNumColumns(bVar.a());
                    gridView.setVerticalSpacing(0);
                    gridView.setHorizontalSpacing(0);
                    gridView.setSelector(R.color.common_color_10022);
                    gridView.setPadding(this.a.E.getResources().getDimensionPixelSize(R.dimen.ds28), 0, this.a.E.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
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
        public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048580, this, viewGroup, i2, obj) == null) {
                if (this.a.v != null) {
                    int size = this.a.v.size();
                    if (i2 == 0 && i2 < size && i2 != this.a.y) {
                        c.a.r0.t0.b.b bVar = (c.a.r0.t0.b.b) this.a.v.get(i2);
                        if (bVar != null) {
                            this.a.y = i2;
                            this.a.f43424h.setVisibility(bVar.f() > 1 ? 0 : 4);
                            this.a.f43424h.setCount(bVar.f());
                            this.a.f43424h.setPosition(bVar.e());
                            this.a.f43424h.setContentDescription(String.format(this.a.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.e() + 1)) + String.format(this.a.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.f())));
                        }
                        if (bVar != null && bVar.g() != this.a.x) {
                            this.a.x = bVar.g();
                            if (this.a.z != null) {
                                this.a.z.onEmotionSwitched(bVar.g());
                            }
                        }
                    }
                }
                super.setPrimaryItem(viewGroup, i2, obj);
            }
        }
    }

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes10.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EmotionTabContentView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(EmotionTabContentView emotionTabContentView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabContentView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                this.a.s(new ArrayList(this.a.u));
                if (this.a.f43422f == null) {
                    return;
                }
                this.a.f43422f.notifyDataSetChanged();
                if ((this.a.x < 0 || this.a.x >= this.a.u.size() || ((c.a.q0.x.p.c) this.a.u.get(this.a.x)).h() == EmotionGroupType.USER_COLLECT) && this.a.f43422f != null) {
                    if (this.a.y >= 0 && this.a.y < this.a.v.size()) {
                        EmotionTabContentView emotionTabContentView = this.a;
                        emotionTabContentView.t = (c.a.r0.t0.b.b) emotionTabContentView.v.get(this.a.y);
                        int f2 = this.a.t.f();
                        this.a.f43424h.setCount(f2);
                        this.a.f43424h.setVisibility(f2 > 1 ? 0 : 4);
                    }
                    if (this.a.f43421e != null) {
                        for (int i2 = 0; i2 < this.a.f43421e.getChildCount(); i2++) {
                            try {
                                View childAt = this.a.f43421e.getChildAt(i2);
                                if (childAt != null && (childAt instanceof GridView)) {
                                    GridView gridView = (GridView) childAt;
                                    if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof c)) {
                                        c cVar = (c) gridView.getAdapter();
                                        int d2 = cVar.a().d();
                                        if (d2 >= 0 && d2 < this.a.v.size()) {
                                            cVar.c((c.a.r0.t0.b.b) this.a.v.get(d2));
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

    /* loaded from: classes10.dex */
    public class c extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public c.a.r0.t0.b.b f43430e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EmotionTabContentView f43431f;

        /* loaded from: classes10.dex */
        public class a extends c.a.d.f.l.c<c.a.d.m.d.a> {
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.d.f.l.c
            public void onLoaded(c.a.d.m.d.a aVar, String str, int i2) {
                View findViewWithTag;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) || aVar == null || (findViewWithTag = this.a.f43431f.findViewWithTag(str)) == null || !(findViewWithTag instanceof TbImageView) || str == null) {
                    return;
                }
                TbImageView tbImageView = (TbImageView) findViewWithTag;
                aVar.h(tbImageView);
                tbImageView.setTag(null);
            }
        }

        public c(EmotionTabContentView emotionTabContentView, c.a.r0.t0.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {emotionTabContentView, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43431f = emotionTabContentView;
            this.f43430e = bVar;
        }

        public c.a.r0.t0.b.b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f43430e : (c.a.r0.t0.b.b) invokeV.objValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                c.a.r0.t0.b.b bVar = this.f43430e;
                if (bVar == null) {
                    return 0;
                }
                return bVar.i();
            }
            return invokeV.intValue;
        }

        public void c(c.a.r0.t0.b.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
                this.f43430e = bVar;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                c.a.r0.t0.b.b bVar = this.f43430e;
                if (bVar == null) {
                    return 0;
                }
                return bVar.b();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? Integer.valueOf(i2) : invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? i2 : invokeI.longValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            LinearLayout linearLayout;
            int i3;
            int color;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
                if (view == null) {
                    LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.emotion_tab_content_item, (ViewGroup) null);
                    int measuredWidth = viewGroup.getMeasuredWidth();
                    int measuredHeight = viewGroup.getMeasuredHeight();
                    int a2 = this.f43430e.a() != 0 ? measuredWidth / this.f43430e.a() : 0;
                    int h2 = this.f43430e.h() != 0 ? measuredHeight / this.f43430e.h() : 0;
                    linearLayout2.setPadding(this.f43431f.q * 2, this.f43431f.q * 2, this.f43431f.q * 2, this.f43431f.q * 2);
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
                c.a.r0.t0.b.b bVar = this.f43430e;
                if (bVar == null) {
                    return linearLayout3;
                }
                int i4 = bVar.i() + i2;
                TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
                tbImageView.setAutoChangeStyle(false);
                SkinManager.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, this.f43431f.D);
                tbImageView.setPadding(0, 0, 0, 0);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                String b2 = this.f43430e.j().b(i4);
                tbImageView.setTag(b2);
                if (TextUtils.isEmpty(b2)) {
                    i3 = 3;
                } else {
                    i3 = 3;
                    Object k2 = c.a.d.f.l.d.h().k(b2, 20, new a(this), 0, 0, null, null, b2, Boolean.FALSE, null);
                    c.a.d.m.d.a aVar = (k2 == null || !(k2 instanceof c.a.d.m.d.a)) ? null : (c.a.d.m.d.a) k2;
                    if (aVar != null) {
                        aVar.h(tbImageView);
                        tbImageView.setTag(null);
                    }
                }
                TextView textView = (TextView) linearLayout3.findViewById(R.id.emotion_tab_content_tip);
                if (this.f43430e.c() == EmotionGroupType.BIG_EMOTION) {
                    String b3 = this.f43430e.j().b(i4);
                    if (!TextUtils.isEmpty(b3) && !b3.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                        if (this.f43431f.D == 0) {
                            color = this.f43431f.getContext().getResources().getColor(R.color.CAM_X0108);
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
                if (b2 != null && b2.length() > i3) {
                    linearLayout3.setContentDescription(b2.substring(2, b2.length() - 1));
                }
                return linearLayout3;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public interface d {
        void onEmotionSwitched(int i2);
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
        this.m = new Rect();
        this.s = -1;
        this.w = 0;
        this.x = -1;
        this.y = -1;
        this.B = new Point();
        this.G = new b(this, 2921028);
        t(context);
    }

    public void emotionStatistics(x xVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, xVar, str) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("fid", xVar.a).param("tid", xVar.f13423b).param("uid", xVar.f13424c).param("obj_type", xVar.f13425d).param("obj_source", xVar.f13426e).param("obj_locate", xVar.f13427f).param("obj_param1", xVar.f13428g).param(TiebaStatic.Params.OBJ_PARAM2, xVar.f13429h);
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.G);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.D = i2;
            SkinManager.setBackgroundResource(this.l, R.drawable.bg_expression_bubble, i2);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0206, i2);
            this.f43424h.setSelector(SkinManager.getDrawable(i2, R.drawable.dot_pb_expression_s));
            this.f43424h.setDrawable(SkinManager.getDrawable(i2, R.drawable.dot_pb_expression_n));
            if (this.f43421e != null) {
                for (int i3 = 0; i3 < this.f43421e.getChildCount(); i3++) {
                    View childAt = this.f43421e.getChildAt(i3);
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

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDetachedFromWindow();
            if (this.r) {
                this.f43426j.removeView(this.l);
                this.r = false;
            }
            MessageManager.getInstance().unRegisterListener(this.G);
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
                        this.B.set(x, y);
                        if (this.r && this.l.getVisibility() != 8 && this.f43423g != null) {
                            return true;
                        }
                    }
                }
                v();
            } else {
                this.B.set(x, y);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        List<c.a.r0.t0.b.b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || (list = this.v) == null) {
            return;
        }
        int size = list.size();
        if (i2 < 0 || i2 >= size) {
            return;
        }
        c.a.r0.t0.b.b bVar = this.v.get(i2);
        this.t = bVar;
        IndicatorView indicatorView = this.f43424h;
        if (indicatorView == null || bVar == null) {
            return;
        }
        if (this.y != i2) {
            this.y = i2;
            indicatorView.setVisibility(bVar.f() > 1 ? 0 : 4);
            this.f43424h.setCount(this.t.f());
            c.a.r0.t0.b.b bVar2 = this.t;
            if (bVar2 != null && bVar2.g() != this.x) {
                this.x = this.t.g();
                d dVar = this.z;
                if (dVar != null) {
                    dVar.onEmotionSwitched(this.t.g());
                }
            }
        }
        float e2 = this.t.e() + f2;
        this.f43424h.setPosition(e2);
        StringBuilder sb = new StringBuilder();
        int i4 = ((int) e2) + 1;
        sb.append(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(i4)));
        sb.append(String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.t.f())));
        this.f43425i.setContentDescription(sb.toString());
        x xVar = new x();
        xVar.a = this.C.getFid();
        xVar.f13423b = this.C.getTid();
        xVar.f13425d = this.t.g() + 1;
        xVar.f13427f = this.t.b();
        xVar.f13429h = i4;
        xVar.f13426e = 0;
        if (this.C.mEB.getBarLauncherType() == 3) {
            xVar.f13426e = 1;
        } else if (this.C.mEB.getBarLauncherType() == 2) {
            xVar.f13426e = 2;
        }
        xVar.f13424c = TbadkCoreApplication.getCurrentAccount();
        emotionStatistics(xVar, "c14124");
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
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
                        getFocusedRect(this.m);
                        if (!this.m.contains(x, y)) {
                            v();
                            return true;
                        }
                        this.m.set(x, y, x + 1, y + 1);
                        GridView gridView = this.f43423g;
                        if (gridView != null) {
                            offsetRectIntoDescendantCoords(gridView, this.m);
                            GridView gridView2 = this.f43423g;
                            Rect rect = this.m;
                            int pointToPosition = gridView2.pointToPosition(rect.left, rect.top);
                            if (pointToPosition != -1) {
                                showFloatView(pointToPosition, this.f43423g);
                            }
                        }
                    } else if (action != 3) {
                    }
                }
                v();
            } else {
                this.B.set(x, y);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            v();
        }
    }

    public final void s(List<c.a.q0.x.p.c> list) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            this.u.clear();
            this.v.clear();
            if (list == null || list.isEmpty()) {
                return;
            }
            this.u.addAll(list);
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                c.a.q0.x.p.c cVar = list.get(i3);
                if (cVar != null) {
                    int c2 = cVar.c();
                    int a2 = cVar.a();
                    int k2 = cVar.k();
                    int i4 = a2 * k2;
                    int i5 = c2 / i4;
                    if (c2 % i4 != 0) {
                        i5++;
                    }
                    int i6 = 0;
                    while (i6 < i5) {
                        c.a.r0.t0.b.b bVar = new c.a.r0.t0.b.b();
                        int i7 = i5 - 1;
                        int i8 = i6 < i7 ? i4 : c2 - (i7 * i4);
                        bVar.u(cVar);
                        bVar.r(i3);
                        bVar.m(cVar.h());
                        bVar.s(k2);
                        bVar.k(a2);
                        bVar.q(i5);
                        bVar.p(i6);
                        bVar.l(i8);
                        bVar.t(i6 * a2 * k2);
                        bVar.n((i2 + i8) - 1);
                        this.v.add(bVar);
                        i6++;
                    }
                }
            }
            this.w = this.v.size();
            for (int i9 = 0; i9 < this.w; i9++) {
                List<c.a.r0.t0.b.b> list2 = this.v;
                if (list2 != null && list2.get(i9) != null) {
                    this.v.get(i9).o(i9);
                }
            }
        }
    }

    public void setOnDataSelected(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, editorTools) == null) {
            this.C = editorTools;
        }
    }

    public void setOnEmotionSwitchedListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) {
            this.z = dVar;
        }
    }

    public void showAllPackages(List<c.a.q0.x.p.c> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048589, this, list, i2) == null) || list == null) {
            return;
        }
        int size = list.size();
        if (i2 < 0 || i2 >= size) {
            return;
        }
        s(list);
        u(i2);
        EmotionViewPagerAdapter emotionViewPagerAdapter = new EmotionViewPagerAdapter(this);
        this.f43422f = emotionViewPagerAdapter;
        this.f43421e.setAdapter(emotionViewPagerAdapter);
        this.f43421e.setCurrentItem(this.A, true);
        d dVar = this.z;
        if (dVar != null) {
            dVar.onEmotionSwitched(i2);
            this.x = i2;
        }
    }

    public void showFloatView(int i2, GridView gridView) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048590, this, i2, gridView) == null) || this.s == i2 || gridView == null || (cVar = (c) gridView.getAdapter()) == null || cVar.a() == null) {
            return;
        }
        c.a.r0.t0.b.b a2 = cVar.a();
        String b2 = a2.j().b(cVar.b() + i2);
        if (a2.c() == EmotionGroupType.USER_COLLECT && c.a.q0.c0.d.f11794d.equals(b2)) {
            return;
        }
        this.l.setTag(b2);
        GifInfo gifInfo = new GifInfo();
        gifInfo.mSharpText = b2;
        if (b2.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
            this.l.setShowStaticDrawable(false);
        } else {
            this.l.setShowStaticDrawable(true);
        }
        this.l.startLoad(gifInfo);
        LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i2 - gridView.getFirstVisiblePosition());
        linearLayout.getDrawingRect(this.m);
        this.n.offsetDescendantRectToMyCoords(linearLayout, this.m);
        WindowManager.LayoutParams layoutParams = this.f43427k;
        layoutParams.x = this.m.left - ((layoutParams.width - linearLayout.getWidth()) / 2);
        WindowManager.LayoutParams layoutParams2 = this.f43427k;
        layoutParams2.y = (this.m.top - layoutParams2.height) + this.q;
        this.l.setVisibility(0);
        if (!this.r) {
            this.f43426j.addView(this.l, this.f43427k);
            this.r = true;
        } else {
            this.f43426j.updateViewLayout(this.l, this.f43427k);
        }
        gridView.setSelection(i2);
        int i3 = this.s;
        if (i3 != -1) {
            ((LinearLayout) gridView.getChildAt(i3 - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
        }
        linearLayout.getChildAt(0).setSelected(true);
        this.s = i2;
        this.f43423g = gridView;
    }

    public final void t(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, context) == null) {
            this.E = context;
            this.u = new ArrayList();
            this.v = new ArrayList();
            this.F = new c.a.d.f.k.b<>(new a(this), 3, 0);
            setOrientation(1);
            LayoutInflater.from(context).inflate(R.layout.emotion_tab_content, (ViewGroup) this, true);
            ViewPager viewPager = (ViewPager) findViewById(R.id.face_tab_viewpager);
            this.f43421e = viewPager;
            viewPager.setFadingEdgeLength(0);
            this.f43421e.setOnPageChangeListener(this);
            GifView gifView = new GifView(context);
            this.l = gifView;
            SkinManager.setBackgroundResource(gifView, R.drawable.bg_expression_bubble, this.D);
            this.l.setVisibility(8);
            this.f43426j = (WindowManager) context.getSystemService("window");
            this.f43427k = new WindowManager.LayoutParams();
            this.o = context.getResources().getDimensionPixelSize(R.dimen.ds240);
            this.p = context.getResources().getDimensionPixelSize(R.dimen.ds252);
            this.q = context.getResources().getDimensionPixelSize(R.dimen.ds10);
            WindowManager.LayoutParams layoutParams = this.f43427k;
            layoutParams.width = this.o;
            layoutParams.height = this.p;
            layoutParams.gravity = 51;
            layoutParams.format = -3;
            layoutParams.type = 1000;
            layoutParams.flags |= 56;
            this.n = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
            this.f43424h = (IndicatorView) findViewById(R.id.emotion_face_tab_indicator);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
            this.f43425i = linearLayout;
            linearLayout.setClickable(true);
            if (MenuKeyUtils.hasSmartBar()) {
                WindowManager.LayoutParams layoutParams2 = this.f43427k;
                layoutParams2.type = 1000;
                layoutParams2.flags = 25165832;
            }
        }
    }

    public void toEmotionPage(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || this.f43421e == null) {
            return;
        }
        int size = this.v.size();
        if (i2 < 0 || i2 >= size) {
            return;
        }
        int i4 = 0;
        while (true) {
            if (i4 < size) {
                c.a.r0.t0.b.b bVar = this.v.get(i4);
                if (bVar != null && bVar.g() == i2) {
                    i3 = bVar.d();
                    break;
                }
                i4++;
            } else {
                i3 = 0;
                break;
            }
        }
        this.f43421e.setCurrentItem(i3, false);
    }

    public final void u(int i2) {
        List<c.a.r0.t0.b.b> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || (list = this.v) == null) {
            return;
        }
        int size = list.size();
        if (i2 < 0 || i2 >= size) {
            return;
        }
        for (int i3 = 0; i3 < size; i3++) {
            c.a.r0.t0.b.b bVar = this.v.get(i3);
            if (bVar != null && bVar.g() == i2) {
                this.A = bVar.d();
                return;
            }
        }
    }

    public final void v() {
        GridView gridView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || !this.r || this.l.getVisibility() == 8 || (gridView = this.f43423g) == null) {
            return;
        }
        gridView.setSelection(-1);
        this.l.setVisibility(8);
        this.f43426j.removeView(this.l);
        this.r = false;
        int i2 = this.s;
        if (i2 != -1) {
            GridView gridView2 = this.f43423g;
            ((LinearLayout) gridView2.getChildAt(i2 - gridView2.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
        }
        this.s = -1;
        this.f43423g = null;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new Rect();
        this.s = -1;
        this.w = 0;
        this.x = -1;
        this.y = -1;
        this.B = new Point();
        this.G = new b(this, 2921028);
        t(context);
    }
}
