package com.baidu.tieba;

import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g12 extends f12 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends oz1>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<oz1> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947740993, "Lcom/baidu/tieba/g12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947740993, "Lcom/baidu/tieba/g12;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", l02.class);
        m.put("fillRect", a02.class);
        m.put("setStrokeStyle", u02.class);
        m.put("strokeStyle", b12.class);
        m.put("setLineCap", o02.class);
        m.put("setLineJoin", q02.class);
        m.put("setLineWidth", r02.class);
        m.put("setLineDash", p02.class);
        m.put("setMiterLimit", s02.class);
        m.put("strokeRect", a12.class);
        m.put("moveTo", e02.class);
        m.put("lineTo", d02.class);
        m.put("stroke", z02.class);
        m.put("fill", zz1.class);
        m.put("beginPath", rz1.class);
        m.put("rect", g02.class);
        m.put("clearRect", tz1.class);
        m.put("closePath", vz1.class);
        m.put("arc", qz1.class);
        m.put("bezierCurveTo", sz1.class);
        m.put("quadraticCurveTo", f02.class);
        m.put("scale", k02.class);
        m.put("rotate", i02.class);
        m.put("translate", e12.class);
        m.put("transform", d12.class);
        m.put("setTransform", x02.class);
        m.put("font", c02.class);
        m.put("setFontSize", m02.class);
        m.put("setTextAlign", v02.class);
        m.put("setTextBaseline", w02.class);
        m.put("fillText", b02.class);
        m.put("strokeText", c12.class);
        m.put("clip", uz1.class);
        m.put("drawImage", yz1.class);
        m.put("save", j02.class);
        m.put("restore", h02.class);
        m.put("setShadow", t02.class);
        m.put("setGlobalAlpha", n02.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g12(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = new ArrayList();
        this.l = false;
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = new JSONArray(jSONObject.optString(NotificationCompat.WearableExtender.KEY_ACTIONS));
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                Class<? extends oz1> cls = m.get(optString);
                if (cls != null) {
                    oz1 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (sm1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<oz1> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.k;
        }
        return (List) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.f12, com.baidu.tieba.y12, com.baidu.tieba.gw2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.isValid();
        }
        return invokeV.booleanValue;
    }
}
