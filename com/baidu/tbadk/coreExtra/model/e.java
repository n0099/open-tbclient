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
    private int eFA;
    private JSONArray eFE;
    private JSONArray eFF;
    private JSONArray eFG;
    private int eFz;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int eFx = 0;
    private int eFy = 0;
    private VersionData eFq = new VersionData();
    private r eFr = new r();
    private s eFs = new s();
    private CombineDownload eFt = new CombineDownload();
    private aa eFu = new aa();
    private aj eFv = new aj();
    private t eFB = new t();
    private com.baidu.tbadk.coreExtra.data.f eFw = new com.baidu.tbadk.coreExtra.data.f();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a eFC = new com.baidu.tbadk.coreExtra.data.a();
    private ac mProfileData = new ac();
    private ABTestExtraData eFD = new ABTestExtraData();
    private NewGodData eFH = new NewGodData();
    private w eFI = new w();
    private com.baidu.tbadk.coreExtra.data.e eFJ = new com.baidu.tbadk.coreExtra.data.e();

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
                this.eFI.V(C(jSONObject, "index_tab_info"));
                this.eFq.parserJson(jSONObject.optJSONObject("version"));
                this.eFr.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                com.baidu.adp.lib.stats.f.bX(jSONObject.optString("client_ip", null));
                this.eFs.parserJson(jSONObject.optJSONObject("config"));
                this.eFv.parserJson(jSONObject.optJSONObject("wl_config"));
                jSONObject.optJSONObject("channel_icon_config");
                String optString = jSONObject.optString("new_god_data", "");
                if (!StringUtils.isNull(optString)) {
                    this.eFH.parserJson(optString);
                }
                this.eFB.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.eFB);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.eFy = jSONObject.optInt("is_uninterest");
                this.eFz = jSONObject.optInt("first_time_motivate");
                this.eFA = jSONObject.optInt("needNewUserLead");
                this.eFt.parserJson(jSONObject.optJSONObject("combine_download"));
                this.eFu.parserJson(jSONObject.optJSONObject("mainbar"));
                this.eFx = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new c().dd(jSONObject.optJSONObject("dis_adv_config"));
                WhiteListData whiteListData = new WhiteListData();
                whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
                TbSingleton.getInstance().setHostWhiteList(whiteListData);
                com.baidu.tbadk.coreExtra.data.g.T(jSONObject.optJSONArray("scheme_whitelist"));
                this.eFw.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                g.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.eFC.parseJson(B(jSONObject, "abtest_config"));
                this.eFD.parseJson(B(jSONObject, "new_abtest_entra"));
                this.eFE = C(jSONObject, "new_abtest_config");
                this.eFF = C(jSONObject, "ubs_abtest_config");
                this.eFG = jSONObject.optJSONArray("windowStrategyList");
                this.eFJ.parserJson(B(jSONObject, "ad_density"));
                com.baidu.tbadk.core.business.a.bcS().N(this.eFG);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
                TbSingleton.getInstance().setPcdnConfigData(jSONObject.optJSONObject("pcdn_config"));
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

    public s bpU() {
        return this.eFs;
    }

    public String bpV() {
        return this.mConfigVersion;
    }

    public CombineDownload bpW() {
        return this.eFt;
    }

    public VersionData bpX() {
        return this.eFq;
    }

    public r bpY() {
        return this.eFr;
    }

    public aj bpZ() {
        return this.eFv;
    }

    public NewGodData bqa() {
        return this.eFH;
    }

    public com.baidu.tbadk.coreExtra.data.f bqb() {
        return this.eFw;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int bqc() {
        return this.eFy;
    }

    public boolean bqd() {
        return this.eFz == 1;
    }

    public int bqe() {
        return this.eFA;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public ac getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a bqf() {
        return this.eFC;
    }

    public ABTestExtraData bqg() {
        return this.eFD;
    }

    public JSONArray bqh() {
        return this.eFE;
    }

    public JSONArray bqi() {
        return this.eFF;
    }
}
