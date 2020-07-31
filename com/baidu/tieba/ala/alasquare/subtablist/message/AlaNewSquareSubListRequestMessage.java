package com.baidu.tieba.ala.alasquare.subtablist.message;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
/* loaded from: classes4.dex */
public class AlaNewSquareSubListRequestMessage extends HttpMessage {
    private String entryName;
    private String lableName;
    private String lat;
    private String lng;
    private int pn;
    private int ps;
    private String sortType;

    public AlaNewSquareSubListRequestMessage() {
        super(AlaCmdConfigHttp.CMD_ALA_NEW_SQUARE_SUB_LIST);
    }

    public void setPn(int i) {
        this.pn = i;
    }

    public int getPn() {
        return this.pn;
    }

    public void setPs(int i) {
        this.ps = i;
    }

    public void setSortType(String str) {
        this.sortType = str;
    }

    public void setEntryName(String str) {
        this.entryName = str;
    }

    public void setLableName(String str) {
        this.lableName = str;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public void setHttpParams() {
        addParam("entry_name", this.entryName);
        addParam(Config.PACKAGE_NAME, this.pn);
        addParam("ps", this.ps);
        addParam("scr_w", l.getEquipmentWidth(TbadkCoreApplication.getInst()));
        addParam("scr_h", l.getEquipmentHeight(TbadkCoreApplication.getInst()));
        addParam("q_type", 0);
        addParam("scr_dip", String.valueOf(l.getEquipmentDensity(TbadkCoreApplication.getInst())));
        addParam("label_name", this.lableName);
        addParam(PbActivityConfig.KEY_SORTTYPE, this.sortType);
        addParam("lat", this.lat);
        addParam("lng", this.lng);
    }
}
