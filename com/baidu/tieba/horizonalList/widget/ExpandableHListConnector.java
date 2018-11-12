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
    private ExpandableListAdapter erk;
    private int erm;
    private int ern = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> erl = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.erk != null) {
            this.erk.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.erk = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b ox(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.erl;
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
            if (i > groupMetadata.erp) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.ero) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.ero) {
                return b.a(i, 2, groupMetadata.erq, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.erp) {
                    return b.a(i, 1, groupMetadata.erq, i - (groupMetadata.ero + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.erp) + groupMetadata2.erq;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.erq - (groupMetadata3.ero - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.erl;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.ery, aVar.type, aVar.ery, aVar.erz, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.ery > groupMetadata.erq) {
                i4 = i + 1;
            } else if (aVar.ery < groupMetadata.erq) {
                i3 = i - 1;
            } else if (aVar.ery == groupMetadata.erq) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.ero, aVar.type, aVar.ery, aVar.erz, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.ero + aVar.erz + 1, aVar.type, aVar.ery, aVar.erz, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.ery - groupMetadata2.erq) + groupMetadata2.erp, aVar.type, aVar.ery, aVar.erz, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.ero - (groupMetadata3.erq - aVar.ery), aVar.type, aVar.ery, aVar.erz, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.erk.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b ox = ox(i);
        com.baidu.tieba.horizonalList.widget.a aVar = ox.erv;
        boolean isChildSelectable = aVar.type == 1 ? this.erk.isChildSelectable(aVar.ery, aVar.erz) : true;
        ox.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.erk.getGroupCount() + this.erm;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b ox = ox(i);
        if (ox.erv.type == 2) {
            child = this.erk.getGroup(ox.erv.ery);
        } else if (ox.erv.type == 1) {
            child = this.erk.getChild(ox.erv.ery, ox.erv.erz);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ox.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b ox = ox(i);
        long groupId = this.erk.getGroupId(ox.erv.ery);
        if (ox.erv.type == 2) {
            combinedChildId = this.erk.getCombinedGroupId(groupId);
        } else if (ox.erv.type == 1) {
            combinedChildId = this.erk.getCombinedChildId(groupId, this.erk.getChildId(ox.erv.ery, ox.erv.erz));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ox.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b ox = ox(i);
        if (ox.erv.type == 2) {
            childView = this.erk.getGroupView(ox.erv.ery, ox.awu(), view, viewGroup);
        } else if (ox.erv.type == 1) {
            childView = this.erk.getChildView(ox.erv.ery, ox.erv.erz, ox.erw.erp == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ox.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b ox = ox(i);
        com.baidu.tieba.horizonalList.widget.a aVar = ox.erv;
        if (this.erk instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.erk;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.ery);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.ery, aVar.erz);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        ox.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.erk instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.erk;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.erk.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.erl;
        int size = arrayList.size();
        this.erm = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int l = l(groupMetadata.ers, groupMetadata.erq);
                if (l != groupMetadata.erq) {
                    if (l == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.erq = l;
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
            if (groupMetadata2.erp == -1 || z) {
                childrenCount = this.erk.getChildrenCount(groupMetadata2.erq);
            } else {
                childrenCount = groupMetadata2.erp - groupMetadata2.ero;
            }
            this.erm += childrenCount;
            int i5 = i4 + (groupMetadata2.erq - i3);
            i3 = groupMetadata2.erq;
            groupMetadata2.ero = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.erp = i6;
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
        if (bVar.erw == null) {
            return false;
        }
        this.erl.remove(bVar.erw);
        H(false, false);
        notifyDataSetChanged();
        this.erk.onGroupCollapsed(bVar.erw.erq);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.erv.ery < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.ern != 0 && bVar.erw == null) {
            if (this.erl.size() >= this.ern) {
                GroupMetadata groupMetadata = this.erl.get(0);
                int indexOf = this.erl.indexOf(groupMetadata);
                collapseGroup(groupMetadata.erq);
                if (bVar.erx > indexOf) {
                    bVar.erx--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.erv.ery, this.erk.getGroupId(bVar.erv.ery));
            this.erl.add(bVar.erx, b2);
            H(false, false);
            notifyDataSetChanged();
            this.erk.onGroupExpanded(b2.erq);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aJT() {
        return this.erk;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aJT = aJT();
        if (aJT instanceof Filterable) {
            return ((Filterable) aJT).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aJU() {
        return this.erl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.erk != null) {
            int groupCount = this.erk.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).erq >= groupCount) {
                    return;
                }
            }
            this.erl = arrayList;
            H(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aJT = aJT();
        if (aJT != null) {
            return aJT.isEmpty();
        }
        return true;
    }

    int l(long j, int i) {
        int groupCount = this.erk.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aJT = aJT();
        if (aJT == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aJT.getGroupId(i3) != j) {
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
            /* renamed from: oy */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int ero;
        int erp;
        int erq;
        long ers;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.ero = i;
            groupMetadata.erp = i2;
            groupMetadata.erq = i3;
            groupMetadata.ers = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.erq - groupMetadata.erq;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.ero);
            parcel.writeInt(this.erp);
            parcel.writeInt(this.erq);
            parcel.writeLong(this.ers);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> eru = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a erv;
        public GroupMetadata erw;
        public int erx;

        private void Tv() {
            if (this.erv != null) {
                this.erv.recycle();
                this.erv = null;
            }
            this.erw = null;
            this.erx = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aJV = aJV();
            aJV.erv = com.baidu.tieba.horizonalList.widget.a.s(i2, i3, i4, i);
            aJV.erw = groupMetadata;
            aJV.erx = i5;
            return aJV;
        }

        private static b aJV() {
            b bVar;
            synchronized (eru) {
                if (eru.size() > 0) {
                    bVar = eru.remove(0);
                    bVar.Tv();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            Tv();
            synchronized (eru) {
                if (eru.size() < 5) {
                    eru.add(this);
                }
            }
        }

        public boolean awu() {
            return this.erw != null;
        }
    }
}
