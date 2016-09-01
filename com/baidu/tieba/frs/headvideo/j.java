package com.baidu.tieba.frs.headvideo;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnTouchListener {
    final /* synthetic */ i cbK;
    private float mLastX;
    private float mLastY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.cbK = iVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        ForumHeadVideoView forumHeadVideoView;
        boolean z;
        ForumHeadVideoView forumHeadVideoView2;
        GestureDetector gestureDetector2;
        ForumHeadVideoView forumHeadVideoView3;
        gestureDetector = this.cbK.cbH;
        if (gestureDetector != null) {
            forumHeadVideoView = this.cbK.cbG;
            if (forumHeadVideoView != null) {
                z = this.cbK.cbI;
                if (z) {
                    forumHeadVideoView3 = this.cbK.cbG;
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
                            forumHeadVideoView2 = this.cbK.cbG;
                            forumHeadVideoView2.requestDisallowInterceptTouchEvent(true);
                            break;
                        }
                        break;
                }
                gestureDetector2 = this.cbK.cbH;
                gestureDetector2.onTouchEvent(motionEvent);
                return true;
            }
        }
        return false;
    }
}
