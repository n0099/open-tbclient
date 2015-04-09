package com.baidu.tieba.friendFeed;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.friendFeed.data.FriendFeedThreadData;
/* loaded from: classes.dex */
class w implements View.OnTouchListener {
    final /* synthetic */ p aIg;

    private w(p pVar) {
        this.aIg = pVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w(p pVar, w wVar) {
        this(pVar);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        FriendFeedThreadData friendFeedThreadData = (FriendFeedThreadData) this.aIg.getItem(((Integer) view.getTag()).intValue());
        View childAt = ((ViewGroup) view).getChildAt(0);
        if (childAt != null) {
            boolean z = friendFeedThreadData.getPraise() == null || friendFeedThreadData.getPraise().getIsLike() == 0;
            if (motionEvent.getAction() == 0) {
                if (System.currentTimeMillis() - p.d(this.aIg) > 1000) {
                    p.b(this.aIg, true);
                    p.a(this.aIg, childAt);
                } else {
                    p.b(this.aIg, false);
                }
            } else if (motionEvent.getAction() == 1) {
                if (z) {
                    p.a(this.aIg, childAt, p.e(this.aIg));
                } else {
                    p.b(this.aIg, childAt, p.e(this.aIg));
                }
            } else if (motionEvent.getAction() == 2) {
                p.b(this.aIg, childAt, p.e(this.aIg));
            } else if (motionEvent.getAction() == 3) {
                p.b(this.aIg, childAt, p.e(this.aIg));
            }
        }
        return false;
    }
}
