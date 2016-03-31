package com.baidu.tieba.enterForum.square;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.l;
import tbclient.GetForumClassList.DataReq;
import tbclient.GetForumClassList.GetForumClassListReqIdl;
/* loaded from: classes.dex */
public class ForumClassRequestNetMessage extends NetMessage {
    public ForumClassRequestNetMessage() {
        super(CmdConfigHttp.CMD_FORUM_CLASS_LIST, 309089);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        int B = k.B(TbadkCoreApplication.m411getInst().getApp());
        int C = k.C(TbadkCoreApplication.m411getInst().getApp());
        DataReq.Builder builder = new DataReq.Builder();
        builder.scr_w = Integer.valueOf(B);
        builder.scr_h = Integer.valueOf(C);
        builder.scr_dip = Double.valueOf(k.D(TbadkCoreApplication.m411getInst().getApp()));
        builder.q_type = Long.valueOf(l.qE().getViewImageQuality());
        if (z) {
            com.baidu.tbadk.util.l.a(builder, true);
        }
        GetForumClassListReqIdl.Builder builder2 = new GetForumClassListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
