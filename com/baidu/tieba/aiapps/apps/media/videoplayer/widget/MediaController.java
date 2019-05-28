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
    private a det;
    private ImageButton dfe;
    private View dff;
    private View dfg;
    private TextView dfh;
    private SeekBar dfi;
    private TextView dfj;
    private long dfk;
    private Timer dfl;
    private Timer dfm;
    private SwanVideoView dfn;
    boolean dfo;
    private boolean dfp;
    private Handler mMainThreadHandler;

    public MediaController(Context context) {
        super(context);
        this.dfp = false;
        aFt();
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dfp = false;
        aFt();
    }

    private void aFt() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.media_controller, this);
        this.dfe = (ImageButton) inflate.findViewById(R.id.btn_play);
        this.dfe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dfn != null) {
                    if (MediaController.this.dfn.isPlaying()) {
                        MediaController.this.dfe.setBackgroundResource(R.drawable.btn_play);
                        MediaController.this.dfn.pause();
                        return;
                    }
                    Log.d("SimpleMediaController", "mPlayButton clicked : to resume");
                    MediaController.this.dfe.setBackgroundResource(R.drawable.btn_pause);
                    MediaController.this.dfn.start();
                }
            }
        });
        this.dfh = (TextView) inflate.findViewById(R.id.tv_position);
        this.dfi = (SeekBar) inflate.findViewById(R.id.seekbar);
        this.dfj = (TextView) inflate.findViewById(R.id.tv_duration);
        this.dfi.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                MediaController.this.mI(i);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.dfo = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (MediaController.this.dfn.getDuration() > 0) {
                    MediaController.this.dfk = seekBar.getProgress();
                    if (MediaController.this.dfn != null) {
                        MediaController.this.dfn.seekTo(seekBar.getProgress());
                    }
                }
                MediaController.this.dfo = false;
            }
        });
        this.dfg = inflate.findViewById(R.id.btn_mute);
        this.dfg.setBackgroundResource(this.dfn != null && this.dfn.isMute() ? R.drawable.mute_on : R.drawable.mute_off);
        this.dfg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MediaController.this.dfn != null) {
                    MediaController.this.dfn.setMuted(!MediaController.this.dfn.isMute());
                }
            }
        });
        this.dff = inflate.findViewById(R.id.btn_toggle_screen);
        this.dff.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.4
            private boolean dfr;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.dfr = !this.dfr;
                if (MediaController.this.det != null) {
                    MediaController.this.det.gw(this.dfr);
                }
            }
        });
        this.dfi.setEnabled(false);
        this.dfe.setEnabled(false);
    }

    public Handler getMainThreadHandler() {
        if (this.mMainThreadHandler == null) {
            this.mMainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mMainThreadHandler;
    }

    public void aFu() {
        int currentPlayerState = this.dfn.getCurrentPlayerState();
        this.dfp = false;
        switch (currentPlayerState) {
            case -1:
            case 0:
                aFw();
                this.dfe.setEnabled(true);
                this.dfe.setBackgroundResource(R.drawable.btn_play);
                this.dfi.setEnabled(false);
                mI(this.dfn == null ? 0 : this.dfn.getCurrentPosition());
                mH(this.dfn != null ? this.dfn.getDuration() : 0);
                return;
            case 1:
                this.dfe.setEnabled(false);
                this.dfi.setEnabled(false);
                return;
            case 2:
                this.dfe.setEnabled(true);
                this.dfe.setBackgroundResource(R.drawable.btn_play);
                this.dfi.setEnabled(true);
                mH(this.dfn != null ? this.dfn.getDuration() : 0);
                this.dfi.setMax(this.dfn.getDuration());
                return;
            case 3:
                aFv();
                this.dfi.setEnabled(true);
                this.dfe.setEnabled(true);
                this.dfe.setBackgroundResource(R.drawable.btn_pause);
                return;
            case 4:
                this.dfe.setEnabled(true);
                this.dfe.setBackgroundResource(R.drawable.btn_play);
                return;
            case 5:
                aFw();
                this.dfi.setProgress(this.dfi.getMax());
                this.dfi.setEnabled(false);
                this.dfe.setEnabled(true);
                this.dfe.setBackgroundResource(R.drawable.btn_play);
                return;
            default:
                return;
        }
    }

    private void aFv() {
        if (this.dfl != null) {
            this.dfl.cancel();
            this.dfl = null;
        }
        this.dfl = new Timer();
        this.dfl.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                MediaController.this.getMainThreadHandler().post(new Runnable() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaController.this.aFy();
                    }
                });
            }
        }, 0L, 500L);
    }

    private void aFw() {
        if (this.dfl != null) {
            this.dfl.cancel();
            this.dfl = null;
        }
    }

    public void o(SwanVideoView swanVideoView) {
        this.dfn = swanVideoView;
    }

    public void setToggleScreenListener(a aVar) {
        this.det = aVar;
    }

    private void show() {
        if (this.dfn != null) {
            setProgress((int) this.dfk);
            setVisibility(0);
        }
    }

    public void aFx() {
        show();
        if (this.dfm != null) {
            this.dfm.cancel();
            this.dfm = null;
        }
        this.dfm = new Timer();
        this.dfm.schedule(new TimerTask() { // from class: com.baidu.tieba.aiapps.apps.media.videoplayer.widget.MediaController.6
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

    private void mH(int i) {
        if (this.dfj != null) {
            this.dfj.setText(mJ(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mI(int i) {
        if (this.dfh != null) {
            this.dfh.setText(mJ(i));
        }
    }

    public static String mJ(int i) {
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
        if (!this.dfp) {
            if (this.dfi != null) {
                this.dfi.setMax(i);
            }
            mH(i);
            if (i > 0) {
                this.dfp = true;
            }
        }
    }

    public void setProgress(int i) {
        if (this.dfi != null) {
            this.dfi.setProgress(i);
        }
    }

    public void setMute(boolean z) {
        if (this.dfg != null) {
            this.dfg.setBackgroundResource(z ? R.drawable.mute_on : R.drawable.mute_off);
        }
    }

    public void aFy() {
        int duration;
        if (this.dfn != null && !this.dfo) {
            long currentPosition = this.dfn.getCurrentPosition();
            if (currentPosition > 0) {
                this.dfk = currentPosition;
            }
            if (getVisibility() == 0 && (duration = this.dfn.getDuration()) > 0) {
                setMax(duration);
                setProgress((int) currentPosition);
            }
        }
    }
}
