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
/* loaded from: classes5.dex */
public final class ao0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a x;
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
    public String j;
    @JvmField
    public int k;
    @JvmField
    public String l;
    @JvmField
    public String m;
    @JvmField
    public String n;
    @JvmField
    public String o;
    @JvmField
    public String p;
    @JvmField
    public float q;
    @JvmField
    public float r;
    @JvmField
    public String s;
    @JvmField
    public int t;
    @JvmField
    public float u;
    @JvmField
    public int v;
    @JvmField
    public String w;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947621767, "Lcom/baidu/tieba/ao0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947621767, "Lcom/baidu/tieba/ao0;");
                return;
            }
        }
        x = new a(null);
    }

    /* loaded from: classes5.dex */
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
        public final ao0 a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                ao0 ao0Var = new ao0();
                Intrinsics.checkNotNullExpressionValue(jSONObject.optString("icon", ""), "json.optString(\"icon\", \"\")");
                String optString = jSONObject.optString("background_img", "");
                Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"background_img\", \"\")");
                ao0Var.a = optString;
                String optString2 = jSONObject.optString("component_img", "");
                Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"component_img\", \"\")");
                ao0Var.c = optString2;
                String optString3 = jSONObject.optString("lottie", "");
                Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"lottie\", \"\")");
                ao0Var.b = optString3;
                ao0Var.d = jSONObject.optInt("show_time", 3);
                ao0Var.e = jSONObject.optInt("display_time", 7);
                ao0Var.f = jSONObject.optInt("range_left", 90);
                ao0Var.g = jSONObject.optInt("range_right", 90);
                Intrinsics.checkNotNullExpressionValue(jSONObject.optString("left_event_cmd", ""), "json.optString(\"left_event_cmd\", \"\")");
                Intrinsics.checkNotNullExpressionValue(jSONObject.optString("right_event_cmd", ""), "json.optString(\"right_event_cmd\", \"\")");
                String optString4 = jSONObject.optString("click_event_cmd", "");
                Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(\"click_event_cmd\", \"\")");
                ao0Var.i = optString4;
                String optString5 = jSONObject.optString("webpanel_event_cmd", "");
                Intrinsics.checkNotNullExpressionValue(optString5, "json.optString(\"webpanel_event_cmd\", \"\")");
                ao0Var.j = optString5;
                ao0Var.h = (float) jSONObject.optDouble("z_limit", 0.5f);
                ao0Var.k = jSONObject.optInt("l_gravity", 48);
                String optString6 = jSONObject.optString(CriusAttrConstants.MARGIN, "0_0_0_0");
                Intrinsics.checkNotNullExpressionValue(optString6, "json.optString(\"margin\", DEFAULT_MARGINS)");
                ao0Var.l = optString6;
                String optString7 = jSONObject.optString("img_key_path", "");
                Intrinsics.checkNotNullExpressionValue(optString7, "json.optString(\"img_key_path\", \"\")");
                ao0Var.m = optString7;
                String optString8 = jSONObject.optString("lottie_show_mode", "");
                Intrinsics.checkNotNullExpressionValue(optString8, "json.optString(\"lottie_show_mode\", \"\")");
                ao0Var.n = optString8;
                String optString9 = jSONObject.optString("type", "");
                Intrinsics.checkNotNullExpressionValue(optString9, "json.optString(\"type\", \"\")");
                ao0Var.o = optString9;
                String optString10 = jSONObject.optString("bg_color", "");
                Intrinsics.checkNotNullExpressionValue(optString10, "json.optString(\"bg_color\", \"\")");
                ao0Var.p = optString10;
                ao0Var.q = (float) jSONObject.optDouble("wh_ratio", 1.0d);
                ao0Var.r = (float) jSONObject.optDouble("width_in_parent", 0.43d);
                String optString11 = jSONObject.optString("sensor_active_time", "3_10");
                Intrinsics.checkNotNullExpressionValue(optString11, "json.optString(\"sensor_active_time\", \"3_10\")");
                ao0Var.s = optString11;
                JSONObject optJSONObject = jSONObject.optJSONObject("shake_params");
                if (optJSONObject != null) {
                    ao0Var.t = optJSONObject.optInt("update_interval", 67);
                    ao0Var.u = (float) optJSONObject.optDouble("shake_sensitivity", 12.0d);
                    ao0Var.v = optJSONObject.optInt("shake_counts", 2);
                    String optString12 = jSONObject.optString("lottie_text", "");
                    Intrinsics.checkNotNullExpressionValue(optString12, "json.optString(\"lottie_text\", \"\")");
                    ao0Var.w = optString12;
                }
                return ao0Var;
            }
            return (ao0) invokeL.objValue;
        }
    }

    public ao0() {
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
        this.j = "";
        this.k = 48;
        this.l = "0_0_0_0";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = 1.0f;
        this.r = 0.43f;
        this.s = "3_10";
        this.t = 67;
        this.u = 12.0f;
        this.v = 2;
        this.w = "";
    }
}
