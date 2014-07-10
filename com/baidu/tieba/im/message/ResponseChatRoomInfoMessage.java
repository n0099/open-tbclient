package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
import protobuf.QueryChatroomInfo.QueryChatroomInfoResIdl;
import protobuf.UserInfo;
/* loaded from: classes.dex */
public class ResponseChatRoomInfoMessage extends SocketResponsedMessage {
    private String content;
    private int leftTime;
    private int maxUserNum;
    private int status;
    private String title;
    private List<UserInfo> userList;
    private int userNum;

    public ResponseChatRoomInfoMessage() {
        super(106001);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        QueryChatroomInfoResIdl queryChatroomInfoResIdl = (QueryChatroomInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryChatroomInfoResIdl.class);
        setError(queryChatroomInfoResIdl.error.errorno.intValue());
        setErrorString(queryChatroomInfoResIdl.error.usermsg);
        if (getError() == 0) {
            this.userNum = queryChatroomInfoResIdl.data.userNum.intValue();
            this.maxUserNum = queryChatroomInfoResIdl.data.maxUserNum.intValue();
            this.userList = queryChatroomInfoResIdl.data.userList;
            this.status = queryChatroomInfoResIdl.data.status.intValue();
            this.leftTime = queryChatroomInfoResIdl.data.leftTime.intValue();
            this.title = queryChatroomInfoResIdl.data.title;
            this.content = queryChatroomInfoResIdl.data.content;
        }
    }

    public int getUserNum() {
        return this.userNum;
    }

    public int getMaxUserNum() {
        return this.maxUserNum;
    }

    public List<UserInfo> getUserList() {
        return this.userList;
    }

    public int getStatus() {
        return this.status;
    }

    public int getLeftTime() {
        return this.leftTime;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }
}
