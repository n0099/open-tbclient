package com.baidu.tieba;

import android.graphics.Point;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bb0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static float j = 0.0f;
    public static float k = 0.0f;
    public static float l = 1.0f;
    public static float m = 1.0f;
    public static float n;
    public static List<Point> o;
    public static List<Point> p;
    public static List<Point> q;
    public static List<Point> r;
    public static List<List<Point>> s;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public List<Point> f;
    public List<Point> g;
    public List<Point> h;
    public List<Point> i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947639065, "Lcom/baidu/tieba/bb0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947639065, "Lcom/baidu/tieba/bb0;");
                return;
            }
        }
        a();
    }

    public bb0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = j;
        this.b = k;
        this.c = l;
        this.d = m;
        this.e = n;
        this.f = o;
        this.g = p;
        this.h = q;
        this.i = r;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            ArrayList arrayList = new ArrayList();
            o = arrayList;
            arrayList.add(new Point(0, 0));
            o.add(new Point(255, 255));
            ArrayList arrayList2 = new ArrayList();
            p = arrayList2;
            arrayList2.add(new Point(0, 0));
            p.add(new Point(255, 255));
            ArrayList arrayList3 = new ArrayList();
            q = arrayList3;
            arrayList3.add(new Point(0, 0));
            q.add(new Point(255, 255));
            ArrayList arrayList4 = new ArrayList();
            r = arrayList4;
            arrayList4.add(new Point(0, 0));
            r.add(new Point(255, 255));
            ArrayList arrayList5 = new ArrayList();
            s = arrayList5;
            arrayList5.add(o);
            s.add(p);
            s.add(q);
            s.add(r);
        }
    }

    public static bb0 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject == null || jSONObject.length() == 0) {
                return null;
            }
            bb0 bb0Var = new bb0();
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject("female");
                if (jSONObject2 != null) {
                    jSONObject2.optDouble("intensity_smooth");
                    jSONObject2.optDouble("intensity_white");
                }
                JSONObject jSONObject3 = jSONObject.getJSONObject("male");
                if (jSONObject3 != null) {
                    jSONObject3.optDouble("intensity_smooth");
                    jSONObject3.optDouble("intensity_white");
                }
                bb0Var.a = (float) jSONObject.optDouble("intensity_sharpness");
                bb0Var.b = (float) jSONObject.optDouble("intensity_brightness");
                bb0Var.c = (float) jSONObject.optDouble("intensity_contrast");
                bb0Var.d = (float) jSONObject.optDouble("intensity_saturation");
                JSONObject optJSONObject = jSONObject.optJSONObject("curves");
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    bb0Var.e = (float) optJSONObject.optDouble("intensity_curves");
                    JSONArray jSONArray = optJSONObject.getJSONArray("composite");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        bb0Var.f = new CopyOnWriteArrayList();
                        for (int i9 = 0; i9 < jSONArray.length(); i9++) {
                            JSONObject jSONObject4 = jSONArray.getJSONObject(i9);
                            if (jSONObject4 != null && jSONObject4.length() > 0) {
                                i8 = jSONObject4.optInt("x");
                                i7 = jSONObject4.optInt("y");
                            } else {
                                i7 = 0;
                                i8 = 0;
                            }
                            bb0Var.f.add(new Point(i8, i7));
                        }
                    }
                    JSONArray jSONArray2 = optJSONObject.getJSONArray(DownloadStatisticConstants.UBC_VALUE_RED);
                    if (jSONArray2 != null && jSONArray2.length() > 0) {
                        bb0Var.g = new CopyOnWriteArrayList();
                        for (int i10 = 0; i10 < jSONArray2.length(); i10++) {
                            JSONObject jSONObject5 = jSONArray2.getJSONObject(i10);
                            if (jSONObject5 != null && jSONObject5.length() > 0) {
                                i6 = jSONObject5.optInt("x");
                                i5 = jSONObject5.optInt("y");
                            } else {
                                i5 = 0;
                                i6 = 0;
                            }
                            bb0Var.g.add(new Point(i6, i5));
                        }
                    }
                    JSONArray jSONArray3 = optJSONObject.getJSONArray("green");
                    if (jSONArray3 != null && jSONArray3.length() > 0) {
                        bb0Var.h = new CopyOnWriteArrayList();
                        for (int i11 = 0; i11 < jSONArray3.length(); i11++) {
                            JSONObject jSONObject6 = jSONArray3.getJSONObject(i11);
                            if (jSONObject6 != null && jSONObject6.length() > 0) {
                                i4 = jSONObject6.optInt("x");
                                i3 = jSONObject6.optInt("y");
                            } else {
                                i3 = 0;
                                i4 = 0;
                            }
                            bb0Var.h.add(new Point(i4, i3));
                        }
                    }
                    JSONArray jSONArray4 = optJSONObject.getJSONArray("blue");
                    if (jSONArray4 != null && jSONArray4.length() > 0) {
                        bb0Var.i = new CopyOnWriteArrayList();
                        for (int i12 = 0; i12 < jSONArray4.length(); i12++) {
                            JSONObject jSONObject7 = jSONArray4.getJSONObject(i12);
                            if (jSONObject7 != null && jSONObject7.length() > 0) {
                                i2 = jSONObject7.optInt("x");
                                i = jSONObject7.optInt("y");
                            } else {
                                i = 0;
                                i2 = 0;
                            }
                            bb0Var.i.add(new Point(i2, i));
                        }
                    }
                }
                return bb0Var;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (bb0) invokeL.objValue;
    }
}
