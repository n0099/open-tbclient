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
    private ImageButton dgP;
    private View dgQ;
    private View dgR;
    private TextView dgS;
    private SeekBar dgT;
    private TextView dgU;
    private long dgV;
    private Timer dgW;
    private Timer dgX;
    private SwanVideoView dgY;
    boolean dgZ;
    private a dge;
    private boolean dha;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.dha = false;
        aGR();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dha = false;
        aGR();
    }

    private void aGR() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.media_controller, this);
        this.dgP = (ImageButton) inflate.findViewById(R.id.btn_play);
        this.dgP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dgY != null) {
                    if (MediaController.this.dgY.isPlaying()) {
                        MediaController.this.dgP.setBackgroundResource(R.drawable.btn_play);
                        MediaController.this.dgY.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.dgP.setBackgroundResource(R.drawable.btn_pause);
                    MediaController.this.dgY.start();
                }
            }
        });
        this.dgS = (TextView) inflate.findViewById(R.id.tv_position);
        this.dgT = (SeekBar) inflate.findViewById(R.id.seekbar);
        this.dgU = (TextView) inflate.findViewById(R.id.tv_duration);
        this.dgT.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.mQ(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.dgZ = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.dgY.getDuration() > 0) {
                    MediaController.this.dgV = seekBar.getProgress();
                    if (MediaController.this.dgY != null) {
                        MediaController.this.dgY.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.dgZ = false;
            }
        });
        this.dgR = inflate.findViewById(R.id.btn_mute);
        this.dgR.setBackgroundResource(this.dgY != null && this.dgY.isMute() ? R.drawable.mute_on : R.drawable.mute_off);
        this.dgR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dgY != null) {
                    MediaController.this.dgY.setMuted(!MediaController.this.dgY.isMute());
                }
            }
        });
        this.dgQ = inflate.findViewById(R.id.btn_toggle_screen);
        this.dgQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.4
            private boolean dhc;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.dhc = !this.dhc;
                if (MediaController.this.dge != null) {
                    MediaController.this.dge.gA(this.dhc);
                }
            }
        });
        this.dgT.setEnabled(false);
        this.dgP.setEnabled(false);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void aGS() {
        int currentPlayerState = this.dgY.getCurrentPlayerState();
        this.dha = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                aGU();
                this.dgP.setEnabled(true);
                this.dgP.setBackgroundResource(R.drawable.btn_play);
                this.dgT.setEnabled(false);
                mQ(this.dgY == null ? 0 : this.dgY.getCurrentPosition());
                mP(this.dgY != null ? this.dgY.getDuration() : 0);
                return;
            case 1:
                this.dgP.setEnabled(false);
                this.dgT.setEnabled(false);
                return;
            case 2:
                this.dgP.setEnabled(true);
                this.dgP.setBackgroundResource(R.drawable.btn_play);
                this.dgT.setEnabled(true);
                mP(this.dgY != null ? this.dgY.getDuration() : 0);
                this.dgT.setMax(this.dgY.getDuration());
                return;
            case 3:
                aGT();
                this.dgT.setEnabled(true);
                this.dgP.setEnabled(true);
                this.dgP.setBackgroundResource(R.drawable.btn_pause);
                return;
            case 4:
                this.dgP.setEnabled(true);
                this.dgP.setBackgroundResource(R.drawable.btn_play);
                return;
            case 5:
                aGU();
                this.dgT.setProgress(this.dgT.getMax());
                this.dgT.setEnabled(false);
                this.dgP.setEnabled(true);
                this.dgP.setBackgroundResource(R.drawable.btn_play);
                return;
            default:
                return;
        }
    }

    private void aGT() {
        if (this.dgW != null) {
            this.dgW.cancel();
            this.dgW = null;
        }
        this.dgW = new Timer();
        this.dgW.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaController.this.aGW();
                    }
                });
            }
        }, 0L, 500L);
    }

    private void aGU() {
        if (this.dgW != null) {
            this.dgW.cancel();
            this.dgW = null;
        }
    }

    public void o(SwanVideoView swanVideoView) {
        this.dgY = swanVideoView;
    }

    public void setToggleScreenListener(a aVar) {
        this.dge = aVar;
    }

    private void show() {
        if (this.dgY != null) {
            setProgress((int) this.dgV);
            setVisibility(0);
        }
    }

    public void aGV() {
        show();
        if (this.dgX != null) {
            this.dgX.cancel();
            this.dgX = null;
        }
        this.dgX = new Timer();
        this.dgX.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.6
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

    private void mP(int i) {
        if (this.dgU != null) {
            this.dgU.setText(mR(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mQ(int i) {
        if (this.dgS != null) {
            this.dgS.setText(mR(i));
        }
    }

    public static String mR(int i) {
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
        if (!this.dha) {
            if (this.dgT != null) {
                this.dgT.setMax(i);
            }
            mP(i);
            if (i > 0) {
                this.dha = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.dgT != null) {
            this.dgT.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.dgR != null) {
            this.dgR.setBackgroundResource(z ? R.drawable.mute_on : R.drawable.mute_off);
        }
    }

    public void aGW() {
        int duration;
        if (this.dgY != null && !this.dgZ) {
            long currentPosition = this.dgY.getCurrentPosition();
            if (currentPosition > 0) {
                this.dgV = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.dgY.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }
}
