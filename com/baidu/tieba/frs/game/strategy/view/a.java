package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes2.dex */
public abstract class a extends BaseAdapter {
    private boolean jyh = true;
    private e jym;

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract int cHQ();

    public abstract int cHR();

    public abstract Object zJ(int i);

    public abstract long zK(int i);

    public abstract void zL(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (cHV()) {
            if (this.jyh) {
                return this.jym.getArrowIndex() + 1;
            }
            if (this.jym != null && this.jym.cHT()) {
                return cHR() + 1;
            }
            return cHR();
        }
        return cHR();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (cHV()) {
            int zM = zM(i);
            if (zM >= 0) {
                return zJ(zM);
            }
            return zJ(i);
        }
        return zJ(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (cHV()) {
            int zM = zM(i);
            if (zM >= 0) {
                return zK(zM);
            }
            return zK(i);
        }
        return zK(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(zM(i), view, viewGroup) : cY(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (cHV() && (arrowIndex = this.jym.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return cHV() ? 2 : 1;
    }

    public void a(e eVar) {
        this.jym = eVar;
    }

    private View cY(View view) {
        if (this.jym != null) {
            if (view == null || view != this.jym.getArrowView()) {
                view = this.jym.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, cHQ()));
                }
            }
            this.jym.cX(view);
        }
        return view;
    }

    public int zM(int i) {
        int arrowIndex;
        if (this.jym != null && this.jym.cHT() && i >= (arrowIndex = this.jym.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean cHV() {
        return this.jym != null && this.jym.cHT() && cHR() + (-1) > this.jym.getArrowIndex();
    }

    public void rl(boolean z) {
        this.jyh = z;
    }
}
