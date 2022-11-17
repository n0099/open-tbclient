package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.sapi2.SapiAccount;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.er4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.FunAdSdk;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class hr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            try {
                NetWork netWork = new NetWork(TbConfig.PassConfig.GET_CERT_URL);
                netWork.getNetContext().getRequest().mIsNeedAddCommenParam = false;
                netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                JSONObject jSONObject = new JSONObject(new String(netWork.getNetData()));
                return new String[]{jSONObject.optString("cert_id"), jSONObject.optString("cert")};
            } catch (Exception unused) {
                return null;
            }
        }
        return (String[]) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (BdNetTypeUtil.isWifiNet()) {
                return UtilHelper.getWifiMac(TbadkCoreApplication.getInst().getApp());
            }
            return UtilHelper.getGprsIpAddress();
        }
        return (String) invokeV.objValue;
    }

    public static String c(ArrayList<BasicNameValuePair> arrayList, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, arrayList, str)) == null) {
            ArrayList arrayList2 = new ArrayList();
            HashMap hashMap = new HashMap();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(arrayList.get(i).getName());
                hashMap.put(arrayList.get(i).getName(), arrayList.get(i).getValue());
            }
            Collections.sort(arrayList2);
            StringBuffer stringBuffer = new StringBuffer();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                stringBuffer.append(str2);
                stringBuffer.append("=");
                try {
                    String str3 = (String) hashMap.get(str2);
                    if (!TextUtils.isEmpty(str3)) {
                        stringBuffer.append(URLEncoder.encode(str3, "UTF-8"));
                    }
                } catch (UnsupportedEncodingException e) {
                    BdLog.e(e.getMessage());
                }
                stringBuffer.append("&");
            }
            stringBuffer.append("sign_key=" + str);
            return fj.c(stringBuffer.toString());
        }
        return (String) invokeLL.objValue;
    }

    public static er4.b d(er4.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVar)) == null) {
            if (bVar == null) {
                return null;
            }
            try {
                String[] a = a();
                if (a == null) {
                    return null;
                }
                ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
                arrayList.add(new BasicNameValuePair("crypttype", "1"));
                arrayList.add(new BasicNameValuePair("tpl", TbConfig.PassConfig.TPL));
                arrayList.add(new BasicNameValuePair("appid", "1"));
                arrayList.add(new BasicNameValuePair("clientip", b()));
                arrayList.add(new BasicNameValuePair("cert_id", a[0]));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bduss", bVar.a);
                jSONObject.put(SapiAccount.SAPI_ACCOUNT_PTOKEN, bVar.b);
                jSONObject.put("cuid", DeviceId.getDeviceID(TbadkCoreApplication.getInst().getApp()));
                jSONObject.put("clientid", TbadkCoreApplication.getInst().getImei());
                arrayList.add(new BasicNameValuePair(TableDefine.DB_TABLE_USERINFO, new hr4().a(a[1], jSONObject.toString())));
                arrayList.add(new BasicNameValuePair(FunAdSdk.PLATFORM_SIG, c(arrayList, TbConfig.PassConfig.ENC_KEY)));
                NetWork netWork = new NetWork(TbConfig.PassConfig.LOGIN_BDUSS_URL);
                netWork.getNetContext().getRequest().mIsNeedAddCommenParam = false;
                netWork.getNetContext().getRequest().mIsUseCurrentBDUSS = false;
                netWork.setPostData(arrayList);
                netWork.getNetContext().getRequest().mRequestGzip = true;
                netWork.getNetContext().getRequest().mIsBaiduServer = false;
                String postNetData = netWork.postNetData();
                if (!netWork.getNetContext().getResponse().isRequestSuccess() || xi.isEmpty(postNetData)) {
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject(postNetData);
                if (!"0".equals(jSONObject2.optString("errno"))) {
                    return null;
                }
                er4.b bVar2 = new er4.b();
                bVar2.a = jSONObject2.optString("bduss");
                bVar2.b = jSONObject2.optString(SapiAccount.SAPI_ACCOUNT_PTOKEN);
                jSONObject2.optString("uname");
                return bVar2;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (er4.b) invokeL.objValue;
    }
}
