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
    private a eeY;
    private SwanVideoView efA;
    boolean efB;
    private boolean efC;
    private ImageButton efr;
    private View efs;
    private View eft;
    private TextView efu;
    private SeekBar efv;
    private TextView efw;
    private long efx;
    private Timer efy;
    private Timer efz;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.efC = false;
        baB();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.efC = false;
        baB();
    }

    private void baB() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.media_controller, this);
        this.efr = (ImageButton) inflate.findViewById(R.id.btn_play);
        this.efr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.efA != null) {
                    if (MediaController.this.efA.isPlaying()) {
                        MediaController.this.efr.setBackgroundResource(R.drawable.btn_play);
                        MediaController.this.efA.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.efr.setBackgroundResource(R.drawable.btn_pause);
                    MediaController.this.efA.start();
                }
            }
        });
        this.efu = (TextView) inflate.findViewById(R.id.tv_position);
        this.efv = (SeekBar) inflate.findViewById(R.id.seekbar);
        this.efw = (TextView) inflate.findViewById(R.id.tv_duration);
        this.efv.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.ov(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.efB = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.efA.getDuration() > 0) {
                    MediaController.this.efx = seekBar.getProgress();
                    if (MediaController.this.efA != null) {
                        MediaController.this.efA.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.efB = false;
            }
        });
        this.eft = inflate.findViewById(R.id.btn_mute);
        this.eft.setBackgroundResource(this.efA != null && this.efA.isMute() ? R.drawable.mute_on : R.drawable.mute_off);
        this.eft.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.efA != null) {
                    MediaController.this.efA.setMuted(!MediaController.this.efA.isMute());
                }
            }
        });
        this.efs = inflate.findViewById(R.id.btn_toggle_screen);
        this.efs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.4
            private boolean efE;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.efE = !this.efE;
                if (MediaController.this.eeY != null) {
                    MediaController.this.eeY.hH(this.efE);
                }
            }
        });
        this.efv.setEnabled(false);
        this.efr.setEnabled(false);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void baC() {
        int currentPlayerState = this.efA.getCurrentPlayerState();
        this.efC = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                baE();
                this.efr.setEnabled(true);
                this.efr.setBackgroundResource(R.drawable.btn_play);
                this.efv.setEnabled(false);
                ov(this.efA == null ? 0 : this.efA.getCurrentPosition());
                ou(this.efA != null ? this.efA.getDuration() : 0);
                return;
            case 1:
                this.efr.setEnabled(false);
                this.efv.setEnabled(false);
                return;
            case 2:
                this.efr.setEnabled(true);
                this.efr.setBackgroundResource(R.drawable.btn_play);
                this.efv.setEnabled(true);
                ou(this.efA == null ? 0 : this.efA.getDuration());
                this.efv.setMax(this.efA != null ? this.efA.getDuration() : 0);
                return;
            case 3:
                baD();
                this.efv.setEnabled(true);
                this.efr.setEnabled(true);
                this.efr.setBackgroundResource(R.drawable.btn_pause);
                return;
            case 4:
                this.efr.setEnabled(true);
                this.efr.setBackgroundResource(R.drawable.btn_play);
                return;
            case 5:
                baE();
                this.efv.setProgress(this.efv.getMax());
                this.efv.setEnabled(false);
                this.efr.setEnabled(true);
                this.efr.setBackgroundResource(R.drawable.btn_play);
                return;
            default:
                return;
        }
    }

    private void baD() {
        if (this.efy != null) {
            this.efy.cancel();
            this.efy = null;
        }
        this.efy = new Timer();
        this.efy.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaController.this.baG();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void baE() {
        if (this.efy != null) {
            this.efy.cancel();
            this.efy = null;
        }
    }

    public void o(SwanVideoView swanVideoView) {
        this.efA = swanVideoView;
    }

    public void setToggleScreenListener(a aVar) {
        this.eeY = aVar;
    }

    private void show() {
        if (this.efA != null) {
            setProgress((int) this.efx);
            setVisibility(0);
        }
    }

    public void baF() {
        show();
        if (this.efz != null) {
            this.efz.cancel();
            this.efz = null;
        }
        this.efz = new Timer();
        this.efz.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.6
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
        if (this.efw != null) {
            this.efw.setText(ow(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ov(int i) {
        if (this.efu != null) {
            this.efu.setText(ow(i));
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
        if (!this.efC) {
            if (this.efv != null) {
                this.efv.setMax(i);
            }
            ou(i);
            if (i > 0) {
                this.efC = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.efv != null) {
            this.efv.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.eft != null) {
            this.eft.setBackgroundResource(z ? R.drawable.mute_on : R.drawable.mute_off);
        }
    }

    public void baG() {
        int duration;
        if (this.efA != null && !this.efB) {
            long currentPosition = this.efA.getCurrentPosition();
            if (currentPosition > 0) {
                this.efx = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.efA.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }
}
