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
import androidx.appcompat.widget.ActivityChooserView;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes.dex */
class ExpandableHListConnector extends BaseAdapter implements Filterable {
    private ExpandableListAdapter bEu;
    private int bEw;
    private int bEx = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> bEv = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.bEu != null) {
            this.bEu.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.bEu = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b BP(int i) {
        int i2;
        int i3;
        ArrayList<GroupMetadata> arrayList = this.bEv;
        int size = arrayList.size();
        int i4 = size - 1;
        if (size == 0) {
            return b.a(i, 2, i, -1, null, 0);
        }
        int i5 = 0;
        int i6 = 0;
        while (i6 <= i4) {
            int i7 = ((i4 - i6) / 2) + i6;
            GroupMetadata groupMetadata = arrayList.get(i7);
            if (i > groupMetadata.bEz) {
                i6 = i7 + 1;
                i5 = i7;
            } else if (i < groupMetadata.bEy) {
                i4 = i7 - 1;
                i5 = i7;
            } else if (i == groupMetadata.bEy) {
                return b.a(i, 2, groupMetadata.bEA, -1, groupMetadata, i7);
            } else {
                if (i <= groupMetadata.bEz) {
                    return b.a(i, 1, groupMetadata.bEA, i - (groupMetadata.bEy + 1), groupMetadata, i7);
                }
                i5 = i7;
            }
        }
        if (i6 > i5) {
            GroupMetadata groupMetadata2 = arrayList.get(i6 - 1);
            i3 = (i - groupMetadata2.bEz) + groupMetadata2.bEA;
            i2 = i6;
        } else if (i4 < i5) {
            i2 = i4 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.bEA - (groupMetadata3.bEy - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        ArrayList<GroupMetadata> arrayList = this.bEv;
        int size = arrayList.size();
        int i = size - 1;
        if (size == 0) {
            return b.a(aVar.bEH, aVar.type, aVar.bEH, aVar.bEI, null, 0);
        }
        int i2 = 0;
        int i3 = 0;
        while (i3 <= i) {
            int i4 = ((i - i3) / 2) + i3;
            GroupMetadata groupMetadata = arrayList.get(i4);
            if (aVar.bEH > groupMetadata.bEA) {
                i2 = i4;
                i3 = i4 + 1;
            } else if (aVar.bEH < groupMetadata.bEA) {
                i = i4 - 1;
                i2 = i4;
            } else if (aVar.bEH == groupMetadata.bEA) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.bEy, aVar.type, aVar.bEH, aVar.bEI, groupMetadata, i4);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.bEy + aVar.bEI + 1, aVar.type, aVar.bEH, aVar.bEI, groupMetadata, i4);
                }
                return null;
            } else {
                i2 = i4;
            }
        }
        if (aVar.type == 2) {
            if (i3 > i2) {
                GroupMetadata groupMetadata2 = arrayList.get(i3 - 1);
                return b.a((aVar.bEH - groupMetadata2.bEA) + groupMetadata2.bEz, aVar.type, aVar.bEH, aVar.bEI, null, i3);
            } else if (i < i2) {
                int i5 = i + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.bEy - (groupMetadata3.bEA - aVar.bEH), aVar.type, aVar.bEH, aVar.bEI, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.bEu.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b BP = BP(i);
        com.baidu.tieba.horizonalList.widget.a aVar = BP.kjP;
        boolean isChildSelectable = aVar.type == 1 ? this.bEu.isChildSelectable(aVar.bEH, aVar.bEI) : true;
        BP.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bEu.getGroupCount() + this.bEw;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b BP = BP(i);
        if (BP.kjP.type == 2) {
            child = this.bEu.getGroup(BP.kjP.bEH);
        } else if (BP.kjP.type == 1) {
            child = this.bEu.getChild(BP.kjP.bEH, BP.kjP.bEI);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        BP.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b BP = BP(i);
        long groupId = this.bEu.getGroupId(BP.kjP.bEH);
        if (BP.kjP.type == 2) {
            combinedChildId = this.bEu.getCombinedGroupId(groupId);
        } else if (BP.kjP.type == 1) {
            combinedChildId = this.bEu.getCombinedChildId(groupId, this.bEu.getChildId(BP.kjP.bEH, BP.kjP.bEI));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        BP.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b BP = BP(i);
        if (BP.kjP.type == 2) {
            childView = this.bEu.getGroupView(BP.kjP.bEH, BP.isExpanded(), view, viewGroup);
        } else if (BP.kjP.type == 1) {
            childView = this.bEu.getChildView(BP.kjP.bEH, BP.kjP.bEI, BP.kjQ.bEz == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        BP.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b BP = BP(i);
        com.baidu.tieba.horizonalList.widget.a aVar = BP.kjP;
        if (this.bEu instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bEu;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.bEH);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.bEH, aVar.bEI);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        BP.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.bEu instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bEu;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.bEu.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        ArrayList<GroupMetadata> arrayList = this.bEv;
        int size = arrayList.size();
        this.bEw = 0;
        if (z2) {
            int i = size - 1;
            boolean z4 = false;
            while (i >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i);
                int k = k(groupMetadata.bEB, groupMetadata.bEA);
                if (k != groupMetadata.bEA) {
                    if (k == -1) {
                        arrayList.remove(i);
                        size--;
                    }
                    groupMetadata.bEA = k;
                    if (!z4) {
                        z3 = true;
                        i--;
                        z4 = z3;
                    }
                }
                z3 = z4;
                i--;
                z4 = z3;
            }
            if (z4) {
                Collections.sort(arrayList);
            }
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < size) {
            GroupMetadata groupMetadata2 = arrayList.get(i2);
            if (groupMetadata2.bEz == -1 || z) {
                childrenCount = this.bEu.getChildrenCount(groupMetadata2.bEA);
            } else {
                childrenCount = groupMetadata2.bEz - groupMetadata2.bEy;
            }
            this.bEw += childrenCount;
            int i5 = i4 + (groupMetadata2.bEA - i3);
            int i6 = groupMetadata2.bEA;
            groupMetadata2.bEy = i5;
            int i7 = childrenCount + i5;
            groupMetadata2.bEz = i7;
            i2++;
            i3 = i6;
            i4 = i7;
        }
    }

    boolean eu(int i) {
        com.baidu.tieba.horizonalList.widget.a J = com.baidu.tieba.horizonalList.widget.a.J(2, i, -1, -1);
        b a2 = a(J);
        J.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.kjQ == null) {
            return false;
        }
        this.bEv.remove(bVar.kjQ);
        g(false, false);
        notifyDataSetChanged();
        this.bEu.onGroupCollapsed(bVar.kjQ.bEA);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.kjP.bEH < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.bEx != 0 && bVar.kjQ == null) {
            if (this.bEv.size() >= this.bEx) {
                GroupMetadata groupMetadata = this.bEv.get(0);
                int indexOf = this.bEv.indexOf(groupMetadata);
                eu(groupMetadata.bEA);
                if (bVar.bEG > indexOf) {
                    bVar.bEG--;
                }
            }
            GroupMetadata c = GroupMetadata.c(-1, -1, bVar.kjP.bEH, this.bEu.getGroupId(bVar.kjP.bEH));
            this.bEv.add(bVar.bEG, c);
            g(false, false);
            notifyDataSetChanged();
            this.bEu.onGroupExpanded(c.bEA);
            return true;
        }
        return false;
    }

    ExpandableListAdapter Sg() {
        return this.bEu;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter Sg = Sg();
        if (Sg instanceof Filterable) {
            return ((Filterable) Sg).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> Sh() {
        return this.bEv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.bEu != null) {
            int groupCount = this.bEu.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).bEA >= groupCount) {
                    return;
                }
            }
            this.bEv = arrayList;
            g(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter Sg = Sg();
        if (Sg != null) {
            return Sg.isEmpty();
        }
        return true;
    }

    int k(long j, int i) {
        int groupCount = this.bEu.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter Sg = Sg();
        if (Sg == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        int i4 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (Sg.getGroupId(i4) != j) {
                boolean z2 = i2 == groupCount + (-1);
                boolean z3 = i3 == 0;
                if (z2 && z3) {
                    break;
                } else if (z3 || (z && !z2)) {
                    int i5 = i2 + 1;
                    z = false;
                    i2 = i5;
                    i4 = i5;
                } else if (z2 || (!z && !z3)) {
                    int i6 = i3 - 1;
                    z = true;
                    i3 = i6;
                    i4 = i6;
                }
            } else {
                return i4;
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
            /* renamed from: ac */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.c(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: BQ */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int bEA;
        long bEB;
        int bEy;
        int bEz;

        private GroupMetadata() {
        }

        static GroupMetadata c(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.bEy = i;
            groupMetadata.bEz = i2;
            groupMetadata.bEA = i3;
            groupMetadata.bEB = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.bEA - groupMetadata.bEA;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.bEy);
            parcel.writeInt(this.bEz);
            parcel.writeInt(this.bEA);
            parcel.writeLong(this.bEB);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> bED = new ArrayList<>(5);
        public int bEG;
        public com.baidu.tieba.horizonalList.widget.a kjP;
        public GroupMetadata kjQ;

        private void Si() {
            if (this.kjP != null) {
                this.kjP.recycle();
                this.kjP = null;
            }
            this.kjQ = null;
            this.bEG = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b cQA = cQA();
            cQA.kjP = com.baidu.tieba.horizonalList.widget.a.J(i2, i3, i4, i);
            cQA.kjQ = groupMetadata;
            cQA.bEG = i5;
            return cQA;
        }

        private static b cQA() {
            b bVar;
            synchronized (bED) {
                if (bED.size() > 0) {
                    bVar = bED.remove(0);
                    bVar.Si();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            Si();
            synchronized (bED) {
                if (bED.size() < 5) {
                    bED.add(this);
                }
            }
        }

        public boolean isExpanded() {
            return this.kjQ != null;
        }
    }
}
