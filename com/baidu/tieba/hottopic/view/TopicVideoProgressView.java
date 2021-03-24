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
    public int f17684e;

    /* renamed from: f  reason: collision with root package name */
    public MediaController.MediaPlayerControl f17685f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17686g;

    /* renamed from: h  reason: collision with root package name */
    public View f17687h;
    public Handler i;

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1 && TopicVideoProgressView.this.f17686g && TopicVideoProgressView.this.f17685f != null && TopicVideoProgressView.this.f17685f.isPlaying()) {
                sendMessageDelayed(obtainMessage(1), TopicVideoProgressView.this.f17684e - (TopicVideoProgressView.this.j() % TopicVideoProgressView.this.f17684e));
            }
        }
    }

    public TopicVideoProgressView(Context context) {
        super(context);
        this.f17684e = 50;
        this.f17686g = true;
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
        this.f17687h = view;
        view.setBackgroundColor(getResources().getColor(R.color.CAM_X0303));
        addView(this.f17687h, 0, (int) context.getResources().getDimension(R.dimen.ds6));
        setBackgroundColor(getResources().getColor(R.color.CAM_X0204));
    }

    public void g() {
        RelativeLayout.LayoutParams layoutParams;
        this.f17686g = false;
        this.i.removeMessages(1);
        View view = this.f17687h;
        if (view == null || (layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = 0;
        this.f17687h.setLayoutParams(layoutParams);
    }

    public void h(int i) {
        SkinManager.setBackgroundColor(this, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f17687h, R.color.CAM_X0303);
    }

    public void i() {
        g();
    }

    public final int j() {
        MediaController.MediaPlayerControl mediaPlayerControl = this.f17685f;
        if (mediaPlayerControl == null || this.f17687h == null) {
            return 0;
        }
        int currentPosition = mediaPlayerControl.getCurrentPosition();
        int duration = this.f17685f.getDuration();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f17687h.getLayoutParams();
        if ((layoutParams instanceof RelativeLayout.LayoutParams) && duration > 0) {
            layoutParams.width = (int) (((getWidth() * 1.0f) * currentPosition) / duration);
            this.f17687h.setLayoutParams(layoutParams);
        }
        return currentPosition;
    }

    public void k() {
        MediaController.MediaPlayerControl mediaPlayerControl = this.f17685f;
        if (mediaPlayerControl == null) {
            return;
        }
        int duration = ((mediaPlayerControl.getDuration() / 200) / 50) * 50;
        this.f17684e = duration;
        if (duration < 50) {
            this.f17684e = 50;
        }
        this.f17686g = true;
        this.i.removeMessages(1);
        Handler handler = this.i;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f17684e - (this.f17685f.getCurrentPosition() % this.f17684e));
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.f17685f = mediaPlayerControl;
    }

    public TopicVideoProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17684e = 50;
        this.f17686g = true;
        this.i = new a(Looper.getMainLooper());
        f(context);
    }

    public TopicVideoProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17684e = 50;
        this.f17686g = true;
        this.i = new a(Looper.getMainLooper());
        f(context);
    }
}
