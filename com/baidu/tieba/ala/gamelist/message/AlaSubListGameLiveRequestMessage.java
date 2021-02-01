package com.baidu.tieba.ala.gamelist.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.v;
import tbclient.LiveTabliveSubTab.DataReq;
import tbclient.LiveTabliveSubTab.LiveTabliveSubTabReqIdl;
/* loaded from: classes10.dex */
public class AlaSubListGameLiveRequestMessage extends NetMessage {
    public Integer entryId;
    public String entryName;
    public String labelName;
    private Integer mPn;
    public int sort_type;

    public AlaSubListGameLiveRequestMessage(int i, int i2, String str, String str2, int i3) {
        super(AlaCmdConfigHttp.CMD_ALA_SUB_LIVE_LIST, AlaCmdConfigSocket.CMD_ALA_SUB_LIVE_LIST);
        this.mPn = 0;
        this.entryId = 0;
        this.mPn = Integer.valueOf(i);
        this.entryId = Integer.valueOf(i2);
        this.entryName = str;
        this.labelName = str2;
        this.sort_type = i3;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.pn = this.mPn;
            builder.scr_w = Integer.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst()));
            builder.scr_h = Integer.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst()));
            builder.q_type = 0;
            builder.scr_dip = Double.valueOf(l.getEquipmentDensity(TbadkCoreApplication.getInst()));
            builder.entry_id = this.entryId;
            builder.entry_name = this.entryName;
            builder.label_name = this.labelName;
            builder.sort_type = Integer.valueOf(this.sort_type);
            if (z) {
                v.b(builder, true);
            }
            LiveTabliveSubTabReqIdl.Builder builder2 = new LiveTabliveSubTabReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception e) {
            return null;
        }
    }

    public int getPn() {
        return this.mPn.intValue();
    }
}
