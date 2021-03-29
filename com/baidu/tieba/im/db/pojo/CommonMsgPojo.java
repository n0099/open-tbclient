package com.baidu.tieba.im.db.pojo;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.GroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import d.b.b.e.m.b;
import d.b.b.e.p.k;
import d.b.i0.d1.s.a;
import d.b.i0.d1.w.c;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class CommonMsgPojo extends OrmObject implements Serializable {
    public static final int DELETEED = 1;
    public static final int READED = 0;
    public static final int UNREAD = 1;
    public static final int UN_DELETE = 0;
    public static final long serialVersionUID = -7522120557807426716L;
    public String content;
    public long create_time;
    public int customGroupType;
    public String ext;
    public int followStatus;
    public String gid;
    public int isFriend;
    public boolean isPrivate;
    public boolean isSelf;
    public int is_delete;
    public long mid;
    public int msg_status;
    public int msg_type;
    public String pushIds;
    public int read_flag;
    public long rid;
    public String serviceId;
    public long sid;
    public String taskId;
    public String toUid;
    public String to_user_info;
    public UserData to_user_info_data;
    public String uid;
    public String user_info;
    public UserData user_info_data;

    public CommonMsgPojo() {
        this.gid = "";
        this.uid = "";
        this.toUid = "";
        this.user_info = "";
        this.to_user_info = "";
        this.user_info_data = null;
        this.to_user_info_data = null;
        this.content = "";
        this.ext = "";
        this.isPrivate = false;
    }

    public void checkRidAndSelf() {
        if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            if (TbadkCoreApplication.getCurrentAccount().equals(this.uid)) {
                this.isSelf = true;
            }
        } else {
            this.isSelf = false;
        }
        if (!this.isSelf) {
            this.rid = this.mid;
        } else if (this.rid == 0) {
            this.rid = this.mid;
        }
    }

    public String getContent() {
        return this.content;
    }

    public long getCreate_time() {
        return this.create_time;
    }

    public int getCustomGroupType() {
        return this.customGroupType;
    }

    public String getExt() {
        return this.ext;
    }

    public int getFollowStatus() {
        return this.followStatus;
    }

    public String getGid() {
        return this.gid;
    }

    public int getIsFriend() {
        return this.isFriend;
    }

    public int getIs_delete() {
        return this.is_delete;
    }

    public long getMid() {
        return this.mid;
    }

    public int getMsg_status() {
        return this.msg_status;
    }

    public int getMsg_type() {
        return this.msg_type;
    }

    public UserData getPrivateOtherUser_infoObj() {
        if (this.user_info_data == null || this.to_user_info_data == null) {
            return null;
        }
        if (b.f(TbadkCoreApplication.getCurrentAccount(), 0L) == this.user_info_data.getUserIdLong()) {
            return this.to_user_info_data;
        }
        return this.user_info_data;
    }

    public String getPushIds() {
        return this.pushIds;
    }

    public int getRead_flag() {
        return this.read_flag;
    }

    public long getRid() {
        return this.rid;
    }

    public String getServiceId() {
        return this.serviceId;
    }

    public long getSid() {
        return this.sid;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public String getToUid() {
        return this.toUid;
    }

    public String getToUser_info() {
        String str = this.to_user_info;
        if (str == null || (str.length() < 1 && this.to_user_info_data != null)) {
            this.to_user_info = OrmObject.jsonStrWithObject(this.to_user_info_data);
        }
        return this.to_user_info;
    }

    public UserData getToUser_infoObj() {
        return this.to_user_info_data;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUser_info() {
        String str = this.user_info;
        if (str == null || (str.length() < 1 && this.user_info_data != null)) {
            this.user_info = OrmObject.jsonStrWithObject(this.user_info_data);
        }
        return this.user_info;
    }

    public UserData getUser_infoObj() {
        return this.user_info_data;
    }

    public boolean isPrivate() {
        return this.isPrivate;
    }

    public boolean isSelf() {
        if (!TextUtils.isEmpty(this.uid) && this.uid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.isSelf = true;
        } else {
            this.isSelf = false;
        }
        return this.isSelf;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreate_time(long j) {
        this.create_time = j;
    }

    public void setCustomGroupType(int i) {
        this.customGroupType = i;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setFollowStatus(int i) {
        this.followStatus = i;
    }

    public void setGid(String str) {
        this.gid = str;
    }

    public void setIsFriend(int i) {
        this.isFriend = i;
    }

    public void setIs_delete(int i) {
        this.is_delete = i;
    }

    public void setMid(long j) {
        this.mid = j;
    }

    public void setMsg_status(int i) {
        this.msg_status = i;
    }

    public void setMsg_type(int i) {
        this.msg_type = i;
    }

    public void setPrivate(boolean z) {
        this.isPrivate = z;
    }

    public void setPushIds(String str) {
        this.pushIds = str;
    }

    public void setRead_flag(int i) {
        this.read_flag = i;
    }

    public void setRid(long j) {
        this.rid = j;
    }

    public void setSelf(boolean z) {
        this.isSelf = z;
    }

    public void setServiceId(String str) {
        this.serviceId = str;
    }

    public void setSid(long j) {
        this.sid = j;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public void setToUid(String str) {
        this.toUid = str;
    }

    public void setToUser_info(String str) {
        this.to_user_info = str;
        this.to_user_info_data = null;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUser_info(String str) {
        this.user_info = str;
        this.user_info_data = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChatMessage toChatMessage() {
        long j;
        long j2;
        long j3;
        ChatMessage personalChatMessage;
        UserData userInfo;
        UserData toUserInfo;
        OldUserData oldUserData;
        long j4;
        OldUserData oldUserData2;
        long j5 = 0;
        try {
            j2 = (this.uid == null || this.uid.length() <= 0) ? 0L : Long.parseLong(this.uid);
        } catch (Exception e2) {
            e = e2;
            j = 0;
        }
        try {
        } catch (Exception e3) {
            long j6 = j2;
            e = e3;
            j = j6;
            e.printStackTrace();
            j2 = j;
            j3 = 0;
            if (TextUtils.isEmpty(this.toUid)) {
            }
            personalChatMessage.setMsgId(this.mid);
            personalChatMessage.setUserId(j2);
            personalChatMessage.setToUserId(j3);
            personalChatMessage.setRecordId(this.rid);
            this.user_info_data = (UserData) OrmObject.objectWithJsonStr(this.user_info, UserData.class);
            this.to_user_info_data = (UserData) OrmObject.objectWithJsonStr(this.to_user_info, UserData.class);
            personalChatMessage.setUserInfo(this.user_info_data);
            personalChatMessage.setToUserInfo(this.to_user_info_data);
            personalChatMessage.setTime(this.create_time);
            personalChatMessage.setMsgType((short) this.msg_type);
            MsgLocalData msgLocalData = new MsgLocalData();
            msgLocalData.setStatus(Short.valueOf((short) this.msg_status));
            personalChatMessage.setLocalData(msgLocalData);
            personalChatMessage.setContent(this.content);
            userInfo = personalChatMessage.getUserInfo();
            if (userInfo != null) {
            }
            toUserInfo = personalChatMessage.getToUserInfo();
            if (toUserInfo != null) {
            }
            c.n(personalChatMessage);
            personalChatMessage.setIsFriend(this.isFriend);
            personalChatMessage.setFollowStatus(this.followStatus);
            return personalChatMessage;
        }
        if (this.toUid != null && this.toUid.length() > 0) {
            j3 = Long.parseLong(this.toUid);
            if (TextUtils.isEmpty(this.toUid)) {
                personalChatMessage = new GroupChatMessage();
                personalChatMessage.setGroupId(this.gid);
            } else {
                personalChatMessage = new PersonalChatMessage();
            }
            personalChatMessage.setMsgId(this.mid);
            personalChatMessage.setUserId(j2);
            personalChatMessage.setToUserId(j3);
            personalChatMessage.setRecordId(this.rid);
            this.user_info_data = (UserData) OrmObject.objectWithJsonStr(this.user_info, UserData.class);
            this.to_user_info_data = (UserData) OrmObject.objectWithJsonStr(this.to_user_info, UserData.class);
            personalChatMessage.setUserInfo(this.user_info_data);
            personalChatMessage.setToUserInfo(this.to_user_info_data);
            personalChatMessage.setTime(this.create_time);
            personalChatMessage.setMsgType((short) this.msg_type);
            MsgLocalData msgLocalData2 = new MsgLocalData();
            msgLocalData2.setStatus(Short.valueOf((short) this.msg_status));
            personalChatMessage.setLocalData(msgLocalData2);
            personalChatMessage.setContent(this.content);
            userInfo = personalChatMessage.getUserInfo();
            if (userInfo != null) {
                if (k.isEmpty(userInfo.getUserId()) && (oldUserData2 = (OldUserData) OrmObject.objectWithJsonStr(this.user_info, OldUserData.class)) != null) {
                    oldUserData2.setToUserData(userInfo);
                }
                try {
                    j4 = Long.parseLong(userInfo.getUserId());
                } catch (Exception unused) {
                    j4 = 0;
                }
                personalChatMessage.setUserId(j4);
            }
            toUserInfo = personalChatMessage.getToUserInfo();
            if (toUserInfo != null) {
                if (k.isEmpty(toUserInfo.getUserId()) && (oldUserData = (OldUserData) OrmObject.objectWithJsonStr(this.to_user_info, OldUserData.class)) != null) {
                    oldUserData.setToUserData(toUserInfo);
                }
                try {
                    j5 = Long.parseLong(toUserInfo.getUserId());
                } catch (Exception unused2) {
                }
                personalChatMessage.setToUserId(j5);
            }
            c.n(personalChatMessage);
            personalChatMessage.setIsFriend(this.isFriend);
            personalChatMessage.setFollowStatus(this.followStatus);
            return personalChatMessage;
        }
        j3 = 0;
        if (TextUtils.isEmpty(this.toUid)) {
        }
        personalChatMessage.setMsgId(this.mid);
        personalChatMessage.setUserId(j2);
        personalChatMessage.setToUserId(j3);
        personalChatMessage.setRecordId(this.rid);
        this.user_info_data = (UserData) OrmObject.objectWithJsonStr(this.user_info, UserData.class);
        this.to_user_info_data = (UserData) OrmObject.objectWithJsonStr(this.to_user_info, UserData.class);
        personalChatMessage.setUserInfo(this.user_info_data);
        personalChatMessage.setToUserInfo(this.to_user_info_data);
        personalChatMessage.setTime(this.create_time);
        personalChatMessage.setMsgType((short) this.msg_type);
        MsgLocalData msgLocalData22 = new MsgLocalData();
        msgLocalData22.setStatus(Short.valueOf((short) this.msg_status));
        personalChatMessage.setLocalData(msgLocalData22);
        personalChatMessage.setContent(this.content);
        userInfo = personalChatMessage.getUserInfo();
        if (userInfo != null) {
        }
        toUserInfo = personalChatMessage.getToUserInfo();
        if (toUserInfo != null) {
        }
        c.n(personalChatMessage);
        personalChatMessage.setIsFriend(this.isFriend);
        personalChatMessage.setFollowStatus(this.followStatus);
        return personalChatMessage;
    }

    public CommonMsgPojo(ChatMessage chatMessage) {
        this.gid = "";
        this.uid = "";
        this.toUid = "";
        this.user_info = "";
        this.to_user_info = "";
        this.user_info_data = null;
        this.to_user_info_data = null;
        this.content = "";
        this.ext = "";
        this.isPrivate = false;
        if (chatMessage != null) {
            if (chatMessage instanceof CommonGroupChatMessage) {
                this.gid = ((CommonGroupChatMessage) chatMessage).getGroupId();
            } else if (chatMessage instanceof PersonalChatMessage) {
                this.gid = String.valueOf(a.i);
            } else if (chatMessage instanceof OfficialChatMessage) {
                this.gid = String.valueOf(a.j);
            }
            this.mid = chatMessage.getMsgId();
            this.uid = String.valueOf(chatMessage.getUserId());
            this.toUid = String.valueOf(chatMessage.getToUserId());
            this.user_info_data = chatMessage.getUserInfo();
            this.to_user_info_data = chatMessage.getToUserInfo();
            try {
                this.to_user_info = OrmObject.jsonStrWithObject(chatMessage.getToUserInfo());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.create_time = chatMessage.getTime();
            this.msg_type = chatMessage.getMsgType();
            if (chatMessage.getLocalData() != null) {
                this.msg_status = chatMessage.getLocalData().getStatus().shortValue();
            }
            this.content = chatMessage.getContent();
            this.sid = chatMessage.getSid();
            this.taskId = String.valueOf(chatMessage.getTaskId());
            this.serviceId = String.valueOf(chatMessage.getServiceId());
            this.is_delete = 0;
            this.rid = chatMessage.getRecordId();
            checkRidAndSelf();
            this.isFriend = chatMessage.getIsFriend();
            this.followStatus = chatMessage.getFollowStatus();
        }
    }
}
