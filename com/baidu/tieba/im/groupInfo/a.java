package com.baidu.tieba.im.groupInfo;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ ApplyJoinGroupActivity bad;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ApplyJoinGroupActivity applyJoinGroupActivity, int i) {
        super(i);
        this.bad = applyJoinGroupActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseJoinGroupMessage)) {
            ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage;
            int error = responseJoinGroupMessage.getError();
            String errorString = responseJoinGroupMessage.getErrorString();
            if (responseJoinGroupMessage.getError() != 0) {
                if (TextUtils.isEmpty(errorString)) {
                    errorString = this.bad.getString(com.baidu.tieba.y.group_apply_fail);
                }
                this.bad.aZV.setEnabled(true);
                this.bad.showToast(errorString);
                return;
            }
            if (TextUtils.isEmpty(errorString)) {
                errorString = this.bad.getString(com.baidu.tieba.y.group_apply_succ);
            }
            this.bad.showToast(errorString, false);
            if (error == 0) {
                z.Pb().a(TbadkApplication.getCurrentAccount(), this.bad.aZZ, true, (com.baidu.tieba.im.a<Void>) null);
                this.bad.finish();
            }
        }
    }
}
