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
    private ExpandableListAdapter dSV;
    private int dSX;
    private int dSY = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> dSW = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.dSV != null) {
            this.dSV.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.dSV = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b mI(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.dSW;
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
            if (i > groupMetadata.dTa) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.dSZ) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.dSZ) {
                return b.a(i, 2, groupMetadata.dTb, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.dTa) {
                    return b.a(i, 1, groupMetadata.dTb, i - (groupMetadata.dSZ + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.dTa) + groupMetadata2.dTb;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.dTb - (groupMetadata3.dSZ - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dSW;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.dTi, aVar.type, aVar.dTi, aVar.dTj, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.dTi > groupMetadata.dTb) {
                i4 = i + 1;
            } else if (aVar.dTi < groupMetadata.dTb) {
                i3 = i - 1;
            } else if (aVar.dTi == groupMetadata.dTb) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.dSZ, aVar.type, aVar.dTi, aVar.dTj, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.dSZ + aVar.dTj + 1, aVar.type, aVar.dTi, aVar.dTj, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.dTi - groupMetadata2.dTb) + groupMetadata2.dTa, aVar.type, aVar.dTi, aVar.dTj, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.dSZ - (groupMetadata3.dTb - aVar.dTi), aVar.type, aVar.dTi, aVar.dTj, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.dSV.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b mI = mI(i);
        com.baidu.tieba.horizonalList.widget.a aVar = mI.dTf;
        boolean isChildSelectable = aVar.type == 1 ? this.dSV.isChildSelectable(aVar.dTi, aVar.dTj) : true;
        mI.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dSV.getGroupCount() + this.dSX;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b mI = mI(i);
        if (mI.dTf.type == 2) {
            child = this.dSV.getGroup(mI.dTf.dTi);
        } else if (mI.dTf.type == 1) {
            child = this.dSV.getChild(mI.dTf.dTi, mI.dTf.dTj);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        mI.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b mI = mI(i);
        long groupId = this.dSV.getGroupId(mI.dTf.dTi);
        if (mI.dTf.type == 2) {
            combinedChildId = this.dSV.getCombinedGroupId(groupId);
        } else if (mI.dTf.type == 1) {
            combinedChildId = this.dSV.getCombinedChildId(groupId, this.dSV.getChildId(mI.dTf.dTi, mI.dTf.dTj));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        mI.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b mI = mI(i);
        if (mI.dTf.type == 2) {
            childView = this.dSV.getGroupView(mI.dTf.dTi, mI.arQ(), view, viewGroup);
        } else if (mI.dTf.type == 1) {
            childView = this.dSV.getChildView(mI.dTf.dTi, mI.dTf.dTj, mI.dTg.dTa == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        mI.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b mI = mI(i);
        com.baidu.tieba.horizonalList.widget.a aVar = mI.dTf;
        if (this.dSV instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dSV;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.dTi);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.dTi, aVar.dTj);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        mI.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.dSV instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dSV;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.dSV.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dSW;
        int size = arrayList.size();
        this.dSX = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int i3 = i(groupMetadata.dTc, groupMetadata.dTb);
                if (i3 != groupMetadata.dTb) {
                    if (i3 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.dTb = i3;
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
            if (groupMetadata2.dTa == -1 || z) {
                childrenCount = this.dSV.getChildrenCount(groupMetadata2.dTb);
            } else {
                childrenCount = groupMetadata2.dTa - groupMetadata2.dSZ;
            }
            this.dSX += childrenCount;
            int i6 = i5 + (groupMetadata2.dTb - i4);
            i4 = groupMetadata2.dTb;
            groupMetadata2.dSZ = i6;
            int i7 = childrenCount + i6;
            groupMetadata2.dTa = i7;
            i++;
            i5 = i7;
        }
    }

    boolean collapseGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a s = com.baidu.tieba.horizonalList.widget.a.s(2, i, -1, -1);
        b a2 = a(s);
        s.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.dTg == null) {
            return false;
        }
        this.dSW.remove(bVar.dTg);
        z(false, false);
        notifyDataSetChanged();
        this.dSV.onGroupCollapsed(bVar.dTg.dTb);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.dTf.dTi < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.dSY != 0 && bVar.dTg == null) {
            if (this.dSW.size() >= this.dSY) {
                GroupMetadata groupMetadata = this.dSW.get(0);
                int indexOf = this.dSW.indexOf(groupMetadata);
                collapseGroup(groupMetadata.dTb);
                if (bVar.dTh > indexOf) {
                    bVar.dTh--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.dTf.dTi, this.dSV.getGroupId(bVar.dTf.dTi));
            this.dSW.add(bVar.dTh, a2);
            z(false, false);
            notifyDataSetChanged();
            this.dSV.onGroupExpanded(a2.dTb);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aDh() {
        return this.dSV;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aDh = aDh();
        if (aDh instanceof Filterable) {
            return ((Filterable) aDh).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aDi() {
        return this.dSW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.dSV != null) {
            int groupCount = this.dSV.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).dTb >= groupCount) {
                    return;
                }
            }
            this.dSW = arrayList;
            z(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aDh = aDh();
        if (aDh != null) {
            return aDh.isEmpty();
        }
        return true;
    }

    int i(long j, int i) {
        int groupCount = this.dSV.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aDh = aDh();
        if (aDh == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aDh.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.z(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.z(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: r */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: mJ */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int dSZ;
        int dTa;
        int dTb;
        long dTc;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.dSZ = i;
            groupMetadata.dTa = i2;
            groupMetadata.dTb = i3;
            groupMetadata.dTc = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.dTb - groupMetadata.dTb;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.dSZ);
            parcel.writeInt(this.dTa);
            parcel.writeInt(this.dTb);
            parcel.writeLong(this.dTc);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> dTe = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a dTf;
        public GroupMetadata dTg;
        public int dTh;

        private void OW() {
            if (this.dTf != null) {
                this.dTf.recycle();
                this.dTf = null;
            }
            this.dTg = null;
            this.dTh = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aDj = aDj();
            aDj.dTf = com.baidu.tieba.horizonalList.widget.a.s(i2, i3, i4, i);
            aDj.dTg = groupMetadata;
            aDj.dTh = i5;
            return aDj;
        }

        private static b aDj() {
            b bVar;
            synchronized (dTe) {
                if (dTe.size() > 0) {
                    bVar = dTe.remove(0);
                    bVar.OW();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            OW();
            synchronized (dTe) {
                if (dTe.size() < 5) {
                    dTe.add(this);
                }
            }
        }

        public boolean arQ() {
            return this.dTg != null;
        }
    }
}
