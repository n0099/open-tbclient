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
    private int dPH;
    private JSONArray dPL;
    private JSONArray dPM;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int dPF = 0;
    private int dPG = 0;
    private VersionData dPy = new VersionData();
    private n dPz = new n();
    private o dPA = new o();
    private CombineDownload dPB = new CombineDownload();
    private t dPC = new t();
    private ac dPD = new ac();
    private p dPI = new p();
    private com.baidu.tbadk.coreExtra.data.e dPE = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a dPJ = new com.baidu.tbadk.coreExtra.data.a();
    private v mProfileData = new v();
    private ABTestExtraData dPK = new ABTestExtraData();

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
                this.dPy.parserJson(jSONObject.optJSONObject("version"));
                this.dPz.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                com.baidu.adp.lib.stats.f.bQ(jSONObject.optString("client_ip", null));
                this.dPA.parserJson(jSONObject.optJSONObject("config"));
                this.dPD.parserJson(jSONObject.optJSONObject("wl_config"));
                this.dPI.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.dPI);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.dPG = jSONObject.optInt("is_uninterest");
                this.dPH = jSONObject.optInt("first_time_motivate");
                this.dPB.parserJson(jSONObject.optJSONObject("combine_download"));
                this.dPC.parserJson(jSONObject.optJSONObject("mainbar"));
                this.dPF = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                this.dPE.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.dPJ.parseJson(p(jSONObject, "abtest_config"));
                this.dPK.parseJson(p(jSONObject, "new_abtest_entra"));
                this.dPL = q(jSONObject, "new_abtest_config");
                this.dPM = jSONObject.optJSONArray("windowStrategyList");
                com.baidu.tbadk.core.business.a.aIo().L(this.dPM);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
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

    public o aUl() {
        return this.dPA;
    }

    public String aUm() {
        return this.mConfigVersion;
    }

    public CombineDownload aUn() {
        return this.dPB;
    }

    public VersionData aUo() {
        return this.dPy;
    }

    public n aUp() {
        return this.dPz;
    }

    public ac aUq() {
        return this.dPD;
    }

    public com.baidu.tbadk.coreExtra.data.e aUr() {
        return this.dPE;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int aUs() {
        return this.dPG;
    }

    public boolean aUt() {
        return this.dPH == 1;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public v getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a aUu() {
        return this.dPJ;
    }

    public ABTestExtraData aUv() {
        return this.dPK;
    }

    public JSONArray aUw() {
        return this.dPL;
    }
}
