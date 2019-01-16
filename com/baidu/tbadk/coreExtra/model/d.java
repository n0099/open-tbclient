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
import com.baidu.tbadk.coreExtra.data.m;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.coreExtra.data.z;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int aRv;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int aRt = 0;
    private int aRu = 0;
    private VersionData aRm = new VersionData();
    private m aRn = new m();
    private n aRo = new n();
    private CombineDownload aRp = new CombineDownload();
    private r aRq = new r();
    private z aRr = new z();
    private o aRw = new o();
    private com.baidu.tbadk.coreExtra.data.e aRs = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a aRx = new com.baidu.tbadk.coreExtra.data.a();
    private t mProfileData = new t();

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
                this.aRm.parserJson(jSONObject.optJSONObject("version"));
                this.aRn.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.aRo.parserJson(jSONObject.optJSONObject("config"));
                this.aRr.parserJson(jSONObject.optJSONObject("wl_config"));
                this.aRw.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.aRw);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.aRu = jSONObject.optInt("is_uninterest");
                this.aRv = jSONObject.optInt("first_time_motivate");
                this.aRp.parserJson(jSONObject.optJSONObject("combine_download"));
                this.aRq.parserJson(jSONObject.optJSONObject("mainbar"));
                this.aRt = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().G(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                com.baidu.tbadk.coreExtra.data.f.k(jSONObject.optJSONArray("scheme_whitelist"));
                this.aRs.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.aRx.parseJson(jSONObject.optJSONObject("abtest_config"));
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("key_live_forum_enter_switch", jSONObject.optInt("ala_channel_white", 0) == 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public n Jp() {
        return this.aRo;
    }

    public String Jq() {
        return this.mConfigVersion;
    }

    public CombineDownload Jr() {
        return this.aRp;
    }

    public VersionData Js() {
        return this.aRm;
    }

    public m Jt() {
        return this.aRn;
    }

    public z Ju() {
        return this.aRr;
    }

    public com.baidu.tbadk.coreExtra.data.e Jv() {
        return this.aRs;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int Jw() {
        return this.aRu;
    }

    public boolean Jx() {
        return this.aRv == 1;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public t getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a Jy() {
        return this.aRx;
    }
}
