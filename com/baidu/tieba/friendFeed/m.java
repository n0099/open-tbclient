package com.baidu.tieba.friendFeed;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.friendFeed.data.FriendFeedThreadData;
import com.baidu.tieba.tbadkCore.at;
/* loaded from: classes.dex */
class m implements at {
    final /* synthetic */ FriendFeedActivity aHM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FriendFeedActivity friendFeedActivity) {
        this.aHM = friendFeedActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.at
    public void fc(String str) {
        boolean z;
        FriendFeedThreadData friendFeedThreadData;
        z = this.aHM.aHy;
        if (z) {
            friendFeedThreadData = this.aHM.aHx;
            this.aHM.eE(friendFeedThreadData.getPraise().getIsLike() == 1 ? 0 : 1);
        }
        this.aHM.aHw = false;
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
    }

    @Override // com.baidu.tieba.tbadkCore.at
    public void fd(String str) {
        boolean z;
        z = this.aHM.aHy;
        if (z && !TextUtils.isEmpty(str)) {
            this.aHM.showToast(str);
        }
        this.aHM.aHw = false;
    }
}
