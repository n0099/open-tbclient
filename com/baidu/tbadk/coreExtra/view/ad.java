package com.baidu.tbadk.coreExtra.view;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ad {
    private static ad OE;
    private static Handler mHandler = new ae();
    private LinkedList<WeakReference<LiveBroadcastCard>> OF = new LinkedList<>();

    public static ad qd() {
        if (OE == null) {
            OE = new ad();
        }
        return OE;
    }

    private ad() {
    }

    public void a(LiveBroadcastCard liveBroadcastCard) {
        Iterator<WeakReference<LiveBroadcastCard>> it = this.OF.iterator();
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
            this.OF.add(new WeakReference<>(liveBroadcastCard));
        }
        if (this.OF.size() > 0) {
            mHandler.removeMessages(1);
            mHandler.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public void b(LiveBroadcastCard liveBroadcastCard) {
        Iterator<WeakReference<LiveBroadcastCard>> it = this.OF.iterator();
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
        if (this.OF.size() == 0) {
            mHandler.removeMessages(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qe() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2012113));
    }
}
