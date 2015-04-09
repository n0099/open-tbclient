package com.baidu.tieba.friendFeed;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.friendFeed.data.FriendFeedThreadData;
import com.baidu.tieba.tbadkCore.at;
/* loaded from: classes.dex */
class m implements at {
    final /* synthetic */ FriendFeedActivity aHU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FriendFeedActivity friendFeedActivity) {
        this.aHU = friendFeedActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.at
    public void ff(String str) {
        boolean z;
        FriendFeedThreadData friendFeedThreadData;
        z = this.aHU.aHG;
        if (z) {
            friendFeedThreadData = this.aHU.aHF;
            this.aHU.eE(friendFeedThreadData.getPraise().getIsLike() == 1 ? 0 : 1);
        }
        this.aHU.aHE = false;
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004006));
    }

    @Override // com.baidu.tieba.tbadkCore.at
    public void fg(String str) {
        boolean z;
        z = this.aHU.aHG;
        if (z && !TextUtils.isEmpty(str)) {
            this.aHU.showToast(str);
        }
        this.aHU.aHE = false;
    }
}
