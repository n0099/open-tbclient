package com.baidu.tieba.im.live.room.replay;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.message.ResponseLiveRoomIntroMessage;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
class c extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ LiveRoomReplayActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(LiveRoomReplayActivity liveRoomReplayActivity, int i) {
        super(i);
        this.a = liveRoomReplayActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        NavigationBar navigationBar;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 107004) {
            if (!(socketResponsedMessage instanceof ResponseLiveRoomIntroMessage)) {
                this.a.showToast(x.neterror);
                return;
            }
            ResponseLiveRoomIntroMessage responseLiveRoomIntroMessage = (ResponseLiveRoomIntroMessage) socketResponsedMessage;
            if (responseLiveRoomIntroMessage.getError() != 0) {
                if (responseLiveRoomIntroMessage.getError() > 0) {
                    if (!TextUtils.isEmpty(responseLiveRoomIntroMessage.getErrorString())) {
                        this.a.showToast(responseLiveRoomIntroMessage.getErrorString());
                        return;
                    }
                    return;
                }
                this.a.showToast(x.neterror);
            } else if (responseLiveRoomIntroMessage.introData != null) {
                this.a.a(responseLiveRoomIntroMessage.introData.getPublisherPortrait(), responseLiveRoomIntroMessage.introData.getPublisherName(), responseLiveRoomIntroMessage.introData.getLikers());
                String name = responseLiveRoomIntroMessage.introData.getName();
                if (name != null) {
                    navigationBar = this.a.b;
                    navigationBar.a(name);
                }
                this.a.a(responseLiveRoomIntroMessage.otherLiveRoomDataList);
                if (responseLiveRoomIntroMessage.introData.getBackground() != null) {
                    this.a.a(responseLiveRoomIntroMessage.introData.getBackground());
                }
            }
        }
    }
}
