package com.baidu.tieba.im.message;

import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
/* loaded from: classes.dex */
public final class aa extends da {
    private GroupNewsPojo a;

    public aa(GroupNewsPojo groupNewsPojo) {
        this.a = groupNewsPojo;
        if (groupNewsPojo != null) {
            String cmd = groupNewsPojo.getCmd();
            if (!TextUtils.isEmpty(cmd)) {
                if (cmd.equals("apply_join_group")) {
                    e(-129);
                } else if (cmd.equals("apply_join_success")) {
                    e(-130);
                } else if (cmd.equals("apply_join_fail")) {
                    e(-131);
                } else if (cmd.equals("kick_out")) {
                    e(-132);
                } else if (cmd.equals("group_notice_change")) {
                    e(-133);
                } else if (cmd.equals("group_name_change")) {
                    e(-134);
                } else if (cmd.equals("group_event_info")) {
                    e(-135);
                } else if (cmd.equals("group_intro_change")) {
                    e(-136);
                } else if (cmd.equals("group_level_up")) {
                    e(-137);
                } else if (cmd.equals("group_head_change")) {
                    e(-138);
                } else if (cmd.equals("group_activitys_change")) {
                    e(-139);
                } else if (cmd.equals("dismiss_group")) {
                    e(-141);
                } else if (cmd.equals("hide_group_warn")) {
                    e(-142);
                } else if (cmd.equals("hide_group")) {
                    e(-143);
                }
            }
        }
    }

    public final GroupNewsPojo a() {
        return this.a;
    }
}
