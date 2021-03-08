package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes2.dex */
public abstract class a extends BaseAdapter {
    private boolean jAe = true;
    private e jAj;

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract int cId();

    public abstract int cIe();

    public abstract Object zK(int i);

    public abstract long zL(int i);

    public abstract void zM(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (cIi()) {
            if (this.jAe) {
                return this.jAj.getArrowIndex() + 1;
            }
            if (this.jAj != null && this.jAj.cIg()) {
                return cIe() + 1;
            }
            return cIe();
        }
        return cIe();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (cIi()) {
            int zN = zN(i);
            if (zN >= 0) {
                return zK(zN);
            }
            return zK(i);
        }
        return zK(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (cIi()) {
            int zN = zN(i);
            if (zN >= 0) {
                return zL(zN);
            }
            return zL(i);
        }
        return zL(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(zN(i), view, viewGroup) : cY(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (cIi() && (arrowIndex = this.jAj.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return cIi() ? 2 : 1;
    }

    public void a(e eVar) {
        this.jAj = eVar;
    }

    private View cY(View view) {
        if (this.jAj != null) {
            if (view == null || view != this.jAj.getArrowView()) {
                view = this.jAj.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, cId()));
                }
            }
            this.jAj.cX(view);
        }
        return view;
    }

    public int zN(int i) {
        int arrowIndex;
        if (this.jAj != null && this.jAj.cIg() && i >= (arrowIndex = this.jAj.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean cIi() {
        return this.jAj != null && this.jAj.cIg() && cIe() + (-1) > this.jAj.getArrowIndex();
    }

    public void rl(boolean z) {
        this.jAe = z;
    }
}
