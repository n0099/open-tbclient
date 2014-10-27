package com.baidu.tieba.im.chat;

import android.location.Address;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.personaltalk.RequestPersonalLbsInfoMessage;
import com.baidu.tieba.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
class dh implements com.baidu.adp.lib.d.d {
    final /* synthetic */ PersonalChatActivity aPI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(PersonalChatActivity personalChatActivity) {
        this.aPI = personalChatActivity;
    }

    @Override // com.baidu.adp.lib.d.d
    public void OnLocationGeted(int i, String str, Address address) {
        if (i == 0 && address != null) {
            String valueOf = String.valueOf(address.getLatitude());
            String valueOf2 = String.valueOf(address.getLongitude());
            UserData user = ((PersonalMsglistModel) this.aPI.aPQ).getUser();
            if (user != null) {
                this.aPI.mUser = user;
                this.aPI.sendMessage(new RequestPersonalLbsInfoMessage(205101, user.getUserIdLong(), valueOf, valueOf2));
            }
        }
    }
}
