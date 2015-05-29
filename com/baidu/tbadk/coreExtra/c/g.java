package com.baidu.tbadk.coreExtra.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import com.baidu.tbadk.coreExtra.data.m;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int adm = 0;
    private VersionData adg = new VersionData();
    private com.baidu.tbadk.coreExtra.data.d adh = new com.baidu.tbadk.coreExtra.data.d();
    private com.baidu.tbadk.coreExtra.data.e adi = new com.baidu.tbadk.coreExtra.data.e();
    private CombineDownload adj = new CombineDownload();
    private com.baidu.tbadk.coreExtra.data.h adk = new com.baidu.tbadk.coreExtra.data.h();
    private m adl = new m();

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
                this.adg.parserJson(jSONObject.optJSONObject("version"));
                this.adh.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.f.setIp(jSONObject.optString("client_ip", null));
                this.adi.parserJson(jSONObject.optJSONObject("config"));
                this.adl.parserJson(jSONObject.optJSONObject("wl_config"));
                this.mConfigVersion = jSONObject.optString("config_version");
                this.adj.parserJson(jSONObject.optJSONObject("combine_download"));
                this.adk.parserJson(jSONObject.optJSONObject("mainbar"));
                this.adm = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new c().g(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public com.baidu.tbadk.coreExtra.data.e wI() {
        return this.adi;
    }

    public String wJ() {
        return this.mConfigVersion;
    }

    public CombineDownload wK() {
        return this.adj;
    }

    public VersionData wL() {
        return this.adg;
    }

    public com.baidu.tbadk.coreExtra.data.d wM() {
        return this.adh;
    }

    public m wN() {
        return this.adl;
    }
}
