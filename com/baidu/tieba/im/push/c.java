package com.baidu.tieba.im.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tieba.im.util.MessageUtils;
import java.util.Vector;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Handler {
    final /* synthetic */ a dfe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, Looper looper) {
        super(looper);
        this.dfe = aVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Vector vector;
        CustomMessageListener customMessageListener;
        switch (message.what) {
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND /* 10001 */:
                MessageUtils.updateGroupNotExist(message.getData());
                return;
            case IjkMediaPlayer.PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND /* 10002 */:
                MessageManager messageManager = MessageManager.getInstance();
                customMessageListener = this.dfe.dek;
                messageManager.registerListener(customMessageListener);
                return;
            case IjkMediaPlayer.FFP_PROP_FLOAT_PLAYBACK_RATE /* 10003 */:
                if (message.getData() != null && message.getData().containsKey("groupId")) {
                    vector = this.dfe.dfd;
                    vector.remove(Long.valueOf(message.getData().getLong("groupId")));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
