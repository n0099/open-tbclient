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
    private ExpandableListAdapter cwk;
    private int cwm;
    private int cwn = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> cwl = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.cwk != null) {
            this.cwk.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.cwk = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b jV(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.cwl;
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
            if (i > groupMetadata.cwp) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.cwo) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.cwo) {
                return b.a(i, 2, groupMetadata.cwq, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.cwp) {
                    return b.a(i, 1, groupMetadata.cwq, i - (groupMetadata.cwo + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.cwp) + groupMetadata2.cwq;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.cwq - (groupMetadata3.cwo - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(i iVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cwl;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(iVar.cwx, iVar.type, iVar.cwx, iVar.cwy, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (iVar.cwx > groupMetadata.cwq) {
                i4 = i + 1;
            } else if (iVar.cwx < groupMetadata.cwq) {
                i3 = i - 1;
            } else if (iVar.cwx == groupMetadata.cwq) {
                if (iVar.type == 2) {
                    return b.a(groupMetadata.cwo, iVar.type, iVar.cwx, iVar.cwy, groupMetadata, i);
                }
                if (iVar.type == 1) {
                    return b.a(groupMetadata.cwo + iVar.cwy + 1, iVar.type, iVar.cwx, iVar.cwy, groupMetadata, i);
                }
                return null;
            }
        }
        if (iVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((iVar.cwx - groupMetadata2.cwq) + groupMetadata2.cwp, iVar.type, iVar.cwx, iVar.cwy, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.cwo - (groupMetadata3.cwq - iVar.cwx), iVar.type, iVar.cwx, iVar.cwy, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.cwk.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b jV = jV(i);
        i iVar = jV.cwu;
        boolean isChildSelectable = iVar.type == 1 ? this.cwk.isChildSelectable(iVar.cwx, iVar.cwy) : true;
        jV.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cwk.getGroupCount() + this.cwm;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b jV = jV(i);
        if (jV.cwu.type == 2) {
            child = this.cwk.getGroup(jV.cwu.cwx);
        } else if (jV.cwu.type == 1) {
            child = this.cwk.getChild(jV.cwu.cwx, jV.cwu.cwy);
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
        long groupId = this.cwk.getGroupId(jV.cwu.cwx);
        if (jV.cwu.type == 2) {
            combinedChildId = this.cwk.getCombinedGroupId(groupId);
        } else if (jV.cwu.type == 1) {
            combinedChildId = this.cwk.getCombinedChildId(groupId, this.cwk.getChildId(jV.cwu.cwx, jV.cwu.cwy));
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
        if (jV.cwu.type == 2) {
            childView = this.cwk.getGroupView(jV.cwu.cwx, jV.akI(), view, viewGroup);
        } else if (jV.cwu.type == 1) {
            childView = this.cwk.getChildView(jV.cwu.cwx, jV.cwu.cwy, jV.cwv.cwp == i, view, viewGroup);
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
        i iVar = jV.cwu;
        if (this.cwk instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cwk;
            if (iVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(iVar.cwx);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(iVar.cwx, iVar.cwy);
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
        if (this.cwk instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cwk;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.cwk.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cwl;
        int size = arrayList.size();
        this.cwm = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int h = h(groupMetadata.cwr, groupMetadata.cwq);
                if (h != groupMetadata.cwq) {
                    if (h == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.cwq = h;
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
            if (groupMetadata2.cwp == -1 || z) {
                childrenCount = this.cwk.getChildrenCount(groupMetadata2.cwq);
            } else {
                childrenCount = groupMetadata2.cwp - groupMetadata2.cwo;
            }
            this.cwm += childrenCount;
            int i5 = i4 + (groupMetadata2.cwq - i3);
            i3 = groupMetadata2.cwq;
            groupMetadata2.cwo = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.cwp = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        i l = i.l(2, i, -1, -1);
        b a2 = a(l);
        l.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.cwv == null) {
            return false;
        }
        this.cwl.remove(bVar.cwv);
        r(false, false);
        notifyDataSetChanged();
        this.cwk.onGroupCollapsed(bVar.cwv.cwq);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.cwu.cwx < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.cwn != 0 && bVar.cwv == null) {
            if (this.cwl.size() >= this.cwn) {
                GroupMetadata groupMetadata = this.cwl.get(0);
                int indexOf = this.cwl.indexOf(groupMetadata);
                collapseGroup(groupMetadata.cwq);
                if (bVar.cww > indexOf) {
                    bVar.cww--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.cwu.cwx, this.cwk.getGroupId(bVar.cwu.cwx));
            this.cwl.add(bVar.cww, a2);
            r(false, false);
            notifyDataSetChanged();
            this.cwk.onGroupExpanded(a2.cwq);
            return true;
        }
        return false;
    }

    ExpandableListAdapter akE() {
        return this.cwk;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter akE = akE();
        if (akE instanceof Filterable) {
            return ((Filterable) akE).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> akF() {
        return this.cwl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.cwk != null) {
            int groupCount = this.cwk.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).cwq >= groupCount) {
                    return;
                }
            }
            this.cwl = arrayList;
            r(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter akE = akE();
        if (akE != null) {
            return akE.isEmpty();
        }
        return true;
    }

    int h(long j, int i) {
        int groupCount = this.cwk.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter akE = akE();
        if (akE == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (akE.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.r(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.r(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new h();
        int cwo;
        int cwp;
        int cwq;
        long cwr;

        private GroupMetadata() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.cwo = i;
            groupMetadata.cwp = i2;
            groupMetadata.cwq = i3;
            groupMetadata.cwr = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.cwq - groupMetadata.cwq;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.cwo);
            parcel.writeInt(this.cwp);
            parcel.writeInt(this.cwq);
            parcel.writeLong(this.cwr);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> cwt = new ArrayList<>(5);
        public i cwu;
        public GroupMetadata cwv;
        public int cww;

        private void akG() {
            if (this.cwu != null) {
                this.cwu.recycle();
                this.cwu = null;
            }
            this.cwv = null;
            this.cww = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b akH = akH();
            akH.cwu = i.l(i2, i3, i4, i);
            akH.cwv = groupMetadata;
            akH.cww = i5;
            return akH;
        }

        private static b akH() {
            b bVar;
            synchronized (cwt) {
                if (cwt.size() > 0) {
                    bVar = cwt.remove(0);
                    bVar.akG();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            akG();
            synchronized (cwt) {
                if (cwt.size() < 5) {
                    cwt.add(this);
                }
            }
        }

        public boolean akI() {
            return this.cwv != null;
        }
    }
}
