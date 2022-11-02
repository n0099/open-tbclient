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
/* loaded from: classes3.dex */
public class dl1 implements zk1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public lt3 c;
    public al1 d;
    public us3 e;
    public List<yk1> f;
    public yk1 g;
    public yk1 h;
    public Map<String, String> i;
    public kt3 j;

    /* loaded from: classes3.dex */
    public class a implements kt3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dl1 a;

        @Override // com.baidu.tieba.kt3
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public a(dl1 dl1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dl1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dl1Var;
        }

        @Override // com.baidu.tieba.kt3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(cl1.b(str));
                nt3.k(this.a.i, str);
            }
        }

        @Override // com.baidu.tieba.kt3
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (yk1 yk1Var : this.a.f) {
                        yk1Var.a(0);
                        if (this.a.f.contains(yk1Var)) {
                            this.a.f.remove(yk1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (yk1 yk1Var2 : this.a.f) {
                    yk1Var2.a(1001);
                    if (this.a.f.contains(yk1Var2)) {
                        this.a.f.remove(yk1Var2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.kt3
        public void c(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, str) == null) {
                if (z) {
                    this.a.h.a(0);
                } else {
                    this.a.h.a(1001);
                }
            }
        }

        @Override // com.baidu.tieba.kt3
        public void d(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(cl1.a(z));
            }
        }
    }

    public dl1(@NonNull JSONObject jSONObject, al1 al1Var, yk1 yk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, al1Var, yk1Var};
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
            this.i = nt3.a("video", "app", optString, this.a, false);
            this.e = new el1();
            lt3 lt3Var = new lt3(rp2.U().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = lt3Var;
            lt3Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, yk1Var, al1Var);
            return;
        }
        yk1Var.a(202);
    }

    @Override // com.baidu.tieba.zk1
    public synchronized void a(JSONObject jSONObject, yk1 yk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, yk1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = yk1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.zk1
    public synchronized void b(JSONObject jSONObject, yk1 yk1Var, al1 al1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, yk1Var, al1Var) == null) {
            synchronized (this) {
                this.d = al1Var;
                if (this.c != null) {
                    this.g = yk1Var;
                    if (yk1Var != null && !this.f.contains(yk1Var)) {
                        this.f.add(yk1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
