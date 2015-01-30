package com.baidu.tieba.friendfeed;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.tbadkCore.ao;
/* loaded from: classes.dex */
class l implements u {
    final /* synthetic */ FriendFeedActivity aBV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FriendFeedActivity friendFeedActivity) {
        this.aBV = friendFeedActivity;
    }

    @Override // com.baidu.tieba.friendfeed.u
    public void a(int i, int i2, View view, View view2, FriendFeedThreadData friendFeedThreadData) {
        x xVar;
        x xVar2;
        x xVar3;
        boolean z;
        ao aoVar;
        xVar = this.aBV.aBD;
        if (i != xVar.FI().FD() || view2 == null || view == null) {
            xVar2 = this.aBV.aBD;
            if (i != xVar2.FI().FC()) {
                xVar3 = this.aBV.aBD;
                xVar3.FI().FE();
                return;
            }
            this.aBV.aBH = friendFeedThreadData;
            z = this.aBV.aBG;
            if (!z) {
                this.aBV.aBG = true;
                int isLike = friendFeedThreadData.getPraise() == null ? 0 : friendFeedThreadData.getPraise().getIsLike();
                aoVar = this.aBV.aBU;
                aoVar.a(friendFeedThreadData.getFirst_post_id(), friendFeedThreadData.getTid(), isLike, "friendfeed");
                return;
            }
            return;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        ((ViewGroup) view2).offsetDescendantRectToMyCoords(view, rect);
        this.aBV.a(i2, friendFeedThreadData, rect.bottom);
    }
}
