package com.baidu.tbadk.coreExtra.view;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ae {
    private static ae afb;
    private static Handler mHandler = new af();
    private LinkedList<WeakReference<LiveBroadcastCard>> cards = new LinkedList<>();

    public static ae xb() {
        if (afb == null) {
            afb = new ae();
        }
        return afb;
    }

    private ae() {
    }

    public void a(LiveBroadcastCard liveBroadcastCard) {
        Iterator<WeakReference<LiveBroadcastCard>> it = this.cards.iterator();
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
            this.cards.add(new WeakReference<>(liveBroadcastCard));
        }
        if (this.cards.size() > 0) {
            mHandler.removeMessages(1);
            mHandler.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public void b(LiveBroadcastCard liveBroadcastCard) {
        Iterator<WeakReference<LiveBroadcastCard>> it = this.cards.iterator();
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
        if (this.cards.size() == 0) {
            mHandler.removeMessages(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendTimeUpdateMessage() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2012113));
    }
}
