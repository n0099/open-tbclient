package com.baidu.tieba.friendfeed;

import android.text.TextUtils;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.pb.main.bs;
/* loaded from: classes.dex */
class n implements dh {
    final /* synthetic */ FriendFeedActivity ayU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FriendFeedActivity friendFeedActivity) {
        this.ayU = friendFeedActivity;
    }

    @Override // com.baidu.tieba.frs.dh
    public void fa(String str) {
        boolean z;
        FriendFeedThreadData friendFeedThreadData;
        z = this.ayU.ayE;
        if (z) {
            friendFeedThreadData = this.ayU.ayD;
            this.ayU.eD(friendFeedThreadData.getPraise().getIsLike() == 1 ? 0 : 1);
        }
        this.ayU.ayC = false;
        bs.Xc().reset();
    }

    @Override // com.baidu.tieba.frs.dh
    public void fb(String str) {
        boolean z;
        z = this.ayU.ayE;
        if (z && !TextUtils.isEmpty(str)) {
            this.ayU.showToast(str);
        }
        this.ayU.ayC = false;
    }
}
