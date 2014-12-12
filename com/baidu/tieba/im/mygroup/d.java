package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.atomData.CreateGroupStepActivityConfig;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
/* loaded from: classes.dex */
class d extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ PersonGroupActivity bjc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(PersonGroupActivity personGroupActivity, int i) {
        super(i);
        this.bjc = personGroupActivity;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [392=4] */
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103008 && (socketResponsedMessage instanceof ResponseUserPermissionMessage)) {
            try {
                ResponseUserPermissionMessage responseUserPermissionMessage = (ResponseUserPermissionMessage) socketResponsedMessage;
                if (responseUserPermissionMessage.getError() > 0) {
                    this.bjc.showToast(responseUserPermissionMessage.getErrorString());
                    return;
                }
                GroupPermData groupPermData = responseUserPermissionMessage.getGroupPermData();
                if (groupPermData != null) {
                    if (groupPermData.isCreatePersonal()) {
                        this.bjc.sendMessage(new CustomMessage(2002001, new CreateGroupStepActivityConfig(this.bjc.getPageContext().getContext(), 2, 0, CreateGroupStepActivityConfig.SOURCE_FROM_MY, groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum())));
                    } else if (!TextUtils.isEmpty(groupPermData.getCreatePersonalTip())) {
                        this.bjc.showToast(groupPermData.getCreatePersonalTip());
                    }
                }
            } catch (Exception e) {
            } finally {
                this.bjc.hideProgressBar();
            }
        }
    }
}
