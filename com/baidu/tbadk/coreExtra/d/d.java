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
    private int alp = 0;
    private VersionData alj = new VersionData();
    private com.baidu.tbadk.coreExtra.data.e alk = new com.baidu.tbadk.coreExtra.data.e();
    private f all = new f();
    private CombineDownload alm = new CombineDownload();
    private j aln = new j();
    private o alo = new o();
    private g alq = new g();

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
                this.alj.parserJson(jSONObject.optJSONObject("version"));
                this.alk.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.e.setIp(jSONObject.optString("client_ip", null));
                this.all.parserJson(jSONObject.optJSONObject("config"));
                this.alo.parserJson(jSONObject.optJSONObject("wl_config"));
                this.alq.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.m411getInst().setConsumePathData(this.alq);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.alm.parserJson(jSONObject.optJSONObject("combine_download"));
                this.aln.parserJson(jSONObject.optJSONObject("mainbar"));
                this.alp = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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

    public f zL() {
        return this.all;
    }

    public String zM() {
        return this.mConfigVersion;
    }

    public CombineDownload zN() {
        return this.alm;
    }

    public VersionData zO() {
        return this.alj;
    }

    public com.baidu.tbadk.coreExtra.data.e zP() {
        return this.alk;
    }

    public o zQ() {
        return this.alo;
    }
}
