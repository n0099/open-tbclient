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
public class dz1 extends cz1 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends lx1>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<lx1> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947721742, "Lcom/baidu/tieba/dz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947721742, "Lcom/baidu/tieba/dz1;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", iy1.class);
        m.put("fillRect", xx1.class);
        m.put("setStrokeStyle", ry1.class);
        m.put("strokeStyle", yy1.class);
        m.put("setLineCap", ly1.class);
        m.put("setLineJoin", ny1.class);
        m.put("setLineWidth", oy1.class);
        m.put("setLineDash", my1.class);
        m.put("setMiterLimit", py1.class);
        m.put("strokeRect", xy1.class);
        m.put("moveTo", by1.class);
        m.put("lineTo", ay1.class);
        m.put("stroke", wy1.class);
        m.put("fill", wx1.class);
        m.put("beginPath", ox1.class);
        m.put("rect", dy1.class);
        m.put("clearRect", qx1.class);
        m.put("closePath", sx1.class);
        m.put("arc", nx1.class);
        m.put("bezierCurveTo", px1.class);
        m.put("quadraticCurveTo", cy1.class);
        m.put("scale", hy1.class);
        m.put("rotate", fy1.class);
        m.put("translate", bz1.class);
        m.put("transform", az1.class);
        m.put("setTransform", uy1.class);
        m.put("font", zx1.class);
        m.put("setFontSize", jy1.class);
        m.put("setTextAlign", sy1.class);
        m.put("setTextBaseline", ty1.class);
        m.put("fillText", yx1.class);
        m.put("strokeText", zy1.class);
        m.put("clip", rx1.class);
        m.put("drawImage", vx1.class);
        m.put("save", gy1.class);
        m.put("restore", ey1.class);
        m.put("setShadow", qy1.class);
        m.put("setGlobalAlpha", ky1.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dz1(String str) {
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
                Class<? extends lx1> cls = m.get(optString);
                if (cls != null) {
                    lx1 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (pk1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<lx1> h() {
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

    @Override // com.baidu.tieba.cz1, com.baidu.tieba.vz1, com.baidu.tieba.eu2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.isValid();
        }
        return invokeV.booleanValue;
    }
}
