package com.baidu.tieba.im.floatwindow.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnTouchListener {
    final /* synthetic */ i aZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.aZW = iVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        HeadImageView headImageView;
        int i;
        m mVar;
        Point point;
        Point point2;
        Point point3;
        Point point4;
        switch (motionEvent.getAction()) {
            case 0:
                point3 = this.aZW.aYR;
                point3.x = (int) motionEvent.getX();
                point4 = this.aZW.aYR;
                point4.y = (int) motionEvent.getY();
                break;
            case 1:
                this.aZW.aZT = false;
                headImageView = this.aZW.aHd;
                headImageView.setVisibility(0);
                i iVar = this.aZW;
                i = this.aZW.aZS;
                iVar.fN(i);
                com.baidu.tieba.im.floatwindow.b Nt = com.baidu.tieba.im.floatwindow.b.Nt();
                mVar = this.aZW.aZU;
                Nt.a(mVar);
                break;
            case 2:
                com.baidu.tieba.im.floatwindow.b Nt2 = com.baidu.tieba.im.floatwindow.b.Nt();
                point = this.aZW.aYR;
                int rawX = ((int) motionEvent.getRawX()) + point.x;
                point2 = this.aZW.aYR;
                Nt2.Q(rawX, (((int) motionEvent.getRawY()) - point2.y) - 25);
                break;
        }
        return false;
    }
}
