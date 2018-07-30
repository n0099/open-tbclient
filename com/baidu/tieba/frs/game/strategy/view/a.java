package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes3.dex */
public abstract class a extends BaseAdapter {
    private f dxC;
    private boolean dxx = true;

    public abstract int axO();

    public abstract int axP();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object lc(int i);

    public abstract long ld(int i);

    public abstract void le(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (axT()) {
            if (this.dxx) {
                return this.dxC.getArrowIndex() + 1;
            }
            if (this.dxC != null && this.dxC.axR()) {
                return axP() + 1;
            }
            return axP();
        }
        return axP();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (axT()) {
            int lf = lf(i);
            if (lf >= 0) {
                return lc(lf);
            }
            return lc(i);
        }
        return lc(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (axT()) {
            int lf = lf(i);
            if (lf >= 0) {
                return ld(lf);
            }
            return ld(i);
        }
        return ld(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(lf(i), view, viewGroup) : az(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (axT() && (arrowIndex = this.dxC.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return axT() ? 2 : 1;
    }

    public void a(f fVar) {
        this.dxC = fVar;
    }

    private View az(View view) {
        if (this.dxC != null) {
            if (view == null || view != this.dxC.getArrowView()) {
                view = this.dxC.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, axO()));
                }
            }
            this.dxC.ay(view);
        }
        return view;
    }

    public int lf(int i) {
        int arrowIndex;
        if (this.dxC != null && this.dxC.axR() && i >= (arrowIndex = this.dxC.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean axT() {
        return this.dxC != null && this.dxC.axR() && axP() + (-1) > this.dxC.getArrowIndex();
    }

    public void gc(boolean z) {
        this.dxx = z;
    }
}
