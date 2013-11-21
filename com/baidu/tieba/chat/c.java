package com.baidu.tieba.chat;

import android.content.DialogInterface;
import com.baidu.tieba.data.chat.ChatMessageData;
/* loaded from: classes.dex */
class c implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f1136a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChatActivity chatActivity) {
        this.f1136a = chatActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ChatMessageData chatMessageData;
        ChatMessageData chatMessageData2;
        chatMessageData = this.f1136a.d;
        if (chatMessageData != null) {
            chatMessageData2 = this.f1136a.d;
            chatMessageData2.setClipString(this.f1136a);
        }
    }
}
