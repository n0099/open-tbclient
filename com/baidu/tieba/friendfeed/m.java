package com.baidu.tieba.friendfeed;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.frs.df;
/* loaded from: classes.dex */
class m implements v {
    final /* synthetic */ FriendFeedActivity ayU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FriendFeedActivity friendFeedActivity) {
        this.ayU = friendFeedActivity;
    }

    @Override // com.baidu.tieba.friendfeed.v
    public void a(int i, int i2, View view, View view2, FriendFeedThreadData friendFeedThreadData) {
        y yVar;
        y yVar2;
        y yVar3;
        boolean z;
        df dfVar;
        yVar = this.ayU.ayz;
        if (i != yVar.ES().EO() || view2 == null || view == null) {
            yVar2 = this.ayU.ayz;
            if (i != yVar2.ES().EN()) {
                yVar3 = this.ayU.ayz;
                yVar3.ES().EP();
                return;
            }
            this.ayU.ayD = friendFeedThreadData;
            z = this.ayU.ayC;
            if (!z) {
                this.ayU.ayC = true;
                int isLike = friendFeedThreadData.getPraise() == null ? 0 : friendFeedThreadData.getPraise().getIsLike();
                dfVar = this.ayU.ayR;
                dfVar.a(friendFeedThreadData.getFirst_post_id(), friendFeedThreadData.getTid(), isLike, "friendfeed");
                return;
            }
            return;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        ((ViewGroup) view2).offsetDescendantRectToMyCoords(view, rect);
        this.ayU.a(i2, friendFeedThreadData, rect.bottom);
    }
}
