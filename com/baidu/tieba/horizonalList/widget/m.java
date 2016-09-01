package com.baidu.tieba.horizonalList.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.baidu.tieba.horizonalList.widget.HListView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class m implements Filterable, WrapperListAdapter {
    static final ArrayList<HListView.b> cMf = new ArrayList<>();
    boolean BA;
    private final boolean BB;
    ArrayList<HListView.b> By;
    ArrayList<HListView.b> Bz;
    private final ListAdapter mAdapter;

    public m(ArrayList<HListView.b> arrayList, ArrayList<HListView.b> arrayList2, ListAdapter listAdapter) {
        this.mAdapter = listAdapter;
        this.BB = listAdapter instanceof Filterable;
        if (arrayList == null) {
            this.By = cMf;
        } else {
            this.By = arrayList;
        }
        if (arrayList2 == null) {
            this.Bz = cMf;
        } else {
            this.Bz = arrayList2;
        }
        this.BA = e(this.By) && e(this.Bz);
    }

    public int getHeadersCount() {
        return this.By.size();
    }

    public int getFootersCount() {
        return this.Bz.size();
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        return this.mAdapter == null || this.mAdapter.isEmpty();
    }

    private boolean e(ArrayList<HListView.b> arrayList) {
        if (arrayList != null) {
            Iterator<HListView.b> it = arrayList.iterator();
            while (it.hasNext()) {
                if (!it.next().isSelectable) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mAdapter != null ? getFootersCount() + getHeadersCount() + this.mAdapter.getCount() : getFootersCount() + getHeadersCount();
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        if (this.mAdapter != null) {
            return this.BA && this.mAdapter.areAllItemsEnabled();
        }
        return true;
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i) {
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.By.get(i).isSelectable;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.mAdapter != null && i2 < (i3 = this.mAdapter.getCount())) {
            return this.mAdapter.isEnabled(i2);
        }
        return this.Bz.get(i2 - i3).isSelectable;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.By.get(i).data;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.mAdapter != null && i2 < (i3 = this.mAdapter.getCount())) {
            return this.mAdapter.getItem(i2);
        }
        return this.Bz.get(i2 - i3).data;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        int i2;
        int headersCount = getHeadersCount();
        if (this.mAdapter == null || i < headersCount || (i2 = i - headersCount) >= this.mAdapter.getCount()) {
            return -1L;
        }
        return this.mAdapter.getItemId(i2);
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        if (this.mAdapter != null) {
            return this.mAdapter.hasStableIds();
        }
        return false;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int headersCount = getHeadersCount();
        if (i < headersCount) {
            return this.By.get(i).view;
        }
        int i2 = i - headersCount;
        int i3 = 0;
        if (this.mAdapter != null && i2 < (i3 = this.mAdapter.getCount())) {
            return this.mAdapter.getView(i2, view, viewGroup);
        }
        return this.Bz.get(i2 - i3).view;
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        int headersCount = getHeadersCount();
        if (this.mAdapter == null || i < headersCount || (i2 = i - headersCount) >= this.mAdapter.getCount()) {
            return -2;
        }
        return this.mAdapter.getItemViewType(i2);
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        if (this.mAdapter != null) {
            return this.mAdapter.getViewTypeCount();
        }
        return 1;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.mAdapter != null) {
            this.mAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.BB) {
            return ((Filterable) this.mAdapter).getFilter();
        }
        return null;
    }

    @Override // android.widget.WrapperListAdapter
    public ListAdapter getWrappedAdapter() {
        return this.mAdapter;
    }
}
