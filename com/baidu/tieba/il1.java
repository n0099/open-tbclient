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
/* loaded from: classes4.dex */
public class il1 implements el1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public qt3 c;
    public fl1 d;
    public zs3 e;
    public List<dl1> f;
    public dl1 g;
    public dl1 h;
    public Map<String, String> i;
    public pt3 j;

    /* loaded from: classes4.dex */
    public class a implements pt3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ il1 a;

        @Override // com.baidu.tieba.pt3
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public a(il1 il1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {il1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = il1Var;
        }

        @Override // com.baidu.tieba.pt3
        public void onError(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.a.d.c(hl1.b(str));
                st3.k(this.a.i, str);
            }
        }

        @Override // com.baidu.tieba.pt3
        public void b(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
                if (z) {
                    this.a.d.b();
                    this.a.g.a(0);
                    for (dl1 dl1Var : this.a.f) {
                        dl1Var.a(0);
                        if (this.a.f.contains(dl1Var)) {
                            this.a.f.remove(dl1Var);
                        }
                    }
                    return;
                }
                this.a.g.a(1001);
                for (dl1 dl1Var2 : this.a.f) {
                    dl1Var2.a(1001);
                    if (this.a.f.contains(dl1Var2)) {
                        this.a.f.remove(dl1Var2);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.pt3
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

        @Override // com.baidu.tieba.pt3
        public void d(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.a.d.a(hl1.a(z));
            }
        }
    }

    public il1(@NonNull JSONObject jSONObject, fl1 fl1Var, dl1 dl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, fl1Var, dl1Var};
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
            this.i = st3.a("video", "app", optString, this.a, false);
            this.e = new jl1();
            qt3 qt3Var = new qt3(wp2.U().getActivity(), this.b, this.a, false, this.j, this.e);
            this.c = qt3Var;
            qt3Var.k0(this.i);
            this.f = new CopyOnWriteArrayList();
            b(jSONObject, dl1Var, fl1Var);
            return;
        }
        dl1Var.a(202);
    }

    @Override // com.baidu.tieba.el1
    public synchronized void a(JSONObject jSONObject, dl1 dl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, dl1Var) == null) {
            synchronized (this) {
                if (this.c != null) {
                    this.h = dl1Var;
                    this.c.l0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.el1
    public synchronized void b(JSONObject jSONObject, dl1 dl1Var, fl1 fl1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, dl1Var, fl1Var) == null) {
            synchronized (this) {
                this.d = fl1Var;
                if (this.c != null) {
                    this.g = dl1Var;
                    if (dl1Var != null && !this.f.contains(dl1Var)) {
                        this.f.add(dl1Var);
                    }
                    this.c.c0();
                }
            }
        }
    }
}
