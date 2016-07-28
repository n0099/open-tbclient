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
    private ExpandableListAdapter czr;
    private int czt;
    private int czu = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> czs = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.czr != null) {
            this.czr.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.czr = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b jV(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.czs;
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
            if (i > groupMetadata.czw) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.czv) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.czv) {
                return b.a(i, 2, groupMetadata.czx, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.czw) {
                    return b.a(i, 1, groupMetadata.czx, i - (groupMetadata.czv + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.czw) + groupMetadata2.czx;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.czx - (groupMetadata3.czv - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(i iVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.czs;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(iVar.czE, iVar.type, iVar.czE, iVar.czF, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (iVar.czE > groupMetadata.czx) {
                i4 = i + 1;
            } else if (iVar.czE < groupMetadata.czx) {
                i3 = i - 1;
            } else if (iVar.czE == groupMetadata.czx) {
                if (iVar.type == 2) {
                    return b.a(groupMetadata.czv, iVar.type, iVar.czE, iVar.czF, groupMetadata, i);
                }
                if (iVar.type == 1) {
                    return b.a(groupMetadata.czv + iVar.czF + 1, iVar.type, iVar.czE, iVar.czF, groupMetadata, i);
                }
                return null;
            }
        }
        if (iVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((iVar.czE - groupMetadata2.czx) + groupMetadata2.czw, iVar.type, iVar.czE, iVar.czF, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.czv - (groupMetadata3.czx - iVar.czE), iVar.type, iVar.czE, iVar.czF, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.czr.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b jV = jV(i);
        i iVar = jV.czB;
        boolean isChildSelectable = iVar.type == 1 ? this.czr.isChildSelectable(iVar.czE, iVar.czF) : true;
        jV.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.czr.getGroupCount() + this.czt;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b jV = jV(i);
        if (jV.czB.type == 2) {
            child = this.czr.getGroup(jV.czB.czE);
        } else if (jV.czB.type == 1) {
            child = this.czr.getChild(jV.czB.czE, jV.czB.czF);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        jV.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b jV = jV(i);
        long groupId = this.czr.getGroupId(jV.czB.czE);
        if (jV.czB.type == 2) {
            combinedChildId = this.czr.getCombinedGroupId(groupId);
        } else if (jV.czB.type == 1) {
            combinedChildId = this.czr.getCombinedChildId(groupId, this.czr.getChildId(jV.czB.czE, jV.czB.czF));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        jV.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b jV = jV(i);
        if (jV.czB.type == 2) {
            childView = this.czr.getGroupView(jV.czB.czE, jV.ajk(), view, viewGroup);
        } else if (jV.czB.type == 1) {
            childView = this.czr.getChildView(jV.czB.czE, jV.czB.czF, jV.czC.czw == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        jV.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b jV = jV(i);
        i iVar = jV.czB;
        if (this.czr instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.czr;
            if (iVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(iVar.czE);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(iVar.czE, iVar.czF);
            }
        } else if (iVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        jV.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.czr instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.czr;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.czr.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.czs;
        int size = arrayList.size();
        this.czt = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int h = h(groupMetadata.czy, groupMetadata.czx);
                if (h != groupMetadata.czx) {
                    if (h == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.czx = h;
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
            if (groupMetadata2.czw == -1 || z) {
                childrenCount = this.czr.getChildrenCount(groupMetadata2.czx);
            } else {
                childrenCount = groupMetadata2.czw - groupMetadata2.czv;
            }
            this.czt += childrenCount;
            int i5 = i4 + (groupMetadata2.czx - i3);
            i3 = groupMetadata2.czx;
            groupMetadata2.czv = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.czw = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        i k = i.k(2, i, -1, -1);
        b a2 = a(k);
        k.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.czC == null) {
            return false;
        }
        this.czs.remove(bVar.czC);
        l(false, false);
        notifyDataSetChanged();
        this.czr.onGroupCollapsed(bVar.czC.czx);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.czB.czE < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.czu != 0 && bVar.czC == null) {
            if (this.czs.size() >= this.czu) {
                GroupMetadata groupMetadata = this.czs.get(0);
                int indexOf = this.czs.indexOf(groupMetadata);
                collapseGroup(groupMetadata.czx);
                if (bVar.czD > indexOf) {
                    bVar.czD--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.czB.czE, this.czr.getGroupId(bVar.czB.czE));
            this.czs.add(bVar.czD, a2);
            l(false, false);
            notifyDataSetChanged();
            this.czr.onGroupExpanded(a2.czx);
            return true;
        }
        return false;
    }

    ExpandableListAdapter ajg() {
        return this.czr;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter ajg = ajg();
        if (ajg instanceof Filterable) {
            return ((Filterable) ajg).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> ajh() {
        return this.czs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.czr != null) {
            int groupCount = this.czr.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).czx >= groupCount) {
                    return;
                }
            }
            this.czs = arrayList;
            l(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter ajg = ajg();
        if (ajg != null) {
            return ajg.isEmpty();
        }
        return true;
    }

    int h(long j, int i) {
        int groupCount = this.czr.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter ajg = ajg();
        if (ajg == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (ajg.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.l(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.l(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new h();
        int czv;
        int czw;
        int czx;
        long czy;

        private GroupMetadata() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.czv = i;
            groupMetadata.czw = i2;
            groupMetadata.czx = i3;
            groupMetadata.czy = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.czx - groupMetadata.czx;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.czv);
            parcel.writeInt(this.czw);
            parcel.writeInt(this.czx);
            parcel.writeLong(this.czy);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> czA = new ArrayList<>(5);
        public i czB;
        public GroupMetadata czC;
        public int czD;

        private void aji() {
            if (this.czB != null) {
                this.czB.recycle();
                this.czB = null;
            }
            this.czC = null;
            this.czD = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b ajj = ajj();
            ajj.czB = i.k(i2, i3, i4, i);
            ajj.czC = groupMetadata;
            ajj.czD = i5;
            return ajj;
        }

        private static b ajj() {
            b bVar;
            synchronized (czA) {
                if (czA.size() > 0) {
                    bVar = czA.remove(0);
                    bVar.aji();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            aji();
            synchronized (czA) {
                if (czA.size() < 5) {
                    czA.add(this);
                }
            }
        }

        public boolean ajk() {
            return this.czC != null;
        }
    }
}
