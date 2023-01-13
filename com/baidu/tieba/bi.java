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
public class bi {
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

    public static String c(jh jhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jhVar)) == null) {
            if (jhVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(jhVar.a, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(jhVar.b, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(jhVar.c, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("os");
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append(HttpConstants.OS_VERSION);
                sb.append("=");
                sb.append(URLEncoder.encode(jhVar.q, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(jhVar.d)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(jhVar.d, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(jhVar.e)) {
                    sb.append("&");
                    sb.append("cfrom");
                    sb.append("=");
                    sb.append(URLEncoder.encode(jhVar.e, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("phone");
                sb.append("=");
                sb.append(URLEncoder.encode(jhVar.k, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(jhVar.l)) {
                    sb.append("&");
                    sb.append("uid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(jhVar.l, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(jhVar.f)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(jhVar.f, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(jhVar.i)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(jhVar.i, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(jhVar.m)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(jhVar.m, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(jhVar.g)) {
                    sb.append("&");
                    sb.append("cuid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(jhVar.g, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(jhVar.h)) {
                    sb.append("&");
                    sb.append("cuid_galaxy2");
                    sb.append("=");
                    sb.append(URLEncoder.encode(jhVar.h, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("net");
                sb.append("=");
                sb.append(URLEncoder.encode(jhVar.o, IMAudioTransRequest.CHARSET));
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(boolean z, jh jhVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65539, null, z, jhVar)) == null) {
            if (jhVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_client_type=2");
            b(sb, "_client_version", jhVar.c, z);
            b(sb, HttpRequest.PHONE_IMEI, jhVar.i, z);
            b(sb, HttpRequest.CLIENT_ID, jhVar.f, z);
            b(sb, HttpRequest.SUBAPP_TYPE, jhVar.j, z);
            b(sb, HttpConstants.OS_VERSION, jhVar.q, z);
            b(sb, "from", jhVar.d, z);
            b(sb, "cfrom", jhVar.e, z);
            b(sb, "net_type", jhVar.p, z);
            b(sb, "cuid", jhVar.g, z);
            b(sb, "model", jhVar.k, z);
            if (TextUtils.isEmpty(jhVar.l)) {
                b(sb, "uid", "0", z);
            } else {
                b(sb, "uid", jhVar.l, z);
            }
            b(sb, "un", jhVar.m, z);
            b(sb, "utbrand", jhVar.w, z);
            b(sb, "cuid_galaxy2", jhVar.h, z);
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public static String e(ph phVar, jh jhVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, phVar, jhVar)) == null) {
            if (phVar.p() != null && (phVar.p().equals("omp") || phVar.p().equals("mon"))) {
                return c(jhVar);
            }
            return d(true, jhVar);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Object> f(String str, jh jhVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, jhVar, z)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            a(hashMap, HttpRequest.CLIENT_TYPE, "2");
            a(hashMap, "_client_version", jhVar.c);
            a(hashMap, HttpRequest.CLIENT_ID, jhVar.f);
            a(hashMap, HttpRequest.SUBAPP_TYPE, jhVar.j);
            a(hashMap, "from", jhVar.d);
            a(hashMap, "net_type", jhVar.p);
            a(hashMap, "cuid", jhVar.g);
            a(hashMap, "cuid_galaxy2", jhVar.h);
            a(hashMap, "model", jhVar.k);
            if (TextUtils.isEmpty(jhVar.l)) {
                jhVar.l = "0";
            }
            a(hashMap, "uid", jhVar.l);
            a(hashMap, "un", jhVar.m);
            a(hashMap, HttpRequest.BDUSS, jhVar.n);
            if (z) {
                a(hashMap, "find_bug", "2");
            } else {
                a(hashMap, "find_bug", "0");
            }
            a(hashMap, "sz", jhVar.r);
            a(hashMap, BaiduIdentityManager.PARAM_CUA, jhVar.s);
            a(hashMap, TiebaStatic.Params.BDID, jhVar.z);
            a(hashMap, "cookie", jhVar.n);
            a(hashMap, "oaid", jhVar.t);
            a(hashMap, "utbrand", jhVar.w);
            a(hashMap, "baiduapppb_ut", jhVar.x);
            a(hashMap, "user_agent", jhVar.y);
            a(hashMap, "active_timestamp", jhVar.A);
            a(hashMap, "first_install_time", jhVar.B);
            a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, jhVar.C);
            a(hashMap, "event_day", jhVar.D);
            if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, str).getData()).booleanValue()) {
                MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
            } else {
                a(hashMap, "mac", jhVar.u);
                a(hashMap, HttpRequest.ANDROID_ID, jhVar.v);
                a(hashMap, HttpRequest.PHONE_IMEI, jhVar.i);
            }
            return hashMap;
        }
        return (HashMap) invokeLLZ.objValue;
    }
}
