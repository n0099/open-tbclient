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
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tbadk.coreExtra.data.ai;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.coreExtra.data.z;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private JSONArray eDA;
    private JSONArray eDB;
    private int eDu;
    private int eDv;
    private JSONArray eDz;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int eDs = 0;
    private int eDt = 0;
    private VersionData eDl = new VersionData();
    private q eDm = new q();
    private r eDn = new r();
    private CombineDownload eDo = new CombineDownload();
    private z eDp = new z();
    private ai eDq = new ai();
    private s eDw = new s();
    private com.baidu.tbadk.coreExtra.data.e eDr = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a eDx = new com.baidu.tbadk.coreExtra.data.a();
    private ab mProfileData = new ab();
    private ABTestExtraData eDy = new ABTestExtraData();
    private NewGodData eDC = new NewGodData();
    private v eDD = new v();

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
                this.eDD.V(C(jSONObject, "index_tab_info"));
                this.eDl.parserJson(jSONObject.optJSONObject("version"));
                this.eDm.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                com.baidu.adp.lib.stats.f.bV(jSONObject.optString("client_ip", null));
                this.eDn.parserJson(jSONObject.optJSONObject("config"));
                this.eDq.parserJson(jSONObject.optJSONObject("wl_config"));
                jSONObject.optJSONObject("channel_icon_config");
                String optString = jSONObject.optString("new_god_data", "");
                if (!StringUtils.isNull(optString)) {
                    this.eDC.parserJson(optString);
                }
                this.eDw.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.eDw);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.eDt = jSONObject.optInt("is_uninterest");
                this.eDu = jSONObject.optInt("first_time_motivate");
                this.eDv = jSONObject.optInt("needNewUserLead");
                this.eDo.parserJson(jSONObject.optJSONObject("combine_download"));
                this.eDp.parserJson(jSONObject.optJSONObject("mainbar"));
                this.eDs = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new c().da(jSONObject.optJSONObject("dis_adv_config"));
                WhiteListData whiteListData = new WhiteListData();
                whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
                TbSingleton.getInstance().setHostWhiteList(whiteListData);
                com.baidu.tbadk.coreExtra.data.f.T(jSONObject.optJSONArray("scheme_whitelist"));
                this.eDr.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                g.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.eDx.parseJson(B(jSONObject, "abtest_config"));
                this.eDy.parseJson(B(jSONObject, "new_abtest_entra"));
                this.eDz = C(jSONObject, "new_abtest_config");
                this.eDA = C(jSONObject, "ubs_abtest_config");
                this.eDB = jSONObject.optJSONArray("windowStrategyList");
                com.baidu.tbadk.core.business.a.bbY().N(this.eDB);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
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

    public r bpa() {
        return this.eDn;
    }

    public String bpb() {
        return this.mConfigVersion;
    }

    public CombineDownload bpc() {
        return this.eDo;
    }

    public VersionData bpd() {
        return this.eDl;
    }

    public q bpe() {
        return this.eDm;
    }

    public ai bpf() {
        return this.eDq;
    }

    public NewGodData bpg() {
        return this.eDC;
    }

    public com.baidu.tbadk.coreExtra.data.e bph() {
        return this.eDr;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int bpi() {
        return this.eDt;
    }

    public boolean bpj() {
        return this.eDu == 1;
    }

    public int bpk() {
        return this.eDv;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public ab getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a bpl() {
        return this.eDx;
    }

    public ABTestExtraData bpm() {
        return this.eDy;
    }

    public JSONArray bpn() {
        return this.eDz;
    }

    public JSONArray bpo() {
        return this.eDA;
    }
}
