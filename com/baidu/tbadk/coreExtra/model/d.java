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
import com.baidu.tbadk.coreExtra.data.af;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.coreExtra.data.y;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int emG;
    private int emH;
    private JSONArray emL;
    private JSONArray emM;
    private JSONArray emN;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int emE = 0;
    private int emF = 0;
    private VersionData emx = new VersionData();
    private n emy = new n();
    private o emz = new o();
    private CombineDownload emA = new CombineDownload();
    private w emB = new w();
    private af emC = new af();
    private p emI = new p();
    private com.baidu.tbadk.coreExtra.data.e emD = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a emJ = new com.baidu.tbadk.coreExtra.data.a();
    private y mProfileData = new y();
    private ABTestExtraData emK = new ABTestExtraData();
    private NewGodData emO = new NewGodData();
    private s emP = new s();

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
                this.emP.S(x(jSONObject, "index_tab_info"));
                this.emx.parserJson(jSONObject.optJSONObject("version"));
                this.emy.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                com.baidu.adp.lib.stats.f.bS(jSONObject.optString("client_ip", null));
                this.emz.parserJson(jSONObject.optJSONObject("config"));
                this.emC.parserJson(jSONObject.optJSONObject("wl_config"));
                String optString = jSONObject.optString("new_god_data", "");
                if (!StringUtils.isNull(optString)) {
                    this.emO.parserJson(optString);
                }
                this.emI.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.emI);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.emF = jSONObject.optInt("is_uninterest");
                this.emG = jSONObject.optInt("first_time_motivate");
                this.emH = jSONObject.optInt("needNewUserLead");
                this.emA.parserJson(jSONObject.optJSONObject("combine_download"));
                this.emB.parserJson(jSONObject.optJSONObject("mainbar"));
                this.emE = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().cN(jSONObject.optJSONObject("dis_adv_config"));
                WhiteListData whiteListData = new WhiteListData();
                whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
                TbSingleton.getInstance().setHostWhiteList(whiteListData);
                com.baidu.tbadk.coreExtra.data.f.Q(jSONObject.optJSONArray("scheme_whitelist"));
                this.emD.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.emJ.parseJson(w(jSONObject, "abtest_config"));
                this.emK.parseJson(w(jSONObject, "new_abtest_entra"));
                this.emL = x(jSONObject, "new_abtest_config");
                this.emM = x(jSONObject, "ubs_abtest_config");
                this.emN = jSONObject.optJSONArray("windowStrategyList");
                com.baidu.tbadk.core.business.a.aPM().K(this.emN);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
                TbSingleton.getInstance().setPcdnConfigData(jSONObject.optJSONObject("pcdn_config"));
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

    public o bcv() {
        return this.emz;
    }

    public String bcw() {
        return this.mConfigVersion;
    }

    public CombineDownload bcx() {
        return this.emA;
    }

    public VersionData bcy() {
        return this.emx;
    }

    public n bcz() {
        return this.emy;
    }

    public af bcA() {
        return this.emC;
    }

    public NewGodData bcB() {
        return this.emO;
    }

    public com.baidu.tbadk.coreExtra.data.e bcC() {
        return this.emD;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int bcD() {
        return this.emF;
    }

    public boolean bcE() {
        return this.emG == 1;
    }

    public int bcF() {
        return this.emH;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public y getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a bcG() {
        return this.emJ;
    }

    public ABTestExtraData bcH() {
        return this.emK;
    }

    public JSONArray bcI() {
        return this.emL;
    }

    public JSONArray bcJ() {
        return this.emM;
    }
}
