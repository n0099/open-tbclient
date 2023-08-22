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
/* loaded from: classes5.dex */
public class b1a implements d36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Object> a;
    public i36 b;
    public n1a c;
    public om d;
    public om e;
    public om f;
    public om g;
    public om h;

    @Override // com.baidu.tieba.d36
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.baidu.tieba.g36
    public void b(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
        }
    }

    public b1a() {
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

    @Override // com.baidu.tieba.d36
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

    @Override // com.baidu.tieba.d36
    public void e(List<c36> list, String str, String str2, String str3, String str4, boolean z, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{list, str, str2, str3, str4, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || g29.e(list)) {
            return;
        }
        Set<bn> a = e3a.a("FRS");
        if (a == null) {
            a = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (c36 c36Var : list) {
            if (c36Var != null) {
                Object a2 = c36Var.a();
                for (bn bnVar : a) {
                    if (a2 != null && c36Var.c() == 3 && (a2 instanceof AdvertAppInfo) && bnVar != null && (bnVar instanceof AdvertAppInfo) && a2.hashCode() == bnVar.hashCode()) {
                        ((AdvertAppInfo) a2).i = ((AdvertAppInfo) bnVar).i;
                    }
                }
                if (a2 != null && c36Var.c() == 3 && (a2 instanceof AdvertAppInfo)) {
                    AdvertAppInfo advertAppInfo = (AdvertAppInfo) a2;
                    if (advertAppInfo.i == null) {
                        b15 b15Var = new b15();
                        advertAppInfo.i = b15Var;
                        b15Var.a = "FRS";
                        String.valueOf(z);
                        b15 b15Var2 = advertAppInfo.i;
                        b15Var2.b = i;
                        b15Var2.c = str;
                        b15Var2.d = str2;
                        b15Var2.e = str3;
                        b15Var2.f = str4;
                        b15Var2.g = advertAppInfo.g;
                        b15Var2.h = false;
                        hashSet.add(advertAppInfo);
                    }
                }
            }
        }
        a.addAll(hashSet);
        e3a.b("FRS", a);
    }

    @Override // com.baidu.tieba.d36
    public TypeAdapter.ViewHolder g(ViewGroup viewGroup, Object obj) {
        InterceptResult invokeLL;
        om omVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, viewGroup, obj)) == null) {
            if (!(obj instanceof AdvertAppInfo)) {
                return null;
            }
            BdUniqueId type = ((AdvertAppInfo) obj).getType();
            if (type == AdvertAppInfo.A) {
                omVar = this.e;
            } else if (type == AdvertAppInfo.x) {
                omVar = this.d;
            } else if (type == AdvertAppInfo.B) {
                omVar = this.f;
            } else if (type == AdvertAppInfo.C) {
                omVar = this.g;
            } else if (type == AdvertAppInfo.D) {
                omVar = this.h;
            } else {
                omVar = null;
            }
            if (omVar == null) {
                return null;
            }
            return omVar.onCreateViewHolder(viewGroup, obj);
        }
        return (TypeAdapter.ViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.g36
    /* renamed from: q */
    public void f(i36 i36Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, i36Var, str) == null) {
            this.b = i36Var;
            if (i36Var != null && (i36Var.a() instanceof n1a)) {
                this.c = (n1a) this.b.a();
                this.d = new w1a(this.c, AdvertAppInfo.x);
                this.e = new x1a(this.c, AdvertAppInfo.A, str);
                this.f = new x1a(this.c, AdvertAppInfo.B, str);
                this.g = new x1a(this.c, AdvertAppInfo.C, str);
                this.h = new x1a(this.c, AdvertAppInfo.D, str);
            }
        }
    }

    @Override // com.baidu.tieba.d36
    public void i(List<c36> list, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048582, this, list, i) != null) || g29.e(this.a)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                g29.a(arrayList, (AdvertAppInfo) obj);
            }
        }
        Iterator<c36> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i2 = g29.i(list);
        int i3 = 0;
        int i4 = 0;
        for (c36 c36Var : list) {
            if (c36Var.c() == 1) {
                i4++;
            }
        }
        int i5 = g29.i(arrayList);
        if (i5 < 1) {
            return;
        }
        int i6 = i2 - i4;
        HashSet hashSet = new HashSet();
        int i7 = 0;
        while (i7 < i5) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) g29.d(arrayList, i7);
            advertAppInfo.j = "FRS";
            int h = advertAppInfo.h();
            if (h != 0) {
                g3a.h(advertAppInfo, i, h);
                if (h != 28 && h != 31) {
                    advertAppInfo.c = -1001;
                }
                i7++;
                i3 = 0;
            }
            if (advertAppInfo.getType() == null) {
                g3a.h(advertAppInfo, i, 100);
            } else {
                int i8 = (JavaTypesHelper.toInt(advertAppInfo.f, i3) + i4) - 1;
                if (hashSet.contains(Integer.valueOf(i8))) {
                    g3a.h(advertAppInfo, i, 29);
                } else if (i8 < 0) {
                    g3a.h(advertAppInfo, i, 33);
                } else if (i8 >= i2 && i6 > 3) {
                    g3a.i(advertAppInfo, i, 2, i8, i2);
                } else {
                    c36 c36Var2 = new c36();
                    c36Var2.d(advertAppInfo);
                    c36Var2.e(advertAppInfo.getType().getId());
                    c36Var2.f(3);
                    if (advertAppInfo.e()) {
                        if (s1a.i(advertAppInfo.q) && s26.a().o()) {
                            g3a.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.q) && !TextUtils.isEmpty(advertAppInfo.m)) {
                            hashSet.add(Integer.valueOf(i8));
                            if (i8 < i2) {
                                g29.b(list, c36Var2, i8);
                            } else if (i8 == i2) {
                                g29.a(list, c36Var2);
                            }
                        }
                    } else if (advertAppInfo.g()) {
                        hashSet.add(Integer.valueOf(i8));
                        if (i8 < i2) {
                            g29.b(list, c36Var2, i8);
                        } else if (i8 == i2) {
                            g29.a(list, c36Var2);
                        }
                    } else {
                        g3a.h(advertAppInfo, i, 21);
                    }
                }
            }
            i7++;
            i3 = 0;
        }
    }

    @Override // com.baidu.tieba.d36
    public void k(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.a = list;
        }
    }

    @Override // com.baidu.tieba.d36
    public View m(int i, View view2, ViewGroup viewGroup, Object obj) {
        InterceptResult invokeCommon;
        om omVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, obj})) == null) {
            if (!(obj instanceof AdvertAppInfo)) {
                return null;
            }
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) obj;
            BdUniqueId type = advertAppInfo.getType();
            if (type == AdvertAppInfo.A) {
                omVar = this.e;
            } else if (type == AdvertAppInfo.x) {
                omVar = this.d;
            } else if (type == AdvertAppInfo.B) {
                omVar = this.f;
            } else if (type == AdvertAppInfo.C) {
                omVar = this.g;
            } else if (type == AdvertAppInfo.D) {
                omVar = this.h;
            } else {
                omVar = null;
            }
            if (omVar == null) {
                return null;
            }
            return omVar.getView(i, view2, viewGroup, advertAppInfo);
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.d36
    public void n(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), viewGroup, viewHolder, obj}) != null) || !(obj instanceof AdvertAppInfo)) {
            return;
        }
        om omVar = null;
        BdUniqueId type = ((AdvertAppInfo) obj).getType();
        if (type == AdvertAppInfo.A) {
            omVar = this.e;
        } else if (type == AdvertAppInfo.x) {
            omVar = this.d;
        } else if (type == AdvertAppInfo.B) {
            omVar = this.f;
        } else if (type == AdvertAppInfo.C) {
            omVar = this.g;
        } else if (type == AdvertAppInfo.D) {
            omVar = this.h;
        }
        if (omVar != null) {
            omVar.onFillViewHolder(i, viewGroup, viewHolder, obj);
        }
    }

    @Override // com.baidu.tieba.d36
    public void o(List<c36> list, List<c36> list2, boolean z, int i) {
        ArrayList arrayList;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{list, list2, Boolean.valueOf(z), Integer.valueOf(i)}) != null) || g29.e(this.a)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : this.a) {
            if (obj instanceof AdvertAppInfo) {
                g29.a(arrayList2, (AdvertAppInfo) obj);
            }
        }
        Iterator<c36> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == 3) {
                it.remove();
            }
        }
        int i5 = g29.i(list);
        int i6 = 0;
        int i7 = 0;
        for (c36 c36Var : list) {
            if (c36Var.c() == 1) {
                i7++;
            }
        }
        int i8 = g29.i(arrayList2);
        if (i8 < 1) {
            return;
        }
        int i9 = 9;
        if (g29.i(arrayList2) > 1 && (i4 = (JavaTypesHelper.toInt(((AdvertAppInfo) g29.d(arrayList2, 1)).f, 0) - JavaTypesHelper.toInt(((AdvertAppInfo) g29.d(arrayList2, 0)).f, 0)) - 1) > 0) {
            i9 = i4;
        }
        int i10 = JavaTypesHelper.toInt(((AdvertAppInfo) g29.d(arrayList2, 0)).f, 0) - 1;
        int i11 = i5 - i7;
        HashSet hashSet = new HashSet();
        int i12 = 0;
        while (i12 < i8) {
            AdvertAppInfo advertAppInfo = (AdvertAppInfo) g29.d(arrayList2, i12);
            advertAppInfo.j = "SMART_FRS";
            int h = advertAppInfo.h();
            if (h != 0) {
                g3a.h(advertAppInfo, i, h);
                if (h != 28 && h != 31) {
                    advertAppInfo.c = -1001;
                }
                arrayList = arrayList2;
                i12++;
                arrayList2 = arrayList;
                i6 = 0;
            }
            if (advertAppInfo.getType() == null) {
                g3a.h(advertAppInfo, i, 100);
                arrayList = arrayList2;
                i12++;
                arrayList2 = arrayList;
                i6 = 0;
            } else {
                int i13 = JavaTypesHelper.toInt(advertAppInfo.f, i6);
                int i14 = (i13 + i7) - 1;
                if (i14 >= 0 && !hashSet.contains(Integer.valueOf(i14)) && i14 <= i5) {
                    if (i13 > (i11 - i9) + i10 && z) {
                        if (!g29.e(list2)) {
                            int i15 = g29.i(list2);
                            int i16 = (i9 - ((i11 - i13) + 1)) - 1;
                            int i17 = 0;
                            while (i17 < i15 && i17 < i16) {
                                arrayList = arrayList2;
                                if (((c36) g29.d(list2, i17)).a() instanceof AdvertAppInfo) {
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
                            if (s26.a().n()) {
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
                        g3a.i(advertAppInfo, i, 2, i14, i5);
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
                    g3a.h(advertAppInfo, i, i2);
                    i12++;
                    arrayList2 = arrayList;
                    i6 = 0;
                } else {
                    c36 c36Var2 = new c36();
                    c36Var2.d(advertAppInfo);
                    c36Var2.e(advertAppInfo.getType().getId());
                    c36Var2.f(3);
                    if (advertAppInfo.e()) {
                        if (s1a.i(advertAppInfo.q) && s26.a().o()) {
                            g3a.h(advertAppInfo, i, 3);
                        } else if (!TextUtils.isEmpty(advertAppInfo.q) && !TextUtils.isEmpty(advertAppInfo.m)) {
                            hashSet.add(Integer.valueOf(i14));
                            if (i14 < i5) {
                                g29.b(list, c36Var2, i14);
                            } else if (i14 == i5) {
                                g29.a(list, c36Var2);
                            }
                        }
                    } else if (advertAppInfo.g()) {
                        hashSet.add(Integer.valueOf(i14));
                        if (i14 < i5) {
                            g29.b(list, c36Var2, i14);
                        } else if (i14 == i5) {
                            g29.a(list, c36Var2);
                        }
                    }
                    i12++;
                    arrayList2 = arrayList;
                    i6 = 0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.d36
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            om omVar = this.e;
            if (omVar instanceof x1a) {
                ((x1a) omVar).L(str);
            }
            om omVar2 = this.f;
            if (omVar2 instanceof x1a) {
                ((x1a) omVar2).L(str);
            }
            om omVar3 = this.g;
            if (omVar3 instanceof x1a) {
                ((x1a) omVar3).L(str);
            }
            om omVar4 = this.h;
            if (omVar4 instanceof x1a) {
                ((x1a) omVar4).L(str);
            }
        }
    }
}
