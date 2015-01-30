package com.baidu.tieba.friendfeed;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.tbadkCore.aq;
/* loaded from: classes.dex */
class m implements aq {
    final /* synthetic */ FriendFeedActivity aBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FriendFeedActivity friendFeedActivity) {
        this.aBV = friendFeedActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.aq
    public void fA(String str) {
        boolean z;
        FriendFeedThreadData friendFeedThreadData;
        z = this.aBV.aBI;
        if (z) {
            friendFeedThreadData = this.aBV.aBH;
            this.aBV.eH(friendFeedThreadData.getPraise().getIsLike() == 1 ? 0 : 1);
        }
        this.aBV.aBG = false;
        TbadkApplication.getInst().resetPbRecorder();
    }

    @Override // com.baidu.tieba.tbadkCore.aq
    public void fB(String str) {
        boolean z;
        z = this.aBV.aBI;
        if (z && !TextUtils.isEmpty(str)) {
            this.aBV.showToast(str);
        }
        this.aBV.aBG = false;
    }
}
