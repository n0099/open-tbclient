package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
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
    private int ckh;
    private JSONArray ckk;
    private JSONArray ckl;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int ckf = 0;
    private int ckg = 0;
    private VersionData cjY = new VersionData();
    private m cjZ = new m();
    private n cka = new n();
    private CombineDownload ckb = new CombineDownload();
    private s ckc = new s();
    private aa ckd = new aa();
    private o cki = new o();
    private com.baidu.tbadk.coreExtra.data.e cke = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a ckj = new com.baidu.tbadk.coreExtra.data.a();
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
                this.cjY.parserJson(jSONObject.optJSONObject("version"));
                this.cjZ.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.cka.parserJson(jSONObject.optJSONObject("config"));
                this.ckd.parserJson(jSONObject.optJSONObject("wl_config"));
                this.cki.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.cki);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.ckg = jSONObject.optInt("is_uninterest");
                this.ckh = jSONObject.optInt("first_time_motivate");
                this.ckb.parserJson(jSONObject.optJSONObject("combine_download"));
                this.ckc.parserJson(jSONObject.optJSONObject("mainbar"));
                this.ckf = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001141, jSONObject));
                this.mFaceShopVersion = jSONObject.optInt("faceshop_version");
                if (this.mFaceShopVersion > TbadkCoreApplication.getInst().getFaceShopVersion()) {
                    TbadkCoreApplication.getInst().setTempFaceShopVersion(this.mFaceShopVersion);
                    TbadkCoreApplication.getInst().setFaceShopNew(true);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject != null) {
                    TbadkCoreApplication.getInst().setLcsSwitchStratgy(optJSONObject.toString());
                }
                new b().bc(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                com.baidu.tbadk.coreExtra.data.f.A(jSONObject.optJSONArray("scheme_whitelist"));
                this.cke.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.ckj.parseJson(jSONObject.optJSONObject("abtest_config"));
                this.ckk = jSONObject.optJSONArray("new_abtest_config");
                this.ckl = jSONObject.optJSONArray("windowStrategyList");
                com.baidu.tbadk.core.business.a.acw().v(this.ckl);
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public n apc() {
        return this.cka;
    }

    public String apd() {
        return this.mConfigVersion;
    }

    public CombineDownload ape() {
        return this.ckb;
    }

    public VersionData apf() {
        return this.cjY;
    }

    public m apg() {
        return this.cjZ;
    }

    public aa aph() {
        return this.ckd;
    }

    public com.baidu.tbadk.coreExtra.data.e apj() {
        return this.cke;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int apk() {
        return this.ckg;
    }

    public boolean apl() {
        return this.ckh == 1;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public u getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a apm() {
        return this.ckj;
    }

    public JSONArray apn() {
        return this.ckk;
    }
}
