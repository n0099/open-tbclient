package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes2.dex */
public abstract class a extends BaseAdapter {
    private e jyA;
    private boolean jyv = true;

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract int cHX();

    public abstract int cHY();

    public abstract Object zJ(int i);

    public abstract long zK(int i);

    public abstract void zL(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (cIc()) {
            if (this.jyv) {
                return this.jyA.getArrowIndex() + 1;
            }
            if (this.jyA != null && this.jyA.cIa()) {
                return cHY() + 1;
            }
            return cHY();
        }
        return cHY();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (cIc()) {
            int zM = zM(i);
            if (zM >= 0) {
                return zJ(zM);
            }
            return zJ(i);
        }
        return zJ(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (cIc()) {
            int zM = zM(i);
            if (zM >= 0) {
                return zK(zM);
            }
            return zK(i);
        }
        return zK(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(zM(i), view, viewGroup) : cY(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (cIc() && (arrowIndex = this.jyA.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return cIc() ? 2 : 1;
    }

    public void a(e eVar) {
        this.jyA = eVar;
    }

    private View cY(View view) {
        if (this.jyA != null) {
            if (view == null || view != this.jyA.getArrowView()) {
                view = this.jyA.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, cHX()));
                }
            }
            this.jyA.cX(view);
        }
        return view;
    }

    public int zM(int i) {
        int arrowIndex;
        if (this.jyA != null && this.jyA.cIa() && i >= (arrowIndex = this.jyA.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean cIc() {
        return this.jyA != null && this.jyA.cIa() && cHY() + (-1) > this.jyA.getArrowIndex();
    }

    public void rl(boolean z) {
        this.jyv = z;
    }
}
