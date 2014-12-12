package com.baidu.tieba.im.floatwindow.view;

import android.location.Address;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.personaltalk.RequestPersonalLbsInfoMessage;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
class aa implements com.baidu.adp.lib.d.d {
    final /* synthetic */ FloatingPersonalChatActivity aYF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.aYF = floatingPersonalChatActivity;
    }

    @Override // com.baidu.adp.lib.d.d
    public void b(int i, String str, Address address) {
        MsglistModel msglistModel;
        UserData userData;
        MsglistModel msglistModel2;
        if (i == 0 && address != null) {
            String valueOf = String.valueOf(address.getLatitude());
            String valueOf2 = String.valueOf(address.getLongitude());
            msglistModel = this.aYF.mListModel;
            if (msglistModel instanceof PersonalMsglistModel) {
                msglistModel2 = this.aYF.mListModel;
                userData = ((PersonalMsglistModel) msglistModel2).getUser();
            } else {
                userData = null;
            }
            if (userData != null) {
                this.aYF.mUser = userData;
                this.aYF.sendMessage(new RequestPersonalLbsInfoMessage(205101, userData.getUserIdLong(), valueOf, valueOf2));
            }
        }
    }
}
