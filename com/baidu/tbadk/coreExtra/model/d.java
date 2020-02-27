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
    private int dpi;
    private JSONArray dpm;
    private JSONArray dpn;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int dpg = 0;
    private int dph = 0;
    private VersionData doZ = new VersionData();
    private n dpa = new n();
    private o dpb = new o();
    private CombineDownload dpc = new CombineDownload();
    private t dpd = new t();
    private ac dpe = new ac();
    private p dpj = new p();
    private com.baidu.tbadk.coreExtra.data.e dpf = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a dpk = new com.baidu.tbadk.coreExtra.data.a();
    private v mProfileData = new v();
    private ABTestExtraData dpl = new ABTestExtraData();

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
                this.doZ.parserJson(jSONObject.optJSONObject("version"));
                this.dpa.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                com.baidu.adp.lib.stats.f.aB(jSONObject.optString("client_ip", null));
                this.dpb.parserJson(jSONObject.optJSONObject("config"));
                this.dpe.parserJson(jSONObject.optJSONObject("wl_config"));
                this.dpj.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.dpj);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.dph = jSONObject.optInt("is_uninterest");
                this.dpi = jSONObject.optInt("first_time_motivate");
                this.dpc.parserJson(jSONObject.optJSONObject("combine_download"));
                this.dpd.parserJson(jSONObject.optJSONObject("mainbar"));
                this.dpg = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                this.dpf.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.dpk.parseJson(o(jSONObject, "abtest_config"));
                this.dpl.parseJson(o(jSONObject, "new_abtest_entra"));
                this.dpm = p(jSONObject, "new_abtest_config");
                this.dpn = jSONObject.optJSONArray("windowStrategyList");
                com.baidu.tbadk.core.business.a.azY().K(this.dpn);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.aFB().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
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

    public o aLJ() {
        return this.dpb;
    }

    public String aLK() {
        return this.mConfigVersion;
    }

    public CombineDownload aLL() {
        return this.dpc;
    }

    public VersionData aLM() {
        return this.doZ;
    }

    public n aLN() {
        return this.dpa;
    }

    public ac aLO() {
        return this.dpe;
    }

    public com.baidu.tbadk.coreExtra.data.e aLP() {
        return this.dpf;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int aLQ() {
        return this.dph;
    }

    public boolean aLR() {
        return this.dpi == 1;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public v getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a aLS() {
        return this.dpk;
    }

    public ABTestExtraData aLT() {
        return this.dpl;
    }

    public JSONArray aLU() {
        return this.dpm;
    }
}
