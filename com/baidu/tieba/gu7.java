package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gift.giftTab.CategoryGiftListModel;
import com.baidu.tieba.gift.giftTab.DefaultGiftListModel;
import com.baidu.tieba.gift.giftTab.FreeGiftChanceModel;
import com.baidu.tieba.gift.giftTab.GiftTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class gu7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k9<GiftTabActivity> a;
    public DefaultGiftListModel b;
    public CategoryGiftListModel c;
    public FreeGiftChanceModel d;
    public ArrayList<du7> e;
    public ArrayList<bu7> f;
    public ArrayList<fu7> g;
    public HashMap<Integer, ArrayList<u25>> h;
    public int i;
    public String j;
    public int k;
    public v25 l;
    public e m;
    public d n;
    public DefaultGiftListModel.b o;
    public CategoryGiftListModel.b p;
    public FreeGiftChanceModel.b q;

    /* loaded from: classes5.dex */
    public interface d {
        void a(int i);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(int i, String str, boolean z, String str2, int i2, v25 v25Var, ArrayList<du7> arrayList, ArrayList<bu7> arrayList2, ArrayList<fu7> arrayList3);
    }

    /* loaded from: classes5.dex */
    public class a implements DefaultGiftListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gu7 a;

        public a(gu7 gu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gu7Var;
        }

        @Override // com.baidu.tieba.gift.giftTab.DefaultGiftListModel.b
        public void a(int i, String str, int i2, String str2, int i3, v25 v25Var, ArrayList<bu7> arrayList, ArrayList<u25> arrayList2, ArrayList<fu7> arrayList3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), str2, Integer.valueOf(i3), v25Var, arrayList, arrayList2, arrayList3}) == null) {
                if (i == 0) {
                    int i4 = 0;
                    if (arrayList != null && arrayList.size() >= 1 && arrayList.get(0) != null) {
                        i4 = arrayList.get(0).a();
                    }
                    this.a.f = arrayList;
                    this.a.h.put(Integer.valueOf(i4), arrayList2);
                    this.a.g = arrayList3;
                    this.a.j = str2;
                    this.a.i = i2;
                    gu7 gu7Var = this.a;
                    gu7Var.k = i3;
                    gu7Var.l = v25Var;
                    gu7Var.q();
                }
                if (this.a.m != null) {
                    e eVar = this.a.m;
                    String str3 = this.a.j;
                    gu7 gu7Var2 = this.a;
                    eVar.a(i, str, true, str3, gu7Var2.k, gu7Var2.l, gu7Var2.e, this.a.f, this.a.g);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements CategoryGiftListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gu7 a;

        public b(gu7 gu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gu7Var;
        }

        @Override // com.baidu.tieba.gift.giftTab.CategoryGiftListModel.b
        public void a(int i, String str, int i2, ArrayList<u25> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), arrayList}) == null) {
                if (i == 0) {
                    this.a.h.put(Integer.valueOf(i2), arrayList);
                    this.a.q();
                }
                if (this.a.m != null) {
                    e eVar = this.a.m;
                    String str2 = this.a.j;
                    gu7 gu7Var = this.a;
                    eVar.a(i, str, false, str2, gu7Var.k, gu7Var.l, gu7Var.e, this.a.f, this.a.g);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements FreeGiftChanceModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gu7 a;

        public c(gu7 gu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gu7Var;
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

    public gu7(k9<GiftTabActivity> k9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new HashMap<>();
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.a = k9Var;
        DefaultGiftListModel defaultGiftListModel = new DefaultGiftListModel(k9Var);
        this.b = defaultGiftListModel;
        defaultGiftListModel.g0(this.o);
        CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.a);
        this.c = categoryGiftListModel;
        categoryGiftListModel.Y(this.p);
        FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.a);
        this.d = freeGiftChanceModel;
        freeGiftChanceModel.Y(this.q);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (this.d == null) {
                FreeGiftChanceModel freeGiftChanceModel = new FreeGiftChanceModel(this.a);
                this.d = freeGiftChanceModel;
                freeGiftChanceModel.Y(this.q);
            }
            this.d.X(str);
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (this.c == null) {
                CategoryGiftListModel categoryGiftListModel = new CategoryGiftListModel(this.a);
                this.c = categoryGiftListModel;
                categoryGiftListModel.Y(this.p);
            }
            this.c.X(i);
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
                defaultGiftListModel.g0(this.o);
            }
            this.b.f0(str, j);
        }
    }

    public final void q() {
        HashMap<Integer, ArrayList<u25>> hashMap;
        ArrayList<bu7> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (hashMap = this.h) != null && hashMap.size() > 0 && (arrayList = this.f) != null && arrayList.size() > 0) {
            if (this.e == null) {
                this.e = new ArrayList<>();
            }
            this.e.clear();
            Iterator<bu7> it = this.f.iterator();
            while (it.hasNext()) {
                bu7 next = it.next();
                if (next != null && !StringUtils.isNull(next.b())) {
                    du7 du7Var = new du7();
                    du7Var.c(next.a());
                    du7Var.d(next.b());
                    ArrayList<u25> arrayList2 = this.h.get(Integer.valueOf(next.a()));
                    if (arrayList2 != null) {
                        du7Var.e(arrayList2);
                    }
                    this.e.add(du7Var);
                }
            }
        }
    }
}
