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
    private ExpandableListAdapter dGE;
    private int dGG;
    private int dGH = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> dGF = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.dGE != null) {
            this.dGE.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.dGE = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b mx(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.dGF;
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
            if (i > groupMetadata.dGJ) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.dGI) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.dGI) {
                return b.a(i, 2, groupMetadata.dGK, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.dGJ) {
                    return b.a(i, 1, groupMetadata.dGK, i - (groupMetadata.dGI + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.dGJ) + groupMetadata2.dGK;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.dGK - (groupMetadata3.dGI - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dGF;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.dGR, aVar.type, aVar.dGR, aVar.dGS, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.dGR > groupMetadata.dGK) {
                i4 = i + 1;
            } else if (aVar.dGR < groupMetadata.dGK) {
                i3 = i - 1;
            } else if (aVar.dGR == groupMetadata.dGK) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.dGI, aVar.type, aVar.dGR, aVar.dGS, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.dGI + aVar.dGS + 1, aVar.type, aVar.dGR, aVar.dGS, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.dGR - groupMetadata2.dGK) + groupMetadata2.dGJ, aVar.type, aVar.dGR, aVar.dGS, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.dGI - (groupMetadata3.dGK - aVar.dGR), aVar.type, aVar.dGR, aVar.dGS, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.dGE.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b mx = mx(i);
        com.baidu.tieba.horizonalList.widget.a aVar = mx.dGO;
        boolean isChildSelectable = aVar.type == 1 ? this.dGE.isChildSelectable(aVar.dGR, aVar.dGS) : true;
        mx.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dGE.getGroupCount() + this.dGG;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b mx = mx(i);
        if (mx.dGO.type == 2) {
            child = this.dGE.getGroup(mx.dGO.dGR);
        } else if (mx.dGO.type == 1) {
            child = this.dGE.getChild(mx.dGO.dGR, mx.dGO.dGS);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        mx.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b mx = mx(i);
        long groupId = this.dGE.getGroupId(mx.dGO.dGR);
        if (mx.dGO.type == 2) {
            combinedChildId = this.dGE.getCombinedGroupId(groupId);
        } else if (mx.dGO.type == 1) {
            combinedChildId = this.dGE.getCombinedChildId(groupId, this.dGE.getChildId(mx.dGO.dGR, mx.dGO.dGS));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        mx.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        View childView;
        b mx = mx(i);
        if (mx.dGO.type == 2) {
            childView = this.dGE.getGroupView(mx.dGO.dGR, mx.anM(), view2, viewGroup);
        } else if (mx.dGO.type == 1) {
            childView = this.dGE.getChildView(mx.dGO.dGR, mx.dGO.dGS, mx.dGP.dGJ == i, view2, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        mx.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b mx = mx(i);
        com.baidu.tieba.horizonalList.widget.a aVar = mx.dGO;
        if (this.dGE instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dGE;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.dGR);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.dGR, aVar.dGS);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        mx.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.dGE instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dGE;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.dGE.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dGF;
        int size = arrayList.size();
        this.dGG = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int j = j(groupMetadata.dGL, groupMetadata.dGK);
                if (j != groupMetadata.dGK) {
                    if (j == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.dGK = j;
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
            if (groupMetadata2.dGJ == -1 || z) {
                childrenCount = this.dGE.getChildrenCount(groupMetadata2.dGK);
            } else {
                childrenCount = groupMetadata2.dGJ - groupMetadata2.dGI;
            }
            this.dGG += childrenCount;
            int i5 = i4 + (groupMetadata2.dGK - i3);
            i3 = groupMetadata2.dGK;
            groupMetadata2.dGI = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.dGJ = i6;
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
        if (bVar.dGP == null) {
            return false;
        }
        this.dGF.remove(bVar.dGP);
        z(false, false);
        notifyDataSetChanged();
        this.dGE.onGroupCollapsed(bVar.dGP.dGK);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.dGO.dGR < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.dGH != 0 && bVar.dGP == null) {
            if (this.dGF.size() >= this.dGH) {
                GroupMetadata groupMetadata = this.dGF.get(0);
                int indexOf = this.dGF.indexOf(groupMetadata);
                collapseGroup(groupMetadata.dGK);
                if (bVar.dGQ > indexOf) {
                    bVar.dGQ--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.dGO.dGR, this.dGE.getGroupId(bVar.dGO.dGR));
            this.dGF.add(bVar.dGQ, a2);
            z(false, false);
            notifyDataSetChanged();
            this.dGE.onGroupExpanded(a2.dGK);
            return true;
        }
        return false;
    }

    ExpandableListAdapter ayo() {
        return this.dGE;
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
        return this.dGF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.dGE != null) {
            int groupCount = this.dGE.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).dGK >= groupCount) {
                    return;
                }
            }
            this.dGF = arrayList;
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
        int groupCount = this.dGE.getGroupCount();
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
            /* renamed from: my */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int dGI;
        int dGJ;
        int dGK;
        long dGL;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.dGI = i;
            groupMetadata.dGJ = i2;
            groupMetadata.dGK = i3;
            groupMetadata.dGL = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.dGK - groupMetadata.dGK;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.dGI);
            parcel.writeInt(this.dGJ);
            parcel.writeInt(this.dGK);
            parcel.writeLong(this.dGL);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> dGN = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a dGO;
        public GroupMetadata dGP;
        public int dGQ;

        private void Lz() {
            if (this.dGO != null) {
                this.dGO.recycle();
                this.dGO = null;
            }
            this.dGP = null;
            this.dGQ = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b ayq = ayq();
            ayq.dGO = com.baidu.tieba.horizonalList.widget.a.s(i2, i3, i4, i);
            ayq.dGP = groupMetadata;
            ayq.dGQ = i5;
            return ayq;
        }

        private static b ayq() {
            b bVar;
            synchronized (dGN) {
                if (dGN.size() > 0) {
                    bVar = dGN.remove(0);
                    bVar.Lz();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            Lz();
            synchronized (dGN) {
                if (dGN.size() < 5) {
                    dGN.add(this);
                }
            }
        }

        public boolean anM() {
            return this.dGP != null;
        }
    }
}
