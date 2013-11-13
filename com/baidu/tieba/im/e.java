package com.baidu.tieba.im;

import android.view.View;
import com.baidu.tieba.im.message.ChatMessage;
/* loaded from: classes.dex */
class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NetWorkDebugActivity f1634a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(NetWorkDebugActivity netWorkDebugActivity) {
        this.f1634a = netWorkDebugActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NetWorkDebugActivity.a("begin send-----------");
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setContent("123456");
        com.baidu.tieba.im.messageCenter.f.a().a(chatMessage);
        NetWorkDebugActivity.a("end send-----------");
        NetWorkDebugActivity.a("wait callback call-----------");
    }
}
