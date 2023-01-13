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
/* loaded from: classes4.dex */
public class hz1 extends gz1 {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Class<? extends px1>> m;
    public transient /* synthetic */ FieldHolder $fh;
    public List<px1> k;
    public boolean l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947840906, "Lcom/baidu/tieba/hz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947840906, "Lcom/baidu/tieba/hz1;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        m = hashMap;
        hashMap.put("setFillStyle", my1.class);
        m.put("fillRect", by1.class);
        m.put("setStrokeStyle", vy1.class);
        m.put("strokeStyle", cz1.class);
        m.put("setLineCap", py1.class);
        m.put("setLineJoin", ry1.class);
        m.put("setLineWidth", sy1.class);
        m.put("setLineDash", qy1.class);
        m.put("setMiterLimit", ty1.class);
        m.put("strokeRect", bz1.class);
        m.put("moveTo", fy1.class);
        m.put("lineTo", ey1.class);
        m.put("stroke", az1.class);
        m.put("fill", ay1.class);
        m.put("beginPath", sx1.class);
        m.put("rect", hy1.class);
        m.put("clearRect", ux1.class);
        m.put("closePath", wx1.class);
        m.put("arc", rx1.class);
        m.put("bezierCurveTo", tx1.class);
        m.put("quadraticCurveTo", gy1.class);
        m.put("scale", ly1.class);
        m.put("rotate", jy1.class);
        m.put("translate", fz1.class);
        m.put("transform", ez1.class);
        m.put("setTransform", yy1.class);
        m.put("font", dy1.class);
        m.put("setFontSize", ny1.class);
        m.put("setTextAlign", wy1.class);
        m.put("setTextBaseline", xy1.class);
        m.put("fillText", cy1.class);
        m.put("strokeText", dz1.class);
        m.put("clip", vx1.class);
        m.put("drawImage", zx1.class);
        m.put("save", ky1.class);
        m.put("restore", iy1.class);
        m.put("setShadow", uy1.class);
        m.put("setGlobalAlpha", oy1.class);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hz1(String str) {
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
                Class<? extends px1> cls = m.get(optString);
                if (cls != null) {
                    px1 newInstance = cls.newInstance();
                    newInstance.b(optJSONArray);
                    this.k.add(newInstance);
                }
            }
            this.l = jSONObject.optInt("reserve") != 0;
        } catch (Exception e) {
            if (tk1.a) {
                e.printStackTrace();
            }
        }
    }

    public List<px1> h() {
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

    @Override // com.baidu.tieba.gz1, com.baidu.tieba.zz1, com.baidu.tieba.iu2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return super.isValid();
        }
        return invokeV.booleanValue;
    }
}
