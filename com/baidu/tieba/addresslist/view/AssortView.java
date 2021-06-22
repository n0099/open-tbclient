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
import d.a.n0.s.f.c;
/* loaded from: classes4.dex */
public class AssortView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Paint f13766e;

    /* renamed from: f  reason: collision with root package name */
    public int f13767f;

    /* renamed from: g  reason: collision with root package name */
    public a f13768g;

    /* loaded from: classes4.dex */
    public interface a {
        void D0();

        void s0(String str);
    }

    public AssortView(Context context) {
        super(context);
        this.f13767f = -1;
        a();
    }

    public final void a() {
        this.f13766e = new Paint();
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
        String[] strArr = c.f54448a;
        int length = height / strArr.length;
        int length2 = strArr.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.f13766e.setAntiAlias(true);
            this.f13766e.setTypeface(Typeface.DEFAULT_BOLD);
            this.f13766e.setColor(SkinManager.getColor(R.color.CAM_X0108));
            this.f13766e.setTextSize(26.0f * f2);
            canvas.drawText(c.f54448a[i2], (width / 2.0f) - (this.f13766e.measureText(c.f54448a[i2]) / 2.0f), (length * i2) + length, this.f13766e);
            this.f13766e.reset();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        float y = motionEvent.getY() / getHeight();
        String[] strArr = c.f54448a;
        int length = (int) (y * strArr.length);
        if (length >= 0 && length < strArr.length) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f13767f = length;
                a aVar = this.f13768g;
                if (aVar != null) {
                    aVar.s0(c.f54448a[length]);
                }
            } else if (action != 1) {
                if (action == 2 && this.f13767f != length) {
                    this.f13767f = length;
                    a aVar2 = this.f13768g;
                    if (aVar2 != null) {
                        aVar2.s0(c.f54448a[length]);
                    }
                }
            } else {
                a aVar3 = this.f13768g;
                if (aVar3 != null) {
                    aVar3.D0();
                }
                this.f13767f = -1;
            }
        } else {
            this.f13767f = -1;
            a aVar4 = this.f13768g;
            if (aVar4 != null) {
                aVar4.D0();
            }
        }
        return true;
    }

    public void setOnTouchListener(a aVar) {
        this.f13768g = aVar;
    }

    public AssortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13767f = -1;
        a();
    }

    public AssortView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13767f = -1;
        a();
    }
}
