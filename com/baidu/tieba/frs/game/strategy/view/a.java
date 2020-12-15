package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes22.dex */
public abstract class a extends BaseAdapter {
    private boolean jkI = true;
    private f jkN;

    public abstract Object AT(int i);

    public abstract long AU(int i);

    public abstract void AV(int i);

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract int cHu();

    public abstract int cHv();

    @Override // android.widget.Adapter
    public int getCount() {
        if (cHz()) {
            if (this.jkI) {
                return this.jkN.getArrowIndex() + 1;
            }
            if (this.jkN != null && this.jkN.cHx()) {
                return cHv() + 1;
            }
            return cHv();
        }
        return cHv();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (cHz()) {
            int AW = AW(i);
            if (AW >= 0) {
                return AT(AW);
            }
            return AT(i);
        }
        return AT(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (cHz()) {
            int AW = AW(i);
            if (AW >= 0) {
                return AU(AW);
            }
            return AU(i);
        }
        return AU(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(AW(i), view, viewGroup) : cQ(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (cHz() && (arrowIndex = this.jkN.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return cHz() ? 2 : 1;
    }

    public void a(f fVar) {
        this.jkN = fVar;
    }

    private View cQ(View view) {
        if (this.jkN != null) {
            if (view == null || view != this.jkN.getArrowView()) {
                view = this.jkN.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, cHu()));
                }
            }
            this.jkN.cP(view);
        }
        return view;
    }

    public int AW(int i) {
        int arrowIndex;
        if (this.jkN != null && this.jkN.cHx() && i >= (arrowIndex = this.jkN.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean cHz() {
        return this.jkN != null && this.jkN.cHx() && cHv() + (-1) > this.jkN.getArrowIndex();
    }

    public void qH(boolean z) {
        this.jkI = z;
    }
}
