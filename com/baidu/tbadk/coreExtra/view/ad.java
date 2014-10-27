package com.baidu.tbadk.coreExtra.view;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ad {
    private static ad OA;
    private static Handler mHandler = new ae();
    private LinkedList<WeakReference<LiveBroadcastCard>> OB = new LinkedList<>();

    public static ad qb() {
        if (OA == null) {
            OA = new ad();
        }
        return OA;
    }

    private ad() {
    }

    public void a(LiveBroadcastCard liveBroadcastCard) {
        Iterator<WeakReference<LiveBroadcastCard>> it = this.OB.iterator();
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
            this.OB.add(new WeakReference<>(liveBroadcastCard));
        }
        if (this.OB.size() > 0) {
            mHandler.removeMessages(1);
            mHandler.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public void b(LiveBroadcastCard liveBroadcastCard) {
        Iterator<WeakReference<LiveBroadcastCard>> it = this.OB.iterator();
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
        if (this.OB.size() == 0) {
            mHandler.removeMessages(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qc() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2012113));
    }
}
