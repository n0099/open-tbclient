package com.baidu.tieba.im.live.room;

import android.os.Handler;
import android.os.Message;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
class av extends Handler {
    final /* synthetic */ LiveRoomEntranceActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(LiveRoomEntranceActivity liveRoomEntranceActivity) {
        this.a = liveRoomEntranceActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        az azVar;
        az azVar2;
        AnimationSet animationSet;
        az azVar3;
        AnimationSet animationSet2;
        Runnable runnable;
        switch (message.what) {
            case TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI /* 2000 */:
                azVar2 = this.a.a;
                ImageView e = azVar2.e();
                animationSet = this.a.c;
                e.setAnimation(animationSet);
                azVar3 = this.a.a;
                ImageView e2 = azVar3.e();
                animationSet2 = this.a.c;
                e2.startAnimation(animationSet2);
                runnable = this.a.e;
                postDelayed(runnable, 2000L);
                return;
            case 2001:
                azVar = this.a.a;
                azVar.a();
                this.a.finish();
                return;
            default:
                return;
        }
    }
}
