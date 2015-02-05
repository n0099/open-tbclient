package com.baidu.tieba.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class co implements View.OnClickListener {
    final /* synthetic */ PersonalChatView aSZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(PersonalChatView personalChatView) {
        this.aSZ = personalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PersonalChatActivity personalChatActivity;
        PersonalChatActivity personalChatActivity2;
        personalChatActivity = this.aSZ.aSR;
        if (!personalChatActivity.KD()) {
            personalChatActivity2 = this.aSZ.aSR;
            personalChatActivity2.showToast(com.baidu.tieba.z.add_friend_cannot_send);
            return;
        }
        this.aSZ.sendMore2Event();
    }
}
