package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.coreExtra.data.m;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.coreExtra.data.w;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int aEL;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int aEJ = 0;
    private int aEK = 0;
    private VersionData aEC = new VersionData();
    private k aED = new k();
    private l aEE = new l();
    private CombineDownload aEF = new CombineDownload();
    private p aEG = new p();
    private w aEH = new w();
    private m aEM = new m();
    private com.baidu.tbadk.coreExtra.data.d aEI = new com.baidu.tbadk.coreExtra.data.d();
    private com.baidu.tbadk.coreExtra.data.c mAdAdSense = new com.baidu.tbadk.coreExtra.data.c();
    private final com.baidu.tbadk.coreExtra.data.b mActivitySwitch = new com.baidu.tbadk.coreExtra.data.b();
    private r mProfileData = new r();

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
                this.aEC.parserJson(jSONObject.optJSONObject("version"));
                this.aED.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.aEE.parserJson(jSONObject.optJSONObject("config"));
                this.aEH.parserJson(jSONObject.optJSONObject("wl_config"));
                this.aEM.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.aEM);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.aEK = jSONObject.optInt("is_uninterest");
                this.aEL = jSONObject.optInt("first_time_motivate");
                this.aEF.parserJson(jSONObject.optJSONObject("combine_download"));
                this.aEG.parserJson(jSONObject.optJSONObject("mainbar"));
                this.aEJ = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                this.aEI.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public l Et() {
        return this.aEE;
    }

    public String Eu() {
        return this.mConfigVersion;
    }

    public CombineDownload Ev() {
        return this.aEF;
    }

    public VersionData Ew() {
        return this.aEC;
    }

    public k Ex() {
        return this.aED;
    }

    public w Ey() {
        return this.aEH;
    }

    public com.baidu.tbadk.coreExtra.data.d Ez() {
        return this.aEI;
    }

    public com.baidu.tbadk.coreExtra.data.c getAdAdSense() {
        return this.mAdAdSense;
    }

    public int EA() {
        return this.aEK;
    }

    public boolean EB() {
        return this.aEL == 1;
    }

    public com.baidu.tbadk.coreExtra.data.b getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public r getProfileData() {
        return this.mProfileData;
    }
}
