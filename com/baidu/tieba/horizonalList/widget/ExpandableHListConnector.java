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
    private ExpandableListAdapter bfR;
    private int bfT;
    private int bfU = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> bfS = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.bfR != null) {
            this.bfR.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.bfR = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b xv(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.bfS;
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
            if (i > groupMetadata.bfW) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.bfV) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.bfV) {
                return b.a(i, 2, groupMetadata.bfX, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.bfW) {
                    return b.a(i, 1, groupMetadata.bfX, i - (groupMetadata.bfV + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.bfW) + groupMetadata2.bfX;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.bfX - (groupMetadata3.bfV - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.bfS;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.bge, aVar.type, aVar.bge, aVar.bgf, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.bge > groupMetadata.bfX) {
                i4 = i + 1;
            } else if (aVar.bge < groupMetadata.bfX) {
                i3 = i - 1;
            } else if (aVar.bge == groupMetadata.bfX) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.bfV, aVar.type, aVar.bge, aVar.bgf, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.bfV + aVar.bgf + 1, aVar.type, aVar.bge, aVar.bgf, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.bge - groupMetadata2.bfX) + groupMetadata2.bfW, aVar.type, aVar.bge, aVar.bgf, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.bfV - (groupMetadata3.bfX - aVar.bge), aVar.type, aVar.bge, aVar.bgf, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.bfR.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b xv = xv(i);
        com.baidu.tieba.horizonalList.widget.a aVar = xv.iBH;
        boolean isChildSelectable = aVar.type == 1 ? this.bfR.isChildSelectable(aVar.bge, aVar.bgf) : true;
        xv.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bfR.getGroupCount() + this.bfT;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b xv = xv(i);
        if (xv.iBH.type == 2) {
            child = this.bfR.getGroup(xv.iBH.bge);
        } else if (xv.iBH.type == 1) {
            child = this.bfR.getChild(xv.iBH.bge, xv.iBH.bgf);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        xv.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b xv = xv(i);
        long groupId = this.bfR.getGroupId(xv.iBH.bge);
        if (xv.iBH.type == 2) {
            combinedChildId = this.bfR.getCombinedGroupId(groupId);
        } else if (xv.iBH.type == 1) {
            combinedChildId = this.bfR.getCombinedChildId(groupId, this.bfR.getChildId(xv.iBH.bge, xv.iBH.bgf));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        xv.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b xv = xv(i);
        if (xv.iBH.type == 2) {
            childView = this.bfR.getGroupView(xv.iBH.bge, xv.HX(), view, viewGroup);
        } else if (xv.iBH.type == 1) {
            childView = this.bfR.getChildView(xv.iBH.bge, xv.iBH.bgf, xv.iBI.bfW == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        xv.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b xv = xv(i);
        com.baidu.tieba.horizonalList.widget.a aVar = xv.iBH;
        if (this.bfR instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bfR;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.bge);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.bge, aVar.bgf);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        xv.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.bfR instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bfR;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.bfR.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.bfS;
        int size = arrayList.size();
        this.bfT = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int b2 = b(groupMetadata.bfY, groupMetadata.bfX);
                if (b2 != groupMetadata.bfX) {
                    if (b2 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.bfX = b2;
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
            if (groupMetadata2.bfW == -1 || z) {
                childrenCount = this.bfR.getChildrenCount(groupMetadata2.bfX);
            } else {
                childrenCount = groupMetadata2.bfW - groupMetadata2.bfV;
            }
            this.bfT += childrenCount;
            int i5 = i4 + (groupMetadata2.bfX - i3);
            i3 = groupMetadata2.bfX;
            groupMetadata2.bfV = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.bfW = i6;
            i++;
            i4 = i6;
        }
    }

    boolean dd(int i) {
        com.baidu.tieba.horizonalList.widget.a B = com.baidu.tieba.horizonalList.widget.a.B(2, i, -1, -1);
        b a2 = a(B);
        B.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.iBI == null) {
            return false;
        }
        this.bfS.remove(bVar.iBI);
        g(false, false);
        notifyDataSetChanged();
        this.bfR.onGroupCollapsed(bVar.iBI.bfX);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.iBH.bge < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.bfU != 0 && bVar.iBI == null) {
            if (this.bfS.size() >= this.bfU) {
                GroupMetadata groupMetadata = this.bfS.get(0);
                int indexOf = this.bfS.indexOf(groupMetadata);
                dd(groupMetadata.bfX);
                if (bVar.bgd > indexOf) {
                    bVar.bgd--;
                }
            }
            GroupMetadata c = GroupMetadata.c(-1, -1, bVar.iBH.bge, this.bfR.getGroupId(bVar.iBH.bge));
            this.bfS.add(bVar.bgd, c);
            g(false, false);
            notifyDataSetChanged();
            this.bfR.onGroupExpanded(c.bfX);
            return true;
        }
        return false;
    }

    ExpandableListAdapter HU() {
        return this.bfR;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter HU = HU();
        if (HU instanceof Filterable) {
            return ((Filterable) HU).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> HV() {
        return this.bfS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.bfR != null) {
            int groupCount = this.bfR.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).bfX >= groupCount) {
                    return;
                }
            }
            this.bfS = arrayList;
            g(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter HU = HU();
        if (HU != null) {
            return HU.isEmpty();
        }
        return true;
    }

    int b(long j, int i) {
        int groupCount = this.bfR.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter HU = HU();
        if (HU == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (HU.getGroupId(i3) != j) {
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
            /* renamed from: Y */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.c(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: xw */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int bfV;
        int bfW;
        int bfX;
        long bfY;

        private GroupMetadata() {
        }

        static GroupMetadata c(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.bfV = i;
            groupMetadata.bfW = i2;
            groupMetadata.bfX = i3;
            groupMetadata.bfY = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.bfX - groupMetadata.bfX;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.bfV);
            parcel.writeInt(this.bfW);
            parcel.writeInt(this.bfX);
            parcel.writeLong(this.bfY);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> bga = new ArrayList<>(5);
        public int bgd;
        public com.baidu.tieba.horizonalList.widget.a iBH;
        public GroupMetadata iBI;

        private void resetState() {
            if (this.iBH != null) {
                this.iBH.recycle();
                this.iBH = null;
            }
            this.iBI = null;
            this.bgd = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b ckX = ckX();
            ckX.iBH = com.baidu.tieba.horizonalList.widget.a.B(i2, i3, i4, i);
            ckX.iBI = groupMetadata;
            ckX.bgd = i5;
            return ckX;
        }

        private static b ckX() {
            b bVar;
            synchronized (bga) {
                if (bga.size() > 0) {
                    bVar = bga.remove(0);
                    bVar.resetState();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            resetState();
            synchronized (bga) {
                if (bga.size() < 5) {
                    bga.add(this);
                }
            }
        }

        public boolean HX() {
            return this.iBI != null;
        }
    }
}
