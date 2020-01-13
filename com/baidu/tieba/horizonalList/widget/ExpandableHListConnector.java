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
    private ExpandableListAdapter avc;
    private int ave;
    private int avf = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> avd = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.avc != null) {
            this.avc.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.avc = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b vr(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.avd;
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
            if (i > groupMetadata.avh) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.avg) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.avg) {
                return b.a(i, 2, groupMetadata.avi, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.avh) {
                    return b.a(i, 1, groupMetadata.avi, i - (groupMetadata.avg + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.avh) + groupMetadata2.avi;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.avi - (groupMetadata3.avg - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.avd;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.avp, aVar.type, aVar.avp, aVar.avq, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.avp > groupMetadata.avi) {
                i4 = i + 1;
            } else if (aVar.avp < groupMetadata.avi) {
                i3 = i - 1;
            } else if (aVar.avp == groupMetadata.avi) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.avg, aVar.type, aVar.avp, aVar.avq, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.avg + aVar.avq + 1, aVar.type, aVar.avp, aVar.avq, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.avp - groupMetadata2.avi) + groupMetadata2.avh, aVar.type, aVar.avp, aVar.avq, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.avg - (groupMetadata3.avi - aVar.avp), aVar.type, aVar.avp, aVar.avq, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.avc.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b vr = vr(i);
        com.baidu.tieba.horizonalList.widget.a aVar = vr.hhD;
        boolean isChildSelectable = aVar.type == 1 ? this.avc.isChildSelectable(aVar.avp, aVar.avq) : true;
        vr.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.avc.getGroupCount() + this.ave;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b vr = vr(i);
        if (vr.hhD.type == 2) {
            child = this.avc.getGroup(vr.hhD.avp);
        } else if (vr.hhD.type == 1) {
            child = this.avc.getChild(vr.hhD.avp, vr.hhD.avq);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        vr.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b vr = vr(i);
        long groupId = this.avc.getGroupId(vr.hhD.avp);
        if (vr.hhD.type == 2) {
            combinedChildId = this.avc.getCombinedGroupId(groupId);
        } else if (vr.hhD.type == 1) {
            combinedChildId = this.avc.getCombinedChildId(groupId, this.avc.getChildId(vr.hhD.avp, vr.hhD.avq));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        vr.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b vr = vr(i);
        if (vr.hhD.type == 2) {
            childView = this.avc.getGroupView(vr.hhD.avp, vr.xw(), view, viewGroup);
        } else if (vr.hhD.type == 1) {
            childView = this.avc.getChildView(vr.hhD.avp, vr.hhD.avq, vr.hhE.avh == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        vr.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b vr = vr(i);
        com.baidu.tieba.horizonalList.widget.a aVar = vr.hhD;
        if (this.avc instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.avc;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.avp);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.avp, aVar.avq);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        vr.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.avc instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.avc;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.avc.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.avd;
        int size = arrayList.size();
        this.ave = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int b2 = b(groupMetadata.avj, groupMetadata.avi);
                if (b2 != groupMetadata.avi) {
                    if (b2 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.avi = b2;
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
            if (groupMetadata2.avh == -1 || z) {
                childrenCount = this.avc.getChildrenCount(groupMetadata2.avi);
            } else {
                childrenCount = groupMetadata2.avh - groupMetadata2.avg;
            }
            this.ave += childrenCount;
            int i5 = i4 + (groupMetadata2.avi - i3);
            i3 = groupMetadata2.avi;
            groupMetadata2.avg = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.avh = i6;
            i++;
            i4 = i6;
        }
    }

    boolean cf(int i) {
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
        if (bVar.hhE == null) {
            return false;
        }
        this.avd.remove(bVar.hhE);
        e(false, false);
        notifyDataSetChanged();
        this.avc.onGroupCollapsed(bVar.hhE.avi);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.hhD.avp < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.avf != 0 && bVar.hhE == null) {
            if (this.avd.size() >= this.avf) {
                GroupMetadata groupMetadata = this.avd.get(0);
                int indexOf = this.avd.indexOf(groupMetadata);
                cf(groupMetadata.avi);
                if (bVar.avo > indexOf) {
                    bVar.avo--;
                }
            }
            GroupMetadata c = GroupMetadata.c(-1, -1, bVar.hhD.avp, this.avc.getGroupId(bVar.hhD.avp));
            this.avd.add(bVar.avo, c);
            e(false, false);
            notifyDataSetChanged();
            this.avc.onGroupExpanded(c.avi);
            return true;
        }
        return false;
    }

    ExpandableListAdapter xt() {
        return this.avc;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter xt = xt();
        if (xt instanceof Filterable) {
            return ((Filterable) xt).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> xu() {
        return this.avd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.avc != null) {
            int groupCount = this.avc.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).avi >= groupCount) {
                    return;
                }
            }
            this.avd = arrayList;
            e(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter xt = xt();
        if (xt != null) {
            return xt.isEmpty();
        }
        return true;
    }

    int b(long j, int i) {
        int groupCount = this.avc.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter xt = xt();
        if (xt == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (xt.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.e(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.e(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ac */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.c(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: vs */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int avg;
        int avh;
        int avi;
        long avj;

        private GroupMetadata() {
        }

        static GroupMetadata c(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.avg = i;
            groupMetadata.avh = i2;
            groupMetadata.avi = i3;
            groupMetadata.avj = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.avi - groupMetadata.avi;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.avg);
            parcel.writeInt(this.avh);
            parcel.writeInt(this.avi);
            parcel.writeLong(this.avj);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> avl = new ArrayList<>(5);
        public int avo;
        public com.baidu.tieba.horizonalList.widget.a hhD;
        public GroupMetadata hhE;

        private void resetState() {
            if (this.hhD != null) {
                this.hhD.recycle();
                this.hhD = null;
            }
            this.hhE = null;
            this.avo = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b bOg = bOg();
            bOg.hhD = com.baidu.tieba.horizonalList.widget.a.A(i2, i3, i4, i);
            bOg.hhE = groupMetadata;
            bOg.avo = i5;
            return bOg;
        }

        private static b bOg() {
            b bVar;
            synchronized (avl) {
                if (avl.size() > 0) {
                    bVar = avl.remove(0);
                    bVar.resetState();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            resetState();
            synchronized (avl) {
                if (avl.size() < 5) {
                    avl.add(this);
                }
            }
        }

        public boolean xw() {
            return this.hhE != null;
        }
    }
}
