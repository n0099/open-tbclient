package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
/* loaded from: classes.dex */
class n extends CustomMessageListener {
    final /* synthetic */ CommonGroupChatActiviy bqJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(CommonGroupChatActiviy commonGroupChatActiviy, int i) {
        super(i);
        this.bqJ = commonGroupChatActiviy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        GroupNewsPojo p;
        if (customResponsedMessage != null) {
            switch (customResponsedMessage.getCmd()) {
                case CmdConfigCustom.CMD_GROUP_MEMBER_CHANGE /* 2001109 */:
                    this.bqJ.mListView.refresh();
                    return;
                case CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS /* 2001130 */:
                case CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT /* 2001132 */:
                case CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE /* 2001134 */:
                case CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE /* 2001136 */:
                case CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP /* 2001137 */:
                case CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_HEAD_CHANGE /* 2001138 */:
                case CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP /* 2001141 */:
                    if ((customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
                        String cmd = p.getCmd();
                        if (!TextUtils.isEmpty(cmd)) {
                            this.bqJ.mListView.refresh();
                            if (!cmd.equals("apply_join_success")) {
                                if (!cmd.equals("kick_out")) {
                                    if (!cmd.equals("group_name_change")) {
                                        if (!cmd.equals("dismiss_group")) {
                                            return;
                                        }
                                        this.bqJ.processDismissGroup(p);
                                        return;
                                    }
                                    this.bqJ.processTitleChange(p);
                                    return;
                                }
                                this.bqJ.processKick(p);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
