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
    private ExpandableListAdapter bSb;
    private int bSd;
    private int bSe = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> bSc = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.bSb != null) {
            this.bSb.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.bSb = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b iO(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.bSc;
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
            if (i > groupMetadata.bSg) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.bSf) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.bSf) {
                return b.a(i, 2, groupMetadata.bSh, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.bSg) {
                    return b.a(i, 1, groupMetadata.bSh, i - (groupMetadata.bSf + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.bSg) + groupMetadata2.bSh;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.bSh - (groupMetadata3.bSf - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(i iVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.bSc;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(iVar.bSo, iVar.type, iVar.bSo, iVar.bSp, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (iVar.bSo > groupMetadata.bSh) {
                i4 = i + 1;
            } else if (iVar.bSo < groupMetadata.bSh) {
                i3 = i - 1;
            } else if (iVar.bSo == groupMetadata.bSh) {
                if (iVar.type == 2) {
                    return b.a(groupMetadata.bSf, iVar.type, iVar.bSo, iVar.bSp, groupMetadata, i);
                }
                if (iVar.type == 1) {
                    return b.a(groupMetadata.bSf + iVar.bSp + 1, iVar.type, iVar.bSo, iVar.bSp, groupMetadata, i);
                }
                return null;
            }
        }
        if (iVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((iVar.bSo - groupMetadata2.bSh) + groupMetadata2.bSg, iVar.type, iVar.bSo, iVar.bSp, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.bSf - (groupMetadata3.bSh - iVar.bSo), iVar.type, iVar.bSo, iVar.bSp, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.bSb.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b iO = iO(i);
        i iVar = iO.bSl;
        boolean isChildSelectable = iVar.type == 1 ? this.bSb.isChildSelectable(iVar.bSo, iVar.bSp) : true;
        iO.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bSb.getGroupCount() + this.bSd;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b iO = iO(i);
        if (iO.bSl.type == 2) {
            child = this.bSb.getGroup(iO.bSl.bSo);
        } else if (iO.bSl.type == 1) {
            child = this.bSb.getChild(iO.bSl.bSo, iO.bSl.bSp);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        iO.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b iO = iO(i);
        long groupId = this.bSb.getGroupId(iO.bSl.bSo);
        if (iO.bSl.type == 2) {
            combinedChildId = this.bSb.getCombinedGroupId(groupId);
        } else if (iO.bSl.type == 1) {
            combinedChildId = this.bSb.getCombinedChildId(groupId, this.bSb.getChildId(iO.bSl.bSo, iO.bSl.bSp));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        iO.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b iO = iO(i);
        if (iO.bSl.type == 2) {
            childView = this.bSb.getGroupView(iO.bSl.bSo, iO.aaE(), view, viewGroup);
        } else if (iO.bSl.type == 1) {
            childView = this.bSb.getChildView(iO.bSl.bSo, iO.bSl.bSp, iO.bSm.bSg == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        iO.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b iO = iO(i);
        i iVar = iO.bSl;
        if (this.bSb instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bSb;
            if (iVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(iVar.bSo);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(iVar.bSo, iVar.bSp);
            }
        } else if (iVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        iO.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.bSb instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bSb;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.bSb.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.bSc;
        int size = arrayList.size();
        this.bSd = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int a2 = a(groupMetadata.bSi, groupMetadata.bSh);
                if (a2 != groupMetadata.bSh) {
                    if (a2 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.bSh = a2;
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
            if (groupMetadata2.bSg == -1 || z) {
                childrenCount = this.bSb.getChildrenCount(groupMetadata2.bSh);
            } else {
                childrenCount = groupMetadata2.bSg - groupMetadata2.bSf;
            }
            this.bSd += childrenCount;
            int i5 = i4 + (groupMetadata2.bSh - i3);
            i3 = groupMetadata2.bSh;
            groupMetadata2.bSf = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.bSg = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        i h = i.h(2, i, -1, -1);
        b a2 = a(h);
        h.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.bSm == null) {
            return false;
        }
        this.bSc.remove(bVar.bSm);
        l(false, false);
        notifyDataSetChanged();
        this.bSb.onGroupCollapsed(bVar.bSm.bSh);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.bSl.bSo < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.bSe != 0 && bVar.bSm == null) {
            if (this.bSc.size() >= this.bSe) {
                GroupMetadata groupMetadata = this.bSc.get(0);
                int indexOf = this.bSc.indexOf(groupMetadata);
                collapseGroup(groupMetadata.bSh);
                if (bVar.bSn > indexOf) {
                    bVar.bSn--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.bSl.bSo, this.bSb.getGroupId(bVar.bSl.bSo));
            this.bSc.add(bVar.bSn, a2);
            l(false, false);
            notifyDataSetChanged();
            this.bSb.onGroupExpanded(a2.bSh);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aaA() {
        return this.bSb;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aaA = aaA();
        if (aaA instanceof Filterable) {
            return ((Filterable) aaA).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aaB() {
        return this.bSc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.bSb != null) {
            int groupCount = this.bSb.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).bSh >= groupCount) {
                    return;
                }
            }
            this.bSc = arrayList;
            l(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aaA = aaA();
        if (aaA != null) {
            return aaA.isEmpty();
        }
        return true;
    }

    int a(long j, int i) {
        int groupCount = this.bSb.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aaA = aaA();
        if (aaA == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aaA.getGroupId(i3) != j) {
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
        int bSf;
        int bSg;
        int bSh;
        long bSi;

        private GroupMetadata() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.bSf = i;
            groupMetadata.bSg = i2;
            groupMetadata.bSh = i3;
            groupMetadata.bSi = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.bSh - groupMetadata.bSh;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.bSf);
            parcel.writeInt(this.bSg);
            parcel.writeInt(this.bSh);
            parcel.writeLong(this.bSi);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> bSk = new ArrayList<>(5);
        public i bSl;
        public GroupMetadata bSm;
        public int bSn;

        private void aaC() {
            if (this.bSl != null) {
                this.bSl.recycle();
                this.bSl = null;
            }
            this.bSm = null;
            this.bSn = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aaD = aaD();
            aaD.bSl = i.h(i2, i3, i4, i);
            aaD.bSm = groupMetadata;
            aaD.bSn = i5;
            return aaD;
        }

        private static b aaD() {
            b bVar;
            synchronized (bSk) {
                if (bSk.size() > 0) {
                    bVar = bSk.remove(0);
                    bVar.aaC();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            aaC();
            synchronized (bSk) {
                if (bSk.size() < 5) {
                    bSk.add(this);
                }
            }
        }

        public boolean aaE() {
            return this.bSm != null;
        }
    }
}
