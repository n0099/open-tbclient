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
public class f62 extends e62 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends n42>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<n42> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947716007, "Lcom/baidu/tieba/f62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947716007, "Lcom/baidu/tieba/f62;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", k52.class);
        m.put("fillRect", z42.class);
        m.put("setStrokeStyle", t52.class);
        m.put("strokeStyle", a62.class);
        m.put("setLineCap", n52.class);
        m.put("setLineJoin", p52.class);
        m.put("setLineWidth", q52.class);
        m.put("setLineDash", o52.class);
        m.put("setMiterLimit", r52.class);
        m.put("strokeRect", z52.class);
        m.put("moveTo", d52.class);
        m.put("lineTo", c52.class);
        m.put("stroke", y52.class);
        m.put("fill", y42.class);
        m.put("beginPath", q42.class);
        m.put("rect", f52.class);
        m.put("clearRect", s42.class);
        m.put("closePath", u42.class);
        m.put("arc", p42.class);
        m.put("bezierCurveTo", r42.class);
        m.put("quadraticCurveTo", e52.class);
        m.put("scale", j52.class);
        m.put("rotate", h52.class);
        m.put("translate", d62.class);
        m.put("transform", c62.class);
        m.put("setTransform", w52.class);
        m.put("font", b52.class);
        m.put("setFontSize", l52.class);
        m.put("setTextAlign", u52.class);
        m.put("setTextBaseline", v52.class);
        m.put("fillText", a52.class);
        m.put("strokeText", b62.class);
        m.put("clip", t42.class);
        m.put("drawImage", x42.class);
        m.put("save", i52.class);
        m.put("restore", g52.class);
        m.put("setShadow", s52.class);
        m.put("setGlobalAlpha", m52.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f62(String str) {
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
                Class<? extends n42> cls = m.get(optString);
                if (cls != null) {
                    n42 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (rr1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<n42> h() {
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

    @Override // com.baidu.tieba.e62, com.baidu.tieba.x62, com.baidu.tieba.g13
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.isValid();
        }
        return invokeV.booleanValue;
    }
}
