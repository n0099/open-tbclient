package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class gi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(HashMap<String, Object> hashMap, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, hashMap, str, str2) == null) || hashMap == null || str == null || str2 == null) {
            return;
        }
        hashMap.put(str, str2);
    }

    public static void b(StringBuilder sb, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{sb, str, str2, Boolean.valueOf(z)}) == null) || sb == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            sb.append("&");
            sb.append(str);
            sb.append("=");
            if (z) {
                str2 = URLEncoder.encode(str2, IMAudioTransRequest.CHARSET);
            }
            sb.append(str2);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public static String c(oh ohVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ohVar)) == null) {
            if (ohVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(ohVar.a, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(ohVar.b, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(ohVar.c, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("os");
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append(HttpConstants.OS_VERSION);
                sb.append("=");
                sb.append(URLEncoder.encode(ohVar.q, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(ohVar.d)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ohVar.d, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ohVar.e)) {
                    sb.append("&");
                    sb.append("cfrom");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ohVar.e, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("phone");
                sb.append("=");
                sb.append(URLEncoder.encode(ohVar.k, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(ohVar.l)) {
                    sb.append("&");
                    sb.append("uid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ohVar.l, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ohVar.f)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ohVar.f, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ohVar.i)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ohVar.i, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ohVar.m)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ohVar.m, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ohVar.g)) {
                    sb.append("&");
                    sb.append("cuid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ohVar.g, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ohVar.h)) {
                    sb.append("&");
                    sb.append("cuid_galaxy2");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ohVar.h, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("net");
                sb.append("=");
                sb.append(URLEncoder.encode(ohVar.o, IMAudioTransRequest.CHARSET));
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(boolean z, oh ohVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65539, null, z, ohVar)) == null) {
            if (ohVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_client_type=2");
            b(sb, "_client_version", ohVar.c, z);
            b(sb, HttpRequest.PHONE_IMEI, ohVar.i, z);
            b(sb, HttpRequest.CLIENT_ID, ohVar.f, z);
            b(sb, HttpRequest.SUBAPP_TYPE, ohVar.j, z);
            b(sb, HttpConstants.OS_VERSION, ohVar.q, z);
            b(sb, "from", ohVar.d, z);
            b(sb, "cfrom", ohVar.e, z);
            b(sb, "net_type", ohVar.p, z);
            b(sb, "cuid", ohVar.g, z);
            b(sb, "model", ohVar.k, z);
            if (TextUtils.isEmpty(ohVar.l)) {
                b(sb, "uid", "0", z);
            } else {
                b(sb, "uid", ohVar.l, z);
            }
            b(sb, "un", ohVar.m, z);
            b(sb, "utbrand", ohVar.w, z);
            b(sb, "cuid_galaxy2", ohVar.h, z);
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public static String e(uh uhVar, oh ohVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, uhVar, ohVar)) == null) {
            if (uhVar.p() != null && (uhVar.p().equals("omp") || uhVar.p().equals("mon"))) {
                return c(ohVar);
            }
            return d(true, ohVar);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Object> f(String str, oh ohVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, ohVar, z)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            a(hashMap, HttpRequest.CLIENT_TYPE, "2");
            a(hashMap, "_client_version", ohVar.c);
            a(hashMap, HttpRequest.CLIENT_ID, ohVar.f);
            a(hashMap, HttpRequest.SUBAPP_TYPE, ohVar.j);
            a(hashMap, "from", ohVar.d);
            a(hashMap, "net_type", ohVar.p);
            a(hashMap, "cuid", ohVar.g);
            a(hashMap, "cuid_galaxy2", ohVar.h);
            a(hashMap, "model", ohVar.k);
            if (TextUtils.isEmpty(ohVar.l)) {
                ohVar.l = "0";
            }
            a(hashMap, "uid", ohVar.l);
            a(hashMap, "un", ohVar.m);
            a(hashMap, HttpRequest.BDUSS, ohVar.n);
            if (z) {
                a(hashMap, "find_bug", "2");
            } else {
                a(hashMap, "find_bug", "0");
            }
            a(hashMap, "sz", ohVar.r);
            a(hashMap, BaiduIdentityManager.PARAM_CUA, ohVar.s);
            a(hashMap, TiebaStatic.Params.BDID, ohVar.z);
            a(hashMap, "cookie", ohVar.n);
            a(hashMap, "oaid", ohVar.t);
            a(hashMap, "utbrand", ohVar.w);
            a(hashMap, "baiduapppb_ut", ohVar.x);
            a(hashMap, HttpRequest.USER_AGENT, ohVar.y);
            a(hashMap, "active_timestamp", ohVar.A);
            a(hashMap, "first_install_time", ohVar.B);
            a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, ohVar.C);
            a(hashMap, "event_day", ohVar.D);
            if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, str).getData()).booleanValue()) {
                MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
            } else {
                a(hashMap, "mac", ohVar.u);
                a(hashMap, HttpRequest.ANDROID_ID, ohVar.v);
                a(hashMap, HttpRequest.PHONE_IMEI, ohVar.i);
            }
            return hashMap;
        }
        return (HashMap) invokeLLZ.objValue;
    }
}
