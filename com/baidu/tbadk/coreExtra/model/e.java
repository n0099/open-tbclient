package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.coreExtra.data.ac;
import com.baidu.tbadk.coreExtra.data.aj;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.coreExtra.data.w;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private int eRG;
    private int eRH;
    private JSONArray eRL;
    private JSONArray eRM;
    private JSONArray eRN;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int eRE = 0;
    private int eRF = 0;
    private VersionData eRx = new VersionData();
    private r eRy = new r();
    private s eRz = new s();
    private CombineDownload eRA = new CombineDownload();
    private aa eRB = new aa();
    private aj eRC = new aj();
    private t eRI = new t();
    private com.baidu.tbadk.coreExtra.data.f eRD = new com.baidu.tbadk.coreExtra.data.f();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a eRJ = new com.baidu.tbadk.coreExtra.data.a();
    private ac mProfileData = new ac();
    private ABTestExtraData eRK = new ABTestExtraData();
    private NewGodData eRO = new NewGodData();
    private w eRP = new w();
    private com.baidu.tbadk.coreExtra.data.e eRQ = new com.baidu.tbadk.coreExtra.data.e();

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
                this.eRP.V(C(jSONObject, "index_tab_info"));
                this.eRx.parserJson(jSONObject.optJSONObject("version"));
                this.eRy.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                com.baidu.adp.lib.stats.f.bX(jSONObject.optString("client_ip", null));
                this.eRz.parserJson(jSONObject.optJSONObject("config"));
                this.eRC.parserJson(jSONObject.optJSONObject("wl_config"));
                jSONObject.optJSONObject("channel_icon_config");
                String optString = jSONObject.optString("new_god_data", "");
                if (!StringUtils.isNull(optString)) {
                    this.eRO.parserJson(optString);
                }
                this.eRI.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.eRI);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.eRF = jSONObject.optInt("is_uninterest");
                this.eRG = jSONObject.optInt("first_time_motivate");
                this.eRH = jSONObject.optInt("needNewUserLead");
                this.eRA.parserJson(jSONObject.optJSONObject("combine_download"));
                this.eRB.parserJson(jSONObject.optJSONObject("mainbar"));
                this.eRE = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_ADS_EMOTION, jSONObject));
                this.mFaceShopVersion = jSONObject.optInt(SharedPrefConfig.FACESHAOP_VERSION);
                if (this.mFaceShopVersion > TbadkCoreApplication.getInst().getFaceShopVersion()) {
                    TbadkCoreApplication.getInst().setTempFaceShopVersion(this.mFaceShopVersion);
                    TbadkCoreApplication.getInst().setFaceShopNew(true);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject != null) {
                    TbadkCoreApplication.getInst().setLcsSwitchStratgy(optJSONObject.toString());
                }
                new c().dk(jSONObject.optJSONObject("dis_adv_config"));
                WhiteListData whiteListData = new WhiteListData();
                whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
                TbSingleton.getInstance().setHostWhiteList(whiteListData);
                com.baidu.tbadk.coreExtra.data.g.T(jSONObject.optJSONArray("scheme_whitelist"));
                this.eRD.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                g.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.eRJ.parseJson(B(jSONObject, "abtest_config"));
                this.eRK.parseJson(B(jSONObject, "new_abtest_entra"));
                this.eRL = C(jSONObject, "new_abtest_config");
                this.eRM = C(jSONObject, "ubs_abtest_config");
                this.eRN = jSONObject.optJSONArray("windowStrategyList");
                this.eRQ.parserJson(B(jSONObject, "ad_density"));
                com.baidu.tbadk.core.business.a.bfA().N(this.eRN);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.blO().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
                TbSingleton.getInstance().setPcdnConfigData(jSONObject.optJSONObject("pcdn_config"));
                TbadkCoreApplication.getInst().setProxyIp(jSONObject.optString("proxy_ip"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private JSONObject B(JSONObject jSONObject, String str) {
        try {
            return jSONObject.optJSONObject(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private JSONArray C(JSONObject jSONObject, String str) {
        try {
            return jSONObject.optJSONArray(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public s bsE() {
        return this.eRz;
    }

    public String bsF() {
        return this.mConfigVersion;
    }

    public CombineDownload bsG() {
        return this.eRA;
    }

    public VersionData bsH() {
        return this.eRx;
    }

    public r bsI() {
        return this.eRy;
    }

    public aj bsJ() {
        return this.eRC;
    }

    public NewGodData bsK() {
        return this.eRO;
    }

    public com.baidu.tbadk.coreExtra.data.f bsL() {
        return this.eRD;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int bsM() {
        return this.eRF;
    }

    public boolean bsN() {
        return this.eRG == 1;
    }

    public int bsO() {
        return this.eRH;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public ac getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a bsP() {
        return this.eRJ;
    }

    public ABTestExtraData bsQ() {
        return this.eRK;
    }

    public JSONArray bsR() {
        return this.eRL;
    }

    public JSONArray bsS() {
        return this.eRM;
    }
}
