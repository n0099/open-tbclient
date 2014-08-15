package com.baidu.tieba.im.group;

import android.app.ProgressDialog;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.message.RequestEnterChatRoomMessage;
import com.baidu.tieba.im.message.ResponseEnterChatRoomMessage;
import com.baidu.tieba.im.randchat.WaittingActivity;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
class g extends com.baidu.adp.framework.listener.d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ProgressDialog progressDialog;
        Context context;
        Context context2;
        Context context3;
        progressDialog = EnterChatRoomStatic.c;
        j.a(progressDialog);
        if (socketResponsedMessage.getCmd() == 106101) {
            if (!(socketResponsedMessage instanceof ResponseEnterChatRoomMessage)) {
                context3 = EnterChatRoomStatic.b;
                j.a(context3, x.neterror);
                return;
            }
            ResponseEnterChatRoomMessage responseEnterChatRoomMessage = (ResponseEnterChatRoomMessage) socketResponsedMessage;
            if (responseEnterChatRoomMessage.getError() != 0) {
                if (responseEnterChatRoomMessage.getError() <= 0) {
                    context = EnterChatRoomStatic.b;
                    j.a(context, x.neterror);
                    return;
                } else if (!TextUtils.isEmpty(responseEnterChatRoomMessage.getErrorString())) {
                    context2 = EnterChatRoomStatic.b;
                    j.a(context2, responseEnterChatRoomMessage.getErrorString());
                    return;
                } else {
                    return;
                }
            }
            RandChatRoomData randChatRoomData = responseEnterChatRoomMessage.getRandChatRoomData();
            if ((((RequestEnterChatRoomMessage) responseEnterChatRoomMessage.getOrginalMessage()) instanceof RequestEnterChatRoomMessage) && ((RequestEnterChatRoomMessage) responseEnterChatRoomMessage.getOrginalMessage()).isFromLYF() && randChatRoomData != null && randChatRoomData.e() > 0) {
                WaittingActivity.a(TbadkApplication.m252getInst().getApplicationContext(), randChatRoomData, 0);
            }
        }
    }
}
