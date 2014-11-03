package com.baidu.tieba.friendfeed;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.data.FriendFeedThreadData;
/* loaded from: classes.dex */
class w implements View.OnTouchListener {
    final /* synthetic */ q azg;

    private w(q qVar) {
        this.azg = qVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w(q qVar, w wVar) {
        this(qVar);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        FriendFeedThreadData friendFeedThreadData = (FriendFeedThreadData) this.azg.getItem(((Integer) view.getTag()).intValue());
        View childAt = ((ViewGroup) view).getChildAt(0);
        if (childAt != null) {
            boolean z = friendFeedThreadData.getPraise() == null || friendFeedThreadData.getPraise().getIsLike() == 0;
            if (motionEvent.getAction() == 0) {
                if (System.currentTimeMillis() - q.a(this.azg) > 1000) {
                    q.a(this.azg, true);
                    q.a(this.azg, childAt);
                } else {
                    q.a(this.azg, false);
                }
            } else if (motionEvent.getAction() == 1) {
                if (z) {
                    q.a(this.azg, childAt, q.b(this.azg));
                } else {
                    q.b(this.azg, childAt, q.b(this.azg));
                }
            } else if (motionEvent.getAction() == 2) {
                q.b(this.azg, childAt, q.b(this.azg));
            } else if (motionEvent.getAction() == 3) {
                q.b(this.azg, childAt, q.b(this.azg));
            }
        }
        return false;
    }
}
