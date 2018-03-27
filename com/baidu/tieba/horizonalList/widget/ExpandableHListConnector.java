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
    private ExpandableListAdapter eme;
    private int emg;
    private int emh = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> emf = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.eme != null) {
            this.eme.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.eme = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b oZ(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.emf;
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
            if (i > groupMetadata.emj) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.emi) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.emi) {
                return b.a(i, 2, groupMetadata.emk, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.emj) {
                    return b.a(i, 1, groupMetadata.emk, i - (groupMetadata.emi + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.emj) + groupMetadata2.emk;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.emk - (groupMetadata3.emi - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.b bVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.emf;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(bVar.emr, bVar.type, bVar.emr, bVar.ems, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (bVar.emr > groupMetadata.emk) {
                i4 = i + 1;
            } else if (bVar.emr < groupMetadata.emk) {
                i3 = i - 1;
            } else if (bVar.emr == groupMetadata.emk) {
                if (bVar.type == 2) {
                    return b.a(groupMetadata.emi, bVar.type, bVar.emr, bVar.ems, groupMetadata, i);
                }
                if (bVar.type == 1) {
                    return b.a(groupMetadata.emi + bVar.ems + 1, bVar.type, bVar.emr, bVar.ems, groupMetadata, i);
                }
                return null;
            }
        }
        if (bVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((bVar.emr - groupMetadata2.emk) + groupMetadata2.emj, bVar.type, bVar.emr, bVar.ems, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.emi - (groupMetadata3.emk - bVar.emr), bVar.type, bVar.emr, bVar.ems, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.eme.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b oZ = oZ(i);
        com.baidu.tieba.horizonalList.widget.b bVar = oZ.emo;
        boolean isChildSelectable = bVar.type == 1 ? this.eme.isChildSelectable(bVar.emr, bVar.ems) : true;
        oZ.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eme.getGroupCount() + this.emg;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b oZ = oZ(i);
        if (oZ.emo.type == 2) {
            child = this.eme.getGroup(oZ.emo.emr);
        } else if (oZ.emo.type == 1) {
            child = this.eme.getChild(oZ.emo.emr, oZ.emo.ems);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        oZ.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b oZ = oZ(i);
        long groupId = this.eme.getGroupId(oZ.emo.emr);
        if (oZ.emo.type == 2) {
            combinedChildId = this.eme.getCombinedGroupId(groupId);
        } else if (oZ.emo.type == 1) {
            combinedChildId = this.eme.getCombinedChildId(groupId, this.eme.getChildId(oZ.emo.emr, oZ.emo.ems));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        oZ.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b oZ = oZ(i);
        if (oZ.emo.type == 2) {
            childView = this.eme.getGroupView(oZ.emo.emr, oZ.atx(), view, viewGroup);
        } else if (oZ.emo.type == 1) {
            childView = this.eme.getChildView(oZ.emo.emr, oZ.emo.ems, oZ.emp.emj == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        oZ.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b oZ = oZ(i);
        com.baidu.tieba.horizonalList.widget.b bVar = oZ.emo;
        if (this.eme instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.eme;
            if (bVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(bVar.emr);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(bVar.emr, bVar.ems);
            }
        } else if (bVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        oZ.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.eme instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.eme;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.eme.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.emf;
        int size = arrayList.size();
        this.emg = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int i3 = i(groupMetadata.eml, groupMetadata.emk);
                if (i3 != groupMetadata.emk) {
                    if (i3 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.emk = i3;
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
        int i4 = 0;
        int i5 = 0;
        while (i < size) {
            GroupMetadata groupMetadata2 = arrayList.get(i);
            if (groupMetadata2.emj == -1 || z) {
                childrenCount = this.eme.getChildrenCount(groupMetadata2.emk);
            } else {
                childrenCount = groupMetadata2.emj - groupMetadata2.emi;
            }
            this.emg += childrenCount;
            int i6 = i5 + (groupMetadata2.emk - i4);
            i4 = groupMetadata2.emk;
            groupMetadata2.emi = i6;
            int i7 = childrenCount + i6;
            groupMetadata2.emj = i7;
            i++;
            i5 = i7;
        }
    }

    boolean collapseGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b z = com.baidu.tieba.horizonalList.widget.b.z(2, i, -1, -1);
        b a2 = a(z);
        z.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.emp == null) {
            return false;
        }
        this.emf.remove(bVar.emp);
        D(false, false);
        notifyDataSetChanged();
        this.eme.onGroupCollapsed(bVar.emp.emk);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.emo.emr < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.emh != 0 && bVar.emp == null) {
            if (this.emf.size() >= this.emh) {
                GroupMetadata groupMetadata = this.emf.get(0);
                int indexOf = this.emf.indexOf(groupMetadata);
                collapseGroup(groupMetadata.emk);
                if (bVar.emq > indexOf) {
                    bVar.emq--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.emo.emr, this.eme.getGroupId(bVar.emo.emr));
            this.emf.add(bVar.emq, a2);
            D(false, false);
            notifyDataSetChanged();
            this.eme.onGroupExpanded(a2.emk);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aDq() {
        return this.eme;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aDq = aDq();
        if (aDq instanceof Filterable) {
            return ((Filterable) aDq).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aDr() {
        return this.emf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.eme != null) {
            int groupCount = this.eme.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).emk >= groupCount) {
                    return;
                }
            }
            this.emf = arrayList;
            D(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aDq = aDq();
        if (aDq != null) {
            return aDq.isEmpty();
        }
        return true;
    }

    int i(long j, int i) {
        int groupCount = this.eme.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aDq = aDq();
        if (aDq == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aDq.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.D(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.D(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: E */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: pa */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int emi;
        int emj;
        int emk;
        long eml;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.emi = i;
            groupMetadata.emj = i2;
            groupMetadata.emk = i3;
            groupMetadata.eml = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.emk - groupMetadata.emk;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.emi);
            parcel.writeInt(this.emj);
            parcel.writeInt(this.emk);
            parcel.writeLong(this.eml);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> emn = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.b emo;
        public GroupMetadata emp;
        public int emq;

        private void Tc() {
            if (this.emo != null) {
                this.emo.recycle();
                this.emo = null;
            }
            this.emp = null;
            this.emq = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aDs = aDs();
            aDs.emo = com.baidu.tieba.horizonalList.widget.b.z(i2, i3, i4, i);
            aDs.emp = groupMetadata;
            aDs.emq = i5;
            return aDs;
        }

        private static b aDs() {
            b bVar;
            synchronized (emn) {
                if (emn.size() > 0) {
                    bVar = emn.remove(0);
                    bVar.Tc();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            Tc();
            synchronized (emn) {
                if (emn.size() < 5) {
                    emn.add(this);
                }
            }
        }

        public boolean atx() {
            return this.emp != null;
        }
    }
}
