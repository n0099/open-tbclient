package com.baidu.tieba;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends LinearLayout implements z {

    /* renamed from: a  reason: collision with root package name */
    private Context f1007a;
    private LayoutInflater b;
    private FrameLayout c;
    private FragmentTabWidget d;
    private FrameLayout e;
    private int f;
    private x g;
    private android.support.v4.app.t h;
    private List<x> i;
    private ArrayList<x> j;

    public FragmentTabHost(Context context) {
        super(context);
        this.i = new ArrayList();
        this.j = new ArrayList<>();
        a(context);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new ArrayList();
        this.j = new ArrayList<>();
        a(context);
    }

    private void a(Context context) {
        this.f1007a = context;
        this.b = (LayoutInflater) this.f1007a.getSystemService("layout_inflater");
        this.b.inflate(R.layout.fragment_tabhost, (ViewGroup) this, true);
        this.f = -1;
        this.g = null;
    }

    private void b() {
        this.c = (FrameLayout) findViewById(R.id.content);
        this.e = (FrameLayout) findViewById(R.id.bottom_container);
        this.d = (FragmentTabWidget) findViewById(R.id.tabcontainer);
        this.d.setTabSelectionListener(this);
    }

    public void setup(android.support.v4.app.t tVar) {
        b();
        this.h = tVar;
    }

    public void a(x xVar) {
        a(xVar, -1);
    }

    public void a(x xVar, int i) {
        if (xVar.f2828a == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (xVar.b == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.i.contains(xVar)) {
            this.d.addView(xVar.f2828a, i);
            if (i == -1) {
                this.i.add(xVar);
            } else {
                this.i.add(i, xVar);
            }
            if (this.f != -1 && i <= this.f) {
                this.f++;
            }
        }
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.i.size() && i != this.f) {
            android.support.v4.app.ae a2 = this.h.a();
            if (this.f != -1) {
                x xVar = this.i.get(this.f);
                if (xVar.b.q() != null) {
                    xVar.b.q().clearFocus();
                }
                a2.b(xVar.b);
            }
            x xVar2 = this.i.get(i);
            if (this.j.contains(xVar2)) {
                a2.c(xVar2.b);
            } else {
                a2.a(this.c.getId(), xVar2.b);
                this.j.add(xVar2);
            }
            a2.b();
            this.d.setCurrentTab(i);
            this.f = i;
            this.g = xVar2;
        }
    }

    @Override // com.baidu.tieba.z
    public void a(int i, boolean z) {
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.d.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.f;
    }

    public Fragment getCurrentFragment() {
        if (this.g != null) {
            return this.g.b;
        }
        return null;
    }

    public x a(int i) {
        if (i < 0 || i >= this.i.size()) {
            return null;
        }
        return this.i.get(i);
    }

    public boolean b(int i) {
        if (i < 0 || i >= this.i.size()) {
            return false;
        }
        return this.j.contains(this.i.get(i));
    }

    public void a() {
        android.support.v4.app.ae a2 = this.h.a();
        Iterator<x> it = this.j.iterator();
        while (it.hasNext()) {
            a2.a(it.next().b);
        }
        a2.b();
        this.j.clear();
        this.i.clear();
        this.g = null;
        this.f = -1;
        this.d.a();
        while (this.e.getChildCount() > 1) {
            this.e.removeViewAt(this.e.getChildCount() - 1);
        }
    }

    public void a(View view) {
        this.e.addView(view);
    }

    public void c(int i) {
        if (i == 1) {
            for (x xVar : this.i) {
                xVar.f2828a.a(i);
            }
            return;
        }
        for (x xVar2 : this.i) {
            xVar2.f2828a.a(i);
        }
    }
}
