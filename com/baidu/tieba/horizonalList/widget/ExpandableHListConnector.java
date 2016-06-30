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
    private ExpandableListAdapter cwC;
    private int cwE;
    private int cwF = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> cwD = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.cwC != null) {
            this.cwC.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.cwC = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b jP(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.cwD;
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
            if (i > groupMetadata.cwH) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.cwG) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.cwG) {
                return b.a(i, 2, groupMetadata.cwI, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.cwH) {
                    return b.a(i, 1, groupMetadata.cwI, i - (groupMetadata.cwG + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.cwH) + groupMetadata2.cwI;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.cwI - (groupMetadata3.cwG - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(i iVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cwD;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(iVar.cwP, iVar.type, iVar.cwP, iVar.cwQ, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (iVar.cwP > groupMetadata.cwI) {
                i4 = i + 1;
            } else if (iVar.cwP < groupMetadata.cwI) {
                i3 = i - 1;
            } else if (iVar.cwP == groupMetadata.cwI) {
                if (iVar.type == 2) {
                    return b.a(groupMetadata.cwG, iVar.type, iVar.cwP, iVar.cwQ, groupMetadata, i);
                }
                if (iVar.type == 1) {
                    return b.a(groupMetadata.cwG + iVar.cwQ + 1, iVar.type, iVar.cwP, iVar.cwQ, groupMetadata, i);
                }
                return null;
            }
        }
        if (iVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((iVar.cwP - groupMetadata2.cwI) + groupMetadata2.cwH, iVar.type, iVar.cwP, iVar.cwQ, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.cwG - (groupMetadata3.cwI - iVar.cwP), iVar.type, iVar.cwP, iVar.cwQ, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.cwC.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b jP = jP(i);
        i iVar = jP.cwM;
        boolean isChildSelectable = iVar.type == 1 ? this.cwC.isChildSelectable(iVar.cwP, iVar.cwQ) : true;
        jP.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.cwC.getGroupCount() + this.cwE;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b jP = jP(i);
        if (jP.cwM.type == 2) {
            child = this.cwC.getGroup(jP.cwM.cwP);
        } else if (jP.cwM.type == 1) {
            child = this.cwC.getChild(jP.cwM.cwP, jP.cwM.cwQ);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        jP.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b jP = jP(i);
        long groupId = this.cwC.getGroupId(jP.cwM.cwP);
        if (jP.cwM.type == 2) {
            combinedChildId = this.cwC.getCombinedGroupId(groupId);
        } else if (jP.cwM.type == 1) {
            combinedChildId = this.cwC.getCombinedChildId(groupId, this.cwC.getChildId(jP.cwM.cwP, jP.cwM.cwQ));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        jP.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b jP = jP(i);
        if (jP.cwM.type == 2) {
            childView = this.cwC.getGroupView(jP.cwM.cwP, jP.aiA(), view, viewGroup);
        } else if (jP.cwM.type == 1) {
            childView = this.cwC.getChildView(jP.cwM.cwP, jP.cwM.cwQ, jP.cwN.cwH == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        jP.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b jP = jP(i);
        i iVar = jP.cwM;
        if (this.cwC instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cwC;
            if (iVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(iVar.cwP);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(iVar.cwP, iVar.cwQ);
            }
        } else if (iVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        jP.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.cwC instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.cwC;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.cwC.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.cwD;
        int size = arrayList.size();
        this.cwE = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int g = g(groupMetadata.cwJ, groupMetadata.cwI);
                if (g != groupMetadata.cwI) {
                    if (g == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.cwI = g;
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
            if (groupMetadata2.cwH == -1 || z) {
                childrenCount = this.cwC.getChildrenCount(groupMetadata2.cwI);
            } else {
                childrenCount = groupMetadata2.cwH - groupMetadata2.cwG;
            }
            this.cwE += childrenCount;
            int i5 = i4 + (groupMetadata2.cwI - i3);
            i3 = groupMetadata2.cwI;
            groupMetadata2.cwG = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.cwH = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        i j = i.j(2, i, -1, -1);
        b a2 = a(j);
        j.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.cwN == null) {
            return false;
        }
        this.cwD.remove(bVar.cwN);
        l(false, false);
        notifyDataSetChanged();
        this.cwC.onGroupCollapsed(bVar.cwN.cwI);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.cwM.cwP < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.cwF != 0 && bVar.cwN == null) {
            if (this.cwD.size() >= this.cwF) {
                GroupMetadata groupMetadata = this.cwD.get(0);
                int indexOf = this.cwD.indexOf(groupMetadata);
                collapseGroup(groupMetadata.cwI);
                if (bVar.cwO > indexOf) {
                    bVar.cwO--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.cwM.cwP, this.cwC.getGroupId(bVar.cwM.cwP));
            this.cwD.add(bVar.cwO, a2);
            l(false, false);
            notifyDataSetChanged();
            this.cwC.onGroupExpanded(a2.cwI);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aiw() {
        return this.cwC;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aiw = aiw();
        if (aiw instanceof Filterable) {
            return ((Filterable) aiw).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aix() {
        return this.cwD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.cwC != null) {
            int groupCount = this.cwC.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).cwI >= groupCount) {
                    return;
                }
            }
            this.cwD = arrayList;
            l(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aiw = aiw();
        if (aiw != null) {
            return aiw.isEmpty();
        }
        return true;
    }

    int g(long j, int i) {
        int groupCount = this.cwC.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aiw = aiw();
        if (aiw == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aiw.getGroupId(i3) != j) {
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
        int cwG;
        int cwH;
        int cwI;
        long cwJ;

        private GroupMetadata() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.cwG = i;
            groupMetadata.cwH = i2;
            groupMetadata.cwI = i3;
            groupMetadata.cwJ = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.cwI - groupMetadata.cwI;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.cwG);
            parcel.writeInt(this.cwH);
            parcel.writeInt(this.cwI);
            parcel.writeLong(this.cwJ);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> cwL = new ArrayList<>(5);
        public i cwM;
        public GroupMetadata cwN;
        public int cwO;

        private void aiy() {
            if (this.cwM != null) {
                this.cwM.recycle();
                this.cwM = null;
            }
            this.cwN = null;
            this.cwO = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aiz = aiz();
            aiz.cwM = i.j(i2, i3, i4, i);
            aiz.cwN = groupMetadata;
            aiz.cwO = i5;
            return aiz;
        }

        private static b aiz() {
            b bVar;
            synchronized (cwL) {
                if (cwL.size() > 0) {
                    bVar = cwL.remove(0);
                    bVar.aiy();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            aiy();
            synchronized (cwL) {
                if (cwL.size() < 5) {
                    cwL.add(this);
                }
            }
        }

        public boolean aiA() {
            return this.cwN != null;
        }
    }
}
