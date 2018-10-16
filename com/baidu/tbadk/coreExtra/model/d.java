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
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.coreExtra.data.m;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tbadk.coreExtra.data.x;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int aMA;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int aMy = 0;
    private int aMz = 0;
    private VersionData aMr = new VersionData();
    private l aMs = new l();
    private m aMt = new m();
    private CombineDownload aMu = new CombineDownload();
    private q aMv = new q();
    private x aMw = new x();
    private n aMB = new n();
    private com.baidu.tbadk.coreExtra.data.e aMx = new com.baidu.tbadk.coreExtra.data.e();
    private com.baidu.tbadk.coreExtra.data.d mAdAdSense = new com.baidu.tbadk.coreExtra.data.d();
    private final com.baidu.tbadk.coreExtra.data.c mActivitySwitch = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.a aMC = new com.baidu.tbadk.coreExtra.data.a();
    private s mProfileData = new s();

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
                this.aMr.parserJson(jSONObject.optJSONObject("version"));
                this.aMs.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.aMt.parserJson(jSONObject.optJSONObject("config"));
                this.aMw.parserJson(jSONObject.optJSONObject("wl_config"));
                this.aMB.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.aMB);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.aMz = jSONObject.optInt("is_uninterest");
                this.aMA = jSONObject.optInt("first_time_motivate");
                this.aMu.parserJson(jSONObject.optJSONObject("combine_download"));
                this.aMv.parserJson(jSONObject.optJSONObject("mainbar"));
                this.aMy = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                this.aMx.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
                this.aMC.parseJson(jSONObject.optJSONObject("abtest_config"));
                this.mProfileData.parseJson(jSONObject.optJSONObject("profile_icon"));
                TbSingleton.getInstance().setNewUser(jSONObject.optInt("recommend_userstatus", 0) == 1);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public m HJ() {
        return this.aMt;
    }

    public String HK() {
        return this.mConfigVersion;
    }

    public CombineDownload HL() {
        return this.aMu;
    }

    public VersionData HM() {
        return this.aMr;
    }

    public l HN() {
        return this.aMs;
    }

    public x HO() {
        return this.aMw;
    }

    public com.baidu.tbadk.coreExtra.data.e HP() {
        return this.aMx;
    }

    public com.baidu.tbadk.coreExtra.data.d getAdAdSense() {
        return this.mAdAdSense;
    }

    public int HQ() {
        return this.aMz;
    }

    public boolean HR() {
        return this.aMA == 1;
    }

    public com.baidu.tbadk.coreExtra.data.c getActivitySwitch() {
        return this.mActivitySwitch;
    }

    public s getProfileData() {
        return this.mProfileData;
    }

    public com.baidu.tbadk.coreExtra.data.a HS() {
        return this.aMC;
    }
}
