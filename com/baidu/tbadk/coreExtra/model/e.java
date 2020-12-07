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
    private int fmB;
    private int fmC;
    private JSONArray fmG;
    private JSONArray fmH;
    private JSONArray fmI;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int fmz = 0;
    private int fmA = 0;
    private VersionData fms = new VersionData();
    private r fmt = new r();
    private s fmu = new s();
    private CombineDownload fmv = new CombineDownload();
    private aa fmw = new aa();
    private aj fmx = new aj();
    private t fmD = new t();
    private com.baidu.tbadk.coreExtra.data.f fmy = new com.baidu.tbadk.coreExtra.data.f();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a fmE = new com.baidu.tbadk.coreExtra.data.a();
    private ac mProfileData = new ac();
    private ABTestExtraData fmF = new ABTestExtraData();
    private NewGodData fmJ = new NewGodData();
    private w fmK = new w();
    private com.baidu.tbadk.coreExtra.data.e fmL = new com.baidu.tbadk.coreExtra.data.e();

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
                this.fmK.W(z(jSONObject, "index_tab_info"));
                this.fms.parserJson(jSONObject.optJSONObject("version"));
                this.fmt.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                com.baidu.adp.lib.stats.f.ca(jSONObject.optString("client_ip", null));
                this.fmu.parserJson(jSONObject.optJSONObject("config"));
                this.fmx.parserJson(jSONObject.optJSONObject("wl_config"));
                jSONObject.optJSONObject("channel_icon_config");
                String optString = jSONObject.optString("new_god_data", "");
                if (!StringUtils.isNull(optString)) {
                    this.fmJ.parserJson(optString);
                }
                this.fmD.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.fmD);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.fmA = jSONObject.optInt("is_uninterest");
                this.fmB = jSONObject.optInt("first_time_motivate");
                this.fmC = jSONObject.optInt("needNewUserLead");
                this.fmv.parserJson(jSONObject.optJSONObject("combine_download"));
                this.fmw.parserJson(jSONObject.optJSONObject("mainbar"));
                this.fmz = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new c().m37do(jSONObject.optJSONObject("dis_adv_config"));
                WhiteListData whiteListData = new WhiteListData();
                whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
                TbSingleton.getInstance().setHostWhiteList(whiteListData);
                com.baidu.tbadk.coreExtra.data.g.U(jSONObject.optJSONArray("scheme_whitelist"));
                this.fmy.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                g.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.fmE.parseJson(y(jSONObject, "abtest_config"));
                this.fmF.parseJson(y(jSONObject, "new_abtest_entra"));
                this.fmG = z(jSONObject, "new_abtest_config");
                this.fmH = z(jSONObject, "ubs_abtest_config");
                this.fmI = jSONObject.optJSONArray("windowStrategyList");
                this.fmL.parserJson(y(jSONObject, "ad_density"));
                com.baidu.tbadk.core.business.a.bmh().O(this.fmI);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
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

    public s bzN() {
        return this.fmu;
    }

    public String bzO() {
        return this.mConfigVersion;
    }

    public CombineDownload bzP() {
        return this.fmv;
    }

    public VersionData bzQ() {
        return this.fms;
    }

    public r bzR() {
        return this.fmt;
    }

    public aj bzS() {
        return this.fmx;
    }

    public NewGodData bzT() {
        return this.fmJ;
    }

    public com.baidu.tbadk.coreExtra.data.f bzU() {
        return this.fmy;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int bzV() {
        return this.fmA;
    }

    public boolean bzW() {
        return this.fmB == 1;
    }

    public int bzX() {
        return this.fmC;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public ac getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a bzY() {
        return this.fmE;
    }

    public ABTestExtraData bzZ() {
        return this.fmF;
    }

    public JSONArray bAa() {
        return this.fmG;
    }

    public JSONArray bAb() {
        return this.fmH;
    }
}
