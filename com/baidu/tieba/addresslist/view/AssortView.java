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
import d.b.i0.s.f.c;
/* loaded from: classes4.dex */
public class AssortView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Paint f14325e;

    /* renamed from: f  reason: collision with root package name */
    public int f14326f;

    /* renamed from: g  reason: collision with root package name */
    public a f14327g;

    /* loaded from: classes4.dex */
    public interface a {
        void f0(String str);

        void z0();
    }

    public AssortView(Context context) {
        super(context);
        this.f14326f = -1;
        a();
    }

    public final void a() {
        this.f14325e = new Paint();
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
        String[] strArr = c.f52108a;
        int length = height / strArr.length;
        int length2 = strArr.length;
        for (int i = 0; i < length2; i++) {
            this.f14325e.setAntiAlias(true);
            this.f14325e.setTypeface(Typeface.DEFAULT_BOLD);
            this.f14325e.setColor(SkinManager.getColor(R.color.CAM_X0108));
            this.f14325e.setTextSize(26.0f * f2);
            canvas.drawText(c.f52108a[i], (width / 2.0f) - (this.f14325e.measureText(c.f52108a[i]) / 2.0f), (length * i) + length, this.f14325e);
            this.f14325e.reset();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        float y = motionEvent.getY() / getHeight();
        String[] strArr = c.f52108a;
        int length = (int) (y * strArr.length);
        if (length >= 0 && length < strArr.length) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f14326f = length;
                a aVar = this.f14327g;
                if (aVar != null) {
                    aVar.f0(c.f52108a[length]);
                }
            } else if (action != 1) {
                if (action == 2 && this.f14326f != length) {
                    this.f14326f = length;
                    a aVar2 = this.f14327g;
                    if (aVar2 != null) {
                        aVar2.f0(c.f52108a[length]);
                    }
                }
            } else {
                a aVar3 = this.f14327g;
                if (aVar3 != null) {
                    aVar3.z0();
                }
                this.f14326f = -1;
            }
        } else {
            this.f14326f = -1;
            a aVar4 = this.f14327g;
            if (aVar4 != null) {
                aVar4.z0();
            }
        }
        return true;
    }

    public void setOnTouchListener(a aVar) {
        this.f14327g = aVar;
    }

    public AssortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14326f = -1;
        a();
    }

    public AssortView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14326f = -1;
        a();
    }
}
