package com.baidu.tbadk.editortools;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.w.f;
import d.b.h0.w.g;
import d.b.h0.w.h;
import d.b.h0.w.j;
import d.b.h0.w.m;
import d.b.h0.w.n;
import d.b.i0.b0.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class EditorTools extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public EditorBar f13844e;

    /* renamed from: f  reason: collision with root package name */
    public EditorDesk f13845f;

    /* renamed from: g  reason: collision with root package name */
    public View f13846g;

    /* renamed from: h  reason: collision with root package name */
    public View f13847h;
    public List<m> i;
    public SparseArray<d.b.h0.w.b> j;
    public SparseArray<HashSet<d.b.h0.w.b>> k;
    public SparseArray<HashSet<Integer>> l;
    public int m;
    public boolean n;
    public int o;
    public int p;
    public boolean q;
    public LinkedList<h> r;
    public boolean s;
    public boolean t;
    public Context u;
    public View.OnClickListener v;
    public View.OnClickListener w;
    public Runnable x;
    public List<Integer> y;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditorTools.this.x(view);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            EditorTools.this.l();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Comparator<m> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(m mVar, m mVar2) {
            return mVar.j - mVar2.j;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (EditorTools.this.w != null) {
                EditorTools.this.w.onClick(view);
            }
        }
    }

    public EditorTools(Context context) {
        super(context);
        this.m = 1;
        this.n = false;
        this.o = 0;
        this.p = 0;
        this.q = true;
        this.s = false;
        this.t = false;
        this.v = new a();
        this.x = new b();
        this.y = new ArrayList();
        r(context);
    }

    public void A(d.b.h0.w.a aVar) {
        HashSet<Integer> hashSet;
        int i;
        m n;
        n nVar;
        if (aVar == null) {
            return;
        }
        int i2 = aVar.f51524a;
        if (i2 == 2) {
            boolean z = false;
            h q = this.f13844e.q(aVar.f51525b);
            if (q == null) {
                q = this.f13845f.l(aVar.f51525b);
                z = true;
            }
            if (q == null) {
                Iterator<h> it = this.r.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    h next = it.next();
                    if (next.getToolId() == aVar.f51525b) {
                        q = next;
                        break;
                    }
                }
            }
            if (q != null) {
                q.onAction(aVar);
                if (!z || (n = n(2)) == null || (nVar = n.k) == null) {
                    return;
                }
                nVar.onAction(aVar);
            }
        } else if (i2 == 5) {
            this.f13844e.n(null);
            this.f13845f.g();
        } else {
            int i3 = aVar.f51525b;
            if (i3 > 0) {
                d.b.h0.w.b bVar = this.j.get(i3);
                if (bVar != null) {
                    int i4 = aVar.f51524a;
                    if (i4 != 19 && i4 != 20 && (i = aVar.f51525b) != 27) {
                        this.f13844e.o(i);
                    }
                    m n2 = n(aVar.f51525b);
                    if (n2 != null && n2.l == 5) {
                        q();
                        p();
                    } else {
                        this.f13845f.h(aVar.f51525b);
                    }
                    bVar.onAction(aVar);
                }
            } else if (i3 <= 0) {
                if (i3 < 0 && (hashSet = this.l.get(i2)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        d.b.h0.w.b bVar2 = this.j.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.onAction(aVar);
                        }
                    }
                }
                HashSet<d.b.h0.w.b> hashSet2 = this.k.get(aVar.f51524a);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<d.b.h0.w.b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().onAction(aVar);
                    }
                }
            }
            if (this.u.getClass().getSimpleName().equals("WriteActivity") && aVar.f51525b == 2) {
                DLauncher dLauncher = (DLauncher) this.f13845f.l(32);
                if (dLauncher != null) {
                    E(dLauncher);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921494));
            }
        }
    }

    public void B(int[] iArr, int i, d.b.h0.w.b bVar) {
        int i2 = 0;
        if (i == 0) {
            if (iArr == null || iArr.length == 0) {
                return;
            }
            HashSet<d.b.h0.w.b> hashSet = this.k.get(iArr[0]);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                int length = iArr.length;
                while (i2 < length) {
                    this.k.put(iArr[i2], hashSet);
                    i2++;
                }
            }
            hashSet.add(bVar);
        } else if (i > 0) {
            this.j.put(i, bVar);
            if (iArr == null || iArr.length <= 0) {
                return;
            }
            int length2 = iArr.length;
            while (i2 < length2) {
                int i3 = iArr[i2];
                HashSet<Integer> hashSet2 = this.l.get(i3);
                if (hashSet2 == null) {
                    hashSet2 = new HashSet<>();
                    this.l.put(i3, hashSet2);
                }
                hashSet2.add(Integer.valueOf(i));
                i2++;
            }
        }
    }

    public void C(boolean z) {
        this.f13844e.y(z);
    }

    public void D(boolean z) {
        this.f13844e.z(z);
    }

    public void E(View view) {
        BaseActivity baseActivity = (BaseActivity) this.u;
        e eVar = new e(baseActivity.getPageContext(), view);
        eVar.c0(R.drawable.bg_tip_blue_down);
        eVar.N(48);
        eVar.T(true);
        eVar.K(2);
        eVar.d0(true);
        eVar.f0(l.g(baseActivity, R.dimen.ds32));
        eVar.a0(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.Z(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.M((int) 3000);
        eVar.j0(baseActivity.getString(R.string.write_vote_hint), "write_vote_hint_tip_key", true);
    }

    public void b(m mVar) {
        if (mVar == null) {
            return;
        }
        d(mVar);
        h i = i(mVar, 1);
        i.hide();
        EditorBar editorBar = this.f13844e;
        if (editorBar != null) {
            editorBar.i(0, i);
            this.f13844e.removeAllViews();
            this.f13844e.l();
        }
        invalidate();
    }

    public final void c() {
        View view = this.f13847h;
        if (view == null || view.getParent() != null) {
            View view2 = new View(getContext());
            this.f13847h = view2;
            SkinManager.setBackgroundResource(view2, R.color.transparent);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.f13847h.setLayoutParams(layoutParams);
            this.f13847h.setOnClickListener(new d());
        }
        addView(this.f13847h, 0);
    }

    public void d(m mVar) {
        if (mVar == null) {
            return;
        }
        this.i.add(mVar);
    }

    public final void e() {
        View view = this.f13846g;
        if (view == null || view.getParent() != null) {
            View view2 = new View(getContext());
            this.f13846g = view2;
            d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(view2);
            a2.h(R.string.J_X02);
            a2.c(R.color.CAM_X0210);
            this.f13846g.setLayoutParams(new RelativeLayout.LayoutParams(-1, l.g(getContext(), R.dimen.L_X01)));
        }
        addView(this.f13846g);
    }

    public void f() {
        j jVar;
        n nVar;
        List<m> list = this.i;
        if (list == null || list.size() == 0) {
            return;
        }
        g();
        LinkedList linkedList = new LinkedList();
        boolean z = false;
        for (m mVar : this.i) {
            if (mVar.f51533d > 0) {
                linkedList.add(mVar);
            }
            n nVar2 = mVar.k;
            if (nVar2 != null) {
                nVar2.setToolId(mVar.f51532c);
                mVar.k.setEditorTools(this);
                int i = mVar.l;
                if (i == 6) {
                    this.f13845f.e(mVar.k);
                } else if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
                    this.f13844e.k(mVar.k, mVar.l, !mVar.m);
                    if (mVar.l == 5 && n(1) == null) {
                        z = true;
                    }
                }
                B(mVar.n, mVar.f51532c, mVar.k);
            }
        }
        Collections.sort(linkedList, new c());
        if (linkedList.size() > this.m) {
            if (this.t) {
                jVar = new j(getContext(), true);
            } else {
                jVar = new j(getContext());
            }
            int i2 = this.p;
            if (i2 > 0 && (nVar = jVar.k) != null && (nVar instanceof CommonTabHost)) {
                ((CommonTabHost) nVar).setBackgroundColorId(i2);
            }
            if (!d.b.h0.r.d0.b.i().g("key_write_more_tool_point", false)) {
                jVar.o = true;
            } else {
                jVar.o = false;
            }
            d(jVar);
            jVar.k.setToolId(jVar.f51532c);
            jVar.k.setEditorTools(this);
            B(jVar.n, jVar.f51532c, jVar.k);
            this.f13845f.e(jVar.k);
            if (this.n) {
                linkedList.add(this.m, jVar);
            } else {
                linkedList.add(0, jVar);
            }
        }
        int i3 = this.m + 1;
        Iterator it = linkedList.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            m mVar2 = (m) it.next();
            if (i4 < i3) {
                this.f13844e.j(i(mVar2, 1));
            } else {
                this.f13845f.d(i(mVar2, 2));
            }
            i4++;
        }
        if (z) {
            f fVar = new f();
            d(fVar);
            h i5 = i(fVar, 1);
            i5.hide();
            this.f13844e.i(0, i5);
        }
        this.f13844e.l();
        this.f13845f.f();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.f13844e.setLayoutParams(layoutParams);
        this.f13845f.setLayoutParams(layoutParams2);
        this.f13845f.n();
        if (this.t) {
            this.f13844e.setPadding(0, 0, 0, 0);
        }
        q();
        removeAllViews();
        if (this.f13844e.getBarLauncherType() != 4) {
            e();
        }
        addView(this.f13844e);
        addView(this.f13845f);
        invalidate();
    }

    public final void g() {
        this.f13844e.p();
        this.f13845f.i();
    }

    public List<m> getAllTools() {
        return this.i;
    }

    public List<Integer> getCollectTools() {
        return this.y;
    }

    public void h(List<Integer> list) {
        this.y.clear();
        this.y.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public final h i(m mVar, int i) {
        h a2 = g.a(getContext(), mVar, i);
        if (a2 instanceof View) {
            ((View) a2).setContentDescription(mVar.f51531b);
        }
        if (a2 instanceof BLauncher) {
            ((View) a2).setOnClickListener(this.v);
        }
        return a2;
    }

    public void j() {
        k(true);
    }

    public void k(boolean z) {
        for (m mVar : this.i) {
            if (mVar != null) {
                n nVar = mVar.k;
                if ((nVar instanceof View) && ((View) nVar).getVisibility() == 0 && !mVar.m) {
                    mVar.k.b();
                }
            }
        }
        if (this.q) {
            this.q = false;
            q();
        }
        if (!u() && z) {
            d.b.b.e.m.e.a().postDelayed(this.x, 200L);
        }
        setVisibility(0);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, Boolean.TRUE));
    }

    public void l() {
        m n = n(3);
        if (n != null) {
            n nVar = n.k;
            if (nVar instanceof View) {
                View view = (View) nVar;
                view.requestFocus();
                l.J(getContext(), view);
            }
        }
    }

    public h m(int i) {
        h q = this.f13844e.q(i);
        return q != null ? q : this.f13845f.l(i);
    }

    public m n(int i) {
        for (m mVar : this.i) {
            if (mVar.f51532c == i) {
                return mVar;
            }
        }
        return null;
    }

    public void o() {
        q();
        setVisibility(8);
        p();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010045, Boolean.FALSE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void p() {
        View currentFocus;
        d.b.b.e.m.e.a().removeCallbacks(this.x);
        boolean z = false;
        if ((getContext() instanceof Activity) && (currentFocus = ((Activity) getContext()).getCurrentFocus()) != null) {
            z = true;
            l.w(getContext(), currentFocus);
        }
        if (z) {
            return;
        }
        m n = n(3);
        if (n != null && (n.k instanceof View)) {
            l.w(getContext(), (View) n.k);
        }
        m n2 = n(28);
        if (n2 == null || !(n2.k instanceof View)) {
            return;
        }
        l.w(getContext(), (View) n2.k);
    }

    public void q() {
        this.f13845f.n();
        this.f13844e.n(null);
    }

    public final void r(Context context) {
        this.u = context;
        this.i = new LinkedList();
        this.j = new SparseArray<>();
        this.k = new SparseArray<>();
        this.l = new SparseArray<>();
        this.f13844e = new EditorBar(context, this);
        this.f13845f = new EditorDesk(context, this);
        this.r = new LinkedList<>();
        setOrientation(1);
    }

    public boolean s() {
        return this.s;
    }

    public void setActionListener(int i, d.b.h0.w.b bVar) {
        B(new int[]{i}, 0, bVar);
    }

    public void setBackgroundColorId(int i) {
        this.o = i;
        if (i != 0) {
            setBackgroundColor(getContext().getResources().getColor(i));
        }
    }

    public void setBarBackgroundColorId(int i) {
        this.f13844e.setBackgroundColorId(i);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.f13844e.setBarLauncherEnabled(z);
    }

    public void setBarLauncherType(int i) {
        this.f13844e.setBarLauncherType(i);
    }

    public void setBarMaxLauCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.m = i;
    }

    public void setDeskBackgroundColorId(int i) {
        this.f13845f.setBackgroundColorId(i);
    }

    public void setDeskLauncherEnabled(boolean z) {
        this.f13845f.setDeskLauncherEnabled(z);
    }

    public void setFrom(int i) {
    }

    public void setIsFromPb(boolean z) {
        this.t = z;
    }

    public void setIsIM(boolean z) {
        this.s = z;
    }

    public void setMoreButtonAtEnd(boolean z) {
        this.n = z;
    }

    public void setMoreDeskBgColorId(int i) {
        this.p = i;
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        this.w = onClickListener;
        c();
    }

    public void setToolEnabled(boolean z, int i) {
        if (this.f13844e.x(z, i)) {
            return;
        }
        this.f13845f.t(z, i);
    }

    public boolean t() {
        return this.t;
    }

    public boolean u() {
        return this.f13845f.q();
    }

    public boolean v() {
        return getVisibility() == 0;
    }

    public void w(int i) {
        SkinManager.setBackgroundColor(this, this.o, i);
        this.f13844e.v(i);
        this.f13845f.r(i);
        View view = this.f13846g;
        if (view != null) {
            d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(view);
            a2.h(R.string.J_X02);
            a2.c(R.color.CAM_X0210);
        }
    }

    public void x(View view) {
        if (view instanceof h) {
            h hVar = (h) view;
            int toolId = hVar.getToolId();
            m n = n(toolId);
            if (n.a()) {
                A(new d.b.h0.w.a(31, 0, Integer.valueOf(hVar.getToolId())));
                this.f13844e.n(n);
                if (hVar.getToolId() == 2 && !d.b.h0.r.d0.b.i().g("key_write_more_tool_point", false)) {
                    d.b.h0.r.d0.b.i().s("key_write_more_tool_point", true);
                    hVar.f();
                }
                if (hVar.getToolId() == 1) {
                    hVar.hide();
                    j();
                    A(new d.b.h0.w.a(1, 3, null));
                } else if (n.k == null) {
                    int[] iArr = n.n;
                    if (iArr == null || iArr.length <= 0) {
                        return;
                    }
                    A(new d.b.h0.w.a(iArr[0], -1, null));
                } else {
                    A(new d.b.h0.w.a(1, toolId, null));
                }
            }
        }
    }

    public void y() {
        this.f13844e.n(null);
    }

    public void z() {
        this.f13844e.w(this.v);
    }

    public void setActionListener(int[] iArr, d.b.h0.w.b bVar) {
        B(iArr, 0, bVar);
    }
}
