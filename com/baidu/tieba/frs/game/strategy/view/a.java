package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes9.dex */
public abstract class a extends BaseAdapter {
    private boolean gAK = true;
    private f gAP;

    public abstract int bHE();

    public abstract int bHF();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object tv(int i);

    public abstract long tw(int i);

    public abstract void tx(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (bHJ()) {
            if (this.gAK) {
                return this.gAP.getArrowIndex() + 1;
            }
            if (this.gAP != null && this.gAP.bHH()) {
                return bHF() + 1;
            }
            return bHF();
        }
        return bHF();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (bHJ()) {
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
        if (bHJ()) {
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
        return (bHJ() && (arrowIndex = this.gAP.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return bHJ() ? 2 : 1;
    }

    public void a(f fVar) {
        this.gAP = fVar;
    }

    private View bS(View view) {
        if (this.gAP != null) {
            if (view == null || view != this.gAP.getArrowView()) {
                view = this.gAP.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, bHE()));
                }
            }
            this.gAP.bR(view);
        }
        return view;
    }

    public int ty(int i) {
        int arrowIndex;
        if (this.gAP != null && this.gAP.bHH() && i >= (arrowIndex = this.gAP.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean bHJ() {
        return this.gAP != null && this.gAP.bHH() && bHF() + (-1) > this.gAP.getArrowIndex();
    }

    public void lQ(boolean z) {
        this.gAK = z;
    }
}
