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
/* loaded from: classes5.dex */
public class f12 extends e12 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends nz1>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<nz1> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947711202, "Lcom/baidu/tieba/f12;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947711202, "Lcom/baidu/tieba/f12;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", k02.class);
        m.put("fillRect", zz1.class);
        m.put("setStrokeStyle", t02.class);
        m.put("strokeStyle", a12.class);
        m.put("setLineCap", n02.class);
        m.put("setLineJoin", p02.class);
        m.put("setLineWidth", q02.class);
        m.put("setLineDash", o02.class);
        m.put("setMiterLimit", r02.class);
        m.put("strokeRect", z02.class);
        m.put("moveTo", d02.class);
        m.put("lineTo", c02.class);
        m.put("stroke", y02.class);
        m.put("fill", yz1.class);
        m.put("beginPath", qz1.class);
        m.put("rect", f02.class);
        m.put("clearRect", sz1.class);
        m.put("closePath", uz1.class);
        m.put("arc", pz1.class);
        m.put("bezierCurveTo", rz1.class);
        m.put("quadraticCurveTo", e02.class);
        m.put("scale", j02.class);
        m.put("rotate", h02.class);
        m.put("translate", d12.class);
        m.put("transform", c12.class);
        m.put("setTransform", w02.class);
        m.put("font", b02.class);
        m.put("setFontSize", l02.class);
        m.put("setTextAlign", u02.class);
        m.put("setTextBaseline", v02.class);
        m.put("fillText", a02.class);
        m.put("strokeText", b12.class);
        m.put("clip", tz1.class);
        m.put("drawImage", xz1.class);
        m.put("save", i02.class);
        m.put("restore", g02.class);
        m.put("setShadow", s02.class);
        m.put("setGlobalAlpha", m02.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f12(String str) {
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
                Class<? extends nz1> cls = m.get(optString);
                if (cls != null) {
                    nz1 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (rm1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<nz1> h() {
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

    @Override // com.baidu.tieba.e12, com.baidu.tieba.x12, com.baidu.tieba.fw2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.isValid();
        }
        return invokeV.booleanValue;
    }
}
