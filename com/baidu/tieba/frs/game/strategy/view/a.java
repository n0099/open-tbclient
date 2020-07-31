package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes16.dex */
public abstract class a extends BaseAdapter {
    private boolean hTS = true;
    private f hTX;

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract int cfG();

    public abstract int cfH();

    public abstract Object vD(int i);

    public abstract long vE(int i);

    public abstract void vF(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (cfL()) {
            if (this.hTS) {
                return this.hTX.getArrowIndex() + 1;
            }
            if (this.hTX != null && this.hTX.cfJ()) {
                return cfH() + 1;
            }
            return cfH();
        }
        return cfH();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (cfL()) {
            int vG = vG(i);
            if (vG >= 0) {
                return vD(vG);
            }
            return vD(i);
        }
        return vD(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (cfL()) {
            int vG = vG(i);
            if (vG >= 0) {
                return vE(vG);
            }
            return vE(i);
        }
        return vE(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(vG(i), view, viewGroup) : ch(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (cfL() && (arrowIndex = this.hTX.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return cfL() ? 2 : 1;
    }

    public void a(f fVar) {
        this.hTX = fVar;
    }

    private View ch(View view) {
        if (this.hTX != null) {
            if (view == null || view != this.hTX.getArrowView()) {
                view = this.hTX.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, cfG()));
                }
            }
            this.hTX.cg(view);
        }
        return view;
    }

    public int vG(int i) {
        int arrowIndex;
        if (this.hTX != null && this.hTX.cfJ() && i >= (arrowIndex = this.hTX.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean cfL() {
        return this.hTX != null && this.hTX.cfJ() && cfH() + (-1) > this.hTX.getArrowIndex();
    }

    public void ol(boolean z) {
        this.hTS = z;
    }
}
