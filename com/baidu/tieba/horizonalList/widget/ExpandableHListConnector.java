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
    private ExpandableListAdapter ehv;
    private int ehx;
    private int ehy = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> ehw = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.ehv != null) {
            this.ehv.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.ehv = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b oX(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.ehw;
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
            if (i > groupMetadata.ehA) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.ehz) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.ehz) {
                return b.a(i, 2, groupMetadata.ehB, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.ehA) {
                    return b.a(i, 1, groupMetadata.ehB, i - (groupMetadata.ehz + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.ehA) + groupMetadata2.ehB;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.ehB - (groupMetadata3.ehz - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.b bVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.ehw;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(bVar.ehI, bVar.type, bVar.ehI, bVar.ehJ, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (bVar.ehI > groupMetadata.ehB) {
                i4 = i + 1;
            } else if (bVar.ehI < groupMetadata.ehB) {
                i3 = i - 1;
            } else if (bVar.ehI == groupMetadata.ehB) {
                if (bVar.type == 2) {
                    return b.a(groupMetadata.ehz, bVar.type, bVar.ehI, bVar.ehJ, groupMetadata, i);
                }
                if (bVar.type == 1) {
                    return b.a(groupMetadata.ehz + bVar.ehJ + 1, bVar.type, bVar.ehI, bVar.ehJ, groupMetadata, i);
                }
                return null;
            }
        }
        if (bVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((bVar.ehI - groupMetadata2.ehB) + groupMetadata2.ehA, bVar.type, bVar.ehI, bVar.ehJ, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.ehz - (groupMetadata3.ehB - bVar.ehI), bVar.type, bVar.ehI, bVar.ehJ, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.ehv.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b oX = oX(i);
        com.baidu.tieba.horizonalList.widget.b bVar = oX.ehF;
        boolean isChildSelectable = bVar.type == 1 ? this.ehv.isChildSelectable(bVar.ehI, bVar.ehJ) : true;
        oX.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ehv.getGroupCount() + this.ehx;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b oX = oX(i);
        if (oX.ehF.type == 2) {
            child = this.ehv.getGroup(oX.ehF.ehI);
        } else if (oX.ehF.type == 1) {
            child = this.ehv.getChild(oX.ehF.ehI, oX.ehF.ehJ);
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
        long groupId = this.ehv.getGroupId(oX.ehF.ehI);
        if (oX.ehF.type == 2) {
            combinedChildId = this.ehv.getCombinedGroupId(groupId);
        } else if (oX.ehF.type == 1) {
            combinedChildId = this.ehv.getCombinedChildId(groupId, this.ehv.getChildId(oX.ehF.ehI, oX.ehF.ehJ));
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
        if (oX.ehF.type == 2) {
            childView = this.ehv.getGroupView(oX.ehF.ehI, oX.asC(), view, viewGroup);
        } else if (oX.ehF.type == 1) {
            childView = this.ehv.getChildView(oX.ehF.ehI, oX.ehF.ehJ, oX.ehG.ehA == i, view, viewGroup);
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
        com.baidu.tieba.horizonalList.widget.b bVar = oX.ehF;
        if (this.ehv instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.ehv;
            if (bVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(bVar.ehI);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(bVar.ehI, bVar.ehJ);
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
        if (this.ehv instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.ehv;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.ehv.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.ehw;
        int size = arrayList.size();
        this.ehx = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int i3 = i(groupMetadata.ehC, groupMetadata.ehB);
                if (i3 != groupMetadata.ehB) {
                    if (i3 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.ehB = i3;
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
            if (groupMetadata2.ehA == -1 || z) {
                childrenCount = this.ehv.getChildrenCount(groupMetadata2.ehB);
            } else {
                childrenCount = groupMetadata2.ehA - groupMetadata2.ehz;
            }
            this.ehx += childrenCount;
            int i6 = i5 + (groupMetadata2.ehB - i4);
            i4 = groupMetadata2.ehB;
            groupMetadata2.ehz = i6;
            int i7 = childrenCount + i6;
            groupMetadata2.ehA = i7;
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
        if (bVar.ehG == null) {
            return false;
        }
        this.ehw.remove(bVar.ehG);
        C(false, false);
        notifyDataSetChanged();
        this.ehv.onGroupCollapsed(bVar.ehG.ehB);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.ehF.ehI < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.ehy != 0 && bVar.ehG == null) {
            if (this.ehw.size() >= this.ehy) {
                GroupMetadata groupMetadata = this.ehw.get(0);
                int indexOf = this.ehw.indexOf(groupMetadata);
                collapseGroup(groupMetadata.ehB);
                if (bVar.ehH > indexOf) {
                    bVar.ehH--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.ehF.ehI, this.ehv.getGroupId(bVar.ehF.ehI));
            this.ehw.add(bVar.ehH, a2);
            C(false, false);
            notifyDataSetChanged();
            this.ehv.onGroupExpanded(a2.ehB);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aBR() {
        return this.ehv;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aBR = aBR();
        if (aBR instanceof Filterable) {
            return ((Filterable) aBR).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aBS() {
        return this.ehw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.ehv != null) {
            int groupCount = this.ehv.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).ehB >= groupCount) {
                    return;
                }
            }
            this.ehw = arrayList;
            C(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aBR = aBR();
        if (aBR != null) {
            return aBR.isEmpty();
        }
        return true;
    }

    int i(long j, int i) {
        int groupCount = this.ehv.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aBR = aBR();
        if (aBR == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aBR.getGroupId(i3) != j) {
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
        int ehA;
        int ehB;
        long ehC;
        int ehz;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.ehz = i;
            groupMetadata.ehA = i2;
            groupMetadata.ehB = i3;
            groupMetadata.ehC = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.ehB - groupMetadata.ehB;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.ehz);
            parcel.writeInt(this.ehA);
            parcel.writeInt(this.ehB);
            parcel.writeLong(this.ehC);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> ehE = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.b ehF;
        public GroupMetadata ehG;
        public int ehH;

        private void St() {
            if (this.ehF != null) {
                this.ehF.recycle();
                this.ehF = null;
            }
            this.ehG = null;
            this.ehH = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aBT = aBT();
            aBT.ehF = com.baidu.tieba.horizonalList.widget.b.z(i2, i3, i4, i);
            aBT.ehG = groupMetadata;
            aBT.ehH = i5;
            return aBT;
        }

        private static b aBT() {
            b bVar;
            synchronized (ehE) {
                if (ehE.size() > 0) {
                    bVar = ehE.remove(0);
                    bVar.St();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            St();
            synchronized (ehE) {
                if (ehE.size() < 5) {
                    ehE.add(this);
                }
            }
        }

        public boolean asC() {
            return this.ehG != null;
        }
    }
}
