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
            h hx = h.hx();
            runnable = GetOnLineInfoStatic.mRunnable;
            hx.removeCallbacks(runnable);
            return;
        }
        long j = com.baidu.tbadk.core.sharedPref.b.vk().getLong("get_online_info_last_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        z = GetOnLineInfoStatic.aAl;
        if (z || currentTimeMillis - j >= 3600000) {
            GetOnLineInfoStatic.aAl = false;
            com.baidu.tbadk.core.sharedPref.b.vk().putLong("get_online_info_last_time", currentTimeMillis);
            h hx2 = h.hx();
            runnable2 = GetOnLineInfoStatic.mRunnable;
            hx2.postDelayed(runnable2, TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }
}
