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
public class gs1 implements cs1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public o04 c;
    public ds1 d;
    public xz3 e;
    public List<bs1> f;
    public bs1 g;
    public bs1 h;
    public Map<String, String> i;
    public n04 j;

    /* loaded from: classes6.dex */
    public class a implements n04 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gs1 a;

        @Override // com.baidu.tieba.n04
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        public a(gs1 gs1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gs1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gs1Var;
        }

        @Override // com.baidu.tieba.n04
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(fs1.b(str));
                q04.k(this.a.i, str);
            }
        }

        @Override // com.baidu.tieba.n04
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (bs1 bs1Var : this.a.f) {
                        bs1Var.a(0);
                        if (this.a.f.contains(bs1Var)) {
                            this.a.f.remove(bs1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (bs1 bs1Var2 : this.a.f) {
                    bs1Var2.a(1001);
                    if (this.a.f.contains(bs1Var2)) {
                        this.a.f.remove(bs1Var2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.n04
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

        @Override // com.baidu.tieba.n04
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(fs1.a(z));
            }
        }
    }

    public gs1(@NonNull JSONObject jSONObject, ds1 ds1Var, bs1 bs1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, ds1Var, bs1Var};
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
            this.i = q04.a("video", "app", optString, this.a, false);
            this.e = new hs1();
            o04 o04Var = new o04(uw2.T().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = o04Var;
            o04Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, bs1Var, ds1Var);
            return;
        }
        bs1Var.a(202);
    }

    @Override // com.baidu.tieba.cs1
    public synchronized void a(JSONObject jSONObject, bs1 bs1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, bs1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = bs1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.cs1
    public synchronized void b(JSONObject jSONObject, bs1 bs1Var, ds1 ds1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, bs1Var, ds1Var) == null) {
            synchronized (this) {
                this.d = ds1Var;
                if (this.c != null) {
                    this.g = bs1Var;
                    if (bs1Var != null && !this.f.contains(bs1Var)) {
                        this.f.add(bs1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
