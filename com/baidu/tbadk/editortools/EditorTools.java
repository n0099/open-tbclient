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
import d.a.c.e.p.l;
import d.a.n0.w.f;
import d.a.n0.w.g;
import d.a.n0.w.h;
import d.a.n0.w.j;
import d.a.n0.w.m;
import d.a.n0.w.n;
import d.a.o0.d0.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class EditorTools extends LinearLayout {
    public List<Integer> A;

    /* renamed from: e  reason: collision with root package name */
    public EditorBar f12891e;

    /* renamed from: f  reason: collision with root package name */
    public EditorDesk f12892f;

    /* renamed from: g  reason: collision with root package name */
    public View f12893g;

    /* renamed from: h  reason: collision with root package name */
    public View f12894h;

    /* renamed from: i  reason: collision with root package name */
    public List<m> f12895i;
    public SparseArray<d.a.n0.w.b> j;
    public SparseArray<HashSet<d.a.n0.w.b>> k;
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
    public String v;
    public long w;
    public View.OnClickListener x;
    public View.OnClickListener y;
    public Runnable z;

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
            if (EditorTools.this.y != null) {
                EditorTools.this.y.onClick(view);
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
        this.x = new a();
        this.z = new b();
        this.A = new ArrayList();
        r(context);
    }

    public void A(d.a.n0.w.a aVar) {
        HashSet<Integer> hashSet;
        int i2;
        m n;
        n nVar;
        if (aVar == null) {
            return;
        }
        int i3 = aVar.f54625a;
        if (i3 == 2) {
            boolean z = false;
            h q = this.f12891e.q(aVar.f54626b);
            if (q == null) {
                q = this.f12892f.l(aVar.f54626b);
                z = true;
            }
            if (q == null) {
                Iterator<h> it = this.r.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    h next = it.next();
                    if (next.getToolId() == aVar.f54626b) {
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
        } else if (i3 == 5) {
            this.f12891e.n(null);
            this.f12892f.g();
        } else {
            int i4 = aVar.f54626b;
            if (i4 > 0) {
                d.a.n0.w.b bVar = this.j.get(i4);
                if (bVar != null) {
                    int i5 = aVar.f54625a;
                    if (i5 != 19 && i5 != 20 && (i2 = aVar.f54626b) != 27) {
                        this.f12891e.o(i2);
                    }
                    m n2 = n(aVar.f54626b);
                    if (n2 != null && n2.l == 5) {
                        q();
                        p();
                    } else {
                        this.f12892f.h(aVar.f54626b);
                    }
                    bVar.onAction(aVar);
                }
            } else if (i4 <= 0) {
                if (i4 < 0 && (hashSet = this.l.get(i3)) != null && !hashSet.isEmpty()) {
                    Iterator<Integer> it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        d.a.n0.w.b bVar2 = this.j.get(it2.next().intValue());
                        if (bVar2 != null) {
                            bVar2.onAction(aVar);
                        }
                    }
                }
                HashSet<d.a.n0.w.b> hashSet2 = this.k.get(aVar.f54625a);
                if (hashSet2 != null && !hashSet2.isEmpty()) {
                    Iterator<d.a.n0.w.b> it3 = hashSet2.iterator();
                    while (it3.hasNext()) {
                        it3.next().onAction(aVar);
                    }
                }
            }
            if (this.u.getClass().getSimpleName().equals("WriteActivity") && aVar.f54626b == 2) {
                DLauncher dLauncher = (DLauncher) this.f12892f.l(32);
                if (dLauncher != null) {
                    E(dLauncher);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921494));
            }
        }
    }

    public void B(int[] iArr, int i2, d.a.n0.w.b bVar) {
        int i3 = 0;
        if (i2 == 0) {
            if (iArr == null || iArr.length == 0) {
                return;
            }
            HashSet<d.a.n0.w.b> hashSet = this.k.get(iArr[0]);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                int length = iArr.length;
                while (i3 < length) {
                    this.k.put(iArr[i3], hashSet);
                    i3++;
                }
            }
            hashSet.add(bVar);
        } else if (i2 > 0) {
            this.j.put(i2, bVar);
            if (iArr == null || iArr.length <= 0) {
                return;
            }
            int length2 = iArr.length;
            while (i3 < length2) {
                int i4 = iArr[i3];
                HashSet<Integer> hashSet2 = this.l.get(i4);
                if (hashSet2 == null) {
                    hashSet2 = new HashSet<>();
                    this.l.put(i4, hashSet2);
                }
                hashSet2.add(Integer.valueOf(i2));
                i3++;
            }
        }
    }

    public void C(boolean z) {
        this.f12891e.y(z);
    }

    public void D(boolean z) {
        this.f12891e.z(z);
    }

    public void E(View view) {
        BaseActivity baseActivity = (BaseActivity) this.u;
        e eVar = new e(baseActivity.getPageContext(), view);
        eVar.g0(R.drawable.bg_tip_blue_down);
        eVar.O(48);
        eVar.U(true);
        eVar.L(2);
        eVar.h0(true);
        eVar.j0(l.g(baseActivity, R.dimen.ds32));
        eVar.d0(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds27));
        eVar.a0(baseActivity.getResources().getDimensionPixelSize(R.dimen.tbds41));
        eVar.N((int) 3000);
        eVar.n0(baseActivity.getString(R.string.write_vote_hint), "write_vote_hint_tip_key", true);
    }

    public void b(m mVar) {
        if (mVar == null) {
            return;
        }
        d(mVar);
        h i2 = i(mVar, 1);
        i2.hide();
        EditorBar editorBar = this.f12891e;
        if (editorBar != null) {
            editorBar.i(0, i2);
            this.f12891e.removeAllViews();
            this.f12891e.l();
        }
        invalidate();
    }

    public final void c() {
        View view = this.f12894h;
        if (view == null || view.getParent() != null) {
            View view2 = new View(getContext());
            this.f12894h = view2;
            SkinManager.setBackgroundResource(view2, R.color.transparent);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.f12894h.setLayoutParams(layoutParams);
            this.f12894h.setOnClickListener(new d());
        }
        addView(this.f12894h, 0);
    }

    public void d(m mVar) {
        if (mVar == null) {
            return;
        }
        this.f12895i.add(mVar);
    }

    public final void e() {
        View view = this.f12893g;
        if (view == null || view.getParent() != null) {
            View view2 = new View(getContext());
            this.f12893g = view2;
            d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(view2);
            d2.m(R.string.J_X02);
            d2.f(R.color.CAM_X0210);
            this.f12893g.setLayoutParams(new RelativeLayout.LayoutParams(-1, l.g(getContext(), R.dimen.L_X01)));
        }
        addView(this.f12893g);
    }

    public void f() {
        j jVar;
        n nVar;
        List<m> list = this.f12895i;
        if (list == null || list.size() == 0) {
            return;
        }
        g();
        LinkedList linkedList = new LinkedList();
        boolean z = false;
        for (m mVar : this.f12895i) {
            if (mVar.f54634d > 0) {
                linkedList.add(mVar);
            }
            n nVar2 = mVar.k;
            if (nVar2 != null) {
                nVar2.setToolId(mVar.f54633c);
                mVar.k.setEditorTools(this);
                int i2 = mVar.l;
                if (i2 == 6) {
                    this.f12892f.e(mVar.k);
                } else if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5) {
                    this.f12891e.k(mVar.k, mVar.l, !mVar.m);
                    if (mVar.l == 5 && n(1) == null) {
                        z = true;
                    }
                }
                B(mVar.n, mVar.f54633c, mVar.k);
            }
        }
        Collections.sort(linkedList, new c());
        if (linkedList.size() > this.m) {
            if (this.t) {
                jVar = new j(getContext(), true);
            } else {
                jVar = new j(getContext());
            }
            int i3 = this.p;
            if (i3 > 0 && (nVar = jVar.k) != null && (nVar instanceof CommonTabHost)) {
                ((CommonTabHost) nVar).setBackgroundColorId(i3);
            }
            if (!d.a.n0.r.d0.b.j().g("key_write_more_tool_point", false)) {
                jVar.o = true;
            } else {
                jVar.o = false;
            }
            d(jVar);
            jVar.k.setToolId(jVar.f54633c);
            jVar.k.setEditorTools(this);
            B(jVar.n, jVar.f54633c, jVar.k);
            this.f12892f.e(jVar.k);
            if (this.n) {
                linkedList.add(this.m, jVar);
            } else {
                linkedList.add(0, jVar);
            }
        }
        int i4 = this.m + 1;
        Iterator it = linkedList.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            m mVar2 = (m) it.next();
            if (i5 < i4) {
                this.f12891e.j(i(mVar2, 1));
            } else {
                this.f12892f.d(i(mVar2, 2));
            }
            i5++;
        }
        if (z) {
            f fVar = new f();
            d(fVar);
            h i6 = i(fVar, 1);
            i6.hide();
            this.f12891e.i(0, i6);
        }
        this.f12891e.l();
        this.f12892f.f();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.f12891e.setLayoutParams(layoutParams);
        this.f12892f.setLayoutParams(layoutParams2);
        this.f12892f.n();
        if (this.t) {
            this.f12891e.setPadding(0, 0, 0, 0);
        }
        q();
        removeAllViews();
        if (this.f12891e.getBarLauncherType() != 4) {
            e();
        }
        addView(this.f12891e);
        addView(this.f12892f);
        invalidate();
    }

    public final void g() {
        this.f12891e.p();
        this.f12892f.i();
    }

    public List<m> getAllTools() {
        return this.f12895i;
    }

    public List<Integer> getCollectTools() {
        return this.A;
    }

    public long getFid() {
        return this.w;
    }

    public String getTid() {
        return this.v;
    }

    public void h(List<Integer> list) {
        this.A.clear();
        this.A.addAll(list);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010044, this));
    }

    public final h i(m mVar, int i2) {
        h a2 = g.a(getContext(), mVar, i2);
        if (a2 instanceof View) {
            ((View) a2).setContentDescription(mVar.f54632b);
        }
        if (a2 instanceof BLauncher) {
            ((View) a2).setOnClickListener(this.x);
        }
        return a2;
    }

    public void j() {
        k(true);
    }

    public void k(boolean z) {
        for (m mVar : this.f12895i) {
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
            d.a.c.e.m.e.a().postDelayed(this.z, 200L);
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
                l.K(getContext(), view);
            }
        }
    }

    public h m(int i2) {
        h q = this.f12891e.q(i2);
        return q != null ? q : this.f12892f.l(i2);
    }

    public m n(int i2) {
        for (m mVar : this.f12895i) {
            if (mVar.f54633c == i2) {
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
        d.a.c.e.m.e.a().removeCallbacks(this.z);
        boolean z = false;
        if ((getContext() instanceof Activity) && (currentFocus = ((Activity) getContext()).getCurrentFocus()) != null) {
            z = true;
            l.x(getContext(), currentFocus);
        }
        if (z) {
            return;
        }
        m n = n(3);
        if (n != null && (n.k instanceof View)) {
            l.x(getContext(), (View) n.k);
        }
        m n2 = n(28);
        if (n2 == null || !(n2.k instanceof View)) {
            return;
        }
        l.x(getContext(), (View) n2.k);
    }

    public void q() {
        this.f12892f.n();
        this.f12891e.n(null);
    }

    public final void r(Context context) {
        this.u = context;
        this.f12895i = new LinkedList();
        this.j = new SparseArray<>();
        this.k = new SparseArray<>();
        this.l = new SparseArray<>();
        this.f12891e = new EditorBar(context, this);
        this.f12892f = new EditorDesk(context, this);
        this.r = new LinkedList<>();
        setOrientation(1);
    }

    public boolean s() {
        return this.s;
    }

    public void setActionListener(int i2, d.a.n0.w.b bVar) {
        B(new int[]{i2}, 0, bVar);
    }

    public void setBackgroundColorId(int i2) {
        this.o = i2;
        if (i2 != 0) {
            setBackgroundColor(getContext().getResources().getColor(i2));
        }
    }

    public void setBarBackgroundColorId(int i2) {
        this.f12891e.setBackgroundColorId(i2);
    }

    public void setBarLauncherEnabled(boolean z) {
        this.f12891e.setBarLauncherEnabled(z);
    }

    public void setBarLauncherType(int i2) {
        this.f12891e.setBarLauncherType(i2);
    }

    public void setBarMaxLauCount(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.m = i2;
    }

    public void setDeskBackgroundColorId(int i2) {
        this.f12892f.setBackgroundColorId(i2);
    }

    public void setDeskLauncherEnabled(boolean z) {
        this.f12892f.setDeskLauncherEnabled(z);
    }

    public void setFid(long j) {
        this.w = j;
    }

    public void setFrom(int i2) {
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

    public void setMoreDeskBgColorId(int i2) {
        this.p = i2;
    }

    public void setOnCancelClickListener(View.OnClickListener onClickListener) {
        this.y = onClickListener;
        c();
    }

    public void setTid(String str) {
        this.v = str;
    }

    public void setToolEnabled(boolean z, int i2) {
        if (this.f12891e.x(z, i2)) {
            return;
        }
        this.f12892f.t(z, i2);
    }

    public boolean t() {
        return this.t;
    }

    public boolean u() {
        return this.f12892f.q();
    }

    public boolean v() {
        return getVisibility() == 0;
    }

    public void w(int i2) {
        SkinManager.setBackgroundColor(this, this.o, i2);
        this.f12891e.v(i2);
        this.f12892f.r(i2);
        View view = this.f12893g;
        if (view != null) {
            d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(view);
            d2.m(R.string.J_X02);
            d2.f(R.color.CAM_X0210);
        }
    }

    public void x(View view) {
        if (view instanceof h) {
            h hVar = (h) view;
            int toolId = hVar.getToolId();
            m n = n(toolId);
            if (n.a()) {
                A(new d.a.n0.w.a(31, 0, Integer.valueOf(hVar.getToolId())));
                this.f12891e.n(n);
                if (hVar.getToolId() == 2 && !d.a.n0.r.d0.b.j().g("key_write_more_tool_point", false)) {
                    d.a.n0.r.d0.b.j().t("key_write_more_tool_point", true);
                    hVar.e();
                }
                if (hVar.getToolId() == 1) {
                    hVar.hide();
                    j();
                    A(new d.a.n0.w.a(1, 3, null));
                } else if (n.k == null) {
                    int[] iArr = n.n;
                    if (iArr == null || iArr.length <= 0) {
                        return;
                    }
                    A(new d.a.n0.w.a(iArr[0], -1, null));
                } else {
                    A(new d.a.n0.w.a(1, toolId, null));
                }
            }
        }
    }

    public void y() {
        this.f12891e.n(null);
    }

    public void z() {
        this.f12891e.w(this.x);
    }

    public void setActionListener(int[] iArr, d.a.n0.w.b bVar) {
        B(iArr, 0, bVar);
    }
}
