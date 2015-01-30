package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.RequestGetMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
/* loaded from: classes.dex */
public class MaskMessageModel extends f {
    public static final int TYPE_ONLY_ATTENTION_SEND = 8;

    public MaskMessageModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void initWithIntent(Intent intent) {
    }

    public void initWithBundle(Bundle bundle) {
    }

    private RequestGetMaskInfoMessage createMaskInfoMessage(int i) {
        RequestGetMaskInfoMessage requestGetMaskInfoMessage = new RequestGetMaskInfoMessage();
        requestGetMaskInfoMessage.setMaskType(i);
        return requestGetMaskInfoMessage;
    }

    private RequestUpdateMaskInfoMessage createUpdateMaskMessage(int i, boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMask(z);
        requestUpdateMaskInfoMessage.setMaskType(i);
        requestUpdateMaskInfoMessage.setList("");
        return requestUpdateMaskInfoMessage;
    }

    public void sendGetMaskInfoMessage(int i) {
        super.sendMessage(createMaskInfoMessage(i));
    }

    public void sendUpdateMaskMessage(int i, boolean z) {
        super.sendMessage(createUpdateMaskMessage(i, z));
    }

    public void registerMaskListener(MessageListener<?> messageListener) {
        MessageManager.getInstance().registerListener(104103, messageListener);
        MessageManager.getInstance().registerListener(104102, messageListener);
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        MessageManager.getInstance().unRegisterListener(messageListener);
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }
}
