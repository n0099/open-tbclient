package com.baidu.tbadk.live;

import android.os.Handler;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.live.LiveStatusRequestMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ LiveGroupManager Vu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(LiveGroupManager liveGroupManager, int i) {
        super(i);
        this.Vu = liveGroupManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Handler handler;
        if (!(customResponsedMessage instanceof LiveStatusRequestMessage) || ((LiveStatusRequestMessage) customResponsedMessage).hasError()) {
            return;
        }
        handler = this.Vu.mHandler;
        handler.sendEmptyMessage(10);
    }
}
