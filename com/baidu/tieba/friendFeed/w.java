package com.baidu.tieba.friendFeed;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.friendFeed.data.FriendFeedThreadData;
/* loaded from: classes.dex */
class w implements View.OnTouchListener {
    final /* synthetic */ p aHY;

    private w(p pVar) {
        this.aHY = pVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w(p pVar, w wVar) {
        this(pVar);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        FriendFeedThreadData friendFeedThreadData = (FriendFeedThreadData) this.aHY.getItem(((Integer) view.getTag()).intValue());
        View childAt = ((ViewGroup) view).getChildAt(0);
        if (childAt != null) {
            boolean z = friendFeedThreadData.getPraise() == null || friendFeedThreadData.getPraise().getIsLike() == 0;
            if (motionEvent.getAction() == 0) {
                if (System.currentTimeMillis() - p.d(this.aHY) > 1000) {
                    p.b(this.aHY, true);
                    p.a(this.aHY, childAt);
                } else {
                    p.b(this.aHY, false);
                }
            } else if (motionEvent.getAction() == 1) {
                if (z) {
                    p.a(this.aHY, childAt, p.e(this.aHY));
                } else {
                    p.b(this.aHY, childAt, p.e(this.aHY));
                }
            } else if (motionEvent.getAction() == 2) {
                p.b(this.aHY, childAt, p.e(this.aHY));
            } else if (motionEvent.getAction() == 3) {
                p.b(this.aHY, childAt, p.e(this.aHY));
            }
        }
        return false;
    }
}
