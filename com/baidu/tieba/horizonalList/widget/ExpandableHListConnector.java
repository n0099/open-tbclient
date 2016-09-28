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
    private ExpandableListAdapter cLN;
    private int cLP;
    private int cLQ = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> cLO = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.cLN != null) {
            this.cLN.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.cLN = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b kE(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.cLO;
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
            if (i > groupMetadata.cLS) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.cLR) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.cLR) {
                return b.a(i, 2, groupMetadata.cLT, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.cLS) {
                    return b.a(i, 1, groupMetadata.cLT, i - (groupMetadata.cLR + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.cLS) + groupMetadata2.cLT;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.cLT - (groupMetadata3.cLR - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(i iVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cLO;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(iVar.cMa, iVar.type, iVar.cMa, iVar.cMb, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (iVar.cMa > groupMetadata.cLT) {
                i4 = i + 1;
            } else if (iVar.cMa < groupMetadata.cLT) {
                i3 = i - 1;
            } else if (iVar.cMa == groupMetadata.cLT) {
                if (iVar.type == 2) {
                    return b.a(groupMetadata.cLR, iVar.type, iVar.cMa, iVar.cMb, groupMetadata, i);
                }
                if (iVar.type == 1) {
                    return b.a(groupMetadata.cLR + iVar.cMb + 1, iVar.type, iVar.cMa, iVar.cMb, groupMetadata, i);
                }
                return null;
            }
        }
        if (iVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((iVar.cMa - groupMetadata2.cLT) + groupMetadata2.cLS, iVar.type, iVar.cMa, iVar.cMb, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.cLR - (groupMetadata3.cLT - iVar.cMa), iVar.type, iVar.cMa, iVar.cMb, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.cLN.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b kE = kE(i);
        i iVar = kE.cLX;
        boolean isChildSelectable = iVar.type == 1 ? this.cLN.isChildSelectable(iVar.cMa, iVar.cMb) : true;
        kE.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cLN.getGroupCount() + this.cLP;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b kE = kE(i);
        if (kE.cLX.type == 2) {
            child = this.cLN.getGroup(kE.cLX.cMa);
        } else if (kE.cLX.type == 1) {
            child = this.cLN.getChild(kE.cLX.cMa, kE.cLX.cMb);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kE.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b kE = kE(i);
        long groupId = this.cLN.getGroupId(kE.cLX.cMa);
        if (kE.cLX.type == 2) {
            combinedChildId = this.cLN.getCombinedGroupId(groupId);
        } else if (kE.cLX.type == 1) {
            combinedChildId = this.cLN.getCombinedChildId(groupId, this.cLN.getChildId(kE.cLX.cMa, kE.cLX.cMb));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kE.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b kE = kE(i);
        if (kE.cLX.type == 2) {
            childView = this.cLN.getGroupView(kE.cLX.cMa, kE.aom(), view, viewGroup);
        } else if (kE.cLX.type == 1) {
            childView = this.cLN.getChildView(kE.cLX.cMa, kE.cLX.cMb, kE.cLY.cLS == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kE.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b kE = kE(i);
        i iVar = kE.cLX;
        if (this.cLN instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cLN;
            if (iVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(iVar.cMa);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(iVar.cMa, iVar.cMb);
            }
        } else if (iVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        kE.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.cLN instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cLN;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.cLN.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cLO;
        int size = arrayList.size();
        this.cLP = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int i3 = i(groupMetadata.cLU, groupMetadata.cLT);
                if (i3 != groupMetadata.cLT) {
                    if (i3 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.cLT = i3;
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
        int i4 = 0;
        int i5 = 0;
        while (i < size) {
            GroupMetadata groupMetadata2 = arrayList.get(i);
            if (groupMetadata2.cLS == -1 || z) {
                childrenCount = this.cLN.getChildrenCount(groupMetadata2.cLT);
            } else {
                childrenCount = groupMetadata2.cLS - groupMetadata2.cLR;
            }
            this.cLP += childrenCount;
            int i6 = i5 + (groupMetadata2.cLT - i4);
            i4 = groupMetadata2.cLT;
            groupMetadata2.cLR = i6;
            int i7 = childrenCount + i6;
            groupMetadata2.cLS = i7;
            i++;
            i5 = i7;
        }
    }

    boolean collapseGroup(int i) {
        i m = i.m(2, i, -1, -1);
        b a2 = a(m);
        m.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.cLY == null) {
            return false;
        }
        this.cLO.remove(bVar.cLY);
        q(false, false);
        notifyDataSetChanged();
        this.cLN.onGroupCollapsed(bVar.cLY.cLT);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.cLX.cMa < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.cLQ != 0 && bVar.cLY == null) {
            if (this.cLO.size() >= this.cLQ) {
                GroupMetadata groupMetadata = this.cLO.get(0);
                int indexOf = this.cLO.indexOf(groupMetadata);
                collapseGroup(groupMetadata.cLT);
                if (bVar.cLZ > indexOf) {
                    bVar.cLZ--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.cLX.cMa, this.cLN.getGroupId(bVar.cLX.cMa));
            this.cLO.add(bVar.cLZ, a2);
            q(false, false);
            notifyDataSetChanged();
            this.cLN.onGroupExpanded(a2.cLT);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aoi() {
        return this.cLN;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aoi = aoi();
        if (aoi instanceof Filterable) {
            return ((Filterable) aoi).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aoj() {
        return this.cLO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.cLN != null) {
            int groupCount = this.cLN.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).cLT >= groupCount) {
                    return;
                }
            }
            this.cLO = arrayList;
            q(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aoi = aoi();
        if (aoi != null) {
            return aoi.isEmpty();
        }
        return true;
    }

    int i(long j, int i) {
        int groupCount = this.cLN.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aoi = aoi();
        if (aoi == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aoi.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.q(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.q(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new h();
        int cLR;
        int cLS;
        int cLT;
        long cLU;

        private GroupMetadata() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.cLR = i;
            groupMetadata.cLS = i2;
            groupMetadata.cLT = i3;
            groupMetadata.cLU = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.cLT - groupMetadata.cLT;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.cLR);
            parcel.writeInt(this.cLS);
            parcel.writeInt(this.cLT);
            parcel.writeLong(this.cLU);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> cLW = new ArrayList<>(5);
        public i cLX;
        public GroupMetadata cLY;
        public int cLZ;

        private void aok() {
            if (this.cLX != null) {
                this.cLX.recycle();
                this.cLX = null;
            }
            this.cLY = null;
            this.cLZ = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aol = aol();
            aol.cLX = i.m(i2, i3, i4, i);
            aol.cLY = groupMetadata;
            aol.cLZ = i5;
            return aol;
        }

        private static b aol() {
            b bVar;
            synchronized (cLW) {
                if (cLW.size() > 0) {
                    bVar = cLW.remove(0);
                    bVar.aok();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            aok();
            synchronized (cLW) {
                if (cLW.size() < 5) {
                    cLW.add(this);
                }
            }
        }

        public boolean aom() {
            return this.cLY != null;
        }
    }
}
