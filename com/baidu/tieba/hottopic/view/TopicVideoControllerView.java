package com.baidu.tieba.hottopic.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes4.dex */
public class TopicVideoControllerView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f16969e;

    /* renamed from: f  reason: collision with root package name */
    public MediaController.MediaPlayerControl f16970f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16971g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16972h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f16973i;
    public boolean j;
    public SeekBar k;
    public StringBuilder l;
    public Formatter m;
    public Handler n;
    public SeekBar.OnSeekBarChangeListener o;

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1 && !TopicVideoControllerView.this.f16973i && TopicVideoControllerView.this.j && TopicVideoControllerView.this.f16970f != null && TopicVideoControllerView.this.f16970f.isPlaying()) {
                sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.f16969e - (TopicVideoControllerView.this.p() % TopicVideoControllerView.this.f16969e));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            if (z) {
                int duration = (int) ((TopicVideoControllerView.this.f16970f.getDuration() * i2) / 10000);
                TopicVideoControllerView.this.f16970f.seekTo(duration);
                if (TopicVideoControllerView.this.f16971g != null) {
                    TopicVideoControllerView.this.f16971g.setText(TopicVideoControllerView.this.r(duration));
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TopicVideoControllerView.this.f16973i = true;
            TopicVideoControllerView.this.n.removeMessages(1);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            TopicVideoControllerView.this.f16973i = false;
            TopicVideoControllerView.this.p();
            TopicVideoControllerView.this.n.sendEmptyMessage(1);
        }
    }

    public TopicVideoControllerView(Context context) {
        super(context);
        this.f16969e = 50;
        this.f16973i = false;
        this.j = true;
        this.n = new a(Looper.getMainLooper());
        this.o = new b();
        k(context);
    }

    public int getCurProgress() {
        SeekBar seekBar = this.k;
        if (seekBar != null) {
            return seekBar.getProgress();
        }
        return 0;
    }

    public void j() {
        Handler handler = this.n;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    public final void k(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.topic_video_controller, (ViewGroup) null);
        addView(inflate, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.f16971g = (TextView) inflate.findViewById(R.id.progress_textview_cur_time);
        this.f16972h = (TextView) inflate.findViewById(R.id.progress_textview_duration);
        SeekBar seekBar = (SeekBar) inflate.findViewById(R.id.topic_video_controller_seekBar);
        this.k = seekBar;
        seekBar.setOnSeekBarChangeListener(this.o);
        this.l = new StringBuilder();
        this.m = new Formatter(this.l, Locale.getDefault());
    }

    public void l(int i2, int i3) {
        this.j = false;
        this.n.removeMessages(1);
        this.k.setProgress(0);
        TextView textView = this.f16971g;
        if (textView != null) {
            textView.setText(r(i2));
        }
        TextView textView2 = this.f16972h;
        if (textView2 != null) {
            textView2.setText(r(n(i3)));
        }
    }

    public void m(int i2) {
        SkinManager.setViewTextColor(this.f16971g, R.color.CAM_X0101, 1);
        SkinManager.setViewTextColor(this.f16972h, R.color.CAM_X0101, 1);
        this.k.setProgressDrawable(SkinManager.getSkinDrawable(null, R.drawable.topic_video_seekbar));
        this.k.setThumb(SkinManager.getSkinDrawable(null, R.drawable.topic_video_seekbar_thumb));
        this.k.setThumbOffset(0);
    }

    public final int n(int i2) {
        return (int) (Math.ceil((i2 * 1.0f) / 1000.0f) * 1000.0d);
    }

    public void o() {
        this.j = false;
        this.n.removeMessages(1);
        this.k.setProgress(0);
        TextView textView = this.f16971g;
        if (textView != null) {
            textView.setText(r(0));
        }
    }

    public final int p() {
        MediaController.MediaPlayerControl mediaPlayerControl = this.f16970f;
        if (mediaPlayerControl == null || this.f16973i) {
            return 0;
        }
        int currentPosition = mediaPlayerControl.getCurrentPosition();
        int duration = this.f16970f.getDuration();
        SeekBar seekBar = this.k;
        if (seekBar != null && duration > 0) {
            seekBar.setProgress((int) ((currentPosition * 10000) / duration));
        }
        TextView textView = this.f16972h;
        if (textView != null && duration > 0) {
            textView.setText(r(n(duration)));
        }
        TextView textView2 = this.f16971g;
        if (textView2 != null) {
            textView2.setText(r(currentPosition));
        }
        return currentPosition;
    }

    public void q() {
        MediaController.MediaPlayerControl mediaPlayerControl = this.f16970f;
        if (mediaPlayerControl == null) {
            return;
        }
        int duration = ((mediaPlayerControl.getDuration() / 200) / 50) * 50;
        this.f16969e = duration;
        if (duration < 50) {
            this.f16969e = 50;
        }
        this.j = true;
        this.n.removeMessages(1);
        Handler handler = this.n;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f16969e - (this.f16970f.getCurrentPosition() % this.f16969e));
    }

    public final String r(int i2) {
        int i3 = i2 / 1000;
        int i4 = i3 % 60;
        int i5 = (i3 / 60) % 60;
        int i6 = i3 / 3600;
        this.l.setLength(0);
        return i6 > 0 ? this.m.format("%d:%02d:%02d", Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i4)).toString() : this.m.format("%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4)).toString();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.f16970f = mediaPlayerControl;
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16969e = 50;
        this.f16973i = false;
        this.j = true;
        this.n = new a(Looper.getMainLooper());
        this.o = new b();
        k(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16969e = 50;
        this.f16973i = false;
        this.j = true;
        this.n = new a(Looper.getMainLooper());
        this.o = new b();
        k(context);
    }
}
