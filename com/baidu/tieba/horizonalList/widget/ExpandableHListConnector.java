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
    private ExpandableListAdapter fRR;
    private int fRT;
    private int fRU = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> fRS = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.fRR != null) {
            this.fRR.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.fRR = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b sQ(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.fRS;
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
            if (i > groupMetadata.fRW) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.fRV) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.fRV) {
                return b.a(i, 2, groupMetadata.fRX, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.fRW) {
                    return b.a(i, 1, groupMetadata.fRX, i - (groupMetadata.fRV + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.fRW) + groupMetadata2.fRX;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.fRX - (groupMetadata3.fRV - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.fRS;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.fSe, aVar.type, aVar.fSe, aVar.fSf, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.fSe > groupMetadata.fRX) {
                i4 = i + 1;
            } else if (aVar.fSe < groupMetadata.fRX) {
                i3 = i - 1;
            } else if (aVar.fSe == groupMetadata.fRX) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.fRV, aVar.type, aVar.fSe, aVar.fSf, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.fRV + aVar.fSf + 1, aVar.type, aVar.fSe, aVar.fSf, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.fSe - groupMetadata2.fRX) + groupMetadata2.fRW, aVar.type, aVar.fSe, aVar.fSf, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.fRV - (groupMetadata3.fRX - aVar.fSe), aVar.type, aVar.fSe, aVar.fSf, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.fRR.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b sQ = sQ(i);
        com.baidu.tieba.horizonalList.widget.a aVar = sQ.fSb;
        boolean isChildSelectable = aVar.type == 1 ? this.fRR.isChildSelectable(aVar.fSe, aVar.fSf) : true;
        sQ.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fRR.getGroupCount() + this.fRT;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b sQ = sQ(i);
        if (sQ.fSb.type == 2) {
            child = this.fRR.getGroup(sQ.fSb.fSe);
        } else if (sQ.fSb.type == 1) {
            child = this.fRR.getChild(sQ.fSb.fSe, sQ.fSb.fSf);
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
        long groupId = this.fRR.getGroupId(sQ.fSb.fSe);
        if (sQ.fSb.type == 2) {
            combinedChildId = this.fRR.getCombinedGroupId(groupId);
        } else if (sQ.fSb.type == 1) {
            combinedChildId = this.fRR.getCombinedChildId(groupId, this.fRR.getChildId(sQ.fSb.fSe, sQ.fSb.fSf));
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
        if (sQ.fSb.type == 2) {
            childView = this.fRR.getGroupView(sQ.fSb.fSe, sQ.aZS(), view, viewGroup);
        } else if (sQ.fSb.type == 1) {
            childView = this.fRR.getChildView(sQ.fSb.fSe, sQ.fSb.fSf, sQ.fSc.fRW == i, view, viewGroup);
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
        com.baidu.tieba.horizonalList.widget.a aVar = sQ.fSb;
        if (this.fRR instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.fRR;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.fSe);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.fSe, aVar.fSf);
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
        if (this.fRR instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.fRR;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.fRR.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.fRS;
        int size = arrayList.size();
        this.fRT = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int q = q(groupMetadata.fRY, groupMetadata.fRX);
                if (q != groupMetadata.fRX) {
                    if (q == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.fRX = q;
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
            if (groupMetadata2.fRW == -1 || z) {
                childrenCount = this.fRR.getChildrenCount(groupMetadata2.fRX);
            } else {
                childrenCount = groupMetadata2.fRW - groupMetadata2.fRV;
            }
            this.fRT += childrenCount;
            int i5 = i4 + (groupMetadata2.fRX - i3);
            i3 = groupMetadata2.fRX;
            groupMetadata2.fRV = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.fRW = i6;
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
        if (bVar.fSc == null) {
            return false;
        }
        this.fRS.remove(bVar.fSc);
        O(false, false);
        notifyDataSetChanged();
        this.fRR.onGroupCollapsed(bVar.fSc.fRX);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.fSb.fSe < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.fRU != 0 && bVar.fSc == null) {
            if (this.fRS.size() >= this.fRU) {
                GroupMetadata groupMetadata = this.fRS.get(0);
                int indexOf = this.fRS.indexOf(groupMetadata);
                collapseGroup(groupMetadata.fRX);
                if (bVar.fSd > indexOf) {
                    bVar.fSd--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.fSb.fSe, this.fRR.getGroupId(bVar.fSb.fSe));
            this.fRS.add(bVar.fSd, b2);
            O(false, false);
            notifyDataSetChanged();
            this.fRR.onGroupExpanded(b2.fRX);
            return true;
        }
        return false;
    }

    ExpandableListAdapter bnF() {
        return this.fRR;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter bnF = bnF();
        if (bnF instanceof Filterable) {
            return ((Filterable) bnF).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> bnG() {
        return this.fRS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ab(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.fRR != null) {
            int groupCount = this.fRR.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).fRX >= groupCount) {
                    return;
                }
            }
            this.fRS = arrayList;
            O(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter bnF = bnF();
        if (bnF != null) {
            return bnF.isEmpty();
        }
        return true;
    }

    int q(long j, int i) {
        int groupCount = this.fRR.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter bnF = bnF();
        if (bnF == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (bnF.getGroupId(i3) != j) {
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
        int fRV;
        int fRW;
        int fRX;
        long fRY;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.fRV = i;
            groupMetadata.fRW = i2;
            groupMetadata.fRX = i3;
            groupMetadata.fRY = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.fRX - groupMetadata.fRX;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.fRV);
            parcel.writeInt(this.fRW);
            parcel.writeInt(this.fRX);
            parcel.writeLong(this.fRY);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> fSa = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a fSb;
        public GroupMetadata fSc;
        public int fSd;

        private void auZ() {
            if (this.fSb != null) {
                this.fSb.recycle();
                this.fSb = null;
            }
            this.fSc = null;
            this.fSd = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b bnH = bnH();
            bnH.fSb = com.baidu.tieba.horizonalList.widget.a.w(i2, i3, i4, i);
            bnH.fSc = groupMetadata;
            bnH.fSd = i5;
            return bnH;
        }

        private static b bnH() {
            b bVar;
            synchronized (fSa) {
                if (fSa.size() > 0) {
                    bVar = fSa.remove(0);
                    bVar.auZ();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            auZ();
            synchronized (fSa) {
                if (fSa.size() < 5) {
                    fSa.add(this);
                }
            }
        }

        public boolean aZS() {
            return this.fSc != null;
        }
    }
}
