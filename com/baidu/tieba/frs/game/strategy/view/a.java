package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes21.dex */
public abstract class a extends BaseAdapter {
    private boolean iXh = true;
    private f iXm;

    public abstract Object Af(int i);

    public abstract long Ag(int i);

    public abstract void Ah(int i);

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract int cCi();

    public abstract int cCj();

    @Override // android.widget.Adapter
    public int getCount() {
        if (cCn()) {
            if (this.iXh) {
                return this.iXm.getArrowIndex() + 1;
            }
            if (this.iXm != null && this.iXm.cCl()) {
                return cCj() + 1;
            }
            return cCj();
        }
        return cCj();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (cCn()) {
            int Ai = Ai(i);
            if (Ai >= 0) {
                return Af(Ai);
            }
            return Af(i);
        }
        return Af(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (cCn()) {
            int Ai = Ai(i);
            if (Ai >= 0) {
                return Ag(Ai);
            }
            return Ag(i);
        }
        return Ag(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(Ai(i), view, viewGroup) : cJ(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (cCn() && (arrowIndex = this.iXm.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return cCn() ? 2 : 1;
    }

    public void a(f fVar) {
        this.iXm = fVar;
    }

    private View cJ(View view) {
        if (this.iXm != null) {
            if (view == null || view != this.iXm.getArrowView()) {
                view = this.iXm.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, cCi()));
                }
            }
            this.iXm.cI(view);
        }
        return view;
    }

    public int Ai(int i) {
        int arrowIndex;
        if (this.iXm != null && this.iXm.cCl() && i >= (arrowIndex = this.iXm.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean cCn() {
        return this.iXm != null && this.iXm.cCl() && cCj() + (-1) > this.iXm.getArrowIndex();
    }

    public void qg(boolean z) {
        this.iXh = z;
    }
}
