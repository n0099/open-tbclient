package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLDecoder;
import java.net.URLEncoder;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class ga0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947787059, "Lcom/baidu/tieba/ga0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947787059, "Lcom/baidu/tieba/ga0;");
        }
    }

    @JvmStatic
    public static final String a(LiveRoomEntity liveRoomEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, liveRoomEntity)) == null) {
            String str = "";
            String str2 = (liveRoomEntity == null || (str2 = liveRoomEntity.cmd) == null) ? "" : "";
            if (TextUtils.isEmpty(liveRoomEntity != null ? liveRoomEntity.beginTime : null)) {
                return str2;
            }
            String b = new ka0(str2).b("params");
            if (b == null || b.length() == 0) {
                return str2;
            }
            try {
                JSONObject jSONObject = new JSONObject(URLDecoder.decode(b, "UTF-8"));
                JSONObject optJSONObject = jSONObject.optJSONObject("extLog");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put("live_union_id", liveRoomEntity != null ? liveRoomEntity.beginTime : null);
                optJSONObject.put("auto_play", "1");
                jSONObject.put("extLog", optJSONObject);
                String removedUrl = da0.j(str2, "params");
                Intrinsics.checkExpressionValueIsNotNull(removedUrl, "removedUrl");
                int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) removedUrl, "?", 0, false, 6, (Object) null);
                if (removedUrl != null) {
                    String substring = removedUrl.substring(0, indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (StringsKt__StringsKt.indexOf$default((CharSequence) removedUrl, "?", 0, false, 6, (Object) null) + 1 < removedUrl.length()) {
                        str = removedUrl.substring(StringsKt__StringsKt.indexOf$default((CharSequence) removedUrl, "?", 0, false, 6, (Object) null) + 1, removedUrl.length());
                        Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                    String encode = URLEncoder.encode(jSONObject.toString());
                    StringBuilder sb = new StringBuilder();
                    sb.append(substring);
                    sb.append("?params=" + encode);
                    if (str.length() > 0) {
                        sb.append(str);
                    }
                    String sb2 = sb.toString();
                    Intrinsics.checkExpressionValueIsNotNull(sb2, "newScheme.toString()");
                    return sb2;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            } catch (Throwable th) {
                th.printStackTrace();
                return str2;
            }
        }
        return (String) invokeL.objValue;
    }
}
