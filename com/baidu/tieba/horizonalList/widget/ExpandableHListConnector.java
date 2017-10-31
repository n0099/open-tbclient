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
    private ExpandableListAdapter dkC;
    private int dkE;
    private int dkF = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> dkD = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.dkC != null) {
            this.dkC.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.dkC = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b lL(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.dkD;
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
            if (i > groupMetadata.dkH) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.dkG) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.dkG) {
                return b.a(i, 2, groupMetadata.dkI, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.dkH) {
                    return b.a(i, 1, groupMetadata.dkI, i - (groupMetadata.dkG + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.dkH) + groupMetadata2.dkI;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.dkI - (groupMetadata3.dkG - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.b bVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dkD;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(bVar.dkP, bVar.type, bVar.dkP, bVar.dkQ, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (bVar.dkP > groupMetadata.dkI) {
                i4 = i + 1;
            } else if (bVar.dkP < groupMetadata.dkI) {
                i3 = i - 1;
            } else if (bVar.dkP == groupMetadata.dkI) {
                if (bVar.type == 2) {
                    return b.a(groupMetadata.dkG, bVar.type, bVar.dkP, bVar.dkQ, groupMetadata, i);
                }
                if (bVar.type == 1) {
                    return b.a(groupMetadata.dkG + bVar.dkQ + 1, bVar.type, bVar.dkP, bVar.dkQ, groupMetadata, i);
                }
                return null;
            }
        }
        if (bVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((bVar.dkP - groupMetadata2.dkI) + groupMetadata2.dkH, bVar.type, bVar.dkP, bVar.dkQ, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.dkG - (groupMetadata3.dkI - bVar.dkP), bVar.type, bVar.dkP, bVar.dkQ, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.dkC.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b lL = lL(i);
        com.baidu.tieba.horizonalList.widget.b bVar = lL.dkM;
        boolean isChildSelectable = bVar.type == 1 ? this.dkC.isChildSelectable(bVar.dkP, bVar.dkQ) : true;
        lL.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dkC.getGroupCount() + this.dkE;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b lL = lL(i);
        if (lL.dkM.type == 2) {
            child = this.dkC.getGroup(lL.dkM.dkP);
        } else if (lL.dkM.type == 1) {
            child = this.dkC.getChild(lL.dkM.dkP, lL.dkM.dkQ);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        lL.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b lL = lL(i);
        long groupId = this.dkC.getGroupId(lL.dkM.dkP);
        if (lL.dkM.type == 2) {
            combinedChildId = this.dkC.getCombinedGroupId(groupId);
        } else if (lL.dkM.type == 1) {
            combinedChildId = this.dkC.getCombinedChildId(groupId, this.dkC.getChildId(lL.dkM.dkP, lL.dkM.dkQ));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        lL.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b lL = lL(i);
        if (lL.dkM.type == 2) {
            childView = this.dkC.getGroupView(lL.dkM.dkP, lL.asI(), view, viewGroup);
        } else if (lL.dkM.type == 1) {
            childView = this.dkC.getChildView(lL.dkM.dkP, lL.dkM.dkQ, lL.dkN.dkH == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        lL.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b lL = lL(i);
        com.baidu.tieba.horizonalList.widget.b bVar = lL.dkM;
        if (this.dkC instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dkC;
            if (bVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(bVar.dkP);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(bVar.dkP, bVar.dkQ);
            }
        } else if (bVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        lL.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.dkC instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dkC;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.dkC.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dkD;
        int size = arrayList.size();
        this.dkE = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int i3 = i(groupMetadata.dkJ, groupMetadata.dkI);
                if (i3 != groupMetadata.dkI) {
                    if (i3 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.dkI = i3;
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
            if (groupMetadata2.dkH == -1 || z) {
                childrenCount = this.dkC.getChildrenCount(groupMetadata2.dkI);
            } else {
                childrenCount = groupMetadata2.dkH - groupMetadata2.dkG;
            }
            this.dkE += childrenCount;
            int i6 = i5 + (groupMetadata2.dkI - i4);
            i4 = groupMetadata2.dkI;
            groupMetadata2.dkG = i6;
            int i7 = childrenCount + i6;
            groupMetadata2.dkH = i7;
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
        if (bVar.dkN == null) {
            return false;
        }
        this.dkD.remove(bVar.dkN);
        A(false, false);
        notifyDataSetChanged();
        this.dkC.onGroupCollapsed(bVar.dkN.dkI);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.dkM.dkP < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.dkF != 0 && bVar.dkN == null) {
            if (this.dkD.size() >= this.dkF) {
                GroupMetadata groupMetadata = this.dkD.get(0);
                int indexOf = this.dkD.indexOf(groupMetadata);
                collapseGroup(groupMetadata.dkI);
                if (bVar.dkO > indexOf) {
                    bVar.dkO--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.dkM.dkP, this.dkC.getGroupId(bVar.dkM.dkP));
            this.dkD.add(bVar.dkO, a2);
            A(false, false);
            notifyDataSetChanged();
            this.dkC.onGroupExpanded(a2.dkI);
            return true;
        }
        return false;
    }

    ExpandableListAdapter asF() {
        return this.dkC;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter asF = asF();
        if (asF instanceof Filterable) {
            return ((Filterable) asF).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> asG() {
        return this.dkD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.dkC != null) {
            int groupCount = this.dkC.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).dkI >= groupCount) {
                    return;
                }
            }
            this.dkD = arrayList;
            A(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter asF = asF();
        if (asF != null) {
            return asF.isEmpty();
        }
        return true;
    }

    int i(long j, int i) {
        int groupCount = this.dkC.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter asF = asF();
        if (asF == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (asF.getGroupId(i3) != j) {
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
            /* renamed from: lM */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int dkG;
        int dkH;
        int dkI;
        long dkJ;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.dkG = i;
            groupMetadata.dkH = i2;
            groupMetadata.dkI = i3;
            groupMetadata.dkJ = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.dkI - groupMetadata.dkI;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.dkG);
            parcel.writeInt(this.dkH);
            parcel.writeInt(this.dkI);
            parcel.writeLong(this.dkJ);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> dkL = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.b dkM;
        public GroupMetadata dkN;
        public int dkO;

        private void Kz() {
            if (this.dkM != null) {
                this.dkM.recycle();
                this.dkM = null;
            }
            this.dkN = null;
            this.dkO = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b asH = asH();
            asH.dkM = com.baidu.tieba.horizonalList.widget.b.r(i2, i3, i4, i);
            asH.dkN = groupMetadata;
            asH.dkO = i5;
            return asH;
        }

        private static b asH() {
            b bVar;
            synchronized (dkL) {
                if (dkL.size() > 0) {
                    bVar = dkL.remove(0);
                    bVar.Kz();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            Kz();
            synchronized (dkL) {
                if (dkL.size() < 5) {
                    dkL.add(this);
                }
            }
        }

        public boolean asI() {
            return this.dkN != null;
        }
    }
}
