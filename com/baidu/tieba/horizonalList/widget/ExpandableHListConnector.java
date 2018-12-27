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
    private ExpandableListAdapter eAX;
    private int eAZ;
    private int eBa = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> eAY = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.eAX != null) {
            this.eAX.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.eAX = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b pe(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.eAY;
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
            if (i > groupMetadata.eBc) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.eBb) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.eBb) {
                return b.a(i, 2, groupMetadata.eBd, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.eBc) {
                    return b.a(i, 1, groupMetadata.eBd, i - (groupMetadata.eBb + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.eBc) + groupMetadata2.eBd;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.eBd - (groupMetadata3.eBb - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.eAY;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.eBk, aVar.type, aVar.eBk, aVar.eBl, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.eBk > groupMetadata.eBd) {
                i4 = i + 1;
            } else if (aVar.eBk < groupMetadata.eBd) {
                i3 = i - 1;
            } else if (aVar.eBk == groupMetadata.eBd) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.eBb, aVar.type, aVar.eBk, aVar.eBl, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.eBb + aVar.eBl + 1, aVar.type, aVar.eBk, aVar.eBl, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.eBk - groupMetadata2.eBd) + groupMetadata2.eBc, aVar.type, aVar.eBk, aVar.eBl, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.eBb - (groupMetadata3.eBd - aVar.eBk), aVar.type, aVar.eBk, aVar.eBl, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.eAX.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b pe = pe(i);
        com.baidu.tieba.horizonalList.widget.a aVar = pe.eBh;
        boolean isChildSelectable = aVar.type == 1 ? this.eAX.isChildSelectable(aVar.eBk, aVar.eBl) : true;
        pe.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eAX.getGroupCount() + this.eAZ;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b pe = pe(i);
        if (pe.eBh.type == 2) {
            child = this.eAX.getGroup(pe.eBh.eBk);
        } else if (pe.eBh.type == 1) {
            child = this.eAX.getChild(pe.eBh.eBk, pe.eBh.eBl);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        pe.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b pe = pe(i);
        long groupId = this.eAX.getGroupId(pe.eBh.eBk);
        if (pe.eBh.type == 2) {
            combinedChildId = this.eAX.getCombinedGroupId(groupId);
        } else if (pe.eBh.type == 1) {
            combinedChildId = this.eAX.getCombinedChildId(groupId, this.eAX.getChildId(pe.eBh.eBk, pe.eBh.eBl));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        pe.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b pe = pe(i);
        if (pe.eBh.type == 2) {
            childView = this.eAX.getGroupView(pe.eBh.eBk, pe.ayU(), view, viewGroup);
        } else if (pe.eBh.type == 1) {
            childView = this.eAX.getChildView(pe.eBh.eBk, pe.eBh.eBl, pe.eBi.eBc == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        pe.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b pe = pe(i);
        com.baidu.tieba.horizonalList.widget.a aVar = pe.eBh;
        if (this.eAX instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.eAX;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.eBk);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.eBk, aVar.eBl);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        pe.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.eAX instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.eAX;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.eAX.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.eAY;
        int size = arrayList.size();
        this.eAZ = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int l = l(groupMetadata.eBe, groupMetadata.eBd);
                if (l != groupMetadata.eBd) {
                    if (l == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.eBd = l;
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
            if (groupMetadata2.eBc == -1 || z) {
                childrenCount = this.eAX.getChildrenCount(groupMetadata2.eBd);
            } else {
                childrenCount = groupMetadata2.eBc - groupMetadata2.eBb;
            }
            this.eAZ += childrenCount;
            int i5 = i4 + (groupMetadata2.eBd - i3);
            i3 = groupMetadata2.eBd;
            groupMetadata2.eBb = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.eBc = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a t = com.baidu.tieba.horizonalList.widget.a.t(2, i, -1, -1);
        b a2 = a(t);
        t.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.eBi == null) {
            return false;
        }
        this.eAY.remove(bVar.eBi);
        H(false, false);
        notifyDataSetChanged();
        this.eAX.onGroupCollapsed(bVar.eBi.eBd);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.eBh.eBk < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.eBa != 0 && bVar.eBi == null) {
            if (this.eAY.size() >= this.eBa) {
                GroupMetadata groupMetadata = this.eAY.get(0);
                int indexOf = this.eAY.indexOf(groupMetadata);
                collapseGroup(groupMetadata.eBd);
                if (bVar.eBj > indexOf) {
                    bVar.eBj--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.eBh.eBk, this.eAX.getGroupId(bVar.eBh.eBk));
            this.eAY.add(bVar.eBj, b2);
            H(false, false);
            notifyDataSetChanged();
            this.eAX.onGroupExpanded(b2.eBd);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aMy() {
        return this.eAX;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aMy = aMy();
        if (aMy instanceof Filterable) {
            return ((Filterable) aMy).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aMz() {
        return this.eAY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.eAX != null) {
            int groupCount = this.eAX.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).eBd >= groupCount) {
                    return;
                }
            }
            this.eAY = arrayList;
            H(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aMy = aMy();
        if (aMy != null) {
            return aMy.isEmpty();
        }
        return true;
    }

    int l(long j, int i) {
        int groupCount = this.eAX.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aMy = aMy();
        if (aMy == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aMy.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.H(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.H(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: s */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.b(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: pf */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int eBb;
        int eBc;
        int eBd;
        long eBe;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.eBb = i;
            groupMetadata.eBc = i2;
            groupMetadata.eBd = i3;
            groupMetadata.eBe = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.eBd - groupMetadata.eBd;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.eBb);
            parcel.writeInt(this.eBc);
            parcel.writeInt(this.eBd);
            parcel.writeLong(this.eBe);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> eBg = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a eBh;
        public GroupMetadata eBi;
        public int eBj;

        private void UD() {
            if (this.eBh != null) {
                this.eBh.recycle();
                this.eBh = null;
            }
            this.eBi = null;
            this.eBj = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aMA = aMA();
            aMA.eBh = com.baidu.tieba.horizonalList.widget.a.t(i2, i3, i4, i);
            aMA.eBi = groupMetadata;
            aMA.eBj = i5;
            return aMA;
        }

        private static b aMA() {
            b bVar;
            synchronized (eBg) {
                if (eBg.size() > 0) {
                    bVar = eBg.remove(0);
                    bVar.UD();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            UD();
            synchronized (eBg) {
                if (eBg.size() < 5) {
                    eBg.add(this);
                }
            }
        }

        public boolean ayU() {
            return this.eBi != null;
        }
    }
}
