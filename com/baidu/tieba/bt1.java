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
/* loaded from: classes5.dex */
public class bt1 implements xs1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public j14 c;
    public ys1 d;
    public s04 e;
    public List<ws1> f;
    public ws1 g;
    public ws1 h;
    public Map<String, String> i;
    public i14 j;

    /* loaded from: classes5.dex */
    public class a implements i14 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bt1 a;

        @Override // com.baidu.tieba.i14
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        public a(bt1 bt1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bt1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bt1Var;
        }

        @Override // com.baidu.tieba.i14
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(at1.b(str));
                l14.k(this.a.i, str);
            }
        }

        @Override // com.baidu.tieba.i14
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (ws1 ws1Var : this.a.f) {
                        ws1Var.a(0);
                        if (this.a.f.contains(ws1Var)) {
                            this.a.f.remove(ws1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (ws1 ws1Var2 : this.a.f) {
                    ws1Var2.a(1001);
                    if (this.a.f.contains(ws1Var2)) {
                        this.a.f.remove(ws1Var2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.i14
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

        @Override // com.baidu.tieba.i14
        public void c(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(at1.a(z));
            }
        }
    }

    public bt1(@NonNull JSONObject jSONObject, ys1 ys1Var, ws1 ws1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, ys1Var, ws1Var};
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
            this.i = l14.a("video", "app", optString, this.a, false);
            this.e = new ct1();
            j14 j14Var = new j14(px2.T().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = j14Var;
            j14Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, ws1Var, ys1Var);
            return;
        }
        ws1Var.a(202);
    }

    @Override // com.baidu.tieba.xs1
    public synchronized void a(JSONObject jSONObject, ws1 ws1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, ws1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = ws1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.xs1
    public synchronized void b(JSONObject jSONObject, ws1 ws1Var, ys1 ys1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, ws1Var, ys1Var) == null) {
            synchronized (this) {
                this.d = ys1Var;
                if (this.c != null) {
                    this.g = ws1Var;
                    if (ws1Var != null && !this.f.contains(ws1Var)) {
                        this.f.add(ws1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
