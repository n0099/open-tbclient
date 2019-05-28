package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes4.dex */
public abstract class a extends BaseAdapter {
    private boolean fAS = true;
    private f fAX;

    public abstract int bnx();

    public abstract int bny();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object rO(int i);

    public abstract long rP(int i);

    public abstract void rQ(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (bnC()) {
            if (this.fAS) {
                return this.fAX.getArrowIndex() + 1;
            }
            if (this.fAX != null && this.fAX.bnA()) {
                return bny() + 1;
            }
            return bny();
        }
        return bny();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (bnC()) {
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
        if (bnC()) {
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
        return (bnC() && (arrowIndex = this.fAX.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return bnC() ? 2 : 1;
    }

    public void a(f fVar) {
        this.fAX = fVar;
    }

    private View bS(View view) {
        if (this.fAX != null) {
            if (view == null || view != this.fAX.getArrowView()) {
                view = this.fAX.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, bnx()));
                }
            }
            this.fAX.bR(view);
        }
        return view;
    }

    public int rR(int i) {
        int arrowIndex;
        if (this.fAX != null && this.fAX.bnA() && i >= (arrowIndex = this.fAX.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean bnC() {
        return this.fAX != null && this.fAX.bnA() && bny() + (-1) > this.fAX.getArrowIndex();
    }

    public void kq(boolean z) {
        this.fAS = z;
    }
}
