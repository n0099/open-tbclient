package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class cm implements View.OnClickListener {
    final /* synthetic */ PersonalChatView aTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(PersonalChatView personalChatView) {
        this.aTa = personalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PersonalChatActivity personalChatActivity;
        PersonalChatActivity personalChatActivity2;
        personalChatActivity = this.aTa.aSS;
        if (!personalChatActivity.KI()) {
            personalChatActivity2 = this.aTa.aSS;
            personalChatActivity2.showToast(com.baidu.tieba.z.add_friend_cannot_send);
            return;
        }
        this.aTa.SendMore1Event();
    }
}
