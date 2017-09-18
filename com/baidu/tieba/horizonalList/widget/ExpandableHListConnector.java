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
    private ExpandableListAdapter dgP;
    private int dgR;
    private int dgS = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> dgQ = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.dgP != null) {
            this.dgP.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.dgP = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b lA(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.dgQ;
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
            if (i > groupMetadata.dgU) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.dgT) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.dgT) {
                return b.a(i, 2, groupMetadata.dgV, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.dgU) {
                    return b.a(i, 1, groupMetadata.dgV, i - (groupMetadata.dgT + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.dgU) + groupMetadata2.dgV;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.dgV - (groupMetadata3.dgT - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.b bVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dgQ;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(bVar.dhc, bVar.type, bVar.dhc, bVar.dhd, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (bVar.dhc > groupMetadata.dgV) {
                i4 = i + 1;
            } else if (bVar.dhc < groupMetadata.dgV) {
                i3 = i - 1;
            } else if (bVar.dhc == groupMetadata.dgV) {
                if (bVar.type == 2) {
                    return b.a(groupMetadata.dgT, bVar.type, bVar.dhc, bVar.dhd, groupMetadata, i);
                }
                if (bVar.type == 1) {
                    return b.a(groupMetadata.dgT + bVar.dhd + 1, bVar.type, bVar.dhc, bVar.dhd, groupMetadata, i);
                }
                return null;
            }
        }
        if (bVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((bVar.dhc - groupMetadata2.dgV) + groupMetadata2.dgU, bVar.type, bVar.dhc, bVar.dhd, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.dgT - (groupMetadata3.dgV - bVar.dhc), bVar.type, bVar.dhc, bVar.dhd, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.dgP.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b lA = lA(i);
        com.baidu.tieba.horizonalList.widget.b bVar = lA.dgZ;
        boolean isChildSelectable = bVar.type == 1 ? this.dgP.isChildSelectable(bVar.dhc, bVar.dhd) : true;
        lA.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dgP.getGroupCount() + this.dgR;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b lA = lA(i);
        if (lA.dgZ.type == 2) {
            child = this.dgP.getGroup(lA.dgZ.dhc);
        } else if (lA.dgZ.type == 1) {
            child = this.dgP.getChild(lA.dgZ.dhc, lA.dgZ.dhd);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        lA.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b lA = lA(i);
        long groupId = this.dgP.getGroupId(lA.dgZ.dhc);
        if (lA.dgZ.type == 2) {
            combinedChildId = this.dgP.getCombinedGroupId(groupId);
        } else if (lA.dgZ.type == 1) {
            combinedChildId = this.dgP.getCombinedChildId(groupId, this.dgP.getChildId(lA.dgZ.dhc, lA.dgZ.dhd));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        lA.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b lA = lA(i);
        if (lA.dgZ.type == 2) {
            childView = this.dgP.getGroupView(lA.dgZ.dhc, lA.arL(), view, viewGroup);
        } else if (lA.dgZ.type == 1) {
            childView = this.dgP.getChildView(lA.dgZ.dhc, lA.dgZ.dhd, lA.dha.dgU == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        lA.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b lA = lA(i);
        com.baidu.tieba.horizonalList.widget.b bVar = lA.dgZ;
        if (this.dgP instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dgP;
            if (bVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(bVar.dhc);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(bVar.dhc, bVar.dhd);
            }
        } else if (bVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        lA.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.dgP instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dgP;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.dgP.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dgQ;
        int size = arrayList.size();
        this.dgR = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int g = g(groupMetadata.dgW, groupMetadata.dgV);
                if (g != groupMetadata.dgV) {
                    if (g == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.dgV = g;
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
            if (groupMetadata2.dgU == -1 || z) {
                childrenCount = this.dgP.getChildrenCount(groupMetadata2.dgV);
            } else {
                childrenCount = groupMetadata2.dgU - groupMetadata2.dgT;
            }
            this.dgR += childrenCount;
            int i5 = i4 + (groupMetadata2.dgV - i3);
            i3 = groupMetadata2.dgV;
            groupMetadata2.dgT = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.dgU = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b m = com.baidu.tieba.horizonalList.widget.b.m(2, i, -1, -1);
        b a2 = a(m);
        m.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.dha == null) {
            return false;
        }
        this.dgQ.remove(bVar.dha);
        y(false, false);
        notifyDataSetChanged();
        this.dgP.onGroupCollapsed(bVar.dha.dgV);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.dgZ.dhc < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.dgS != 0 && bVar.dha == null) {
            if (this.dgQ.size() >= this.dgS) {
                GroupMetadata groupMetadata = this.dgQ.get(0);
                int indexOf = this.dgQ.indexOf(groupMetadata);
                collapseGroup(groupMetadata.dgV);
                if (bVar.dhb > indexOf) {
                    bVar.dhb--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.dgZ.dhc, this.dgP.getGroupId(bVar.dgZ.dhc));
            this.dgQ.add(bVar.dhb, a2);
            y(false, false);
            notifyDataSetChanged();
            this.dgP.onGroupExpanded(a2.dgV);
            return true;
        }
        return false;
    }

    ExpandableListAdapter arI() {
        return this.dgP;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter arI = arI();
        if (arI instanceof Filterable) {
            return ((Filterable) arI).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> arJ() {
        return this.dgQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.dgP != null) {
            int groupCount = this.dgP.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).dgV >= groupCount) {
                    return;
                }
            }
            this.dgQ = arrayList;
            y(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter arI = arI();
        if (arI != null) {
            return arI.isEmpty();
        }
        return true;
    }

    int g(long j, int i) {
        int groupCount = this.dgP.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter arI = arI();
        if (arI == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (arI.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.y(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.y(true, true);
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
            /* renamed from: lB */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int dgT;
        int dgU;
        int dgV;
        long dgW;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.dgT = i;
            groupMetadata.dgU = i2;
            groupMetadata.dgV = i3;
            groupMetadata.dgW = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.dgV - groupMetadata.dgV;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.dgT);
            parcel.writeInt(this.dgU);
            parcel.writeInt(this.dgV);
            parcel.writeLong(this.dgW);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> dgY = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.b dgZ;
        public GroupMetadata dha;
        public int dhb;

        private void wN() {
            if (this.dgZ != null) {
                this.dgZ.recycle();
                this.dgZ = null;
            }
            this.dha = null;
            this.dhb = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b arK = arK();
            arK.dgZ = com.baidu.tieba.horizonalList.widget.b.m(i2, i3, i4, i);
            arK.dha = groupMetadata;
            arK.dhb = i5;
            return arK;
        }

        private static b arK() {
            b bVar;
            synchronized (dgY) {
                if (dgY.size() > 0) {
                    bVar = dgY.remove(0);
                    bVar.wN();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            wN();
            synchronized (dgY) {
                if (dgY.size() < 5) {
                    dgY.add(this);
                }
            }
        }

        public boolean arL() {
            return this.dha != null;
        }
    }
}
