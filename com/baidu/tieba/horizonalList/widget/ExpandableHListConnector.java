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
    private ExpandableListAdapter ega;
    private int egc;
    private int egd = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new a();
    private ArrayList<GroupMetadata> egb = new ArrayList<>();

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        a(expandableListAdapter);
    }

    public void a(ExpandableListAdapter expandableListAdapter) {
        if (this.ega != null) {
            this.ega.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.ega = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b pe(int i) {
        int i2;
        int i3;
        int i4 = 0;
        ArrayList<GroupMetadata> arrayList = this.egb;
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
            if (i > groupMetadata.egf) {
                i7 = i4 + 1;
            } else if (i < groupMetadata.ege) {
                i6 = i4 - 1;
            } else if (i == groupMetadata.ege) {
                return b.a(i, 2, groupMetadata.egg, -1, groupMetadata, i4);
            } else {
                if (i <= groupMetadata.egf) {
                    return b.a(i, 1, groupMetadata.egg, i - (groupMetadata.ege + 1), groupMetadata, i4);
                }
            }
        }
        if (i7 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i7 - 1);
            i3 = (i - groupMetadata2.egf) + groupMetadata2.egg;
            i2 = i7;
        } else if (i6 < i4) {
            i2 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i2);
            i3 = groupMetadata3.egg - (groupMetadata3.ege - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.a(i, 2, i3, -1, null, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(com.baidu.tieba.horizonalList.widget.b bVar) {
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.egb;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            return b.a(bVar.egn, bVar.type, bVar.egn, bVar.ego, null, 0);
        }
        int i3 = i2;
        int i4 = 0;
        while (i4 <= i3) {
            i = ((i3 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i);
            if (bVar.egn > groupMetadata.egg) {
                i4 = i + 1;
            } else if (bVar.egn < groupMetadata.egg) {
                i3 = i - 1;
            } else if (bVar.egn == groupMetadata.egg) {
                if (bVar.type == 2) {
                    return b.a(groupMetadata.ege, bVar.type, bVar.egn, bVar.ego, groupMetadata, i);
                }
                if (bVar.type == 1) {
                    return b.a(groupMetadata.ege + bVar.ego + 1, bVar.type, bVar.egn, bVar.ego, groupMetadata, i);
                }
                return null;
            }
        }
        if (bVar.type == 2) {
            if (i4 > i) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                return b.a((bVar.egn - groupMetadata2.egg) + groupMetadata2.egf, bVar.type, bVar.egn, bVar.ego, null, i4);
            } else if (i3 < i) {
                int i5 = i3 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                return b.a(groupMetadata3.ege - (groupMetadata3.egg - bVar.egn), bVar.type, bVar.egn, bVar.ego, null, i5);
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.ega.areAllItemsEnabled();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b pe = pe(i);
        com.baidu.tieba.horizonalList.widget.b bVar = pe.egk;
        boolean isChildSelectable = bVar.type == 1 ? this.ega.isChildSelectable(bVar.egn, bVar.ego) : true;
        pe.recycle();
        return isChildSelectable;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ega.getGroupCount() + this.egc;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b pe = pe(i);
        if (pe.egk.type == 2) {
            child = this.ega.getGroup(pe.egk.egn);
        } else if (pe.egk.type == 1) {
            child = this.ega.getChild(pe.egk.egn, pe.egk.ego);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        pe.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b pe = pe(i);
        long groupId = this.ega.getGroupId(pe.egk.egn);
        if (pe.egk.type == 2) {
            combinedChildId = this.ega.getCombinedGroupId(groupId);
        } else if (pe.egk.type == 1) {
            combinedChildId = this.ega.getCombinedChildId(groupId, this.ega.getChildId(pe.egk.egn, pe.egk.ego));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        pe.recycle();
        return combinedChildId;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b pe = pe(i);
        if (pe.egk.type == 2) {
            childView = this.ega.getGroupView(pe.egk.egn, pe.arz(), view, viewGroup);
        } else if (pe.egk.type == 1) {
            childView = this.ega.getChildView(pe.egk.egn, pe.egk.ego, pe.egl.egf == i, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        pe.recycle();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b pe = pe(i);
        com.baidu.tieba.horizonalList.widget.b bVar = pe.egk;
        if (this.ega instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.ega;
            if (bVar.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(bVar.egn);
            } else {
                i2 = heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildType(bVar.egn, bVar.ego);
            }
        } else if (bVar.type == 2) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        pe.recycle();
        return i2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        if (this.ega instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) this.ega;
            return heterogeneousExpandableList.getChildTypeCount() + heterogeneousExpandableList.getGroupTypeCount();
        }
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.ega.hasStableIds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z, boolean z2) {
        int childrenCount;
        boolean z3;
        int i = 0;
        ArrayList<GroupMetadata> arrayList = this.egb;
        int size = arrayList.size();
        this.egc = 0;
        if (z2) {
            int i2 = size - 1;
            boolean z4 = false;
            while (i2 >= 0) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int i3 = i(groupMetadata.egh, groupMetadata.egg);
                if (i3 != groupMetadata.egg) {
                    if (i3 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.egg = i3;
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
        int i4 = 0;
        int i5 = 0;
        while (i < size) {
            GroupMetadata groupMetadata2 = arrayList.get(i);
            if (groupMetadata2.egf == -1 || z) {
                childrenCount = this.ega.getChildrenCount(groupMetadata2.egg);
            } else {
                childrenCount = groupMetadata2.egf - groupMetadata2.ege;
            }
            this.egc += childrenCount;
            int i6 = i5 + (groupMetadata2.egg - i4);
            i4 = groupMetadata2.egg;
            groupMetadata2.ege = i6;
            int i7 = childrenCount + i6;
            groupMetadata2.egf = i7;
            i++;
            i5 = i7;
        }
    }

    boolean collapseGroup(int i) {
        com.baidu.tieba.horizonalList.widget.b z = com.baidu.tieba.horizonalList.widget.b.z(2, i, -1, -1);
        b a2 = a(z);
        z.recycle();
        if (a2 == null) {
            return false;
        }
        boolean a3 = a(a2);
        a2.recycle();
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(b bVar) {
        if (bVar.egl == null) {
            return false;
        }
        this.egb.remove(bVar.egl);
        C(false, false);
        notifyDataSetChanged();
        this.ega.onGroupCollapsed(bVar.egl.egg);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(b bVar) {
        if (bVar.egk.egn < 0) {
            throw new RuntimeException("Need group");
        }
        if (this.egd != 0 && bVar.egl == null) {
            if (this.egb.size() >= this.egd) {
                GroupMetadata groupMetadata = this.egb.get(0);
                int indexOf = this.egb.indexOf(groupMetadata);
                collapseGroup(groupMetadata.egg);
                if (bVar.egm > indexOf) {
                    bVar.egm--;
                }
            }
            GroupMetadata a2 = GroupMetadata.a(-1, -1, bVar.egk.egn, this.ega.getGroupId(bVar.egk.egn));
            this.egb.add(bVar.egm, a2);
            C(false, false);
            notifyDataSetChanged();
            this.ega.onGroupExpanded(a2.egg);
            return true;
        }
        return false;
    }

    ExpandableListAdapter aBM() {
        return this.ega;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter aBM = aBM();
        if (aBM instanceof Filterable) {
            return ((Filterable) aBM).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> aBN() {
        return this.egb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R(ArrayList<GroupMetadata> arrayList) {
        if (arrayList != null && this.ega != null) {
            int groupCount = this.ega.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).egg >= groupCount) {
                    return;
                }
            }
            this.egb = arrayList;
            C(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter aBM = aBM();
        if (aBM != null) {
            return aBM.isEmpty();
        }
        return true;
    }

    int i(long j, int i) {
        int groupCount = this.ega.getGroupCount();
        if (groupCount == 0 || j == Long.MIN_VALUE) {
            return -1;
        }
        int min = Math.min(groupCount - 1, Math.max(0, i));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        boolean z = false;
        ExpandableListAdapter aBM = aBM();
        if (aBM == null) {
            return -1;
        }
        int i2 = min;
        int i3 = min;
        while (SystemClock.uptimeMillis() <= uptimeMillis) {
            if (aBM.getGroupId(i3) != j) {
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
            ExpandableHListConnector.this.C(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.C(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: com.baidu.tieba.horizonalList.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: D */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.a(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: pf */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        int ege;
        int egf;
        int egg;
        long egh;

        private GroupMetadata() {
        }

        static GroupMetadata a(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.ege = i;
            groupMetadata.egf = i2;
            groupMetadata.egg = i3;
            groupMetadata.egh = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata == null) {
                throw new IllegalArgumentException();
            }
            return this.egg - groupMetadata.egg;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.ege);
            parcel.writeInt(this.egf);
            parcel.writeInt(this.egg);
            parcel.writeLong(this.egh);
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        private static ArrayList<b> egj = new ArrayList<>(5);
        public com.baidu.tieba.horizonalList.widget.b egk;
        public GroupMetadata egl;
        public int egm;

        private void SF() {
            if (this.egk != null) {
                this.egk.recycle();
                this.egk = null;
            }
            this.egl = null;
            this.egm = 0;
        }

        private b() {
        }

        static b a(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b aBO = aBO();
            aBO.egk = com.baidu.tieba.horizonalList.widget.b.z(i2, i3, i4, i);
            aBO.egl = groupMetadata;
            aBO.egm = i5;
            return aBO;
        }

        private static b aBO() {
            b bVar;
            synchronized (egj) {
                if (egj.size() > 0) {
                    bVar = egj.remove(0);
                    bVar.SF();
                } else {
                    bVar = new b();
                }
            }
            return bVar;
        }

        public void recycle() {
            SF();
            synchronized (egj) {
                if (egj.size() < 5) {
                    egj.add(this);
                }
            }
        }

        public boolean arz() {
            return this.egl != null;
        }
    }
}
