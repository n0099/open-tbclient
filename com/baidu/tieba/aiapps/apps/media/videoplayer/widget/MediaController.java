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
    private ImageButton drV;
    private View drW;
    private View drX;
    private TextView drY;
    private SeekBar drZ;
    private a drk;
    private TextView dsa;
    private long dsb;
    private Timer dsc;
    private Timer dsd;
    private SwanVideoView dse;
    boolean dsf;
    private boolean dsg;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.dsg = false;
        aHI();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dsg = false;
        aHI();
    }

    private void aHI() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.media_controller, this);
        this.drV = (ImageButton) inflate.findViewById(R.id.btn_play);
        this.drV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dse != null) {
                    if (MediaController.this.dse.isPlaying()) {
                        MediaController.this.drV.setBackgroundResource(R.drawable.btn_play);
                        MediaController.this.dse.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.drV.setBackgroundResource(R.drawable.btn_pause);
                    MediaController.this.dse.start();
                }
            }
        });
        this.drY = (TextView) inflate.findViewById(R.id.tv_position);
        this.drZ = (SeekBar) inflate.findViewById(R.id.seekbar);
        this.dsa = (TextView) inflate.findViewById(R.id.tv_duration);
        this.drZ.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.lW(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.dsf = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.dse.getDuration() > 0) {
                    MediaController.this.dsb = seekBar.getProgress();
                    if (MediaController.this.dse != null) {
                        MediaController.this.dse.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.dsf = false;
            }
        });
        this.drX = inflate.findViewById(R.id.btn_mute);
        this.drX.setBackgroundResource(this.dse != null && this.dse.isMute() ? R.drawable.mute_on : R.drawable.mute_off);
        this.drX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dse != null) {
                    MediaController.this.dse.setMuted(!MediaController.this.dse.isMute());
                }
            }
        });
        this.drW = inflate.findViewById(R.id.btn_toggle_screen);
        this.drW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.4
            private boolean dsi;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.dsi = !this.dsi;
                if (MediaController.this.drk != null) {
                    MediaController.this.drk.gs(this.dsi);
                }
            }
        });
        this.drZ.setEnabled(false);
        this.drV.setEnabled(false);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void aHJ() {
        int currentPlayerState = this.dse.getCurrentPlayerState();
        this.dsg = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                aHL();
                this.drV.setEnabled(true);
                this.drV.setBackgroundResource(R.drawable.btn_play);
                this.drZ.setEnabled(false);
                lW(this.dse == null ? 0 : this.dse.getCurrentPosition());
                lV(this.dse != null ? this.dse.getDuration() : 0);
                return;
            case 1:
                this.drV.setEnabled(false);
                this.drZ.setEnabled(false);
                return;
            case 2:
                this.drV.setEnabled(true);
                this.drV.setBackgroundResource(R.drawable.btn_play);
                this.drZ.setEnabled(true);
                lV(this.dse != null ? this.dse.getDuration() : 0);
                this.drZ.setMax(this.dse.getDuration());
                return;
            case 3:
                aHK();
                this.drZ.setEnabled(true);
                this.drV.setEnabled(true);
                this.drV.setBackgroundResource(R.drawable.btn_pause);
                return;
            case 4:
                this.drV.setEnabled(true);
                this.drV.setBackgroundResource(R.drawable.btn_play);
                return;
            case 5:
                aHL();
                this.drZ.setProgress(this.drZ.getMax());
                this.drZ.setEnabled(false);
                this.drV.setEnabled(true);
                this.drV.setBackgroundResource(R.drawable.btn_play);
                return;
            default:
                return;
        }
    }

    private void aHK() {
        if (this.dsc != null) {
            this.dsc.cancel();
            this.dsc = null;
        }
        this.dsc = new Timer();
        this.dsc.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaController.this.aHN();
                    }
                });
            }
        }, 0L, 500L);
    }

    private void aHL() {
        if (this.dsc != null) {
            this.dsc.cancel();
            this.dsc = null;
        }
    }

    public void o(SwanVideoView swanVideoView) {
        this.dse = swanVideoView;
    }

    public void setToggleScreenListener(a aVar) {
        this.drk = aVar;
    }

    private void show() {
        if (this.dse != null) {
            setProgress((int) this.dsb);
            setVisibility(0);
        }
    }

    public void aHM() {
        show();
        if (this.dsd != null) {
            this.dsd.cancel();
            this.dsd = null;
        }
        this.dsd = new Timer();
        this.dsd.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.6
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

    private void lV(int i) {
        if (this.dsa != null) {
            this.dsa.setText(lX(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lW(int i) {
        if (this.drY != null) {
            this.drY.setText(lX(i));
        }
    }

    public static String lX(int i) {
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
        if (!this.dsg) {
            if (this.drZ != null) {
                this.drZ.setMax(i);
            }
            lV(i);
            if (i > 0) {
                this.dsg = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.drZ != null) {
            this.drZ.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.drX != null) {
            this.drX.setBackgroundResource(z ? R.drawable.mute_on : R.drawable.mute_off);
        }
    }

    public void aHN() {
        int duration;
        if (this.dse != null && !this.dsf) {
            long currentPosition = this.dse.getCurrentPosition();
            if (currentPosition > 0) {
                this.dsb = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.dse.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }
}
