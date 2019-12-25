package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes6.dex */
public abstract class a extends BaseAdapter {
    private boolean gvm = true;
    private f gvr;

    public abstract int bEX();

    public abstract int bEY();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object tk(int i);

    public abstract long tl(int i);

    public abstract void tm(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (bFc()) {
            if (this.gvm) {
                return this.gvr.getArrowIndex() + 1;
            }
            if (this.gvr != null && this.gvr.bFa()) {
                return bEY() + 1;
            }
            return bEY();
        }
        return bEY();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (bFc()) {
            int tn = tn(i);
            if (tn >= 0) {
                return tk(tn);
            }
            return tk(i);
        }
        return tk(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (bFc()) {
            int tn = tn(i);
            if (tn >= 0) {
                return tl(tn);
            }
            return tl(i);
        }
        return tl(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(tn(i), view, viewGroup) : bN(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (bFc() && (arrowIndex = this.gvr.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return bFc() ? 2 : 1;
    }

    public void a(f fVar) {
        this.gvr = fVar;
    }

    private View bN(View view) {
        if (this.gvr != null) {
            if (view == null || view != this.gvr.getArrowView()) {
                view = this.gvr.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, bEX()));
                }
            }
            this.gvr.bM(view);
        }
        return view;
    }

    public int tn(int i) {
        int arrowIndex;
        if (this.gvr != null && this.gvr.bFa() && i >= (arrowIndex = this.gvr.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean bFc() {
        return this.gvr != null && this.gvr.bFa() && bEY() + (-1) > this.gvr.getArrowIndex();
    }

    public void lC(boolean z) {
        this.gvm = z;
    }
}
