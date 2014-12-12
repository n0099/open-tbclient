package com.baidu.tbadk.coreExtra.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.j;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {
    private String Rs;
    private int mFaceShopVersion;
    private int Rv = 0;
    private VersionData Rp = new VersionData();
    private com.baidu.tbadk.coreExtra.data.d Rq = new com.baidu.tbadk.coreExtra.data.d();
    private com.baidu.tbadk.coreExtra.data.e Rr = new com.baidu.tbadk.coreExtra.data.e();
    private CombineDownload Rt = new CombineDownload();
    private com.baidu.tbadk.coreExtra.data.g Ru = new com.baidu.tbadk.coreExtra.data.g();

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
                this.Rp.parserJson(jSONObject.optJSONObject("version"));
                this.Rq.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.util.a.zq().parserJson(jSONObject.optJSONObject("ad_config"));
                j.setIp(jSONObject.optString("client_ip", null));
                this.Rr.parserJson(jSONObject.optJSONObject("config"));
                this.Rs = jSONObject.optString("config_version");
                this.Rt.parserJson(jSONObject.optJSONObject("combine_download"));
                this.Ru.parserJson(jSONObject.optJSONObject("mainbar"));
                this.Rv = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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

    public com.baidu.tbadk.coreExtra.data.e sm() {
        return this.Rr;
    }

    public String sn() {
        return this.Rs;
    }

    public CombineDownload so() {
        return this.Rt;
    }

    public VersionData sp() {
        return this.Rp;
    }

    public com.baidu.tbadk.coreExtra.data.d sq() {
        return this.Rq;
    }
}
