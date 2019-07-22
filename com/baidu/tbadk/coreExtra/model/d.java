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
    private int cjf;
    private JSONArray cji;
    private JSONArray cjj;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int cjd = 0;
    private int cje = 0;
    private VersionData ciW = new VersionData();
    private m ciX = new m();
    private n ciY = new n();
    private CombineDownload ciZ = new CombineDownload();
    private r cja = new r();
    private z cjb = new z();
    private o cjg = new o();
    private com.baidu.tbadk.coreExtra.data.e cjc = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a cjh = new com.baidu.tbadk.coreExtra.data.a();
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
                this.ciW.parserJson(jSONObject.optJSONObject("version"));
                this.ciX.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.ciY.parserJson(jSONObject.optJSONObject("config"));
                this.cjb.parserJson(jSONObject.optJSONObject("wl_config"));
                this.cjg.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.cjg);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.cje = jSONObject.optInt("is_uninterest");
                this.cjf = jSONObject.optInt("first_time_motivate");
                this.ciZ.parserJson(jSONObject.optJSONObject("combine_download"));
                this.cja.parserJson(jSONObject.optJSONObject("mainbar"));
                this.cjd = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().bc(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                com.baidu.tbadk.coreExtra.data.f.A(jSONObject.optJSONArray("scheme_whitelist"));
                this.cjc.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.cjh.parseJson(jSONObject.optJSONObject("abtest_config"));
                this.cji = jSONObject.optJSONArray("new_abtest_config");
                this.cjj = jSONObject.optJSONArray("windowStrategyList");
                com.baidu.tbadk.core.business.a.acs().v(this.cjj);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public n aoO() {
        return this.ciY;
    }

    public String aoP() {
        return this.mConfigVersion;
    }

    public CombineDownload aoQ() {
        return this.ciZ;
    }

    public VersionData aoR() {
        return this.ciW;
    }

    public m aoS() {
        return this.ciX;
    }

    public z aoT() {
        return this.cjb;
    }

    public com.baidu.tbadk.coreExtra.data.e aoU() {
        return this.cjc;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int aoV() {
        return this.cje;
    }

    public boolean aoW() {
        return this.cjf == 1;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public t getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a aoX() {
        return this.cjh;
    }

    public JSONArray aoY() {
        return this.cji;
    }
}
