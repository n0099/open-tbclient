package com.baidu.tieba.frs.headvideo;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.baidu.tieba.frs.headvideo.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ g cfi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.cfi = gVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        u.a aVar;
        ForumHeadVideoView forumHeadVideoView;
        ForumHeadVideoView forumHeadVideoView2;
        u.a aVar2;
        ForumHeadVideoView forumHeadVideoView3;
        int y = (int) (motionEvent.getY() - motionEvent2.getY());
        if (Math.abs(y) * 3 <= Math.abs((int) (motionEvent.getX() - motionEvent2.getX())) || y < 20 || Math.abs(f2) <= 20.0f) {
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }
        aVar = this.cfi.cfh;
        if (aVar != null) {
            forumHeadVideoView = this.cfi.cfe;
            if (forumHeadVideoView != null) {
                forumHeadVideoView2 = this.cfi.cfe;
                forumHeadVideoView2.requestDisallowInterceptTouchEvent(true);
                aVar2 = this.cfi.cfh;
                forumHeadVideoView3 = this.cfi.cfe;
                aVar2.ah(forumHeadVideoView3);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        u.a aVar;
        ForumHeadVideoView forumHeadVideoView;
        ForumHeadVideoView forumHeadVideoView2;
        u.a aVar2;
        ForumHeadVideoView forumHeadVideoView3;
        aVar = this.cfi.cfh;
        if (aVar != null) {
            forumHeadVideoView = this.cfi.cfe;
            if (forumHeadVideoView != null) {
                forumHeadVideoView2 = this.cfi.cfe;
                forumHeadVideoView2.requestDisallowInterceptTouchEvent(true);
                aVar2 = this.cfi.cfh;
                forumHeadVideoView3 = this.cfi.cfe;
                aVar2.ag(forumHeadVideoView3);
            }
        }
        return super.onSingleTapConfirmed(motionEvent);
    }
}
