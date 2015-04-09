package com.baidu.tbadk.coreExtra.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.m;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int acg = 0;
    private VersionData aca = new VersionData();
    private com.baidu.tbadk.coreExtra.data.d acb = new com.baidu.tbadk.coreExtra.data.d();
    private com.baidu.tbadk.coreExtra.data.e acc = new com.baidu.tbadk.coreExtra.data.e();
    private CombineDownload acd = new CombineDownload();
    private com.baidu.tbadk.coreExtra.data.h ace = new com.baidu.tbadk.coreExtra.data.h();
    private m acf = new m();

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
                this.aca.parserJson(jSONObject.optJSONObject("version"));
                this.acb.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.util.a.Db().parserJson(jSONObject.optJSONObject("ad_config"));
                com.baidu.tbadk.core.util.f.setIp(jSONObject.optString("client_ip", null));
                this.acc.parserJson(jSONObject.optJSONObject("config"));
                this.acf.parserJson(jSONObject.optJSONObject("wl_config"));
                this.mConfigVersion = jSONObject.optString("config_version");
                this.acd.parserJson(jSONObject.optJSONObject("combine_download"));
                this.ace.parserJson(jSONObject.optJSONObject("mainbar"));
                this.acg = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001145, jSONObject));
                this.mFaceShopVersion = jSONObject.optInt("faceshop_version");
                if (this.mFaceShopVersion > TbadkCoreApplication.m411getInst().getFaceShopVersion()) {
                    TbadkCoreApplication.m411getInst().setTempFaceShopVersion(this.mFaceShopVersion);
                    TbadkCoreApplication.m411getInst().setFaceShopNew(true);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject != null) {
                    TbadkCoreApplication.m411getInst().setLcsSwitchStratgy(optJSONObject.toString());
                }
                new c().g(jSONObject.optJSONObject("next_start"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public com.baidu.tbadk.coreExtra.data.e vY() {
        return this.acc;
    }

    public String vZ() {
        return this.mConfigVersion;
    }

    public CombineDownload wa() {
        return this.acd;
    }

    public VersionData wb() {
        return this.aca;
    }

    public com.baidu.tbadk.coreExtra.data.d wc() {
        return this.acb;
    }

    public m wd() {
        return this.acf;
    }
}
