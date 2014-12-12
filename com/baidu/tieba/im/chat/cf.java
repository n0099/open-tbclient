package com.baidu.tieba.im.chat;

import android.location.Address;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.personaltalk.RequestPersonalLbsInfoMessage;
import com.baidu.tieba.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
class cf implements com.baidu.adp.lib.d.d {
    final /* synthetic */ PersonalChatActivity aRE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(PersonalChatActivity personalChatActivity) {
        this.aRE = personalChatActivity;
    }

    @Override // com.baidu.adp.lib.d.d
    public void b(int i, String str, Address address) {
        if (i == 0 && address != null) {
            String valueOf = String.valueOf(address.getLatitude());
            String valueOf2 = String.valueOf(address.getLongitude());
            UserData user = ((PersonalMsglistModel) this.aRE.mListModel).getUser();
            if (user != null) {
                this.aRE.mUser = user;
                this.aRE.sendMessage(new RequestPersonalLbsInfoMessage(205101, user.getUserIdLong(), valueOf, valueOf2));
            }
        }
    }
}
