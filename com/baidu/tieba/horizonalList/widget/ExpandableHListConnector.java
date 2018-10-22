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
    private ExpandableListAdapter epR;
    private int epT;
    private int epU = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> epS = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.epR != null) {
            this.epR.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.epR = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b of(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.epS;
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
            if (i > groupMetadata.epW) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.epV) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.epV) {
                return b.a(i, 2, groupMetadata.epX, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.epW) {
                    return b.a(i, 1, groupMetadata.epX, i - (groupMetadata.epV + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.epW) + groupMetadata2.epX;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.epX - (groupMetadata3.epV - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.epS;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.eqe, aVar.type, aVar.eqe, aVar.eqf, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.eqe > groupMetadata.epX) {
                i4 = i + 1;
            } else if (aVar.eqe < groupMetadata.epX) {
                i3 = i - 1;
            } else if (aVar.eqe == groupMetadata.epX) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.epV, aVar.type, aVar.eqe, aVar.eqf, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.epV + aVar.eqf + 1, aVar.type, aVar.eqe, aVar.eqf, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.eqe - groupMetadata2.epX) + groupMetadata2.epW, aVar.type, aVar.eqe, aVar.eqf, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.epV - (groupMetadata3.epX - aVar.eqe), aVar.type, aVar.eqe, aVar.eqf, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.epR.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b of = of(i);
        com.baidu.tieba.horizonalList.widget.a aVar = of.eqb;
        boolean isChildSelectable = aVar.type == 1 ? this.epR.isChildSelectable(aVar.eqe, aVar.eqf) : true;
        of.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.epR.getGroupCount() + this.epT;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b of = of(i);
        if (of.eqb.type == 2) {
            child = this.epR.getGroup(of.eqb.eqe);
        } else if (of.eqb.type == 1) {
            child = this.epR.getChild(of.eqb.eqe, of.eqb.eqf);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        of.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b of = of(i);
        long groupId = this.epR.getGroupId(of.eqb.eqe);
        if (of.eqb.type == 2) {
            combinedChildId = this.epR.getCombinedGroupId(groupId);
        } else if (of.eqb.type == 1) {
            combinedChildId = this.epR.getCombinedChildId(groupId, this.epR.getChildId(of.eqb.eqe, of.eqb.eqf));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        of.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b of = of(i);
        if (of.eqb.type == 2) {
            childView = this.epR.getGroupView(of.eqb.eqe, of.awW(), view, viewGroup);
        } else if (of.eqb.type == 1) {
            childView = this.epR.getChildView(of.eqb.eqe, of.eqb.eqf, of.eqc.epW == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        of.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b of = of(i);
        com.baidu.tieba.horizonalList.widget.a aVar = of.eqb;
        if (this.epR instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.epR;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.eqe);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.eqe, aVar.eqf);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        of.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.epR instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.epR;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.epR.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.epS;
        int size = arrayList.size();
        this.epT = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int l = l(groupMetadata.epY, groupMetadata.epX);
                if (l != groupMetadata.epX) {
                    if (l == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.epX = l;
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
            if (groupMetadata2.epW == -1 || z) {
                childrenCount = this.epR.getChildrenCount(groupMetadata2.epX);
            } else {
                childrenCount = groupMetadata2.epW - groupMetadata2.epV;
            }
            this.epT += childrenCount;
            int i5 = i4 + (groupMetadata2.epX - i3);
            i3 = groupMetadata2.epX;
            groupMetadata2.epV = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.epW = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a s = com.baidu.tieba.horizonalList.widget.a.s(2, i, -1, -1);
        b a2 = a(s);
        s.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.eqc == null) {
            return false;
        }
        this.epS.remove(bVar.eqc);
        F(false, false);
        notifyDataSetChanged();
        this.epR.onGroupCollapsed(bVar.eqc.epX);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.eqb.eqe < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.epU != 0 && bVar.eqc == null) {
            if (this.epS.size() >= this.epU) {
                GroupMetadata groupMetadata = this.epS.get(0);
                int indexOf = this.epS.indexOf(groupMetadata);
                collapseGroup(groupMetadata.epX);
                if (bVar.eqd > indexOf) {
                    bVar.eqd--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.eqb.eqe, this.epR.getGroupId(bVar.eqb.eqe));
            this.epS.add(bVar.eqd, a2);
            F(false, false);
            notifyDataSetChanged();
            this.epR.onGroupExpanded(a2.epX);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aKv() {
        return this.epR;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aKv = aKv();
        if (aKv instanceof Filterable) {
            return ((Filterable) aKv).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aKw() {
        return this.epS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.epR != null) {
            int groupCount = this.epR.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).epX >= groupCount) {
                    return;
                }
            }
            this.epS = arrayList;
            F(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aKv = aKv();
        if (aKv != null) {
            return aKv.isEmpty();
        }
        return true;
    }

    int l(long j, int i) {
        int groupCount = this.epR.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aKv = aKv();
        if (aKv == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aKv.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.F(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.F(true, true);
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
                return GroupMetadata.a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: og */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int epV;
        int epW;
        int epX;
        long epY;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.epV = i;
            groupMetadata.epW = i2;
            groupMetadata.epX = i3;
            groupMetadata.epY = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.epX - groupMetadata.epX;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.epV);
            parcel.writeInt(this.epW);
            parcel.writeInt(this.epX);
            parcel.writeLong(this.epY);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> eqa = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a eqb;
        public GroupMetadata eqc;
        public int eqd;

        private void Tm() {
            if (this.eqb != null) {
                this.eqb.recycle();
                this.eqb = null;
            }
            this.eqc = null;
            this.eqd = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aKx = aKx();
            aKx.eqb = com.baidu.tieba.horizonalList.widget.a.s(i2, i3, i4, i);
            aKx.eqc = groupMetadata;
            aKx.eqd = i5;
            return aKx;
        }

        private static b aKx() {
            b bVar;
            synchronized (eqa) {
                if (eqa.size() > 0) {
                    bVar = eqa.remove(0);
                    bVar.Tm();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            Tm();
            synchronized (eqa) {
                if (eqa.size() < 5) {
                    eqa.add(this);
                }
            }
        }

        public boolean awW() {
            return this.eqc != null;
        }
    }
}
