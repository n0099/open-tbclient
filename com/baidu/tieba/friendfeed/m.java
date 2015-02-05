package com.baidu.tieba.friendfeed;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.tbadkCore.aq;
/* loaded from: classes.dex */
class m implements aq {
    final /* synthetic */ FriendFeedActivity aBS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FriendFeedActivity friendFeedActivity) {
        this.aBS = friendFeedActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.aq
    public void fx(String str) {
        boolean z;
        FriendFeedThreadData friendFeedThreadData;
        z = this.aBS.aBF;
        if (z) {
            friendFeedThreadData = this.aBS.aBE;
            this.aBS.eH(friendFeedThreadData.getPraise().getIsLike() == 1 ? 0 : 1);
        }
        this.aBS.aBD = false;
        TbadkApplication.getInst().resetPbRecorder();
    }

    @Override // com.baidu.tieba.tbadkCore.aq
    public void fy(String str) {
        boolean z;
        z = this.aBS.aBF;
        if (z && !TextUtils.isEmpty(str)) {
            this.aBS.showToast(str);
        }
        this.aBS.aBD = false;
    }
}
