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
    private int cxQ;
    private JSONArray cxT;
    private JSONArray cxU;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int cxO = 0;
    private int cxP = 0;
    private VersionData cxH = new VersionData();
    private m cxI = new m();
    private n cxJ = new n();
    private CombineDownload cxK = new CombineDownload();
    private s cxL = new s();
    private aa cxM = new aa();
    private o cxR = new o();
    private com.baidu.tbadk.coreExtra.data.e cxN = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a cxS = new com.baidu.tbadk.coreExtra.data.a();
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
                this.cxH.parserJson(jSONObject.optJSONObject("version"));
                this.cxI.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.cxJ.parserJson(jSONObject.optJSONObject("config"));
                this.cxM.parserJson(jSONObject.optJSONObject("wl_config"));
                this.cxR.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.cxR);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.cxP = jSONObject.optInt("is_uninterest");
                this.cxQ = jSONObject.optInt("first_time_motivate");
                this.cxK.parserJson(jSONObject.optJSONObject("combine_download"));
                this.cxL.parserJson(jSONObject.optJSONObject("mainbar"));
                this.cxO = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().bz(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                com.baidu.tbadk.coreExtra.data.f.I(jSONObject.optJSONArray("scheme_whitelist"));
                this.cxN.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.cxS.parseJson(jSONObject.optJSONObject("abtest_config"));
                this.cxT = jSONObject.optJSONArray("new_abtest_config");
                this.cxU = jSONObject.optJSONArray("windowStrategyList");
                com.baidu.tbadk.core.business.a.agC().D(this.cxU);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.alR().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public n arz() {
        return this.cxJ;
    }

    public String arA() {
        return this.mConfigVersion;
    }

    public CombineDownload arB() {
        return this.cxK;
    }

    public VersionData arC() {
        return this.cxH;
    }

    public m arD() {
        return this.cxI;
    }

    public aa arE() {
        return this.cxM;
    }

    public com.baidu.tbadk.coreExtra.data.e arF() {
        return this.cxN;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int arG() {
        return this.cxP;
    }

    public boolean arH() {
        return this.cxQ == 1;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public u getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a arI() {
        return this.cxS;
    }

    public JSONArray arJ() {
        return this.cxT;
    }
}
