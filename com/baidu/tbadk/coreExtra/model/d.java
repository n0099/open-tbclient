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
    private int cjm;
    private JSONArray cjp;
    private JSONArray cjq;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int cjk = 0;
    private int cjl = 0;
    private VersionData cjd = new VersionData();
    private m cje = new m();
    private n cjf = new n();
    private CombineDownload cjg = new CombineDownload();
    private r cjh = new r();
    private z cji = new z();
    private o cjn = new o();
    private com.baidu.tbadk.coreExtra.data.e cjj = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a cjo = new com.baidu.tbadk.coreExtra.data.a();
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
                this.cjd.parserJson(jSONObject.optJSONObject("version"));
                this.cje.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.cjf.parserJson(jSONObject.optJSONObject("config"));
                this.cji.parserJson(jSONObject.optJSONObject("wl_config"));
                this.cjn.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.cjn);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.cjl = jSONObject.optInt("is_uninterest");
                this.cjm = jSONObject.optInt("first_time_motivate");
                this.cjg.parserJson(jSONObject.optJSONObject("combine_download"));
                this.cjh.parserJson(jSONObject.optJSONObject("mainbar"));
                this.cjk = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                this.cjj.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.cjo.parseJson(jSONObject.optJSONObject("abtest_config"));
                this.cjp = jSONObject.optJSONArray("new_abtest_config");
                this.cjq = jSONObject.optJSONArray("windowStrategyList");
                com.baidu.tbadk.core.business.a.acs().v(this.cjq);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public n aoQ() {
        return this.cjf;
    }

    public String aoR() {
        return this.mConfigVersion;
    }

    public CombineDownload aoS() {
        return this.cjg;
    }

    public VersionData aoT() {
        return this.cjd;
    }

    public m aoU() {
        return this.cje;
    }

    public z aoV() {
        return this.cji;
    }

    public com.baidu.tbadk.coreExtra.data.e aoW() {
        return this.cjj;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int aoX() {
        return this.cjl;
    }

    public boolean aoY() {
        return this.cjm == 1;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public t getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a aoZ() {
        return this.cjo;
    }

    public JSONArray apa() {
        return this.cjp;
    }
}
