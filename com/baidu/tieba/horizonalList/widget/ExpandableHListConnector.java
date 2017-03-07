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
    private ExpandableListAdapter cEK;
    private int cEM;
    private int cEN = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> cEL = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.cEK != null) {
            this.cEK.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.cEK = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b km(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.cEL;
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
            if (i > groupMetadata.cEP) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.cEO) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.cEO) {
                return b.a(i, 2, groupMetadata.cEQ, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.cEP) {
                    return b.a(i, 1, groupMetadata.cEQ, i - (groupMetadata.cEO + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.cEP) + groupMetadata2.cEQ;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.cEQ - (groupMetadata3.cEO - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(i iVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cEL;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(iVar.cEX, iVar.type, iVar.cEX, iVar.cEY, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (iVar.cEX > groupMetadata.cEQ) {
                i4 = i + 1;
            } else if (iVar.cEX < groupMetadata.cEQ) {
                i3 = i - 1;
            } else if (iVar.cEX == groupMetadata.cEQ) {
                if (iVar.type == 2) {
                    return b.a(groupMetadata.cEO, iVar.type, iVar.cEX, iVar.cEY, groupMetadata, i);
                }
                if (iVar.type == 1) {
                    return b.a(groupMetadata.cEO + iVar.cEY + 1, iVar.type, iVar.cEX, iVar.cEY, groupMetadata, i);
                }
                return null;
            }
        }
        if (iVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((iVar.cEX - groupMetadata2.cEQ) + groupMetadata2.cEP, iVar.type, iVar.cEX, iVar.cEY, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.cEO - (groupMetadata3.cEQ - iVar.cEX), iVar.type, iVar.cEX, iVar.cEY, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.cEK.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b km = km(i);
        i iVar = km.cEU;
        boolean isChildSelectable = iVar.type == 1 ? this.cEK.isChildSelectable(iVar.cEX, iVar.cEY) : true;
        km.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cEK.getGroupCount() + this.cEM;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b km = km(i);
        if (km.cEU.type == 2) {
            child = this.cEK.getGroup(km.cEU.cEX);
        } else if (km.cEU.type == 1) {
            child = this.cEK.getChild(km.cEU.cEX, km.cEU.cEY);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        km.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b km = km(i);
        long groupId = this.cEK.getGroupId(km.cEU.cEX);
        if (km.cEU.type == 2) {
            combinedChildId = this.cEK.getCombinedGroupId(groupId);
        } else if (km.cEU.type == 1) {
            combinedChildId = this.cEK.getCombinedChildId(groupId, this.cEK.getChildId(km.cEU.cEX, km.cEU.cEY));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        km.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b km = km(i);
        if (km.cEU.type == 2) {
            childView = this.cEK.getGroupView(km.cEU.cEX, km.alb(), view, viewGroup);
        } else if (km.cEU.type == 1) {
            childView = this.cEK.getChildView(km.cEU.cEX, km.cEU.cEY, km.cEV.cEP == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        km.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b km = km(i);
        i iVar = km.cEU;
        if (this.cEK instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cEK;
            if (iVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(iVar.cEX);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(iVar.cEX, iVar.cEY);
            }
        } else if (iVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        km.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.cEK instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cEK;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.cEK.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cEL;
        int size = arrayList.size();
        this.cEM = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int h = h(groupMetadata.cER, groupMetadata.cEQ);
                if (h != groupMetadata.cEQ) {
                    if (h == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.cEQ = h;
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
            if (groupMetadata2.cEP == -1 || z) {
                childrenCount = this.cEK.getChildrenCount(groupMetadata2.cEQ);
            } else {
                childrenCount = groupMetadata2.cEP - groupMetadata2.cEO;
            }
            this.cEM += childrenCount;
            int i5 = i4 + (groupMetadata2.cEQ - i3);
            i3 = groupMetadata2.cEQ;
            groupMetadata2.cEO = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.cEP = i6;
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
        if (bVar.cEV == null) {
            return false;
        }
        this.cEL.remove(bVar.cEV);
        o(false, false);
        notifyDataSetChanged();
        this.cEK.onGroupCollapsed(bVar.cEV.cEQ);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.cEU.cEX < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.cEN != 0 && bVar.cEV == null) {
            if (this.cEL.size() >= this.cEN) {
                GroupMetadata groupMetadata = this.cEL.get(0);
                int indexOf = this.cEL.indexOf(groupMetadata);
                collapseGroup(groupMetadata.cEQ);
                if (bVar.cEW > indexOf) {
                    bVar.cEW--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.cEU.cEX, this.cEK.getGroupId(bVar.cEU.cEX));
            this.cEL.add(bVar.cEW, a2);
            o(false, false);
            notifyDataSetChanged();
            this.cEK.onGroupExpanded(a2.cEQ);
            return true;
        }
        return false;
    }

    ExpandableListAdapter akX() {
        return this.cEK;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter akX = akX();
        if (akX instanceof Filterable) {
            return ((Filterable) akX).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> akY() {
        return this.cEL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.cEK != null) {
            int groupCount = this.cEK.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).cEQ >= groupCount) {
                    return;
                }
            }
            this.cEL = arrayList;
            o(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter akX = akX();
        if (akX != null) {
            return akX.isEmpty();
        }
        return true;
    }

    int h(long j, int i) {
        int groupCount = this.cEK.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter akX = akX();
        if (akX == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (akX.getGroupId(i3) != j) {
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
        int cEO;
        int cEP;
        int cEQ;
        long cER;

        private GroupMetadata() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.cEO = i;
            groupMetadata.cEP = i2;
            groupMetadata.cEQ = i3;
            groupMetadata.cER = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.cEQ - groupMetadata.cEQ;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.cEO);
            parcel.writeInt(this.cEP);
            parcel.writeInt(this.cEQ);
            parcel.writeLong(this.cER);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> cET = new ArrayList<>(5);
        public i cEU;
        public GroupMetadata cEV;
        public int cEW;

        private void akZ() {
            if (this.cEU != null) {
                this.cEU.recycle();
                this.cEU = null;
            }
            this.cEV = null;
            this.cEW = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b ala = ala();
            ala.cEU = i.k(i2, i3, i4, i);
            ala.cEV = groupMetadata;
            ala.cEW = i5;
            return ala;
        }

        private static b ala() {
            b bVar;
            synchronized (cET) {
                if (cET.size() > 0) {
                    bVar = cET.remove(0);
                    bVar.akZ();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            akZ();
            synchronized (cET) {
                if (cET.size() < 5) {
                    cET.add(this);
                }
            }
        }

        public boolean alb() {
            return this.cEV != null;
        }
    }
}
