package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements Handler.Callback {
    final /* synthetic */ ai a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar) {
        this.a = aiVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 2:
                MessageManager.getInstance().sendMessage(new CustomMessage(2008001, com.baidu.tbadk.core.frameworkData.a.START));
                return false;
            case 3:
                MessageManager.getInstance().sendMessage(new CustomMessage(2008001, com.baidu.tbadk.core.frameworkData.a.STOP));
                return false;
            default:
                return false;
        }
    }
}
