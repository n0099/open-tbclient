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
    private ExpandableListAdapter aTu;
    private int aTw;
    private int aTx = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> aTv = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.aTu != null) {
            this.aTu.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.aTu = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b wd(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.aTv;
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
            if (i > groupMetadata.aTz) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.aTy) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.aTy) {
                return b.a(i, 2, groupMetadata.aTA, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.aTz) {
                    return b.a(i, 1, groupMetadata.aTA, i - (groupMetadata.aTy + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.aTz) + groupMetadata2.aTA;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.aTA - (groupMetadata3.aTy - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.aTv;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.aTH, aVar.type, aVar.aTH, aVar.aTI, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.aTH > groupMetadata.aTA) {
                i4 = i + 1;
            } else if (aVar.aTH < groupMetadata.aTA) {
                i3 = i - 1;
            } else if (aVar.aTH == groupMetadata.aTA) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.aTy, aVar.type, aVar.aTH, aVar.aTI, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.aTy + aVar.aTI + 1, aVar.type, aVar.aTH, aVar.aTI, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.aTH - groupMetadata2.aTA) + groupMetadata2.aTz, aVar.type, aVar.aTH, aVar.aTI, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.aTy - (groupMetadata3.aTA - aVar.aTH), aVar.type, aVar.aTH, aVar.aTI, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.aTu.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b wd = wd(i);
        com.baidu.tieba.horizonalList.widget.a aVar = wd.hVh;
        boolean isChildSelectable = aVar.type == 1 ? this.aTu.isChildSelectable(aVar.aTH, aVar.aTI) : true;
        wd.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.aTu.getGroupCount() + this.aTw;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b wd = wd(i);
        if (wd.hVh.type == 2) {
            child = this.aTu.getGroup(wd.hVh.aTH);
        } else if (wd.hVh.type == 1) {
            child = this.aTu.getChild(wd.hVh.aTH, wd.hVh.aTI);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        wd.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b wd = wd(i);
        long groupId = this.aTu.getGroupId(wd.hVh.aTH);
        if (wd.hVh.type == 2) {
            combinedChildId = this.aTu.getCombinedGroupId(groupId);
        } else if (wd.hVh.type == 1) {
            combinedChildId = this.aTu.getCombinedChildId(groupId, this.aTu.getChildId(wd.hVh.aTH, wd.hVh.aTI));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        wd.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b wd = wd(i);
        if (wd.hVh.type == 2) {
            childView = this.aTu.getGroupView(wd.hVh.aTH, wd.ET(), view, viewGroup);
        } else if (wd.hVh.type == 1) {
            childView = this.aTu.getChildView(wd.hVh.aTH, wd.hVh.aTI, wd.hVi.aTz == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        wd.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b wd = wd(i);
        com.baidu.tieba.horizonalList.widget.a aVar = wd.hVh;
        if (this.aTu instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.aTu;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.aTH);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.aTH, aVar.aTI);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        wd.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.aTu instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.aTu;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.aTu.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.aTv;
        int size = arrayList.size();
        this.aTw = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int b2 = b(groupMetadata.aTB, groupMetadata.aTA);
                if (b2 != groupMetadata.aTA) {
                    if (b2 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.aTA = b2;
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
            if (groupMetadata2.aTz == -1 || z) {
                childrenCount = this.aTu.getChildrenCount(groupMetadata2.aTA);
            } else {
                childrenCount = groupMetadata2.aTz - groupMetadata2.aTy;
            }
            this.aTw += childrenCount;
            int i5 = i4 + (groupMetadata2.aTA - i3);
            i3 = groupMetadata2.aTA;
            groupMetadata2.aTy = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.aTz = i6;
            i++;
            i4 = i6;
        }
    }

    boolean cK(int i) {
        com.baidu.tieba.horizonalList.widget.a A = com.baidu.tieba.horizonalList.widget.a.A(2, i, -1, -1);
        b a2 = a(A);
        A.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.hVi == null) {
            return false;
        }
        this.aTv.remove(bVar.hVi);
        g(false, false);
        notifyDataSetChanged();
        this.aTu.onGroupCollapsed(bVar.hVi.aTA);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.hVh.aTH < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.aTx != 0 && bVar.hVi == null) {
            if (this.aTv.size() >= this.aTx) {
                GroupMetadata groupMetadata = this.aTv.get(0);
                int indexOf = this.aTv.indexOf(groupMetadata);
                cK(groupMetadata.aTA);
                if (bVar.aTG > indexOf) {
                    bVar.aTG--;
                }
            }
            GroupMetadata c = GroupMetadata.c(-1, -1, bVar.hVh.aTH, this.aTu.getGroupId(bVar.hVh.aTH));
            this.aTv.add(bVar.aTG, c);
            g(false, false);
            notifyDataSetChanged();
            this.aTu.onGroupExpanded(c.aTA);
            return true;
        }
        return false;
    }

    ExpandableListAdapter EQ() {
        return this.aTu;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter EQ = EQ();
        if (EQ instanceof Filterable) {
            return ((Filterable) EQ).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> ER() {
        return this.aTv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.aTu != null) {
            int groupCount = this.aTu.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).aTA >= groupCount) {
                    return;
                }
            }
            this.aTv = arrayList;
            g(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter EQ = EQ();
        if (EQ != null) {
            return EQ.isEmpty();
        }
        return true;
    }

    int b(long j, int i) {
        int groupCount = this.aTu.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter EQ = EQ();
        if (EQ == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (EQ.getGroupId(i3) != j) {
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
            /* renamed from: V */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.c(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: we */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int aTA;
        long aTB;
        int aTy;
        int aTz;

        private GroupMetadata() {
        }

        static GroupMetadata c(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.aTy = i;
            groupMetadata.aTz = i2;
            groupMetadata.aTA = i3;
            groupMetadata.aTB = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.aTA - groupMetadata.aTA;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.aTy);
            parcel.writeInt(this.aTz);
            parcel.writeInt(this.aTA);
            parcel.writeLong(this.aTB);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> aTD = new ArrayList<>(5);
        public int aTG;
        public com.baidu.tieba.horizonalList.widget.a hVh;
        public GroupMetadata hVi;

        private void resetState() {
            if (this.hVh != null) {
                this.hVh.recycle();
                this.hVh = null;
            }
            this.hVi = null;
            this.aTG = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b caC = caC();
            caC.hVh = com.baidu.tieba.horizonalList.widget.a.A(i2, i3, i4, i);
            caC.hVi = groupMetadata;
            caC.aTG = i5;
            return caC;
        }

        private static b caC() {
            b bVar;
            synchronized (aTD) {
                if (aTD.size() > 0) {
                    bVar = aTD.remove(0);
                    bVar.resetState();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            resetState();
            synchronized (aTD) {
                if (aTD.size() < 5) {
                    aTD.add(this);
                }
            }
        }

        public boolean ET() {
            return this.hVi != null;
        }
    }
}
