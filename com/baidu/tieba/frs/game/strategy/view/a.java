package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes3.dex */
public abstract class a extends BaseAdapter {
    private boolean dOC = true;
    private g dOH;

    public abstract int axV();

    public abstract int axW();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object nt(int i);

    public abstract long nu(int i);

    public abstract void nv(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (aya()) {
            if (this.dOC) {
                return this.dOH.getArrowIndex() + 1;
            }
            if (this.dOH != null && this.dOH.axY()) {
                return axW() + 1;
            }
            return axW();
        }
        return axW();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (aya()) {
            int nw = nw(i);
            if (nw >= 0) {
                return nt(nw);
            }
            return nt(i);
        }
        return nt(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (aya()) {
            int nw = nw(i);
            if (nw >= 0) {
                return nu(nw);
            }
            return nu(i);
        }
        return nu(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(nw(i), view, viewGroup) : bP(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (aya() && (arrowIndex = this.dOH.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return aya() ? 2 : 1;
    }

    public void a(g gVar) {
        this.dOH = gVar;
    }

    private View bP(View view) {
        if (this.dOH != null) {
            if (view == null || view != this.dOH.getArrowView()) {
                view = this.dOH.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, axV()));
                }
            }
            this.dOH.bO(view);
        }
        return view;
    }

    public int nw(int i) {
        int arrowIndex;
        if (this.dOH != null && this.dOH.axY() && i >= (arrowIndex = this.dOH.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean aya() {
        return this.dOH != null && this.dOH.axY() && axW() + (-1) > this.dOH.getArrowIndex();
    }

    public void gh(boolean z) {
        this.dOC = z;
    }
}
