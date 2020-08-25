package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes16.dex */
public abstract class a extends BaseAdapter {
    private boolean iib = true;
    private f iig;

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract int cql();

    public abstract int cqm();

    public abstract Object xW(int i);

    public abstract long xX(int i);

    public abstract void xY(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (cqq()) {
            if (this.iib) {
                return this.iig.getArrowIndex() + 1;
            }
            if (this.iig != null && this.iig.cqo()) {
                return cqm() + 1;
            }
            return cqm();
        }
        return cqm();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (cqq()) {
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
        if (cqq()) {
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
        return (cqq() && (arrowIndex = this.iig.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return cqq() ? 2 : 1;
    }

    public void a(f fVar) {
        this.iig = fVar;
    }

    private View cj(View view) {
        if (this.iig != null) {
            if (view == null || view != this.iig.getArrowView()) {
                view = this.iig.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, cql()));
                }
            }
            this.iig.ci(view);
        }
        return view;
    }

    public int xZ(int i) {
        int arrowIndex;
        if (this.iig != null && this.iig.cqo() && i >= (arrowIndex = this.iig.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean cqq() {
        return this.iig != null && this.iig.cqo() && cqm() + (-1) > this.iig.getArrowIndex();
    }

    public void oP(boolean z) {
        this.iib = z;
    }
}
