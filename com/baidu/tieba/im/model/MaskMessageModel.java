package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.MessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.RequestGetMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
/* loaded from: classes3.dex */
public class MaskMessageModel extends BdBaseModel {
    public static final int TYPE_ONLY_ATTENTION_SEND = 8;

    public MaskMessageModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void initWithBundle(Bundle bundle) {
    }

    public void initWithIntent(Intent intent) {
    }

    public void registerMaskListener(MessageListener<?> messageListener) {
        MessageManager.getInstance().registerListener(104103, messageListener);
        MessageManager.getInstance().registerListener(104102, messageListener);
    }

    public void saveInstance(Bundle bundle) {
    }

    public void sendGetMaskInfoMessage(int i) {
        super.sendMessage(createMaskInfoMessage(i));
    }

    public void sendUpdateMaskMessage(int i, boolean z) {
        super.sendMessage(createUpdateMaskMessage(i, z));
    }

    public void unRegisterListener(MessageListener<?> messageListener) {
        MessageManager.getInstance().unRegisterListener(messageListener);
    }
}
