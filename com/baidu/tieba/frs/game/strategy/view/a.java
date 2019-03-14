package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes4.dex */
public abstract class a extends BaseAdapter {
    private boolean fkK = true;
    private f fkP;

    public abstract int bgf();

    public abstract int bgg();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object qK(int i);

    public abstract long qL(int i);

    public abstract void qM(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (bgk()) {
            if (this.fkK) {
                return this.fkP.getArrowIndex() + 1;
            }
            if (this.fkP != null && this.fkP.bgi()) {
                return bgg() + 1;
            }
            return bgg();
        }
        return bgg();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (bgk()) {
            int qN = qN(i);
            if (qN >= 0) {
                return qK(qN);
            }
            return qK(i);
        }
        return qK(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (bgk()) {
            int qN = qN(i);
            if (qN >= 0) {
                return qL(qN);
            }
            return qL(i);
        }
        return qL(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(qN(i), view, viewGroup) : bK(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (bgk() && (arrowIndex = this.fkP.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return bgk() ? 2 : 1;
    }

    public void a(f fVar) {
        this.fkP = fVar;
    }

    private View bK(View view) {
        if (this.fkP != null) {
            if (view == null || view != this.fkP.getArrowView()) {
                view = this.fkP.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, bgf()));
                }
            }
            this.fkP.bJ(view);
        }
        return view;
    }

    public int qN(int i) {
        int arrowIndex;
        if (this.fkP != null && this.fkP.bgi() && i >= (arrowIndex = this.fkP.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean bgk() {
        return this.fkP != null && this.fkP.bgi() && bgg() + (-1) > this.fkP.getArrowIndex();
    }

    public void jE(boolean z) {
        this.fkK = z;
    }
}
