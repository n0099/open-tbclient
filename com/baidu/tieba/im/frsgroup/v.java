package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
/* loaded from: classes.dex */
final class v extends com.baidu.adp.framework.c.a {
    final /* synthetic */ MembersActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(MembersActivity membersActivity, int i) {
        super(0);
        this.a = membersActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        GroupNewsPojo b;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 == null || !(customResponsedMessage2 instanceof PushMessage) || (b = ((PushMessage) customResponsedMessage2).b()) == null) {
            return;
        }
        String cmd = b.getCmd();
        if (TextUtils.isEmpty(cmd)) {
            return;
        }
        if (cmd.equals("apply_join_success")) {
            MembersActivity.f(this.a);
        } else if (cmd.equals("kick_out")) {
            MembersActivity.f(this.a);
        }
    }
}
