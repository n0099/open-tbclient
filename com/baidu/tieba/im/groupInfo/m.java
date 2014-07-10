package com.baidu.tieba.im.groupInfo;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
/* loaded from: classes.dex */
class m extends CustomMessageListener {
    final /* synthetic */ GroupInfoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(GroupInfoActivity groupInfoActivity, int i) {
        super(i);
        this.a = groupInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        GroupNewsPojo p;
        if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
            String cmd = p.getCmd();
            if (!TextUtils.isEmpty(cmd)) {
                if (cmd.equals("apply_join_success")) {
                    this.a.b(p);
                } else if (cmd.equals("kick_out")) {
                    this.a.a(p);
                } else if (cmd.equals("group_name_change")) {
                    this.a.c(p);
                } else if (cmd.equals("dismiss_group")) {
                    this.a.d(p);
                } else if (cmd.equals("group_activitys_change")) {
                    this.a.e();
                }
            }
        }
    }
}
