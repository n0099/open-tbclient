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
    private ExpandableListAdapter gpY;
    private int gqa;
    private int gqb = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> gpZ = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.gpY != null) {
            this.gpY.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.gpY = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b ut(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.gpZ;
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
            if (i > groupMetadata.gqd) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.gqc) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.gqc) {
                return b.a(i, 2, groupMetadata.gqe, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.gqd) {
                    return b.a(i, 1, groupMetadata.gqe, i - (groupMetadata.gqc + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.gqd) + groupMetadata2.gqe;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.gqe - (groupMetadata3.gqc - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.gpZ;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.gql, aVar.type, aVar.gql, aVar.gqm, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.gql > groupMetadata.gqe) {
                i4 = i + 1;
            } else if (aVar.gql < groupMetadata.gqe) {
                i3 = i - 1;
            } else if (aVar.gql == groupMetadata.gqe) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.gqc, aVar.type, aVar.gql, aVar.gqm, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.gqc + aVar.gqm + 1, aVar.type, aVar.gql, aVar.gqm, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.gql - groupMetadata2.gqe) + groupMetadata2.gqd, aVar.type, aVar.gql, aVar.gqm, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.gqc - (groupMetadata3.gqe - aVar.gql), aVar.type, aVar.gql, aVar.gqm, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.gpY.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b ut = ut(i);
        com.baidu.tieba.horizonalList.widget.a aVar = ut.gqi;
        boolean isChildSelectable = aVar.type == 1 ? this.gpY.isChildSelectable(aVar.gql, aVar.gqm) : true;
        ut.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gpY.getGroupCount() + this.gqa;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b ut = ut(i);
        if (ut.gqi.type == 2) {
            child = this.gpY.getGroup(ut.gqi.gql);
        } else if (ut.gqi.type == 1) {
            child = this.gpY.getChild(ut.gqi.gql, ut.gqi.gqm);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ut.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b ut = ut(i);
        long groupId = this.gpY.getGroupId(ut.gqi.gql);
        if (ut.gqi.type == 2) {
            combinedChildId = this.gpY.getCombinedGroupId(groupId);
        } else if (ut.gqi.type == 1) {
            combinedChildId = this.gpY.getCombinedChildId(groupId, this.gpY.getChildId(ut.gqi.gql, ut.gqi.gqm));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ut.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b ut = ut(i);
        if (ut.gqi.type == 2) {
            childView = this.gpY.getGroupView(ut.gqi.gql, ut.bju(), view, viewGroup);
        } else if (ut.gqi.type == 1) {
            childView = this.gpY.getChildView(ut.gqi.gql, ut.gqi.gqm, ut.gqj.gqd == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ut.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b ut = ut(i);
        com.baidu.tieba.horizonalList.widget.a aVar = ut.gqi;
        if (this.gpY instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.gpY;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.gql);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.gql, aVar.gqm);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        ut.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.gpY instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.gpY;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.gpY.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.gpZ;
        int size = arrayList.size();
        this.gqa = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int o = o(groupMetadata.gqf, groupMetadata.gqe);
                if (o != groupMetadata.gqe) {
                    if (o == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.gqe = o;
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
            if (groupMetadata2.gqd == -1 || z) {
                childrenCount = this.gpY.getChildrenCount(groupMetadata2.gqe);
            } else {
                childrenCount = groupMetadata2.gqd - groupMetadata2.gqc;
            }
            this.gqa += childrenCount;
            int i5 = i4 + (groupMetadata2.gqe - i3);
            i3 = groupMetadata2.gqe;
            groupMetadata2.gqc = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.gqd = i6;
            i++;
            i4 = i6;
        }
    }

    boolean uu(int i) {
        com.baidu.tieba.horizonalList.widget.a x = com.baidu.tieba.horizonalList.widget.a.x(2, i, -1, -1);
        b a2 = a(x);
        x.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.gqj == null) {
            return false;
        }
        this.gpZ.remove(bVar.gqj);
        Q(false, false);
        notifyDataSetChanged();
        this.gpY.onGroupCollapsed(bVar.gqj.gqe);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.gqi.gql < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.gqb != 0 && bVar.gqj == null) {
            if (this.gpZ.size() >= this.gqb) {
                GroupMetadata groupMetadata = this.gpZ.get(0);
                int indexOf = this.gpZ.indexOf(groupMetadata);
                uu(groupMetadata.gqe);
                if (bVar.gqk > indexOf) {
                    bVar.gqk--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.gqi.gql, this.gpY.getGroupId(bVar.gqi.gql));
            this.gpZ.add(bVar.gqk, b2);
            Q(false, false);
            notifyDataSetChanged();
            this.gpY.onGroupExpanded(b2.gqe);
            return true;
        }
        return false;
    }

    ExpandableListAdapter byb() {
        return this.gpY;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter byb = byb();
        if (byb instanceof Filterable) {
            return ((Filterable) byb).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> byc() {
        return this.gpZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void af(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.gpY != null) {
            int groupCount = this.gpY.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).gqe >= groupCount) {
                    return;
                }
            }
            this.gpZ = arrayList;
            Q(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter byb = byb();
        if (byb != null) {
            return byb.isEmpty();
        }
        return true;
    }

    int o(long j, int i) {
        int groupCount = this.gpY.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter byb = byb();
        if (byb == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (byb.getGroupId(i3) != j) {
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
            /* renamed from: uv */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int gqc;
        int gqd;
        int gqe;
        long gqf;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.gqc = i;
            groupMetadata.gqd = i2;
            groupMetadata.gqe = i3;
            groupMetadata.gqf = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.gqe - groupMetadata.gqe;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.gqc);
            parcel.writeInt(this.gqd);
            parcel.writeInt(this.gqe);
            parcel.writeLong(this.gqf);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> gqh = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a gqi;
        public GroupMetadata gqj;
        public int gqk;

        private void aBt() {
            if (this.gqi != null) {
                this.gqi.recycle();
                this.gqi = null;
            }
            this.gqj = null;
            this.gqk = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b byd = byd();
            byd.gqi = com.baidu.tieba.horizonalList.widget.a.x(i2, i3, i4, i);
            byd.gqj = groupMetadata;
            byd.gqk = i5;
            return byd;
        }

        private static b byd() {
            b bVar;
            synchronized (gqh) {
                if (gqh.size() > 0) {
                    bVar = gqh.remove(0);
                    bVar.aBt();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            aBt();
            synchronized (gqh) {
                if (gqh.size() < 5) {
                    gqh.add(this);
                }
            }
        }

        public boolean bju() {
            return this.gqj != null;
        }
    }
}
