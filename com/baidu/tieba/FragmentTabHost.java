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
public class FragmentTabHost extends LinearLayout implements y {
    private Context a;
    private LayoutInflater b;
    private FrameLayout c;
    private FragmentTabWidget d;
    private FrameLayout e;
    private int f;
    private w g;
    private android.support.v4.app.t h;
    private List<w> i;
    private ArrayList<w> j;

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
        this.a = context;
        this.b = (LayoutInflater) this.a.getSystemService("layout_inflater");
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

    public void a(w wVar) {
        a(wVar, -1);
    }

    public void a(w wVar, int i) {
        if (wVar.a == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (wVar.b == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (!this.i.contains(wVar)) {
            this.d.addView(wVar.a, i);
            if (i == -1) {
                this.i.add(wVar);
            } else {
                this.i.add(i, wVar);
            }
            if (this.f != -1 && i <= this.f) {
                this.f++;
            }
        }
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.i.size() && i != this.f) {
            android.support.v4.app.ae a = this.h.a();
            if (this.f != -1) {
                w wVar = this.i.get(this.f);
                if (wVar.b.q() != null) {
                    wVar.b.q().clearFocus();
                }
                a.b(wVar.b);
            }
            w wVar2 = this.i.get(i);
            if (this.j.contains(wVar2)) {
                a.c(wVar2.b);
            } else {
                a.a(this.c.getId(), wVar2.b);
                this.j.add(wVar2);
            }
            a.b();
            this.d.setCurrentTab(i);
            this.f = i;
            this.g = wVar2;
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
        return this.f;
    }

    public Fragment getCurrentFragment() {
        if (this.g != null) {
            return this.g.b;
        }
        return null;
    }

    public w a(int i) {
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
        android.support.v4.app.ae a = this.h.a();
        Iterator<w> it = this.j.iterator();
        while (it.hasNext()) {
            a.a(it.next().b);
        }
        a.b();
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
            for (w wVar : this.i) {
                wVar.a.a(i);
            }
            return;
        }
        for (w wVar2 : this.i) {
            wVar2.a.a(i);
        }
    }
}
