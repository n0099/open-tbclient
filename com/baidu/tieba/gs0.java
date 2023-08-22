package com.baidu.tieba;

import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class gs0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a w;
    public transient /* synthetic */ FieldHolder $fh;
    @JvmField
    public String a;
    @JvmField
    public String b;
    @JvmField
    public String c;
    @JvmField
    public int d;
    @JvmField
    public int e;
    @JvmField
    public int f;
    @JvmField
    public int g;
    @JvmField
    public float h;
    @JvmField
    public String i;
    @JvmField
    public int j;
    @JvmField
    public String k;
    @JvmField
    public String l;
    @JvmField
    public String m;
    @JvmField
    public String n;
    @JvmField
    public String o;
    @JvmField
    public float p;
    @JvmField
    public float q;
    @JvmField
    public String r;
    @JvmField
    public int s;
    @JvmField
    public float t;
    @JvmField
    public int u;
    @JvmField
    public String v;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947804357, "Lcom/baidu/tieba/gs0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947804357, "Lcom/baidu/tieba/gs0;");
                return;
            }
        }
        w = new a(null);
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final gs0 a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                gs0 gs0Var = new gs0();
                Intrinsics.checkNotNullExpressionValue(jSONObject.optString("icon", ""), "json.optString(\"icon\", \"\")");
                String optString = jSONObject.optString("background_img", "");
                Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"background_img\", \"\")");
                gs0Var.a = optString;
                String optString2 = jSONObject.optString("component_img", "");
                Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"component_img\", \"\")");
                gs0Var.c = optString2;
                String optString3 = jSONObject.optString("lottie", "");
                Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"lottie\", \"\")");
                gs0Var.b = optString3;
                gs0Var.d = jSONObject.optInt("show_time", 3);
                gs0Var.e = jSONObject.optInt("display_time", 7);
                gs0Var.f = jSONObject.optInt("range_left", 90);
                gs0Var.g = jSONObject.optInt("range_right", 90);
                Intrinsics.checkNotNullExpressionValue(jSONObject.optString("left_event_cmd", ""), "json.optString(\"left_event_cmd\", \"\")");
                Intrinsics.checkNotNullExpressionValue(jSONObject.optString("right_event_cmd", ""), "json.optString(\"right_event_cmd\", \"\")");
                String optString4 = jSONObject.optString("click_event_cmd", "");
                Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(\"click_event_cmd\", \"\")");
                gs0Var.i = optString4;
                gs0Var.h = (float) jSONObject.optDouble("z_limit", 0.5f);
                gs0Var.j = jSONObject.optInt("l_gravity", 48);
                String optString5 = jSONObject.optString(CriusAttrConstants.MARGIN, "0_0_0_0");
                Intrinsics.checkNotNullExpressionValue(optString5, "json.optString(\"margin\", DEFAULT_MARGINS)");
                gs0Var.k = optString5;
                String optString6 = jSONObject.optString("img_key_path", "");
                Intrinsics.checkNotNullExpressionValue(optString6, "json.optString(\"img_key_path\", \"\")");
                gs0Var.l = optString6;
                String optString7 = jSONObject.optString("lottie_show_mode", "");
                Intrinsics.checkNotNullExpressionValue(optString7, "json.optString(\"lottie_show_mode\", \"\")");
                gs0Var.m = optString7;
                String optString8 = jSONObject.optString("type", "");
                Intrinsics.checkNotNullExpressionValue(optString8, "json.optString(\"type\", \"\")");
                gs0Var.n = optString8;
                String optString9 = jSONObject.optString("bg_color", "");
                Intrinsics.checkNotNullExpressionValue(optString9, "json.optString(\"bg_color\", \"\")");
                gs0Var.o = optString9;
                gs0Var.p = (float) jSONObject.optDouble("wh_ratio", 1.0d);
                gs0Var.q = (float) jSONObject.optDouble("width_in_parent", 0.43d);
                String optString10 = jSONObject.optString("sensor_active_time", "3_10");
                Intrinsics.checkNotNullExpressionValue(optString10, "json.optString(\"sensor_active_time\", \"3_10\")");
                gs0Var.r = optString10;
                JSONObject optJSONObject = jSONObject.optJSONObject("shake_params");
                if (optJSONObject != null) {
                    gs0Var.s = optJSONObject.optInt("update_interval", 67);
                    gs0Var.t = (float) optJSONObject.optDouble("shake_sensitivity", 12.0d);
                    gs0Var.u = optJSONObject.optInt("shake_counts", 2);
                    String optString11 = jSONObject.optString("lottie_text", "");
                    Intrinsics.checkNotNullExpressionValue(optString11, "json.optString(\"lottie_text\", \"\")");
                    gs0Var.v = optString11;
                }
                return gs0Var;
            }
            return (gs0) invokeL.objValue;
        }
    }

    public gs0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = 3;
        this.e = 7;
        this.f = 90;
        this.g = 90;
        this.h = 0.5f;
        this.i = "";
        this.j = 48;
        this.k = "0_0_0_0";
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = 1.0f;
        this.q = 0.43f;
        this.r = "3_10";
        this.s = 67;
        this.t = 12.0f;
        this.u = 2;
        this.v = "";
    }
}
