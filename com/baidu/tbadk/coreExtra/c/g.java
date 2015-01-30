package com.baidu.tbadk.coreExtra.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.j;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.k;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int RZ = 0;
    private VersionData RT = new VersionData();
    private com.baidu.tbadk.coreExtra.data.d RU = new com.baidu.tbadk.coreExtra.data.d();
    private com.baidu.tbadk.coreExtra.data.e RV = new com.baidu.tbadk.coreExtra.data.e();
    private CombineDownload RW = new CombineDownload();
    private com.baidu.tbadk.coreExtra.data.g RX = new com.baidu.tbadk.coreExtra.data.g();
    private k RY = new k();

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
                this.RT.parserJson(jSONObject.optJSONObject("version"));
                this.RU.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.util.a.zH().parserJson(jSONObject.optJSONObject("ad_config"));
                j.setIp(jSONObject.optString("client_ip", null));
                this.RV.parserJson(jSONObject.optJSONObject("config"));
                this.RY.parserJson(jSONObject.optJSONObject("wl_config"));
                this.mConfigVersion = jSONObject.optString("config_version");
                this.RW.parserJson(jSONObject.optJSONObject("combine_download"));
                this.RX.parserJson(jSONObject.optJSONObject("mainbar"));
                this.RZ = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001145, jSONObject));
                this.mFaceShopVersion = jSONObject.optInt("faceshop_version");
                if (this.mFaceShopVersion > TbadkCoreApplication.m255getInst().getFaceShopVersion()) {
                    TbadkCoreApplication.m255getInst().setTempFaceShopVersion(this.mFaceShopVersion);
                    TbadkCoreApplication.m255getInst().setFaceShopNew(true);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject != null) {
                    TbadkCoreApplication.m255getInst().setLcsSwitchStratgy(optJSONObject.toString());
                }
                new c().h(jSONObject.optJSONObject("next_start"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public com.baidu.tbadk.coreExtra.data.e sC() {
        return this.RV;
    }

    public String sD() {
        return this.mConfigVersion;
    }

    public CombineDownload sE() {
        return this.RW;
    }

    public VersionData sF() {
        return this.RT;
    }

    public com.baidu.tbadk.coreExtra.data.d sG() {
        return this.RU;
    }

    public k sH() {
        return this.RY;
    }
}
