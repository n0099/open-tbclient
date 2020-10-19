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
    private ExpandableListAdapter bsC;
    private int bsE;
    private int bsF = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> bsD = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.bsC != null) {
            this.bsC.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.bsC = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b Bo(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.bsD;
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
            if (i > groupMetadata.bsH) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.bsG) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.bsG) {
                return b.a(i, 2, groupMetadata.bsI, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.bsH) {
                    return b.a(i, 1, groupMetadata.bsI, i - (groupMetadata.bsG + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.bsH) + groupMetadata2.bsI;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.bsI - (groupMetadata3.bsG - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.bsD;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.bsP, aVar.type, aVar.bsP, aVar.bsQ, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.bsP > groupMetadata.bsI) {
                i4 = i + 1;
            } else if (aVar.bsP < groupMetadata.bsI) {
                i3 = i - 1;
            } else if (aVar.bsP == groupMetadata.bsI) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.bsG, aVar.type, aVar.bsP, aVar.bsQ, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.bsG + aVar.bsQ + 1, aVar.type, aVar.bsP, aVar.bsQ, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.bsP - groupMetadata2.bsI) + groupMetadata2.bsH, aVar.type, aVar.bsP, aVar.bsQ, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.bsG - (groupMetadata3.bsI - aVar.bsP), aVar.type, aVar.bsP, aVar.bsQ, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.bsC.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b Bo = Bo(i);
        com.baidu.tieba.horizonalList.widget.a aVar = Bo.juw;
        boolean isChildSelectable = aVar.type == 1 ? this.bsC.isChildSelectable(aVar.bsP, aVar.bsQ) : true;
        Bo.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bsC.getGroupCount() + this.bsE;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b Bo = Bo(i);
        if (Bo.juw.type == 2) {
            child = this.bsC.getGroup(Bo.juw.bsP);
        } else if (Bo.juw.type == 1) {
            child = this.bsC.getChild(Bo.juw.bsP, Bo.juw.bsQ);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        Bo.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b Bo = Bo(i);
        long groupId = this.bsC.getGroupId(Bo.juw.bsP);
        if (Bo.juw.type == 2) {
            combinedChildId = this.bsC.getCombinedGroupId(groupId);
        } else if (Bo.juw.type == 1) {
            combinedChildId = this.bsC.getCombinedChildId(groupId, this.bsC.getChildId(Bo.juw.bsP, Bo.juw.bsQ));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        Bo.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b Bo = Bo(i);
        if (Bo.juw.type == 2) {
            childView = this.bsC.getGroupView(Bo.juw.bsP, Bo.PE(), view, viewGroup);
        } else if (Bo.juw.type == 1) {
            childView = this.bsC.getChildView(Bo.juw.bsP, Bo.juw.bsQ, Bo.jux.bsH == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        Bo.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b Bo = Bo(i);
        com.baidu.tieba.horizonalList.widget.a aVar = Bo.juw;
        if (this.bsC instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bsC;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.bsP);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.bsP, aVar.bsQ);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        Bo.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.bsC instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bsC;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.bsC.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.bsD;
        int size = arrayList.size();
        this.bsE = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int f = f(groupMetadata.bsJ, groupMetadata.bsI);
                if (f != groupMetadata.bsI) {
                    if (f == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.bsI = f;
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
            if (groupMetadata2.bsH == -1 || z) {
                childrenCount = this.bsC.getChildrenCount(groupMetadata2.bsI);
            } else {
                childrenCount = groupMetadata2.bsH - groupMetadata2.bsG;
            }
            this.bsE += childrenCount;
            int i5 = i4 + (groupMetadata2.bsI - i3);
            i3 = groupMetadata2.bsI;
            groupMetadata2.bsG = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.bsH = i6;
            i++;
            i4 = i6;
        }
    }

    boolean fq(int i) {
        com.baidu.tieba.horizonalList.widget.a C = com.baidu.tieba.horizonalList.widget.a.C(2, i, -1, -1);
        b a2 = a(C);
        C.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.jux == null) {
            return false;
        }
        this.bsD.remove(bVar.jux);
        g(false, false);
        notifyDataSetChanged();
        this.bsC.onGroupCollapsed(bVar.jux.bsI);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.juw.bsP < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.bsF != 0 && bVar.jux == null) {
            if (this.bsD.size() >= this.bsF) {
                GroupMetadata groupMetadata = this.bsD.get(0);
                int indexOf = this.bsD.indexOf(groupMetadata);
                fq(groupMetadata.bsI);
                if (bVar.bsO > indexOf) {
                    bVar.bsO--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.juw.bsP, this.bsC.getGroupId(bVar.juw.bsP));
            this.bsD.add(bVar.bsO, b2);
            g(false, false);
            notifyDataSetChanged();
            this.bsC.onGroupExpanded(b2.bsI);
            return true;
        }
        return false;
    }

    ExpandableListAdapter PB() {
        return this.bsC;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter PB = PB();
        if (PB instanceof Filterable) {
            return ((Filterable) PB).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> PC() {
        return this.bsD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.bsC != null) {
            int groupCount = this.bsC.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).bsI >= groupCount) {
                    return;
                }
            }
            this.bsD = arrayList;
            g(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter PB = PB();
        if (PB != null) {
            return PB.isEmpty();
        }
        return true;
    }

    int f(long j, int i) {
        int groupCount = this.bsC.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter PB = PB();
        if (PB == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (PB.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.g(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.g(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ab */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.b(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Bp */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int bsG;
        int bsH;
        int bsI;
        long bsJ;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.bsG = i;
            groupMetadata.bsH = i2;
            groupMetadata.bsI = i3;
            groupMetadata.bsJ = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.bsI - groupMetadata.bsI;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.bsG);
            parcel.writeInt(this.bsH);
            parcel.writeInt(this.bsI);
            parcel.writeLong(this.bsJ);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> bsL = new ArrayList<>(5);
        public int bsO;
        public com.baidu.tieba.horizonalList.widget.a juw;
        public GroupMetadata jux;

        private void resetState() {
            if (this.juw != null) {
                this.juw.recycle();
                this.juw = null;
            }
            this.jux = null;
            this.bsO = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b cGH = cGH();
            cGH.juw = com.baidu.tieba.horizonalList.widget.a.C(i2, i3, i4, i);
            cGH.jux = groupMetadata;
            cGH.bsO = i5;
            return cGH;
        }

        private static b cGH() {
            b bVar;
            synchronized (bsL) {
                if (bsL.size() > 0) {
                    bVar = bsL.remove(0);
                    bVar.resetState();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            resetState();
            synchronized (bsL) {
                if (bsL.size() < 5) {
                    bsL.add(this);
                }
            }
        }

        public boolean PE() {
            return this.jux != null;
        }
    }
}
