package com.baidu.tbadk.coreExtra.view;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ac {
    private static ac a;
    private static Handler b = new ad();
    private LinkedList<WeakReference<LiveBroadcastCard>> c = new LinkedList<>();

    public static ac a() {
        if (a == null) {
            a = new ac();
        }
        return a;
    }

    private ac() {
    }

    public void a(LiveBroadcastCard liveBroadcastCard) {
        Iterator<WeakReference<LiveBroadcastCard>> it = this.c.iterator();
        boolean z = false;
        while (it.hasNext()) {
            LiveBroadcastCard liveBroadcastCard2 = it.next().get();
            if (liveBroadcastCard2 != null) {
                if (liveBroadcastCard2 == liveBroadcastCard) {
                    z = true;
                }
            } else {
                it.remove();
            }
        }
        if (!z) {
            this.c.add(new WeakReference<>(liveBroadcastCard));
        }
        if (this.c.size() > 0) {
            b.removeMessages(1);
            b.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public void b(LiveBroadcastCard liveBroadcastCard) {
        Iterator<WeakReference<LiveBroadcastCard>> it = this.c.iterator();
        while (it.hasNext()) {
            LiveBroadcastCard liveBroadcastCard2 = it.next().get();
            if (liveBroadcastCard2 != null) {
                if (liveBroadcastCard2 == liveBroadcastCard) {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
        if (this.c.size() == 0) {
            b.removeMessages(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfig.LIVE_CARD_TIME_UPDATE));
    }
}
