package com.baidu.tieba.frs.headvideo;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnTouchListener {
    final /* synthetic */ g bKR;
    private float mLastX;
    private float mLastY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.bKR = gVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        ForumHeadVideoView forumHeadVideoView;
        boolean z;
        ForumHeadVideoView forumHeadVideoView2;
        GestureDetector gestureDetector2;
        ForumHeadVideoView forumHeadVideoView3;
        gestureDetector = this.bKR.bKO;
        if (gestureDetector != null) {
            forumHeadVideoView = this.bKR.bKN;
            if (forumHeadVideoView != null) {
                z = this.bKR.bKP;
                if (z) {
                    forumHeadVideoView3 = this.bKR.bKN;
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
                            forumHeadVideoView2 = this.bKR.bKN;
                            forumHeadVideoView2.requestDisallowInterceptTouchEvent(true);
                            break;
                        }
                        break;
                }
                gestureDetector2 = this.bKR.bKO;
                gestureDetector2.onTouchEvent(motionEvent);
                return true;
            }
        }
        return false;
    }
}
