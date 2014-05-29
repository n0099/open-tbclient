package com.baidu.tieba.im.live;

import android.os.Handler;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.live.LiveStatusRequestMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.a = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Handler handler;
        if (!(customResponsedMessage instanceof LiveStatusRequestMessage) || ((LiveStatusRequestMessage) customResponsedMessage).hasError()) {
            return;
        }
        handler = this.a.v;
        handler.sendEmptyMessage(10);
    }
}
