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
import com.baidu.tbadk.coreExtra.data.m;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.coreExtra.data.z;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int bZZ;
    private JSONArray cac;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int bZX = 0;
    private int bZY = 0;
    private VersionData bZQ = new VersionData();
    private m bZR = new m();
    private n bZS = new n();
    private CombineDownload bZT = new CombineDownload();
    private r bZU = new r();
    private z bZV = new z();
    private o caa = new o();
    private com.baidu.tbadk.coreExtra.data.e bZW = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a cab = new com.baidu.tbadk.coreExtra.data.a();
    private t mProfileData = new t();

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
                this.bZQ.parserJson(jSONObject.optJSONObject("version"));
                this.bZR.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.bZS.parserJson(jSONObject.optJSONObject("config"));
                this.bZV.parserJson(jSONObject.optJSONObject("wl_config"));
                this.caa.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.caa);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.bZY = jSONObject.optInt("is_uninterest");
                this.bZZ = jSONObject.optInt("first_time_motivate");
                this.bZT.parserJson(jSONObject.optJSONObject("combine_download"));
                this.bZU.parserJson(jSONObject.optJSONObject("mainbar"));
                this.bZX = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().aQ(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                com.baidu.tbadk.coreExtra.data.f.z(jSONObject.optJSONArray("scheme_whitelist"));
                this.bZW.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.cab.parseJson(jSONObject.optJSONObject("abtest_config"));
                this.cac = jSONObject.optJSONArray("new_abtest_config");
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public n aiL() {
        return this.bZS;
    }

    public String aiM() {
        return this.mConfigVersion;
    }

    public CombineDownload aiN() {
        return this.bZT;
    }

    public VersionData aiO() {
        return this.bZQ;
    }

    public m aiP() {
        return this.bZR;
    }

    public z aiQ() {
        return this.bZV;
    }

    public com.baidu.tbadk.coreExtra.data.e aiR() {
        return this.bZW;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int aiS() {
        return this.bZY;
    }

    public boolean aiT() {
        return this.bZZ == 1;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public t getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a aiU() {
        return this.cab;
    }

    public JSONArray aiV() {
        return this.cac;
    }
}
