package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes3.dex */
public abstract class a extends BaseAdapter {
    private boolean dim = true;
    private f dir;

    public abstract int asA();

    public abstract int asz();

    public abstract View c(int i, View view2, ViewGroup viewGroup);

    public abstract Object kF(int i);

    public abstract long kG(int i);

    public abstract void kH(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (asE()) {
            if (this.dim) {
                return this.dir.getArrowIndex() + 1;
            }
            if (this.dir != null && this.dir.asC()) {
                return asA() + 1;
            }
            return asA();
        }
        return asA();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (asE()) {
            int kI = kI(i);
            if (kI >= 0) {
                return kF(kI);
            }
            return kF(i);
        }
        return kF(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (asE()) {
            int kI = kI(i);
            if (kI >= 0) {
                return kG(kI);
            }
            return kG(i);
        }
        return kG(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(kI(i), view2, viewGroup) : au(view2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (asE() && (arrowIndex = this.dir.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return asE() ? 2 : 1;
    }

    public void a(f fVar) {
        this.dir = fVar;
    }

    private View au(View view2) {
        if (this.dir != null) {
            if (view2 == null || view2 != this.dir.getArrowView()) {
                view2 = this.dir.getArrowView();
                if (view2.getLayoutParams() == null) {
                    view2.setLayoutParams(new AbsListView.LayoutParams(-1, asz()));
                }
            }
            this.dir.at(view2);
        }
        return view2;
    }

    public int kI(int i) {
        int arrowIndex;
        if (this.dir != null && this.dir.asC() && i >= (arrowIndex = this.dir.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean asE() {
        return this.dir != null && this.dir.asC() && asA() + (-1) > this.dir.getArrowIndex();
    }

    public void fN(boolean z) {
        this.dim = z;
    }
}
