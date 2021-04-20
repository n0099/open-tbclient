package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class TopicVideoProgressView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f17362e;

    /* renamed from: f  reason: collision with root package name */
    public MediaController.MediaPlayerControl f17363f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17364g;

    /* renamed from: h  reason: collision with root package name */
    public View f17365h;
    public Handler i;

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1 && TopicVideoProgressView.this.f17364g && TopicVideoProgressView.this.f17363f != null && TopicVideoProgressView.this.f17363f.isPlaying()) {
                sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.f17362e - (TopicVideoProgressView.this.j() % TopicVideoProgressView.this.f17362e));
            }
        }
    }

    public TopicVideoProgressView(Context context) {
        super(context);
        this.f17362e = 50;
        this.f17364g = true;
        this.i = new a(Looper.getMainLooper());
        f(context);
    }

    public void e() {
        Handler handler = this.i;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    public final void f(Context context) {
        View view = new View(context);
        this.f17365h = view;
        view.setBackgroundColor(getResources().getColor(R.color.CAM_X0303));
        addView(this.f17365h, 0, (int) context.getResources().getDimension(R.dimen.ds6));
        setBackgroundColor(getResources().getColor(R.color.CAM_X0204));
    }

    public void g() {
        RelativeLayout.LayoutParams layoutParams;
        this.f17364g = false;
        this.i.removeMessages(1);
        View view = this.f17365h;
        if (view == null || (layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = 0;
        this.f17365h.setLayoutParams(layoutParams);
    }

    public void h(int i) {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f17365h, R.color.CAM_X0303);
    }

    public void i() {
        g();
    }

    public final int j() {
        MediaController.MediaPlayerControl mediaPlayerControl = this.f17363f;
        if (mediaPlayerControl == null || this.f17365h == null) {
            return 0;
        }
        int currentPosition = mediaPlayerControl.getCurrentPosition();
        int duration = this.f17363f.getDuration();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f17365h.getLayoutParams();
        if ((layoutParams instanceof RelativeLayout.LayoutParams) && duration > 0) {
            layoutParams.width = (int) (((getWidth() * 1.0f) * currentPosition) / duration);
            this.f17365h.setLayoutParams(layoutParams);
        }
        return currentPosition;
    }

    public void k() {
        MediaController.MediaPlayerControl mediaPlayerControl = this.f17363f;
        if (mediaPlayerControl == null) {
            return;
        }
        int duration = ((mediaPlayerControl.getDuration() / 200) / 50) * 50;
        this.f17362e = duration;
        if (duration < 50) {
            this.f17362e = 50;
        }
        this.f17364g = true;
        this.i.removeMessages(1);
        Handler handler = this.i;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f17362e - (this.f17363f.getCurrentPosition() % this.f17362e));
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.f17363f = mediaPlayerControl;
    }

    public TopicVideoProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17362e = 50;
        this.f17364g = true;
        this.i = new a(Looper.getMainLooper());
        f(context);
    }

    public TopicVideoProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17362e = 50;
        this.f17364g = true;
        this.i = new a(Looper.getMainLooper());
        f(context);
    }
}
