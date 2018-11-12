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
import com.baidu.tbadk.coreExtra.data.y;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int aNq;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int aNo = 0;
    private int aNp = 0;
    private VersionData aNh = new VersionData();
    private m aNi = new m();
    private n aNj = new n();
    private CombineDownload aNk = new CombineDownload();
    private r aNl = new r();
    private y aNm = new y();
    private o aNr = new o();
    private com.baidu.tbadk.coreExtra.data.e aNn = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a aNs = new com.baidu.tbadk.coreExtra.data.a();
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
                this.aNh.parserJson(jSONObject.optJSONObject("version"));
                this.aNi.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.aNj.parserJson(jSONObject.optJSONObject("config"));
                this.aNm.parserJson(jSONObject.optJSONObject("wl_config"));
                this.aNr.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.aNr);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.aNp = jSONObject.optInt("is_uninterest");
                this.aNq = jSONObject.optInt("first_time_motivate");
                this.aNk.parserJson(jSONObject.optJSONObject("combine_download"));
                this.aNl.parserJson(jSONObject.optJSONObject("mainbar"));
                this.aNo = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().F(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                com.baidu.tbadk.coreExtra.data.f.k(jSONObject.optJSONArray("scheme_whitelist"));
                this.aNn.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.aNs.parseJson(jSONObject.optJSONObject("abtest_config"));
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public n HV() {
        return this.aNj;
    }

    public String HW() {
        return this.mConfigVersion;
    }

    public CombineDownload HX() {
        return this.aNk;
    }

    public VersionData HY() {
        return this.aNh;
    }

    public m HZ() {
        return this.aNi;
    }

    public y Ia() {
        return this.aNm;
    }

    public com.baidu.tbadk.coreExtra.data.e Ib() {
        return this.aNn;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int Ic() {
        return this.aNp;
    }

    public boolean Id() {
        return this.aNq == 1;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public t getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a Ie() {
        return this.aNs;
    }
}
