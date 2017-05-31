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
    private ExpandableListAdapter cFt;
    private int cFv;
    private int cFw = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> cFu = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.cFt != null) {
            this.cFt.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.cFt = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b kC(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.cFu;
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
            if (i > groupMetadata.cFy) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.cFx) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.cFx) {
                return b.a(i, 2, groupMetadata.cFz, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.cFy) {
                    return b.a(i, 1, groupMetadata.cFz, i - (groupMetadata.cFx + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.cFy) + groupMetadata2.cFz;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.cFz - (groupMetadata3.cFx - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(h hVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cFu;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(hVar.cFG, hVar.type, hVar.cFG, hVar.cFH, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (hVar.cFG > groupMetadata.cFz) {
                i4 = i + 1;
            } else if (hVar.cFG < groupMetadata.cFz) {
                i3 = i - 1;
            } else if (hVar.cFG == groupMetadata.cFz) {
                if (hVar.type == 2) {
                    return b.a(groupMetadata.cFx, hVar.type, hVar.cFG, hVar.cFH, groupMetadata, i);
                }
                if (hVar.type == 1) {
                    return b.a(groupMetadata.cFx + hVar.cFH + 1, hVar.type, hVar.cFG, hVar.cFH, groupMetadata, i);
                }
                return null;
            }
        }
        if (hVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((hVar.cFG - groupMetadata2.cFz) + groupMetadata2.cFy, hVar.type, hVar.cFG, hVar.cFH, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.cFx - (groupMetadata3.cFz - hVar.cFG), hVar.type, hVar.cFG, hVar.cFH, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.cFt.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b kC = kC(i);
        h hVar = kC.cFD;
        boolean isChildSelectable = hVar.type == 1 ? this.cFt.isChildSelectable(hVar.cFG, hVar.cFH) : true;
        kC.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cFt.getGroupCount() + this.cFv;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b kC = kC(i);
        if (kC.cFD.type == 2) {
            child = this.cFt.getGroup(kC.cFD.cFG);
        } else if (kC.cFD.type == 1) {
            child = this.cFt.getChild(kC.cFD.cFG, kC.cFD.cFH);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kC.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b kC = kC(i);
        long groupId = this.cFt.getGroupId(kC.cFD.cFG);
        if (kC.cFD.type == 2) {
            combinedChildId = this.cFt.getCombinedGroupId(groupId);
        } else if (kC.cFD.type == 1) {
            combinedChildId = this.cFt.getCombinedChildId(groupId, this.cFt.getChildId(kC.cFD.cFG, kC.cFD.cFH));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kC.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b kC = kC(i);
        if (kC.cFD.type == 2) {
            childView = this.cFt.getGroupView(kC.cFD.cFG, kC.ajM(), view, viewGroup);
        } else if (kC.cFD.type == 1) {
            childView = this.cFt.getChildView(kC.cFD.cFG, kC.cFD.cFH, kC.cFE.cFy == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kC.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b kC = kC(i);
        h hVar = kC.cFD;
        if (this.cFt instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cFt;
            if (hVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(hVar.cFG);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(hVar.cFG, hVar.cFH);
            }
        } else if (hVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        kC.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.cFt instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cFt;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.cFt.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cFu;
        int size = arrayList.size();
        this.cFv = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int g = g(groupMetadata.cFA, groupMetadata.cFz);
                if (g != groupMetadata.cFz) {
                    if (g == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.cFz = g;
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
            if (groupMetadata2.cFy == -1 || z) {
                childrenCount = this.cFt.getChildrenCount(groupMetadata2.cFz);
            } else {
                childrenCount = groupMetadata2.cFy - groupMetadata2.cFx;
            }
            this.cFv += childrenCount;
            int i5 = i4 + (groupMetadata2.cFz - i3);
            i3 = groupMetadata2.cFz;
            groupMetadata2.cFx = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.cFy = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        h i2 = h.i(2, i, -1, -1);
        b a2 = a(i2);
        i2.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.cFE == null) {
            return false;
        }
        this.cFu.remove(bVar.cFE);
        r(false, false);
        notifyDataSetChanged();
        this.cFt.onGroupCollapsed(bVar.cFE.cFz);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.cFD.cFG < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.cFw != 0 && bVar.cFE == null) {
            if (this.cFu.size() >= this.cFw) {
                GroupMetadata groupMetadata = this.cFu.get(0);
                int indexOf = this.cFu.indexOf(groupMetadata);
                collapseGroup(groupMetadata.cFz);
                if (bVar.cFF > indexOf) {
                    bVar.cFF--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.cFD.cFG, this.cFt.getGroupId(bVar.cFD.cFG));
            this.cFu.add(bVar.cFF, a2);
            r(false, false);
            notifyDataSetChanged();
            this.cFt.onGroupExpanded(a2.cFz);
            return true;
        }
        return false;
    }

    ExpandableListAdapter ajI() {
        return this.cFt;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter ajI = ajI();
        if (ajI instanceof Filterable) {
            return ((Filterable) ajI).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> ajJ() {
        return this.cFu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.cFt != null) {
            int groupCount = this.cFt.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).cFz >= groupCount) {
                    return;
                }
            }
            this.cFu = arrayList;
            r(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter ajI = ajI();
        if (ajI != null) {
            return ajI.isEmpty();
        }
        return true;
    }

    int g(long j, int i) {
        int groupCount = this.cFt.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter ajI = ajI();
        if (ajI == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (ajI.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.r(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.r(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new g();
        long cFA;
        int cFx;
        int cFy;
        int cFz;

        private GroupMetadata() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.cFx = i;
            groupMetadata.cFy = i2;
            groupMetadata.cFz = i3;
            groupMetadata.cFA = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.cFz - groupMetadata.cFz;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.cFx);
            parcel.writeInt(this.cFy);
            parcel.writeInt(this.cFz);
            parcel.writeLong(this.cFA);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> cFC = new ArrayList<>(5);
        public h cFD;
        public GroupMetadata cFE;
        public int cFF;

        private void ajK() {
            if (this.cFD != null) {
                this.cFD.recycle();
                this.cFD = null;
            }
            this.cFE = null;
            this.cFF = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b ajL = ajL();
            ajL.cFD = h.i(i2, i3, i4, i);
            ajL.cFE = groupMetadata;
            ajL.cFF = i5;
            return ajL;
        }

        private static b ajL() {
            b bVar;
            synchronized (cFC) {
                if (cFC.size() > 0) {
                    bVar = cFC.remove(0);
                    bVar.ajK();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            ajK();
            synchronized (cFC) {
                if (cFC.size() < 5) {
                    cFC.add(this);
                }
            }
        }

        public boolean ajM() {
            return this.cFE != null;
        }
    }
}
