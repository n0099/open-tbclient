package com.baidu.tieba.aiapps.apps.barcode;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.tbadk.core.atomData.QRCodeScanActivityConfig;
/* loaded from: classes4.dex */
public class a extends ActivityDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAttachedToWindow() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new QRCodeScanActivityConfig(getAgent(), true)));
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        return false;
    }
}
