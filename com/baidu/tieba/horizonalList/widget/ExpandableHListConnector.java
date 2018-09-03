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
    private ExpandableListAdapter eaE;
    private int eaG;
    private int eaH = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> eaF = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.eaE != null) {
            this.eaE.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.eaE = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b nd(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.eaF;
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
            if (i > groupMetadata.eaJ) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.eaI) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.eaI) {
                return b.a(i, 2, groupMetadata.eaK, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.eaJ) {
                    return b.a(i, 1, groupMetadata.eaK, i - (groupMetadata.eaI + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.eaJ) + groupMetadata2.eaK;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.eaK - (groupMetadata3.eaI - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.eaF;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.eaR, aVar.type, aVar.eaR, aVar.eaS, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.eaR > groupMetadata.eaK) {
                i4 = i + 1;
            } else if (aVar.eaR < groupMetadata.eaK) {
                i3 = i - 1;
            } else if (aVar.eaR == groupMetadata.eaK) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.eaI, aVar.type, aVar.eaR, aVar.eaS, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.eaI + aVar.eaS + 1, aVar.type, aVar.eaR, aVar.eaS, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.eaR - groupMetadata2.eaK) + groupMetadata2.eaJ, aVar.type, aVar.eaR, aVar.eaS, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.eaI - (groupMetadata3.eaK - aVar.eaR), aVar.type, aVar.eaR, aVar.eaS, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.eaE.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b nd = nd(i);
        com.baidu.tieba.horizonalList.widget.a aVar = nd.eaO;
        boolean isChildSelectable = aVar.type == 1 ? this.eaE.isChildSelectable(aVar.eaR, aVar.eaS) : true;
        nd.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eaE.getGroupCount() + this.eaG;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b nd = nd(i);
        if (nd.eaO.type == 2) {
            child = this.eaE.getGroup(nd.eaO.eaR);
        } else if (nd.eaO.type == 1) {
            child = this.eaE.getChild(nd.eaO.eaR, nd.eaO.eaS);
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
        long groupId = this.eaE.getGroupId(nd.eaO.eaR);
        if (nd.eaO.type == 2) {
            combinedChildId = this.eaE.getCombinedGroupId(groupId);
        } else if (nd.eaO.type == 1) {
            combinedChildId = this.eaE.getCombinedChildId(groupId, this.eaE.getChildId(nd.eaO.eaR, nd.eaO.eaS));
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
        if (nd.eaO.type == 2) {
            childView = this.eaE.getGroupView(nd.eaO.eaR, nd.arL(), view, viewGroup);
        } else if (nd.eaO.type == 1) {
            childView = this.eaE.getChildView(nd.eaO.eaR, nd.eaO.eaS, nd.eaP.eaJ == i, view, viewGroup);
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
        com.baidu.tieba.horizonalList.widget.a aVar = nd.eaO;
        if (this.eaE instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.eaE;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.eaR);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.eaR, aVar.eaS);
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
        if (this.eaE instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.eaE;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.eaE.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.eaF;
        int size = arrayList.size();
        this.eaG = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int i3 = i(groupMetadata.eaL, groupMetadata.eaK);
                if (i3 != groupMetadata.eaK) {
                    if (i3 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.eaK = i3;
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
            if (groupMetadata2.eaJ == -1 || z) {
                childrenCount = this.eaE.getChildrenCount(groupMetadata2.eaK);
            } else {
                childrenCount = groupMetadata2.eaJ - groupMetadata2.eaI;
            }
            this.eaG += childrenCount;
            int i6 = i5 + (groupMetadata2.eaK - i4);
            i4 = groupMetadata2.eaK;
            groupMetadata2.eaI = i6;
            int i7 = childrenCount + i6;
            groupMetadata2.eaJ = i7;
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
        if (bVar.eaP == null) {
            return false;
        }
        this.eaF.remove(bVar.eaP);
        C(false, false);
        notifyDataSetChanged();
        this.eaE.onGroupCollapsed(bVar.eaP.eaK);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.eaO.eaR < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.eaH != 0 && bVar.eaP == null) {
            if (this.eaF.size() >= this.eaH) {
                GroupMetadata groupMetadata = this.eaF.get(0);
                int indexOf = this.eaF.indexOf(groupMetadata);
                collapseGroup(groupMetadata.eaK);
                if (bVar.eaQ > indexOf) {
                    bVar.eaQ--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.eaO.eaR, this.eaE.getGroupId(bVar.eaO.eaR));
            this.eaF.add(bVar.eaQ, a2);
            C(false, false);
            notifyDataSetChanged();
            this.eaE.onGroupExpanded(a2.eaK);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aEO() {
        return this.eaE;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aEO = aEO();
        if (aEO instanceof Filterable) {
            return ((Filterable) aEO).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aEP() {
        return this.eaF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.eaE != null) {
            int groupCount = this.eaE.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).eaK >= groupCount) {
                    return;
                }
            }
            this.eaF = arrayList;
            C(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aEO = aEO();
        if (aEO != null) {
            return aEO.isEmpty();
        }
        return true;
    }

    int i(long j, int i) {
        int groupCount = this.eaE.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aEO = aEO();
        if (aEO == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aEO.getGroupId(i3) != j) {
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
        int eaI;
        int eaJ;
        int eaK;
        long eaL;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.eaI = i;
            groupMetadata.eaJ = i2;
            groupMetadata.eaK = i3;
            groupMetadata.eaL = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.eaK - groupMetadata.eaK;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.eaI);
            parcel.writeInt(this.eaJ);
            parcel.writeInt(this.eaK);
            parcel.writeLong(this.eaL);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> eaN = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a eaO;
        public GroupMetadata eaP;
        public int eaQ;

        private void PD() {
            if (this.eaO != null) {
                this.eaO.recycle();
                this.eaO = null;
            }
            this.eaP = null;
            this.eaQ = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aEQ = aEQ();
            aEQ.eaO = com.baidu.tieba.horizonalList.widget.a.r(i2, i3, i4, i);
            aEQ.eaP = groupMetadata;
            aEQ.eaQ = i5;
            return aEQ;
        }

        private static b aEQ() {
            b bVar;
            synchronized (eaN) {
                if (eaN.size() > 0) {
                    bVar = eaN.remove(0);
                    bVar.PD();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            PD();
            synchronized (eaN) {
                if (eaN.size() < 5) {
                    eaN.add(this);
                }
            }
        }

        public boolean arL() {
            return this.eaP != null;
        }
    }
}
