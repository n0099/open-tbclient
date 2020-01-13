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
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tbadk.coreExtra.data.m;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tbadk.coreExtra.data.u;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int dlb;
    private JSONArray dle;
    private JSONArray dlf;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int dkZ = 0;
    private int dla = 0;
    private VersionData dkS = new VersionData();
    private m dkT = new m();
    private n dkU = new n();
    private CombineDownload dkV = new CombineDownload();
    private s dkW = new s();
    private ab dkX = new ab();
    private o dlc = new o();
    private com.baidu.tbadk.coreExtra.data.e dkY = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a dld = new com.baidu.tbadk.coreExtra.data.a();
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
                this.dkS.parserJson(jSONObject.optJSONObject("version"));
                this.dkT.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.dkU.parserJson(jSONObject.optJSONObject("config"));
                this.dkX.parserJson(jSONObject.optJSONObject("wl_config"));
                this.dlc.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.dlc);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.dla = jSONObject.optInt("is_uninterest");
                this.dlb = jSONObject.optInt("first_time_motivate");
                this.dkV.parserJson(jSONObject.optJSONObject("combine_download"));
                this.dkW.parserJson(jSONObject.optJSONObject("mainbar"));
                this.dkZ = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                com.baidu.tbadk.coreExtra.data.f.Q(jSONObject.optJSONArray("scheme_whitelist"));
                this.dkY.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.dld.parseJson(jSONObject.optJSONObject("abtest_config"));
                this.dle = jSONObject.optJSONArray("new_abtest_config");
                this.dlf = jSONObject.optJSONArray("windowStrategyList");
                com.baidu.tbadk.core.business.a.axK().K(this.dlf);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public n aJq() {
        return this.dkU;
    }

    public String aJr() {
        return this.mConfigVersion;
    }

    public CombineDownload aJs() {
        return this.dkV;
    }

    public VersionData aJt() {
        return this.dkS;
    }

    public m aJu() {
        return this.dkT;
    }

    public ab aJv() {
        return this.dkX;
    }

    public com.baidu.tbadk.coreExtra.data.e aJw() {
        return this.dkY;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int aJx() {
        return this.dla;
    }

    public boolean aJy() {
        return this.dlb == 1;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public u getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a aJz() {
        return this.dld;
    }

    public JSONArray aJA() {
        return this.dle;
    }
}
