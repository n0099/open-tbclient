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
    private ExpandableListAdapter czK;
    private int czM;
    private int czN = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> czL = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.czK != null) {
            this.czK.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.czK = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b kg(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.czL;
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
            if (i > groupMetadata.czP) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.czO) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.czO) {
                return b.a(i, 2, groupMetadata.czQ, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.czP) {
                    return b.a(i, 1, groupMetadata.czQ, i - (groupMetadata.czO + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.czP) + groupMetadata2.czQ;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.czQ - (groupMetadata3.czO - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(h hVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.czL;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(hVar.czX, hVar.type, hVar.czX, hVar.czY, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (hVar.czX > groupMetadata.czQ) {
                i4 = i + 1;
            } else if (hVar.czX < groupMetadata.czQ) {
                i3 = i - 1;
            } else if (hVar.czX == groupMetadata.czQ) {
                if (hVar.type == 2) {
                    return b.a(groupMetadata.czO, hVar.type, hVar.czX, hVar.czY, groupMetadata, i);
                }
                if (hVar.type == 1) {
                    return b.a(groupMetadata.czO + hVar.czY + 1, hVar.type, hVar.czX, hVar.czY, groupMetadata, i);
                }
                return null;
            }
        }
        if (hVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((hVar.czX - groupMetadata2.czQ) + groupMetadata2.czP, hVar.type, hVar.czX, hVar.czY, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.czO - (groupMetadata3.czQ - hVar.czX), hVar.type, hVar.czX, hVar.czY, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.czK.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b kg = kg(i);
        h hVar = kg.czU;
        boolean isChildSelectable = hVar.type == 1 ? this.czK.isChildSelectable(hVar.czX, hVar.czY) : true;
        kg.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.czK.getGroupCount() + this.czM;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b kg = kg(i);
        if (kg.czU.type == 2) {
            child = this.czK.getGroup(kg.czU.czX);
        } else if (kg.czU.type == 1) {
            child = this.czK.getChild(kg.czU.czX, kg.czU.czY);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kg.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b kg = kg(i);
        long groupId = this.czK.getGroupId(kg.czU.czX);
        if (kg.czU.type == 2) {
            combinedChildId = this.czK.getCombinedGroupId(groupId);
        } else if (kg.czU.type == 1) {
            combinedChildId = this.czK.getCombinedChildId(groupId, this.czK.getChildId(kg.czU.czX, kg.czU.czY));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kg.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b kg = kg(i);
        if (kg.czU.type == 2) {
            childView = this.czK.getGroupView(kg.czU.czX, kg.aiM(), view, viewGroup);
        } else if (kg.czU.type == 1) {
            childView = this.czK.getChildView(kg.czU.czX, kg.czU.czY, kg.czV.czP == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        kg.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b kg = kg(i);
        h hVar = kg.czU;
        if (this.czK instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.czK;
            if (hVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(hVar.czX);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(hVar.czX, hVar.czY);
            }
        } else if (hVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        kg.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.czK instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.czK;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.czK.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.czL;
        int size = arrayList.size();
        this.czM = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int f = f(groupMetadata.czR, groupMetadata.czQ);
                if (f != groupMetadata.czQ) {
                    if (f == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.czQ = f;
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
            if (groupMetadata2.czP == -1 || z) {
                childrenCount = this.czK.getChildrenCount(groupMetadata2.czQ);
            } else {
                childrenCount = groupMetadata2.czP - groupMetadata2.czO;
            }
            this.czM += childrenCount;
            int i5 = i4 + (groupMetadata2.czQ - i3);
            i3 = groupMetadata2.czQ;
            groupMetadata2.czO = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.czP = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        h j = h.j(2, i, -1, -1);
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
        if (bVar.czV == null) {
            return false;
        }
        this.czL.remove(bVar.czV);
        o(false, false);
        notifyDataSetChanged();
        this.czK.onGroupCollapsed(bVar.czV.czQ);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.czU.czX < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.czN != 0 && bVar.czV == null) {
            if (this.czL.size() >= this.czN) {
                GroupMetadata groupMetadata = this.czL.get(0);
                int indexOf = this.czL.indexOf(groupMetadata);
                collapseGroup(groupMetadata.czQ);
                if (bVar.czW > indexOf) {
                    bVar.czW--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.czU.czX, this.czK.getGroupId(bVar.czU.czX));
            this.czL.add(bVar.czW, a2);
            o(false, false);
            notifyDataSetChanged();
            this.czK.onGroupExpanded(a2.czQ);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aiI() {
        return this.czK;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aiI = aiI();
        if (aiI instanceof Filterable) {
            return ((Filterable) aiI).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aiJ() {
        return this.czL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.czK != null) {
            int groupCount = this.czK.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).czQ >= groupCount) {
                    return;
                }
            }
            this.czL = arrayList;
            o(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aiI = aiI();
        if (aiI != null) {
            return aiI.isEmpty();
        }
        return true;
    }

    int f(long j, int i) {
        int groupCount = this.czK.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aiI = aiI();
        if (aiI == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aiI.getGroupId(i3) != j) {
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
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new g();
        int czO;
        int czP;
        int czQ;
        long czR;

        private GroupMetadata() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.czO = i;
            groupMetadata.czP = i2;
            groupMetadata.czQ = i3;
            groupMetadata.czR = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.czQ - groupMetadata.czQ;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.czO);
            parcel.writeInt(this.czP);
            parcel.writeInt(this.czQ);
            parcel.writeLong(this.czR);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> czT = new ArrayList<>(5);
        public h czU;
        public GroupMetadata czV;
        public int czW;

        private void aiK() {
            if (this.czU != null) {
                this.czU.recycle();
                this.czU = null;
            }
            this.czV = null;
            this.czW = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aiL = aiL();
            aiL.czU = h.j(i2, i3, i4, i);
            aiL.czV = groupMetadata;
            aiL.czW = i5;
            return aiL;
        }

        private static b aiL() {
            b bVar;
            synchronized (czT) {
                if (czT.size() > 0) {
                    bVar = czT.remove(0);
                    bVar.aiK();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            aiK();
            synchronized (czT) {
                if (czT.size() < 5) {
                    czT.add(this);
                }
            }
        }

        public boolean aiM() {
            return this.czV != null;
        }
    }
}
