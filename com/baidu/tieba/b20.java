package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b20 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized void a(List<t8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, list) == null) {
            synchronized (b20.class) {
                if (list != null) {
                    if (list.size() > 0) {
                        if (AppConfig.isDebug()) {
                            Log.d("ExperimentManager", "deleteExpInfoList >> " + list.size());
                        }
                        String a = e20.a();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (!TextUtils.isEmpty(a)) {
                                jSONObject = new JSONObject(a);
                            }
                            for (t8 t8Var : list) {
                                jSONObject.remove(t8Var.c() + "_" + t8Var.b());
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        e20.f(jSONObject);
                    }
                }
            }
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return e20.a();
        }
        return (String) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return e20.b();
        }
        return (String) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return e20.c();
        }
        return (String) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return e20.d();
        }
        return (String) invokeV.objValue;
    }

    public static JSONObject[] f(JSONObject jSONObject, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, jSONObject, i)) == null) {
            JSONObject[] jSONObjectArr = new JSONObject[i];
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                int a = l20.a(next, i);
                JSONObject jSONObject2 = jSONObjectArr[a];
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                    jSONObjectArr[a] = jSONObject2;
                }
                try {
                    Object obj = jSONObject.get(next);
                    if (obj != null) {
                        jSONObject2.put(next, obj);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return jSONObjectArr;
        }
        return (JSONObject[]) invokeLI.objValue;
    }

    public static synchronized boolean o(JSONObject jSONObject, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65550, null, jSONObject, z)) == null) {
            synchronized (b20.class) {
                if (jSONObject != null) {
                    if (jSONObject.length() != 0) {
                        int a = e9.b().a();
                        return m(f(jSONObject, a), a, z);
                    }
                }
                return false;
            }
        }
        return invokeLZ.booleanValue;
    }

    public static synchronized void g(List<t8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, list) == null) {
            synchronized (b20.class) {
                if (list != null) {
                    if (list.size() != 0) {
                        if (AppConfig.isDebug()) {
                            Log.d("ExperimentManager", "saveExpInfoList >> " + list.size());
                        }
                        String a = e20.a();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (!TextUtils.isEmpty(a)) {
                                jSONObject = new JSONObject(a);
                            }
                            for (t8 t8Var : list) {
                                String str = t8Var.c() + "_" + t8Var.b();
                                JSONObject jSONObject2 = new JSONObject();
                                if (t8Var.e() && t8Var.d() != -1) {
                                    jSONObject2.put("is_upload", t8Var.e());
                                    jSONObject2.put("expired_time", t8Var.d());
                                }
                                jSONObject.put(str, jSONObject2);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        e20.f(jSONObject);
                    }
                }
            }
        }
    }

    public static synchronized void h(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, jSONObject) == null) {
            synchronized (b20.class) {
                if (jSONObject != null) {
                    if (jSONObject.length() != 0) {
                        e20.g(jSONObject);
                    }
                }
            }
        }
    }

    public static synchronized void i(JSONObject jSONObject, JSONObject jSONObject2, List<t8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, jSONObject, jSONObject2, list) == null) {
            synchronized (b20.class) {
                o(jSONObject2, false);
                j(jSONObject);
                g(list);
            }
        }
    }

    public static synchronized void k(JSONObject jSONObject, JSONObject jSONObject2, List<t8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, jSONObject, jSONObject2, list) == null) {
            synchronized (b20.class) {
                o(jSONObject2, true);
                l(jSONObject);
                g(list);
            }
        }
    }

    public static synchronized void j(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, jSONObject) == null) {
            synchronized (b20.class) {
                if (AppConfig.isDebug()) {
                    Log.d("ExperimentManager", "saveV1SwitchData >> " + jSONObject);
                }
                e20.h(jSONObject);
            }
        }
    }

    public static synchronized boolean l(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, jSONObject)) == null) {
            synchronized (b20.class) {
                if (jSONObject != null) {
                    if (jSONObject.length() != 0) {
                        String d = e20.d();
                        if (!TextUtils.isEmpty(d)) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(d);
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    jSONObject2.put(next, jSONObject.get(next));
                                }
                                if (jSONObject2.length() > 0) {
                                    e20.i(jSONObject2);
                                    return true;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else {
                            e20.i(jSONObject);
                        }
                        return false;
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean m(JSONObject[] jSONObjectArr, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{jSONObjectArr, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            for (int i2 = 0; i2 < i; i2++) {
                JSONObject jSONObject = jSONObjectArr[i2];
                String e = e20.e(i2);
                if (TextUtils.isEmpty(e)) {
                    e20.j(jSONObject, i2);
                } else {
                    try {
                        JSONObject jSONObject2 = new JSONObject(e);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            Object obj = jSONObject.get(next);
                            if (!jSONObject2.has(next) || z) {
                                jSONObject2.put(next, obj);
                            }
                        }
                        if (jSONObject2.length() > 0) {
                            e20.j(jSONObject2, i2);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static synchronized void n(JSONObject jSONObject, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65549, null, jSONObject, i) == null) {
            synchronized (b20.class) {
                if (jSONObject != null) {
                    if (jSONObject.length() != 0) {
                        String e = e20.e(i);
                        if (!TextUtils.isEmpty(e)) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(e);
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    jSONObject2.put(next, jSONObject.get(next));
                                }
                                e20.j(jSONObject2, i);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            e20.j(jSONObject, i);
                        }
                    }
                }
            }
        }
    }
}
