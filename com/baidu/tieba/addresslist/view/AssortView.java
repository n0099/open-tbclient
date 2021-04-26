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
import d.a.i0.s.f.c;
/* loaded from: classes4.dex */
public class AssortView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Paint f14380e;

    /* renamed from: f  reason: collision with root package name */
    public int f14381f;

    /* renamed from: g  reason: collision with root package name */
    public a f14382g;

    /* loaded from: classes4.dex */
    public interface a {
        void B0();

        void p0(String str);
    }

    public AssortView(Context context) {
        super(context);
        this.f14381f = -1;
        a();
    }

    public final void a() {
        this.f14380e = new Paint();
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
        String[] strArr = c.f49772a;
        int length = height / strArr.length;
        int length2 = strArr.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.f14380e.setAntiAlias(true);
            this.f14380e.setTypeface(Typeface.DEFAULT_BOLD);
            this.f14380e.setColor(SkinManager.getColor(R.color.CAM_X0108));
            this.f14380e.setTextSize(26.0f * f2);
            canvas.drawText(c.f49772a[i2], (width / 2.0f) - (this.f14380e.measureText(c.f49772a[i2]) / 2.0f), (length * i2) + length, this.f14380e);
            this.f14380e.reset();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        float y = motionEvent.getY() / getHeight();
        String[] strArr = c.f49772a;
        int length = (int) (y * strArr.length);
        if (length >= 0 && length < strArr.length) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f14381f = length;
                a aVar = this.f14382g;
                if (aVar != null) {
                    aVar.p0(c.f49772a[length]);
                }
            } else if (action != 1) {
                if (action == 2 && this.f14381f != length) {
                    this.f14381f = length;
                    a aVar2 = this.f14382g;
                    if (aVar2 != null) {
                        aVar2.p0(c.f49772a[length]);
                    }
                }
            } else {
                a aVar3 = this.f14382g;
                if (aVar3 != null) {
                    aVar3.B0();
                }
                this.f14381f = -1;
            }
        } else {
            this.f14381f = -1;
            a aVar4 = this.f14382g;
            if (aVar4 != null) {
                aVar4.B0();
            }
        }
        return true;
    }

    public void setOnTouchListener(a aVar) {
        this.f14382g = aVar;
    }

    public AssortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14381f = -1;
        a();
    }

    public AssortView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f14381f = -1;
        a();
    }
}
