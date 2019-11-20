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
    private a dqt;
    private ImageButton dre;
    private View drf;
    private View drg;
    private TextView drh;
    private SeekBar dri;
    private TextView drj;
    private long drk;
    private Timer drl;
    private Timer drm;
    private SwanVideoView drn;
    boolean dro;
    private boolean drp;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.drp = false;
        aHG();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drp = false;
        aHG();
    }

    private void aHG() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.media_controller, this);
        this.dre = (ImageButton) inflate.findViewById(R.id.btn_play);
        this.dre.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.drn != null) {
                    if (MediaController.this.drn.isPlaying()) {
                        MediaController.this.dre.setBackgroundResource(R.drawable.btn_play);
                        MediaController.this.drn.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.dre.setBackgroundResource(R.drawable.btn_pause);
                    MediaController.this.drn.start();
                }
            }
        });
        this.drh = (TextView) inflate.findViewById(R.id.tv_position);
        this.dri = (SeekBar) inflate.findViewById(R.id.seekbar);
        this.drj = (TextView) inflate.findViewById(R.id.tv_duration);
        this.dri.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.lV(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.dro = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.drn.getDuration() > 0) {
                    MediaController.this.drk = seekBar.getProgress();
                    if (MediaController.this.drn != null) {
                        MediaController.this.drn.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.dro = false;
            }
        });
        this.drg = inflate.findViewById(R.id.btn_mute);
        this.drg.setBackgroundResource(this.drn != null && this.drn.isMute() ? R.drawable.mute_on : R.drawable.mute_off);
        this.drg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.drn != null) {
                    MediaController.this.drn.setMuted(!MediaController.this.drn.isMute());
                }
            }
        });
        this.drf = inflate.findViewById(R.id.btn_toggle_screen);
        this.drf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.4
            private boolean drr;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.drr = !this.drr;
                if (MediaController.this.dqt != null) {
                    MediaController.this.dqt.gs(this.drr);
                }
            }
        });
        this.dri.setEnabled(false);
        this.dre.setEnabled(false);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void aHH() {
        int currentPlayerState = this.drn.getCurrentPlayerState();
        this.drp = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                aHJ();
                this.dre.setEnabled(true);
                this.dre.setBackgroundResource(R.drawable.btn_play);
                this.dri.setEnabled(false);
                lV(this.drn == null ? 0 : this.drn.getCurrentPosition());
                lU(this.drn != null ? this.drn.getDuration() : 0);
                return;
            case 1:
                this.dre.setEnabled(false);
                this.dri.setEnabled(false);
                return;
            case 2:
                this.dre.setEnabled(true);
                this.dre.setBackgroundResource(R.drawable.btn_play);
                this.dri.setEnabled(true);
                lU(this.drn != null ? this.drn.getDuration() : 0);
                this.dri.setMax(this.drn.getDuration());
                return;
            case 3:
                aHI();
                this.dri.setEnabled(true);
                this.dre.setEnabled(true);
                this.dre.setBackgroundResource(R.drawable.btn_pause);
                return;
            case 4:
                this.dre.setEnabled(true);
                this.dre.setBackgroundResource(R.drawable.btn_play);
                return;
            case 5:
                aHJ();
                this.dri.setProgress(this.dri.getMax());
                this.dri.setEnabled(false);
                this.dre.setEnabled(true);
                this.dre.setBackgroundResource(R.drawable.btn_play);
                return;
            default:
                return;
        }
    }

    private void aHI() {
        if (this.drl != null) {
            this.drl.cancel();
            this.drl = null;
        }
        this.drl = new Timer();
        this.drl.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaController.this.aHL();
                    }
                });
            }
        }, 0L, 500L);
    }

    private void aHJ() {
        if (this.drl != null) {
            this.drl.cancel();
            this.drl = null;
        }
    }

    public void o(SwanVideoView swanVideoView) {
        this.drn = swanVideoView;
    }

    public void setToggleScreenListener(a aVar) {
        this.dqt = aVar;
    }

    private void show() {
        if (this.drn != null) {
            setProgress((int) this.drk);
            setVisibility(0);
        }
    }

    public void aHK() {
        show();
        if (this.drm != null) {
            this.drm.cancel();
            this.drm = null;
        }
        this.drm = new Timer();
        this.drm.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.6
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

    private void lU(int i) {
        if (this.drj != null) {
            this.drj.setText(lW(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lV(int i) {
        if (this.drh != null) {
            this.drh.setText(lW(i));
        }
    }

    public static String lW(int i) {
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
        if (!this.drp) {
            if (this.dri != null) {
                this.dri.setMax(i);
            }
            lU(i);
            if (i > 0) {
                this.drp = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.dri != null) {
            this.dri.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.drg != null) {
            this.drg.setBackgroundResource(z ? R.drawable.mute_on : R.drawable.mute_off);
        }
    }

    public void aHL() {
        int duration;
        if (this.drn != null && !this.dro) {
            long currentPosition = this.drn.getCurrentPosition();
            if (currentPosition > 0) {
                this.drk = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.drn.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }
}
