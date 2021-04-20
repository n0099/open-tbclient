package com.baidu.tieba.im.db.pojo;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.ModelHelper;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GroupNewsPojo implements Serializable {
    public static final int hide = 3;
    public static final int read = 2;
    public static final long serialVersionUID = -4624684256008701507L;
    public static final int un_read = 1;
    public String cmd;
    public String content;
    public int content_status;
    public String ext;
    public String gid;
    public String notice_id;
    public CommonMsgPojo originalChatMsgPojo;
    public ChatMessage originalPushMsg;
    public long time;

    public GroupNewsPojo() {
    }

    private void initByValidateData(ValidateItemData validateItemData) {
        if (validateItemData == null) {
            return;
        }
        setCmd("apply_join_group");
        this.notice_id = validateItemData.getNotice_id();
        this.content = validateItemData.toJsonString();
        setTime(validateItemData.getApplyTime());
        setGid(validateItemData.getGroupId());
        setContent_status(validateItemData.isShown() ? 2 : 1);
        setExt(validateItemData.getExt());
    }

    private void setSelfNewsRead() {
        UpdatesItemData convertToUpdatesItem;
        if (TextUtils.isEmpty(getCmd())) {
            return;
        }
        if ((!getCmd().equals("group_intro_change") && !getCmd().equals("group_name_change") && !getCmd().equals("group_notice_change")) || ModelHelper.getInstance().getUpdatasModel() == null || (convertToUpdatesItem = ModelHelper.getInstance().getUpdatasModel().convertToUpdatesItem(this)) == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            return;
        }
        String authorId = convertToUpdatesItem.getAuthorId();
        if (TextUtils.isEmpty(authorId)) {
            return;
        }
        if (currentAccount.equals(authorId)) {
            setContent_status(2);
        } else {
            setContent_status(1);
        }
    }

    public String getCmd() {
        return this.cmd;
    }

    public String getContent() {
        return this.content;
    }

    public int getContent_status() {
        return this.content_status;
    }

    public String getExt() {
        return this.ext;
    }

    public String getGid() {
        return this.gid;
    }

    public String getNotice_id() {
        return this.notice_id;
    }

    public CommonMsgPojo getOriginalChatMsgPojo() {
        return this.originalChatMsgPojo;
    }

    public ChatMessage getOriginalPushMsg() {
        return this.originalPushMsg;
    }

    public long getTime() {
        return this.time;
    }

    public void setCmd(String str) {
        this.cmd = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setContent_status(int i) {
        this.content_status = i;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setGid(String str) {
        this.gid = str;
    }

    public void setNotice_id(String str) {
        this.notice_id = str;
    }

    public void setOriginalChatMsgPojo(CommonMsgPojo commonMsgPojo) {
        this.originalChatMsgPojo = commonMsgPojo;
    }

    public void setOriginalPushMsg(ChatMessage chatMessage) {
        this.originalPushMsg = chatMessage;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public GroupNewsPojo(ChatMessage chatMessage, String str) {
        String str2;
        if (chatMessage == null || TextUtils.isEmpty(str)) {
            return;
        }
        setContent_status(1);
        if (str.equals(TbEnum.SystemMessage.EVENT_ID_APPLY_VERIFY)) {
            str2 = "apply_join_group";
        } else if (str.equals(TbEnum.SystemMessage.EVENT_ID_APPLY_SUC)) {
            str2 = "apply_join_success";
        } else if (str.equals(TbEnum.SystemMessage.EVENT_ID_KICKED_OUT)) {
            str2 = "kick_out";
        } else if (str.equals("101")) {
            str2 = "group_name_change";
        } else if (str.equals(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY)) {
            str2 = "group_notice_change";
        } else if (str.equals(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY)) {
            str2 = "group_intro_change";
        } else if (str.equals(TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE)) {
            str2 = "group_level_up";
        } else if (str.equals("108")) {
            str2 = "group_head_change";
        } else if (str.equals(TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP)) {
            str2 = "dismiss_group";
        } else if (str.equals(TbEnum.SystemMessage.EVENT_ID_HIDE_GROUP_WARN)) {
            str2 = "hide_group_warn";
        } else if (str.equals(TbEnum.SystemMessage.EVENT_ID_HIDE_GROUP)) {
            str2 = "hide_group";
        } else if (str.equals(TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP)) {
            str2 = "group_event_info";
        } else if (str.equals("124")) {
            str2 = "group_activitys_change";
        } else if (str.equals(TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND)) {
            str2 = "apply_new_friend";
        } else if (str.equals(TbEnum.SystemMessage.EVENT_ID_PASSED_FRIEND)) {
            str2 = "passed_new_friend";
        } else if (str.equals(TbEnum.SystemMessage.EVENT_ID_DELETE_FRIEND)) {
            str2 = "delete_new_friend";
        } else if (TbEnum.SystemMessage.EVENT_ID_APPLY_REPLY_MESSAGE.equals(str)) {
            str2 = "apply_reply_message";
        } else if (TbEnum.SystemMessage.EVENT_ID_APPLY_ADD_FRIEND.equals(str)) {
            str2 = "apply_add_friend";
        } else if (TbEnum.SystemMessage.EVENT_ID_APPLY_PASS_FRIEND.equals(str)) {
            str2 = "apply_pass_friend";
        } else if ("501".equals(str)) {
            str2 = "upload_stat";
        } else if ("502".equals(str)) {
            str2 = "plugin_config_sync";
        } else {
            str2 = "503".equals(str) ? "offline_debug" : "000";
        }
        setCmd(str2);
        setContent(chatMessage.getContent());
        setTime(chatMessage.getTime() * 1000);
        setNotice_id(String.valueOf(chatMessage.getMsgId()));
        setSelfNewsRead();
        String content = getContent();
        if (!TextUtils.isEmpty(content)) {
            try {
                JSONObject optJSONObject = new JSONObject(content).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                if (optJSONObject != null) {
                    setGid(optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (!str2.equals("apply_join_group") || ModelHelper.getInstance().getValidateModel() == null) {
            return;
        }
        initByValidateData(ModelHelper.getInstance().getValidateModel().convertToValidateItemData(this));
    }

    public GroupNewsPojo(ValidateItemData validateItemData) {
        initByValidateData(validateItemData);
    }

    public GroupNewsPojo(UpdatesItemData updatesItemData) {
        if (updatesItemData == null) {
            return;
        }
        setCmd(updatesItemData.getUpdatesType());
        this.notice_id = updatesItemData.getNotice_id();
        this.content = updatesItemData.toJsonString();
        setTime(updatesItemData.getTime());
    }
}
