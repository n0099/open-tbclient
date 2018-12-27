package com.baidu.tieba.frs.game.strategy.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes3.dex */
public abstract class a extends BaseAdapter {
    private boolean dWB = true;
    private f dWG;

    public abstract int aFq();

    public abstract int aFr();

    public abstract View c(int i, View view, ViewGroup viewGroup);

    public abstract Object mW(int i);

    public abstract long mX(int i);

    public abstract void mY(int i);

    @Override // android.widget.Adapter
    public int getCount() {
        if (aFv()) {
            if (this.dWB) {
                return this.dWG.getArrowIndex() + 1;
            }
            if (this.dWG != null && this.dWG.aFt()) {
                return aFr() + 1;
            }
            return aFr();
        }
        return aFr();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (aFv()) {
            int mZ = mZ(i);
            if (mZ >= 0) {
                return mW(mZ);
            }
            return mW(i);
        }
        return mW(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (aFv()) {
            int mZ = mZ(i);
            if (mZ >= 0) {
                return mX(mZ);
            }
            return mX(i);
        }
        return mX(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return getItemViewType(i) == 0 ? c(mZ(i), view, viewGroup) : aS(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (aFv() && (arrowIndex = this.dWG.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return aFv() ? 2 : 1;
    }

    public void a(f fVar) {
        this.dWG = fVar;
    }

    private View aS(View view) {
        if (this.dWG != null) {
            if (view == null || view != this.dWG.getArrowView()) {
                view = this.dWG.getArrowView();
                if (view.getLayoutParams() == null) {
                    view.setLayoutParams(new AbsListView.LayoutParams(-1, aFq()));
                }
            }
            this.dWG.aR(view);
        }
        return view;
    }

    public int mZ(int i) {
        int arrowIndex;
        if (this.dWG != null && this.dWG.aFt() && i >= (arrowIndex = this.dWG.getArrowIndex())) {
            if (i == arrowIndex) {
                return -1;
            }
            return i - 1;
        }
        return i;
    }

    public boolean aFv() {
        return this.dWG != null && this.dWG.aFt() && aFr() + (-1) > this.dWG.getArrowIndex();
    }

    public void hg(boolean z) {
        this.dWB = z;
    }
}
