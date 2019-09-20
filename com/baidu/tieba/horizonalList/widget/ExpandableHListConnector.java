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
    private ExpandableListAdapter grP;
    private int grR;
    private int grS = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> grQ = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.grP != null) {
            this.grP.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.grP = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b ux(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.grQ;
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
            if (i > groupMetadata.grU) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.grT) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.grT) {
                return b.a(i, 2, groupMetadata.grV, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.grU) {
                    return b.a(i, 1, groupMetadata.grV, i - (groupMetadata.grT + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.grU) + groupMetadata2.grV;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.grV - (groupMetadata3.grT - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.grQ;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.gsc, aVar.type, aVar.gsc, aVar.gsd, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.gsc > groupMetadata.grV) {
                i4 = i + 1;
            } else if (aVar.gsc < groupMetadata.grV) {
                i3 = i - 1;
            } else if (aVar.gsc == groupMetadata.grV) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.grT, aVar.type, aVar.gsc, aVar.gsd, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.grT + aVar.gsd + 1, aVar.type, aVar.gsc, aVar.gsd, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.gsc - groupMetadata2.grV) + groupMetadata2.grU, aVar.type, aVar.gsc, aVar.gsd, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.grT - (groupMetadata3.grV - aVar.gsc), aVar.type, aVar.gsc, aVar.gsd, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.grP.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b ux = ux(i);
        com.baidu.tieba.horizonalList.widget.a aVar = ux.grZ;
        boolean isChildSelectable = aVar.type == 1 ? this.grP.isChildSelectable(aVar.gsc, aVar.gsd) : true;
        ux.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.grP.getGroupCount() + this.grR;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b ux = ux(i);
        if (ux.grZ.type == 2) {
            child = this.grP.getGroup(ux.grZ.gsc);
        } else if (ux.grZ.type == 1) {
            child = this.grP.getChild(ux.grZ.gsc, ux.grZ.gsd);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ux.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b ux = ux(i);
        long groupId = this.grP.getGroupId(ux.grZ.gsc);
        if (ux.grZ.type == 2) {
            combinedChildId = this.grP.getCombinedGroupId(groupId);
        } else if (ux.grZ.type == 1) {
            combinedChildId = this.grP.getCombinedChildId(groupId, this.grP.getChildId(ux.grZ.gsc, ux.grZ.gsd));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ux.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b ux = ux(i);
        if (ux.grZ.type == 2) {
            childView = this.grP.getGroupView(ux.grZ.gsc, ux.bkf(), view, viewGroup);
        } else if (ux.grZ.type == 1) {
            childView = this.grP.getChildView(ux.grZ.gsc, ux.grZ.gsd, ux.gsa.grU == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ux.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b ux = ux(i);
        com.baidu.tieba.horizonalList.widget.a aVar = ux.grZ;
        if (this.grP instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.grP;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.gsc);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.gsc, aVar.gsd);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        ux.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.grP instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.grP;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.grP.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.grQ;
        int size = arrayList.size();
        this.grR = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int o = o(groupMetadata.grW, groupMetadata.grV);
                if (o != groupMetadata.grV) {
                    if (o == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.grV = o;
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
            if (groupMetadata2.grU == -1 || z) {
                childrenCount = this.grP.getChildrenCount(groupMetadata2.grV);
            } else {
                childrenCount = groupMetadata2.grU - groupMetadata2.grT;
            }
            this.grR += childrenCount;
            int i5 = i4 + (groupMetadata2.grV - i3);
            i3 = groupMetadata2.grV;
            groupMetadata2.grT = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.grU = i6;
            i++;
            i4 = i6;
        }
    }

    boolean uy(int i) {
        com.baidu.tieba.horizonalList.widget.a A = com.baidu.tieba.horizonalList.widget.a.A(2, i, -1, -1);
        b a2 = a(A);
        A.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.gsa == null) {
            return false;
        }
        this.grQ.remove(bVar.gsa);
        Q(false, false);
        notifyDataSetChanged();
        this.grP.onGroupCollapsed(bVar.gsa.grV);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.grZ.gsc < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.grS != 0 && bVar.gsa == null) {
            if (this.grQ.size() >= this.grS) {
                GroupMetadata groupMetadata = this.grQ.get(0);
                int indexOf = this.grQ.indexOf(groupMetadata);
                uy(groupMetadata.grV);
                if (bVar.gsb > indexOf) {
                    bVar.gsb--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.grZ.gsc, this.grP.getGroupId(bVar.grZ.gsc));
            this.grQ.add(bVar.gsb, b2);
            Q(false, false);
            notifyDataSetChanged();
            this.grP.onGroupExpanded(b2.grV);
            return true;
        }
        return false;
    }

    ExpandableListAdapter byP() {
        return this.grP;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter byP = byP();
        if (byP instanceof Filterable) {
            return ((Filterable) byP).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> byQ() {
        return this.grQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void af(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.grP != null) {
            int groupCount = this.grP.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).grV >= groupCount) {
                    return;
                }
            }
            this.grQ = arrayList;
            Q(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter byP = byP();
        if (byP != null) {
            return byP.isEmpty();
        }
        return true;
    }

    int o(long j, int i) {
        int groupCount = this.grP.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter byP = byP();
        if (byP == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (byP.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.Q(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.Q(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: O */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.b(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: uz */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int grT;
        int grU;
        int grV;
        long grW;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.grT = i;
            groupMetadata.grU = i2;
            groupMetadata.grV = i3;
            groupMetadata.grW = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.grV - groupMetadata.grV;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.grT);
            parcel.writeInt(this.grU);
            parcel.writeInt(this.grV);
            parcel.writeLong(this.grW);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> grY = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a grZ;
        public GroupMetadata gsa;
        public int gsb;

        private void aBH() {
            if (this.grZ != null) {
                this.grZ.recycle();
                this.grZ = null;
            }
            this.gsa = null;
            this.gsb = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b byR = byR();
            byR.grZ = com.baidu.tieba.horizonalList.widget.a.A(i2, i3, i4, i);
            byR.gsa = groupMetadata;
            byR.gsb = i5;
            return byR;
        }

        private static b byR() {
            b bVar;
            synchronized (grY) {
                if (grY.size() > 0) {
                    bVar = grY.remove(0);
                    bVar.aBH();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            aBH();
            synchronized (grY) {
                if (grY.size() < 5) {
                    grY.add(this);
                }
            }
        }

        public boolean bkf() {
            return this.gsa != null;
        }
    }
}
