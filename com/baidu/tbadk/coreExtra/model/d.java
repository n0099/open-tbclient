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
    private int dPC;
    private JSONArray dPG;
    private JSONArray dPH;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int dPA = 0;
    private int dPB = 0;
    private VersionData dPt = new VersionData();
    private n dPu = new n();
    private o dPv = new o();
    private CombineDownload dPw = new CombineDownload();
    private t dPx = new t();
    private ac dPy = new ac();
    private p dPD = new p();
    private com.baidu.tbadk.coreExtra.data.e dPz = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a dPE = new com.baidu.tbadk.coreExtra.data.a();
    private v mProfileData = new v();
    private ABTestExtraData dPF = new ABTestExtraData();

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
                this.dPt.parserJson(jSONObject.optJSONObject("version"));
                this.dPu.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                com.baidu.adp.lib.stats.f.bQ(jSONObject.optString("client_ip", null));
                this.dPv.parserJson(jSONObject.optJSONObject("config"));
                this.dPy.parserJson(jSONObject.optJSONObject("wl_config"));
                this.dPD.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.dPD);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.dPB = jSONObject.optInt("is_uninterest");
                this.dPC = jSONObject.optInt("first_time_motivate");
                this.dPw.parserJson(jSONObject.optJSONObject("combine_download"));
                this.dPx.parserJson(jSONObject.optJSONObject("mainbar"));
                this.dPA = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().cA(jSONObject.optJSONObject("dis_adv_config"));
                WhiteListData whiteListData = new WhiteListData();
                whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
                TbSingleton.getInstance().setHostWhiteList(whiteListData);
                com.baidu.tbadk.coreExtra.data.f.R(jSONObject.optJSONArray("scheme_whitelist"));
                this.dPz.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.dPE.parseJson(p(jSONObject, "abtest_config"));
                this.dPF.parseJson(p(jSONObject, "new_abtest_entra"));
                this.dPG = q(jSONObject, "new_abtest_config");
                this.dPH = jSONObject.optJSONArray("windowStrategyList");
                com.baidu.tbadk.core.business.a.aIq().L(this.dPH);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private JSONObject p(JSONObject jSONObject, String str) {
        try {
            return jSONObject.optJSONObject(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private JSONArray q(JSONObject jSONObject, String str) {
        try {
            return jSONObject.optJSONArray(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public o aUn() {
        return this.dPv;
    }

    public String aUo() {
        return this.mConfigVersion;
    }

    public CombineDownload aUp() {
        return this.dPw;
    }

    public VersionData aUq() {
        return this.dPt;
    }

    public n aUr() {
        return this.dPu;
    }

    public ac aUs() {
        return this.dPy;
    }

    public com.baidu.tbadk.coreExtra.data.e aUt() {
        return this.dPz;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int aUu() {
        return this.dPB;
    }

    public boolean aUv() {
        return this.dPC == 1;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public v getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a aUw() {
        return this.dPE;
    }

    public ABTestExtraData aUx() {
        return this.dPF;
    }

    public JSONArray aUy() {
        return this.dPG;
    }
}
