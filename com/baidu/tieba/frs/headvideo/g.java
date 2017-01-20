package com.baidu.tieba.frs.headvideo;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnTouchListener {
    final /* synthetic */ f bRk;
    private float mLastX;
    private float mLastY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.bRk = fVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        ForumHeadVideoView forumHeadVideoView;
        boolean z;
        ForumHeadVideoView forumHeadVideoView2;
        GestureDetector gestureDetector2;
        ForumHeadVideoView forumHeadVideoView3;
        gestureDetector = this.bRk.bRh;
        if (gestureDetector != null) {
            forumHeadVideoView = this.bRk.bRg;
            if (forumHeadVideoView != null) {
                z = this.bRk.bRi;
                if (z) {
                    forumHeadVideoView3 = this.bRk.bRg;
                    forumHeadVideoView3.requestDisallowInterceptTouchEvent(true);
                }
                switch (motionEvent.getAction()) {
                    case 0:
                        this.mLastY = motionEvent.getY();
                        this.mLastX = motionEvent.getX();
                        break;
                    case 1:
                    case 3:
                        this.mLastY = 0.0f;
                        this.mLastX = 0.0f;
                        break;
                    case 2:
                        float y = this.mLastY - motionEvent.getY();
                        if (3.0f * Math.abs(y) > Math.abs(this.mLastX - motionEvent.getX()) && y >= 0.0f) {
                            forumHeadVideoView2 = this.bRk.bRg;
                            forumHeadVideoView2.requestDisallowInterceptTouchEvent(true);
                            break;
                        }
                        break;
                }
                gestureDetector2 = this.bRk.bRh;
                gestureDetector2.onTouchEvent(motionEvent);
                return true;
            }
        }
        return false;
    }
}
