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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes12.dex */
public class ExpandableHListConnector extends BaseAdapter implements Filterable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ExpandableListAdapter f46321e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<GroupMetadata> f46322f;

    /* renamed from: g  reason: collision with root package name */
    public int f46323g;

    /* renamed from: h  reason: collision with root package name */
    public int f46324h;

    /* renamed from: i  reason: collision with root package name */
    public final DataSetObserver f46325i;

    /* loaded from: classes12.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final Parcelable.Creator<GroupMetadata> CREATOR;
        public static final int REFRESH = -1;
        public transient /* synthetic */ FieldHolder $fh;
        public int flPos;
        public long gId;
        public int gPos;
        public int lastChildFlPos;

        /* loaded from: classes12.dex */
        public static class a implements Parcelable.Creator<GroupMetadata> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public GroupMetadata createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? GroupMetadata.obtain(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong()) : (GroupMetadata) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public GroupMetadata[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new GroupMetadata[i2] : (GroupMetadata[]) invokeI.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(801276356, "Lcom/baidu/tieba/horizonalList/widget/ExpandableHListConnector$GroupMetadata;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(801276356, "Lcom/baidu/tieba/horizonalList/widget/ExpandableHListConnector$GroupMetadata;");
                    return;
                }
            }
            CREATOR = new a();
        }

        public GroupMetadata() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static GroupMetadata obtain(int i2, int i3, int i4, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2)})) == null) {
                GroupMetadata groupMetadata = new GroupMetadata();
                groupMetadata.flPos = i2;
                groupMetadata.lastChildFlPos = i3;
                groupMetadata.gPos = i4;
                groupMetadata.gId = j2;
                return groupMetadata;
            }
            return (GroupMetadata) invokeCommon.objValue;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i2) == null) {
                parcel.writeInt(this.flPos);
                parcel.writeInt(this.lastChildFlPos);
                parcel.writeInt(this.gPos);
                parcel.writeLong(this.gId);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(GroupMetadata groupMetadata) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, groupMetadata)) == null) {
                if (groupMetadata != null) {
                    return this.gPos - groupMetadata.gPos;
                }
                throw new IllegalArgumentException();
            }
            return invokeL.intValue;
        }
    }

    /* loaded from: classes12.dex */
    public class a extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ExpandableHListConnector a;

        public a(ExpandableHListConnector expandableHListConnector) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {expandableHListConnector};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = expandableHListConnector;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k(true, true);
                this.a.notifyDataSetChanged();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.k(true, true);
                this.a.notifyDataSetInvalidated();
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: d  reason: collision with root package name */
        public static ArrayList<b> f46326d;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.t0.p1.b.a a;

        /* renamed from: b  reason: collision with root package name */
        public GroupMetadata f46327b;

        /* renamed from: c  reason: collision with root package name */
        public int f46328c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1999866128, "Lcom/baidu/tieba/horizonalList/widget/ExpandableHListConnector$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1999866128, "Lcom/baidu/tieba/horizonalList/widget/ExpandableHListConnector$b;");
                    return;
                }
            }
            f46326d = new ArrayList<>(5);
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                synchronized (f46326d) {
                    if (f46326d.size() > 0) {
                        b remove = f46326d.remove(0);
                        remove.e();
                        return remove;
                    }
                    return new b();
                }
            }
            return (b) invokeV.objValue;
        }

        public static b c(int i2, int i3, int i4, int i5, GroupMetadata groupMetadata, int i6) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), groupMetadata, Integer.valueOf(i6)})) == null) {
                b a = a();
                a.a = c.a.t0.p1.b.a.c(i3, i4, i5, i2);
                a.f46327b = groupMetadata;
                a.f46328c = i6;
                return a;
            }
            return (b) invokeCommon.objValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f46327b != null : invokeV.booleanValue;
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                e();
                synchronized (f46326d) {
                    if (f46326d.size() < 5) {
                        f46326d.add(this);
                    }
                }
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                c.a.t0.p1.b.a aVar = this.a;
                if (aVar != null) {
                    aVar.g();
                    this.a = null;
                }
                this.f46327b = null;
                this.f46328c = 0;
            }
        }
    }

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {expandableListAdapter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f46324h = Integer.MAX_VALUE;
        this.f46325i = new a(this);
        this.f46322f = new ArrayList<>();
        l(expandableListAdapter);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f46321e.areAllItemsEnabled() : invokeV.booleanValue;
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            c.a.t0.p1.b.a c2 = c.a.t0.p1.b.a.c(2, i2, -1, -1);
            b h2 = h(c2);
            c2.g();
            if (h2 == null) {
                return false;
            }
            boolean c3 = c(h2);
            h2.d();
            return c3;
        }
        return invokeI.booleanValue;
    }

    public boolean c(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            GroupMetadata groupMetadata = bVar.f46327b;
            if (groupMetadata == null) {
                return false;
            }
            this.f46322f.remove(groupMetadata);
            k(false, false);
            notifyDataSetChanged();
            this.f46321e.onGroupCollapsed(bVar.f46327b.gPos);
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean d(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
            if (bVar.a.a >= 0) {
                if (this.f46324h != 0 && bVar.f46327b == null) {
                    if (this.f46322f.size() >= this.f46324h) {
                        GroupMetadata groupMetadata = this.f46322f.get(0);
                        int indexOf = this.f46322f.indexOf(groupMetadata);
                        b(groupMetadata.gPos);
                        int i2 = bVar.f46328c;
                        if (i2 > indexOf) {
                            bVar.f46328c = i2 - 1;
                        }
                    }
                    int i3 = bVar.a.a;
                    GroupMetadata obtain = GroupMetadata.obtain(-1, -1, i3, this.f46321e.getGroupId(i3));
                    this.f46322f.add(bVar.f46328c, obtain);
                    k(false, false);
                    notifyDataSetChanged();
                    this.f46321e.onGroupExpanded(obtain.gPos);
                    return true;
                }
                return false;
            }
            throw new RuntimeException("Need group");
        }
        return invokeL.booleanValue;
    }

    public int e(long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) {
            int groupCount = this.f46321e.getGroupCount();
            if (groupCount == 0 || j2 == Long.MIN_VALUE) {
                return -1;
            }
            int i3 = groupCount - 1;
            int min = Math.min(i3, Math.max(0, i2));
            long uptimeMillis = SystemClock.uptimeMillis() + 100;
            ExpandableListAdapter f2 = f();
            if (f2 == null) {
                return -1;
            }
            int i4 = min;
            int i5 = i4;
            loop0: while (true) {
                boolean z = false;
                while (SystemClock.uptimeMillis() <= uptimeMillis) {
                    if (f2.getGroupId(min) != j2) {
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
            return -1;
        }
        return invokeCommon.intValue;
    }

    public ExpandableListAdapter f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f46321e : (ExpandableListAdapter) invokeV.objValue;
    }

    public ArrayList<GroupMetadata> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f46322f : (ArrayList) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f46321e.getGroupCount() + this.f46323g : invokeV.intValue;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ExpandableListAdapter f2 = f();
            if (f2 instanceof Filterable) {
                return ((Filterable) f2).getFilter();
            }
            return null;
        }
        return (Filter) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Object child;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            b i3 = i(i2);
            c.a.t0.p1.b.a aVar = i3.a;
            int i4 = aVar.f21977d;
            if (i4 == 2) {
                child = this.f46321e.getGroup(aVar.a);
            } else if (i4 == 1) {
                child = this.f46321e.getChild(aVar.a, aVar.f21975b);
            } else {
                throw new RuntimeException("Flat list position is of unknown type");
            }
            i3.d();
            return child;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        long combinedChildId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            b i3 = i(i2);
            long groupId = this.f46321e.getGroupId(i3.a.a);
            c.a.t0.p1.b.a aVar = i3.a;
            int i4 = aVar.f21977d;
            if (i4 == 2) {
                combinedChildId = this.f46321e.getCombinedGroupId(groupId);
            } else if (i4 == 1) {
                combinedChildId = this.f46321e.getCombinedChildId(groupId, this.f46321e.getChildId(aVar.a, aVar.f21975b));
            } else {
                throw new RuntimeException("Flat list position is of unknown type");
            }
            i3.d();
            return combinedChildId;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            b i4 = i(i2);
            c.a.t0.p1.b.a aVar = i4.a;
            ExpandableListAdapter expandableListAdapter = this.f46321e;
            if (expandableListAdapter instanceof HeterogeneousExpandableList) {
                HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) expandableListAdapter;
                if (aVar.f21977d == 2) {
                    i3 = heterogeneousExpandableList.getGroupType(aVar.a);
                } else {
                    i3 = heterogeneousExpandableList.getChildType(aVar.a, aVar.f21975b) + heterogeneousExpandableList.getGroupTypeCount();
                }
            } else {
                i3 = aVar.f21977d == 2 ? 0 : 1;
            }
            i4.d();
            return i3;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        View childView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048588, this, i2, view, viewGroup)) == null) {
            b i3 = i(i2);
            c.a.t0.p1.b.a aVar = i3.a;
            int i4 = aVar.f21977d;
            if (i4 == 2) {
                childView = this.f46321e.getGroupView(aVar.a, i3.b(), view, viewGroup);
            } else if (i4 == 1) {
                boolean z = i3.f46327b.lastChildFlPos == i2;
                ExpandableListAdapter expandableListAdapter = this.f46321e;
                c.a.t0.p1.b.a aVar2 = i3.a;
                childView = expandableListAdapter.getChildView(aVar2.a, aVar2.f21975b, z, view, viewGroup);
            } else {
                throw new RuntimeException("Flat list position is of unknown type");
            }
            i3.d();
            return childView;
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ExpandableListAdapter expandableListAdapter = this.f46321e;
            if (expandableListAdapter instanceof HeterogeneousExpandableList) {
                HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) expandableListAdapter;
                return heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildTypeCount();
            }
            return 2;
        }
        return invokeV.intValue;
    }

    public b h(c.a.t0.p1.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, aVar)) == null) {
            ArrayList<GroupMetadata> arrayList = this.f46322f;
            int size = arrayList.size();
            int i2 = size - 1;
            if (size == 0) {
                int i3 = aVar.a;
                return b.c(i3, aVar.f21977d, i3, aVar.f21975b, null, 0);
            }
            int i4 = 0;
            int i5 = 0;
            while (i5 <= i2) {
                i4 = ((i2 - i5) / 2) + i5;
                GroupMetadata groupMetadata = arrayList.get(i4);
                int i6 = aVar.a;
                int i7 = groupMetadata.gPos;
                if (i6 > i7) {
                    i5 = i4 + 1;
                } else if (i6 < i7) {
                    i2 = i4 - 1;
                } else if (i6 == i7) {
                    int i8 = aVar.f21977d;
                    if (i8 == 2) {
                        return b.c(groupMetadata.flPos, i8, i6, aVar.f21975b, groupMetadata, i4);
                    }
                    if (i8 == 1) {
                        int i9 = groupMetadata.flPos;
                        int i10 = aVar.f21975b;
                        return b.c(i9 + i10 + 1, i8, i6, i10, groupMetadata, i4);
                    }
                    return null;
                }
            }
            if (aVar.f21977d != 2) {
                return null;
            }
            if (i5 > i4) {
                GroupMetadata groupMetadata2 = arrayList.get(i5 - 1);
                int i11 = groupMetadata2.lastChildFlPos;
                int i12 = aVar.a;
                return b.c(i11 + (i12 - groupMetadata2.gPos), aVar.f21977d, i12, aVar.f21975b, null, i5);
            } else if (i2 < i4) {
                int i13 = 1 + i2;
                GroupMetadata groupMetadata3 = arrayList.get(i13);
                int i14 = groupMetadata3.flPos;
                int i15 = groupMetadata3.gPos;
                int i16 = aVar.a;
                return b.c(i14 - (i15 - i16), aVar.f21977d, i16, aVar.f21975b, null, i13);
            } else {
                return null;
            }
        }
        return (b) invokeL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f46321e.hasStableIds() : invokeV.booleanValue;
    }

    public b i(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            ArrayList<GroupMetadata> arrayList = this.f46322f;
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
                int i9 = groupMetadata.lastChildFlPos;
                if (i2 > i9) {
                    i5 = i8 + 1;
                } else {
                    int i10 = groupMetadata.flPos;
                    if (i2 < i10) {
                        i6 = i8 - 1;
                    } else if (i2 == i10) {
                        return b.c(i2, 2, groupMetadata.gPos, -1, groupMetadata, i8);
                    } else {
                        if (i2 <= i9) {
                            return b.c(i2, 1, groupMetadata.gPos, i2 - (i10 + 1), groupMetadata, i8);
                        }
                    }
                }
                i7 = i8;
            }
            if (i5 > i7) {
                GroupMetadata groupMetadata2 = arrayList.get(i5 - 1);
                i3 = (i2 - groupMetadata2.lastChildFlPos) + groupMetadata2.gPos;
            } else if (i6 < i7) {
                i5 = i6 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i5);
                i3 = groupMetadata3.gPos - (groupMetadata3.flPos - i2);
            } else {
                throw new RuntimeException("Unknown state");
            }
            return b.c(i2, 2, i3, -1, null, i5);
        }
        return (b) invokeI.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            ExpandableListAdapter f2 = f();
            if (f2 != null) {
                return f2.isEmpty();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            b i3 = i(i2);
            c.a.t0.p1.b.a aVar = i3.a;
            boolean isChildSelectable = aVar.f21977d == 1 ? this.f46321e.isChildSelectable(aVar.a, aVar.f21975b) : true;
            i3.d();
            return isChildSelectable;
        }
        return invokeI.booleanValue;
    }

    public boolean j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            for (int size = this.f46322f.size() - 1; size >= 0; size--) {
                if (this.f46322f.get(size).gPos == i2) {
                    return true;
                }
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void k(boolean z, boolean z2) {
        int childrenCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ArrayList<GroupMetadata> arrayList = this.f46322f;
            int size = arrayList.size();
            int i2 = 0;
            this.f46323g = 0;
            if (z2) {
                boolean z3 = false;
                for (int i3 = size - 1; i3 >= 0; i3--) {
                    GroupMetadata groupMetadata = arrayList.get(i3);
                    int e2 = e(groupMetadata.gId, groupMetadata.gPos);
                    if (e2 != groupMetadata.gPos) {
                        if (e2 == -1) {
                            arrayList.remove(i3);
                            size--;
                        }
                        groupMetadata.gPos = e2;
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
                int i6 = groupMetadata2.lastChildFlPos;
                if (i6 != -1 && !z) {
                    childrenCount = i6 - groupMetadata2.flPos;
                } else {
                    childrenCount = this.f46321e.getChildrenCount(groupMetadata2.gPos);
                }
                this.f46323g += childrenCount;
                int i7 = groupMetadata2.gPos;
                int i8 = i4 + (i7 - i5);
                groupMetadata2.flPos = i8;
                i4 = i8 + childrenCount;
                groupMetadata2.lastChildFlPos = i4;
                i2++;
                i5 = i7;
            }
        }
    }

    public void l(ExpandableListAdapter expandableListAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, expandableListAdapter) == null) {
            ExpandableListAdapter expandableListAdapter2 = this.f46321e;
            if (expandableListAdapter2 != null) {
                expandableListAdapter2.unregisterDataSetObserver(this.f46325i);
            }
            this.f46321e = expandableListAdapter;
            expandableListAdapter.registerDataSetObserver(this.f46325i);
        }
    }

    public void m(ArrayList<GroupMetadata> arrayList) {
        ExpandableListAdapter expandableListAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, arrayList) == null) || arrayList == null || (expandableListAdapter = this.f46321e) == null) {
            return;
        }
        int groupCount = expandableListAdapter.getGroupCount();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).gPos >= groupCount) {
                return;
            }
        }
        this.f46322f = arrayList;
        k(true, false);
    }
}
