package com.baidu.tieba.im.live.livenotify;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class f extends CustomMessageListener {
    final /* synthetic */ LiveNotifyCardView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(LiveNotifyCardView liveNotifyCardView, int i) {
        super(i);
        this.a = liveNotifyCardView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        long j;
        if (customResponsedMessage != null) {
            j = this.a.o;
            if (j <= 0) {
                return;
            }
            this.a.h();
        }
    }
}
