package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes4.dex */
public abstract class a extends BaseAdapter {
    private boolean fHK = true;
    private f fHP;

    public abstract int bnC();

    public abstract int bnD();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object rf(int i);

    public abstract long rg(int i);

    public abstract void rh(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (bnH()) {
            if (this.fHK) {
                return this.fHP.getArrowIndex() + 1;
            }
            if (this.fHP != null && this.fHP.bnF()) {
                return bnD() + 1;
            }
            return bnD();
        }
        return bnD();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (bnH()) {
            int ri = ri(i);
            if (ri >= 0) {
                return rf(ri);
            }
            return rf(i);
        }
        return rf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (bnH()) {
            int ri = ri(i);
            if (ri >= 0) {
                return rg(ri);
            }
            return rg(i);
        }
        return rg(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(ri(i), view, viewGroup) : bS(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (bnH() && (arrowIndex = this.fHP.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return bnH() ? 2 : 1;
    }

    public void a(f fVar) {
        this.fHP = fVar;
    }

    private View bS(View view) {
        if (this.fHP != null) {
            if (view == null || view != this.fHP.getArrowView()) {
                view = this.fHP.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, bnC()));
                }
            }
            this.fHP.bR(view);
        }
        return view;
    }

    public int ri(int i) {
        int arrowIndex;
        if (this.fHP != null && this.fHP.bnF() && i >= (arrowIndex = this.fHP.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean bnH() {
        return this.fHP != null && this.fHP.bnF() && bnD() + (-1) > this.fHP.getArrowIndex();
    }

    public void kq(boolean z) {
        this.fHK = z;
    }
}
