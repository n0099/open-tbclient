package com.baidu.tieba.im.chat.snapGroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.message.ResponseChatRoomInfoMessage;
import com.baidu.tieba.im.message.ResponseEnterChatRoomMessage;
import com.baidu.tieba.im.message.ResponseQuitChatRoomMessage;
import com.baidu.tieba.im.randchat.WaittingActivity;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
class b extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(SnapGroupChatActivity snapGroupChatActivity, int i) {
        super(i);
        this.a = snapGroupChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean z;
        int i;
        int i2;
        com.baidu.tieba.im.chat.g gVar;
        switch (socketResponsedMessage.getCmd()) {
            case 106001:
                if (!(socketResponsedMessage instanceof ResponseChatRoomInfoMessage)) {
                    return;
                }
                this.a.a(com.baidu.tieba.im.d.k.a(((ResponseChatRoomInfoMessage) socketResponsedMessage).getUserList()));
                return;
            case 106101:
                this.a.closeLoadingDialog();
                if (!(socketResponsedMessage instanceof ResponseEnterChatRoomMessage)) {
                    this.a.showToast(x.neterror);
                    return;
                }
                ResponseEnterChatRoomMessage responseEnterChatRoomMessage = (ResponseEnterChatRoomMessage) socketResponsedMessage;
                if (responseEnterChatRoomMessage.getError() != 0) {
                    if (responseEnterChatRoomMessage.getError() > 0) {
                        if (!TextUtils.isEmpty(responseEnterChatRoomMessage.getErrorString())) {
                            this.a.showToast(responseEnterChatRoomMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    this.a.showToast(x.neterror);
                    return;
                }
                RandChatRoomData randChatRoomData = responseEnterChatRoomMessage.getRandChatRoomData();
                if (randChatRoomData != null && randChatRoomData.e() > 0) {
                    z = this.a.u;
                    if (!z) {
                        SnapGroupChatActivity snapGroupChatActivity = this.a;
                        i2 = snapGroupChatActivity.s;
                        snapGroupChatActivity.s = i2 + 1;
                    }
                    SnapGroupChatActivity snapGroupChatActivity2 = this.a;
                    i = this.a.s;
                    WaittingActivity.a(snapGroupChatActivity2, randChatRoomData, i);
                    this.a.finish();
                    return;
                }
                return;
            case 106102:
                if (socketResponsedMessage instanceof ResponseQuitChatRoomMessage) {
                    gVar = this.a.d;
                    gVar.R();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
