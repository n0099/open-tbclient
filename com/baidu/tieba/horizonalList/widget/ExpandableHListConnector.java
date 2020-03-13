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
    private ExpandableListAdapter azu;
    private int azw;
    private int azx = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> azv = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.azu != null) {
            this.azu.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.azu = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b vx(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.azv;
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
            if (i > groupMetadata.azz) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.azy) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.azy) {
                return b.a(i, 2, groupMetadata.azA, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.azz) {
                    return b.a(i, 1, groupMetadata.azA, i - (groupMetadata.azy + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.azz) + groupMetadata2.azA;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.azA - (groupMetadata3.azy - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.azv;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.azH, aVar.type, aVar.azH, aVar.azI, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.azH > groupMetadata.azA) {
                i4 = i + 1;
            } else if (aVar.azH < groupMetadata.azA) {
                i3 = i - 1;
            } else if (aVar.azH == groupMetadata.azA) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.azy, aVar.type, aVar.azH, aVar.azI, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.azy + aVar.azI + 1, aVar.type, aVar.azH, aVar.azI, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.azH - groupMetadata2.azA) + groupMetadata2.azz, aVar.type, aVar.azH, aVar.azI, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.azy - (groupMetadata3.azA - aVar.azH), aVar.type, aVar.azH, aVar.azI, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.azu.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b vx = vx(i);
        com.baidu.tieba.horizonalList.widget.a aVar = vx.hjS;
        boolean isChildSelectable = aVar.type == 1 ? this.azu.isChildSelectable(aVar.azH, aVar.azI) : true;
        vx.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.azu.getGroupCount() + this.azw;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b vx = vx(i);
        if (vx.hjS.type == 2) {
            child = this.azu.getGroup(vx.hjS.azH);
        } else if (vx.hjS.type == 1) {
            child = this.azu.getChild(vx.hjS.azH, vx.hjS.azI);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        vx.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b vx = vx(i);
        long groupId = this.azu.getGroupId(vx.hjS.azH);
        if (vx.hjS.type == 2) {
            combinedChildId = this.azu.getCombinedGroupId(groupId);
        } else if (vx.hjS.type == 1) {
            combinedChildId = this.azu.getCombinedChildId(groupId, this.azu.getChildId(vx.hjS.azH, vx.hjS.azI));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        vx.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b vx = vx(i);
        if (vx.hjS.type == 2) {
            childView = this.azu.getGroupView(vx.hjS.azH, vx.zP(), view, viewGroup);
        } else if (vx.hjS.type == 1) {
            childView = this.azu.getChildView(vx.hjS.azH, vx.hjS.azI, vx.hjT.azz == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        vx.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b vx = vx(i);
        com.baidu.tieba.horizonalList.widget.a aVar = vx.hjS;
        if (this.azu instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.azu;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.azH);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.azH, aVar.azI);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        vx.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.azu instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.azu;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.azu.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.azv;
        int size = arrayList.size();
        this.azw = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int b2 = b(groupMetadata.azB, groupMetadata.azA);
                if (b2 != groupMetadata.azA) {
                    if (b2 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.azA = b2;
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
            if (groupMetadata2.azz == -1 || z) {
                childrenCount = this.azu.getChildrenCount(groupMetadata2.azA);
            } else {
                childrenCount = groupMetadata2.azz - groupMetadata2.azy;
            }
            this.azw += childrenCount;
            int i5 = i4 + (groupMetadata2.azA - i3);
            i3 = groupMetadata2.azA;
            groupMetadata2.azy = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.azz = i6;
            i++;
            i4 = i6;
        }
    }

    boolean cv(int i) {
        com.baidu.tieba.horizonalList.widget.a A = com.baidu.tieba.horizonalList.widget.a.A(2, i, -1, -1);
        b a2 = a(A);
        A.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.hjT == null) {
            return false;
        }
        this.azv.remove(bVar.hjT);
        h(false, false);
        notifyDataSetChanged();
        this.azu.onGroupCollapsed(bVar.hjT.azA);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.hjS.azH < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.azx != 0 && bVar.hjT == null) {
            if (this.azv.size() >= this.azx) {
                GroupMetadata groupMetadata = this.azv.get(0);
                int indexOf = this.azv.indexOf(groupMetadata);
                cv(groupMetadata.azA);
                if (bVar.azG > indexOf) {
                    bVar.azG--;
                }
            }
            GroupMetadata c = GroupMetadata.c(-1, -1, bVar.hjS.azH, this.azu.getGroupId(bVar.hjS.azH));
            this.azv.add(bVar.azG, c);
            h(false, false);
            notifyDataSetChanged();
            this.azu.onGroupExpanded(c.azA);
            return true;
        }
        return false;
    }

    ExpandableListAdapter zM() {
        return this.azu;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter zM = zM();
        if (zM instanceof Filterable) {
            return ((Filterable) zM).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> zN() {
        return this.azv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.azu != null) {
            int groupCount = this.azu.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).azA >= groupCount) {
                    return;
                }
            }
            this.azv = arrayList;
            h(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter zM = zM();
        if (zM != null) {
            return zM.isEmpty();
        }
        return true;
    }

    int b(long j, int i) {
        int groupCount = this.azu.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter zM = zM();
        if (zM == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (zM.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.h(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.h(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ac */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.c(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: vy */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int azA;
        long azB;
        int azy;
        int azz;

        private GroupMetadata() {
        }

        static GroupMetadata c(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.azy = i;
            groupMetadata.azz = i2;
            groupMetadata.azA = i3;
            groupMetadata.azB = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.azA - groupMetadata.azA;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.azy);
            parcel.writeInt(this.azz);
            parcel.writeInt(this.azA);
            parcel.writeLong(this.azB);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> azD = new ArrayList<>(5);
        public int azG;
        public com.baidu.tieba.horizonalList.widget.a hjS;
        public GroupMetadata hjT;

        private void resetState() {
            if (this.hjS != null) {
                this.hjS.recycle();
                this.hjS = null;
            }
            this.hjT = null;
            this.azG = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b bPL = bPL();
            bPL.hjS = com.baidu.tieba.horizonalList.widget.a.A(i2, i3, i4, i);
            bPL.hjT = groupMetadata;
            bPL.azG = i5;
            return bPL;
        }

        private static b bPL() {
            b bVar;
            synchronized (azD) {
                if (azD.size() > 0) {
                    bVar = azD.remove(0);
                    bVar.resetState();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            resetState();
            synchronized (azD) {
                if (azD.size() < 5) {
                    azD.add(this);
                }
            }
        }

        public boolean zP() {
            return this.hjT != null;
        }
    }
}
