package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes9.dex */
public abstract class a extends BaseAdapter {
    private boolean hNT = true;
    private f hNY;

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract int cch();

    public abstract int cci();

    public abstract Object vl(int i);

    public abstract long vm(int i);

    public abstract void vn(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (ccm()) {
            if (this.hNT) {
                return this.hNY.getArrowIndex() + 1;
            }
            if (this.hNY != null && this.hNY.cck()) {
                return cci() + 1;
            }
            return cci();
        }
        return cci();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (ccm()) {
            int vo = vo(i);
            if (vo >= 0) {
                return vl(vo);
            }
            return vl(i);
        }
        return vl(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (ccm()) {
            int vo = vo(i);
            if (vo >= 0) {
                return vm(vo);
            }
            return vm(i);
        }
        return vm(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(vo(i), view, viewGroup) : cb(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (ccm() && (arrowIndex = this.hNY.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return ccm() ? 2 : 1;
    }

    public void a(f fVar) {
        this.hNY = fVar;
    }

    private View cb(View view) {
        if (this.hNY != null) {
            if (view == null || view != this.hNY.getArrowView()) {
                view = this.hNY.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, cch()));
                }
            }
            this.hNY.ca(view);
        }
        return view;
    }

    public int vo(int i) {
        int arrowIndex;
        if (this.hNY != null && this.hNY.cck() && i >= (arrowIndex = this.hNY.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean ccm() {
        return this.hNY != null && this.hNY.cck() && cci() + (-1) > this.hNY.getArrowIndex();
    }

    public void nG(boolean z) {
        this.hNT = z;
    }
}
