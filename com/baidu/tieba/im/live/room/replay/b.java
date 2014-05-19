package com.baidu.tieba.im.live.room.replay;

import android.widget.SeekBar;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.im.live.PlayProgressChangedMessage;
/* loaded from: classes.dex */
class b extends CustomMessageListener {
    final /* synthetic */ LiveRoomReplayActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(LiveRoomReplayActivity liveRoomReplayActivity, int i) {
        super(i);
        this.a = liveRoomReplayActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        LiveRoomReplayPlayer liveRoomReplayPlayer;
        String str;
        LiveRoomReplayPlayer liveRoomReplayPlayer2;
        if (customResponsedMessage instanceof PlayProgressChangedMessage) {
            PlayProgressChangedMessage playProgressChangedMessage = (PlayProgressChangedMessage) customResponsedMessage;
            liveRoomReplayPlayer = this.a.e;
            SeekBar playerBar = liveRoomReplayPlayer.getPlayerBar();
            if (playProgressChangedMessage.getUrl() != null) {
                String url = playProgressChangedMessage.getUrl();
                str = this.a.j;
                if (url.equals(str)) {
                    if (playProgressChangedMessage.getDuration() != playerBar.getMax()) {
                        int n = com.baidu.tieba.im.live.b.b().n();
                        liveRoomReplayPlayer2 = this.a.e;
                        liveRoomReplayPlayer2.getPlayerDur().setText(StringUtils.translateSecondsToString(n));
                        playerBar.setMax(playProgressChangedMessage.getDuration());
                    }
                    if (playProgressChangedMessage.getCurrentPosition() != playerBar.getProgress()) {
                        playerBar.setProgress(playProgressChangedMessage.getCurrentPosition());
                        return;
                    }
                    return;
                }
            }
            playerBar.setMax(0);
            playerBar.setProgress(0);
        }
    }
}
