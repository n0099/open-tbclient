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
    private int aQR;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int aQP = 0;
    private int aQQ = 0;
    private VersionData aQI = new VersionData();
    private m aQJ = new m();
    private n aQK = new n();
    private CombineDownload aQL = new CombineDownload();
    private r aQM = new r();
    private y aQN = new y();
    private o aQS = new o();
    private com.baidu.tbadk.coreExtra.data.e aQO = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a aQT = new com.baidu.tbadk.coreExtra.data.a();
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
                this.aQI.parserJson(jSONObject.optJSONObject("version"));
                this.aQJ.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.aQK.parserJson(jSONObject.optJSONObject("config"));
                this.aQN.parserJson(jSONObject.optJSONObject("wl_config"));
                this.aQS.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.aQS);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.aQQ = jSONObject.optInt("is_uninterest");
                this.aQR = jSONObject.optInt("first_time_motivate");
                this.aQL.parserJson(jSONObject.optJSONObject("combine_download"));
                this.aQM.parserJson(jSONObject.optJSONObject("mainbar"));
                this.aQP = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                this.aQO.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.aQT.parseJson(jSONObject.optJSONObject("abtest_config"));
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public n Ja() {
        return this.aQK;
    }

    public String Jb() {
        return this.mConfigVersion;
    }

    public CombineDownload Jc() {
        return this.aQL;
    }

    public VersionData Jd() {
        return this.aQI;
    }

    public m Je() {
        return this.aQJ;
    }

    public y Jf() {
        return this.aQN;
    }

    public com.baidu.tbadk.coreExtra.data.e Jg() {
        return this.aQO;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int Jh() {
        return this.aQQ;
    }

    public boolean Ji() {
        return this.aQR == 1;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public t getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a Jj() {
        return this.aQT;
    }
}
