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
    private ExpandableListAdapter bzk;
    private int bzm;
    private int bzn = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> bzl = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.bzk != null) {
            this.bzk.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.bzk = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b Cs(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.bzl;
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
            if (i > groupMetadata.bzp) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.bzo) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.bzo) {
                return b.a(i, 2, groupMetadata.bzq, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.bzp) {
                    return b.a(i, 1, groupMetadata.bzq, i - (groupMetadata.bzo + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.bzp) + groupMetadata2.bzq;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.bzq - (groupMetadata3.bzo - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.bzl;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.bzx, aVar.type, aVar.bzx, aVar.bzy, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.bzx > groupMetadata.bzq) {
                i4 = i + 1;
            } else if (aVar.bzx < groupMetadata.bzq) {
                i3 = i - 1;
            } else if (aVar.bzx == groupMetadata.bzq) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.bzo, aVar.type, aVar.bzx, aVar.bzy, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.bzo + aVar.bzy + 1, aVar.type, aVar.bzx, aVar.bzy, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.bzx - groupMetadata2.bzq) + groupMetadata2.bzp, aVar.type, aVar.bzx, aVar.bzy, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.bzo - (groupMetadata3.bzq - aVar.bzx), aVar.type, aVar.bzx, aVar.bzy, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.bzk.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b Cs = Cs(i);
        com.baidu.tieba.horizonalList.widget.a aVar = Cs.jND;
        boolean isChildSelectable = aVar.type == 1 ? this.bzk.isChildSelectable(aVar.bzx, aVar.bzy) : true;
        Cs.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bzk.getGroupCount() + this.bzm;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b Cs = Cs(i);
        if (Cs.jND.type == 2) {
            child = this.bzk.getGroup(Cs.jND.bzx);
        } else if (Cs.jND.type == 1) {
            child = this.bzk.getChild(Cs.jND.bzx, Cs.jND.bzy);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        Cs.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b Cs = Cs(i);
        long groupId = this.bzk.getGroupId(Cs.jND.bzx);
        if (Cs.jND.type == 2) {
            combinedChildId = this.bzk.getCombinedGroupId(groupId);
        } else if (Cs.jND.type == 1) {
            combinedChildId = this.bzk.getCombinedChildId(groupId, this.bzk.getChildId(Cs.jND.bzx, Cs.jND.bzy));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        Cs.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b Cs = Cs(i);
        if (Cs.jND.type == 2) {
            childView = this.bzk.getGroupView(Cs.jND.bzx, Cs.Sy(), view, viewGroup);
        } else if (Cs.jND.type == 1) {
            childView = this.bzk.getChildView(Cs.jND.bzx, Cs.jND.bzy, Cs.jNE.bzp == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        Cs.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b Cs = Cs(i);
        com.baidu.tieba.horizonalList.widget.a aVar = Cs.jND;
        if (this.bzk instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bzk;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.bzx);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.bzx, aVar.bzy);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        Cs.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.bzk instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bzk;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.bzk.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.bzl;
        int size = arrayList.size();
        this.bzm = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int j = j(groupMetadata.bzr, groupMetadata.bzq);
                if (j != groupMetadata.bzq) {
                    if (j == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.bzq = j;
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
            if (groupMetadata2.bzp == -1 || z) {
                childrenCount = this.bzk.getChildrenCount(groupMetadata2.bzq);
            } else {
                childrenCount = groupMetadata2.bzp - groupMetadata2.bzo;
            }
            this.bzm += childrenCount;
            int i5 = i4 + (groupMetadata2.bzq - i3);
            i3 = groupMetadata2.bzq;
            groupMetadata2.bzo = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.bzp = i6;
            i++;
            i4 = i6;
        }
    }

    boolean fB(int i) {
        com.baidu.tieba.horizonalList.widget.a E = com.baidu.tieba.horizonalList.widget.a.E(2, i, -1, -1);
        b a2 = a(E);
        E.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.jNE == null) {
            return false;
        }
        this.bzl.remove(bVar.jNE);
        g(false, false);
        notifyDataSetChanged();
        this.bzk.onGroupCollapsed(bVar.jNE.bzq);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.jND.bzx < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.bzn != 0 && bVar.jNE == null) {
            if (this.bzl.size() >= this.bzn) {
                GroupMetadata groupMetadata = this.bzl.get(0);
                int indexOf = this.bzl.indexOf(groupMetadata);
                fB(groupMetadata.bzq);
                if (bVar.bzw > indexOf) {
                    bVar.bzw--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.jND.bzx, this.bzk.getGroupId(bVar.jND.bzx));
            this.bzl.add(bVar.bzw, b2);
            g(false, false);
            notifyDataSetChanged();
            this.bzk.onGroupExpanded(b2.bzq);
            return true;
        }
        return false;
    }

    ExpandableListAdapter Sv() {
        return this.bzk;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter Sv = Sv();
        if (Sv instanceof Filterable) {
            return ((Filterable) Sv).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> Sw() {
        return this.bzl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.bzk != null) {
            int groupCount = this.bzk.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).bzq >= groupCount) {
                    return;
                }
            }
            this.bzl = arrayList;
            g(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter Sv = Sv();
        if (Sv != null) {
            return Sv.isEmpty();
        }
        return true;
    }

    int j(long j, int i) {
        int groupCount = this.bzk.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter Sv = Sv();
        if (Sv == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (Sv.getGroupId(i3) != j) {
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
            /* renamed from: ab */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.b(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Ct */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int bzo;
        int bzp;
        int bzq;
        long bzr;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.bzo = i;
            groupMetadata.bzp = i2;
            groupMetadata.bzq = i3;
            groupMetadata.bzr = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.bzq - groupMetadata.bzq;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.bzo);
            parcel.writeInt(this.bzp);
            parcel.writeInt(this.bzq);
            parcel.writeLong(this.bzr);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> bzt = new ArrayList<>(5);
        public int bzw;
        public com.baidu.tieba.horizonalList.widget.a jND;
        public GroupMetadata jNE;

        private void resetState() {
            if (this.jND != null) {
                this.jND.recycle();
                this.jND = null;
            }
            this.jNE = null;
            this.bzw = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b cLW = cLW();
            cLW.jND = com.baidu.tieba.horizonalList.widget.a.E(i2, i3, i4, i);
            cLW.jNE = groupMetadata;
            cLW.bzw = i5;
            return cLW;
        }

        private static b cLW() {
            b bVar;
            synchronized (bzt) {
                if (bzt.size() > 0) {
                    bVar = bzt.remove(0);
                    bVar.resetState();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            resetState();
            synchronized (bzt) {
                if (bzt.size() < 5) {
                    bzt.add(this);
                }
            }
        }

        public boolean Sy() {
            return this.jNE != null;
        }
    }
}
