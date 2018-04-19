package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes3.dex */
public abstract class a extends BaseAdapter {
    private boolean dhi = true;
    private f dhn;

    public abstract int asA();

    public abstract int asB();

    public abstract View c(int i, View view2, ViewGroup viewGroup);

    public abstract Object kG(int i);

    public abstract long kH(int i);

    public abstract void kI(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (asF()) {
            if (this.dhi) {
                return this.dhn.getArrowIndex() + 1;
            }
            if (this.dhn != null && this.dhn.asD()) {
                return asB() + 1;
            }
            return asB();
        }
        return asB();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (asF()) {
            int kJ = kJ(i);
            if (kJ >= 0) {
                return kG(kJ);
            }
            return kG(i);
        }
        return kG(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (asF()) {
            int kJ = kJ(i);
            if (kJ >= 0) {
                return kH(kJ);
            }
            return kH(i);
        }
        return kH(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(kJ(i), view2, viewGroup) : au(view2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (asF() && (arrowIndex = this.dhn.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return asF() ? 2 : 1;
    }

    public void a(f fVar) {
        this.dhn = fVar;
    }

    private View au(View view2) {
        if (this.dhn != null) {
            if (view2 == null || view2 != this.dhn.getArrowView()) {
                view2 = this.dhn.getArrowView();
                if (view2.getLayoutParams() == null) {
                    view2.setLayoutParams(new AbsListView.LayoutParams(-1, asA()));
                }
            }
            this.dhn.at(view2);
        }
        return view2;
    }

    public int kJ(int i) {
        int arrowIndex;
        if (this.dhn != null && this.dhn.asD() && i >= (arrowIndex = this.dhn.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean asF() {
        return this.dhn != null && this.dhn.asD() && asB() + (-1) > this.dhn.getArrowIndex();
    }

    public void fM(boolean z) {
        this.dhi = z;
    }
}
