package com.baidu.tbadk.coreExtra.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.j;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.k;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int RW = 0;
    private VersionData RQ = new VersionData();
    private com.baidu.tbadk.coreExtra.data.d RR = new com.baidu.tbadk.coreExtra.data.d();
    private com.baidu.tbadk.coreExtra.data.e RS = new com.baidu.tbadk.coreExtra.data.e();
    private CombineDownload RT = new CombineDownload();
    private com.baidu.tbadk.coreExtra.data.g RU = new com.baidu.tbadk.coreExtra.data.g();
    private k RV = new k();

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.RQ.parserJson(jSONObject.optJSONObject("version"));
                this.RR.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.util.a.zB().parserJson(jSONObject.optJSONObject("ad_config"));
                j.setIp(jSONObject.optString("client_ip", null));
                this.RS.parserJson(jSONObject.optJSONObject("config"));
                this.RV.parserJson(jSONObject.optJSONObject("wl_config"));
                this.mConfigVersion = jSONObject.optString("config_version");
                this.RT.parserJson(jSONObject.optJSONObject("combine_download"));
                this.RU.parserJson(jSONObject.optJSONObject("mainbar"));
                this.RW = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001145, jSONObject));
                this.mFaceShopVersion = jSONObject.optInt("faceshop_version");
                if (this.mFaceShopVersion > TbadkCoreApplication.m255getInst().getFaceShopVersion()) {
                    TbadkCoreApplication.m255getInst().setTempFaceShopVersion(this.mFaceShopVersion);
                    TbadkCoreApplication.m255getInst().setFaceShopNew(true);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject != null) {
                    TbadkCoreApplication.m255getInst().setLcsSwitchStratgy(optJSONObject.toString());
                }
                new c().h(jSONObject.optJSONObject("next_start"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public com.baidu.tbadk.coreExtra.data.e sw() {
        return this.RS;
    }

    public String sx() {
        return this.mConfigVersion;
    }

    public CombineDownload sy() {
        return this.RT;
    }

    public VersionData sz() {
        return this.RQ;
    }

    public com.baidu.tbadk.coreExtra.data.d sA() {
        return this.RR;
    }

    public k sB() {
        return this.RV;
    }
}
