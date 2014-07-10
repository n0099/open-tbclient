package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
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
            i = 2001129;
        } else if (cmd.equals("apply_join_success")) {
            i = 2001130;
        } else if (cmd.equals("apply_join_fail")) {
            i = 2001131;
        } else if (cmd.equals("kick_out")) {
            i = 2001132;
        } else if (cmd.equals("group_notice_change")) {
            i = 2001133;
        } else if (cmd.equals("group_name_change")) {
            i = 2001134;
        } else if (cmd.equals("group_event_info")) {
            i = 2001135;
        } else if (cmd.equals("group_intro_change")) {
            i = 2001136;
        } else if (cmd.equals("group_level_up")) {
            i = 2001137;
        } else if (cmd.equals("group_head_change")) {
            i = 2001138;
        } else if (cmd.equals("group_activitys_change")) {
            i = 2001139;
        } else if (cmd.equals("dismiss_group")) {
            i = 2001141;
        } else if (cmd.equals("hide_group_warn")) {
            i = 2001142;
        } else if (cmd.equals("hide_group")) {
            i = 2001143;
        } else if (cmd.equals("live_notify")) {
            i = 2001167;
        } else if (cmd.equals("live_user_mute")) {
            i = 2001169;
        } else if (cmd.equals("apply_new_friend")) {
            i = 2001176;
        } else if (cmd.equals("passed_new_friend")) {
            i = 2001177;
        } else {
            return null;
        }
        return new PushMessage(i, groupNewsPojo);
    }

    public GroupNewsPojo getP() {
        return getData();
    }
}
