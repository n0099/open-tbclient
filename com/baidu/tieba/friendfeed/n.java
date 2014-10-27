package com.baidu.tieba.friendfeed;

import android.text.TextUtils;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.pb.main.bs;
/* loaded from: classes.dex */
class n implements dh {
    final /* synthetic */ FriendFeedActivity ayL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FriendFeedActivity friendFeedActivity) {
        this.ayL = friendFeedActivity;
    }

    @Override // com.baidu.tieba.frs.dh
    public void fa(String str) {
        boolean z;
        FriendFeedThreadData friendFeedThreadData;
        z = this.ayL.ayv;
        if (z) {
            friendFeedThreadData = this.ayL.ayu;
            this.ayL.eD(friendFeedThreadData.getPraise().getIsLike() == 1 ? 0 : 1);
        }
        this.ayL.ayt = false;
        bs.WZ().reset();
    }

    @Override // com.baidu.tieba.frs.dh
    public void fb(String str) {
        boolean z;
        z = this.ayL.ayv;
        if (z && !TextUtils.isEmpty(str)) {
            this.ayL.showToast(str);
        }
        this.ayL.ayt = false;
    }
}
