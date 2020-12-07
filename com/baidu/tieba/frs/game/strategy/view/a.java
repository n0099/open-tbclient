package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes22.dex */
public abstract class a extends BaseAdapter {
    private boolean jkG = true;
    private f jkL;

    public abstract Object AT(int i);

    public abstract long AU(int i);

    public abstract void AV(int i);

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract int cHt();

    public abstract int cHu();

    @Override // android.widget.Adapter
    public int getCount() {
        if (cHy()) {
            if (this.jkG) {
                return this.jkL.getArrowIndex() + 1;
            }
            if (this.jkL != null && this.jkL.cHw()) {
                return cHu() + 1;
            }
            return cHu();
        }
        return cHu();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (cHy()) {
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
        if (cHy()) {
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
        return (cHy() && (arrowIndex = this.jkL.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return cHy() ? 2 : 1;
    }

    public void a(f fVar) {
        this.jkL = fVar;
    }

    private View cQ(View view) {
        if (this.jkL != null) {
            if (view == null || view != this.jkL.getArrowView()) {
                view = this.jkL.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, cHt()));
                }
            }
            this.jkL.cP(view);
        }
        return view;
    }

    public int AW(int i) {
        int arrowIndex;
        if (this.jkL != null && this.jkL.cHw() && i >= (arrowIndex = this.jkL.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean cHy() {
        return this.jkL != null && this.jkL.cHw() && cHu() + (-1) > this.jkL.getArrowIndex();
    }

    public void qH(boolean z) {
        this.jkG = z;
    }
}
