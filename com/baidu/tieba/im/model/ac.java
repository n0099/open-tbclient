package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.message.RequestGetMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.base.b {
    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        return false;
    }

    private RequestGetMaskInfoMessage b(int i) {
        RequestGetMaskInfoMessage requestGetMaskInfoMessage = new RequestGetMaskInfoMessage();
        requestGetMaskInfoMessage.setMaskType(i);
        return requestGetMaskInfoMessage;
    }

    private RequestUpdateMaskInfoMessage b(int i, boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMask(z);
        requestUpdateMaskInfoMessage.setMaskType(i);
        requestUpdateMaskInfoMessage.setList("");
        return requestUpdateMaskInfoMessage;
    }

    public void a(int i) {
        super.sendMessage(b(i));
    }

    public void a(int i, boolean z) {
        super.sendMessage(b(i, z));
    }

    public void a(MessageListener<?> messageListener) {
        MessageManager.getInstance().registerListener(MessageTypes.CMD_GET_MASK_INFO, messageListener);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_UPDATE_MASK_INFO, messageListener);
    }

    public void b(MessageListener<?> messageListener) {
        MessageManager.getInstance().unRegisterListener(messageListener);
    }

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }
}
