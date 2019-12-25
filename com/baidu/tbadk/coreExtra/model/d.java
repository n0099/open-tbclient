package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.coreExtra.data.m;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tbadk.coreExtra.data.u;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int dkL;
    private JSONArray dkO;
    private JSONArray dkP;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int dkJ = 0;
    private int dkK = 0;
    private VersionData dkC = new VersionData();
    private m dkD = new m();
    private n dkE = new n();
    private CombineDownload dkF = new CombineDownload();
    private s dkG = new s();
    private aa dkH = new aa();
    private o dkM = new o();
    private com.baidu.tbadk.coreExtra.data.e dkI = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a dkN = new com.baidu.tbadk.coreExtra.data.a();
    private u mProfileData = new u();

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
                this.dkC.parserJson(jSONObject.optJSONObject("version"));
                this.dkD.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.dkE.parserJson(jSONObject.optJSONObject("config"));
                this.dkH.parserJson(jSONObject.optJSONObject("wl_config"));
                this.dkM.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.dkM);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.dkK = jSONObject.optInt("is_uninterest");
                this.dkL = jSONObject.optInt("first_time_motivate");
                this.dkF.parserJson(jSONObject.optJSONObject("combine_download"));
                this.dkG.parserJson(jSONObject.optJSONObject("mainbar"));
                this.dkJ = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().cp(jSONObject.optJSONObject("dis_adv_config"));
                WhiteListData whiteListData = new WhiteListData();
                whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
                TbSingleton.getInstance().setHostWhiteList(whiteListData);
                com.baidu.tbadk.coreExtra.data.f.P(jSONObject.optJSONArray("scheme_whitelist"));
                this.dkI.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.dkN.parseJson(jSONObject.optJSONObject("abtest_config"));
                this.dkO = jSONObject.optJSONArray("new_abtest_config");
                this.dkP = jSONObject.optJSONArray("windowStrategyList");
                com.baidu.tbadk.core.business.a.axr().J(this.dkP);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public n aIW() {
        return this.dkE;
    }

    public String aIX() {
        return this.mConfigVersion;
    }

    public CombineDownload aIY() {
        return this.dkF;
    }

    public VersionData aIZ() {
        return this.dkC;
    }

    public m aJa() {
        return this.dkD;
    }

    public aa aJb() {
        return this.dkH;
    }

    public com.baidu.tbadk.coreExtra.data.e aJc() {
        return this.dkI;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int aJd() {
        return this.dkK;
    }

    public boolean aJe() {
        return this.dkL == 1;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public u getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a aJf() {
        return this.dkN;
    }

    public JSONArray aJg() {
        return this.dkO;
    }
}
