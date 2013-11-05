package com.baidu.tieba.chat;

import android.content.DialogInterface;
import com.baidu.tieba.data.chat.ChatMessageData;
/* loaded from: classes.dex */
class c implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatActivity f1097a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChatActivity chatActivity) {
        this.f1097a = chatActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ChatMessageData chatMessageData;
        ChatMessageData chatMessageData2;
        chatMessageData = this.f1097a.d;
        if (chatMessageData != null) {
            chatMessageData2 = this.f1097a.d;
            chatMessageData2.setClipString(this.f1097a);
        }
    }
}
