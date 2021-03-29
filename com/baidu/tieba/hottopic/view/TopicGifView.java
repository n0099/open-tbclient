package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/* loaded from: classes3.dex */
public class TopicGifView extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: e  reason: collision with root package name */
    public SurfaceHolder f17677e;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public TopicGifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        new Thread(new a());
        a();
    }

    public final void a() {
        SurfaceHolder holder = getHolder();
        this.f17677e = holder;
        holder.addCallback(this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
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
