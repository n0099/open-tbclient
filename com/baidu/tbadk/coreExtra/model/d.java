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
    private int chZ;
    private JSONArray cic;
    private JSONArray cie;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int chX = 0;
    private int chY = 0;
    private VersionData chQ = new VersionData();
    private m chR = new m();
    private n chS = new n();
    private CombineDownload chT = new CombineDownload();
    private r chU = new r();
    private z chV = new z();
    private o cia = new o();
    private com.baidu.tbadk.coreExtra.data.e chW = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a cib = new com.baidu.tbadk.coreExtra.data.a();
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
                this.chQ.parserJson(jSONObject.optJSONObject("version"));
                this.chR.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.chS.parserJson(jSONObject.optJSONObject("config"));
                this.chV.parserJson(jSONObject.optJSONObject("wl_config"));
                this.cia.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.cia);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.chY = jSONObject.optInt("is_uninterest");
                this.chZ = jSONObject.optInt("first_time_motivate");
                this.chT.parserJson(jSONObject.optJSONObject("combine_download"));
                this.chU.parserJson(jSONObject.optJSONObject("mainbar"));
                this.chX = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                this.chW.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.cib.parseJson(jSONObject.optJSONObject("abtest_config"));
                this.cic = jSONObject.optJSONArray("new_abtest_config");
                this.cie = jSONObject.optJSONArray("windowStrategyList");
                com.baidu.tbadk.core.business.a.abt().v(this.cie);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public n anJ() {
        return this.chS;
    }

    public String anK() {
        return this.mConfigVersion;
    }

    public CombineDownload anL() {
        return this.chT;
    }

    public VersionData anM() {
        return this.chQ;
    }

    public m anN() {
        return this.chR;
    }

    public z anO() {
        return this.chV;
    }

    public com.baidu.tbadk.coreExtra.data.e anP() {
        return this.chW;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int anQ() {
        return this.chY;
    }

    public boolean anR() {
        return this.chZ == 1;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public t getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a anS() {
        return this.cib;
    }

    public JSONArray anT() {
        return this.cic;
    }
}
