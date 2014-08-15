package com.baidu.tieba.im.live.room;

import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.message.ResponseAddLiveGroupMessage;
import protobuf.LiveGroupInfo;
/* loaded from: classes.dex */
class az extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ LiveRoomEntranceActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az(LiveRoomEntranceActivity liveRoomEntranceActivity, int i) {
        super(i);
        this.a = liveRoomEntranceActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ba baVar;
        Handler handler;
        this.a.hideProgressBar();
        if (socketResponsedMessage == null) {
            this.a.showToast(com.baidu.tieba.x.neterror);
        } else if (socketResponsedMessage.getCmd() == 107101 && (socketResponsedMessage instanceof ResponseAddLiveGroupMessage)) {
            ResponseAddLiveGroupMessage responseAddLiveGroupMessage = (ResponseAddLiveGroupMessage) socketResponsedMessage;
            if (responseAddLiveGroupMessage.hasError()) {
                if (TextUtils.isEmpty(responseAddLiveGroupMessage.getErrorString())) {
                    this.a.showToast(com.baidu.tieba.x.neterror);
                    return;
                } else {
                    this.a.showToast(responseAddLiveGroupMessage.getErrorString());
                    return;
                }
            }
            LiveGroupInfo liveGroupInfo = responseAddLiveGroupMessage.getLiveGroupInfo();
            MessageManager messageManager = MessageManager.getInstance();
            LiveRoomEntranceActivity liveRoomEntranceActivity = this.a;
            int intValue = liveGroupInfo.groupId.intValue();
            baVar = this.a.b;
            messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.al(liveRoomEntranceActivity, intValue, baVar.a())));
            handler = this.a.d;
            handler.sendEmptyMessageDelayed(2001, 300L);
        }
    }
}
