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
import androidx.appcompat.widget.ActivityChooserView;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes.dex */
class ExpandableHListConnector extends BaseAdapter implements Filterable {
    private ExpandableListAdapter bJg;
    private int bJi;
    private int bJj = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> bJh = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.bJg != null) {
            this.bJg.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.bJg = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b Dv(int i) {
        int i2;
        int i3;
        ArrayList<GroupMetadata> arrayList = this.bJh;
        int size = arrayList.size();
        int i4 = size - 1;
        if (size == 0) {
            return b.a(i, 2, i, -1, null, 0);
        }
        int i5 = 0;
        int i6 = 0;
        while (i6 <= i4) {
            int i7 = ((i4 - i6) / 2) + i6;
            GroupMetadata groupMetadata = arrayList.get(i7);
            if (i > groupMetadata.bJl) {
                i6 = i7 + 1;
                i5 = i7;
            } else if (i < groupMetadata.bJk) {
                i4 = i7 - 1;
                i5 = i7;
            } else if (i == groupMetadata.bJk) {
                return b.a(i, 2, groupMetadata.bJm, -1, groupMetadata, i7);
            } else {
                if (i <= groupMetadata.bJl) {
                    return b.a(i, 1, groupMetadata.bJm, i - (groupMetadata.bJk + 1), groupMetadata, i7);
                }
                i5 = i7;
            }
        }
        if (i6 > i5) {
            GroupMetadata groupMetadata2 = arrayList.get(i6 - 1);
            i3 = (i - groupMetadata2.bJl) + groupMetadata2.bJm;
            i2 = i6;
        } else if (i4 < i5) {
            i2 = i4 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.bJm - (groupMetadata3.bJk - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.a aVar) {
        ArrayList<GroupMetadata> arrayList = this.bJh;
        int size = arrayList.size();
        int i = size - 1;
        if (size == 0) {
            return b.a(aVar.bJt, aVar.type, aVar.bJt, aVar.bJu, null, 0);
        }
        int i2 = 0;
        int i3 = 0;
        while (i3 <= i) {
            int i4 = ((i - i3) / 2) + i3;
            GroupMetadata groupMetadata = arrayList.get(i4);
            if (aVar.bJt > groupMetadata.bJm) {
                i2 = i4;
                i3 = i4 + 1;
            } else if (aVar.bJt < groupMetadata.bJm) {
                i = i4 - 1;
                i2 = i4;
            } else if (aVar.bJt == groupMetadata.bJm) {
                if (aVar.type == 2) {
                    return b.a(groupMetadata.bJk, aVar.type, aVar.bJt, aVar.bJu, groupMetadata, i4);
                }
                if (aVar.type == 1) {
                    return b.a(groupMetadata.bJk + aVar.bJu + 1, aVar.type, aVar.bJt, aVar.bJu, groupMetadata, i4);
                }
                return null;
            } else {
                i2 = i4;
            }
        }
        if (aVar.type == 2) {
            if (i3 > i2) {
                GroupMetadata groupMetadata2 = arrayList.get(i3 - 1);
                return b.a((aVar.bJt - groupMetadata2.bJm) + groupMetadata2.bJl, aVar.type, aVar.bJt, aVar.bJu, null, i3);
            } else if (i < i2) {
                int i5 = i + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.bJk - (groupMetadata3.bJm - aVar.bJt), aVar.type, aVar.bJt, aVar.bJu, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.bJg.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b Dv = Dv(i);
        com.baidu.tieba.horizonalList.widget.a aVar = Dv.kou;
        boolean isChildSelectable = aVar.type == 1 ? this.bJg.isChildSelectable(aVar.bJt, aVar.bJu) : true;
        Dv.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bJg.getGroupCount() + this.bJi;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b Dv = Dv(i);
        if (Dv.kou.type == 2) {
            child = this.bJg.getGroup(Dv.kou.bJt);
        } else if (Dv.kou.type == 1) {
            child = this.bJg.getChild(Dv.kou.bJt, Dv.kou.bJu);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        Dv.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b Dv = Dv(i);
        long groupId = this.bJg.getGroupId(Dv.kou.bJt);
        if (Dv.kou.type == 2) {
            combinedChildId = this.bJg.getCombinedGroupId(groupId);
        } else if (Dv.kou.type == 1) {
            combinedChildId = this.bJg.getCombinedChildId(groupId, this.bJg.getChildId(Dv.kou.bJt, Dv.kou.bJu));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        Dv.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b Dv = Dv(i);
        if (Dv.kou.type == 2) {
            childView = this.bJg.getGroupView(Dv.kou.bJt, Dv.isExpanded(), view, viewGroup);
        } else if (Dv.kou.type == 1) {
            childView = this.bJg.getChildView(Dv.kou.bJt, Dv.kou.bJu, Dv.kov.bJl == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        Dv.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b Dv = Dv(i);
        com.baidu.tieba.horizonalList.widget.a aVar = Dv.kou;
        if (this.bJg instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bJg;
            if (aVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.bJt);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(aVar.bJt, aVar.bJu);
            }
        } else if (aVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        Dv.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.bJg instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.bJg;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.bJg.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        ArrayList<GroupMetadata> arrayList = this.bJh;
        int size = arrayList.size();
        this.bJi = 0;
        if (z2) {
            int i = size - 1;
            boolean z4 = false;
            while (i >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i);
                int k = k(groupMetadata.bJn, groupMetadata.bJm);
                if (k != groupMetadata.bJm) {
                    if (k == -1) {
                        arrayList.remove(i);
                        size--;
                    }
                    groupMetadata.bJm = k;
                    if (!z4) {
                        z3 = true;
                        i--;
                        z4 = z3;
                    }
                }
                z3 = z4;
                i--;
                z4 = z3;
            }
            if (z4) {
                Collections.sort(arrayList);
            }
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < size) {
            GroupMetadata groupMetadata2 = arrayList.get(i2);
            if (groupMetadata2.bJl == -1 || z) {
                childrenCount = this.bJg.getChildrenCount(groupMetadata2.bJm);
            } else {
                childrenCount = groupMetadata2.bJl - groupMetadata2.bJk;
            }
            this.bJi += childrenCount;
            int i5 = i4 + (groupMetadata2.bJm - i3);
            int i6 = groupMetadata2.bJm;
            groupMetadata2.bJk = i5;
            int i7 = childrenCount + i5;
            groupMetadata2.bJl = i7;
            i2++;
            i3 = i6;
            i4 = i7;
        }
    }

    boolean ga(int i) {
        com.baidu.tieba.horizonalList.widget.a J = com.baidu.tieba.horizonalList.widget.a.J(2, i, -1, -1);
        b a2 = a(J);
        J.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.kov == null) {
            return false;
        }
        this.bJh.remove(bVar.kov);
        g(false, false);
        notifyDataSetChanged();
        this.bJg.onGroupCollapsed(bVar.kov.bJm);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.kou.bJt < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.bJj != 0 && bVar.kov == null) {
            if (this.bJh.size() >= this.bJj) {
                GroupMetadata groupMetadata = this.bJh.get(0);
                int indexOf = this.bJh.indexOf(groupMetadata);
                ga(groupMetadata.bJm);
                if (bVar.bJs > indexOf) {
                    bVar.bJs--;
                }
            }
            GroupMetadata c = GroupMetadata.c(-1, -1, bVar.kou.bJt, this.bJg.getGroupId(bVar.kou.bJt));
            this.bJh.add(bVar.bJs, c);
            g(false, false);
            notifyDataSetChanged();
            this.bJg.onGroupExpanded(c.bJm);
            return true;
        }
        return false;
    }

    ExpandableListAdapter VZ() {
        return this.bJg;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter VZ = VZ();
        if (VZ instanceof Filterable) {
            return ((Filterable) VZ).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> Wa() {
        return this.bJh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.bJg != null) {
            int groupCount = this.bJg.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).bJm >= groupCount) {
                    return;
                }
            }
            this.bJh = arrayList;
            g(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter VZ = VZ();
        if (VZ != null) {
            return VZ.isEmpty();
        }
        return true;
    }

    int k(long j, int i) {
        int groupCount = this.bJg.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter VZ = VZ();
        if (VZ == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        int i4 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (VZ.getGroupId(i4) != j) {
                boolean z2 = i2 == groupCount + (-1);
                boolean z3 = i3 == 0;
                if (z2 && z3) {
                    break;
                } else if (z3 || (z && !z2)) {
                    int i5 = i2 + 1;
                    z = false;
                    i2 = i5;
                    i4 = i5;
                } else if (z2 || (!z && !z3)) {
                    int i6 = i3 - 1;
                    z = true;
                    i3 = i6;
                    i4 = i6;
                }
            } else {
                return i4;
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
            /* renamed from: ac */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.c(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: Dw */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int bJk;
        int bJl;
        int bJm;
        long bJn;

        private GroupMetadata() {
        }

        static GroupMetadata c(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.bJk = i;
            groupMetadata.bJl = i2;
            groupMetadata.bJm = i3;
            groupMetadata.bJn = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.bJm - groupMetadata.bJm;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.bJk);
            parcel.writeInt(this.bJl);
            parcel.writeInt(this.bJm);
            parcel.writeLong(this.bJn);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> bJp = new ArrayList<>(5);
        public int bJs;
        public com.baidu.tieba.horizonalList.widget.a kou;
        public GroupMetadata kov;

        private void Wb() {
            if (this.kou != null) {
                this.kou.recycle();
                this.kou = null;
            }
            this.kov = null;
            this.bJs = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b cUs = cUs();
            cUs.kou = com.baidu.tieba.horizonalList.widget.a.J(i2, i3, i4, i);
            cUs.kov = groupMetadata;
            cUs.bJs = i5;
            return cUs;
        }

        private static b cUs() {
            b bVar;
            synchronized (bJp) {
                if (bJp.size() > 0) {
                    bVar = bJp.remove(0);
                    bVar.Wb();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            Wb();
            synchronized (bJp) {
                if (bJp.size() < 5) {
                    bJp.add(this);
                }
            }
        }

        public boolean isExpanded() {
            return this.kov != null;
        }
    }
}
