package com.baidu.tieba.im.live.room.replay;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeDefinition;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeMessage;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class d extends CustomMessageListener {
    final /* synthetic */ LiveRoomReplayActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(LiveRoomReplayActivity liveRoomReplayActivity, int i) {
        super(i);
        this.a = liveRoomReplayActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        LiveStatusChangeMessage.LiveStatusData data;
        String str;
        LiveRoomReplayPlayer liveRoomReplayPlayer;
        LiveRoomReplayPlayer liveRoomReplayPlayer2;
        LiveRoomReplayPlayer liveRoomReplayPlayer3;
        LiveRoomReplayPlayer liveRoomReplayPlayer4;
        int i;
        if (customResponsedMessage.getCmd() == 2001161 && (customResponsedMessage instanceof LiveStatusChangeMessage) && (data = ((LiveStatusChangeMessage) customResponsedMessage).getData()) != null && LiveStatusChangeDefinition.GROUP_FOR_RECORD_PLAY.equals(data.groupId)) {
            str = this.a.i;
            if (str.equals(data.url)) {
                switch (data.status) {
                    case 17:
                        liveRoomReplayPlayer = this.a.d;
                        liveRoomReplayPlayer.getPauseOrPlayView().setBackgroundResource(t.icon_live_head_go);
                        this.a.j = data.status;
                        break;
                    case 19:
                        liveRoomReplayPlayer3 = this.a.d;
                        liveRoomReplayPlayer3.getPauseOrPlayView().setBackgroundResource(t.icon_live_head_stop);
                        this.a.j = data.status;
                        break;
                    case 20:
                        liveRoomReplayPlayer2 = this.a.d;
                        liveRoomReplayPlayer2.getPauseOrPlayView().setBackgroundResource(t.icon_live_head_go);
                        this.a.j = data.status;
                        break;
                }
                liveRoomReplayPlayer4 = this.a.d;
                i = this.a.j;
                liveRoomReplayPlayer4.setNeedKeepDragPosition(i == 17);
            }
        }
    }
}
