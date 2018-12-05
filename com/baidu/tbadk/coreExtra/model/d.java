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
    private int aQP;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int aQN = 0;
    private int aQO = 0;
    private VersionData aQG = new VersionData();
    private m aQH = new m();
    private n aQI = new n();
    private CombineDownload aQJ = new CombineDownload();
    private r aQK = new r();
    private y aQL = new y();
    private o aQQ = new o();
    private com.baidu.tbadk.coreExtra.data.e aQM = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a aQR = new com.baidu.tbadk.coreExtra.data.a();
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
                this.aQG.parserJson(jSONObject.optJSONObject("version"));
                this.aQH.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.aQI.parserJson(jSONObject.optJSONObject("config"));
                this.aQL.parserJson(jSONObject.optJSONObject("wl_config"));
                this.aQQ.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.aQQ);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.aQO = jSONObject.optInt("is_uninterest");
                this.aQP = jSONObject.optInt("first_time_motivate");
                this.aQJ.parserJson(jSONObject.optJSONObject("combine_download"));
                this.aQK.parserJson(jSONObject.optJSONObject("mainbar"));
                this.aQN = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                this.aQM.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.aQR.parseJson(jSONObject.optJSONObject("abtest_config"));
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public n IZ() {
        return this.aQI;
    }

    public String Ja() {
        return this.mConfigVersion;
    }

    public CombineDownload Jb() {
        return this.aQJ;
    }

    public VersionData Jc() {
        return this.aQG;
    }

    public m Jd() {
        return this.aQH;
    }

    public y Je() {
        return this.aQL;
    }

    public com.baidu.tbadk.coreExtra.data.e Jf() {
        return this.aQM;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int Jg() {
        return this.aQO;
    }

    public boolean Jh() {
        return this.aQP == 1;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public t getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a Ji() {
        return this.aQR;
    }
}
