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
    private ExpandableListAdapter eyf;
    private int eyh;
    private int eyi = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> eyg = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.eyf != null) {
            this.eyf.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.eyf = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b oR(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.eyg;
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
            if (i > groupMetadata.eyk) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.eyj) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.eyj) {
                return b.a(i, 2, groupMetadata.eyl, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.eyk) {
                    return b.a(i, 1, groupMetadata.eyl, i - (groupMetadata.eyj + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.eyk) + groupMetadata2.eyl;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.eyl - (groupMetadata3.eyj - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.eyg;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.eyt, aVar.type, aVar.eyt, aVar.eyu, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.eyt > groupMetadata.eyl) {
                i4 = i + 1;
            } else if (aVar.eyt < groupMetadata.eyl) {
                i3 = i - 1;
            } else if (aVar.eyt == groupMetadata.eyl) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.eyj, aVar.type, aVar.eyt, aVar.eyu, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.eyj + aVar.eyu + 1, aVar.type, aVar.eyt, aVar.eyu, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.eyt - groupMetadata2.eyl) + groupMetadata2.eyk, aVar.type, aVar.eyt, aVar.eyu, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.eyj - (groupMetadata3.eyl - aVar.eyt), aVar.type, aVar.eyt, aVar.eyu, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.eyf.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b oR = oR(i);
        com.baidu.tieba.horizonalList.widget.a aVar = oR.eyq;
        boolean isChildSelectable = aVar.type == 1 ? this.eyf.isChildSelectable(aVar.eyt, aVar.eyu) : true;
        oR.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eyf.getGroupCount() + this.eyh;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b oR = oR(i);
        if (oR.eyq.type == 2) {
            child = this.eyf.getGroup(oR.eyq.eyt);
        } else if (oR.eyq.type == 1) {
            child = this.eyf.getChild(oR.eyq.eyt, oR.eyq.eyu);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        oR.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b oR = oR(i);
        long groupId = this.eyf.getGroupId(oR.eyq.eyt);
        if (oR.eyq.type == 2) {
            combinedChildId = this.eyf.getCombinedGroupId(groupId);
        } else if (oR.eyq.type == 1) {
            combinedChildId = this.eyf.getCombinedChildId(groupId, this.eyf.getChildId(oR.eyq.eyt, oR.eyq.eyu));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        oR.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b oR = oR(i);
        if (oR.eyq.type == 2) {
            childView = this.eyf.getGroupView(oR.eyq.eyt, oR.ayf(), view, viewGroup);
        } else if (oR.eyq.type == 1) {
            childView = this.eyf.getChildView(oR.eyq.eyt, oR.eyq.eyu, oR.eyr.eyk == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        oR.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b oR = oR(i);
        com.baidu.tieba.horizonalList.widget.a aVar = oR.eyq;
        if (this.eyf instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.eyf;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.eyt);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.eyt, aVar.eyu);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        oR.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.eyf instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.eyf;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.eyf.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.eyg;
        int size = arrayList.size();
        this.eyh = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int l = l(groupMetadata.eyn, groupMetadata.eyl);
                if (l != groupMetadata.eyl) {
                    if (l == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.eyl = l;
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
            if (groupMetadata2.eyk == -1 || z) {
                childrenCount = this.eyf.getChildrenCount(groupMetadata2.eyl);
            } else {
                childrenCount = groupMetadata2.eyk - groupMetadata2.eyj;
            }
            this.eyh += childrenCount;
            int i5 = i4 + (groupMetadata2.eyl - i3);
            i3 = groupMetadata2.eyl;
            groupMetadata2.eyj = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.eyk = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a t = com.baidu.tieba.horizonalList.widget.a.t(2, i, -1, -1);
        b a2 = a(t);
        t.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.eyr == null) {
            return false;
        }
        this.eyg.remove(bVar.eyr);
        H(false, false);
        notifyDataSetChanged();
        this.eyf.onGroupCollapsed(bVar.eyr.eyl);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.eyq.eyt < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.eyi != 0 && bVar.eyr == null) {
            if (this.eyg.size() >= this.eyi) {
                GroupMetadata groupMetadata = this.eyg.get(0);
                int indexOf = this.eyg.indexOf(groupMetadata);
                collapseGroup(groupMetadata.eyl);
                if (bVar.eys > indexOf) {
                    bVar.eys--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.eyq.eyt, this.eyf.getGroupId(bVar.eyq.eyt));
            this.eyg.add(bVar.eys, b2);
            H(false, false);
            notifyDataSetChanged();
            this.eyf.onGroupExpanded(b2.eyl);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aLK() {
        return this.eyf;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aLK = aLK();
        if (aLK instanceof Filterable) {
            return ((Filterable) aLK).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aLL() {
        return this.eyg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.eyf != null) {
            int groupCount = this.eyf.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).eyl >= groupCount) {
                    return;
                }
            }
            this.eyg = arrayList;
            H(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aLK = aLK();
        if (aLK != null) {
            return aLK.isEmpty();
        }
        return true;
    }

    int l(long j, int i) {
        int groupCount = this.eyf.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aLK = aLK();
        if (aLK == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aLK.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.H(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.H(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: s */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.b(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: oS */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int eyj;
        int eyk;
        int eyl;
        long eyn;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.eyj = i;
            groupMetadata.eyk = i2;
            groupMetadata.eyl = i3;
            groupMetadata.eyn = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.eyl - groupMetadata.eyl;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.eyj);
            parcel.writeInt(this.eyk);
            parcel.writeInt(this.eyl);
            parcel.writeLong(this.eyn);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> eyp = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a eyq;
        public GroupMetadata eyr;
        public int eys;

        private void UB() {
            if (this.eyq != null) {
                this.eyq.recycle();
                this.eyq = null;
            }
            this.eyr = null;
            this.eys = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aLM = aLM();
            aLM.eyq = com.baidu.tieba.horizonalList.widget.a.t(i2, i3, i4, i);
            aLM.eyr = groupMetadata;
            aLM.eys = i5;
            return aLM;
        }

        private static b aLM() {
            b bVar;
            synchronized (eyp) {
                if (eyp.size() > 0) {
                    bVar = eyp.remove(0);
                    bVar.UB();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            UB();
            synchronized (eyp) {
                if (eyp.size() < 5) {
                    eyp.add(this);
                }
            }
        }

        public boolean ayf() {
            return this.eyr != null;
        }
    }
}
