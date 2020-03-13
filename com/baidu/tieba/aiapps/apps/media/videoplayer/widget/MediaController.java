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
    private ImageButton efE;
    private View efF;
    private View efG;
    private TextView efH;
    private SeekBar efI;
    private TextView efJ;
    private long efK;
    private Timer efL;
    private Timer efM;
    private SwanVideoView efN;
    boolean efO;
    private boolean efP;
    private a efl;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.efP = false;
        baC();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.efP = false;
        baC();
    }

    private void baC() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.media_controller, this);
        this.efE = (ImageButton) inflate.findViewById(R.id.btn_play);
        this.efE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.efN != null) {
                    if (MediaController.this.efN.isPlaying()) {
                        MediaController.this.efE.setBackgroundResource(R.drawable.btn_play);
                        MediaController.this.efN.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.efE.setBackgroundResource(R.drawable.btn_pause);
                    MediaController.this.efN.start();
                }
            }
        });
        this.efH = (TextView) inflate.findViewById(R.id.tv_position);
        this.efI = (SeekBar) inflate.findViewById(R.id.seekbar);
        this.efJ = (TextView) inflate.findViewById(R.id.tv_duration);
        this.efI.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.ov(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.efO = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.efN.getDuration() > 0) {
                    MediaController.this.efK = seekBar.getProgress();
                    if (MediaController.this.efN != null) {
                        MediaController.this.efN.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.efO = false;
            }
        });
        this.efG = inflate.findViewById(R.id.btn_mute);
        this.efG.setBackgroundResource(this.efN != null && this.efN.isMute() ? R.drawable.mute_on : R.drawable.mute_off);
        this.efG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.efN != null) {
                    MediaController.this.efN.setMuted(!MediaController.this.efN.isMute());
                }
            }
        });
        this.efF = inflate.findViewById(R.id.btn_toggle_screen);
        this.efF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.4
            private boolean efR;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.efR = !this.efR;
                if (MediaController.this.efl != null) {
                    MediaController.this.efl.hH(this.efR);
                }
            }
        });
        this.efI.setEnabled(false);
        this.efE.setEnabled(false);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void baD() {
        int currentPlayerState = this.efN.getCurrentPlayerState();
        this.efP = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                baF();
                this.efE.setEnabled(true);
                this.efE.setBackgroundResource(R.drawable.btn_play);
                this.efI.setEnabled(false);
                ov(this.efN == null ? 0 : this.efN.getCurrentPosition());
                ou(this.efN != null ? this.efN.getDuration() : 0);
                return;
            case 1:
                this.efE.setEnabled(false);
                this.efI.setEnabled(false);
                return;
            case 2:
                this.efE.setEnabled(true);
                this.efE.setBackgroundResource(R.drawable.btn_play);
                this.efI.setEnabled(true);
                ou(this.efN == null ? 0 : this.efN.getDuration());
                this.efI.setMax(this.efN != null ? this.efN.getDuration() : 0);
                return;
            case 3:
                baE();
                this.efI.setEnabled(true);
                this.efE.setEnabled(true);
                this.efE.setBackgroundResource(R.drawable.btn_pause);
                return;
            case 4:
                this.efE.setEnabled(true);
                this.efE.setBackgroundResource(R.drawable.btn_play);
                return;
            case 5:
                baF();
                this.efI.setProgress(this.efI.getMax());
                this.efI.setEnabled(false);
                this.efE.setEnabled(true);
                this.efE.setBackgroundResource(R.drawable.btn_play);
                return;
            default:
                return;
        }
    }

    private void baE() {
        if (this.efL != null) {
            this.efL.cancel();
            this.efL = null;
        }
        this.efL = new Timer();
        this.efL.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaController.this.baH();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void baF() {
        if (this.efL != null) {
            this.efL.cancel();
            this.efL = null;
        }
    }

    public void o(SwanVideoView swanVideoView) {
        this.efN = swanVideoView;
    }

    public void setToggleScreenListener(a aVar) {
        this.efl = aVar;
    }

    private void show() {
        if (this.efN != null) {
            setProgress((int) this.efK);
            setVisibility(0);
        }
    }

    public void baG() {
        show();
        if (this.efM != null) {
            this.efM.cancel();
            this.efM = null;
        }
        this.efM = new Timer();
        this.efM.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.6
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
        if (this.efJ != null) {
            this.efJ.setText(ow(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ov(int i) {
        if (this.efH != null) {
            this.efH.setText(ow(i));
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
        if (!this.efP) {
            if (this.efI != null) {
                this.efI.setMax(i);
            }
            ou(i);
            if (i > 0) {
                this.efP = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.efI != null) {
            this.efI.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.efG != null) {
            this.efG.setBackgroundResource(z ? R.drawable.mute_on : R.drawable.mute_off);
        }
    }

    public void baH() {
        int duration;
        if (this.efN != null && !this.efO) {
            long currentPosition = this.efN.getCurrentPosition();
            if (currentPosition > 0) {
                this.efK = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.efN.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }
}
