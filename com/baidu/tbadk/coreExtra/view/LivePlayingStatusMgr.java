package com.baidu.tbadk.coreExtra.view;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class LivePlayingStatusMgr {
    private static LivePlayingStatusMgr a;
    private int b;
    private ArrayList<SoftReference<LivePlayingImageView>> d;
    private LivePlayingStatus c = LivePlayingStatus.IDEL;
    private final CustomMessageListener e = new aj(this, 2001161);
    private final CustomMessageListener f = new ak(this, 2001166);
    @SuppressLint({"HandlerLeak"})
    private final Handler g = new al(this);

    /* loaded from: classes.dex */
    public enum LivePlayingStatus {
        IDEL,
        JOINED,
        PLAYING,
        PAUSE,
        NO_PUBLISHER;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static LivePlayingStatus[] valuesCustom() {
            LivePlayingStatus[] valuesCustom = values();
            int length = valuesCustom.length;
            LivePlayingStatus[] livePlayingStatusArr = new LivePlayingStatus[length];
            System.arraycopy(valuesCustom, 0, livePlayingStatusArr, 0, length);
            return livePlayingStatusArr;
        }
    }

    private LivePlayingStatusMgr() {
        this.d = null;
        BdLog.addLogPackage("com.baidu.tbadk.coreExtra.view");
        this.d = new ArrayList<>();
        MessageManager.getInstance().registerListener(this.e);
        MessageManager.getInstance().registerListener(this.f);
    }

    public static synchronized LivePlayingStatusMgr a() {
        LivePlayingStatusMgr livePlayingStatusMgr;
        synchronized (LivePlayingStatusMgr.class) {
            if (a == null) {
                a = new LivePlayingStatusMgr();
            }
            livePlayingStatusMgr = a;
        }
        return livePlayingStatusMgr;
    }

    public void a(LivePlayingImageView livePlayingImageView) {
        if (livePlayingImageView != null) {
            this.d.add(new SoftReference<>(livePlayingImageView));
        }
    }

    public void b(LivePlayingImageView livePlayingImageView) {
        Iterator<SoftReference<LivePlayingImageView>> it = this.d.iterator();
        while (it.hasNext()) {
            SoftReference<LivePlayingImageView> next = it.next();
            if (next != null && next.get() != null && (next.get() instanceof LivePlayingImageView) && next.get() == livePlayingImageView) {
                it.remove();
            }
        }
    }

    public LivePlayingStatus b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    public void d() {
        a(0, LivePlayingStatus.IDEL);
    }

    public void a(int i, LivePlayingStatus livePlayingStatus) {
        Message message = new Message();
        message.obj = livePlayingStatus;
        message.arg1 = i;
        this.g.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LivePlayingStatus livePlayingStatus) {
        Iterator<SoftReference<LivePlayingImageView>> it = this.d.iterator();
        while (it.hasNext()) {
            SoftReference<LivePlayingImageView> next = it.next();
            if (next != null && next.get() != null && (next.get() instanceof LivePlayingImageView)) {
                next.get().a(livePlayingStatus);
            }
        }
    }
}
