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
    private int arB;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int arz = 0;
    private int arA = 0;
    private VersionData ars = new VersionData();
    private i art = new i();
    private j aru = new j();
    private CombineDownload arv = new CombineDownload();
    private n arw = new n();
    private r arx = new r();
    private k arC = new k();
    private com.baidu.tbadk.coreExtra.data.b ary = new com.baidu.tbadk.coreExtra.data.b();
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
                this.ars.parserJson(jSONObject.optJSONObject("version"));
                this.art.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.aru.parserJson(jSONObject.optJSONObject("config"));
                this.arx.parserJson(jSONObject.optJSONObject("wl_config"));
                this.arC.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.m9getInst().setConsumePathData(this.arC);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.arA = jSONObject.optInt("is_uninterest");
                this.arB = jSONObject.optInt("first_time_motivate");
                this.arv.parserJson(jSONObject.optJSONObject("combine_download"));
                this.arw.parserJson(jSONObject.optJSONObject("mainbar"));
                this.arz = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                this.ary.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public j zE() {
        return this.aru;
    }

    public String zF() {
        return this.mConfigVersion;
    }

    public CombineDownload zG() {
        return this.arv;
    }

    public VersionData zH() {
        return this.ars;
    }

    public i zI() {
        return this.art;
    }

    public r zJ() {
        return this.arx;
    }

    public com.baidu.tbadk.coreExtra.data.b zK() {
        return this.ary;
    }

    public com.baidu.tbadk.coreExtra.data.a getAdAdSense() {
        return this.mAdAdSense;
    }

    public int zL() {
        return this.arA;
    }

    public boolean zM() {
        return this.arB == 1;
    }
}
