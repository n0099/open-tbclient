package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
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
/* loaded from: classes6.dex */
public class gha implements p06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Object> a;
    public u06 b;
    public sha c;
    public ci d;
    public ci e;
    public ci f;
    public ci g;
    public ci h;

    @Override // com.baidu.tieba.p06
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.baidu.tieba.s06
    public void b(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
        }
    }

    public gha() {
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

    @Override // com.baidu.tieba.p06
    public List<Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(AdvertAppInfo.B.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.y.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.C.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.D.getId()));
            arrayList.add(Integer.valueOf(AdvertAppInfo.E.getId()));
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p06
    public void e(List<o06> list, String str, String str2, String str3, String str4, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{list, str, str2, str3, str4, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || eg9.e(list)) {
            return;
        }
        Set<pi> a = jja.a("FRS");
        if (a == null) {
            a = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (o06 o06Var : list) {
            if (o06Var != null) {
                Object a2 = o06Var.a();
                for (pi piVar : a) {
                    if (a2 != null && o06Var.c() == 3 && (a2 instanceof AdvertAppInfo) && piVar != null && (piVar instanceof AdvertAppInfo) && a2.hashCode() == piVar.hashCode()) {
                        ((AdvertAppInfo) a2).i = ((AdvertAppInfo) piVar).i;
                    }
                }
                if (a2 != null && o06Var.c() == 3 && (a2 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a2;
                    if (advertAppInfo.i == null) {
                        kw4 kw4Var = new kw4();
                        advertAppInfo.i = kw4Var;
                        kw4Var.a = "FRS";
                        String.valueOf(z);
                        kw4 kw4Var2 = advertAppInfo.i;
                        kw4Var2.b = i;
                        kw4Var2.c = str;
                        kw4Var2.d = str2;
                        kw4Var2.e = str3;
                        kw4Var2.f = str4;
                        kw4Var2.g = advertAppInfo.g;
                        kw4Var2.h = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a.addAll(hashSet);
        jja.b("FRS", a);
    }

    @Override // com.baidu.tieba.p06
    public TypeAdapter.ViewHolder g(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        ci ciVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, viewGroup, obj)) == null) {
            if (!(obj instanceof AdvertAppInfo)) {
                return null;
            }
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.B) {
                ciVar = this.e;
            } else if (type == AdvertAppInfo.y) {
                ciVar = this.d;
            } else if (type == AdvertAppInfo.C) {
                ciVar = this.f;
            } else if (type == AdvertAppInfo.D) {
                ciVar = this.g;
            } else if (type == AdvertAppInfo.E) {
                ciVar = this.h;
            } else {
                ciVar = null;
            }
            if (ciVar == null) {
                return null;
            }
            return ciVar.onCreateViewHolder(viewGroup, obj);
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s06
    /* renamed from: q */
    public void f(u06 u06Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, u06Var, str) == null) {
            this.b = u06Var;
            if (u06Var != null && (u06Var.a() instanceof sha)) {
                this.c = (sha) this.b.a();
                this.d = new bia(this.c, AdvertAppInfo.y);
                this.e = new cia(this.c, AdvertAppInfo.B, str);
                this.f = new cia(this.c, AdvertAppInfo.C, str);
                this.g = new cia(this.c, AdvertAppInfo.D, str);
                this.h = new cia(this.c, AdvertAppInfo.E, str);
            }
        }
    }

    @Override // com.baidu.tieba.p06
    public void i(List<o06> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048582, this, list, i) != null) || eg9.e(this.a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                eg9.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<o06> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i2 = eg9.i(list);
        int i3 = 0;
        int i4 = 0;
        for (o06 o06Var : list) {
            if (o06Var.c() == 1) {
                i4++;
            }
        }
        int i5 = eg9.i(arrayList);
        if (i5 < 1) {
            return;
        }
        int i6 = i2 - i4;
        HashSet hashSet = new HashSet();
        int i7 = 0;
        while (i7 < i5) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) eg9.d(arrayList, i7);
            advertAppInfo.j = "FRS";
            int h = advertAppInfo.h();
            if (h != 0) {
                lja.h(advertAppInfo, i, h);
                if (h != 28 && h != 31) {
                    advertAppInfo.c = -1001;
                }
                i7++;
                i3 = 0;
            }
            if (advertAppInfo.getType() == null) {
                lja.h(advertAppInfo, i, 100);
            } else {
                int i8 = (JavaTypesHelper.toInt(advertAppInfo.f, i3) + i4) - 1;
                if (hashSet.contains(Integer.valueOf(i8))) {
                    lja.h(advertAppInfo, i, 29);
                } else if (i8 < 0) {
                    lja.h(advertAppInfo, i, 33);
                } else if (i8 >= i2 && i6 > 3) {
                    lja.i(advertAppInfo, i, 2, i8, i2);
                } else {
                    o06 o06Var2 = new o06();
                    o06Var2.d(advertAppInfo);
                    o06Var2.e(advertAppInfo.getType().getId());
                    o06Var2.f(3);
                    if (advertAppInfo.e()) {
                        if (xha.i(advertAppInfo.q) && e06.a().o()) {
                            lja.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.q) && !TextUtils.isEmpty(advertAppInfo.m)) {
                            hashSet.add(Integer.valueOf(i8));
                            if (i8 < i2) {
                                eg9.b(list, o06Var2, i8);
                            } else if (i8 == i2) {
                                eg9.a(list, o06Var2);
                            }
                        }
                    } else if (advertAppInfo.g()) {
                        hashSet.add(Integer.valueOf(i8));
                        if (i8 < i2) {
                            eg9.b(list, o06Var2, i8);
                        } else if (i8 == i2) {
                            eg9.a(list, o06Var2);
                        }
                    } else {
                        lja.h(advertAppInfo, i, 21);
                    }
                }
            }
            i7++;
            i3 = 0;
        }
    }

    @Override // com.baidu.tieba.p06
    public void k(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.a = list;
        }
    }

    @Override // com.baidu.tieba.p06
    public View m(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        ci ciVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof AdvertAppInfo)) {
                return null;
            }
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.B) {
                ciVar = this.e;
            } else if (type == AdvertAppInfo.y) {
                ciVar = this.d;
            } else if (type == AdvertAppInfo.C) {
                ciVar = this.f;
            } else if (type == AdvertAppInfo.D) {
                ciVar = this.g;
            } else if (type == AdvertAppInfo.E) {
                ciVar = this.h;
            } else {
                ciVar = null;
            }
            if (ciVar == null) {
                return null;
            }
            return ciVar.getView(i, view2, viewGroup, advertAppInfo);
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.p06
    public void n(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof AdvertAppInfo)) {
            return;
        }
        ci ciVar = null;
        BdUniqueId type = ((AdvertAppInfo) obj).getType();
        if (type == AdvertAppInfo.B) {
            ciVar = this.e;
        } else if (type == AdvertAppInfo.y) {
            ciVar = this.d;
        } else if (type == AdvertAppInfo.C) {
            ciVar = this.f;
        } else if (type == AdvertAppInfo.D) {
            ciVar = this.g;
        } else if (type == AdvertAppInfo.E) {
            ciVar = this.h;
        }
        if (ciVar != null) {
            ciVar.onFillViewHolder(i, viewGroup, viewHolder, obj);
        }
    }

    @Override // com.baidu.tieba.p06
    public void o(List<o06> list, List<o06> list2, boolean z, int i) {
        ArrayList arrayList;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{list, list2, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || eg9.e(this.a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                eg9.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<o06> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i5 = eg9.i(list);
        int i6 = 0;
        int i7 = 0;
        for (o06 o06Var : list) {
            if (o06Var.c() == 1) {
                i7++;
            }
        }
        int i8 = eg9.i(arrayList2);
        if (i8 < 1) {
            return;
        }
        int i9 = 9;
        if (eg9.i(arrayList2) > 1 && (i4 = (JavaTypesHelper.toInt(((AdvertAppInfo) eg9.d(arrayList2, 1)).f, 0) - JavaTypesHelper.toInt(((AdvertAppInfo) eg9.d(arrayList2, 0)).f, 0)) - 1) > 0) {
            i9 = i4;
        }
        int i10 = JavaTypesHelper.toInt(((AdvertAppInfo) eg9.d(arrayList2, 0)).f, 0) - 1;
        int i11 = i5 - i7;
        HashSet hashSet = new HashSet();
        int i12 = 0;
        while (i12 < i8) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) eg9.d(arrayList2, i12);
            advertAppInfo.j = "SMART_FRS";
            int h = advertAppInfo.h();
            if (h != 0) {
                lja.h(advertAppInfo, i, h);
                if (h != 28 && h != 31) {
                    advertAppInfo.c = -1001;
                }
                arrayList = arrayList2;
                i12++;
                arrayList2 = arrayList;
                i6 = 0;
            }
            if (advertAppInfo.getType() == null) {
                lja.h(advertAppInfo, i, 100);
                arrayList = arrayList2;
                i12++;
                arrayList2 = arrayList;
                i6 = 0;
            } else {
                int i13 = JavaTypesHelper.toInt(advertAppInfo.f, i6);
                int i14 = (i13 + i7) - 1;
                if (i14 >= 0 && !hashSet.contains(Integer.valueOf(i14)) && i14 <= i5) {
                    if (i13 > (i11 - i9) + i10 && z) {
                        if (!eg9.e(list2)) {
                            int i15 = eg9.i(list2);
                            int i16 = (i9 - ((i11 - i13) + 1)) - 1;
                            int i17 = 0;
                            while (i17 < i15 && i17 < i16) {
                                arrayList = arrayList2;
                                if (((o06) eg9.d(list2, i17)).a() instanceof AdvertAppInfo) {
                                    i3 = 0;
                                    break;
                                } else {
                                    i17++;
                                    arrayList2 = arrayList;
                                }
                            }
                            arrayList = arrayList2;
                            i3 = 1;
                            i2 = i3 ^ 1;
                        } else {
                            arrayList = arrayList2;
                            if (e06.a().n()) {
                                i2 = 36;
                            }
                        }
                    } else {
                        arrayList = arrayList2;
                    }
                    i2 = 0;
                } else {
                    arrayList = arrayList2;
                    if (i14 > i5) {
                        lja.i(advertAppInfo, i, 2, i14, i5);
                        i12++;
                        arrayList2 = arrayList;
                        i6 = 0;
                    } else if (i14 < 0) {
                        i2 = 33;
                    } else {
                        i2 = 29;
                    }
                }
                if (i2 != 0) {
                    lja.h(advertAppInfo, i, i2);
                    i12++;
                    arrayList2 = arrayList;
                    i6 = 0;
                } else {
                    o06 o06Var2 = new o06();
                    o06Var2.d(advertAppInfo);
                    o06Var2.e(advertAppInfo.getType().getId());
                    o06Var2.f(3);
                    if (advertAppInfo.e()) {
                        if (xha.i(advertAppInfo.q) && e06.a().o()) {
                            lja.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.q) && !TextUtils.isEmpty(advertAppInfo.m)) {
                            hashSet.add(Integer.valueOf(i14));
                            if (i14 < i5) {
                                eg9.b(list, o06Var2, i14);
                            } else if (i14 == i5) {
                                eg9.a(list, o06Var2);
                            }
                        }
                    } else if (advertAppInfo.g()) {
                        hashSet.add(Integer.valueOf(i14));
                        if (i14 < i5) {
                            eg9.b(list, o06Var2, i14);
                        } else if (i14 == i5) {
                            eg9.a(list, o06Var2);
                        }
                    }
                    i12++;
                    arrayList2 = arrayList;
                    i6 = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.p06
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            ci ciVar = this.e;
            if (ciVar instanceof cia) {
                ((cia) ciVar).M(str);
            }
            ci ciVar2 = this.f;
            if (ciVar2 instanceof cia) {
                ((cia) ciVar2).M(str);
            }
            ci ciVar3 = this.g;
            if (ciVar3 instanceof cia) {
                ((cia) ciVar3).M(str);
            }
            ci ciVar4 = this.h;
            if (ciVar4 instanceof cia) {
                ((cia) ciVar4).M(str);
            }
        }
    }
}
