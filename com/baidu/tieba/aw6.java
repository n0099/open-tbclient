package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gift.giftTab.CategoryGiftListModel;
import com.baidu.tieba.gift.giftTab.DefaultGiftListModel;
import com.baidu.tieba.gift.giftTab.FreeGiftChanceModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class aw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r9 a;
    public DefaultGiftListModel b;
    public CategoryGiftListModel c;
    public FreeGiftChanceModel d;
    public ArrayList e;
    public ArrayList f;
    public ArrayList g;
    public HashMap h;
    public int i;
    public String j;
    public int k;
    public ls4 l;
    public e m;
    public d n;
    public DefaultGiftListModel.b o;
    public CategoryGiftListModel.b p;
    public FreeGiftChanceModel.b q;

    /* loaded from: classes3.dex */
    public interface d {
        void a(int i);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(int i, String str, boolean z, String str2, int i2, ls4 ls4Var, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3);
    }

    /* loaded from: classes3.dex */
    public class a implements DefaultGiftListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw6 a;

        public a(aw6 aw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aw6Var;
        }

        @Override // com.baidu.tieba.gift.giftTab.DefaultGiftListModel.b
        public void a(int i, String str, int i2, String str2, int i3, ls4 ls4Var, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), str2, Integer.valueOf(i3), ls4Var, arrayList, arrayList2, arrayList3}) == null) {
                if (i == 0) {
                    int i4 = 0;
                    if (arrayList != null && arrayList.size() >= 1 && arrayList.get(0) != null) {
                        i4 = ((vv6) arrayList.get(0)).a();
                    }
                    this.a.f = arrayList;
                    this.a.h.put(Integer.valueOf(i4), arrayList2);
                    this.a.g = arrayList3;
                    this.a.j = str2;
                    this.a.i = i2;
                    aw6 aw6Var = this.a;
                    aw6Var.k = i3;
                    aw6Var.l = ls4Var;
                    aw6Var.q();
                }
                if (this.a.m != null) {
                    e eVar = this.a.m;
                    String str3 = this.a.j;
                    aw6 aw6Var2 = this.a;
                    eVar.a(i, str, true, str3, aw6Var2.k, aw6Var2.l, aw6Var2.e, this.a.f, this.a.g);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements CategoryGiftListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw6 a;

        public b(aw6 aw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aw6Var;
        }

        @Override // com.baidu.tieba.gift.giftTab.CategoryGiftListModel.b
        public void a(int i, String str, int i2, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), arrayList}) == null) {
                if (i == 0) {
                    this.a.h.put(Integer.valueOf(i2), arrayList);
                    this.a.q();
                }
                if (this.a.m != null) {
                    e eVar = this.a.m;
                    String str2 = this.a.j;
                    aw6 aw6Var = this.a;
                    eVar.a(i, str, false, str2, aw6Var.k, aw6Var.l, aw6Var.e, this.a.f, this.a.g);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements FreeGiftChanceModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw6 a;

        public c(aw6 aw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aw6Var;
        }

        @Override // com.baidu.tieba.gift.giftTab.FreeGiftChanceModel.b
        public void a(int i, String str, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) != null) || i != 0) {
                return;
            }
            this.a.i = i2;
            if (this.a.n != null) {
                this.a.n.a(this.a.i);
            }
        }
    }

    public aw6(r9 r9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new HashMap();
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.a = r9Var;
        DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(r9Var);
        this.b = defaultGiftListModel;
        defaultGiftListModel.L(this.o);
        CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.a);
        this.c = categoryGiftListModel;
        categoryGiftListModel.D(this.p);
        FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.a);
        this.d = freeGiftChanceModel;
        freeGiftChanceModel.D(this.q);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.d == null) {
                FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.a);
                this.d = freeGiftChanceModel;
                freeGiftChanceModel.D(this.q);
            }
            this.d.C(str);
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (this.c == null) {
                CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.a);
                this.c = categoryGiftListModel;
                categoryGiftListModel.D(this.p);
            }
            this.c.C(i);
        }
    }

    public void r(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            this.n = dVar;
        }
    }

    public void s(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) {
            this.m = eVar;
        }
    }

    public void o(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
            if (this.b == null) {
                DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(this.a);
                this.b = defaultGiftListModel;
                defaultGiftListModel.L(this.o);
            }
            this.b.K(str, j);
        }
    }

    public final void q() {
        HashMap hashMap;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (hashMap = this.h) != null && hashMap.size() > 0 && (arrayList = this.f) != null && arrayList.size() > 0) {
            if (this.e == null) {
                this.e = new ArrayList();
            }
            this.e.clear();
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                vv6 vv6Var = (vv6) it.next();
                if (vv6Var != null && !StringUtils.isNull(vv6Var.b())) {
                    xv6 xv6Var = new xv6();
                    xv6Var.c(vv6Var.a());
                    xv6Var.d(vv6Var.b());
                    ArrayList arrayList2 = (ArrayList) this.h.get(Integer.valueOf(vv6Var.a()));
                    if (arrayList2 != null) {
                        xv6Var.e(arrayList2);
                    }
                    this.e.add(xv6Var);
                }
            }
        }
    }
}
