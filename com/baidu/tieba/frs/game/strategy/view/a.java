package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes3.dex */
public abstract class a extends BaseAdapter {
    private boolean dTK = true;
    private f dTP;

    public abstract int aEB();

    public abstract int aEC();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object mJ(int i);

    public abstract long mK(int i);

    public abstract void mL(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (aEG()) {
            if (this.dTK) {
                return this.dTP.getArrowIndex() + 1;
            }
            if (this.dTP != null && this.dTP.aEE()) {
                return aEC() + 1;
            }
            return aEC();
        }
        return aEC();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (aEG()) {
            int mM = mM(i);
            if (mM >= 0) {
                return mJ(mM);
            }
            return mJ(i);
        }
        return mJ(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (aEG()) {
            int mM = mM(i);
            if (mM >= 0) {
                return mK(mM);
            }
            return mK(i);
        }
        return mK(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(mM(i), view, viewGroup) : aP(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (aEG() && (arrowIndex = this.dTP.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return aEG() ? 2 : 1;
    }

    public void a(f fVar) {
        this.dTP = fVar;
    }

    private View aP(View view) {
        if (this.dTP != null) {
            if (view == null || view != this.dTP.getArrowView()) {
                view = this.dTP.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, aEB()));
                }
            }
            this.dTP.aO(view);
        }
        return view;
    }

    public int mM(int i) {
        int arrowIndex;
        if (this.dTP != null && this.dTP.aEE() && i >= (arrowIndex = this.dTP.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean aEG() {
        return this.dTP != null && this.dTP.aEE() && aEC() + (-1) > this.dTP.getArrowIndex();
    }

    public void hd(boolean z) {
        this.dTK = z;
    }
}
