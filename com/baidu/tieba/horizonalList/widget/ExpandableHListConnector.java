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
    public ExpandableListAdapter f17174e;

    /* renamed from: g  reason: collision with root package name */
    public int f17176g;

    /* renamed from: h  reason: collision with root package name */
    public int f17177h = Integer.MAX_VALUE;
    public final DataSetObserver i = new a();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<GroupMetadata> f17175f = new ArrayList<>();

    /* loaded from: classes4.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public int f17178e;

        /* renamed from: f  reason: collision with root package name */
        public int f17179f;

        /* renamed from: g  reason: collision with root package name */
        public int f17180g;

        /* renamed from: h  reason: collision with root package name */
        public long f17181h;

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
            groupMetadata.f17178e = i;
            groupMetadata.f17179f = i2;
            groupMetadata.f17180g = i3;
            groupMetadata.f17181h = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata != null) {
                return this.f17180g - groupMetadata.f17180g;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f17178e);
            parcel.writeInt(this.f17179f);
            parcel.writeInt(this.f17180g);
            parcel.writeLong(this.f17181h);
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
        public static ArrayList<b> f17183d = new ArrayList<>(5);

        /* renamed from: a  reason: collision with root package name */
        public d.b.i0.b1.b.a f17184a;

        /* renamed from: b  reason: collision with root package name */
        public GroupMetadata f17185b;

        /* renamed from: c  reason: collision with root package name */
        public int f17186c;

        public static b a() {
            synchronized (f17183d) {
                if (f17183d.size() > 0) {
                    b remove = f17183d.remove(0);
                    remove.e();
                    return remove;
                }
                return new b();
            }
        }

        public static b c(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            b a2 = a();
            a2.f17184a = d.b.i0.b1.b.a.c(i2, i3, i4, i);
            a2.f17185b = groupMetadata;
            a2.f17186c = i5;
            return a2;
        }

        public boolean b() {
            return this.f17185b != null;
        }

        public void d() {
            e();
            synchronized (f17183d) {
                if (f17183d.size() < 5) {
                    f17183d.add(this);
                }
            }
        }

        public final void e() {
            d.b.i0.b1.b.a aVar = this.f17184a;
            if (aVar != null) {
                aVar.e();
                this.f17184a = null;
            }
            this.f17185b = null;
            this.f17186c = 0;
        }
    }

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        k(expandableListAdapter);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.f17174e.areAllItemsEnabled();
    }

    public boolean b(int i) {
        d.b.i0.b1.b.a c2 = d.b.i0.b1.b.a.c(2, i, -1, -1);
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
        GroupMetadata groupMetadata = bVar.f17185b;
        if (groupMetadata == null) {
            return false;
        }
        this.f17175f.remove(groupMetadata);
        j(false, false);
        notifyDataSetChanged();
        this.f17174e.onGroupCollapsed(bVar.f17185b.f17180g);
        return true;
    }

    public boolean d(b bVar) {
        if (bVar.f17184a.f53292a >= 0) {
            if (this.f17177h != 0 && bVar.f17185b == null) {
                if (this.f17175f.size() >= this.f17177h) {
                    GroupMetadata groupMetadata = this.f17175f.get(0);
                    int indexOf = this.f17175f.indexOf(groupMetadata);
                    b(groupMetadata.f17180g);
                    int i = bVar.f17186c;
                    if (i > indexOf) {
                        bVar.f17186c = i - 1;
                    }
                }
                int i2 = bVar.f17184a.f53292a;
                GroupMetadata b2 = GroupMetadata.b(-1, -1, i2, this.f17174e.getGroupId(i2));
                this.f17175f.add(bVar.f17186c, b2);
                j(false, false);
                notifyDataSetChanged();
                this.f17174e.onGroupExpanded(b2.f17180g);
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
        int groupCount = this.f17174e.getGroupCount();
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
        return this.f17174e;
    }

    public ArrayList<GroupMetadata> g() {
        return this.f17175f;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f17174e.getGroupCount() + this.f17176g;
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
        d.b.i0.b1.b.a aVar = i2.f17184a;
        int i3 = aVar.f53295d;
        if (i3 == 2) {
            child = this.f17174e.getGroup(aVar.f53292a);
        } else if (i3 == 1) {
            child = this.f17174e.getChild(aVar.f53292a, aVar.f53293b);
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
        long groupId = this.f17174e.getGroupId(i2.f17184a.f53292a);
        d.b.i0.b1.b.a aVar = i2.f17184a;
        int i3 = aVar.f53295d;
        if (i3 == 2) {
            combinedChildId = this.f17174e.getCombinedGroupId(groupId);
        } else if (i3 == 1) {
            combinedChildId = this.f17174e.getCombinedChildId(groupId, this.f17174e.getChildId(aVar.f53292a, aVar.f53293b));
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
        d.b.i0.b1.b.a aVar = i3.f17184a;
        ExpandableListAdapter expandableListAdapter = this.f17174e;
        if (expandableListAdapter instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) expandableListAdapter;
            if (aVar.f53295d == 2) {
                i2 = heterogeneousExpandableList.getGroupType(aVar.f53292a);
            } else {
                i2 = heterogeneousExpandableList.getChildType(aVar.f53292a, aVar.f53293b) + heterogeneousExpandableList.getGroupTypeCount();
            }
        } else {
            i2 = aVar.f53295d == 2 ? 0 : 1;
        }
        i3.d();
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View childView;
        b i2 = i(i);
        d.b.i0.b1.b.a aVar = i2.f17184a;
        int i3 = aVar.f53295d;
        if (i3 == 2) {
            childView = this.f17174e.getGroupView(aVar.f53292a, i2.b(), view, viewGroup);
        } else if (i3 == 1) {
            boolean z = i2.f17185b.f17179f == i;
            ExpandableListAdapter expandableListAdapter = this.f17174e;
            d.b.i0.b1.b.a aVar2 = i2.f17184a;
            childView = expandableListAdapter.getChildView(aVar2.f53292a, aVar2.f53293b, z, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        i2.d();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        ExpandableListAdapter expandableListAdapter = this.f17174e;
        if (expandableListAdapter instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) expandableListAdapter;
            return heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildTypeCount();
        }
        return 2;
    }

    public b h(d.b.i0.b1.b.a aVar) {
        ArrayList<GroupMetadata> arrayList = this.f17175f;
        int size = arrayList.size();
        int i = size - 1;
        if (size == 0) {
            int i2 = aVar.f53292a;
            return b.c(i2, aVar.f53295d, i2, aVar.f53293b, null, 0);
        }
        int i3 = 0;
        int i4 = 0;
        while (i4 <= i) {
            i3 = ((i - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i3);
            int i5 = aVar.f53292a;
            int i6 = groupMetadata.f17180g;
            if (i5 > i6) {
                i4 = i3 + 1;
            } else if (i5 < i6) {
                i = i3 - 1;
            } else if (i5 == i6) {
                int i7 = aVar.f53295d;
                if (i7 == 2) {
                    return b.c(groupMetadata.f17178e, i7, i5, aVar.f53293b, groupMetadata, i3);
                }
                if (i7 == 1) {
                    int i8 = groupMetadata.f17178e;
                    int i9 = aVar.f53293b;
                    return b.c(i8 + i9 + 1, i7, i5, i9, groupMetadata, i3);
                }
                return null;
            }
        }
        if (aVar.f53295d != 2) {
            return null;
        }
        if (i4 > i3) {
            GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
            int i10 = groupMetadata2.f17179f;
            int i11 = aVar.f53292a;
            return b.c(i10 + (i11 - groupMetadata2.f17180g), aVar.f53295d, i11, aVar.f53293b, null, i4);
        } else if (i < i3) {
            int i12 = 1 + i;
            GroupMetadata groupMetadata3 = arrayList.get(i12);
            int i13 = groupMetadata3.f17178e;
            int i14 = groupMetadata3.f17180g;
            int i15 = aVar.f53292a;
            return b.c(i13 - (i14 - i15), aVar.f53295d, i15, aVar.f53293b, null, i12);
        } else {
            return null;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.f17174e.hasStableIds();
    }

    public b i(int i) {
        int i2;
        ArrayList<GroupMetadata> arrayList = this.f17175f;
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
            int i8 = groupMetadata.f17179f;
            if (i > i8) {
                i4 = i7 + 1;
            } else {
                int i9 = groupMetadata.f17178e;
                if (i < i9) {
                    i5 = i7 - 1;
                } else if (i == i9) {
                    return b.c(i, 2, groupMetadata.f17180g, -1, groupMetadata, i7);
                } else {
                    if (i <= i8) {
                        return b.c(i, 1, groupMetadata.f17180g, i - (i9 + 1), groupMetadata, i7);
                    }
                }
            }
            i6 = i7;
        }
        if (i4 > i6) {
            GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
            i2 = (i - groupMetadata2.f17179f) + groupMetadata2.f17180g;
        } else if (i5 < i6) {
            i4 = i5 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i4);
            i2 = groupMetadata3.f17180g - (groupMetadata3.f17178e - i);
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
        d.b.i0.b1.b.a aVar = i2.f17184a;
        boolean isChildSelectable = aVar.f53295d == 1 ? this.f17174e.isChildSelectable(aVar.f53292a, aVar.f53293b) : true;
        i2.d();
        return isChildSelectable;
    }

    public final void j(boolean z, boolean z2) {
        int childrenCount;
        ArrayList<GroupMetadata> arrayList = this.f17175f;
        int size = arrayList.size();
        int i = 0;
        this.f17176g = 0;
        if (z2) {
            boolean z3 = false;
            for (int i2 = size - 1; i2 >= 0; i2--) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int e2 = e(groupMetadata.f17181h, groupMetadata.f17180g);
                if (e2 != groupMetadata.f17180g) {
                    if (e2 == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.f17180g = e2;
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
            int i5 = groupMetadata2.f17179f;
            if (i5 != -1 && !z) {
                childrenCount = i5 - groupMetadata2.f17178e;
            } else {
                childrenCount = this.f17174e.getChildrenCount(groupMetadata2.f17180g);
            }
            this.f17176g += childrenCount;
            int i6 = groupMetadata2.f17180g;
            int i7 = i3 + (i6 - i4);
            groupMetadata2.f17178e = i7;
            i3 = i7 + childrenCount;
            groupMetadata2.f17179f = i3;
            i++;
            i4 = i6;
        }
    }

    public void k(ExpandableListAdapter expandableListAdapter) {
        ExpandableListAdapter expandableListAdapter2 = this.f17174e;
        if (expandableListAdapter2 != null) {
            expandableListAdapter2.unregisterDataSetObserver(this.i);
        }
        this.f17174e = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.i);
    }

    public void l(ArrayList<GroupMetadata> arrayList) {
        ExpandableListAdapter expandableListAdapter;
        if (arrayList == null || (expandableListAdapter = this.f17174e) == null) {
            return;
        }
        int groupCount = expandableListAdapter.getGroupCount();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f17180g >= groupCount) {
                return;
            }
        }
        this.f17175f = arrayList;
        j(true, false);
    }
}
