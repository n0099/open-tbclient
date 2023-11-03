package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.cyberplayer.sdk.task.UpgradeInfo;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
@JvmName(name = "H5ShowDialogHelper")
/* loaded from: classes5.dex */
public final class eu4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final TBAlertConfig.OperateBtnStyle a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            switch (str.hashCode()) {
                case -817598092:
                    if (str.equals("secondary")) {
                        return TBAlertConfig.OperateBtnStyle.SECONDARY;
                    }
                    break;
                case 3343801:
                    if (str.equals("main")) {
                        return TBAlertConfig.OperateBtnStyle.MAIN;
                    }
                    break;
                case 92899676:
                    if (str.equals("alert")) {
                        return TBAlertConfig.OperateBtnStyle.ALERT;
                    }
                    break;
                case 97618667:
                    if (str.equals(UpgradeInfo.KEY_INT_FORCE_UPGRADE)) {
                        return TBAlertConfig.OperateBtnStyle.FORCE;
                    }
                    break;
            }
            return TBAlertConfig.OperateBtnStyle.SECONDARY;
        }
        return (TBAlertConfig.OperateBtnStyle) invokeL.objValue;
    }

    public static final TBAlertConfig.OperateBtnConfig b(final String str, String str2, String str3, final String str4, final WebView webView) {
        InterceptResult invokeLLLLL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, null, str, str2, str3, str4, webView)) == null) {
            boolean z3 = true;
            if (str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (str2.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    if (str3.length() != 0) {
                        z3 = false;
                    }
                    if (!z3) {
                        return new TBAlertConfig.OperateBtnConfig(str2, a(str3), new View.OnClickListener() { // from class: com.baidu.tieba.bu4
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                    eu4.c(str4, str, webView, view2);
                                }
                            }
                        });
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return (TBAlertConfig.OperateBtnConfig) invokeLLLLL.objValue;
    }

    public static final void c(String str, String id, WebView webView, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, str, id, webView, view2) == null) {
            Intrinsics.checkNotNullParameter(id, "$id");
            Intrinsics.checkNotNullParameter(webView, "$webView");
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("resultCode", 1);
            if (str == null) {
                str = "";
            }
            hashMap.put("dialogId", str);
            hashMap.put("btnId", id);
            dj6.a().d(webView, "showDialog", hashMap);
        }
    }

    public static final boolean d(Activity activity, final WebView webView, int i, String str, final String str2) {
        InterceptResult invokeCommon;
        JSONObject a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{activity, webView, Integer.valueOf(i), str, str2})) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(webView, "webView");
            if (i == 1 && (a = bn6.a.a(str)) != null) {
                String optString = a.optString("title");
                String optString2 = a.optString("desc");
                JSONArray optJSONArray = a.optJSONArray("btn");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        Object opt = optJSONArray.opt(i2);
                        if (opt instanceof JSONObject) {
                            JSONObject jSONObject = (JSONObject) opt;
                            String id = jSONObject.optString("id");
                            String text = jSONObject.optString("text");
                            String style = jSONObject.optString("style");
                            Intrinsics.checkNotNullExpressionValue(id, "id");
                            Intrinsics.checkNotNullExpressionValue(text, "text");
                            Intrinsics.checkNotNullExpressionValue(style, "style");
                            TBAlertConfig.OperateBtnConfig b = b(id, text, style, str2, webView);
                            if (b != null) {
                                arrayList.add(b);
                            }
                        }
                    }
                }
                int size = arrayList.size();
                if (size < 1) {
                    return false;
                }
                if (size > 3) {
                    size = 3;
                }
                TBAlertConfig.OperateBtnConfig[] operateBtnConfigArr = new TBAlertConfig.OperateBtnConfig[size];
                for (int i3 = 0; i3 < size; i3++) {
                    operateBtnConfigArr[i3] = (TBAlertConfig.OperateBtnConfig) arrayList.get(i3);
                }
                new TBAlertBuilder(activity).setTitleStr(optString).setDescStr(optString2).setCancelable(true).setAutoClose().setOperateBtn((TBAlertConfig.OperateBtnConfig[]) Arrays.copyOf(operateBtnConfigArr, size)).show().setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.au4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                            eu4.e(str2, webView, dialogInterface);
                        }
                    }
                });
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static final void e(String str, WebView webView, DialogInterface dialogInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, webView, dialogInterface) == null) {
            Intrinsics.checkNotNullParameter(webView, "$webView");
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("resultCode", 2);
            if (str == null) {
                str = "";
            }
            hashMap.put("dialogId", str);
            dj6.a().d(webView, "showDialog", hashMap);
        }
    }
}
