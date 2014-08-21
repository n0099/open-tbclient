package com.baidu.tieba.friendfeed;

import android.text.TextUtils;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.frs.dv;
import com.baidu.tieba.pb.main.bp;
/* loaded from: classes.dex */
class f implements dv {
    final /* synthetic */ FriendFeedActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FriendFeedActivity friendFeedActivity) {
        this.a = friendFeedActivity;
    }

    @Override // com.baidu.tieba.frs.dv
    public void a(String str) {
        boolean z;
        FriendFeedThreadData friendFeedThreadData;
        z = this.a.g;
        if (z) {
            friendFeedThreadData = this.a.f;
            this.a.a(friendFeedThreadData.getPraise().getIsLike() == 1 ? 0 : 1);
        }
        this.a.e = false;
        bp.a().f();
    }

    @Override // com.baidu.tieba.frs.dv
    public void b(String str) {
        boolean z;
        z = this.a.g;
        if (z && !TextUtils.isEmpty(str)) {
            this.a.showToast(str);
        }
        this.a.e = false;
    }
}
