package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class at9 {
    public static /* synthetic */ Interceptable $ic;
    public static at9 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ at9 a;

        public a(at9 at9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = at9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                List a = at9.a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    zs9 zs9Var = (zs9) a.get(i);
                    this.a.j(zs9Var.a, zs9Var.b);
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<zs9, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ at9 a;

        public b(at9 at9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = at9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(zs9... zs9VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, zs9VarArr)) == null) {
                if (zs9VarArr != null && zs9VarArr.length == 1 && zs9VarArr[0] != null) {
                    this.a.c(zs9VarArr[0]);
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947626851, "Lcom/baidu/tieba/at9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947626851, "Lcom/baidu/tieba/at9;");
                return;
            }
        }
        a = new at9();
    }

    public at9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static /* synthetic */ List a() {
        return h();
    }

    public static at9 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return a;
        }
        return (at9) invokeV.objValue;
    }

    public static File[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            File file = new File(en8.e);
            if (!file.exists()) {
                return null;
            }
            return file.listFiles();
        }
        return (File[]) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || !di.c()) {
            return;
        }
        new a(this).execute(new Void[0]);
    }

    public void j(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) {
            new b(this).execute(new zs9(str, jSONObject));
        }
    }

    public static JSONObject e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (StringUtils.isNull(str) || !new File(str).exists()) {
                return null;
            }
            try {
                return new JSONObject().put("running", l(cn8.d(str)));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject f(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            try {
                jSONObject = new JSONObject(cn8.e(file));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!m(jSONObject)) {
                return null;
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static boolean m(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, jSONObject)) == null) {
            int optInt = jSONObject.optInt("errorTimes", -1);
            int optInt2 = jSONObject.optInt("postSuccess", -1);
            int optInt3 = jSONObject.optInt("posted", -1);
            if (optInt != -1 && optInt2 != -1 && optInt3 != -1 && (optInt3 == 1 || optInt > 0)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void c(zs9 zs9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, zs9Var) == null) {
            try {
                byte[] b2 = bt9.b(zs9Var.b);
                bt9.c(b2, TbConfig.SERVER_ADDRESS + TbConfig.URL_POST_VIDEO_MONITOR_REPORT);
                cn8.b(zs9Var.a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static List<zs9> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            ArrayList arrayList = new ArrayList();
            File[] g = g();
            if (g == null) {
                return arrayList;
            }
            for (File file : g) {
                String name = file.getName();
                JSONObject f = f(file.getAbsolutePath() + en8.a + "kpi");
                if (f == null) {
                    cn8.b(name);
                } else {
                    JSONObject e = e(file.getAbsolutePath() + en8.a + "debug");
                    if (e == null) {
                        cn8.b(name);
                    } else {
                        arrayList.add(new zs9(name, i(VideoPlatformStatic.c(), f, e)));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static JSONObject i(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, jSONObject, jSONObject2, jSONObject3)) == null) {
            try {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("kpiInfo", jSONObject2);
                jSONObject4.put("baseInfo", jSONObject);
                jSONObject4.put("debugInfo", jSONObject3);
                return jSONObject4;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (JSONObject) invokeLLL.objValue;
    }

    public static JSONArray l(JSONArray jSONArray) {
        InterceptResult invokeL;
        int optInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, jSONArray)) == null) {
            if (jSONArray == null) {
                return null;
            }
            int length = jSONArray.length();
            boolean z = false;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null && ((optInt = optJSONObject.optInt("type")) == 501 || optInt == 503 || optInt == 502)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                jSONArray.put(new g89(502, "unknown", -4399, "").a());
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }
}
