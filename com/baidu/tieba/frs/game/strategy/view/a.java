package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes3.dex */
public abstract class a extends BaseAdapter {
    private boolean dMd = true;
    private f dMi;

    public abstract int aDv();

    public abstract int aDw();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object mc(int i);

    public abstract long md(int i);

    public abstract void me(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (aDA()) {
            if (this.dMd) {
                return this.dMi.getArrowIndex() + 1;
            }
            if (this.dMi != null && this.dMi.aDy()) {
                return aDw() + 1;
            }
            return aDw();
        }
        return aDw();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (aDA()) {
            int mf = mf(i);
            if (mf >= 0) {
                return mc(mf);
            }
            return mc(i);
        }
        return mc(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (aDA()) {
            int mf = mf(i);
            if (mf >= 0) {
                return md(mf);
            }
            return md(i);
        }
        return md(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(mf(i), view, viewGroup) : aN(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (aDA() && (arrowIndex = this.dMi.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return aDA() ? 2 : 1;
    }

    public void a(f fVar) {
        this.dMi = fVar;
    }

    private View aN(View view) {
        if (this.dMi != null) {
            if (view == null || view != this.dMi.getArrowView()) {
                view = this.dMi.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, aDv()));
                }
            }
            this.dMi.aM(view);
        }
        return view;
    }

    public int mf(int i) {
        int arrowIndex;
        if (this.dMi != null && this.dMi.aDy() && i >= (arrowIndex = this.dMi.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean aDA() {
        return this.dMi != null && this.dMi.aDy() && aDw() + (-1) > this.dMi.getArrowIndex();
    }

    public void gS(boolean z) {
        this.dMd = z;
    }
}
