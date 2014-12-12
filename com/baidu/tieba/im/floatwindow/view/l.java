package com.baidu.tieba.im.floatwindow.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnTouchListener {
    final /* synthetic */ i aYA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.aYA = iVar;
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
                point3 = this.aYA.aXv;
                point3.x = (int) motionEvent.getX();
                point4 = this.aYA.aXv;
                point4.y = (int) motionEvent.getY();
                break;
            case 1:
                this.aYA.aYx = false;
                headImageView = this.aYA.aFT;
                headImageView.setVisibility(0);
                i iVar = this.aYA;
                i = this.aYA.aYw;
                iVar.fI(i);
                com.baidu.tieba.im.floatwindow.b MX = com.baidu.tieba.im.floatwindow.b.MX();
                mVar = this.aYA.aYy;
                MX.a(mVar);
                break;
            case 2:
                com.baidu.tieba.im.floatwindow.b MX2 = com.baidu.tieba.im.floatwindow.b.MX();
                point = this.aYA.aXv;
                int rawX = ((int) motionEvent.getRawX()) + point.x;
                point2 = this.aYA.aXv;
                MX2.P(rawX, (((int) motionEvent.getRawY()) - point2.y) - 25);
                break;
        }
        return false;
    }
}
