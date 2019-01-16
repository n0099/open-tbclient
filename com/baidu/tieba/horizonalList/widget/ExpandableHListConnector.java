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
    private ExpandableListAdapter eBJ;
    private int eBL;
    private int eBM = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> eBK = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.eBJ != null) {
            this.eBJ.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.eBJ = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b pf(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.eBK;
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
            if (i > groupMetadata.eBO) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.eBN) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.eBN) {
                return b.a(i, 2, groupMetadata.eBP, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.eBO) {
                    return b.a(i, 1, groupMetadata.eBP, i - (groupMetadata.eBN + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.eBO) + groupMetadata2.eBP;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.eBP - (groupMetadata3.eBN - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.eBK;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.eBW, aVar.type, aVar.eBW, aVar.eBX, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.eBW > groupMetadata.eBP) {
                i4 = i + 1;
            } else if (aVar.eBW < groupMetadata.eBP) {
                i3 = i - 1;
            } else if (aVar.eBW == groupMetadata.eBP) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.eBN, aVar.type, aVar.eBW, aVar.eBX, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.eBN + aVar.eBX + 1, aVar.type, aVar.eBW, aVar.eBX, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.eBW - groupMetadata2.eBP) + groupMetadata2.eBO, aVar.type, aVar.eBW, aVar.eBX, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.eBN - (groupMetadata3.eBP - aVar.eBW), aVar.type, aVar.eBW, aVar.eBX, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.eBJ.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b pf = pf(i);
        com.baidu.tieba.horizonalList.widget.a aVar = pf.eBT;
        boolean isChildSelectable = aVar.type == 1 ? this.eBJ.isChildSelectable(aVar.eBW, aVar.eBX) : true;
        pf.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eBJ.getGroupCount() + this.eBL;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b pf = pf(i);
        if (pf.eBT.type == 2) {
            child = this.eBJ.getGroup(pf.eBT.eBW);
        } else if (pf.eBT.type == 1) {
            child = this.eBJ.getChild(pf.eBT.eBW, pf.eBT.eBX);
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
        long groupId = this.eBJ.getGroupId(pf.eBT.eBW);
        if (pf.eBT.type == 2) {
            combinedChildId = this.eBJ.getCombinedGroupId(groupId);
        } else if (pf.eBT.type == 1) {
            combinedChildId = this.eBJ.getCombinedChildId(groupId, this.eBJ.getChildId(pf.eBT.eBW, pf.eBT.eBX));
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
        if (pf.eBT.type == 2) {
            childView = this.eBJ.getGroupView(pf.eBT.eBW, pf.azr(), view, viewGroup);
        } else if (pf.eBT.type == 1) {
            childView = this.eBJ.getChildView(pf.eBT.eBW, pf.eBT.eBX, pf.eBU.eBO == i, view, viewGroup);
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
        com.baidu.tieba.horizonalList.widget.a aVar = pf.eBT;
        if (this.eBJ instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.eBJ;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.eBW);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.eBW, aVar.eBX);
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
        if (this.eBJ instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.eBJ;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.eBJ.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.eBK;
        int size = arrayList.size();
        this.eBL = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int l = l(groupMetadata.eBQ, groupMetadata.eBP);
                if (l != groupMetadata.eBP) {
                    if (l == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.eBP = l;
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
            if (groupMetadata2.eBO == -1 || z) {
                childrenCount = this.eBJ.getChildrenCount(groupMetadata2.eBP);
            } else {
                childrenCount = groupMetadata2.eBO - groupMetadata2.eBN;
            }
            this.eBL += childrenCount;
            int i5 = i4 + (groupMetadata2.eBP - i3);
            i3 = groupMetadata2.eBP;
            groupMetadata2.eBN = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.eBO = i6;
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
        if (bVar.eBU == null) {
            return false;
        }
        this.eBK.remove(bVar.eBU);
        H(false, false);
        notifyDataSetChanged();
        this.eBJ.onGroupCollapsed(bVar.eBU.eBP);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.eBT.eBW < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.eBM != 0 && bVar.eBU == null) {
            if (this.eBK.size() >= this.eBM) {
                GroupMetadata groupMetadata = this.eBK.get(0);
                int indexOf = this.eBK.indexOf(groupMetadata);
                collapseGroup(groupMetadata.eBP);
                if (bVar.eBV > indexOf) {
                    bVar.eBV--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.eBT.eBW, this.eBJ.getGroupId(bVar.eBT.eBW));
            this.eBK.add(bVar.eBV, b2);
            H(false, false);
            notifyDataSetChanged();
            this.eBJ.onGroupExpanded(b2.eBP);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aMY() {
        return this.eBJ;
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
        return this.eBK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.eBJ != null) {
            int groupCount = this.eBJ.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).eBP >= groupCount) {
                    return;
                }
            }
            this.eBK = arrayList;
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
        int groupCount = this.eBJ.getGroupCount();
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
        int eBN;
        int eBO;
        int eBP;
        long eBQ;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.eBN = i;
            groupMetadata.eBO = i2;
            groupMetadata.eBP = i3;
            groupMetadata.eBQ = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.eBP - groupMetadata.eBP;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.eBN);
            parcel.writeInt(this.eBO);
            parcel.writeInt(this.eBP);
            parcel.writeLong(this.eBQ);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> eBS = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a eBT;
        public GroupMetadata eBU;
        public int eBV;

        private void UZ() {
            if (this.eBT != null) {
                this.eBT.recycle();
                this.eBT = null;
            }
            this.eBU = null;
            this.eBV = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aNa = aNa();
            aNa.eBT = com.baidu.tieba.horizonalList.widget.a.t(i2, i3, i4, i);
            aNa.eBU = groupMetadata;
            aNa.eBV = i5;
            return aNa;
        }

        private static b aNa() {
            b bVar;
            synchronized (eBS) {
                if (eBS.size() > 0) {
                    bVar = eBS.remove(0);
                    bVar.UZ();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            UZ();
            synchronized (eBS) {
                if (eBS.size() < 5) {
                    eBS.add(this);
                }
            }
        }

        public boolean azr() {
            return this.eBU != null;
        }
    }
}
