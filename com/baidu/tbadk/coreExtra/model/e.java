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
    private int ffT;
    private int ffU;
    private JSONArray ffY;
    private JSONArray ffZ;
    private JSONArray fga;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int ffR = 0;
    private int ffS = 0;
    private VersionData ffK = new VersionData();
    private r ffL = new r();
    private s ffM = new s();
    private CombineDownload ffN = new CombineDownload();
    private aa ffO = new aa();
    private aj ffP = new aj();
    private t ffV = new t();
    private com.baidu.tbadk.coreExtra.data.f ffQ = new com.baidu.tbadk.coreExtra.data.f();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a ffW = new com.baidu.tbadk.coreExtra.data.a();
    private ac mProfileData = new ac();
    private ABTestExtraData ffX = new ABTestExtraData();
    private NewGodData fgb = new NewGodData();
    private w fgc = new w();
    private com.baidu.tbadk.coreExtra.data.e fgd = new com.baidu.tbadk.coreExtra.data.e();

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
                this.fgc.V(C(jSONObject, "index_tab_info"));
                this.ffK.parserJson(jSONObject.optJSONObject("version"));
                this.ffL.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                com.baidu.adp.lib.stats.f.bX(jSONObject.optString("client_ip", null));
                this.ffM.parserJson(jSONObject.optJSONObject("config"));
                this.ffP.parserJson(jSONObject.optJSONObject("wl_config"));
                jSONObject.optJSONObject("channel_icon_config");
                String optString = jSONObject.optString("new_god_data", "");
                if (!StringUtils.isNull(optString)) {
                    this.fgb.parserJson(optString);
                }
                this.ffV.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.ffV);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.ffS = jSONObject.optInt("is_uninterest");
                this.ffT = jSONObject.optInt("first_time_motivate");
                this.ffU = jSONObject.optInt("needNewUserLead");
                this.ffN.parserJson(jSONObject.optJSONObject("combine_download"));
                this.ffO.parserJson(jSONObject.optJSONObject("mainbar"));
                this.ffR = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new c().dt(jSONObject.optJSONObject("dis_adv_config"));
                WhiteListData whiteListData = new WhiteListData();
                whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
                TbSingleton.getInstance().setHostWhiteList(whiteListData);
                com.baidu.tbadk.coreExtra.data.g.T(jSONObject.optJSONArray("scheme_whitelist"));
                this.ffQ.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                g.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.ffW.parseJson(B(jSONObject, "abtest_config"));
                this.ffX.parseJson(B(jSONObject, "new_abtest_entra"));
                this.ffY = C(jSONObject, "new_abtest_config");
                this.ffZ = C(jSONObject, "ubs_abtest_config");
                this.fga = jSONObject.optJSONArray("windowStrategyList");
                this.fgd.parserJson(B(jSONObject, "ad_density"));
                com.baidu.tbadk.core.business.a.bjT().N(this.fga);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
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

    public s bwX() {
        return this.ffM;
    }

    public String bwY() {
        return this.mConfigVersion;
    }

    public CombineDownload bwZ() {
        return this.ffN;
    }

    public VersionData bxa() {
        return this.ffK;
    }

    public r bxb() {
        return this.ffL;
    }

    public aj bxc() {
        return this.ffP;
    }

    public NewGodData bxd() {
        return this.fgb;
    }

    public com.baidu.tbadk.coreExtra.data.f bxe() {
        return this.ffQ;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int bxf() {
        return this.ffS;
    }

    public boolean bxg() {
        return this.ffT == 1;
    }

    public int bxh() {
        return this.ffU;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public ac getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a bxi() {
        return this.ffW;
    }

    public ABTestExtraData bxj() {
        return this.ffX;
    }

    public JSONArray bxk() {
        return this.ffY;
    }

    public JSONArray bxl() {
        return this.ffZ;
    }
}
