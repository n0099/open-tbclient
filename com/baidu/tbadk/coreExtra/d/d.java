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
import com.baidu.tbadk.coreExtra.data.h;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.q;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int aiO = 0;
    private VersionData aiH = new VersionData();
    private f aiI = new f();
    private g aiJ = new g();
    private CombineDownload aiK = new CombineDownload();
    private k aiL = new k();
    private q aiM = new q();
    private h aiP = new h();
    private com.baidu.tbadk.coreExtra.data.a aiN = new com.baidu.tbadk.coreExtra.data.a();

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
                this.aiH.parserJson(jSONObject.optJSONObject("version"));
                this.aiI.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.e.setIp(jSONObject.optString("client_ip", null));
                this.aiJ.parserJson(jSONObject.optJSONObject("config"));
                this.aiM.parserJson(jSONObject.optJSONObject("wl_config"));
                this.aiP.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.m10getInst().setConsumePathData(this.aiP);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.aiK.parserJson(jSONObject.optJSONObject("combine_download"));
                this.aiL.parserJson(jSONObject.optJSONObject("mainbar"));
                this.aiO = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_ADS_EMOTION, jSONObject));
                this.mFaceShopVersion = jSONObject.optInt("faceshop_version");
                if (this.mFaceShopVersion > TbadkCoreApplication.m10getInst().getFaceShopVersion()) {
                    TbadkCoreApplication.m10getInst().setTempFaceShopVersion(this.mFaceShopVersion);
                    TbadkCoreApplication.m10getInst().setFaceShopNew(true);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject != null) {
                    TbadkCoreApplication.m10getInst().setLcsSwitchStratgy(optJSONObject.toString());
                }
                new b().n(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                this.aiN.parserJson(jSONObject.optJSONObject("app_entrance"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public g ym() {
        return this.aiJ;
    }

    public String yn() {
        return this.mConfigVersion;
    }

    public CombineDownload yo() {
        return this.aiK;
    }

    public VersionData yp() {
        return this.aiH;
    }

    public f yq() {
        return this.aiI;
    }

    public q yr() {
        return this.aiM;
    }

    public com.baidu.tbadk.coreExtra.data.a ys() {
        return this.aiN;
    }
}
