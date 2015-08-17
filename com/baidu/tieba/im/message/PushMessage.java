package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
/* loaded from: classes.dex */
public class PushMessage extends CustomResponsedMessage<GroupNewsPojo> {
    public PushMessage(int i, GroupNewsPojo groupNewsPojo) {
        super(i, groupNewsPojo);
    }

    public static PushMessage newInstance(GroupNewsPojo groupNewsPojo) {
        int i;
        String cmd = groupNewsPojo.getCmd();
        if (cmd.equals("apply_join_group")) {
            i = CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_GROUP;
        } else if (cmd.equals("apply_join_success")) {
            i = CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS;
        } else if (cmd.equals("apply_join_fail")) {
            i = CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_FAIL;
        } else if (cmd.equals("kick_out")) {
            i = CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT;
        } else if (cmd.equals("group_notice_change")) {
            i = CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NOTICE_CHANGE;
        } else if (cmd.equals("group_name_change")) {
            i = CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE;
        } else if (cmd.equals("group_event_info")) {
            i = CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_EVENT_INFO;
        } else if (cmd.equals("group_intro_change")) {
            i = CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE;
        } else if (cmd.equals("group_level_up")) {
            i = CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP;
        } else if (cmd.equals("group_head_change")) {
            i = CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_HEAD_CHANGE;
        } else if (cmd.equals("group_activitys_change")) {
            i = CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_ACTIVITYS_CHANGE;
        } else if (cmd.equals("dismiss_group")) {
            i = CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP;
        } else if (cmd.equals("hide_group_warn")) {
            i = CmdConfigCustom.CMD_IM_PUSH_NOTIFY_HIDE_GROUP_WARN;
        } else if (cmd.equals("hide_group")) {
            i = CmdConfigCustom.CMD_IM_PUSH_NOTIFY_HIDE_GROUP;
        } else if (cmd.equals("live_notify")) {
            i = CmdConfigCustom.CMD_LIVE_NOTIFY_LOCAL;
        } else if (cmd.equals("live_user_mute")) {
            i = CmdConfigCustom.CMD_LIVE_USER_MUTE;
        } else if (cmd.equals("apply_new_friend")) {
            i = CmdConfigCustom.CMD_APPLY_NEW_FRIEND_LOCAL;
        } else if (cmd.equals("passed_new_friend")) {
            i = CmdConfigCustom.CMD_PASSED_NEW_FRIEND_LOCAL;
        } else if (cmd.equals("delete_new_friend")) {
            i = CmdConfigCustom.CMD_DELETED_NEW_FRIEND_LOCAL;
        } else if (cmd.equals("live_group_update")) {
            i = CmdConfigCustom.CMD_LIVE_GROUP_UPDATE;
        } else if (cmd.equals("publisher_update_livegroup")) {
            i = CmdConfigCustom.CMD_PUBLISHER_UPDATE_LIVEGROUP;
        } else if (cmd.equals("dismiss_livegroup")) {
            i = CmdConfigCustom.CMD_DISMISS_LIVEGROUP;
        } else if (cmd.equals("livegroup_start")) {
            i = CmdConfigCustom.CMD_LIVEGROUP_START;
        } else if (cmd.equals("livegroup_pause")) {
            i = CmdConfigCustom.CMD_LIVEGROUP_PAUSE;
        } else if (cmd.equals("livegroup_resume")) {
            i = CmdConfigCustom.CMD_LIVEGROUP_RESUME;
        } else if (cmd.equals("livegroup_end")) {
            i = CmdConfigCustom.CMD_LIVEGROUP_END;
        } else if (cmd.equals("publisher_enter_livegroup")) {
            i = CmdConfigCustom.CMD_PUBLISHER_ENTER_LIVEGROUP;
        } else if (cmd.equals("apply_reply_message")) {
            i = CmdConfigCustom.CMD_APPLY_REPLY_MESSAGE;
        } else if (cmd.equals("apply_add_friend")) {
            i = CmdConfigCustom.CMD_APPLY_ADDFRIEND;
        } else if (cmd.equals("apply_pass_friend")) {
            i = CmdConfigCustom.CMD_APPLY_PASSFRIEND;
        } else if (cmd.equals("live_v_notify")) {
            i = CmdConfigCustom.CMD_LIVE_MSG_NOTIFY;
        } else if (cmd.equals("upload_stat")) {
            i = CmdConfigCustom.CMD_UPLOAD_STAT;
        } else {
            return null;
        }
        return new PushMessage(i, groupNewsPojo);
    }

    public GroupNewsPojo getP() {
        return getData();
    }
}
