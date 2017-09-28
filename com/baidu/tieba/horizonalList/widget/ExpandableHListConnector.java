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
    private ExpandableListAdapter ddb;
    private int ddd;
    private int dde = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> ddc = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.ddb != null) {
            this.ddb.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.ddb = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b lv(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.ddc;
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
            if (i > groupMetadata.ddg) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.ddf) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.ddf) {
                return b.a(i, 2, groupMetadata.ddh, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.ddg) {
                    return b.a(i, 1, groupMetadata.ddh, i - (groupMetadata.ddf + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.ddg) + groupMetadata2.ddh;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.ddh - (groupMetadata3.ddf - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.b bVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.ddc;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(bVar.ddo, bVar.type, bVar.ddo, bVar.ddp, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (bVar.ddo > groupMetadata.ddh) {
                i4 = i + 1;
            } else if (bVar.ddo < groupMetadata.ddh) {
                i3 = i - 1;
            } else if (bVar.ddo == groupMetadata.ddh) {
                if (bVar.type == 2) {
                    return b.a(groupMetadata.ddf, bVar.type, bVar.ddo, bVar.ddp, groupMetadata, i);
                }
                if (bVar.type == 1) {
                    return b.a(groupMetadata.ddf + bVar.ddp + 1, bVar.type, bVar.ddo, bVar.ddp, groupMetadata, i);
                }
                return null;
            }
        }
        if (bVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((bVar.ddo - groupMetadata2.ddh) + groupMetadata2.ddg, bVar.type, bVar.ddo, bVar.ddp, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.ddf - (groupMetadata3.ddh - bVar.ddo), bVar.type, bVar.ddo, bVar.ddp, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.ddb.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b lv = lv(i);
        com.baidu.tieba.horizonalList.widget.b bVar = lv.ddl;
        boolean isChildSelectable = bVar.type == 1 ? this.ddb.isChildSelectable(bVar.ddo, bVar.ddp) : true;
        lv.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ddb.getGroupCount() + this.ddd;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b lv = lv(i);
        if (lv.ddl.type == 2) {
            child = this.ddb.getGroup(lv.ddl.ddo);
        } else if (lv.ddl.type == 1) {
            child = this.ddb.getChild(lv.ddl.ddo, lv.ddl.ddp);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        lv.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b lv = lv(i);
        long groupId = this.ddb.getGroupId(lv.ddl.ddo);
        if (lv.ddl.type == 2) {
            combinedChildId = this.ddb.getCombinedGroupId(groupId);
        } else if (lv.ddl.type == 1) {
            combinedChildId = this.ddb.getCombinedChildId(groupId, this.ddb.getChildId(lv.ddl.ddo, lv.ddl.ddp));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        lv.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b lv = lv(i);
        if (lv.ddl.type == 2) {
            childView = this.ddb.getGroupView(lv.ddl.ddo, lv.aqr(), view, viewGroup);
        } else if (lv.ddl.type == 1) {
            childView = this.ddb.getChildView(lv.ddl.ddo, lv.ddl.ddp, lv.ddm.ddg == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        lv.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b lv = lv(i);
        com.baidu.tieba.horizonalList.widget.b bVar = lv.ddl;
        if (this.ddb instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.ddb;
            if (bVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(bVar.ddo);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(bVar.ddo, bVar.ddp);
            }
        } else if (bVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        lv.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.ddb instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.ddb;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.ddb.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.ddc;
        int size = arrayList.size();
        this.ddd = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int g = g(groupMetadata.ddi, groupMetadata.ddh);
                if (g != groupMetadata.ddh) {
                    if (g == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.ddh = g;
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
            if (groupMetadata2.ddg == -1 || z) {
                childrenCount = this.ddb.getChildrenCount(groupMetadata2.ddh);
            } else {
                childrenCount = groupMetadata2.ddg - groupMetadata2.ddf;
            }
            this.ddd += childrenCount;
            int i5 = i4 + (groupMetadata2.ddh - i3);
            i3 = groupMetadata2.ddh;
            groupMetadata2.ddf = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.ddg = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b p = com.baidu.tieba.horizonalList.widget.b.p(2, i, -1, -1);
        b a2 = a(p);
        p.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.ddm == null) {
            return false;
        }
        this.ddc.remove(bVar.ddm);
        z(false, false);
        notifyDataSetChanged();
        this.ddb.onGroupCollapsed(bVar.ddm.ddh);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.ddl.ddo < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.dde != 0 && bVar.ddm == null) {
            if (this.ddc.size() >= this.dde) {
                GroupMetadata groupMetadata = this.ddc.get(0);
                int indexOf = this.ddc.indexOf(groupMetadata);
                collapseGroup(groupMetadata.ddh);
                if (bVar.ddn > indexOf) {
                    bVar.ddn--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.ddl.ddo, this.ddb.getGroupId(bVar.ddl.ddo));
            this.ddc.add(bVar.ddn, a2);
            z(false, false);
            notifyDataSetChanged();
            this.ddb.onGroupExpanded(a2.ddh);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aqo() {
        return this.ddb;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aqo = aqo();
        if (aqo instanceof Filterable) {
            return ((Filterable) aqo).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aqp() {
        return this.ddc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.ddb != null) {
            int groupCount = this.ddb.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).ddh >= groupCount) {
                    return;
                }
            }
            this.ddc = arrayList;
            z(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aqo = aqo();
        if (aqo != null) {
            return aqo.isEmpty();
        }
        return true;
    }

    int g(long j, int i) {
        int groupCount = this.ddb.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aqo = aqo();
        if (aqo == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aqo.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.z(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.z(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: n */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: lw */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int ddf;
        int ddg;
        int ddh;
        long ddi;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.ddf = i;
            groupMetadata.ddg = i2;
            groupMetadata.ddh = i3;
            groupMetadata.ddi = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.ddh - groupMetadata.ddh;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.ddf);
            parcel.writeInt(this.ddg);
            parcel.writeInt(this.ddh);
            parcel.writeLong(this.ddi);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> ddk = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.b ddl;
        public GroupMetadata ddm;
        public int ddn;

        private void Kw() {
            if (this.ddl != null) {
                this.ddl.recycle();
                this.ddl = null;
            }
            this.ddm = null;
            this.ddn = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aqq = aqq();
            aqq.ddl = com.baidu.tieba.horizonalList.widget.b.p(i2, i3, i4, i);
            aqq.ddm = groupMetadata;
            aqq.ddn = i5;
            return aqq;
        }

        private static b aqq() {
            b bVar;
            synchronized (ddk) {
                if (ddk.size() > 0) {
                    bVar = ddk.remove(0);
                    bVar.Kw();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            Kw();
            synchronized (ddk) {
                if (ddk.size() < 5) {
                    ddk.add(this);
                }
            }
        }

        public boolean aqr() {
            return this.ddm != null;
        }
    }
}
