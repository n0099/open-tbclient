package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes3.dex */
public abstract class a extends BaseAdapter {
    private boolean dXi = true;
    private f dXn;

    public abstract int aFN();

    public abstract int aFO();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object mX(int i);

    public abstract long mY(int i);

    public abstract void mZ(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (aFS()) {
            if (this.dXi) {
                return this.dXn.getArrowIndex() + 1;
            }
            if (this.dXn != null && this.dXn.aFQ()) {
                return aFO() + 1;
            }
            return aFO();
        }
        return aFO();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (aFS()) {
            int na = na(i);
            if (na >= 0) {
                return mX(na);
            }
            return mX(i);
        }
        return mX(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (aFS()) {
            int na = na(i);
            if (na >= 0) {
                return mY(na);
            }
            return mY(i);
        }
        return mY(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(na(i), view, viewGroup) : aS(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (aFS() && (arrowIndex = this.dXn.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return aFS() ? 2 : 1;
    }

    public void a(f fVar) {
        this.dXn = fVar;
    }

    private View aS(View view) {
        if (this.dXn != null) {
            if (view == null || view != this.dXn.getArrowView()) {
                view = this.dXn.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, aFN()));
                }
            }
            this.dXn.aR(view);
        }
        return view;
    }

    public int na(int i) {
        int arrowIndex;
        if (this.dXn != null && this.dXn.aFQ() && i >= (arrowIndex = this.dXn.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean aFS() {
        return this.dXn != null && this.dXn.aFQ() && aFO() + (-1) > this.dXn.getArrowIndex();
    }

    public void hj(boolean z) {
        this.dXi = z;
    }
}
