package com.baidu.tieba.im.groupInfo;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
/* loaded from: classes.dex */
final class m extends com.baidu.adp.framework.c.a {
    final /* synthetic */ GroupInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(GroupInfoActivity groupInfoActivity, int i) {
        super(0);
        this.a = groupInfoActivity;
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
            this.a.b(b);
        } else if (cmd.equals("kick_out")) {
            this.a.a(b);
        } else if (cmd.equals("group_name_change")) {
            GroupInfoActivity.a(this.a, b);
        } else if (cmd.equals("dismiss_group")) {
            GroupInfoActivity.b(this.a, b);
        } else if (cmd.equals("group_activitys_change")) {
            this.a.b();
        }
    }
}
