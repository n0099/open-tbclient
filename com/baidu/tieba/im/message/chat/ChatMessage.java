package com.baidu.tieba.im.message.chat;

import com.baidu.adp.framework.client.socket.a;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.MsgLocalData;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class ChatMessage extends TbSocketMessage implements a {
    private long bornTime;
    private transient MsgCacheData cacheData;
    private String content;
    private com.baidu.tbadk.gif.a gifInfo;
    private String groupId;
    public boolean hasRepeat;
    private int height;
    private boolean isGifLoadSuccess;
    private boolean isUploading;
    private String link;
    private MsgLocalData localData;
    private long logTime;
    private LinkedList<IconData> mTShowIconInfo;
    private long mToUserId;
    private long msgId;
    private int msgType;
    private Object objContent;
    private int progressValue;
    private long recordId;
    private String stat;
    private long taskId;
    private long time;
    private UserData toUserInfo;
    private long userId;
    private UserData userInfo;
    private int width;

    public ChatMessage(int i) {
        super(i);
        this.progressValue = 0;
        this.isGifLoadSuccess = true;
        this.isUploading = false;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public long getBornTime() {
        return this.bornTime;
    }

    public void setBornTime(long j) {
        this.bornTime = j;
    }

    public long getToUserId() {
        return this.mToUserId;
    }

    public void setToUserId(long j) {
        this.mToUserId = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.baidu.tbadk.gif.a getGifInfo() {
        JSONObject jSONObject;
        JSONArray jSONArray;
        if (this.gifInfo != null) {
            return this.gifInfo;
        }
        String str = this.content;
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException e) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
            }
        }
        if (jSONArray.length() > 0) {
            jSONObject = jSONArray.getJSONObject(0);
            if (jSONObject == null) {
                String optString = jSONObject.optString("face_name");
                String optString2 = jSONObject.optString("url_s");
                String optString3 = jSONObject.optString("url_d");
                String optString4 = jSONObject.optString("pid");
                String optString5 = jSONObject.optString("packet_name");
                String optString6 = jSONObject.optString("icon");
                int optInt = jSONObject.optInt("size_width");
                int optInt2 = jSONObject.optInt("size_height");
                com.baidu.tbadk.gif.a aVar = new com.baidu.tbadk.gif.a();
                aVar.a = false;
                aVar.b = optString;
                aVar.c = optString2;
                aVar.d = optString3;
                aVar.e = optString4;
                aVar.f = optInt;
                aVar.g = optInt2;
                aVar.h = optString5;
                aVar.i = optString6;
                this.gifInfo = aVar;
                return aVar;
            }
            return null;
        }
        jSONObject = null;
        if (jSONObject == null) {
        }
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public String getStat() {
        return this.stat;
    }

    public void setStat(String str) {
        this.stat = str;
    }

    public long getTaskId() {
        return this.taskId;
    }

    public void setTaskId(long j) {
        this.taskId = j;
    }

    public void setTShowInfo(LinkedList<IconData> linkedList) {
        this.mTShowIconInfo = linkedList;
    }

    public LinkedList<IconData> getTShowInfo() {
        return this.mTShowIconInfo;
    }

    public boolean getIsUploading() {
        return this.isUploading;
    }

    public void setIsUploading(boolean z) {
        this.isUploading = z;
    }

    public int getProgressValue() {
        return this.progressValue;
    }

    public void setProgressValue(int i) {
        this.progressValue = i;
    }

    public Object getObjContent() {
        return this.objContent;
    }

    public void setObjContent(Object obj) {
        this.objContent = obj;
    }

    public UserData getUserInfo() {
        return this.userInfo;
    }

    public void setUserInfo(UserData userData) {
        this.userInfo = userData;
    }

    public UserData getToUserInfo() {
        return this.toUserInfo;
    }

    public void setToUserInfo(UserData userData) {
        this.toUserInfo = userData;
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

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public MsgLocalData getLocalData() {
        return this.localData;
    }

    public void setLocalData(MsgLocalData msgLocalData) {
        this.localData = msgLocalData;
    }

    public MsgCacheData getCacheData() {
        return this.cacheData;
    }

    public void setCacheData(MsgCacheData msgCacheData) {
        this.cacheData = msgCacheData;
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

    public boolean isGifLoadSuccess() {
        return this.isGifLoadSuccess;
    }

    public void setGifLoadSuccess(boolean z) {
        this.isGifLoadSuccess = z;
    }

    public long getLogTime() {
        return this.logTime;
    }

    public void setLogTime(long j) {
        this.logTime = j;
    }

    public String toString() {
        return "ChatMessage{msgType=" + this.msgType + ", objContent=" + this.objContent + ", content='" + this.content + "', recordId=" + this.recordId + ", msgId=" + this.msgId + ", time=" + this.time + ", width=" + this.width + ", height=" + this.height + ", userId=" + this.userId + ", userInfo=" + this.userInfo + ", toUserInfo=" + this.toUserInfo + ", localData=" + this.localData + ", cacheData=" + this.cacheData + ", progressValue=" + this.progressValue + ", mToUserId=" + this.mToUserId + ", isGifLoadSuccess=" + this.isGifLoadSuccess + ", isUploading=" + this.isUploading + ", logTime=" + this.logTime + ", mTShowIconInfo=" + this.mTShowIconInfo + '}';
    }

    @Override // com.baidu.adp.framework.client.socket.a
    public boolean onFindMessage(SocketMessage socketMessage) {
        if (socketMessage != null && (socketMessage instanceof ChatMessage)) {
            ChatMessage chatMessage = (ChatMessage) socketMessage;
            return chatMessage.getRecordId() == this.recordId && chatMessage.getGroupId().equals(this.groupId) && chatMessage.getToUserId() == this.mToUserId;
        }
        return false;
    }
}
