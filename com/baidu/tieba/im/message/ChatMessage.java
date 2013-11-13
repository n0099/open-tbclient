package com.baidu.tieba.im.message;

import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.messageCenter.c;
import com.tencent.mm.sdk.conversation.RConversation;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ChatMessage extends Message implements c {

    /* renamed from: a  reason: collision with root package name */
    private transient MsgCacheData f1726a;
    private String content;
    private String groupId;
    private int height;
    private MsgLocalData localData;
    private long logTime;
    private long msgId;
    private int msgType;
    private Object objContent;
    private long recordId;
    private long time;
    private long userId;
    private UserData userInfo;
    private int width;

    public ChatMessage() {
        setCmd(202001);
    }

    public Object getObjContent() {
        return this.objContent;
    }

    public void setObjContent(Object obj) {
        this.objContent = obj;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public void setMsgType(int i) {
        this.msgType = i;
    }

    public long getRecordId() {
        return this.recordId;
    }

    public void setRecordId(long j) {
        this.recordId = j;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public void setMsgId(long j) {
        this.msgId = j;
    }

    public UserData getUserInfo() {
        return this.userInfo;
    }

    public void setUserInfo(UserData userData) {
        this.userInfo = userData;
    }

    public MsgLocalData getLocalData() {
        return this.localData;
    }

    public void setLocalData(MsgLocalData msgLocalData) {
        this.localData = msgLocalData;
    }

    public MsgCacheData getCacheData() {
        return this.f1726a;
    }

    public void setCacheData(MsgCacheData msgCacheData) {
        this.f1726a = msgCacheData;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
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

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public long getLogTime() {
        return this.logTime;
    }

    public void setLogTime(long j) {
        this.logTime = j;
    }

    @Override // com.baidu.tieba.im.messageCenter.c
    public boolean onFindMessage(Message message) {
        return message != null && (message instanceof ChatMessage) && ((ChatMessage) message).getRecordId() == this.recordId;
    }

    @Override // com.baidu.tieba.im.message.Message
    public Map toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", String.valueOf(202001));
        hashMap.put("groupId", this.groupId);
        hashMap.put(RConversation.COL_MSGTYPE, String.valueOf(this.msgType));
        hashMap.put("content", this.content);
        hashMap.put("recordId", String.valueOf(this.recordId));
        return hashMap;
    }
}
