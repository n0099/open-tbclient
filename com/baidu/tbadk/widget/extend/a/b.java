package com.baidu.tbadk.widget.extend.a;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public abstract class b {
    private DataSetObservable mObservable = new DataSetObservable();

    public abstract int getCount();

    public abstract View getView(int i, ViewGroup viewGroup);

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        try {
            this.mObservable.registerObserver(dataSetObserver);
        } catch (Throwable th) {
        }
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        try {
            this.mObservable.unregisterObserver(dataSetObserver);
        } catch (Throwable th) {
        }
    }

    public void notifyDataSetChanged() {
        this.mObservable.notifyChanged();
    }
}
