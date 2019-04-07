package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes4.dex */
public abstract class a extends BaseAdapter {
    private f fkB;
    private boolean fkw = true;

    public abstract int bgd();

    public abstract int bge();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object qG(int i);

    public abstract long qH(int i);

    public abstract void qI(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (bgi()) {
            if (this.fkw) {
                return this.fkB.getArrowIndex() + 1;
            }
            if (this.fkB != null && this.fkB.bgg()) {
                return bge() + 1;
            }
            return bge();
        }
        return bge();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (bgi()) {
            int qJ = qJ(i);
            if (qJ >= 0) {
                return qG(qJ);
            }
            return qG(i);
        }
        return qG(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (bgi()) {
            int qJ = qJ(i);
            if (qJ >= 0) {
                return qH(qJ);
            }
            return qH(i);
        }
        return qH(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(qJ(i), view, viewGroup) : bK(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (bgi() && (arrowIndex = this.fkB.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return bgi() ? 2 : 1;
    }

    public void a(f fVar) {
        this.fkB = fVar;
    }

    private View bK(View view) {
        if (this.fkB != null) {
            if (view == null || view != this.fkB.getArrowView()) {
                view = this.fkB.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, bgd()));
                }
            }
            this.fkB.bJ(view);
        }
        return view;
    }

    public int qJ(int i) {
        int arrowIndex;
        if (this.fkB != null && this.fkB.bgg() && i >= (arrowIndex = this.fkB.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean bgi() {
        return this.fkB != null && this.fkB.bgg() && bge() + (-1) > this.fkB.getArrowIndex();
    }

    public void jE(boolean z) {
        this.fkw = z;
    }
}
