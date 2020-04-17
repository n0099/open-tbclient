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
    private ExpandableListAdapter aTp;
    private int aTr;
    private int aTs = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> aTq = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.aTp != null) {
            this.aTp.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.aTp = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b wd(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.aTq;
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
            if (i > groupMetadata.aTu) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.aTt) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.aTt) {
                return b.a(i, 2, groupMetadata.aTv, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.aTu) {
                    return b.a(i, 1, groupMetadata.aTv, i - (groupMetadata.aTt + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.aTu) + groupMetadata2.aTv;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.aTv - (groupMetadata3.aTt - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.aTq;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.aTC, aVar.type, aVar.aTC, aVar.aTD, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.aTC > groupMetadata.aTv) {
                i4 = i + 1;
            } else if (aVar.aTC < groupMetadata.aTv) {
                i3 = i - 1;
            } else if (aVar.aTC == groupMetadata.aTv) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.aTt, aVar.type, aVar.aTC, aVar.aTD, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.aTt + aVar.aTD + 1, aVar.type, aVar.aTC, aVar.aTD, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.aTC - groupMetadata2.aTv) + groupMetadata2.aTu, aVar.type, aVar.aTC, aVar.aTD, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.aTt - (groupMetadata3.aTv - aVar.aTC), aVar.type, aVar.aTC, aVar.aTD, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.aTp.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b wd = wd(i);
        com.baidu.tieba.horizonalList.widget.a aVar = wd.hVb;
        boolean isChildSelectable = aVar.type == 1 ? this.aTp.isChildSelectable(aVar.aTC, aVar.aTD) : true;
        wd.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.aTp.getGroupCount() + this.aTr;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b wd = wd(i);
        if (wd.hVb.type == 2) {
            child = this.aTp.getGroup(wd.hVb.aTC);
        } else if (wd.hVb.type == 1) {
            child = this.aTp.getChild(wd.hVb.aTC, wd.hVb.aTD);
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
        long groupId = this.aTp.getGroupId(wd.hVb.aTC);
        if (wd.hVb.type == 2) {
            combinedChildId = this.aTp.getCombinedGroupId(groupId);
        } else if (wd.hVb.type == 1) {
            combinedChildId = this.aTp.getCombinedChildId(groupId, this.aTp.getChildId(wd.hVb.aTC, wd.hVb.aTD));
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
        if (wd.hVb.type == 2) {
            childView = this.aTp.getGroupView(wd.hVb.aTC, wd.EU(), view, viewGroup);
        } else if (wd.hVb.type == 1) {
            childView = this.aTp.getChildView(wd.hVb.aTC, wd.hVb.aTD, wd.hVc.aTu == i, view, viewGroup);
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
        com.baidu.tieba.horizonalList.widget.a aVar = wd.hVb;
        if (this.aTp instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.aTp;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.aTC);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.aTC, aVar.aTD);
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
        if (this.aTp instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.aTp;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.aTp.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.aTq;
        int size = arrayList.size();
        this.aTr = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int b2 = b(groupMetadata.aTw, groupMetadata.aTv);
                if (b2 != groupMetadata.aTv) {
                    if (b2 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.aTv = b2;
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
            if (groupMetadata2.aTu == -1 || z) {
                childrenCount = this.aTp.getChildrenCount(groupMetadata2.aTv);
            } else {
                childrenCount = groupMetadata2.aTu - groupMetadata2.aTt;
            }
            this.aTr += childrenCount;
            int i5 = i4 + (groupMetadata2.aTv - i3);
            i3 = groupMetadata2.aTv;
            groupMetadata2.aTt = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.aTu = i6;
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
        if (bVar.hVc == null) {
            return false;
        }
        this.aTq.remove(bVar.hVc);
        g(false, false);
        notifyDataSetChanged();
        this.aTp.onGroupCollapsed(bVar.hVc.aTv);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.hVb.aTC < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.aTs != 0 && bVar.hVc == null) {
            if (this.aTq.size() >= this.aTs) {
                GroupMetadata groupMetadata = this.aTq.get(0);
                int indexOf = this.aTq.indexOf(groupMetadata);
                cK(groupMetadata.aTv);
                if (bVar.aTB > indexOf) {
                    bVar.aTB--;
                }
            }
            GroupMetadata c = GroupMetadata.c(-1, -1, bVar.hVb.aTC, this.aTp.getGroupId(bVar.hVb.aTC));
            this.aTq.add(bVar.aTB, c);
            g(false, false);
            notifyDataSetChanged();
            this.aTp.onGroupExpanded(c.aTv);
            return true;
        }
        return false;
    }

    ExpandableListAdapter ER() {
        return this.aTp;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter ER = ER();
        if (ER instanceof Filterable) {
            return ((Filterable) ER).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> ES() {
        return this.aTq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.aTp != null) {
            int groupCount = this.aTp.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).aTv >= groupCount) {
                    return;
                }
            }
            this.aTq = arrayList;
            g(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter ER = ER();
        if (ER != null) {
            return ER.isEmpty();
        }
        return true;
    }

    int b(long j, int i) {
        int groupCount = this.aTp.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter ER = ER();
        if (ER == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (ER.getGroupId(i3) != j) {
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
        int aTt;
        int aTu;
        int aTv;
        long aTw;

        private GroupMetadata() {
        }

        static GroupMetadata c(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.aTt = i;
            groupMetadata.aTu = i2;
            groupMetadata.aTv = i3;
            groupMetadata.aTw = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.aTv - groupMetadata.aTv;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.aTt);
            parcel.writeInt(this.aTu);
            parcel.writeInt(this.aTv);
            parcel.writeLong(this.aTw);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> aTy = new ArrayList<>(5);
        public int aTB;
        public com.baidu.tieba.horizonalList.widget.a hVb;
        public GroupMetadata hVc;

        private void resetState() {
            if (this.hVb != null) {
                this.hVb.recycle();
                this.hVb = null;
            }
            this.hVc = null;
            this.aTB = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b caD = caD();
            caD.hVb = com.baidu.tieba.horizonalList.widget.a.A(i2, i3, i4, i);
            caD.hVc = groupMetadata;
            caD.aTB = i5;
            return caD;
        }

        private static b caD() {
            b bVar;
            synchronized (aTy) {
                if (aTy.size() > 0) {
                    bVar = aTy.remove(0);
                    bVar.resetState();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            resetState();
            synchronized (aTy) {
                if (aTy.size() < 5) {
                    aTy.add(this);
                }
            }
        }

        public boolean EU() {
            return this.hVc != null;
        }
    }
}
