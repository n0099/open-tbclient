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
    private int fac;
    private int fad;
    private JSONArray fah;
    private JSONArray fai;
    private JSONArray faj;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int faa = 0;
    private int fab = 0;
    private VersionData eZT = new VersionData();
    private r eZU = new r();
    private s eZV = new s();
    private CombineDownload eZW = new CombineDownload();
    private aa eZX = new aa();
    private aj eZY = new aj();
    private t fae = new t();
    private com.baidu.tbadk.coreExtra.data.f eZZ = new com.baidu.tbadk.coreExtra.data.f();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a faf = new com.baidu.tbadk.coreExtra.data.a();
    private ac mProfileData = new ac();
    private ABTestExtraData fag = new ABTestExtraData();
    private NewGodData fak = new NewGodData();
    private w fal = new w();
    private com.baidu.tbadk.coreExtra.data.e fam = new com.baidu.tbadk.coreExtra.data.e();

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
                this.fal.V(C(jSONObject, "index_tab_info"));
                this.eZT.parserJson(jSONObject.optJSONObject("version"));
                this.eZU.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                com.baidu.adp.lib.stats.f.bX(jSONObject.optString("client_ip", null));
                this.eZV.parserJson(jSONObject.optJSONObject("config"));
                this.eZY.parserJson(jSONObject.optJSONObject("wl_config"));
                jSONObject.optJSONObject("channel_icon_config");
                String optString = jSONObject.optString("new_god_data", "");
                if (!StringUtils.isNull(optString)) {
                    this.fak.parserJson(optString);
                }
                this.fae.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.fae);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.fab = jSONObject.optInt("is_uninterest");
                this.fac = jSONObject.optInt("first_time_motivate");
                this.fad = jSONObject.optInt("needNewUserLead");
                this.eZW.parserJson(jSONObject.optJSONObject("combine_download"));
                this.eZX.parserJson(jSONObject.optJSONObject("mainbar"));
                this.faa = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                this.eZZ.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                g.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.faf.parseJson(B(jSONObject, "abtest_config"));
                this.fag.parseJson(B(jSONObject, "new_abtest_entra"));
                this.fah = C(jSONObject, "new_abtest_config");
                this.fai = C(jSONObject, "ubs_abtest_config");
                this.faj = jSONObject.optJSONArray("windowStrategyList");
                this.fam.parserJson(B(jSONObject, "ad_density"));
                com.baidu.tbadk.core.business.a.bht().N(this.faj);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.bnH().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
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

    public s bux() {
        return this.eZV;
    }

    public String buy() {
        return this.mConfigVersion;
    }

    public CombineDownload buz() {
        return this.eZW;
    }

    public VersionData buA() {
        return this.eZT;
    }

    public r buB() {
        return this.eZU;
    }

    public aj buC() {
        return this.eZY;
    }

    public NewGodData buD() {
        return this.fak;
    }

    public com.baidu.tbadk.coreExtra.data.f buE() {
        return this.eZZ;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int buF() {
        return this.fab;
    }

    public boolean buG() {
        return this.fac == 1;
    }

    public int buH() {
        return this.fad;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public ac getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a buI() {
        return this.faf;
    }

    public ABTestExtraData buJ() {
        return this.fag;
    }

    public JSONArray buK() {
        return this.fah;
    }

    public JSONArray buL() {
        return this.fai;
    }
}
