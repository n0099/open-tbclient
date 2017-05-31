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
    private int aqy = 0;
    private VersionData aqr = new VersionData();
    private i aqs = new i();
    private j aqt = new j();
    private CombineDownload aqu = new CombineDownload();
    private n aqv = new n();
    private r aqw = new r();
    private k aqz = new k();
    private com.baidu.tbadk.coreExtra.data.b aqx = new com.baidu.tbadk.coreExtra.data.b();
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
                this.aqr.parserJson(jSONObject.optJSONObject("version"));
                this.aqs.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.aqt.parserJson(jSONObject.optJSONObject("config"));
                this.aqw.parserJson(jSONObject.optJSONObject("wl_config"));
                this.aqz.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.m9getInst().setConsumePathData(this.aqz);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.aqu.parserJson(jSONObject.optJSONObject("combine_download"));
                this.aqv.parserJson(jSONObject.optJSONObject("mainbar"));
                this.aqy = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                this.aqx.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public j zl() {
        return this.aqt;
    }

    public String zm() {
        return this.mConfigVersion;
    }

    public CombineDownload zn() {
        return this.aqu;
    }

    public VersionData zo() {
        return this.aqr;
    }

    public i zp() {
        return this.aqs;
    }

    public r zq() {
        return this.aqw;
    }

    public com.baidu.tbadk.coreExtra.data.b zr() {
        return this.aqx;
    }

    public com.baidu.tbadk.coreExtra.data.a getAdAdSense() {
        return this.mAdAdSense;
    }
}
