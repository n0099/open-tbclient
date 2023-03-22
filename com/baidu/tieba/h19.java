package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.activity.AdWebVideoActivity;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h19 implements d19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<AdvertAppInfo> a;

    @Override // com.baidu.tieba.d19
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-797828132, "Lcom/baidu/tieba/h19$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-797828132, "Lcom/baidu/tieba/h19$a;");
                    return;
                }
            }
            int[] iArr = new int[IAdBaseAsyncController.Type.values().length];
            a = iArr;
            try {
                iArr[IAdBaseAsyncController.Type.PIC_PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[IAdBaseAsyncController.Type.VIDEO_FLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public h19() {
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

    @Override // com.baidu.tieba.d19
    public y09 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return n09.t();
        }
        return (y09) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d19
    public t09 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return vx5.l();
        }
        return (t09) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d19
    public List<AdvertAppInfo> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d19
    public a19 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return n09.t();
        }
        return (a19) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d19
    public tm<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, baseFragmentActivity, bdUniqueId)) == null) {
            if (baseFragmentActivity == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.z) {
                return new n19(baseFragmentActivity, bdUniqueId);
            }
            if (bdUniqueId != AdvertAppInfo.x) {
                return null;
            }
            return new m19(baseFragmentActivity, bdUniqueId);
        }
        return (tm) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.d19
    public tm<?, ?> d(c19 c19Var, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, c19Var, bdUniqueId)) == null) {
            if (c19Var == null || bdUniqueId == null) {
                return null;
            }
            if (bdUniqueId == AdvertAppInfo.w) {
                return new k19(c19Var, bdUniqueId);
            }
            return new l19(c19Var, bdUniqueId, null);
        }
        return (tm) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.d19
    @Nullable
    public IAdBaseAsyncController h(IAdBaseAsyncController.Type type, IAdBaseAsyncController.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, type, aVar)) == null) {
            int i = a.a[type.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return new z29(aVar);
            }
            return new p29(aVar);
        }
        return (IAdBaseAsyncController) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.d19
    public tm<?, ?> g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, tbPageContext, bdUniqueId, str)) == null) {
            if (bdUniqueId == AdvertAppInfo.y) {
                return new i19(tbPageContext, bdUniqueId, str);
            }
            if (bdUniqueId != null) {
                return new j19(tbPageContext, bdUniqueId, str);
            }
            return null;
        }
        return (tm) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.d19
    public void j(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, advertAppInfo) == null) {
            AdWebVideoActivity.g2(advertAppInfo, 0, "DETAIL");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v14 */
    @Override // com.baidu.tieba.d19
    public void k(@NonNull HashMap<String, String> hashMap, Context context) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, hashMap, context) == null) {
            Bundle bundle = new Bundle();
            JSONObject jSONObject4 = null;
            try {
                if (hashMap.get(WriteActivityConfig.VIDEO_INFO) != null) {
                    jSONObject = new JSONObject(hashMap.get(WriteActivityConfig.VIDEO_INFO));
                } else {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    bundle.putString("video_url", jSONObject.optString("video_url", ""));
                    bundle.putString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL, jSONObject.optString("poster_image", ""));
                    float floatValue = Float.valueOf(jSONObject.optString("video_aspect_ratio", "1")).floatValue();
                    bundle.putFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, floatValue);
                    if (floatValue < 1.0f) {
                        bundle.putInt(AdWebVideoActivityConfig.KEY_GOOD_STYLE, 14);
                    } else {
                        bundle.putInt(AdWebVideoActivityConfig.KEY_GOOD_STYLE, 7);
                    }
                    bundle.putInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, jSONObject.optInt("duration", 0));
                    bundle.putString(WebViewActivityConfig.TAG_AD_DEEPLINK_URL, jSONObject.optString("page_url", ""));
                    String str = hashMap.get("url");
                    try {
                        if (TextUtils.isEmpty(str)) {
                            str = jSONObject.optString("page_url", "");
                        }
                        if (jSONObject.get(AdWebVideoActivityConfig.KEY_TAIL_FRAME) != null) {
                            jSONObject2 = new JSONObject(jSONObject.optString(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
                        } else {
                            jSONObject2 = null;
                        }
                        if (hashMap.get("download") != null) {
                            jSONObject3 = new JSONObject(hashMap.get("download"));
                        } else {
                            jSONObject3 = null;
                        }
                        if (jSONObject3 != null) {
                            bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, jSONObject3.optString("key", ""));
                            jSONObject4 = new JSONObject();
                            jSONObject4.put("pkgname", jSONObject3.optString("key", ""));
                            jSONObject4.put("download_url", jSONObject3.optString("download_url", ""));
                        }
                        if (jSONObject2 != null) {
                            jSONObject2.put("style", TableDefine.DRColumns.COLUMN_JUMP_TO_RECENT);
                            jSONObject2.put("button_scheme", jSONObject2.optString("button_scheme", ""));
                            jSONObject2.put("scheme", jSONObject.optString("page_url", ""));
                            jSONObject2.put("ext_data", jSONObject4);
                            if (jSONObject3 != null) {
                                jSONObject2.put("pkgname", jSONObject3.optString("key", ""));
                                jSONObject2.put("style", "apk_download");
                            }
                        }
                        i29 i29Var = new i29();
                        i29Var.b(jSONObject2);
                        bundle.putString(AdWebVideoActivityConfig.KEY_TAIL_FRAME, i29Var.d());
                        jSONObject4 = str;
                    } catch (JSONException e) {
                        e = e;
                        jSONObject4 = str;
                        e.printStackTrace();
                        bundle.putString(WebViewActivityConfig.TAG_AD_EXT_INFO, hashMap.get("ext_info"));
                        AdWebVideoActivity.f2(new AdWebVideoActivityConfig(context, "", jSONObject4, true, true, true, bundle));
                    }
                }
            } catch (JSONException e2) {
                e = e2;
            }
            bundle.putString(WebViewActivityConfig.TAG_AD_EXT_INFO, hashMap.get("ext_info"));
            AdWebVideoActivity.f2(new AdWebVideoActivityConfig(context, "", jSONObject4, true, true, true, bundle));
        }
    }
}
