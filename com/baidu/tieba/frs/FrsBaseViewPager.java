package com.baidu.tieba.frs;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class FrsBaseViewPager extends BdBaseViewPager {
    public int j;
    public float k;
    public Activity l;
    public boolean m;
    public a n;
    public boolean o;
    public boolean p;

    /* loaded from: classes4.dex */
    public interface a {
        void a();

        boolean b();
    }

    public FrsBaseViewPager(Context context) {
        this(context, null);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.k = motionEvent.getRawX();
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            a aVar = this.n;
            if (aVar != null) {
                aVar.a();
            }
            if (this.k >= getMeasuredWidth() - this.j && this.k <= getMeasuredWidth()) {
                setmDisallowSlip(false);
                this.m = true;
                this.p = true;
            } else {
                this.p = false;
            }
        } else if (action != 1) {
            if (action == 2 && this.p) {
                a aVar2 = this.n;
                boolean b2 = aVar2 != null ? aVar2.b() : true;
                setmDisallowSlip((this.m && b2) ? true : true);
                this.p = b2;
            }
        } else {
            this.p = true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.o || this.m) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.k = motionEvent.getRawX();
        if (motionEvent.getAction() == 1) {
            if (this.m) {
                this.m = false;
            }
            if (this.o) {
                this.o = false;
            }
            setmDisallowSlip(false);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceIntercept(boolean z) {
        this.o = z;
    }

    public void setOnTouchEventListener(a aVar) {
        this.n = aVar;
    }

    public FrsBaseViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = 0;
        this.p = true;
        Activity activity = (Activity) context;
        this.l = activity;
        this.j = l.e(activity, 0);
        BdBaseViewPager.a aVar = new BdBaseViewPager.a(this.l);
        aVar.b(1000);
        aVar.a(this);
    }
}
