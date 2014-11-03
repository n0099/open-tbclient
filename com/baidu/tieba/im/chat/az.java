package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends CustomMessageListener {
    final /* synthetic */ CommonGroupChatActiviy aOo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(CommonGroupChatActiviy commonGroupChatActiviy, int i) {
        super(i);
        this.aOo = commonGroupChatActiviy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        GroupNewsPojo p;
        if (customResponsedMessage != null) {
            switch (customResponsedMessage.getCmd()) {
                case 2001109:
                    this.aOo.aQd.refresh();
                    return;
                case 2001130:
                case 2001132:
                case 2001134:
                case 2001136:
                case 2001137:
                case 2001138:
                case 2001141:
                    if ((customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
                        String cmd = p.getCmd();
                        if (!TextUtils.isEmpty(cmd)) {
                            this.aOo.aQd.refresh();
                            if (!cmd.equals("apply_join_success")) {
                                if (!cmd.equals("kick_out")) {
                                    if (!cmd.equals("group_name_change")) {
                                        if (!cmd.equals("dismiss_group")) {
                                            return;
                                        }
                                        this.aOo.c(p);
                                        return;
                                    }
                                    this.aOo.b(p);
                                    return;
                                }
                                this.aOo.a(p);
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
