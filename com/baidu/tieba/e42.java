package com.baidu.tieba;

import androidx.core.app.NotificationCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
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
public class e42 extends d42 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends m22>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<m22> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947684294, "Lcom/baidu/tieba/e42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947684294, "Lcom/baidu/tieba/e42;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", j32.class);
        m.put("fillRect", y22.class);
        m.put("setStrokeStyle", s32.class);
        m.put("strokeStyle", z32.class);
        m.put("setLineCap", m32.class);
        m.put("setLineJoin", o32.class);
        m.put("setLineWidth", p32.class);
        m.put("setLineDash", n32.class);
        m.put("setMiterLimit", q32.class);
        m.put("strokeRect", y32.class);
        m.put("moveTo", c32.class);
        m.put("lineTo", b32.class);
        m.put("stroke", x32.class);
        m.put("fill", x22.class);
        m.put("beginPath", p22.class);
        m.put("rect", e32.class);
        m.put("clearRect", r22.class);
        m.put("closePath", t22.class);
        m.put("arc", o22.class);
        m.put("bezierCurveTo", q22.class);
        m.put("quadraticCurveTo", d32.class);
        m.put("scale", i32.class);
        m.put("rotate", g32.class);
        m.put("translate", c42.class);
        m.put("transform", b42.class);
        m.put("setTransform", v32.class);
        m.put("font", a32.class);
        m.put("setFontSize", k32.class);
        m.put("setTextAlign", t32.class);
        m.put("setTextBaseline", u32.class);
        m.put("fillText", z22.class);
        m.put("strokeText", a42.class);
        m.put("clip", s22.class);
        m.put("drawImage", w22.class);
        m.put(CommandUBCHelper.COMMAND_UBC_TYPE_SAVE, h32.class);
        m.put("restore", f32.class);
        m.put("setShadow", r32.class);
        m.put("setGlobalAlpha", l32.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e42(String str) {
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
                Class<? extends m22> cls = m.get(optString);
                if (cls != null) {
                    m22 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (qp1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<m22> h() {
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

    @Override // com.baidu.tieba.d42, com.baidu.tieba.w42, com.baidu.tieba.fz2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.isValid();
        }
        return invokeV.booleanValue;
    }
}
