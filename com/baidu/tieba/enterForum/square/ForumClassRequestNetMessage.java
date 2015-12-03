package com.baidu.tieba.enterForum.square;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.m;
import com.baidu.tbadk.util.i;
import tbclient.GetForumClassList.DataReq;
import tbclient.GetForumClassList.GetForumClassListReqIdl;
/* loaded from: classes.dex */
public class ForumClassRequestNetMessage extends NetMessage {
    public ForumClassRequestNetMessage() {
        super(CmdConfigHttp.CMD_FORUM_CLASS_LIST, 309089);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        int K = k.K(TbadkCoreApplication.m411getInst().getApp());
        int L = k.L(TbadkCoreApplication.m411getInst().getApp());
        DataReq.Builder builder = new DataReq.Builder();
        builder.scr_w = Integer.valueOf(K);
        builder.scr_h = Integer.valueOf(L);
        builder.scr_dip = Double.valueOf(k.M(TbadkCoreApplication.m411getInst().getApp()));
        builder.q_type = Long.valueOf(m.rh().getViewImageQuality());
        if (z) {
            i.a(builder, true);
        }
        GetForumClassListReqIdl.Builder builder2 = new GetForumClassListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
