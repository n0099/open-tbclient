package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.coreExtra.data.m;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.v;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int aEM;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int aEK = 0;
    private int aEL = 0;
    private VersionData aED = new VersionData();
    private k aEE = new k();
    private l aEF = new l();
    private CombineDownload aEG = new CombineDownload();
    private p aEH = new p();
    private v aEI = new v();
    private m aEN = new m();
    private com.baidu.tbadk.coreExtra.data.d aEJ = new com.baidu.tbadk.coreExtra.data.d();
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
                this.aED.parserJson(jSONObject.optJSONObject("version"));
                this.aEE.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.aEF.parserJson(jSONObject.optJSONObject("config"));
                this.aEI.parserJson(jSONObject.optJSONObject("wl_config"));
                this.aEN.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.aEN);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.aEL = jSONObject.optInt("is_uninterest");
                this.aEM = jSONObject.optInt("first_time_motivate");
                this.aEG.parserJson(jSONObject.optJSONObject("combine_download"));
                this.aEH.parserJson(jSONObject.optJSONObject("mainbar"));
                this.aEK = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001141, jSONObject));
                this.mFaceShopVersion = jSONObject.optInt("faceshop_version");
                if (this.mFaceShopVersion > TbadkCoreApplication.getInst().getFaceShopVersion()) {
                    TbadkCoreApplication.getInst().setTempFaceShopVersion(this.mFaceShopVersion);
                    TbadkCoreApplication.getInst().setFaceShopNew(true);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject != null) {
                    TbadkCoreApplication.getInst().setLcsSwitchStratgy(optJSONObject.toString());
                }
                new b().s(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                this.aEJ.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public l Et() {
        return this.aEF;
    }

    public String Eu() {
        return this.mConfigVersion;
    }

    public CombineDownload Ev() {
        return this.aEG;
    }

    public VersionData Ew() {
        return this.aED;
    }

    public k Ex() {
        return this.aEE;
    }

    public v Ey() {
        return this.aEI;
    }

    public com.baidu.tbadk.coreExtra.data.d Ez() {
        return this.aEJ;
    }

    public com.baidu.tbadk.coreExtra.data.c getAdAdSense() {
        return this.mAdAdSense;
    }

    public int EA() {
        return this.aEL;
    }

    public boolean EB() {
        return this.aEM == 1;
    }

    public com.baidu.tbadk.coreExtra.data.b getActivitySwitch() {
        return this.mActivitySwitch;
    }
}
