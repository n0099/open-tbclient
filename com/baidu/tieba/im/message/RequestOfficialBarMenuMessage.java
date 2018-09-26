package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import tbclient.ForumMenu.DataReq;
import tbclient.ForumMenu.ForumMenuReqIdl;
/* loaded from: classes3.dex */
public class RequestOfficialBarMenuMessage extends TbSocketMessage {
    private String forum_id;
    private long timestamp;

    public RequestOfficialBarMenuMessage() {
        super(303006);
    }

    public String getForum_id() {
        return this.forum_id;
    }

    public void setForum_id(String str) {
        this.forum_id = str;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Integer.valueOf(com.baidu.adp.lib.g.b.l(getForum_id(), 0));
        builder.update_time = Integer.valueOf((int) getTimestamp());
        ForumMenuReqIdl.Builder builder2 = new ForumMenuReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
