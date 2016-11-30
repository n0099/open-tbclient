package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class h extends BaseViewPager {
    private PointF aoN;
    private com.baidu.tbadk.widget.a aoO;
    private com.baidu.tbadk.widget.a aoP;

    public h(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.aoO = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.aoO;
    }

    private float[] i(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.aoN.x, pointF.y - this.aoN.y};
            case 0:
                this.aoN = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.aoO != null) {
                this.aoO.Ho();
            }
        }
        if (this.aoO == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] i = i(motionEvent);
        if (this.aoO.Hp()) {
            return super.onTouchEvent(motionEvent);
        }
        if (i != null && this.aoO.Ht() && i[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (i != null && this.aoO.Hu() && i[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (i == null) {
            if (this.aoO.Hu() || this.aoO.Ht()) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onInterceptTouchEvent(motionEvent);
        }
        float[] i = i(motionEvent);
        if (this.aoO == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.aoO.Hp()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (i != null && this.aoO.Ht() && i[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (i != null && this.aoO.Hu() && i[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (i == null) {
            if (this.aoO.Hu() || this.aoO.Ht()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.aoP = aVar;
    }

    public com.baidu.tbadk.widget.a getSelectedView() {
        return this.aoP;
    }
}
