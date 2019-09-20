package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes4.dex */
public abstract class a extends BaseAdapter {
    private boolean fIt = true;
    private f fIy;

    public abstract int bqx();

    public abstract int bqy();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object sm(int i);

    public abstract long sn(int i);

    public abstract void so(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (bqC()) {
            if (this.fIt) {
                return this.fIy.getArrowIndex() + 1;
            }
            if (this.fIy != null && this.fIy.bqA()) {
                return bqy() + 1;
            }
            return bqy();
        }
        return bqy();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (bqC()) {
            int sp = sp(i);
            if (sp >= 0) {
                return sm(sp);
            }
            return sm(i);
        }
        return sm(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (bqC()) {
            int sp = sp(i);
            if (sp >= 0) {
                return sn(sp);
            }
            return sn(i);
        }
        return sn(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(sp(i), view, viewGroup) : bV(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (bqC() && (arrowIndex = this.fIy.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return bqC() ? 2 : 1;
    }

    public void a(f fVar) {
        this.fIy = fVar;
    }

    private View bV(View view) {
        if (this.fIy != null) {
            if (view == null || view != this.fIy.getArrowView()) {
                view = this.fIy.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, bqx()));
                }
            }
            this.fIy.bU(view);
        }
        return view;
    }

    public int sp(int i) {
        int arrowIndex;
        if (this.fIy != null && this.fIy.bqA() && i >= (arrowIndex = this.fIy.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean bqC() {
        return this.fIy != null && this.fIy.bqA() && bqy() + (-1) > this.fIy.getArrowIndex();
    }

    public void kD(boolean z) {
        this.fIt = z;
    }
}
