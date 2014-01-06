package com.baidu.tieba;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends LinearLayout implements y {
    private Context a;
    private LayoutInflater b;
    private FrameLayout c;
    private FragmentTabWidget d;
    private int e;
    private v f;
    private android.support.v4.app.t g;
    private List<v> h;
    private ArrayList<v> i;
    private u j;

    public FragmentTabHost(Context context) {
        super(context);
        this.h = new ArrayList();
        this.i = new ArrayList<>();
        this.j = null;
        a(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = new ArrayList();
        this.i = new ArrayList<>();
        this.j = null;
        a(context);
    }

    private void a(Context context) {
        this.a = context;
        this.b = (LayoutInflater) this.a.getSystemService("layout_inflater");
        this.b.inflate(R.layout.fragment_tabhost, (ViewGroup) this, true);
        this.e = -1;
        this.f = null;
    }

    private void b() {
        this.c = (FrameLayout) findViewById(R.id.content);
        this.d = (FragmentTabWidget) findViewById(R.id.tabcontainer);
        this.d.setTabSelectionListener(this);
    }

    public void setup(android.support.v4.app.t tVar) {
        b();
        this.g = tVar;
    }

    public void a(v vVar) {
        a(vVar, -1);
    }

    public void a(v vVar, int i) {
        if (vVar.a == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (vVar.b == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.h.contains(vVar)) {
            this.d.addView(vVar.a, i);
            if (i == -1) {
                this.h.add(vVar);
            } else {
                this.h.add(i, vVar);
            }
            if (this.e != -1 && i <= this.e) {
                this.e++;
            }
        }
    }

    public void setTabChangeListener(u uVar) {
        this.j = uVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.h.size() && i != this.e) {
            android.support.v4.app.ae a = this.g.a();
            if (this.e != -1) {
                v vVar = this.h.get(this.e);
                if (vVar.b.q() != null) {
                    vVar.b.q().clearFocus();
                }
                a.b(vVar.b);
            }
            v vVar2 = this.h.get(i);
            if (this.i.contains(vVar2)) {
                a.c(vVar2.b);
            } else {
                a.a(this.c.getId(), vVar2.b);
                this.i.add(vVar2);
            }
            a.b();
            this.d.setCurrentTab(i);
            if (this.j != null) {
                this.j.a(i, this.e);
            }
            this.e = i;
            this.f = vVar2;
        }
    }

    @Override // com.baidu.tieba.y
    public void a(int i, boolean z) {
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.d.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.e;
    }

    public Fragment getCurrentFragment() {
        if (this.f != null) {
            return this.f.b;
        }
        return null;
    }

    public v a(int i) {
        if (i < 0 || i >= this.h.size()) {
            return null;
        }
        return this.h.get(i);
    }

    public boolean b(int i) {
        if (i < 0 || i >= this.h.size()) {
            return false;
        }
        return this.i.contains(this.h.get(i));
    }

    public void a() {
        android.support.v4.app.ae a = this.g.a();
        Iterator<v> it = this.i.iterator();
        while (it.hasNext()) {
            a.a(it.next().b);
        }
        a.b();
        this.i.clear();
        this.h.clear();
        this.f = null;
        this.e = -1;
        this.d.a();
    }

    public void c(int i) {
        if (i == 1) {
            for (v vVar : this.h) {
                vVar.a.a(i);
            }
            return;
        }
        for (v vVar2 : this.h) {
            vVar2.a.a(i);
        }
    }
}
