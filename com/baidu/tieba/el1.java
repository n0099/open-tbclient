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
public class el1 implements al1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public mt3 c;
    public bl1 d;
    public vs3 e;
    public List<zk1> f;
    public zk1 g;
    public zk1 h;
    public Map<String, String> i;
    public lt3 j;

    /* loaded from: classes3.dex */
    public class a implements lt3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ el1 a;

        @Override // com.baidu.tieba.lt3
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public a(el1 el1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {el1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = el1Var;
        }

        @Override // com.baidu.tieba.lt3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(dl1.b(str));
                ot3.k(this.a.i, str);
            }
        }

        @Override // com.baidu.tieba.lt3
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (zk1 zk1Var : this.a.f) {
                        zk1Var.a(0);
                        if (this.a.f.contains(zk1Var)) {
                            this.a.f.remove(zk1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (zk1 zk1Var2 : this.a.f) {
                    zk1Var2.a(1001);
                    if (this.a.f.contains(zk1Var2)) {
                        this.a.f.remove(zk1Var2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.lt3
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

        @Override // com.baidu.tieba.lt3
        public void d(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(dl1.a(z));
            }
        }
    }

    public el1(@NonNull JSONObject jSONObject, bl1 bl1Var, zk1 zk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, bl1Var, zk1Var};
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
            this.i = ot3.a("video", "app", optString, this.a, false);
            this.e = new fl1();
            mt3 mt3Var = new mt3(sp2.U().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = mt3Var;
            mt3Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, zk1Var, bl1Var);
            return;
        }
        zk1Var.a(202);
    }

    @Override // com.baidu.tieba.al1
    public synchronized void a(JSONObject jSONObject, zk1 zk1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, zk1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = zk1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.al1
    public synchronized void b(JSONObject jSONObject, zk1 zk1Var, bl1 bl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, zk1Var, bl1Var) == null) {
            synchronized (this) {
                this.d = bl1Var;
                if (this.c != null) {
                    this.g = zk1Var;
                    if (zk1Var != null && !this.f.contains(zk1Var)) {
                        this.f.add(zk1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
