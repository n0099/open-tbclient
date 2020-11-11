package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes22.dex */
public abstract class a extends BaseAdapter {
    private f iWA;
    private boolean iWv = true;

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract int cCE();

    public abstract int cCF();

    public abstract Object zH(int i);

    public abstract long zI(int i);

    public abstract void zJ(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (cCJ()) {
            if (this.iWv) {
                return this.iWA.getArrowIndex() + 1;
            }
            if (this.iWA != null && this.iWA.cCH()) {
                return cCF() + 1;
            }
            return cCF();
        }
        return cCF();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (cCJ()) {
            int zK = zK(i);
            if (zK >= 0) {
                return zH(zK);
            }
            return zH(i);
        }
        return zH(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (cCJ()) {
            int zK = zK(i);
            if (zK >= 0) {
                return zI(zK);
            }
            return zI(i);
        }
        return zI(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(zK(i), view, viewGroup) : cF(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (cCJ() && (arrowIndex = this.iWA.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return cCJ() ? 2 : 1;
    }

    public void a(f fVar) {
        this.iWA = fVar;
    }

    private View cF(View view) {
        if (this.iWA != null) {
            if (view == null || view != this.iWA.getArrowView()) {
                view = this.iWA.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, cCE()));
                }
            }
            this.iWA.cE(view);
        }
        return view;
    }

    public int zK(int i) {
        int arrowIndex;
        if (this.iWA != null && this.iWA.cCH() && i >= (arrowIndex = this.iWA.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean cCJ() {
        return this.iWA != null && this.iWA.cCH() && cCF() + (-1) > this.iWA.getArrowIndex();
    }

    public void qd(boolean z) {
        this.iWv = z;
    }
}
