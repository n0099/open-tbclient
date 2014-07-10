package com.baidu.tieba.im.live.room.intro;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseLiveRoomIntroMessage;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class a extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ LiveRoomIntroActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(LiveRoomIntroActivity liveRoomIntroActivity, int i) {
        super(i);
        this.a = liveRoomIntroActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        e eVar;
        e eVar2;
        e eVar3;
        e eVar4;
        eVar = this.a.a;
        eVar.a(false);
        if (socketResponsedMessage.getCmd() == 107004) {
            if (!(socketResponsedMessage instanceof ResponseLiveRoomIntroMessage)) {
                this.a.showToast(y.neterror);
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
                this.a.showToast(y.neterror);
            } else if (responseLiveRoomIntroMessage.introData != null) {
                eVar2 = this.a.a;
                eVar2.a(responseLiveRoomIntroMessage.introData.getPublisherPortrait(), responseLiveRoomIntroMessage.introData.getPublisherName(), responseLiveRoomIntroMessage.introData.getLikers(), responseLiveRoomIntroMessage.introData.getPublisherId());
                eVar3 = this.a.a;
                eVar3.a(responseLiveRoomIntroMessage.introData.getGroupId(), responseLiveRoomIntroMessage.introData.getName(), responseLiveRoomIntroMessage.introData.getIntro(), responseLiveRoomIntroMessage.introData.getForumName());
                eVar4 = this.a.a;
                eVar4.a(responseLiveRoomIntroMessage.otherLiveRoomDataList);
            }
        }
    }
}
