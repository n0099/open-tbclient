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
    private int ahZ = 0;
    private VersionData ahS = new VersionData();
    private f ahT = new f();
    private g ahU = new g();
    private CombineDownload ahV = new CombineDownload();
    private k ahW = new k();
    private q ahX = new q();
    private h aia = new h();
    private com.baidu.tbadk.coreExtra.data.a ahY = new com.baidu.tbadk.coreExtra.data.a();

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
                this.ahS.parserJson(jSONObject.optJSONObject("version"));
                this.ahT.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.e.setIp(jSONObject.optString("client_ip", null));
                this.ahU.parserJson(jSONObject.optJSONObject("config"));
                this.ahX.parserJson(jSONObject.optJSONObject("wl_config"));
                this.aia.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.m9getInst().setConsumePathData(this.aia);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.ahV.parserJson(jSONObject.optJSONObject("combine_download"));
                this.ahW.parserJson(jSONObject.optJSONObject("mainbar"));
                this.ahZ = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().l(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                this.ahY.parserJson(jSONObject.optJSONObject("app_entrance"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public g ym() {
        return this.ahU;
    }

    public String yn() {
        return this.mConfigVersion;
    }

    public CombineDownload yo() {
        return this.ahV;
    }

    public VersionData yp() {
        return this.ahS;
    }

    public f yq() {
        return this.ahT;
    }

    public q yr() {
        return this.ahX;
    }

    public com.baidu.tbadk.coreExtra.data.a ys() {
        return this.ahY;
    }
}
