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
    private int ftU;
    private int ftV;
    private JSONArray ftZ;
    private JSONArray fua;
    private JSONArray fub;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int ftS = 0;
    private int ftT = 0;
    private VersionData ftL = new VersionData();
    private r ftM = new r();
    private s ftN = new s();
    private CombineDownload ftO = new CombineDownload();
    private aa ftP = new aa();
    private aj ftQ = new aj();
    private t ftW = new t();
    private com.baidu.tbadk.coreExtra.data.f ftR = new com.baidu.tbadk.coreExtra.data.f();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a ftX = new com.baidu.tbadk.coreExtra.data.a();
    private ac mProfileData = new ac();
    private ABTestExtraData ftY = new ABTestExtraData();
    private NewGodData fuc = new NewGodData();
    private w fud = new w();
    private com.baidu.tbadk.coreExtra.data.e fue = new com.baidu.tbadk.coreExtra.data.e();

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
                this.fud.V(y(jSONObject, "index_tab_info"));
                this.ftL.parserJson(jSONObject.optJSONObject("version"));
                this.ftM.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                com.baidu.adp.lib.stats.f.bU(jSONObject.optString("client_ip", null));
                this.ftN.parserJson(jSONObject.optJSONObject("config"));
                this.ftQ.parserJson(jSONObject.optJSONObject("wl_config"));
                jSONObject.optJSONObject("channel_icon_config");
                String optString = jSONObject.optString("new_god_data", "");
                if (!StringUtils.isNull(optString)) {
                    this.fuc.parserJson(optString);
                }
                this.ftW.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.ftW);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.ftT = jSONObject.optInt("is_uninterest");
                this.ftU = jSONObject.optInt("first_time_motivate");
                this.ftV = jSONObject.optInt("needNewUserLead");
                this.ftO.parserJson(jSONObject.optJSONObject("combine_download"));
                this.ftP.parserJson(jSONObject.optJSONObject("mainbar"));
                this.ftS = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                com.baidu.tbadk.coreExtra.data.g.T(jSONObject.optJSONArray("scheme_whitelist"));
                this.ftR.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                g.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.ftX.parseJson(x(jSONObject, "abtest_config"));
                this.ftY.parseJson(x(jSONObject, "new_abtest_entra"));
                this.ftZ = y(jSONObject, "new_abtest_config");
                this.fua = y(jSONObject, "ubs_abtest_config");
                this.fub = jSONObject.optJSONArray("windowStrategyList");
                this.fue.parserJson(x(jSONObject, "ad_density"));
                com.baidu.tbadk.core.business.b.blh().N(this.fub);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
                TbSingleton.getInstance().setPcdnConfigData(jSONObject.optJSONObject("pcdn_config"));
                JSONArray y = y(jSONObject, "offpack");
                if (y != null && y.length() > 0 && (jSONObject2 = y.getJSONObject(0)) != null) {
                    com.baidu.tieba.quickWebView.data.b bVar = new com.baidu.tieba.quickWebView.data.b();
                    bVar.Ri(jSONObject2.optString("mod_name"));
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

    public s byG() {
        return this.ftN;
    }

    public String byH() {
        return this.mConfigVersion;
    }

    public CombineDownload byI() {
        return this.ftO;
    }

    public VersionData byJ() {
        return this.ftL;
    }

    public r byK() {
        return this.ftM;
    }

    public aj byL() {
        return this.ftQ;
    }

    public NewGodData byM() {
        return this.fuc;
    }

    public com.baidu.tbadk.coreExtra.data.f byN() {
        return this.ftR;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int byO() {
        return this.ftT;
    }

    public boolean byP() {
        return this.ftU == 1;
    }

    public int byQ() {
        return this.ftV;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public ac getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a byR() {
        return this.ftX;
    }

    public ABTestExtraData byS() {
        return this.ftY;
    }

    public JSONArray byT() {
        return this.ftZ;
    }

    public JSONArray byU() {
        return this.fua;
    }
}
