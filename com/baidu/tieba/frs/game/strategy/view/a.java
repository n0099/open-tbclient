package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes4.dex */
public abstract class a extends BaseAdapter {
    private boolean fGT = true;
    private f fGY;

    public abstract int bnA();

    public abstract int bnB();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object re(int i);

    public abstract long rf(int i);

    public abstract void rg(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (bnF()) {
            if (this.fGT) {
                return this.fGY.getArrowIndex() + 1;
            }
            if (this.fGY != null && this.fGY.bnD()) {
                return bnB() + 1;
            }
            return bnB();
        }
        return bnB();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (bnF()) {
            int rh = rh(i);
            if (rh >= 0) {
                return re(rh);
            }
            return re(i);
        }
        return re(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (bnF()) {
            int rh = rh(i);
            if (rh >= 0) {
                return rf(rh);
            }
            return rf(i);
        }
        return rf(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(rh(i), view, viewGroup) : bS(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (bnF() && (arrowIndex = this.fGY.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return bnF() ? 2 : 1;
    }

    public void a(f fVar) {
        this.fGY = fVar;
    }

    private View bS(View view) {
        if (this.fGY != null) {
            if (view == null || view != this.fGY.getArrowView()) {
                view = this.fGY.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, bnA()));
                }
            }
            this.fGY.bR(view);
        }
        return view;
    }

    public int rh(int i) {
        int arrowIndex;
        if (this.fGY != null && this.fGY.bnD() && i >= (arrowIndex = this.fGY.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean bnF() {
        return this.fGY != null && this.fGY.bnD() && bnB() + (-1) > this.fGY.getArrowIndex();
    }

    public void kq(boolean z) {
        this.fGT = z;
    }
}
