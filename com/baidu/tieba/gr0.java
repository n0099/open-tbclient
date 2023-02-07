package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class gr0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a d;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    @JvmField
    public String c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947803396, "Lcom/baidu/tieba/gr0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947803396, "Lcom/baidu/tieba/gr0;");
                return;
            }
        }
        d = new a(null);
    }

    @JvmStatic
    public static final gr0 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) ? d.a(jSONObject) : (gr0) invokeL.objValue;
    }

    @JvmStatic
    public static final gr0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? d.b() : (gr0) invokeV.objValue;
    }

    @JvmStatic
    public static final JSONObject e(gr0 gr0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, gr0Var)) == null) ? d.c(gr0Var) : (JSONObject) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof gr0) {
                    gr0 gr0Var = (gr0) obj;
                    return Intrinsics.areEqual(this.a, gr0Var.a) && Intrinsics.areEqual(this.b, gr0Var.b) && Intrinsics.areEqual(this.c, gr0Var.c);
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String str = this.a;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.c;
            return hashCode2 + (str3 != null ? str3.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "ExtPolicy(invokeTaskId=" + this.a + ", backCmd=" + this.b + ", sdkSwitch=" + this.c + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
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

        @JvmStatic
        public final gr0 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new gr0("", "", "0");
            }
            return (gr0) invokeV.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final gr0 a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
                if (jSONObject != null) {
                    String optString = jSONObject.optString("invoke_task_id");
                    Intrinsics.checkNotNullExpressionValue(optString, "optString(\"invoke_task_id\")");
                    String optString2 = jSONObject.optString("back_cmd");
                    Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"back_cmd\")");
                    String optString3 = jSONObject.optString("sdk_switch", "0");
                    Intrinsics.checkNotNullExpressionValue(optString3, "optString(\"sdk_switch\", \"0\")");
                    return new gr0(optString, optString2, optString3);
                }
                return null;
            }
            return (gr0) invokeL.objValue;
        }

        @JvmStatic
        public final JSONObject c(gr0 gr0Var) {
            InterceptResult invokeL;
            String c;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gr0Var)) == null) {
                JSONObject jSONObject = new JSONObject();
                String str2 = null;
                if (gr0Var != null) {
                    try {
                        c = gr0Var.c();
                    } catch (JSONException unused) {
                    }
                } else {
                    c = null;
                }
                JSONObject put = jSONObject.put("invoke_task_id", c);
                if (gr0Var != null) {
                    str = gr0Var.b();
                } else {
                    str = null;
                }
                JSONObject put2 = put.put("back_cmd", str);
                if (gr0Var != null) {
                    str2 = gr0Var.c;
                }
                put2.put("sdk_switch", str2);
                return jSONObject;
            }
            return (JSONObject) invokeL.objValue;
        }
    }

    public gr0(String invokeTaskId, String backCmd, String sdkSwitch) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {invokeTaskId, backCmd, sdkSwitch};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(invokeTaskId, "invokeTaskId");
        Intrinsics.checkNotNullParameter(backCmd, "backCmd");
        Intrinsics.checkNotNullParameter(sdkSwitch, "sdkSwitch");
        this.a = invokeTaskId;
        this.b = backCmd;
        this.c = sdkSwitch;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }
}
