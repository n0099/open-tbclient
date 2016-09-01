package com.baidu.tbadk.online;

import com.baidu.adp.framework.listener.e;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.h.h;
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
        boolean z;
        Runnable runnable2;
        if (!(socketResponsedMessage instanceof ResponseOnlineMessage) || socketResponsedMessage.hasError()) {
            h eG = h.eG();
            runnable = GetOnLineInfoStatic.mRunnable;
            eG.removeCallbacks(runnable);
            return;
        }
        long j = com.baidu.tbadk.core.sharedPref.b.tS().getLong("get_online_info_last_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        z = GetOnLineInfoStatic.aAZ;
        if (z || currentTimeMillis - j >= 3600000) {
            GetOnLineInfoStatic.aAZ = false;
            com.baidu.tbadk.core.sharedPref.b.tS().putLong("get_online_info_last_time", currentTimeMillis);
            h eG2 = h.eG();
            runnable2 = GetOnLineInfoStatic.mRunnable;
            eG2.postDelayed(runnable2, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }
}
