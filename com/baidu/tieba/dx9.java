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
/* loaded from: classes4.dex */
public class dx9 {
    public static /* synthetic */ Interceptable $ic;
    public static dx9 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx9 a;

        public a(dx9 dx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                List a = dx9.a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    cx9 cx9Var = (cx9) a.get(i);
                    this.a.j(cx9Var.a, cx9Var.b);
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<cx9, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx9 a;

        public b(dx9 dx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dx9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(cx9... cx9VarArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cx9VarArr)) == null) {
                if (cx9VarArr != null && cx9VarArr.length == 1 && cx9VarArr[0] != null) {
                    this.a.c(cx9VarArr[0]);
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947720068, "Lcom/baidu/tieba/dx9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947720068, "Lcom/baidu/tieba/dx9;");
                return;
            }
        }
        a = new dx9();
    }

    public dx9() {
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

    public static dx9 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return a;
        }
        return (dx9) invokeV.objValue;
    }

    public static File[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            File file = new File(vp8.e);
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
            new b(this).execute(new cx9(str, jSONObject));
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
                return new JSONObject().put("running", l(tp8.d(str)));
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
                jSONObject = new JSONObject(tp8.e(file));
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

    public final void c(cx9 cx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cx9Var) == null) {
            try {
                byte[] b2 = ex9.b(cx9Var.b);
                ex9.c(b2, TbConfig.SERVER_ADDRESS + TbConfig.URL_POST_VIDEO_MONITOR_REPORT);
                tp8.b(cx9Var.a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static List<cx9> h() {
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
                JSONObject f = f(file.getAbsolutePath() + vp8.a + "kpi");
                if (f == null) {
                    tp8.b(name);
                } else {
                    JSONObject e = e(file.getAbsolutePath() + vp8.a + "debug");
                    if (e == null) {
                        tp8.b(name);
                    } else {
                        arrayList.add(new cx9(name, i(VideoPlatformStatic.c(), f, e)));
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
                jSONArray.put(new hb9(502, "unknown", -4399, "").a());
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }
}
