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
    private ExpandableListAdapter giU;
    private int giW;
    private int giX = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> giV = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.giU != null) {
            this.giU.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.giU = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b tT(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.giV;
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
            if (i > groupMetadata.giZ) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.giY) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.giY) {
                return b.a(i, 2, groupMetadata.gja, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.giZ) {
                    return b.a(i, 1, groupMetadata.gja, i - (groupMetadata.giY + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.giZ) + groupMetadata2.gja;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.gja - (groupMetadata3.giY - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.giV;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.gjh, aVar.type, aVar.gjh, aVar.gji, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.gjh > groupMetadata.gja) {
                i4 = i + 1;
            } else if (aVar.gjh < groupMetadata.gja) {
                i3 = i - 1;
            } else if (aVar.gjh == groupMetadata.gja) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.giY, aVar.type, aVar.gjh, aVar.gji, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.giY + aVar.gji + 1, aVar.type, aVar.gjh, aVar.gji, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.gjh - groupMetadata2.gja) + groupMetadata2.giZ, aVar.type, aVar.gjh, aVar.gji, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.giY - (groupMetadata3.gja - aVar.gjh), aVar.type, aVar.gjh, aVar.gji, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.giU.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b tT = tT(i);
        com.baidu.tieba.horizonalList.widget.a aVar = tT.gje;
        boolean isChildSelectable = aVar.type == 1 ? this.giU.isChildSelectable(aVar.gjh, aVar.gji) : true;
        tT.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.giU.getGroupCount() + this.giW;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b tT = tT(i);
        if (tT.gje.type == 2) {
            child = this.giU.getGroup(tT.gje.gjh);
        } else if (tT.gje.type == 1) {
            child = this.giU.getChild(tT.gje.gjh, tT.gje.gji);
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
        long groupId = this.giU.getGroupId(tT.gje.gjh);
        if (tT.gje.type == 2) {
            combinedChildId = this.giU.getCombinedGroupId(groupId);
        } else if (tT.gje.type == 1) {
            combinedChildId = this.giU.getCombinedChildId(groupId, this.giU.getChildId(tT.gje.gjh, tT.gje.gji));
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
        if (tT.gje.type == 2) {
            childView = this.giU.getGroupView(tT.gje.gjh, tT.bhk(), view, viewGroup);
        } else if (tT.gje.type == 1) {
            childView = this.giU.getChildView(tT.gje.gjh, tT.gje.gji, tT.gjf.giZ == i, view, viewGroup);
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
        com.baidu.tieba.horizonalList.widget.a aVar = tT.gje;
        if (this.giU instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.giU;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.gjh);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.gjh, aVar.gji);
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
        if (this.giU instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.giU;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.giU.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.giV;
        int size = arrayList.size();
        this.giW = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int o = o(groupMetadata.gjb, groupMetadata.gja);
                if (o != groupMetadata.gja) {
                    if (o == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.gja = o;
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
            if (groupMetadata2.giZ == -1 || z) {
                childrenCount = this.giU.getChildrenCount(groupMetadata2.gja);
            } else {
                childrenCount = groupMetadata2.giZ - groupMetadata2.giY;
            }
            this.giW += childrenCount;
            int i5 = i4 + (groupMetadata2.gja - i3);
            i3 = groupMetadata2.gja;
            groupMetadata2.giY = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.giZ = i6;
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
        if (bVar.gjf == null) {
            return false;
        }
        this.giV.remove(bVar.gjf);
        N(false, false);
        notifyDataSetChanged();
        this.giU.onGroupCollapsed(bVar.gjf.gja);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.gje.gjh < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.giX != 0 && bVar.gjf == null) {
            if (this.giV.size() >= this.giX) {
                GroupMetadata groupMetadata = this.giV.get(0);
                int indexOf = this.giV.indexOf(groupMetadata);
                collapseGroup(groupMetadata.gja);
                if (bVar.gjg > indexOf) {
                    bVar.gjg--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.gje.gjh, this.giU.getGroupId(bVar.gje.gjh));
            this.giV.add(bVar.gjg, b2);
            N(false, false);
            notifyDataSetChanged();
            this.giU.onGroupExpanded(b2.gja);
            return true;
        }
        return false;
    }

    ExpandableListAdapter bvi() {
        return this.giU;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter bvi = bvi();
        if (bvi instanceof Filterable) {
            return ((Filterable) bvi).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> bvj() {
        return this.giV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void af(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.giU != null) {
            int groupCount = this.giU.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).gja >= groupCount) {
                    return;
                }
            }
            this.giV = arrayList;
            N(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter bvi = bvi();
        if (bvi != null) {
            return bvi.isEmpty();
        }
        return true;
    }

    int o(long j, int i) {
        int groupCount = this.giU.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter bvi = bvi();
        if (bvi == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (bvi.getGroupId(i3) != j) {
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
        int giY;
        int giZ;
        int gja;
        long gjb;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.giY = i;
            groupMetadata.giZ = i2;
            groupMetadata.gja = i3;
            groupMetadata.gjb = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.gja - groupMetadata.gja;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.giY);
            parcel.writeInt(this.giZ);
            parcel.writeInt(this.gja);
            parcel.writeLong(this.gjb);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> gjd = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a gje;
        public GroupMetadata gjf;
        public int gjg;

        private void aAd() {
            if (this.gje != null) {
                this.gje.recycle();
                this.gje = null;
            }
            this.gjf = null;
            this.gjg = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b bvk = bvk();
            bvk.gje = com.baidu.tieba.horizonalList.widget.a.w(i2, i3, i4, i);
            bvk.gjf = groupMetadata;
            bvk.gjg = i5;
            return bvk;
        }

        private static b bvk() {
            b bVar;
            synchronized (gjd) {
                if (gjd.size() > 0) {
                    bVar = gjd.remove(0);
                    bVar.aAd();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            aAd();
            synchronized (gjd) {
                if (gjd.size() < 5) {
                    gjd.add(this);
                }
            }
        }

        public boolean bhk() {
            return this.gjf != null;
        }
    }
}
