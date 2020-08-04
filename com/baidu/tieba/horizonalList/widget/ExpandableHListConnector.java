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
    private ExpandableListAdapter bgk;
    private int bgm;
    private int bgn = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> bgl = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.bgk != null) {
            this.bgk.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.bgk = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b xN(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.bgl;
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
            if (i > groupMetadata.bgp) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.bgo) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.bgo) {
                return b.a(i, 2, groupMetadata.bgq, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.bgp) {
                    return b.a(i, 1, groupMetadata.bgq, i - (groupMetadata.bgo + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.bgp) + groupMetadata2.bgq;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.bgq - (groupMetadata3.bgo - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.bgl;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.bgy, aVar.type, aVar.bgy, aVar.bgz, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.bgy > groupMetadata.bgq) {
                i4 = i + 1;
            } else if (aVar.bgy < groupMetadata.bgq) {
                i3 = i - 1;
            } else if (aVar.bgy == groupMetadata.bgq) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.bgo, aVar.type, aVar.bgy, aVar.bgz, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.bgo + aVar.bgz + 1, aVar.type, aVar.bgy, aVar.bgz, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.bgy - groupMetadata2.bgq) + groupMetadata2.bgp, aVar.type, aVar.bgy, aVar.bgz, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.bgo - (groupMetadata3.bgq - aVar.bgy), aVar.type, aVar.bgy, aVar.bgz, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.bgk.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b xN = xN(i);
        com.baidu.tieba.horizonalList.widget.a aVar = xN.iHN;
        boolean isChildSelectable = aVar.type == 1 ? this.bgk.isChildSelectable(aVar.bgy, aVar.bgz) : true;
        xN.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bgk.getGroupCount() + this.bgm;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b xN = xN(i);
        if (xN.iHN.type == 2) {
            child = this.bgk.getGroup(xN.iHN.bgy);
        } else if (xN.iHN.type == 1) {
            child = this.bgk.getChild(xN.iHN.bgy, xN.iHN.bgz);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        xN.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b xN = xN(i);
        long groupId = this.bgk.getGroupId(xN.iHN.bgy);
        if (xN.iHN.type == 2) {
            combinedChildId = this.bgk.getCombinedGroupId(groupId);
        } else if (xN.iHN.type == 1) {
            combinedChildId = this.bgk.getCombinedChildId(groupId, this.bgk.getChildId(xN.iHN.bgy, xN.iHN.bgz));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        xN.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b xN = xN(i);
        if (xN.iHN.type == 2) {
            childView = this.bgk.getGroupView(xN.iHN.bgy, xN.Id(), view, viewGroup);
        } else if (xN.iHN.type == 1) {
            childView = this.bgk.getChildView(xN.iHN.bgy, xN.iHN.bgz, xN.iHO.bgp == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        xN.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b xN = xN(i);
        com.baidu.tieba.horizonalList.widget.a aVar = xN.iHN;
        if (this.bgk instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bgk;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.bgy);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.bgy, aVar.bgz);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        xN.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.bgk instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bgk;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.bgk.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.bgl;
        int size = arrayList.size();
        this.bgm = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int b2 = b(groupMetadata.bgr, groupMetadata.bgq);
                if (b2 != groupMetadata.bgq) {
                    if (b2 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.bgq = b2;
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
            if (groupMetadata2.bgp == -1 || z) {
                childrenCount = this.bgk.getChildrenCount(groupMetadata2.bgq);
            } else {
                childrenCount = groupMetadata2.bgp - groupMetadata2.bgo;
            }
            this.bgm += childrenCount;
            int i5 = i4 + (groupMetadata2.bgq - i3);
            i3 = groupMetadata2.bgq;
            groupMetadata2.bgo = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.bgp = i6;
            i++;
            i4 = i6;
        }
    }

    boolean dd(int i) {
        com.baidu.tieba.horizonalList.widget.a C = com.baidu.tieba.horizonalList.widget.a.C(2, i, -1, -1);
        b a2 = a(C);
        C.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.iHO == null) {
            return false;
        }
        this.bgl.remove(bVar.iHO);
        g(false, false);
        notifyDataSetChanged();
        this.bgk.onGroupCollapsed(bVar.iHO.bgq);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.iHN.bgy < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.bgn != 0 && bVar.iHO == null) {
            if (this.bgl.size() >= this.bgn) {
                GroupMetadata groupMetadata = this.bgl.get(0);
                int indexOf = this.bgl.indexOf(groupMetadata);
                dd(groupMetadata.bgq);
                if (bVar.bgx > indexOf) {
                    bVar.bgx--;
                }
            }
            GroupMetadata c = GroupMetadata.c(-1, -1, bVar.iHN.bgy, this.bgk.getGroupId(bVar.iHN.bgy));
            this.bgl.add(bVar.bgx, c);
            g(false, false);
            notifyDataSetChanged();
            this.bgk.onGroupExpanded(c.bgq);
            return true;
        }
        return false;
    }

    ExpandableListAdapter Ia() {
        return this.bgk;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter Ia = Ia();
        if (Ia instanceof Filterable) {
            return ((Filterable) Ia).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> Ib() {
        return this.bgl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.bgk != null) {
            int groupCount = this.bgk.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).bgq >= groupCount) {
                    return;
                }
            }
            this.bgl = arrayList;
            g(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter Ia = Ia();
        if (Ia != null) {
            return Ia.isEmpty();
        }
        return true;
    }

    int b(long j, int i) {
        int groupCount = this.bgk.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter Ia = Ia();
        if (Ia == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (Ia.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.g(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.g(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: aa */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.c(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: xO */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int bgo;
        int bgp;
        int bgq;
        long bgr;

        private GroupMetadata() {
        }

        static GroupMetadata c(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.bgo = i;
            groupMetadata.bgp = i2;
            groupMetadata.bgq = i3;
            groupMetadata.bgr = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.bgq - groupMetadata.bgq;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.bgo);
            parcel.writeInt(this.bgp);
            parcel.writeInt(this.bgq);
            parcel.writeLong(this.bgr);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> bgu = new ArrayList<>(5);
        public int bgx;
        public com.baidu.tieba.horizonalList.widget.a iHN;
        public GroupMetadata iHO;

        private void resetState() {
            if (this.iHN != null) {
                this.iHN.recycle();
                this.iHN = null;
            }
            this.iHO = null;
            this.bgx = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b cox = cox();
            cox.iHN = com.baidu.tieba.horizonalList.widget.a.C(i2, i3, i4, i);
            cox.iHO = groupMetadata;
            cox.bgx = i5;
            return cox;
        }

        private static b cox() {
            b bVar;
            synchronized (bgu) {
                if (bgu.size() > 0) {
                    bVar = bgu.remove(0);
                    bVar.resetState();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            resetState();
            synchronized (bgu) {
                if (bgu.size() < 5) {
                    bgu.add(this);
                }
            }
        }

        public boolean Id() {
            return this.iHO != null;
        }
    }
}
