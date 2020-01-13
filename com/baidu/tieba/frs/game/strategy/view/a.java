package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes7.dex */
public abstract class a extends BaseAdapter {
    private f gyB;
    private boolean gyw = true;

    public abstract int bFZ();

    public abstract int bGa();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object tp(int i);

    public abstract long tq(int i);

    public abstract void tr(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (bGe()) {
            if (this.gyw) {
                return this.gyB.getArrowIndex() + 1;
            }
            if (this.gyB != null && this.gyB.bGc()) {
                return bGa() + 1;
            }
            return bGa();
        }
        return bGa();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (bGe()) {
            int ts = ts(i);
            if (ts >= 0) {
                return tp(ts);
            }
            return tp(i);
        }
        return tp(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (bGe()) {
            int ts = ts(i);
            if (ts >= 0) {
                return tq(ts);
            }
            return tq(i);
        }
        return tq(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(ts(i), view, viewGroup) : bS(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (bGe() && (arrowIndex = this.gyB.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return bGe() ? 2 : 1;
    }

    public void a(f fVar) {
        this.gyB = fVar;
    }

    private View bS(View view) {
        if (this.gyB != null) {
            if (view == null || view != this.gyB.getArrowView()) {
                view = this.gyB.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, bFZ()));
                }
            }
            this.gyB.bR(view);
        }
        return view;
    }

    public int ts(int i) {
        int arrowIndex;
        if (this.gyB != null && this.gyB.bGc() && i >= (arrowIndex = this.gyB.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean bGe() {
        return this.gyB != null && this.gyB.bGc() && bGa() + (-1) > this.gyB.getArrowIndex();
    }

    public void lN(boolean z) {
        this.gyw = z;
    }
}
