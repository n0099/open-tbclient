package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes9.dex */
public abstract class a extends BaseAdapter {
    private boolean gBI = true;
    private f gBN;

    public abstract int bHQ();

    public abstract int bHR();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object tB(int i);

    public abstract long tC(int i);

    public abstract void tD(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (bHV()) {
            if (this.gBI) {
                return this.gBN.getArrowIndex() + 1;
            }
            if (this.gBN != null && this.gBN.bHT()) {
                return bHR() + 1;
            }
            return bHR();
        }
        return bHR();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (bHV()) {
            int tE = tE(i);
            if (tE >= 0) {
                return tB(tE);
            }
            return tB(i);
        }
        return tB(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (bHV()) {
            int tE = tE(i);
            if (tE >= 0) {
                return tC(tE);
            }
            return tC(i);
        }
        return tC(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(tE(i), view, viewGroup) : bS(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (bHV() && (arrowIndex = this.gBN.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return bHV() ? 2 : 1;
    }

    public void a(f fVar) {
        this.gBN = fVar;
    }

    private View bS(View view) {
        if (this.gBN != null) {
            if (view == null || view != this.gBN.getArrowView()) {
                view = this.gBN.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, bHQ()));
                }
            }
            this.gBN.bR(view);
        }
        return view;
    }

    public int tE(int i) {
        int arrowIndex;
        if (this.gBN != null && this.gBN.bHT() && i >= (arrowIndex = this.gBN.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean bHV() {
        return this.gBN != null && this.gBN.bHT() && bHR() + (-1) > this.gBN.getArrowIndex();
    }

    public void lV(boolean z) {
        this.gBI = z;
    }
}
