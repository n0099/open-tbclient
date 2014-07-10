package com.baidu.tieba.im.live.livenotify;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class h {
    private static h a;
    private static Handler b = new i();
    private LinkedList<WeakReference<LiveNotifyCardView>> c = new LinkedList<>();

    public static h a() {
        if (a == null) {
            a = new h();
        }
        return a;
    }

    private h() {
    }

    public void a(LiveNotifyCardView liveNotifyCardView) {
        Iterator<WeakReference<LiveNotifyCardView>> it = this.c.iterator();
        boolean z = false;
        while (it.hasNext()) {
            LiveNotifyCardView liveNotifyCardView2 = it.next().get();
            if (liveNotifyCardView2 != null) {
                if (liveNotifyCardView2 == liveNotifyCardView) {
                    z = true;
                }
            } else {
                it.remove();
            }
        }
        if (!z) {
            this.c.add(new WeakReference<>(liveNotifyCardView));
        }
        if (this.c.size() > 0) {
            b.removeMessages(1);
            b.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public void b(LiveNotifyCardView liveNotifyCardView) {
        Iterator<WeakReference<LiveNotifyCardView>> it = this.c.iterator();
        while (it.hasNext()) {
            LiveNotifyCardView liveNotifyCardView2 = it.next().get();
            if (liveNotifyCardView2 != null) {
                if (liveNotifyCardView2 == liveNotifyCardView) {
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
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2012113));
    }
}
