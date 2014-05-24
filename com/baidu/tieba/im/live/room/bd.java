package com.baidu.tieba.im.live.room;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseUpdateLiveGroupMessage;
/* loaded from: classes.dex */
class bd extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ LiveRoomSettingActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd(LiveRoomSettingActivity liveRoomSettingActivity, int i) {
        super(i);
        this.a = liveRoomSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        bi biVar;
        bh bhVar;
        biVar = this.a.e;
        biVar.m();
        if (socketResponsedMessage == null) {
            this.a.showToast(com.baidu.tieba.y.neterror);
        } else if (socketResponsedMessage.getCmd() == 107102) {
            bhVar = this.a.f;
            if (bhVar.f() == socketResponsedMessage.getOrginalMessage() && (socketResponsedMessage instanceof ResponseUpdateLiveGroupMessage)) {
                ResponseUpdateLiveGroupMessage responseUpdateLiveGroupMessage = (ResponseUpdateLiveGroupMessage) socketResponsedMessage;
                if (responseUpdateLiveGroupMessage.getError() == 0) {
                    this.a.showToast(com.baidu.tieba.y.group_update_success, false);
                    this.a.finish();
                    return;
                }
                this.a.a(responseUpdateLiveGroupMessage.getError(), responseUpdateLiveGroupMessage.getErrorString());
            }
        }
    }
}
