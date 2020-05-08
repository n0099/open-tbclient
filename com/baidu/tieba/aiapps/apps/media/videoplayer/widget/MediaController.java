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
    private ImageButton eFP;
    private View eFQ;
    private View eFR;
    private TextView eFS;
    private SeekBar eFT;
    private TextView eFU;
    private long eFV;
    private Timer eFW;
    private Timer eFX;
    private SwanVideoView eFY;
    boolean eFZ;
    private a eFw;
    private boolean eGa;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.eGa = false;
        biH();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eGa = false;
        biH();
    }

    private void biH() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.media_controller, this);
        this.eFP = (ImageButton) inflate.findViewById(R.id.btn_play);
        this.eFP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.eFY != null) {
                    if (MediaController.this.eFY.isPlaying()) {
                        MediaController.this.eFP.setBackgroundResource(R.drawable.btn_play);
                        MediaController.this.eFY.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.eFP.setBackgroundResource(R.drawable.btn_pause);
                    MediaController.this.eFY.start();
                }
            }
        });
        this.eFS = (TextView) inflate.findViewById(R.id.tv_position);
        this.eFT = (SeekBar) inflate.findViewById(R.id.seekbar);
        this.eFU = (TextView) inflate.findViewById(R.id.tv_duration);
        this.eFT.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.oK(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.eFZ = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.eFY.getDuration() > 0) {
                    MediaController.this.eFV = seekBar.getProgress();
                    if (MediaController.this.eFY != null) {
                        MediaController.this.eFY.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.eFZ = false;
            }
        });
        this.eFR = inflate.findViewById(R.id.btn_mute);
        this.eFR.setBackgroundResource(this.eFY != null && this.eFY.isMute() ? R.drawable.mute_on : R.drawable.mute_off);
        this.eFR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.eFY != null) {
                    MediaController.this.eFY.setMuted(!MediaController.this.eFY.isMute());
                }
            }
        });
        this.eFQ = inflate.findViewById(R.id.btn_toggle_screen);
        this.eFQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.4
            private boolean eGc;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.eGc = !this.eGc;
                if (MediaController.this.eFw != null) {
                    MediaController.this.eFw.iG(this.eGc);
                }
            }
        });
        this.eFT.setEnabled(false);
        this.eFP.setEnabled(false);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void biI() {
        int currentPlayerState = this.eFY.getCurrentPlayerState();
        this.eGa = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                biK();
                this.eFP.setEnabled(true);
                this.eFP.setBackgroundResource(R.drawable.btn_play);
                this.eFT.setEnabled(false);
                oK(this.eFY == null ? 0 : this.eFY.getCurrentPosition());
                oJ(this.eFY != null ? this.eFY.getDuration() : 0);
                return;
            case 1:
                this.eFP.setEnabled(false);
                this.eFT.setEnabled(false);
                return;
            case 2:
                this.eFP.setEnabled(true);
                this.eFP.setBackgroundResource(R.drawable.btn_play);
                this.eFT.setEnabled(true);
                oJ(this.eFY == null ? 0 : this.eFY.getDuration());
                this.eFT.setMax(this.eFY != null ? this.eFY.getDuration() : 0);
                return;
            case 3:
                biJ();
                this.eFT.setEnabled(true);
                this.eFP.setEnabled(true);
                this.eFP.setBackgroundResource(R.drawable.btn_pause);
                return;
            case 4:
                this.eFP.setEnabled(true);
                this.eFP.setBackgroundResource(R.drawable.btn_play);
                return;
            case 5:
                biK();
                this.eFT.setProgress(this.eFT.getMax());
                this.eFT.setEnabled(false);
                this.eFP.setEnabled(true);
                this.eFP.setBackgroundResource(R.drawable.btn_play);
                return;
            default:
                return;
        }
    }

    private void biJ() {
        if (this.eFW != null) {
            this.eFW.cancel();
            this.eFW = null;
        }
        this.eFW = new Timer();
        this.eFW.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaController.this.biM();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void biK() {
        if (this.eFW != null) {
            this.eFW.cancel();
            this.eFW = null;
        }
    }

    public void o(SwanVideoView swanVideoView) {
        this.eFY = swanVideoView;
    }

    public void setToggleScreenListener(a aVar) {
        this.eFw = aVar;
    }

    private void show() {
        if (this.eFY != null) {
            setProgress((int) this.eFV);
            setVisibility(0);
        }
    }

    public void biL() {
        show();
        if (this.eFX != null) {
            this.eFX.cancel();
            this.eFX = null;
        }
        this.eFX = new Timer();
        this.eFX.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.6
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

    private void oJ(int i) {
        if (this.eFU != null) {
            this.eFU.setText(oL(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oK(int i) {
        if (this.eFS != null) {
            this.eFS.setText(oL(i));
        }
    }

    public static String oL(int i) {
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
        if (!this.eGa) {
            if (this.eFT != null) {
                this.eFT.setMax(i);
            }
            oJ(i);
            if (i > 0) {
                this.eGa = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.eFT != null) {
            this.eFT.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.eFR != null) {
            this.eFR.setBackgroundResource(z ? R.drawable.mute_on : R.drawable.mute_off);
        }
    }

    public void biM() {
        int duration;
        if (this.eFY != null && !this.eFZ) {
            long currentPosition = this.eFY.getCurrentPosition();
            if (currentPosition > 0) {
                this.eFV = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.eFY.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }
}
