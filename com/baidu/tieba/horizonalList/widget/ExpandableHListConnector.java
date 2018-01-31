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
    private ExpandableListAdapter ehQ;
    private int ehS;
    private int ehT = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> ehR = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.ehQ != null) {
            this.ehQ.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.ehQ = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b oX(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.ehR;
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
            if (i > groupMetadata.ehV) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.ehU) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.ehU) {
                return b.a(i, 2, groupMetadata.ehW, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.ehV) {
                    return b.a(i, 1, groupMetadata.ehW, i - (groupMetadata.ehU + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.ehV) + groupMetadata2.ehW;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.ehW - (groupMetadata3.ehU - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.b bVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.ehR;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(bVar.eid, bVar.type, bVar.eid, bVar.eie, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (bVar.eid > groupMetadata.ehW) {
                i4 = i + 1;
            } else if (bVar.eid < groupMetadata.ehW) {
                i3 = i - 1;
            } else if (bVar.eid == groupMetadata.ehW) {
                if (bVar.type == 2) {
                    return b.a(groupMetadata.ehU, bVar.type, bVar.eid, bVar.eie, groupMetadata, i);
                }
                if (bVar.type == 1) {
                    return b.a(groupMetadata.ehU + bVar.eie + 1, bVar.type, bVar.eid, bVar.eie, groupMetadata, i);
                }
                return null;
            }
        }
        if (bVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((bVar.eid - groupMetadata2.ehW) + groupMetadata2.ehV, bVar.type, bVar.eid, bVar.eie, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.ehU - (groupMetadata3.ehW - bVar.eid), bVar.type, bVar.eid, bVar.eie, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.ehQ.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b oX = oX(i);
        com.baidu.tieba.horizonalList.widget.b bVar = oX.eia;
        boolean isChildSelectable = bVar.type == 1 ? this.ehQ.isChildSelectable(bVar.eid, bVar.eie) : true;
        oX.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ehQ.getGroupCount() + this.ehS;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b oX = oX(i);
        if (oX.eia.type == 2) {
            child = this.ehQ.getGroup(oX.eia.eid);
        } else if (oX.eia.type == 1) {
            child = this.ehQ.getChild(oX.eia.eid, oX.eia.eie);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        oX.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b oX = oX(i);
        long groupId = this.ehQ.getGroupId(oX.eia.eid);
        if (oX.eia.type == 2) {
            combinedChildId = this.ehQ.getCombinedGroupId(groupId);
        } else if (oX.eia.type == 1) {
            combinedChildId = this.ehQ.getCombinedChildId(groupId, this.ehQ.getChildId(oX.eia.eid, oX.eia.eie));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        oX.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b oX = oX(i);
        if (oX.eia.type == 2) {
            childView = this.ehQ.getGroupView(oX.eia.eid, oX.asH(), view, viewGroup);
        } else if (oX.eia.type == 1) {
            childView = this.ehQ.getChildView(oX.eia.eid, oX.eia.eie, oX.eib.ehV == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        oX.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b oX = oX(i);
        com.baidu.tieba.horizonalList.widget.b bVar = oX.eia;
        if (this.ehQ instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.ehQ;
            if (bVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(bVar.eid);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(bVar.eid, bVar.eie);
            }
        } else if (bVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        oX.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.ehQ instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.ehQ;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.ehQ.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.ehR;
        int size = arrayList.size();
        this.ehS = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int i3 = i(groupMetadata.ehX, groupMetadata.ehW);
                if (i3 != groupMetadata.ehW) {
                    if (i3 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.ehW = i3;
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
            if (groupMetadata2.ehV == -1 || z) {
                childrenCount = this.ehQ.getChildrenCount(groupMetadata2.ehW);
            } else {
                childrenCount = groupMetadata2.ehV - groupMetadata2.ehU;
            }
            this.ehS += childrenCount;
            int i6 = i5 + (groupMetadata2.ehW - i4);
            i4 = groupMetadata2.ehW;
            groupMetadata2.ehU = i6;
            int i7 = childrenCount + i6;
            groupMetadata2.ehV = i7;
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
        if (bVar.eib == null) {
            return false;
        }
        this.ehR.remove(bVar.eib);
        C(false, false);
        notifyDataSetChanged();
        this.ehQ.onGroupCollapsed(bVar.eib.ehW);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.eia.eid < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.ehT != 0 && bVar.eib == null) {
            if (this.ehR.size() >= this.ehT) {
                GroupMetadata groupMetadata = this.ehR.get(0);
                int indexOf = this.ehR.indexOf(groupMetadata);
                collapseGroup(groupMetadata.ehW);
                if (bVar.eic > indexOf) {
                    bVar.eic--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.eia.eid, this.ehQ.getGroupId(bVar.eia.eid));
            this.ehR.add(bVar.eic, a2);
            C(false, false);
            notifyDataSetChanged();
            this.ehQ.onGroupExpanded(a2.ehW);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aBW() {
        return this.ehQ;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aBW = aBW();
        if (aBW instanceof Filterable) {
            return ((Filterable) aBW).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aBX() {
        return this.ehR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.ehQ != null) {
            int groupCount = this.ehQ.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).ehW >= groupCount) {
                    return;
                }
            }
            this.ehR = arrayList;
            C(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aBW = aBW();
        if (aBW != null) {
            return aBW.isEmpty();
        }
        return true;
    }

    int i(long j, int i) {
        int groupCount = this.ehQ.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aBW = aBW();
        if (aBW == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aBW.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.C(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.C(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: D */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: oY */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int ehU;
        int ehV;
        int ehW;
        long ehX;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.ehU = i;
            groupMetadata.ehV = i2;
            groupMetadata.ehW = i3;
            groupMetadata.ehX = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.ehW - groupMetadata.ehW;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.ehU);
            parcel.writeInt(this.ehV);
            parcel.writeInt(this.ehW);
            parcel.writeLong(this.ehX);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> ehZ = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.b eia;
        public GroupMetadata eib;
        public int eic;

        private void Sv() {
            if (this.eia != null) {
                this.eia.recycle();
                this.eia = null;
            }
            this.eib = null;
            this.eic = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aBY = aBY();
            aBY.eia = com.baidu.tieba.horizonalList.widget.b.z(i2, i3, i4, i);
            aBY.eib = groupMetadata;
            aBY.eic = i5;
            return aBY;
        }

        private static b aBY() {
            b bVar;
            synchronized (ehZ) {
                if (ehZ.size() > 0) {
                    bVar = ehZ.remove(0);
                    bVar.Sv();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            Sv();
            synchronized (ehZ) {
                if (ehZ.size() < 5) {
                    ehZ.add(this);
                }
            }
        }

        public boolean asH() {
            return this.eib != null;
        }
    }
}
