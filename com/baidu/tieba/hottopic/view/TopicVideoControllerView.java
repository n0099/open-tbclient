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
    public int f17356e;

    /* renamed from: f  reason: collision with root package name */
    public MediaController.MediaPlayerControl f17357f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17358g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17359h;
    public boolean i;
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
            if (message.what == 1 && !TopicVideoControllerView.this.i && TopicVideoControllerView.this.j && TopicVideoControllerView.this.f17357f != null && TopicVideoControllerView.this.f17357f.isPlaying()) {
                sendMessageDelayed(obtainMessage(1), TopicVideoControllerView.this.f17356e - (TopicVideoControllerView.this.p() % TopicVideoControllerView.this.f17356e));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                int duration = (int) ((TopicVideoControllerView.this.f17357f.getDuration() * i) / 10000);
                TopicVideoControllerView.this.f17357f.seekTo(duration);
                if (TopicVideoControllerView.this.f17358g != null) {
                    TopicVideoControllerView.this.f17358g.setText(TopicVideoControllerView.this.r(duration));
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            TopicVideoControllerView.this.i = true;
            TopicVideoControllerView.this.n.removeMessages(1);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            TopicVideoControllerView.this.i = false;
            TopicVideoControllerView.this.p();
            TopicVideoControllerView.this.n.sendEmptyMessage(1);
        }
    }

    public TopicVideoControllerView(Context context) {
        super(context);
        this.f17356e = 50;
        this.i = false;
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
        this.f17358g = (TextView) inflate.findViewById(R.id.progress_textview_cur_time);
        this.f17359h = (TextView) inflate.findViewById(R.id.progress_textview_duration);
        SeekBar seekBar = (SeekBar) inflate.findViewById(R.id.topic_video_controller_seekBar);
        this.k = seekBar;
        seekBar.setOnSeekBarChangeListener(this.o);
        this.l = new StringBuilder();
        this.m = new Formatter(this.l, Locale.getDefault());
    }

    public void l(int i, int i2) {
        this.j = false;
        this.n.removeMessages(1);
        this.k.setProgress(0);
        TextView textView = this.f17358g;
        if (textView != null) {
            textView.setText(r(i));
        }
        TextView textView2 = this.f17359h;
        if (textView2 != null) {
            textView2.setText(r(n(i2)));
        }
    }

    public void m(int i) {
        SkinManager.setViewTextColor(this.f17358g, R.color.CAM_X0101, 1);
        SkinManager.setViewTextColor(this.f17359h, R.color.CAM_X0101, 1);
        this.k.setProgressDrawable(SkinManager.getSkinDrawable(null, R.drawable.topic_video_seekbar));
        this.k.setThumb(SkinManager.getSkinDrawable(null, R.drawable.topic_video_seekbar_thumb));
        this.k.setThumbOffset(0);
    }

    public final int n(int i) {
        return (int) (Math.ceil((i * 1.0f) / 1000.0f) * 1000.0d);
    }

    public void o() {
        this.j = false;
        this.n.removeMessages(1);
        this.k.setProgress(0);
        TextView textView = this.f17358g;
        if (textView != null) {
            textView.setText(r(0));
        }
    }

    public final int p() {
        MediaController.MediaPlayerControl mediaPlayerControl = this.f17357f;
        if (mediaPlayerControl == null || this.i) {
            return 0;
        }
        int currentPosition = mediaPlayerControl.getCurrentPosition();
        int duration = this.f17357f.getDuration();
        SeekBar seekBar = this.k;
        if (seekBar != null && duration > 0) {
            seekBar.setProgress((int) ((currentPosition * 10000) / duration));
        }
        TextView textView = this.f17359h;
        if (textView != null && duration > 0) {
            textView.setText(r(n(duration)));
        }
        TextView textView2 = this.f17358g;
        if (textView2 != null) {
            textView2.setText(r(currentPosition));
        }
        return currentPosition;
    }

    public void q() {
        MediaController.MediaPlayerControl mediaPlayerControl = this.f17357f;
        if (mediaPlayerControl == null) {
            return;
        }
        int duration = ((mediaPlayerControl.getDuration() / 200) / 50) * 50;
        this.f17356e = duration;
        if (duration < 50) {
            this.f17356e = 50;
        }
        this.j = true;
        this.n.removeMessages(1);
        Handler handler = this.n;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f17356e - (this.f17357f.getCurrentPosition() % this.f17356e));
    }

    public final String r(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.l.setLength(0);
        return i5 > 0 ? this.m.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.m.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.f17357f = mediaPlayerControl;
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17356e = 50;
        this.i = false;
        this.j = true;
        this.n = new a(Looper.getMainLooper());
        this.o = new b();
        k(context);
    }

    public TopicVideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f17356e = 50;
        this.i = false;
        this.j = true;
        this.n = new a(Looper.getMainLooper());
        this.o = new b();
        k(context);
    }
}
