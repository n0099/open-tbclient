package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
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
    private JSONArray dpA;
    private JSONArray dpB;
    private int dpw;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int dpu = 0;
    private int dpv = 0;
    private VersionData dpn = new VersionData();
    private n dpo = new n();
    private o dpp = new o();
    private CombineDownload dpq = new CombineDownload();
    private t dpr = new t();
    private ac dps = new ac();
    private p dpx = new p();
    private com.baidu.tbadk.coreExtra.data.e dpt = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a dpy = new com.baidu.tbadk.coreExtra.data.a();
    private v mProfileData = new v();
    private ABTestExtraData dpz = new ABTestExtraData();

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
                this.dpn.parserJson(jSONObject.optJSONObject("version"));
                this.dpo.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                com.baidu.adp.lib.stats.f.aB(jSONObject.optString("client_ip", null));
                this.dpp.parserJson(jSONObject.optJSONObject("config"));
                this.dps.parserJson(jSONObject.optJSONObject("wl_config"));
                this.dpx.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.dpx);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.dpv = jSONObject.optInt("is_uninterest");
                this.dpw = jSONObject.optInt("first_time_motivate");
                this.dpq.parserJson(jSONObject.optJSONObject("combine_download"));
                this.dpr.parserJson(jSONObject.optJSONObject("mainbar"));
                this.dpu = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().cp(jSONObject.optJSONObject("dis_adv_config"));
                WhiteListData whiteListData = new WhiteListData();
                whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
                TbSingleton.getInstance().setHostWhiteList(whiteListData);
                com.baidu.tbadk.coreExtra.data.f.Q(jSONObject.optJSONArray("scheme_whitelist"));
                this.dpt.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.dpy.parseJson(o(jSONObject, "abtest_config"));
                this.dpz.parseJson(o(jSONObject, "new_abtest_entra"));
                this.dpA = p(jSONObject, "new_abtest_config");
                this.dpB = jSONObject.optJSONArray("windowStrategyList");
                com.baidu.tbadk.core.business.a.aAa().K(this.dpB);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private JSONObject o(JSONObject jSONObject, String str) {
        try {
            return jSONObject.optJSONObject(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private JSONArray p(JSONObject jSONObject, String str) {
        try {
            return jSONObject.optJSONArray(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public o aLM() {
        return this.dpp;
    }

    public String aLN() {
        return this.mConfigVersion;
    }

    public CombineDownload aLO() {
        return this.dpq;
    }

    public VersionData aLP() {
        return this.dpn;
    }

    public n aLQ() {
        return this.dpo;
    }

    public ac aLR() {
        return this.dps;
    }

    public com.baidu.tbadk.coreExtra.data.e aLS() {
        return this.dpt;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int aLT() {
        return this.dpv;
    }

    public boolean aLU() {
        return this.dpw == 1;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public v getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a aLV() {
        return this.dpy;
    }

    public ABTestExtraData aLW() {
        return this.dpz;
    }

    public JSONArray aLX() {
        return this.dpA;
    }
}
