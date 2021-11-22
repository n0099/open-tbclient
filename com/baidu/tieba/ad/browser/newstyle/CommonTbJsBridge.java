package com.baidu.tieba.ad.browser.newstyle;

import android.content.Context;
import android.os.Build;
import android.webkit.JsPromptResult;
import b.a.e.f.p.q;
import b.a.r0.m3.n0.b;
import b.a.r0.m3.n0.d.c;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.xiuba.JSResultData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class CommonTbJsBridge implements b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GET_SUPPLEMENT_INFO = "getSupplementInfo";
    public static final String INTERFACE_NAME = "CommonJSBridge";
    public static final String START_LOGIN_MODULE = "startLoginModule";
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> mTbPageContext;

    public CommonTbJsBridge(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mTbPageContext = tbPageContext;
    }

    private String startLoginModule() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            TbadkCoreApplication.getInst().login(this.mTbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig((Context) this.mTbPageContext.getPageActivity(), true)));
            JSResultData jSResultData = new JSResultData();
            jSResultData.setStatus(1);
            jSResultData.setErrorCode("0");
            jSResultData.setErrorMsg("");
            return OrmObject.jsonStrWithObject(jSResultData);
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.r0.m3.n0.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, str2, str3, jsPromptResult)) == null) {
            if ("CommonJSBridge".equals(str)) {
                if ("startLoginModule".equals(str2)) {
                    try {
                        new JSONObject(str3);
                        jsPromptResult.confirm(startLoginModule());
                        return true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return false;
                    }
                } else if ("getSupplementInfo".equals(str2)) {
                    jsPromptResult.confirm(getSupplementInfo().a());
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public c getSupplementInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c cVar = new c();
            StringBuilder sb = new StringBuilder(1024);
            String imei = TbadkCoreApplication.getInst().getImei();
            sb.append("imei=");
            sb.append(imei);
            String cuid = TbadkCoreApplication.getInst().getCuid();
            sb.append("cuid=");
            sb.append(cuid);
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            sb.append("shoubai_cuid=");
            sb.append(cuidGalaxy2);
            String str = Build.BRAND;
            sb.append("brand=");
            sb.append(str);
            sb.append("client_type=");
            sb.append("Android");
            String version = TbConfig.getVersion();
            sb.append("client_version=");
            sb.append(version);
            String zid = TbadkCoreApplication.getInst().getZid();
            sb.append("zid=");
            sb.append(zid);
            sb.append("tiebaclient!!!");
            String c2 = q.c(sb.toString());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imei", imei);
                jSONObject.put("cuid", cuid);
                jSONObject.put("shoubai_cuid", cuidGalaxy2);
                jSONObject.put("brand", str);
                jSONObject.put("client_type", "Android");
                jSONObject.put("client_version", version);
                jSONObject.put("zid", zid);
                jSONObject.put("sign", c2);
                cVar.o(jSONObject.toString());
                return cVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                cVar.o("");
                return cVar;
            }
        }
        return (c) invokeV.objValue;
    }
}
