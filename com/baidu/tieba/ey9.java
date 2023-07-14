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
public class ey9 implements e56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Object> a;
    public j56 b;
    public qy9 c;
    public ln d;
    public ln e;
    public ln f;
    public ln g;
    public ln h;

    @Override // com.baidu.tieba.e56
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.baidu.tieba.h56
    public void b(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
        }
    }

    public ey9() {
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

    @Override // com.baidu.tieba.e56
    public List<Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(AdvertAppInfo.A.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.x.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.B.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.C.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.D.getId()));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e56
    public void e(List<d56> list, String str, String str2, String str3, String str4, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{list, str, str2, str3, str4, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || g09.e(list)) {
            return;
        }
        Set<yn> a = h0a.a("FRS");
        if (a == null) {
            a = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (d56 d56Var : list) {
            if (d56Var != null) {
                Object a2 = d56Var.a();
                for (yn ynVar : a) {
                    if (a2 != null && d56Var.c() == 3 && (a2 instanceof AdvertAppInfo) && ynVar != null && (ynVar instanceof AdvertAppInfo) && a2.hashCode() == ynVar.hashCode()) {
                        ((AdvertAppInfo) a2).i = ((AdvertAppInfo) ynVar).i;
                    }
                }
                if (a2 != null && d56Var.c() == 3 && (a2 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a2;
                    if (advertAppInfo.i == null) {
                        y15 y15Var = new y15();
                        advertAppInfo.i = y15Var;
                        y15Var.a = "FRS";
                        String.valueOf(z);
                        y15 y15Var2 = advertAppInfo.i;
                        y15Var2.b = i;
                        y15Var2.c = str;
                        y15Var2.d = str2;
                        y15Var2.e = str3;
                        y15Var2.f = str4;
                        y15Var2.g = advertAppInfo.g;
                        y15Var2.h = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a.addAll(hashSet);
        h0a.b("FRS", a);
    }

    @Override // com.baidu.tieba.e56
    public TypeAdapter.ViewHolder g(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        ln lnVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, viewGroup, obj)) == null) {
            if (!(obj instanceof AdvertAppInfo)) {
                return null;
            }
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.A) {
                lnVar = this.e;
            } else if (type == AdvertAppInfo.x) {
                lnVar = this.d;
            } else if (type == AdvertAppInfo.B) {
                lnVar = this.f;
            } else if (type == AdvertAppInfo.C) {
                lnVar = this.g;
            } else if (type == AdvertAppInfo.D) {
                lnVar = this.h;
            } else {
                lnVar = null;
            }
            if (lnVar == null) {
                return null;
            }
            return lnVar.onCreateViewHolder(viewGroup, obj);
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h56
    /* renamed from: q */
    public void f(j56 j56Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, j56Var, str) == null) {
            this.b = j56Var;
            if (j56Var != null && (j56Var.a() instanceof qy9)) {
                this.c = (qy9) this.b.a();
                this.d = new zy9(this.c, AdvertAppInfo.x);
                this.e = new az9(this.c, AdvertAppInfo.A, str);
                this.f = new az9(this.c, AdvertAppInfo.B, str);
                this.g = new az9(this.c, AdvertAppInfo.C, str);
                this.h = new az9(this.c, AdvertAppInfo.D, str);
            }
        }
    }

    @Override // com.baidu.tieba.e56
    public void i(List<d56> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048582, this, list, i) != null) || g09.e(this.a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                g09.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<d56> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i2 = g09.i(list);
        int i3 = 0;
        int i4 = 0;
        for (d56 d56Var : list) {
            if (d56Var.c() == 1) {
                i4++;
            }
        }
        int i5 = g09.i(arrayList);
        if (i5 < 1) {
            return;
        }
        int i6 = i2 - i4;
        HashSet hashSet = new HashSet();
        int i7 = 0;
        while (i7 < i5) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) g09.d(arrayList, i7);
            advertAppInfo.j = "FRS";
            int h = advertAppInfo.h();
            if (h != 0) {
                j0a.h(advertAppInfo, i, h);
                if (h != 28 && h != 31) {
                    advertAppInfo.c = -1001;
                }
                i7++;
                i3 = 0;
            }
            if (advertAppInfo.getType() == null) {
                j0a.h(advertAppInfo, i, 100);
            } else {
                int e = (wg.e(advertAppInfo.f, i3) + i4) - 1;
                if (hashSet.contains(Integer.valueOf(e))) {
                    j0a.h(advertAppInfo, i, 29);
                } else if (e < 0) {
                    j0a.h(advertAppInfo, i, 33);
                } else if (e >= i2 && i6 > 3) {
                    j0a.i(advertAppInfo, i, 2, e, i2);
                } else {
                    d56 d56Var2 = new d56();
                    d56Var2.d(advertAppInfo);
                    d56Var2.e(advertAppInfo.getType().getId());
                    d56Var2.f(3);
                    if (advertAppInfo.e()) {
                        if (vy9.i(advertAppInfo.q) && s46.a().o()) {
                            j0a.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.q) && !TextUtils.isEmpty(advertAppInfo.m)) {
                            hashSet.add(Integer.valueOf(e));
                            if (e < i2) {
                                g09.b(list, d56Var2, e);
                            } else if (e == i2) {
                                g09.a(list, d56Var2);
                            }
                        }
                    } else if (advertAppInfo.g()) {
                        hashSet.add(Integer.valueOf(e));
                        if (e < i2) {
                            g09.b(list, d56Var2, e);
                        } else if (e == i2) {
                            g09.a(list, d56Var2);
                        }
                    } else {
                        j0a.h(advertAppInfo, i, 21);
                    }
                }
            }
            i7++;
            i3 = 0;
        }
    }

    @Override // com.baidu.tieba.e56
    public void k(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.a = list;
        }
    }

    @Override // com.baidu.tieba.e56
    public View m(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        ln lnVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof AdvertAppInfo)) {
                return null;
            }
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.A) {
                lnVar = this.e;
            } else if (type == AdvertAppInfo.x) {
                lnVar = this.d;
            } else if (type == AdvertAppInfo.B) {
                lnVar = this.f;
            } else if (type == AdvertAppInfo.C) {
                lnVar = this.g;
            } else if (type == AdvertAppInfo.D) {
                lnVar = this.h;
            } else {
                lnVar = null;
            }
            if (lnVar == null) {
                return null;
            }
            return lnVar.getView(i, view2, viewGroup, advertAppInfo);
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.e56
    public void n(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof AdvertAppInfo)) {
            return;
        }
        ln lnVar = null;
        BdUniqueId type = ((AdvertAppInfo) obj).getType();
        if (type == AdvertAppInfo.A) {
            lnVar = this.e;
        } else if (type == AdvertAppInfo.x) {
            lnVar = this.d;
        } else if (type == AdvertAppInfo.B) {
            lnVar = this.f;
        } else if (type == AdvertAppInfo.C) {
            lnVar = this.g;
        } else if (type == AdvertAppInfo.D) {
            lnVar = this.h;
        }
        if (lnVar != null) {
            lnVar.onFillViewHolder(i, viewGroup, viewHolder, obj);
        }
    }

    @Override // com.baidu.tieba.e56
    public void o(List<d56> list, List<d56> list2, boolean z, int i) {
        ArrayList arrayList;
        int i2;
        int i3;
        int e;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{list, list2, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || g09.e(this.a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                g09.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<d56> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i4 = g09.i(list);
        int i5 = 0;
        int i6 = 0;
        for (d56 d56Var : list) {
            if (d56Var.c() == 1) {
                i6++;
            }
        }
        int i7 = g09.i(arrayList2);
        if (i7 < 1) {
            return;
        }
        int i8 = 9;
        if (g09.i(arrayList2) > 1 && (e = (wg.e(((AdvertAppInfo) g09.d(arrayList2, 1)).f, 0) - wg.e(((AdvertAppInfo) g09.d(arrayList2, 0)).f, 0)) - 1) > 0) {
            i8 = e;
        }
        int e2 = wg.e(((AdvertAppInfo) g09.d(arrayList2, 0)).f, 0) - 1;
        int i9 = i4 - i6;
        HashSet hashSet = new HashSet();
        int i10 = 0;
        while (i10 < i7) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) g09.d(arrayList2, i10);
            advertAppInfo.j = "SMART_FRS";
            int h = advertAppInfo.h();
            if (h != 0) {
                j0a.h(advertAppInfo, i, h);
                if (h != 28 && h != 31) {
                    advertAppInfo.c = -1001;
                }
                arrayList = arrayList2;
                i10++;
                arrayList2 = arrayList;
                i5 = 0;
            }
            if (advertAppInfo.getType() == null) {
                j0a.h(advertAppInfo, i, 100);
                arrayList = arrayList2;
                i10++;
                arrayList2 = arrayList;
                i5 = 0;
            } else {
                int e3 = wg.e(advertAppInfo.f, i5);
                int i11 = (e3 + i6) - 1;
                if (i11 >= 0 && !hashSet.contains(Integer.valueOf(i11)) && i11 <= i4) {
                    if (e3 > (i9 - i8) + e2 && z) {
                        if (!g09.e(list2)) {
                            int i12 = g09.i(list2);
                            int i13 = (i8 - ((i9 - e3) + 1)) - 1;
                            int i14 = 0;
                            while (i14 < i12 && i14 < i13) {
                                arrayList = arrayList2;
                                if (((d56) g09.d(list2, i14)).a() instanceof AdvertAppInfo) {
                                    i3 = 0;
                                    break;
                                } else {
                                    i14++;
                                    arrayList2 = arrayList;
                                }
                            }
                            arrayList = arrayList2;
                            i3 = 1;
                            i2 = i3 ^ 1;
                        } else {
                            arrayList = arrayList2;
                            if (s46.a().n()) {
                                i2 = 36;
                            }
                        }
                    } else {
                        arrayList = arrayList2;
                    }
                    i2 = 0;
                } else {
                    arrayList = arrayList2;
                    if (i11 > i4) {
                        j0a.i(advertAppInfo, i, 2, i11, i4);
                        i10++;
                        arrayList2 = arrayList;
                        i5 = 0;
                    } else if (i11 < 0) {
                        i2 = 33;
                    } else {
                        i2 = 29;
                    }
                }
                if (i2 != 0) {
                    j0a.h(advertAppInfo, i, i2);
                    i10++;
                    arrayList2 = arrayList;
                    i5 = 0;
                } else {
                    d56 d56Var2 = new d56();
                    d56Var2.d(advertAppInfo);
                    d56Var2.e(advertAppInfo.getType().getId());
                    d56Var2.f(3);
                    if (advertAppInfo.e()) {
                        if (vy9.i(advertAppInfo.q) && s46.a().o()) {
                            j0a.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.q) && !TextUtils.isEmpty(advertAppInfo.m)) {
                            hashSet.add(Integer.valueOf(i11));
                            if (i11 < i4) {
                                g09.b(list, d56Var2, i11);
                            } else if (i11 == i4) {
                                g09.a(list, d56Var2);
                            }
                        }
                    } else if (advertAppInfo.g()) {
                        hashSet.add(Integer.valueOf(i11));
                        if (i11 < i4) {
                            g09.b(list, d56Var2, i11);
                        } else if (i11 == i4) {
                            g09.a(list, d56Var2);
                        }
                    }
                    i10++;
                    arrayList2 = arrayList;
                    i5 = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.e56
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            ln lnVar = this.e;
            if (lnVar instanceof az9) {
                ((az9) lnVar).M(str);
            }
            ln lnVar2 = this.f;
            if (lnVar2 instanceof az9) {
                ((az9) lnVar2).M(str);
            }
            ln lnVar3 = this.g;
            if (lnVar3 instanceof az9) {
                ((az9) lnVar3).M(str);
            }
            ln lnVar4 = this.h;
            if (lnVar4 instanceof az9) {
                ((az9) lnVar4).M(str);
            }
        }
    }
}
