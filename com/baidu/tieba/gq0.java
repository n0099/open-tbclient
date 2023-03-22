package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class gq0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a i;
    public transient /* synthetic */ FieldHolder $fh;
    @JvmField
    public List<c> a;
    @JvmField
    public String b;
    @JvmField
    public b c;
    @JvmField
    public long d;
    @JvmField
    public long e;
    @JvmField
    public String f;
    @JvmField
    public String g;
    @JvmField
    public int h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947802435, "Lcom/baidu/tieba/gq0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947802435, "Lcom/baidu/tieba/gq0;");
                return;
            }
        }
        i = new a(null);
    }

    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final a b;
        public transient /* synthetic */ FieldHolder $fh;
        @JvmField
        public String a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-767620027, "Lcom/baidu/tieba/gq0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-767620027, "Lcom/baidu/tieba/gq0$b;");
                    return;
                }
            }
            b = new a(null);
        }

        /* loaded from: classes4.dex */
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
            public final b a(JSONObject jSONObject) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                    if (jSONObject == null) {
                        return null;
                    }
                    b bVar = new b();
                    String str = "立即下载";
                    String optString = jSONObject.optString("init_text", "立即下载");
                    if (optString != null) {
                        str = optString;
                    }
                    bVar.a = str;
                    return bVar;
                }
                return (b) invokeL.objValue;
            }
        }

        public b() {
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
        }
    }

    /* loaded from: classes4.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final a e;
        public transient /* synthetic */ FieldHolder $fh;
        @JvmField
        public String a;
        @JvmField
        public int[] b;
        @JvmField
        public String c;
        @JvmField
        public String d;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-767619996, "Lcom/baidu/tieba/gq0$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-767619996, "Lcom/baidu/tieba/gq0$c;");
                    return;
                }
            }
            e = new a(null);
        }

        /* loaded from: classes4.dex */
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
            public final c a(JSONObject jSONObject) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                    if (jSONObject == null) {
                        return null;
                    }
                    c cVar = new c();
                    String optString = jSONObject.optString("text", "");
                    if (optString == null) {
                        optString = "";
                    }
                    cVar.a = optString;
                    cVar.b = c.e.b(jSONObject.optString("highlight_range", ""), cVar.a);
                    String optString2 = jSONObject.optString(MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR, "");
                    Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"text_color\", \"\")");
                    cVar.c = optString2;
                    String optString3 = jSONObject.optString("highlight_color", "");
                    Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"highlight_color\", \"\")");
                    cVar.d = optString3;
                    return cVar;
                }
                return (c) invokeL.objValue;
            }

            @JvmStatic
            public final int[] b(String str, String str2) {
                InterceptResult invokeLL;
                boolean z;
                String str3;
                Integer intOrNull;
                Integer intOrNull2;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                    if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        return null;
                    }
                    List split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"_"}, false, 0, 6, (Object) null);
                    if (split$default.size() == 2 && (str3 = (String) CollectionsKt___CollectionsKt.getOrNull(split$default, 0)) != null && (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str3)) != null) {
                        int intValue = intOrNull.intValue();
                        String str4 = (String) CollectionsKt___CollectionsKt.getOrNull(split$default, 1);
                        if (str4 != null && (intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(str4)) != null) {
                            int intValue2 = intOrNull2.intValue();
                            if (intValue >= 0 && intValue2 <= str2.length() && intValue < intValue2) {
                                return new int[]{intValue, intValue2};
                            }
                        }
                    }
                    return null;
                }
                return (int[]) invokeLL.objValue;
            }
        }

        public c() {
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
            this.c = "";
            this.d = "";
        }
    }

    /* loaded from: classes4.dex */
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
        public final gq0 a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                gq0 gq0Var = new gq0();
                gq0Var.a = gq0.i.b(jSONObject.optJSONArray(PushConstants.SUB_TAGS_STATUS_LIST));
                String optString = jSONObject.optString("icon", "");
                Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"icon\", \"\")");
                gq0Var.b = optString;
                gq0Var.c = b.b.a(jSONObject.optJSONObject("download_text"));
                gq0Var.d = jSONObject.optLong("interval", 3000L);
                gq0Var.e = jSONObject.optLong("start_delay", 3000L);
                String optString2 = jSONObject.optString("background_color", "");
                Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"background_color\", \"\")");
                gq0Var.f = optString2;
                String optString3 = jSONObject.optString("cmd", "");
                Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"cmd\", \"\")");
                gq0Var.g = optString3;
                Intrinsics.checkNotNullExpressionValue(jSONObject.optString("type", ""), "json.optString(\"type\", \"\")");
                Intrinsics.checkNotNullExpressionValue(jSONObject.optString("style", ""), "json.optString(\"style\", \"\")");
                gq0Var.h = jSONObject.optInt("show_count", 0);
                jSONObject.optDouble("max_width", 0.6d);
                return gq0Var;
            }
            return (gq0) invokeL.objValue;
        }

        @JvmStatic
        public final List<c> b(JSONArray jSONArray) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray)) == null) {
                if (jSONArray != null && jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        c a = c.e.a(jSONArray.optJSONObject(i));
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                    return arrayList;
                }
                return new ArrayList();
            }
            return (List) invokeL.objValue;
        }
    }

    public gq0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.b = "";
        this.d = 3000L;
        this.e = 3000L;
        this.f = "";
        this.g = "";
    }
}
