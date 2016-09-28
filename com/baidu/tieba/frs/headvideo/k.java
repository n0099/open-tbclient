package com.baidu.tieba.frs.headvideo;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.tieba.frs.headvideo.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ i cbM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.cbM = iVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        w.a aVar;
        ForumHeadVideoView forumHeadVideoView;
        ForumHeadVideoView forumHeadVideoView2;
        w.a aVar2;
        ForumHeadVideoView forumHeadVideoView3;
        int y = (int) (motionEvent.getY() - motionEvent2.getY());
        if (Math.abs(y) * 3 <= Math.abs((int) (motionEvent.getX() - motionEvent2.getX())) || y < 20 || Math.abs(f2) <= 20.0f) {
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
        aVar = this.cbM.cbL;
        if (aVar != null) {
            forumHeadVideoView = this.cbM.cbI;
            if (forumHeadVideoView != null) {
                forumHeadVideoView2 = this.cbM.cbI;
                forumHeadVideoView2.requestDisallowInterceptTouchEvent(true);
                aVar2 = this.cbM.cbL;
                forumHeadVideoView3 = this.cbM.cbI;
                aVar2.ag(forumHeadVideoView3);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        w.a aVar;
        ForumHeadVideoView forumHeadVideoView;
        ForumHeadVideoView forumHeadVideoView2;
        w.a aVar2;
        ForumHeadVideoView forumHeadVideoView3;
        aVar = this.cbM.cbL;
        if (aVar != null) {
            forumHeadVideoView = this.cbM.cbI;
            if (forumHeadVideoView != null) {
                forumHeadVideoView2 = this.cbM.cbI;
                forumHeadVideoView2.requestDisallowInterceptTouchEvent(true);
                aVar2 = this.cbM.cbL;
                forumHeadVideoView3 = this.cbM.cbI;
                aVar2.af(forumHeadVideoView3);
            }
        }
        return super.onSingleTapConfirmed(motionEvent);
    }
}
