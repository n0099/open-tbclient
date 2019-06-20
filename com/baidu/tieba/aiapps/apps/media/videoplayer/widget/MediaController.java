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
    private a deu;
    private ImageButton dff;
    private View dfg;
    private View dfh;
    private TextView dfi;
    private SeekBar dfj;
    private TextView dfk;
    private long dfl;
    private Timer dfm;
    private Timer dfn;
    private SwanVideoView dfo;
    boolean dfp;
    private boolean dfq;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.dfq = false;
        aFt();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dfq = false;
        aFt();
    }

    private void aFt() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.media_controller, this);
        this.dff = (ImageButton) inflate.findViewById(R.id.btn_play);
        this.dff.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dfo != null) {
                    if (MediaController.this.dfo.isPlaying()) {
                        MediaController.this.dff.setBackgroundResource(R.drawable.btn_play);
                        MediaController.this.dfo.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.dff.setBackgroundResource(R.drawable.btn_pause);
                    MediaController.this.dfo.start();
                }
            }
        });
        this.dfi = (TextView) inflate.findViewById(R.id.tv_position);
        this.dfj = (SeekBar) inflate.findViewById(R.id.seekbar);
        this.dfk = (TextView) inflate.findViewById(R.id.tv_duration);
        this.dfj.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.mI(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.dfp = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.dfo.getDuration() > 0) {
                    MediaController.this.dfl = seekBar.getProgress();
                    if (MediaController.this.dfo != null) {
                        MediaController.this.dfo.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.dfp = false;
            }
        });
        this.dfh = inflate.findViewById(R.id.btn_mute);
        this.dfh.setBackgroundResource(this.dfo != null && this.dfo.isMute() ? R.drawable.mute_on : R.drawable.mute_off);
        this.dfh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dfo != null) {
                    MediaController.this.dfo.setMuted(!MediaController.this.dfo.isMute());
                }
            }
        });
        this.dfg = inflate.findViewById(R.id.btn_toggle_screen);
        this.dfg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.4
            private boolean dfs;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.dfs = !this.dfs;
                if (MediaController.this.deu != null) {
                    MediaController.this.deu.gw(this.dfs);
                }
            }
        });
        this.dfj.setEnabled(false);
        this.dff.setEnabled(false);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void aFu() {
        int currentPlayerState = this.dfo.getCurrentPlayerState();
        this.dfq = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                aFw();
                this.dff.setEnabled(true);
                this.dff.setBackgroundResource(R.drawable.btn_play);
                this.dfj.setEnabled(false);
                mI(this.dfo == null ? 0 : this.dfo.getCurrentPosition());
                mH(this.dfo != null ? this.dfo.getDuration() : 0);
                return;
            case 1:
                this.dff.setEnabled(false);
                this.dfj.setEnabled(false);
                return;
            case 2:
                this.dff.setEnabled(true);
                this.dff.setBackgroundResource(R.drawable.btn_play);
                this.dfj.setEnabled(true);
                mH(this.dfo != null ? this.dfo.getDuration() : 0);
                this.dfj.setMax(this.dfo.getDuration());
                return;
            case 3:
                aFv();
                this.dfj.setEnabled(true);
                this.dff.setEnabled(true);
                this.dff.setBackgroundResource(R.drawable.btn_pause);
                return;
            case 4:
                this.dff.setEnabled(true);
                this.dff.setBackgroundResource(R.drawable.btn_play);
                return;
            case 5:
                aFw();
                this.dfj.setProgress(this.dfj.getMax());
                this.dfj.setEnabled(false);
                this.dff.setEnabled(true);
                this.dff.setBackgroundResource(R.drawable.btn_play);
                return;
            default:
                return;
        }
    }

    private void aFv() {
        if (this.dfm != null) {
            this.dfm.cancel();
            this.dfm = null;
        }
        this.dfm = new Timer();
        this.dfm.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaController.this.aFy();
                    }
                });
            }
        }, 0L, 500L);
    }

    private void aFw() {
        if (this.dfm != null) {
            this.dfm.cancel();
            this.dfm = null;
        }
    }

    public void o(SwanVideoView swanVideoView) {
        this.dfo = swanVideoView;
    }

    public void setToggleScreenListener(a aVar) {
        this.deu = aVar;
    }

    private void show() {
        if (this.dfo != null) {
            setProgress((int) this.dfl);
            setVisibility(0);
        }
    }

    public void aFx() {
        show();
        if (this.dfn != null) {
            this.dfn.cancel();
            this.dfn = null;
        }
        this.dfn = new Timer();
        this.dfn.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.6
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
        if (this.dfk != null) {
            this.dfk.setText(mJ(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mI(int i) {
        if (this.dfi != null) {
            this.dfi.setText(mJ(i));
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
        if (!this.dfq) {
            if (this.dfj != null) {
                this.dfj.setMax(i);
            }
            mH(i);
            if (i > 0) {
                this.dfq = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.dfj != null) {
            this.dfj.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.dfh != null) {
            this.dfh.setBackgroundResource(z ? R.drawable.mute_on : R.drawable.mute_off);
        }
    }

    public void aFy() {
        int duration;
        if (this.dfo != null && !this.dfp) {
            long currentPosition = this.dfo.getCurrentPosition();
            if (currentPosition > 0) {
                this.dfl = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.dfo.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }
}
