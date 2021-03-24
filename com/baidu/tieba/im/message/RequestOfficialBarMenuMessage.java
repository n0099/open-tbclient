package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import d.b.b.e.m.b;
import tbclient.ForumMenu.DataReq;
import tbclient.ForumMenu.ForumMenuReqIdl;
/* loaded from: classes4.dex */
public class RequestOfficialBarMenuMessage extends TbSocketMessage {
    public String forum_id;
    public long timestamp;

    public RequestOfficialBarMenuMessage() {
        super(303006);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Integer.valueOf(b.d(getForum_id(), 0));
        builder.update_time = Integer.valueOf((int) getTimestamp());
        ForumMenuReqIdl.Builder builder2 = new ForumMenuReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public String getForum_id() {
        return this.forum_id;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setForum_id(String str) {
        this.forum_id = str;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
