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
    private ExpandableListAdapter cDo;
    private int cDq;
    private int cDr = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> cDp = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.cDo != null) {
            this.cDo.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.cDo = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b kI(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.cDp;
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
            if (i > groupMetadata.cDt) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.cDs) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.cDs) {
                return b.a(i, 2, groupMetadata.cDu, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.cDt) {
                    return b.a(i, 1, groupMetadata.cDu, i - (groupMetadata.cDs + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.cDt) + groupMetadata2.cDu;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.cDu - (groupMetadata3.cDs - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(i iVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cDp;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(iVar.cDB, iVar.type, iVar.cDB, iVar.cDC, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (iVar.cDB > groupMetadata.cDu) {
                i4 = i + 1;
            } else if (iVar.cDB < groupMetadata.cDu) {
                i3 = i - 1;
            } else if (iVar.cDB == groupMetadata.cDu) {
                if (iVar.type == 2) {
                    return b.a(groupMetadata.cDs, iVar.type, iVar.cDB, iVar.cDC, groupMetadata, i);
                }
                if (iVar.type == 1) {
                    return b.a(groupMetadata.cDs + iVar.cDC + 1, iVar.type, iVar.cDB, iVar.cDC, groupMetadata, i);
                }
                return null;
            }
        }
        if (iVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((iVar.cDB - groupMetadata2.cDu) + groupMetadata2.cDt, iVar.type, iVar.cDB, iVar.cDC, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.cDs - (groupMetadata3.cDu - iVar.cDB), iVar.type, iVar.cDB, iVar.cDC, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.cDo.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b kI = kI(i);
        i iVar = kI.cDy;
        boolean isChildSelectable = iVar.type == 1 ? this.cDo.isChildSelectable(iVar.cDB, iVar.cDC) : true;
        kI.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cDo.getGroupCount() + this.cDq;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b kI = kI(i);
        if (kI.cDy.type == 2) {
            child = this.cDo.getGroup(kI.cDy.cDB);
        } else if (kI.cDy.type == 1) {
            child = this.cDo.getChild(kI.cDy.cDB, kI.cDy.cDC);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kI.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b kI = kI(i);
        long groupId = this.cDo.getGroupId(kI.cDy.cDB);
        if (kI.cDy.type == 2) {
            combinedChildId = this.cDo.getCombinedGroupId(groupId);
        } else if (kI.cDy.type == 1) {
            combinedChildId = this.cDo.getCombinedChildId(groupId, this.cDo.getChildId(kI.cDy.cDB, kI.cDy.cDC));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kI.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b kI = kI(i);
        if (kI.cDy.type == 2) {
            childView = this.cDo.getGroupView(kI.cDy.cDB, kI.alP(), view, viewGroup);
        } else if (kI.cDy.type == 1) {
            childView = this.cDo.getChildView(kI.cDy.cDB, kI.cDy.cDC, kI.cDz.cDt == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kI.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b kI = kI(i);
        i iVar = kI.cDy;
        if (this.cDo instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cDo;
            if (iVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(iVar.cDB);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(iVar.cDB, iVar.cDC);
            }
        } else if (iVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        kI.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.cDo instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cDo;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.cDo.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cDp;
        int size = arrayList.size();
        this.cDq = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int h = h(groupMetadata.cDv, groupMetadata.cDu);
                if (h != groupMetadata.cDu) {
                    if (h == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.cDu = h;
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
            if (groupMetadata2.cDt == -1 || z) {
                childrenCount = this.cDo.getChildrenCount(groupMetadata2.cDu);
            } else {
                childrenCount = groupMetadata2.cDt - groupMetadata2.cDs;
            }
            this.cDq += childrenCount;
            int i5 = i4 + (groupMetadata2.cDu - i3);
            i3 = groupMetadata2.cDu;
            groupMetadata2.cDs = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.cDt = i6;
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
        if (bVar.cDz == null) {
            return false;
        }
        this.cDp.remove(bVar.cDz);
        p(false, false);
        notifyDataSetChanged();
        this.cDo.onGroupCollapsed(bVar.cDz.cDu);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.cDy.cDB < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.cDr != 0 && bVar.cDz == null) {
            if (this.cDp.size() >= this.cDr) {
                GroupMetadata groupMetadata = this.cDp.get(0);
                int indexOf = this.cDp.indexOf(groupMetadata);
                collapseGroup(groupMetadata.cDu);
                if (bVar.cDA > indexOf) {
                    bVar.cDA--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.cDy.cDB, this.cDo.getGroupId(bVar.cDy.cDB));
            this.cDp.add(bVar.cDA, a2);
            p(false, false);
            notifyDataSetChanged();
            this.cDo.onGroupExpanded(a2.cDu);
            return true;
        }
        return false;
    }

    ExpandableListAdapter alL() {
        return this.cDo;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter alL = alL();
        if (alL instanceof Filterable) {
            return ((Filterable) alL).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> alM() {
        return this.cDp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.cDo != null) {
            int groupCount = this.cDo.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).cDu >= groupCount) {
                    return;
                }
            }
            this.cDp = arrayList;
            p(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter alL = alL();
        if (alL != null) {
            return alL.isEmpty();
        }
        return true;
    }

    int h(long j, int i) {
        int groupCount = this.cDo.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter alL = alL();
        if (alL == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (alL.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.p(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.p(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new h();
        int cDs;
        int cDt;
        int cDu;
        long cDv;

        private GroupMetadata() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.cDs = i;
            groupMetadata.cDt = i2;
            groupMetadata.cDu = i3;
            groupMetadata.cDv = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.cDu - groupMetadata.cDu;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.cDs);
            parcel.writeInt(this.cDt);
            parcel.writeInt(this.cDu);
            parcel.writeLong(this.cDv);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> cDx = new ArrayList<>(5);
        public int cDA;
        public i cDy;
        public GroupMetadata cDz;

        private void alN() {
            if (this.cDy != null) {
                this.cDy.recycle();
                this.cDy = null;
            }
            this.cDz = null;
            this.cDA = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b alO = alO();
            alO.cDy = i.k(i2, i3, i4, i);
            alO.cDz = groupMetadata;
            alO.cDA = i5;
            return alO;
        }

        private static b alO() {
            b bVar;
            synchronized (cDx) {
                if (cDx.size() > 0) {
                    bVar = cDx.remove(0);
                    bVar.alN();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            alN();
            synchronized (cDx) {
                if (cDx.size() < 5) {
                    cDx.add(this);
                }
            }
        }

        public boolean alP() {
            return this.cDz != null;
        }
    }
}
