package com.baidu.tieba.friendfeed;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.data.FriendFeedThreadData;
/* loaded from: classes.dex */
class w implements View.OnTouchListener {
    final /* synthetic */ q aBe;

    private w(q qVar) {
        this.aBe = qVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w(q qVar, w wVar) {
        this(qVar);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        FriendFeedThreadData friendFeedThreadData = (FriendFeedThreadData) this.aBe.getItem(((Integer) view.getTag()).intValue());
        View childAt = ((ViewGroup) view).getChildAt(0);
        if (childAt != null) {
            boolean z = friendFeedThreadData.getPraise() == null || friendFeedThreadData.getPraise().getIsLike() == 0;
            if (motionEvent.getAction() == 0) {
                if (System.currentTimeMillis() - q.a(this.aBe) > 1000) {
                    q.a(this.aBe, true);
                    q.a(this.aBe, childAt);
                } else {
                    q.a(this.aBe, false);
                }
            } else if (motionEvent.getAction() == 1) {
                if (z) {
                    q.a(this.aBe, childAt, q.b(this.aBe));
                } else {
                    q.b(this.aBe, childAt, q.b(this.aBe));
                }
            } else if (motionEvent.getAction() == 2) {
                q.b(this.aBe, childAt, q.b(this.aBe));
            } else if (motionEvent.getAction() == 3) {
                q.b(this.aBe, childAt, q.b(this.aBe));
            }
        }
        return false;
    }
}
