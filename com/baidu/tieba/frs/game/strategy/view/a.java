package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes9.dex */
public abstract class a extends BaseAdapter {
    private f gAD;
    private boolean gAy = true;

    public abstract int bHD();

    public abstract int bHE();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object tv(int i);

    public abstract long tw(int i);

    public abstract void tx(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (bHI()) {
            if (this.gAy) {
                return this.gAD.getArrowIndex() + 1;
            }
            if (this.gAD != null && this.gAD.bHG()) {
                return bHE() + 1;
            }
            return bHE();
        }
        return bHE();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (bHI()) {
            int ty = ty(i);
            if (ty >= 0) {
                return tv(ty);
            }
            return tv(i);
        }
        return tv(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (bHI()) {
            int ty = ty(i);
            if (ty >= 0) {
                return tw(ty);
            }
            return tw(i);
        }
        return tw(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(ty(i), view, viewGroup) : bS(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (bHI() && (arrowIndex = this.gAD.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return bHI() ? 2 : 1;
    }

    public void a(f fVar) {
        this.gAD = fVar;
    }

    private View bS(View view) {
        if (this.gAD != null) {
            if (view == null || view != this.gAD.getArrowView()) {
                view = this.gAD.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, bHD()));
                }
            }
            this.gAD.bR(view);
        }
        return view;
    }

    public int ty(int i) {
        int arrowIndex;
        if (this.gAD != null && this.gAD.bHG() && i >= (arrowIndex = this.gAD.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean bHI() {
        return this.gAD != null && this.gAD.bHG() && bHE() + (-1) > this.gAD.getArrowIndex();
    }

    public void lQ(boolean z) {
        this.gAy = z;
    }
}
