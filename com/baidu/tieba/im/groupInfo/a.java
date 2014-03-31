package com.baidu.tieba.im.groupInfo;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
final class a extends com.baidu.adp.framework.c.g {
    final /* synthetic */ ApplyJoinGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ApplyJoinGroupActivity applyJoinGroupActivity, int i) {
        super(103110);
        this.a = applyJoinGroupActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 == null || !(socketResponsedMessage2 instanceof ResponseJoinGroupMessage)) {
            return;
        }
        ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage2;
        int e = responseJoinGroupMessage.e();
        String f = responseJoinGroupMessage.f();
        if (responseJoinGroupMessage.e() != 0) {
            String string = TextUtils.isEmpty(f) ? this.a.getString(com.baidu.tieba.im.j.group_apply_fail) : f;
            com.baidu.adp.lib.util.f.e("apply add group" + socketResponsedMessage2.toString() + "err:" + e + " errMsg" + string);
            this.a.f.setEnabled(true);
            this.a.showToast(string);
            return;
        }
        if (TextUtils.isEmpty(f)) {
            f = this.a.getString(com.baidu.tieba.im.j.group_apply_succ);
        }
        this.a.showToast(f, false);
        if (e == 0) {
            aa.a().a(TbadkApplication.E(), this.a.k, true);
            this.a.finish();
        }
    }
}
