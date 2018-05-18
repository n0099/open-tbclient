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
    private ExpandableListAdapter dHK;
    private int dHM;
    private int dHN = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> dHL = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.dHK != null) {
            this.dHK.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.dHK = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b mw(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.dHL;
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
            if (i > groupMetadata.dHP) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.dHO) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.dHO) {
                return b.a(i, 2, groupMetadata.dHQ, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.dHP) {
                    return b.a(i, 1, groupMetadata.dHQ, i - (groupMetadata.dHO + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.dHP) + groupMetadata2.dHQ;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.dHQ - (groupMetadata3.dHO - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dHL;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.dHX, aVar.type, aVar.dHX, aVar.dHY, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.dHX > groupMetadata.dHQ) {
                i4 = i + 1;
            } else if (aVar.dHX < groupMetadata.dHQ) {
                i3 = i - 1;
            } else if (aVar.dHX == groupMetadata.dHQ) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.dHO, aVar.type, aVar.dHX, aVar.dHY, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.dHO + aVar.dHY + 1, aVar.type, aVar.dHX, aVar.dHY, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.dHX - groupMetadata2.dHQ) + groupMetadata2.dHP, aVar.type, aVar.dHX, aVar.dHY, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.dHO - (groupMetadata3.dHQ - aVar.dHX), aVar.type, aVar.dHX, aVar.dHY, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.dHK.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b mw = mw(i);
        com.baidu.tieba.horizonalList.widget.a aVar = mw.dHU;
        boolean isChildSelectable = aVar.type == 1 ? this.dHK.isChildSelectable(aVar.dHX, aVar.dHY) : true;
        mw.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dHK.getGroupCount() + this.dHM;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b mw = mw(i);
        if (mw.dHU.type == 2) {
            child = this.dHK.getGroup(mw.dHU.dHX);
        } else if (mw.dHU.type == 1) {
            child = this.dHK.getChild(mw.dHU.dHX, mw.dHU.dHY);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        mw.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b mw = mw(i);
        long groupId = this.dHK.getGroupId(mw.dHU.dHX);
        if (mw.dHU.type == 2) {
            combinedChildId = this.dHK.getCombinedGroupId(groupId);
        } else if (mw.dHU.type == 1) {
            combinedChildId = this.dHK.getCombinedChildId(groupId, this.dHK.getChildId(mw.dHU.dHX, mw.dHU.dHY));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        mw.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        View childView;
        b mw = mw(i);
        if (mw.dHU.type == 2) {
            childView = this.dHK.getGroupView(mw.dHU.dHX, mw.anL(), view2, viewGroup);
        } else if (mw.dHU.type == 1) {
            childView = this.dHK.getChildView(mw.dHU.dHX, mw.dHU.dHY, mw.dHV.dHP == i, view2, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        mw.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b mw = mw(i);
        com.baidu.tieba.horizonalList.widget.a aVar = mw.dHU;
        if (this.dHK instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dHK;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.dHX);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.dHX, aVar.dHY);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        mw.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.dHK instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dHK;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.dHK.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dHL;
        int size = arrayList.size();
        this.dHM = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int i3 = i(groupMetadata.dHR, groupMetadata.dHQ);
                if (i3 != groupMetadata.dHQ) {
                    if (i3 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.dHQ = i3;
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
            if (groupMetadata2.dHP == -1 || z) {
                childrenCount = this.dHK.getChildrenCount(groupMetadata2.dHQ);
            } else {
                childrenCount = groupMetadata2.dHP - groupMetadata2.dHO;
            }
            this.dHM += childrenCount;
            int i6 = i5 + (groupMetadata2.dHQ - i4);
            i4 = groupMetadata2.dHQ;
            groupMetadata2.dHO = i6;
            int i7 = childrenCount + i6;
            groupMetadata2.dHP = i7;
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
        if (bVar.dHV == null) {
            return false;
        }
        this.dHL.remove(bVar.dHV);
        z(false, false);
        notifyDataSetChanged();
        this.dHK.onGroupCollapsed(bVar.dHV.dHQ);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.dHU.dHX < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.dHN != 0 && bVar.dHV == null) {
            if (this.dHL.size() >= this.dHN) {
                GroupMetadata groupMetadata = this.dHL.get(0);
                int indexOf = this.dHL.indexOf(groupMetadata);
                collapseGroup(groupMetadata.dHQ);
                if (bVar.dHW > indexOf) {
                    bVar.dHW--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.dHU.dHX, this.dHK.getGroupId(bVar.dHU.dHX));
            this.dHL.add(bVar.dHW, a2);
            z(false, false);
            notifyDataSetChanged();
            this.dHK.onGroupExpanded(a2.dHQ);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aym() {
        return this.dHK;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aym = aym();
        if (aym instanceof Filterable) {
            return ((Filterable) aym).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> ayn() {
        return this.dHL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.dHK != null) {
            int groupCount = this.dHK.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).dHQ >= groupCount) {
                    return;
                }
            }
            this.dHL = arrayList;
            z(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aym = aym();
        if (aym != null) {
            return aym.isEmpty();
        }
        return true;
    }

    int i(long j, int i) {
        int groupCount = this.dHK.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aym = aym();
        if (aym == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aym.getGroupId(i3) != j) {
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
            /* renamed from: q */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: mx */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int dHO;
        int dHP;
        int dHQ;
        long dHR;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.dHO = i;
            groupMetadata.dHP = i2;
            groupMetadata.dHQ = i3;
            groupMetadata.dHR = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.dHQ - groupMetadata.dHQ;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.dHO);
            parcel.writeInt(this.dHP);
            parcel.writeInt(this.dHQ);
            parcel.writeLong(this.dHR);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> dHT = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a dHU;
        public GroupMetadata dHV;
        public int dHW;

        private void Lx() {
            if (this.dHU != null) {
                this.dHU.recycle();
                this.dHU = null;
            }
            this.dHV = null;
            this.dHW = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b ayo = ayo();
            ayo.dHU = com.baidu.tieba.horizonalList.widget.a.s(i2, i3, i4, i);
            ayo.dHV = groupMetadata;
            ayo.dHW = i5;
            return ayo;
        }

        private static b ayo() {
            b bVar;
            synchronized (dHT) {
                if (dHT.size() > 0) {
                    bVar = dHT.remove(0);
                    bVar.Lx();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            Lx();
            synchronized (dHT) {
                if (dHT.size() < 5) {
                    dHT.add(this);
                }
            }
        }

        public boolean anL() {
            return this.dHV != null;
        }
    }
}
