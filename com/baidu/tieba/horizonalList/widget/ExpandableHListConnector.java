package com.baidu.tieba.horizonalList.widget;

import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v7.widget.ActivityChooserView;
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
    private ExpandableListAdapter ehZ;
    private int eib;
    private int eic = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> eia = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.ehZ != null) {
            this.ehZ.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.ehZ = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b nH(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.eia;
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
            if (i > groupMetadata.eie) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.eid) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.eid) {
                return b.a(i, 2, groupMetadata.eif, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.eie) {
                    return b.a(i, 1, groupMetadata.eif, i - (groupMetadata.eid + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.eie) + groupMetadata2.eif;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.eif - (groupMetadata3.eid - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.eia;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.eim, aVar.type, aVar.eim, aVar.ein, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.eim > groupMetadata.eif) {
                i4 = i + 1;
            } else if (aVar.eim < groupMetadata.eif) {
                i3 = i - 1;
            } else if (aVar.eim == groupMetadata.eif) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.eid, aVar.type, aVar.eim, aVar.ein, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.eid + aVar.ein + 1, aVar.type, aVar.eim, aVar.ein, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.eim - groupMetadata2.eif) + groupMetadata2.eie, aVar.type, aVar.eim, aVar.ein, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.eid - (groupMetadata3.eif - aVar.eim), aVar.type, aVar.eim, aVar.ein, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.ehZ.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b nH = nH(i);
        com.baidu.tieba.horizonalList.widget.a aVar = nH.eij;
        boolean isChildSelectable = aVar.type == 1 ? this.ehZ.isChildSelectable(aVar.eim, aVar.ein) : true;
        nH.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ehZ.getGroupCount() + this.eib;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b nH = nH(i);
        if (nH.eij.type == 2) {
            child = this.ehZ.getGroup(nH.eij.eim);
        } else if (nH.eij.type == 1) {
            child = this.ehZ.getChild(nH.eij.eim, nH.eij.ein);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        nH.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b nH = nH(i);
        long groupId = this.ehZ.getGroupId(nH.eij.eim);
        if (nH.eij.type == 2) {
            combinedChildId = this.ehZ.getCombinedGroupId(groupId);
        } else if (nH.eij.type == 1) {
            combinedChildId = this.ehZ.getCombinedChildId(groupId, this.ehZ.getChildId(nH.eij.eim, nH.eij.ein));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        nH.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b nH = nH(i);
        if (nH.eij.type == 2) {
            childView = this.ehZ.getGroupView(nH.eij.eim, nH.atz(), view, viewGroup);
        } else if (nH.eij.type == 1) {
            childView = this.ehZ.getChildView(nH.eij.eim, nH.eij.ein, nH.eik.eie == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        nH.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b nH = nH(i);
        com.baidu.tieba.horizonalList.widget.a aVar = nH.eij;
        if (this.ehZ instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.ehZ;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.eim);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.eim, aVar.ein);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        nH.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.ehZ instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.ehZ;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.ehZ.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.eia;
        int size = arrayList.size();
        this.eib = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int l = l(groupMetadata.eig, groupMetadata.eif);
                if (l != groupMetadata.eif) {
                    if (l == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.eif = l;
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
            if (groupMetadata2.eie == -1 || z) {
                childrenCount = this.ehZ.getChildrenCount(groupMetadata2.eif);
            } else {
                childrenCount = groupMetadata2.eie - groupMetadata2.eid;
            }
            this.eib += childrenCount;
            int i5 = i4 + (groupMetadata2.eif - i3);
            i3 = groupMetadata2.eif;
            groupMetadata2.eid = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.eie = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a s = com.baidu.tieba.horizonalList.widget.a.s(2, i, -1, -1);
        b a2 = a(s);
        s.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.eik == null) {
            return false;
        }
        this.eia.remove(bVar.eik);
        E(false, false);
        notifyDataSetChanged();
        this.ehZ.onGroupCollapsed(bVar.eik.eif);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.eij.eim < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.eic != 0 && bVar.eik == null) {
            if (this.eia.size() >= this.eic) {
                GroupMetadata groupMetadata = this.eia.get(0);
                int indexOf = this.eia.indexOf(groupMetadata);
                collapseGroup(groupMetadata.eif);
                if (bVar.eil > indexOf) {
                    bVar.eil--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.eij.eim, this.ehZ.getGroupId(bVar.eij.eim));
            this.eia.add(bVar.eil, a2);
            E(false, false);
            notifyDataSetChanged();
            this.ehZ.onGroupExpanded(a2.eif);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aHd() {
        return this.ehZ;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aHd = aHd();
        if (aHd instanceof Filterable) {
            return ((Filterable) aHd).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aHe() {
        return this.eia;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.ehZ != null) {
            int groupCount = this.ehZ.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).eif >= groupCount) {
                    return;
                }
            }
            this.eia = arrayList;
            E(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aHd = aHd();
        if (aHd != null) {
            return aHd.isEmpty();
        }
        return true;
    }

    int l(long j, int i) {
        int groupCount = this.ehZ.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aHd = aHd();
        if (aHd == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aHd.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.E(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.E(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: r */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: nI */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int eid;
        int eie;
        int eif;
        long eig;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.eid = i;
            groupMetadata.eie = i2;
            groupMetadata.eif = i3;
            groupMetadata.eig = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.eif - groupMetadata.eif;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.eid);
            parcel.writeInt(this.eie);
            parcel.writeInt(this.eif);
            parcel.writeLong(this.eig);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> eii = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a eij;
        public GroupMetadata eik;
        public int eil;

        private void Rq() {
            if (this.eij != null) {
                this.eij.recycle();
                this.eij = null;
            }
            this.eik = null;
            this.eil = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aHf = aHf();
            aHf.eij = com.baidu.tieba.horizonalList.widget.a.s(i2, i3, i4, i);
            aHf.eik = groupMetadata;
            aHf.eil = i5;
            return aHf;
        }

        private static b aHf() {
            b bVar;
            synchronized (eii) {
                if (eii.size() > 0) {
                    bVar = eii.remove(0);
                    bVar.Rq();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            Rq();
            synchronized (eii) {
                if (eii.size() < 5) {
                    eii.add(this);
                }
            }
        }

        public boolean atz() {
            return this.eik != null;
        }
    }
}
