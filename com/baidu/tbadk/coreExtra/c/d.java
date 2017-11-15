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
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.coreExtra.data.s;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int asL;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int asJ = 0;
    private int asK = 0;
    private VersionData asC = new VersionData();
    private j asD = new j();
    private k asE = new k();
    private CombineDownload asF = new CombineDownload();
    private o asG = new o();
    private s asH = new s();
    private l asM = new l();
    private com.baidu.tbadk.coreExtra.data.c asI = new com.baidu.tbadk.coreExtra.data.c();
    private com.baidu.tbadk.coreExtra.data.b mAdAdSense = new com.baidu.tbadk.coreExtra.data.b();

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
                this.asC.parserJson(jSONObject.optJSONObject("version"));
                this.asD.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.asE.parserJson(jSONObject.optJSONObject("config"));
                this.asH.parserJson(jSONObject.optJSONObject("wl_config"));
                this.asM.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.asM);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.asK = jSONObject.optInt("is_uninterest");
                this.asL = jSONObject.optInt("first_time_motivate");
                this.asF.parserJson(jSONObject.optJSONObject("combine_download"));
                this.asG.parserJson(jSONObject.optJSONObject("mainbar"));
                this.asJ = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().j(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                this.asI.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
                f.parserJson(jSONObject.optJSONObject("video_report_config"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public k zI() {
        return this.asE;
    }

    public String zJ() {
        return this.mConfigVersion;
    }

    public CombineDownload zK() {
        return this.asF;
    }

    public VersionData zL() {
        return this.asC;
    }

    public j zM() {
        return this.asD;
    }

    public s zN() {
        return this.asH;
    }

    public com.baidu.tbadk.coreExtra.data.c zO() {
        return this.asI;
    }

    public com.baidu.tbadk.coreExtra.data.b getAdAdSense() {
        return this.mAdAdSense;
    }

    public int zP() {
        return this.asK;
    }

    public boolean zQ() {
        return this.asL == 1;
    }
}
