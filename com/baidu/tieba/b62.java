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
public class b62 extends a62 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends j42>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<j42> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947596843, "Lcom/baidu/tieba/b62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947596843, "Lcom/baidu/tieba/b62;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", g52.class);
        m.put("fillRect", v42.class);
        m.put("setStrokeStyle", p52.class);
        m.put("strokeStyle", w52.class);
        m.put("setLineCap", j52.class);
        m.put("setLineJoin", l52.class);
        m.put("setLineWidth", m52.class);
        m.put("setLineDash", k52.class);
        m.put("setMiterLimit", n52.class);
        m.put("strokeRect", v52.class);
        m.put("moveTo", z42.class);
        m.put("lineTo", y42.class);
        m.put("stroke", u52.class);
        m.put("fill", u42.class);
        m.put("beginPath", m42.class);
        m.put("rect", b52.class);
        m.put("clearRect", o42.class);
        m.put("closePath", q42.class);
        m.put("arc", l42.class);
        m.put("bezierCurveTo", n42.class);
        m.put("quadraticCurveTo", a52.class);
        m.put("scale", f52.class);
        m.put("rotate", d52.class);
        m.put("translate", z52.class);
        m.put("transform", y52.class);
        m.put("setTransform", s52.class);
        m.put("font", x42.class);
        m.put("setFontSize", h52.class);
        m.put("setTextAlign", q52.class);
        m.put("setTextBaseline", r52.class);
        m.put("fillText", w42.class);
        m.put("strokeText", x52.class);
        m.put("clip", p42.class);
        m.put("drawImage", t42.class);
        m.put("save", e52.class);
        m.put("restore", c52.class);
        m.put("setShadow", o52.class);
        m.put("setGlobalAlpha", i52.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b62(String str) {
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
                Class<? extends j42> cls = m.get(optString);
                if (cls != null) {
                    j42 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (nr1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<j42> h() {
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

    @Override // com.baidu.tieba.a62, com.baidu.tieba.t62, com.baidu.tieba.c13
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.isValid();
        }
        return invokeV.booleanValue;
    }
}
