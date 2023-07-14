package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.tieba.hl3;
import com.baidu.tieba.yz1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c22 extends b22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "AccelerometerApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements yz1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c22 a;

        /* renamed from: com.baidu.tieba.c22$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0253a implements hl3.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ n22 b;
            public final /* synthetic */ a c;

            public C0253a(a aVar, String str, n22 n22Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, str, n22Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = str;
                this.b = n22Var;
            }

            @Override // com.baidu.tieba.hl3.a
            public void a(double[] dArr) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dArr) == null) {
                    if (dArr != null && dArr.length == 3) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("x", dArr[0]);
                            jSONObject.put("y", dArr[1]);
                            jSONObject.put("z", dArr[2]);
                            this.b.d(this.c.a, jSONObject);
                            return;
                        } catch (JSONException e) {
                            this.c.a.p("json put data fail", e, true);
                            this.b.f(this.c.a, "json put data fail");
                            return;
                        }
                    }
                    this.c.a.p("illegal accelerometers", null, true);
                    this.c.a.d(this.a, new v32(1001));
                }
            }
        }

        public a(c22 c22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c22Var;
        }

        @Override // com.baidu.tieba.yz1.a
        public v32 a(vb3 vb3Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, vb3Var, jSONObject, str)) == null) {
                n22 n22Var = new n22("accelerometerChange", jSONObject, str);
                hl3 a = hl3.a();
                a.b(this.a.getContext(), b.a(jSONObject.optString("interval")));
                a.e(new C0253a(this, str, n22Var));
                a.f();
                n22Var.b(this.a);
                return v32.f();
            }
            return (v32) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static ArrayMap<String, Integer> a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-940258872, "Lcom/baidu/tieba/c22$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-940258872, "Lcom/baidu/tieba/c22$b;");
                    return;
                }
            }
            ArrayMap<String, Integer> arrayMap = new ArrayMap<>(3);
            a = arrayMap;
            arrayMap.put(TaskUIData.key, 60);
            a.put("game", 20);
            a.put("normal", 200);
        }

        public static int a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                Integer num = a.get(str);
                if (num != null) {
                    return num.intValue();
                }
                return 200;
            }
            return invokeL.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c22(@NonNull wz1 wz1Var) {
        super(wz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public v32 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#startAccelerometer", false);
            return l(str, true, new a(this));
        }
        return (v32) invokeL.objValue;
    }

    public v32 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#stopAccelerometer", true);
            hl3.a().g();
            return v32.f();
        }
        return (v32) invokeV.objValue;
    }
}
