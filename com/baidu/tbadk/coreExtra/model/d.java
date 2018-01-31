package com.baidu.tbadk.coreExtra.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.coreExtra.data.m;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.coreExtra.data.u;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int bhO;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int bhM = 0;
    private int bhN = 0;
    private VersionData bhF = new VersionData();
    private k bhG = new k();
    private l bhH = new l();
    private CombineDownload bhI = new CombineDownload();
    private p bhJ = new p();
    private u bhK = new u();
    private m bhP = new m();
    private com.baidu.tbadk.coreExtra.data.d bhL = new com.baidu.tbadk.coreExtra.data.d();
    private com.baidu.tbadk.coreExtra.data.c mAdAdSense = new com.baidu.tbadk.coreExtra.data.c();
    private final com.baidu.tbadk.coreExtra.data.b mActivitySwitch = new com.baidu.tbadk.coreExtra.data.b();

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
                this.bhF.parserJson(jSONObject.optJSONObject(ClientCookie.VERSION_ATTR));
                this.bhG.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.bhH.parserJson(jSONObject.optJSONObject("config"));
                this.bhK.parserJson(jSONObject.optJSONObject("wl_config"));
                this.bhP.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.bhP);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.bhN = jSONObject.optInt("is_uninterest");
                this.bhO = jSONObject.optInt("first_time_motivate");
                this.bhI.parserJson(jSONObject.optJSONObject("combine_download"));
                this.bhJ.parserJson(jSONObject.optJSONObject("mainbar"));
                this.bhM = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_ADS_EMOTION, jSONObject));
                this.mFaceShopVersion = jSONObject.optInt("faceshop_version");
                if (this.mFaceShopVersion > TbadkCoreApplication.getInst().getFaceShopVersion()) {
                    TbadkCoreApplication.getInst().setTempFaceShopVersion(this.mFaceShopVersion);
                    TbadkCoreApplication.getInst().setFaceShopNew(true);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject != null) {
                    TbadkCoreApplication.getInst().setLcsSwitchStratgy(optJSONObject.toString());
                }
                new b().h(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                this.bhL.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public l Hh() {
        return this.bhH;
    }

    public String Hi() {
        return this.mConfigVersion;
    }

    public CombineDownload Hj() {
        return this.bhI;
    }

    public VersionData Hk() {
        return this.bhF;
    }

    public k Hl() {
        return this.bhG;
    }

    public u Hm() {
        return this.bhK;
    }

    public com.baidu.tbadk.coreExtra.data.d Hn() {
        return this.bhL;
    }

    public com.baidu.tbadk.coreExtra.data.c getAdAdSense() {
        return this.mAdAdSense;
    }

    public int Ho() {
        return this.bhN;
    }

    public boolean Hp() {
        return this.bhO == 1;
    }

    public com.baidu.tbadk.coreExtra.data.b getActivitySwitch() {
        return this.mActivitySwitch;
    }
}
