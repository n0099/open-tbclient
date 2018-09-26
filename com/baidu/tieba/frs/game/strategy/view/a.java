package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes3.dex */
public abstract class a extends BaseAdapter {
    private boolean dEe = true;
    private f dEj;

    public abstract int aAb();

    public abstract int aAc();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object lE(int i);

    public abstract long lF(int i);

    public abstract void lG(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (aAg()) {
            if (this.dEe) {
                return this.dEj.getArrowIndex() + 1;
            }
            if (this.dEj != null && this.dEj.aAe()) {
                return aAc() + 1;
            }
            return aAc();
        }
        return aAc();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (aAg()) {
            int lH = lH(i);
            if (lH >= 0) {
                return lE(lH);
            }
            return lE(i);
        }
        return lE(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (aAg()) {
            int lH = lH(i);
            if (lH >= 0) {
                return lF(lH);
            }
            return lF(i);
        }
        return lF(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(lH(i), view, viewGroup) : aN(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (aAg() && (arrowIndex = this.dEj.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return aAg() ? 2 : 1;
    }

    public void a(f fVar) {
        this.dEj = fVar;
    }

    private View aN(View view) {
        if (this.dEj != null) {
            if (view == null || view != this.dEj.getArrowView()) {
                view = this.dEj.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, aAb()));
                }
            }
            this.dEj.aM(view);
        }
        return view;
    }

    public int lH(int i) {
        int arrowIndex;
        if (this.dEj != null && this.dEj.aAe() && i >= (arrowIndex = this.dEj.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean aAg() {
        return this.dEj != null && this.dEj.aAe() && aAc() + (-1) > this.dEj.getArrowIndex();
    }

    public void gA(boolean z) {
        this.dEe = z;
    }
}
