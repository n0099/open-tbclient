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
    private int atK;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int atI = 0;
    private int atJ = 0;
    private VersionData atB = new VersionData();
    private i atC = new i();
    private j atD = new j();
    private CombineDownload atE = new CombineDownload();
    private n atF = new n();
    private r atG = new r();
    private k atL = new k();
    private com.baidu.tbadk.coreExtra.data.b atH = new com.baidu.tbadk.coreExtra.data.b();
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
                this.atB.parserJson(jSONObject.optJSONObject("version"));
                this.atC.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.atD.parserJson(jSONObject.optJSONObject("config"));
                this.atG.parserJson(jSONObject.optJSONObject("wl_config"));
                this.atL.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.atL);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.atJ = jSONObject.optInt("is_uninterest");
                this.atK = jSONObject.optInt("first_time_motivate");
                this.atE.parserJson(jSONObject.optJSONObject("combine_download"));
                this.atF.parserJson(jSONObject.optJSONObject("mainbar"));
                this.atI = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                this.atH.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public j zX() {
        return this.atD;
    }

    public String zY() {
        return this.mConfigVersion;
    }

    public CombineDownload zZ() {
        return this.atE;
    }

    public VersionData Aa() {
        return this.atB;
    }

    public i Ab() {
        return this.atC;
    }

    public r Ac() {
        return this.atG;
    }

    public com.baidu.tbadk.coreExtra.data.b Ad() {
        return this.atH;
    }

    public com.baidu.tbadk.coreExtra.data.a getAdAdSense() {
        return this.mAdAdSense;
    }

    public int Ae() {
        return this.atJ;
    }

    public boolean Af() {
        return this.atK == 1;
    }
}
