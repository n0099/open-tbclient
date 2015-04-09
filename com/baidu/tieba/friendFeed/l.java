package com.baidu.tieba.friendFeed;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.friendFeed.data.FriendFeedThreadData;
import com.baidu.tieba.tbadkCore.ar;
/* loaded from: classes.dex */
class l implements v {
    final /* synthetic */ FriendFeedActivity aHU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FriendFeedActivity friendFeedActivity) {
        this.aHU = friendFeedActivity;
    }

    @Override // com.baidu.tieba.friendFeed.v
    public void a(int i, int i2, View view, View view2, FriendFeedThreadData friendFeedThreadData) {
        y yVar;
        y yVar2;
        y yVar3;
        boolean z;
        ar arVar;
        yVar = this.aHU.aHB;
        if (i != yVar.Jh().Jc() || view2 == null || view == null) {
            yVar2 = this.aHU.aHB;
            if (i != yVar2.Jh().Jb()) {
                yVar3 = this.aHU.aHB;
                yVar3.Jh().Jd();
                return;
            }
            this.aHU.aHF = friendFeedThreadData;
            z = this.aHU.aHE;
            if (!z) {
                this.aHU.aHE = true;
                int isLike = friendFeedThreadData.getPraise() == null ? 0 : friendFeedThreadData.getPraise().getIsLike();
                arVar = this.aHU.aHT;
                arVar.a(friendFeedThreadData.getFirst_post_id(), friendFeedThreadData.getTid(), isLike, "friendfeed");
                return;
            }
            return;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        ((ViewGroup) view2).offsetDescendantRectToMyCoords(view, rect);
        this.aHU.a(i2, friendFeedThreadData, rect.bottom);
    }
}
