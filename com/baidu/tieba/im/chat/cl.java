package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class cl implements View.OnClickListener {
    final /* synthetic */ PersonalChatView aRR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(PersonalChatView personalChatView) {
        this.aRR = personalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PersonalChatActivity personalChatActivity;
        PersonalChatActivity personalChatActivity2;
        personalChatActivity = this.aRR.aRJ;
        if (!personalChatActivity.Kn()) {
            personalChatActivity2 = this.aRR.aRJ;
            personalChatActivity2.showToast(com.baidu.tieba.z.add_friend_cannot_send);
            return;
        }
        this.aRR.sendMore2Event();
    }
}
