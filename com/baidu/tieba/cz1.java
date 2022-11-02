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
/* loaded from: classes3.dex */
public class cz1 extends bz1 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends kx1>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<kx1> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947691951, "Lcom/baidu/tieba/cz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947691951, "Lcom/baidu/tieba/cz1;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", hy1.class);
        m.put("fillRect", wx1.class);
        m.put("setStrokeStyle", qy1.class);
        m.put("strokeStyle", xy1.class);
        m.put("setLineCap", ky1.class);
        m.put("setLineJoin", my1.class);
        m.put("setLineWidth", ny1.class);
        m.put("setLineDash", ly1.class);
        m.put("setMiterLimit", oy1.class);
        m.put("strokeRect", wy1.class);
        m.put("moveTo", ay1.class);
        m.put("lineTo", zx1.class);
        m.put("stroke", vy1.class);
        m.put("fill", vx1.class);
        m.put("beginPath", nx1.class);
        m.put("rect", cy1.class);
        m.put("clearRect", px1.class);
        m.put("closePath", rx1.class);
        m.put("arc", mx1.class);
        m.put("bezierCurveTo", ox1.class);
        m.put("quadraticCurveTo", by1.class);
        m.put("scale", gy1.class);
        m.put("rotate", ey1.class);
        m.put("translate", az1.class);
        m.put("transform", zy1.class);
        m.put("setTransform", ty1.class);
        m.put("font", yx1.class);
        m.put("setFontSize", iy1.class);
        m.put("setTextAlign", ry1.class);
        m.put("setTextBaseline", sy1.class);
        m.put("fillText", xx1.class);
        m.put("strokeText", yy1.class);
        m.put("clip", qx1.class);
        m.put("drawImage", ux1.class);
        m.put("save", fy1.class);
        m.put("restore", dy1.class);
        m.put("setShadow", py1.class);
        m.put("setGlobalAlpha", jy1.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cz1(String str) {
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
                Class<? extends kx1> cls = m.get(optString);
                if (cls != null) {
                    kx1 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (ok1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<kx1> h() {
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

    @Override // com.baidu.tieba.bz1, com.baidu.tieba.uz1, com.baidu.tieba.du2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.isValid();
        }
        return invokeV.booleanValue;
    }
}
