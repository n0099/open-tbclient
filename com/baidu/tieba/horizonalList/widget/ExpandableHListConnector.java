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
    private ExpandableListAdapter dsN;
    private int dsP;
    private int dsQ = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> dsO = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.dsN != null) {
            this.dsN.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.dsN = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b mg(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.dsO;
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
            if (i > groupMetadata.dsS) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.dsR) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.dsR) {
                return b.a(i, 2, groupMetadata.dsT, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.dsS) {
                    return b.a(i, 1, groupMetadata.dsT, i - (groupMetadata.dsR + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.dsS) + groupMetadata2.dsT;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.dsT - (groupMetadata3.dsR - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.b bVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dsO;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(bVar.dta, bVar.type, bVar.dta, bVar.dtb, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (bVar.dta > groupMetadata.dsT) {
                i4 = i + 1;
            } else if (bVar.dta < groupMetadata.dsT) {
                i3 = i - 1;
            } else if (bVar.dta == groupMetadata.dsT) {
                if (bVar.type == 2) {
                    return b.a(groupMetadata.dsR, bVar.type, bVar.dta, bVar.dtb, groupMetadata, i);
                }
                if (bVar.type == 1) {
                    return b.a(groupMetadata.dsR + bVar.dtb + 1, bVar.type, bVar.dta, bVar.dtb, groupMetadata, i);
                }
                return null;
            }
        }
        if (bVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((bVar.dta - groupMetadata2.dsT) + groupMetadata2.dsS, bVar.type, bVar.dta, bVar.dtb, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.dsR - (groupMetadata3.dsT - bVar.dta), bVar.type, bVar.dta, bVar.dtb, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.dsN.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b mg = mg(i);
        com.baidu.tieba.horizonalList.widget.b bVar = mg.dsX;
        boolean isChildSelectable = bVar.type == 1 ? this.dsN.isChildSelectable(bVar.dta, bVar.dtb) : true;
        mg.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dsN.getGroupCount() + this.dsP;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b mg = mg(i);
        if (mg.dsX.type == 2) {
            child = this.dsN.getGroup(mg.dsX.dta);
        } else if (mg.dsX.type == 1) {
            child = this.dsN.getChild(mg.dsX.dta, mg.dsX.dtb);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        mg.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b mg = mg(i);
        long groupId = this.dsN.getGroupId(mg.dsX.dta);
        if (mg.dsX.type == 2) {
            combinedChildId = this.dsN.getCombinedGroupId(groupId);
        } else if (mg.dsX.type == 1) {
            combinedChildId = this.dsN.getCombinedChildId(groupId, this.dsN.getChildId(mg.dsX.dta, mg.dsX.dtb));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        mg.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b mg = mg(i);
        if (mg.dsX.type == 2) {
            childView = this.dsN.getGroupView(mg.dsX.dta, mg.auC(), view, viewGroup);
        } else if (mg.dsX.type == 1) {
            childView = this.dsN.getChildView(mg.dsX.dta, mg.dsX.dtb, mg.dsY.dsS == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        mg.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b mg = mg(i);
        com.baidu.tieba.horizonalList.widget.b bVar = mg.dsX;
        if (this.dsN instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dsN;
            if (bVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(bVar.dta);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(bVar.dta, bVar.dtb);
            }
        } else if (bVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        mg.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.dsN instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dsN;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.dsN.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dsO;
        int size = arrayList.size();
        this.dsP = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int i3 = i(groupMetadata.dsU, groupMetadata.dsT);
                if (i3 != groupMetadata.dsT) {
                    if (i3 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.dsT = i3;
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
            if (groupMetadata2.dsS == -1 || z) {
                childrenCount = this.dsN.getChildrenCount(groupMetadata2.dsT);
            } else {
                childrenCount = groupMetadata2.dsS - groupMetadata2.dsR;
            }
            this.dsP += childrenCount;
            int i6 = i5 + (groupMetadata2.dsT - i4);
            i4 = groupMetadata2.dsT;
            groupMetadata2.dsR = i6;
            int i7 = childrenCount + i6;
            groupMetadata2.dsS = i7;
            i++;
            i5 = i7;
        }
    }

    boolean collapseGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b r = com.baidu.tieba.horizonalList.widget.b.r(2, i, -1, -1);
        b a2 = a(r);
        r.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.dsY == null) {
            return false;
        }
        this.dsO.remove(bVar.dsY);
        A(false, false);
        notifyDataSetChanged();
        this.dsN.onGroupCollapsed(bVar.dsY.dsT);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.dsX.dta < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.dsQ != 0 && bVar.dsY == null) {
            if (this.dsO.size() >= this.dsQ) {
                GroupMetadata groupMetadata = this.dsO.get(0);
                int indexOf = this.dsO.indexOf(groupMetadata);
                collapseGroup(groupMetadata.dsT);
                if (bVar.dsZ > indexOf) {
                    bVar.dsZ--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.dsX.dta, this.dsN.getGroupId(bVar.dsX.dta));
            this.dsO.add(bVar.dsZ, a2);
            A(false, false);
            notifyDataSetChanged();
            this.dsN.onGroupExpanded(a2.dsT);
            return true;
        }
        return false;
    }

    ExpandableListAdapter auz() {
        return this.dsN;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter auz = auz();
        if (auz instanceof Filterable) {
            return ((Filterable) auz).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> auA() {
        return this.dsO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.dsN != null) {
            int groupCount = this.dsN.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).dsT >= groupCount) {
                    return;
                }
            }
            this.dsO = arrayList;
            A(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter auz = auz();
        if (auz != null) {
            return auz.isEmpty();
        }
        return true;
    }

    int i(long j, int i) {
        int groupCount = this.dsN.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter auz = auz();
        if (auz == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (auz.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.A(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.A(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: n */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: mh */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int dsR;
        int dsS;
        int dsT;
        long dsU;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.dsR = i;
            groupMetadata.dsS = i2;
            groupMetadata.dsT = i3;
            groupMetadata.dsU = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.dsT - groupMetadata.dsT;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.dsR);
            parcel.writeInt(this.dsS);
            parcel.writeInt(this.dsT);
            parcel.writeLong(this.dsU);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> dsW = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.b dsX;
        public GroupMetadata dsY;
        public int dsZ;

        private void Lg() {
            if (this.dsX != null) {
                this.dsX.recycle();
                this.dsX = null;
            }
            this.dsY = null;
            this.dsZ = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b auB = auB();
            auB.dsX = com.baidu.tieba.horizonalList.widget.b.r(i2, i3, i4, i);
            auB.dsY = groupMetadata;
            auB.dsZ = i5;
            return auB;
        }

        private static b auB() {
            b bVar;
            synchronized (dsW) {
                if (dsW.size() > 0) {
                    bVar = dsW.remove(0);
                    bVar.Lg();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            Lg();
            synchronized (dsW) {
                if (dsW.size() < 5) {
                    dsW.add(this);
                }
            }
        }

        public boolean auC() {
            return this.dsY != null;
        }
    }
}
