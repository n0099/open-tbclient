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
/* loaded from: classes10.dex */
public class MediaController extends RelativeLayout {
    private a eaU;
    private ImageButton ebn;
    private View ebo;
    private View ebp;
    private TextView ebq;
    private SeekBar ebr;
    private TextView ebs;
    private long ebt;
    private Timer ebu;
    private Timer ebv;
    private SwanVideoView ebw;
    boolean ebx;
    private boolean eby;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.eby = false;
        aYk();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eby = false;
        aYk();
    }

    private void aYk() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.media_controller, this);
        this.ebn = (ImageButton) inflate.findViewById(R.id.btn_play);
        this.ebn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.ebw != null) {
                    if (MediaController.this.ebw.isPlaying()) {
                        MediaController.this.ebn.setBackgroundResource(R.drawable.btn_play);
                        MediaController.this.ebw.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.ebn.setBackgroundResource(R.drawable.btn_pause);
                    MediaController.this.ebw.start();
                }
            }
        });
        this.ebq = (TextView) inflate.findViewById(R.id.tv_position);
        this.ebr = (SeekBar) inflate.findViewById(R.id.seekbar);
        this.ebs = (TextView) inflate.findViewById(R.id.tv_duration);
        this.ebr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.oe(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.ebx = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.ebw.getDuration() > 0) {
                    MediaController.this.ebt = seekBar.getProgress();
                    if (MediaController.this.ebw != null) {
                        MediaController.this.ebw.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.ebx = false;
            }
        });
        this.ebp = inflate.findViewById(R.id.btn_mute);
        this.ebp.setBackgroundResource(this.ebw != null && this.ebw.isMute() ? R.drawable.mute_on : R.drawable.mute_off);
        this.ebp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.ebw != null) {
                    MediaController.this.ebw.setMuted(!MediaController.this.ebw.isMute());
                }
            }
        });
        this.ebo = inflate.findViewById(R.id.btn_toggle_screen);
        this.ebo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.4
            private boolean ebA;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.ebA = !this.ebA;
                if (MediaController.this.eaU != null) {
                    MediaController.this.eaU.hA(this.ebA);
                }
            }
        });
        this.ebr.setEnabled(false);
        this.ebn.setEnabled(false);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void aYl() {
        int currentPlayerState = this.ebw.getCurrentPlayerState();
        this.eby = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                aYn();
                this.ebn.setEnabled(true);
                this.ebn.setBackgroundResource(R.drawable.btn_play);
                this.ebr.setEnabled(false);
                oe(this.ebw == null ? 0 : this.ebw.getCurrentPosition());
                od(this.ebw != null ? this.ebw.getDuration() : 0);
                return;
            case 1:
                this.ebn.setEnabled(false);
                this.ebr.setEnabled(false);
                return;
            case 2:
                this.ebn.setEnabled(true);
                this.ebn.setBackgroundResource(R.drawable.btn_play);
                this.ebr.setEnabled(true);
                od(this.ebw == null ? 0 : this.ebw.getDuration());
                this.ebr.setMax(this.ebw != null ? this.ebw.getDuration() : 0);
                return;
            case 3:
                aYm();
                this.ebr.setEnabled(true);
                this.ebn.setEnabled(true);
                this.ebn.setBackgroundResource(R.drawable.btn_pause);
                return;
            case 4:
                this.ebn.setEnabled(true);
                this.ebn.setBackgroundResource(R.drawable.btn_play);
                return;
            case 5:
                aYn();
                this.ebr.setProgress(this.ebr.getMax());
                this.ebr.setEnabled(false);
                this.ebn.setEnabled(true);
                this.ebn.setBackgroundResource(R.drawable.btn_play);
                return;
            default:
                return;
        }
    }

    private void aYm() {
        if (this.ebu != null) {
            this.ebu.cancel();
            this.ebu = null;
        }
        this.ebu = new Timer();
        this.ebu.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaController.this.aYp();
                    }
                });
            }
        }, 0L, 1000L);
    }

    private void aYn() {
        if (this.ebu != null) {
            this.ebu.cancel();
            this.ebu = null;
        }
    }

    public void o(SwanVideoView swanVideoView) {
        this.ebw = swanVideoView;
    }

    public void setToggleScreenListener(a aVar) {
        this.eaU = aVar;
    }

    private void show() {
        if (this.ebw != null) {
            setProgress((int) this.ebt);
            setVisibility(0);
        }
    }

    public void aYo() {
        show();
        if (this.ebv != null) {
            this.ebv.cancel();
            this.ebv = null;
        }
        this.ebv = new Timer();
        this.ebv.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.6
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
        if (this.ebs != null) {
            this.ebs.setText(of(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oe(int i) {
        if (this.ebq != null) {
            this.ebq.setText(of(i));
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
        if (!this.eby) {
            if (this.ebr != null) {
                this.ebr.setMax(i);
            }
            od(i);
            if (i > 0) {
                this.eby = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.ebr != null) {
            this.ebr.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.ebp != null) {
            this.ebp.setBackgroundResource(z ? R.drawable.mute_on : R.drawable.mute_off);
        }
    }

    public void aYp() {
        int duration;
        if (this.ebw != null && !this.ebx) {
            long currentPosition = this.ebw.getCurrentPosition();
            if (currentPosition > 0) {
                this.ebt = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.ebw.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }
}
