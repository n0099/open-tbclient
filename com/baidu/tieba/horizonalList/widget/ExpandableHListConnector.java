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
    private ExpandableListAdapter ema;
    private int emc;
    private int emd = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> emb = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.ema != null) {
            this.ema.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.ema = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b oY(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.emb;
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
            if (i > groupMetadata.emf) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.eme) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.eme) {
                return b.a(i, 2, groupMetadata.emg, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.emf) {
                    return b.a(i, 1, groupMetadata.emg, i - (groupMetadata.eme + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.emf) + groupMetadata2.emg;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.emg - (groupMetadata3.eme - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.b bVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.emb;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(bVar.emn, bVar.type, bVar.emn, bVar.emo, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (bVar.emn > groupMetadata.emg) {
                i4 = i + 1;
            } else if (bVar.emn < groupMetadata.emg) {
                i3 = i - 1;
            } else if (bVar.emn == groupMetadata.emg) {
                if (bVar.type == 2) {
                    return b.a(groupMetadata.eme, bVar.type, bVar.emn, bVar.emo, groupMetadata, i);
                }
                if (bVar.type == 1) {
                    return b.a(groupMetadata.eme + bVar.emo + 1, bVar.type, bVar.emn, bVar.emo, groupMetadata, i);
                }
                return null;
            }
        }
        if (bVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((bVar.emn - groupMetadata2.emg) + groupMetadata2.emf, bVar.type, bVar.emn, bVar.emo, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.eme - (groupMetadata3.emg - bVar.emn), bVar.type, bVar.emn, bVar.emo, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.ema.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b oY = oY(i);
        com.baidu.tieba.horizonalList.widget.b bVar = oY.emk;
        boolean isChildSelectable = bVar.type == 1 ? this.ema.isChildSelectable(bVar.emn, bVar.emo) : true;
        oY.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ema.getGroupCount() + this.emc;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b oY = oY(i);
        if (oY.emk.type == 2) {
            child = this.ema.getGroup(oY.emk.emn);
        } else if (oY.emk.type == 1) {
            child = this.ema.getChild(oY.emk.emn, oY.emk.emo);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        oY.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b oY = oY(i);
        long groupId = this.ema.getGroupId(oY.emk.emn);
        if (oY.emk.type == 2) {
            combinedChildId = this.ema.getCombinedGroupId(groupId);
        } else if (oY.emk.type == 1) {
            combinedChildId = this.ema.getCombinedChildId(groupId, this.ema.getChildId(oY.emk.emn, oY.emk.emo));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        oY.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b oY = oY(i);
        if (oY.emk.type == 2) {
            childView = this.ema.getGroupView(oY.emk.emn, oY.atx(), view, viewGroup);
        } else if (oY.emk.type == 1) {
            childView = this.ema.getChildView(oY.emk.emn, oY.emk.emo, oY.eml.emf == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        oY.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b oY = oY(i);
        com.baidu.tieba.horizonalList.widget.b bVar = oY.emk;
        if (this.ema instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.ema;
            if (bVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(bVar.emn);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(bVar.emn, bVar.emo);
            }
        } else if (bVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        oY.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.ema instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.ema;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.ema.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.emb;
        int size = arrayList.size();
        this.emc = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int i3 = i(groupMetadata.emh, groupMetadata.emg);
                if (i3 != groupMetadata.emg) {
                    if (i3 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.emg = i3;
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
            if (groupMetadata2.emf == -1 || z) {
                childrenCount = this.ema.getChildrenCount(groupMetadata2.emg);
            } else {
                childrenCount = groupMetadata2.emf - groupMetadata2.eme;
            }
            this.emc += childrenCount;
            int i6 = i5 + (groupMetadata2.emg - i4);
            i4 = groupMetadata2.emg;
            groupMetadata2.eme = i6;
            int i7 = childrenCount + i6;
            groupMetadata2.emf = i7;
            i++;
            i5 = i7;
        }
    }

    boolean collapseGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b z = com.baidu.tieba.horizonalList.widget.b.z(2, i, -1, -1);
        b a2 = a(z);
        z.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.eml == null) {
            return false;
        }
        this.emb.remove(bVar.eml);
        D(false, false);
        notifyDataSetChanged();
        this.ema.onGroupCollapsed(bVar.eml.emg);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.emk.emn < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.emd != 0 && bVar.eml == null) {
            if (this.emb.size() >= this.emd) {
                GroupMetadata groupMetadata = this.emb.get(0);
                int indexOf = this.emb.indexOf(groupMetadata);
                collapseGroup(groupMetadata.emg);
                if (bVar.emm > indexOf) {
                    bVar.emm--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.emk.emn, this.ema.getGroupId(bVar.emk.emn));
            this.emb.add(bVar.emm, a2);
            D(false, false);
            notifyDataSetChanged();
            this.ema.onGroupExpanded(a2.emg);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aDq() {
        return this.ema;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aDq = aDq();
        if (aDq instanceof Filterable) {
            return ((Filterable) aDq).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aDr() {
        return this.emb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.ema != null) {
            int groupCount = this.ema.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).emg >= groupCount) {
                    return;
                }
            }
            this.emb = arrayList;
            D(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aDq = aDq();
        if (aDq != null) {
            return aDq.isEmpty();
        }
        return true;
    }

    int i(long j, int i) {
        int groupCount = this.ema.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aDq = aDq();
        if (aDq == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aDq.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.D(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.D(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: E */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: oZ */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int eme;
        int emf;
        int emg;
        long emh;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.eme = i;
            groupMetadata.emf = i2;
            groupMetadata.emg = i3;
            groupMetadata.emh = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.emg - groupMetadata.emg;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.eme);
            parcel.writeInt(this.emf);
            parcel.writeInt(this.emg);
            parcel.writeLong(this.emh);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> emj = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.b emk;
        public GroupMetadata eml;
        public int emm;

        private void Tc() {
            if (this.emk != null) {
                this.emk.recycle();
                this.emk = null;
            }
            this.eml = null;
            this.emm = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aDs = aDs();
            aDs.emk = com.baidu.tieba.horizonalList.widget.b.z(i2, i3, i4, i);
            aDs.eml = groupMetadata;
            aDs.emm = i5;
            return aDs;
        }

        private static b aDs() {
            b bVar;
            synchronized (emj) {
                if (emj.size() > 0) {
                    bVar = emj.remove(0);
                    bVar.Tc();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            Tc();
            synchronized (emj) {
                if (emj.size() < 5) {
                    emj.add(this);
                }
            }
        }

        public boolean atx() {
            return this.eml != null;
        }
    }
}
