package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class eh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(HashMap<String, Object> hashMap, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, hashMap, str, str2) == null) && hashMap != null && str != null && str2 != null) {
            hashMap.put(str, str2);
        }
    }

    public static void b(StringBuilder sb, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{sb, str, str2, Boolean.valueOf(z)}) == null) && sb != null && !TextUtils.isEmpty(str)) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "";
                }
                sb.append("&");
                sb.append(str);
                sb.append("=");
                if (z) {
                    str2 = URLEncoder.encode(str2, "utf-8");
                }
                sb.append(str2);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public static String c(ng ngVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ngVar)) == null) {
            if (ngVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(ngVar.a, "utf-8"));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(ngVar.b, "utf-8"));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(ngVar.c, "utf-8"));
                sb.append("&");
                sb.append("os");
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append(HttpConstants.OS_VERSION);
                sb.append("=");
                sb.append(URLEncoder.encode(ngVar.q, "utf-8"));
                if (!TextUtils.isEmpty(ngVar.d)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ngVar.d, "utf-8"));
                }
                if (!TextUtils.isEmpty(ngVar.e)) {
                    sb.append("&");
                    sb.append("cfrom");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ngVar.e, "utf-8"));
                }
                sb.append("&");
                sb.append("phone");
                sb.append("=");
                sb.append(URLEncoder.encode(ngVar.k, "utf-8"));
                if (!TextUtils.isEmpty(ngVar.l)) {
                    sb.append("&");
                    sb.append("uid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ngVar.l, "utf-8"));
                }
                if (!TextUtils.isEmpty(ngVar.f)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ngVar.f, "utf-8"));
                }
                if (!TextUtils.isEmpty(ngVar.i)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ngVar.i, "utf-8"));
                }
                if (!TextUtils.isEmpty(ngVar.m)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ngVar.m, "utf-8"));
                }
                if (!TextUtils.isEmpty(ngVar.g)) {
                    sb.append("&");
                    sb.append("cuid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ngVar.g, "utf-8"));
                }
                if (!TextUtils.isEmpty(ngVar.h)) {
                    sb.append("&");
                    sb.append("cuid_galaxy2");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ngVar.h, "utf-8"));
                }
                sb.append("&");
                sb.append("net");
                sb.append("=");
                sb.append(URLEncoder.encode(ngVar.o, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(boolean z, ng ngVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65539, null, z, ngVar)) == null) {
            if (ngVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_client_type=2");
            b(sb, "_client_version", ngVar.c, z);
            b(sb, HttpRequest.PHONE_IMEI, ngVar.i, z);
            b(sb, HttpRequest.CLIENT_ID, ngVar.f, z);
            b(sb, HttpRequest.SUBAPP_TYPE, ngVar.j, z);
            b(sb, HttpConstants.OS_VERSION, ngVar.q, z);
            b(sb, "from", ngVar.d, z);
            b(sb, "cfrom", ngVar.e, z);
            b(sb, "net_type", ngVar.p, z);
            b(sb, "cuid", ngVar.g, z);
            b(sb, "model", ngVar.k, z);
            if (TextUtils.isEmpty(ngVar.l)) {
                b(sb, "uid", "0", z);
            } else {
                b(sb, "uid", ngVar.l, z);
            }
            b(sb, "un", ngVar.m, z);
            b(sb, "utbrand", ngVar.w, z);
            b(sb, "cuid_galaxy2", ngVar.h, z);
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public static String e(tg tgVar, ng ngVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, tgVar, ngVar)) == null) {
            if (tgVar.p() != null && (tgVar.p().equals("omp") || tgVar.p().equals("mon"))) {
                return c(ngVar);
            }
            return d(true, ngVar);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Object> f(String str, ng ngVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, ngVar, z)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            a(hashMap, HttpRequest.CLIENT_TYPE, "2");
            a(hashMap, "_client_version", ngVar.c);
            a(hashMap, HttpRequest.CLIENT_ID, ngVar.f);
            a(hashMap, HttpRequest.SUBAPP_TYPE, ngVar.j);
            a(hashMap, "from", ngVar.d);
            a(hashMap, "net_type", ngVar.p);
            a(hashMap, "cuid", ngVar.g);
            a(hashMap, "cuid_galaxy2", ngVar.h);
            if (TextUtils.isEmpty(ngVar.l)) {
                ngVar.l = "0";
            }
            a(hashMap, "uid", ngVar.l);
            a(hashMap, "un", ngVar.m);
            a(hashMap, HttpRequest.BDUSS, ngVar.n);
            if (z) {
                a(hashMap, "find_bug", "2");
            } else {
                a(hashMap, "find_bug", "0");
            }
            a(hashMap, "sz", ngVar.r);
            a(hashMap, BaiduIdentityManager.PARAM_CUA, ngVar.s);
            a(hashMap, TiebaStatic.Params.BDID, ngVar.z);
            a(hashMap, "cookie", ngVar.n);
            a(hashMap, "utbrand", ngVar.w);
            a(hashMap, "baiduapppb_ut", ngVar.x);
            a(hashMap, HttpRequest.USER_AGENT, ngVar.y);
            a(hashMap, "active_timestamp", ngVar.A);
            a(hashMap, "first_install_time", ngVar.B);
            a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, ngVar.C);
            a(hashMap, "event_day", ngVar.D);
            if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, "isKeepOriginalLogic").getData()).booleanValue()) {
                a(hashMap, "model", ngVar.k);
                a(hashMap, "oaid", ngVar.t);
                if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, str).getData()).booleanValue()) {
                    a(hashMap, "isKeepOriginalLogic", YYOption.IsLive.VALUE_TRUE);
                    MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
                } else {
                    a(hashMap, HttpRequest.ANDROID_ID, ngVar.v);
                    a(hashMap, HttpRequest.PHONE_IMEI, ngVar.i);
                }
            } else {
                MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
            }
            if (((Boolean) MessageManager.getInstance().runTask(2000983, Boolean.class, "isKeepOriginalLogic").getData()).booleanValue()) {
                if (((Boolean) MessageManager.getInstance().runTask(2000983, Boolean.class, str).getData()).booleanValue()) {
                    a(hashMap, "isKeepOriginalLogic", YYOption.IsLive.VALUE_TRUE);
                    MessageManager.getInstance().runTask(2000982, HashMap.class, hashMap);
                } else {
                    a(hashMap, "mac", ngVar.u);
                }
            } else {
                MessageManager.getInstance().runTask(2000982, HashMap.class, hashMap);
            }
            return hashMap;
        }
        return (HashMap) invokeLLZ.objValue;
    }
}
