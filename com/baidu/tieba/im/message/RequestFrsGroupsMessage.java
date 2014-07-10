package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryGroupsByFid.DataReq;
import protobuf.QueryGroupsByFid.QueryGroupsByFidReqIdl;
/* loaded from: classes.dex */
public class RequestFrsGroupsMessage extends TbSocketMessage {
    private String forumId;
    private int height;
    private String offset;
    private String rn;
    private String type;
    private int width;

    public RequestFrsGroupsMessage() {
        super(103002);
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public String getForumId() {
        return this.forumId;
    }

    public void setForumId(String str) {
        this.forumId = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getOffset() {
        return this.offset;
    }

    public void setOffset(String str) {
        this.offset = str;
    }

    public String getRn() {
        return this.rn;
    }

    public void setRn(String str) {
        this.rn = str;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forumId = Integer.valueOf(com.baidu.adp.lib.f.b.a(getForumId(), 0));
        builder.offset = Integer.valueOf(com.baidu.adp.lib.f.b.a(getOffset(), 0));
        builder.rn = Integer.valueOf(com.baidu.adp.lib.f.b.a(getRn(), 0));
        builder.type = Integer.valueOf(com.baidu.adp.lib.f.b.a(getType(), 0));
        builder.width = Integer.valueOf(getWidth());
        builder.height = Integer.valueOf(getHeight());
        QueryGroupsByFidReqIdl.Builder builder2 = new QueryGroupsByFidReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
