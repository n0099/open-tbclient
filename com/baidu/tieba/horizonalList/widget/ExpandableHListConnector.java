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
    private ExpandableListAdapter dfU;
    private int dfW;
    private int dfX = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> dfV = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.dfU != null) {
            this.dfU.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.dfU = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b ly(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.dfV;
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
            if (i > groupMetadata.dfZ) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.dfY) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.dfY) {
                return b.a(i, 2, groupMetadata.dga, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.dfZ) {
                    return b.a(i, 1, groupMetadata.dga, i - (groupMetadata.dfY + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.dfZ) + groupMetadata2.dga;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.dga - (groupMetadata3.dfY - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.b bVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dfV;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(bVar.dgh, bVar.type, bVar.dgh, bVar.dgi, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (bVar.dgh > groupMetadata.dga) {
                i4 = i + 1;
            } else if (bVar.dgh < groupMetadata.dga) {
                i3 = i - 1;
            } else if (bVar.dgh == groupMetadata.dga) {
                if (bVar.type == 2) {
                    return b.a(groupMetadata.dfY, bVar.type, bVar.dgh, bVar.dgi, groupMetadata, i);
                }
                if (bVar.type == 1) {
                    return b.a(groupMetadata.dfY + bVar.dgi + 1, bVar.type, bVar.dgh, bVar.dgi, groupMetadata, i);
                }
                return null;
            }
        }
        if (bVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((bVar.dgh - groupMetadata2.dga) + groupMetadata2.dfZ, bVar.type, bVar.dgh, bVar.dgi, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.dfY - (groupMetadata3.dga - bVar.dgh), bVar.type, bVar.dgh, bVar.dgi, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.dfU.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b ly = ly(i);
        com.baidu.tieba.horizonalList.widget.b bVar = ly.dge;
        boolean isChildSelectable = bVar.type == 1 ? this.dfU.isChildSelectable(bVar.dgh, bVar.dgi) : true;
        ly.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dfU.getGroupCount() + this.dfW;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b ly = ly(i);
        if (ly.dge.type == 2) {
            child = this.dfU.getGroup(ly.dge.dgh);
        } else if (ly.dge.type == 1) {
            child = this.dfU.getChild(ly.dge.dgh, ly.dge.dgi);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ly.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b ly = ly(i);
        long groupId = this.dfU.getGroupId(ly.dge.dgh);
        if (ly.dge.type == 2) {
            combinedChildId = this.dfU.getCombinedGroupId(groupId);
        } else if (ly.dge.type == 1) {
            combinedChildId = this.dfU.getCombinedChildId(groupId, this.dfU.getChildId(ly.dge.dgh, ly.dge.dgi));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ly.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b ly = ly(i);
        if (ly.dge.type == 2) {
            childView = this.dfU.getGroupView(ly.dge.dgh, ly.arA(), view, viewGroup);
        } else if (ly.dge.type == 1) {
            childView = this.dfU.getChildView(ly.dge.dgh, ly.dge.dgi, ly.dgf.dfZ == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ly.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b ly = ly(i);
        com.baidu.tieba.horizonalList.widget.b bVar = ly.dge;
        if (this.dfU instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dfU;
            if (bVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(bVar.dgh);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(bVar.dgh, bVar.dgi);
            }
        } else if (bVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        ly.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.dfU instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dfU;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.dfU.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dfV;
        int size = arrayList.size();
        this.dfW = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int g = g(groupMetadata.dgb, groupMetadata.dga);
                if (g != groupMetadata.dga) {
                    if (g == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.dga = g;
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
            if (groupMetadata2.dfZ == -1 || z) {
                childrenCount = this.dfU.getChildrenCount(groupMetadata2.dga);
            } else {
                childrenCount = groupMetadata2.dfZ - groupMetadata2.dfY;
            }
            this.dfW += childrenCount;
            int i5 = i4 + (groupMetadata2.dga - i3);
            i3 = groupMetadata2.dga;
            groupMetadata2.dfY = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.dfZ = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b m = com.baidu.tieba.horizonalList.widget.b.m(2, i, -1, -1);
        b a2 = a(m);
        m.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.dgf == null) {
            return false;
        }
        this.dfV.remove(bVar.dgf);
        y(false, false);
        notifyDataSetChanged();
        this.dfU.onGroupCollapsed(bVar.dgf.dga);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.dge.dgh < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.dfX != 0 && bVar.dgf == null) {
            if (this.dfV.size() >= this.dfX) {
                GroupMetadata groupMetadata = this.dfV.get(0);
                int indexOf = this.dfV.indexOf(groupMetadata);
                collapseGroup(groupMetadata.dga);
                if (bVar.dgg > indexOf) {
                    bVar.dgg--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.dge.dgh, this.dfU.getGroupId(bVar.dge.dgh));
            this.dfV.add(bVar.dgg, a2);
            y(false, false);
            notifyDataSetChanged();
            this.dfU.onGroupExpanded(a2.dga);
            return true;
        }
        return false;
    }

    ExpandableListAdapter arx() {
        return this.dfU;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter arx = arx();
        if (arx instanceof Filterable) {
            return ((Filterable) arx).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> ary() {
        return this.dfV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.dfU != null) {
            int groupCount = this.dfU.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).dga >= groupCount) {
                    return;
                }
            }
            this.dfV = arrayList;
            y(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter arx = arx();
        if (arx != null) {
            return arx.isEmpty();
        }
        return true;
    }

    int g(long j, int i) {
        int groupCount = this.dfU.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter arx = arx();
        if (arx == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (arx.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.y(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.y(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: n */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: lz */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int dfY;
        int dfZ;
        int dga;
        long dgb;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.dfY = i;
            groupMetadata.dfZ = i2;
            groupMetadata.dga = i3;
            groupMetadata.dgb = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.dga - groupMetadata.dga;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.dfY);
            parcel.writeInt(this.dfZ);
            parcel.writeInt(this.dga);
            parcel.writeLong(this.dgb);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> dgd = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.b dge;
        public GroupMetadata dgf;
        public int dgg;

        private void wN() {
            if (this.dge != null) {
                this.dge.recycle();
                this.dge = null;
            }
            this.dgf = null;
            this.dgg = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b arz = arz();
            arz.dge = com.baidu.tieba.horizonalList.widget.b.m(i2, i3, i4, i);
            arz.dgf = groupMetadata;
            arz.dgg = i5;
            return arz;
        }

        private static b arz() {
            b bVar;
            synchronized (dgd) {
                if (dgd.size() > 0) {
                    bVar = dgd.remove(0);
                    bVar.wN();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            wN();
            synchronized (dgd) {
                if (dgd.size() < 5) {
                    dgd.add(this);
                }
            }
        }

        public boolean arA() {
            return this.dgf != null;
        }
    }
}
