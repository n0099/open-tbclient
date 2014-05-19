package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
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
        super(MessageTypes.CMD_QUERY_CHAT_ROOM_INFO);
    }

    public String toString() {
        return "ResponseChatRoomInfoMessage{userNum=" + this.userNum + ", maxUserNum=" + this.maxUserNum + ", userList=" + this.userList + ", status=" + this.status + ", leftTime=" + this.leftTime + ", title='" + this.title + "', content='" + this.content + "'}";
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
            BdLog.d(toString());
        }
    }

    public int getUserNum() {
        return this.userNum;
    }

    public void setUserNum(int i) {
        this.userNum = i;
    }

    public int getMaxUserNum() {
        return this.maxUserNum;
    }

    public void setMaxUserNum(int i) {
        this.maxUserNum = i;
    }

    public List<UserInfo> getUserList() {
        return this.userList;
    }

    public void setUserList(List<UserInfo> list) {
        this.userList = list;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public int getLeftTime() {
        return this.leftTime;
    }

    public void setLeftTime(int i) {
        this.leftTime = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }
}
