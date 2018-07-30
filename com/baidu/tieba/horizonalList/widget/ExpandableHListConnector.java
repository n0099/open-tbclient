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
    private ExpandableListAdapter eaH;
    private int eaJ;
    private int eaK = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> eaI = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.eaH != null) {
            this.eaH.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.eaH = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b nd(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.eaI;
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
            if (i > groupMetadata.eaM) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.eaL) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.eaL) {
                return b.a(i, 2, groupMetadata.eaN, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.eaM) {
                    return b.a(i, 1, groupMetadata.eaN, i - (groupMetadata.eaL + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.eaM) + groupMetadata2.eaN;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.eaN - (groupMetadata3.eaL - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.eaI;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.eaU, aVar.type, aVar.eaU, aVar.eaV, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.eaU > groupMetadata.eaN) {
                i4 = i + 1;
            } else if (aVar.eaU < groupMetadata.eaN) {
                i3 = i - 1;
            } else if (aVar.eaU == groupMetadata.eaN) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.eaL, aVar.type, aVar.eaU, aVar.eaV, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.eaL + aVar.eaV + 1, aVar.type, aVar.eaU, aVar.eaV, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.eaU - groupMetadata2.eaN) + groupMetadata2.eaM, aVar.type, aVar.eaU, aVar.eaV, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.eaL - (groupMetadata3.eaN - aVar.eaU), aVar.type, aVar.eaU, aVar.eaV, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.eaH.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b nd = nd(i);
        com.baidu.tieba.horizonalList.widget.a aVar = nd.eaR;
        boolean isChildSelectable = aVar.type == 1 ? this.eaH.isChildSelectable(aVar.eaU, aVar.eaV) : true;
        nd.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eaH.getGroupCount() + this.eaJ;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b nd = nd(i);
        if (nd.eaR.type == 2) {
            child = this.eaH.getGroup(nd.eaR.eaU);
        } else if (nd.eaR.type == 1) {
            child = this.eaH.getChild(nd.eaR.eaU, nd.eaR.eaV);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        nd.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b nd = nd(i);
        long groupId = this.eaH.getGroupId(nd.eaR.eaU);
        if (nd.eaR.type == 2) {
            combinedChildId = this.eaH.getCombinedGroupId(groupId);
        } else if (nd.eaR.type == 1) {
            combinedChildId = this.eaH.getCombinedChildId(groupId, this.eaH.getChildId(nd.eaR.eaU, nd.eaR.eaV));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        nd.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b nd = nd(i);
        if (nd.eaR.type == 2) {
            childView = this.eaH.getGroupView(nd.eaR.eaU, nd.arL(), view, viewGroup);
        } else if (nd.eaR.type == 1) {
            childView = this.eaH.getChildView(nd.eaR.eaU, nd.eaR.eaV, nd.eaS.eaM == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        nd.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b nd = nd(i);
        com.baidu.tieba.horizonalList.widget.a aVar = nd.eaR;
        if (this.eaH instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.eaH;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.eaU);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.eaU, aVar.eaV);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        nd.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.eaH instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.eaH;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.eaH.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.eaI;
        int size = arrayList.size();
        this.eaJ = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int i3 = i(groupMetadata.eaO, groupMetadata.eaN);
                if (i3 != groupMetadata.eaN) {
                    if (i3 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.eaN = i3;
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
            if (groupMetadata2.eaM == -1 || z) {
                childrenCount = this.eaH.getChildrenCount(groupMetadata2.eaN);
            } else {
                childrenCount = groupMetadata2.eaM - groupMetadata2.eaL;
            }
            this.eaJ += childrenCount;
            int i6 = i5 + (groupMetadata2.eaN - i4);
            i4 = groupMetadata2.eaN;
            groupMetadata2.eaL = i6;
            int i7 = childrenCount + i6;
            groupMetadata2.eaM = i7;
            i++;
            i5 = i7;
        }
    }

    boolean collapseGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a r = com.baidu.tieba.horizonalList.widget.a.r(2, i, -1, -1);
        b a2 = a(r);
        r.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.eaS == null) {
            return false;
        }
        this.eaI.remove(bVar.eaS);
        C(false, false);
        notifyDataSetChanged();
        this.eaH.onGroupCollapsed(bVar.eaS.eaN);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.eaR.eaU < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.eaK != 0 && bVar.eaS == null) {
            if (this.eaI.size() >= this.eaK) {
                GroupMetadata groupMetadata = this.eaI.get(0);
                int indexOf = this.eaI.indexOf(groupMetadata);
                collapseGroup(groupMetadata.eaN);
                if (bVar.eaT > indexOf) {
                    bVar.eaT--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.eaR.eaU, this.eaH.getGroupId(bVar.eaR.eaU));
            this.eaI.add(bVar.eaT, a2);
            C(false, false);
            notifyDataSetChanged();
            this.eaH.onGroupExpanded(a2.eaN);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aER() {
        return this.eaH;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aER = aER();
        if (aER instanceof Filterable) {
            return ((Filterable) aER).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aES() {
        return this.eaI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.eaH != null) {
            int groupCount = this.eaH.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).eaN >= groupCount) {
                    return;
                }
            }
            this.eaI = arrayList;
            C(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aER = aER();
        if (aER != null) {
            return aER.isEmpty();
        }
        return true;
    }

    int i(long j, int i) {
        int groupCount = this.eaH.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aER = aER();
        if (aER == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aER.getGroupId(i3) != j) {
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
            /* renamed from: ne */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int eaL;
        int eaM;
        int eaN;
        long eaO;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.eaL = i;
            groupMetadata.eaM = i2;
            groupMetadata.eaN = i3;
            groupMetadata.eaO = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.eaN - groupMetadata.eaN;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.eaL);
            parcel.writeInt(this.eaM);
            parcel.writeInt(this.eaN);
            parcel.writeLong(this.eaO);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> eaQ = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a eaR;
        public GroupMetadata eaS;
        public int eaT;

        private void Px() {
            if (this.eaR != null) {
                this.eaR.recycle();
                this.eaR = null;
            }
            this.eaS = null;
            this.eaT = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aET = aET();
            aET.eaR = com.baidu.tieba.horizonalList.widget.a.r(i2, i3, i4, i);
            aET.eaS = groupMetadata;
            aET.eaT = i5;
            return aET;
        }

        private static b aET() {
            b bVar;
            synchronized (eaQ) {
                if (eaQ.size() > 0) {
                    bVar = eaQ.remove(0);
                    bVar.Px();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            Px();
            synchronized (eaQ) {
                if (eaQ.size() < 5) {
                    eaQ.add(this);
                }
            }
        }

        public boolean arL() {
            return this.eaS != null;
        }
    }
}
