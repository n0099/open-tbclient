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
/* loaded from: classes3.dex */
public class ai {
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
                    str2 = URLEncoder.encode(str2, IMAudioTransRequest.CHARSET);
                }
                sb.append(str2);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public static String c(ih ihVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ihVar)) == null) {
            if (ihVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(ihVar.a, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(ihVar.b, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(ihVar.c, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("os");
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append(HttpConstants.OS_VERSION);
                sb.append("=");
                sb.append(URLEncoder.encode(ihVar.q, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(ihVar.d)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ihVar.d, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ihVar.e)) {
                    sb.append("&");
                    sb.append("cfrom");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ihVar.e, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("phone");
                sb.append("=");
                sb.append(URLEncoder.encode(ihVar.k, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(ihVar.l)) {
                    sb.append("&");
                    sb.append("uid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ihVar.l, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ihVar.f)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ihVar.f, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ihVar.i)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ihVar.i, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ihVar.m)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ihVar.m, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ihVar.g)) {
                    sb.append("&");
                    sb.append("cuid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ihVar.g, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ihVar.h)) {
                    sb.append("&");
                    sb.append("cuid_galaxy2");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ihVar.h, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("net");
                sb.append("=");
                sb.append(URLEncoder.encode(ihVar.o, IMAudioTransRequest.CHARSET));
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(boolean z, ih ihVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65539, null, z, ihVar)) == null) {
            if (ihVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_client_type=2");
            b(sb, "_client_version", ihVar.c, z);
            b(sb, HttpRequest.PHONE_IMEI, ihVar.i, z);
            b(sb, HttpRequest.CLIENT_ID, ihVar.f, z);
            b(sb, HttpRequest.SUBAPP_TYPE, ihVar.j, z);
            b(sb, HttpConstants.OS_VERSION, ihVar.q, z);
            b(sb, "from", ihVar.d, z);
            b(sb, "cfrom", ihVar.e, z);
            b(sb, "net_type", ihVar.p, z);
            b(sb, "cuid", ihVar.g, z);
            b(sb, "model", ihVar.k, z);
            if (TextUtils.isEmpty(ihVar.l)) {
                b(sb, "uid", "0", z);
            } else {
                b(sb, "uid", ihVar.l, z);
            }
            b(sb, "un", ihVar.m, z);
            b(sb, "utbrand", ihVar.w, z);
            b(sb, "cuid_galaxy2", ihVar.h, z);
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public static String e(oh ohVar, ih ihVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ohVar, ihVar)) == null) {
            if (ohVar.p() != null && (ohVar.p().equals("omp") || ohVar.p().equals("mon"))) {
                return c(ihVar);
            }
            return d(true, ihVar);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Object> f(String str, ih ihVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, ihVar, z)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            a(hashMap, HttpRequest.CLIENT_TYPE, "2");
            a(hashMap, "_client_version", ihVar.c);
            a(hashMap, HttpRequest.CLIENT_ID, ihVar.f);
            a(hashMap, HttpRequest.SUBAPP_TYPE, ihVar.j);
            a(hashMap, "from", ihVar.d);
            a(hashMap, "net_type", ihVar.p);
            a(hashMap, "cuid", ihVar.g);
            a(hashMap, "cuid_galaxy2", ihVar.h);
            a(hashMap, "model", ihVar.k);
            if (TextUtils.isEmpty(ihVar.l)) {
                ihVar.l = "0";
            }
            a(hashMap, "uid", ihVar.l);
            a(hashMap, "un", ihVar.m);
            a(hashMap, HttpRequest.BDUSS, ihVar.n);
            if (z) {
                a(hashMap, "find_bug", "2");
            } else {
                a(hashMap, "find_bug", "0");
            }
            a(hashMap, "sz", ihVar.r);
            a(hashMap, BaiduIdentityManager.PARAM_CUA, ihVar.s);
            a(hashMap, TiebaStatic.Params.BDID, ihVar.z);
            a(hashMap, "cookie", ihVar.n);
            a(hashMap, "oaid", ihVar.t);
            a(hashMap, "utbrand", ihVar.w);
            a(hashMap, "baiduapppb_ut", ihVar.x);
            a(hashMap, "user_agent", ihVar.y);
            a(hashMap, "active_timestamp", ihVar.A);
            a(hashMap, "first_install_time", ihVar.B);
            a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, ihVar.C);
            a(hashMap, "event_day", ihVar.D);
            if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, str).getData()).booleanValue()) {
                MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
            } else {
                a(hashMap, "mac", ihVar.u);
                a(hashMap, HttpRequest.ANDROID_ID, ihVar.v);
                a(hashMap, HttpRequest.PHONE_IMEI, ihVar.i);
            }
            return hashMap;
        }
        return (HashMap) invokeLLZ.objValue;
    }
}
