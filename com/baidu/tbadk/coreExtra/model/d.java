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
    private int esS;
    private int esT;
    private JSONArray esX;
    private JSONArray esY;
    private JSONArray esZ;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int esQ = 0;
    private int esR = 0;
    private VersionData esJ = new VersionData();
    private n esK = new n();
    private o esL = new o();
    private CombineDownload esM = new CombineDownload();
    private w esN = new w();
    private af esO = new af();
    private p esU = new p();
    private com.baidu.tbadk.coreExtra.data.e esP = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a esV = new com.baidu.tbadk.coreExtra.data.a();
    private y mProfileData = new y();
    private ABTestExtraData esW = new ABTestExtraData();
    private NewGodData eta = new NewGodData();
    private s etb = new s();

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
                this.etb.T(z(jSONObject, "index_tab_info"));
                this.esJ.parserJson(jSONObject.optJSONObject("version"));
                this.esK.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                com.baidu.adp.lib.stats.f.bQ(jSONObject.optString("client_ip", null));
                this.esL.parserJson(jSONObject.optJSONObject("config"));
                this.esO.parserJson(jSONObject.optJSONObject("wl_config"));
                String optString = jSONObject.optString("new_god_data", "");
                if (!StringUtils.isNull(optString)) {
                    this.eta.parserJson(optString);
                }
                this.esU.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.esU);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.esR = jSONObject.optInt("is_uninterest");
                this.esS = jSONObject.optInt("first_time_motivate");
                this.esT = jSONObject.optInt("needNewUserLead");
                this.esM.parserJson(jSONObject.optJSONObject("combine_download"));
                this.esN.parserJson(jSONObject.optJSONObject("mainbar"));
                this.esQ = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().cT(jSONObject.optJSONObject("dis_adv_config"));
                WhiteListData whiteListData = new WhiteListData();
                whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
                TbSingleton.getInstance().setHostWhiteList(whiteListData);
                com.baidu.tbadk.coreExtra.data.f.R(jSONObject.optJSONArray("scheme_whitelist"));
                this.esP.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.esV.parseJson(y(jSONObject, "abtest_config"));
                this.esW.parseJson(y(jSONObject, "new_abtest_entra"));
                this.esX = z(jSONObject, "new_abtest_config");
                this.esY = z(jSONObject, "ubs_abtest_config");
                this.esZ = jSONObject.optJSONArray("windowStrategyList");
                com.baidu.tbadk.core.business.a.aTH().L(this.esZ);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
                TbSingleton.getInstance().setPcdnConfigData(jSONObject.optJSONObject("pcdn_config"));
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

    public o bgo() {
        return this.esL;
    }

    public String bgp() {
        return this.mConfigVersion;
    }

    public CombineDownload bgq() {
        return this.esM;
    }

    public VersionData bgr() {
        return this.esJ;
    }

    public n bgs() {
        return this.esK;
    }

    public af bgt() {
        return this.esO;
    }

    public NewGodData bgu() {
        return this.eta;
    }

    public com.baidu.tbadk.coreExtra.data.e bgv() {
        return this.esP;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int bgw() {
        return this.esR;
    }

    public boolean bgx() {
        return this.esS == 1;
    }

    public int bgy() {
        return this.esT;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public y getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a bgz() {
        return this.esV;
    }

    public ABTestExtraData bgA() {
        return this.esW;
    }

    public JSONArray bgB() {
        return this.esX;
    }

    public JSONArray bgC() {
        return this.esY;
    }
}
