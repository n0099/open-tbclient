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
    private ExpandableListAdapter bSC;
    private int bSE;
    private int bSF = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> bSD = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.bSC != null) {
            this.bSC.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.bSC = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b ir(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.bSD;
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
            if (i > groupMetadata.bSH) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.bSG) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.bSG) {
                return b.a(i, 2, groupMetadata.bSI, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.bSH) {
                    return b.a(i, 1, groupMetadata.bSI, i - (groupMetadata.bSG + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.bSH) + groupMetadata2.bSI;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.bSI - (groupMetadata3.bSG - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(i iVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.bSD;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(iVar.bSP, iVar.type, iVar.bSP, iVar.bSQ, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (iVar.bSP > groupMetadata.bSI) {
                i4 = i + 1;
            } else if (iVar.bSP < groupMetadata.bSI) {
                i3 = i - 1;
            } else if (iVar.bSP == groupMetadata.bSI) {
                if (iVar.type == 2) {
                    return b.a(groupMetadata.bSG, iVar.type, iVar.bSP, iVar.bSQ, groupMetadata, i);
                }
                if (iVar.type == 1) {
                    return b.a(groupMetadata.bSG + iVar.bSQ + 1, iVar.type, iVar.bSP, iVar.bSQ, groupMetadata, i);
                }
                return null;
            }
        }
        if (iVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((iVar.bSP - groupMetadata2.bSI) + groupMetadata2.bSH, iVar.type, iVar.bSP, iVar.bSQ, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.bSG - (groupMetadata3.bSI - iVar.bSP), iVar.type, iVar.bSP, iVar.bSQ, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.bSC.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b ir = ir(i);
        i iVar = ir.bSM;
        boolean isChildSelectable = iVar.type == 1 ? this.bSC.isChildSelectable(iVar.bSP, iVar.bSQ) : true;
        ir.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bSC.getGroupCount() + this.bSE;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b ir = ir(i);
        if (ir.bSM.type == 2) {
            child = this.bSC.getGroup(ir.bSM.bSP);
        } else if (ir.bSM.type == 1) {
            child = this.bSC.getChild(ir.bSM.bSP, ir.bSM.bSQ);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ir.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b ir = ir(i);
        long groupId = this.bSC.getGroupId(ir.bSM.bSP);
        if (ir.bSM.type == 2) {
            combinedChildId = this.bSC.getCombinedGroupId(groupId);
        } else if (ir.bSM.type == 1) {
            combinedChildId = this.bSC.getCombinedChildId(groupId, this.bSC.getChildId(ir.bSM.bSP, ir.bSM.bSQ));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ir.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b ir = ir(i);
        if (ir.bSM.type == 2) {
            childView = this.bSC.getGroupView(ir.bSM.bSP, ir.aaD(), view, viewGroup);
        } else if (ir.bSM.type == 1) {
            childView = this.bSC.getChildView(ir.bSM.bSP, ir.bSM.bSQ, ir.bSN.bSH == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        ir.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b ir = ir(i);
        i iVar = ir.bSM;
        if (this.bSC instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bSC;
            if (iVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(iVar.bSP);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(iVar.bSP, iVar.bSQ);
            }
        } else if (iVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        ir.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.bSC instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bSC;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.bSC.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.bSD;
        int size = arrayList.size();
        this.bSE = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int a2 = a(groupMetadata.bSJ, groupMetadata.bSI);
                if (a2 != groupMetadata.bSI) {
                    if (a2 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.bSI = a2;
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
            if (groupMetadata2.bSH == -1 || z) {
                childrenCount = this.bSC.getChildrenCount(groupMetadata2.bSI);
            } else {
                childrenCount = groupMetadata2.bSH - groupMetadata2.bSG;
            }
            this.bSE += childrenCount;
            int i5 = i4 + (groupMetadata2.bSI - i3);
            i3 = groupMetadata2.bSI;
            groupMetadata2.bSG = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.bSH = i6;
            i++;
            i4 = i6;
        }
    }

    boolean collapseGroup(int i) {
        i i2 = i.i(2, i, -1, -1);
        b a2 = a(i2);
        i2.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.bSN == null) {
            return false;
        }
        this.bSD.remove(bVar.bSN);
        k(false, false);
        notifyDataSetChanged();
        this.bSC.onGroupCollapsed(bVar.bSN.bSI);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.bSM.bSP < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.bSF != 0 && bVar.bSN == null) {
            if (this.bSD.size() >= this.bSF) {
                GroupMetadata groupMetadata = this.bSD.get(0);
                int indexOf = this.bSD.indexOf(groupMetadata);
                collapseGroup(groupMetadata.bSI);
                if (bVar.bSO > indexOf) {
                    bVar.bSO--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.bSM.bSP, this.bSC.getGroupId(bVar.bSM.bSP));
            this.bSD.add(bVar.bSO, a2);
            k(false, false);
            notifyDataSetChanged();
            this.bSC.onGroupExpanded(a2.bSI);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aaz() {
        return this.bSC;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aaz = aaz();
        if (aaz instanceof Filterable) {
            return ((Filterable) aaz).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aaA() {
        return this.bSD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.bSC != null) {
            int groupCount = this.bSC.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).bSI >= groupCount) {
                    return;
                }
            }
            this.bSD = arrayList;
            k(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aaz = aaz();
        if (aaz != null) {
            return aaz.isEmpty();
        }
        return true;
    }

    int a(long j, int i) {
        int groupCount = this.bSC.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aaz = aaz();
        if (aaz == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aaz.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.k(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.k(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new h();
        int bSG;
        int bSH;
        int bSI;
        long bSJ;

        private GroupMetadata() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.bSG = i;
            groupMetadata.bSH = i2;
            groupMetadata.bSI = i3;
            groupMetadata.bSJ = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.bSI - groupMetadata.bSI;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.bSG);
            parcel.writeInt(this.bSH);
            parcel.writeInt(this.bSI);
            parcel.writeLong(this.bSJ);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> bSL = new ArrayList<>(5);
        public i bSM;
        public GroupMetadata bSN;
        public int bSO;

        private void aaB() {
            if (this.bSM != null) {
                this.bSM.recycle();
                this.bSM = null;
            }
            this.bSN = null;
            this.bSO = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aaC = aaC();
            aaC.bSM = i.i(i2, i3, i4, i);
            aaC.bSN = groupMetadata;
            aaC.bSO = i5;
            return aaC;
        }

        private static b aaC() {
            b bVar;
            synchronized (bSL) {
                if (bSL.size() > 0) {
                    bVar = bSL.remove(0);
                    bVar.aaB();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            aaB();
            synchronized (bSL) {
                if (bSL.size() < 5) {
                    bSL.add(this);
                }
            }
        }

        public boolean aaD() {
            return this.bSN != null;
        }
    }
}
