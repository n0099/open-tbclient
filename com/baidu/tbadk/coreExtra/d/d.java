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
import com.baidu.tbadk.coreExtra.data.p;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int aht = 0;
    private VersionData ahn = new VersionData();
    private com.baidu.tbadk.coreExtra.data.e aho = new com.baidu.tbadk.coreExtra.data.e();
    private f ahp = new f();
    private CombineDownload ahq = new CombineDownload();
    private j ahr = new j();
    private p ahs = new p();
    private g ahu = new g();

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
                this.ahn.parserJson(jSONObject.optJSONObject("version"));
                this.aho.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.e.setIp(jSONObject.optString("client_ip", null));
                this.ahp.parserJson(jSONObject.optJSONObject("config"));
                this.ahs.parserJson(jSONObject.optJSONObject("wl_config"));
                this.ahu.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.m11getInst().setConsumePathData(this.ahu);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.ahq.parserJson(jSONObject.optJSONObject("combine_download"));
                this.ahr.parserJson(jSONObject.optJSONObject("mainbar"));
                this.aht = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_ADS_EMOTION, jSONObject));
                this.mFaceShopVersion = jSONObject.optInt("faceshop_version");
                if (this.mFaceShopVersion > TbadkCoreApplication.m11getInst().getFaceShopVersion()) {
                    TbadkCoreApplication.m11getInst().setTempFaceShopVersion(this.mFaceShopVersion);
                    TbadkCoreApplication.m11getInst().setFaceShopNew(true);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject != null) {
                    TbadkCoreApplication.m11getInst().setLcsSwitchStratgy(optJSONObject.toString());
                }
                new b().k(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public f yi() {
        return this.ahp;
    }

    public String yj() {
        return this.mConfigVersion;
    }

    public CombineDownload yk() {
        return this.ahq;
    }

    public VersionData yl() {
        return this.ahn;
    }

    public com.baidu.tbadk.coreExtra.data.e ym() {
        return this.aho;
    }

    public p yn() {
        return this.ahs;
    }
}
