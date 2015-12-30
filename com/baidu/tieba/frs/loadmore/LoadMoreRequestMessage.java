package com.baidu.tieba.frs.loadmore;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.util.i;
import tbclient.ThreadList.DataReq;
import tbclient.ThreadList.ThreadListReqIdl;
/* loaded from: classes.dex */
public class LoadMoreRequestMessage extends NetMessage {
    private String forumName;
    private long forum_id;
    private int need_abstract;
    private int pn;
    private int st_type;
    private String thread_ids;

    public LoadMoreRequestMessage() {
        super(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
    }

    public void setThreadIds(String str) {
        this.thread_ids = str;
    }

    public void setForumId(long j) {
        this.forum_id = j;
    }

    public void setNeedAbstract(int i) {
        this.need_abstract = i;
    }

    public void setForumName(String str) {
        this.forumName = str;
    }

    public void setPageNumber(int i) {
        this.pn = i;
    }

    public void setStType(int i) {
        this.st_type = i;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.thread_ids = this.thread_ids;
        builder.forum_id = Long.valueOf(this.forum_id);
        builder.need_abstract = Integer.valueOf(this.need_abstract);
        builder.user_id = Long.valueOf(com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), 0L));
        builder.forum_name = this.forumName;
        builder.scr_dip = Double.valueOf(TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density);
        int K = k.K(TbadkCoreApplication.m411getInst());
        int L = k.L(TbadkCoreApplication.m411getInst());
        builder.pn = Integer.valueOf(this.pn);
        builder.st_type = Integer.valueOf(this.st_type);
        builder.scr_h = Integer.valueOf(L);
        builder.scr_w = Integer.valueOf(K);
        builder.q_type = Integer.valueOf(ay.va().vc() ? 2 : 1);
        if (z) {
            i.a(builder, true);
        }
        ThreadListReqIdl.Builder builder2 = new ThreadListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
