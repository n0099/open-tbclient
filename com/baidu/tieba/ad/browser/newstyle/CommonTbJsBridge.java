package com.baidu.tieba.ad.browser.newstyle;

import android.content.Context;
import android.os.Build;
import android.webkit.JsPromptResult;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tbadk.xiuba.JSResultData;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
class CommonTbJsBridge implements com.baidu.tieba.tbadkCore.e.b {
    private static final String GET_SUPPLEMENT_INFO = "getSupplementInfo";
    private static final String INTERFACE_NAME = "CommonJSBridge";
    private static final String START_LOGIN_MODULE = "startLoginModule";
    private final TbPageContext<?> mTbPageContext;

    public CommonTbJsBridge(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
    }

    private String startLoginModule() {
        TbadkCoreApplication.getInst().login(this.mTbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.mTbPageContext.getPageActivity(), true)));
        JSResultData jSResultData = new JSResultData();
        jSResultData.setStatus(1);
        jSResultData.setErrorCode("0");
        jSResultData.setErrorMsg("");
        return OrmObject.jsonStrWithObject(jSResultData);
    }

    @Override // com.baidu.tieba.tbadkCore.e.b
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if ("CommonJSBridge".equals(str)) {
            if (START_LOGIN_MODULE.equals(str2)) {
                try {
                    new JSONObject(str3);
                    jsPromptResult.confirm(startLoginModule());
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (GET_SUPPLEMENT_INFO.equals(str2)) {
                jsPromptResult.confirm(getSupplementInfo().getData());
                return true;
            }
        }
        return false;
    }

    public com.baidu.tieba.tbadkCore.e.a.c getSupplementInfo() {
        com.baidu.tieba.tbadkCore.e.a.c cVar = new com.baidu.tieba.tbadkCore.e.a.c();
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
        String md5 = s.toMd5(sb.toString());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("imei", imei);
            jSONObject.put("cuid", cuid);
            jSONObject.put(AdExtParam.KEY_SHOUBAI_CUID, cuidGalaxy2);
            jSONObject.put(Constants.PHONE_BRAND, str);
            jSONObject.put("client_type", "Android");
            jSONObject.put("client_version", version);
            jSONObject.put("zid", zid);
            jSONObject.put("sign", md5);
            cVar.setData(jSONObject.toString());
        } catch (JSONException e) {
            BdLog.e(e);
            cVar.setData("");
        }
        return cVar;
    }
}
