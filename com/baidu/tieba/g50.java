package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.b50;
import com.baidu.tieba.e50;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g50 extends e50 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b50.a d;
    public b e;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HashSet<String> a;
        public HashSet<String> b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new HashSet<>();
            this.b = new HashSet<>();
        }

        public static a c(TrustSubject trustSubject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, trustSubject)) == null) {
                try {
                    String m = trustSubject.m("config-aid");
                    if (!TextUtils.isEmpty(m)) {
                        try {
                            a aVar = new a();
                            JSONObject jSONObject = new JSONObject(m);
                            JSONArray optJSONArray = jSONObject.optJSONArray("blist");
                            if (optJSONArray != null) {
                                int length = optJSONArray.length();
                                for (int i = 0; i < length; i++) {
                                    aVar.a.add(optJSONArray.getString(i));
                                }
                            }
                            JSONArray optJSONArray2 = jSONObject.optJSONArray("reset_blist");
                            if (optJSONArray2 != null) {
                                int length2 = optJSONArray2.length();
                                for (int i2 = 0; i2 < length2; i2++) {
                                    aVar.b.add(optJSONArray2.getString(i2));
                                }
                            }
                            return aVar;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                    return null;
                } catch (TrustSubject.ConfigNotFoundException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return (a) invokeL.objValue;
        }

        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return this.a.contains(str);
            }
            return invokeL.booleanValue;
        }

        public boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                return this.b.contains(str);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] a;
        public String b;
        public String c;
        public long d;
        public boolean e;
        public String f;
        public y40 g;
        public long h;
        public final /* synthetic */ g50 i;

        public b(g50 g50Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g50Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = g50Var;
            this.e = true;
            this.g = new y40();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.c;
            }
            return (String) invokeV.objValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.h;
            }
            return invokeV.longValue;
        }

        public byte[] e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a;
            }
            return (byte[]) invokeV.objValue;
        }

        public long b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                return this.g.a(j);
            }
            return invokeJ.longValue;
        }

        public void h(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048583, this, str) != null) || str == (str2 = this.b)) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.b = str;
                this.e = true;
            }
        }

        public void j(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048585, this, str) != null) || (str2 = this.c) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.c = str;
                this.e = true;
            }
        }

        public void k(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048586, this, j) == null) && j != this.d) {
                this.d = j;
                this.e = true;
            }
        }

        public void l(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048587, this, j) == null) && this.h != j) {
                this.h = j;
                this.e = true;
            }
        }

        public void m(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048588, this, str) != null) || str == (str2 = this.f)) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f = str;
                this.e = true;
            }
        }

        public void n(byte[] bArr) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048589, this, bArr) == null) && !Arrays.equals(bArr, this.a)) {
                this.a = bArr;
                this.e = true;
            }
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.e) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("and_id", this.b);
                        jSONObject.put("form_id", this.c);
                        jSONObject.put("gen_ts", this.d);
                        jSONObject.put("flags", this.g.d());
                        jSONObject.put("c_form_ver", 1);
                        if (!TextUtils.isEmpty(this.f)) {
                            jSONObject.put("ran_id", this.f);
                        }
                        if (this.a != null) {
                            jSONObject.put("raw_id", Base64.encodeToString(this.a, 2));
                        }
                        jSONObject.put("lst_conf_ver", this.h);
                        this.i.d.i("aid.dat", jSONObject.toString(), true);
                        this.e = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                String g = this.i.d.g("aid.dat", true);
                if (!TextUtils.isEmpty(g)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g);
                        this.a = Base64.decode(jSONObject.getString("raw_id"), 2);
                        this.d = jSONObject.getLong("gen_ts");
                        this.c = jSONObject.getString("form_id");
                        this.b = jSONObject.getString("and_id");
                        this.f = jSONObject.optString("ran_id", null);
                        this.g.b(jSONObject.getLong("flags"));
                        this.h = jSONObject.getLong("lst_conf_ver");
                        jSONObject.getInt("c_form_ver");
                        this.e = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void i(long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && this.g.c(j, j2)) {
                this.e = true;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g50() {
        super("aid");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new b(this);
    }

    public static String i(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            return e50.b("A00", new v40("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).c(bArr));
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.e50
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e.c();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e50
    public byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e.e();
        }
        return (byte[]) invokeV.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:3|(2:5|(4:7|8|(1:51)(1:14)|(12:19|(1:21)(1:50)|22|23|24|25|(1:27)|28|(2:(2:41|42)|33)(2:(2:44|(1:46))|42)|(3:35|(1:37)|38)|39|40)(1:17)))(1:53)|52|8|(1:10)|51|(0)|19|(0)(0)|22|23|24|25|(0)|28|(0)(0)|(0)|39|40) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
        if (r13.b(r6) != false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a1  */
    @Override // com.baidu.tieba.e50
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(e50.c cVar) {
        long j;
        boolean z;
        boolean z2;
        String str;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.d = this.a.f("aid");
            this.e.g();
            TrustSubject trustSubject = this.b.c.b;
            boolean z3 = false;
            boolean z4 = true;
            if (trustSubject != null) {
                j = trustSubject.n();
                if (j != this.e.d()) {
                    z = true;
                    if (TextUtils.isEmpty(this.e.c()) && this.e.e() != null && !TextUtils.isEmpty(this.e.a())) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z2 && !z) {
                        return;
                    }
                    str = null;
                    if (trustSubject == null) {
                        aVar = a.c(trustSubject);
                    } else {
                        aVar = null;
                    }
                    str = ApiReplaceUtil.Overload.getString(this.b.a.getContentResolver(), HttpRequest.ANDROID_ID);
                    if (TextUtils.isEmpty(str)) {
                        str = "000000000";
                    }
                    if (!z2) {
                        if (aVar == null || !aVar.a(str)) {
                            z3 = true;
                            z4 = false;
                        }
                        z3 = true;
                    } else {
                        if (aVar != null) {
                            if (this.e.b(1L) == 0) {
                            }
                        }
                        z4 = false;
                    }
                    if (z3) {
                        String str2 = "com.helios" + str;
                        if (z4) {
                            String uuid = UUID.randomUUID().toString();
                            this.e.m(uuid);
                            str2 = str2 + uuid;
                            this.e.i(1L, 1L);
                        }
                        byte[] a2 = z40.a(str2, "utf-8");
                        String i = i(a2);
                        this.e.n(a2);
                        this.e.k(System.currentTimeMillis());
                        this.e.h(str);
                        this.e.j(i);
                    }
                    this.e.l(j);
                    this.e.f();
                }
            } else {
                j = 0;
            }
            z = false;
            if (TextUtils.isEmpty(this.e.c())) {
            }
            z2 = true;
            if (z2) {
            }
            str = null;
            if (trustSubject == null) {
            }
            str = ApiReplaceUtil.Overload.getString(this.b.a.getContentResolver(), HttpRequest.ANDROID_ID);
            if (TextUtils.isEmpty(str)) {
            }
            if (!z2) {
            }
            if (z3) {
            }
            this.e.l(j);
            this.e.f();
        }
    }
}
