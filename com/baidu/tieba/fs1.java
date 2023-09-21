package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class fs1 implements bs1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public n04 c;
    public cs1 d;
    public wz3 e;
    public List<as1> f;
    public as1 g;
    public as1 h;
    public Map<String, String> i;
    public m04 j;

    /* loaded from: classes6.dex */
    public class a implements m04 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fs1 a;

        @Override // com.baidu.tieba.m04
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        public a(fs1 fs1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fs1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fs1Var;
        }

        @Override // com.baidu.tieba.m04
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(es1.b(str));
                p04.k(this.a.i, str);
            }
        }

        @Override // com.baidu.tieba.m04
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (as1 as1Var : this.a.f) {
                        as1Var.a(0);
                        if (this.a.f.contains(as1Var)) {
                            this.a.f.remove(as1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (as1 as1Var2 : this.a.f) {
                    as1Var2.a(1001);
                    if (this.a.f.contains(as1Var2)) {
                        this.a.f.remove(as1Var2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.m04
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.a.h.a(0);
                } else {
                    this.a.h.a(1001);
                }
            }
        }

        @Override // com.baidu.tieba.m04
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(es1.a(z));
            }
        }
    }

    public fs1(@NonNull JSONObject jSONObject, cs1 cs1Var, as1 as1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, cs1Var, as1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
        this.i = new TreeMap();
        this.j = new a(this);
        if (jSONObject != null && !TextUtils.isEmpty(jSONObject.optString("adUnitId")) && !TextUtils.isEmpty(jSONObject.optString("appSid"))) {
            this.a = jSONObject.optString("adUnitId");
            String optString = jSONObject.optString("appSid");
            this.b = optString;
            this.i = p04.a("video", "app", optString, this.a, false);
            this.e = new gs1();
            n04 n04Var = new n04(tw2.T().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = n04Var;
            n04Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, as1Var, cs1Var);
            return;
        }
        as1Var.a(202);
    }

    @Override // com.baidu.tieba.bs1
    public synchronized void a(JSONObject jSONObject, as1 as1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, as1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = as1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.bs1
    public synchronized void b(JSONObject jSONObject, as1 as1Var, cs1 cs1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, as1Var, cs1Var) == null) {
            synchronized (this) {
                this.d = cs1Var;
                if (this.c != null) {
                    this.g = as1Var;
                    if (as1Var != null && !this.f.contains(as1Var)) {
                        this.f.add(as1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
