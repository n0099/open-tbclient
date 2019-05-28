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
    private ExpandableListAdapter giS;
    private int giU;
    private int giV = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> giT = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.giS != null) {
            this.giS.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.giS = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b tT(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.giT;
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
            if (i > groupMetadata.giX) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.giW) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.giW) {
                return b.a(i, 2, groupMetadata.giY, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.giX) {
                    return b.a(i, 1, groupMetadata.giY, i - (groupMetadata.giW + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.giX) + groupMetadata2.giY;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.giY - (groupMetadata3.giW - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.giT;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.gjf, aVar.type, aVar.gjf, aVar.gjg, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.gjf > groupMetadata.giY) {
                i4 = i + 1;
            } else if (aVar.gjf < groupMetadata.giY) {
                i3 = i - 1;
            } else if (aVar.gjf == groupMetadata.giY) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.giW, aVar.type, aVar.gjf, aVar.gjg, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.giW + aVar.gjg + 1, aVar.type, aVar.gjf, aVar.gjg, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.gjf - groupMetadata2.giY) + groupMetadata2.giX, aVar.type, aVar.gjf, aVar.gjg, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.giW - (groupMetadata3.giY - aVar.gjf), aVar.type, aVar.gjf, aVar.gjg, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.giS.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b tT = tT(i);
        com.baidu.tieba.horizonalList.widget.a aVar = tT.gjc;
        boolean isChildSelectable = aVar.type == 1 ? this.giS.isChildSelectable(aVar.gjf, aVar.gjg) : true;
        tT.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.giS.getGroupCount() + this.giU;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b tT = tT(i);
        if (tT.gjc.type == 2) {
            child = this.giS.getGroup(tT.gjc.gjf);
        } else if (tT.gjc.type == 1) {
            child = this.giS.getChild(tT.gjc.gjf, tT.gjc.gjg);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        tT.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b tT = tT(i);
        long groupId = this.giS.getGroupId(tT.gjc.gjf);
        if (tT.gjc.type == 2) {
            combinedChildId = this.giS.getCombinedGroupId(groupId);
        } else if (tT.gjc.type == 1) {
            combinedChildId = this.giS.getCombinedChildId(groupId, this.giS.getChildId(tT.gjc.gjf, tT.gjc.gjg));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        tT.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b tT = tT(i);
        if (tT.gjc.type == 2) {
            childView = this.giS.getGroupView(tT.gjc.gjf, tT.bhk(), view, viewGroup);
        } else if (tT.gjc.type == 1) {
            childView = this.giS.getChildView(tT.gjc.gjf, tT.gjc.gjg, tT.gjd.giX == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        tT.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b tT = tT(i);
        com.baidu.tieba.horizonalList.widget.a aVar = tT.gjc;
        if (this.giS instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.giS;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.gjf);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.gjf, aVar.gjg);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        tT.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.giS instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.giS;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.giS.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.giT;
        int size = arrayList.size();
        this.giU = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int o = o(groupMetadata.giZ, groupMetadata.giY);
                if (o != groupMetadata.giY) {
                    if (o == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.giY = o;
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
            if (groupMetadata2.giX == -1 || z) {
                childrenCount = this.giS.getChildrenCount(groupMetadata2.giY);
            } else {
                childrenCount = groupMetadata2.giX - groupMetadata2.giW;
            }
            this.giU += childrenCount;
            int i5 = i4 + (groupMetadata2.giY - i3);
            i3 = groupMetadata2.giY;
            groupMetadata2.giW = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.giX = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        com.baidu.tieba.horizonalList.widget.a w = com.baidu.tieba.horizonalList.widget.a.w(2, i, -1, -1);
        b a2 = a(w);
        w.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.gjd == null) {
            return false;
        }
        this.giT.remove(bVar.gjd);
        N(false, false);
        notifyDataSetChanged();
        this.giS.onGroupCollapsed(bVar.gjd.giY);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.gjc.gjf < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.giV != 0 && bVar.gjd == null) {
            if (this.giT.size() >= this.giV) {
                GroupMetadata groupMetadata = this.giT.get(0);
                int indexOf = this.giT.indexOf(groupMetadata);
                collapseGroup(groupMetadata.giY);
                if (bVar.gje > indexOf) {
                    bVar.gje--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.gjc.gjf, this.giS.getGroupId(bVar.gjc.gjf));
            this.giT.add(bVar.gje, b2);
            N(false, false);
            notifyDataSetChanged();
            this.giS.onGroupExpanded(b2.giY);
            return true;
        }
        return false;
    }

    ExpandableListAdapter bvh() {
        return this.giS;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter bvh = bvh();
        if (bvh instanceof Filterable) {
            return ((Filterable) bvh).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> bvi() {
        return this.giT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void af(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.giS != null) {
            int groupCount = this.giS.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).giY >= groupCount) {
                    return;
                }
            }
            this.giT = arrayList;
            N(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter bvh = bvh();
        if (bvh != null) {
            return bvh.isEmpty();
        }
        return true;
    }

    int o(long j, int i) {
        int groupCount = this.giS.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter bvh = bvh();
        if (bvh == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (bvh.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.N(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.N(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: M */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.b(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: tU */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int giW;
        int giX;
        int giY;
        long giZ;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.giW = i;
            groupMetadata.giX = i2;
            groupMetadata.giY = i3;
            groupMetadata.giZ = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.giY - groupMetadata.giY;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.giW);
            parcel.writeInt(this.giX);
            parcel.writeInt(this.giY);
            parcel.writeLong(this.giZ);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> gjb = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a gjc;
        public GroupMetadata gjd;
        public int gje;

        private void aAd() {
            if (this.gjc != null) {
                this.gjc.recycle();
                this.gjc = null;
            }
            this.gjd = null;
            this.gje = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b bvj = bvj();
            bvj.gjc = com.baidu.tieba.horizonalList.widget.a.w(i2, i3, i4, i);
            bvj.gjd = groupMetadata;
            bvj.gje = i5;
            return bvj;
        }

        private static b bvj() {
            b bVar;
            synchronized (gjb) {
                if (gjb.size() > 0) {
                    bVar = gjb.remove(0);
                    bVar.aAd();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            aAd();
            synchronized (gjb) {
                if (gjb.size() < 5) {
                    gjb.add(this);
                }
            }
        }

        public boolean bhk() {
            return this.gjd != null;
        }
    }
}
