package com.baidu.tieba.im.live.room;

import android.os.Handler;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
class ay implements Runnable {
    final /* synthetic */ LiveRoomEntranceActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(LiveRoomEntranceActivity liveRoomEntranceActivity) {
        this.a = liveRoomEntranceActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        handler = this.a.d;
        handler.sendEmptyMessage(TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI);
    }
}
