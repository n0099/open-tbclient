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
    private a dhP;
    private ImageButton diA;
    private View diB;
    private View diC;
    private TextView diD;
    private SeekBar diE;
    private TextView diF;
    private long diG;
    private Timer diH;
    private Timer diI;
    private SwanVideoView diJ;
    boolean diK;
    private boolean diL;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.diL = false;
        aHv();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.diL = false;
        aHv();
    }

    private void aHv() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.media_controller, this);
        this.diA = (ImageButton) inflate.findViewById(R.id.btn_play);
        this.diA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.diJ != null) {
                    if (MediaController.this.diJ.isPlaying()) {
                        MediaController.this.diA.setBackgroundResource(R.drawable.btn_play);
                        MediaController.this.diJ.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.diA.setBackgroundResource(R.drawable.btn_pause);
                    MediaController.this.diJ.start();
                }
            }
        });
        this.diD = (TextView) inflate.findViewById(R.id.tv_position);
        this.diE = (SeekBar) inflate.findViewById(R.id.seekbar);
        this.diF = (TextView) inflate.findViewById(R.id.tv_duration);
        this.diE.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.mU(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.diK = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.diJ.getDuration() > 0) {
                    MediaController.this.diG = seekBar.getProgress();
                    if (MediaController.this.diJ != null) {
                        MediaController.this.diJ.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.diK = false;
            }
        });
        this.diC = inflate.findViewById(R.id.btn_mute);
        this.diC.setBackgroundResource(this.diJ != null && this.diJ.isMute() ? R.drawable.mute_on : R.drawable.mute_off);
        this.diC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.diJ != null) {
                    MediaController.this.diJ.setMuted(!MediaController.this.diJ.isMute());
                }
            }
        });
        this.diB = inflate.findViewById(R.id.btn_toggle_screen);
        this.diB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.4
            private boolean diN;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.diN = !this.diN;
                if (MediaController.this.dhP != null) {
                    MediaController.this.dhP.gD(this.diN);
                }
            }
        });
        this.diE.setEnabled(false);
        this.diA.setEnabled(false);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void aHw() {
        int currentPlayerState = this.diJ.getCurrentPlayerState();
        this.diL = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                aHy();
                this.diA.setEnabled(true);
                this.diA.setBackgroundResource(R.drawable.btn_play);
                this.diE.setEnabled(false);
                mU(this.diJ == null ? 0 : this.diJ.getCurrentPosition());
                mT(this.diJ != null ? this.diJ.getDuration() : 0);
                return;
            case 1:
                this.diA.setEnabled(false);
                this.diE.setEnabled(false);
                return;
            case 2:
                this.diA.setEnabled(true);
                this.diA.setBackgroundResource(R.drawable.btn_play);
                this.diE.setEnabled(true);
                mT(this.diJ != null ? this.diJ.getDuration() : 0);
                this.diE.setMax(this.diJ.getDuration());
                return;
            case 3:
                aHx();
                this.diE.setEnabled(true);
                this.diA.setEnabled(true);
                this.diA.setBackgroundResource(R.drawable.btn_pause);
                return;
            case 4:
                this.diA.setEnabled(true);
                this.diA.setBackgroundResource(R.drawable.btn_play);
                return;
            case 5:
                aHy();
                this.diE.setProgress(this.diE.getMax());
                this.diE.setEnabled(false);
                this.diA.setEnabled(true);
                this.diA.setBackgroundResource(R.drawable.btn_play);
                return;
            default:
                return;
        }
    }

    private void aHx() {
        if (this.diH != null) {
            this.diH.cancel();
            this.diH = null;
        }
        this.diH = new Timer();
        this.diH.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaController.this.aHA();
                    }
                });
            }
        }, 0L, 500L);
    }

    private void aHy() {
        if (this.diH != null) {
            this.diH.cancel();
            this.diH = null;
        }
    }

    public void o(SwanVideoView swanVideoView) {
        this.diJ = swanVideoView;
    }

    public void setToggleScreenListener(a aVar) {
        this.dhP = aVar;
    }

    private void show() {
        if (this.diJ != null) {
            setProgress((int) this.diG);
            setVisibility(0);
        }
    }

    public void aHz() {
        show();
        if (this.diI != null) {
            this.diI.cancel();
            this.diI = null;
        }
        this.diI = new Timer();
        this.diI.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.6
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

    private void mT(int i) {
        if (this.diF != null) {
            this.diF.setText(mV(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mU(int i) {
        if (this.diD != null) {
            this.diD.setText(mV(i));
        }
    }

    public static String mV(int i) {
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
        if (!this.diL) {
            if (this.diE != null) {
                this.diE.setMax(i);
            }
            mT(i);
            if (i > 0) {
                this.diL = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.diE != null) {
            this.diE.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.diC != null) {
            this.diC.setBackgroundResource(z ? R.drawable.mute_on : R.drawable.mute_off);
        }
    }

    public void aHA() {
        int duration;
        if (this.diJ != null && !this.diK) {
            long currentPosition = this.diJ.getCurrentPosition();
            if (currentPosition > 0) {
                this.diG = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.diJ.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }
}
