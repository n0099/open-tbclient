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
    private int bZY;
    private String bZZ;
    private JSONArray cac;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int bZW = 0;
    private int bZX = 0;
    private VersionData bZP = new VersionData();
    private m bZQ = new m();
    private n bZR = new n();
    private CombineDownload bZS = new CombineDownload();
    private r bZT = new r();
    private z bZU = new z();
    private o caa = new o();
    private com.baidu.tbadk.coreExtra.data.e bZV = new com.baidu.tbadk.coreExtra.data.e();
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
                this.bZP.parserJson(jSONObject.optJSONObject("version"));
                this.bZQ.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.bZR.parserJson(jSONObject.optJSONObject("config"));
                this.bZU.parserJson(jSONObject.optJSONObject("wl_config"));
                this.caa.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.caa);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.bZX = jSONObject.optInt("is_uninterest");
                this.bZY = jSONObject.optInt("first_time_motivate");
                this.bZS.parserJson(jSONObject.optJSONObject("combine_download"));
                this.bZT.parserJson(jSONObject.optJSONObject("mainbar"));
                this.bZW = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                this.bZV.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.cab.parseJson(jSONObject.optJSONObject("abtest_config"));
                this.cac = jSONObject.optJSONArray("new_abtest_config");
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
                this.bZZ = jSONObject.optString("complete_apk_url");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public n aiL() {
        return this.bZR;
    }

    public String aiM() {
        return this.mConfigVersion;
    }

    public CombineDownload aiN() {
        return this.bZS;
    }

    public VersionData aiO() {
        return this.bZP;
    }

    public m aiP() {
        return this.bZQ;
    }

    public z aiQ() {
        return this.bZU;
    }

    public com.baidu.tbadk.coreExtra.data.e aiR() {
        return this.bZV;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int aiS() {
        return this.bZX;
    }

    public boolean aiT() {
        return this.bZY == 1;
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

    public String aiV() {
        return this.bZZ;
    }

    public JSONArray aiW() {
        return this.cac;
    }
}
