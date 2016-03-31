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
import com.baidu.tbadk.coreExtra.data.f;
import com.baidu.tbadk.coreExtra.data.g;
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tbadk.coreExtra.data.o;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int alG = 0;
    private VersionData alA = new VersionData();
    private com.baidu.tbadk.coreExtra.data.e alB = new com.baidu.tbadk.coreExtra.data.e();
    private f alC = new f();
    private CombineDownload alD = new CombineDownload();
    private j alE = new j();
    private o alF = new o();
    private g alH = new g();

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
                this.alA.parserJson(jSONObject.optJSONObject("version"));
                this.alB.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.e.setIp(jSONObject.optString("client_ip", null));
                this.alC.parserJson(jSONObject.optJSONObject("config"));
                this.alF.parserJson(jSONObject.optJSONObject("wl_config"));
                this.alH.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.m411getInst().setConsumePathData(this.alH);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.alD.parserJson(jSONObject.optJSONObject("combine_download"));
                this.alE.parserJson(jSONObject.optJSONObject("mainbar"));
                this.alG = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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

    public f Ao() {
        return this.alC;
    }

    public String Ap() {
        return this.mConfigVersion;
    }

    public CombineDownload Aq() {
        return this.alD;
    }

    public VersionData Ar() {
        return this.alA;
    }

    public com.baidu.tbadk.coreExtra.data.e As() {
        return this.alB;
    }

    public o At() {
        return this.alF;
    }
}
