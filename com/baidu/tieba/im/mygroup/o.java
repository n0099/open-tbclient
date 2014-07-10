package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.creategroup.CreateGroupStepActivity;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
/* loaded from: classes.dex */
class o extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ PersonGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PersonGroupActivity personGroupActivity, int i) {
        super(i);
        this.a = personGroupActivity;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [270=4] */
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103008 && (socketResponsedMessage instanceof ResponseUserPermissionMessage)) {
            try {
                ResponseUserPermissionMessage responseUserPermissionMessage = (ResponseUserPermissionMessage) socketResponsedMessage;
                if (responseUserPermissionMessage.getError() > 0) {
                    this.a.a(responseUserPermissionMessage.getErrorString());
                    return;
                }
                GroupPermData groupPermData = responseUserPermissionMessage.getGroupPermData();
                if (groupPermData != null) {
                    if (groupPermData.isCreatePersonal()) {
                        CreateGroupStepActivity.a(this.a, 2, 0, 1012, groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum());
                        this.a.finish();
                    } else if (!TextUtils.isEmpty(groupPermData.getCreatePersonalTip())) {
                        this.a.a(groupPermData.getCreatePersonalTip());
                    }
                }
            } catch (Exception e) {
            } finally {
                this.a.e();
            }
        }
    }
}
