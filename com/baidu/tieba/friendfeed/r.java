package com.baidu.tieba.friendfeed;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.data.FriendFeedThreadData;
/* loaded from: classes.dex */
class r implements View.OnTouchListener {
    final /* synthetic */ l a;

    private r(l lVar) {
        this.a = lVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(l lVar, r rVar) {
        this(lVar);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        FriendFeedThreadData friendFeedThreadData = (FriendFeedThreadData) this.a.getItem(((Integer) view.getTag()).intValue());
        View childAt = ((ViewGroup) view).getChildAt(0);
        if (childAt != null) {
            boolean z = friendFeedThreadData.getPraise() == null || friendFeedThreadData.getPraise().getIsLike() == 0;
            if (motionEvent.getAction() == 0) {
                if (System.currentTimeMillis() - l.a(this.a) > 1000) {
                    l.a(this.a, true);
                    l.a(this.a, childAt);
                } else {
                    l.a(this.a, false);
                }
            } else if (motionEvent.getAction() == 1) {
                if (z) {
                    l.a(this.a, childAt, l.b(this.a));
                } else {
                    l.b(this.a, childAt, l.b(this.a));
                }
            } else if (motionEvent.getAction() == 2) {
                l.b(this.a, childAt, l.b(this.a));
            } else if (motionEvent.getAction() == 3) {
                l.b(this.a, childAt, l.b(this.a));
            }
        }
        return false;
    }
}
