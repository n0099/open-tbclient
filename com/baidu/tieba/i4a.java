package com.baidu.tieba;

import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yy.gslbsdk.db.DelayTB;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public List<a> b;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public long b;
        public long c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                this.a = jSONObject.optInt("style");
                long optLong = jSONObject.optLong(DelayTB.DELAY);
                this.b = optLong;
                if (optLong < 0) {
                    this.b = 0L;
                }
                this.c = jSONObject.optLong("duration");
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    public i4a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static i4a a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            i4a i4aVar = new i4a();
            i4aVar.a = jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR);
            JSONArray optJSONArray = jSONObject.optJSONArray(AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
            i4aVar.b = new ArrayList();
            for (int i = 0; optJSONArray != null && i < optJSONArray.length(); i++) {
                List<a> list = i4aVar.b;
                a aVar = new a();
                aVar.a(optJSONArray.optJSONObject(i));
                list.add(aVar);
            }
            return i4aVar;
        }
        return (i4a) invokeL.objValue;
    }
}
