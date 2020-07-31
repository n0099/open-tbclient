package com.baidu.tieba.ala.liveroom.livepager;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes4.dex */
public class AlaLoopPagerAdapterWrapper extends PagerAdapter {
    private SparseArray<a> gov = new SparseArray<>();
    private boolean gow;
    private PagerAdapter mAdapter;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBoundaryCaching(boolean z) {
        this.gow = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlaLoopPagerAdapterWrapper(PagerAdapter pagerAdapter) {
        this.mAdapter = pagerAdapter;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        if (this.gov != null) {
            this.gov.clear();
        }
        this.gov = new SparseArray<>();
        super.notifyDataSetChanged();
        this.mAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int rP(int i) {
        int bIS = bIS();
        if (bIS == 0) {
            return 0;
        }
        int i2 = (i - 1) % bIS;
        if (i2 < 0) {
            return i2 + bIS;
        }
        return i2;
    }

    public int rQ(int i) {
        return i + 1;
    }

    private int bIQ() {
        return 1;
    }

    private int bIR() {
        return (bIQ() + bIS()) - 1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mAdapter.getCount() + 2;
    }

    public int bIS() {
        return this.mAdapter.getCount();
    }

    public PagerAdapter bIT() {
        return this.mAdapter;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        this.mAdapter.registerDataSetObserver(dataSetObserver);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        super.unregisterDataSetObserver(dataSetObserver);
        this.mAdapter.unregisterDataSetObserver(dataSetObserver);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        a aVar;
        int rP = ((this.mAdapter instanceof FragmentPagerAdapter) || (this.mAdapter instanceof FragmentStatePagerAdapter)) ? i : rP(i);
        if (this.gow && (aVar = this.gov.get(i)) != null) {
            this.gov.remove(i);
            return aVar.object;
        }
        return this.mAdapter.instantiateItem(viewGroup, rP);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        int bIQ = bIQ();
        int bIR = bIR();
        int rP = ((this.mAdapter instanceof FragmentPagerAdapter) || (this.mAdapter instanceof FragmentStatePagerAdapter)) ? i : rP(i);
        if (this.gow && (i == bIQ || i == bIR)) {
            this.gov.put(i, new a(viewGroup, rP, obj));
        } else {
            this.mAdapter.destroyItem(viewGroup, rP, obj);
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        this.mAdapter.finishUpdate(viewGroup);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return this.mAdapter.isViewFromObject(view, obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        this.mAdapter.restoreState(parcelable, classLoader);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Parcelable saveState() {
        return this.mAdapter.saveState();
    }

    @Override // android.support.v4.view.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        this.mAdapter.startUpdate(viewGroup);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        this.mAdapter.setPrimaryItem(viewGroup, i, obj);
    }

    /* loaded from: classes4.dex */
    static class a {
        ViewGroup drb;
        Object object;
        int position;

        public a(ViewGroup viewGroup, int i, Object obj) {
            this.drb = viewGroup;
            this.position = i;
            this.object = obj;
        }
    }
}
