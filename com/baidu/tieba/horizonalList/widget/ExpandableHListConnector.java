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
    private ExpandableListAdapter dWP;
    private int dWR;
    private int dWS = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> dWQ = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.dWP != null) {
            this.dWP.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.dWP = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b mP(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.dWQ;
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
            if (i > groupMetadata.dWU) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.dWT) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.dWT) {
                return b.a(i, 2, groupMetadata.dWV, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.dWU) {
                    return b.a(i, 1, groupMetadata.dWV, i - (groupMetadata.dWT + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.dWU) + groupMetadata2.dWV;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.dWV - (groupMetadata3.dWT - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dWQ;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.dXc, aVar.type, aVar.dXc, aVar.dXd, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.dXc > groupMetadata.dWV) {
                i4 = i + 1;
            } else if (aVar.dXc < groupMetadata.dWV) {
                i3 = i - 1;
            } else if (aVar.dXc == groupMetadata.dWV) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.dWT, aVar.type, aVar.dXc, aVar.dXd, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.dWT + aVar.dXd + 1, aVar.type, aVar.dXc, aVar.dXd, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.dXc - groupMetadata2.dWV) + groupMetadata2.dWU, aVar.type, aVar.dXc, aVar.dXd, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.dWT - (groupMetadata3.dWV - aVar.dXc), aVar.type, aVar.dXc, aVar.dXd, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.dWP.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b mP = mP(i);
        com.baidu.tieba.horizonalList.widget.a aVar = mP.dWZ;
        boolean isChildSelectable = aVar.type == 1 ? this.dWP.isChildSelectable(aVar.dXc, aVar.dXd) : true;
        mP.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dWP.getGroupCount() + this.dWR;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b mP = mP(i);
        if (mP.dWZ.type == 2) {
            child = this.dWP.getGroup(mP.dWZ.dXc);
        } else if (mP.dWZ.type == 1) {
            child = this.dWP.getChild(mP.dWZ.dXc, mP.dWZ.dXd);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        mP.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b mP = mP(i);
        long groupId = this.dWP.getGroupId(mP.dWZ.dXc);
        if (mP.dWZ.type == 2) {
            combinedChildId = this.dWP.getCombinedGroupId(groupId);
        } else if (mP.dWZ.type == 1) {
            combinedChildId = this.dWP.getCombinedChildId(groupId, this.dWP.getChildId(mP.dWZ.dXc, mP.dWZ.dXd));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        mP.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b mP = mP(i);
        if (mP.dWZ.type == 2) {
            childView = this.dWP.getGroupView(mP.dWZ.dXc, mP.arl(), view, viewGroup);
        } else if (mP.dWZ.type == 1) {
            childView = this.dWP.getChildView(mP.dWZ.dXc, mP.dWZ.dXd, mP.dXa.dWU == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        mP.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b mP = mP(i);
        com.baidu.tieba.horizonalList.widget.a aVar = mP.dWZ;
        if (this.dWP instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dWP;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.dXc);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.dXc, aVar.dXd);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        mP.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.dWP instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dWP;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.dWP.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dWQ;
        int size = arrayList.size();
        this.dWR = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int i3 = i(groupMetadata.dWW, groupMetadata.dWV);
                if (i3 != groupMetadata.dWV) {
                    if (i3 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.dWV = i3;
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
            if (groupMetadata2.dWU == -1 || z) {
                childrenCount = this.dWP.getChildrenCount(groupMetadata2.dWV);
            } else {
                childrenCount = groupMetadata2.dWU - groupMetadata2.dWT;
            }
            this.dWR += childrenCount;
            int i6 = i5 + (groupMetadata2.dWV - i4);
            i4 = groupMetadata2.dWV;
            groupMetadata2.dWT = i6;
            int i7 = childrenCount + i6;
            groupMetadata2.dWU = i7;
            i++;
            i5 = i7;
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
        if (bVar.dXa == null) {
            return false;
        }
        this.dWQ.remove(bVar.dXa);
        C(false, false);
        notifyDataSetChanged();
        this.dWP.onGroupCollapsed(bVar.dXa.dWV);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.dWZ.dXc < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.dWS != 0 && bVar.dXa == null) {
            if (this.dWQ.size() >= this.dWS) {
                GroupMetadata groupMetadata = this.dWQ.get(0);
                int indexOf = this.dWQ.indexOf(groupMetadata);
                collapseGroup(groupMetadata.dWV);
                if (bVar.dXb > indexOf) {
                    bVar.dXb--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.dWZ.dXc, this.dWP.getGroupId(bVar.dWZ.dXc));
            this.dWQ.add(bVar.dXb, a2);
            C(false, false);
            notifyDataSetChanged();
            this.dWP.onGroupExpanded(a2.dWV);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aDR() {
        return this.dWP;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aDR = aDR();
        if (aDR instanceof Filterable) {
            return ((Filterable) aDR).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aDS() {
        return this.dWQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.dWP != null) {
            int groupCount = this.dWP.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).dWV >= groupCount) {
                    return;
                }
            }
            this.dWQ = arrayList;
            C(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aDR = aDR();
        if (aDR != null) {
            return aDR.isEmpty();
        }
        return true;
    }

    int i(long j, int i) {
        int groupCount = this.dWP.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aDR = aDR();
        if (aDR == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aDR.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.C(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.C(true, true);
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
            /* renamed from: mQ */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int dWT;
        int dWU;
        int dWV;
        long dWW;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.dWT = i;
            groupMetadata.dWU = i2;
            groupMetadata.dWV = i3;
            groupMetadata.dWW = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.dWV - groupMetadata.dWV;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.dWT);
            parcel.writeInt(this.dWU);
            parcel.writeInt(this.dWV);
            parcel.writeLong(this.dWW);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> dWY = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a dWZ;
        public GroupMetadata dXa;
        public int dXb;

        private void Pr() {
            if (this.dWZ != null) {
                this.dWZ.recycle();
                this.dWZ = null;
            }
            this.dXa = null;
            this.dXb = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aDT = aDT();
            aDT.dWZ = com.baidu.tieba.horizonalList.widget.a.s(i2, i3, i4, i);
            aDT.dXa = groupMetadata;
            aDT.dXb = i5;
            return aDT;
        }

        private static b aDT() {
            b bVar;
            synchronized (dWY) {
                if (dWY.size() > 0) {
                    bVar = dWY.remove(0);
                    bVar.Pr();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            Pr();
            synchronized (dWY) {
                if (dWY.size() < 5) {
                    dWY.add(this);
                }
            }
        }

        public boolean arl() {
            return this.dXa != null;
        }
    }
}
