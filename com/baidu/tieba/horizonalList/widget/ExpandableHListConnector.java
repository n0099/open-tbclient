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
    private ExpandableListAdapter dGH;
    private int dGJ;
    private int dGK = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> dGI = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.dGH != null) {
            this.dGH.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.dGH = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b my(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.dGI;
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
            if (i > groupMetadata.dGM) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.dGL) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.dGL) {
                return b.a(i, 2, groupMetadata.dGN, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.dGM) {
                    return b.a(i, 1, groupMetadata.dGN, i - (groupMetadata.dGL + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.dGM) + groupMetadata2.dGN;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.dGN - (groupMetadata3.dGL - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dGI;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.dGU, aVar.type, aVar.dGU, aVar.dGV, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.dGU > groupMetadata.dGN) {
                i4 = i + 1;
            } else if (aVar.dGU < groupMetadata.dGN) {
                i3 = i - 1;
            } else if (aVar.dGU == groupMetadata.dGN) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.dGL, aVar.type, aVar.dGU, aVar.dGV, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.dGL + aVar.dGV + 1, aVar.type, aVar.dGU, aVar.dGV, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.dGU - groupMetadata2.dGN) + groupMetadata2.dGM, aVar.type, aVar.dGU, aVar.dGV, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.dGL - (groupMetadata3.dGN - aVar.dGU), aVar.type, aVar.dGU, aVar.dGV, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.dGH.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b my = my(i);
        com.baidu.tieba.horizonalList.widget.a aVar = my.dGR;
        boolean isChildSelectable = aVar.type == 1 ? this.dGH.isChildSelectable(aVar.dGU, aVar.dGV) : true;
        my.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dGH.getGroupCount() + this.dGJ;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b my = my(i);
        if (my.dGR.type == 2) {
            child = this.dGH.getGroup(my.dGR.dGU);
        } else if (my.dGR.type == 1) {
            child = this.dGH.getChild(my.dGR.dGU, my.dGR.dGV);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        my.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b my = my(i);
        long groupId = this.dGH.getGroupId(my.dGR.dGU);
        if (my.dGR.type == 2) {
            combinedChildId = this.dGH.getCombinedGroupId(groupId);
        } else if (my.dGR.type == 1) {
            combinedChildId = this.dGH.getCombinedChildId(groupId, this.dGH.getChildId(my.dGR.dGU, my.dGR.dGV));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        my.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        View childView;
        b my = my(i);
        if (my.dGR.type == 2) {
            childView = this.dGH.getGroupView(my.dGR.dGU, my.anM(), view2, viewGroup);
        } else if (my.dGR.type == 1) {
            childView = this.dGH.getChildView(my.dGR.dGU, my.dGR.dGV, my.dGS.dGM == i, view2, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        my.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b my = my(i);
        com.baidu.tieba.horizonalList.widget.a aVar = my.dGR;
        if (this.dGH instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dGH;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.dGU);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.dGU, aVar.dGV);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        my.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.dGH instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dGH;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.dGH.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dGI;
        int size = arrayList.size();
        this.dGJ = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int j = j(groupMetadata.dGO, groupMetadata.dGN);
                if (j != groupMetadata.dGN) {
                    if (j == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.dGN = j;
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
            if (groupMetadata2.dGM == -1 || z) {
                childrenCount = this.dGH.getChildrenCount(groupMetadata2.dGN);
            } else {
                childrenCount = groupMetadata2.dGM - groupMetadata2.dGL;
            }
            this.dGJ += childrenCount;
            int i5 = i4 + (groupMetadata2.dGN - i3);
            i3 = groupMetadata2.dGN;
            groupMetadata2.dGL = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.dGM = i6;
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
        if (bVar.dGS == null) {
            return false;
        }
        this.dGI.remove(bVar.dGS);
        z(false, false);
        notifyDataSetChanged();
        this.dGH.onGroupCollapsed(bVar.dGS.dGN);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.dGR.dGU < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.dGK != 0 && bVar.dGS == null) {
            if (this.dGI.size() >= this.dGK) {
                GroupMetadata groupMetadata = this.dGI.get(0);
                int indexOf = this.dGI.indexOf(groupMetadata);
                collapseGroup(groupMetadata.dGN);
                if (bVar.dGT > indexOf) {
                    bVar.dGT--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.dGR.dGU, this.dGH.getGroupId(bVar.dGR.dGU));
            this.dGI.add(bVar.dGT, a2);
            z(false, false);
            notifyDataSetChanged();
            this.dGH.onGroupExpanded(a2.dGN);
            return true;
        }
        return false;
    }

    ExpandableListAdapter ayo() {
        return this.dGH;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter ayo = ayo();
        if (ayo instanceof Filterable) {
            return ((Filterable) ayo).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> ayp() {
        return this.dGI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.dGH != null) {
            int groupCount = this.dGH.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).dGN >= groupCount) {
                    return;
                }
            }
            this.dGI = arrayList;
            z(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter ayo = ayo();
        if (ayo != null) {
            return ayo.isEmpty();
        }
        return true;
    }

    int j(long j, int i) {
        int groupCount = this.dGH.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter ayo = ayo();
        if (ayo == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (ayo.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.z(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.z(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: p */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: mz */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int dGL;
        int dGM;
        int dGN;
        long dGO;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.dGL = i;
            groupMetadata.dGM = i2;
            groupMetadata.dGN = i3;
            groupMetadata.dGO = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.dGN - groupMetadata.dGN;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.dGL);
            parcel.writeInt(this.dGM);
            parcel.writeInt(this.dGN);
            parcel.writeLong(this.dGO);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> dGQ = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a dGR;
        public GroupMetadata dGS;
        public int dGT;

        private void Lz() {
            if (this.dGR != null) {
                this.dGR.recycle();
                this.dGR = null;
            }
            this.dGS = null;
            this.dGT = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b ayq = ayq();
            ayq.dGR = com.baidu.tieba.horizonalList.widget.a.s(i2, i3, i4, i);
            ayq.dGS = groupMetadata;
            ayq.dGT = i5;
            return ayq;
        }

        private static b ayq() {
            b bVar;
            synchronized (dGQ) {
                if (dGQ.size() > 0) {
                    bVar = dGQ.remove(0);
                    bVar.Lz();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            Lz();
            synchronized (dGQ) {
                if (dGQ.size() < 5) {
                    dGQ.add(this);
                }
            }
        }

        public boolean anM() {
            return this.dGS != null;
        }
    }
}
