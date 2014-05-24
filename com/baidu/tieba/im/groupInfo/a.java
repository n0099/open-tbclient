package com.baidu.tieba.im.groupInfo;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ ApplyJoinGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ApplyJoinGroupActivity applyJoinGroupActivity, int i) {
        super(i);
        this.a = applyJoinGroupActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseJoinGroupMessage)) {
            ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage;
            int error = responseJoinGroupMessage.getError();
            String errorString = responseJoinGroupMessage.getErrorString();
            if (responseJoinGroupMessage.getError() != 0) {
                String string = TextUtils.isEmpty(errorString) ? this.a.getString(com.baidu.tieba.y.group_apply_fail) : errorString;
                BdLog.d("apply add group" + socketResponsedMessage.toString() + "err:" + error + " errMsg" + string);
                this.a.f.setEnabled(true);
                this.a.showToast(string);
                return;
            }
            if (TextUtils.isEmpty(errorString)) {
                errorString = this.a.getString(com.baidu.tieba.y.group_apply_succ);
            }
            this.a.showToast(errorString, false);
            if (error == 0) {
                aa.a().a(TbadkApplication.getCurrentAccount(), this.a.k, true);
                this.a.finish();
            }
        }
    }
}
