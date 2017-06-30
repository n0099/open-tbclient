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
    private ExpandableListAdapter cNq;
    private int cNs;
    private int cNt = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> cNr = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.cNq != null) {
            this.cNq.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.cNq = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b kN(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.cNr;
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
            if (i > groupMetadata.cNv) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.cNu) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.cNu) {
                return b.a(i, 2, groupMetadata.cNw, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.cNv) {
                    return b.a(i, 1, groupMetadata.cNw, i - (groupMetadata.cNu + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.cNv) + groupMetadata2.cNw;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.cNw - (groupMetadata3.cNu - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(h hVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cNr;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(hVar.cND, hVar.type, hVar.cND, hVar.cNE, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (hVar.cND > groupMetadata.cNw) {
                i4 = i + 1;
            } else if (hVar.cND < groupMetadata.cNw) {
                i3 = i - 1;
            } else if (hVar.cND == groupMetadata.cNw) {
                if (hVar.type == 2) {
                    return b.a(groupMetadata.cNu, hVar.type, hVar.cND, hVar.cNE, groupMetadata, i);
                }
                if (hVar.type == 1) {
                    return b.a(groupMetadata.cNu + hVar.cNE + 1, hVar.type, hVar.cND, hVar.cNE, groupMetadata, i);
                }
                return null;
            }
        }
        if (hVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((hVar.cND - groupMetadata2.cNw) + groupMetadata2.cNv, hVar.type, hVar.cND, hVar.cNE, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.cNu - (groupMetadata3.cNw - hVar.cND), hVar.type, hVar.cND, hVar.cNE, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.cNq.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b kN = kN(i);
        h hVar = kN.cNA;
        boolean isChildSelectable = hVar.type == 1 ? this.cNq.isChildSelectable(hVar.cND, hVar.cNE) : true;
        kN.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cNq.getGroupCount() + this.cNs;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b kN = kN(i);
        if (kN.cNA.type == 2) {
            child = this.cNq.getGroup(kN.cNA.cND);
        } else if (kN.cNA.type == 1) {
            child = this.cNq.getChild(kN.cNA.cND, kN.cNA.cNE);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kN.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b kN = kN(i);
        long groupId = this.cNq.getGroupId(kN.cNA.cND);
        if (kN.cNA.type == 2) {
            combinedChildId = this.cNq.getCombinedGroupId(groupId);
        } else if (kN.cNA.type == 1) {
            combinedChildId = this.cNq.getCombinedChildId(groupId, this.cNq.getChildId(kN.cNA.cND, kN.cNA.cNE));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kN.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b kN = kN(i);
        if (kN.cNA.type == 2) {
            childView = this.cNq.getGroupView(kN.cNA.cND, kN.anx(), view, viewGroup);
        } else if (kN.cNA.type == 1) {
            childView = this.cNq.getChildView(kN.cNA.cND, kN.cNA.cNE, kN.cNB.cNv == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kN.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b kN = kN(i);
        h hVar = kN.cNA;
        if (this.cNq instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cNq;
            if (hVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(hVar.cND);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(hVar.cND, hVar.cNE);
            }
        } else if (hVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        kN.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.cNq instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cNq;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.cNq.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cNr;
        int size = arrayList.size();
        this.cNs = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int g = g(groupMetadata.cNx, groupMetadata.cNw);
                if (g != groupMetadata.cNw) {
                    if (g == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.cNw = g;
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
            if (groupMetadata2.cNv == -1 || z) {
                childrenCount = this.cNq.getChildrenCount(groupMetadata2.cNw);
            } else {
                childrenCount = groupMetadata2.cNv - groupMetadata2.cNu;
            }
            this.cNs += childrenCount;
            int i5 = i4 + (groupMetadata2.cNw - i3);
            i3 = groupMetadata2.cNw;
            groupMetadata2.cNu = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.cNv = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        h k = h.k(2, i, -1, -1);
        b a2 = a(k);
        k.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.cNB == null) {
            return false;
        }
        this.cNr.remove(bVar.cNB);
        s(false, false);
        notifyDataSetChanged();
        this.cNq.onGroupCollapsed(bVar.cNB.cNw);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.cNA.cND < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.cNt != 0 && bVar.cNB == null) {
            if (this.cNr.size() >= this.cNt) {
                GroupMetadata groupMetadata = this.cNr.get(0);
                int indexOf = this.cNr.indexOf(groupMetadata);
                collapseGroup(groupMetadata.cNw);
                if (bVar.cNC > indexOf) {
                    bVar.cNC--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.cNA.cND, this.cNq.getGroupId(bVar.cNA.cND));
            this.cNr.add(bVar.cNC, a2);
            s(false, false);
            notifyDataSetChanged();
            this.cNq.onGroupExpanded(a2.cNw);
            return true;
        }
        return false;
    }

    ExpandableListAdapter ant() {
        return this.cNq;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter ant = ant();
        if (ant instanceof Filterable) {
            return ((Filterable) ant).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> anu() {
        return this.cNr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.cNq != null) {
            int groupCount = this.cNq.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).cNw >= groupCount) {
                    return;
                }
            }
            this.cNr = arrayList;
            s(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter ant = ant();
        if (ant != null) {
            return ant.isEmpty();
        }
        return true;
    }

    int g(long j, int i) {
        int groupCount = this.cNq.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter ant = ant();
        if (ant == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (ant.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.s(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.s(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new g();
        int cNu;
        int cNv;
        int cNw;
        long cNx;

        private GroupMetadata() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.cNu = i;
            groupMetadata.cNv = i2;
            groupMetadata.cNw = i3;
            groupMetadata.cNx = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.cNw - groupMetadata.cNw;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.cNu);
            parcel.writeInt(this.cNv);
            parcel.writeInt(this.cNw);
            parcel.writeLong(this.cNx);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> cNz = new ArrayList<>(5);
        public h cNA;
        public GroupMetadata cNB;
        public int cNC;

        private void anv() {
            if (this.cNA != null) {
                this.cNA.recycle();
                this.cNA = null;
            }
            this.cNB = null;
            this.cNC = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b anw = anw();
            anw.cNA = h.k(i2, i3, i4, i);
            anw.cNB = groupMetadata;
            anw.cNC = i5;
            return anw;
        }

        private static b anw() {
            b bVar;
            synchronized (cNz) {
                if (cNz.size() > 0) {
                    bVar = cNz.remove(0);
                    bVar.anv();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            anv();
            synchronized (cNz) {
                if (cNz.size() < 5) {
                    cNz.add(this);
                }
            }
        }

        public boolean anx() {
            return this.cNB != null;
        }
    }
}
