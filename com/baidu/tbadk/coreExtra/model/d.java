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
import com.baidu.tbadk.coreExtra.data.ac;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.coreExtra.data.v;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int edY;
    private int edZ;
    private JSONArray eed;
    private JSONArray eee;
    private JSONArray eef;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int edW = 0;
    private int edX = 0;
    private VersionData edP = new VersionData();
    private n edQ = new n();
    private o edR = new o();
    private CombineDownload edS = new CombineDownload();
    private t edT = new t();
    private ac edU = new ac();
    private p eea = new p();
    private com.baidu.tbadk.coreExtra.data.e edV = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a eeb = new com.baidu.tbadk.coreExtra.data.a();
    private v mProfileData = new v();
    private ABTestExtraData eec = new ABTestExtraData();
    private NewGodData eeg = new NewGodData();

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
                this.edP.parserJson(jSONObject.optJSONObject("version"));
                this.edQ.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                com.baidu.adp.lib.stats.f.bR(jSONObject.optString("client_ip", null));
                this.edR.parserJson(jSONObject.optJSONObject("config"));
                this.edU.parserJson(jSONObject.optJSONObject("wl_config"));
                String optString = jSONObject.optString("new_god_data", "");
                if (!StringUtils.isNull(optString)) {
                    this.eeg.parserJson(optString);
                }
                this.eea.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.eea);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.edX = jSONObject.optInt("is_uninterest");
                this.edY = jSONObject.optInt("first_time_motivate");
                this.edZ = jSONObject.optInt("needNewUserLead");
                this.edS.parserJson(jSONObject.optJSONObject("combine_download"));
                this.edT.parserJson(jSONObject.optJSONObject("mainbar"));
                this.edW = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().cG(jSONObject.optJSONObject("dis_adv_config"));
                WhiteListData whiteListData = new WhiteListData();
                whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
                TbSingleton.getInstance().setHostWhiteList(whiteListData);
                com.baidu.tbadk.coreExtra.data.f.Q(jSONObject.optJSONArray("scheme_whitelist"));
                this.edV.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.eeb.parseJson(w(jSONObject, "abtest_config"));
                this.eec.parseJson(w(jSONObject, "new_abtest_entra"));
                this.eed = x(jSONObject, "new_abtest_config");
                this.eee = x(jSONObject, "ubs_abtest_config");
                this.eef = jSONObject.optJSONArray("windowStrategyList");
                com.baidu.tbadk.core.business.a.aOc().K(this.eef);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private JSONObject w(JSONObject jSONObject, String str) {
        try {
            return jSONObject.optJSONObject(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private JSONArray x(JSONObject jSONObject, String str) {
        try {
            return jSONObject.optJSONArray(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public o bas() {
        return this.edR;
    }

    public String bat() {
        return this.mConfigVersion;
    }

    public CombineDownload bau() {
        return this.edS;
    }

    public VersionData bav() {
        return this.edP;
    }

    public n baw() {
        return this.edQ;
    }

    public ac bax() {
        return this.edU;
    }

    public NewGodData bay() {
        return this.eeg;
    }

    public com.baidu.tbadk.coreExtra.data.e baz() {
        return this.edV;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int baA() {
        return this.edX;
    }

    public boolean baB() {
        return this.edY == 1;
    }

    public int baC() {
        return this.edZ;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public v getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a baD() {
        return this.eeb;
    }

    public ABTestExtraData baE() {
        return this.eec;
    }

    public JSONArray baF() {
        return this.eed;
    }

    public JSONArray baG() {
        return this.eee;
    }
}
