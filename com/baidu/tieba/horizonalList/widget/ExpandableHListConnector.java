package com.baidu.tieba.horizonalList.widget;

import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v7.widget.ActivityChooserView;
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
    private ExpandableListAdapter fRE;
    private int fRG;
    private int fRH = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> fRF = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.fRE != null) {
            this.fRE.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.fRE = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b sM(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.fRF;
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
            if (i > groupMetadata.fRJ) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.fRI) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.fRI) {
                return b.a(i, 2, groupMetadata.fRK, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.fRJ) {
                    return b.a(i, 1, groupMetadata.fRK, i - (groupMetadata.fRI + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.fRJ) + groupMetadata2.fRK;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.fRK - (groupMetadata3.fRI - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.fRF;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.fRR, aVar.type, aVar.fRR, aVar.fRS, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.fRR > groupMetadata.fRK) {
                i4 = i + 1;
            } else if (aVar.fRR < groupMetadata.fRK) {
                i3 = i - 1;
            } else if (aVar.fRR == groupMetadata.fRK) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.fRI, aVar.type, aVar.fRR, aVar.fRS, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.fRI + aVar.fRS + 1, aVar.type, aVar.fRR, aVar.fRS, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.fRR - groupMetadata2.fRK) + groupMetadata2.fRJ, aVar.type, aVar.fRR, aVar.fRS, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.fRI - (groupMetadata3.fRK - aVar.fRR), aVar.type, aVar.fRR, aVar.fRS, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.fRE.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b sM = sM(i);
        com.baidu.tieba.horizonalList.widget.a aVar = sM.fRO;
        boolean isChildSelectable = aVar.type == 1 ? this.fRE.isChildSelectable(aVar.fRR, aVar.fRS) : true;
        sM.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fRE.getGroupCount() + this.fRG;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b sM = sM(i);
        if (sM.fRO.type == 2) {
            child = this.fRE.getGroup(sM.fRO.fRR);
        } else if (sM.fRO.type == 1) {
            child = this.fRE.getChild(sM.fRO.fRR, sM.fRO.fRS);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        sM.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b sM = sM(i);
        long groupId = this.fRE.getGroupId(sM.fRO.fRR);
        if (sM.fRO.type == 2) {
            combinedChildId = this.fRE.getCombinedGroupId(groupId);
        } else if (sM.fRO.type == 1) {
            combinedChildId = this.fRE.getCombinedChildId(groupId, this.fRE.getChildId(sM.fRO.fRR, sM.fRO.fRS));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        sM.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b sM = sM(i);
        if (sM.fRO.type == 2) {
            childView = this.fRE.getGroupView(sM.fRO.fRR, sM.aZO(), view, viewGroup);
        } else if (sM.fRO.type == 1) {
            childView = this.fRE.getChildView(sM.fRO.fRR, sM.fRO.fRS, sM.fRP.fRJ == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        sM.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b sM = sM(i);
        com.baidu.tieba.horizonalList.widget.a aVar = sM.fRO;
        if (this.fRE instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.fRE;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.fRR);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.fRR, aVar.fRS);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        sM.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.fRE instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.fRE;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.fRE.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.fRF;
        int size = arrayList.size();
        this.fRG = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int q = q(groupMetadata.fRL, groupMetadata.fRK);
                if (q != groupMetadata.fRK) {
                    if (q == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.fRK = q;
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
            if (groupMetadata2.fRJ == -1 || z) {
                childrenCount = this.fRE.getChildrenCount(groupMetadata2.fRK);
            } else {
                childrenCount = groupMetadata2.fRJ - groupMetadata2.fRI;
            }
            this.fRG += childrenCount;
            int i5 = i4 + (groupMetadata2.fRK - i3);
            i3 = groupMetadata2.fRK;
            groupMetadata2.fRI = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.fRJ = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a w = com.baidu.tieba.horizonalList.widget.a.w(2, i, -1, -1);
        b a2 = a(w);
        w.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.fRP == null) {
            return false;
        }
        this.fRF.remove(bVar.fRP);
        M(false, false);
        notifyDataSetChanged();
        this.fRE.onGroupCollapsed(bVar.fRP.fRK);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.fRO.fRR < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.fRH != 0 && bVar.fRP == null) {
            if (this.fRF.size() >= this.fRH) {
                GroupMetadata groupMetadata = this.fRF.get(0);
                int indexOf = this.fRF.indexOf(groupMetadata);
                collapseGroup(groupMetadata.fRK);
                if (bVar.fRQ > indexOf) {
                    bVar.fRQ--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.fRO.fRR, this.fRE.getGroupId(bVar.fRO.fRR));
            this.fRF.add(bVar.fRQ, b2);
            M(false, false);
            notifyDataSetChanged();
            this.fRE.onGroupExpanded(b2.fRK);
            return true;
        }
        return false;
    }

    ExpandableListAdapter bnB() {
        return this.fRE;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter bnB = bnB();
        if (bnB instanceof Filterable) {
            return ((Filterable) bnB).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> bnC() {
        return this.fRF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ab(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.fRE != null) {
            int groupCount = this.fRE.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).fRK >= groupCount) {
                    return;
                }
            }
            this.fRF = arrayList;
            M(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter bnB = bnB();
        if (bnB != null) {
            return bnB.isEmpty();
        }
        return true;
    }

    int q(long j, int i) {
        int groupCount = this.fRE.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter bnB = bnB();
        if (bnB == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (bnB.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.M(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.M(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: J */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.b(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: sN */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int fRI;
        int fRJ;
        int fRK;
        long fRL;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.fRI = i;
            groupMetadata.fRJ = i2;
            groupMetadata.fRK = i3;
            groupMetadata.fRL = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.fRK - groupMetadata.fRK;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.fRI);
            parcel.writeInt(this.fRJ);
            parcel.writeInt(this.fRK);
            parcel.writeLong(this.fRL);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> fRN = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a fRO;
        public GroupMetadata fRP;
        public int fRQ;

        private void auV() {
            if (this.fRO != null) {
                this.fRO.recycle();
                this.fRO = null;
            }
            this.fRP = null;
            this.fRQ = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b bnD = bnD();
            bnD.fRO = com.baidu.tieba.horizonalList.widget.a.w(i2, i3, i4, i);
            bnD.fRP = groupMetadata;
            bnD.fRQ = i5;
            return bnD;
        }

        private static b bnD() {
            b bVar;
            synchronized (fRN) {
                if (fRN.size() > 0) {
                    bVar = fRN.remove(0);
                    bVar.auV();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            auV();
            synchronized (fRN) {
                if (fRN.size() < 5) {
                    fRN.add(this);
                }
            }
        }

        public boolean aZO() {
            return this.fRP != null;
        }
    }
}
