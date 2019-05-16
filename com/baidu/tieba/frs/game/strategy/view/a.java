package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes4.dex */
public abstract class a extends BaseAdapter {
    private boolean fAR = true;
    private f fAW;

    public abstract int bnu();

    public abstract int bnv();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object rO(int i);

    public abstract long rP(int i);

    public abstract void rQ(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (bnz()) {
            if (this.fAR) {
                return this.fAW.getArrowIndex() + 1;
            }
            if (this.fAW != null && this.fAW.bnx()) {
                return bnv() + 1;
            }
            return bnv();
        }
        return bnv();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (bnz()) {
            int rR = rR(i);
            if (rR >= 0) {
                return rO(rR);
            }
            return rO(i);
        }
        return rO(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (bnz()) {
            int rR = rR(i);
            if (rR >= 0) {
                return rP(rR);
            }
            return rP(i);
        }
        return rP(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(rR(i), view, viewGroup) : bS(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (bnz() && (arrowIndex = this.fAW.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return bnz() ? 2 : 1;
    }

    public void a(f fVar) {
        this.fAW = fVar;
    }

    private View bS(View view) {
        if (this.fAW != null) {
            if (view == null || view != this.fAW.getArrowView()) {
                view = this.fAW.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, bnu()));
                }
            }
            this.fAW.bR(view);
        }
        return view;
    }

    public int rR(int i) {
        int arrowIndex;
        if (this.fAW != null && this.fAW.bnx() && i >= (arrowIndex = this.fAW.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean bnz() {
        return this.fAW != null && this.fAW.bnx() && bnv() + (-1) > this.fAW.getArrowIndex();
    }

    public void kq(boolean z) {
        this.fAR = z;
    }
}
