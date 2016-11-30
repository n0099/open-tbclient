package com.baidu.tbadk.coreExtra.d;

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
import com.baidu.tbadk.coreExtra.data.t;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int amu = 0;
    private VersionData amn = new VersionData();
    private i amo = new i();
    private j amp = new j();
    private CombineDownload amq = new CombineDownload();
    private n amr = new n();
    private t ams = new t();
    private k amv = new k();
    private com.baidu.tbadk.coreExtra.data.b amt = new com.baidu.tbadk.coreExtra.data.b();
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
                this.amn.parserJson(jSONObject.optJSONObject("version"));
                this.amo.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.e.setIp(jSONObject.optString("client_ip", null));
                this.amp.parserJson(jSONObject.optJSONObject("config"));
                this.ams.parserJson(jSONObject.optJSONObject("wl_config"));
                this.amv.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.m9getInst().setConsumePathData(this.amv);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.amq.parserJson(jSONObject.optJSONObject("combine_download"));
                this.amr.parserJson(jSONObject.optJSONObject("mainbar"));
                this.amu = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().n(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                this.amt.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public j zJ() {
        return this.amp;
    }

    public String zK() {
        return this.mConfigVersion;
    }

    public CombineDownload zL() {
        return this.amq;
    }

    public VersionData zM() {
        return this.amn;
    }

    public i zN() {
        return this.amo;
    }

    public t zO() {
        return this.ams;
    }

    public com.baidu.tbadk.coreExtra.data.b zP() {
        return this.amt;
    }

    public com.baidu.tbadk.coreExtra.data.a getAdAdSense() {
        return this.mAdAdSense;
    }
}
