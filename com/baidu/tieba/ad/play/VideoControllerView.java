package com.baidu.tieba.ad.play;

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
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class VideoControllerView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f14212e;

    /* renamed from: f  reason: collision with root package name */
    public int f14213f;

    /* renamed from: g  reason: collision with root package name */
    public MediaController.MediaPlayerControl f14214g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f14215h;
    public TextView i;
    public boolean j;
    public boolean k;
    public SeekBar l;
    public d m;
    public c n;
    public SeekBar.OnSeekBarChangeListener o;
    public int p;
    public int q;
    public Handler r;
    public SeekBar.OnSeekBarChangeListener s;

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1 && !VideoControllerView.this.j && VideoControllerView.this.k && VideoControllerView.this.f14214g != null) {
                int r = VideoControllerView.this.r();
                if (VideoControllerView.this.m != null) {
                    VideoControllerView.this.m.a(r);
                }
                sendMessageDelayed(obtainMessage(1), VideoControllerView.this.f14213f - (r % VideoControllerView.this.f14213f));
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
                VideoControllerView.this.q = (int) ((VideoControllerView.this.f14214g.getDuration() * i) / 10000);
                if (VideoControllerView.this.f14215h != null) {
                    VideoControllerView.this.f14215h.setText(StringHelper.stringForVideoTime(VideoControllerView.this.q));
                }
                if (VideoControllerView.this.n != null) {
                    VideoControllerView.this.n.a();
                }
                if (VideoControllerView.this.o != null) {
                    VideoControllerView.this.o.onProgressChanged(seekBar, VideoControllerView.this.q, z);
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            VideoControllerView.this.j = true;
            if (VideoControllerView.this.o != null) {
                VideoControllerView.this.o.onStartTrackingTouch(seekBar);
            }
            VideoControllerView.this.r.removeMessages(1);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            VideoControllerView.this.f14214g.seekTo(VideoControllerView.this.q);
            VideoControllerView.this.j = false;
            VideoControllerView.this.r.sendEmptyMessageDelayed(1, 500L);
            if (VideoControllerView.this.o != null) {
                VideoControllerView.this.o.onStopTrackingTouch(seekBar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(int i);
    }

    public VideoControllerView(Context context) {
        super(context);
        this.f14213f = 50;
        this.j = false;
        this.k = true;
        this.q = 0;
        this.r = new a(Looper.getMainLooper());
        this.s = new b();
        o(context);
    }

    public int getCurProgress() {
        SeekBar seekBar = this.l;
        if (seekBar != null) {
            return seekBar.getProgress();
        }
        return 0;
    }

    public int getSeekPosition() {
        return this.q;
    }

    public View n(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.ad_video_controller, (ViewGroup) null);
    }

    public final void o(Context context) {
        this.f14212e = context;
        View n = n(context);
        addView(n, -1, (int) context.getResources().getDimension(R.dimen.ds80));
        this.f14215h = (TextView) n.findViewById(R.id.textview_cur_time);
        this.i = (TextView) n.findViewById(R.id.textview_duration);
        SeekBar seekBar = (SeekBar) n.findViewById(R.id.pb_video_controller_seekBar);
        this.l = seekBar;
        seekBar.setOnSeekBarChangeListener(this.s);
    }

    public void p(int i, int i2) {
        this.p = i2;
        this.k = false;
        this.r.removeMessages(1);
        this.l.setProgress((int) (((i * 1.0f) / i2) * 10000.0f));
        TextView textView = this.f14215h;
        if (textView != null) {
            textView.setText(StringHelper.stringForVideoTime(i));
        }
        TextView textView2 = this.i;
        if (textView2 != null) {
            textView2.setText(StringHelper.stringForVideoTime(this.p));
        }
    }

    public void q() {
        this.k = false;
        this.r.removeMessages(1);
        this.l.setProgress(0);
        TextView textView = this.f14215h;
        if (textView != null) {
            textView.setText(StringHelper.stringForVideoTime(0));
        }
    }

    public final int r() {
        MediaController.MediaPlayerControl mediaPlayerControl = this.f14214g;
        if (mediaPlayerControl == null || this.j) {
            return 0;
        }
        int currentPosition = mediaPlayerControl.getCurrentPosition();
        int duration = this.f14214g.getDuration();
        if (currentPosition > duration) {
            currentPosition = duration;
        }
        SeekBar seekBar = this.l;
        if (seekBar != null) {
            if (duration > 0) {
                seekBar.setProgress((int) ((currentPosition * 10000) / duration));
            }
            this.f14214g.getBufferPercentage();
        }
        TextView textView = this.f14215h;
        if (textView != null) {
            textView.setText(StringHelper.stringForVideoTime(currentPosition));
        }
        return currentPosition;
    }

    public void s() {
        MediaController.MediaPlayerControl mediaPlayerControl = this.f14214g;
        if (mediaPlayerControl == null) {
            return;
        }
        int duration = ((mediaPlayerControl.getDuration() / 200) / 50) * 50;
        this.f14213f = duration;
        if (duration < 50) {
            this.f14213f = 50;
        } else if (duration > 500) {
            this.f14213f = 500;
        }
        this.k = true;
        this.r.removeMessages(1);
        Handler handler = this.r;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f14213f - (this.f14214g.getCurrentPosition() % this.f14213f));
    }

    public void setCurrentDuration(int i, boolean z) {
        if (i < 0) {
            i = 0;
        }
        if (!z) {
            Handler handler = this.r;
            if (handler != null) {
                handler.removeMessages(1);
            }
        } else {
            this.f14214g.seekTo(i);
            TextView textView = this.f14215h;
            if (textView != null) {
                textView.setText(StringHelper.stringForVideoTime(i));
            }
            s();
        }
        if (this.f14214g.isPlaying()) {
            return;
        }
        this.l.setProgress((int) (((i * 1.0f) / this.p) * 10000.0f));
    }

    public void setOnDragingListener(c cVar) {
        this.n = cVar;
    }

    public void setOnProgressUpdatedListener(d dVar) {
        this.m = dVar;
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.o = onSeekBarChangeListener;
    }

    public void setPlayer(MediaController.MediaPlayerControl mediaPlayerControl) {
        this.f14214g = mediaPlayerControl;
    }

    public VideoControllerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14213f = 50;
        this.j = false;
        this.k = true;
        this.q = 0;
        this.r = new a(Looper.getMainLooper());
        this.s = new b();
        o(context);
    }

    public VideoControllerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14213f = 50;
        this.j = false;
        this.k = true;
        this.q = 0;
        this.r = new a(Looper.getMainLooper());
        this.s = new b();
        o(context);
    }
}
