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
    private int chY;
    private JSONArray cib;
    private JSONArray cic;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int chW = 0;
    private int chX = 0;
    private VersionData chP = new VersionData();
    private m chQ = new m();
    private n chR = new n();
    private CombineDownload chS = new CombineDownload();
    private r chT = new r();
    private z chU = new z();
    private o chZ = new o();
    private com.baidu.tbadk.coreExtra.data.e chV = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a cia = new com.baidu.tbadk.coreExtra.data.a();
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
                this.chP.parserJson(jSONObject.optJSONObject("version"));
                this.chQ.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.chR.parserJson(jSONObject.optJSONObject("config"));
                this.chU.parserJson(jSONObject.optJSONObject("wl_config"));
                this.chZ.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.chZ);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.chX = jSONObject.optInt("is_uninterest");
                this.chY = jSONObject.optInt("first_time_motivate");
                this.chS.parserJson(jSONObject.optJSONObject("combine_download"));
                this.chT.parserJson(jSONObject.optJSONObject("mainbar"));
                this.chW = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                this.chV.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.cia.parseJson(jSONObject.optJSONObject("abtest_config"));
                this.cib = jSONObject.optJSONArray("new_abtest_config");
                this.cic = jSONObject.optJSONArray("windowStrategyList");
                com.baidu.tbadk.core.business.a.abt().v(this.cic);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public n anJ() {
        return this.chR;
    }

    public String anK() {
        return this.mConfigVersion;
    }

    public CombineDownload anL() {
        return this.chS;
    }

    public VersionData anM() {
        return this.chP;
    }

    public m anN() {
        return this.chQ;
    }

    public z anO() {
        return this.chU;
    }

    public com.baidu.tbadk.coreExtra.data.e anP() {
        return this.chV;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int anQ() {
        return this.chX;
    }

    public boolean anR() {
        return this.chY == 1;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public t getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a anS() {
        return this.cia;
    }

    public JSONArray anT() {
        return this.cib;
    }
}
