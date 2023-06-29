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
public class a72 extends z62 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends i52>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<i52> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947568013, "Lcom/baidu/tieba/a72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947568013, "Lcom/baidu/tieba/a72;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", f62.class);
        m.put("fillRect", u52.class);
        m.put("setStrokeStyle", o62.class);
        m.put("strokeStyle", v62.class);
        m.put("setLineCap", i62.class);
        m.put("setLineJoin", k62.class);
        m.put("setLineWidth", l62.class);
        m.put("setLineDash", j62.class);
        m.put("setMiterLimit", m62.class);
        m.put("strokeRect", u62.class);
        m.put("moveTo", y52.class);
        m.put("lineTo", x52.class);
        m.put("stroke", t62.class);
        m.put("fill", t52.class);
        m.put("beginPath", l52.class);
        m.put("rect", a62.class);
        m.put("clearRect", n52.class);
        m.put("closePath", p52.class);
        m.put("arc", k52.class);
        m.put("bezierCurveTo", m52.class);
        m.put("quadraticCurveTo", z52.class);
        m.put("scale", e62.class);
        m.put("rotate", c62.class);
        m.put("translate", y62.class);
        m.put("transform", x62.class);
        m.put("setTransform", r62.class);
        m.put("font", w52.class);
        m.put("setFontSize", g62.class);
        m.put("setTextAlign", p62.class);
        m.put("setTextBaseline", q62.class);
        m.put("fillText", v52.class);
        m.put("strokeText", w62.class);
        m.put("clip", o52.class);
        m.put("drawImage", s52.class);
        m.put("save", d62.class);
        m.put("restore", b62.class);
        m.put("setShadow", n62.class);
        m.put("setGlobalAlpha", h62.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a72(String str) {
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
                Class<? extends i52> cls = m.get(optString);
                if (cls != null) {
                    i52 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (ms1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<i52> h() {
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

    @Override // com.baidu.tieba.z62, com.baidu.tieba.s72, com.baidu.tieba.b23
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.isValid();
        }
        return invokeV.booleanValue;
    }
}
