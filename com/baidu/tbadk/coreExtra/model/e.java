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
    private int ffb;
    private int ffc;
    private JSONArray ffg;
    private JSONArray ffh;
    private JSONArray ffi;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int feZ = 0;
    private int ffa = 0;
    private VersionData feS = new VersionData();
    private r feT = new r();
    private s feU = new s();
    private CombineDownload feV = new CombineDownload();
    private aa feW = new aa();
    private aj feX = new aj();
    private t ffd = new t();
    private com.baidu.tbadk.coreExtra.data.f feY = new com.baidu.tbadk.coreExtra.data.f();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a ffe = new com.baidu.tbadk.coreExtra.data.a();
    private ac mProfileData = new ac();
    private ABTestExtraData fff = new ABTestExtraData();
    private NewGodData ffj = new NewGodData();
    private w ffk = new w();
    private com.baidu.tbadk.coreExtra.data.e ffl = new com.baidu.tbadk.coreExtra.data.e();

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
                this.ffk.V(z(jSONObject, "index_tab_info"));
                this.feS.parserJson(jSONObject.optJSONObject("version"));
                this.feT.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                com.baidu.adp.lib.stats.f.bX(jSONObject.optString("client_ip", null));
                this.feU.parserJson(jSONObject.optJSONObject("config"));
                this.feX.parserJson(jSONObject.optJSONObject("wl_config"));
                jSONObject.optJSONObject("channel_icon_config");
                String optString = jSONObject.optString("new_god_data", "");
                if (!StringUtils.isNull(optString)) {
                    this.ffj.parserJson(optString);
                }
                this.ffd.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.ffd);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.ffa = jSONObject.optInt("is_uninterest");
                this.ffb = jSONObject.optInt("first_time_motivate");
                this.ffc = jSONObject.optInt("needNewUserLead");
                this.feV.parserJson(jSONObject.optJSONObject("combine_download"));
                this.feW.parserJson(jSONObject.optJSONObject("mainbar"));
                this.feZ = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new c().dn(jSONObject.optJSONObject("dis_adv_config"));
                WhiteListData whiteListData = new WhiteListData();
                whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
                TbSingleton.getInstance().setHostWhiteList(whiteListData);
                com.baidu.tbadk.coreExtra.data.g.T(jSONObject.optJSONArray("scheme_whitelist"));
                this.feY.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                g.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.ffe.parseJson(y(jSONObject, "abtest_config"));
                this.fff.parseJson(y(jSONObject, "new_abtest_entra"));
                this.ffg = z(jSONObject, "new_abtest_config");
                this.ffh = z(jSONObject, "ubs_abtest_config");
                this.ffi = jSONObject.optJSONArray("windowStrategyList");
                this.ffl.parserJson(y(jSONObject, "ad_density"));
                com.baidu.tbadk.core.business.a.biX().N(this.ffi);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
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

    public s bwn() {
        return this.feU;
    }

    public String bwo() {
        return this.mConfigVersion;
    }

    public CombineDownload bwp() {
        return this.feV;
    }

    public VersionData bwq() {
        return this.feS;
    }

    public r bwr() {
        return this.feT;
    }

    public aj bws() {
        return this.feX;
    }

    public NewGodData bwt() {
        return this.ffj;
    }

    public com.baidu.tbadk.coreExtra.data.f bwu() {
        return this.feY;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int bwv() {
        return this.ffa;
    }

    public boolean bww() {
        return this.ffb == 1;
    }

    public int bwx() {
        return this.ffc;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public ac getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a bwy() {
        return this.ffe;
    }

    public ABTestExtraData bwz() {
        return this.fff;
    }

    public JSONArray bwA() {
        return this.ffg;
    }

    public JSONArray bwB() {
        return this.ffh;
    }
}
