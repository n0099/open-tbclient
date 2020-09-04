package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class CommitVoteReqMsg extends HttpMessage {
    public long candidate_uid;
    public long forum_id;
    public int source;
    public long thread_id;

    public CommitVoteReqMsg(long j, long j2, long j3, int i) {
        super(CmdConfigHttp.CMD_BAR_VOTE);
        this.candidate_uid = j;
        this.forum_id = j2;
        this.thread_id = j3;
        this.source = i;
        addParam("candidate_uid", j);
        addParam("forum_id", j2);
        addParam("thread_id", j3);
        addParam("source", i);
        addHeader("needSig", "1");
        addParam("check_new_sig", "1");
        addParam("subapp_type", "tieba");
    }
}
