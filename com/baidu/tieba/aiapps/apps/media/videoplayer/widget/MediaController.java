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
    private a efB;
    private ImageButton efU;
    private View efV;
    private View efW;
    private TextView efX;
    private SeekBar efY;
    private TextView efZ;
    private long ega;
    private Timer egb;
    private Timer egc;
    private SwanVideoView egd;
    boolean ege;
    private boolean egf;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.egf = false;
        baG();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.egf = false;
        baG();
    }

    private void baG() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.media_controller, this);
        this.efU = (ImageButton) inflate.findViewById(R.id.btn_play);
        this.efU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.egd != null) {
                    if (MediaController.this.egd.isPlaying()) {
                        MediaController.this.efU.setBackgroundResource(R.drawable.btn_play);
                        MediaController.this.egd.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.efU.setBackgroundResource(R.drawable.btn_pause);
                    MediaController.this.egd.start();
                }
            }
        });
        this.efX = (TextView) inflate.findViewById(R.id.tv_position);
        this.efY = (SeekBar) inflate.findViewById(R.id.seekbar);
        this.efZ = (TextView) inflate.findViewById(R.id.tv_duration);
        this.efY.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.ox(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.ege = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.egd.getDuration() > 0) {
                    MediaController.this.ega = seekBar.getProgress();
                    if (MediaController.this.egd != null) {
                        MediaController.this.egd.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.ege = false;
            }
        });
        this.efW = inflate.findViewById(R.id.btn_mute);
        this.efW.setBackgroundResource(this.egd != null && this.egd.isMute() ? R.drawable.mute_on : R.drawable.mute_off);
        this.efW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.egd != null) {
                    MediaController.this.egd.setMuted(!MediaController.this.egd.isMute());
                }
            }
        });
        this.efV = inflate.findViewById(R.id.btn_toggle_screen);
        this.efV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.4
            private boolean egh;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.egh = !this.egh;
                if (MediaController.this.efB != null) {
                    MediaController.this.efB.hI(this.egh);
                }
            }
        });
        this.efY.setEnabled(false);
        this.efU.setEnabled(false);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void baH() {
        int currentPlayerState = this.egd.getCurrentPlayerState();
        this.egf = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                baJ();
                this.efU.setEnabled(true);
                this.efU.setBackgroundResource(R.drawable.btn_play);
                this.efY.setEnabled(false);
                ox(this.egd == null ? 0 : this.egd.getCurrentPosition());
                ow(this.egd != null ? this.egd.getDuration() : 0);
                return;
            case 1:
                this.efU.setEnabled(false);
                this.efY.setEnabled(false);
                return;
            case 2:
                this.efU.setEnabled(true);
                this.efU.setBackgroundResource(R.drawable.btn_play);
                this.efY.setEnabled(true);
                ow(this.egd == null ? 0 : this.egd.getDuration());
                this.efY.setMax(this.egd != null ? this.egd.getDuration() : 0);
                return;
            case 3:
                baI();
                this.efY.setEnabled(true);
                this.efU.setEnabled(true);
                this.efU.setBackgroundResource(R.drawable.btn_pause);
                return;
            case 4:
                this.efU.setEnabled(true);
                this.efU.setBackgroundResource(R.drawable.btn_play);
                return;
            case 5:
                baJ();
                this.efY.setProgress(this.efY.getMax());
                this.efY.setEnabled(false);
                this.efU.setEnabled(true);
                this.efU.setBackgroundResource(R.drawable.btn_play);
                return;
            default:
                return;
        }
    }

    private void baI() {
        if (this.egb != null) {
            this.egb.cancel();
            this.egb = null;
        }
        this.egb = new Timer();
        this.egb.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaController.this.baL();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void baJ() {
        if (this.egb != null) {
            this.egb.cancel();
            this.egb = null;
        }
    }

    public void o(SwanVideoView swanVideoView) {
        this.egd = swanVideoView;
    }

    public void setToggleScreenListener(a aVar) {
        this.efB = aVar;
    }

    private void show() {
        if (this.egd != null) {
            setProgress((int) this.ega);
            setVisibility(0);
        }
    }

    public void baK() {
        show();
        if (this.egc != null) {
            this.egc.cancel();
            this.egc = null;
        }
        this.egc = new Timer();
        this.egc.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.6
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

    private void ow(int i) {
        if (this.efZ != null) {
            this.efZ.setText(oy(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ox(int i) {
        if (this.efX != null) {
            this.efX.setText(oy(i));
        }
    }

    public static String oy(int i) {
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
        if (!this.egf) {
            if (this.efY != null) {
                this.efY.setMax(i);
            }
            ow(i);
            if (i > 0) {
                this.egf = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.efY != null) {
            this.efY.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.efW != null) {
            this.efW.setBackgroundResource(z ? R.drawable.mute_on : R.drawable.mute_off);
        }
    }

    public void baL() {
        int duration;
        if (this.egd != null && !this.ege) {
            long currentPosition = this.egd.getCurrentPosition();
            if (currentPosition > 0) {
                this.ega = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.egd.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }
}
