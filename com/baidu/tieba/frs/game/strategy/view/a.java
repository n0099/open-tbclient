package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes9.dex */
public abstract class a extends BaseAdapter {
    private boolean hle = true;
    private f hlj;

    public abstract int bSp();

    public abstract int bSq();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object tZ(int i);

    public abstract long ua(int i);

    public abstract void ub(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (bSu()) {
            if (this.hle) {
                return this.hlj.getArrowIndex() + 1;
            }
            if (this.hlj != null && this.hlj.bSs()) {
                return bSq() + 1;
            }
            return bSq();
        }
        return bSq();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (bSu()) {
            int uc = uc(i);
            if (uc >= 0) {
                return tZ(uc);
            }
            return tZ(i);
        }
        return tZ(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (bSu()) {
            int uc = uc(i);
            if (uc >= 0) {
                return ua(uc);
            }
            return ua(i);
        }
        return ua(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(uc(i), view, viewGroup) : ca(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (bSu() && (arrowIndex = this.hlj.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return bSu() ? 2 : 1;
    }

    public void a(f fVar) {
        this.hlj = fVar;
    }

    private View ca(View view) {
        if (this.hlj != null) {
            if (view == null || view != this.hlj.getArrowView()) {
                view = this.hlj.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, bSp()));
                }
            }
            this.hlj.bZ(view);
        }
        return view;
    }

    public int uc(int i) {
        int arrowIndex;
        if (this.hlj != null && this.hlj.bSs() && i >= (arrowIndex = this.hlj.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean bSu() {
        return this.hlj != null && this.hlj.bSs() && bSq() + (-1) > this.hlj.getArrowIndex();
    }

    public void mZ(boolean z) {
        this.hle = z;
    }
}
