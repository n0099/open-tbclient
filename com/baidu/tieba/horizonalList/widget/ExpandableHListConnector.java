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
    private ExpandableListAdapter giR;
    private int giT;
    private int giU = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> giS = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.giR != null) {
            this.giR.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.giR = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b tT(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.giS;
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
            if (i > groupMetadata.giW) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.giV) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.giV) {
                return b.a(i, 2, groupMetadata.giX, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.giW) {
                    return b.a(i, 1, groupMetadata.giX, i - (groupMetadata.giV + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.giW) + groupMetadata2.giX;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.giX - (groupMetadata3.giV - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.giS;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.gje, aVar.type, aVar.gje, aVar.gjf, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.gje > groupMetadata.giX) {
                i4 = i + 1;
            } else if (aVar.gje < groupMetadata.giX) {
                i3 = i - 1;
            } else if (aVar.gje == groupMetadata.giX) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.giV, aVar.type, aVar.gje, aVar.gjf, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.giV + aVar.gjf + 1, aVar.type, aVar.gje, aVar.gjf, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.gje - groupMetadata2.giX) + groupMetadata2.giW, aVar.type, aVar.gje, aVar.gjf, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.giV - (groupMetadata3.giX - aVar.gje), aVar.type, aVar.gje, aVar.gjf, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.giR.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b tT = tT(i);
        com.baidu.tieba.horizonalList.widget.a aVar = tT.gjb;
        boolean isChildSelectable = aVar.type == 1 ? this.giR.isChildSelectable(aVar.gje, aVar.gjf) : true;
        tT.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.giR.getGroupCount() + this.giT;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b tT = tT(i);
        if (tT.gjb.type == 2) {
            child = this.giR.getGroup(tT.gjb.gje);
        } else if (tT.gjb.type == 1) {
            child = this.giR.getChild(tT.gjb.gje, tT.gjb.gjf);
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
        long groupId = this.giR.getGroupId(tT.gjb.gje);
        if (tT.gjb.type == 2) {
            combinedChildId = this.giR.getCombinedGroupId(groupId);
        } else if (tT.gjb.type == 1) {
            combinedChildId = this.giR.getCombinedChildId(groupId, this.giR.getChildId(tT.gjb.gje, tT.gjb.gjf));
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
        if (tT.gjb.type == 2) {
            childView = this.giR.getGroupView(tT.gjb.gje, tT.bhh(), view, viewGroup);
        } else if (tT.gjb.type == 1) {
            childView = this.giR.getChildView(tT.gjb.gje, tT.gjb.gjf, tT.gjc.giW == i, view, viewGroup);
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
        com.baidu.tieba.horizonalList.widget.a aVar = tT.gjb;
        if (this.giR instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.giR;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.gje);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.gje, aVar.gjf);
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
        if (this.giR instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.giR;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.giR.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.giS;
        int size = arrayList.size();
        this.giT = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int o = o(groupMetadata.giY, groupMetadata.giX);
                if (o != groupMetadata.giX) {
                    if (o == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.giX = o;
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
            if (groupMetadata2.giW == -1 || z) {
                childrenCount = this.giR.getChildrenCount(groupMetadata2.giX);
            } else {
                childrenCount = groupMetadata2.giW - groupMetadata2.giV;
            }
            this.giT += childrenCount;
            int i5 = i4 + (groupMetadata2.giX - i3);
            i3 = groupMetadata2.giX;
            groupMetadata2.giV = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.giW = i6;
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
        if (bVar.gjc == null) {
            return false;
        }
        this.giS.remove(bVar.gjc);
        N(false, false);
        notifyDataSetChanged();
        this.giR.onGroupCollapsed(bVar.gjc.giX);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.gjb.gje < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.giU != 0 && bVar.gjc == null) {
            if (this.giS.size() >= this.giU) {
                GroupMetadata groupMetadata = this.giS.get(0);
                int indexOf = this.giS.indexOf(groupMetadata);
                collapseGroup(groupMetadata.giX);
                if (bVar.gjd > indexOf) {
                    bVar.gjd--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.gjb.gje, this.giR.getGroupId(bVar.gjb.gje));
            this.giS.add(bVar.gjd, b2);
            N(false, false);
            notifyDataSetChanged();
            this.giR.onGroupExpanded(b2.giX);
            return true;
        }
        return false;
    }

    ExpandableListAdapter bve() {
        return this.giR;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter bve = bve();
        if (bve instanceof Filterable) {
            return ((Filterable) bve).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> bvf() {
        return this.giS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void af(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.giR != null) {
            int groupCount = this.giR.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).giX >= groupCount) {
                    return;
                }
            }
            this.giS = arrayList;
            N(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter bve = bve();
        if (bve != null) {
            return bve.isEmpty();
        }
        return true;
    }

    int o(long j, int i) {
        int groupCount = this.giR.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter bve = bve();
        if (bve == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (bve.getGroupId(i3) != j) {
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
        int giV;
        int giW;
        int giX;
        long giY;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.giV = i;
            groupMetadata.giW = i2;
            groupMetadata.giX = i3;
            groupMetadata.giY = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.giX - groupMetadata.giX;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.giV);
            parcel.writeInt(this.giW);
            parcel.writeInt(this.giX);
            parcel.writeLong(this.giY);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> gja = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.a gjb;
        public GroupMetadata gjc;
        public int gjd;

        private void aAa() {
            if (this.gjb != null) {
                this.gjb.recycle();
                this.gjb = null;
            }
            this.gjc = null;
            this.gjd = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b bvg = bvg();
            bvg.gjb = com.baidu.tieba.horizonalList.widget.a.w(i2, i3, i4, i);
            bvg.gjc = groupMetadata;
            bvg.gjd = i5;
            return bvg;
        }

        private static b bvg() {
            b bVar;
            synchronized (gja) {
                if (gja.size() > 0) {
                    bVar = gja.remove(0);
                    bVar.aAa();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            aAa();
            synchronized (gja) {
                if (gja.size() < 5) {
                    gja.add(this);
                }
            }
        }

        public boolean bhh() {
            return this.gjc != null;
        }
    }
}
