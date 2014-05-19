package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
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
            i = MessageTypes.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_GROUP;
        } else if (cmd.equals("apply_join_success")) {
            i = MessageTypes.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS;
        } else if (cmd.equals("apply_join_fail")) {
            i = MessageTypes.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_FAIL;
        } else if (cmd.equals("kick_out")) {
            i = MessageTypes.CMD_IM_PUSH_NOTIFY_KICK_OUT;
        } else if (cmd.equals("group_notice_change")) {
            i = MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_NOTICE_CHANGE;
        } else if (cmd.equals("group_name_change")) {
            i = MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE;
        } else if (cmd.equals("group_event_info")) {
            i = MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_EVENT_INFO;
        } else if (cmd.equals("group_intro_change")) {
            i = MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE;
        } else if (cmd.equals("group_level_up")) {
            i = MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP;
        } else if (cmd.equals("group_head_change")) {
            i = MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_HEAD_CHANGE;
        } else if (cmd.equals("group_activitys_change")) {
            i = MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_ACTIVITYS_CHANGE;
        } else if (cmd.equals("dismiss_group")) {
            i = MessageTypes.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP;
        } else if (cmd.equals("hide_group_warn")) {
            i = MessageTypes.CMD_IM_PUSH_NOTIFY_HIDE_GROUP_WARN;
        } else if (cmd.equals("hide_group")) {
            i = MessageTypes.CMD_IM_PUSH_NOTIFY_HIDE_GROUP;
        } else if (cmd.equals("live_notify")) {
            i = MessageTypes.CMD_LIVE_NOTIFY_LOCAL;
        } else if (cmd.equals("live_user_mute")) {
            i = MessageTypes.CMD_LIVE_USER_MUTE;
        } else {
            if (BdLog.isDebugMode()) {
                BdLog.i("PushMessage: ignore system msg:" + groupNewsPojo);
            }
            return null;
        }
        return new PushMessage(i, groupNewsPojo);
    }

    public GroupNewsPojo getP() {
        return getData();
    }
}
