package com.baidu.tieba.ala.alasquare.subtablist.message;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.webkit.internal.ETAG;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class AlaNewSquareSubListRequestMessage extends HttpMessage {
    public String entryName;
    public String lableName;
    public String lat;
    public String lng;
    public int pn;
    public int ps;
    public int refreshCount;
    public int refreshType;
    public long sessionId;
    public String sortType;
    public int tabId;

    public AlaNewSquareSubListRequestMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST);
    }

    public int getPn() {
        return this.pn;
    }

    public void setEntryName(String str) {
        this.entryName = str;
    }

    public void setHttpParams() {
        int k = l.k(TbadkCoreApplication.getInst());
        int i2 = l.i(TbadkCoreApplication.getInst());
        float h2 = l.h(TbadkCoreApplication.getInst());
        addParam("entry_name", this.entryName);
        addParam(Config.PACKAGE_NAME, this.pn);
        addParam("ps", this.ps);
        addParam("scr_w", k);
        addParam("scr_h", i2);
        addParam("q_type", 0);
        addParam("scr_dip", String.valueOf(h2));
        addParam("label_name", this.lableName);
        addParam("sort_type", this.sortType);
        addParam(SuggestAddrField.KEY_LAT, this.lat);
        addParam(SuggestAddrField.KEY_LNG, this.lng);
        String str = "N";
        if (j.z()) {
            if (j.H()) {
                str = "1_0";
            } else if (j.v()) {
                str = "0_13";
            } else if (j.u()) {
                str = "0_3";
            } else if (j.t()) {
                str = "0_2";
            }
        }
        addParam("network", str);
        addParam("ua_str", k + "_" + i2 + "_android_" + TbConfig.getVersion());
        addParam("tab_id", this.tabId);
        addParam("refresh_type", this.refreshType);
        addParam(ETAG.KEY_STATISTICS_SEESIONID, this.sessionId);
        addParam("big_refresh_count", this.refreshCount);
    }

    public void setLableName(String str) {
        this.lableName = str;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public void setPn(int i2) {
        this.pn = i2;
    }

    public void setPs(int i2) {
        this.ps = i2;
    }

    public void setSortType(String str) {
        this.sortType = str;
    }
}
