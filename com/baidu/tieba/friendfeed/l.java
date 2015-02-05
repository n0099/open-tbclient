package com.baidu.tieba.friendfeed;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.tbadkCore.ao;
/* loaded from: classes.dex */
class l implements u {
    final /* synthetic */ FriendFeedActivity aBS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FriendFeedActivity friendFeedActivity) {
        this.aBS = friendFeedActivity;
    }

    @Override // com.baidu.tieba.friendfeed.u
    public void a(int i, int i2, View view, View view2, FriendFeedThreadData friendFeedThreadData) {
        x xVar;
        x xVar2;
        x xVar3;
        boolean z;
        ao aoVar;
        xVar = this.aBS.aBA;
        if (i != xVar.FC().Fx() || view2 == null || view == null) {
            xVar2 = this.aBS.aBA;
            if (i != xVar2.FC().Fw()) {
                xVar3 = this.aBS.aBA;
                xVar3.FC().Fy();
                return;
            }
            this.aBS.aBE = friendFeedThreadData;
            z = this.aBS.aBD;
            if (!z) {
                this.aBS.aBD = true;
                int isLike = friendFeedThreadData.getPraise() == null ? 0 : friendFeedThreadData.getPraise().getIsLike();
                aoVar = this.aBS.aBR;
                aoVar.a(friendFeedThreadData.getFirst_post_id(), friendFeedThreadData.getTid(), isLike, "friendfeed");
                return;
            }
            return;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        ((ViewGroup) view2).offsetDescendantRectToMyCoords(view, rect);
        this.aBS.a(i2, friendFeedThreadData, rect.bottom);
    }
}
