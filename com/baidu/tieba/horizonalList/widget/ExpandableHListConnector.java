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
    private ExpandableListAdapter cFA;
    private int cFC;
    private int cFD = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> cFB = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.cFA != null) {
            this.cFA.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.cFA = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b kt(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.cFB;
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
            if (i > groupMetadata.cFF) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.cFE) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.cFE) {
                return b.a(i, 2, groupMetadata.cFG, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.cFF) {
                    return b.a(i, 1, groupMetadata.cFG, i - (groupMetadata.cFE + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.cFF) + groupMetadata2.cFG;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.cFG - (groupMetadata3.cFE - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(i iVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cFB;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(iVar.cFN, iVar.type, iVar.cFN, iVar.cFO, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (iVar.cFN > groupMetadata.cFG) {
                i4 = i + 1;
            } else if (iVar.cFN < groupMetadata.cFG) {
                i3 = i - 1;
            } else if (iVar.cFN == groupMetadata.cFG) {
                if (iVar.type == 2) {
                    return b.a(groupMetadata.cFE, iVar.type, iVar.cFN, iVar.cFO, groupMetadata, i);
                }
                if (iVar.type == 1) {
                    return b.a(groupMetadata.cFE + iVar.cFO + 1, iVar.type, iVar.cFN, iVar.cFO, groupMetadata, i);
                }
                return null;
            }
        }
        if (iVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((iVar.cFN - groupMetadata2.cFG) + groupMetadata2.cFF, iVar.type, iVar.cFN, iVar.cFO, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.cFE - (groupMetadata3.cFG - iVar.cFN), iVar.type, iVar.cFN, iVar.cFO, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.cFA.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b kt = kt(i);
        i iVar = kt.cFK;
        boolean isChildSelectable = iVar.type == 1 ? this.cFA.isChildSelectable(iVar.cFN, iVar.cFO) : true;
        kt.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cFA.getGroupCount() + this.cFC;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b kt = kt(i);
        if (kt.cFK.type == 2) {
            child = this.cFA.getGroup(kt.cFK.cFN);
        } else if (kt.cFK.type == 1) {
            child = this.cFA.getChild(kt.cFK.cFN, kt.cFK.cFO);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kt.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b kt = kt(i);
        long groupId = this.cFA.getGroupId(kt.cFK.cFN);
        if (kt.cFK.type == 2) {
            combinedChildId = this.cFA.getCombinedGroupId(groupId);
        } else if (kt.cFK.type == 1) {
            combinedChildId = this.cFA.getCombinedChildId(groupId, this.cFA.getChildId(kt.cFK.cFN, kt.cFK.cFO));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kt.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b kt = kt(i);
        if (kt.cFK.type == 2) {
            childView = this.cFA.getGroupView(kt.cFK.cFN, kt.alW(), view, viewGroup);
        } else if (kt.cFK.type == 1) {
            childView = this.cFA.getChildView(kt.cFK.cFN, kt.cFK.cFO, kt.cFL.cFF == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kt.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b kt = kt(i);
        i iVar = kt.cFK;
        if (this.cFA instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cFA;
            if (iVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(iVar.cFN);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(iVar.cFN, iVar.cFO);
            }
        } else if (iVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        kt.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.cFA instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cFA;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.cFA.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cFB;
        int size = arrayList.size();
        this.cFC = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int h = h(groupMetadata.cFH, groupMetadata.cFG);
                if (h != groupMetadata.cFG) {
                    if (h == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.cFG = h;
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
            if (groupMetadata2.cFF == -1 || z) {
                childrenCount = this.cFA.getChildrenCount(groupMetadata2.cFG);
            } else {
                childrenCount = groupMetadata2.cFF - groupMetadata2.cFE;
            }
            this.cFC += childrenCount;
            int i5 = i4 + (groupMetadata2.cFG - i3);
            i3 = groupMetadata2.cFG;
            groupMetadata2.cFE = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.cFF = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        i k = i.k(2, i, -1, -1);
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
        if (bVar.cFL == null) {
            return false;
        }
        this.cFB.remove(bVar.cFL);
        o(false, false);
        notifyDataSetChanged();
        this.cFA.onGroupCollapsed(bVar.cFL.cFG);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.cFK.cFN < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.cFD != 0 && bVar.cFL == null) {
            if (this.cFB.size() >= this.cFD) {
                GroupMetadata groupMetadata = this.cFB.get(0);
                int indexOf = this.cFB.indexOf(groupMetadata);
                collapseGroup(groupMetadata.cFG);
                if (bVar.cFM > indexOf) {
                    bVar.cFM--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.cFK.cFN, this.cFA.getGroupId(bVar.cFK.cFN));
            this.cFB.add(bVar.cFM, a2);
            o(false, false);
            notifyDataSetChanged();
            this.cFA.onGroupExpanded(a2.cFG);
            return true;
        }
        return false;
    }

    ExpandableListAdapter alS() {
        return this.cFA;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter alS = alS();
        if (alS instanceof Filterable) {
            return ((Filterable) alS).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> alT() {
        return this.cFB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.cFA != null) {
            int groupCount = this.cFA.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).cFG >= groupCount) {
                    return;
                }
            }
            this.cFB = arrayList;
            o(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter alS = alS();
        if (alS != null) {
            return alS.isEmpty();
        }
        return true;
    }

    int h(long j, int i) {
        int groupCount = this.cFA.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter alS = alS();
        if (alS == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (alS.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.o(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.o(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new h();
        int cFE;
        int cFF;
        int cFG;
        long cFH;

        private GroupMetadata() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.cFE = i;
            groupMetadata.cFF = i2;
            groupMetadata.cFG = i3;
            groupMetadata.cFH = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.cFG - groupMetadata.cFG;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.cFE);
            parcel.writeInt(this.cFF);
            parcel.writeInt(this.cFG);
            parcel.writeLong(this.cFH);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> cFJ = new ArrayList<>(5);
        public i cFK;
        public GroupMetadata cFL;
        public int cFM;

        private void alU() {
            if (this.cFK != null) {
                this.cFK.recycle();
                this.cFK = null;
            }
            this.cFL = null;
            this.cFM = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b alV = alV();
            alV.cFK = i.k(i2, i3, i4, i);
            alV.cFL = groupMetadata;
            alV.cFM = i5;
            return alV;
        }

        private static b alV() {
            b bVar;
            synchronized (cFJ) {
                if (cFJ.size() > 0) {
                    bVar = cFJ.remove(0);
                    bVar.alU();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            alU();
            synchronized (cFJ) {
                if (cFJ.size() < 5) {
                    cFJ.add(this);
                }
            }
        }

        public boolean alW() {
            return this.cFL != null;
        }
    }
}
