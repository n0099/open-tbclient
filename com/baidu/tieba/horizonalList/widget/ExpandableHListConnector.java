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
/* loaded from: classes5.dex */
public class ExpandableHListConnector extends BaseAdapter implements Filterable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ExpandableListAdapter f16987e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<GroupMetadata> f16988f;

    /* renamed from: g  reason: collision with root package name */
    public int f16989g;

    /* renamed from: h  reason: collision with root package name */
    public int f16990h;

    /* renamed from: i  reason: collision with root package name */
    public final DataSetObserver f16991i;

    /* loaded from: classes5.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final Parcelable.Creator<GroupMetadata> CREATOR;
        public static final int REFRESH = -1;
        public transient /* synthetic */ FieldHolder $fh;
        public int flPos;
        public long gId;
        public int gPos;
        public int lastChildFlPos;

        /* loaded from: classes5.dex */
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

        public static GroupMetadata obtain(int i2, int i3, int i4, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j)})) == null) {
                GroupMetadata groupMetadata = new GroupMetadata();
                groupMetadata.flPos = i2;
                groupMetadata.lastChildFlPos = i3;
                groupMetadata.gPos = i4;
                groupMetadata.gId = j;
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

    /* loaded from: classes5.dex */
    public class a extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ExpandableHListConnector f16992a;

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
            this.f16992a = expandableHListConnector;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16992a.j(true, true);
                this.f16992a.notifyDataSetChanged();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f16992a.j(true, true);
                this.f16992a.notifyDataSetInvalidated();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: d  reason: collision with root package name */
        public static ArrayList<b> f16993d;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public d.a.s0.f1.b.a f16994a;

        /* renamed from: b  reason: collision with root package name */
        public GroupMetadata f16995b;

        /* renamed from: c  reason: collision with root package name */
        public int f16996c;

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
            f16993d = new ArrayList<>(5);
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
                synchronized (f16993d) {
                    if (f16993d.size() > 0) {
                        b remove = f16993d.remove(0);
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
                b a2 = a();
                a2.f16994a = d.a.s0.f1.b.a.c(i3, i4, i5, i2);
                a2.f16995b = groupMetadata;
                a2.f16996c = i6;
                return a2;
            }
            return (b) invokeCommon.objValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16995b != null : invokeV.booleanValue;
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                e();
                synchronized (f16993d) {
                    if (f16993d.size() < 5) {
                        f16993d.add(this);
                    }
                }
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                d.a.s0.f1.b.a aVar = this.f16994a;
                if (aVar != null) {
                    aVar.e();
                    this.f16994a = null;
                }
                this.f16995b = null;
                this.f16996c = 0;
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
        this.f16990h = Integer.MAX_VALUE;
        this.f16991i = new a(this);
        this.f16988f = new ArrayList<>();
        k(expandableListAdapter);
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f16987e.areAllItemsEnabled() : invokeV.booleanValue;
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            d.a.s0.f1.b.a c2 = d.a.s0.f1.b.a.c(2, i2, -1, -1);
            b h2 = h(c2);
            c2.e();
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
            GroupMetadata groupMetadata = bVar.f16995b;
            if (groupMetadata == null) {
                return false;
            }
            this.f16988f.remove(groupMetadata);
            j(false, false);
            notifyDataSetChanged();
            this.f16987e.onGroupCollapsed(bVar.f16995b.gPos);
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean d(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
            if (bVar.f16994a.f59446a >= 0) {
                if (this.f16990h != 0 && bVar.f16995b == null) {
                    if (this.f16988f.size() >= this.f16990h) {
                        GroupMetadata groupMetadata = this.f16988f.get(0);
                        int indexOf = this.f16988f.indexOf(groupMetadata);
                        b(groupMetadata.gPos);
                        int i2 = bVar.f16996c;
                        if (i2 > indexOf) {
                            bVar.f16996c = i2 - 1;
                        }
                    }
                    int i3 = bVar.f16994a.f59446a;
                    GroupMetadata obtain = GroupMetadata.obtain(-1, -1, i3, this.f16987e.getGroupId(i3));
                    this.f16988f.add(bVar.f16996c, obtain);
                    j(false, false);
                    notifyDataSetChanged();
                    this.f16987e.onGroupExpanded(obtain.gPos);
                    return true;
                }
                return false;
            }
            throw new RuntimeException("Need group");
        }
        return invokeL.booleanValue;
    }

    public int e(long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            int groupCount = this.f16987e.getGroupCount();
            if (groupCount == 0 || j == Long.MIN_VALUE) {
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
            return -1;
        }
        return invokeCommon.intValue;
    }

    public ExpandableListAdapter f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f16987e : (ExpandableListAdapter) invokeV.objValue;
    }

    public ArrayList<GroupMetadata> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f16988f : (ArrayList) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f16987e.getGroupCount() + this.f16989g : invokeV.intValue;
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
            d.a.s0.f1.b.a aVar = i3.f16994a;
            int i4 = aVar.f59449d;
            if (i4 == 2) {
                child = this.f16987e.getGroup(aVar.f59446a);
            } else if (i4 == 1) {
                child = this.f16987e.getChild(aVar.f59446a, aVar.f59447b);
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
            long groupId = this.f16987e.getGroupId(i3.f16994a.f59446a);
            d.a.s0.f1.b.a aVar = i3.f16994a;
            int i4 = aVar.f59449d;
            if (i4 == 2) {
                combinedChildId = this.f16987e.getCombinedGroupId(groupId);
            } else if (i4 == 1) {
                combinedChildId = this.f16987e.getCombinedChildId(groupId, this.f16987e.getChildId(aVar.f59446a, aVar.f59447b));
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
            d.a.s0.f1.b.a aVar = i4.f16994a;
            ExpandableListAdapter expandableListAdapter = this.f16987e;
            if (expandableListAdapter instanceof HeterogeneousExpandableList) {
                HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) expandableListAdapter;
                if (aVar.f59449d == 2) {
                    i3 = heterogeneousExpandableList.getGroupType(aVar.f59446a);
                } else {
                    i3 = heterogeneousExpandableList.getChildType(aVar.f59446a, aVar.f59447b) + heterogeneousExpandableList.getGroupTypeCount();
                }
            } else {
                i3 = aVar.f59449d == 2 ? 0 : 1;
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
            d.a.s0.f1.b.a aVar = i3.f16994a;
            int i4 = aVar.f59449d;
            if (i4 == 2) {
                childView = this.f16987e.getGroupView(aVar.f59446a, i3.b(), view, viewGroup);
            } else if (i4 == 1) {
                boolean z = i3.f16995b.lastChildFlPos == i2;
                ExpandableListAdapter expandableListAdapter = this.f16987e;
                d.a.s0.f1.b.a aVar2 = i3.f16994a;
                childView = expandableListAdapter.getChildView(aVar2.f59446a, aVar2.f59447b, z, view, viewGroup);
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
            ExpandableListAdapter expandableListAdapter = this.f16987e;
            if (expandableListAdapter instanceof HeterogeneousExpandableList) {
                HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) expandableListAdapter;
                return heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildTypeCount();
            }
            return 2;
        }
        return invokeV.intValue;
    }

    public b h(d.a.s0.f1.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, aVar)) == null) {
            ArrayList<GroupMetadata> arrayList = this.f16988f;
            int size = arrayList.size();
            int i2 = size - 1;
            if (size == 0) {
                int i3 = aVar.f59446a;
                return b.c(i3, aVar.f59449d, i3, aVar.f59447b, null, 0);
            }
            int i4 = 0;
            int i5 = 0;
            while (i5 <= i2) {
                i4 = ((i2 - i5) / 2) + i5;
                GroupMetadata groupMetadata = arrayList.get(i4);
                int i6 = aVar.f59446a;
                int i7 = groupMetadata.gPos;
                if (i6 > i7) {
                    i5 = i4 + 1;
                } else if (i6 < i7) {
                    i2 = i4 - 1;
                } else if (i6 == i7) {
                    int i8 = aVar.f59449d;
                    if (i8 == 2) {
                        return b.c(groupMetadata.flPos, i8, i6, aVar.f59447b, groupMetadata, i4);
                    }
                    if (i8 == 1) {
                        int i9 = groupMetadata.flPos;
                        int i10 = aVar.f59447b;
                        return b.c(i9 + i10 + 1, i8, i6, i10, groupMetadata, i4);
                    }
                    return null;
                }
            }
            if (aVar.f59449d != 2) {
                return null;
            }
            if (i5 > i4) {
                GroupMetadata groupMetadata2 = arrayList.get(i5 - 1);
                int i11 = groupMetadata2.lastChildFlPos;
                int i12 = aVar.f59446a;
                return b.c(i11 + (i12 - groupMetadata2.gPos), aVar.f59449d, i12, aVar.f59447b, null, i5);
            } else if (i2 < i4) {
                int i13 = 1 + i2;
                GroupMetadata groupMetadata3 = arrayList.get(i13);
                int i14 = groupMetadata3.flPos;
                int i15 = groupMetadata3.gPos;
                int i16 = aVar.f59446a;
                return b.c(i14 - (i15 - i16), aVar.f59449d, i16, aVar.f59447b, null, i13);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f16987e.hasStableIds() : invokeV.booleanValue;
    }

    public b i(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            ArrayList<GroupMetadata> arrayList = this.f16988f;
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
            d.a.s0.f1.b.a aVar = i3.f16994a;
            boolean isChildSelectable = aVar.f59449d == 1 ? this.f16987e.isChildSelectable(aVar.f59446a, aVar.f59447b) : true;
            i3.d();
            return isChildSelectable;
        }
        return invokeI.booleanValue;
    }

    public final void j(boolean z, boolean z2) {
        int childrenCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ArrayList<GroupMetadata> arrayList = this.f16988f;
            int size = arrayList.size();
            int i2 = 0;
            this.f16989g = 0;
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
                    childrenCount = this.f16987e.getChildrenCount(groupMetadata2.gPos);
                }
                this.f16989g += childrenCount;
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

    public void k(ExpandableListAdapter expandableListAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, expandableListAdapter) == null) {
            ExpandableListAdapter expandableListAdapter2 = this.f16987e;
            if (expandableListAdapter2 != null) {
                expandableListAdapter2.unregisterDataSetObserver(this.f16991i);
            }
            this.f16987e = expandableListAdapter;
            expandableListAdapter.registerDataSetObserver(this.f16991i);
        }
    }

    public void l(ArrayList<GroupMetadata> arrayList) {
        ExpandableListAdapter expandableListAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, arrayList) == null) || arrayList == null || (expandableListAdapter = this.f16987e) == null) {
            return;
        }
        int groupCount = expandableListAdapter.getGroupCount();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).gPos >= groupCount) {
                return;
            }
        }
        this.f16988f = arrayList;
        j(true, false);
    }
}
