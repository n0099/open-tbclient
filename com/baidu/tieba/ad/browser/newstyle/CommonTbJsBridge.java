package com.baidu.tieba.ad.browser.newstyle;

import android.content.Context;
import android.os.Build;
import android.webkit.JsPromptResult;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tbadk.xiuba.JSResultData;
import d.b.b.e.p.q;
import d.b.i0.c3.l0.b;
import d.b.i0.c3.l0.d.c;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CommonTbJsBridge implements b {
    public static final String GET_SUPPLEMENT_INFO = "getSupplementInfo";
    public static final String INTERFACE_NAME = "CommonJSBridge";
    public static final String START_LOGIN_MODULE = "startLoginModule";
    public final TbPageContext<?> mTbPageContext;

    public CommonTbJsBridge(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    private String startLoginModule() {
        TbadkCoreApplication.getInst().login(this.mTbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig((Context) this.mTbPageContext.getPageActivity(), true)));
        JSResultData jSResultData = new JSResultData();
        jSResultData.setStatus(1);
        jSResultData.setErrorCode("0");
        jSResultData.setErrorMsg("");
        return OrmObject.jsonStrWithObject(jSResultData);
    }

    @Override // d.b.i0.c3.l0.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
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

    public c getSupplementInfo() {
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
        sb.append(NetWork.SIGN_SUFFIX);
        String c2 = q.c(sb.toString());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("imei", imei);
            jSONObject.put("cuid", cuid);
            jSONObject.put(AdExtParam.KEY_SHOUBAI_CUID, cuidGalaxy2);
            jSONObject.put("brand", str);
            jSONObject.put("client_type", "Android");
            jSONObject.put("client_version", version);
            jSONObject.put("zid", zid);
            jSONObject.put("sign", c2);
            cVar.l(jSONObject.toString());
            return cVar;
        } catch (JSONException e2) {
            BdLog.e(e2);
            cVar.l("");
            return cVar;
        }
    }
}
