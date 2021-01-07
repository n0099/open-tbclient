package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes2.dex */
public abstract class a extends BaseAdapter {
    private boolean jxh = true;
    private e jxm;

    public abstract Object Bf(int i);

    public abstract long Bg(int i);

    public abstract void Bh(int i);

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract int cKv();

    public abstract int cKw();

    @Override // android.widget.Adapter
    public int getCount() {
        if (cKA()) {
            if (this.jxh) {
                return this.jxm.getArrowIndex() + 1;
            }
            if (this.jxm != null && this.jxm.cKy()) {
                return cKw() + 1;
            }
            return cKw();
        }
        return cKw();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (cKA()) {
            int Bi = Bi(i);
            if (Bi >= 0) {
                return Bf(Bi);
            }
            return Bf(i);
        }
        return Bf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (cKA()) {
            int Bi = Bi(i);
            if (Bi >= 0) {
                return Bg(Bi);
            }
            return Bg(i);
        }
        return Bg(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(Bi(i), view, viewGroup) : da(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (cKA() && (arrowIndex = this.jxm.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return cKA() ? 2 : 1;
    }

    public void a(e eVar) {
        this.jxm = eVar;
    }

    private View da(View view) {
        if (this.jxm != null) {
            if (view == null || view != this.jxm.getArrowView()) {
                view = this.jxm.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, cKv()));
                }
            }
            this.jxm.cZ(view);
        }
        return view;
    }

    public int Bi(int i) {
        int arrowIndex;
        if (this.jxm != null && this.jxm.cKy() && i >= (arrowIndex = this.jxm.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean cKA() {
        return this.jxm != null && this.jxm.cKy() && cKw() + (-1) > this.jxm.getArrowIndex();
    }

    public void rf(boolean z) {
        this.jxh = z;
    }
}
