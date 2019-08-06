package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes4.dex */
public abstract class a extends BaseAdapter {
    private boolean fGE = true;
    private f fGJ;

    public abstract int bpL();

    public abstract int bpM();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object si(int i);

    public abstract long sj(int i);

    public abstract void sk(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (bpQ()) {
            if (this.fGE) {
                return this.fGJ.getArrowIndex() + 1;
            }
            if (this.fGJ != null && this.fGJ.bpO()) {
                return bpM() + 1;
            }
            return bpM();
        }
        return bpM();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (bpQ()) {
            int sl = sl(i);
            if (sl >= 0) {
                return si(sl);
            }
            return si(i);
        }
        return si(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (bpQ()) {
            int sl = sl(i);
            if (sl >= 0) {
                return sj(sl);
            }
            return sj(i);
        }
        return sj(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(sl(i), view, viewGroup) : bV(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (bpQ() && (arrowIndex = this.fGJ.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return bpQ() ? 2 : 1;
    }

    public void a(f fVar) {
        this.fGJ = fVar;
    }

    private View bV(View view) {
        if (this.fGJ != null) {
            if (view == null || view != this.fGJ.getArrowView()) {
                view = this.fGJ.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, bpL()));
                }
            }
            this.fGJ.bU(view);
        }
        return view;
    }

    public int sl(int i) {
        int arrowIndex;
        if (this.fGJ != null && this.fGJ.bpO() && i >= (arrowIndex = this.fGJ.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean bpQ() {
        return this.fGJ != null && this.fGJ.bpO() && bpM() + (-1) > this.fGJ.getArrowIndex();
    }

    public void kA(boolean z) {
        this.fGE = z;
    }
}
