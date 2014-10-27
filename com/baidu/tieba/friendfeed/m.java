package com.baidu.tieba.friendfeed;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.data.FriendFeedThreadData;
import com.baidu.tieba.frs.df;
/* loaded from: classes.dex */
class m implements v {
    final /* synthetic */ FriendFeedActivity ayL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FriendFeedActivity friendFeedActivity) {
        this.ayL = friendFeedActivity;
    }

    @Override // com.baidu.tieba.friendfeed.v
    public void a(int i, int i2, View view, View view2, FriendFeedThreadData friendFeedThreadData) {
        y yVar;
        y yVar2;
        y yVar3;
        boolean z;
        df dfVar;
        yVar = this.ayL.ayq;
        if (i != yVar.EQ().EM() || view2 == null || view == null) {
            yVar2 = this.ayL.ayq;
            if (i != yVar2.EQ().EL()) {
                yVar3 = this.ayL.ayq;
                yVar3.EQ().EN();
                return;
            }
            this.ayL.ayu = friendFeedThreadData;
            z = this.ayL.ayt;
            if (!z) {
                this.ayL.ayt = true;
                int isLike = friendFeedThreadData.getPraise() == null ? 0 : friendFeedThreadData.getPraise().getIsLike();
                dfVar = this.ayL.ayI;
                dfVar.a(friendFeedThreadData.getFirst_post_id(), friendFeedThreadData.getTid(), isLike, "friendfeed");
                return;
            }
            return;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        ((ViewGroup) view2).offsetDescendantRectToMyCoords(view, rect);
        this.ayL.a(i2, friendFeedThreadData, rect.bottom);
    }
}
