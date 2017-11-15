package com.baidu.tieba.im.db.pojo;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.g.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.sendmessage.a;
import java.io.Serializable;
/* loaded from: classes.dex */
public class CommonMsgPojo extends OrmObject implements Serializable {
    public static final int DELETEED = 1;
    public static final int READED = 0;
    public static final int UNREAD = 1;
    public static final int UN_DELETE = 0;
    private static final long serialVersionUID = -7522120557807426716L;
    private String content;
    private long create_time;
    private int customGroupType;
    private String ext;
    private String gid;
    private int isFriend;
    private boolean isPrivate;
    boolean isSelf;
    private int is_delete;
    private long mid;
    private int msg_status;
    private int msg_type;
    private String pushIds;
    private int read_flag;
    private long rid;
    private long sid;
    private String taskId;
    private String toUid;
    private String to_user_info;
    private UserData to_user_info_data;
    private String uid;
    private String user_info;
    private UserData user_info_data;

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

    public String getPushIds() {
        return this.pushIds;
    }

    public void setPushIds(String str) {
        this.pushIds = str;
    }

    public boolean isPrivate() {
        return this.isPrivate;
    }

    public void setPrivate(boolean z) {
        this.isPrivate = z;
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
                this.gid = String.valueOf(a.dLo);
            } else if (chatMessage instanceof OfficialChatMessage) {
                this.gid = String.valueOf(a.dLp);
            }
            this.mid = chatMessage.getMsgId();
            this.uid = String.valueOf(chatMessage.getUserId());
            this.toUid = String.valueOf(chatMessage.getToUserId());
            this.user_info_data = chatMessage.getUserInfo();
            this.to_user_info_data = chatMessage.getToUserInfo();
            this.create_time = chatMessage.getTime();
            this.msg_type = chatMessage.getMsgType();
            if (chatMessage.getLocalData() != null) {
                this.msg_status = chatMessage.getLocalData().getStatus().shortValue();
            }
            this.content = chatMessage.getContent();
            this.sid = chatMessage.getSid();
            this.taskId = String.valueOf(chatMessage.getTaskId());
            this.is_delete = 0;
            this.rid = chatMessage.getRecordId();
            checkRidAndSelf();
            this.isFriend = chatMessage.getIsFriend();
        }
    }

    public int getIs_delete() {
        return this.is_delete;
    }

    public void setIs_delete(int i) {
        this.is_delete = i;
    }

    public int getRead_flag() {
        return this.read_flag;
    }

    public void setRead_flag(int i) {
        this.read_flag = i;
    }

    public boolean isSelf() {
        if (!TextUtils.isEmpty(this.uid) && this.uid.equals(TbadkCoreApplication.getCurrentAccount())) {
            this.isSelf = true;
        } else {
            this.isSelf = false;
        }
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

    public long getSid() {
        return this.sid;
    }

    public void setSid(long j) {
        this.sid = j;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String str) {
        this.taskId = str;
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

    public void setToUid(String str) {
        this.toUid = str;
    }

    public String getToUid() {
        return this.toUid;
    }

    public String getUser_info() {
        if (this.user_info == null || (this.user_info.length() < 1 && this.user_info_data != null)) {
            this.user_info = OrmObject.jsonStrWithObject(this.user_info_data);
        }
        return this.user_info;
    }

    public UserData getUser_infoObj() {
        return this.user_info_data;
    }

    public UserData getToUser_infoObj() {
        return this.to_user_info_data;
    }

    public UserData getPrivateOtherUser_infoObj() {
        if (this.user_info_data == null || this.to_user_info_data == null) {
            return null;
        }
        if (b.c(TbadkCoreApplication.getCurrentAccount(), 0L) == this.user_info_data.getUserIdLong()) {
            return this.to_user_info_data;
        }
        return this.user_info_data;
    }

    public void setUser_info(String str) {
        this.user_info = str;
        this.user_info_data = null;
    }

    public String getToUser_info() {
        if (this.to_user_info == null || (this.to_user_info.length() < 1 && this.to_user_info_data != null)) {
            this.to_user_info = OrmObject.jsonStrWithObject(this.to_user_info_data);
        }
        return this.to_user_info;
    }

    public void setToUser_info(String str) {
        this.to_user_info = str;
        this.to_user_info_data = null;
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

    public int getIsFriend() {
        return this.isFriend;
    }

    public void setIsFriend(int i) {
        this.isFriend = i;
    }

    public int getCustomGroupType() {
        return this.customGroupType;
    }

    public void setCustomGroupType(int i) {
        this.customGroupType = i;
    }
}
