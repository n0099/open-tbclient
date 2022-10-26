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
public class hi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(HashMap hashMap, String str, String str2) {
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

    public static String c(ph phVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, phVar)) == null) {
            if (phVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(phVar.a, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(phVar.b, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(phVar.c, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("os");
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append(HttpConstants.OS_VERSION);
                sb.append("=");
                sb.append(URLEncoder.encode(phVar.q, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(phVar.d)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(phVar.d, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(phVar.e)) {
                    sb.append("&");
                    sb.append("cfrom");
                    sb.append("=");
                    sb.append(URLEncoder.encode(phVar.e, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("phone");
                sb.append("=");
                sb.append(URLEncoder.encode(phVar.k, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(phVar.l)) {
                    sb.append("&");
                    sb.append("uid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(phVar.l, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(phVar.f)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(phVar.f, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(phVar.i)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(phVar.i, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(phVar.m)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(phVar.m, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(phVar.g)) {
                    sb.append("&");
                    sb.append("cuid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(phVar.g, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(phVar.h)) {
                    sb.append("&");
                    sb.append("cuid_galaxy2");
                    sb.append("=");
                    sb.append(URLEncoder.encode(phVar.h, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("net");
                sb.append("=");
                sb.append(URLEncoder.encode(phVar.o, IMAudioTransRequest.CHARSET));
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(boolean z, ph phVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65539, null, z, phVar)) == null) {
            if (phVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_client_type=2");
            b(sb, "_client_version", phVar.c, z);
            b(sb, HttpRequest.PHONE_IMEI, phVar.i, z);
            b(sb, HttpRequest.CLIENT_ID, phVar.f, z);
            b(sb, HttpRequest.SUBAPP_TYPE, phVar.j, z);
            b(sb, HttpConstants.OS_VERSION, phVar.q, z);
            b(sb, "from", phVar.d, z);
            b(sb, "cfrom", phVar.e, z);
            b(sb, "net_type", phVar.p, z);
            b(sb, "cuid", phVar.g, z);
            b(sb, "model", phVar.k, z);
            if (TextUtils.isEmpty(phVar.l)) {
                b(sb, "uid", "0", z);
            } else {
                b(sb, "uid", phVar.l, z);
            }
            b(sb, "un", phVar.m, z);
            b(sb, "utbrand", phVar.w, z);
            b(sb, "cuid_galaxy2", phVar.h, z);
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public static String e(vh vhVar, ph phVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, vhVar, phVar)) == null) {
            if (vhVar.p() != null && (vhVar.p().equals("omp") || vhVar.p().equals("mon"))) {
                return c(phVar);
            }
            return d(true, phVar);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap f(String str, ph phVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, phVar, z)) == null) {
            HashMap hashMap = new HashMap();
            a(hashMap, HttpRequest.CLIENT_TYPE, "2");
            a(hashMap, "_client_version", phVar.c);
            a(hashMap, HttpRequest.CLIENT_ID, phVar.f);
            a(hashMap, HttpRequest.SUBAPP_TYPE, phVar.j);
            a(hashMap, "from", phVar.d);
            a(hashMap, "net_type", phVar.p);
            a(hashMap, "cuid", phVar.g);
            a(hashMap, "cuid_galaxy2", phVar.h);
            a(hashMap, "model", phVar.k);
            if (TextUtils.isEmpty(phVar.l)) {
                phVar.l = "0";
            }
            a(hashMap, "uid", phVar.l);
            a(hashMap, "un", phVar.m);
            a(hashMap, HttpRequest.BDUSS, phVar.n);
            if (z) {
                a(hashMap, "find_bug", "2");
            } else {
                a(hashMap, "find_bug", "0");
            }
            a(hashMap, "sz", phVar.r);
            a(hashMap, BaiduIdentityManager.PARAM_CUA, phVar.s);
            a(hashMap, TiebaStatic.Params.BDID, phVar.z);
            a(hashMap, "cookie", phVar.n);
            a(hashMap, "oaid", phVar.t);
            a(hashMap, "utbrand", phVar.w);
            a(hashMap, "baiduapppb_ut", phVar.x);
            a(hashMap, HttpRequest.USER_AGENT, phVar.y);
            a(hashMap, "active_timestamp", phVar.A);
            a(hashMap, "first_install_time", phVar.B);
            a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, phVar.C);
            a(hashMap, "event_day", phVar.D);
            if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, str).getData()).booleanValue()) {
                MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
            } else {
                a(hashMap, "mac", phVar.u);
                a(hashMap, HttpRequest.ANDROID_ID, phVar.v);
                a(hashMap, HttpRequest.PHONE_IMEI, phVar.i);
            }
            return hashMap;
        }
        return (HashMap) invokeLLZ.objValue;
    }
}
