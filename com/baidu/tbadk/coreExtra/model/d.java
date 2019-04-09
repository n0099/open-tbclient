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
    private int cac;
    private JSONArray caf;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int caa = 0;
    private int cab = 0;
    private VersionData bZT = new VersionData();
    private m bZU = new m();
    private n bZV = new n();
    private CombineDownload bZW = new CombineDownload();
    private r bZX = new r();
    private z bZY = new z();
    private o cad = new o();
    private com.baidu.tbadk.coreExtra.data.e bZZ = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a cae = new com.baidu.tbadk.coreExtra.data.a();
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
                this.bZT.parserJson(jSONObject.optJSONObject("version"));
                this.bZU.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.bZV.parserJson(jSONObject.optJSONObject("config"));
                this.bZY.parserJson(jSONObject.optJSONObject("wl_config"));
                this.cad.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.cad);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.cab = jSONObject.optInt("is_uninterest");
                this.cac = jSONObject.optInt("first_time_motivate");
                this.bZW.parserJson(jSONObject.optJSONObject("combine_download"));
                this.bZX.parserJson(jSONObject.optJSONObject("mainbar"));
                this.caa = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                this.bZZ.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.cae.parseJson(jSONObject.optJSONObject("abtest_config"));
                this.caf = jSONObject.optJSONArray("new_abtest_config");
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public n aiI() {
        return this.bZV;
    }

    public String aiJ() {
        return this.mConfigVersion;
    }

    public CombineDownload aiK() {
        return this.bZW;
    }

    public VersionData aiL() {
        return this.bZT;
    }

    public m aiM() {
        return this.bZU;
    }

    public z aiN() {
        return this.bZY;
    }

    public com.baidu.tbadk.coreExtra.data.e aiO() {
        return this.bZZ;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int aiP() {
        return this.cab;
    }

    public boolean aiQ() {
        return this.cac == 1;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public t getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a aiR() {
        return this.cae;
    }

    public JSONArray aiS() {
        return this.caf;
    }
}
