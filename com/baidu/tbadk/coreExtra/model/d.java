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
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.coreExtra.data.s;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int atg;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int ate = 0;
    private int atf = 0;
    private VersionData asX = new VersionData();
    private j asY = new j();
    private k asZ = new k();
    private CombineDownload ata = new CombineDownload();
    private o atb = new o();
    private s atc = new s();
    private l ath = new l();
    private com.baidu.tbadk.coreExtra.data.c atd = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.b mAdAdSense = new com.baidu.tbadk.coreExtra.data.b();

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
                this.asX.parserJson(jSONObject.optJSONObject("version"));
                this.asY.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.asZ.parserJson(jSONObject.optJSONObject("config"));
                this.atc.parserJson(jSONObject.optJSONObject("wl_config"));
                this.ath.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.ath);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.atf = jSONObject.optInt("is_uninterest");
                this.atg = jSONObject.optInt("first_time_motivate");
                this.ata.parserJson(jSONObject.optJSONObject("combine_download"));
                this.atb.parserJson(jSONObject.optJSONObject("mainbar"));
                this.ate = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().i(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                this.atd.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public k zM() {
        return this.asZ;
    }

    public String zN() {
        return this.mConfigVersion;
    }

    public CombineDownload zO() {
        return this.ata;
    }

    public VersionData zP() {
        return this.asX;
    }

    public j zQ() {
        return this.asY;
    }

    public s zR() {
        return this.atc;
    }

    public com.baidu.tbadk.coreExtra.data.c zS() {
        return this.atd;
    }

    public com.baidu.tbadk.coreExtra.data.b getAdAdSense() {
        return this.mAdAdSense;
    }

    public int zT() {
        return this.atf;
    }

    public boolean zU() {
        return this.atg == 1;
    }
}
