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
    public ExpandableListAdapter f16856e;

    /* renamed from: g  reason: collision with root package name */
    public int f16858g;

    /* renamed from: h  reason: collision with root package name */
    public int f16859h = Integer.MAX_VALUE;

    /* renamed from: i  reason: collision with root package name */
    public final DataSetObserver f16860i = new a();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<GroupMetadata> f16857f = new ArrayList<>();

    /* loaded from: classes4.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new a();

        /* renamed from: e  reason: collision with root package name */
        public int f16861e;

        /* renamed from: f  reason: collision with root package name */
        public int f16862f;

        /* renamed from: g  reason: collision with root package name */
        public int f16863g;

        /* renamed from: h  reason: collision with root package name */
        public long f16864h;

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
            public GroupMetadata[] newArray(int i2) {
                return new GroupMetadata[i2];
            }
        }

        public static GroupMetadata b(int i2, int i3, int i4, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.f16861e = i2;
            groupMetadata.f16862f = i3;
            groupMetadata.f16863g = i4;
            groupMetadata.f16864h = j;
            return groupMetadata;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata != null) {
                return this.f16863g - groupMetadata.f16863g;
            }
            throw new IllegalArgumentException();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f16861e);
            parcel.writeInt(this.f16862f);
            parcel.writeInt(this.f16863g);
            parcel.writeLong(this.f16864h);
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
        public static ArrayList<b> f16866d = new ArrayList<>(5);

        /* renamed from: a  reason: collision with root package name */
        public d.a.o0.c1.b.a f16867a;

        /* renamed from: b  reason: collision with root package name */
        public GroupMetadata f16868b;

        /* renamed from: c  reason: collision with root package name */
        public int f16869c;

        public static b a() {
            synchronized (f16866d) {
                if (f16866d.size() > 0) {
                    b remove = f16866d.remove(0);
                    remove.e();
                    return remove;
                }
                return new b();
            }
        }

        public static b c(int i2, int i3, int i4, int i5, GroupMetadata groupMetadata, int i6) {
            b a2 = a();
            a2.f16867a = d.a.o0.c1.b.a.c(i3, i4, i5, i2);
            a2.f16868b = groupMetadata;
            a2.f16869c = i6;
            return a2;
        }

        public boolean b() {
            return this.f16868b != null;
        }

        public void d() {
            e();
            synchronized (f16866d) {
                if (f16866d.size() < 5) {
                    f16866d.add(this);
                }
            }
        }

        public final void e() {
            d.a.o0.c1.b.a aVar = this.f16867a;
            if (aVar != null) {
                aVar.e();
                this.f16867a = null;
            }
            this.f16868b = null;
            this.f16869c = 0;
        }
    }

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        k(expandableListAdapter);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.f16856e.areAllItemsEnabled();
    }

    public boolean b(int i2) {
        d.a.o0.c1.b.a c2 = d.a.o0.c1.b.a.c(2, i2, -1, -1);
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
        GroupMetadata groupMetadata = bVar.f16868b;
        if (groupMetadata == null) {
            return false;
        }
        this.f16857f.remove(groupMetadata);
        j(false, false);
        notifyDataSetChanged();
        this.f16856e.onGroupCollapsed(bVar.f16868b.f16863g);
        return true;
    }

    public boolean d(b bVar) {
        if (bVar.f16867a.f56130a >= 0) {
            if (this.f16859h != 0 && bVar.f16868b == null) {
                if (this.f16857f.size() >= this.f16859h) {
                    GroupMetadata groupMetadata = this.f16857f.get(0);
                    int indexOf = this.f16857f.indexOf(groupMetadata);
                    b(groupMetadata.f16863g);
                    int i2 = bVar.f16869c;
                    if (i2 > indexOf) {
                        bVar.f16869c = i2 - 1;
                    }
                }
                int i3 = bVar.f16867a.f56130a;
                GroupMetadata b2 = GroupMetadata.b(-1, -1, i3, this.f16856e.getGroupId(i3));
                this.f16857f.add(bVar.f16869c, b2);
                j(false, false);
                notifyDataSetChanged();
                this.f16856e.onGroupExpanded(b2.f16863g);
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
    public int e(long j, int i2) {
        int groupCount = this.f16856e.getGroupCount();
        if (groupCount != 0 && j != Long.MIN_VALUE) {
            int i3 = groupCount - 1;
            int min = Math.min(i3, Math.max(0, i2));
            long uptimeMillis = SystemClock.uptimeMillis() + 100;
            ExpandableListAdapter f2 = f();
            if (f2 != null) {
                int i4 = min;
                int i5 = i4;
                loop0: while (true) {
                    boolean z = false;
                    while (SystemClock.uptimeMillis() <= uptimeMillis) {
                        if (f2.getGroupId(min) != j) {
                            boolean z2 = i4 == i3;
                            boolean z3 = i5 == 0;
                            if (z2 && z3) {
                                break loop0;
                            } else if (z3 || (z && !z2)) {
                                i4++;
                                min = i4;
                            } else if (z2 || (!z && !z3)) {
                                i5--;
                                min = i5;
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
        return this.f16856e;
    }

    public ArrayList<GroupMetadata> g() {
        return this.f16857f;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f16856e.getGroupCount() + this.f16858g;
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
    public Object getItem(int i2) {
        Object child;
        b i3 = i(i2);
        d.a.o0.c1.b.a aVar = i3.f16867a;
        int i4 = aVar.f56133d;
        if (i4 == 2) {
            child = this.f16856e.getGroup(aVar.f56130a);
        } else if (i4 == 1) {
            child = this.f16856e.getChild(aVar.f56130a, aVar.f56131b);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        i3.d();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        long combinedChildId;
        b i3 = i(i2);
        long groupId = this.f16856e.getGroupId(i3.f16867a.f56130a);
        d.a.o0.c1.b.a aVar = i3.f16867a;
        int i4 = aVar.f56133d;
        if (i4 == 2) {
            combinedChildId = this.f16856e.getCombinedGroupId(groupId);
        } else if (i4 == 1) {
            combinedChildId = this.f16856e.getCombinedChildId(groupId, this.f16856e.getChildId(aVar.f56130a, aVar.f56131b));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        i3.d();
        return combinedChildId;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        int i3;
        b i4 = i(i2);
        d.a.o0.c1.b.a aVar = i4.f16867a;
        ExpandableListAdapter expandableListAdapter = this.f16856e;
        if (expandableListAdapter instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) expandableListAdapter;
            if (aVar.f56133d == 2) {
                i3 = heterogeneousExpandableList.getGroupType(aVar.f56130a);
            } else {
                i3 = heterogeneousExpandableList.getChildType(aVar.f56130a, aVar.f56131b) + heterogeneousExpandableList.getGroupTypeCount();
            }
        } else {
            i3 = aVar.f56133d == 2 ? 0 : 1;
        }
        i4.d();
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View childView;
        b i3 = i(i2);
        d.a.o0.c1.b.a aVar = i3.f16867a;
        int i4 = aVar.f56133d;
        if (i4 == 2) {
            childView = this.f16856e.getGroupView(aVar.f56130a, i3.b(), view, viewGroup);
        } else if (i4 == 1) {
            boolean z = i3.f16868b.f16862f == i2;
            ExpandableListAdapter expandableListAdapter = this.f16856e;
            d.a.o0.c1.b.a aVar2 = i3.f16867a;
            childView = expandableListAdapter.getChildView(aVar2.f56130a, aVar2.f56131b, z, view, viewGroup);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        i3.d();
        return childView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        ExpandableListAdapter expandableListAdapter = this.f16856e;
        if (expandableListAdapter instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) expandableListAdapter;
            return heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildTypeCount();
        }
        return 2;
    }

    public b h(d.a.o0.c1.b.a aVar) {
        ArrayList<GroupMetadata> arrayList = this.f16857f;
        int size = arrayList.size();
        int i2 = size - 1;
        if (size == 0) {
            int i3 = aVar.f56130a;
            return b.c(i3, aVar.f56133d, i3, aVar.f56131b, null, 0);
        }
        int i4 = 0;
        int i5 = 0;
        while (i5 <= i2) {
            i4 = ((i2 - i5) / 2) + i5;
            GroupMetadata groupMetadata = arrayList.get(i4);
            int i6 = aVar.f56130a;
            int i7 = groupMetadata.f16863g;
            if (i6 > i7) {
                i5 = i4 + 1;
            } else if (i6 < i7) {
                i2 = i4 - 1;
            } else if (i6 == i7) {
                int i8 = aVar.f56133d;
                if (i8 == 2) {
                    return b.c(groupMetadata.f16861e, i8, i6, aVar.f56131b, groupMetadata, i4);
                }
                if (i8 == 1) {
                    int i9 = groupMetadata.f16861e;
                    int i10 = aVar.f56131b;
                    return b.c(i9 + i10 + 1, i8, i6, i10, groupMetadata, i4);
                }
                return null;
            }
        }
        if (aVar.f56133d != 2) {
            return null;
        }
        if (i5 > i4) {
            GroupMetadata groupMetadata2 = arrayList.get(i5 - 1);
            int i11 = groupMetadata2.f16862f;
            int i12 = aVar.f56130a;
            return b.c(i11 + (i12 - groupMetadata2.f16863g), aVar.f56133d, i12, aVar.f56131b, null, i5);
        } else if (i2 < i4) {
            int i13 = 1 + i2;
            GroupMetadata groupMetadata3 = arrayList.get(i13);
            int i14 = groupMetadata3.f16861e;
            int i15 = groupMetadata3.f16863g;
            int i16 = aVar.f56130a;
            return b.c(i14 - (i15 - i16), aVar.f56133d, i16, aVar.f56131b, null, i13);
        } else {
            return null;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.f16856e.hasStableIds();
    }

    public b i(int i2) {
        int i3;
        ArrayList<GroupMetadata> arrayList = this.f16857f;
        int size = arrayList.size();
        int i4 = size - 1;
        if (size == 0) {
            return b.c(i2, 2, i2, -1, null, 0);
        }
        int i5 = 0;
        int i6 = i4;
        int i7 = 0;
        while (i5 <= i6) {
            int i8 = ((i6 - i5) / 2) + i5;
            GroupMetadata groupMetadata = arrayList.get(i8);
            int i9 = groupMetadata.f16862f;
            if (i2 > i9) {
                i5 = i8 + 1;
            } else {
                int i10 = groupMetadata.f16861e;
                if (i2 < i10) {
                    i6 = i8 - 1;
                } else if (i2 == i10) {
                    return b.c(i2, 2, groupMetadata.f16863g, -1, groupMetadata, i8);
                } else {
                    if (i2 <= i9) {
                        return b.c(i2, 1, groupMetadata.f16863g, i2 - (i10 + 1), groupMetadata, i8);
                    }
                }
            }
            i7 = i8;
        }
        if (i5 > i7) {
            GroupMetadata groupMetadata2 = arrayList.get(i5 - 1);
            i3 = (i2 - groupMetadata2.f16862f) + groupMetadata2.f16863g;
        } else if (i6 < i7) {
            i5 = i6 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i5);
            i3 = groupMetadata3.f16863g - (groupMetadata3.f16861e - i2);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return b.c(i2, 2, i3, -1, null, i5);
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
    public boolean isEnabled(int i2) {
        b i3 = i(i2);
        d.a.o0.c1.b.a aVar = i3.f16867a;
        boolean isChildSelectable = aVar.f56133d == 1 ? this.f16856e.isChildSelectable(aVar.f56130a, aVar.f56131b) : true;
        i3.d();
        return isChildSelectable;
    }

    public final void j(boolean z, boolean z2) {
        int childrenCount;
        ArrayList<GroupMetadata> arrayList = this.f16857f;
        int size = arrayList.size();
        int i2 = 0;
        this.f16858g = 0;
        if (z2) {
            boolean z3 = false;
            for (int i3 = size - 1; i3 >= 0; i3--) {
                GroupMetadata groupMetadata = arrayList.get(i3);
                int e2 = e(groupMetadata.f16864h, groupMetadata.f16863g);
                if (e2 != groupMetadata.f16863g) {
                    if (e2 == -1) {
                        arrayList.remove(i3);
                        size--;
                    }
                    groupMetadata.f16863g = e2;
                    if (!z3) {
                        z3 = true;
                    }
                }
            }
            if (z3) {
                Collections.sort(arrayList);
            }
        }
        int i4 = 0;
        int i5 = 0;
        while (i2 < size) {
            GroupMetadata groupMetadata2 = arrayList.get(i2);
            int i6 = groupMetadata2.f16862f;
            if (i6 != -1 && !z) {
                childrenCount = i6 - groupMetadata2.f16861e;
            } else {
                childrenCount = this.f16856e.getChildrenCount(groupMetadata2.f16863g);
            }
            this.f16858g += childrenCount;
            int i7 = groupMetadata2.f16863g;
            int i8 = i4 + (i7 - i5);
            groupMetadata2.f16861e = i8;
            i4 = i8 + childrenCount;
            groupMetadata2.f16862f = i4;
            i2++;
            i5 = i7;
        }
    }

    public void k(ExpandableListAdapter expandableListAdapter) {
        ExpandableListAdapter expandableListAdapter2 = this.f16856e;
        if (expandableListAdapter2 != null) {
            expandableListAdapter2.unregisterDataSetObserver(this.f16860i);
        }
        this.f16856e = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.f16860i);
    }

    public void l(ArrayList<GroupMetadata> arrayList) {
        ExpandableListAdapter expandableListAdapter;
        if (arrayList == null || (expandableListAdapter = this.f16856e) == null) {
            return;
        }
        int groupCount = expandableListAdapter.getGroupCount();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f16863g >= groupCount) {
                return;
            }
        }
        this.f16857f = arrayList;
        j(true, false);
    }
}
