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
    private int atM;
    private String mConfigVersion;
    private int mFaceShopVersion;
    private int atK = 0;
    private int atL = 0;
    private VersionData atD = new VersionData();
    private i atE = new i();
    private j atF = new j();
    private CombineDownload atG = new CombineDownload();
    private n atH = new n();
    private r atI = new r();
    private k atN = new k();
    private com.baidu.tbadk.coreExtra.data.b atJ = new com.baidu.tbadk.coreExtra.data.b();
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
                this.atD.parserJson(jSONObject.optJSONObject("version"));
                this.atE.parserJson(jSONObject.optJSONObject("client"));
                com.baidu.tbadk.core.util.d.setIp(jSONObject.optString("client_ip", null));
                this.atF.parserJson(jSONObject.optJSONObject("config"));
                this.atI.parserJson(jSONObject.optJSONObject("wl_config"));
                this.atN.parserJson(jSONObject.optJSONObject("consume_path"));
                TbadkCoreApplication.getInst().setConsumePathData(this.atN);
                this.mConfigVersion = jSONObject.optString("config_version");
                this.atL = jSONObject.optInt("is_uninterest");
                this.atM = jSONObject.optInt("first_time_motivate");
                this.atG.parserJson(jSONObject.optJSONObject("combine_download"));
                this.atH.parserJson(jSONObject.optJSONObject("mainbar"));
                this.atK = jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
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
                new b().m(jSONObject.optJSONObject("dis_adv_config"));
                new WhiteListData().saveJson(jSONObject.optJSONArray("whitelist"));
                this.atJ.parserJson(jSONObject.optJSONObject("app_entrance"));
                this.mAdAdSense.parserJson(jSONObject.optJSONObject("ad_adsense"));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public j zX() {
        return this.atF;
    }

    public String zY() {
        return this.mConfigVersion;
    }

    public CombineDownload zZ() {
        return this.atG;
    }

    public VersionData Aa() {
        return this.atD;
    }

    public i Ab() {
        return this.atE;
    }

    public r Ac() {
        return this.atI;
    }

    public com.baidu.tbadk.coreExtra.data.b Ad() {
        return this.atJ;
    }

    public com.baidu.tbadk.coreExtra.data.a getAdAdSense() {
        return this.mAdAdSense;
    }

    public int Ae() {
        return this.atL;
    }

    public boolean Af() {
        return this.atM == 1;
    }
}
