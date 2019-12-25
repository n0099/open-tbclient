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
/* loaded from: classes9.dex */
public class MediaController extends RelativeLayout {
    private a eaL;
    private ImageButton ebe;
    private View ebf;
    private View ebg;
    private TextView ebh;
    private SeekBar ebi;
    private TextView ebj;
    private long ebk;
    private Timer ebl;
    private Timer ebm;
    private SwanVideoView ebn;
    boolean ebo;
    private boolean ebp;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.ebp = false;
        aXQ();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ebp = false;
        aXQ();
    }

    private void aXQ() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.media_controller, this);
        this.ebe = (ImageButton) inflate.findViewById(R.id.btn_play);
        this.ebe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.ebn != null) {
                    if (MediaController.this.ebn.isPlaying()) {
                        MediaController.this.ebe.setBackgroundResource(R.drawable.btn_play);
                        MediaController.this.ebn.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.ebe.setBackgroundResource(R.drawable.btn_pause);
                    MediaController.this.ebn.start();
                }
            }
        });
        this.ebh = (TextView) inflate.findViewById(R.id.tv_position);
        this.ebi = (SeekBar) inflate.findViewById(R.id.seekbar);
        this.ebj = (TextView) inflate.findViewById(R.id.tv_duration);
        this.ebi.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.oe(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.ebo = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.ebn.getDuration() > 0) {
                    MediaController.this.ebk = seekBar.getProgress();
                    if (MediaController.this.ebn != null) {
                        MediaController.this.ebn.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.ebo = false;
            }
        });
        this.ebg = inflate.findViewById(R.id.btn_mute);
        this.ebg.setBackgroundResource(this.ebn != null && this.ebn.isMute() ? R.drawable.mute_on : R.drawable.mute_off);
        this.ebg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.ebn != null) {
                    MediaController.this.ebn.setMuted(!MediaController.this.ebn.isMute());
                }
            }
        });
        this.ebf = inflate.findViewById(R.id.btn_toggle_screen);
        this.ebf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.4
            private boolean ebr;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.ebr = !this.ebr;
                if (MediaController.this.eaL != null) {
                    MediaController.this.eaL.hv(this.ebr);
                }
            }
        });
        this.ebi.setEnabled(false);
        this.ebe.setEnabled(false);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void aXR() {
        int currentPlayerState = this.ebn.getCurrentPlayerState();
        this.ebp = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                aXT();
                this.ebe.setEnabled(true);
                this.ebe.setBackgroundResource(R.drawable.btn_play);
                this.ebi.setEnabled(false);
                oe(this.ebn == null ? 0 : this.ebn.getCurrentPosition());
                od(this.ebn != null ? this.ebn.getDuration() : 0);
                return;
            case 1:
                this.ebe.setEnabled(false);
                this.ebi.setEnabled(false);
                return;
            case 2:
                this.ebe.setEnabled(true);
                this.ebe.setBackgroundResource(R.drawable.btn_play);
                this.ebi.setEnabled(true);
                od(this.ebn == null ? 0 : this.ebn.getDuration());
                this.ebi.setMax(this.ebn != null ? this.ebn.getDuration() : 0);
                return;
            case 3:
                aXS();
                this.ebi.setEnabled(true);
                this.ebe.setEnabled(true);
                this.ebe.setBackgroundResource(R.drawable.btn_pause);
                return;
            case 4:
                this.ebe.setEnabled(true);
                this.ebe.setBackgroundResource(R.drawable.btn_play);
                return;
            case 5:
                aXT();
                this.ebi.setProgress(this.ebi.getMax());
                this.ebi.setEnabled(false);
                this.ebe.setEnabled(true);
                this.ebe.setBackgroundResource(R.drawable.btn_play);
                return;
            default:
                return;
        }
    }

    private void aXS() {
        if (this.ebl != null) {
            this.ebl.cancel();
            this.ebl = null;
        }
        this.ebl = new Timer();
        this.ebl.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaController.this.aXV();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void aXT() {
        if (this.ebl != null) {
            this.ebl.cancel();
            this.ebl = null;
        }
    }

    public void o(SwanVideoView swanVideoView) {
        this.ebn = swanVideoView;
    }

    public void setToggleScreenListener(a aVar) {
        this.eaL = aVar;
    }

    private void show() {
        if (this.ebn != null) {
            setProgress((int) this.ebk);
            setVisibility(0);
        }
    }

    public void aXU() {
        show();
        if (this.ebm != null) {
            this.ebm.cancel();
            this.ebm = null;
        }
        this.ebm = new Timer();
        this.ebm.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.6
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

    private void od(int i) {
        if (this.ebj != null) {
            this.ebj.setText(of(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oe(int i) {
        if (this.ebh != null) {
            this.ebh.setText(of(i));
        }
    }

    public static String of(int i) {
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
        if (!this.ebp) {
            if (this.ebi != null) {
                this.ebi.setMax(i);
            }
            od(i);
            if (i > 0) {
                this.ebp = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.ebi != null) {
            this.ebi.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.ebg != null) {
            this.ebg.setBackgroundResource(z ? R.drawable.mute_on : R.drawable.mute_off);
        }
    }

    public void aXV() {
        int duration;
        if (this.ebn != null && !this.ebo) {
            long currentPosition = this.ebn.getCurrentPosition();
            if (currentPosition > 0) {
                this.ebk = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.ebn.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }
}
