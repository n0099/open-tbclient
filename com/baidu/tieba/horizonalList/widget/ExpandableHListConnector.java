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
    private ExpandableListAdapter cVU;
    private int cVW;
    private int cVX = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> cVV = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.cVU != null) {
            this.cVU.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.cVU = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b kX(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.cVV;
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
            if (i > groupMetadata.cVZ) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.cVY) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.cVY) {
                return b.a(i, 2, groupMetadata.cWa, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.cVZ) {
                    return b.a(i, 1, groupMetadata.cWa, i - (groupMetadata.cVY + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.cVZ) + groupMetadata2.cWa;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.cWa - (groupMetadata3.cVY - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.b bVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cVV;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(bVar.cWh, bVar.type, bVar.cWh, bVar.cWi, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (bVar.cWh > groupMetadata.cWa) {
                i4 = i + 1;
            } else if (bVar.cWh < groupMetadata.cWa) {
                i3 = i - 1;
            } else if (bVar.cWh == groupMetadata.cWa) {
                if (bVar.type == 2) {
                    return b.a(groupMetadata.cVY, bVar.type, bVar.cWh, bVar.cWi, groupMetadata, i);
                }
                if (bVar.type == 1) {
                    return b.a(groupMetadata.cVY + bVar.cWi + 1, bVar.type, bVar.cWh, bVar.cWi, groupMetadata, i);
                }
                return null;
            }
        }
        if (bVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((bVar.cWh - groupMetadata2.cWa) + groupMetadata2.cVZ, bVar.type, bVar.cWh, bVar.cWi, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.cVY - (groupMetadata3.cWa - bVar.cWh), bVar.type, bVar.cWh, bVar.cWi, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.cVU.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b kX = kX(i);
        com.baidu.tieba.horizonalList.widget.b bVar = kX.cWe;
        boolean isChildSelectable = bVar.type == 1 ? this.cVU.isChildSelectable(bVar.cWh, bVar.cWi) : true;
        kX.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cVU.getGroupCount() + this.cVW;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b kX = kX(i);
        if (kX.cWe.type == 2) {
            child = this.cVU.getGroup(kX.cWe.cWh);
        } else if (kX.cWe.type == 1) {
            child = this.cVU.getChild(kX.cWe.cWh, kX.cWe.cWi);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kX.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b kX = kX(i);
        long groupId = this.cVU.getGroupId(kX.cWe.cWh);
        if (kX.cWe.type == 2) {
            combinedChildId = this.cVU.getCombinedGroupId(groupId);
        } else if (kX.cWe.type == 1) {
            combinedChildId = this.cVU.getCombinedChildId(groupId, this.cVU.getChildId(kX.cWe.cWh, kX.cWe.cWi));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kX.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b kX = kX(i);
        if (kX.cWe.type == 2) {
            childView = this.cVU.getGroupView(kX.cWe.cWh, kX.apd(), view, viewGroup);
        } else if (kX.cWe.type == 1) {
            childView = this.cVU.getChildView(kX.cWe.cWh, kX.cWe.cWi, kX.cWf.cVZ == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kX.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b kX = kX(i);
        com.baidu.tieba.horizonalList.widget.b bVar = kX.cWe;
        if (this.cVU instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cVU;
            if (bVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(bVar.cWh);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(bVar.cWh, bVar.cWi);
            }
        } else if (bVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        kX.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.cVU instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cVU;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.cVU.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cVV;
        int size = arrayList.size();
        this.cVW = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int g = g(groupMetadata.cWb, groupMetadata.cWa);
                if (g != groupMetadata.cWa) {
                    if (g == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.cWa = g;
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
            if (groupMetadata2.cVZ == -1 || z) {
                childrenCount = this.cVU.getChildrenCount(groupMetadata2.cWa);
            } else {
                childrenCount = groupMetadata2.cVZ - groupMetadata2.cVY;
            }
            this.cVW += childrenCount;
            int i5 = i4 + (groupMetadata2.cWa - i3);
            i3 = groupMetadata2.cWa;
            groupMetadata2.cVY = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.cVZ = i6;
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
        if (bVar.cWf == null) {
            return false;
        }
        this.cVV.remove(bVar.cWf);
        w(false, false);
        notifyDataSetChanged();
        this.cVU.onGroupCollapsed(bVar.cWf.cWa);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.cWe.cWh < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.cVX != 0 && bVar.cWf == null) {
            if (this.cVV.size() >= this.cVX) {
                GroupMetadata groupMetadata = this.cVV.get(0);
                int indexOf = this.cVV.indexOf(groupMetadata);
                collapseGroup(groupMetadata.cWa);
                if (bVar.cWg > indexOf) {
                    bVar.cWg--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.cWe.cWh, this.cVU.getGroupId(bVar.cWe.cWh));
            this.cVV.add(bVar.cWg, a2);
            w(false, false);
            notifyDataSetChanged();
            this.cVU.onGroupExpanded(a2.cWa);
            return true;
        }
        return false;
    }

    ExpandableListAdapter apa() {
        return this.cVU;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter apa = apa();
        if (apa instanceof Filterable) {
            return ((Filterable) apa).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> apb() {
        return this.cVV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.cVU != null) {
            int groupCount = this.cVU.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).cWa >= groupCount) {
                    return;
                }
            }
            this.cVV = arrayList;
            w(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter apa = apa();
        if (apa != null) {
            return apa.isEmpty();
        }
        return true;
    }

    int g(long j, int i) {
        int groupCount = this.cVU.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter apa = apa();
        if (apa == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (apa.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.w(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.w(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: m */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: kY */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int cVY;
        int cVZ;
        int cWa;
        long cWb;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.cVY = i;
            groupMetadata.cVZ = i2;
            groupMetadata.cWa = i3;
            groupMetadata.cWb = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.cWa - groupMetadata.cWa;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.cVY);
            parcel.writeInt(this.cVZ);
            parcel.writeInt(this.cWa);
            parcel.writeLong(this.cWb);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> cWd = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.b cWe;
        public GroupMetadata cWf;
        public int cWg;

        private void wF() {
            if (this.cWe != null) {
                this.cWe.recycle();
                this.cWe = null;
            }
            this.cWf = null;
            this.cWg = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b apc = apc();
            apc.cWe = com.baidu.tieba.horizonalList.widget.b.m(i2, i3, i4, i);
            apc.cWf = groupMetadata;
            apc.cWg = i5;
            return apc;
        }

        private static b apc() {
            b bVar;
            synchronized (cWd) {
                if (cWd.size() > 0) {
                    bVar = cWd.remove(0);
                    bVar.wF();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            wF();
            synchronized (cWd) {
                if (cWd.size() < 5) {
                    cWd.add(this);
                }
            }
        }

        public boolean apd() {
            return this.cWf != null;
        }
    }
}
