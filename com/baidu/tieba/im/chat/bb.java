package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bb extends com.baidu.adp.framework.c.a {
    final /* synthetic */ CommonGroupChatActiviy a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb(CommonGroupChatActiviy commonGroupChatActiviy, int i) {
        super(0);
        this.a = commonGroupChatActiviy;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        GroupNewsPojo b;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 != null) {
            switch (customResponsedMessage2.g()) {
                case 2001109:
                    this.a.d.g();
                    return;
                case 2001130:
                case 2001132:
                case 2001134:
                case 2001136:
                case 2001137:
                case 2001138:
                case 2001141:
                    if (!(customResponsedMessage2 instanceof PushMessage) || (b = ((PushMessage) customResponsedMessage2).b()) == null) {
                        return;
                    }
                    String cmd = b.getCmd();
                    if (TextUtils.isEmpty(cmd)) {
                        return;
                    }
                    this.a.d.g();
                    if (cmd.equals("apply_join_success")) {
                        return;
                    }
                    if (cmd.equals("kick_out")) {
                        CommonGroupChatActiviy.a(this.a, b);
                        return;
                    } else if (cmd.equals("group_name_change")) {
                        CommonGroupChatActiviy.b(this.a, b);
                        return;
                    } else if (cmd.equals("dismiss_group")) {
                        CommonGroupChatActiviy.c(this.a, b);
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
