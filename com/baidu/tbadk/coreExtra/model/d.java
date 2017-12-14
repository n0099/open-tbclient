package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.coreExtra.data.m;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.t;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int atl;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int atj = 0;
    private int atk = 0;
    private VersionData atc = new VersionData();
    private k atd = new k();
    private l ate = new l();
    private CombineDownload atf = new CombineDownload();
    private p atg = new p();
    private t ath = new t();
    private m atm = new m();
    private com.baidu.tbadk.coreExtra.data.d ati = new com.baidu.tbadk.coreExtra.data.d();
    private com.baidu.tbadk.coreExtra.data.c mAdAdSense = new com.baidu.tbadk.coreExtra.data.c();
    private final com.baidu.tbadk.coreExtra.data.b mActivitySwitch = new com.baidu.tbadk.coreExtra.data.b();

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
                this.atc.parserJson(jSONObject.optJSONObject("version"));
                this.atd.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.ate.parserJson(jSONObject.optJSONObject("config"));
                this.ath.parserJson(jSONObject.optJSONObject("wl_config"));
                this.atm.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.atm);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.atk = jSONObject.optInt("is_uninterest");
                this.atl = jSONObject.optInt("first_time_motivate");
                this.atf.parserJson(jSONObject.optJSONObject("combine_download"));
                this.atg.parserJson(jSONObject.optJSONObject("mainbar"));
                this.atj = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().h(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                this.ati.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public l zN() {
        return this.ate;
    }

    public String zO() {
        return this.mConfigVersion;
    }

    public CombineDownload zP() {
        return this.atf;
    }

    public VersionData zQ() {
        return this.atc;
    }

    public k zR() {
        return this.atd;
    }

    public t zS() {
        return this.ath;
    }

    public com.baidu.tbadk.coreExtra.data.d zT() {
        return this.ati;
    }

    public com.baidu.tbadk.coreExtra.data.c getAdAdSense() {
        return this.mAdAdSense;
    }

    public int zU() {
        return this.atk;
    }

    public boolean zV() {
        return this.atl == 1;
    }

    public com.baidu.tbadk.coreExtra.data.b getActivitySwitch() {
        return this.mActivitySwitch;
    }
}
