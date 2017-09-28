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
    private int asy;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int asw = 0;
    private int asx = 0;
    private VersionData asp = new VersionData();
    private i asq = new i();
    private j asr = new j();
    private CombineDownload ass = new CombineDownload();
    private n ast = new n();
    private r asu = new r();
    private k asz = new k();
    private com.baidu.tbadk.coreExtra.data.b asv = new com.baidu.tbadk.coreExtra.data.b();
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
                this.asp.parserJson(jSONObject.optJSONObject("version"));
                this.asq.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.asr.parserJson(jSONObject.optJSONObject("config"));
                this.asu.parserJson(jSONObject.optJSONObject("wl_config"));
                this.asz.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.asz);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.asx = jSONObject.optInt("is_uninterest");
                this.asy = jSONObject.optInt("first_time_motivate");
                this.ass.parserJson(jSONObject.optJSONObject("combine_download"));
                this.ast.parserJson(jSONObject.optJSONObject("mainbar"));
                this.asw = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().g(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                this.asv.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
                TbadkCoreApplication.getInst().saveKeepLiveSwitch(jSONObject.optInt("android_keepalive") == 0);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public j zz() {
        return this.asr;
    }

    public String zA() {
        return this.mConfigVersion;
    }

    public CombineDownload zB() {
        return this.ass;
    }

    public VersionData zC() {
        return this.asp;
    }

    public i zD() {
        return this.asq;
    }

    public r zE() {
        return this.asu;
    }

    public com.baidu.tbadk.coreExtra.data.b zF() {
        return this.asv;
    }

    public com.baidu.tbadk.coreExtra.data.a getAdAdSense() {
        return this.mAdAdSense;
    }

    public int zG() {
        return this.asx;
    }

    public boolean zH() {
        return this.asy == 1;
    }
}
