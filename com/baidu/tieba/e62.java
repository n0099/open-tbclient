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
public class e62 extends d62 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends m42>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<m42> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947686216, "Lcom/baidu/tieba/e62;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947686216, "Lcom/baidu/tieba/e62;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", j52.class);
        m.put("fillRect", y42.class);
        m.put("setStrokeStyle", s52.class);
        m.put("strokeStyle", z52.class);
        m.put("setLineCap", m52.class);
        m.put("setLineJoin", o52.class);
        m.put("setLineWidth", p52.class);
        m.put("setLineDash", n52.class);
        m.put("setMiterLimit", q52.class);
        m.put("strokeRect", y52.class);
        m.put("moveTo", c52.class);
        m.put("lineTo", b52.class);
        m.put("stroke", x52.class);
        m.put("fill", x42.class);
        m.put("beginPath", p42.class);
        m.put("rect", e52.class);
        m.put("clearRect", r42.class);
        m.put("closePath", t42.class);
        m.put("arc", o42.class);
        m.put("bezierCurveTo", q42.class);
        m.put("quadraticCurveTo", d52.class);
        m.put("scale", i52.class);
        m.put("rotate", g52.class);
        m.put("translate", c62.class);
        m.put("transform", b62.class);
        m.put("setTransform", v52.class);
        m.put("font", a52.class);
        m.put("setFontSize", k52.class);
        m.put("setTextAlign", t52.class);
        m.put("setTextBaseline", u52.class);
        m.put("fillText", z42.class);
        m.put("strokeText", a62.class);
        m.put("clip", s42.class);
        m.put("drawImage", w42.class);
        m.put("save", h52.class);
        m.put("restore", f52.class);
        m.put("setShadow", r52.class);
        m.put("setGlobalAlpha", l52.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e62(String str) {
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
                Class<? extends m42> cls = m.get(optString);
                if (cls != null) {
                    m42 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (qr1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<m42> h() {
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

    @Override // com.baidu.tieba.d62, com.baidu.tieba.w62, com.baidu.tieba.f13
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.isValid();
        }
        return invokeV.booleanValue;
    }
}
