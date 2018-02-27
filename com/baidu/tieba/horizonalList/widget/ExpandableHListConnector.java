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
    private ExpandableListAdapter elO;
    private int elQ;
    private int elR = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> elP = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.elO != null) {
            this.elO.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.elO = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b oY(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.elP;
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
            if (i > groupMetadata.elT) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.elS) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.elS) {
                return b.a(i, 2, groupMetadata.elU, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.elT) {
                    return b.a(i, 1, groupMetadata.elU, i - (groupMetadata.elS + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.elT) + groupMetadata2.elU;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.elU - (groupMetadata3.elS - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.b bVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.elP;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(bVar.emb, bVar.type, bVar.emb, bVar.emc, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (bVar.emb > groupMetadata.elU) {
                i4 = i + 1;
            } else if (bVar.emb < groupMetadata.elU) {
                i3 = i - 1;
            } else if (bVar.emb == groupMetadata.elU) {
                if (bVar.type == 2) {
                    return b.a(groupMetadata.elS, bVar.type, bVar.emb, bVar.emc, groupMetadata, i);
                }
                if (bVar.type == 1) {
                    return b.a(groupMetadata.elS + bVar.emc + 1, bVar.type, bVar.emb, bVar.emc, groupMetadata, i);
                }
                return null;
            }
        }
        if (bVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((bVar.emb - groupMetadata2.elU) + groupMetadata2.elT, bVar.type, bVar.emb, bVar.emc, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.elS - (groupMetadata3.elU - bVar.emb), bVar.type, bVar.emb, bVar.emc, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.elO.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b oY = oY(i);
        com.baidu.tieba.horizonalList.widget.b bVar = oY.elY;
        boolean isChildSelectable = bVar.type == 1 ? this.elO.isChildSelectable(bVar.emb, bVar.emc) : true;
        oY.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.elO.getGroupCount() + this.elQ;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b oY = oY(i);
        if (oY.elY.type == 2) {
            child = this.elO.getGroup(oY.elY.emb);
        } else if (oY.elY.type == 1) {
            child = this.elO.getChild(oY.elY.emb, oY.elY.emc);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        oY.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b oY = oY(i);
        long groupId = this.elO.getGroupId(oY.elY.emb);
        if (oY.elY.type == 2) {
            combinedChildId = this.elO.getCombinedGroupId(groupId);
        } else if (oY.elY.type == 1) {
            combinedChildId = this.elO.getCombinedChildId(groupId, this.elO.getChildId(oY.elY.emb, oY.elY.emc));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        oY.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b oY = oY(i);
        if (oY.elY.type == 2) {
            childView = this.elO.getGroupView(oY.elY.emb, oY.atw(), view, viewGroup);
        } else if (oY.elY.type == 1) {
            childView = this.elO.getChildView(oY.elY.emb, oY.elY.emc, oY.elZ.elT == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        oY.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b oY = oY(i);
        com.baidu.tieba.horizonalList.widget.b bVar = oY.elY;
        if (this.elO instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.elO;
            if (bVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(bVar.emb);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(bVar.emb, bVar.emc);
            }
        } else if (bVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        oY.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.elO instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.elO;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.elO.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.elP;
        int size = arrayList.size();
        this.elQ = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int i3 = i(groupMetadata.elV, groupMetadata.elU);
                if (i3 != groupMetadata.elU) {
                    if (i3 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.elU = i3;
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
            if (groupMetadata2.elT == -1 || z) {
                childrenCount = this.elO.getChildrenCount(groupMetadata2.elU);
            } else {
                childrenCount = groupMetadata2.elT - groupMetadata2.elS;
            }
            this.elQ += childrenCount;
            int i6 = i5 + (groupMetadata2.elU - i4);
            i4 = groupMetadata2.elU;
            groupMetadata2.elS = i6;
            int i7 = childrenCount + i6;
            groupMetadata2.elT = i7;
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
        if (bVar.elZ == null) {
            return false;
        }
        this.elP.remove(bVar.elZ);
        D(false, false);
        notifyDataSetChanged();
        this.elO.onGroupCollapsed(bVar.elZ.elU);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.elY.emb < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.elR != 0 && bVar.elZ == null) {
            if (this.elP.size() >= this.elR) {
                GroupMetadata groupMetadata = this.elP.get(0);
                int indexOf = this.elP.indexOf(groupMetadata);
                collapseGroup(groupMetadata.elU);
                if (bVar.ema > indexOf) {
                    bVar.ema--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.elY.emb, this.elO.getGroupId(bVar.elY.emb));
            this.elP.add(bVar.ema, a2);
            D(false, false);
            notifyDataSetChanged();
            this.elO.onGroupExpanded(a2.elU);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aDp() {
        return this.elO;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aDp = aDp();
        if (aDp instanceof Filterable) {
            return ((Filterable) aDp).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aDq() {
        return this.elP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.elO != null) {
            int groupCount = this.elO.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).elU >= groupCount) {
                    return;
                }
            }
            this.elP = arrayList;
            D(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aDp = aDp();
        if (aDp != null) {
            return aDp.isEmpty();
        }
        return true;
    }

    int i(long j, int i) {
        int groupCount = this.elO.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aDp = aDp();
        if (aDp == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aDp.getGroupId(i3) != j) {
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
            /* renamed from: oZ */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int elS;
        int elT;
        int elU;
        long elV;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.elS = i;
            groupMetadata.elT = i2;
            groupMetadata.elU = i3;
            groupMetadata.elV = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.elU - groupMetadata.elU;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.elS);
            parcel.writeInt(this.elT);
            parcel.writeInt(this.elU);
            parcel.writeLong(this.elV);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> elX = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.b elY;
        public GroupMetadata elZ;
        public int ema;

        private void Tb() {
            if (this.elY != null) {
                this.elY.recycle();
                this.elY = null;
            }
            this.elZ = null;
            this.ema = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aDr = aDr();
            aDr.elY = com.baidu.tieba.horizonalList.widget.b.z(i2, i3, i4, i);
            aDr.elZ = groupMetadata;
            aDr.ema = i5;
            return aDr;
        }

        private static b aDr() {
            b bVar;
            synchronized (elX) {
                if (elX.size() > 0) {
                    bVar = elX.remove(0);
                    bVar.Tb();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            Tb();
            synchronized (elX) {
                if (elX.size() < 5) {
                    elX.add(this);
                }
            }
        }

        public boolean atw() {
            return this.elZ != null;
        }
    }
}
