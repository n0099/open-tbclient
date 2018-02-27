package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes3.dex */
public abstract class a extends BaseAdapter {
    private g dOC;
    private boolean dOx = true;

    public abstract int axT();

    public abstract int axU();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object nt(int i);

    public abstract long nu(int i);

    public abstract void nv(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (axY()) {
            if (this.dOx) {
                return this.dOC.getArrowIndex() + 1;
            }
            if (this.dOC != null && this.dOC.axW()) {
                return axU() + 1;
            }
            return axU();
        }
        return axU();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (axY()) {
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
        if (axY()) {
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
        return (axY() && (arrowIndex = this.dOC.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return axY() ? 2 : 1;
    }

    public void a(g gVar) {
        this.dOC = gVar;
    }

    private View bP(View view) {
        if (this.dOC != null) {
            if (view == null || view != this.dOC.getArrowView()) {
                view = this.dOC.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, axT()));
                }
            }
            this.dOC.bO(view);
        }
        return view;
    }

    public int nw(int i) {
        int arrowIndex;
        if (this.dOC != null && this.dOC.axW() && i >= (arrowIndex = this.dOC.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean axY() {
        return this.dOC != null && this.dOC.axW() && axU() + (-1) > this.dOC.getArrowIndex();
    }

    public void gg(boolean z) {
        this.dOx = z;
    }
}
