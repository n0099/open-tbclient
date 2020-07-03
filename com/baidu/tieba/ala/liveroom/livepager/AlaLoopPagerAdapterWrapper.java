package com.baidu.tieba.ala.liveroom.livepager;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes3.dex */
public class AlaLoopPagerAdapterWrapper extends PagerAdapter {
    private SparseArray<a> gjw = new SparseArray<>();
    private boolean gjx;
    private PagerAdapter mAdapter;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBoundaryCaching(boolean z) {
        this.gjx = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlaLoopPagerAdapterWrapper(PagerAdapter pagerAdapter) {
        this.mAdapter = pagerAdapter;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void notifyDataSetChanged() {
        if (this.gjw != null) {
            this.gjw.clear();
        }
        this.gjw = new SparseArray<>();
        super.notifyDataSetChanged();
        this.mAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int rz(int i) {
        int bFJ = bFJ();
        if (bFJ == 0) {
            return 0;
        }
        int i2 = (i - 1) % bFJ;
        if (i2 < 0) {
            return i2 + bFJ;
        }
        return i2;
    }

    public int rA(int i) {
        return i + 1;
    }

    private int bFH() {
        return 1;
    }

    private int bFI() {
        return (bFH() + bFJ()) - 1;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mAdapter.getCount() + 2;
    }

    public int bFJ() {
        return this.mAdapter.getCount();
    }

    public PagerAdapter bFK() {
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
        int rz = ((this.mAdapter instanceof FragmentPagerAdapter) || (this.mAdapter instanceof FragmentStatePagerAdapter)) ? i : rz(i);
        if (this.gjx && (aVar = this.gjw.get(i)) != null) {
            this.gjw.remove(i);
            return aVar.object;
        }
        return this.mAdapter.instantiateItem(viewGroup, rz);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        int bFH = bFH();
        int bFI = bFI();
        int rz = ((this.mAdapter instanceof FragmentPagerAdapter) || (this.mAdapter instanceof FragmentStatePagerAdapter)) ? i : rz(i);
        if (this.gjx && (i == bFH || i == bFI)) {
            this.gjw.put(i, new a(viewGroup, rz, obj));
        } else {
            this.mAdapter.destroyItem(viewGroup, rz, obj);
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

    /* loaded from: classes3.dex */
    static class a {
        ViewGroup dlh;
        Object object;
        int position;

        public a(ViewGroup viewGroup, int i, Object obj) {
            this.dlh = viewGroup;
            this.position = i;
            this.object = obj;
        }
    }
}
