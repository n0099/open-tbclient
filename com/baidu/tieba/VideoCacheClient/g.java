package com.baidu.tieba.VideoCacheClient;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Handler.Callback {
    final /* synthetic */ f aQU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.aQU = fVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        String str;
        Handler handler;
        Handler handler2;
        if (message.what == 1) {
            if (message.obj instanceof String) {
                this.aQU.gR((String) message.obj);
            }
        } else if (message.what == 2) {
            if (message.obj instanceof String) {
                this.aQU.gX((String) message.obj);
            }
        } else if (message.what == 3) {
            str = f.TAG;
            e.log(str, "got MSG_CHECK");
            this.aQU.Lf();
            handler = this.aQU.mHandler;
            handler2 = this.aQU.mHandler;
            handler.sendMessageDelayed(handler2.obtainMessage(3), TbConfig.NOTIFY_SOUND_INTERVAL);
        } else if (message.what == 4) {
            this.aQU.Lg();
        }
        return true;
    }
}
