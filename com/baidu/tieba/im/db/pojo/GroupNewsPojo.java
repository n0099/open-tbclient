package com.baidu.tieba.im.db.pojo;

import android.text.TextUtils;
import com.baidu.adp.lib.h.d;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.im.groupUpdates.m;
import com.baidu.tieba.im.message.ChatMessage;
import com.baidu.tieba.im.validate.ValidateItemData;
import com.baidu.tieba.im.validate.k;
import java.io.Serializable;
/* loaded from: classes.dex */
public class GroupNewsPojo implements Serializable {
    public static final int hide = 3;
    public static final int read = 2;
    private static final long serialVersionUID = -4624684256008701507L;
    public static final int un_read = 1;
    String cmd;
    String content;
    int content_status;
    String ext;
    String gid;
    String notice_id;
    private GroupMsgPojo originalChatMsgPojo;
    private ChatMessage originalPushMsg;
    long time;

    public GroupNewsPojo() {
    }

    public GroupNewsPojo(ChatMessage chatMessage, String str) {
        if (chatMessage != null && !TextUtils.isEmpty(str)) {
            String str2 = "000";
            setContent_status(1);
            if (str.equals("001")) {
                str2 = "apply_join_group";
            } else if (str.equals("002")) {
                str2 = "apply_join_success";
            } else if (str.equals("003")) {
                str2 = "kick_out";
            } else if (str.equals("101")) {
                str2 = "group_name_change";
            } else if (str.equals("102")) {
                str2 = "group_notice_change";
            } else if (str.equals("103")) {
                str2 = "group_intro_change";
            } else if (str.equals("104")) {
                str2 = "group_level_up";
            } else if (str.equals("108")) {
                str2 = "group_head_change";
            }
            setCmd(str2);
            setGid(chatMessage.getGroupId());
            setContent(chatMessage.getContent());
            setTime(chatMessage.getTime() * 1000);
            setNotice_id(String.valueOf(chatMessage.getMsgId()));
            a();
            if (str2.equals("apply_join_group")) {
                a(k.a(this));
            }
        }
    }

    private void a() {
        d.d("begin");
        if (!TextUtils.isEmpty(getCmd())) {
            if (getCmd().equals("group_intro_change") || getCmd().equals("group_name_change") || getCmd().equals("group_notice_change")) {
                UpdatesItemData a2 = m.a(this);
                if (a2 != null) {
                    String A = TiebaApplication.A();
                    if (!TextUtils.isEmpty(A)) {
                        String authorId = a2.getAuthorId();
                        if (!TextUtils.isEmpty(authorId)) {
                            d.d("curUid:" + A + " uid:" + authorId);
                            if (A.equals(authorId)) {
                                setContent_status(2);
                            } else {
                                setContent_status(1);
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            d.d("end");
        }
    }

    public GroupNewsPojo(ValidateItemData validateItemData) {
        a(validateItemData);
    }

    private void a(ValidateItemData validateItemData) {
        if (validateItemData != null) {
            setCmd("apply_join_group");
            this.notice_id = validateItemData.getNotice_id();
            this.content = validateItemData.toJsonString();
            setTime(validateItemData.getApplyTime());
        }
    }

    public GroupNewsPojo(UpdatesItemData updatesItemData) {
        if (updatesItemData != null) {
            setCmd(updatesItemData.getUpdatesType());
            this.notice_id = updatesItemData.getNotice_id();
            this.content = updatesItemData.toJsonString();
            setTime(updatesItemData.getTime());
        }
    }

    public String getNotice_id() {
        return this.notice_id;
    }

    public void setNotice_id(String str) {
        this.notice_id = str;
    }

    public String getCmd() {
        return this.cmd;
    }

    public void setCmd(String str) {
        this.cmd = str;
    }

    public String getGid() {
        return this.gid;
    }

    public void setGid(String str) {
        this.gid = str;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public int getContent_status() {
        return this.content_status;
    }

    public void setContent_status(int i) {
        this.content_status = i;
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
        return "GroupNewsPojo [notice_id=" + this.notice_id + ", cmd=" + this.cmd + ", gid=" + this.gid + ", time=" + this.time + ", content=" + this.content + ", content_status=" + this.content_status + ", ext=" + this.ext + "]";
    }

    public ChatMessage getOriginalPushMsg() {
        return this.originalPushMsg;
    }

    public void setOriginalPushMsg(ChatMessage chatMessage) {
        this.originalPushMsg = chatMessage;
    }

    public GroupMsgPojo getOriginalChatMsgPojo() {
        return this.originalChatMsgPojo;
    }

    public void setOriginalChatMsgPojo(GroupMsgPojo groupMsgPojo) {
        this.originalChatMsgPojo = groupMsgPojo;
    }
}
