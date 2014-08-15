package com.baidu.tieba.im.live.room;

import android.os.Handler;
import android.os.Message;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
class ax extends Handler {
    final /* synthetic */ LiveRoomEntranceActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(LiveRoomEntranceActivity liveRoomEntranceActivity) {
        this.a = liveRoomEntranceActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        bb bbVar;
        bb bbVar2;
        AnimationSet animationSet;
        bb bbVar3;
        AnimationSet animationSet2;
        Runnable runnable;
        switch (message.what) {
            case TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI /* 2000 */:
                bbVar2 = this.a.a;
                ImageView e = bbVar2.e();
                animationSet = this.a.c;
                e.setAnimation(animationSet);
                bbVar3 = this.a.a;
                ImageView e2 = bbVar3.e();
                animationSet2 = this.a.c;
                e2.startAnimation(animationSet2);
                runnable = this.a.e;
                postDelayed(runnable, 2000L);
                return;
            case 2001:
                bbVar = this.a.a;
                bbVar.a();
                this.a.finish();
                return;
            default:
                return;
        }
    }
}
