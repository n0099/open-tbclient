package com.baidu.tbadk.coreExtra.view;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class LivePlayingStatusMgr {
    private static LivePlayingStatusMgr alv;
    private ArrayList<SoftReference<LivePlayingImageView>> alx;
    private int gid;
    private LivePlayingStatus alw = LivePlayingStatus.IDEL;
    private final CustomMessageListener mCustomMessageListener = new u(this, CmdConfigCustom.CMD_LIVE_STATUS_CHANGE);
    private final CustomMessageListener aly = new v(this, CmdConfigCustom.CMD_LIVE_CHAT_ROOM_EVENT);
    private final Handler mHandler = new w(this);

    /* loaded from: classes.dex */
    public enum LivePlayingStatus {
        IDEL,
        JOINED,
        PLAYING,
        PAUSE,
        NO_PUBLISHER;

        /* JADX DEBUG: Replace access to removed values field (alA) with 'values()' method */
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
        this.alx = null;
        BdLog.addLogPackage("com.baidu.tbadk.coreExtra.view");
        this.alx = new ArrayList<>();
        MessageManager.getInstance().registerListener(this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(this.aly);
    }

    public static synchronized LivePlayingStatusMgr zg() {
        LivePlayingStatusMgr livePlayingStatusMgr;
        synchronized (LivePlayingStatusMgr.class) {
            if (alv == null) {
                alv = new LivePlayingStatusMgr();
            }
            livePlayingStatusMgr = alv;
        }
        return livePlayingStatusMgr;
    }

    public void a(LivePlayingImageView livePlayingImageView) {
        if (livePlayingImageView != null) {
            this.alx.add(new SoftReference<>(livePlayingImageView));
        }
    }

    public void b(LivePlayingImageView livePlayingImageView) {
        Iterator<SoftReference<LivePlayingImageView>> it = this.alx.iterator();
        while (it.hasNext()) {
            SoftReference<LivePlayingImageView> next = it.next();
            if (next != null && next.get() != null && (next.get() instanceof LivePlayingImageView) && next.get() == livePlayingImageView) {
                it.remove();
            }
        }
    }

    public LivePlayingStatus zh() {
        return this.alw;
    }

    public int getGid() {
        return this.gid;
    }

    public void zi() {
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
        Iterator<SoftReference<LivePlayingImageView>> it = this.alx.iterator();
        while (it.hasNext()) {
            SoftReference<LivePlayingImageView> next = it.next();
            if (next != null && next.get() != null && (next.get() instanceof LivePlayingImageView)) {
                next.get().a(livePlayingStatus);
            }
        }
    }
}
