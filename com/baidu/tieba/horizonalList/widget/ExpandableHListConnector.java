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
    private ExpandableListAdapter cRd;
    private int cRf;
    private int cRg = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> cRe = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.cRd != null) {
            this.cRd.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.cRd = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b kL(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.cRe;
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
            if (i > groupMetadata.cRi) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.cRh) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.cRh) {
                return b.a(i, 2, groupMetadata.cRj, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.cRi) {
                    return b.a(i, 1, groupMetadata.cRj, i - (groupMetadata.cRh + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.cRi) + groupMetadata2.cRj;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.cRj - (groupMetadata3.cRh - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(i iVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cRe;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(iVar.cRq, iVar.type, iVar.cRq, iVar.cRr, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (iVar.cRq > groupMetadata.cRj) {
                i4 = i + 1;
            } else if (iVar.cRq < groupMetadata.cRj) {
                i3 = i - 1;
            } else if (iVar.cRq == groupMetadata.cRj) {
                if (iVar.type == 2) {
                    return b.a(groupMetadata.cRh, iVar.type, iVar.cRq, iVar.cRr, groupMetadata, i);
                }
                if (iVar.type == 1) {
                    return b.a(groupMetadata.cRh + iVar.cRr + 1, iVar.type, iVar.cRq, iVar.cRr, groupMetadata, i);
                }
                return null;
            }
        }
        if (iVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((iVar.cRq - groupMetadata2.cRj) + groupMetadata2.cRi, iVar.type, iVar.cRq, iVar.cRr, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.cRh - (groupMetadata3.cRj - iVar.cRq), iVar.type, iVar.cRq, iVar.cRr, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.cRd.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b kL = kL(i);
        i iVar = kL.cRn;
        boolean isChildSelectable = iVar.type == 1 ? this.cRd.isChildSelectable(iVar.cRq, iVar.cRr) : true;
        kL.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cRd.getGroupCount() + this.cRf;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b kL = kL(i);
        if (kL.cRn.type == 2) {
            child = this.cRd.getGroup(kL.cRn.cRq);
        } else if (kL.cRn.type == 1) {
            child = this.cRd.getChild(kL.cRn.cRq, kL.cRn.cRr);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kL.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b kL = kL(i);
        long groupId = this.cRd.getGroupId(kL.cRn.cRq);
        if (kL.cRn.type == 2) {
            combinedChildId = this.cRd.getCombinedGroupId(groupId);
        } else if (kL.cRn.type == 1) {
            combinedChildId = this.cRd.getCombinedChildId(groupId, this.cRd.getChildId(kL.cRn.cRq, kL.cRn.cRr));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kL.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b kL = kL(i);
        if (kL.cRn.type == 2) {
            childView = this.cRd.getGroupView(kL.cRn.cRq, kL.aqg(), view, viewGroup);
        } else if (kL.cRn.type == 1) {
            childView = this.cRd.getChildView(kL.cRn.cRq, kL.cRn.cRr, kL.cRo.cRi == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kL.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b kL = kL(i);
        i iVar = kL.cRn;
        if (this.cRd instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cRd;
            if (iVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(iVar.cRq);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(iVar.cRq, iVar.cRr);
            }
        } else if (iVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        kL.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.cRd instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cRd;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.cRd.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cRe;
        int size = arrayList.size();
        this.cRf = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int i3 = i(groupMetadata.cRk, groupMetadata.cRj);
                if (i3 != groupMetadata.cRj) {
                    if (i3 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.cRj = i3;
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
            if (groupMetadata2.cRi == -1 || z) {
                childrenCount = this.cRd.getChildrenCount(groupMetadata2.cRj);
            } else {
                childrenCount = groupMetadata2.cRi - groupMetadata2.cRh;
            }
            this.cRf += childrenCount;
            int i6 = i5 + (groupMetadata2.cRj - i4);
            i4 = groupMetadata2.cRj;
            groupMetadata2.cRh = i6;
            int i7 = childrenCount + i6;
            groupMetadata2.cRi = i7;
            i++;
            i5 = i7;
        }
    }

    boolean collapseGroup(int i) {
        i l = i.l(2, i, -1, -1);
        b a2 = a(l);
        l.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.cRo == null) {
            return false;
        }
        this.cRe.remove(bVar.cRo);
        q(false, false);
        notifyDataSetChanged();
        this.cRd.onGroupCollapsed(bVar.cRo.cRj);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.cRn.cRq < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.cRg != 0 && bVar.cRo == null) {
            if (this.cRe.size() >= this.cRg) {
                GroupMetadata groupMetadata = this.cRe.get(0);
                int indexOf = this.cRe.indexOf(groupMetadata);
                collapseGroup(groupMetadata.cRj);
                if (bVar.cRp > indexOf) {
                    bVar.cRp--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.cRn.cRq, this.cRd.getGroupId(bVar.cRn.cRq));
            this.cRe.add(bVar.cRp, a2);
            q(false, false);
            notifyDataSetChanged();
            this.cRd.onGroupExpanded(a2.cRj);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aqc() {
        return this.cRd;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aqc = aqc();
        if (aqc instanceof Filterable) {
            return ((Filterable) aqc).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aqd() {
        return this.cRe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.cRd != null) {
            int groupCount = this.cRd.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).cRj >= groupCount) {
                    return;
                }
            }
            this.cRe = arrayList;
            q(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aqc = aqc();
        if (aqc != null) {
            return aqc.isEmpty();
        }
        return true;
    }

    int i(long j, int i) {
        int groupCount = this.cRd.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aqc = aqc();
        if (aqc == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aqc.getGroupId(i3) != j) {
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
        int cRh;
        int cRi;
        int cRj;
        long cRk;

        private GroupMetadata() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.cRh = i;
            groupMetadata.cRi = i2;
            groupMetadata.cRj = i3;
            groupMetadata.cRk = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.cRj - groupMetadata.cRj;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.cRh);
            parcel.writeInt(this.cRi);
            parcel.writeInt(this.cRj);
            parcel.writeLong(this.cRk);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> cRm = new ArrayList<>(5);
        public i cRn;
        public GroupMetadata cRo;
        public int cRp;

        private void aqe() {
            if (this.cRn != null) {
                this.cRn.recycle();
                this.cRn = null;
            }
            this.cRo = null;
            this.cRp = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aqf = aqf();
            aqf.cRn = i.l(i2, i3, i4, i);
            aqf.cRo = groupMetadata;
            aqf.cRp = i5;
            return aqf;
        }

        private static b aqf() {
            b bVar;
            synchronized (cRm) {
                if (cRm.size() > 0) {
                    bVar = cRm.remove(0);
                    bVar.aqe();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            aqe();
            synchronized (cRm) {
                if (cRm.size() < 5) {
                    cRm.add(this);
                }
            }
        }

        public boolean aqg() {
            return this.cRo != null;
        }
    }
}
