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
    private ExpandableListAdapter bJE;
    private int bJG;
    private int bJH = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> bJF = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.bJE != null) {
            this.bJE.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.bJE = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b Cj(int i) {
        int i2;
        int i3;
        ArrayList<GroupMetadata> arrayList = this.bJF;
        int size = arrayList.size();
        int i4 = size - 1;
        if (size == 0) {
            return b.a(i, 2, i, -1, null, 0);
        }
        int i5 = 0;
        int i6 = 0;
        while (i6 <= i4) {
            int i7 = ((i4 - i6) / 2) + i6;
            GroupMetadata groupMetadata = arrayList.get(i7);
            if (i > groupMetadata.bJJ) {
                i6 = i7 + 1;
                i5 = i7;
            } else if (i < groupMetadata.bJI) {
                i4 = i7 - 1;
                i5 = i7;
            } else if (i == groupMetadata.bJI) {
                return b.a(i, 2, groupMetadata.bJK, -1, groupMetadata, i7);
            } else {
                if (i <= groupMetadata.bJJ) {
                    return b.a(i, 1, groupMetadata.bJK, i - (groupMetadata.bJI + 1), groupMetadata, i7);
                }
                i5 = i7;
            }
        }
        if (i6 > i5) {
            GroupMetadata groupMetadata2 = arrayList.get(i6 - 1);
            i3 = (i - groupMetadata2.bJJ) + groupMetadata2.bJK;
            i2 = i6;
        } else if (i4 < i5) {
            i2 = i4 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.bJK - (groupMetadata3.bJI - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        ArrayList<GroupMetadata> arrayList = this.bJF;
        int size = arrayList.size();
        int i = size - 1;
        if (size == 0) {
            return b.a(aVar.bJR, aVar.type, aVar.bJR, aVar.bJS, null, 0);
        }
        int i2 = 0;
        int i3 = 0;
        while (i3 <= i) {
            int i4 = ((i - i3) / 2) + i3;
            GroupMetadata groupMetadata = arrayList.get(i4);
            if (aVar.bJR > groupMetadata.bJK) {
                i2 = i4;
                i3 = i4 + 1;
            } else if (aVar.bJR < groupMetadata.bJK) {
                i = i4 - 1;
                i2 = i4;
            } else if (aVar.bJR == groupMetadata.bJK) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.bJI, aVar.type, aVar.bJR, aVar.bJS, groupMetadata, i4);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.bJI + aVar.bJS + 1, aVar.type, aVar.bJR, aVar.bJS, groupMetadata, i4);
                }
                return null;
            } else {
                i2 = i4;
            }
        }
        if (aVar.type == 2) {
            if (i3 > i2) {
                GroupMetadata groupMetadata2 = arrayList.get(i3 - 1);
                return b.a((aVar.bJR - groupMetadata2.bJK) + groupMetadata2.bJJ, aVar.type, aVar.bJR, aVar.bJS, null, i3);
            } else if (i < i2) {
                int i5 = i + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.bJI - (groupMetadata3.bJK - aVar.bJR), aVar.type, aVar.bJR, aVar.bJS, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.bJE.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b Cj = Cj(i);
        com.baidu.tieba.horizonalList.widget.a aVar = Cj.kum;
        boolean isChildSelectable = aVar.type == 1 ? this.bJE.isChildSelectable(aVar.bJR, aVar.bJS) : true;
        Cj.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bJE.getGroupCount() + this.bJG;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b Cj = Cj(i);
        if (Cj.kum.type == 2) {
            child = this.bJE.getGroup(Cj.kum.bJR);
        } else if (Cj.kum.type == 1) {
            child = this.bJE.getChild(Cj.kum.bJR, Cj.kum.bJS);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        Cj.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b Cj = Cj(i);
        long groupId = this.bJE.getGroupId(Cj.kum.bJR);
        if (Cj.kum.type == 2) {
            combinedChildId = this.bJE.getCombinedGroupId(groupId);
        } else if (Cj.kum.type == 1) {
            combinedChildId = this.bJE.getCombinedChildId(groupId, this.bJE.getChildId(Cj.kum.bJR, Cj.kum.bJS));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        Cj.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b Cj = Cj(i);
        if (Cj.kum.type == 2) {
            childView = this.bJE.getGroupView(Cj.kum.bJR, Cj.isExpanded(), view, viewGroup);
        } else if (Cj.kum.type == 1) {
            childView = this.bJE.getChildView(Cj.kum.bJR, Cj.kum.bJS, Cj.kun.bJJ == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        Cj.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b Cj = Cj(i);
        com.baidu.tieba.horizonalList.widget.a aVar = Cj.kum;
        if (this.bJE instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bJE;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.bJR);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.bJR, aVar.bJS);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        Cj.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.bJE instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bJE;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.bJE.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        ArrayList<GroupMetadata> arrayList = this.bJF;
        int size = arrayList.size();
        this.bJG = 0;
        if (z2) {
            int i = size - 1;
            boolean z4 = false;
            while (i >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i);
                int k = k(groupMetadata.bJL, groupMetadata.bJK);
                if (k != groupMetadata.bJK) {
                    if (k == -1) {
                        arrayList.remove(i);
                        size--;
                    }
                    groupMetadata.bJK = k;
                    if (!z4) {
                        z3 = true;
                        i--;
                        z4 = z3;
                    }
                }
                z3 = z4;
                i--;
                z4 = z3;
            }
            if (z4) {
                Collections.sort(arrayList);
            }
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < size) {
            GroupMetadata groupMetadata2 = arrayList.get(i2);
            if (groupMetadata2.bJJ == -1 || z) {
                childrenCount = this.bJE.getChildrenCount(groupMetadata2.bJK);
            } else {
                childrenCount = groupMetadata2.bJJ - groupMetadata2.bJI;
            }
            this.bJG += childrenCount;
            int i5 = i4 + (groupMetadata2.bJK - i3);
            int i6 = groupMetadata2.bJK;
            groupMetadata2.bJI = i5;
            int i7 = childrenCount + i5;
            groupMetadata2.bJJ = i7;
            i2++;
            i3 = i6;
            i4 = i7;
        }
    }

    boolean ez(int i) {
        com.baidu.tieba.horizonalList.widget.a H = com.baidu.tieba.horizonalList.widget.a.H(2, i, -1, -1);
        b a2 = a(H);
        H.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.kun == null) {
            return false;
        }
        this.bJF.remove(bVar.kun);
        h(false, false);
        notifyDataSetChanged();
        this.bJE.onGroupCollapsed(bVar.kun.bJK);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.kum.bJR < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.bJH != 0 && bVar.kun == null) {
            if (this.bJF.size() >= this.bJH) {
                GroupMetadata groupMetadata = this.bJF.get(0);
                int indexOf = this.bJF.indexOf(groupMetadata);
                ez(groupMetadata.bJK);
                if (bVar.bJQ > indexOf) {
                    bVar.bJQ--;
                }
            }
            GroupMetadata c = GroupMetadata.c(-1, -1, bVar.kum.bJR, this.bJE.getGroupId(bVar.kum.bJR));
            this.bJF.add(bVar.bJQ, c);
            h(false, false);
            notifyDataSetChanged();
            this.bJE.onGroupExpanded(c.bJK);
            return true;
        }
        return false;
    }

    ExpandableListAdapter TQ() {
        return this.bJE;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter TQ = TQ();
        if (TQ instanceof Filterable) {
            return ((Filterable) TQ).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> TR() {
        return this.bJF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.bJE != null) {
            int groupCount = this.bJE.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).bJK >= groupCount) {
                    return;
                }
            }
            this.bJF = arrayList;
            h(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter TQ = TQ();
        if (TQ != null) {
            return TQ.isEmpty();
        }
        return true;
    }

    int k(long j, int i) {
        int groupCount = this.bJE.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter TQ = TQ();
        if (TQ == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        int i4 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (TQ.getGroupId(i4) != j) {
                boolean z2 = i2 == groupCount + (-1);
                boolean z3 = i3 == 0;
                if (z2 && z3) {
                    break;
                } else if (z3 || (z && !z2)) {
                    int i5 = i2 + 1;
                    z = false;
                    i2 = i5;
                    i4 = i5;
                } else if (z2 || (!z && !z3)) {
                    int i6 = i3 - 1;
                    z = true;
                    i3 = i6;
                    i4 = i6;
                }
            } else {
                return i4;
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
            /* renamed from: Ck */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int bJI;
        int bJJ;
        int bJK;
        long bJL;

        private GroupMetadata() {
        }

        static GroupMetadata c(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.bJI = i;
            groupMetadata.bJJ = i2;
            groupMetadata.bJK = i3;
            groupMetadata.bJL = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.bJK - groupMetadata.bJK;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.bJI);
            parcel.writeInt(this.bJJ);
            parcel.writeInt(this.bJK);
            parcel.writeLong(this.bJL);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> bJN = new ArrayList<>(5);
        public int bJQ;
        public com.baidu.tieba.horizonalList.widget.a kum;
        public GroupMetadata kun;

        private void TS() {
            if (this.kum != null) {
                this.kum.recycle();
                this.kum = null;
            }
            this.kun = null;
            this.bJQ = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b cSN = cSN();
            cSN.kum = com.baidu.tieba.horizonalList.widget.a.H(i2, i3, i4, i);
            cSN.kun = groupMetadata;
            cSN.bJQ = i5;
            return cSN;
        }

        private static b cSN() {
            b bVar;
            synchronized (bJN) {
                if (bJN.size() > 0) {
                    bVar = bJN.remove(0);
                    bVar.TS();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            TS();
            synchronized (bJN) {
                if (bJN.size() < 5) {
                    bJN.add(this);
                }
            }
        }

        public boolean isExpanded() {
            return this.kun != null;
        }
    }
}
