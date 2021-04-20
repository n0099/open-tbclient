package com.baidu.tieba.addresslist.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.h0.s.f.c;
/* loaded from: classes4.dex */
public class AssortView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Paint f14317e;

    /* renamed from: f  reason: collision with root package name */
    public int f14318f;

    /* renamed from: g  reason: collision with root package name */
    public a f14319g;

    /* loaded from: classes4.dex */
    public interface a {
        void f0(String str);

        void z0();
    }

    public AssortView(Context context) {
        super(context);
        this.f14318f = -1;
        a();
    }

    public final void a() {
        this.f14317e = new Paint();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        float f2 = (float) (width / 48.0d);
        String[] strArr = c.f51772a;
        int length = height / strArr.length;
        int length2 = strArr.length;
        for (int i = 0; i < length2; i++) {
            this.f14317e.setAntiAlias(true);
            this.f14317e.setTypeface(Typeface.DEFAULT_BOLD);
            this.f14317e.setColor(SkinManager.getColor(R.color.CAM_X0108));
            this.f14317e.setTextSize(26.0f * f2);
            canvas.drawText(c.f51772a[i], (width / 2.0f) - (this.f14317e.measureText(c.f51772a[i]) / 2.0f), (length * i) + length, this.f14317e);
            this.f14317e.reset();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        float y = motionEvent.getY() / getHeight();
        String[] strArr = c.f51772a;
        int length = (int) (y * strArr.length);
        if (length >= 0 && length < strArr.length) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f14318f = length;
                a aVar = this.f14319g;
                if (aVar != null) {
                    aVar.f0(c.f51772a[length]);
                }
            } else if (action != 1) {
                if (action == 2 && this.f14318f != length) {
                    this.f14318f = length;
                    a aVar2 = this.f14319g;
                    if (aVar2 != null) {
                        aVar2.f0(c.f51772a[length]);
                    }
                }
            } else {
                a aVar3 = this.f14319g;
                if (aVar3 != null) {
                    aVar3.z0();
                }
                this.f14318f = -1;
            }
        } else {
            this.f14318f = -1;
            a aVar4 = this.f14319g;
            if (aVar4 != null) {
                aVar4.z0();
            }
        }
        return true;
    }

    public void setOnTouchListener(a aVar) {
        this.f14319g = aVar;
    }

    public AssortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14318f = -1;
        a();
    }

    public AssortView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14318f = -1;
        a();
    }
}
