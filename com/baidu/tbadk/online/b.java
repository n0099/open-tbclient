package com.baidu.tbadk.online;

import com.baidu.adp.framework.listener.e;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.g.h;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        Runnable runnable;
        Runnable runnable2;
        if (!(socketResponsedMessage instanceof ResponseOnlineMessage) || socketResponsedMessage.hasError()) {
            h hi = h.hi();
            runnable = GetOnLineInfoStatic.mRunnable;
            hi.removeCallbacks(runnable);
            return;
        }
        h hi2 = h.hi();
        runnable2 = GetOnLineInfoStatic.mRunnable;
        hi2.postDelayed(runnable2, TbConfig.NOTIFY_SOUND_INTERVAL);
    }
}
