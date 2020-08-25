package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
/* loaded from: classes15.dex */
public class TopicGifView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder jdd;
    private Thread thread;

    public TopicGifView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.thread = new Thread(new Runnable() { // from class: com.baidu.tieba.hottopic.view.TopicGifView.1
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        init();
    }

    public TopicGifView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.thread = new Thread(new Runnable() { // from class: com.baidu.tieba.hottopic.view.TopicGifView.1
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        init();
    }

    public TopicGifView(Context context) {
        super(context);
        this.thread = new Thread(new Runnable() { // from class: com.baidu.tieba.hottopic.view.TopicGifView.1
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        init();
    }

    private void init() {
        this.jdd = getHolder();
        this.jdd.addCallback(this);
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
}
