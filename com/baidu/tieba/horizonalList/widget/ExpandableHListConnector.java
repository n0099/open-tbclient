package com.baidu.tieba.horizonalList.widget;

import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.HeterogeneousExpandableList;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes.dex */
class ExpandableHListConnector extends BaseAdapter implements Filterable {
    private ExpandableListAdapter cDj;
    private int cDl;
    private int cDm = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> cDk = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.cDj != null) {
            this.cDj.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.cDj = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b kn(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.cDk;
        int size = arrayList.size();
        int i5 = size - 1;
        if (size == 0) {
            return b.a(i, 2, i, -1, null, 0);
        }
        int i6 = i5;
        int i7 = 0;
        while (i7 <= i6) {
            i4 = ((i6 - i7) / 2) + i7;
            GroupMetadata groupMetadata = arrayList.get(i4);
            if (i > groupMetadata.cDo) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.cDn) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.cDn) {
                return b.a(i, 2, groupMetadata.cDp, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.cDo) {
                    return b.a(i, 1, groupMetadata.cDp, i - (groupMetadata.cDn + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.cDo) + groupMetadata2.cDp;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.cDp - (groupMetadata3.cDn - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(i iVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cDk;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(iVar.cDw, iVar.type, iVar.cDw, iVar.cDx, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (iVar.cDw > groupMetadata.cDp) {
                i4 = i + 1;
            } else if (iVar.cDw < groupMetadata.cDp) {
                i3 = i - 1;
            } else if (iVar.cDw == groupMetadata.cDp) {
                if (iVar.type == 2) {
                    return b.a(groupMetadata.cDn, iVar.type, iVar.cDw, iVar.cDx, groupMetadata, i);
                }
                if (iVar.type == 1) {
                    return b.a(groupMetadata.cDn + iVar.cDx + 1, iVar.type, iVar.cDw, iVar.cDx, groupMetadata, i);
                }
                return null;
            }
        }
        if (iVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((iVar.cDw - groupMetadata2.cDp) + groupMetadata2.cDo, iVar.type, iVar.cDw, iVar.cDx, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.cDn - (groupMetadata3.cDp - iVar.cDw), iVar.type, iVar.cDw, iVar.cDx, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.cDj.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b kn = kn(i);
        i iVar = kn.cDt;
        boolean isChildSelectable = iVar.type == 1 ? this.cDj.isChildSelectable(iVar.cDw, iVar.cDx) : true;
        kn.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cDj.getGroupCount() + this.cDl;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b kn = kn(i);
        if (kn.cDt.type == 2) {
            child = this.cDj.getGroup(kn.cDt.cDw);
        } else if (kn.cDt.type == 1) {
            child = this.cDj.getChild(kn.cDt.cDw, kn.cDt.cDx);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kn.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b kn = kn(i);
        long groupId = this.cDj.getGroupId(kn.cDt.cDw);
        if (kn.cDt.type == 2) {
            combinedChildId = this.cDj.getCombinedGroupId(groupId);
        } else if (kn.cDt.type == 1) {
            combinedChildId = this.cDj.getCombinedChildId(groupId, this.cDj.getChildId(kn.cDt.cDw, kn.cDt.cDx));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kn.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b kn = kn(i);
        if (kn.cDt.type == 2) {
            childView = this.cDj.getGroupView(kn.cDt.cDw, kn.akV(), view, viewGroup);
        } else if (kn.cDt.type == 1) {
            childView = this.cDj.getChildView(kn.cDt.cDw, kn.cDt.cDx, kn.cDu.cDo == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kn.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b kn = kn(i);
        i iVar = kn.cDt;
        if (this.cDj instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cDj;
            if (iVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(iVar.cDw);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(iVar.cDw, iVar.cDx);
            }
        } else if (iVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        kn.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.cDj instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cDj;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.cDj.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cDk;
        int size = arrayList.size();
        this.cDl = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int h = h(groupMetadata.cDq, groupMetadata.cDp);
                if (h != groupMetadata.cDp) {
                    if (h == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.cDp = h;
                    if (!z4) {
                        z3 = true;
                        i2--;
                        z4 = z3;
                    }
                }
                z3 = z4;
                i2--;
                z4 = z3;
            }
            if (z4) {
                Collections.sort(arrayList);
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i < size) {
            GroupMetadata groupMetadata2 = arrayList.get(i);
            if (groupMetadata2.cDo == -1 || z) {
                childrenCount = this.cDj.getChildrenCount(groupMetadata2.cDp);
            } else {
                childrenCount = groupMetadata2.cDo - groupMetadata2.cDn;
            }
            this.cDl += childrenCount;
            int i5 = i4 + (groupMetadata2.cDp - i3);
            i3 = groupMetadata2.cDp;
            groupMetadata2.cDn = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.cDo = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        i k = i.k(2, i, -1, -1);
        b a2 = a(k);
        k.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.cDu == null) {
            return false;
        }
        this.cDk.remove(bVar.cDu);
        o(false, false);
        notifyDataSetChanged();
        this.cDj.onGroupCollapsed(bVar.cDu.cDp);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.cDt.cDw < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.cDm != 0 && bVar.cDu == null) {
            if (this.cDk.size() >= this.cDm) {
                GroupMetadata groupMetadata = this.cDk.get(0);
                int indexOf = this.cDk.indexOf(groupMetadata);
                collapseGroup(groupMetadata.cDp);
                if (bVar.cDv > indexOf) {
                    bVar.cDv--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.cDt.cDw, this.cDj.getGroupId(bVar.cDt.cDw));
            this.cDk.add(bVar.cDv, a2);
            o(false, false);
            notifyDataSetChanged();
            this.cDj.onGroupExpanded(a2.cDp);
            return true;
        }
        return false;
    }

    ExpandableListAdapter akR() {
        return this.cDj;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter akR = akR();
        if (akR instanceof Filterable) {
            return ((Filterable) akR).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> akS() {
        return this.cDk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.cDj != null) {
            int groupCount = this.cDj.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).cDp >= groupCount) {
                    return;
                }
            }
            this.cDk = arrayList;
            o(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter akR = akR();
        if (akR != null) {
            return akR.isEmpty();
        }
        return true;
    }

    int h(long j, int i) {
        int groupCount = this.cDj.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter akR = akR();
        if (akR == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (akR.getGroupId(i3) != j) {
                boolean z2 = min == groupCount + (-1);
                boolean z3 = i2 == 0;
                if (z2 && z3) {
                    break;
                } else if (z3 || (z && !z2)) {
                    min++;
                    z = false;
                    i3 = min;
                } else if (z2 || (!z && !z3)) {
                    i2--;
                    z = true;
                    i3 = i2;
                }
            } else {
                return i3;
            }
        }
        return -1;
    }

    /* loaded from: classes.dex */
    protected class a extends DataSetObserver {
        protected a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ExpandableHListConnector.this.o(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.o(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new h();
        int cDn;
        int cDo;
        int cDp;
        long cDq;

        private GroupMetadata() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.cDn = i;
            groupMetadata.cDo = i2;
            groupMetadata.cDp = i3;
            groupMetadata.cDq = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.cDp - groupMetadata.cDp;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.cDn);
            parcel.writeInt(this.cDo);
            parcel.writeInt(this.cDp);
            parcel.writeLong(this.cDq);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> cDs = new ArrayList<>(5);
        public i cDt;
        public GroupMetadata cDu;
        public int cDv;

        private void akT() {
            if (this.cDt != null) {
                this.cDt.recycle();
                this.cDt = null;
            }
            this.cDu = null;
            this.cDv = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b akU = akU();
            akU.cDt = i.k(i2, i3, i4, i);
            akU.cDu = groupMetadata;
            akU.cDv = i5;
            return akU;
        }

        private static b akU() {
            b bVar;
            synchronized (cDs) {
                if (cDs.size() > 0) {
                    bVar = cDs.remove(0);
                    bVar.akT();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            akT();
            synchronized (cDs) {
                if (cDs.size() < 5) {
                    cDs.add(this);
                }
            }
        }

        public boolean akV() {
            return this.cDu != null;
        }
    }
}
