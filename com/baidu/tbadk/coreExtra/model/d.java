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
    private int cwZ;
    private JSONArray cxc;
    private JSONArray cxd;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int cwX = 0;
    private int cwY = 0;
    private VersionData cwQ = new VersionData();
    private m cwR = new m();
    private n cwS = new n();
    private CombineDownload cwT = new CombineDownload();
    private s cwU = new s();
    private aa cwV = new aa();
    private o cxa = new o();
    private com.baidu.tbadk.coreExtra.data.e cwW = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a cxb = new com.baidu.tbadk.coreExtra.data.a();
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
                this.cwQ.parserJson(jSONObject.optJSONObject("version"));
                this.cwR.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.cwS.parserJson(jSONObject.optJSONObject("config"));
                this.cwV.parserJson(jSONObject.optJSONObject("wl_config"));
                this.cxa.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.cxa);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.cwY = jSONObject.optInt("is_uninterest");
                this.cwZ = jSONObject.optInt("first_time_motivate");
                this.cwT.parserJson(jSONObject.optJSONObject("combine_download"));
                this.cwU.parserJson(jSONObject.optJSONObject("mainbar"));
                this.cwX = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().bA(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                com.baidu.tbadk.coreExtra.data.f.I(jSONObject.optJSONArray("scheme_whitelist"));
                this.cwW.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.cxb.parseJson(jSONObject.optJSONObject("abtest_config"));
                this.cxc = jSONObject.optJSONArray("new_abtest_config");
                this.cxd = jSONObject.optJSONArray("windowStrategyList");
                com.baidu.tbadk.core.business.a.agA().D(this.cxd);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.alP().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public n arx() {
        return this.cwS;
    }

    public String ary() {
        return this.mConfigVersion;
    }

    public CombineDownload arz() {
        return this.cwT;
    }

    public VersionData arA() {
        return this.cwQ;
    }

    public m arB() {
        return this.cwR;
    }

    public aa arC() {
        return this.cwV;
    }

    public com.baidu.tbadk.coreExtra.data.e arD() {
        return this.cwW;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int arE() {
        return this.cwY;
    }

    public boolean arF() {
        return this.cwZ == 1;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public u getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a arG() {
        return this.cxb;
    }

    public JSONArray arH() {
        return this.cxc;
    }
}
