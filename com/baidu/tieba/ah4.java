package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
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
public class ah4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public JSONObject a;

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
            this.a = new JSONObject();
        }

        public static a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                return new a();
            }
            return (a) invokeV.objValue;
        }

        public JSONObject b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return (JSONObject) invokeV.objValue;
        }

        public a c(String str, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        this.a.put(str, obj);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            return (a) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947615164, "Lcom/baidu/tieba/ah4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947615164, "Lcom/baidu/tieba/ah4;");
                return;
            }
        }
        a = fs1.a;
    }

    public static void a(fh4 fh4Var, py2 py2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, fh4Var, py2Var) == null) {
            a a2 = a.a();
            a2.c("mapId", fh4Var.j);
            a2.c("markerId", py2Var.a);
            JSONObject b = a2.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("vtype", "callouttap");
                jSONObject.put("data", b.toString());
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, fh4Var.i);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            cr3.d(fh4Var.i, fh4Var.j, "map", "callouttap", jSONObject);
        }
    }

    public static void b(View view2, fh4 fh4Var) {
        String str;
        ny2 ny2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, view2, fh4Var) == null) {
            dh4 G = fh4Var.G(view2);
            if (G != null && (ny2Var = G.a) != null) {
                str = ny2Var.a;
            } else {
                str = "";
            }
            a a2 = a.a();
            a2.c("mapId", fh4Var.j);
            a2.c("controlId", str);
            JSONObject b = a2.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("vtype", "controltap");
                jSONObject.put("data", b.toString());
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, fh4Var.i);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            cr3.d(fh4Var.i, fh4Var.j, "map", "controltap", jSONObject);
        }
    }

    public static void e(Marker marker, fh4 fh4Var) {
        String str;
        py2 py2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, marker, fh4Var) == null) {
            eh4 H = fh4Var.H(marker);
            if (H != null && (py2Var = H.a) != null) {
                str = py2Var.a;
            } else {
                str = "";
            }
            a a2 = a.a();
            a2.c("mapId", fh4Var.j);
            a2.c("markerId", str);
            JSONObject b = a2.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("vtype", "markertap");
                jSONObject.put("data", b.toString());
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, fh4Var.i);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            cr3.d(fh4Var.i, fh4Var.j, "map", "markertap", jSONObject);
        }
    }

    public static void c(fh4 fh4Var, LatLng latLng) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, fh4Var, latLng) == null) {
            a a2 = a.a();
            a2.c("latitude", Double.valueOf(latLng.latitude));
            a2.c("longitude", Double.valueOf(latLng.longitude));
            JSONObject b = a2.b();
            a a3 = a.a();
            a3.c("mapId", fh4Var.j);
            a3.c(CriusAttrConstants.POSITION, b);
            JSONObject b2 = a3.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("vtype", "tap");
                jSONObject.put("data", b2.toString());
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, fh4Var.i);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            cr3.d(fh4Var.i, fh4Var.j, "map", "tap", jSONObject);
        }
    }

    public static void d(fh4 fh4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fh4Var) == null) {
            a a2 = a.a();
            a2.c("mapId", fh4Var.j);
            JSONObject b = a2.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("vtype", "updated");
                jSONObject.put("data", b.toString());
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, fh4Var.i);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            cr3.d(fh4Var.i, fh4Var.j, "map", "updated", jSONObject);
        }
    }

    public static void f(fh4 fh4Var, MapStatus mapStatus, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65542, null, fh4Var, mapStatus, i) == null) {
            a a2 = a.a();
            a2.c("latitude", Double.valueOf(mapStatus.bound.northeast.latitude));
            a2.c("longitude", Double.valueOf(mapStatus.bound.northeast.longitude));
            JSONObject b = a2.b();
            a a3 = a.a();
            a3.c("latitude", Double.valueOf(mapStatus.bound.southwest.latitude));
            a3.c("longitude", Double.valueOf(mapStatus.bound.southwest.longitude));
            JSONObject b2 = a3.b();
            a a4 = a.a();
            a4.c("mapId", fh4Var.j);
            a4.c("northeast", b);
            a4.c("southwest", b2);
            a4.c("scale", Float.valueOf(mapStatus.zoom));
            a4.c("reason", Integer.valueOf(i));
            JSONObject b3 = a4.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("vtype", "regionchange");
                jSONObject.put("data", b3.toString());
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, fh4Var.i);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            cr3.d(fh4Var.i, fh4Var.j, "map", "regionchange", jSONObject);
        }
    }
}
