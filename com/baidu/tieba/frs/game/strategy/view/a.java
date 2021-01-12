package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes2.dex */
public abstract class a extends BaseAdapter {
    private boolean jsB = true;
    private e jsG;

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract int cGD();

    public abstract int cGE();

    public abstract long zA(int i);

    public abstract void zB(int i);

    public abstract Object zz(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (cGI()) {
            if (this.jsB) {
                return this.jsG.getArrowIndex() + 1;
            }
            if (this.jsG != null && this.jsG.cGG()) {
                return cGE() + 1;
            }
            return cGE();
        }
        return cGE();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (cGI()) {
            int zC = zC(i);
            if (zC >= 0) {
                return zz(zC);
            }
            return zz(i);
        }
        return zz(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (cGI()) {
            int zC = zC(i);
            if (zC >= 0) {
                return zA(zC);
            }
            return zA(i);
        }
        return zA(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(zC(i), view, viewGroup) : da(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (cGI() && (arrowIndex = this.jsG.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return cGI() ? 2 : 1;
    }

    public void a(e eVar) {
        this.jsG = eVar;
    }

    private View da(View view) {
        if (this.jsG != null) {
            if (view == null || view != this.jsG.getArrowView()) {
                view = this.jsG.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, cGD()));
                }
            }
            this.jsG.cZ(view);
        }
        return view;
    }

    public int zC(int i) {
        int arrowIndex;
        if (this.jsG != null && this.jsG.cGG() && i >= (arrowIndex = this.jsG.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean cGI() {
        return this.jsG != null && this.jsG.cGG() && cGE() + (-1) > this.jsG.getArrowIndex();
    }

    public void rb(boolean z) {
        this.jsB = z;
    }
}
