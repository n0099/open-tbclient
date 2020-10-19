package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes22.dex */
public abstract class a extends BaseAdapter {
    private boolean iEc = true;
    private f iEh;

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract int cwW();

    public abstract int cwX();

    public abstract Object zb(int i);

    public abstract long zc(int i);

    public abstract void zd(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (cxb()) {
            if (this.iEc) {
                return this.iEh.getArrowIndex() + 1;
            }
            if (this.iEh != null && this.iEh.cwZ()) {
                return cwX() + 1;
            }
            return cwX();
        }
        return cwX();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (cxb()) {
            int ze = ze(i);
            if (ze >= 0) {
                return zb(ze);
            }
            return zb(i);
        }
        return zb(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (cxb()) {
            int ze = ze(i);
            if (ze >= 0) {
                return zc(ze);
            }
            return zc(i);
        }
        return zc(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(ze(i), view, viewGroup) : cw(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (cxb() && (arrowIndex = this.iEh.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return cxb() ? 2 : 1;
    }

    public void a(f fVar) {
        this.iEh = fVar;
    }

    private View cw(View view) {
        if (this.iEh != null) {
            if (view == null || view != this.iEh.getArrowView()) {
                view = this.iEh.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, cwW()));
                }
            }
            this.iEh.cv(view);
        }
        return view;
    }

    public int ze(int i) {
        int arrowIndex;
        if (this.iEh != null && this.iEh.cwZ() && i >= (arrowIndex = this.iEh.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean cxb() {
        return this.iEh != null && this.iEh.cwZ() && cwX() + (-1) > this.iEh.getArrowIndex();
    }

    public void pC(boolean z) {
        this.iEc = z;
    }
}
