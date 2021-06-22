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
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.IndicatorView;
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
import com.compatible.menukey.MenuKeyUtils;
import d.a.n0.s.c.v;
import d.a.n0.s.c.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class EmotionTabContentView extends LinearLayout implements ViewPager.OnPageChangeListener {
    public int A;
    public final Point B;
    public EditorTools C;
    public int D;
    public Context E;
    public d.a.c.e.k.b<GridView> F;
    public CustomMessageListener G;

    /* renamed from: e  reason: collision with root package name */
    public ViewPager f14462e;

    /* renamed from: f  reason: collision with root package name */
    public EmotionViewPagerAdapter f14463f;

    /* renamed from: g  reason: collision with root package name */
    public GridView f14464g;

    /* renamed from: h  reason: collision with root package name */
    public IndicatorView f14465h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f14466i;
    public WindowManager j;
    public WindowManager.LayoutParams k;
    public GifView l;
    public final Rect m;
    public ViewGroup n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public int s;
    public d.a.o0.i0.b.b t;
    public List<d.a.n0.w.p.c> u;
    public List<d.a.o0.i0.b.b> v;
    public int w;
    public int x;
    public int y;
    public d z;

    /* loaded from: classes4.dex */
    public class EmotionViewPagerAdapter extends PagerAdapter {

        /* loaded from: classes4.dex */
        public class a implements AdapterView.OnItemLongClickListener {
            public a() {
            }

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                c cVar = (c) adapterView.getAdapter();
                if (cVar == null || cVar.a() == null) {
                    return false;
                }
                d.a.o0.i0.b.b a2 = cVar.a();
                if (a2.c() == EmotionGroupType.BIG_EMOTION || a2.c() == EmotionGroupType.USER_COLLECT) {
                    EmotionTabContentView.this.A(i2, (GridView) adapterView);
                    return true;
                }
                return false;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements AdapterView.OnItemClickListener {
            public b() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                adapterView.setSelection(-1);
                if (EmotionTabContentView.this.C != null) {
                    v vVar = new v();
                    c cVar = (c) adapterView.getAdapter();
                    if (cVar == null || cVar.a() == null) {
                        return;
                    }
                    d.a.o0.i0.b.b a2 = cVar.a();
                    int b2 = cVar.b();
                    d.a.n0.w.p.c j2 = a2.j();
                    String b3 = a2.j().b(b2 + i2);
                    if (j2.h() == EmotionGroupType.USER_COLLECT && d.a.n0.a0.d.f52597d.equals(b3)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new UserCollectManageActivityConfig(EmotionTabContentView.this.E)));
                        return;
                    }
                    vVar.k(b3);
                    vVar.n(j2.h());
                    vVar.m(j2.g());
                    vVar.l(j2.f());
                    vVar.p(j2.l());
                    vVar.j(j2.i());
                    w wVar = new w();
                    wVar.f54318a = EmotionTabContentView.this.C.getFid();
                    wVar.f54319b = EmotionTabContentView.this.C.getTid();
                    wVar.f54321d = a2.g() + 1;
                    wVar.f54325h = a2.e() + 1;
                    wVar.f54323f = (a2.e() * 21) + i2 + 1;
                    wVar.f54324g = 0;
                    wVar.f54322e = 0;
                    if (EmotionTabContentView.this.C.f12891e.getBarLauncherType() != 3) {
                        if (EmotionTabContentView.this.C.f12891e.getBarLauncherType() == 2) {
                            wVar.f54322e = 2;
                        }
                    } else {
                        wVar.f54322e = 1;
                    }
                    wVar.f54320c = TbadkCoreApplication.getCurrentAccount();
                    vVar.i(wVar);
                    EmotionTabContentView.this.C.A(new d.a.n0.w.a(24, -1, vVar));
                    EmotionTabContentView.this.s(wVar, "c14122");
                }
            }
        }

        public EmotionViewPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            GridView gridView = (GridView) obj;
            viewGroup.removeView(gridView);
            EmotionTabContentView.this.F.e(gridView);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (EmotionTabContentView.this.v == null) {
                return 0;
            }
            return EmotionTabContentView.this.v.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            GridView gridView = (GridView) EmotionTabContentView.this.F.b();
            if (gridView == null) {
                gridView = new GridView(EmotionTabContentView.this.E);
            }
            gridView.setScrollbarFadingEnabled(false);
            if (EmotionTabContentView.this.v != null && i2 < EmotionTabContentView.this.v.size()) {
                d.a.o0.i0.b.b bVar = (d.a.o0.i0.b.b) EmotionTabContentView.this.v.get(i2);
                gridView.setNumColumns(bVar.a());
                gridView.setVerticalSpacing(0);
                gridView.setHorizontalSpacing(0);
                gridView.setSelector(R.color.common_color_10022);
                gridView.setPadding(EmotionTabContentView.this.E.getResources().getDimensionPixelSize(R.dimen.ds28), 0, EmotionTabContentView.this.E.getResources().getDimensionPixelSize(R.dimen.ds28), 0);
                gridView.setOnItemLongClickListener(new a());
                gridView.setOnItemClickListener(new b());
                gridView.setAdapter((ListAdapter) new c(bVar));
            }
            viewGroup.addView(gridView);
            return gridView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
            if (EmotionTabContentView.this.v != null) {
                int size = EmotionTabContentView.this.v.size();
                if (i2 == 0 && i2 < size && i2 != EmotionTabContentView.this.y) {
                    d.a.o0.i0.b.b bVar = (d.a.o0.i0.b.b) EmotionTabContentView.this.v.get(i2);
                    if (bVar != null) {
                        EmotionTabContentView.this.y = i2;
                        EmotionTabContentView.this.f14465h.setVisibility(bVar.f() > 1 ? 0 : 4);
                        EmotionTabContentView.this.f14465h.setCount(bVar.f());
                        EmotionTabContentView.this.f14465h.setPosition(bVar.e());
                        EmotionTabContentView.this.f14465h.setContentDescription(String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_selection), Integer.valueOf(bVar.e() + 1)) + String.format(EmotionTabContentView.this.getResources().getString(R.string.emotion_page), Integer.valueOf(bVar.f())));
                    }
                    if (bVar != null && bVar.g() != EmotionTabContentView.this.x) {
                        EmotionTabContentView.this.x = bVar.g();
                        if (EmotionTabContentView.this.z != null) {
                            EmotionTabContentView.this.z.c(bVar.g());
                        }
                    }
                }
            }
            super.setPrimaryItem(viewGroup, i2, obj);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements d.a.c.e.k.c<GridView> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ GridView a(GridView gridView) {
            GridView gridView2 = gridView;
            e(gridView2);
            return gridView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ GridView c(GridView gridView) {
            GridView gridView2 = gridView;
            h(gridView2);
            return gridView2;
        }

        public GridView e(GridView gridView) {
            return gridView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(GridView gridView) {
            gridView.setAdapter((ListAdapter) null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public GridView d() {
            return new GridView(EmotionTabContentView.this.getContext());
        }

        public GridView h(GridView gridView) {
            gridView.setAdapter((ListAdapter) null);
            return gridView;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() != 2921028) {
                return;
            }
            EmotionTabContentView.this.t(new ArrayList(EmotionTabContentView.this.u));
            if (EmotionTabContentView.this.f14463f == null) {
                return;
            }
            EmotionTabContentView.this.f14463f.notifyDataSetChanged();
            if ((EmotionTabContentView.this.x < 0 || EmotionTabContentView.this.x >= EmotionTabContentView.this.u.size() || ((d.a.n0.w.p.c) EmotionTabContentView.this.u.get(EmotionTabContentView.this.x)).h() == EmotionGroupType.USER_COLLECT) && EmotionTabContentView.this.f14463f != null) {
                if (EmotionTabContentView.this.y >= 0 && EmotionTabContentView.this.y < EmotionTabContentView.this.v.size()) {
                    EmotionTabContentView emotionTabContentView = EmotionTabContentView.this;
                    emotionTabContentView.t = (d.a.o0.i0.b.b) emotionTabContentView.v.get(EmotionTabContentView.this.y);
                    int f2 = EmotionTabContentView.this.t.f();
                    EmotionTabContentView.this.f14465h.setCount(f2);
                    EmotionTabContentView.this.f14465h.setVisibility(f2 > 1 ? 0 : 4);
                }
                if (EmotionTabContentView.this.f14462e != null) {
                    for (int i2 = 0; i2 < EmotionTabContentView.this.f14462e.getChildCount(); i2++) {
                        try {
                            View childAt = EmotionTabContentView.this.f14462e.getChildAt(i2);
                            if (childAt != null && (childAt instanceof GridView)) {
                                GridView gridView = (GridView) childAt;
                                if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof c)) {
                                    c cVar = (c) gridView.getAdapter();
                                    int d2 = cVar.a().d();
                                    if (d2 >= 0 && d2 < EmotionTabContentView.this.v.size()) {
                                        cVar.c((d.a.o0.i0.b.b) EmotionTabContentView.this.v.get(d2));
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

    /* loaded from: classes4.dex */
    public class c extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public d.a.o0.i0.b.b f14472e;

        /* loaded from: classes4.dex */
        public class a extends d.a.c.e.l.c<d.a.c.k.d.a> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.c.e.l.c
            public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
                View findViewWithTag;
                if (aVar == null || (findViewWithTag = EmotionTabContentView.this.findViewWithTag(str)) == null || !(findViewWithTag instanceof TbImageView) || str == null) {
                    return;
                }
                TbImageView tbImageView = (TbImageView) findViewWithTag;
                aVar.h(tbImageView);
                tbImageView.setTag(null);
            }
        }

        public c(d.a.o0.i0.b.b bVar) {
            this.f14472e = bVar;
        }

        public d.a.o0.i0.b.b a() {
            return this.f14472e;
        }

        public int b() {
            d.a.o0.i0.b.b bVar = this.f14472e;
            if (bVar == null) {
                return 0;
            }
            return bVar.i();
        }

        public void c(d.a.o0.i0.b.b bVar) {
            this.f14472e = bVar;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            d.a.o0.i0.b.b bVar = this.f14472e;
            if (bVar == null) {
                return 0;
            }
            return bVar.b();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return Integer.valueOf(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            LinearLayout linearLayout;
            int i3;
            int color;
            if (view == null) {
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.emotion_tab_content_item, (ViewGroup) null);
                int measuredWidth = viewGroup.getMeasuredWidth();
                int measuredHeight = viewGroup.getMeasuredHeight();
                int a2 = this.f14472e.a() != 0 ? measuredWidth / this.f14472e.a() : 0;
                int h2 = this.f14472e.h() != 0 ? measuredHeight / this.f14472e.h() : 0;
                linearLayout2.setPadding(EmotionTabContentView.this.q * 2, EmotionTabContentView.this.q * 2, EmotionTabContentView.this.q * 2, EmotionTabContentView.this.q * 2);
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
            d.a.o0.i0.b.b bVar = this.f14472e;
            if (bVar == null) {
                return linearLayout3;
            }
            int i4 = bVar.i() + i2;
            TbImageView tbImageView = (TbImageView) linearLayout3.findViewById(R.id.emotion_tab_content_img);
            tbImageView.setAutoChangeStyle(false);
            SkinManager.setBackgroundResource(tbImageView, R.drawable.btn_choose_face_selector, EmotionTabContentView.this.D);
            tbImageView.setPadding(0, 0, 0, 0);
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            String b2 = this.f14472e.j().b(i4);
            tbImageView.setTag(b2);
            if (TextUtils.isEmpty(b2)) {
                i3 = 3;
            } else {
                i3 = 3;
                Object k = d.a.c.e.l.d.h().k(b2, 20, new a(), 0, 0, null, null, b2, Boolean.FALSE, null);
                d.a.c.k.d.a aVar = (k == null || !(k instanceof d.a.c.k.d.a)) ? null : (d.a.c.k.d.a) k;
                if (aVar != null) {
                    aVar.h(tbImageView);
                    tbImageView.setTag(null);
                }
            }
            TextView textView = (TextView) linearLayout3.findViewById(R.id.emotion_tab_content_tip);
            if (this.f14472e.c() == EmotionGroupType.BIG_EMOTION) {
                String b3 = this.f14472e.j().b(i4);
                if (!TextUtils.isEmpty(b3) && !b3.startsWith(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX)) {
                    if (EmotionTabContentView.this.D == 0) {
                        color = EmotionTabContentView.this.getContext().getResources().getColor(R.color.CAM_X0108);
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
    }

    /* loaded from: classes4.dex */
    public interface d {
        void c(int i2);
    }

    public EmotionTabContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = new Rect();
        this.s = -1;
        this.w = 0;
        this.x = -1;
        this.y = -1;
        this.B = new Point();
        this.G = new b(2921028);
        u(context);
    }

    public void A(int i2, GridView gridView) {
        c cVar;
        if (this.s == i2 || gridView == null || (cVar = (c) gridView.getAdapter()) == null || cVar.a() == null) {
            return;
        }
        d.a.o0.i0.b.b a2 = cVar.a();
        String b2 = a2.j().b(cVar.b() + i2);
        if (a2.c() == EmotionGroupType.USER_COLLECT && d.a.n0.a0.d.f52597d.equals(b2)) {
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
        this.l.w0(gifInfo);
        LinearLayout linearLayout = (LinearLayout) gridView.getChildAt(i2 - gridView.getFirstVisiblePosition());
        linearLayout.getDrawingRect(this.m);
        this.n.offsetDescendantRectToMyCoords(linearLayout, this.m);
        WindowManager.LayoutParams layoutParams = this.k;
        layoutParams.x = this.m.left - ((layoutParams.width - linearLayout.getWidth()) / 2);
        WindowManager.LayoutParams layoutParams2 = this.k;
        layoutParams2.y = (this.m.top - layoutParams2.height) + this.q;
        this.l.setVisibility(0);
        if (!this.r) {
            this.j.addView(this.l, this.k);
            this.r = true;
        } else {
            this.j.updateViewLayout(this.l, this.k);
        }
        gridView.setSelection(i2);
        int i3 = this.s;
        if (i3 != -1) {
            ((LinearLayout) gridView.getChildAt(i3 - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
        }
        linearLayout.getChildAt(0).setSelected(true);
        this.s = i2;
        this.f14464g = gridView;
    }

    public void B(int i2) {
        int i3;
        if (this.f14462e != null) {
            int size = this.v.size();
            if (i2 < 0 || i2 >= size) {
                return;
            }
            int i4 = 0;
            while (true) {
                if (i4 < size) {
                    d.a.o0.i0.b.b bVar = this.v.get(i4);
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
            this.f14462e.setCurrentItem(i3, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.G);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.r) {
            this.j.removeView(this.l);
            this.r = false;
        }
        MessageManager.getInstance().unRegisterListener(this.G);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (r0 != 3) goto L9;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.B.set(x, y);
                    if (this.r && this.l.getVisibility() != 8 && this.f14464g != null) {
                        return true;
                    }
                }
            }
            x();
        } else {
            this.B.set(x, y);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        List<d.a.o0.i0.b.b> list = this.v;
        if (list != null) {
            int size = list.size();
            if (i2 < 0 || i2 >= size) {
                return;
            }
            d.a.o0.i0.b.b bVar = this.v.get(i2);
            this.t = bVar;
            IndicatorView indicatorView = this.f14465h;
            if (indicatorView == null || bVar == null) {
                return;
            }
            if (this.y != i2) {
                this.y = i2;
                indicatorView.setVisibility(bVar.f() > 1 ? 0 : 4);
                this.f14465h.setCount(this.t.f());
                d.a.o0.i0.b.b bVar2 = this.t;
                if (bVar2 != null && bVar2.g() != this.x) {
                    this.x = this.t.g();
                    d dVar = this.z;
                    if (dVar != null) {
                        dVar.c(this.t.g());
                    }
                }
            }
            float e2 = this.t.e() + f2;
            this.f14465h.setPosition(e2);
            StringBuilder sb = new StringBuilder();
            int i4 = ((int) e2) + 1;
            sb.append(String.format(getResources().getString(R.string.emotion_selection), Integer.valueOf(i4)));
            sb.append(String.format(getResources().getString(R.string.emotion_page), Integer.valueOf(this.t.f())));
            this.f14466i.setContentDescription(sb.toString());
            w wVar = new w();
            wVar.f54318a = this.C.getFid();
            wVar.f54319b = this.C.getTid();
            wVar.f54321d = this.t.g() + 1;
            wVar.f54323f = this.t.b();
            wVar.f54325h = i4;
            wVar.f54322e = 0;
            if (this.C.f12891e.getBarLauncherType() == 3) {
                wVar.f54322e = 1;
            } else if (this.C.f12891e.getBarLauncherType() == 2) {
                wVar.f54322e = 2;
            }
            wVar.f54320c = TbadkCoreApplication.getCurrentAccount();
            s(wVar, "c14124");
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r0 != 4) goto L10;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    getFocusedRect(this.m);
                    if (!this.m.contains(x, y)) {
                        x();
                        return true;
                    }
                    this.m.set(x, y, x + 1, y + 1);
                    GridView gridView = this.f14464g;
                    if (gridView != null) {
                        offsetRectIntoDescendantCoords(gridView, this.m);
                        GridView gridView2 = this.f14464g;
                        Rect rect = this.m;
                        int pointToPosition = gridView2.pointToPosition(rect.left, rect.top);
                        if (pointToPosition != -1) {
                            A(pointToPosition, this.f14464g);
                        }
                    }
                } else if (action != 3) {
                }
            }
            x();
        } else {
            this.B.set(x, y);
        }
        return true;
    }

    public void s(w wVar, String str) {
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("fid", wVar.f54318a).param("tid", wVar.f54319b).param("uid", wVar.f54320c).param("obj_type", wVar.f54321d).param("obj_source", wVar.f54322e).param("obj_locate", wVar.f54323f).param("obj_param1", wVar.f54324g).param(TiebaStatic.Params.OBJ_PARAM2, wVar.f54325h);
        TiebaStatic.log(statisticItem);
    }

    public void setOnDataSelected(EditorTools editorTools) {
        this.C = editorTools;
    }

    public void setOnEmotionSwitchedListener(d dVar) {
        this.z = dVar;
    }

    public final void t(List<d.a.n0.w.p.c> list) {
        int i2;
        this.u.clear();
        this.v.clear();
        if (list == null || list.isEmpty()) {
            return;
        }
        this.u.addAll(list);
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            d.a.n0.w.p.c cVar = list.get(i3);
            if (cVar != null) {
                int c2 = cVar.c();
                int a2 = cVar.a();
                int k = cVar.k();
                int i4 = a2 * k;
                int i5 = c2 / i4;
                if (c2 % i4 != 0) {
                    i5++;
                }
                int i6 = 0;
                while (i6 < i5) {
                    d.a.o0.i0.b.b bVar = new d.a.o0.i0.b.b();
                    int i7 = i5 - 1;
                    int i8 = i6 < i7 ? i4 : c2 - (i7 * i4);
                    bVar.u(cVar);
                    bVar.r(i3);
                    bVar.m(cVar.h());
                    bVar.s(k);
                    bVar.k(a2);
                    bVar.q(i5);
                    bVar.p(i6);
                    bVar.l(i8);
                    bVar.t(i6 * a2 * k);
                    bVar.n((i2 + i8) - 1);
                    this.v.add(bVar);
                    i6++;
                }
            }
        }
        this.w = this.v.size();
        for (int i9 = 0; i9 < this.w; i9++) {
            List<d.a.o0.i0.b.b> list2 = this.v;
            if (list2 != null && list2.get(i9) != null) {
                this.v.get(i9).o(i9);
            }
        }
    }

    public final void u(Context context) {
        this.E = context;
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.F = new d.a.c.e.k.b<>(new a(), 3, 0);
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.emotion_tab_content, (ViewGroup) this, true);
        ViewPager viewPager = (ViewPager) findViewById(R.id.face_tab_viewpager);
        this.f14462e = viewPager;
        viewPager.setFadingEdgeLength(0);
        this.f14462e.setOnPageChangeListener(this);
        GifView gifView = new GifView(context);
        this.l = gifView;
        SkinManager.setBackgroundResource(gifView, R.drawable.bg_expression_bubble, this.D);
        this.l.setVisibility(8);
        this.j = (WindowManager) context.getSystemService("window");
        this.k = new WindowManager.LayoutParams();
        this.o = context.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.p = context.getResources().getDimensionPixelSize(R.dimen.ds252);
        this.q = context.getResources().getDimensionPixelSize(R.dimen.ds10);
        WindowManager.LayoutParams layoutParams = this.k;
        layoutParams.width = this.o;
        layoutParams.height = this.p;
        layoutParams.gravity = 51;
        layoutParams.format = -3;
        layoutParams.type = 1000;
        layoutParams.flags |= 56;
        this.n = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        this.f14465h = (IndicatorView) findViewById(R.id.face_tab_indicator);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.face_tab_indicator_layout);
        this.f14466i = linearLayout;
        linearLayout.setClickable(true);
        if (MenuKeyUtils.hasSmartBar()) {
            WindowManager.LayoutParams layoutParams2 = this.k;
            layoutParams2.type = 1000;
            layoutParams2.flags = 25165832;
        }
    }

    public final void v(int i2) {
        List<d.a.o0.i0.b.b> list = this.v;
        if (list == null) {
            return;
        }
        int size = list.size();
        if (i2 < 0 || i2 >= size) {
            return;
        }
        for (int i3 = 0; i3 < size; i3++) {
            d.a.o0.i0.b.b bVar = this.v.get(i3);
            if (bVar != null && bVar.g() == i2) {
                this.A = bVar.d();
                return;
            }
        }
    }

    public void w(int i2) {
        this.D = i2;
        SkinManager.setBackgroundResource(this.l, R.drawable.bg_expression_bubble, i2);
        SkinManager.setBackgroundColor(this, R.color.CAM_X0206, i2);
        this.f14465h.setSelector(SkinManager.getDrawable(i2, R.drawable.dot_pb_expression_s));
        this.f14465h.setDrawable(SkinManager.getDrawable(i2, R.drawable.dot_pb_expression_n));
        if (this.f14462e != null) {
            for (int i3 = 0; i3 < this.f14462e.getChildCount(); i3++) {
                View childAt = this.f14462e.getChildAt(i3);
                if (childAt != null && (childAt instanceof GridView)) {
                    GridView gridView = (GridView) childAt;
                    if (gridView.getAdapter() != null && (gridView.getAdapter() instanceof c)) {
                        ((c) gridView.getAdapter()).notifyDataSetChanged();
                    }
                }
            }
        }
    }

    public final void x() {
        GridView gridView;
        if (!this.r || this.l.getVisibility() == 8 || (gridView = this.f14464g) == null) {
            return;
        }
        gridView.setSelection(-1);
        this.l.setVisibility(8);
        this.j.removeView(this.l);
        this.r = false;
        int i2 = this.s;
        if (i2 != -1) {
            GridView gridView2 = this.f14464g;
            ((LinearLayout) gridView2.getChildAt(i2 - gridView2.getFirstVisiblePosition())).getChildAt(0).setSelected(false);
        }
        this.s = -1;
        this.f14464g = null;
    }

    public void y() {
        x();
    }

    public void z(List<d.a.n0.w.p.c> list, int i2) {
        if (list == null) {
            return;
        }
        int size = list.size();
        if (i2 < 0 || i2 >= size) {
            return;
        }
        t(list);
        v(i2);
        EmotionViewPagerAdapter emotionViewPagerAdapter = new EmotionViewPagerAdapter();
        this.f14463f = emotionViewPagerAdapter;
        this.f14462e.setAdapter(emotionViewPagerAdapter);
        this.f14462e.setCurrentItem(this.A, true);
        d dVar = this.z;
        if (dVar != null) {
            dVar.c(i2);
            this.x = i2;
        }
    }

    public EmotionTabContentView(Context context) {
        super(context);
        this.m = new Rect();
        this.s = -1;
        this.w = 0;
        this.x = -1;
        this.y = -1;
        this.B = new Point();
        this.G = new b(2921028);
        u(context);
    }
}
