package com.baidu.tbadk.coreExtra.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import com.baidu.tbadk.coreExtra.data.i;
import com.baidu.tbadk.coreExtra.data.j;
import com.baidu.tbadk.coreExtra.data.k;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.coreExtra.data.r;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int ass;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int asq = 0;
    private int asr = 0;
    private VersionData asj = new VersionData();
    private i ask = new i();
    private j asl = new j();
    private CombineDownload asm = new CombineDownload();
    private n asn = new n();
    private r aso = new r();
    private k ast = new k();
    private com.baidu.tbadk.coreExtra.data.b asp = new com.baidu.tbadk.coreExtra.data.b();
    private com.baidu.tbadk.coreExtra.data.a mAdAdSense = new com.baidu.tbadk.coreExtra.data.a();

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
                this.asj.parserJson(jSONObject.optJSONObject("version"));
                this.ask.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.asl.parserJson(jSONObject.optJSONObject("config"));
                this.aso.parserJson(jSONObject.optJSONObject("wl_config"));
                this.ast.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.ast);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.asr = jSONObject.optInt("is_uninterest");
                this.ass = jSONObject.optInt("first_time_motivate");
                this.asm.parserJson(jSONObject.optJSONObject("combine_download"));
                this.asn.parserJson(jSONObject.optJSONObject("mainbar"));
                this.asq = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_ADS_EMOTION, jSONObject));
                this.mFaceShopVersion = jSONObject.optInt("faceshop_version");
                if (this.mFaceShopVersion > TbadkCoreApplication.getInst().getFaceShopVersion()) {
                    TbadkCoreApplication.getInst().setTempFaceShopVersion(this.mFaceShopVersion);
                    TbadkCoreApplication.getInst().setFaceShopNew(true);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
                if (optJSONObject != null) {
                    TbadkCoreApplication.getInst().setLcsSwitchStratgy(optJSONObject.toString());
                }
                new b().l(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                this.asp.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public j zP() {
        return this.asl;
    }

    public String zQ() {
        return this.mConfigVersion;
    }

    public CombineDownload zR() {
        return this.asm;
    }

    public VersionData zS() {
        return this.asj;
    }

    public i zT() {
        return this.ask;
    }

    public r zU() {
        return this.aso;
    }

    public com.baidu.tbadk.coreExtra.data.b zV() {
        return this.asp;
    }

    public com.baidu.tbadk.coreExtra.data.a getAdAdSense() {
        return this.mAdAdSense;
    }

    public int zW() {
        return this.asr;
    }

    public boolean zX() {
        return this.ass == 1;
    }
}
