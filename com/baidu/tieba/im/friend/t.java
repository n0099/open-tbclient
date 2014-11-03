package com.baidu.tieba.im.friend;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ s aWt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.aWt = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InviteFriendListActivity inviteFriendListActivity;
        inviteFriendListActivity = this.aWt.aWj;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(inviteFriendListActivity)));
    }
}
