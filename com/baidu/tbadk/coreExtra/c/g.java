package com.baidu.tbadk.coreExtra.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.l;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int abY = 0;
    private VersionData abS = new VersionData();
    private com.baidu.tbadk.coreExtra.data.d abT = new com.baidu.tbadk.coreExtra.data.d();
    private com.baidu.tbadk.coreExtra.data.e abU = new com.baidu.tbadk.coreExtra.data.e();
    private CombineDownload abV = new CombineDownload();
    private com.baidu.tbadk.coreExtra.data.g abW = new com.baidu.tbadk.coreExtra.data.g();
    private l abX = new l();

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
                this.abS.parserJson(jSONObject.optJSONObject("version"));
                this.abT.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.util.a.CV().parserJson(jSONObject.optJSONObject("ad_config"));
                com.baidu.tbadk.core.util.f.setIp(jSONObject.optString("client_ip", null));
                this.abU.parserJson(jSONObject.optJSONObject("config"));
                this.abX.parserJson(jSONObject.optJSONObject("wl_config"));
                this.mConfigVersion = jSONObject.optString("config_version");
                this.abV.parserJson(jSONObject.optJSONObject("combine_download"));
                this.abW.parserJson(jSONObject.optJSONObject("mainbar"));
                this.abY = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001145, jSONObject));
                this.mFaceShopVersion = jSONObject.optInt("faceshop_version");
                if (this.mFaceShopVersion > TbadkCoreApplication.m411getInst().getFaceShopVersion()) {
                    TbadkCoreApplication.m411getInst().setTempFaceShopVersion(this.mFaceShopVersion);
                    TbadkCoreApplication.m411getInst().setFaceShopNew(true);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject != null) {
                    TbadkCoreApplication.m411getInst().setLcsSwitchStratgy(optJSONObject.toString());
                }
                new c().g(jSONObject.optJSONObject("next_start"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public com.baidu.tbadk.coreExtra.data.e vS() {
        return this.abU;
    }

    public String vT() {
        return this.mConfigVersion;
    }

    public CombineDownload vU() {
        return this.abV;
    }

    public VersionData vV() {
        return this.abS;
    }

    public com.baidu.tbadk.coreExtra.data.d vW() {
        return this.abT;
    }

    public l vX() {
        return this.abX;
    }
}
