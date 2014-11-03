package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ FrsGroupActivity aWB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(FrsGroupActivity frsGroupActivity, int i) {
        super(i);
        this.aWB = frsGroupActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        l lVar;
        l lVar2;
        com.baidu.tbadk.mvc.core.b bVar;
        com.baidu.tbadk.mvc.core.b bVar2;
        lVar = this.aWB.aWx;
        lVar.cX(false);
        lVar2 = this.aWB.aWx;
        lVar2.cW(true);
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseUserPermissionMessage)) {
            this.aWB.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        ResponseUserPermissionMessage responseUserPermissionMessage = (ResponseUserPermissionMessage) socketResponsedMessage;
        if (responseUserPermissionMessage.getError() != 0) {
            if (responseUserPermissionMessage.getError() > 0) {
                if (!TextUtils.isEmpty(responseUserPermissionMessage.getErrorString())) {
                    this.aWB.showToast(responseUserPermissionMessage.getErrorString());
                    return;
                }
                return;
            }
            this.aWB.showToast(com.baidu.tieba.y.neterror);
            return;
        }
        GroupPermData groupPermData = responseUserPermissionMessage.getGroupPermData();
        if (groupPermData != null) {
            bVar = this.aWB.aWy;
            int childCount = bVar.getChildCount();
            for (int i = 0; i < childCount; i++) {
                bVar2 = this.aWB.aWy;
                com.baidu.tbadk.mvc.core.a df = bVar2.df(i);
                if (df instanceof d) {
                    ((d) df).setGroupPerm(groupPermData);
                }
            }
            this.aWB.a(groupPermData);
        }
    }
}
