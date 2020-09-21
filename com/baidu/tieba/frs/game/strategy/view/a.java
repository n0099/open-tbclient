package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes21.dex */
public abstract class a extends BaseAdapter {
    private boolean ipj = true;
    private f ipo;

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract int ctA();

    public abstract int ctz();

    public abstract Object yv(int i);

    public abstract long yw(int i);

    public abstract void yx(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (ctE()) {
            if (this.ipj) {
                return this.ipo.getArrowIndex() + 1;
            }
            if (this.ipo != null && this.ipo.ctC()) {
                return ctA() + 1;
            }
            return ctA();
        }
        return ctA();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (ctE()) {
            int yy = yy(i);
            if (yy >= 0) {
                return yv(yy);
            }
            return yv(i);
        }
        return yv(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (ctE()) {
            int yy = yy(i);
            if (yy >= 0) {
                return yw(yy);
            }
            return yw(i);
        }
        return yw(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(yy(i), view, viewGroup) : cs(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (ctE() && (arrowIndex = this.ipo.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return ctE() ? 2 : 1;
    }

    public void a(f fVar) {
        this.ipo = fVar;
    }

    private View cs(View view) {
        if (this.ipo != null) {
            if (view == null || view != this.ipo.getArrowView()) {
                view = this.ipo.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, ctz()));
                }
            }
            this.ipo.cr(view);
        }
        return view;
    }

    public int yy(int i) {
        int arrowIndex;
        if (this.ipo != null && this.ipo.ctC() && i >= (arrowIndex = this.ipo.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean ctE() {
        return this.ipo != null && this.ipo.ctC() && ctA() + (-1) > this.ipo.getArrowIndex();
    }

    public void oX(boolean z) {
        this.ipj = z;
    }
}
