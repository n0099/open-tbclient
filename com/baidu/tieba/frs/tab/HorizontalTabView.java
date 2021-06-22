package com.baidu.tieba.frs.tab;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.n0.r.s.b;
import d.a.o0.r0.e1;
import d.a.o0.r0.f1;
import d.a.o0.r0.k2.e;
import d.a.o0.r0.p0;
import d.a.o0.r0.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class HorizontalTabView extends MyHorizontalScrollView implements d.a.o0.r0.k2.b {

    /* renamed from: e  reason: collision with root package name */
    public int f15847e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f15848f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.o0.r0.k2.e f15849g;

    /* renamed from: h  reason: collision with root package name */
    public List<d.a.o0.r0.k2.d> f15850h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.o0.r0.k2.d> f15851i;
    public TabItemView j;
    public d.a.o0.r0.k2.b k;
    public final Paint l;
    public final int m;
    public final int n;
    public int o;
    public boolean p;
    public TbPageContext q;
    public boolean r;
    public int s;
    public g t;
    public h u;
    public e.InterfaceC1564e v;
    public e.d w;
    public p0 x;
    public View.OnClickListener y;
    public i z;

    /* loaded from: classes4.dex */
    public class a implements e.InterfaceC1564e {
        public a() {
        }

        @Override // d.a.o0.r0.k2.e.InterfaceC1564e
        public void a(int i2) {
            if (HorizontalTabView.this.j != null && HorizontalTabView.this.x != null && HorizontalTabView.this.x != null) {
                HorizontalTabView.this.x.q(HorizontalTabView.this.j.getTabId(), i2, null);
            }
            if (HorizontalTabView.this.k != null) {
                HorizontalTabView.this.k.b(i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements e.d {
        public b() {
        }

        @Override // d.a.o0.r0.k2.e.d
        public void a(TabItemView tabItemView) {
            HorizontalTabView.this.i(tabItemView, false);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HorizontalTabView.this.r) {
                if ((view instanceof TabItemView) && ((TabItemView) view).getTabId() == 1) {
                    if (HorizontalTabView.this.t != null) {
                        HorizontalTabView.this.t.a(HorizontalTabView.this.k(1));
                    }
                    HorizontalTabView.this.q();
                    return;
                }
                return;
            }
            boolean z = view instanceof TabItemView;
            if (z) {
                HorizontalTabView.this.i((TabItemView) view, false);
            }
            if (HorizontalTabView.this.k != null) {
                if (z) {
                    TabItemView tabItemView = (TabItemView) view;
                    if (HorizontalTabView.o(tabItemView.getTabId())) {
                        HorizontalTabView.this.k.a(tabItemView.getTabId());
                        return;
                    }
                }
                if (HorizontalTabView.this.j != null) {
                    HorizontalTabView.this.k.a(HorizontalTabView.this.j.getTabId());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f1 f15855a;

        public d(f1 f1Var) {
            this.f15855a = f1Var;
        }

        @Override // d.a.n0.r.s.b.c
        public void a(d.a.n0.r.s.b bVar, int i2, View view) {
            if (this.f15855a.f62372b.size() <= i2 || this.f15855a.f62372b.get(i2) == null) {
                return;
            }
            bVar.e();
            HorizontalTabView horizontalTabView = HorizontalTabView.this;
            horizontalTabView.h(horizontalTabView.k(this.f15855a.f62372b.get(i2).f62265b));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f15857e;

        public e(int i2) {
            this.f15857e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HorizontalTabView.this.scrollBy(0 - this.f15857e, 0);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HorizontalTabView horizontalTabView = HorizontalTabView.this;
            horizontalTabView.scrollBy(horizontalTabView.getContext().getResources().getDimensionPixelSize(R.dimen.ds160), 0);
        }
    }

    /* loaded from: classes4.dex */
    public interface g {
        void a(d.a.o0.r0.k2.d dVar);
    }

    /* loaded from: classes4.dex */
    public interface h {
        void a(d.a.o0.r0.k2.d dVar);
    }

    /* loaded from: classes4.dex */
    public interface i {
        boolean a(int i2);

        void b(int i2);
    }

    public HorizontalTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15847e = 0;
        this.j = null;
        this.k = null;
        this.l = new Paint();
        this.m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds6);
        this.n = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1);
        this.o = 0;
        this.p = true;
        this.s = 0;
        this.v = new a();
        this.w = new b();
        this.y = new c();
        LinearLayout linearLayout = new LinearLayout(context);
        this.f15848f = linearLayout;
        linearLayout.setOrientation(0);
        this.f15848f.setGravity(16);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.ds88));
        this.f15849g = new d.a.o0.r0.k2.e(context, this.v, this.w);
        m(layoutParams);
    }

    private int getBottomLineMargin() {
        TabItemView tabItemView = this.j;
        if (tabItemView == null || this.f15847e == 0) {
            return 0;
        }
        return ((tabItemView.getMeasuredWidth() - this.f15847e) - this.j.getDrawableWidth()) / 2;
    }

    public static boolean o(int i2) {
        return i2 > 200 && i2 <= 300;
    }

    @Override // d.a.o0.r0.k2.b
    public void a(int i2) {
        h(k(i2));
    }

    @Override // d.a.o0.r0.k2.b
    public void b(int i2) {
        p0 p0Var;
        TabItemView tabItemView = this.j;
        if (tabItemView == null || (p0Var = this.x) == null) {
            return;
        }
        p0Var.q(tabItemView.getTabId(), i2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.j != null) {
            this.l.setColor(SkinManager.getColor(R.color.CAM_X0204));
            if (this.p) {
                canvas.drawRect(this.f15848f.getLeft(), getMeasuredHeight() - this.n, this.f15848f.getRight() > getRight() ? this.f15848f.getRight() : getRight(), getMeasuredHeight(), this.l);
            }
            if (!this.r) {
                int i2 = this.s;
                if (i2 == 0) {
                    this.l.setColor(SkinManager.getSkinColor(null, R.color.CAM_X0302));
                } else {
                    this.l.setColor(SkinManager.getSkinColor(null, i2));
                }
                canvas.drawRect(this.j.getLeft() + getBottomLineMargin(), getMeasuredHeight() - this.m, (this.j.getRight() - getBottomLineMargin()) - this.j.getDrawableWidth(), getMeasuredHeight(), this.l);
            }
        }
        if (this.r) {
            this.l.setAntiAlias(true);
            this.l.setColor(SkinManager.getSkinColor(null, R.color.CAM_X0105));
            int g2 = l.g(getContext(), R.dimen.ds96);
            TabItemView tabItemView = this.j;
            if (tabItemView != null) {
                g2 = tabItemView.getRight() - this.j.getDrawableWidth();
            }
            canvas.drawRoundRect(new RectF(l.g(getContext(), R.dimen.tbds44), l.g(getContext(), R.dimen.tbds98), g2, l.g(getContext(), R.dimen.tbds104)), l.g(getContext(), R.dimen.tbds6), l.g(getContext(), R.dimen.tbds6), this.l);
        }
    }

    public i getmShowMenuCallBack() {
        return this.z;
    }

    public void h(d.a.o0.r0.k2.d dVar) {
        boolean z;
        if (dVar == null) {
            return;
        }
        h hVar = this.u;
        if (hVar != null) {
            hVar.a(dVar);
        }
        if (dVar.f62626b == 49) {
            TiebaStatic.log("c11841");
        }
        if (o(dVar.f62626b)) {
            if (this.x == null || TextUtils.isEmpty(dVar.f62628d)) {
                return;
            }
            z0 z0Var = new z0();
            String str = dVar.f62628d;
            this.x.q(dVar.f62626b, -1, z0Var);
            return;
        }
        int i2 = dVar.f62626b;
        z0 z0Var2 = null;
        if (i2 == 301) {
            p0 p0Var = this.x;
            if (p0Var != null) {
                p0Var.q(i2, -1, null);
                return;
            }
            return;
        }
        if (i2 != 49 || this.x == null) {
            z = true;
        } else {
            z0 z0Var3 = new z0();
            String str2 = dVar.f62628d;
            String str3 = dVar.f62625a;
            this.x.q(dVar.f62626b, 0, z0Var3);
            if (z0Var3.f63688d) {
                return;
            }
            z = false;
        }
        for (int i3 = 0; i3 < this.f15848f.getChildCount(); i3++) {
            View childAt = this.f15848f.getChildAt(i3);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView = (TabItemView) childAt;
                if (tabItemView.getTabId() == 1) {
                    tabItemView.setText(dVar.f62625a);
                }
            }
        }
        if (!TextUtils.isEmpty(dVar.f62628d)) {
            z0Var2 = new z0();
            String str4 = dVar.f62628d;
            String str5 = dVar.f62625a;
        }
        p0 p0Var2 = this.x;
        if (p0Var2 == null || !z) {
            return;
        }
        p0Var2.q(dVar.f62626b, 0, z0Var2);
    }

    public void i(TabItemView tabItemView, boolean z) {
        p0 p0Var;
        List<e1> list;
        if (tabItemView == null) {
            return;
        }
        if (tabItemView.getTabId() == 49) {
            TiebaStatic.log("c11841");
        }
        if (o(tabItemView.getTabId())) {
            if (this.x == null || TextUtils.isEmpty(tabItemView.getUrl())) {
                return;
            }
            z0 z0Var = new z0();
            tabItemView.getUrl();
            this.x.q(tabItemView.getTabId(), -1, z0Var);
            return;
        }
        z0 z0Var2 = null;
        if (tabItemView.getTabId() == 301) {
            p0 p0Var2 = this.x;
            if (p0Var2 != null) {
                p0Var2.q(tabItemView.getTabId(), -1, null);
                return;
            }
            return;
        }
        this.j = tabItemView;
        int[] iArr = new int[2];
        tabItemView.getLocationOnScreen(iArr);
        int i2 = 0;
        int k = l.k(getContext()) - iArr[0];
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds160);
        if (iArr[0] < 0) {
            post(new e(dimensionPixelSize));
        } else if (k < dimensionPixelSize) {
            post(new f());
        }
        for (int i3 = 0; i3 < this.f15848f.getChildCount(); i3++) {
            View childAt = this.f15848f.getChildAt(i3);
            if (childAt instanceof TabItemView) {
                TabItemView tabItemView2 = (TabItemView) childAt;
                if (tabItemView2.getTabId() != this.j.getTabId() && !o(tabItemView2.getTabId())) {
                    tabItemView2.setState(TabItemView.f15860i);
                }
            }
        }
        if (this.j.getState() != TabItemView.f15860i && this.j.getState() != TabItemView.k) {
            if (l(this.j.getTabId()) && !z) {
                i iVar = this.z;
                if (iVar != null && !iVar.a(this.j.getTabId())) {
                    return;
                }
                this.j.setState(TabItemView.k);
                TabItemView tabItemView3 = this.j;
                this.f15849g.f((Activity) getContext(), this, tabItemView3, j(tabItemView3.getTabId()).f62627c);
            }
        } else {
            this.f15849g.c();
            boolean z2 = this.j.getState() == TabItemView.f15860i;
            this.j.setState(TabItemView.j);
            d.a.o0.r0.k2.d j = j(this.j.getTabId());
            if (j == null) {
                return;
            }
            if (!TextUtils.isEmpty(j.f62628d)) {
                z0Var2 = new z0();
                String str = j.f62628d;
                String str2 = j.f62625a;
            }
            f1 f1Var = j.f62627c;
            if (f1Var != null && (list = f1Var.f62372b) != null && list.size() > 0) {
                for (e1 e1Var : j.f62627c.f62372b) {
                    if (e1Var != null && e1Var.f62266c) {
                        i2 = e1Var.f62265b;
                    }
                }
            }
            if (z2 && (p0Var = this.x) != null) {
                p0Var.q(this.j.getTabId(), i2, z0Var2);
            }
        }
        invalidate();
    }

    public final d.a.o0.r0.k2.d j(int i2) {
        List<d.a.o0.r0.k2.d> list;
        if (i2 >= 0 && (list = this.f15851i) != null && list.size() != 0) {
            for (d.a.o0.r0.k2.d dVar : this.f15851i) {
                if (dVar != null && dVar.f62626b == i2) {
                    return dVar;
                }
            }
        }
        return null;
    }

    public d.a.o0.r0.k2.d k(int i2) {
        if (ListUtils.isEmpty(this.f15851i)) {
            return null;
        }
        for (d.a.o0.r0.k2.d dVar : this.f15851i) {
            if (dVar != null && dVar.f62626b == i2) {
                return dVar;
            }
        }
        return null;
    }

    public final boolean l(int i2) {
        f1 f1Var;
        List<e1> list;
        d.a.o0.r0.k2.d j = j(i2);
        return (j == null || (f1Var = j.f62627c) == null || (list = f1Var.f62372b) == null || list.size() <= 0) ? false : true;
    }

    @SuppressLint({"ResourceAsColor"})
    public final void m(AbsListView.LayoutParams layoutParams) {
        addView(this.f15848f, layoutParams);
        setLayoutParams(layoutParams);
        setHorizontalScrollBarEnabled(false);
        SkinManager.setBackgroundColor(this, R.color.transparent);
        setDescendantFocusability(262144);
    }

    public final boolean n(List<d.a.o0.r0.k2.d> list) {
        f1 f1Var;
        int size;
        if (list == null) {
            return false;
        }
        d.a.o0.r0.k2.d j = j(1);
        d.a.o0.r0.k2.d dVar = null;
        Iterator<d.a.o0.r0.k2.d> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            d.a.o0.r0.k2.d next = it.next();
            if (next != null && next.f62626b == 1) {
                dVar = next;
                break;
            }
        }
        if (j == null || dVar == null || (j.f62627c == null && dVar.f62627c == null)) {
            return false;
        }
        if ((j.f62627c != null || dVar.f62627c == null) && (dVar.f62627c != null || j.f62627c == null)) {
            f1 f1Var2 = j.f62627c;
            if (f1Var2 == null || (f1Var = dVar.f62627c) == null || (f1Var2.f62372b == null && f1Var.f62372b == null)) {
                return false;
            }
            if ((j.f62627c.f62372b != null || dVar.f62627c.f62372b == null) && ((dVar.f62627c.f62372b != null || j.f62627c.f62372b == null) && (size = j.f62627c.f62372b.size()) == dVar.f62627c.f62372b.size())) {
                for (int i2 = 0; i2 < size; i2++) {
                    e1 e1Var = dVar.f62627c.f62372b.get(i2);
                    e1 e1Var2 = j.f62627c.f62372b.get(i2);
                    if (e1Var.f62265b != e1Var2.f62265b || !e1Var.f62264a.equals(e1Var2.f62264a)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public final void p(List<d.a.o0.r0.k2.d> list, int i2, int i3, boolean z) {
        LinearLayout.LayoutParams layoutParams;
        if (this.o > 0 && list.size() == this.o) {
            layoutParams = new LinearLayout.LayoutParams(l.k(getContext()) / this.o, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ds15);
            layoutParams.leftMargin = dimensionPixelSize;
            layoutParams.rightMargin = dimensionPixelSize;
        }
        if (list != null && list.size() != 0) {
            setVisibility(0);
            if (this.f15850h == null || n(list)) {
                this.f15850h = list;
                this.f15848f.removeAllViews();
                for (int i4 = 0; i4 < list.size(); i4++) {
                    d.a.o0.r0.k2.d dVar = list.get(i4);
                    if (dVar != null) {
                        TabItemView tabItemView = new TabItemView(getContext(), dVar, i3, this.r);
                        int i5 = this.s;
                        if (i5 != 0) {
                            tabItemView.setSelectItemColorResId(i5);
                        }
                        tabItemView.setOnClickListener(this.y);
                        if (o(dVar.f62626b)) {
                            SkinManager.setViewTextColor(tabItemView, R.color.CAM_X0105);
                        }
                        if (i4 == 0) {
                            layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.tbds44);
                        }
                        this.f15848f.addView(tabItemView, layoutParams);
                        if (dVar.f62626b == i2) {
                            this.j = tabItemView;
                            tabItemView.setState(TabItemView.j);
                        }
                    }
                }
                return;
            }
            return;
        }
        this.f15850h = null;
        d.a.o0.r0.k2.d dVar2 = new d.a.o0.r0.k2.d();
        dVar2.f62626b = 1;
        dVar2.f62625a = getContext().getResources().getString(R.string.chosen_pb_title);
        this.f15848f.removeAllViews();
        TabItemView tabItemView2 = new TabItemView(getContext(), dVar2, i3, this.r);
        int i6 = this.s;
        if (i6 != 0) {
            tabItemView2.setSelectItemColorResId(i6);
        }
        tabItemView2.setOnClickListener(this.y);
        layoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.ds32);
        this.f15848f.addView(tabItemView2, layoutParams);
        this.j = tabItemView2;
        tabItemView2.setState(TabItemView.j);
    }

    public void q() {
        f1 f1Var;
        List<e1> list;
        if (this.q != null) {
            ArrayList arrayList = new ArrayList();
            List<d.a.o0.r0.k2.d> list2 = this.f15850h;
            if (list2 == null || list2.size() <= 0 || this.f15850h.get(0) == null || (f1Var = this.f15850h.get(0).f62627c) == null || (list = f1Var.f62372b) == null) {
                return;
            }
            for (e1 e1Var : list) {
                if (e1Var != null) {
                    arrayList.add(e1Var.f62264a);
                }
            }
            d.a.n0.r.s.b bVar = new d.a.n0.r.s.b(this.q.getPageActivity());
            bVar.i(arrayList, new d(f1Var));
            bVar.c(this.q);
            bVar.m();
        }
    }

    public void setAutoFillTabCount(int i2) {
        this.o = i2;
    }

    public void setData(List<d.a.o0.r0.k2.d> list, int i2, int i3) {
        d.a.o0.r0.k2.d dVar;
        List<e1> list2;
        if (this.r) {
            ArrayList arrayList = new ArrayList();
            this.f15851i = arrayList;
            arrayList.addAll(list);
            if (list != null && list.size() > 0 && (dVar = list.get(0)) != null && dVar.f62626b == 1) {
                f1 f1Var = dVar.f62627c;
                if (f1Var != null && (list2 = f1Var.f62372b) != null) {
                    list2.clear();
                } else {
                    f1Var = new f1();
                    f1Var.f62372b = new ArrayList();
                }
                if (ListUtils.getCount(list) > 1) {
                    e1 e1Var = new e1();
                    e1Var.f62265b = 1;
                    e1Var.f62264a = getContext().getString(R.string.chosen_pb_title);
                    f1Var.f62372b.add(e1Var);
                    for (d.a.o0.r0.k2.d dVar2 : list) {
                        if (dVar2 != null && dVar2.f62626b != 1) {
                            e1 e1Var2 = new e1();
                            e1Var2.f62265b = dVar2.f62626b;
                            e1Var2.f62264a = dVar2.f62625a;
                            f1Var.f62372b.add(e1Var2);
                        }
                    }
                    dVar.f62627c = f1Var;
                }
                list.clear();
                list.add(dVar);
            }
        } else {
            this.f15851i = list;
        }
        p(list, i2, i3, false);
    }

    public void setDataLoadInterface(p0 p0Var) {
        this.x = p0Var;
    }

    public void setFakeTab(d.a.o0.r0.k2.b bVar) {
        this.k = bVar;
    }

    public void setForNewFrame(boolean z) {
        this.r = z;
    }

    public void setNeedBottomLine(boolean z) {
        this.p = z;
        invalidate();
    }

    public void setOnTabItemClickListener(g gVar) {
        this.t = gVar;
    }

    public void setOnTabItemSelectListener(h hVar) {
        this.u = hVar;
    }

    public void setSelectedItemColorResourceId(int i2) {
        this.s = i2;
    }

    public void setTabBackgroudColor(int i2) {
    }

    public void setmShowMenuCallBack(i iVar) {
        this.z = iVar;
    }
}
