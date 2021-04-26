package com.baidu.tieba.ala.gamelist.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.c.e.p.l;
import d.a.i0.z0.w;
import tbclient.LiveTabliveSubTab.DataReq;
import tbclient.LiveTabliveSubTab.LiveTabliveSubTabReqIdl;
/* loaded from: classes4.dex */
public class AlaSubListGameLiveRequestMessage extends NetMessage {
    public Integer entryId;
    public String entryName;
    public String labelName;
    public Integer mPn;
    public int sort_type;

    public AlaSubListGameLiveRequestMessage(int i2, int i3, String str, String str2, int i4) {
        super(AlaCmdConfigHttp.CMD_ALA_SUB_LIVE_LIST, AlaCmdConfigSocket.CMD_ALA_SUB_LIVE_LIST);
        this.mPn = 0;
        this.entryId = 0;
        this.mPn = Integer.valueOf(i2);
        this.entryId = Integer.valueOf(i3);
        this.entryName = str;
        this.labelName = str2;
        this.sort_type = i4;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.pn = this.mPn;
            builder.scr_w = Integer.valueOf(l.k(TbadkCoreApplication.getInst()));
            builder.scr_h = Integer.valueOf(l.i(TbadkCoreApplication.getInst()));
            builder.q_type = 0;
            builder.scr_dip = Double.valueOf(l.h(TbadkCoreApplication.getInst()));
            builder.entry_id = this.entryId;
            builder.entry_name = this.entryName;
            builder.label_name = this.labelName;
            builder.sort_type = Integer.valueOf(this.sort_type);
            if (z) {
                w.a(builder, true);
            }
            LiveTabliveSubTabReqIdl.Builder builder2 = new LiveTabliveSubTabReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        } catch (Exception unused) {
            return null;
        }
    }

    public int getPn() {
        return this.mPn.intValue();
    }
}
