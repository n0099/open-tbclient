package com.baidu.tieba.im.friend;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ s baL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.baL = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InviteFriendListActivity inviteFriendListActivity;
        inviteFriendListActivity = this.baL.baB;
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(inviteFriendListActivity.getPageContext().getPageActivity())));
    }
}
