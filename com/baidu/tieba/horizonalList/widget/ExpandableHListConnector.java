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
    private ExpandableListAdapter cZm;
    private int cZo;
    private int cZp = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> cZn = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.cZm != null) {
            this.cZm.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.cZm = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b lg(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.cZn;
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
            if (i > groupMetadata.cZr) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.cZq) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.cZq) {
                return b.a(i, 2, groupMetadata.cZs, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.cZr) {
                    return b.a(i, 1, groupMetadata.cZs, i - (groupMetadata.cZq + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.cZr) + groupMetadata2.cZs;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.cZs - (groupMetadata3.cZq - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.b bVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cZn;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(bVar.cZz, bVar.type, bVar.cZz, bVar.cZA, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (bVar.cZz > groupMetadata.cZs) {
                i4 = i + 1;
            } else if (bVar.cZz < groupMetadata.cZs) {
                i3 = i - 1;
            } else if (bVar.cZz == groupMetadata.cZs) {
                if (bVar.type == 2) {
                    return b.a(groupMetadata.cZq, bVar.type, bVar.cZz, bVar.cZA, groupMetadata, i);
                }
                if (bVar.type == 1) {
                    return b.a(groupMetadata.cZq + bVar.cZA + 1, bVar.type, bVar.cZz, bVar.cZA, groupMetadata, i);
                }
                return null;
            }
        }
        if (bVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((bVar.cZz - groupMetadata2.cZs) + groupMetadata2.cZr, bVar.type, bVar.cZz, bVar.cZA, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.cZq - (groupMetadata3.cZs - bVar.cZz), bVar.type, bVar.cZz, bVar.cZA, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.cZm.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b lg = lg(i);
        com.baidu.tieba.horizonalList.widget.b bVar = lg.cZw;
        boolean isChildSelectable = bVar.type == 1 ? this.cZm.isChildSelectable(bVar.cZz, bVar.cZA) : true;
        lg.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cZm.getGroupCount() + this.cZo;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b lg = lg(i);
        if (lg.cZw.type == 2) {
            child = this.cZm.getGroup(lg.cZw.cZz);
        } else if (lg.cZw.type == 1) {
            child = this.cZm.getChild(lg.cZw.cZz, lg.cZw.cZA);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        lg.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b lg = lg(i);
        long groupId = this.cZm.getGroupId(lg.cZw.cZz);
        if (lg.cZw.type == 2) {
            combinedChildId = this.cZm.getCombinedGroupId(groupId);
        } else if (lg.cZw.type == 1) {
            combinedChildId = this.cZm.getCombinedChildId(groupId, this.cZm.getChildId(lg.cZw.cZz, lg.cZw.cZA));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        lg.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b lg = lg(i);
        if (lg.cZw.type == 2) {
            childView = this.cZm.getGroupView(lg.cZw.cZz, lg.apQ(), view, viewGroup);
        } else if (lg.cZw.type == 1) {
            childView = this.cZm.getChildView(lg.cZw.cZz, lg.cZw.cZA, lg.cZx.cZr == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        lg.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b lg = lg(i);
        com.baidu.tieba.horizonalList.widget.b bVar = lg.cZw;
        if (this.cZm instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cZm;
            if (bVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(bVar.cZz);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(bVar.cZz, bVar.cZA);
            }
        } else if (bVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        lg.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.cZm instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cZm;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.cZm.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cZn;
        int size = arrayList.size();
        this.cZo = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int g = g(groupMetadata.cZt, groupMetadata.cZs);
                if (g != groupMetadata.cZs) {
                    if (g == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.cZs = g;
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
            if (groupMetadata2.cZr == -1 || z) {
                childrenCount = this.cZm.getChildrenCount(groupMetadata2.cZs);
            } else {
                childrenCount = groupMetadata2.cZr - groupMetadata2.cZq;
            }
            this.cZo += childrenCount;
            int i5 = i4 + (groupMetadata2.cZs - i3);
            i3 = groupMetadata2.cZs;
            groupMetadata2.cZq = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.cZr = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b o = com.baidu.tieba.horizonalList.widget.b.o(2, i, -1, -1);
        b a2 = a(o);
        o.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.cZx == null) {
            return false;
        }
        this.cZn.remove(bVar.cZx);
        x(false, false);
        notifyDataSetChanged();
        this.cZm.onGroupCollapsed(bVar.cZx.cZs);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.cZw.cZz < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.cZp != 0 && bVar.cZx == null) {
            if (this.cZn.size() >= this.cZp) {
                GroupMetadata groupMetadata = this.cZn.get(0);
                int indexOf = this.cZn.indexOf(groupMetadata);
                collapseGroup(groupMetadata.cZs);
                if (bVar.cZy > indexOf) {
                    bVar.cZy--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.cZw.cZz, this.cZm.getGroupId(bVar.cZw.cZz));
            this.cZn.add(bVar.cZy, a2);
            x(false, false);
            notifyDataSetChanged();
            this.cZm.onGroupExpanded(a2.cZs);
            return true;
        }
        return false;
    }

    ExpandableListAdapter apN() {
        return this.cZm;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter apN = apN();
        if (apN instanceof Filterable) {
            return ((Filterable) apN).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> apO() {
        return this.cZn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.cZm != null) {
            int groupCount = this.cZm.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).cZs >= groupCount) {
                    return;
                }
            }
            this.cZn = arrayList;
            x(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter apN = apN();
        if (apN != null) {
            return apN.isEmpty();
        }
        return true;
    }

    int g(long j, int i) {
        int groupCount = this.cZm.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter apN = apN();
        if (apN == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (apN.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.x(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.x(true, true);
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
            /* renamed from: lh */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int cZq;
        int cZr;
        int cZs;
        long cZt;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.cZq = i;
            groupMetadata.cZr = i2;
            groupMetadata.cZs = i3;
            groupMetadata.cZt = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.cZs - groupMetadata.cZs;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.cZq);
            parcel.writeInt(this.cZr);
            parcel.writeInt(this.cZs);
            parcel.writeLong(this.cZt);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> cZv = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.b cZw;
        public GroupMetadata cZx;
        public int cZy;

        private void resetState() {
            if (this.cZw != null) {
                this.cZw.recycle();
                this.cZw = null;
            }
            this.cZx = null;
            this.cZy = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b apP = apP();
            apP.cZw = com.baidu.tieba.horizonalList.widget.b.o(i2, i3, i4, i);
            apP.cZx = groupMetadata;
            apP.cZy = i5;
            return apP;
        }

        private static b apP() {
            b bVar;
            synchronized (cZv) {
                if (cZv.size() > 0) {
                    bVar = cZv.remove(0);
                    bVar.resetState();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            resetState();
            synchronized (cZv) {
                if (cZv.size() < 5) {
                    cZv.add(this);
                }
            }
        }

        public boolean apQ() {
            return this.cZx != null;
        }
    }
}
