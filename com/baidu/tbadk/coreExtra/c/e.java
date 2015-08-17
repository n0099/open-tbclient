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
import com.baidu.tbadk.coreExtra.data.h;
import com.baidu.tbadk.coreExtra.data.m;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int aiv = 0;
    private VersionData aip = new VersionData();
    private com.baidu.tbadk.coreExtra.data.d aiq = new com.baidu.tbadk.coreExtra.data.d();
    private com.baidu.tbadk.coreExtra.data.e air = new com.baidu.tbadk.coreExtra.data.e();
    private CombineDownload ais = new CombineDownload();
    private h ait = new h();
    private m aiu = new m();

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
                this.aip.parserJson(jSONObject.optJSONObject("version"));
                this.aiq.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.f.setIp(jSONObject.optString("client_ip", null));
                this.air.parserJson(jSONObject.optJSONObject("config"));
                this.aiu.parserJson(jSONObject.optJSONObject("wl_config"));
                this.mConfigVersion = jSONObject.optString("config_version");
                this.ais.parserJson(jSONObject.optJSONObject("combine_download"));
                this.ait.parserJson(jSONObject.optJSONObject("mainbar"));
                this.aiv = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_ADS_EMOTION, jSONObject));
                this.mFaceShopVersion = jSONObject.optInt("faceshop_version");
                if (this.mFaceShopVersion > TbadkCoreApplication.m411getInst().getFaceShopVersion()) {
                    TbadkCoreApplication.m411getInst().setTempFaceShopVersion(this.mFaceShopVersion);
                    TbadkCoreApplication.m411getInst().setFaceShopNew(true);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject != null) {
                    TbadkCoreApplication.m411getInst().setLcsSwitchStratgy(optJSONObject.toString());
                }
                new b().k(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public com.baidu.tbadk.coreExtra.data.e xS() {
        return this.air;
    }

    public String xT() {
        return this.mConfigVersion;
    }

    public CombineDownload xU() {
        return this.ais;
    }

    public VersionData xV() {
        return this.aip;
    }

    public com.baidu.tbadk.coreExtra.data.d xW() {
        return this.aiq;
    }

    public m xX() {
        return this.aiu;
    }
}
