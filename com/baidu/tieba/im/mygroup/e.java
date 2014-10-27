package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
/* loaded from: classes.dex */
class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ PersonGroupActivity bfC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PersonGroupActivity personGroupActivity, int i) {
        super(i);
        this.bfC = personGroupActivity;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [329=4] */
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103008 && (socketResponsedMessage instanceof ResponseUserPermissionMessage)) {
            try {
                ResponseUserPermissionMessage responseUserPermissionMessage = (ResponseUserPermissionMessage) socketResponsedMessage;
                if (responseUserPermissionMessage.getError() > 0) {
                    this.bfC.showToast(responseUserPermissionMessage.getErrorString());
                    return;
                }
                GroupPermData groupPermData = responseUserPermissionMessage.getGroupPermData();
                if (groupPermData != null) {
                    if (groupPermData.isCreatePersonal()) {
                        CreateGroupStepActivity.a(this.bfC, 2, 0, 1012, groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum());
                    } else if (!TextUtils.isEmpty(groupPermData.getCreatePersonalTip())) {
                        this.bfC.showToast(groupPermData.getCreatePersonalTip());
                    }
                }
            } catch (Exception e) {
            } finally {
                this.bfC.hideProgressBar();
            }
        }
    }
}
