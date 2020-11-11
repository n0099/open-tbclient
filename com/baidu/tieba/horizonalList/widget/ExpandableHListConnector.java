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
    private ExpandableListAdapter bAV;
    private int bAX;
    private int bAY = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> bAW = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.bAV != null) {
            this.bAV.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.bAV = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b BU(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.bAW;
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
            if (i > groupMetadata.bBa) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.bAZ) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.bAZ) {
                return b.a(i, 2, groupMetadata.bBb, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.bBa) {
                    return b.a(i, 1, groupMetadata.bBb, i - (groupMetadata.bAZ + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.bBa) + groupMetadata2.bBb;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.bBb - (groupMetadata3.bAZ - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.bAW;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.bBi, aVar.type, aVar.bBi, aVar.bBj, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.bBi > groupMetadata.bBb) {
                i4 = i + 1;
            } else if (aVar.bBi < groupMetadata.bBb) {
                i3 = i - 1;
            } else if (aVar.bBi == groupMetadata.bBb) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.bAZ, aVar.type, aVar.bBi, aVar.bBj, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.bAZ + aVar.bBj + 1, aVar.type, aVar.bBi, aVar.bBj, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.bBi - groupMetadata2.bBb) + groupMetadata2.bBa, aVar.type, aVar.bBi, aVar.bBj, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.bAZ - (groupMetadata3.bBb - aVar.bBi), aVar.type, aVar.bBi, aVar.bBj, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.bAV.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b BU = BU(i);
        com.baidu.tieba.horizonalList.widget.a aVar = BU.jMT;
        boolean isChildSelectable = aVar.type == 1 ? this.bAV.isChildSelectable(aVar.bBi, aVar.bBj) : true;
        BU.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bAV.getGroupCount() + this.bAX;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b BU = BU(i);
        if (BU.jMT.type == 2) {
            child = this.bAV.getGroup(BU.jMT.bBi);
        } else if (BU.jMT.type == 1) {
            child = this.bAV.getChild(BU.jMT.bBi, BU.jMT.bBj);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        BU.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b BU = BU(i);
        long groupId = this.bAV.getGroupId(BU.jMT.bBi);
        if (BU.jMT.type == 2) {
            combinedChildId = this.bAV.getCombinedGroupId(groupId);
        } else if (BU.jMT.type == 1) {
            combinedChildId = this.bAV.getCombinedChildId(groupId, this.bAV.getChildId(BU.jMT.bBi, BU.jMT.bBj));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        BU.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b BU = BU(i);
        if (BU.jMT.type == 2) {
            childView = this.bAV.getGroupView(BU.jMT.bBi, BU.Th(), view, viewGroup);
        } else if (BU.jMT.type == 1) {
            childView = this.bAV.getChildView(BU.jMT.bBi, BU.jMT.bBj, BU.jMU.bBa == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        BU.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b BU = BU(i);
        com.baidu.tieba.horizonalList.widget.a aVar = BU.jMT;
        if (this.bAV instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bAV;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.bBi);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.bBi, aVar.bBj);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        BU.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.bAV instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bAV;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.bAV.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.bAW;
        int size = arrayList.size();
        this.bAX = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int j = j(groupMetadata.bBc, groupMetadata.bBb);
                if (j != groupMetadata.bBb) {
                    if (j == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.bBb = j;
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
            if (groupMetadata2.bBa == -1 || z) {
                childrenCount = this.bAV.getChildrenCount(groupMetadata2.bBb);
            } else {
                childrenCount = groupMetadata2.bBa - groupMetadata2.bAZ;
            }
            this.bAX += childrenCount;
            int i5 = i4 + (groupMetadata2.bBb - i3);
            i3 = groupMetadata2.bBb;
            groupMetadata2.bAZ = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.bBa = i6;
            i++;
            i4 = i6;
        }
    }

    boolean fF(int i) {
        com.baidu.tieba.horizonalList.widget.a D = com.baidu.tieba.horizonalList.widget.a.D(2, i, -1, -1);
        b a2 = a(D);
        D.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.jMU == null) {
            return false;
        }
        this.bAW.remove(bVar.jMU);
        g(false, false);
        notifyDataSetChanged();
        this.bAV.onGroupCollapsed(bVar.jMU.bBb);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.jMT.bBi < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.bAY != 0 && bVar.jMU == null) {
            if (this.bAW.size() >= this.bAY) {
                GroupMetadata groupMetadata = this.bAW.get(0);
                int indexOf = this.bAW.indexOf(groupMetadata);
                fF(groupMetadata.bBb);
                if (bVar.bBh > indexOf) {
                    bVar.bBh--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.jMT.bBi, this.bAV.getGroupId(bVar.jMT.bBi));
            this.bAW.add(bVar.bBh, b2);
            g(false, false);
            notifyDataSetChanged();
            this.bAV.onGroupExpanded(b2.bBb);
            return true;
        }
        return false;
    }

    ExpandableListAdapter Te() {
        return this.bAV;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter Te = Te();
        if (Te instanceof Filterable) {
            return ((Filterable) Te).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> Tf() {
        return this.bAW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.bAV != null) {
            int groupCount = this.bAV.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).bBb >= groupCount) {
                    return;
                }
            }
            this.bAW = arrayList;
            g(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter Te = Te();
        if (Te != null) {
            return Te.isEmpty();
        }
        return true;
    }

    int j(long j, int i) {
        int groupCount = this.bAV.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter Te = Te();
        if (Te == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (Te.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.g(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.g(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ab */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.b(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: BV */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int bAZ;
        int bBa;
        int bBb;
        long bBc;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.bAZ = i;
            groupMetadata.bBa = i2;
            groupMetadata.bBb = i3;
            groupMetadata.bBc = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.bBb - groupMetadata.bBb;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.bAZ);
            parcel.writeInt(this.bBa);
            parcel.writeInt(this.bBb);
            parcel.writeLong(this.bBc);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> bBe = new ArrayList<>(5);
        public int bBh;
        public com.baidu.tieba.horizonalList.widget.a jMT;
        public GroupMetadata jMU;

        private void resetState() {
            if (this.jMT != null) {
                this.jMT.recycle();
                this.jMT = null;
            }
            this.jMU = null;
            this.bBh = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b cMp = cMp();
            cMp.jMT = com.baidu.tieba.horizonalList.widget.a.D(i2, i3, i4, i);
            cMp.jMU = groupMetadata;
            cMp.bBh = i5;
            return cMp;
        }

        private static b cMp() {
            b bVar;
            synchronized (bBe) {
                if (bBe.size() > 0) {
                    bVar = bBe.remove(0);
                    bVar.resetState();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            resetState();
            synchronized (bBe) {
                if (bBe.size() < 5) {
                    bBe.add(this);
                }
            }
        }

        public boolean Th() {
            return this.jMU != null;
        }
    }
}
