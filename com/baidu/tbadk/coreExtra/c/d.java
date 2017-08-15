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
    private int atL;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int atJ = 0;
    private int atK = 0;
    private VersionData atC = new VersionData();
    private i atD = new i();
    private j atE = new j();
    private CombineDownload atF = new CombineDownload();
    private n atG = new n();
    private r atH = new r();
    private k atM = new k();
    private com.baidu.tbadk.coreExtra.data.b atI = new com.baidu.tbadk.coreExtra.data.b();
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
                this.atC.parserJson(jSONObject.optJSONObject("version"));
                this.atD.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.atE.parserJson(jSONObject.optJSONObject("config"));
                this.atH.parserJson(jSONObject.optJSONObject("wl_config"));
                this.atM.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.atM);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.atK = jSONObject.optInt("is_uninterest");
                this.atL = jSONObject.optInt("first_time_motivate");
                this.atF.parserJson(jSONObject.optJSONObject("combine_download"));
                this.atG.parserJson(jSONObject.optJSONObject("mainbar"));
                this.atJ = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                this.atI.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public j zX() {
        return this.atE;
    }

    public String zY() {
        return this.mConfigVersion;
    }

    public CombineDownload zZ() {
        return this.atF;
    }

    public VersionData Aa() {
        return this.atC;
    }

    public i Ab() {
        return this.atD;
    }

    public r Ac() {
        return this.atH;
    }

    public com.baidu.tbadk.coreExtra.data.b Ad() {
        return this.atI;
    }

    public com.baidu.tbadk.coreExtra.data.a getAdAdSense() {
        return this.mAdAdSense;
    }

    public int Ae() {
        return this.atK;
    }

    public boolean Af() {
        return this.atL == 1;
    }
}
