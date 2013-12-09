package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.message.BackgroundSwitchMessage;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PingManager f1803a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PingManager pingManager) {
        this.f1803a = pingManager;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        if (message != null) {
            if (message.getCmd() == -11 && (message instanceof BackgroundSwitchMessage)) {
                this.f1803a.a((BackgroundSwitchMessage) message);
            } else if (message.getCmd() == 1003 && (message instanceof ResponsedMessage)) {
                this.f1803a.a((ResponsedMessage) message);
            }
        }
    }
}
