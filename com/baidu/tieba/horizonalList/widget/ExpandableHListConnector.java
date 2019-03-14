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
    private ExpandableListAdapter fRQ;
    private int fRS;
    private int fRT = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> fRR = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.fRQ != null) {
            this.fRQ.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.fRQ = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b sQ(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.fRR;
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
            if (i > groupMetadata.fRV) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.fRU) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.fRU) {
                return b.a(i, 2, groupMetadata.fRW, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.fRV) {
                    return b.a(i, 1, groupMetadata.fRW, i - (groupMetadata.fRU + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.fRV) + groupMetadata2.fRW;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.fRW - (groupMetadata3.fRU - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.fRR;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.fSd, aVar.type, aVar.fSd, aVar.fSe, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.fSd > groupMetadata.fRW) {
                i4 = i + 1;
            } else if (aVar.fSd < groupMetadata.fRW) {
                i3 = i - 1;
            } else if (aVar.fSd == groupMetadata.fRW) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.fRU, aVar.type, aVar.fSd, aVar.fSe, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.fRU + aVar.fSe + 1, aVar.type, aVar.fSd, aVar.fSe, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.fSd - groupMetadata2.fRW) + groupMetadata2.fRV, aVar.type, aVar.fSd, aVar.fSe, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.fRU - (groupMetadata3.fRW - aVar.fSd), aVar.type, aVar.fSd, aVar.fSe, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.fRQ.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b sQ = sQ(i);
        com.baidu.tieba.horizonalList.widget.a aVar = sQ.fSa;
        boolean isChildSelectable = aVar.type == 1 ? this.fRQ.isChildSelectable(aVar.fSd, aVar.fSe) : true;
        sQ.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fRQ.getGroupCount() + this.fRS;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b sQ = sQ(i);
        if (sQ.fSa.type == 2) {
            child = this.fRQ.getGroup(sQ.fSa.fSd);
        } else if (sQ.fSa.type == 1) {
            child = this.fRQ.getChild(sQ.fSa.fSd, sQ.fSa.fSe);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        sQ.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b sQ = sQ(i);
        long groupId = this.fRQ.getGroupId(sQ.fSa.fSd);
        if (sQ.fSa.type == 2) {
            combinedChildId = this.fRQ.getCombinedGroupId(groupId);
        } else if (sQ.fSa.type == 1) {
            combinedChildId = this.fRQ.getCombinedChildId(groupId, this.fRQ.getChildId(sQ.fSa.fSd, sQ.fSa.fSe));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        sQ.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b sQ = sQ(i);
        if (sQ.fSa.type == 2) {
            childView = this.fRQ.getGroupView(sQ.fSa.fSd, sQ.aZR(), view, viewGroup);
        } else if (sQ.fSa.type == 1) {
            childView = this.fRQ.getChildView(sQ.fSa.fSd, sQ.fSa.fSe, sQ.fSb.fRV == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        sQ.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b sQ = sQ(i);
        com.baidu.tieba.horizonalList.widget.a aVar = sQ.fSa;
        if (this.fRQ instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.fRQ;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.fSd);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.fSd, aVar.fSe);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        sQ.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.fRQ instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.fRQ;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.fRQ.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.fRR;
        int size = arrayList.size();
        this.fRS = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int q = q(groupMetadata.fRX, groupMetadata.fRW);
                if (q != groupMetadata.fRW) {
                    if (q == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.fRW = q;
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
            if (groupMetadata2.fRV == -1 || z) {
                childrenCount = this.fRQ.getChildrenCount(groupMetadata2.fRW);
            } else {
                childrenCount = groupMetadata2.fRV - groupMetadata2.fRU;
            }
            this.fRS += childrenCount;
            int i5 = i4 + (groupMetadata2.fRW - i3);
            i3 = groupMetadata2.fRW;
            groupMetadata2.fRU = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.fRV = i6;
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
        if (bVar.fSb == null) {
            return false;
        }
        this.fRR.remove(bVar.fSb);
        O(false, false);
        notifyDataSetChanged();
        this.fRQ.onGroupCollapsed(bVar.fSb.fRW);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.fSa.fSd < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.fRT != 0 && bVar.fSb == null) {
            if (this.fRR.size() >= this.fRT) {
                GroupMetadata groupMetadata = this.fRR.get(0);
                int indexOf = this.fRR.indexOf(groupMetadata);
                collapseGroup(groupMetadata.fRW);
                if (bVar.fSc > indexOf) {
                    bVar.fSc--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.fSa.fSd, this.fRQ.getGroupId(bVar.fSa.fSd));
            this.fRR.add(bVar.fSc, b2);
            O(false, false);
            notifyDataSetChanged();
            this.fRQ.onGroupExpanded(b2.fRW);
            return true;
        }
        return false;
    }

    ExpandableListAdapter bnE() {
        return this.fRQ;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter bnE = bnE();
        if (bnE instanceof Filterable) {
            return ((Filterable) bnE).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> bnF() {
        return this.fRR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ab(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.fRQ != null) {
            int groupCount = this.fRQ.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).fRW >= groupCount) {
                    return;
                }
            }
            this.fRR = arrayList;
            O(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter bnE = bnE();
        if (bnE != null) {
            return bnE.isEmpty();
        }
        return true;
    }

    int q(long j, int i) {
        int groupCount = this.fRQ.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter bnE = bnE();
        if (bnE == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (bnE.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.O(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.O(true, true);
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
            /* renamed from: sR */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int fRU;
        int fRV;
        int fRW;
        long fRX;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.fRU = i;
            groupMetadata.fRV = i2;
            groupMetadata.fRW = i3;
            groupMetadata.fRX = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.fRW - groupMetadata.fRW;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.fRU);
            parcel.writeInt(this.fRV);
            parcel.writeInt(this.fRW);
            parcel.writeLong(this.fRX);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> fRZ = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a fSa;
        public GroupMetadata fSb;
        public int fSc;

        private void auY() {
            if (this.fSa != null) {
                this.fSa.recycle();
                this.fSa = null;
            }
            this.fSb = null;
            this.fSc = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b bnG = bnG();
            bnG.fSa = com.baidu.tieba.horizonalList.widget.a.w(i2, i3, i4, i);
            bnG.fSb = groupMetadata;
            bnG.fSc = i5;
            return bnG;
        }

        private static b bnG() {
            b bVar;
            synchronized (fRZ) {
                if (fRZ.size() > 0) {
                    bVar = fRZ.remove(0);
                    bVar.auY();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            auY();
            synchronized (fRZ) {
                if (fRZ.size() < 5) {
                    fRZ.add(this);
                }
            }
        }

        public boolean aZR() {
            return this.fSb != null;
        }
    }
}
