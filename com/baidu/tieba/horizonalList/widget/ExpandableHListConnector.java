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
/* loaded from: classes4.dex */
public class ExpandableHListConnector extends BaseAdapter implements Filterable {

    /* renamed from: e  reason: collision with root package name */
    public ExpandableListAdapter f17496e;

    /* renamed from: g  reason: collision with root package name */
    public int f17498g;

    /* renamed from: h  reason: collision with root package name */
    public int f17499h = Integer.MAX_VALUE;
    public final DataSetObserver i = new a();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<GroupMetadata> f17497f = new ArrayList<>();

    /* loaded from: classes4.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public int f17500e;

        /* renamed from: f  reason: collision with root package name */
        public int f17501f;

        /* renamed from: g  reason: collision with root package name */
        public int f17502g;

        /* renamed from: h  reason: collision with root package name */
        public long f17503h;

        /* loaded from: classes4.dex */
        public static class a implements Parcelable.Creator<GroupMetadata> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.b(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        }

        public static GroupMetadata b(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.f17500e = i;
            groupMetadata.f17501f = i2;
            groupMetadata.f17502g = i3;
            groupMetadata.f17503h = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata != null) {
                return this.f17502g - groupMetadata.f17502g;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f17500e);
            parcel.writeInt(this.f17501f);
            parcel.writeInt(this.f17502g);
            parcel.writeLong(this.f17503h);
        }
    }

    /* loaded from: classes4.dex */
    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ExpandableHListConnector.this.j(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.j(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: d  reason: collision with root package name */
        public static ArrayList<b> f17505d = new ArrayList<>(5);

        /* renamed from: a  reason: collision with root package name */
        public d.b.i0.a1.b.a f17506a;

        /* renamed from: b  reason: collision with root package name */
        public GroupMetadata f17507b;

        /* renamed from: c  reason: collision with root package name */
        public int f17508c;

        public static b a() {
            synchronized (f17505d) {
                if (f17505d.size() > 0) {
                    b remove = f17505d.remove(0);
                    remove.e();
                    return remove;
                }
                return new b();
            }
        }

        public static b c(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b a2 = a();
            a2.f17506a = d.b.i0.a1.b.a.c(i2, i3, i4, i);
            a2.f17507b = groupMetadata;
            a2.f17508c = i5;
            return a2;
        }

        public boolean b() {
            return this.f17507b != null;
        }

        public void d() {
            e();
            synchronized (f17505d) {
                if (f17505d.size() < 5) {
                    f17505d.add(this);
                }
            }
        }

        public final void e() {
            d.b.i0.a1.b.a aVar = this.f17506a;
            if (aVar != null) {
                aVar.e();
                this.f17506a = null;
            }
            this.f17507b = null;
            this.f17508c = 0;
        }
    }

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        k(expandableListAdapter);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.f17496e.areAllItemsEnabled();
    }

    public boolean b(int i) {
        d.b.i0.a1.b.a c2 = d.b.i0.a1.b.a.c(2, i, -1, -1);
        b h2 = h(c2);
        c2.e();
        if (h2 == null) {
            return false;
        }
        boolean c3 = c(h2);
        h2.d();
        return c3;
    }

    public boolean c(b bVar) {
        GroupMetadata groupMetadata = bVar.f17507b;
        if (groupMetadata == null) {
            return false;
        }
        this.f17497f.remove(groupMetadata);
        j(false, false);
        notifyDataSetChanged();
        this.f17496e.onGroupCollapsed(bVar.f17507b.f17502g);
        return true;
    }

    public boolean d(b bVar) {
        if (bVar.f17506a.f51871a >= 0) {
            if (this.f17499h != 0 && bVar.f17507b == null) {
                if (this.f17497f.size() >= this.f17499h) {
                    GroupMetadata groupMetadata = this.f17497f.get(0);
                    int indexOf = this.f17497f.indexOf(groupMetadata);
                    b(groupMetadata.f17502g);
                    int i = bVar.f17508c;
                    if (i > indexOf) {
                        bVar.f17508c = i - 1;
                    }
                }
                int i2 = bVar.f17506a.f51871a;
                GroupMetadata b2 = GroupMetadata.b(-1, -1, i2, this.f17496e.getGroupId(i2));
                this.f17497f.add(bVar.f17508c, b2);
                j(false, false);
                notifyDataSetChanged();
                this.f17496e.onGroupExpanded(b2.f17502g);
                return true;
            }
            return false;
        }
        throw new RuntimeException("Need group");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0066, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int e(long j, int i) {
        int groupCount = this.f17496e.getGroupCount();
        if (groupCount != 0 && j != Long.MIN_VALUE) {
            int i2 = groupCount - 1;
            int min = Math.min(i2, Math.max(0, i));
            long uptimeMillis = SystemClock.uptimeMillis() + 100;
            ExpandableListAdapter f2 = f();
            if (f2 != null) {
                int i3 = min;
                int i4 = i3;
                loop0: while (true) {
                    boolean z = false;
                    while (SystemClock.uptimeMillis() <= uptimeMillis) {
                        if (f2.getGroupId(min) != j) {
                            boolean z2 = i3 == i2;
                            boolean z3 = i4 == 0;
                            if (z2 && z3) {
                                break loop0;
                            } else if (z3 || (z && !z2)) {
                                i3++;
                                min = i3;
                            } else if (z2 || (!z && !z3)) {
                                i4--;
                                min = i4;
                                z = true;
                            }
                        } else {
                            return min;
                        }
                    }
                    break loop0;
                }
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public ExpandableListAdapter f() {
        return this.f17496e;
    }

    public ArrayList<GroupMetadata> g() {
        return this.f17497f;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f17496e.getGroupCount() + this.f17498g;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter f2 = f();
        if (f2 instanceof Filterable) {
            return ((Filterable) f2).getFilter();
        }
        return null;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        b i2 = i(i);
        d.b.i0.a1.b.a aVar = i2.f17506a;
        int i3 = aVar.f51874d;
        if (i3 == 2) {
            child = this.f17496e.getGroup(aVar.f51871a);
        } else if (i3 == 1) {
            child = this.f17496e.getChild(aVar.f51871a, aVar.f51872b);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        i2.d();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        b i2 = i(i);
        long groupId = this.f17496e.getGroupId(i2.f17506a.f51871a);
        d.b.i0.a1.b.a aVar = i2.f17506a;
        int i3 = aVar.f51874d;
        if (i3 == 2) {
            combinedChildId = this.f17496e.getCombinedGroupId(groupId);
        } else if (i3 == 1) {
            combinedChildId = this.f17496e.getCombinedChildId(groupId, this.f17496e.getChildId(aVar.f51871a, aVar.f51872b));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        i2.d();
        return combinedChildId;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        b i3 = i(i);
        d.b.i0.a1.b.a aVar = i3.f17506a;
        ExpandableListAdapter expandableListAdapter = this.f17496e;
        if (expandableListAdapter instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) expandableListAdapter;
            if (aVar.f51874d == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.f51871a);
            } else {
                i2 = heterogeneousExpandableList.getChildType(aVar.f51871a, aVar.f51872b) + heterogeneousExpandableList.getGroupTypeCount();
            }
        } else {
            i2 = aVar.f51874d == 2 ? 0 : 1;
        }
        i3.d();
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b i2 = i(i);
        d.b.i0.a1.b.a aVar = i2.f17506a;
        int i3 = aVar.f51874d;
        if (i3 == 2) {
            childView = this.f17496e.getGroupView(aVar.f51871a, i2.b(), view, viewGroup);
        } else if (i3 == 1) {
            boolean z = i2.f17507b.f17501f == i;
            ExpandableListAdapter expandableListAdapter = this.f17496e;
            d.b.i0.a1.b.a aVar2 = i2.f17506a;
            childView = expandableListAdapter.getChildView(aVar2.f51871a, aVar2.f51872b, z, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        i2.d();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        ExpandableListAdapter expandableListAdapter = this.f17496e;
        if (expandableListAdapter instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) expandableListAdapter;
            return heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildTypeCount();
        }
        return 2;
    }

    public b h(d.b.i0.a1.b.a aVar) {
        ArrayList<GroupMetadata> arrayList = this.f17497f;
        int size = arrayList.size();
        int i = size - 1;
        if (size == 0) {
            int i2 = aVar.f51871a;
            return b.c(i2, aVar.f51874d, i2, aVar.f51872b, null, 0);
        }
        int i3 = 0;
        int i4 = 0;
        while (i4 <= i) {
            i3 = ((i - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i3);
            int i5 = aVar.f51871a;
            int i6 = groupMetadata.f17502g;
            if (i5 > i6) {
                i4 = i3 + 1;
            } else if (i5 < i6) {
                i = i3 - 1;
            } else if (i5 == i6) {
                int i7 = aVar.f51874d;
                if (i7 == 2) {
                    return b.c(groupMetadata.f17500e, i7, i5, aVar.f51872b, groupMetadata, i3);
                }
                if (i7 == 1) {
                    int i8 = groupMetadata.f17500e;
                    int i9 = aVar.f51872b;
                    return b.c(i8 + i9 + 1, i7, i5, i9, groupMetadata, i3);
                }
                return null;
            }
        }
        if (aVar.f51874d != 2) {
            return null;
        }
        if (i4 > i3) {
            GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
            int i10 = groupMetadata2.f17501f;
            int i11 = aVar.f51871a;
            return b.c(i10 + (i11 - groupMetadata2.f17502g), aVar.f51874d, i11, aVar.f51872b, null, i4);
        } else if (i < i3) {
            int i12 = 1 + i;
            GroupMetadata groupMetadata3 = arrayList.get(i12);
            int i13 = groupMetadata3.f17500e;
            int i14 = groupMetadata3.f17502g;
            int i15 = aVar.f51871a;
            return b.c(i13 - (i14 - i15), aVar.f51874d, i15, aVar.f51872b, null, i12);
        } else {
            return null;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.f17496e.hasStableIds();
    }

    public b i(int i) {
        int i2;
        ArrayList<GroupMetadata> arrayList = this.f17497f;
        int size = arrayList.size();
        int i3 = size - 1;
        if (size == 0) {
            return b.c(i, 2, i, -1, null, 0);
        }
        int i4 = 0;
        int i5 = i3;
        int i6 = 0;
        while (i4 <= i5) {
            int i7 = ((i5 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i7);
            int i8 = groupMetadata.f17501f;
            if (i > i8) {
                i4 = i7 + 1;
            } else {
                int i9 = groupMetadata.f17500e;
                if (i < i9) {
                    i5 = i7 - 1;
                } else if (i == i9) {
                    return b.c(i, 2, groupMetadata.f17502g, -1, groupMetadata, i7);
                } else {
                    if (i <= i8) {
                        return b.c(i, 1, groupMetadata.f17502g, i - (i9 + 1), groupMetadata, i7);
                    }
                }
            }
            i6 = i7;
        }
        if (i4 > i6) {
            GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
            i2 = (i - groupMetadata2.f17501f) + groupMetadata2.f17502g;
        } else if (i5 < i6) {
            i4 = i5 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i4);
            i2 = groupMetadata3.f17502g - (groupMetadata3.f17500e - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.c(i, 2, i2, -1, null, i4);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter f2 = f();
        if (f2 != null) {
            return f2.isEmpty();
        }
        return true;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        b i2 = i(i);
        d.b.i0.a1.b.a aVar = i2.f17506a;
        boolean isChildSelectable = aVar.f51874d == 1 ? this.f17496e.isChildSelectable(aVar.f51871a, aVar.f51872b) : true;
        i2.d();
        return isChildSelectable;
    }

    public final void j(boolean z, boolean z2) {
        int childrenCount;
        ArrayList<GroupMetadata> arrayList = this.f17497f;
        int size = arrayList.size();
        int i = 0;
        this.f17498g = 0;
        if (z2) {
            boolean z3 = false;
            for (int i2 = size - 1; i2 >= 0; i2--) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int e2 = e(groupMetadata.f17503h, groupMetadata.f17502g);
                if (e2 != groupMetadata.f17502g) {
                    if (e2 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.f17502g = e2;
                    if (!z3) {
                        z3 = true;
                    }
                }
            }
            if (z3) {
                Collections.sort(arrayList);
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i < size) {
            GroupMetadata groupMetadata2 = arrayList.get(i);
            int i5 = groupMetadata2.f17501f;
            if (i5 != -1 && !z) {
                childrenCount = i5 - groupMetadata2.f17500e;
            } else {
                childrenCount = this.f17496e.getChildrenCount(groupMetadata2.f17502g);
            }
            this.f17498g += childrenCount;
            int i6 = groupMetadata2.f17502g;
            int i7 = i3 + (i6 - i4);
            groupMetadata2.f17500e = i7;
            i3 = i7 + childrenCount;
            groupMetadata2.f17501f = i3;
            i++;
            i4 = i6;
        }
    }

    public void k(ExpandableListAdapter expandableListAdapter) {
        ExpandableListAdapter expandableListAdapter2 = this.f17496e;
        if (expandableListAdapter2 != null) {
            expandableListAdapter2.unregisterDataSetObserver(this.i);
        }
        this.f17496e = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.i);
    }

    public void l(ArrayList<GroupMetadata> arrayList) {
        ExpandableListAdapter expandableListAdapter;
        if (arrayList == null || (expandableListAdapter = this.f17496e) == null) {
            return;
        }
        int groupCount = expandableListAdapter.getGroupCount();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f17502g >= groupCount) {
                return;
            }
        }
        this.f17497f = arrayList;
        j(true, false);
    }
}
