package com.baidu.tbadk.coreExtra.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import com.baidu.tbadk.coreExtra.data.i;
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.coreExtra.data.r;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int asF;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int asD = 0;
    private int asE = 0;
    private VersionData asw = new VersionData();
    private i asx = new i();
    private j asy = new j();
    private CombineDownload asz = new CombineDownload();
    private n asA = new n();
    private r asB = new r();
    private k asG = new k();
    private com.baidu.tbadk.coreExtra.data.b asC = new com.baidu.tbadk.coreExtra.data.b();
    private com.baidu.tbadk.coreExtra.data.a mAdAdSense = new com.baidu.tbadk.coreExtra.data.a();

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
                this.asw.parserJson(jSONObject.optJSONObject("version"));
                this.asx.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.asy.parserJson(jSONObject.optJSONObject("config"));
                this.asB.parserJson(jSONObject.optJSONObject("wl_config"));
                this.asG.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.asG);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.asE = jSONObject.optInt("is_uninterest");
                this.asF = jSONObject.optInt("first_time_motivate");
                this.asz.parserJson(jSONObject.optJSONObject("combine_download"));
                this.asA.parserJson(jSONObject.optJSONObject("mainbar"));
                this.asD = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().i(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                this.asC.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public j zA() {
        return this.asy;
    }

    public String zB() {
        return this.mConfigVersion;
    }

    public CombineDownload zC() {
        return this.asz;
    }

    public VersionData zD() {
        return this.asw;
    }

    public i zE() {
        return this.asx;
    }

    public r zF() {
        return this.asB;
    }

    public com.baidu.tbadk.coreExtra.data.b zG() {
        return this.asC;
    }

    public com.baidu.tbadk.coreExtra.data.a getAdAdSense() {
        return this.mAdAdSense;
    }

    public int zH() {
        return this.asE;
    }

    public boolean zI() {
        return this.asF == 1;
    }
}
