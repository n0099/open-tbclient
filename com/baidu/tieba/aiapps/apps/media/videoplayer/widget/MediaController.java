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
    private ImageButton eFK;
    private View eFL;
    private View eFM;
    private TextView eFN;
    private SeekBar eFO;
    private TextView eFP;
    private long eFQ;
    private Timer eFR;
    private Timer eFS;
    private SwanVideoView eFT;
    boolean eFU;
    private boolean eFV;
    private a eFr;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.eFV = false;
        biJ();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eFV = false;
        biJ();
    }

    private void biJ() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.media_controller, this);
        this.eFK = (ImageButton) inflate.findViewById(R.id.btn_play);
        this.eFK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.eFT != null) {
                    if (MediaController.this.eFT.isPlaying()) {
                        MediaController.this.eFK.setBackgroundResource(R.drawable.btn_play);
                        MediaController.this.eFT.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.eFK.setBackgroundResource(R.drawable.btn_pause);
                    MediaController.this.eFT.start();
                }
            }
        });
        this.eFN = (TextView) inflate.findViewById(R.id.tv_position);
        this.eFO = (SeekBar) inflate.findViewById(R.id.seekbar);
        this.eFP = (TextView) inflate.findViewById(R.id.tv_duration);
        this.eFO.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.oK(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.eFU = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.eFT.getDuration() > 0) {
                    MediaController.this.eFQ = seekBar.getProgress();
                    if (MediaController.this.eFT != null) {
                        MediaController.this.eFT.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.eFU = false;
            }
        });
        this.eFM = inflate.findViewById(R.id.btn_mute);
        this.eFM.setBackgroundResource(this.eFT != null && this.eFT.isMute() ? R.drawable.mute_on : R.drawable.mute_off);
        this.eFM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.eFT != null) {
                    MediaController.this.eFT.setMuted(!MediaController.this.eFT.isMute());
                }
            }
        });
        this.eFL = inflate.findViewById(R.id.btn_toggle_screen);
        this.eFL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.4
            private boolean eFX;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.eFX = !this.eFX;
                if (MediaController.this.eFr != null) {
                    MediaController.this.eFr.iG(this.eFX);
                }
            }
        });
        this.eFO.setEnabled(false);
        this.eFK.setEnabled(false);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void biK() {
        int currentPlayerState = this.eFT.getCurrentPlayerState();
        this.eFV = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                biM();
                this.eFK.setEnabled(true);
                this.eFK.setBackgroundResource(R.drawable.btn_play);
                this.eFO.setEnabled(false);
                oK(this.eFT == null ? 0 : this.eFT.getCurrentPosition());
                oJ(this.eFT != null ? this.eFT.getDuration() : 0);
                return;
            case 1:
                this.eFK.setEnabled(false);
                this.eFO.setEnabled(false);
                return;
            case 2:
                this.eFK.setEnabled(true);
                this.eFK.setBackgroundResource(R.drawable.btn_play);
                this.eFO.setEnabled(true);
                oJ(this.eFT == null ? 0 : this.eFT.getDuration());
                this.eFO.setMax(this.eFT != null ? this.eFT.getDuration() : 0);
                return;
            case 3:
                biL();
                this.eFO.setEnabled(true);
                this.eFK.setEnabled(true);
                this.eFK.setBackgroundResource(R.drawable.btn_pause);
                return;
            case 4:
                this.eFK.setEnabled(true);
                this.eFK.setBackgroundResource(R.drawable.btn_play);
                return;
            case 5:
                biM();
                this.eFO.setProgress(this.eFO.getMax());
                this.eFO.setEnabled(false);
                this.eFK.setEnabled(true);
                this.eFK.setBackgroundResource(R.drawable.btn_play);
                return;
            default:
                return;
        }
    }

    private void biL() {
        if (this.eFR != null) {
            this.eFR.cancel();
            this.eFR = null;
        }
        this.eFR = new Timer();
        this.eFR.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaController.this.biO();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void biM() {
        if (this.eFR != null) {
            this.eFR.cancel();
            this.eFR = null;
        }
    }

    public void o(SwanVideoView swanVideoView) {
        this.eFT = swanVideoView;
    }

    public void setToggleScreenListener(a aVar) {
        this.eFr = aVar;
    }

    private void show() {
        if (this.eFT != null) {
            setProgress((int) this.eFQ);
            setVisibility(0);
        }
    }

    public void biN() {
        show();
        if (this.eFS != null) {
            this.eFS.cancel();
            this.eFS = null;
        }
        this.eFS = new Timer();
        this.eFS.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.6
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
        if (this.eFP != null) {
            this.eFP.setText(oL(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oK(int i) {
        if (this.eFN != null) {
            this.eFN.setText(oL(i));
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
        if (!this.eFV) {
            if (this.eFO != null) {
                this.eFO.setMax(i);
            }
            oJ(i);
            if (i > 0) {
                this.eFV = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.eFO != null) {
            this.eFO.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.eFM != null) {
            this.eFM.setBackgroundResource(z ? R.drawable.mute_on : R.drawable.mute_off);
        }
    }

    public void biO() {
        int duration;
        if (this.eFT != null && !this.eFU) {
            long currentPosition = this.eFT.getCurrentPosition();
            if (currentPosition > 0) {
                this.eFQ = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.eFT.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }
}
