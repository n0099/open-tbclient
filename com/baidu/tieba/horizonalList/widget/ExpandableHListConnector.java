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
    private ExpandableListAdapter boP;
    private int boR;
    private int boS = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> boQ = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.boP != null) {
            this.boP.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.boP = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b AI(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.boQ;
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
            if (i > groupMetadata.boU) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.boT) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.boT) {
                return b.a(i, 2, groupMetadata.boV, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.boU) {
                    return b.a(i, 1, groupMetadata.boV, i - (groupMetadata.boT + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.boU) + groupMetadata2.boV;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.boV - (groupMetadata3.boT - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.boQ;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(aVar.bpc, aVar.type, aVar.bpc, aVar.bpd, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (aVar.bpc > groupMetadata.boV) {
                i4 = i + 1;
            } else if (aVar.bpc < groupMetadata.boV) {
                i3 = i - 1;
            } else if (aVar.bpc == groupMetadata.boV) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.boT, aVar.type, aVar.bpc, aVar.bpd, groupMetadata, i);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.boT + aVar.bpd + 1, aVar.type, aVar.bpc, aVar.bpd, groupMetadata, i);
                }
                return null;
            }
        }
        if (aVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((aVar.bpc - groupMetadata2.boV) + groupMetadata2.boU, aVar.type, aVar.bpc, aVar.bpd, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.boT - (groupMetadata3.boV - aVar.bpc), aVar.type, aVar.bpc, aVar.bpd, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.boP.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b AI = AI(i);
        com.baidu.tieba.horizonalList.widget.a aVar = AI.jfx;
        boolean isChildSelectable = aVar.type == 1 ? this.boP.isChildSelectable(aVar.bpc, aVar.bpd) : true;
        AI.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.boP.getGroupCount() + this.boR;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b AI = AI(i);
        if (AI.jfx.type == 2) {
            child = this.boP.getGroup(AI.jfx.bpc);
        } else if (AI.jfx.type == 1) {
            child = this.boP.getChild(AI.jfx.bpc, AI.jfx.bpd);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        AI.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b AI = AI(i);
        long groupId = this.boP.getGroupId(AI.jfx.bpc);
        if (AI.jfx.type == 2) {
            combinedChildId = this.boP.getCombinedGroupId(groupId);
        } else if (AI.jfx.type == 1) {
            combinedChildId = this.boP.getCombinedChildId(groupId, this.boP.getChildId(AI.jfx.bpc, AI.jfx.bpd));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        AI.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b AI = AI(i);
        if (AI.jfx.type == 2) {
            childView = this.boP.getGroupView(AI.jfx.bpc, AI.Oz(), view, viewGroup);
        } else if (AI.jfx.type == 1) {
            childView = this.boP.getChildView(AI.jfx.bpc, AI.jfx.bpd, AI.jfy.boU == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        AI.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b AI = AI(i);
        com.baidu.tieba.horizonalList.widget.a aVar = AI.jfx;
        if (this.boP instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.boP;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.bpc);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.bpc, aVar.bpd);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        AI.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.boP instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.boP;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.boP.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.boQ;
        int size = arrayList.size();
        this.boR = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int f = f(groupMetadata.boW, groupMetadata.boV);
                if (f != groupMetadata.boV) {
                    if (f == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.boV = f;
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
            if (groupMetadata2.boU == -1 || z) {
                childrenCount = this.boP.getChildrenCount(groupMetadata2.boV);
            } else {
                childrenCount = groupMetadata2.boU - groupMetadata2.boT;
            }
            this.boR += childrenCount;
            int i5 = i4 + (groupMetadata2.boV - i3);
            i3 = groupMetadata2.boV;
            groupMetadata2.boT = i5;
            int i6 = childrenCount + i5;
            groupMetadata2.boU = i6;
            i++;
            i4 = i6;
        }
    }

    boolean fh(int i) {
        com.baidu.tieba.horizonalList.widget.a C = com.baidu.tieba.horizonalList.widget.a.C(2, i, -1, -1);
        b a2 = a(C);
        C.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.jfy == null) {
            return false;
        }
        this.boQ.remove(bVar.jfy);
        g(false, false);
        notifyDataSetChanged();
        this.boP.onGroupCollapsed(bVar.jfy.boV);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.jfx.bpc < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.boS != 0 && bVar.jfy == null) {
            if (this.boQ.size() >= this.boS) {
                GroupMetadata groupMetadata = this.boQ.get(0);
                int indexOf = this.boQ.indexOf(groupMetadata);
                fh(groupMetadata.boV);
                if (bVar.bpb > indexOf) {
                    bVar.bpb--;
                }
            }
            GroupMetadata b2 = GroupMetadata.b(-1, -1, bVar.jfx.bpc, this.boP.getGroupId(bVar.jfx.bpc));
            this.boQ.add(bVar.bpb, b2);
            g(false, false);
            notifyDataSetChanged();
            this.boP.onGroupExpanded(b2.boV);
            return true;
        }
        return false;
    }

    ExpandableListAdapter Ow() {
        return this.boP;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter Ow = Ow();
        if (Ow instanceof Filterable) {
            return ((Filterable) Ow).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> Ox() {
        return this.boQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.boP != null) {
            int groupCount = this.boP.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).boV >= groupCount) {
                    return;
                }
            }
            this.boQ = arrayList;
            g(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter Ow = Ow();
        if (Ow != null) {
            return Ow.isEmpty();
        }
        return true;
    }

    int f(long j, int i) {
        int groupCount = this.boP.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter Ow = Ow();
        if (Ow == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (Ow.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.g(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.g(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ab */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.b(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: AJ */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int boT;
        int boU;
        int boV;
        long boW;

        private GroupMetadata() {
        }

        static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.boT = i;
            groupMetadata.boU = i2;
            groupMetadata.boV = i3;
            groupMetadata.boW = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.boV - groupMetadata.boV;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.boT);
            parcel.writeInt(this.boU);
            parcel.writeInt(this.boV);
            parcel.writeLong(this.boW);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> boY = new ArrayList<>(5);
        public int bpb;
        public com.baidu.tieba.horizonalList.widget.a jfx;
        public GroupMetadata jfy;

        private void resetState() {
            if (this.jfx != null) {
                this.jfx.recycle();
                this.jfx = null;
            }
            this.jfy = null;
            this.bpb = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b cCY = cCY();
            cCY.jfx = com.baidu.tieba.horizonalList.widget.a.C(i2, i3, i4, i);
            cCY.jfy = groupMetadata;
            cCY.bpb = i5;
            return cCY;
        }

        private static b cCY() {
            b bVar;
            synchronized (boY) {
                if (boY.size() > 0) {
                    bVar = boY.remove(0);
                    bVar.resetState();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            resetState();
            synchronized (boY) {
                if (boY.size() < 5) {
                    boY.add(this);
                }
            }
        }

        public boolean Oz() {
            return this.jfy != null;
        }
    }
}
