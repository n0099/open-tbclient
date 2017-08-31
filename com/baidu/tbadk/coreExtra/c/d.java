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
    private int att;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int atr = 0;
    private int ats = 0;
    private VersionData atk = new VersionData();
    private i atl = new i();
    private j atm = new j();
    private CombineDownload atn = new CombineDownload();
    private n ato = new n();
    private r atp = new r();
    private k atu = new k();
    private com.baidu.tbadk.coreExtra.data.b atq = new com.baidu.tbadk.coreExtra.data.b();
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
                this.atk.parserJson(jSONObject.optJSONObject("version"));
                this.atl.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.atm.parserJson(jSONObject.optJSONObject("config"));
                this.atp.parserJson(jSONObject.optJSONObject("wl_config"));
                this.atu.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.atu);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.ats = jSONObject.optInt("is_uninterest");
                this.att = jSONObject.optInt("first_time_motivate");
                this.atn.parserJson(jSONObject.optJSONObject("combine_download"));
                this.ato.parserJson(jSONObject.optJSONObject("mainbar"));
                this.atr = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_ADS_EMOTION, jSONObject));
                this.mFaceShopVersion = jSONObject.optInt("faceshop_version");
                if (this.mFaceShopVersion > TbadkCoreApplication.getInst().getFaceShopVersion()) {
                    TbadkCoreApplication.getInst().setTempFaceShopVersion(this.mFaceShopVersion);
                    TbadkCoreApplication.getInst().setFaceShopNew(true);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject != null) {
                    TbadkCoreApplication.getInst().setLcsSwitchStratgy(optJSONObject.toString());
                }
                new b().g(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                this.atq.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public j Ab() {
        return this.atm;
    }

    public String Ac() {
        return this.mConfigVersion;
    }

    public CombineDownload Ad() {
        return this.atn;
    }

    public VersionData Ae() {
        return this.atk;
    }

    public i Af() {
        return this.atl;
    }

    public r Ag() {
        return this.atp;
    }

    public com.baidu.tbadk.coreExtra.data.b Ah() {
        return this.atq;
    }

    public com.baidu.tbadk.coreExtra.data.a getAdAdSense() {
        return this.mAdAdSense;
    }

    public int Ai() {
        return this.ats;
    }

    public boolean Aj() {
        return this.att == 1;
    }
}
