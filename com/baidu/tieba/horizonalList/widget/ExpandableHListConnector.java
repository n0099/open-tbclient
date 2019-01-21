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
    private ExpandableListAdapter eBK;
    private int eBM;
    private int eBN = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> eBL = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.eBK != null) {
            this.eBK.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.eBK = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b pf(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.eBL;
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
            if (i > groupMetadata.eBP) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.eBO) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.eBO) {
                return b.a(i, 2, groupMetadata.eBQ, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.eBP) {
                    return b.a(i, 1, groupMetadata.eBQ, i - (groupMetadata.eBO + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.eBP) + groupMetadata2.eBQ;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.eBQ - (groupMetadata3.eBO - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.eBL;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.eBX, aVar.type, aVar.eBX, aVar.eBY, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.eBX > groupMetadata.eBQ) {
                i4 = i + 1;
            } else if (aVar.eBX < groupMetadata.eBQ) {
                i3 = i - 1;
            } else if (aVar.eBX == groupMetadata.eBQ) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.eBO, aVar.type, aVar.eBX, aVar.eBY, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.eBO + aVar.eBY + 1, aVar.type, aVar.eBX, aVar.eBY, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.eBX - groupMetadata2.eBQ) + groupMetadata2.eBP, aVar.type, aVar.eBX, aVar.eBY, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.eBO - (groupMetadata3.eBQ - aVar.eBX), aVar.type, aVar.eBX, aVar.eBY, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.eBK.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b pf = pf(i);
        com.baidu.tieba.horizonalList.widget.a aVar = pf.eBU;
        boolean isChildSelectable = aVar.type == 1 ? this.eBK.isChildSelectable(aVar.eBX, aVar.eBY) : true;
        pf.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eBK.getGroupCount() + this.eBM;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b pf = pf(i);
        if (pf.eBU.type == 2) {
            child = this.eBK.getGroup(pf.eBU.eBX);
        } else if (pf.eBU.type == 1) {
            child = this.eBK.getChild(pf.eBU.eBX, pf.eBU.eBY);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        pf.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b pf = pf(i);
        long groupId = this.eBK.getGroupId(pf.eBU.eBX);
        if (pf.eBU.type == 2) {
            combinedChildId = this.eBK.getCombinedGroupId(groupId);
        } else if (pf.eBU.type == 1) {
            combinedChildId = this.eBK.getCombinedChildId(groupId, this.eBK.getChildId(pf.eBU.eBX, pf.eBU.eBY));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        pf.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b pf = pf(i);
        if (pf.eBU.type == 2) {
            childView = this.eBK.getGroupView(pf.eBU.eBX, pf.azr(), view, viewGroup);
        } else if (pf.eBU.type == 1) {
            childView = this.eBK.getChildView(pf.eBU.eBX, pf.eBU.eBY, pf.eBV.eBP == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        pf.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b pf = pf(i);
        com.baidu.tieba.horizonalList.widget.a aVar = pf.eBU;
        if (this.eBK instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.eBK;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.eBX);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.eBX, aVar.eBY);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        pf.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.eBK instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.eBK;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.eBK.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.eBL;
        int size = arrayList.size();
        this.eBM = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int l = l(groupMetadata.eBR, groupMetadata.eBQ);
                if (l != groupMetadata.eBQ) {
                    if (l == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.eBQ = l;
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
            if (groupMetadata2.eBP == -1 || z) {
                childrenCount = this.eBK.getChildrenCount(groupMetadata2.eBQ);
            } else {
                childrenCount = groupMetadata2.eBP - groupMetadata2.eBO;
            }
            this.eBM += childrenCount;
            int i5 = i4 + (groupMetadata2.eBQ - i3);
            i3 = groupMetadata2.eBQ;
            groupMetadata2.eBO = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.eBP = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a t = com.baidu.tieba.horizonalList.widget.a.t(2, i, -1, -1);
        b a2 = a(t);
        t.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.eBV == null) {
            return false;
        }
        this.eBL.remove(bVar.eBV);
        H(false, false);
        notifyDataSetChanged();
        this.eBK.onGroupCollapsed(bVar.eBV.eBQ);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.eBU.eBX < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.eBN != 0 && bVar.eBV == null) {
            if (this.eBL.size() >= this.eBN) {
                GroupMetadata groupMetadata = this.eBL.get(0);
                int indexOf = this.eBL.indexOf(groupMetadata);
                collapseGroup(groupMetadata.eBQ);
                if (bVar.eBW > indexOf) {
                    bVar.eBW--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.eBU.eBX, this.eBK.getGroupId(bVar.eBU.eBX));
            this.eBL.add(bVar.eBW, b2);
            H(false, false);
            notifyDataSetChanged();
            this.eBK.onGroupExpanded(b2.eBQ);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aMY() {
        return this.eBK;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aMY = aMY();
        if (aMY instanceof Filterable) {
            return ((Filterable) aMY).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aMZ() {
        return this.eBL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.eBK != null) {
            int groupCount = this.eBK.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).eBQ >= groupCount) {
                    return;
                }
            }
            this.eBL = arrayList;
            H(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aMY = aMY();
        if (aMY != null) {
            return aMY.isEmpty();
        }
        return true;
    }

    int l(long j, int i) {
        int groupCount = this.eBK.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aMY = aMY();
        if (aMY == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aMY.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.H(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.H(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: s */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.b(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: pg */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int eBO;
        int eBP;
        int eBQ;
        long eBR;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.eBO = i;
            groupMetadata.eBP = i2;
            groupMetadata.eBQ = i3;
            groupMetadata.eBR = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.eBQ - groupMetadata.eBQ;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.eBO);
            parcel.writeInt(this.eBP);
            parcel.writeInt(this.eBQ);
            parcel.writeLong(this.eBR);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> eBT = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a eBU;
        public GroupMetadata eBV;
        public int eBW;

        private void UZ() {
            if (this.eBU != null) {
                this.eBU.recycle();
                this.eBU = null;
            }
            this.eBV = null;
            this.eBW = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aNa = aNa();
            aNa.eBU = com.baidu.tieba.horizonalList.widget.a.t(i2, i3, i4, i);
            aNa.eBV = groupMetadata;
            aNa.eBW = i5;
            return aNa;
        }

        private static b aNa() {
            b bVar;
            synchronized (eBT) {
                if (eBT.size() > 0) {
                    bVar = eBT.remove(0);
                    bVar.UZ();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            UZ();
            synchronized (eBT) {
                if (eBT.size() < 5) {
                    eBT.add(this);
                }
            }
        }

        public boolean azr() {
            return this.eBV != null;
        }
    }
}
