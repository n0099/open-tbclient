package com.baidu.tieba.friendfeed;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.tbadkCore.ao;
/* loaded from: classes.dex */
class m implements v {
    final /* synthetic */ FriendFeedActivity aAU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FriendFeedActivity friendFeedActivity) {
        this.aAU = friendFeedActivity;
    }

    @Override // com.baidu.tieba.friendfeed.v
    public void a(int i, int i2, View view, View view2, FriendFeedThreadData friendFeedThreadData) {
        y yVar;
        y yVar2;
        y yVar3;
        boolean z;
        ao aoVar;
        yVar = this.aAU.aAB;
        if (i != yVar.Fk().Ff() || view2 == null || view == null) {
            yVar2 = this.aAU.aAB;
            if (i != yVar2.Fk().Fe()) {
                yVar3 = this.aAU.aAB;
                yVar3.Fk().Fg();
                return;
            }
            this.aAU.aAF = friendFeedThreadData;
            z = this.aAU.aAE;
            if (!z) {
                this.aAU.aAE = true;
                int isLike = friendFeedThreadData.getPraise() == null ? 0 : friendFeedThreadData.getPraise().getIsLike();
                aoVar = this.aAU.aAT;
                aoVar.a(friendFeedThreadData.getFirst_post_id(), friendFeedThreadData.getTid(), isLike, "friendfeed");
                return;
            }
            return;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        ((ViewGroup) view2).offsetDescendantRectToMyCoords(view, rect);
        this.aAU.a(i2, friendFeedThreadData, rect.bottom);
    }
}
