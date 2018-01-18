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
    private int bhG;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int bhE = 0;
    private int bhF = 0;
    private VersionData bhx = new VersionData();
    private k bhy = new k();
    private l bhz = new l();
    private CombineDownload bhA = new CombineDownload();
    private p bhB = new p();
    private u bhC = new u();
    private m bhH = new m();
    private com.baidu.tbadk.coreExtra.data.d bhD = new com.baidu.tbadk.coreExtra.data.d();
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
                this.bhx.parserJson(jSONObject.optJSONObject(ClientCookie.VERSION_ATTR));
                this.bhy.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.bhz.parserJson(jSONObject.optJSONObject("config"));
                this.bhC.parserJson(jSONObject.optJSONObject("wl_config"));
                this.bhH.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.bhH);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.bhF = jSONObject.optInt("is_uninterest");
                this.bhG = jSONObject.optInt("first_time_motivate");
                this.bhA.parserJson(jSONObject.optJSONObject("combine_download"));
                this.bhB.parserJson(jSONObject.optJSONObject("mainbar"));
                this.bhE = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                this.bhD.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
                this.mActivitySwitch.parseJson(jSONObject.optJSONObject("activity_switch"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public l Hf() {
        return this.bhz;
    }

    public String Hg() {
        return this.mConfigVersion;
    }

    public CombineDownload Hh() {
        return this.bhA;
    }

    public VersionData Hi() {
        return this.bhx;
    }

    public k Hj() {
        return this.bhy;
    }

    public u Hk() {
        return this.bhC;
    }

    public com.baidu.tbadk.coreExtra.data.d Hl() {
        return this.bhD;
    }

    public com.baidu.tbadk.coreExtra.data.c getAdAdSense() {
        return this.mAdAdSense;
    }

    public int Hm() {
        return this.bhF;
    }

    public boolean Hn() {
        return this.bhG == 1;
    }

    public com.baidu.tbadk.coreExtra.data.b getActivitySwitch() {
        return this.mActivitySwitch;
    }
}
