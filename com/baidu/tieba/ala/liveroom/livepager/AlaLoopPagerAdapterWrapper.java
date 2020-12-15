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
    private SparseArray<a> hub = new SparseArray<>();
    private boolean huc;
    private PagerAdapter mAdapter;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBoundaryCaching(boolean z) {
        this.huc = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlaLoopPagerAdapterWrapper(PagerAdapter pagerAdapter) {
        this.mAdapter = pagerAdapter;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        if (this.hub != null) {
            this.hub.clear();
        }
        this.hub = new SparseArray<>();
        super.notifyDataSetChanged();
        this.mAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int wN(int i) {
        int cgL = cgL();
        if (cgL == 0) {
            return 0;
        }
        int i2 = (i - 1) % cgL;
        if (i2 < 0) {
            return i2 + cgL;
        }
        return i2;
    }

    public int wO(int i) {
        return i + 1;
    }

    private int cgJ() {
        return 1;
    }

    private int cgK() {
        return (cgJ() + cgL()) - 1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mAdapter.getCount() + 2;
    }

    public int cgL() {
        return this.mAdapter.getCount();
    }

    public PagerAdapter cgM() {
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
        int wN = ((this.mAdapter instanceof FragmentPagerAdapter) || (this.mAdapter instanceof FragmentStatePagerAdapter)) ? i : wN(i);
        if (this.huc && (aVar = this.hub.get(i)) != null) {
            this.hub.remove(i);
            return aVar.object;
        }
        return this.mAdapter.instantiateItem(viewGroup, wN);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        int cgJ = cgJ();
        int cgK = cgK();
        int wN = ((this.mAdapter instanceof FragmentPagerAdapter) || (this.mAdapter instanceof FragmentStatePagerAdapter)) ? i : wN(i);
        if (this.huc && (i == cgJ || i == cgK)) {
            this.hub.put(i, new a(viewGroup, wN, obj));
        } else {
            this.mAdapter.destroyItem(viewGroup, wN, obj);
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
        ViewGroup eiQ;
        Object object;
        int position;

        public a(ViewGroup viewGroup, int i, Object obj) {
            this.eiQ = viewGroup;
            this.position = i;
            this.object = obj;
        }
    }
}
