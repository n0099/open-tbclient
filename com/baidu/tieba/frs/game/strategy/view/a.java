package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes16.dex */
public abstract class a extends BaseAdapter {
    private boolean iih = true;
    private f iim;

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract int cqm();

    public abstract int cqn();

    public abstract Object xW(int i);

    public abstract long xX(int i);

    public abstract void xY(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (cqr()) {
            if (this.iih) {
                return this.iim.getArrowIndex() + 1;
            }
            if (this.iim != null && this.iim.cqp()) {
                return cqn() + 1;
            }
            return cqn();
        }
        return cqn();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (cqr()) {
            int xZ = xZ(i);
            if (xZ >= 0) {
                return xW(xZ);
            }
            return xW(i);
        }
        return xW(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (cqr()) {
            int xZ = xZ(i);
            if (xZ >= 0) {
                return xX(xZ);
            }
            return xX(i);
        }
        return xX(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(xZ(i), view, viewGroup) : cj(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (cqr() && (arrowIndex = this.iim.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return cqr() ? 2 : 1;
    }

    public void a(f fVar) {
        this.iim = fVar;
    }

    private View cj(View view) {
        if (this.iim != null) {
            if (view == null || view != this.iim.getArrowView()) {
                view = this.iim.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, cqm()));
                }
            }
            this.iim.ci(view);
        }
        return view;
    }

    public int xZ(int i) {
        int arrowIndex;
        if (this.iim != null && this.iim.cqp() && i >= (arrowIndex = this.iim.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean cqr() {
        return this.iim != null && this.iim.cqp() && cqn() + (-1) > this.iim.getArrowIndex();
    }

    public void oR(boolean z) {
        this.iih = z;
    }
}
