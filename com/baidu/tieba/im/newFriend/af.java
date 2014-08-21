package com.baidu.tieba.im.newFriend;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
/* loaded from: classes.dex */
class af extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public af(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        GroupNewsPojo p;
        if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
            String cmd = p.getCmd();
            if (!TextUtils.isEmpty(cmd)) {
                String content = p.getContent();
                if (!TextUtils.isEmpty(content)) {
                    if (cmd.equals("apply_new_friend")) {
                        NewFriendDbManagerStatic.a().a(content);
                    } else if (cmd.equals("passed_new_friend")) {
                        NewFriendDbManagerStatic.a().b(content);
                    } else if (cmd.equals("delete_new_friend")) {
                        NewFriendDbManagerStatic.a().c(content);
                    } else if (cmd.equals("apply_reply_message")) {
                        NewFriendDbManagerStatic.a().d(content);
                    } else if (cmd.equals("apply_add_friend")) {
                        NewFriendDbManagerStatic.a().e(content);
                    } else if (cmd.equals("apply_pass_friend")) {
                        NewFriendDbManagerStatic.a().f(content);
                    }
                }
            }
        }
    }
}
