package com.baidu.tbadk.coreExtra.model;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
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
    private JSONArray fvA;
    private int fvt;
    private int fvu;
    private JSONArray fvy;
    private JSONArray fvz;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int fvr = 0;
    private int fvs = 0;
    private VersionData fvk = new VersionData();
    private r fvl = new r();
    private s fvm = new s();
    private CombineDownload fvn = new CombineDownload();
    private aa fvo = new aa();
    private aj fvp = new aj();
    private t fvv = new t();
    private com.baidu.tbadk.coreExtra.data.f fvq = new com.baidu.tbadk.coreExtra.data.f();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a fvw = new com.baidu.tbadk.coreExtra.data.a();
    private ac mProfileData = new ac();
    private ABTestExtraData fvx = new ABTestExtraData();
    private NewGodData fvB = new NewGodData();
    private w fvC = new w();
    private com.baidu.tbadk.coreExtra.data.e fvD = new com.baidu.tbadk.coreExtra.data.e();

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject != null) {
            try {
                this.fvC.V(y(jSONObject, "index_tab_info"));
                this.fvk.parserJson(jSONObject.optJSONObject("version"));
                this.fvl.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                com.baidu.adp.lib.stats.f.bY(jSONObject.optString("client_ip", null));
                this.fvm.parserJson(jSONObject.optJSONObject("config"));
                this.fvp.parserJson(jSONObject.optJSONObject("wl_config"));
                jSONObject.optJSONObject("channel_icon_config");
                String optString = jSONObject.optString("new_god_data", "");
                if (!StringUtils.isNull(optString)) {
                    this.fvB.parserJson(optString);
                }
                this.fvv.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.fvv);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.fvs = jSONObject.optInt("is_uninterest");
                this.fvt = jSONObject.optInt("first_time_motivate");
                this.fvu = jSONObject.optInt("needNewUserLead");
                this.fvn.parserJson(jSONObject.optJSONObject("combine_download"));
                this.fvo.parserJson(jSONObject.optJSONObject("mainbar"));
                this.fvr = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new c().dz(jSONObject.optJSONObject("dis_adv_config"));
                WhiteListData whiteListData = new WhiteListData();
                whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
                TbSingleton.getInstance().setHostWhiteList(whiteListData);
                com.baidu.tbadk.coreExtra.data.g.T(jSONObject.optJSONArray("scheme_whitelist"));
                this.fvq.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                g.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.fvw.parseJson(x(jSONObject, "abtest_config"));
                this.fvx.parseJson(x(jSONObject, "new_abtest_entra"));
                this.fvy = y(jSONObject, "new_abtest_config");
                this.fvz = y(jSONObject, "ubs_abtest_config");
                this.fvA = jSONObject.optJSONArray("windowStrategyList");
                this.fvD.parserJson(x(jSONObject, "ad_density"));
                com.baidu.tbadk.core.business.b.blj().N(this.fvA);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
                TbSingleton.getInstance().setPcdnConfigData(jSONObject.optJSONObject("pcdn_config"));
                JSONArray y = y(jSONObject, "offpack");
                if (y != null && y.length() > 0 && (jSONObject2 = y.getJSONObject(0)) != null) {
                    com.baidu.tieba.quickWebView.data.b bVar = new com.baidu.tieba.quickWebView.data.b();
                    bVar.Rp(jSONObject2.optString("mod_name"));
                    bVar.xz(jSONObject2.optInt("upload_offline_web_cache") == 1);
                    bVar.setClear(jSONObject2.optInt("clear_offline_web_cache") == 1);
                    if (!TextUtils.isEmpty(bVar.getModName())) {
                        TbSingleton.getInstance().setUploadAndClearModule(bVar);
                    }
                }
                String optString2 = jSONObject.optString("proxy_ip");
                String optString3 = jSONObject.optString("proxy_port");
                TbadkCoreApplication.getInst().setProxyIp(optString2);
                TbadkCoreApplication.getInst().setProxyPort(optString3);
                MessageManager.getInstance().runTask(2016552, null, jSONObject.optString("ad_sdk_priority"));
                JSONObject optJSONObject2 = jSONObject.optJSONObject(LowFlowsActivityConfig.LF_USER_INFO);
                if (optJSONObject2 != null) {
                    String optString4 = optJSONObject2.optString(LowFlowsActivityConfig.LF_USER);
                    TbSingleton.getInstance().setLFUser(optString4);
                    if (!StringUtils.isNull(optString4) && "2".equals(optString4)) {
                        TbSingleton.getInstance().setLFUserTaskId(optJSONObject2.optString(LowFlowsActivityConfig.LF_USER_TASKID));
                        TbSingleton.getInstance().setBannerText(optJSONObject2.optString(LowFlowsActivityConfig.LF_BANNER_TEXT));
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    private JSONObject x(JSONObject jSONObject, String str) {
        try {
            return jSONObject.optJSONObject(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    private JSONArray y(JSONObject jSONObject, String str) {
        try {
            return jSONObject.optJSONArray(str);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return null;
        }
    }

    public s byJ() {
        return this.fvm;
    }

    public String byK() {
        return this.mConfigVersion;
    }

    public CombineDownload byL() {
        return this.fvn;
    }

    public VersionData byM() {
        return this.fvk;
    }

    public r byN() {
        return this.fvl;
    }

    public aj byO() {
        return this.fvp;
    }

    public NewGodData byP() {
        return this.fvB;
    }

    public com.baidu.tbadk.coreExtra.data.f byQ() {
        return this.fvq;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int byR() {
        return this.fvs;
    }

    public boolean byS() {
        return this.fvt == 1;
    }

    public int byT() {
        return this.fvu;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public ac getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a byU() {
        return this.fvw;
    }

    public ABTestExtraData byV() {
        return this.fvx;
    }

    public JSONArray byW() {
        return this.fvy;
    }

    public JSONArray byX() {
        return this.fvz;
    }
}
