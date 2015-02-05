package com.baidu.tieba.im.floatwindow.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnTouchListener {
    final /* synthetic */ i aZV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.aZV = iVar;
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
                point3 = this.aZV.aYQ;
                point3.x = (int) motionEvent.getX();
                point4 = this.aZV.aYQ;
                point4.y = (int) motionEvent.getY();
                break;
            case 1:
                this.aZV.aZS = false;
                headImageView = this.aZV.aHa;
                headImageView.setVisibility(0);
                i iVar = this.aZV;
                i = this.aZV.aZR;
                iVar.fN(i);
                com.baidu.tieba.im.floatwindow.b No = com.baidu.tieba.im.floatwindow.b.No();
                mVar = this.aZV.aZT;
                No.a(mVar);
                break;
            case 2:
                com.baidu.tieba.im.floatwindow.b No2 = com.baidu.tieba.im.floatwindow.b.No();
                point = this.aZV.aYQ;
                int rawX = ((int) motionEvent.getRawX()) + point.x;
                point2 = this.aZV.aYQ;
                No2.R(rawX, (((int) motionEvent.getRawY()) - point2.y) - 25);
                break;
        }
        return false;
    }
}
