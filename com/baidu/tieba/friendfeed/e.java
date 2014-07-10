package com.baidu.tieba.friendfeed;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.frs.Cdo;
/* loaded from: classes.dex */
class e implements q {
    final /* synthetic */ FriendFeedActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FriendFeedActivity friendFeedActivity) {
        this.a = friendFeedActivity;
    }

    @Override // com.baidu.tieba.friendfeed.q
    public void a(int i, int i2, View view, View view2, FriendFeedThreadData friendFeedThreadData) {
        t tVar;
        t tVar2;
        t tVar3;
        boolean z;
        Cdo cdo;
        tVar = this.a.c;
        if (i != tVar.c().e() || view2 == null || view == null) {
            tVar2 = this.a.c;
            if (i != tVar2.c().d()) {
                tVar3 = this.a.c;
                tVar3.c().f();
                return;
            }
            this.a.f = friendFeedThreadData;
            z = this.a.e;
            if (!z) {
                this.a.e = true;
                int isLike = friendFeedThreadData.getPraise() == null ? 0 : friendFeedThreadData.getPraise().getIsLike();
                cdo = this.a.q;
                cdo.a(friendFeedThreadData.getFirst_post_id(), friendFeedThreadData.getTid(), isLike, "friendfeed");
                return;
            }
            return;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        ((ViewGroup) view2).offsetDescendantRectToMyCoords(view, rect);
        this.a.a(i2, friendFeedThreadData, rect.bottom);
    }
}
