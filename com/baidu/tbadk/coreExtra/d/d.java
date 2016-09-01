package com.baidu.tbadk.coreExtra.d;

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
import com.baidu.tbadk.coreExtra.data.t;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int alT = 0;
    private VersionData alM = new VersionData();
    private i alN = new i();
    private j alO = new j();
    private CombineDownload alP = new CombineDownload();
    private n alQ = new n();
    private t alR = new t();
    private k alU = new k();
    private com.baidu.tbadk.coreExtra.data.b alS = new com.baidu.tbadk.coreExtra.data.b();
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
                this.alM.parserJson(jSONObject.optJSONObject("version"));
                this.alN.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.e.setIp(jSONObject.optString("client_ip", null));
                this.alO.parserJson(jSONObject.optJSONObject("config"));
                this.alR.parserJson(jSONObject.optJSONObject("wl_config"));
                this.alU.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.m9getInst().setConsumePathData(this.alU);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.alP.parserJson(jSONObject.optJSONObject("combine_download"));
                this.alQ.parserJson(jSONObject.optJSONObject("mainbar"));
                this.alT = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_ADS_EMOTION, jSONObject));
                this.mFaceShopVersion = jSONObject.optInt("faceshop_version");
                if (this.mFaceShopVersion > TbadkCoreApplication.m9getInst().getFaceShopVersion()) {
                    TbadkCoreApplication.m9getInst().setTempFaceShopVersion(this.mFaceShopVersion);
                    TbadkCoreApplication.m9getInst().setFaceShopNew(true);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject != null) {
                    TbadkCoreApplication.m9getInst().setLcsSwitchStratgy(optJSONObject.toString());
                }
                new b().n(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                this.alS.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public j zz() {
        return this.alO;
    }

    public String zA() {
        return this.mConfigVersion;
    }

    public CombineDownload zB() {
        return this.alP;
    }

    public VersionData zC() {
        return this.alM;
    }

    public i zD() {
        return this.alN;
    }

    public t zE() {
        return this.alR;
    }

    public com.baidu.tbadk.coreExtra.data.b zF() {
        return this.alS;
    }

    public com.baidu.tbadk.coreExtra.data.a getAdAdSense() {
        return this.mAdAdSense;
    }
}
