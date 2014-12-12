package com.baidu.tieba.friendfeed;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.tbadkCore.aq;
/* loaded from: classes.dex */
class n implements aq {
    final /* synthetic */ FriendFeedActivity aAU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FriendFeedActivity friendFeedActivity) {
        this.aAU = friendFeedActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.aq
    public void fv(String str) {
        boolean z;
        FriendFeedThreadData friendFeedThreadData;
        z = this.aAU.aAG;
        if (z) {
            friendFeedThreadData = this.aAU.aAF;
            this.aAU.eB(friendFeedThreadData.getPraise().getIsLike() == 1 ? 0 : 1);
        }
        this.aAU.aAE = false;
        TbadkApplication.getInst().resetPbRecorder();
    }

    @Override // com.baidu.tieba.tbadkCore.aq
    public void fw(String str) {
        boolean z;
        z = this.aAU.aAG;
        if (z && !TextUtils.isEmpty(str)) {
            this.aAU.showToast(str);
        }
        this.aAU.aAE = false;
    }
}
