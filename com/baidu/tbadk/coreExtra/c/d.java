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
    private int atq;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int ato = 0;
    private int atp = 0;
    private VersionData ath = new VersionData();
    private i ati = new i();
    private j atj = new j();
    private CombineDownload atk = new CombineDownload();
    private n atl = new n();
    private r atm = new r();
    private k atr = new k();
    private com.baidu.tbadk.coreExtra.data.b atn = new com.baidu.tbadk.coreExtra.data.b();
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
                this.ath.parserJson(jSONObject.optJSONObject("version"));
                this.ati.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.atj.parserJson(jSONObject.optJSONObject("config"));
                this.atm.parserJson(jSONObject.optJSONObject("wl_config"));
                this.atr.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.atr);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.atp = jSONObject.optInt("is_uninterest");
                this.atq = jSONObject.optInt("first_time_motivate");
                this.atk.parserJson(jSONObject.optJSONObject("combine_download"));
                this.atl.parserJson(jSONObject.optJSONObject("mainbar"));
                this.ato = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                this.atn.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public j Ab() {
        return this.atj;
    }

    public String Ac() {
        return this.mConfigVersion;
    }

    public CombineDownload Ad() {
        return this.atk;
    }

    public VersionData Ae() {
        return this.ath;
    }

    public i Af() {
        return this.ati;
    }

    public r Ag() {
        return this.atm;
    }

    public com.baidu.tbadk.coreExtra.data.b Ah() {
        return this.atn;
    }

    public com.baidu.tbadk.coreExtra.data.a getAdAdSense() {
        return this.mAdAdSense;
    }

    public int Ai() {
        return this.atp;
    }

    public boolean Aj() {
        return this.atq == 1;
    }
}
