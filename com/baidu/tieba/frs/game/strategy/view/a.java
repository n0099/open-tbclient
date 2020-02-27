package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes9.dex */
public abstract class a extends BaseAdapter {
    private f gAB;
    private boolean gAw = true;

    public abstract int bHB();

    public abstract int bHC();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object tv(int i);

    public abstract long tw(int i);

    public abstract void tx(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (bHG()) {
            if (this.gAw) {
                return this.gAB.getArrowIndex() + 1;
            }
            if (this.gAB != null && this.gAB.bHE()) {
                return bHC() + 1;
            }
            return bHC();
        }
        return bHC();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (bHG()) {
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
        if (bHG()) {
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
        return (bHG() && (arrowIndex = this.gAB.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return bHG() ? 2 : 1;
    }

    public void a(f fVar) {
        this.gAB = fVar;
    }

    private View bS(View view) {
        if (this.gAB != null) {
            if (view == null || view != this.gAB.getArrowView()) {
                view = this.gAB.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, bHB()));
                }
            }
            this.gAB.bR(view);
        }
        return view;
    }

    public int ty(int i) {
        int arrowIndex;
        if (this.gAB != null && this.gAB.bHE() && i >= (arrowIndex = this.gAB.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean bHG() {
        return this.gAB != null && this.gAB.bHE() && bHC() + (-1) > this.gAB.getArrowIndex();
    }

    public void lQ(boolean z) {
        this.gAw = z;
    }
}
