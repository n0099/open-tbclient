package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes3.dex */
public abstract class a extends BaseAdapter {
    private boolean dNh = true;
    private f dNm;

    public abstract int aCP();

    public abstract int aCQ();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object mt(int i);

    public abstract long mu(int i);

    public abstract void mv(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (aCU()) {
            if (this.dNh) {
                return this.dNm.getArrowIndex() + 1;
            }
            if (this.dNm != null && this.dNm.aCS()) {
                return aCQ() + 1;
            }
            return aCQ();
        }
        return aCQ();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (aCU()) {
            int mw = mw(i);
            if (mw >= 0) {
                return mt(mw);
            }
            return mt(i);
        }
        return mt(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (aCU()) {
            int mw = mw(i);
            if (mw >= 0) {
                return mu(mw);
            }
            return mu(i);
        }
        return mu(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(mw(i), view, viewGroup) : aP(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (aCU() && (arrowIndex = this.dNm.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return aCU() ? 2 : 1;
    }

    public void a(f fVar) {
        this.dNm = fVar;
    }

    private View aP(View view) {
        if (this.dNm != null) {
            if (view == null || view != this.dNm.getArrowView()) {
                view = this.dNm.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, aCP()));
                }
            }
            this.dNm.aO(view);
        }
        return view;
    }

    public int mw(int i) {
        int arrowIndex;
        if (this.dNm != null && this.dNm.aCS() && i >= (arrowIndex = this.dNm.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean aCU() {
        return this.dNm != null && this.dNm.aCS() && aCQ() + (-1) > this.dNm.getArrowIndex();
    }

    public void hb(boolean z) {
        this.dNh = z;
    }
}
