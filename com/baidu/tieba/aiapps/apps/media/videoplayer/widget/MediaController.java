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
    private a dfX;
    private ImageButton dgI;
    private View dgJ;
    private View dgK;
    private TextView dgL;
    private SeekBar dgM;
    private TextView dgN;
    private long dgO;
    private Timer dgP;
    private Timer dgQ;
    private SwanVideoView dgR;
    boolean dgS;
    private boolean dgT;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.dgT = false;
        aGP();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dgT = false;
        aGP();
    }

    private void aGP() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.media_controller, this);
        this.dgI = (ImageButton) inflate.findViewById(R.id.btn_play);
        this.dgI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dgR != null) {
                    if (MediaController.this.dgR.isPlaying()) {
                        MediaController.this.dgI.setBackgroundResource(R.drawable.btn_play);
                        MediaController.this.dgR.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.dgI.setBackgroundResource(R.drawable.btn_pause);
                    MediaController.this.dgR.start();
                }
            }
        });
        this.dgL = (TextView) inflate.findViewById(R.id.tv_position);
        this.dgM = (SeekBar) inflate.findViewById(R.id.seekbar);
        this.dgN = (TextView) inflate.findViewById(R.id.tv_duration);
        this.dgM.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.mP(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.dgS = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.dgR.getDuration() > 0) {
                    MediaController.this.dgO = seekBar.getProgress();
                    if (MediaController.this.dgR != null) {
                        MediaController.this.dgR.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.dgS = false;
            }
        });
        this.dgK = inflate.findViewById(R.id.btn_mute);
        this.dgK.setBackgroundResource(this.dgR != null && this.dgR.isMute() ? R.drawable.mute_on : R.drawable.mute_off);
        this.dgK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dgR != null) {
                    MediaController.this.dgR.setMuted(!MediaController.this.dgR.isMute());
                }
            }
        });
        this.dgJ = inflate.findViewById(R.id.btn_toggle_screen);
        this.dgJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.4
            private boolean dgV;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.dgV = !this.dgV;
                if (MediaController.this.dfX != null) {
                    MediaController.this.dfX.gA(this.dgV);
                }
            }
        });
        this.dgM.setEnabled(false);
        this.dgI.setEnabled(false);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void aGQ() {
        int currentPlayerState = this.dgR.getCurrentPlayerState();
        this.dgT = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                aGS();
                this.dgI.setEnabled(true);
                this.dgI.setBackgroundResource(R.drawable.btn_play);
                this.dgM.setEnabled(false);
                mP(this.dgR == null ? 0 : this.dgR.getCurrentPosition());
                mO(this.dgR != null ? this.dgR.getDuration() : 0);
                return;
            case 1:
                this.dgI.setEnabled(false);
                this.dgM.setEnabled(false);
                return;
            case 2:
                this.dgI.setEnabled(true);
                this.dgI.setBackgroundResource(R.drawable.btn_play);
                this.dgM.setEnabled(true);
                mO(this.dgR != null ? this.dgR.getDuration() : 0);
                this.dgM.setMax(this.dgR.getDuration());
                return;
            case 3:
                aGR();
                this.dgM.setEnabled(true);
                this.dgI.setEnabled(true);
                this.dgI.setBackgroundResource(R.drawable.btn_pause);
                return;
            case 4:
                this.dgI.setEnabled(true);
                this.dgI.setBackgroundResource(R.drawable.btn_play);
                return;
            case 5:
                aGS();
                this.dgM.setProgress(this.dgM.getMax());
                this.dgM.setEnabled(false);
                this.dgI.setEnabled(true);
                this.dgI.setBackgroundResource(R.drawable.btn_play);
                return;
            default:
                return;
        }
    }

    private void aGR() {
        if (this.dgP != null) {
            this.dgP.cancel();
            this.dgP = null;
        }
        this.dgP = new Timer();
        this.dgP.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaController.this.aGU();
                    }
                });
            }
        }, 0L, 500L);
    }

    private void aGS() {
        if (this.dgP != null) {
            this.dgP.cancel();
            this.dgP = null;
        }
    }

    public void o(SwanVideoView swanVideoView) {
        this.dgR = swanVideoView;
    }

    public void setToggleScreenListener(a aVar) {
        this.dfX = aVar;
    }

    private void show() {
        if (this.dgR != null) {
            setProgress((int) this.dgO);
            setVisibility(0);
        }
    }

    public void aGT() {
        show();
        if (this.dgQ != null) {
            this.dgQ.cancel();
            this.dgQ = null;
        }
        this.dgQ = new Timer();
        this.dgQ.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.6
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

    private void mO(int i) {
        if (this.dgN != null) {
            this.dgN.setText(mQ(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mP(int i) {
        if (this.dgL != null) {
            this.dgL.setText(mQ(i));
        }
    }

    public static String mQ(int i) {
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
        if (!this.dgT) {
            if (this.dgM != null) {
                this.dgM.setMax(i);
            }
            mO(i);
            if (i > 0) {
                this.dgT = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.dgM != null) {
            this.dgM.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.dgK != null) {
            this.dgK.setBackgroundResource(z ? R.drawable.mute_on : R.drawable.mute_off);
        }
    }

    public void aGU() {
        int duration;
        if (this.dgR != null && !this.dgS) {
            long currentPosition = this.dgR.getCurrentPosition();
            if (currentPosition > 0) {
                this.dgO = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.dgR.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }
}
