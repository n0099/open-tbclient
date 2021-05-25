package com.baidu.tieba.ala.alasquare.live.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.m0.z0.w;
import tbclient.LiveSquare.DataReq;
import tbclient.LiveSquare.LiveSquareReqIdl;
/* loaded from: classes4.dex */
public class AlaSquareLiveRequestMessage extends NetMessage {
    public Integer mPn;

    public AlaSquareLiveRequestMessage(int i2, boolean z) {
        super(AlaCmdConfigHttp.CMD_SQUARE_LIVE, AlaCmdConfigSocket.CMD_SQUARE_LIVE);
        this.mPn = 0;
        this.mPn = Integer.valueOf(i2);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.pn = this.mPn;
            builder.scr_w = Integer.valueOf(l.k(TbadkCoreApplication.getInst()));
            builder.scr_h = Integer.valueOf(l.i(TbadkCoreApplication.getInst()));
            builder.q_type = 0;
            builder.scr_dip = Integer.valueOf((int) l.h(TbadkCoreApplication.getInst()));
            builder.network_type = String.valueOf(j.K());
            if (z) {
                w.a(builder, true);
            }
            LiveSquareReqIdl.Builder builder2 = new LiveSquareReqIdl.Builder();
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
