package com.baidu.tieba.ala.alasquare.live.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.t;
import tbclient.LiveSquare.DataReq;
import tbclient.LiveSquare.LiveSquareReqIdl;
/* loaded from: classes10.dex */
public class AlaSquareLiveRequestMessage extends NetMessage {
    private Integer mPn;

    public AlaSquareLiveRequestMessage(int i, boolean z) {
        super(AlaCmdConfigHttp.CMD_SQUARE_LIVE, AlaCmdConfigSocket.CMD_SQUARE_LIVE);
        this.mPn = 0;
        this.mPn = Integer.valueOf(i);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.pn = this.mPn;
            builder.scr_w = Integer.valueOf(l.getEquipmentWidth(TbadkCoreApplication.getInst()));
            builder.scr_h = Integer.valueOf(l.getEquipmentHeight(TbadkCoreApplication.getInst()));
            builder.q_type = 0;
            builder.scr_dip = Integer.valueOf((int) l.getEquipmentDensity(TbadkCoreApplication.getInst()));
            builder.network_type = String.valueOf(j.netTypeNameInUpperCase());
            if (z) {
                t.b(builder, true);
            }
            LiveSquareReqIdl.Builder builder2 = new LiveSquareReqIdl.Builder();
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
