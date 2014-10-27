package com.baidu.tieba.im.creategroup;

import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.AddGroupInfoData;
import com.baidu.tieba.im.message.RequestAddGroupMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
/* loaded from: classes.dex */
class k extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ CreateGroupStepActivity aTB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(CreateGroupStepActivity createGroupStepActivity, int i) {
        super(i);
        this.aTB = createGroupStepActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103101) {
            this.aTB.setIsLoading(false);
            if (!(socketResponsedMessage instanceof ResponseAddGroupMessage)) {
                this.aTB.showToast(com.baidu.tieba.y.group_create_fail);
                return;
            }
            ResponseAddGroupMessage responseAddGroupMessage = (ResponseAddGroupMessage) socketResponsedMessage;
            if (responseAddGroupMessage.getError() != 0) {
                this.aTB.t(responseAddGroupMessage.getErrorString(), responseAddGroupMessage.getError());
                return;
            }
            RequestAddGroupMessage requestAddGroupMessage = (RequestAddGroupMessage) responseAddGroupMessage.getOrginalMessage();
            AddGroupInfoData addGroupInfo = responseAddGroupMessage.getAddGroupInfo();
            if (addGroupInfo == null) {
                this.aTB.showToast(com.baidu.tieba.y.group_create_fail);
            } else {
                a(addGroupInfo);
            }
        }
    }

    private void a(AddGroupInfoData addGroupInfoData) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(this.aTB.getResources().getString(com.baidu.tieba.y.group_create_name)) + ":" + addGroupInfoData.getName() + "\n");
        sb.append(String.valueOf(this.aTB.getResources().getString(com.baidu.tieba.y.group_create_number)) + ":" + addGroupInfoData.getGroupId() + "\n");
        sb.append(this.aTB.getResources().getString(com.baidu.tieba.y.group_create_share));
        com.baidu.adp.lib.g.j.a(new AlertDialog.Builder(this.aTB).setTitle(com.baidu.tieba.y.group_create_success).setIcon((Drawable) null).setCancelable(false).setMessage(sb.toString()).setPositiveButton(com.baidu.tieba.y.group_create_step_done_tip, new l(this)).setNegativeButton(com.baidu.tieba.y.group_create_step_share_tip, new m(this, addGroupInfoData)).create(), this.aTB);
    }
}
