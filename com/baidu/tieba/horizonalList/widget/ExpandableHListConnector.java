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
    private ExpandableListAdapter cXn;
    private int cXp;
    private int cXq = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> cXo = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.cXn != null) {
            this.cXn.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.cXn = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b kW(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.cXo;
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
            if (i > groupMetadata.cXs) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.cXr) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.cXr) {
                return b.a(i, 2, groupMetadata.cXt, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.cXs) {
                    return b.a(i, 1, groupMetadata.cXt, i - (groupMetadata.cXr + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.cXs) + groupMetadata2.cXt;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.cXt - (groupMetadata3.cXr - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.b bVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cXo;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(bVar.cXA, bVar.type, bVar.cXA, bVar.cXB, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (bVar.cXA > groupMetadata.cXt) {
                i4 = i + 1;
            } else if (bVar.cXA < groupMetadata.cXt) {
                i3 = i - 1;
            } else if (bVar.cXA == groupMetadata.cXt) {
                if (bVar.type == 2) {
                    return b.a(groupMetadata.cXr, bVar.type, bVar.cXA, bVar.cXB, groupMetadata, i);
                }
                if (bVar.type == 1) {
                    return b.a(groupMetadata.cXr + bVar.cXB + 1, bVar.type, bVar.cXA, bVar.cXB, groupMetadata, i);
                }
                return null;
            }
        }
        if (bVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((bVar.cXA - groupMetadata2.cXt) + groupMetadata2.cXs, bVar.type, bVar.cXA, bVar.cXB, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.cXr - (groupMetadata3.cXt - bVar.cXA), bVar.type, bVar.cXA, bVar.cXB, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.cXn.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b kW = kW(i);
        com.baidu.tieba.horizonalList.widget.b bVar = kW.cXx;
        boolean isChildSelectable = bVar.type == 1 ? this.cXn.isChildSelectable(bVar.cXA, bVar.cXB) : true;
        kW.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cXn.getGroupCount() + this.cXp;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b kW = kW(i);
        if (kW.cXx.type == 2) {
            child = this.cXn.getGroup(kW.cXx.cXA);
        } else if (kW.cXx.type == 1) {
            child = this.cXn.getChild(kW.cXx.cXA, kW.cXx.cXB);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kW.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b kW = kW(i);
        long groupId = this.cXn.getGroupId(kW.cXx.cXA);
        if (kW.cXx.type == 2) {
            combinedChildId = this.cXn.getCombinedGroupId(groupId);
        } else if (kW.cXx.type == 1) {
            combinedChildId = this.cXn.getCombinedChildId(groupId, this.cXn.getChildId(kW.cXx.cXA, kW.cXx.cXB));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kW.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b kW = kW(i);
        if (kW.cXx.type == 2) {
            childView = this.cXn.getGroupView(kW.cXx.cXA, kW.app(), view, viewGroup);
        } else if (kW.cXx.type == 1) {
            childView = this.cXn.getChildView(kW.cXx.cXA, kW.cXx.cXB, kW.cXy.cXs == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kW.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b kW = kW(i);
        com.baidu.tieba.horizonalList.widget.b bVar = kW.cXx;
        if (this.cXn instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cXn;
            if (bVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(bVar.cXA);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(bVar.cXA, bVar.cXB);
            }
        } else if (bVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        kW.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.cXn instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cXn;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.cXn.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cXo;
        int size = arrayList.size();
        this.cXp = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int g = g(groupMetadata.cXu, groupMetadata.cXt);
                if (g != groupMetadata.cXt) {
                    if (g == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.cXt = g;
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
            if (groupMetadata2.cXs == -1 || z) {
                childrenCount = this.cXn.getChildrenCount(groupMetadata2.cXt);
            } else {
                childrenCount = groupMetadata2.cXs - groupMetadata2.cXr;
            }
            this.cXp += childrenCount;
            int i5 = i4 + (groupMetadata2.cXt - i3);
            i3 = groupMetadata2.cXt;
            groupMetadata2.cXr = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.cXs = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b n = com.baidu.tieba.horizonalList.widget.b.n(2, i, -1, -1);
        b a2 = a(n);
        n.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.cXy == null) {
            return false;
        }
        this.cXo.remove(bVar.cXy);
        w(false, false);
        notifyDataSetChanged();
        this.cXn.onGroupCollapsed(bVar.cXy.cXt);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.cXx.cXA < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.cXq != 0 && bVar.cXy == null) {
            if (this.cXo.size() >= this.cXq) {
                GroupMetadata groupMetadata = this.cXo.get(0);
                int indexOf = this.cXo.indexOf(groupMetadata);
                collapseGroup(groupMetadata.cXt);
                if (bVar.cXz > indexOf) {
                    bVar.cXz--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.cXx.cXA, this.cXn.getGroupId(bVar.cXx.cXA));
            this.cXo.add(bVar.cXz, a2);
            w(false, false);
            notifyDataSetChanged();
            this.cXn.onGroupExpanded(a2.cXt);
            return true;
        }
        return false;
    }

    ExpandableListAdapter apm() {
        return this.cXn;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter apm = apm();
        if (apm instanceof Filterable) {
            return ((Filterable) apm).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> apn() {
        return this.cXo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.cXn != null) {
            int groupCount = this.cXn.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).cXt >= groupCount) {
                    return;
                }
            }
            this.cXo = arrayList;
            w(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter apm = apm();
        if (apm != null) {
            return apm.isEmpty();
        }
        return true;
    }

    int g(long j, int i) {
        int groupCount = this.cXn.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter apm = apm();
        if (apm == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (apm.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.w(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.w(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: m */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: kX */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int cXr;
        int cXs;
        int cXt;
        long cXu;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.cXr = i;
            groupMetadata.cXs = i2;
            groupMetadata.cXt = i3;
            groupMetadata.cXu = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.cXt - groupMetadata.cXt;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.cXr);
            parcel.writeInt(this.cXs);
            parcel.writeInt(this.cXt);
            parcel.writeLong(this.cXu);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> cXw = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.b cXx;
        public GroupMetadata cXy;
        public int cXz;

        private void resetState() {
            if (this.cXx != null) {
                this.cXx.recycle();
                this.cXx = null;
            }
            this.cXy = null;
            this.cXz = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b apo = apo();
            apo.cXx = com.baidu.tieba.horizonalList.widget.b.n(i2, i3, i4, i);
            apo.cXy = groupMetadata;
            apo.cXz = i5;
            return apo;
        }

        private static b apo() {
            b bVar;
            synchronized (cXw) {
                if (cXw.size() > 0) {
                    bVar = cXw.remove(0);
                    bVar.resetState();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            resetState();
            synchronized (cXw) {
                if (cXw.size() < 5) {
                    cXw.add(this);
                }
            }
        }

        public boolean app() {
            return this.cXy != null;
        }
    }
}
