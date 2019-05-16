package com.baidu.tieba.aiapps.apps.media.videoplayer.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.media.videoplayer.SwanVideoView;
import com.baidu.tieba.aiapps.apps.media.videoplayer.a.a;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes4.dex */
public class MediaController extends RelativeLayout {
    private a der;
    private ImageButton dfd;
    private View dfe;
    private View dff;
    private TextView dfg;
    private SeekBar dfh;
    private TextView dfi;
    private long dfj;
    private Timer dfk;
    private Timer dfl;
    private SwanVideoView dfm;
    boolean dfn;
    private boolean dfo;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.dfo = false;
        aFq();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dfo = false;
        aFq();
    }

    private void aFq() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.media_controller, this);
        this.dfd = (ImageButton) inflate.findViewById(R.id.btn_play);
        this.dfd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dfm != null) {
                    if (MediaController.this.dfm.isPlaying()) {
                        MediaController.this.dfd.setBackgroundResource(R.drawable.btn_play);
                        MediaController.this.dfm.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.dfd.setBackgroundResource(R.drawable.btn_pause);
                    MediaController.this.dfm.start();
                }
            }
        });
        this.dfg = (TextView) inflate.findViewById(R.id.tv_position);
        this.dfh = (SeekBar) inflate.findViewById(R.id.seekbar);
        this.dfi = (TextView) inflate.findViewById(R.id.tv_duration);
        this.dfh.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.mI(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.dfn = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.dfm.getDuration() > 0) {
                    MediaController.this.dfj = seekBar.getProgress();
                    if (MediaController.this.dfm != null) {
                        MediaController.this.dfm.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.dfn = false;
            }
        });
        this.dff = inflate.findViewById(R.id.btn_mute);
        this.dff.setBackgroundResource(this.dfm != null && this.dfm.isMute() ? R.drawable.mute_on : R.drawable.mute_off);
        this.dff.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dfm != null) {
                    MediaController.this.dfm.setMuted(!MediaController.this.dfm.isMute());
                }
            }
        });
        this.dfe = inflate.findViewById(R.id.btn_toggle_screen);
        this.dfe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.4
            private boolean dfq;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.dfq = !this.dfq;
                if (MediaController.this.der != null) {
                    MediaController.this.der.gw(this.dfq);
                }
            }
        });
        this.dfh.setEnabled(false);
        this.dfd.setEnabled(false);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void aFr() {
        int currentPlayerState = this.dfm.getCurrentPlayerState();
        this.dfo = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                aFt();
                this.dfd.setEnabled(true);
                this.dfd.setBackgroundResource(R.drawable.btn_play);
                this.dfh.setEnabled(false);
                mI(this.dfm == null ? 0 : this.dfm.getCurrentPosition());
                mH(this.dfm != null ? this.dfm.getDuration() : 0);
                return;
            case 1:
                this.dfd.setEnabled(false);
                this.dfh.setEnabled(false);
                return;
            case 2:
                this.dfd.setEnabled(true);
                this.dfd.setBackgroundResource(R.drawable.btn_play);
                this.dfh.setEnabled(true);
                mH(this.dfm != null ? this.dfm.getDuration() : 0);
                this.dfh.setMax(this.dfm.getDuration());
                return;
            case 3:
                aFs();
                this.dfh.setEnabled(true);
                this.dfd.setEnabled(true);
                this.dfd.setBackgroundResource(R.drawable.btn_pause);
                return;
            case 4:
                this.dfd.setEnabled(true);
                this.dfd.setBackgroundResource(R.drawable.btn_play);
                return;
            case 5:
                aFt();
                this.dfh.setProgress(this.dfh.getMax());
                this.dfh.setEnabled(false);
                this.dfd.setEnabled(true);
                this.dfd.setBackgroundResource(R.drawable.btn_play);
                return;
            default:
                return;
        }
    }

    private void aFs() {
        if (this.dfk != null) {
            this.dfk.cancel();
            this.dfk = null;
        }
        this.dfk = new Timer();
        this.dfk.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaController.this.aFv();
                    }
                });
            }
        }, 0L, 500L);
    }

    private void aFt() {
        if (this.dfk != null) {
            this.dfk.cancel();
            this.dfk = null;
        }
    }

    public void o(SwanVideoView swanVideoView) {
        this.dfm = swanVideoView;
    }

    public void setToggleScreenListener(a aVar) {
        this.der = aVar;
    }

    private void show() {
        if (this.dfm != null) {
            setProgress((int) this.dfj);
            setVisibility(0);
        }
    }

    public void aFu() {
        show();
        if (this.dfl != null) {
            this.dfl.cancel();
            this.dfl = null;
        }
        this.dfl = new Timer();
        this.dfl.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.6
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaController.this.hide();
                    }
                });
            }
        }, 3000L);
    }

    public void hide() {
        setVisibility(8);
    }

    private void mH(int i) {
        if (this.dfi != null) {
            this.dfi.setText(mJ(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mI(int i) {
        if (this.dfg != null) {
            this.dfg.setText(mJ(i));
        }
    }

    public static String mJ(int i) {
        if (i < 0) {
            return "";
        }
        int i2 = i / 1000;
        int i3 = i2 / 3600;
        int i4 = (i2 % 3600) / 60;
        int i5 = i2 % 60;
        return i3 != 0 ? String.format(Locale.US, "%02d:%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.US, "%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private void setMax(int i) {
        if (!this.dfo) {
            if (this.dfh != null) {
                this.dfh.setMax(i);
            }
            mH(i);
            if (i > 0) {
                this.dfo = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.dfh != null) {
            this.dfh.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.dff != null) {
            this.dff.setBackgroundResource(z ? R.drawable.mute_on : R.drawable.mute_off);
        }
    }

    public void aFv() {
        int duration;
        if (this.dfm != null && !this.dfn) {
            long currentPosition = this.dfm.getCurrentPosition();
            if (currentPosition > 0) {
                this.dfj = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.dfm.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }
}
