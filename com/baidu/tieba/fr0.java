package com.baidu.tieba;

import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import com.baidu.nadcore.model.MonitorUrl;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fr0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a v;
    public transient /* synthetic */ FieldHolder $fh;
    @JvmField
    public int a;
    @JvmField
    public String b;
    @JvmField
    public String c;
    @JvmField
    public boolean d;
    @JvmField
    public boolean e;
    @JvmField
    public boolean f;
    @JvmField
    public boolean g;
    @JvmField
    public List<MonitorUrl> h;
    @JvmField
    public String i;
    @JvmField
    public String j;
    @JvmField
    public String k;
    @JvmField
    public String l;
    @JvmField
    public String m;
    @JvmField
    public String n;
    @JvmField
    public List<ir0> o;
    @JvmField
    public br0 p;
    @JvmField
    public er0 q;
    @JvmField
    public String r;
    @JvmField
    public wr0 s;
    @JvmField
    public String t;
    @JvmField
    public boolean u;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947773605, "Lcom/baidu/tieba/fr0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947773605, "Lcom/baidu/tieba/fr0;");
                return;
            }
        }
        v = new a(null);
    }

    @JvmStatic
    public static final fr0 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) ? v.a(jSONObject) : (fr0) invokeL.objValue;
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

        /* JADX WARN: Code restructure failed: missing block: B:40:0x00ec, code lost:
            if (r0.equals(com.baidu.searchbox.net.listener.DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST) != false) goto L36;
         */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0123  */
        @JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final fr0 a(JSONObject jSONObject) {
            InterceptResult invokeL;
            boolean z;
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("convert");
                if (optJSONObject2 == null) {
                    optJSONObject2 = e31.c(jSONObject.optString("convert"));
                }
                if (optJSONObject2 == null) {
                    return null;
                }
                fr0 fr0Var = new fr0();
                fr0Var.b = optJSONObject2.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
                fr0Var.c = optJSONObject2.optString("button_icon");
                fr0Var.i = optJSONObject2.optString("download_button_start_color");
                fr0Var.j = optJSONObject2.optString("download_button_end_color");
                fr0Var.k = optJSONObject2.optString("invoke_button_start_color");
                fr0Var.l = optJSONObject2.optString("invoke_button_end_color");
                fr0Var.m = optJSONObject2.optString("invoke_button_icon");
                fr0Var.n = optJSONObject2.optString("invoke_button_text");
                String optString = optJSONObject2.optString("button_text_color");
                Intrinsics.checkNotNullExpressionValue(optString, "it.optString(\"button_text_color\")");
                int i = 1;
                if (optString.length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    optJSONObject2.optString("button_text_color");
                } else {
                    optJSONObject2.optString("textColor");
                }
                optJSONObject2.optInt("buttonShineType");
                fr0Var.r = optJSONObject2.optString("background_color");
                fr0Var.t = optJSONObject2.optString("button_scheme");
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = optJSONObject2.optJSONArray(AnimatedStateListDrawableCompat.ELEMENT_TRANSITION);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        ir0 a = ir0.d.a(optJSONArray.optJSONObject(i2));
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
                fr0Var.o = arrayList;
                String optString2 = optJSONObject2.optString("type");
                if (optString2 != null) {
                    int hashCode = optString2.hashCode();
                    if (hashCode != -1335224239) {
                        if (hashCode != -1183693704) {
                            if (hashCode == 1427818632 && optString2.equals("download")) {
                                i = 2;
                            }
                        }
                        fr0Var.a = i;
                        fr0Var.p = br0.c(optJSONObject2.optJSONObject("download"));
                        er0 er0Var = new er0();
                        er0Var.d = optJSONObject2.optString("ext");
                        er0Var.a = optJSONObject2.optString(BdVideoAd.AD_VIDEO_DAPAGE);
                        Unit unit2 = Unit.INSTANCE;
                        fr0Var.q = er0Var;
                        optJSONObject = optJSONObject2.optJSONObject("app_info");
                        if (optJSONObject != null) {
                            wr0 d = wr0.d(optJSONObject);
                            fr0Var.s = d;
                            if (d != null) {
                                d.m = optJSONObject2.optString("ext");
                            }
                        }
                        return fr0Var;
                    }
                    optString2.equals("detail");
                }
                i = 0;
                fr0Var.a = i;
                fr0Var.p = br0.c(optJSONObject2.optJSONObject("download"));
                er0 er0Var2 = new er0();
                er0Var2.d = optJSONObject2.optString("ext");
                er0Var2.a = optJSONObject2.optString(BdVideoAd.AD_VIDEO_DAPAGE);
                Unit unit22 = Unit.INSTANCE;
                fr0Var.q = er0Var2;
                optJSONObject = optJSONObject2.optJSONObject("app_info");
                if (optJSONObject != null) {
                }
                return fr0Var;
            }
            return (fr0) invokeL.objValue;
        }
    }

    public fr0() {
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
        this.a = 1;
        this.h = new ArrayList();
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a != 2 || this.p != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
