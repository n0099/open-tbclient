package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes3.dex */
public abstract class a extends BaseAdapter {
    private boolean duK = true;
    private f duP;

    public abstract int axj();

    public abstract int axk();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object kR(int i);

    public abstract long kS(int i);

    public abstract void kT(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (axo()) {
            if (this.duK) {
                return this.duP.getArrowIndex() + 1;
            }
            if (this.duP != null && this.duP.axm()) {
                return axk() + 1;
            }
            return axk();
        }
        return axk();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (axo()) {
            int kU = kU(i);
            if (kU >= 0) {
                return kR(kU);
            }
            return kR(i);
        }
        return kR(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (axo()) {
            int kU = kU(i);
            if (kU >= 0) {
                return kS(kU);
            }
            return kS(i);
        }
        return kS(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(kU(i), view, viewGroup) : aw(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (axo() && (arrowIndex = this.duP.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return axo() ? 2 : 1;
    }

    public void a(f fVar) {
        this.duP = fVar;
    }

    private View aw(View view) {
        if (this.duP != null) {
            if (view == null || view != this.duP.getArrowView()) {
                view = this.duP.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, axj()));
                }
            }
            this.duP.av(view);
        }
        return view;
    }

    public int kU(int i) {
        int arrowIndex;
        if (this.duP != null && this.duP.axm() && i >= (arrowIndex = this.duP.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean axo() {
        return this.duP != null && this.duP.axm() && axk() + (-1) > this.duP.getArrowIndex();
    }

    public void ga(boolean z) {
        this.duK = z;
    }
}
