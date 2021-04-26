package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.QueryGroupsByUid.DataReq;
import protobuf.QueryGroupsByUid.QueryGroupsByUidReqIdl;
/* loaded from: classes4.dex */
public class GroupsByUidMessage extends TbSocketMessage {
    public long friendUid;
    public int height;
    public int isFriend;
    public int width;

    public GroupsByUidMessage(int i2, int i3) {
        super(103003);
        this.width = i2;
        this.height = i3;
        this.friendUid = 0L;
        this.isFriend = 0;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.width = Integer.valueOf(getWidth());
        builder.height = Integer.valueOf(getHeight());
        if (this.isFriend == 1) {
            builder.friendId = Long.valueOf(getFriendUid());
            builder.isGuest = Integer.valueOf(getIsFriend());
        }
        QueryGroupsByUidReqIdl.Builder builder2 = new QueryGroupsByUidReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getFriendUid() {
        return this.friendUid;
    }

    public int getHeight() {
        return this.height;
    }

    public int getIsFriend() {
        return this.isFriend;
    }

    public int getWidth() {
        return this.width;
    }

    public void setFriendUid(long j) {
        this.friendUid = j;
    }

    public void setHeight(int i2) {
        this.height = i2;
    }

    public void setIsGuest(int i2) {
        this.isFriend = i2;
    }

    public void setWidth(int i2) {
        this.width = i2;
    }

    public GroupsByUidMessage(long j, int i2, int i3) {
        super(103003);
        this.width = i2;
        this.height = i3;
        this.friendUid = j;
        this.isFriend = 1;
    }
}
