package com.baidu.tieba.frs.headvideo;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.tieba.frs.headvideo.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ f bYs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.bYs = fVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        t.a aVar;
        ForumHeadVideoView forumHeadVideoView;
        ForumHeadVideoView forumHeadVideoView2;
        t.a aVar2;
        ForumHeadVideoView forumHeadVideoView3;
        int y = (int) (motionEvent.getY() - motionEvent2.getY());
        if (Math.abs(y) * 3 <= Math.abs((int) (motionEvent.getX() - motionEvent2.getX())) || y < 20 || Math.abs(f2) <= 20.0f) {
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
        aVar = this.bYs.bYr;
        if (aVar != null) {
            forumHeadVideoView = this.bYs.bYo;
            if (forumHeadVideoView != null) {
                forumHeadVideoView2 = this.bYs.bYo;
                forumHeadVideoView2.requestDisallowInterceptTouchEvent(true);
                aVar2 = this.bYs.bYr;
                forumHeadVideoView3 = this.bYs.bYo;
                aVar2.ak(forumHeadVideoView3);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        t.a aVar;
        ForumHeadVideoView forumHeadVideoView;
        ForumHeadVideoView forumHeadVideoView2;
        t.a aVar2;
        ForumHeadVideoView forumHeadVideoView3;
        aVar = this.bYs.bYr;
        if (aVar != null) {
            forumHeadVideoView = this.bYs.bYo;
            if (forumHeadVideoView != null) {
                forumHeadVideoView2 = this.bYs.bYo;
                forumHeadVideoView2.requestDisallowInterceptTouchEvent(true);
                aVar2 = this.bYs.bYr;
                forumHeadVideoView3 = this.bYs.bYo;
                aVar2.aj(forumHeadVideoView3);
            }
        }
        return super.onSingleTapConfirmed(motionEvent);
    }
}
