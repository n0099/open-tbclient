package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes9.dex */
public abstract class a extends BaseAdapter {
    private boolean hlk = true;
    private f hlp;

    public abstract int bSn();

    public abstract int bSo();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object tZ(int i);

    public abstract long ua(int i);

    public abstract void ub(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (bSs()) {
            if (this.hlk) {
                return this.hlp.getArrowIndex() + 1;
            }
            if (this.hlp != null && this.hlp.bSq()) {
                return bSo() + 1;
            }
            return bSo();
        }
        return bSo();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (bSs()) {
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
        if (bSs()) {
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
        return (bSs() && (arrowIndex = this.hlp.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return bSs() ? 2 : 1;
    }

    public void a(f fVar) {
        this.hlp = fVar;
    }

    private View ca(View view) {
        if (this.hlp != null) {
            if (view == null || view != this.hlp.getArrowView()) {
                view = this.hlp.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, bSn()));
                }
            }
            this.hlp.bZ(view);
        }
        return view;
    }

    public int uc(int i) {
        int arrowIndex;
        if (this.hlp != null && this.hlp.bSq() && i >= (arrowIndex = this.hlp.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean bSs() {
        return this.hlp != null && this.hlp.bSq() && bSo() + (-1) > this.hlp.getArrowIndex();
    }

    public void mZ(boolean z) {
        this.hlk = z;
    }
}
