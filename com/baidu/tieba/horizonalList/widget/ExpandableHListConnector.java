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
    private ExpandableListAdapter amK;
    private int amM;
    private int amN = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> amL = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.amK != null) {
            this.amK.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.amK = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b tl(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.amL;
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
            if (i > groupMetadata.amP) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.amO) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.amO) {
                return b.a(i, 2, groupMetadata.amQ, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.amP) {
                    return b.a(i, 1, groupMetadata.amQ, i - (groupMetadata.amO + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.amP) + groupMetadata2.amQ;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.amQ - (groupMetadata3.amO - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.amL;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.amX, aVar.type, aVar.amX, aVar.amY, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.amX > groupMetadata.amQ) {
                i4 = i + 1;
            } else if (aVar.amX < groupMetadata.amQ) {
                i3 = i - 1;
            } else if (aVar.amX == groupMetadata.amQ) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.amO, aVar.type, aVar.amX, aVar.amY, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.amO + aVar.amY + 1, aVar.type, aVar.amX, aVar.amY, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.amX - groupMetadata2.amQ) + groupMetadata2.amP, aVar.type, aVar.amX, aVar.amY, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.amO - (groupMetadata3.amQ - aVar.amX), aVar.type, aVar.amX, aVar.amY, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.amK.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b tl = tl(i);
        com.baidu.tieba.horizonalList.widget.a aVar = tl.gqO;
        boolean isChildSelectable = aVar.type == 1 ? this.amK.isChildSelectable(aVar.amX, aVar.amY) : true;
        tl.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.amK.getGroupCount() + this.amM;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b tl = tl(i);
        if (tl.gqO.type == 2) {
            child = this.amK.getGroup(tl.gqO.amX);
        } else if (tl.gqO.type == 1) {
            child = this.amK.getChild(tl.gqO.amX, tl.gqO.amY);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        tl.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b tl = tl(i);
        long groupId = this.amK.getGroupId(tl.gqO.amX);
        if (tl.gqO.type == 2) {
            combinedChildId = this.amK.getCombinedGroupId(groupId);
        } else if (tl.gqO.type == 1) {
            combinedChildId = this.amK.getCombinedChildId(groupId, this.amK.getChildId(tl.gqO.amX, tl.gqO.amY));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        tl.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b tl = tl(i);
        if (tl.gqO.type == 2) {
            childView = this.amK.getGroupView(tl.gqO.amX, tl.vh(), view, viewGroup);
        } else if (tl.gqO.type == 1) {
            childView = this.amK.getChildView(tl.gqO.amX, tl.gqO.amY, tl.gqP.amP == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        tl.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b tl = tl(i);
        com.baidu.tieba.horizonalList.widget.a aVar = tl.gqO;
        if (this.amK instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.amK;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.amX);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.amX, aVar.amY);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        tl.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.amK instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.amK;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.amK.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.amL;
        int size = arrayList.size();
        this.amM = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int b2 = b(groupMetadata.amR, groupMetadata.amQ);
                if (b2 != groupMetadata.amQ) {
                    if (b2 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.amQ = b2;
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
            if (groupMetadata2.amP == -1 || z) {
                childrenCount = this.amK.getChildrenCount(groupMetadata2.amQ);
            } else {
                childrenCount = groupMetadata2.amP - groupMetadata2.amO;
            }
            this.amM += childrenCount;
            int i5 = i4 + (groupMetadata2.amQ - i3);
            i3 = groupMetadata2.amQ;
            groupMetadata2.amO = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.amP = i6;
            i++;
            i4 = i6;
        }
    }

    boolean bM(int i) {
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
        if (bVar.gqP == null) {
            return false;
        }
        this.amL.remove(bVar.gqP);
        f(false, false);
        notifyDataSetChanged();
        this.amK.onGroupCollapsed(bVar.gqP.amQ);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.gqO.amX < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.amN != 0 && bVar.gqP == null) {
            if (this.amL.size() >= this.amN) {
                GroupMetadata groupMetadata = this.amL.get(0);
                int indexOf = this.amL.indexOf(groupMetadata);
                bM(groupMetadata.amQ);
                if (bVar.amW > indexOf) {
                    bVar.amW--;
                }
            }
            GroupMetadata c = GroupMetadata.c(-1, -1, bVar.gqO.amX, this.amK.getGroupId(bVar.gqO.amX));
            this.amL.add(bVar.amW, c);
            f(false, false);
            notifyDataSetChanged();
            this.amK.onGroupExpanded(c.amQ);
            return true;
        }
        return false;
    }

    ExpandableListAdapter vd() {
        return this.amK;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter vd = vd();
        if (vd instanceof Filterable) {
            return ((Filterable) vd).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> ve() {
        return this.amL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.amK != null) {
            int groupCount = this.amK.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).amQ >= groupCount) {
                    return;
                }
            }
            this.amL = arrayList;
            f(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter vd = vd();
        if (vd != null) {
            return vd.isEmpty();
        }
        return true;
    }

    int b(long j, int i) {
        int groupCount = this.amK.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter vd = vd();
        if (vd == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (vd.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.f(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.f(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: R */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.c(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: tm */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int amO;
        int amP;
        int amQ;
        long amR;

        private GroupMetadata() {
        }

        static GroupMetadata c(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.amO = i;
            groupMetadata.amP = i2;
            groupMetadata.amQ = i3;
            groupMetadata.amR = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.amQ - groupMetadata.amQ;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.amO);
            parcel.writeInt(this.amP);
            parcel.writeInt(this.amQ);
            parcel.writeLong(this.amR);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> amT = new ArrayList<>(5);
        public int amW;
        public com.baidu.tieba.horizonalList.widget.a gqO;
        public GroupMetadata gqP;

        private void vf() {
            if (this.gqO != null) {
                this.gqO.recycle();
                this.gqO = null;
            }
            this.gqP = null;
            this.amW = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b bvI = bvI();
            bvI.gqO = com.baidu.tieba.horizonalList.widget.a.w(i2, i3, i4, i);
            bvI.gqP = groupMetadata;
            bvI.amW = i5;
            return bvI;
        }

        private static b bvI() {
            b bVar;
            synchronized (amT) {
                if (amT.size() > 0) {
                    bVar = amT.remove(0);
                    bVar.vf();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            vf();
            synchronized (amT) {
                if (amT.size() < 5) {
                    amT.add(this);
                }
            }
        }

        public boolean vh() {
            return this.gqP != null;
        }
    }
}
