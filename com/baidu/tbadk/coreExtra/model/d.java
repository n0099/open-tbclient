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
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.coreExtra.data.m;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tbadk.coreExtra.data.x;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int aHY;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int aHW = 0;
    private int aHX = 0;
    private VersionData aHP = new VersionData();
    private l aHQ = new l();
    private m aHR = new m();
    private CombineDownload aHS = new CombineDownload();
    private q aHT = new q();
    private x aHU = new x();
    private n aHZ = new n();
    private com.baidu.tbadk.coreExtra.data.e aHV = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a aIa = new com.baidu.tbadk.coreExtra.data.a();
    private s mProfileData = new s();

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
                this.aHP.parserJson(jSONObject.optJSONObject("version"));
                this.aHQ.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.aHR.parserJson(jSONObject.optJSONObject("config"));
                this.aHU.parserJson(jSONObject.optJSONObject("wl_config"));
                this.aHZ.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.aHZ);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.aHX = jSONObject.optInt("is_uninterest");
                this.aHY = jSONObject.optInt("first_time_motivate");
                this.aHS.parserJson(jSONObject.optJSONObject("combine_download"));
                this.aHT.parserJson(jSONObject.optJSONObject("mainbar"));
                this.aHW = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().C(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                this.aHV.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.aIa.parseJson(jSONObject.optJSONObject("abtest_config"));
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public m FI() {
        return this.aHR;
    }

    public String FJ() {
        return this.mConfigVersion;
    }

    public CombineDownload FK() {
        return this.aHS;
    }

    public VersionData FL() {
        return this.aHP;
    }

    public l FM() {
        return this.aHQ;
    }

    public x FN() {
        return this.aHU;
    }

    public com.baidu.tbadk.coreExtra.data.e FO() {
        return this.aHV;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int FP() {
        return this.aHX;
    }

    public boolean FQ() {
        return this.aHY == 1;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public s getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a FR() {
        return this.aIa;
    }
}
