package com.baidu.tieba.ala.liveroom.livepager;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
/* loaded from: classes11.dex */
public class AlaLoopPagerAdapterWrapper extends PagerAdapter {
    private SparseArray<a> hFO = new SparseArray<>();
    private boolean hFP;
    private PagerAdapter mAdapter;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBoundaryCaching(boolean z) {
        this.hFP = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AlaLoopPagerAdapterWrapper(PagerAdapter pagerAdapter) {
        this.mAdapter = pagerAdapter;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        if (this.hFO != null) {
            this.hFO.clear();
        }
        this.hFO = new SparseArray<>();
        super.notifyDataSetChanged();
        this.mAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int vD(int i) {
        int cgI = cgI();
        if (cgI == 0) {
            return 0;
        }
        int i2 = (i - 1) % cgI;
        if (i2 < 0) {
            return i2 + cgI;
        }
        return i2;
    }

    public int vE(int i) {
        return i + 1;
    }

    private int cgG() {
        return 1;
    }

    private int cgH() {
        return (cgG() + cgI()) - 1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mAdapter.getCount() + 2;
    }

    public int cgI() {
        return this.mAdapter.getCount();
    }

    public PagerAdapter cgJ() {
        return this.mAdapter;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        super.registerDataSetObserver(dataSetObserver);
        this.mAdapter.registerDataSetObserver(dataSetObserver);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        super.unregisterDataSetObserver(dataSetObserver);
        this.mAdapter.unregisterDataSetObserver(dataSetObserver);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        a aVar;
        int vD = ((this.mAdapter instanceof FragmentPagerAdapter) || (this.mAdapter instanceof FragmentStatePagerAdapter)) ? i : vD(i);
        if (this.hFP && (aVar = this.hFO.get(i)) != null) {
            this.hFO.remove(i);
            return aVar.object;
        }
        return this.mAdapter.instantiateItem(viewGroup, vD);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        int cgG = cgG();
        int cgH = cgH();
        int vD = ((this.mAdapter instanceof FragmentPagerAdapter) || (this.mAdapter instanceof FragmentStatePagerAdapter)) ? i : vD(i);
        if (this.hFP && (i == cgG || i == cgH)) {
            this.hFO.put(i, new a(viewGroup, vD, obj));
        } else {
            this.mAdapter.destroyItem(viewGroup, vD, obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        this.mAdapter.finishUpdate(viewGroup);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return this.mAdapter.isViewFromObject(view, obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        this.mAdapter.restoreState(parcelable, classLoader);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        return this.mAdapter.saveState();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        this.mAdapter.startUpdate(viewGroup);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        this.mAdapter.setPrimaryItem(viewGroup, i, obj);
    }

    /* loaded from: classes11.dex */
    static class a {
        ViewGroup epo;
        Object object;
        int position;

        public a(ViewGroup viewGroup, int i, Object obj) {
            this.epo = viewGroup;
            this.position = i;
            this.object = obj;
        }
    }
}
