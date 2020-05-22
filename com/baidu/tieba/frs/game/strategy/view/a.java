package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes9.dex */
public abstract class a extends BaseAdapter {
    private f hAd;
    private boolean hzY = true;

    public abstract int bYJ();

    public abstract int bYK();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object uE(int i);

    public abstract long uF(int i);

    public abstract void uG(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (bYO()) {
            if (this.hzY) {
                return this.hAd.getArrowIndex() + 1;
            }
            if (this.hAd != null && this.hAd.bYM()) {
                return bYK() + 1;
            }
            return bYK();
        }
        return bYK();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (bYO()) {
            int uH = uH(i);
            if (uH >= 0) {
                return uE(uH);
            }
            return uE(i);
        }
        return uE(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (bYO()) {
            int uH = uH(i);
            if (uH >= 0) {
                return uF(uH);
            }
            return uF(i);
        }
        return uF(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(uH(i), view, viewGroup) : ca(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (bYO() && (arrowIndex = this.hAd.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return bYO() ? 2 : 1;
    }

    public void a(f fVar) {
        this.hAd = fVar;
    }

    private View ca(View view) {
        if (this.hAd != null) {
            if (view == null || view != this.hAd.getArrowView()) {
                view = this.hAd.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, bYJ()));
                }
            }
            this.hAd.bZ(view);
        }
        return view;
    }

    public int uH(int i) {
        int arrowIndex;
        if (this.hAd != null && this.hAd.bYM() && i >= (arrowIndex = this.hAd.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean bYO() {
        return this.hAd != null && this.hAd.bYM() && bYK() + (-1) > this.hAd.getArrowIndex();
    }

    public void nu(boolean z) {
        this.hzY = z;
    }
}
