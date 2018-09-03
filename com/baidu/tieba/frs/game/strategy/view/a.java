package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes3.dex */
public abstract class a extends BaseAdapter {
    private boolean dxu = true;
    private f dxz;

    public abstract int axM();

    public abstract int axN();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object lb(int i);

    public abstract long lc(int i);

    public abstract void ld(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (axR()) {
            if (this.dxu) {
                return this.dxz.getArrowIndex() + 1;
            }
            if (this.dxz != null && this.dxz.axP()) {
                return axN() + 1;
            }
            return axN();
        }
        return axN();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (axR()) {
            int le = le(i);
            if (le >= 0) {
                return lb(le);
            }
            return lb(i);
        }
        return lb(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (axR()) {
            int le = le(i);
            if (le >= 0) {
                return lc(le);
            }
            return lc(i);
        }
        return lc(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(le(i), view, viewGroup) : az(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (axR() && (arrowIndex = this.dxz.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return axR() ? 2 : 1;
    }

    public void a(f fVar) {
        this.dxz = fVar;
    }

    private View az(View view) {
        if (this.dxz != null) {
            if (view == null || view != this.dxz.getArrowView()) {
                view = this.dxz.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, axM()));
                }
            }
            this.dxz.ay(view);
        }
        return view;
    }

    public int le(int i) {
        int arrowIndex;
        if (this.dxz != null && this.dxz.axP() && i >= (arrowIndex = this.dxz.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean axR() {
        return this.dxz != null && this.dxz.axP() && axN() + (-1) > this.dxz.getArrowIndex();
    }

    public void gc(boolean z) {
        this.dxu = z;
    }
}
