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
public class gn1 implements cn1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public nv3 c;
    public dn1 d;
    public wu3 e;
    public List<bn1> f;
    public bn1 g;
    public bn1 h;
    public Map<String, String> i;
    public mv3 j;

    /* loaded from: classes6.dex */
    public class a implements mv3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gn1 a;

        @Override // com.baidu.tieba.mv3
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        public a(gn1 gn1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gn1Var;
        }

        @Override // com.baidu.tieba.mv3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(fn1.b(str));
                pv3.k(this.a.i, str);
            }
        }

        @Override // com.baidu.tieba.mv3
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (bn1 bn1Var : this.a.f) {
                        bn1Var.a(0);
                        if (this.a.f.contains(bn1Var)) {
                            this.a.f.remove(bn1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (bn1 bn1Var2 : this.a.f) {
                    bn1Var2.a(1001);
                    if (this.a.f.contains(bn1Var2)) {
                        this.a.f.remove(bn1Var2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.mv3
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

        @Override // com.baidu.tieba.mv3
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(fn1.a(z));
            }
        }
    }

    public gn1(@NonNull JSONObject jSONObject, dn1 dn1Var, bn1 bn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, dn1Var, bn1Var};
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
            this.i = pv3.a("video", "app", optString, this.a, false);
            this.e = new hn1();
            nv3 nv3Var = new nv3(tr2.V().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = nv3Var;
            nv3Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, bn1Var, dn1Var);
            return;
        }
        bn1Var.a(202);
    }

    @Override // com.baidu.tieba.cn1
    public synchronized void a(JSONObject jSONObject, bn1 bn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, bn1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = bn1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.cn1
    public synchronized void b(JSONObject jSONObject, bn1 bn1Var, dn1 dn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, bn1Var, dn1Var) == null) {
            synchronized (this) {
                this.d = dn1Var;
                if (this.c != null) {
                    this.g = bn1Var;
                    if (bn1Var != null && !this.f.contains(bn1Var)) {
                        this.f.add(bn1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
