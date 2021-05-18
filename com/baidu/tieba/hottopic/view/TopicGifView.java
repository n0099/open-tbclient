package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/* loaded from: classes4.dex */
public class TopicGifView extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: e  reason: collision with root package name */
    public SurfaceHolder f16981e;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public TopicGifView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        new Thread(new a());
        a();
    }

    public final void a() {
        SurfaceHolder holder = getHolder();
        this.f16981e = holder;
        holder.addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public TopicGifView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        new Thread(new a());
        a();
    }

    public TopicGifView(Context context) {
        super(context);
        new Thread(new a());
        a();
    }
}
