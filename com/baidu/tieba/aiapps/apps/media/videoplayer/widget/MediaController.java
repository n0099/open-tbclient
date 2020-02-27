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
/* loaded from: classes12.dex */
public class MediaController extends RelativeLayout {
    private a eeX;
    boolean efA;
    private boolean efB;
    private ImageButton efq;
    private View efr;
    private View efs;
    private TextView eft;
    private SeekBar efu;
    private TextView efv;
    private long efw;
    private Timer efx;
    private Timer efy;
    private SwanVideoView efz;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.efB = false;
        baz();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.efB = false;
        baz();
    }

    private void baz() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.media_controller, this);
        this.efq = (ImageButton) inflate.findViewById(R.id.btn_play);
        this.efq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.efz != null) {
                    if (MediaController.this.efz.isPlaying()) {
                        MediaController.this.efq.setBackgroundResource(R.drawable.btn_play);
                        MediaController.this.efz.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.efq.setBackgroundResource(R.drawable.btn_pause);
                    MediaController.this.efz.start();
                }
            }
        });
        this.eft = (TextView) inflate.findViewById(R.id.tv_position);
        this.efu = (SeekBar) inflate.findViewById(R.id.seekbar);
        this.efv = (TextView) inflate.findViewById(R.id.tv_duration);
        this.efu.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.ov(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.efA = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.efz.getDuration() > 0) {
                    MediaController.this.efw = seekBar.getProgress();
                    if (MediaController.this.efz != null) {
                        MediaController.this.efz.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.efA = false;
            }
        });
        this.efs = inflate.findViewById(R.id.btn_mute);
        this.efs.setBackgroundResource(this.efz != null && this.efz.isMute() ? R.drawable.mute_on : R.drawable.mute_off);
        this.efs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.efz != null) {
                    MediaController.this.efz.setMuted(!MediaController.this.efz.isMute());
                }
            }
        });
        this.efr = inflate.findViewById(R.id.btn_toggle_screen);
        this.efr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.4
            private boolean efD;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.efD = !this.efD;
                if (MediaController.this.eeX != null) {
                    MediaController.this.eeX.hH(this.efD);
                }
            }
        });
        this.efu.setEnabled(false);
        this.efq.setEnabled(false);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void baA() {
        int currentPlayerState = this.efz.getCurrentPlayerState();
        this.efB = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                baC();
                this.efq.setEnabled(true);
                this.efq.setBackgroundResource(R.drawable.btn_play);
                this.efu.setEnabled(false);
                ov(this.efz == null ? 0 : this.efz.getCurrentPosition());
                ou(this.efz != null ? this.efz.getDuration() : 0);
                return;
            case 1:
                this.efq.setEnabled(false);
                this.efu.setEnabled(false);
                return;
            case 2:
                this.efq.setEnabled(true);
                this.efq.setBackgroundResource(R.drawable.btn_play);
                this.efu.setEnabled(true);
                ou(this.efz == null ? 0 : this.efz.getDuration());
                this.efu.setMax(this.efz != null ? this.efz.getDuration() : 0);
                return;
            case 3:
                baB();
                this.efu.setEnabled(true);
                this.efq.setEnabled(true);
                this.efq.setBackgroundResource(R.drawable.btn_pause);
                return;
            case 4:
                this.efq.setEnabled(true);
                this.efq.setBackgroundResource(R.drawable.btn_play);
                return;
            case 5:
                baC();
                this.efu.setProgress(this.efu.getMax());
                this.efu.setEnabled(false);
                this.efq.setEnabled(true);
                this.efq.setBackgroundResource(R.drawable.btn_play);
                return;
            default:
                return;
        }
    }

    private void baB() {
        if (this.efx != null) {
            this.efx.cancel();
            this.efx = null;
        }
        this.efx = new Timer();
        this.efx.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaController.this.baE();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void baC() {
        if (this.efx != null) {
            this.efx.cancel();
            this.efx = null;
        }
    }

    public void o(SwanVideoView swanVideoView) {
        this.efz = swanVideoView;
    }

    public void setToggleScreenListener(a aVar) {
        this.eeX = aVar;
    }

    private void show() {
        if (this.efz != null) {
            setProgress((int) this.efw);
            setVisibility(0);
        }
    }

    public void baD() {
        show();
        if (this.efy != null) {
            this.efy.cancel();
            this.efy = null;
        }
        this.efy = new Timer();
        this.efy.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.6
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

    private void ou(int i) {
        if (this.efv != null) {
            this.efv.setText(ow(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ov(int i) {
        if (this.eft != null) {
            this.eft.setText(ow(i));
        }
    }

    public static String ow(int i) {
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
        if (!this.efB) {
            if (this.efu != null) {
                this.efu.setMax(i);
            }
            ou(i);
            if (i > 0) {
                this.efB = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.efu != null) {
            this.efu.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.efs != null) {
            this.efs.setBackgroundResource(z ? R.drawable.mute_on : R.drawable.mute_off);
        }
    }

    public void baE() {
        int duration;
        if (this.efz != null && !this.efA) {
            long currentPosition = this.efz.getCurrentPosition();
            if (currentPosition > 0) {
                this.efw = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.efz.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }
}
