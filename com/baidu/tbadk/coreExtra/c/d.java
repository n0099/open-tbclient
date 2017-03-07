package com.baidu.tbadk.coreExtra.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import com.baidu.tbadk.coreExtra.data.i;
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.coreExtra.data.r;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int aqw = 0;
    private VersionData aqp = new VersionData();
    private i aqq = new i();
    private j aqr = new j();
    private CombineDownload aqs = new CombineDownload();
    private n aqt = new n();
    private r aqu = new r();
    private k aqx = new k();
    private com.baidu.tbadk.coreExtra.data.b aqv = new com.baidu.tbadk.coreExtra.data.b();
    private com.baidu.tbadk.coreExtra.data.a mAdAdSense = new com.baidu.tbadk.coreExtra.data.a();

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
                this.aqp.parserJson(jSONObject.optJSONObject("version"));
                this.aqq.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.aqr.parserJson(jSONObject.optJSONObject("config"));
                this.aqu.parserJson(jSONObject.optJSONObject("wl_config"));
                this.aqx.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.m9getInst().setConsumePathData(this.aqx);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.aqs.parserJson(jSONObject.optJSONObject("combine_download"));
                this.aqt.parserJson(jSONObject.optJSONObject("mainbar"));
                this.aqw = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_ADS_EMOTION, jSONObject));
                this.mFaceShopVersion = jSONObject.optInt("faceshop_version");
                if (this.mFaceShopVersion > TbadkCoreApplication.m9getInst().getFaceShopVersion()) {
                    TbadkCoreApplication.m9getInst().setTempFaceShopVersion(this.mFaceShopVersion);
                    TbadkCoreApplication.m9getInst().setFaceShopNew(true);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject != null) {
                    TbadkCoreApplication.m9getInst().setLcsSwitchStratgy(optJSONObject.toString());
                }
                new b().l(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                this.aqv.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public j zI() {
        return this.aqr;
    }

    public String zJ() {
        return this.mConfigVersion;
    }

    public CombineDownload zK() {
        return this.aqs;
    }

    public VersionData zL() {
        return this.aqp;
    }

    public i zM() {
        return this.aqq;
    }

    public r zN() {
        return this.aqu;
    }

    public com.baidu.tbadk.coreExtra.data.b zO() {
        return this.aqv;
    }

    public com.baidu.tbadk.coreExtra.data.a getAdAdSense() {
        return this.mAdAdSense;
    }
}
