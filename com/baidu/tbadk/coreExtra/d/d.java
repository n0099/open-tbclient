package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.f;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import com.baidu.tbadk.coreExtra.data.h;
import com.baidu.tbadk.coreExtra.data.m;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int ahH = 0;
    private VersionData ahB = new VersionData();
    private com.baidu.tbadk.coreExtra.data.d ahC = new com.baidu.tbadk.coreExtra.data.d();
    private com.baidu.tbadk.coreExtra.data.e ahD = new com.baidu.tbadk.coreExtra.data.e();
    private CombineDownload ahE = new CombineDownload();
    private h ahF = new h();
    private m ahG = new m();

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
                this.ahB.parserJson(jSONObject.optJSONObject("version"));
                this.ahC.parserJson(jSONObject.optJSONObject("client"));
                f.setIp(jSONObject.optString("client_ip", null));
                this.ahD.parserJson(jSONObject.optJSONObject("config"));
                this.ahG.parserJson(jSONObject.optJSONObject("wl_config"));
                this.mConfigVersion = jSONObject.optString("config_version");
                this.ahE.parserJson(jSONObject.optJSONObject("combine_download"));
                this.ahF.parserJson(jSONObject.optJSONObject("mainbar"));
                this.ahH = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().j(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public com.baidu.tbadk.coreExtra.data.e xL() {
        return this.ahD;
    }

    public String xM() {
        return this.mConfigVersion;
    }

    public CombineDownload xN() {
        return this.ahE;
    }

    public VersionData xO() {
        return this.ahB;
    }

    public com.baidu.tbadk.coreExtra.data.d xP() {
        return this.ahC;
    }

    public m xQ() {
        return this.ahG;
    }
}
