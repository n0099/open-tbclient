package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public class hf9 implements nz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Object> a;
    public sz5 b;
    public tf9 c;
    public en d;
    public en e;
    public en f;
    public en g;
    public en h;

    @Override // com.baidu.tieba.nz5
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.baidu.tieba.qz5
    public void b(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
        }
    }

    public hf9() {
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

    @Override // com.baidu.tieba.nz5
    public List<Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(AdvertAppInfo.z.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.w.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.A.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.B.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.C.getId()));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nz5
    public void e(List<mz5> list, String str, String str2, String str3, String str4, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{list, str, str2, str3, str4, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || yi8.e(list)) {
            return;
        }
        Set<rn> a = jh9.a("FRS");
        if (a == null) {
            a = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (mz5 mz5Var : list) {
            if (mz5Var != null) {
                Object a2 = mz5Var.a();
                for (rn rnVar : a) {
                    if (a2 != null && mz5Var.c() == 3 && (a2 instanceof AdvertAppInfo) && rnVar != null && (rnVar instanceof AdvertAppInfo) && a2.hashCode() == rnVar.hashCode()) {
                        ((AdvertAppInfo) a2).i = ((AdvertAppInfo) rnVar).i;
                    }
                }
                if (a2 != null && mz5Var.c() == 3 && (a2 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a2;
                    if (advertAppInfo.i == null) {
                        oy4 oy4Var = new oy4();
                        advertAppInfo.i = oy4Var;
                        oy4Var.a = "FRS";
                        String.valueOf(z);
                        oy4 oy4Var2 = advertAppInfo.i;
                        oy4Var2.b = i;
                        oy4Var2.c = str;
                        oy4Var2.d = str2;
                        oy4Var2.e = str3;
                        oy4Var2.f = str4;
                        oy4Var2.g = advertAppInfo.g;
                        oy4Var2.h = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a.addAll(hashSet);
        jh9.b("FRS", a);
    }

    @Override // com.baidu.tieba.nz5
    public TypeAdapter.ViewHolder g(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        en enVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, viewGroup, obj)) == null) {
            if (!(obj instanceof AdvertAppInfo)) {
                return null;
            }
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.z) {
                enVar = this.e;
            } else if (type == AdvertAppInfo.w) {
                enVar = this.d;
            } else if (type == AdvertAppInfo.A) {
                enVar = this.f;
            } else if (type == AdvertAppInfo.B) {
                enVar = this.g;
            } else if (type == AdvertAppInfo.C) {
                enVar = this.h;
            } else {
                enVar = null;
            }
            if (enVar == null) {
                return null;
            }
            return enVar.onCreateViewHolder(viewGroup, obj);
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qz5
    /* renamed from: q */
    public void f(sz5 sz5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, sz5Var, str) == null) {
            this.b = sz5Var;
            if (sz5Var != null && (sz5Var.a() instanceof tf9)) {
                this.c = (tf9) this.b.a();
                this.d = new cg9(this.c, AdvertAppInfo.w);
                this.e = new dg9(this.c, AdvertAppInfo.z, str);
                this.f = new dg9(this.c, AdvertAppInfo.A, str);
                this.g = new dg9(this.c, AdvertAppInfo.B, str);
                this.h = new dg9(this.c, AdvertAppInfo.C, str);
            }
        }
    }

    @Override // com.baidu.tieba.nz5
    public void i(List<mz5> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048582, this, list, i) != null) || yi8.e(this.a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                yi8.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<mz5> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i2 = yi8.i(list);
        int i3 = 0;
        int i4 = 0;
        for (mz5 mz5Var : list) {
            if (mz5Var.c() == 1) {
                i4++;
            }
        }
        int i5 = yi8.i(arrayList);
        if (i5 < 1) {
            return;
        }
        int i6 = i2 - i4;
        HashSet hashSet = new HashSet();
        int i7 = 0;
        while (i7 < i5) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) yi8.d(arrayList, i7);
            advertAppInfo.j = "FRS";
            int i8 = advertAppInfo.i();
            if (i8 != 0) {
                lh9.h(advertAppInfo, i, i8);
                if (i8 != 28 && i8 != 31) {
                    advertAppInfo.c = -1001;
                }
                i7++;
                i3 = 0;
            }
            if (advertAppInfo.getType() == null) {
                lh9.h(advertAppInfo, i, 100);
            } else {
                int e = (pg.e(advertAppInfo.f, i3) + i4) - 1;
                if (hashSet.contains(Integer.valueOf(e))) {
                    lh9.h(advertAppInfo, i, 29);
                } else if (e < 0) {
                    lh9.h(advertAppInfo, i, 33);
                } else if (e >= i2 && i6 > 3) {
                    lh9.i(advertAppInfo, i, 2, e, i2);
                } else {
                    mz5 mz5Var2 = new mz5();
                    mz5Var2.d(advertAppInfo);
                    mz5Var2.e(advertAppInfo.getType().getId());
                    mz5Var2.f(3);
                    if (advertAppInfo.e()) {
                        if (yf9.i(advertAppInfo.p) && bz5.a().p()) {
                            lh9.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.p) && !TextUtils.isEmpty(advertAppInfo.l)) {
                            hashSet.add(Integer.valueOf(e));
                            if (e < i2) {
                                yi8.b(list, mz5Var2, e);
                            } else if (e == i2) {
                                yi8.a(list, mz5Var2);
                            }
                        }
                    } else if (advertAppInfo.h()) {
                        hashSet.add(Integer.valueOf(e));
                        if (e < i2) {
                            yi8.b(list, mz5Var2, e);
                        } else if (e == i2) {
                            yi8.a(list, mz5Var2);
                        }
                    } else {
                        lh9.h(advertAppInfo, i, 21);
                    }
                }
            }
            i7++;
            i3 = 0;
        }
    }

    @Override // com.baidu.tieba.nz5
    public void k(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.a = list;
        }
    }

    @Override // com.baidu.tieba.nz5
    public View m(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        en enVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof AdvertAppInfo)) {
                return null;
            }
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.z) {
                enVar = this.e;
            } else if (type == AdvertAppInfo.w) {
                enVar = this.d;
            } else if (type == AdvertAppInfo.A) {
                enVar = this.f;
            } else if (type == AdvertAppInfo.B) {
                enVar = this.g;
            } else if (type == AdvertAppInfo.C) {
                enVar = this.h;
            } else {
                enVar = null;
            }
            if (enVar == null) {
                return null;
            }
            return enVar.getView(i, view2, viewGroup, advertAppInfo);
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.nz5
    public void n(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof AdvertAppInfo)) {
            return;
        }
        en enVar = null;
        BdUniqueId type = ((AdvertAppInfo) obj).getType();
        if (type == AdvertAppInfo.z) {
            enVar = this.e;
        } else if (type == AdvertAppInfo.w) {
            enVar = this.d;
        } else if (type == AdvertAppInfo.A) {
            enVar = this.f;
        } else if (type == AdvertAppInfo.B) {
            enVar = this.g;
        } else if (type == AdvertAppInfo.C) {
            enVar = this.h;
        }
        if (enVar != null) {
            enVar.onFillViewHolder(i, viewGroup, viewHolder, obj);
        }
    }

    @Override // com.baidu.tieba.nz5
    public void o(List<mz5> list, List<mz5> list2, boolean z, int i) {
        ArrayList arrayList;
        int i2;
        int i3;
        int e;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{list, list2, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || yi8.e(this.a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                yi8.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<mz5> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i4 = yi8.i(list);
        int i5 = 0;
        int i6 = 0;
        for (mz5 mz5Var : list) {
            if (mz5Var.c() == 1) {
                i6++;
            }
        }
        int i7 = yi8.i(arrayList2);
        if (i7 < 1) {
            return;
        }
        int i8 = 9;
        if (yi8.i(arrayList2) > 1 && (e = (pg.e(((AdvertAppInfo) yi8.d(arrayList2, 1)).f, 0) - pg.e(((AdvertAppInfo) yi8.d(arrayList2, 0)).f, 0)) - 1) > 0) {
            i8 = e;
        }
        int e2 = pg.e(((AdvertAppInfo) yi8.d(arrayList2, 0)).f, 0) - 1;
        int i9 = i4 - i6;
        HashSet hashSet = new HashSet();
        int i10 = 0;
        while (i10 < i7) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) yi8.d(arrayList2, i10);
            advertAppInfo.j = "SMART_FRS";
            int i11 = advertAppInfo.i();
            if (i11 != 0) {
                lh9.h(advertAppInfo, i, i11);
                if (i11 != 28 && i11 != 31) {
                    advertAppInfo.c = -1001;
                }
                arrayList = arrayList2;
                i10++;
                arrayList2 = arrayList;
                i5 = 0;
            }
            if (advertAppInfo.getType() == null) {
                lh9.h(advertAppInfo, i, 100);
                arrayList = arrayList2;
                i10++;
                arrayList2 = arrayList;
                i5 = 0;
            } else {
                int e3 = pg.e(advertAppInfo.f, i5);
                int i12 = (e3 + i6) - 1;
                if (i12 >= 0 && !hashSet.contains(Integer.valueOf(i12)) && i12 <= i4) {
                    if (e3 > (i9 - i8) + e2 && z) {
                        if (!yi8.e(list2)) {
                            int i13 = yi8.i(list2);
                            int i14 = (i8 - ((i9 - e3) + 1)) - 1;
                            int i15 = 0;
                            while (i15 < i13 && i15 < i14) {
                                arrayList = arrayList2;
                                if (((mz5) yi8.d(list2, i15)).a() instanceof AdvertAppInfo) {
                                    i3 = 0;
                                    break;
                                } else {
                                    i15++;
                                    arrayList2 = arrayList;
                                }
                            }
                            arrayList = arrayList2;
                            i3 = 1;
                            i2 = i3 ^ 1;
                        } else {
                            arrayList = arrayList2;
                            if (bz5.a().o()) {
                                i2 = 36;
                            }
                        }
                    } else {
                        arrayList = arrayList2;
                    }
                    i2 = 0;
                } else {
                    arrayList = arrayList2;
                    if (i12 > i4) {
                        lh9.i(advertAppInfo, i, 2, i12, i4);
                        i10++;
                        arrayList2 = arrayList;
                        i5 = 0;
                    } else if (i12 < 0) {
                        i2 = 33;
                    } else {
                        i2 = 29;
                    }
                }
                if (i2 != 0) {
                    lh9.h(advertAppInfo, i, i2);
                    i10++;
                    arrayList2 = arrayList;
                    i5 = 0;
                } else {
                    mz5 mz5Var2 = new mz5();
                    mz5Var2.d(advertAppInfo);
                    mz5Var2.e(advertAppInfo.getType().getId());
                    mz5Var2.f(3);
                    if (advertAppInfo.e()) {
                        if (yf9.i(advertAppInfo.p) && bz5.a().p()) {
                            lh9.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.p) && !TextUtils.isEmpty(advertAppInfo.l)) {
                            hashSet.add(Integer.valueOf(i12));
                            if (i12 < i4) {
                                yi8.b(list, mz5Var2, i12);
                            } else if (i12 == i4) {
                                yi8.a(list, mz5Var2);
                            }
                        }
                    } else if (advertAppInfo.h()) {
                        hashSet.add(Integer.valueOf(i12));
                        if (i12 < i4) {
                            yi8.b(list, mz5Var2, i12);
                        } else if (i12 == i4) {
                            yi8.a(list, mz5Var2);
                        }
                    }
                    i10++;
                    arrayList2 = arrayList;
                    i5 = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.nz5
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            en enVar = this.e;
            if (enVar instanceof dg9) {
                ((dg9) enVar).M(str);
            }
            en enVar2 = this.f;
            if (enVar2 instanceof dg9) {
                ((dg9) enVar2).M(str);
            }
            en enVar3 = this.g;
            if (enVar3 instanceof dg9) {
                ((dg9) enVar3).M(str);
            }
            en enVar4 = this.h;
            if (enVar4 instanceof dg9) {
                ((dg9) enVar4).M(str);
            }
        }
    }
}
