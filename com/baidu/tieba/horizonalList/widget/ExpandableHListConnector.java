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
    private ExpandableListAdapter dtS;
    private int dtU;
    private int dtV = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> dtT = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.dtS != null) {
            this.dtS.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.dtS = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b mn(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.dtT;
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
            if (i > groupMetadata.dtX) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.dtW) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.dtW) {
                return b.a(i, 2, groupMetadata.dtY, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.dtX) {
                    return b.a(i, 1, groupMetadata.dtY, i - (groupMetadata.dtW + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.dtX) + groupMetadata2.dtY;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.dtY - (groupMetadata3.dtW - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.b bVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dtT;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(bVar.duf, bVar.type, bVar.duf, bVar.dug, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (bVar.duf > groupMetadata.dtY) {
                i4 = i + 1;
            } else if (bVar.duf < groupMetadata.dtY) {
                i3 = i - 1;
            } else if (bVar.duf == groupMetadata.dtY) {
                if (bVar.type == 2) {
                    return b.a(groupMetadata.dtW, bVar.type, bVar.duf, bVar.dug, groupMetadata, i);
                }
                if (bVar.type == 1) {
                    return b.a(groupMetadata.dtW + bVar.dug + 1, bVar.type, bVar.duf, bVar.dug, groupMetadata, i);
                }
                return null;
            }
        }
        if (bVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((bVar.duf - groupMetadata2.dtY) + groupMetadata2.dtX, bVar.type, bVar.duf, bVar.dug, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.dtW - (groupMetadata3.dtY - bVar.duf), bVar.type, bVar.duf, bVar.dug, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.dtS.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b mn = mn(i);
        com.baidu.tieba.horizonalList.widget.b bVar = mn.duc;
        boolean isChildSelectable = bVar.type == 1 ? this.dtS.isChildSelectable(bVar.duf, bVar.dug) : true;
        mn.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dtS.getGroupCount() + this.dtU;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b mn = mn(i);
        if (mn.duc.type == 2) {
            child = this.dtS.getGroup(mn.duc.duf);
        } else if (mn.duc.type == 1) {
            child = this.dtS.getChild(mn.duc.duf, mn.duc.dug);
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
        long groupId = this.dtS.getGroupId(mn.duc.duf);
        if (mn.duc.type == 2) {
            combinedChildId = this.dtS.getCombinedGroupId(groupId);
        } else if (mn.duc.type == 1) {
            combinedChildId = this.dtS.getCombinedChildId(groupId, this.dtS.getChildId(mn.duc.duf, mn.duc.dug));
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
        if (mn.duc.type == 2) {
            childView = this.dtS.getGroupView(mn.duc.duf, mn.auK(), view, viewGroup);
        } else if (mn.duc.type == 1) {
            childView = this.dtS.getChildView(mn.duc.duf, mn.duc.dug, mn.dud.dtX == i, view, viewGroup);
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
        com.baidu.tieba.horizonalList.widget.b bVar = mn.duc;
        if (this.dtS instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dtS;
            if (bVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(bVar.duf);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(bVar.duf, bVar.dug);
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
        if (this.dtS instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dtS;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.dtS.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dtT;
        int size = arrayList.size();
        this.dtU = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int i3 = i(groupMetadata.dtZ, groupMetadata.dtY);
                if (i3 != groupMetadata.dtY) {
                    if (i3 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.dtY = i3;
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
            if (groupMetadata2.dtX == -1 || z) {
                childrenCount = this.dtS.getChildrenCount(groupMetadata2.dtY);
            } else {
                childrenCount = groupMetadata2.dtX - groupMetadata2.dtW;
            }
            this.dtU += childrenCount;
            int i6 = i5 + (groupMetadata2.dtY - i4);
            i4 = groupMetadata2.dtY;
            groupMetadata2.dtW = i6;
            int i7 = childrenCount + i6;
            groupMetadata2.dtX = i7;
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
        if (bVar.dud == null) {
            return false;
        }
        this.dtT.remove(bVar.dud);
        A(false, false);
        notifyDataSetChanged();
        this.dtS.onGroupCollapsed(bVar.dud.dtY);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.duc.duf < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.dtV != 0 && bVar.dud == null) {
            if (this.dtT.size() >= this.dtV) {
                GroupMetadata groupMetadata = this.dtT.get(0);
                int indexOf = this.dtT.indexOf(groupMetadata);
                collapseGroup(groupMetadata.dtY);
                if (bVar.due > indexOf) {
                    bVar.due--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.duc.duf, this.dtS.getGroupId(bVar.duc.duf));
            this.dtT.add(bVar.due, a2);
            A(false, false);
            notifyDataSetChanged();
            this.dtS.onGroupExpanded(a2.dtY);
            return true;
        }
        return false;
    }

    ExpandableListAdapter auH() {
        return this.dtS;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter auH = auH();
        if (auH instanceof Filterable) {
            return ((Filterable) auH).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> auI() {
        return this.dtT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.dtS != null) {
            int groupCount = this.dtS.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).dtY >= groupCount) {
                    return;
                }
            }
            this.dtT = arrayList;
            A(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter auH = auH();
        if (auH != null) {
            return auH.isEmpty();
        }
        return true;
    }

    int i(long j, int i) {
        int groupCount = this.dtS.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter auH = auH();
        if (auH == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (auH.getGroupId(i3) != j) {
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
        int dtW;
        int dtX;
        int dtY;
        long dtZ;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.dtW = i;
            groupMetadata.dtX = i2;
            groupMetadata.dtY = i3;
            groupMetadata.dtZ = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.dtY - groupMetadata.dtY;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.dtW);
            parcel.writeInt(this.dtX);
            parcel.writeInt(this.dtY);
            parcel.writeLong(this.dtZ);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> dub = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.b duc;
        public GroupMetadata dud;
        public int due;

        private void Lg() {
            if (this.duc != null) {
                this.duc.recycle();
                this.duc = null;
            }
            this.dud = null;
            this.due = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b auJ = auJ();
            auJ.duc = com.baidu.tieba.horizonalList.widget.b.r(i2, i3, i4, i);
            auJ.dud = groupMetadata;
            auJ.due = i5;
            return auJ;
        }

        private static b auJ() {
            b bVar;
            synchronized (dub) {
                if (dub.size() > 0) {
                    bVar = dub.remove(0);
                    bVar.Lg();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            Lg();
            synchronized (dub) {
                if (dub.size() < 5) {
                    dub.add(this);
                }
            }
        }

        public boolean auK() {
            return this.dud != null;
        }
    }
}
