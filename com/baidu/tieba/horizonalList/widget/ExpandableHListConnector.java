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
    private ExpandableListAdapter dkW;
    private int dkY;
    private int dkZ = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> dkX = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.dkW != null) {
            this.dkW.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.dkW = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b lL(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.dkX;
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
            if (i > groupMetadata.dlb) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.dla) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.dla) {
                return b.a(i, 2, groupMetadata.dlc, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.dlb) {
                    return b.a(i, 1, groupMetadata.dlc, i - (groupMetadata.dla + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.dlb) + groupMetadata2.dlc;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.dlc - (groupMetadata3.dla - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.b bVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dkX;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(bVar.dlj, bVar.type, bVar.dlj, bVar.dlk, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (bVar.dlj > groupMetadata.dlc) {
                i4 = i + 1;
            } else if (bVar.dlj < groupMetadata.dlc) {
                i3 = i - 1;
            } else if (bVar.dlj == groupMetadata.dlc) {
                if (bVar.type == 2) {
                    return b.a(groupMetadata.dla, bVar.type, bVar.dlj, bVar.dlk, groupMetadata, i);
                }
                if (bVar.type == 1) {
                    return b.a(groupMetadata.dla + bVar.dlk + 1, bVar.type, bVar.dlj, bVar.dlk, groupMetadata, i);
                }
                return null;
            }
        }
        if (bVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((bVar.dlj - groupMetadata2.dlc) + groupMetadata2.dlb, bVar.type, bVar.dlj, bVar.dlk, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.dla - (groupMetadata3.dlc - bVar.dlj), bVar.type, bVar.dlj, bVar.dlk, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.dkW.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b lL = lL(i);
        com.baidu.tieba.horizonalList.widget.b bVar = lL.dlg;
        boolean isChildSelectable = bVar.type == 1 ? this.dkW.isChildSelectable(bVar.dlj, bVar.dlk) : true;
        lL.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.dkW.getGroupCount() + this.dkY;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b lL = lL(i);
        if (lL.dlg.type == 2) {
            child = this.dkW.getGroup(lL.dlg.dlj);
        } else if (lL.dlg.type == 1) {
            child = this.dkW.getChild(lL.dlg.dlj, lL.dlg.dlk);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        lL.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b lL = lL(i);
        long groupId = this.dkW.getGroupId(lL.dlg.dlj);
        if (lL.dlg.type == 2) {
            combinedChildId = this.dkW.getCombinedGroupId(groupId);
        } else if (lL.dlg.type == 1) {
            combinedChildId = this.dkW.getCombinedChildId(groupId, this.dkW.getChildId(lL.dlg.dlj, lL.dlg.dlk));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        lL.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b lL = lL(i);
        if (lL.dlg.type == 2) {
            childView = this.dkW.getGroupView(lL.dlg.dlj, lL.asZ(), view, viewGroup);
        } else if (lL.dlg.type == 1) {
            childView = this.dkW.getChildView(lL.dlg.dlj, lL.dlg.dlk, lL.dlh.dlb == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        lL.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b lL = lL(i);
        com.baidu.tieba.horizonalList.widget.b bVar = lL.dlg;
        if (this.dkW instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dkW;
            if (bVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(bVar.dlj);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(bVar.dlj, bVar.dlk);
            }
        } else if (bVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        lL.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.dkW instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.dkW;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.dkW.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.dkX;
        int size = arrayList.size();
        this.dkY = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int i3 = i(groupMetadata.dld, groupMetadata.dlc);
                if (i3 != groupMetadata.dlc) {
                    if (i3 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.dlc = i3;
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
            if (groupMetadata2.dlb == -1 || z) {
                childrenCount = this.dkW.getChildrenCount(groupMetadata2.dlc);
            } else {
                childrenCount = groupMetadata2.dlb - groupMetadata2.dla;
            }
            this.dkY += childrenCount;
            int i6 = i5 + (groupMetadata2.dlc - i4);
            i4 = groupMetadata2.dlc;
            groupMetadata2.dla = i6;
            int i7 = childrenCount + i6;
            groupMetadata2.dlb = i7;
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
        if (bVar.dlh == null) {
            return false;
        }
        this.dkX.remove(bVar.dlh);
        A(false, false);
        notifyDataSetChanged();
        this.dkW.onGroupCollapsed(bVar.dlh.dlc);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.dlg.dlj < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.dkZ != 0 && bVar.dlh == null) {
            if (this.dkX.size() >= this.dkZ) {
                GroupMetadata groupMetadata = this.dkX.get(0);
                int indexOf = this.dkX.indexOf(groupMetadata);
                collapseGroup(groupMetadata.dlc);
                if (bVar.dli > indexOf) {
                    bVar.dli--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.dlg.dlj, this.dkW.getGroupId(bVar.dlg.dlj));
            this.dkX.add(bVar.dli, a2);
            A(false, false);
            notifyDataSetChanged();
            this.dkW.onGroupExpanded(a2.dlc);
            return true;
        }
        return false;
    }

    ExpandableListAdapter asW() {
        return this.dkW;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter asW = asW();
        if (asW instanceof Filterable) {
            return ((Filterable) asW).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> asX() {
        return this.dkX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.dkW != null) {
            int groupCount = this.dkW.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).dlc >= groupCount) {
                    return;
                }
            }
            this.dkX = arrayList;
            A(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter asW = asW();
        if (asW != null) {
            return asW.isEmpty();
        }
        return true;
    }

    int i(long j, int i) {
        int groupCount = this.dkW.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter asW = asW();
        if (asW == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (asW.getGroupId(i3) != j) {
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
            /* renamed from: lM */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int dla;
        int dlb;
        int dlc;
        long dld;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.dla = i;
            groupMetadata.dlb = i2;
            groupMetadata.dlc = i3;
            groupMetadata.dld = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.dlc - groupMetadata.dlc;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.dla);
            parcel.writeInt(this.dlb);
            parcel.writeInt(this.dlc);
            parcel.writeLong(this.dld);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> dlf = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.b dlg;
        public GroupMetadata dlh;
        public int dli;

        private void KK() {
            if (this.dlg != null) {
                this.dlg.recycle();
                this.dlg = null;
            }
            this.dlh = null;
            this.dli = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b asY = asY();
            asY.dlg = com.baidu.tieba.horizonalList.widget.b.r(i2, i3, i4, i);
            asY.dlh = groupMetadata;
            asY.dli = i5;
            return asY;
        }

        private static b asY() {
            b bVar;
            synchronized (dlf) {
                if (dlf.size() > 0) {
                    bVar = dlf.remove(0);
                    bVar.KK();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            KK();
            synchronized (dlf) {
                if (dlf.size() < 5) {
                    dlf.add(this);
                }
            }
        }

        public boolean asZ() {
            return this.dlh != null;
        }
    }
}
