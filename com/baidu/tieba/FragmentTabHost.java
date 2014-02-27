package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.compatible.smartbarutil.SmartBarUtils;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FragmentTabHost extends LinearLayout implements r {
    private Context a;
    private LayoutInflater b;
    private FrameLayout c;
    private FragmentTabWidget d;
    private int e;
    private p f;
    private FragmentManager g;
    private List<p> h;
    private ArrayList<p> i;
    private o j;
    private boolean k;

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

    public void setup(FragmentManager fragmentManager) {
        this.c = (FrameLayout) findViewById(R.id.content);
        this.d = (FragmentTabWidget) findViewById(R.id.tabcontainer);
        this.d.setTabSelectionListener(this);
        this.k = TiebaApplication.g().bm();
        if (this.k) {
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
        }
        this.g = fragmentManager;
    }

    public final void a(p pVar) {
        if (pVar.b == null) {
            throw new IllegalArgumentException("you must create the tab indicator.");
        }
        if (pVar.c == null) {
            throw new IllegalArgumentException("you must create the tab content");
        }
        if (this.h.contains(pVar)) {
            return;
        }
        if (!this.k) {
            this.d.addView(pVar.b, -1);
        }
        this.h.add(pVar);
        if (this.e == -1 || -1 > this.e) {
            return;
        }
        this.e++;
    }

    public void setTabChangeListener(o oVar) {
        this.j = oVar;
    }

    public void setCurrentTab(int i) {
        if (i >= 0 && i < this.h.size() && i != this.e) {
            FragmentTransaction beginTransaction = this.g.beginTransaction();
            if (this.e != -1) {
                p pVar = this.h.get(this.e);
                if (pVar.c.getView() != null) {
                    pVar.c.getView().clearFocus();
                }
                beginTransaction.hide(pVar.c);
            }
            p pVar2 = this.h.get(i);
            if (this.i.contains(pVar2)) {
                beginTransaction.show(pVar2.c);
            } else {
                beginTransaction.add(this.c.getId(), pVar2.c);
                this.i.add(pVar2);
            }
            beginTransaction.commitAllowingStateLoss();
            this.g.executePendingTransactions();
            this.d.setCurrentTab(i);
            if (this.j != null) {
                o oVar = this.j;
                int i2 = this.e;
                oVar.a(i);
            }
            this.e = i;
            this.f = pVar2;
            if (this.k) {
                SmartBarUtils.invalidateOptionsMenu((Activity) getContext());
            }
        }
    }

    public void setCurrentTabByType(int i) {
        int i2;
        int size = this.h.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = -1;
                break;
            } else if (i == this.h.get(i3).a) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 != -1) {
            setCurrentTab(i2);
        } else if (this.e == -1) {
            setCurrentTab(0);
        }
    }

    @Override // com.baidu.tieba.r
    public final void a(int i) {
        setCurrentTab(i);
    }

    public void setTabWidgetBackgroundColor(int i) {
        this.d.setBackgroundColor(i);
    }

    public int getCurrentTabIndex() {
        return this.e;
    }

    public int getCurrentTabType() {
        if (this.e < 0 || this.e >= this.h.size()) {
            return -1;
        }
        return this.h.get(this.e).a;
    }

    public Fragment getCurrentFragment() {
        if (this.f != null) {
            return this.f.c;
        }
        return null;
    }

    public final p b(int i) {
        for (p pVar : this.h) {
            if (i == pVar.a) {
                return pVar;
            }
        }
        return null;
    }

    public final boolean c(int i) {
        for (p pVar : this.h) {
            if (1 == pVar.a) {
                return this.i.contains(pVar);
            }
        }
        return false;
    }

    public final void a() {
        FragmentTransaction beginTransaction = this.g.beginTransaction();
        Iterator<p> it = this.i.iterator();
        while (it.hasNext()) {
            beginTransaction.remove(it.next().c);
        }
        beginTransaction.commitAllowingStateLoss();
        this.g.executePendingTransactions();
        this.i.clear();
        this.h.clear();
        this.f = null;
        this.e = -1;
        if (!this.k) {
            this.d.a();
        }
    }

    public final void d(int i) {
        if (i == 1) {
            for (p pVar : this.h) {
                pVar.b.a(i);
            }
            return;
        }
        for (p pVar2 : this.h) {
            pVar2.b.a(i);
        }
    }
}
