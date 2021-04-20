package com.baidu.tieba.ala.alasquare.subtablist.message;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class AlaNewSquareSubListRequestMessage extends HttpMessage {
    public String entryName;
    public String lableName;
    public String lat;
    public String lng;
    public int pn;
    public int ps;
    public String sortType;

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
        addParam("entry_name", this.entryName);
        addParam(Config.PACKAGE_NAME, this.pn);
        addParam("ps", this.ps);
        addParam("scr_w", l.k(TbadkCoreApplication.getInst()));
        addParam("scr_h", l.i(TbadkCoreApplication.getInst()));
        addParam("q_type", 0);
        addParam("scr_dip", String.valueOf(l.h(TbadkCoreApplication.getInst())));
        addParam("label_name", this.lableName);
        addParam("sort_type", this.sortType);
        addParam(SuggestAddrField.KEY_LAT, this.lat);
        addParam(SuggestAddrField.KEY_LNG, this.lng);
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

    public void setPn(int i) {
        this.pn = i;
    }

    public void setPs(int i) {
        this.ps = i;
    }

    public void setSortType(String str) {
        this.sortType = str;
    }
}
