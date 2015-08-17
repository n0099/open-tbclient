package com.baidu.tieba.frs.loadmore;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.g;
import tbclient.ThreadList.DataReq;
import tbclient.ThreadList.ThreadListReqIdl;
/* loaded from: classes.dex */
public class LoadMoreRequestMessage extends NetMessage {
    private long forum_id;
    private int need_abstract;
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

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.forum_id);
        builder.thread_ids = this.thread_ids;
        builder.need_abstract = Integer.valueOf(this.need_abstract);
        if (z) {
            g.a(builder, true);
        }
        ThreadListReqIdl.Builder builder2 = new ThreadListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
