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
import com.baidu.tieba.xv7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes4.dex */
public class ExpandableHListConnector extends BaseAdapter implements Filterable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ExpandableListAdapter a;
    public ArrayList<GroupMetadata> b;
    public int c;
    public int d;
    public final DataSetObserver e;

    /* loaded from: classes4.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final Parcelable.Creator<GroupMetadata> CREATOR;
        public static final int REFRESH = -1;
        public transient /* synthetic */ FieldHolder $fh;
        public int flPos;
        public long gId;
        public int gPos;
        public int lastChildFlPos;

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        /* loaded from: classes4.dex */
        public static class a implements Parcelable.Creator<GroupMetadata> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                    return GroupMetadata.obtain(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
                }
                return (GroupMetadata) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public GroupMetadata[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                    return new GroupMetadata[i];
                }
                return (GroupMetadata[]) invokeI.objValue;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static GroupMetadata obtain(int i, int i2, int i3, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)})) == null) {
                GroupMetadata groupMetadata = new GroupMetadata();
                groupMetadata.flPos = i;
                groupMetadata.lastChildFlPos = i2;
                groupMetadata.gPos = i3;
                groupMetadata.gId = j;
                return groupMetadata;
            }
            return (GroupMetadata) invokeCommon.objValue;
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

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i) == null) {
                parcel.writeInt(this.flPos);
                parcel.writeInt(this.lastChildFlPos);
                parcel.writeInt(this.gPos);
                parcel.writeLong(this.gId);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.j(true, true);
                this.a.notifyDataSetChanged();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.j(true, true);
                this.a.notifyDataSetInvalidated();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static ArrayList<b> d;
        public transient /* synthetic */ FieldHolder $fh;
        public xv7 a;
        public GroupMetadata b;
        public int c;

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
            d = new ArrayList<>(5);
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.b != null) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                e();
                synchronized (d) {
                    if (d.size() < 5) {
                        d.add(this);
                    }
                }
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                xv7 xv7Var = this.a;
                if (xv7Var != null) {
                    xv7Var.e();
                    this.a = null;
                }
                this.b = null;
                this.c = 0;
            }
        }

        public static b a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                synchronized (d) {
                    if (d.size() > 0) {
                        b remove = d.remove(0);
                        remove.e();
                        return remove;
                    }
                    return new b();
                }
            }
            return (b) invokeV.objValue;
        }

        public static b c(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), groupMetadata, Integer.valueOf(i5)})) == null) {
                b a = a();
                a.a = xv7.c(i2, i3, i4, i);
                a.b = groupMetadata;
                a.c = i5;
                return a;
            }
            return (b) invokeCommon.objValue;
        }
    }

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {expandableListAdapter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = Integer.MAX_VALUE;
        this.e = new a(this);
        this.b = new ArrayList<>();
        k(expandableListAdapter);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Object child;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            b i2 = i(i);
            xv7 xv7Var = i2.a;
            int i3 = xv7Var.d;
            if (i3 == 2) {
                child = this.a.getGroup(xv7Var.a);
            } else if (i3 == 1) {
                child = this.a.getChild(xv7Var.a, xv7Var.b);
            } else {
                throw new RuntimeException("Flat list position is of unknown type");
            }
            i2.d();
            return child;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            b i3 = i(i);
            xv7 xv7Var = i3.a;
            ExpandableListAdapter expandableListAdapter = this.a;
            if (expandableListAdapter instanceof HeterogeneousExpandableList) {
                HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) expandableListAdapter;
                if (xv7Var.d == 2) {
                    i2 = heterogeneousExpandableList.getGroupType(xv7Var.a);
                } else {
                    i2 = heterogeneousExpandableList.getChildType(xv7Var.a, xv7Var.b) + heterogeneousExpandableList.getGroupTypeCount();
                }
            } else if (xv7Var.d == 2) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            i3.d();
            return i2;
        }
        return invokeI.intValue;
    }

    public void l(ArrayList<GroupMetadata> arrayList) {
        ExpandableListAdapter expandableListAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, arrayList) == null) && arrayList != null && (expandableListAdapter = this.a) != null) {
            int groupCount = expandableListAdapter.getGroupCount();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size).gPos >= groupCount) {
                    return;
                }
            }
            this.b = arrayList;
            j(true, false);
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a.areAllItemsEnabled();
        }
        return invokeV.booleanValue;
    }

    public ExpandableListAdapter f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (ExpandableListAdapter) invokeV.objValue;
    }

    public ArrayList<GroupMetadata> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a.getGroupCount() + this.c;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ExpandableListAdapter f = f();
            if (f instanceof Filterable) {
                return ((Filterable) f).getFilter();
            }
            return null;
        }
        return (Filter) invokeV.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ExpandableListAdapter expandableListAdapter = this.a;
            if (expandableListAdapter instanceof HeterogeneousExpandableList) {
                HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) expandableListAdapter;
                return heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildTypeCount();
            }
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.a.hasStableIds();
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            ExpandableListAdapter f = f();
            if (f != null) {
                return f.isEmpty();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            xv7 c = xv7.c(2, i, -1, -1);
            b h = h(c);
            c.e();
            if (h == null) {
                return false;
            }
            boolean c2 = c(h);
            h.d();
            return c2;
        }
        return invokeI.booleanValue;
    }

    public boolean c(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar)) == null) {
            GroupMetadata groupMetadata = bVar.b;
            if (groupMetadata == null) {
                return false;
            }
            this.b.remove(groupMetadata);
            j(false, false);
            notifyDataSetChanged();
            this.a.onGroupCollapsed(bVar.b.gPos);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            b i2 = i(i);
            xv7 xv7Var = i2.a;
            boolean z = true;
            if (xv7Var.d == 1) {
                z = this.a.isChildSelectable(xv7Var.a, xv7Var.b);
            }
            i2.d();
            return z;
        }
        return invokeI.booleanValue;
    }

    public void k(ExpandableListAdapter expandableListAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, expandableListAdapter) == null) {
            ExpandableListAdapter expandableListAdapter2 = this.a;
            if (expandableListAdapter2 != null) {
                expandableListAdapter2.unregisterDataSetObserver(this.e);
            }
            this.a = expandableListAdapter;
            expandableListAdapter.registerDataSetObserver(this.e);
        }
    }

    public boolean d(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bVar)) == null) {
            if (bVar.a.a >= 0) {
                if (this.d == 0 || bVar.b != null) {
                    return false;
                }
                if (this.b.size() >= this.d) {
                    GroupMetadata groupMetadata = this.b.get(0);
                    int indexOf = this.b.indexOf(groupMetadata);
                    b(groupMetadata.gPos);
                    int i = bVar.c;
                    if (i > indexOf) {
                        bVar.c = i - 1;
                    }
                }
                int i2 = bVar.a.a;
                GroupMetadata obtain = GroupMetadata.obtain(-1, -1, i2, this.a.getGroupId(i2));
                this.b.add(bVar.c, obtain);
                j(false, false);
                notifyDataSetChanged();
                this.a.onGroupExpanded(obtain.gPos);
                return true;
            }
            throw new RuntimeException("Need group");
        }
        return invokeL.booleanValue;
    }

    public int e(long j, int i) {
        InterceptResult invokeCommon;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            int groupCount = this.a.getGroupCount();
            if (groupCount == 0 || j == Long.MIN_VALUE) {
                return -1;
            }
            int i2 = groupCount - 1;
            int min = Math.min(i2, Math.max(0, i));
            long uptimeMillis = SystemClock.uptimeMillis() + 100;
            ExpandableListAdapter f = f();
            if (f == null) {
                return -1;
            }
            int i3 = min;
            int i4 = i3;
            loop0: while (true) {
                boolean z3 = false;
                while (SystemClock.uptimeMillis() <= uptimeMillis) {
                    if (f.getGroupId(min) == j) {
                        return min;
                    }
                    if (i3 == i2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (i4 == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && z2) {
                        break loop0;
                    } else if (!z2 && (!z3 || z)) {
                        if (z || (!z3 && !z2)) {
                            i4--;
                            min = i4;
                            z3 = true;
                        }
                    } else {
                        i3++;
                        min = i3;
                    }
                }
                break loop0;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    public final void j(boolean z, boolean z2) {
        int childrenCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ArrayList<GroupMetadata> arrayList = this.b;
            int size = arrayList.size();
            int i = 0;
            this.c = 0;
            if (z2) {
                boolean z3 = false;
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    GroupMetadata groupMetadata = arrayList.get(i2);
                    int e = e(groupMetadata.gId, groupMetadata.gPos);
                    if (e != groupMetadata.gPos) {
                        if (e == -1) {
                            arrayList.remove(i2);
                            size--;
                        }
                        groupMetadata.gPos = e;
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
                int i5 = groupMetadata2.lastChildFlPos;
                if (i5 != -1 && !z) {
                    childrenCount = i5 - groupMetadata2.flPos;
                } else {
                    childrenCount = this.a.getChildrenCount(groupMetadata2.gPos);
                }
                this.c += childrenCount;
                int i6 = groupMetadata2.gPos;
                int i7 = i3 + (i6 - i4);
                groupMetadata2.flPos = i7;
                i3 = i7 + childrenCount;
                groupMetadata2.lastChildFlPos = i3;
                i++;
                i4 = i6;
            }
        }
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        long combinedChildId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            b i2 = i(i);
            long groupId = this.a.getGroupId(i2.a.a);
            xv7 xv7Var = i2.a;
            int i3 = xv7Var.d;
            if (i3 == 2) {
                combinedChildId = this.a.getCombinedGroupId(groupId);
            } else if (i3 == 1) {
                combinedChildId = this.a.getCombinedChildId(groupId, this.a.getChildId(xv7Var.a, xv7Var.b));
            } else {
                throw new RuntimeException("Flat list position is of unknown type");
            }
            i2.d();
            return combinedChildId;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        boolean z;
        View childView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048588, this, i, view2, viewGroup)) == null) {
            b i2 = i(i);
            xv7 xv7Var = i2.a;
            int i3 = xv7Var.d;
            if (i3 == 2) {
                childView = this.a.getGroupView(xv7Var.a, i2.b(), view2, viewGroup);
            } else if (i3 == 1) {
                if (i2.b.lastChildFlPos == i) {
                    z = true;
                } else {
                    z = false;
                }
                ExpandableListAdapter expandableListAdapter = this.a;
                xv7 xv7Var2 = i2.a;
                childView = expandableListAdapter.getChildView(xv7Var2.a, xv7Var2.b, z, view2, viewGroup);
            } else {
                throw new RuntimeException("Flat list position is of unknown type");
            }
            i2.d();
            return childView;
        }
        return (View) invokeILL.objValue;
    }

    public b h(xv7 xv7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, xv7Var)) == null) {
            ArrayList<GroupMetadata> arrayList = this.b;
            int size = arrayList.size();
            int i = size - 1;
            if (size == 0) {
                int i2 = xv7Var.a;
                return b.c(i2, xv7Var.d, i2, xv7Var.b, null, 0);
            }
            int i3 = 0;
            int i4 = 0;
            while (i4 <= i) {
                i3 = ((i - i4) / 2) + i4;
                GroupMetadata groupMetadata = arrayList.get(i3);
                int i5 = xv7Var.a;
                int i6 = groupMetadata.gPos;
                if (i5 > i6) {
                    i4 = i3 + 1;
                } else if (i5 < i6) {
                    i = i3 - 1;
                } else if (i5 == i6) {
                    int i7 = xv7Var.d;
                    if (i7 == 2) {
                        return b.c(groupMetadata.flPos, i7, i5, xv7Var.b, groupMetadata, i3);
                    }
                    if (i7 != 1) {
                        return null;
                    }
                    int i8 = groupMetadata.flPos;
                    int i9 = xv7Var.b;
                    return b.c(i8 + i9 + 1, i7, i5, i9, groupMetadata, i3);
                }
            }
            if (xv7Var.d != 2) {
                return null;
            }
            if (i4 > i3) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                int i10 = groupMetadata2.lastChildFlPos;
                int i11 = xv7Var.a;
                return b.c(i10 + (i11 - groupMetadata2.gPos), xv7Var.d, i11, xv7Var.b, null, i4);
            } else if (i >= i3) {
                return null;
            } else {
                int i12 = 1 + i;
                GroupMetadata groupMetadata3 = arrayList.get(i12);
                int i13 = groupMetadata3.flPos;
                int i14 = groupMetadata3.gPos;
                int i15 = xv7Var.a;
                return b.c(i13 - (i14 - i15), xv7Var.d, i15, xv7Var.b, null, i12);
            }
        }
        return (b) invokeL.objValue;
    }

    public b i(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            ArrayList<GroupMetadata> arrayList = this.b;
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
                int i8 = groupMetadata.lastChildFlPos;
                if (i > i8) {
                    i4 = i7 + 1;
                } else {
                    int i9 = groupMetadata.flPos;
                    if (i < i9) {
                        i5 = i7 - 1;
                    } else if (i == i9) {
                        return b.c(i, 2, groupMetadata.gPos, -1, groupMetadata, i7);
                    } else {
                        if (i <= i8) {
                            return b.c(i, 1, groupMetadata.gPos, i - (i9 + 1), groupMetadata, i7);
                        }
                    }
                }
                i6 = i7;
            }
            if (i4 > i6) {
                GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
                i2 = (i - groupMetadata2.lastChildFlPos) + groupMetadata2.gPos;
            } else if (i5 < i6) {
                i4 = i5 + 1;
                GroupMetadata groupMetadata3 = arrayList.get(i4);
                i2 = groupMetadata3.gPos - (groupMetadata3.flPos - i);
            } else {
                throw new RuntimeException("Unknown state");
            }
            return b.c(i, 2, i2, -1, null, i4);
        }
        return (b) invokeI.objValue;
    }
}
