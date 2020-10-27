package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes22.dex */
public abstract class a extends BaseAdapter {
    private f iQD;
    private boolean iQy = true;

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract int cAd();

    public abstract int cAe();

    public abstract Object zu(int i);

    public abstract long zv(int i);

    public abstract void zw(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (cAi()) {
            if (this.iQy) {
                return this.iQD.getArrowIndex() + 1;
            }
            if (this.iQD != null && this.iQD.cAg()) {
                return cAe() + 1;
            }
            return cAe();
        }
        return cAe();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (cAi()) {
            int zx = zx(i);
            if (zx >= 0) {
                return zu(zx);
            }
            return zu(i);
        }
        return zu(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (cAi()) {
            int zx = zx(i);
            if (zx >= 0) {
                return zv(zx);
            }
            return zv(i);
        }
        return zv(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(zx(i), view, viewGroup) : cA(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (cAi() && (arrowIndex = this.iQD.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return cAi() ? 2 : 1;
    }

    public void a(f fVar) {
        this.iQD = fVar;
    }

    private View cA(View view) {
        if (this.iQD != null) {
            if (view == null || view != this.iQD.getArrowView()) {
                view = this.iQD.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, cAd()));
                }
            }
            this.iQD.cz(view);
        }
        return view;
    }

    public int zx(int i) {
        int arrowIndex;
        if (this.iQD != null && this.iQD.cAg() && i >= (arrowIndex = this.iQD.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean cAi() {
        return this.iQD != null && this.iQD.cAg() && cAe() + (-1) > this.iQD.getArrowIndex();
    }

    public void pU(boolean z) {
        this.iQy = z;
    }
}
