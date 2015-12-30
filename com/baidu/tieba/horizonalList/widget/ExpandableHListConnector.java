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
    private ExpandableListAdapter bEs;
    private int bEu;
    private int bEv = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> bEt = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.bEs != null) {
            this.bEs.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.bEs = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b hJ(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.bEt;
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
            if (i > groupMetadata.bEx) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.bEw) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.bEw) {
                return b.a(i, 2, groupMetadata.bEy, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.bEx) {
                    return b.a(i, 1, groupMetadata.bEy, i - (groupMetadata.bEw + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.bEx) + groupMetadata2.bEy;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.bEy - (groupMetadata3.bEw - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(i iVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.bEt;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(iVar.bEF, iVar.type, iVar.bEF, iVar.bEG, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (iVar.bEF > groupMetadata.bEy) {
                i4 = i + 1;
            } else if (iVar.bEF < groupMetadata.bEy) {
                i3 = i - 1;
            } else if (iVar.bEF == groupMetadata.bEy) {
                if (iVar.type == 2) {
                    return b.a(groupMetadata.bEw, iVar.type, iVar.bEF, iVar.bEG, groupMetadata, i);
                }
                if (iVar.type == 1) {
                    return b.a(groupMetadata.bEw + iVar.bEG + 1, iVar.type, iVar.bEF, iVar.bEG, groupMetadata, i);
                }
                return null;
            }
        }
        if (iVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((iVar.bEF - groupMetadata2.bEy) + groupMetadata2.bEx, iVar.type, iVar.bEF, iVar.bEG, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.bEw - (groupMetadata3.bEy - iVar.bEF), iVar.type, iVar.bEF, iVar.bEG, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.bEs.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b hJ = hJ(i);
        i iVar = hJ.bEC;
        boolean isChildSelectable = iVar.type == 1 ? this.bEs.isChildSelectable(iVar.bEF, iVar.bEG) : true;
        hJ.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bEs.getGroupCount() + this.bEu;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b hJ = hJ(i);
        if (hJ.bEC.type == 2) {
            child = this.bEs.getGroup(hJ.bEC.bEF);
        } else if (hJ.bEC.type == 1) {
            child = this.bEs.getChild(hJ.bEC.bEF, hJ.bEC.bEG);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        hJ.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b hJ = hJ(i);
        long groupId = this.bEs.getGroupId(hJ.bEC.bEF);
        if (hJ.bEC.type == 2) {
            combinedChildId = this.bEs.getCombinedGroupId(groupId);
        } else if (hJ.bEC.type == 1) {
            combinedChildId = this.bEs.getCombinedChildId(groupId, this.bEs.getChildId(hJ.bEC.bEF, hJ.bEC.bEG));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        hJ.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b hJ = hJ(i);
        if (hJ.bEC.type == 2) {
            childView = this.bEs.getGroupView(hJ.bEC.bEF, hJ.pq(), view, viewGroup);
        } else if (hJ.bEC.type == 1) {
            childView = this.bEs.getChildView(hJ.bEC.bEF, hJ.bEC.bEG, hJ.bED.bEx == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        hJ.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b hJ = hJ(i);
        i iVar = hJ.bEC;
        if (this.bEs instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bEs;
            if (iVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(iVar.bEF);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(iVar.bEF, iVar.bEG);
            }
        } else if (iVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        hJ.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.bEs instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bEs;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.bEs.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.bEt;
        int size = arrayList.size();
        this.bEu = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int b2 = b(groupMetadata.bEz, groupMetadata.bEy);
                if (b2 != groupMetadata.bEy) {
                    if (b2 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.bEy = b2;
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
            if (groupMetadata2.bEx == -1 || z) {
                childrenCount = this.bEs.getChildrenCount(groupMetadata2.bEy);
            } else {
                childrenCount = groupMetadata2.bEx - groupMetadata2.bEw;
            }
            this.bEu += childrenCount;
            int i5 = i4 + (groupMetadata2.bEy - i3);
            i3 = groupMetadata2.bEy;
            groupMetadata2.bEw = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.bEx = i6;
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
        if (bVar.bED == null) {
            return false;
        }
        this.bEt.remove(bVar.bED);
        h(false, false);
        notifyDataSetChanged();
        this.bEs.onGroupCollapsed(bVar.bED.bEy);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.bEC.bEF < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.bEv != 0 && bVar.bED == null) {
            if (this.bEt.size() >= this.bEv) {
                GroupMetadata groupMetadata = this.bEt.get(0);
                int indexOf = this.bEt.indexOf(groupMetadata);
                collapseGroup(groupMetadata.bEy);
                if (bVar.bEE > indexOf) {
                    bVar.bEE--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.bEC.bEF, this.bEs.getGroupId(bVar.bEC.bEF));
            this.bEt.add(bVar.bEE, a2);
            h(false, false);
            notifyDataSetChanged();
            this.bEs.onGroupExpanded(a2.bEy);
            return true;
        }
        return false;
    }

    ExpandableListAdapter UR() {
        return this.bEs;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter UR = UR();
        if (UR instanceof Filterable) {
            return ((Filterable) UR).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> US() {
        return this.bEt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.bEs != null) {
            int groupCount = this.bEs.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).bEy >= groupCount) {
                    return;
                }
            }
            this.bEt = arrayList;
            h(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter UR = UR();
        if (UR != null) {
            return UR.isEmpty();
        }
        return true;
    }

    int b(long j, int i) {
        int groupCount = this.bEs.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter UR = UR();
        if (UR == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (UR.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.h(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.h(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new h();
        int bEw;
        int bEx;
        int bEy;
        long bEz;

        private GroupMetadata() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.bEw = i;
            groupMetadata.bEx = i2;
            groupMetadata.bEy = i3;
            groupMetadata.bEz = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.bEy - groupMetadata.bEy;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.bEw);
            parcel.writeInt(this.bEx);
            parcel.writeInt(this.bEy);
            parcel.writeLong(this.bEz);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> bEB = new ArrayList<>(5);
        public i bEC;
        public GroupMetadata bED;
        public int bEE;

        private void UT() {
            if (this.bEC != null) {
                this.bEC.recycle();
                this.bEC = null;
            }
            this.bED = null;
            this.bEE = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b UU = UU();
            UU.bEC = i.k(i2, i3, i4, i);
            UU.bED = groupMetadata;
            UU.bEE = i5;
            return UU;
        }

        private static b UU() {
            b bVar;
            synchronized (bEB) {
                if (bEB.size() > 0) {
                    bVar = bEB.remove(0);
                    bVar.UT();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            UT();
            synchronized (bEB) {
                if (bEB.size() < 5) {
                    bEB.add(this);
                }
            }
        }

        public boolean pq() {
            return this.bED != null;
        }
    }
}
