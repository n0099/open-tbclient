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
    private int ajt = 0;
    private VersionData ajn = new VersionData();
    private com.baidu.tbadk.coreExtra.data.e ajo = new com.baidu.tbadk.coreExtra.data.e();
    private f ajp = new f();
    private CombineDownload ajq = new CombineDownload();
    private j ajr = new j();
    private o ajs = new o();
    private g aju = new g();

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
                this.ajn.parserJson(jSONObject.optJSONObject("version"));
                this.ajo.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.f.setIp(jSONObject.optString("client_ip", null));
                this.ajp.parserJson(jSONObject.optJSONObject("config"));
                this.ajs.parserJson(jSONObject.optJSONObject("wl_config"));
                this.aju.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.m411getInst().setConsumePathData(this.aju);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.ajq.parserJson(jSONObject.optJSONObject("combine_download"));
                this.ajr.parserJson(jSONObject.optJSONObject("mainbar"));
                this.ajt = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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

    public f yH() {
        return this.ajp;
    }

    public String yI() {
        return this.mConfigVersion;
    }

    public CombineDownload yJ() {
        return this.ajq;
    }

    public VersionData yK() {
        return this.ajn;
    }

    public com.baidu.tbadk.coreExtra.data.e yL() {
        return this.ajo;
    }

    public o yM() {
        return this.ajs;
    }
}
