package com.baidu.tieba.im.live.room;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseAddLiveGroupMessage;
import protobuf.LiveGroupInfo;
/* loaded from: classes.dex */
class ax extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ LiveRoomEntranceActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax(LiveRoomEntranceActivity liveRoomEntranceActivity, int i) {
        super(i);
        this.a = liveRoomEntranceActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        az azVar;
        ay ayVar;
        this.a.hideProgressBar();
        if (socketResponsedMessage == null) {
            this.a.showToast(com.baidu.tieba.u.neterror);
        } else if (socketResponsedMessage.getCmd() == 107101 && (socketResponsedMessage instanceof ResponseAddLiveGroupMessage)) {
            ResponseAddLiveGroupMessage responseAddLiveGroupMessage = (ResponseAddLiveGroupMessage) socketResponsedMessage;
            if (!responseAddLiveGroupMessage.hasError()) {
                azVar = this.a.a;
                azVar.a();
                LiveGroupInfo liveGroupInfo = responseAddLiveGroupMessage.getLiveGroupInfo();
                MessageManager messageManager = MessageManager.getInstance();
                LiveRoomEntranceActivity liveRoomEntranceActivity = this.a;
                int intValue = liveGroupInfo.groupId.intValue();
                ayVar = this.a.b;
                messageManager.sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.ae(liveRoomEntranceActivity, intValue, ayVar.a())));
                this.a.finish();
            } else if (TextUtils.isEmpty(responseAddLiveGroupMessage.getErrorString())) {
                this.a.showToast(com.baidu.tieba.u.neterror);
            } else {
                this.a.showToast(responseAddLiveGroupMessage.getErrorString());
            }
        }
    }
}
