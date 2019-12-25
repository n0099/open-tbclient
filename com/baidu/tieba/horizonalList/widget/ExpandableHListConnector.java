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
    private ExpandableListAdapter auq;
    private int aus;
    private int aut = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> aur = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.auq != null) {
            this.auq.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.auq = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b vm(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.aur;
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
            if (i > groupMetadata.auv) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.auu) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.auu) {
                return b.a(i, 2, groupMetadata.auw, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.auv) {
                    return b.a(i, 1, groupMetadata.auw, i - (groupMetadata.auu + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.auv) + groupMetadata2.auw;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.auw - (groupMetadata3.auu - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.aur;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.auD, aVar.type, aVar.auD, aVar.auE, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.auD > groupMetadata.auw) {
                i4 = i + 1;
            } else if (aVar.auD < groupMetadata.auw) {
                i3 = i - 1;
            } else if (aVar.auD == groupMetadata.auw) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.auu, aVar.type, aVar.auD, aVar.auE, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.auu + aVar.auE + 1, aVar.type, aVar.auD, aVar.auE, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.auD - groupMetadata2.auw) + groupMetadata2.auv, aVar.type, aVar.auD, aVar.auE, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.auu - (groupMetadata3.auw - aVar.auD), aVar.type, aVar.auD, aVar.auE, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.auq.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b vm = vm(i);
        com.baidu.tieba.horizonalList.widget.a aVar = vm.hea;
        boolean isChildSelectable = aVar.type == 1 ? this.auq.isChildSelectable(aVar.auD, aVar.auE) : true;
        vm.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.auq.getGroupCount() + this.aus;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b vm = vm(i);
        if (vm.hea.type == 2) {
            child = this.auq.getGroup(vm.hea.auD);
        } else if (vm.hea.type == 1) {
            child = this.auq.getChild(vm.hea.auD, vm.hea.auE);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        vm.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b vm = vm(i);
        long groupId = this.auq.getGroupId(vm.hea.auD);
        if (vm.hea.type == 2) {
            combinedChildId = this.auq.getCombinedGroupId(groupId);
        } else if (vm.hea.type == 1) {
            combinedChildId = this.auq.getCombinedChildId(groupId, this.auq.getChildId(vm.hea.auD, vm.hea.auE));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        vm.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b vm = vm(i);
        if (vm.hea.type == 2) {
            childView = this.auq.getGroupView(vm.hea.auD, vm.xg(), view, viewGroup);
        } else if (vm.hea.type == 1) {
            childView = this.auq.getChildView(vm.hea.auD, vm.hea.auE, vm.heb.auv == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        vm.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b vm = vm(i);
        com.baidu.tieba.horizonalList.widget.a aVar = vm.hea;
        if (this.auq instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.auq;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.auD);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.auD, aVar.auE);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        vm.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.auq instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.auq;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.auq.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.aur;
        int size = arrayList.size();
        this.aus = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int b2 = b(groupMetadata.aux, groupMetadata.auw);
                if (b2 != groupMetadata.auw) {
                    if (b2 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.auw = b2;
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
            if (groupMetadata2.auv == -1 || z) {
                childrenCount = this.auq.getChildrenCount(groupMetadata2.auw);
            } else {
                childrenCount = groupMetadata2.auv - groupMetadata2.auu;
            }
            this.aus += childrenCount;
            int i5 = i4 + (groupMetadata2.auw - i3);
            i3 = groupMetadata2.auw;
            groupMetadata2.auu = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.auv = i6;
            i++;
            i4 = i6;
        }
    }

    boolean ce(int i) {
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
        if (bVar.heb == null) {
            return false;
        }
        this.aur.remove(bVar.heb);
        f(false, false);
        notifyDataSetChanged();
        this.auq.onGroupCollapsed(bVar.heb.auw);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.hea.auD < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.aut != 0 && bVar.heb == null) {
            if (this.aur.size() >= this.aut) {
                GroupMetadata groupMetadata = this.aur.get(0);
                int indexOf = this.aur.indexOf(groupMetadata);
                ce(groupMetadata.auw);
                if (bVar.auC > indexOf) {
                    bVar.auC--;
                }
            }
            GroupMetadata c = GroupMetadata.c(-1, -1, bVar.hea.auD, this.auq.getGroupId(bVar.hea.auD));
            this.aur.add(bVar.auC, c);
            f(false, false);
            notifyDataSetChanged();
            this.auq.onGroupExpanded(c.auw);
            return true;
        }
        return false;
    }

    ExpandableListAdapter xd() {
        return this.auq;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter xd = xd();
        if (xd instanceof Filterable) {
            return ((Filterable) xd).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> xe() {
        return this.aur;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.auq != null) {
            int groupCount = this.auq.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).auw >= groupCount) {
                    return;
                }
            }
            this.aur = arrayList;
            f(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter xd = xd();
        if (xd != null) {
            return xd.isEmpty();
        }
        return true;
    }

    int b(long j, int i) {
        int groupCount = this.auq.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter xd = xd();
        if (xd == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (xd.getGroupId(i3) != j) {
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
            /* renamed from: ac */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.c(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: vn */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int auu;
        int auv;
        int auw;
        long aux;

        private GroupMetadata() {
        }

        static GroupMetadata c(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.auu = i;
            groupMetadata.auv = i2;
            groupMetadata.auw = i3;
            groupMetadata.aux = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.auw - groupMetadata.auw;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.auu);
            parcel.writeInt(this.auv);
            parcel.writeInt(this.auw);
            parcel.writeLong(this.aux);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> auz = new ArrayList<>(5);
        public int auC;
        public com.baidu.tieba.horizonalList.widget.a hea;
        public GroupMetadata heb;

        private void resetState() {
            if (this.hea != null) {
                this.hea.recycle();
                this.hea = null;
            }
            this.heb = null;
            this.auC = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b bMX = bMX();
            bMX.hea = com.baidu.tieba.horizonalList.widget.a.A(i2, i3, i4, i);
            bMX.heb = groupMetadata;
            bMX.auC = i5;
            return bMX;
        }

        private static b bMX() {
            b bVar;
            synchronized (auz) {
                if (auz.size() > 0) {
                    bVar = auz.remove(0);
                    bVar.resetState();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            resetState();
            synchronized (auz) {
                if (auz.size() < 5) {
                    auz.add(this);
                }
            }
        }

        public boolean xg() {
            return this.heb != null;
        }
    }
}
