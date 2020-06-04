package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes9.dex */
public abstract class a extends BaseAdapter {
    private boolean hAL = true;
    private f hAQ;

    public abstract int bYR();

    public abstract int bYS();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object uG(int i);

    public abstract long uH(int i);

    public abstract void uI(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (bYW()) {
            if (this.hAL) {
                return this.hAQ.getArrowIndex() + 1;
            }
            if (this.hAQ != null && this.hAQ.bYU()) {
                return bYS() + 1;
            }
            return bYS();
        }
        return bYS();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (bYW()) {
            int uJ = uJ(i);
            if (uJ >= 0) {
                return uG(uJ);
            }
            return uG(i);
        }
        return uG(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (bYW()) {
            int uJ = uJ(i);
            if (uJ >= 0) {
                return uH(uJ);
            }
            return uH(i);
        }
        return uH(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(uJ(i), view, viewGroup) : ca(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (bYW() && (arrowIndex = this.hAQ.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return bYW() ? 2 : 1;
    }

    public void a(f fVar) {
        this.hAQ = fVar;
    }

    private View ca(View view) {
        if (this.hAQ != null) {
            if (view == null || view != this.hAQ.getArrowView()) {
                view = this.hAQ.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, bYR()));
                }
            }
            this.hAQ.bZ(view);
        }
        return view;
    }

    public int uJ(int i) {
        int arrowIndex;
        if (this.hAQ != null && this.hAQ.bYU() && i >= (arrowIndex = this.hAQ.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean bYW() {
        return this.hAQ != null && this.hAQ.bYU() && bYS() + (-1) > this.hAQ.getArrowIndex();
    }

    public void nu(boolean z) {
        this.hAL = z;
    }
}
