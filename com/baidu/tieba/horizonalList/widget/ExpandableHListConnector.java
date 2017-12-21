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
    private ExpandableListAdapter dtW;
    private int dtY;
    private int dtZ = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> dtX = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.dtW != null) {
            this.dtW.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.dtW = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b mn(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.dtX;
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
            if (i > groupMetadata.dub) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.dua) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.dua) {
                return b.a(i, 2, groupMetadata.duc, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.dub) {
                    return b.a(i, 1, groupMetadata.duc, i - (groupMetadata.dua + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.dub) + groupMetadata2.duc;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.duc - (groupMetadata3.dua - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.b bVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dtX;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(bVar.duj, bVar.type, bVar.duj, bVar.duk, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (bVar.duj > groupMetadata.duc) {
                i4 = i + 1;
            } else if (bVar.duj < groupMetadata.duc) {
                i3 = i - 1;
            } else if (bVar.duj == groupMetadata.duc) {
                if (bVar.type == 2) {
                    return b.a(groupMetadata.dua, bVar.type, bVar.duj, bVar.duk, groupMetadata, i);
                }
                if (bVar.type == 1) {
                    return b.a(groupMetadata.dua + bVar.duk + 1, bVar.type, bVar.duj, bVar.duk, groupMetadata, i);
                }
                return null;
            }
        }
        if (bVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((bVar.duj - groupMetadata2.duc) + groupMetadata2.dub, bVar.type, bVar.duj, bVar.duk, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.dua - (groupMetadata3.duc - bVar.duj), bVar.type, bVar.duj, bVar.duk, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.dtW.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b mn = mn(i);
        com.baidu.tieba.horizonalList.widget.b bVar = mn.dug;
        boolean isChildSelectable = bVar.type == 1 ? this.dtW.isChildSelectable(bVar.duj, bVar.duk) : true;
        mn.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dtW.getGroupCount() + this.dtY;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b mn = mn(i);
        if (mn.dug.type == 2) {
            child = this.dtW.getGroup(mn.dug.duj);
        } else if (mn.dug.type == 1) {
            child = this.dtW.getChild(mn.dug.duj, mn.dug.duk);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        mn.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b mn = mn(i);
        long groupId = this.dtW.getGroupId(mn.dug.duj);
        if (mn.dug.type == 2) {
            combinedChildId = this.dtW.getCombinedGroupId(groupId);
        } else if (mn.dug.type == 1) {
            combinedChildId = this.dtW.getCombinedChildId(groupId, this.dtW.getChildId(mn.dug.duj, mn.dug.duk));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        mn.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b mn = mn(i);
        if (mn.dug.type == 2) {
            childView = this.dtW.getGroupView(mn.dug.duj, mn.auL(), view, viewGroup);
        } else if (mn.dug.type == 1) {
            childView = this.dtW.getChildView(mn.dug.duj, mn.dug.duk, mn.duh.dub == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        mn.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b mn = mn(i);
        com.baidu.tieba.horizonalList.widget.b bVar = mn.dug;
        if (this.dtW instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dtW;
            if (bVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(bVar.duj);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(bVar.duj, bVar.duk);
            }
        } else if (bVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        mn.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.dtW instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dtW;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.dtW.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dtX;
        int size = arrayList.size();
        this.dtY = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int i3 = i(groupMetadata.dud, groupMetadata.duc);
                if (i3 != groupMetadata.duc) {
                    if (i3 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.duc = i3;
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
            if (groupMetadata2.dub == -1 || z) {
                childrenCount = this.dtW.getChildrenCount(groupMetadata2.duc);
            } else {
                childrenCount = groupMetadata2.dub - groupMetadata2.dua;
            }
            this.dtY += childrenCount;
            int i6 = i5 + (groupMetadata2.duc - i4);
            i4 = groupMetadata2.duc;
            groupMetadata2.dua = i6;
            int i7 = childrenCount + i6;
            groupMetadata2.dub = i7;
            i++;
            i5 = i7;
        }
    }

    boolean collapseGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b r = com.baidu.tieba.horizonalList.widget.b.r(2, i, -1, -1);
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
        if (bVar.duh == null) {
            return false;
        }
        this.dtX.remove(bVar.duh);
        A(false, false);
        notifyDataSetChanged();
        this.dtW.onGroupCollapsed(bVar.duh.duc);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.dug.duj < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.dtZ != 0 && bVar.duh == null) {
            if (this.dtX.size() >= this.dtZ) {
                GroupMetadata groupMetadata = this.dtX.get(0);
                int indexOf = this.dtX.indexOf(groupMetadata);
                collapseGroup(groupMetadata.duc);
                if (bVar.dui > indexOf) {
                    bVar.dui--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.dug.duj, this.dtW.getGroupId(bVar.dug.duj));
            this.dtX.add(bVar.dui, a2);
            A(false, false);
            notifyDataSetChanged();
            this.dtW.onGroupExpanded(a2.duc);
            return true;
        }
        return false;
    }

    ExpandableListAdapter auI() {
        return this.dtW;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter auI = auI();
        if (auI instanceof Filterable) {
            return ((Filterable) auI).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> auJ() {
        return this.dtX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.dtW != null) {
            int groupCount = this.dtW.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).duc >= groupCount) {
                    return;
                }
            }
            this.dtX = arrayList;
            A(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter auI = auI();
        if (auI != null) {
            return auI.isEmpty();
        }
        return true;
    }

    int i(long j, int i) {
        int groupCount = this.dtW.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter auI = auI();
        if (auI == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (auI.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.A(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.A(true, true);
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
            /* renamed from: mo */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int dua;
        int dub;
        int duc;
        long dud;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.dua = i;
            groupMetadata.dub = i2;
            groupMetadata.duc = i3;
            groupMetadata.dud = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.duc - groupMetadata.duc;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.dua);
            parcel.writeInt(this.dub);
            parcel.writeInt(this.duc);
            parcel.writeLong(this.dud);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> duf = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.b dug;
        public GroupMetadata duh;
        public int dui;

        private void Lg() {
            if (this.dug != null) {
                this.dug.recycle();
                this.dug = null;
            }
            this.duh = null;
            this.dui = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b auK = auK();
            auK.dug = com.baidu.tieba.horizonalList.widget.b.r(i2, i3, i4, i);
            auK.duh = groupMetadata;
            auK.dui = i5;
            return auK;
        }

        private static b auK() {
            b bVar;
            synchronized (duf) {
                if (duf.size() > 0) {
                    bVar = duf.remove(0);
                    bVar.Lg();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            Lg();
            synchronized (duf) {
                if (duf.size() < 5) {
                    duf.add(this);
                }
            }
        }

        public boolean auL() {
            return this.duh != null;
        }
    }
}
