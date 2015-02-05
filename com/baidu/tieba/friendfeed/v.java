package com.baidu.tieba.friendfeed;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.data.FriendFeedThreadData;
/* loaded from: classes.dex */
class v implements View.OnTouchListener {
    final /* synthetic */ p aCc;

    private v(p pVar) {
        this.aCc = pVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v(p pVar, v vVar) {
        this(pVar);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        FriendFeedThreadData friendFeedThreadData = (FriendFeedThreadData) this.aCc.getItem(((Integer) view.getTag()).intValue());
        View childAt = ((ViewGroup) view).getChildAt(0);
        if (childAt != null) {
            boolean z = friendFeedThreadData.getPraise() == null || friendFeedThreadData.getPraise().getIsLike() == 0;
            if (motionEvent.getAction() == 0) {
                if (System.currentTimeMillis() - p.a(this.aCc) > 1000) {
                    p.a(this.aCc, true);
                    p.a(this.aCc, childAt);
                } else {
                    p.a(this.aCc, false);
                }
            } else if (motionEvent.getAction() == 1) {
                if (z) {
                    p.a(this.aCc, childAt, p.b(this.aCc));
                } else {
                    p.b(this.aCc, childAt, p.b(this.aCc));
                }
            } else if (motionEvent.getAction() == 2) {
                p.b(this.aCc, childAt, p.b(this.aCc));
            } else if (motionEvent.getAction() == 3) {
                p.b(this.aCc, childAt, p.b(this.aCc));
            }
        }
        return false;
    }
}
