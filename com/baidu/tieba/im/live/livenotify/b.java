package com.baidu.tieba.im.live.livenotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ LiveNotifyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(LiveNotifyActivity liveNotifyActivity, int i) {
        super(i);
        this.a = liveNotifyActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        s sVar;
        com.baidu.tieba.im.a aVar;
        sVar = this.a.b;
        sVar.a(false);
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponsedMessage) && 2003167 == customResponsedMessage.getCmd()) {
            aVar = this.a.c;
            o.b(aVar);
        }
    }
}
