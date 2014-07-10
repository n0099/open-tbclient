package com.baidu.tieba.friendfeed;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.data.FriendFeedThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnTouchListener {
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
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        long j;
        FriendFeedThreadData friendFeedThreadData = (FriendFeedThreadData) this.a.getItem(((Integer) view.getTag()).intValue());
        View childAt = ((ViewGroup) view).getChildAt(0);
        if (childAt != null) {
            boolean z5 = friendFeedThreadData.getPraise() == null || friendFeedThreadData.getPraise().getIsLike() == 0;
            if (motionEvent.getAction() == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                j = this.a.l;
                if (currentTimeMillis - j > 1000) {
                    this.a.m = true;
                    this.a.a(childAt);
                } else {
                    this.a.m = false;
                }
            } else if (motionEvent.getAction() == 1) {
                if (z5) {
                    l lVar = this.a;
                    z4 = this.a.m;
                    lVar.b(childAt, z4);
                } else {
                    l lVar2 = this.a;
                    z3 = this.a.m;
                    lVar2.a(childAt, z3);
                }
            } else if (motionEvent.getAction() == 2) {
                l lVar3 = this.a;
                z2 = this.a.m;
                lVar3.a(childAt, z2);
            } else if (motionEvent.getAction() == 3) {
                l lVar4 = this.a;
                z = this.a.m;
                lVar4.a(childAt, z);
            }
        }
        return false;
    }
}
