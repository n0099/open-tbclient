package com.baidu.tbadk.coreExtra.view;

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
    private static LivePlayingStatusMgr aff;
    private ArrayList<SoftReference<LivePlayingImageView>> afh;
    private int gid;
    private LivePlayingStatus afg = LivePlayingStatus.IDEL;
    private final CustomMessageListener mCustomMessageListener = new ai(this, 2001161);
    private final CustomMessageListener afi = new aj(this, 2001166);
    private final Handler mHandler = new ak(this);

    /* loaded from: classes.dex */
    public enum LivePlayingStatus {
        IDEL,
        JOINED,
        PLAYING,
        PAUSE,
        NO_PUBLISHER;

        /* JADX DEBUG: Replace access to removed values field (afk) with 'values()' method */
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
        this.afh = null;
        BdLog.addLogPackage("com.baidu.tbadk.coreExtra.view");
        this.afh = new ArrayList<>();
        MessageManager.getInstance().registerListener(this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(this.afi);
    }

    public static synchronized LivePlayingStatusMgr xd() {
        LivePlayingStatusMgr livePlayingStatusMgr;
        synchronized (LivePlayingStatusMgr.class) {
            if (aff == null) {
                aff = new LivePlayingStatusMgr();
            }
            livePlayingStatusMgr = aff;
        }
        return livePlayingStatusMgr;
    }

    public void a(LivePlayingImageView livePlayingImageView) {
        if (livePlayingImageView != null) {
            this.afh.add(new SoftReference<>(livePlayingImageView));
        }
    }

    public void b(LivePlayingImageView livePlayingImageView) {
        Iterator<SoftReference<LivePlayingImageView>> it = this.afh.iterator();
        while (it.hasNext()) {
            SoftReference<LivePlayingImageView> next = it.next();
            if (next != null && next.get() != null && (next.get() instanceof LivePlayingImageView) && next.get() == livePlayingImageView) {
                it.remove();
            }
        }
    }

    public LivePlayingStatus xe() {
        return this.afg;
    }

    public int getGid() {
        return this.gid;
    }

    public void xf() {
        a(0, LivePlayingStatus.IDEL);
    }

    public void a(int i, LivePlayingStatus livePlayingStatus) {
        Message message = new Message();
        message.obj = livePlayingStatus;
        message.arg1 = i;
        this.mHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(LivePlayingStatus livePlayingStatus) {
        Iterator<SoftReference<LivePlayingImageView>> it = this.afh.iterator();
        while (it.hasNext()) {
            SoftReference<LivePlayingImageView> next = it.next();
            if (next != null && next.get() != null && (next.get() instanceof LivePlayingImageView)) {
                next.get().a(livePlayingStatus);
            }
        }
    }
}
