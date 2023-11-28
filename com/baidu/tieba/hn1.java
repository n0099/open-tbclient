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
public class hn1 implements dn1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public ov3 c;
    public en1 d;
    public xu3 e;
    public List<cn1> f;
    public cn1 g;
    public cn1 h;
    public Map<String, String> i;
    public nv3 j;

    /* loaded from: classes6.dex */
    public class a implements nv3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hn1 a;

        @Override // com.baidu.tieba.nv3
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        public a(hn1 hn1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hn1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hn1Var;
        }

        @Override // com.baidu.tieba.nv3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(gn1.b(str));
                qv3.k(this.a.i, str);
            }
        }

        @Override // com.baidu.tieba.nv3
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (cn1 cn1Var : this.a.f) {
                        cn1Var.a(0);
                        if (this.a.f.contains(cn1Var)) {
                            this.a.f.remove(cn1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (cn1 cn1Var2 : this.a.f) {
                    cn1Var2.a(1001);
                    if (this.a.f.contains(cn1Var2)) {
                        this.a.f.remove(cn1Var2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.nv3
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

        @Override // com.baidu.tieba.nv3
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(gn1.a(z));
            }
        }
    }

    public hn1(@NonNull JSONObject jSONObject, en1 en1Var, cn1 cn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, en1Var, cn1Var};
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
            this.i = qv3.a("video", "app", optString, this.a, false);
            this.e = new in1();
            ov3 ov3Var = new ov3(ur2.V().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = ov3Var;
            ov3Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, cn1Var, en1Var);
            return;
        }
        cn1Var.a(202);
    }

    @Override // com.baidu.tieba.dn1
    public synchronized void a(JSONObject jSONObject, cn1 cn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, cn1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = cn1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.dn1
    public synchronized void b(JSONObject jSONObject, cn1 cn1Var, en1 en1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, cn1Var, en1Var) == null) {
            synchronized (this) {
                this.d = en1Var;
                if (this.c != null) {
                    this.g = cn1Var;
                    if (cn1Var != null && !this.f.contains(cn1Var)) {
                        this.f.add(cn1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
