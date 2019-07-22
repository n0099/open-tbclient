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
    private ExpandableListAdapter gpg;
    private int gpi;
    private int gpj = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> gph = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.gpg != null) {
            this.gpg.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.gpg = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b ur(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.gph;
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
            if (i > groupMetadata.gpl) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.gpk) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.gpk) {
                return b.a(i, 2, groupMetadata.gpm, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.gpl) {
                    return b.a(i, 1, groupMetadata.gpm, i - (groupMetadata.gpk + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.gpl) + groupMetadata2.gpm;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.gpm - (groupMetadata3.gpk - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.gph;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.gpt, aVar.type, aVar.gpt, aVar.gpu, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.gpt > groupMetadata.gpm) {
                i4 = i + 1;
            } else if (aVar.gpt < groupMetadata.gpm) {
                i3 = i - 1;
            } else if (aVar.gpt == groupMetadata.gpm) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.gpk, aVar.type, aVar.gpt, aVar.gpu, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.gpk + aVar.gpu + 1, aVar.type, aVar.gpt, aVar.gpu, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.gpt - groupMetadata2.gpm) + groupMetadata2.gpl, aVar.type, aVar.gpt, aVar.gpu, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.gpk - (groupMetadata3.gpm - aVar.gpt), aVar.type, aVar.gpt, aVar.gpu, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.gpg.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b ur = ur(i);
        com.baidu.tieba.horizonalList.widget.a aVar = ur.gpq;
        boolean isChildSelectable = aVar.type == 1 ? this.gpg.isChildSelectable(aVar.gpt, aVar.gpu) : true;
        ur.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gpg.getGroupCount() + this.gpi;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b ur = ur(i);
        if (ur.gpq.type == 2) {
            child = this.gpg.getGroup(ur.gpq.gpt);
        } else if (ur.gpq.type == 1) {
            child = this.gpg.getChild(ur.gpq.gpt, ur.gpq.gpu);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ur.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b ur = ur(i);
        long groupId = this.gpg.getGroupId(ur.gpq.gpt);
        if (ur.gpq.type == 2) {
            combinedChildId = this.gpg.getCombinedGroupId(groupId);
        } else if (ur.gpq.type == 1) {
            combinedChildId = this.gpg.getCombinedChildId(groupId, this.gpg.getChildId(ur.gpq.gpt, ur.gpq.gpu));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ur.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b ur = ur(i);
        if (ur.gpq.type == 2) {
            childView = this.gpg.getGroupView(ur.gpq.gpt, ur.bjn(), view, viewGroup);
        } else if (ur.gpq.type == 1) {
            childView = this.gpg.getChildView(ur.gpq.gpt, ur.gpq.gpu, ur.gpr.gpl == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ur.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b ur = ur(i);
        com.baidu.tieba.horizonalList.widget.a aVar = ur.gpq;
        if (this.gpg instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.gpg;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.gpt);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.gpt, aVar.gpu);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        ur.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.gpg instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.gpg;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.gpg.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.gph;
        int size = arrayList.size();
        this.gpi = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int o = o(groupMetadata.gpn, groupMetadata.gpm);
                if (o != groupMetadata.gpm) {
                    if (o == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.gpm = o;
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
            if (groupMetadata2.gpl == -1 || z) {
                childrenCount = this.gpg.getChildrenCount(groupMetadata2.gpm);
            } else {
                childrenCount = groupMetadata2.gpl - groupMetadata2.gpk;
            }
            this.gpi += childrenCount;
            int i5 = i4 + (groupMetadata2.gpm - i3);
            i3 = groupMetadata2.gpm;
            groupMetadata2.gpk = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.gpl = i6;
            i++;
            i4 = i6;
        }
    }

    boolean us(int i) {
        com.baidu.tieba.horizonalList.widget.a x = com.baidu.tieba.horizonalList.widget.a.x(2, i, -1, -1);
        b a2 = a(x);
        x.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.gpr == null) {
            return false;
        }
        this.gph.remove(bVar.gpr);
        Q(false, false);
        notifyDataSetChanged();
        this.gpg.onGroupCollapsed(bVar.gpr.gpm);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.gpq.gpt < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.gpj != 0 && bVar.gpr == null) {
            if (this.gph.size() >= this.gpj) {
                GroupMetadata groupMetadata = this.gph.get(0);
                int indexOf = this.gph.indexOf(groupMetadata);
                us(groupMetadata.gpm);
                if (bVar.gps > indexOf) {
                    bVar.gps--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.gpq.gpt, this.gpg.getGroupId(bVar.gpq.gpt));
            this.gph.add(bVar.gps, b2);
            Q(false, false);
            notifyDataSetChanged();
            this.gpg.onGroupExpanded(b2.gpm);
            return true;
        }
        return false;
    }

    ExpandableListAdapter bxN() {
        return this.gpg;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter bxN = bxN();
        if (bxN instanceof Filterable) {
            return ((Filterable) bxN).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> bxO() {
        return this.gph;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void af(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.gpg != null) {
            int groupCount = this.gpg.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).gpm >= groupCount) {
                    return;
                }
            }
            this.gph = arrayList;
            Q(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter bxN = bxN();
        if (bxN != null) {
            return bxN.isEmpty();
        }
        return true;
    }

    int o(long j, int i) {
        int groupCount = this.gpg.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter bxN = bxN();
        if (bxN == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (bxN.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.Q(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.Q(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: O */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.b(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ut */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int gpk;
        int gpl;
        int gpm;
        long gpn;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.gpk = i;
            groupMetadata.gpl = i2;
            groupMetadata.gpm = i3;
            groupMetadata.gpn = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.gpm - groupMetadata.gpm;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.gpk);
            parcel.writeInt(this.gpl);
            parcel.writeInt(this.gpm);
            parcel.writeLong(this.gpn);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> gpp = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a gpq;
        public GroupMetadata gpr;
        public int gps;

        private void aBr() {
            if (this.gpq != null) {
                this.gpq.recycle();
                this.gpq = null;
            }
            this.gpr = null;
            this.gps = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b bxP = bxP();
            bxP.gpq = com.baidu.tieba.horizonalList.widget.a.x(i2, i3, i4, i);
            bxP.gpr = groupMetadata;
            bxP.gps = i5;
            return bxP;
        }

        private static b bxP() {
            b bVar;
            synchronized (gpp) {
                if (gpp.size() > 0) {
                    bVar = gpp.remove(0);
                    bVar.aBr();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            aBr();
            synchronized (gpp) {
                if (gpp.size() < 5) {
                    gpp.add(this);
                }
            }
        }

        public boolean bjn() {
            return this.gpr != null;
        }
    }
}
