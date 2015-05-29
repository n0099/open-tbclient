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
        } else if (cmd.equals("delete_new_friend")) {
            i = 2001215;
        } else if (cmd.equals("live_group_update")) {
            i = 2001202;
        } else if (cmd.equals("publisher_update_livegroup")) {
            i = 2001203;
        } else if (cmd.equals("dismiss_livegroup")) {
            i = 2001204;
        } else if (cmd.equals("livegroup_start")) {
            i = 2001205;
        } else if (cmd.equals("livegroup_pause")) {
            i = 2001206;
        } else if (cmd.equals("livegroup_resume")) {
            i = 2001207;
        } else if (cmd.equals("livegroup_end")) {
            i = 2001208;
        } else if (cmd.equals("publisher_enter_livegroup")) {
            i = 2001209;
        } else if (cmd.equals("apply_reply_message")) {
            i = 2001225;
        } else if (cmd.equals("apply_add_friend")) {
            i = 2001226;
        } else if (cmd.equals("apply_pass_friend")) {
            i = 2001227;
        } else if (cmd.equals("live_v_notify")) {
            i = 2016206;
        } else if (cmd.equals("upload_stat")) {
            i = 2001327;
        } else {
            return null;
        }
        return new PushMessage(i, groupNewsPojo);
    }

    public GroupNewsPojo getP() {
        return getData();
    }
}
