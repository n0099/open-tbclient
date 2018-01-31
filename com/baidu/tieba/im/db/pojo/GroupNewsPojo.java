package com.baidu.tieba.im.db.pojo;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.ModelHelper;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
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
    private CommonMsgPojo originalChatMsgPojo;
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
            } else if (str.equals("107")) {
                str2 = "dismiss_group";
            } else if (str.equals("121")) {
                str2 = "hide_group_warn";
            } else if (str.equals("122")) {
                str2 = "hide_group";
            } else if (str.equals("109")) {
                str2 = "group_event_info";
            } else if (str.equals("124")) {
                str2 = "group_activitys_change";
            } else if (str.equals("301")) {
                str2 = "live_notify";
            } else if (str.equals("311")) {
                str2 = "live_user_mute";
            } else if (str.equals("401")) {
                str2 = "apply_new_friend";
            } else if (str.equals("402")) {
                str2 = "passed_new_friend";
            } else if (str.equals("405")) {
                str2 = "delete_new_friend";
            } else if ("302".equals(str)) {
                str2 = "live_group_update";
            } else if ("306".equals(str)) {
                str2 = "publisher_update_livegroup";
            } else if ("310".equals(str)) {
                str2 = "dismiss_livegroup";
            } else if ("307".equals(str)) {
                str2 = "livegroup_start";
            } else if ("308".equals(str)) {
                str2 = "livegroup_pause";
            } else if ("318".equals(str)) {
                str2 = "livegroup_resume";
            } else if ("309".equals(str)) {
                str2 = "livegroup_end";
            } else if ("304".equals(str)) {
                str2 = "publisher_enter_livegroup";
            } else if ("412".equals(str)) {
                str2 = "apply_reply_message";
            } else if ("410".equals(str)) {
                str2 = "apply_add_friend";
            } else if ("411".equals(str)) {
                str2 = "apply_pass_friend";
            } else if ("312".equals(str)) {
                str2 = "live_v_notify";
            } else if ("501".equals(str)) {
                str2 = "upload_stat";
            } else if ("502".equals(str)) {
                str2 = "plugin_config_sync";
            } else if ("503".equals(str)) {
                str2 = "offline_debug";
            }
            setCmd(str2);
            setContent(chatMessage.getContent());
            setTime(chatMessage.getTime() * 1000);
            setNotice_id(String.valueOf(chatMessage.getMsgId()));
            aGW();
            String content = getContent();
            if (!TextUtils.isEmpty(content)) {
                try {
                    JSONObject optJSONObject = new JSONObject(content).optJSONObject("eventParam");
                    if (optJSONObject != null) {
                        setGid(optJSONObject.optString("groupId"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (str2.equals("apply_join_group") && ModelHelper.getInstance().getValidateModel() != null) {
                b(ModelHelper.getInstance().getValidateModel().convertToValidateItemData(this));
            }
        }
    }

    private void aGW() {
        UpdatesItemData convertToUpdatesItem;
        if (!TextUtils.isEmpty(getCmd())) {
            if ((getCmd().equals("group_intro_change") || getCmd().equals("group_name_change") || getCmd().equals("group_notice_change")) && ModelHelper.getInstance().getUpdatasModel() != null && (convertToUpdatesItem = ModelHelper.getInstance().getUpdatasModel().convertToUpdatesItem(this)) != null) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!TextUtils.isEmpty(currentAccount)) {
                    String authorId = convertToUpdatesItem.getAuthorId();
                    if (!TextUtils.isEmpty(authorId)) {
                        if (currentAccount.equals(authorId)) {
                            setContent_status(2);
                        } else {
                            setContent_status(1);
                        }
                    }
                }
            }
        }
    }

    public GroupNewsPojo(ValidateItemData validateItemData) {
        b(validateItemData);
    }

    private void b(ValidateItemData validateItemData) {
        if (validateItemData != null) {
            setCmd("apply_join_group");
            this.notice_id = validateItemData.getNotice_id();
            this.content = validateItemData.toJsonString();
            setTime(validateItemData.getApplyTime());
            setGid(validateItemData.getGroupId());
            setContent_status(validateItemData.isShown() ? 2 : 1);
            setExt(validateItemData.getExt());
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

    public ChatMessage getOriginalPushMsg() {
        return this.originalPushMsg;
    }

    public void setOriginalPushMsg(ChatMessage chatMessage) {
        this.originalPushMsg = chatMessage;
    }

    public CommonMsgPojo getOriginalChatMsgPojo() {
        return this.originalChatMsgPojo;
    }

    public void setOriginalChatMsgPojo(CommonMsgPojo commonMsgPojo) {
        this.originalChatMsgPojo = commonMsgPojo;
    }
}
