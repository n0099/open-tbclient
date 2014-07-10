package com.baidu.tieba.im.live.room;

import android.os.Handler;
import android.os.Message;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
class aw extends Handler {
    final /* synthetic */ LiveRoomEntranceActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(LiveRoomEntranceActivity liveRoomEntranceActivity) {
        this.a = liveRoomEntranceActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ba baVar;
        ba baVar2;
        AnimationSet animationSet;
        ba baVar3;
        AnimationSet animationSet2;
        Runnable runnable;
        switch (message.what) {
            case TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI /* 2000 */:
                baVar2 = this.a.a;
                ImageView e = baVar2.e();
                animationSet = this.a.c;
                e.setAnimation(animationSet);
                baVar3 = this.a.a;
                ImageView e2 = baVar3.e();
                animationSet2 = this.a.c;
                e2.startAnimation(animationSet2);
                runnable = this.a.e;
                postDelayed(runnable, 2000L);
                return;
            case 2001:
                baVar = this.a.a;
                baVar.a();
                this.a.finish();
                return;
            default:
                return;
        }
    }
}
