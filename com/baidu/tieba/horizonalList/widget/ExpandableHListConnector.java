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
    private ExpandableListAdapter azs;
    private int azu;
    private int azv = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> azt = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.azs != null) {
            this.azs.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.azs = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b vx(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.azt;
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
            if (i > groupMetadata.azx) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.azw) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.azw) {
                return b.a(i, 2, groupMetadata.azy, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.azx) {
                    return b.a(i, 1, groupMetadata.azy, i - (groupMetadata.azw + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.azx) + groupMetadata2.azy;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.azy - (groupMetadata3.azw - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.azt;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.azF, aVar.type, aVar.azF, aVar.azG, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.azF > groupMetadata.azy) {
                i4 = i + 1;
            } else if (aVar.azF < groupMetadata.azy) {
                i3 = i - 1;
            } else if (aVar.azF == groupMetadata.azy) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.azw, aVar.type, aVar.azF, aVar.azG, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.azw + aVar.azG + 1, aVar.type, aVar.azF, aVar.azG, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.azF - groupMetadata2.azy) + groupMetadata2.azx, aVar.type, aVar.azF, aVar.azG, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.azw - (groupMetadata3.azy - aVar.azF), aVar.type, aVar.azF, aVar.azG, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.azs.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b vx = vx(i);
        com.baidu.tieba.horizonalList.widget.a aVar = vx.hjE;
        boolean isChildSelectable = aVar.type == 1 ? this.azs.isChildSelectable(aVar.azF, aVar.azG) : true;
        vx.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.azs.getGroupCount() + this.azu;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b vx = vx(i);
        if (vx.hjE.type == 2) {
            child = this.azs.getGroup(vx.hjE.azF);
        } else if (vx.hjE.type == 1) {
            child = this.azs.getChild(vx.hjE.azF, vx.hjE.azG);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        vx.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b vx = vx(i);
        long groupId = this.azs.getGroupId(vx.hjE.azF);
        if (vx.hjE.type == 2) {
            combinedChildId = this.azs.getCombinedGroupId(groupId);
        } else if (vx.hjE.type == 1) {
            combinedChildId = this.azs.getCombinedChildId(groupId, this.azs.getChildId(vx.hjE.azF, vx.hjE.azG));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        vx.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b vx = vx(i);
        if (vx.hjE.type == 2) {
            childView = this.azs.getGroupView(vx.hjE.azF, vx.zN(), view, viewGroup);
        } else if (vx.hjE.type == 1) {
            childView = this.azs.getChildView(vx.hjE.azF, vx.hjE.azG, vx.hjF.azx == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        vx.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b vx = vx(i);
        com.baidu.tieba.horizonalList.widget.a aVar = vx.hjE;
        if (this.azs instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.azs;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.azF);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.azF, aVar.azG);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        vx.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.azs instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.azs;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.azs.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.azt;
        int size = arrayList.size();
        this.azu = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int b2 = b(groupMetadata.azz, groupMetadata.azy);
                if (b2 != groupMetadata.azy) {
                    if (b2 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.azy = b2;
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
            if (groupMetadata2.azx == -1 || z) {
                childrenCount = this.azs.getChildrenCount(groupMetadata2.azy);
            } else {
                childrenCount = groupMetadata2.azx - groupMetadata2.azw;
            }
            this.azu += childrenCount;
            int i5 = i4 + (groupMetadata2.azy - i3);
            i3 = groupMetadata2.azy;
            groupMetadata2.azw = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.azx = i6;
            i++;
            i4 = i6;
        }
    }

    boolean cv(int i) {
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
        if (bVar.hjF == null) {
            return false;
        }
        this.azt.remove(bVar.hjF);
        g(false, false);
        notifyDataSetChanged();
        this.azs.onGroupCollapsed(bVar.hjF.azy);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.hjE.azF < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.azv != 0 && bVar.hjF == null) {
            if (this.azt.size() >= this.azv) {
                GroupMetadata groupMetadata = this.azt.get(0);
                int indexOf = this.azt.indexOf(groupMetadata);
                cv(groupMetadata.azy);
                if (bVar.azE > indexOf) {
                    bVar.azE--;
                }
            }
            GroupMetadata c = GroupMetadata.c(-1, -1, bVar.hjE.azF, this.azs.getGroupId(bVar.hjE.azF));
            this.azt.add(bVar.azE, c);
            g(false, false);
            notifyDataSetChanged();
            this.azs.onGroupExpanded(c.azy);
            return true;
        }
        return false;
    }

    ExpandableListAdapter zK() {
        return this.azs;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter zK = zK();
        if (zK instanceof Filterable) {
            return ((Filterable) zK).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> zL() {
        return this.azt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.azs != null) {
            int groupCount = this.azs.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).azy >= groupCount) {
                    return;
                }
            }
            this.azt = arrayList;
            g(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter zK = zK();
        if (zK != null) {
            return zK.isEmpty();
        }
        return true;
    }

    int b(long j, int i) {
        int groupCount = this.azs.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter zK = zK();
        if (zK == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (zK.getGroupId(i3) != j) {
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
            /* renamed from: ac */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.c(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: vy */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int azw;
        int azx;
        int azy;
        long azz;

        private GroupMetadata() {
        }

        static GroupMetadata c(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.azw = i;
            groupMetadata.azx = i2;
            groupMetadata.azy = i3;
            groupMetadata.azz = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.azy - groupMetadata.azy;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.azw);
            parcel.writeInt(this.azx);
            parcel.writeInt(this.azy);
            parcel.writeLong(this.azz);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> azB = new ArrayList<>(5);
        public int azE;
        public com.baidu.tieba.horizonalList.widget.a hjE;
        public GroupMetadata hjF;

        private void resetState() {
            if (this.hjE != null) {
                this.hjE.recycle();
                this.hjE = null;
            }
            this.hjF = null;
            this.azE = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b bPI = bPI();
            bPI.hjE = com.baidu.tieba.horizonalList.widget.a.A(i2, i3, i4, i);
            bPI.hjF = groupMetadata;
            bPI.azE = i5;
            return bPI;
        }

        private static b bPI() {
            b bVar;
            synchronized (azB) {
                if (azB.size() > 0) {
                    bVar = azB.remove(0);
                    bVar.resetState();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            resetState();
            synchronized (azB) {
                if (azB.size() < 5) {
                    azB.add(this);
                }
            }
        }

        public boolean zN() {
            return this.hjF != null;
        }
    }
}
