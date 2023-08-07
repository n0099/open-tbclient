package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.messages.NetDiskFileMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.ripper.BaseAdRipper;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.ad.sdk.internal.api.utils.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class afb extends BaseAdRipper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public afb(Ssp.Pid pid) {
        super(pid);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Ssp.Pid) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final JSONObject d(Object obj) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            String[] strArr = {"com.bytedance.sdk.openadsdk.core.q.z", "com.bytedance.sdk.openadsdk.core.s.y", "com.bytedance.sdk.openadsdk.core.m.ng"};
            Object obj2 = null;
            for (int i = 0; i < 3 && (obj2 = ReflectionUtils.findField(strArr[i], obj)) == null; i++) {
            }
            String[] strArr2 = {"bO", "zp"};
            JSONObject jSONObject2 = null;
            for (int i2 = 0; i2 < 2; i2++) {
                try {
                    jSONObject = (JSONObject) ReflectionUtils.invoke(obj2, strArr2[i2], null, new Object[0]);
                    jSONObject2 = jSONObject;
                } catch (Exception unused) {
                    LogPrinter.d("parse method error", new Object[0]);
                }
                if (jSONObject != null) {
                    break;
                }
            }
            return jSONObject2;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final Object e(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            try {
                Field declaredField = obj.getClass().getSuperclass().getDeclaredField("h");
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                Field declaredField2 = obj2.getClass().getDeclaredField("a");
                declaredField2.setAccessible(true);
                return declaredField2.get(obj2);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006d, code lost:
        r1 = null;
     */
    @Override // com.fun.ad.sdk.internal.api.ripper.BaseAdRipper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RippedAd getRippedAdInternal(Object obj) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String optString;
        String str6;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            try {
                Object obj2 = ((qfb) obj).a;
                if (obj2.getClass().getName().contains("Proxy") && (obj2 = e(obj2)) == null) {
                    return null;
                }
                String a = mgb.a(obj2);
                if (TextUtils.isEmpty(a)) {
                    jSONObject2 = d(obj2);
                } else {
                    LinkedList linkedList = new LinkedList(Arrays.asList(a.split("\\+")));
                    Object obj3 = obj2;
                    while (true) {
                        String str7 = (String) linkedList.pollFirst();
                        if (str7 == null) {
                            break;
                        } else if (!str7.equals("super")) {
                            if (str7.startsWith("*")) {
                                jSONObject = (JSONObject) ReflectionUtils.invoke(obj3, str7.substring(1), null, new Object[0]);
                                break;
                            }
                            obj3 = ReflectionUtils.findField(str7, obj3);
                            if (obj3 == null) {
                                break;
                            }
                        }
                    }
                    if (jSONObject == null) {
                        new Thread(new lgb(obj2)).start();
                        return null;
                    }
                    jSONObject2 = jSONObject;
                }
                if (jSONObject2 == null) {
                    return null;
                }
                JSONObject optJSONObject3 = jSONObject2.optJSONObject("icon");
                if (optJSONObject3 != null) {
                    str = optJSONObject3.optString("url");
                } else {
                    str = null;
                }
                String combineStrWithComma = RippedAd.combineStrWithComma(jSONObject2.optJSONArray("image"), new RippedAd.Acceptor() { // from class: com.baidu.tieba.web
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.fun.ad.sdk.internal.api.ripper.RippedAd.Acceptor
                    public final String accept(Object obj4) {
                        InterceptResult invokeL2;
                        String optString2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, obj4)) == null) {
                            optString2 = ((JSONObject) obj4).optString("url");
                            return optString2;
                        }
                        return (String) invokeL2.objValue;
                    }
                });
                JSONObject optJSONObject4 = jSONObject2.optJSONObject("video");
                if (optJSONObject4 != null) {
                    str3 = optJSONObject4.optString("video_url");
                    str2 = optJSONObject4.optString(NetDiskFileMsg.NetDiskFile.JSON_KEY_COVER_URL);
                } else {
                    str2 = null;
                    str3 = null;
                }
                int optInt = jSONObject2.optInt("interaction_type", -1);
                if (optInt != 3) {
                    if (optInt == 4 && (optJSONObject2 = jSONObject2.optJSONObject("app")) != null) {
                        String optString2 = optJSONObject2.optString("app_name");
                        String optString3 = optJSONObject2.optString("package_name");
                        str6 = optJSONObject2.optString("download_url");
                        str5 = optString3;
                        str4 = optString2;
                        optString = null;
                    }
                    str6 = null;
                    optString = null;
                    str4 = null;
                    str5 = null;
                } else {
                    JSONObject optJSONObject5 = jSONObject2.optJSONObject("deep_link");
                    if (optJSONObject5 != null) {
                        str4 = null;
                        str5 = null;
                        optString = optJSONObject5.optString("deeplink_url");
                        str6 = null;
                    }
                    str6 = null;
                    optString = null;
                    str4 = null;
                    str5 = null;
                }
                if (str4 == null && (optJSONObject = jSONObject2.optJSONObject("app_manage")) != null) {
                    str4 = optJSONObject.optString("app_name");
                    str5 = optJSONObject.optString("package_name");
                }
                RippedAd.Builder builder = new RippedAd.Builder();
                builder.setCorporation(jSONObject2.optString("source")).setTitle(jSONObject2.optString("title")).setDescription(jSONObject2.optString("description")).setAppName(str4).setAppPkg(str5).setAppUrl(str6).setIconUrl(str).setImageUrl(combineStrWithComma).setVideoImageUrl(str2).setVideoUrl(str3).setClickUrl(jSONObject2.optString("target_url")).setDeepLinkUrl(optString).setConvUrl(null);
                return builder.build();
            } catch (Error | Exception e) {
                LogPrinter.e(e);
                return null;
            }
        }
        return (RippedAd) invokeL.objValue;
    }
}
