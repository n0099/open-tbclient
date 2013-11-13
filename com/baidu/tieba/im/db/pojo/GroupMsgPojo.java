package com.baidu.tieba.im.db.pojo;

import android.text.TextUtils;
import com.baidu.adp.lib.h.d;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.d.c;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.message.ChatMessage;
import com.google.gson.Gson;
import java.io.Serializable;
/* loaded from: classes.dex */
public class GroupMsgPojo implements Serializable {
    public static final int READED = 0;
    public static final int UNREAD = 1;
    private static final long serialVersionUID = -7522120557807426716L;
    String content;
    long create_time;
    String ext;
    String gid;
    Gson gson = new Gson();
    boolean isSelf;
    long mid;
    int msg_status;
    int msg_type;
    int read_flag;
    long rid;
    String uid;
    String user_info;

    public GroupMsgPojo() {
    }

    public GroupMsgPojo(ChatMessage chatMessage) {
        if (chatMessage != null) {
            this.gid = chatMessage.getGroupId();
            this.mid = chatMessage.getMsgId();
            this.uid = chatMessage.getUserInfo().getId();
            this.user_info = this.gson.toJson(chatMessage.getUserInfo());
            this.create_time = chatMessage.getTime();
            this.msg_type = chatMessage.getMsgType();
            this.msg_status = chatMessage.getLocalData().getStatus().shortValue();
            this.content = chatMessage.getContent();
            this.rid = chatMessage.getRecordId();
            if (!TextUtils.isEmpty(this.uid)) {
                this.isSelf = this.uid.equals(TiebaApplication.A());
            }
        }
    }

    public int getRead_flag() {
        return this.read_flag;
    }

    public void setRead_flag(int i) {
        this.read_flag = i;
    }

    public boolean isSelf() {
        return this.isSelf;
    }

    public void setSelf(boolean z) {
        this.isSelf = z;
    }

    public long getRid() {
        return this.rid;
    }

    public void setRid(long j) {
        this.rid = j;
    }

    public ChatMessage toChatMessage() {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setGroupId(this.gid);
        chatMessage.setMsgId(this.mid);
        chatMessage.setRecordId(this.mid);
        chatMessage.setUserInfo((UserData) this.gson.fromJson(this.user_info, (Class<Object>) UserData.class));
        chatMessage.setTime(this.create_time);
        chatMessage.setMsgType((short) this.msg_type);
        MsgLocalData msgLocalData = new MsgLocalData();
        msgLocalData.setStatus(Short.valueOf((short) this.msg_status));
        chatMessage.setLocalData(msgLocalData);
        chatMessage.setContent(this.content);
        UserData userInfo = chatMessage.getUserInfo();
        if (userInfo != null) {
            String id = userInfo.getId();
            long j = 0;
            try {
                j = Long.parseLong(id);
            } catch (Exception e) {
                d.a("error" + e.getMessage());
            }
            chatMessage.setUserId(j);
        }
        c.e(chatMessage);
        return chatMessage;
    }

    public String getGid() {
        return this.gid;
    }

    public void setGid(String str) {
        this.gid = str;
    }

    public long getMid() {
        return this.mid;
    }

    public void setMid(long j) {
        this.mid = j;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String getUser_info() {
        return this.user_info;
    }

    public void setUser_info(String str) {
        this.user_info = str;
    }

    public long getCreate_time() {
        return this.create_time;
    }

    public void setCreate_time(long j) {
        this.create_time = j;
    }

    public int getMsg_type() {
        return this.msg_type;
    }

    public void setMsg_type(int i) {
        this.msg_type = i;
    }

    public int getMsg_status() {
        return this.msg_status;
    }

    public void setMsg_status(int i) {
        this.msg_status = i;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getExt() {
        return this.ext;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public String toString() {
        return "GroupMsgPojo [gid=" + this.gid + ", mid=" + this.mid + ", uid=" + this.uid + ", user_info=" + this.user_info + ", create_time=" + this.create_time + ", msg_type=" + this.msg_type + ", msg_status=" + this.msg_status + ", content=" + this.content + ", ext=" + this.ext + "]";
    }
}
