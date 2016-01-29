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
    private ExpandableListAdapter bHE;
    private int bHG;
    private int bHH = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> bHF = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.bHE != null) {
            this.bHE.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.bHE = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b ig(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.bHF;
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
            if (i > groupMetadata.bHJ) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.bHI) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.bHI) {
                return b.a(i, 2, groupMetadata.bHK, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.bHJ) {
                    return b.a(i, 1, groupMetadata.bHK, i - (groupMetadata.bHI + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.bHJ) + groupMetadata2.bHK;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.bHK - (groupMetadata3.bHI - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(i iVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.bHF;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(iVar.bHR, iVar.type, iVar.bHR, iVar.bHS, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (iVar.bHR > groupMetadata.bHK) {
                i4 = i + 1;
            } else if (iVar.bHR < groupMetadata.bHK) {
                i3 = i - 1;
            } else if (iVar.bHR == groupMetadata.bHK) {
                if (iVar.type == 2) {
                    return b.a(groupMetadata.bHI, iVar.type, iVar.bHR, iVar.bHS, groupMetadata, i);
                }
                if (iVar.type == 1) {
                    return b.a(groupMetadata.bHI + iVar.bHS + 1, iVar.type, iVar.bHR, iVar.bHS, groupMetadata, i);
                }
                return null;
            }
        }
        if (iVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((iVar.bHR - groupMetadata2.bHK) + groupMetadata2.bHJ, iVar.type, iVar.bHR, iVar.bHS, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.bHI - (groupMetadata3.bHK - iVar.bHR), iVar.type, iVar.bHR, iVar.bHS, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.bHE.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b ig = ig(i);
        i iVar = ig.bHO;
        boolean isChildSelectable = iVar.type == 1 ? this.bHE.isChildSelectable(iVar.bHR, iVar.bHS) : true;
        ig.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bHE.getGroupCount() + this.bHG;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b ig = ig(i);
        if (ig.bHO.type == 2) {
            child = this.bHE.getGroup(ig.bHO.bHR);
        } else if (ig.bHO.type == 1) {
            child = this.bHE.getChild(ig.bHO.bHR, ig.bHO.bHS);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ig.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b ig = ig(i);
        long groupId = this.bHE.getGroupId(ig.bHO.bHR);
        if (ig.bHO.type == 2) {
            combinedChildId = this.bHE.getCombinedGroupId(groupId);
        } else if (ig.bHO.type == 1) {
            combinedChildId = this.bHE.getCombinedChildId(groupId, this.bHE.getChildId(ig.bHO.bHR, ig.bHO.bHS));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ig.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b ig = ig(i);
        if (ig.bHO.type == 2) {
            childView = this.bHE.getGroupView(ig.bHO.bHR, ig.pV(), view, viewGroup);
        } else if (ig.bHO.type == 1) {
            childView = this.bHE.getChildView(ig.bHO.bHR, ig.bHO.bHS, ig.bHP.bHJ == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ig.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b ig = ig(i);
        i iVar = ig.bHO;
        if (this.bHE instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bHE;
            if (iVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(iVar.bHR);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(iVar.bHR, iVar.bHS);
            }
        } else if (iVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        ig.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.bHE instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bHE;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.bHE.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.bHF;
        int size = arrayList.size();
        this.bHG = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int b2 = b(groupMetadata.bHL, groupMetadata.bHK);
                if (b2 != groupMetadata.bHK) {
                    if (b2 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.bHK = b2;
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
            if (groupMetadata2.bHJ == -1 || z) {
                childrenCount = this.bHE.getChildrenCount(groupMetadata2.bHK);
            } else {
                childrenCount = groupMetadata2.bHJ - groupMetadata2.bHI;
            }
            this.bHG += childrenCount;
            int i5 = i4 + (groupMetadata2.bHK - i3);
            i3 = groupMetadata2.bHK;
            groupMetadata2.bHI = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.bHJ = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        i j = i.j(2, i, -1, -1);
        b a2 = a(j);
        j.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.bHP == null) {
            return false;
        }
        this.bHF.remove(bVar.bHP);
        j(false, false);
        notifyDataSetChanged();
        this.bHE.onGroupCollapsed(bVar.bHP.bHK);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.bHO.bHR < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.bHH != 0 && bVar.bHP == null) {
            if (this.bHF.size() >= this.bHH) {
                GroupMetadata groupMetadata = this.bHF.get(0);
                int indexOf = this.bHF.indexOf(groupMetadata);
                collapseGroup(groupMetadata.bHK);
                if (bVar.bHQ > indexOf) {
                    bVar.bHQ--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.bHO.bHR, this.bHE.getGroupId(bVar.bHO.bHR));
            this.bHF.add(bVar.bHQ, a2);
            j(false, false);
            notifyDataSetChanged();
            this.bHE.onGroupExpanded(a2.bHK);
            return true;
        }
        return false;
    }

    ExpandableListAdapter Xb() {
        return this.bHE;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter Xb = Xb();
        if (Xb instanceof Filterable) {
            return ((Filterable) Xb).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> Xc() {
        return this.bHF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.bHE != null) {
            int groupCount = this.bHE.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).bHK >= groupCount) {
                    return;
                }
            }
            this.bHF = arrayList;
            j(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter Xb = Xb();
        if (Xb != null) {
            return Xb.isEmpty();
        }
        return true;
    }

    int b(long j, int i) {
        int groupCount = this.bHE.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter Xb = Xb();
        if (Xb == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (Xb.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.j(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.j(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new h();
        int bHI;
        int bHJ;
        int bHK;
        long bHL;

        private GroupMetadata() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.bHI = i;
            groupMetadata.bHJ = i2;
            groupMetadata.bHK = i3;
            groupMetadata.bHL = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.bHK - groupMetadata.bHK;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.bHI);
            parcel.writeInt(this.bHJ);
            parcel.writeInt(this.bHK);
            parcel.writeLong(this.bHL);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> bHN = new ArrayList<>(5);
        public i bHO;
        public GroupMetadata bHP;
        public int bHQ;

        private void Xd() {
            if (this.bHO != null) {
                this.bHO.recycle();
                this.bHO = null;
            }
            this.bHP = null;
            this.bHQ = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b Xe = Xe();
            Xe.bHO = i.j(i2, i3, i4, i);
            Xe.bHP = groupMetadata;
            Xe.bHQ = i5;
            return Xe;
        }

        private static b Xe() {
            b bVar;
            synchronized (bHN) {
                if (bHN.size() > 0) {
                    bVar = bHN.remove(0);
                    bVar.Xd();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            Xd();
            synchronized (bHN) {
                if (bHN.size() < 5) {
                    bHN.add(this);
                }
            }
        }

        public boolean pV() {
            return this.bHP != null;
        }
    }
}
