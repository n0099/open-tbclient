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
    private ExpandableListAdapter cKW;
    private int cKY;
    private int cKZ = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> cKX = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.cKW != null) {
            this.cKW.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.cKW = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b ky(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.cKX;
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
            if (i > groupMetadata.cLb) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.cLa) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.cLa) {
                return b.a(i, 2, groupMetadata.cLc, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.cLb) {
                    return b.a(i, 1, groupMetadata.cLc, i - (groupMetadata.cLa + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.cLb) + groupMetadata2.cLc;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.cLc - (groupMetadata3.cLa - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(i iVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cKX;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(iVar.cLj, iVar.type, iVar.cLj, iVar.cLk, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (iVar.cLj > groupMetadata.cLc) {
                i4 = i + 1;
            } else if (iVar.cLj < groupMetadata.cLc) {
                i3 = i - 1;
            } else if (iVar.cLj == groupMetadata.cLc) {
                if (iVar.type == 2) {
                    return b.a(groupMetadata.cLa, iVar.type, iVar.cLj, iVar.cLk, groupMetadata, i);
                }
                if (iVar.type == 1) {
                    return b.a(groupMetadata.cLa + iVar.cLk + 1, iVar.type, iVar.cLj, iVar.cLk, groupMetadata, i);
                }
                return null;
            }
        }
        if (iVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((iVar.cLj - groupMetadata2.cLc) + groupMetadata2.cLb, iVar.type, iVar.cLj, iVar.cLk, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.cLa - (groupMetadata3.cLc - iVar.cLj), iVar.type, iVar.cLj, iVar.cLk, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.cKW.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b ky = ky(i);
        i iVar = ky.cLg;
        boolean isChildSelectable = iVar.type == 1 ? this.cKW.isChildSelectable(iVar.cLj, iVar.cLk) : true;
        ky.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cKW.getGroupCount() + this.cKY;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b ky = ky(i);
        if (ky.cLg.type == 2) {
            child = this.cKW.getGroup(ky.cLg.cLj);
        } else if (ky.cLg.type == 1) {
            child = this.cKW.getChild(ky.cLg.cLj, ky.cLg.cLk);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ky.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b ky = ky(i);
        long groupId = this.cKW.getGroupId(ky.cLg.cLj);
        if (ky.cLg.type == 2) {
            combinedChildId = this.cKW.getCombinedGroupId(groupId);
        } else if (ky.cLg.type == 1) {
            combinedChildId = this.cKW.getCombinedChildId(groupId, this.cKW.getChildId(ky.cLg.cLj, ky.cLg.cLk));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ky.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b ky = ky(i);
        if (ky.cLg.type == 2) {
            childView = this.cKW.getGroupView(ky.cLg.cLj, ky.anY(), view, viewGroup);
        } else if (ky.cLg.type == 1) {
            childView = this.cKW.getChildView(ky.cLg.cLj, ky.cLg.cLk, ky.cLh.cLb == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ky.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b ky = ky(i);
        i iVar = ky.cLg;
        if (this.cKW instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cKW;
            if (iVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(iVar.cLj);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(iVar.cLj, iVar.cLk);
            }
        } else if (iVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        ky.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.cKW instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cKW;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.cKW.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cKX;
        int size = arrayList.size();
        this.cKY = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int i3 = i(groupMetadata.cLd, groupMetadata.cLc);
                if (i3 != groupMetadata.cLc) {
                    if (i3 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.cLc = i3;
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
            if (groupMetadata2.cLb == -1 || z) {
                childrenCount = this.cKW.getChildrenCount(groupMetadata2.cLc);
            } else {
                childrenCount = groupMetadata2.cLb - groupMetadata2.cLa;
            }
            this.cKY += childrenCount;
            int i6 = i5 + (groupMetadata2.cLc - i4);
            i4 = groupMetadata2.cLc;
            groupMetadata2.cLa = i6;
            int i7 = childrenCount + i6;
            groupMetadata2.cLb = i7;
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
        if (bVar.cLh == null) {
            return false;
        }
        this.cKX.remove(bVar.cLh);
        o(false, false);
        notifyDataSetChanged();
        this.cKW.onGroupCollapsed(bVar.cLh.cLc);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.cLg.cLj < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.cKZ != 0 && bVar.cLh == null) {
            if (this.cKX.size() >= this.cKZ) {
                GroupMetadata groupMetadata = this.cKX.get(0);
                int indexOf = this.cKX.indexOf(groupMetadata);
                collapseGroup(groupMetadata.cLc);
                if (bVar.cLi > indexOf) {
                    bVar.cLi--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.cLg.cLj, this.cKW.getGroupId(bVar.cLg.cLj));
            this.cKX.add(bVar.cLi, a2);
            o(false, false);
            notifyDataSetChanged();
            this.cKW.onGroupExpanded(a2.cLc);
            return true;
        }
        return false;
    }

    ExpandableListAdapter anU() {
        return this.cKW;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter anU = anU();
        if (anU instanceof Filterable) {
            return ((Filterable) anU).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> anV() {
        return this.cKX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.cKW != null) {
            int groupCount = this.cKW.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).cLc >= groupCount) {
                    return;
                }
            }
            this.cKX = arrayList;
            o(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter anU = anU();
        if (anU != null) {
            return anU.isEmpty();
        }
        return true;
    }

    int i(long j, int i) {
        int groupCount = this.cKW.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter anU = anU();
        if (anU == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (anU.getGroupId(i3) != j) {
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
        int cLa;
        int cLb;
        int cLc;
        long cLd;

        private GroupMetadata() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.cLa = i;
            groupMetadata.cLb = i2;
            groupMetadata.cLc = i3;
            groupMetadata.cLd = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.cLc - groupMetadata.cLc;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.cLa);
            parcel.writeInt(this.cLb);
            parcel.writeInt(this.cLc);
            parcel.writeLong(this.cLd);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> cLf = new ArrayList<>(5);
        public i cLg;
        public GroupMetadata cLh;
        public int cLi;

        private void anW() {
            if (this.cLg != null) {
                this.cLg.recycle();
                this.cLg = null;
            }
            this.cLh = null;
            this.cLi = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b anX = anX();
            anX.cLg = i.l(i2, i3, i4, i);
            anX.cLh = groupMetadata;
            anX.cLi = i5;
            return anX;
        }

        private static b anX() {
            b bVar;
            synchronized (cLf) {
                if (cLf.size() > 0) {
                    bVar = cLf.remove(0);
                    bVar.anW();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            anW();
            synchronized (cLf) {
                if (cLf.size() < 5) {
                    cLf.add(this);
                }
            }
        }

        public boolean anY() {
            return this.cLh != null;
        }
    }
}
