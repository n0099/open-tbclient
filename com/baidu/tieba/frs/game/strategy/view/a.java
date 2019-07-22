package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes4.dex */
public abstract class a extends BaseAdapter {
    private boolean fFQ = true;
    private f fFV;

    public abstract int bpy();

    public abstract int bpz();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object sg(int i);

    public abstract long sh(int i);

    public abstract void si(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (bpD()) {
            if (this.fFQ) {
                return this.fFV.getArrowIndex() + 1;
            }
            if (this.fFV != null && this.fFV.bpB()) {
                return bpz() + 1;
            }
            return bpz();
        }
        return bpz();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (bpD()) {
            int sj = sj(i);
            if (sj >= 0) {
                return sg(sj);
            }
            return sg(i);
        }
        return sg(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (bpD()) {
            int sj = sj(i);
            if (sj >= 0) {
                return sh(sj);
            }
            return sh(i);
        }
        return sh(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(sj(i), view, viewGroup) : bU(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (bpD() && (arrowIndex = this.fFV.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return bpD() ? 2 : 1;
    }

    public void a(f fVar) {
        this.fFV = fVar;
    }

    private View bU(View view) {
        if (this.fFV != null) {
            if (view == null || view != this.fFV.getArrowView()) {
                view = this.fFV.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, bpy()));
                }
            }
            this.fFV.bT(view);
        }
        return view;
    }

    public int sj(int i) {
        int arrowIndex;
        if (this.fFV != null && this.fFV.bpB() && i >= (arrowIndex = this.fFV.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean bpD() {
        return this.fFV != null && this.fFV.bpB() && bpz() + (-1) > this.fFV.getArrowIndex();
    }

    public void kA(boolean z) {
        this.fFQ = z;
    }
}
