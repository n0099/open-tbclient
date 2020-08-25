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
/* loaded from: classes2.dex */
public class e {
    private int eDq;
    private int eDr;
    private JSONArray eDv;
    private JSONArray eDw;
    private JSONArray eDx;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int eDo = 0;
    private int eDp = 0;
    private VersionData eDh = new VersionData();
    private q eDi = new q();
    private r eDj = new r();
    private CombineDownload eDk = new CombineDownload();
    private z eDl = new z();
    private ai eDm = new ai();
    private s eDs = new s();
    private com.baidu.tbadk.coreExtra.data.e eDn = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a eDt = new com.baidu.tbadk.coreExtra.data.a();
    private ab mProfileData = new ab();
    private ABTestExtraData eDu = new ABTestExtraData();
    private NewGodData eDy = new NewGodData();
    private v eDz = new v();

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
                this.eDz.V(C(jSONObject, "index_tab_info"));
                this.eDh.parserJson(jSONObject.optJSONObject("version"));
                this.eDi.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                com.baidu.adp.lib.stats.f.bV(jSONObject.optString("client_ip", null));
                this.eDj.parserJson(jSONObject.optJSONObject("config"));
                this.eDm.parserJson(jSONObject.optJSONObject("wl_config"));
                jSONObject.optJSONObject("channel_icon_config");
                String optString = jSONObject.optString("new_god_data", "");
                if (!StringUtils.isNull(optString)) {
                    this.eDy.parserJson(optString);
                }
                this.eDs.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.eDs);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.eDp = jSONObject.optInt("is_uninterest");
                this.eDq = jSONObject.optInt("first_time_motivate");
                this.eDr = jSONObject.optInt("needNewUserLead");
                this.eDk.parserJson(jSONObject.optJSONObject("combine_download"));
                this.eDl.parserJson(jSONObject.optJSONObject("mainbar"));
                this.eDo = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                this.eDn.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                g.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.eDt.parseJson(B(jSONObject, "abtest_config"));
                this.eDu.parseJson(B(jSONObject, "new_abtest_entra"));
                this.eDv = C(jSONObject, "new_abtest_config");
                this.eDw = C(jSONObject, "ubs_abtest_config");
                this.eDx = jSONObject.optJSONArray("windowStrategyList");
                com.baidu.tbadk.core.business.a.bbY().N(this.eDx);
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

    public r boZ() {
        return this.eDj;
    }

    public String bpa() {
        return this.mConfigVersion;
    }

    public CombineDownload bpb() {
        return this.eDk;
    }

    public VersionData bpc() {
        return this.eDh;
    }

    public q bpd() {
        return this.eDi;
    }

    public ai bpe() {
        return this.eDm;
    }

    public NewGodData bpf() {
        return this.eDy;
    }

    public com.baidu.tbadk.coreExtra.data.e bpg() {
        return this.eDn;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int bph() {
        return this.eDp;
    }

    public boolean bpi() {
        return this.eDq == 1;
    }

    public int bpj() {
        return this.eDr;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public ab getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a bpk() {
        return this.eDt;
    }

    public ABTestExtraData bpl() {
        return this.eDu;
    }

    public JSONArray bpm() {
        return this.eDv;
    }

    public JSONArray bpn() {
        return this.eDw;
    }
}
