package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends CustomMessageListener {
    final /* synthetic */ CommonGroupChatActiviy a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb(CommonGroupChatActiviy commonGroupChatActiviy, int i) {
        super(i);
        this.a = commonGroupChatActiviy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        GroupNewsPojo p;
        if (customResponsedMessage != null) {
            switch (customResponsedMessage.getCmd()) {
                case MessageTypes.CMD_GROUP_MEMBER_CHANGE /* 2003109 */:
                    this.a.d.j();
                    return;
                case MessageTypes.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS /* 2003130 */:
                case MessageTypes.CMD_IM_PUSH_NOTIFY_KICK_OUT /* 2003132 */:
                case MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE /* 2003134 */:
                case MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE /* 2003136 */:
                case MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP /* 2003137 */:
                case MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_HEAD_CHANGE /* 2003138 */:
                case MessageTypes.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP /* 2003141 */:
                    if ((customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
                        String cmd = p.getCmd();
                        if (!TextUtils.isEmpty(cmd)) {
                            this.a.d.j();
                            if (!cmd.equals("apply_join_success")) {
                                if (!cmd.equals("kick_out")) {
                                    if (!cmd.equals("group_name_change")) {
                                        if (!cmd.equals("dismiss_group")) {
                                            return;
                                        }
                                        this.a.c(p);
                                        return;
                                    }
                                    this.a.b(p);
                                    return;
                                }
                                this.a.a(p);
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
