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
    private int fwl;
    private int fwm;
    private JSONArray fwq;
    private JSONArray fwr;
    private JSONArray fws;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int fwj = 0;
    private int fwk = 0;
    private VersionData fwc = new VersionData();
    private r fwd = new r();
    private s fwe = new s();
    private CombineDownload fwf = new CombineDownload();
    private aa fwg = new aa();
    private aj fwh = new aj();
    private t fwn = new t();
    private com.baidu.tbadk.coreExtra.data.f fwi = new com.baidu.tbadk.coreExtra.data.f();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a fwo = new com.baidu.tbadk.coreExtra.data.a();
    private ac mProfileData = new ac();
    private ABTestExtraData fwp = new ABTestExtraData();
    private NewGodData fwt = new NewGodData();
    private w fwu = new w();
    private com.baidu.tbadk.coreExtra.data.e fwv = new com.baidu.tbadk.coreExtra.data.e();

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
                this.fwu.W(z(jSONObject, "index_tab_info"));
                this.fwc.parserJson(jSONObject.optJSONObject("version"));
                this.fwd.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                com.baidu.adp.lib.stats.f.bU(jSONObject.optString("client_ip", null));
                this.fwe.parserJson(jSONObject.optJSONObject("config"));
                this.fwh.parserJson(jSONObject.optJSONObject("wl_config"));
                jSONObject.optJSONObject("channel_icon_config");
                String optString = jSONObject.optString("new_god_data", "");
                if (!StringUtils.isNull(optString)) {
                    this.fwt.parserJson(optString);
                }
                this.fwn.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.fwn);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.fwk = jSONObject.optInt("is_uninterest");
                this.fwl = jSONObject.optInt("first_time_motivate");
                this.fwm = jSONObject.optInt("needNewUserLead");
                this.fwf.parserJson(jSONObject.optJSONObject("combine_download"));
                this.fwg.parserJson(jSONObject.optJSONObject("mainbar"));
                this.fwj = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new c().dx(jSONObject.optJSONObject("dis_adv_config"));
                WhiteListData whiteListData = new WhiteListData();
                whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
                TbSingleton.getInstance().setHostWhiteList(whiteListData);
                com.baidu.tbadk.coreExtra.data.g.U(jSONObject.optJSONArray("scheme_whitelist"));
                this.fwi.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                g.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.fwo.parseJson(y(jSONObject, "abtest_config"));
                this.fwp.parseJson(y(jSONObject, "new_abtest_entra"));
                this.fwq = z(jSONObject, "new_abtest_config");
                this.fwr = z(jSONObject, "ubs_abtest_config");
                this.fws = jSONObject.optJSONArray("windowStrategyList");
                this.fwv.parserJson(y(jSONObject, "ad_density"));
                com.baidu.tbadk.core.business.b.boJ().O(this.fws);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.bvr().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
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

    public s bCi() {
        return this.fwe;
    }

    public String bCj() {
        return this.mConfigVersion;
    }

    public CombineDownload bCk() {
        return this.fwf;
    }

    public VersionData bCl() {
        return this.fwc;
    }

    public r bCm() {
        return this.fwd;
    }

    public aj bCn() {
        return this.fwh;
    }

    public NewGodData bCo() {
        return this.fwt;
    }

    public com.baidu.tbadk.coreExtra.data.f bCp() {
        return this.fwi;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int bCq() {
        return this.fwk;
    }

    public boolean bCr() {
        return this.fwl == 1;
    }

    public int bCs() {
        return this.fwm;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public ac getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a bCt() {
        return this.fwo;
    }

    public ABTestExtraData bCu() {
        return this.fwp;
    }

    public JSONArray bCv() {
        return this.fwq;
    }

    public JSONArray bCw() {
        return this.fwr;
    }
}
