package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.view.InputDeviceCompat;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.swan.apps.publisher.PublishParams;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class i13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final List<String> b;
    public static final List<String> c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947800606, "Lcom/baidu/tieba/i13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947800606, "Lcom/baidu/tieba/i13;");
                return;
            }
        }
        a = pk1.a;
        b = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"title", "image", "emoji", "video", "friends", "target"});
        c = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"image", "emoji"});
    }

    public static final PublishParams a(JSONObject jSONObject) {
        InterceptResult invokeL;
        int i;
        float f;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("moduleList");
            ArrayList arrayList = new ArrayList(c);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                arrayList.clear();
                int length = optJSONArray.length();
                for (int i5 = 0; i5 < length; i5++) {
                    try {
                        String string = optJSONArray.getString(i5);
                        if (b.contains(string)) {
                            arrayList.add(string);
                        }
                    } catch (JSONException e) {
                        if (a) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            if (arrayList.isEmpty() && a) {
                Log.d("PublishParams", "展示列表为空");
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("imageConf");
            if (optJSONObject != null) {
                double d = 1.0f;
                i = Math.min(9, optJSONObject.optInt("maxNum", 9));
                f = (float) Math.min(d, jSONObject.optDouble(MapBundleKey.OfflineMapKey.OFFLINE_RATION, d));
            } else {
                i = 9;
                f = 1.0f;
            }
            Application context = mn2.c();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String b2 = b(context, jSONObject, "contentPlaceholder", R.string.obfuscated_res_0x7f0f133d);
            String e2 = e(b(context, jSONObject, "titlePlaceholder", R.string.obfuscated_res_0x7f0f133e), 20, null, 4, null);
            String e3 = e(b(context, jSONObject, "confirmText", R.string.obfuscated_res_0x7f0f133f), 4, null, 4, null);
            String e4 = e(b(context, jSONObject, "cancelText", R.string.obfuscated_res_0x7f0f0112), 4, null, 4, null);
            String e5 = e(b(context, jSONObject, "navBarTitleText", R.string.obfuscated_res_0x7f0f1340), 8, null, 4, null);
            String c2 = c(jSONObject, "navBarTextStyle", "");
            if (!CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"black", "white"}).contains(c2)) {
                c2 = "black";
            }
            int parseColor = Color.parseColor(c2);
            try {
                i2 = Color.parseColor(c(jSONObject, "navBarBackgroundColor", "#FFFFFF"));
            } catch (Exception e6) {
                if (a) {
                    e6.printStackTrace();
                }
                i2 = -1;
            }
            int color = context.getResources().getColor(R.color.obfuscated_res_0x7f060abe);
            try {
                i3 = Color.parseColor(c(jSONObject, "confirmColor", "#3388FF"));
            } catch (Exception e7) {
                if (a) {
                    e7.printStackTrace();
                }
                i3 = color;
            }
            try {
                i4 = Color.parseColor(c(jSONObject, "cancelColor", "#000000"));
            } catch (Exception e8) {
                if (a) {
                    e8.printStackTrace();
                }
                i4 = -16777216;
            }
            return new PublishParams(b2, e2, e5, parseColor, i2, e3, i3, e4, i4, jSONObject.optString("targetText", ""), jSONObject.optString("emojiPath", ""), jSONObject.optString("cb"), i, f, arrayList, null, null, 98304, null);
        }
        return (PublishParams) invokeL.objValue;
    }

    public static final String b(@NonNull Context context, @NonNull JSONObject obj, @NonNull String key, @StringRes int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65538, null, context, obj, key, i)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(obj, "obj");
            Intrinsics.checkNotNullParameter(key, "key");
            String optString = obj.optString(key);
            Intrinsics.checkNotNullExpressionValue(optString, "obj.optString(key)");
            if (StringsKt__StringsJVMKt.isBlank(optString)) {
                String string = context.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(defaultStrRes)");
                return string;
            }
            return optString;
        }
        return (String) invokeLLLI.objValue;
    }

    public static final String c(@NonNull JSONObject obj, @NonNull String key, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, obj, key, str)) == null) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(str, "default");
            String optString = obj.optString(key);
            Intrinsics.checkNotNullExpressionValue(optString, "obj.optString(key)");
            if (!StringsKt__StringsJVMKt.isBlank(optString)) {
                return optString;
            }
            return str;
        }
        return (String) invokeLLL.objValue;
    }

    public static final String d(String s, int i, String substitue) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, s, i, substitue)) == null) {
            Intrinsics.checkNotNullParameter(s, "s");
            Intrinsics.checkNotNullParameter(substitue, "substitue");
            if (s.length() <= i) {
                return s;
            }
            StringBuilder sb = new StringBuilder();
            String substring = s.substring(0, i - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append(substitue);
            return sb.toString();
        }
        return (String) invokeLIL.objValue;
    }

    public static /* synthetic */ String e(String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = StringHelper.STRING_MORE;
        }
        return d(str, i, str2);
    }
}
