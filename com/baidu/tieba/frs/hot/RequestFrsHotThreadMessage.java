package com.baidu.tieba.frs.hot;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.m;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.util.g;
import tbclient.GetHotThread.DataReq;
import tbclient.GetHotThread.GetHotThreadReqIdl;
/* loaded from: classes.dex */
public class RequestFrsHotThreadMessage extends NetMessage {
    private long mForumId;
    private int mPn;

    public RequestFrsHotThreadMessage(long j, int i) {
        super(CmdConfigHttp.FRS_HOT_TAB_CMD, 301003);
        this.mForumId = j;
        this.mPn = i < 0 ? 1 : i;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.scr_w = Integer.valueOf(k.K(TbadkCoreApplication.m411getInst()));
        builder.scr_h = Integer.valueOf(k.L(TbadkCoreApplication.m411getInst()));
        builder.scr_dip = Double.valueOf(TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density);
        builder.q_type = Integer.valueOf(ar.uE().uG() ? 2 : 1);
        if (m.rd().rh()) {
            builder.rn = 35;
        } else {
            builder.rn = 50;
        }
        builder.need_abstract = 1;
        builder.need_photo_pic = 0;
        builder.order_type = 1;
        builder.forum_id = Long.valueOf(this.mForumId);
        builder.pn = Integer.valueOf(this.mPn);
        if (z) {
            g.a(builder, true);
        }
        GetHotThreadReqIdl.Builder builder2 = new GetHotThreadReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getForumId() {
        return this.mForumId;
    }
}
