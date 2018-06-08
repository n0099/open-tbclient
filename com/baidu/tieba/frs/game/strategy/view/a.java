package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes3.dex */
public abstract class a extends BaseAdapter {
    private boolean drB = true;
    private f drG;

    public abstract int awF();

    public abstract int awG();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object kK(int i);

    public abstract long kL(int i);

    public abstract void kM(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (awK()) {
            if (this.drB) {
                return this.drG.getArrowIndex() + 1;
            }
            if (this.drG != null && this.drG.awI()) {
                return awG() + 1;
            }
            return awG();
        }
        return awG();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (awK()) {
            int kN = kN(i);
            if (kN >= 0) {
                return kK(kN);
            }
            return kK(i);
        }
        return kK(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (awK()) {
            int kN = kN(i);
            if (kN >= 0) {
                return kL(kN);
            }
            return kL(i);
        }
        return kL(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(kN(i), view, viewGroup) : au(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (awK() && (arrowIndex = this.drG.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return awK() ? 2 : 1;
    }

    public void a(f fVar) {
        this.drG = fVar;
    }

    private View au(View view) {
        if (this.drG != null) {
            if (view == null || view != this.drG.getArrowView()) {
                view = this.drG.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, awF()));
                }
            }
            this.drG.at(view);
        }
        return view;
    }

    public int kN(int i) {
        int arrowIndex;
        if (this.drG != null && this.drG.awI() && i >= (arrowIndex = this.drG.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean awK() {
        return this.drG != null && this.drG.awI() && awG() + (-1) > this.drG.getArrowIndex();
    }

    public void fS(boolean z) {
        this.drB = z;
    }
}
