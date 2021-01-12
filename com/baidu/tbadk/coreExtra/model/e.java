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
    private int frC;
    private int frD;
    private JSONArray frH;
    private JSONArray frI;
    private JSONArray frJ;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int frA = 0;
    private int frB = 0;
    private VersionData frt = new VersionData();
    private r fru = new r();
    private s frv = new s();
    private CombineDownload frw = new CombineDownload();
    private aa frx = new aa();
    private aj fry = new aj();
    private t frE = new t();
    private com.baidu.tbadk.coreExtra.data.f frz = new com.baidu.tbadk.coreExtra.data.f();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a frF = new com.baidu.tbadk.coreExtra.data.a();
    private ac mProfileData = new ac();
    private ABTestExtraData frG = new ABTestExtraData();
    private NewGodData frK = new NewGodData();
    private w frL = new w();
    private com.baidu.tbadk.coreExtra.data.e frM = new com.baidu.tbadk.coreExtra.data.e();

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
                this.frL.W(z(jSONObject, "index_tab_info"));
                this.frt.parserJson(jSONObject.optJSONObject("version"));
                this.fru.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                com.baidu.adp.lib.stats.f.bU(jSONObject.optString("client_ip", null));
                this.frv.parserJson(jSONObject.optJSONObject("config"));
                this.fry.parserJson(jSONObject.optJSONObject("wl_config"));
                jSONObject.optJSONObject("channel_icon_config");
                String optString = jSONObject.optString("new_god_data", "");
                if (!StringUtils.isNull(optString)) {
                    this.frK.parserJson(optString);
                }
                this.frE.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.frE);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.frB = jSONObject.optInt("is_uninterest");
                this.frC = jSONObject.optInt("first_time_motivate");
                this.frD = jSONObject.optInt("needNewUserLead");
                this.frw.parserJson(jSONObject.optJSONObject("combine_download"));
                this.frx.parserJson(jSONObject.optJSONObject("mainbar"));
                this.frA = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new c().dx(jSONObject.optJSONObject("dis_adv_config"));
                WhiteListData whiteListData = new WhiteListData();
                whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
                TbSingleton.getInstance().setHostWhiteList(whiteListData);
                com.baidu.tbadk.coreExtra.data.g.U(jSONObject.optJSONArray("scheme_whitelist"));
                this.frz.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                g.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.frF.parseJson(y(jSONObject, "abtest_config"));
                this.frG.parseJson(y(jSONObject, "new_abtest_entra"));
                this.frH = z(jSONObject, "new_abtest_config");
                this.frI = z(jSONObject, "ubs_abtest_config");
                this.frJ = jSONObject.optJSONArray("windowStrategyList");
                this.frM.parserJson(y(jSONObject, "ad_density"));
                com.baidu.tbadk.core.business.b.bkP().O(this.frJ);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
                TbSingleton.getInstance().setPcdnConfigData(jSONObject.optJSONObject("pcdn_config"));
                String optString2 = jSONObject.optString("proxy_ip");
                String optString3 = jSONObject.optString("proxy_port");
                TbadkCoreApplication.getInst().setProxyIp(optString2);
                TbadkCoreApplication.getInst().setProxyPort(optString3);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private JSONObject y(JSONObject jSONObject, String str) {
        try {
            return jSONObject.optJSONObject(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private JSONArray z(JSONObject jSONObject, String str) {
        try {
            return jSONObject.optJSONArray(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public s byo() {
        return this.frv;
    }

    public String byp() {
        return this.mConfigVersion;
    }

    public CombineDownload byq() {
        return this.frw;
    }

    public VersionData byr() {
        return this.frt;
    }

    public r bys() {
        return this.fru;
    }

    public aj byt() {
        return this.fry;
    }

    public NewGodData byu() {
        return this.frK;
    }

    public com.baidu.tbadk.coreExtra.data.f byv() {
        return this.frz;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int byw() {
        return this.frB;
    }

    public boolean byx() {
        return this.frC == 1;
    }

    public int byy() {
        return this.frD;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public ac getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a byz() {
        return this.frF;
    }

    public ABTestExtraData byA() {
        return this.frG;
    }

    public JSONArray byB() {
        return this.frH;
    }

    public JSONArray byC() {
        return this.frI;
    }
}
